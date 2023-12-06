package Song;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SongManagement {
    private static SongManagement instance;
    private List<Song> songs;

//  Initialization
    private SongManagement() {
        songs = new ArrayList<>();
    }
//  Singleton implementation
    public static synchronized SongManagement getInstance() {
        if (instance == null) {
            instance = new SongManagement();
        }
        return instance;
    }

    public void addSong(Song song) {
        songs.add(song);
        System.out.println("\nSong added successfully!");
    }

    public void viewSongs() {
        int songCount = 0;
        for (Song song : songs) {
            System.out.println(song);
            songCount++;
        }
        System.out.println("\n Total number of songs: " + songCount);
    }
    public void updateSong(String keyword) {
        Scanner scanner = new Scanner(System.in);
        boolean songFound = false;

        System.out.println("\nMaybe this is the song you're looking for:");
        for (Song song : songs) {
            if (song.getSongName().toLowerCase().contains(keyword.toLowerCase())) {
                songFound = true;
                System.out.println("- " + song.getSongName());
            }
        }

        if (!songFound) {
            System.out.println("No matching song found!");
            return;
        }

        System.out.print("\nEnter the name of the song to update: ");
        String songToUpdate = scanner.nextLine();

        Song selectedSong = findSongByName(songToUpdate);

        if (selectedSong == null) {
            System.out.println("Song not found!");
            return;
        }

        do {
            System.out.println("Updating song information:");

            // Update Song Name
            System.out.print("Song name update: ");
            String newSongName = scanner.nextLine();
            selectedSong.setSongName(newSongName);

            // Update Artist
            System.out.print("Artist name update: ");
            String newArtist = scanner.nextLine();
            selectedSong.setArtist(newArtist);

            // Update Genre
            System.out.print("Genre update: ");
            String newGenre = scanner.nextLine();
            selectedSong.setGenre(newGenre);

            // Update Release Date
            System.out.print("Release Date update: ");
            String newReleaseDate = scanner.nextLine();
            selectedSong.setReleaseDate(newReleaseDate);

            // Update Provided By
            System.out.print("Provided By update: ");
            String newProvidedBy = scanner.nextLine();
            selectedSong.setProvidedBy(newProvidedBy);

            System.out.println("\nUpdated song information successfully:");
            System.out.println(selectedSong);

        } while (confirmUpdate());
        System.out.println("Returning to home...");
    }
    private Song findSongByName(String songName) {
        for (Song song : songs) {
            if (song.getSongName().equalsIgnoreCase(songName)) {
                return song;
            }
        }
        return null;
    }
    private boolean confirmUpdate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nWould you like to revise it again? (yes/no): ");
        String confirmation = scanner.nextLine();
        if (confirmation.equalsIgnoreCase("yes") || confirmation.equalsIgnoreCase("y")) {
            return true;
        } else if (confirmation.equalsIgnoreCase("no") || confirmation.equalsIgnoreCase("n")) {
            return false;
        } else {
            System.out.println("Invalid choice! Song information has not been updated!");
        }
        return false;
    }

    public void deleteSong() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n*** Delete Song ***");
        System.out.print("Enter the keyword to find the song to delete: ");
        String keyword = scanner.nextLine();

        List<Song> songsToDelete = findSongsByName(keyword);

        if (songsToDelete.isEmpty()) {
            System.out.println("No matching song found to delete!");
        } else {
            System.out.println("\nSongs found for deletion:");
            for (Song song : songsToDelete) {
                System.out.println("- " + song.getSongName());
            }

            System.out.print("\nEnter the name of the song to delete: ");
            String songToDelete = scanner.nextLine();

            Iterator<Song> iterator = songs.iterator();
            while (iterator.hasNext()) {
                Song song = iterator.next();
                if (song.getSongName().equalsIgnoreCase(songToDelete)) {
                    if (confirmDelete()) {
                        iterator.remove();
                        System.out.println("Song deleted successfully!");
                    } else {
                        System.out.println("Deletion canceled!");
                    }
                    return;
                }
            }

            System.out.println("Song not found. Deletion canceled!");
        }
    }
    private List<Song> findSongsByName(String songName) {
        List<Song> foundSongs = new ArrayList<>();
        for (Song song : songs) {
            if (song.getSongName().toLowerCase().contains(songName.toLowerCase())) {
                foundSongs.add(song);
            }
        }
        return foundSongs;
    }

    public boolean confirmDelete(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to delete this song? (Yes/No): ");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("yes") || confirmation.equalsIgnoreCase("y")) {
            return true;
        } else if (confirmation.equalsIgnoreCase("no") || confirmation.equalsIgnoreCase("n")) {
            return false;
        } else {
            System.out.println("Invalid!. The song has not been deleted!");
        }
        return false;
    }
    public List<Song> getSongs() {
        return songs;
    }
}
