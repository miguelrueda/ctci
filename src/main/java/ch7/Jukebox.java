package ch7;

import java.util.Queue;
import java.util.Set;

public class Jukebox {

    private CDPlayer cdPlayer;
    private User user;
    private Set<CD> cdCollection;
    private SongSelector ts;

    public Jukebox(CDPlayer cdPlayer, User user, Set<CD> cdCollection, SongSelector ts) {}

    public Song getCurrentSong() {
        return ts.getCurrentSong();
    }

    public void setUser(User u) {
        this.user = u;
    }
}

class CDPlayer {
    private Playlist p;
    private CD c;

    // Constructors
    public CDPlayer(CD c, Playlist p) {

    }

    public CDPlayer(Playlist p) {
        this.p = p;
    }

    public CDPlayer(CD c) {
        this.c = c;
    }

    public void playSong(Song s) {}

    public Playlist getPlaylist() {
        return p;
    }

    public void setPlaylist(Playlist p) {
        this.p = p;
    }

    public CD getCD() {
        return c;
    }

    public void setCD(CD c) {
        this.c = c;
    }
}

class Playlist {

    private Song song;
    private Queue<Song> queue;
    public Playlist(Song song, Queue<Song> queue) {

    }

    public Song getNextSongToPlay() {
        return queue.peek();
    }

    public void queueUpSong(Song s) {
        queue.add(s);
    }
}

class CD { // data for id, artist, song, etc
}

class Song { // data for id, cd, title, length
}

class User {
    private String name;
}

class SongSelector {
    public Song getCurrentSong() {
        return null;
    }
}
