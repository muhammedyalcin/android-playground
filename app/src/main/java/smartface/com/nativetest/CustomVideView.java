package smartface.com.nativetest;

import android.content.Context;
import android.graphics.Canvas;
import android.media.AudioAttributes;
import android.media.MediaFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.NonNull;

import java.io.InputStream;
import java.util.Map;

class CustomVideView extends VideoView {

    public CustomVideView(Context context) {
        super(context);
    }

    public CustomVideView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomVideView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public CharSequence getAccessibilityClassName() {
        return super.getAccessibilityClassName();
    }

    @Override
    public int resolveAdjustedSize(int desiredSize, int measureSpec) {
        return super.resolveAdjustedSize(desiredSize, measureSpec);
    }

    @Override
    public void setVideoPath(String path) {
        super.setVideoPath(path);
    }

    @Override
    public void setVideoURI(Uri uri) {
        super.setVideoURI(uri);
    }

    @Override
    public void setVideoURI(Uri uri, Map<String, String> headers) {
        super.setVideoURI(uri, headers);
    }

    @Override
    public void setAudioFocusRequest(int focusGain) {
        super.setAudioFocusRequest(focusGain);
    }

    @Override
    public void setAudioAttributes(@NonNull AudioAttributes attributes) {
        super.setAudioAttributes(attributes);
    }

    @Override
    public void addSubtitleSource(InputStream is, MediaFormat format) {
        super.addSubtitleSource(is, format);
    }

    @Override
    public void stopPlayback() {
        super.stopPlayback();
    }

    @Override
    public void setMediaController(MediaController controller) {
        super.setMediaController(controller);
    }

    @Override
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener l) {
        super.setOnPreparedListener(l);
    }

    @Override
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener l) {
        super.setOnCompletionListener(l);
    }

    @Override
    public void setOnErrorListener(MediaPlayer.OnErrorListener l) {
        super.setOnErrorListener(l);
    }

    @Override
    public void setOnInfoListener(MediaPlayer.OnInfoListener l) {
        super.setOnInfoListener(l);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(ev);
    }

    @Override
    public boolean onTrackballEvent(MotionEvent ev) {
        return super.onTrackballEvent(ev);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void suspend() {
        super.suspend();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public int getDuration() {
        return super.getDuration();
    }

    @Override
    public int getCurrentPosition() {
        return super.getCurrentPosition();
    }

    @Override
    public void seekTo(int msec) {
        super.seekTo(msec);
    }

    @Override
    public boolean isPlaying() {
        return super.isPlaying();
    }

    @Override
    public int getBufferPercentage() {
        return super.getBufferPercentage();
    }

    @Override
    public boolean canPause() {
        return super.canPause();
    }

    @Override
    public boolean canSeekBackward() {
        return super.canSeekBackward();
    }

    @Override
    public boolean canSeekForward() {
        return super.canSeekForward();
    }

    @Override
    public int getAudioSessionId() {
        return super.getAudioSessionId();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

}
