package com.example.andriod.dzidzi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //creating a private list

    AutoCompleteTextView songSearch;
    private List<Song> songList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

//        this part calls the constructor(menu)
        menu menuConstructor = new menu( this );
        menuConstructor.activity.getIntent();

//        this part calls the songs list method
        fillSongList();

        songSearch = findViewById( R.id.search_box );

        SondAdapter newSongAdapter = new SondAdapter( this, songList );
        songSearch.setAdapter( newSongAdapter );

        showAllSong();
    }

    //    this method is for the interactive search
    private void fillSongList() {

        songList = new ArrayList<>();
        songList.add( new Song( R.drawable.ub40c, "Kingston Town", "UB 40 ", R.drawable.download, R.drawable.clouddown ) );
        songList.add( new Song( R.drawable.duanec, "August Town", "D. Stephenson ", R.drawable.download, R.drawable.clouddown ) );
        songList.add( new Song( R.drawable.ebenc, "Jesus at the cent", "Eben ", R.drawable.download, R.drawable.clouddown ) );
        songList.add( new Song( R.drawable.westlifec, "An empty Street", "West Life ", R.drawable.download, R.drawable.clouddown ) );
        songList.add( new Song( R.drawable.kennyc, "Twenty Yeas Ago", "Kenny Rogers ", R.drawable.download, R.drawable.clouddown ) );

    }

    //    this method is for the homepage
    private void showAllSong() {

        ArrayList<Song> songsAll = new ArrayList<>();

        songsAll.add( new Song( R.drawable.ub40c, "Kingston Town", "UB 40 ", R.drawable.download, R.drawable.clouddown ) );
        songsAll.add( new Song( R.drawable.duanec, "August Town", "D. Stephenson ", R.drawable.download, R.drawable.clouddown ) );
        songsAll.add( new Song( R.drawable.ebenc, "Jesus at the cent", "Eben ", R.drawable.download, R.drawable.clouddown ) );
        songsAll.add( new Song( R.drawable.westlifec, "An empty Street", "West Life ", R.drawable.download, R.drawable.clouddown ) );
        songsAll.add( new Song( R.drawable.kennyc, "Twenty Yeas Ago", "Kenny Rogers ", R.drawable.download, R.drawable.clouddown ) );
        SondAdapter adapter = new SondAdapter( this, songsAll );
        ListView listSongs = findViewById( R.id.current_list );
        listSongs.setAdapter( adapter );

    }

}
