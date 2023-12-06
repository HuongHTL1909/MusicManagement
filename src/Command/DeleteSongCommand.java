package Command;

import Song.SongManagement;

public class DeleteSongCommand implements Command {
    private final SongManagement songManagement;

    public DeleteSongCommand(SongManagement songManagement) {
        this.songManagement = songManagement;
    }

    @Override
    public void execute() {
        songManagement.deleteSong();
    }
}
