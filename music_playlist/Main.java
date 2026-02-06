package music_playlist;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Music Playlist Menu ---");
            System.out.println("1. Add Song");
            System.out.println("2. Remove Song");
            System.out.println("3. Play Next");
            System.out.println("4. Play Previous");
            System.out.println("5. Search Song");
            System.out.println("6. Shuffle Playlist");
            System.out.println("7. Show Playlist");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int choice;

            // 🔹 SAFE INPUT HANDLING
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 8");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Artist: ");
                    String artist = sc.nextLine();

                    System.out.print("Album: ");
                    String album = sc.nextLine();

                    System.out.print("Duration: ");
                    String duration = sc.nextLine();

                    playlist.addSong(new Song(title, artist, album, duration));
                    break;

                case 2:
                    System.out.print("Enter song title: ");
                    playlist.removeSong(sc.nextLine());
                    break;

                case 3:
                    playlist.playNext();
                    break;

                case 4:
                    playlist.playPrevious();
                    break;

                case 5:
                    System.out.print("Enter keyword: ");
                    playlist.searchSong(sc.nextLine());
                    break;

                case 6:
                    playlist.shuffle();
                    break;

                case 7:
                    playlist.showPlaylist();
                    break;

                case 8:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Please choose a valid option (1–8).");
            }
        }
    }
}
