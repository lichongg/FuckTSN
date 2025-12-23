package com.bykv.vk.component.ttvideo.player;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.utils.vl;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class MediaPlayerClient {
    public static final int IsAudioVoiceWaitTimeout = 1;
    public static final int IsBuffering = 0;
    public static final int MAX_LOG_LINES = 40;

    public abstract void deselectTrack(int i6);

    public abstract int getCurrentPosition();

    public String getDataSource() {
        return null;
    }

    public abstract int getDuration();

    public abstract int getSelectedTrack(int i6);

    public String getStringOption(int i6) {
        return null;
    }

    public abstract MediaPlayer.TrackInfo[] getTrackInfo();

    public abstract int getType();

    public abstract int getVideoHeight();

    public int getVideoType() {
        return 0;
    }

    public abstract int getVideoWidth();

    public abstract boolean isLooping();

    public boolean isMute() {
        return false;
    }

    public abstract boolean isPlaying();

    public abstract void pause();

    public abstract void prepare();

    public abstract void prepareAsync();

    @Deprecated
    public abstract void prevClose();

    public abstract void release();

    public abstract void releaseAsync();

    public abstract void reset();

    public abstract void seekTo(int i6);

    public abstract void selectTrack(int i6);

    public abstract void setDataSource(Context context, Uri uri) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException;

    public abstract void setDataSource(Context context, Uri uri, Map<String, String> map) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException;

    public abstract void setDataSource(IMediaDataSource iMediaDataSource) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException;

    public abstract void setDataSource(FileDescriptor fileDescriptor, long j6, long j7) throws IllegalStateException, IllegalArgumentException, IOException;

    public abstract void setDataSource(String str) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException;

    public abstract void setDisplay(SurfaceHolder surfaceHolder);

    public int setDoubleOption(int i6, double d6) {
        return -1;
    }

    public int setFloatOption(int i6, float f6) {
        return -1;
    }

    public abstract void setFrameMetadataListener(FrameMetadataListener frameMetadataListener);

    public int setLongOption(int i6, long j6) {
        return -1;
    }

    public abstract void setLooping(boolean z5);

    public abstract void setMediaTransport(MediaTransport mediaTransport);

    public abstract void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener);

    public abstract void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener);

    public abstract void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener);

    public abstract void setOnExternInfoListener(MediaPlayer.OnExternInfoListener onExternInfoListener);

    public abstract void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener);

    public abstract void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener);

    public abstract void setOnSARChangedListener(MediaPlayer.onSARChangedListener onsarchangedlistener);

    public abstract void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener);

    public abstract void setOnVideoSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener);

    public abstract void setPlaybackParams(PlaybackParams playbackParams);

    public abstract void setScreenOnWhilePlaying(boolean z5);

    public int setStringOption(int i6, String str) {
        return -1;
    }

    public abstract void setSurface(Surface surface);

    public abstract void setVolume(float f6, float f7);

    public abstract void setWakeMode(Context context, int i6);

    public abstract void start();

    public abstract void stop();

    public abstract void switchStream(int i6, int i7);

    public abstract void takeScreenshot(MediaPlayer.OnScreenshotListener onScreenshotListener);

    public void rotateCamera(float f6, float f7) {
        vl.j(TTPlayerConfiger.TAG, "<MediaPlayerClient.java,rotateCamera,55>rotateCamera is not implemented");
    }

    public int setIntOption(int i6, int i7) {
        vl.j(TTPlayerConfiger.TAG, "<MediaPlayerClient.java,setIntOption,65>set os player is not inval");
        return -1;
    }

    public void setIsMute(boolean z5) {
    }

    public void setOnLogListener(MediaPlayer.OnLogListener onLogListener) {
    }

    public void setPanoVideoControlModel(int i6) {
    }

    public double getDoubleOption(int i6, double d6) {
        return d6;
    }

    public float getFloatOption(int i6, float f6) {
        return f6;
    }

    public int getIntOption(int i6, int i7) {
        return i7;
    }

    public long getLongOption(int i6, long j6) {
        return j6;
    }

    public void setCacheFile(String str, int i6) {
    }

    public void mouseEvent(int i6, int i7, int i8) {
    }
}
