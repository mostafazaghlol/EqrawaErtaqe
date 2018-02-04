package com.alsalilweb.androiddeveloper.eqrawaertaqe;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import co.mobiwise.materialintro.shape.Focus;
import co.mobiwise.materialintro.shape.FocusGravity;
import co.mobiwise.materialintro.view.MaterialIntroView;

public class YoutubeActivity extends YouTubeBaseActivity {
    Button b;
    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer.OnInitializedListener onInitializedListener;
    private ListView listView;

    @Override
    protected void onStop() {
        super.onStop();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
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

        new MaterialIntroView.Builder(this)
                .enableDotAnimation(true)
                .enableIcon(false)
                .setFocusGravity(FocusGravity.CENTER)
                .setFocusType(Focus.MINIMUM)
                .setDelayMillis(500)
                .enableFadeAnimation(true)
                .performClick(true)
                .setInfoText("تقدر تختار الصوره الى تريد الاستماع اليها من هنا")
                .setTarget(listView)
                .setUsageId("intro_card") //THIS SHOULD BE UNIQUE ID
                .show();
    }

    public void hi(View view) {
        onBackPressed();
    }



}
