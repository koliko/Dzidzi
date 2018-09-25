package com.example.andriod.dzidzi;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SondAdapter extends ArrayAdapter<Song> {

    private static final String LOG_TAG = SondAdapter.class.getSimpleName();

    //    copy of the songs we passed to our adapter
    private List<Song> fillSongListFull;
    private Filter songFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            FilterResults results = new FilterResults();
            List<Song> suggestion = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {

                suggestion.addAll( fillSongListFull );
            } else {

                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Song item : fillSongListFull) {

                    if (item.getSongTitleId().toLowerCase().contains( filterPattern ) || item.getArtistNameId().toLowerCase().contains( filterPattern )) {
                        suggestion.add( item );
                    }
                }
            }

            results.values = suggestion;
            results.count = suggestion.size();

            return results;

        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            clear();
            addAll( (List) results.values );
            notifyDataSetChanged();
        }

        @Override
        public CharSequence convertResultToString(Object resultValue) {
            return ((Song) resultValue).getSongTitleId();
        }
    };

    //    Calling the constructor into the Array Adapter
    public SondAdapter(Activity context, List<Song> songList) {

        super( context, 0, songList );

//        this crate a new array list to hold our song list
        fillSongListFull = new ArrayList<>( songList );
    }

    //    this part create a filter for the songs

    @NonNull
    @Override
    public Filter getFilter() {
        return songFilter;
    }

//    this method get the songs into the spinner dropdown

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        return songView( position, convertView, parent );
    }

    private View songView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from( getContext() ).inflate(
                    R.layout.song_list, parent, false
            );
        }

        ImageView iconImage = convertView.findViewById( R.id.song_theme );
        TextView songTitle = convertView.findViewById( R.id.song_title );
        TextView songArtist = convertView.findViewById( R.id.artist_name );

        Song currentSong = getItem( position );

        if (currentSong != null) {

            iconImage.setImageResource( currentSong.getImageResouceId() );
            songTitle.setText( currentSong.getSongTitleId() );
            songArtist.setText( currentSong.getArtistNameId() );
        }

        return convertView;
    }

    //    this method get the songs and list them on the array adapter
    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {

        View songItemView = convertView;

//        checking if a View is not in use for View re-cycling
        if (songItemView == null) {
            songItemView = LayoutInflater.from( getContext() ).inflate( R.layout.song_list, parent, false );
        }

//        getting each item into the Adapter with their position
        Song currentSong = getItem( position );

        final TextView songTitle = songItemView.findViewById( R.id.song_title );
        songTitle.setText( currentSong.getSongTitleId() );

        final ImageView iconView = songItemView.findViewById( R.id.song_theme );
        iconView.setImageResource( currentSong.getImageResouceId() );

        final TextView artistName = songItemView.findViewById( R.id.artist_name );
        artistName.setText( currentSong.getArtistNameId() );

        final ImageView downloadSong = songItemView.findViewById( R.id.song_download );
        downloadSong.setImageResource( currentSong.getSongDownloadId() );

        final ImageView cloudSong = songItemView.findViewById( R.id.cloud_song );
        cloudSong.setImageResource( currentSong.getSongTocloudId() );

        iconView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( getContext(), "NOw Playing  Selected Song ", Toast.LENGTH_LONG ).show();

            }
        } );

        cloudSong.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( getContext(), "Song save to Cloud, Check My Library ", Toast.LENGTH_LONG ).show();
            }
        } );

        downloadSong.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( getContext(), "Song save to device, Check My Music ", Toast.LENGTH_LONG ).show();

            }
        } );
        return songItemView;
    }

}
