package com.alsalilweb.androiddeveloper.eqrawaertaqe;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeActivity extends YouTubeBaseActivity {
    Button b;
    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer.OnInitializedListener onInitializedListener;
    private ListView listView;

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubeViewer);
        listView = (ListView)findViewById(R.id.list);
        String[] array =  getResources().getStringArray(R.array.Quran_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1,array);
        listView.setAdapter(adapter);

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, final YouTubePlayer youTubePlayer, boolean b) {
                    youTubePlayer.loadPlaylist("PLlG9ym8zo48Tn4W3uPOp7_tqzpGB2a2gc");
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                youTubePlayer.loadPlaylist("PLlG9ym8zo48Tn4W3uPOp7_tqzpGB2a2gc",i,0);
                Home.numberOfSwra = i ;
                Home.currentTimeMillis = youTubePlayer.getCurrentTimeMillis();
                    }
                });

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        youTubePlayerView.initialize("AIzaSyCxIDO5PtAnPY6Y_DO-u07Z1SVo8guVH7Q", onInitializedListener);

    }

    public void hi(View view) {
        onBackPressed();
    }

//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        numberOfSwra = savedInstanceState.getInt("numberOfSwra");
//        currentTimeMillis = savedInstanceState.getInt("currentTimeMillis");
//    }
//
//    @Override
//    protected void onSaveInstanceState(Bundle bundle) {
//        super.onSaveInstanceState(bundle);
//        bundle.putInt("numberOfSwra",numberOfSwra);
//        bundle.putInt("currentTimeMillis",currentTimeMillis);
//    }


}
