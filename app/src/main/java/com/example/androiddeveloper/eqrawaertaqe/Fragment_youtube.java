package com.example.androiddeveloper.eqrawaertaqe;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerView;

/**
 * Created by mostafa on 1/30/18.
 */

public class Fragment_youtube extends android.support.v4.app.Fragment {
    Button b;
    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer.OnInitializedListener onInitializedListener;
    View  MyView;
    public Fragment_youtube(){
        // Required empty public constructor .
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Youtube");
}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MyView = inflater.inflate(R.layout.youtube, container, false);
        return MyView;
    }
/*
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        try {
            youTubePlayerView = (YouTubePlayerView) getView().findViewById(R.id.youtube);
            onInitializedListener = new YouTubePlayer.OnInitializedListener() {
                @Override
                public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                    youTubePlayer.loadVideo("a4NT5iBFuZs");
                }

                @Override
                public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

                }
            };
            b = (Button) getView().findViewById(R.id.ButtonYou);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    youTubePlayerView.initialize("AIzaSyCxIDO5PtAnPY6Y_DO-u07Z1SVo8guVH7Q", onInitializedListener);
                }
            });
        }catch (Exception e){
            Log.e("onCreateView",e.getMessage());
        }

    }
    */
}
