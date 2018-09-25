package com.example.andriod.dzidzi;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

public class menu {


    public Activity activity;

    public menu(final Activity newActivity) {

        this.activity = newActivity;

        ImageView myMusic = this.activity.findViewById( R.id.my_music );
        ImageView mediaLibrary = this.activity.findViewById( R.id.media_library );
        ImageView currentHit = this.activity.findViewById( R.id.current_hit );
        ImageView home = this.activity.findViewById( R.id.myhome );

        myMusic.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Users are send to the music search page via intent

                Intent intent = new Intent( menu.this.activity, MyMusic.class );
                activity.startActivity( intent );
                activity.overridePendingTransition( R.anim.slide_left, R.anim.slide_right );
            }
        } );

        mediaLibrary.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( menu.this.activity, MediaLibrary.class );
                activity.startActivity( intent );
                activity.overridePendingTransition( R.anim.slide_left, R.anim.slide_right );
            }
        } );

        currentHit.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( menu.this.activity, CurrentHit.class );
                activity.startActivity( intent );
                activity.overridePendingTransition( R.anim.slide_right, R.anim.slide_left );
            }
        } );

//        this is the activity for the home screen
        home.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( menu.this.activity, MainActivity.class );
                activity.startActivity( intent );
                activity.overridePendingTransition( R.anim.slide_left, R.anim.slide_right );

            }
        } );


    }

}
