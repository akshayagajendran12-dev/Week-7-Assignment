import java.util.Arrays;

public class Playlist {
    private String[] songs;
    private int songCount;

    public Playlist(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException(
                "Maximum size must be positive."
            );
        }

        songs = new String[maxSize];
        songCount = 0;
    }

    public void addSong(String song) {
        if (song == null || song.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Song title cannot be empty."
            );
        }

        if (songCount >= songs.length) {
            throw new IllegalStateException(
                "Playlist is full."
            );
        }

        songs[songCount] = song;
        songCount++;
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();

        System.out.println("Songs in playlist:");
        for (String song : p.getSongs()) {
            System.out.println(song);
        }

        System.out.println("Song count: " + p.getSongCount());

        copy[0] = "Hacked";

        System.out.println("After modifying the returned copy:");
        System.out.println("First song: " + p.getSongs()[0]);
        System.out.println("Song count: " + p.getSongCount());
    }
}
