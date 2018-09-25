package com.example.andriod.dzidzi;

public class Song {

    //    local or private method items
    private int imageResouceFile;
    private String songTitle;
    private String artistName;
    private int songDownload;
    private int songTocloud;

    //    this states how the items will appear on the list
    public Song(int imageResouceId, String titleSong, String nameOfArtist, int downloadSong, int cloudSong) {

        imageResouceFile = imageResouceId;
        artistName = nameOfArtist;
        songTitle = titleSong;
        songDownload = downloadSong;
        songTocloud = cloudSong;
    }

//    this part is for the current hit

    public Song(int imageResouceFile2, String titleSong2, String artistName2) {

        imageResouceFile = imageResouceFile2;
        songTitle = titleSong2;
        artistName = artistName2;
    }

//    This part is for the cloud list

    public Song(int cloudImage, int imageResouceFile3, String titleSong3, String artistName3) {

        songTocloud = cloudImage;
        imageResouceFile = imageResouceFile3;
        songTitle = titleSong3;
        artistName = artistName3;

    }

    public int getImageResouceId() {
        return imageResouceFile;
    }

    public String getSongTitleId() {
        return songTitle;
    }

    public String getArtistNameId() {
        return artistName;
    }

    public int getSongDownloadId() {
        return songDownload;
    }

    public int getSongTocloudId() {
        return songTocloud;
    }
}
