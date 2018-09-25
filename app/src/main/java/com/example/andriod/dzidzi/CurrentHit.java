package com.example.andriod.dzidzi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class CurrentHit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_current_hit );

        menu menuConstructor = new menu( this );
        menuConstructor.activity.getIntent();

        ArrayList<Song> songs = new ArrayList<>();

        ListView currentHitSongs = findViewById( R.id.current_list2 );

        SondAdapter adapter = new SondAdapter( this, songs );

//        this part list the top 40 hit songs
        currentHitSongs.setAdapter( adapter );
        songs.add( new Song( R.drawable.duanec, "August Town", "D. Stephenson " ) );
        songs.add( new Song( R.drawable.ebenc, "Jesus at the cent", "Eben " ) );
        songs.add( new Song( R.drawable.westlifec, "An empty Street", "West Life " ) );
        songs.add( new Song( R.drawable.kennyc, "Twenty Yeas Ago", "Kenny Rogers " ) );
        songs.add( new Song( R.drawable.ub40c, "Kingston Town", "UB 40 " ) );


    }

}
