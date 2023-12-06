package Song;

public class Song {
    private String songName;
    private String artist;
    private String genre;
    private String releaseDate;
    private String providedBy;

    public Song(String songName, String artist, String genre, String releaseDate, String providedBy) {
        this.songName = songName;
        this.artist = artist;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.providedBy = providedBy;
    }

    @Override
    public String toString() {
        return
            "SONGS INFORMATION: \n" +
            "\t Name: "+ songName.toUpperCase() + ",\n" +
            "\t Artist: " + artist + ",\n" +
            "\t Genre: " + genre + ",\n" +
            "\t Release Date: " + releaseDate + ",\n" +
            "\t Provided By: " + providedBy;
    }

    public String getSongName(){
        return songName;
    }

    public void setSongName(String newSongName) {
        this.songName = newSongName;
    }

    public void setArtist(String newArtist) {
        this.artist = newArtist;
    }

    public void setGenre(String newGenre) {
        this.genre = newGenre;
    }

    public void setReleaseDate(String newReleaseDate) {
        this.releaseDate = newReleaseDate;
    }

    public void setProvidedBy(String newProvidedBy) {
        this.providedBy = newProvidedBy;
    }
}
