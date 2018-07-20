package in.paperwrk.musicalstructureapp.model;

public class Song {
    private String songName;
    private String songArtistName;
    private int thumbnail;

    public Song(String songName, String songArtistName, int thumbnail) {
        this.songName = songName;
        this.songArtistName = songArtistName;
        this.thumbnail = thumbnail;
    }

    public Song(String songName, int thumbnail){
        this.songName = songName;
        this.thumbnail = thumbnail;
    }

    public String getSongName() {
        return songName;
    }

    public String getSongArtistName() {
        return songArtistName;
    }

    public int getThumbnail() {
        return thumbnail;
    }
}