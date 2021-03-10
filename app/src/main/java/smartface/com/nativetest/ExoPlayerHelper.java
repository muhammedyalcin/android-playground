package smartface.com.nativetest;

import android.content.Context;
import android.net.Uri;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackPreparer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;
import com.google.android.exoplayer2.ui.StyledPlayerView;
import com.google.android.exoplayer2.util.Util;

class ExoPlayerHelper extends StyledPlayerView implements StyledPlayerControlView.OnFullScreenModeChangedListener, PlaybackPreparer, Player.EventListener, LifecycleObserver {

//    private SMFJSObject onFullScreenModeChangedCallback;
//    private SMFJSObject onPlaybackStateChanged;
    private boolean allowBackgroundRunning;
    private String mediaUri;
    private boolean playWhenReady;
    private int repeatMode = Player.REPEAT_MODE_OFF;
    private long startPosition;
    private int windowIndex;
    private boolean isStateful = true;

    public ExoPlayerHelper(Context context) {
        super(context);
        initPlayer();
    }

    public void allowBackgroundRunning(boolean background) {
        this.allowBackgroundRunning = background;
    }

    public boolean getAllowBackgroundRunning() {
        return allowBackgroundRunning;
    }

    public boolean getStateful() {
        return this.isStateful;
    }

    public void setStateful(boolean stateful) {
        this.isStateful = stateful;
    }

    public void setUri(String url) {

        if (getPlayer() != null && getPlayer().getMediaItemCount() != 0) {
            getPlayer().stop(true);
            releasePlayer();
            initPlayer();
        }

        mediaUri = url;
        MediaItem item = new MediaItem.Builder()
                .setUri(Uri.parse(mediaUri))
                .build();
        getPlayer().setMediaItem(item);
        getPlayer().prepare();
    }

    public void initPlayer() {

        SimpleExoPlayer player = new SimpleExoPlayer.Builder(getContext())
                .setAudioAttributes(AudioAttributes.DEFAULT, true)
                .build();

        player.addListener(this);
        setPlayer(player);
        setPlaybackPreparer(this);

        if (!isStateful)
            return;

        player.setPlayWhenReady(playWhenReady);
        player.setRepeatMode(repeatMode);

        if (startPosition != C.TIME_UNSET && startPosition != 0)
            player.seekTo(windowIndex, startPosition);

        if (mediaUri != null)
            setUri(mediaUri);
    }


    @Override
    public void onPlaybackStateChanged(int state) {
//        if (this.onPlaybackStateChanged == null)
//            return;
//        try {
//            SMFJSObject smfjsObject = this.onPlaybackStateChanged.getProperty("onPlaybackStateChanged");
//            smfjsObject.callAsNativeFunctionNew(smfjsObject.jsValueRef, new Object[]{state});
//        } catch (Exception e) {
//            Log.e("SMF", "SFVideoView onPlaybackStateChanged: ", e);
//        }
    }
//
//    public void setOnPlaybackStateChanged(SMFJSObject onPlaybackStateChanged) {
//        this.onPlaybackStateChanged = onPlaybackStateChanged;
//    }
//
//    public void setFullScreenModeChangedCallback(SMFJSObject onFullScreenModeChangedCallback) {
//        this.onFullScreenModeChangedCallback = onFullScreenModeChangedCallback;
//        setControllerOnFullScreenModeChangedListener(this);
//    }

    @Override
    public void onFullScreenModeChanged(boolean isFullScreen) {
//        if (this.onFullScreenModeChangedCallback != null)
//            return;
//        try {
//            SMFJSObject smfjsObject = this.onFullScreenModeChangedCallback.getProperty("onFullScreenModeChanged");
//            smfjsObject.callAsNativeFunctionNew(smfjsObject.jsValueRef, new Object[]{isFullScreen});
//        } catch (Exception e) {
//            Log.e("SMF", "SFVideoView onFullScreenModeChanged: ", e);
//        }
    }

    public void releasePlayer() {
        if (getPlayer() == null)
            return;

        playWhenReady = getPlayer().getPlayWhenReady();
        repeatMode = getPlayer().getRepeatMode();
        windowIndex = getPlayer().getCurrentWindowIndex();
        startPosition = Math.max(0, getPlayer().getCurrentPosition());
        getPlayer().removeListener(this);
        getPlayer().clearMediaItems();
        getPlayer().release();
        setPlayer(null);
    }


    @Override
    public void preparePlayback() {
        getPlayer().prepare();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onFragmentStop() {
        if (Util.SDK_INT > 23) {
            onPause();
            if (!allowBackgroundRunning)
                releasePlayer();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onFragmentPause() {
        if (Util.SDK_INT <= 23) {
            onPause();
            if (!allowBackgroundRunning)
                releasePlayer();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onFragmentResume() {
        if (Util.SDK_INT <= 23) {
            if (!allowBackgroundRunning && getPlayer() == null)
                initPlayer();
            onResume();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onFragmentStart() {
        if (Util.SDK_INT > 23) {
            if (!allowBackgroundRunning && getPlayer() == null)
                initPlayer();
            onResume();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onFragmentDestroy() {
        releasePlayer();
    }

}