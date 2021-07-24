package com.example.spotifykaraokeee.ui.SearchSong;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.spotifykaraokeee.R;

import java.util.List;

import kaaes.spotify.webapi.android.SpotifyApi;
import kaaes.spotify.webapi.android.SpotifyCallback;
import kaaes.spotify.webapi.android.SpotifyError;
import kaaes.spotify.webapi.android.SpotifyService;
import kaaes.spotify.webapi.android.models.Track;
import kaaes.spotify.webapi.android.models.TracksPager;

public class SearchSongFragment extends Fragment {

    private SearchSongViewModel searchSongViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        searchSongViewModel =
                new ViewModelProvider(this).get(SearchSongViewModel.class);
        View root = inflater.inflate(R.layout.fragment_search_song, container, false);
        //originally was a dashboard fragment, changed name to search song fragment
        final TextView textView = root.findViewById(R.id.text_search_song);
        searchSongViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;

        /*
        String song_title = "Love never felt so good";

        SpotifyApi api = new SpotifyApi();

        api.setAccessToken();

        SpotifyService spotify = api.getService();

        spotify.searchTracks(song_title, new SpotifyCallback<TracksPager>() {
            @Override
            public void success(TracksPager tracksPager, retrofit.client.Response response) {
               List<Track> songs = tracksPager.tracks.items;
                //System.out.print(songs);
            }

            @Override
            public void failure(SpotifyError spotifyError) {
                Log.d("Track failure", spotifyError.toString());
            }
        });
        */
    }
}