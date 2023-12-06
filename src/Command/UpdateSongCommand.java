// src/Command/UpdateSongCommand.java
package Command;

import Song.Song;
import Song.SongManagement;

import java.util.Scanner;

public class UpdateSongCommand implements Command {
    private SongManagement songManagement;

    public UpdateSongCommand(SongManagement songManagement) {
        this.songManagement = songManagement;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n *** Update Song *** \n");
        System.out.print("Find the song by name: ");
        String keyword = scanner.nextLine();

        songManagement.updateSong(keyword);
    }
}
