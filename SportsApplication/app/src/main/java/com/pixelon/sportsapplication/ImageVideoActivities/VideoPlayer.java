package com.pixelon.sportsapplication.ImageVideoActivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.pixelon.sportsapplication.PlayerConfig;
import com.pixelon.sportsapplication.R;

public class VideoPlayer extends YouTubeBaseActivity {
String url;
    YouTubePlayerView view;
    YouTubePlayer.OnInitializedListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        url = getIntent().getStringExtra("VIDEO_URL");
        view = (YouTubePlayerView)findViewById(R.id.youtube_player);
        listener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                    youTubePlayer.loadVideo(url);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
            view.initialize(PlayerConfig.API_KEY, listener);
    }
}
