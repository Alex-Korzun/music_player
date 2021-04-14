package model;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private final List<Song> playlist = new ArrayList<>();

    public List<Song> getPlaylist() {
        return playlist;
    }
}
