package smartface.com.nativetest;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;

import androidx.appcompat.app.AppCompatActivity;

import android.util.AttributeSet;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.util.Log;


import com.devbrackets.android.exomedia.core.source.builder.MediaSourceBuilder;
import com.devbrackets.android.exomedia.ui.widget.VideoControlsCore;
import com.devbrackets.android.exomedia.ui.widget.VideoControlsMobile;
import com.devbrackets.android.exomedia.ui.widget.VideoView;
import com.google.android.exoplayer2.ControlDispatcher;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackPreparer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.device.DeviceInfo;
import com.google.android.exoplayer2.device.DeviceListener;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;
import com.google.android.exoplayer2.ui.StyledPlayerView;
import com.google.android.exoplayer2.video.VideoListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/*
- loading indicator - Mevcut
- placeHolder - ?
- full screen buttonu
- life-cycle management ? (isBackgroundRunEnabled)
 */
public class VideoTest extends AppCompatActivity {

    MediaSessionCompat mediaSession;
    PlaybackStateCompat.Builder stateBuilder;
    CustomVideView videoView;
    Context videoTestCtx;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.video_bg_layout);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);

        videoTestCtx = this;

        ExoPlayerHelper exoPlayerHelper = new ExoPlayerHelper(this);
        getLifecycle().addObserver(exoPlayerHelper);

        exoPlayerHelper.allowBackgroundRunning(true);
        exoPlayerHelper.setStateful(true);

        exoPlayerHelper.setUri("https://tv-trtworld.live.trt.com.tr/master.m3u8");

//        StyledPlayerView playerView = new StyledPlayerView(this);
//        MediaItem mediaItem = new MediaItem.Builder()
//                .setUri(Uri.parse("https://tv-trtworld.live.trt.com.tr/master.m3u8"))
//                .build();
//
//        SimpleExoPlayer player = new SimpleExoPlayer.Builder(this)
//                .build();
//
//        player.setMediaItem(mediaItem);
//        player.prepare();
//        permanent
        exoPlayerHelper.setCustomErrorMessage("This is Custom Error Message :)");
//        playerView.setPlayer(player);
//        exoPlayerHelper.setBackgroundColor(Color.RED);


        exoPlayerHelper.setShowBuffering(StyledPlayerView.SHOW_BUFFERING_NEVER);

        exoPlayerHelper.setShowNextButton(true);
        exoPlayerHelper.setShowFastForwardButton(true);
        exoPlayerHelper.setShowRewindButton(true);
        exoPlayerHelper.setShowPreviousButton(true);
        exoPlayerHelper.setControllerVisibilityListener(new StyledPlayerControlView.VisibilityListener() {
            @Override
            public void onVisibilityChange(int visibility) {

            }
        });

        exoPlayerHelper.getPlayer().addListener(new Player.EventListener() {
            @Override
            public void onPlayerError(ExoPlaybackException error) {
                ExoPlaybackException e = error;
            }
        });
        //        playerView.setUseController(false);



        exoPlayerHelper.getPlayer().setPlayWhenReady(false);
        exoPlayerHelper.setControllerOnFullScreenModeChangedListener(isFullScreen -> {
            if (isFullScreen)
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            else
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        });


        exoPlayerHelper.setLayoutParams(new ViewGroup.LayoutParams(500, 500));
        setContentView(exoPlayerHelper);

        Button button = new Button(this);
        button.setText("PressOn");


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            enterPictureInPictureMode();
        }
    }


    @Override
    public void onPictureInPictureModeChanged (boolean isInPictureInPictureMode, Configuration newConfig) {
        if (isInPictureInPictureMode) {
            // Hide the full-screen UI (controls, etc.) while in picture-in-picture mode.
        } else {
            // Restore the full-screen UI.
        }
    }
}
