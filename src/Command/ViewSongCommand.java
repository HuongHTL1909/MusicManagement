package Command;
import Song.*;
import java.util.Scanner;

public class ViewSongCommand implements Command {
    private SongManagement songManagement;

    public ViewSongCommand(SongManagement songManagement) {
        this.songManagement = songManagement;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n *** View Songs ***");
        System.out.println("1 - View all songs");
        System.out.println("2 - View songs by name");

        System.out.print("\nEnter your choice: ");
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                viewAllSongs();
            } else if (choice == 2) {
                viewSongsByName();
            } else {
                System.out.println("Invalid choice. Please choose a valid option.");
            }
        } else {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }

    }

    private void viewAllSongs() {
        System.out.println("\n*** List of all songs ***");
        songManagement.viewSongs();
    }

    private void viewSongsByName() {
        System.out.print("Enter the name to search for: ");
        Scanner scanner = new Scanner(System.in);
        String nameToSearch = scanner.nextLine();

        System.out.println("\n*** List of songs with name '" + nameToSearch + "' ***");
        for (Song song : songManagement.getSongs()) {
            if (song.getSongName().toLowerCase().contains(nameToSearch.toLowerCase())) {
                System.out.println(song);
            }
        }
    }
}
