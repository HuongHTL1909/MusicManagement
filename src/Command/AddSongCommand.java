package Command;
import Song.Song;
import Song.SongManagement;

import java.util.Scanner;

public class AddSongCommand implements Command {
    private SongManagement songManagement;

    public AddSongCommand(SongManagement songManagement) {
        this.songManagement = songManagement;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n*** ADD A NEW SONG ***");
        System.out.print("Enter Song Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Artist: ");
        String artist = scanner.nextLine();
        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter Release Date: ");
        String releaseDate = scanner.nextLine();
        System.out.print("Enter Provided By: ");
        String providedBy = scanner.nextLine();

        Song newSong = new Song(name, artist, genre, releaseDate, providedBy);
        songManagement.addSong(newSong);
    }
}
