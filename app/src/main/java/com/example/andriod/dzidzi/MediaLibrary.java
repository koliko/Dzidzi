package com.example.andriod.dzidzi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.ListView;

import java.util.ArrayList;

public class MediaLibrary extends AppCompatActivity {

    CheckBox checkBox;
    private ArrayList<Song> myCloud;
    private SondAdapter myCloudSound;
    private ListView myCloudList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_media_library );

        menu menuConstructor = new menu( this );
        menuConstructor.activity.getIntent();

        checkBox = findViewById( R.id.cloudCheck );

//        this part calls the array adapter for the cloud sounds and add it to the listview
        myCloudList();
        myCloudSound = new SondAdapter( this, myCloud );
        myCloudList = findViewById( R.id.cloudList );
        myCloudList.setAdapter( myCloudSound );


    }

    //    this method is for the cloud song listing
    public void myCloudList() {
        myCloud = new ArrayList<>();
        myCloud.add( new Song( R.drawable.googledrive, R.drawable.ebenc, "Jesus at the center ", "Eben" ) );
        myCloud.add( new Song( R.drawable.googledrive, R.drawable.ebenc, "Jesus at the center ", "Eben" ) );
        myCloud.add( new Song( R.drawable.dropbox, R.drawable.ebenc, "Jesus at the center ", "Eben" ) );
        myCloud.add( new Song( R.drawable.dropbox, R.drawable.ebenc, "Jesus at the center ", "Eben" ) );
        myCloud.add( new Song( R.drawable.googledrive, R.drawable.ebenc, "Jesus at the center ", "Eben" ) );
        myCloud.add( new Song( R.drawable.dropbox, R.drawable.ebenc, "Jesus at the center ", "Eben" ) );
        myCloud.add( new Song( R.drawable.googledrive, R.drawable.ebenc, "Jesus at the center ", "Eben" ) );
        myCloud.add( new Song( R.drawable.dropbox, R.drawable.ebenc, "Jesus at the center ", "Eben" ) );
    }
}
