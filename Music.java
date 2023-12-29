import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Song.java
public class Song {
    private String title;
    private String artist;
    private int lengthInSeconds;

    public Song(String title, String artist, int lengthInSeconds) {
        this.title = title;
        this.artist = artist;
        this.lengthInSeconds = lengthInSeconds;
    }

    public void playSong() {
        System.out.println("Playing: " + title + " by " + artist);
    }

    public String getTitle() {
        return title;
    }

    public int getLengthInSeconds() {
        return lengthInSeconds;
    }
}

// Album.java
public class Album {
    private String title;
    private List<Song> songs;

    public Album(String title) {
        this.title = title;
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
        System.out.println("Added song to the album: " + song.getTitle());
    }

    public void removeSong(Song song) {
        songs.remove(song);
        System.out.println("Removed song from the album: " + song.getTitle());
    }

    public void listAllSongs() {
        System.out.println("Songs in the album '" + title + "':");
        for (Song song : songs) {
            System.out.println(song.getTitle() + " by " + song.getArtist());
        }
    }
}

// Artist.java
public class Artist {
    private String name;
    private List<Album> albums;

    public Artist(String name) {
        this.name = name;
        this.albums = new ArrayList<>();
    }

    public void addAlbum(Album album) {
        albums.add(album);
        System.out.println("Added album to the artist: " + album.getTitle());
    }

    public void deleteAlbum(Album album) {
        albums.remove(album);
        System.out.println("Deleted album from the artist: " + album.getTitle());
    }

    public void listAllAlbums() {
        System.out.println("Albums by the artist '" + name + "':");
        for (Album album : albums) {
            System.out.println(album.getTitle());
        }
    }
}

// User.java
public interface User {
    void listen(Song song);
    void addToPlaylist(Song song);
}

// FreeUser.java
public class FreeUser implements User {
    private String username;

    public FreeUser(String username) {
        this.username = username;
    }

    @Override
    public void listen(Song song) {
        System.out.println("Listening to: " + song.getTitle());
    }

    @Override
    public void addToPlaylist(Song song) {
        System.out.println("Added to playlist: " + song.getTitle());
    }
}

// PremiumUser.java
public class PremiumUser implements User {
    private String username;

    public PremiumUser(String username) {
        this.username = username;
    }

    @Override
    public void listen(Song song) {
        System.out.println("Listening to: " + song.getTitle());
    }

    @Override
    public void addToPlaylist(Song song) {
        System.out.println("Added to playlist: " + song.getTitle());
    }
}

// Playlist.java
public class Playlist {
    private User user;
    private List<Song> songs;

    public Playlist(User user) {
        this.user = user;
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
        System.out.println("Added song to the playlist: " + song.getTitle());
    }

    public void removeSong(Song song) {
        songs.remove(song);
        System.out.println("Removed song from the playlist: " + song.getTitle());
    }

    public void shuffleSongs() {
        System.out.println("Shuffling the playlist...");
        // Implement shuffling logic (randomize the order of songs)
        Random random = new Random();
        for (int i = songs.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Song temp = songs.get(i);
            songs.set(i, songs.get(j));
            songs.set(j, temp);
        }
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        Song song1 = new Song("Song1", "Artist1", 180);
        Song song2 = new Song("Song2", "Artist2", 200);

        Album album1 = new Album("Album1");
        album1.addSong(song1);
        album1.addSong(song2);

        Artist artist1 = new Artist("Artist1");
        artist1.addAlbum(album1);

        FreeUser freeUser = new FreeUser("FreeUser1");
        PremiumUser premiumUser = new PremiumUser("PremiumUser1");

        freeUser.listen(song1);
        freeUser.addToPlaylist(song1);

        premiumUser.listen(song2);
        premiumUser.addToPlaylist(song2);

        Playlist playlist = new Playlist(premiumUser);
        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.shuffleSongs();
    }
}
