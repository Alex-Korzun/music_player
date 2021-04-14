package service;

import java.util.Collections;
import java.util.Scanner;
import model.Playlist;
import model.Song;

public class Controller {
    private Song currentPlaying;
    private final Playlist playlist = new Playlist();

    public void start() {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        createPlaylist();
        currentPlaying = playlist.getPlaylist().get(0);

        while (true) {
            int i = scanner.nextInt();
            switch (i) {
                case 1:
                    play();
                    break;
                case 2:
                    pause();
                    break;
                case 3:
                    restart();
                    break;
                case 4:
                    playNextSong();
                    break;
                case 5:
                    playPreviousSong();
                    break;
                case 6:
                    addToPlaylist();
                    break;
                case 7:
                    removeFromPlaylist();
                    break;
                case 8:
                    shuffle();
                    break;
                case 9:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter valid number from the list");
            }
        }
    }

    private void createPlaylist() {
        Song smokeOnTheWater = new Song("Smoke on the Water", "Deep Purple", 376);
        Song ridersOnTheStorm = new Song("Riders on the Storm", "The Doors", 435);
        Song immigrantSong = new Song("Immigrant Song", "Led Zeppelin", 327);
        Song houseOfTheRisingSun = new Song("House of the Rising Sun", "The Animals", 329);
        Song nothingElseMatters = new Song("Nothing Else Matters", "Metallica", 398);
        Song backInBlack = new Song("Back In Black", "AC/DC", 255);
        Song paintItBlack = new Song("Paint It, Black", "The Rolling Stones", 204);
        Song sultansOfSwing = new Song("Sultans of Swing", "Dire Straits", 348);
        Song stairwayToHeaven = new Song("Stairway to Heaven", "Led Zeppelin", 482);

        playlist.getPlaylist().add(smokeOnTheWater);
        playlist.getPlaylist().add(ridersOnTheStorm);
        playlist.getPlaylist().add(immigrantSong);
        playlist.getPlaylist().add(houseOfTheRisingSun);
        playlist.getPlaylist().add(nothingElseMatters);
        playlist.getPlaylist().add(backInBlack);
        playlist.getPlaylist().add(paintItBlack);
        playlist.getPlaylist().add(sultansOfSwing);
        playlist.getPlaylist().add(stairwayToHeaven);
    }

    private void printMenu() {
        System.out.println("Press 1 to play");
        System.out.println("Press 2 to pause");
        System.out.println("Press 3 to restart a song");
        System.out.println("Press 4 for next song");
        System.out.println("Press 5 for previous song");
        System.out.println("Press 6 to add a song to playlist");
        System.out.println("Press 7 to remove current playing song from a playlist");
        System.out.println("Press 8 to shuffle playlist");
        System.out.println("Press 9 to close the app");
    }

    private void playPreviousSong() {
        int currentIndex = playlist.getPlaylist().indexOf(currentPlaying);
        if (currentIndex == 0) {
            System.out.println("This is the first song");
        } else {
            currentPlaying = playlist.getPlaylist().get(currentIndex - 1);
            play();
        }
    }

    private void playNextSong() {
        int currentIndex = playlist.getPlaylist().indexOf(currentPlaying);
        if (currentIndex == playlist.getPlaylist().size() - 1) {
            System.out.println("This is the last song");
        } else {
            currentPlaying = playlist.getPlaylist().get(currentIndex + 1);
            play();
        }
    }

    private void shuffle() {
        Collections.shuffle(playlist.getPlaylist());
        currentPlaying = playlist.getPlaylist().get(0);
        play();
    }

    private void removeFromPlaylist() {
        playlist.getPlaylist().remove(currentPlaying);
        System.out.println("The song has been removed from playlist");
    }

    private void addToPlaylist() {
        System.out.println("Enter name of the song, performer and length(in seconds) "
                + "as in the example\n'Stairway to Heaven,Led Zeppelin,482'");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] splitInfo = line.split(",");
        int parsedLength = Integer.parseInt(splitInfo[2]);
        Song songToAdd = new Song(splitInfo[0], splitInfo[1], parsedLength);
        playlist.getPlaylist().add(songToAdd);
        if (playlist.getPlaylist().contains(songToAdd)) {
            System.out.println("This song is already in the playlist");
        } else {
            System.out.println("Your song has been added to a playlist");
        }
    }

    private void restart() {
        System.out.println("The song '" + currentPlaying.getName()
                + "' started from the beginning");
    }

    private void pause() {
        System.out.println("The song '" + currentPlaying.getName() + "' is paused");
    }

    private void play() {
        System.out.println("The song '" + currentPlaying.getName() + "' is playing");
    }
}
