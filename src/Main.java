import Command.*;
import Song.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SongManagement songManagement = SongManagement.getInstance();

        while (true) {
            System.out.println("\n *** TUNESOURCE'S SONG MANAGEMENT PAGE *** \n");
            System.out.println("\t 1 - Add a new song");
            System.out.println("\t 2 - View song(s)");
            System.out.println("\t 3 - Update a song");
            System.out.println("\t 4 - Delete song");
            System.out.println("\t 5 - Exit");

            System.out.print("\nEnter your choice: ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume the newline character

                switch (choice) {
                    case 1:
                        Command addSongCommand = new AddSongCommand(songManagement);
                        addSongCommand.execute();
                        break;
                    case 2:
                        if (songManagement.getSongs().isEmpty()){
                            System.out.println("The list of songs is currently empty!");
                        } else {
                            Command viewSongCommand = new ViewSongCommand(songManagement);
                            viewSongCommand.execute();
                        }
                        break;
                    case 3:
                        Command updateSongCommand = new UpdateSongCommand(songManagement);
                        updateSongCommand.execute();
                        break;
                    case 4:
                        Command deleteSongCommand = new DeleteSongCommand(songManagement);
                        deleteSongCommand.execute();
                        break;
                    case 5:
                        System.out.println("The program is being closed!");
                        System.out.println("Wait a minute...");
                        try {
                            Thread.sleep(3000);
                            System.exit(0);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose a valid option.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
    }
}
