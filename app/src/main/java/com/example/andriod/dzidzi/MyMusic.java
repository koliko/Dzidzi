package com.example.andriod.dzidzi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MyMusic extends AppCompatActivity {

    //    this part gets the songs into the player
    int drawable[] = {R.drawable.duanec, R.drawable.westlifec, R.drawable.ebenc, R.drawable.kennyc, R.drawable.ub40c};

    private ArrayList<Song> mySong;
    private SondAdapter mYSongAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_my_music );

        menu menuConstructor = new menu( this );
        menuConstructor.activity.getIntent();
        mySongList();
        Spinner spinner = findViewById( R.id.songsReceive );
        mYSongAdapter = new SondAdapter( this, mySong );
        spinner.setAdapter( mYSongAdapter );

//        this handles the onclick item of the spinner view
        spinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Song song = (Song) parent.getItemAtPosition( position );

                final int songTheme = song.getImageResouceId();

                int TotalSong;
                int size = drawable.length;
                for (int i = 0; i < size; i++) {

                    if (drawable[i] == songTheme) {
                        TotalSong = drawable[i];

                        displayCurrentSongTheme( TotalSong );
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        } );
    }


    //    this function gets the songs and add them to the spinner
    private void mySongList() {
        mySong = new ArrayList<>();
        mySong.add( new Song( R.drawable.duanec, "August Town", "D. Stephenson " ) );
        mySong.add( new Song( R.drawable.ebenc, "Jesus at the cent", "Eben " ) );
        mySong.add( new Song( R.drawable.westlifec, "An empty Street", "West Life " ) );
        mySong.add( new Song( R.drawable.kennyc, "Twenty Yeas Ago", "Kenny Rogers " ) );
        mySong.add( new Song( R.drawable.ub40c, "Kingston Town", "UB 40 " ) );
    }

    //    displaying the current paying song theme
    public void displayCurrentSongTheme(int theme) {
        ImageView imageView = findViewById( R.id.currentPlayingTheme );
        imageView.setImageResource( Integer.parseInt( "" + theme ) );
    }
}

