package music_playlist;

import java.util.*;

public class Playlist {
    private List<Song> songs;
    private int currentIndex;

    public Playlist() {
        songs = new ArrayList<>();
        currentIndex = -1;
    }

    public void addSong(Song song) {
        songs.add(song);
        System.out.println("Song added: " + song.getTitle());
    }

    public void removeSong(String title) {
        boolean removed = songs.removeIf(
            s -> s.getTitle().equalsIgnoreCase(title)
        );
        if (removed)
            System.out.println("Removed song: " + title);
        else
            System.out.println("Song not found!");
    }

    public void showPlaylist() {
        if (songs.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }
        System.out.println("\n--- Playlist ---");
        for (int i = 0; i < songs.size(); i++) {
            System.out.println((i + 1) + ". " + songs.get(i));
        }
    }

    public void playNext() {
        if (songs.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }
        currentIndex = (currentIndex + 1) % songs.size();
        System.out.println("Playing: " + songs.get(currentIndex));
    }

    public void playPrevious() {
        if (songs.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }
        currentIndex = (currentIndex - 1 + songs.size()) % songs.size();
        System.out.println("Playing: " + songs.get(currentIndex));
    }

    public void searchSong(String keyword) {
        boolean found = false;
        for (Song s : songs) {
            if (s.getTitle().toLowerCase().contains(keyword.toLowerCase())
                || s.getArtist().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(s);
                found = true;
            }
        }
        if (!found)
            System.out.println("No song found!");
    }

    public void shuffle() {
        Collections.shuffle(songs);
        currentIndex = -1;
        System.out.println("Playlist shuffled!");
    }
}
