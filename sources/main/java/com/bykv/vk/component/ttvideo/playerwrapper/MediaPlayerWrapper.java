package com.bykv.vk.component.ttvideo.playerwrapper;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bykv.vk.component.ttvideo.log.MyLog;
import com.bykv.vk.component.ttvideo.player.FrameMetadataListener;
import com.bykv.vk.component.ttvideo.player.IMediaDataSource;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.component.ttvideo.player.MediaPlayerClient;
import com.bykv.vk.component.ttvideo.player.MediaTransport;
import com.bykv.vk.component.ttvideo.player.OSPlayerClient;
import com.bykv.vk.component.ttvideo.player.PlaybackParams;
import com.bykv.vk.component.ttvideo.player.TTPlayerConfiger;
import com.bytedance.sdk.component.utils.vl;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public final class MediaPlayerWrapper implements MediaPlayer {
    private static final String OWN_LITE_PLAYER_CLASS_NAME = "com.ss.ttmplayer.player.TTPlayerClient";
    private static final String OWN_PLAYER_CLASS_NAME = "com.bykv.vk.component.ttvideo.player.TTPlayerClient";
    private MediaPlayerClient mClient;

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setDataSource(IMediaDataSource iMediaDataSource) throws IllegalArgumentException, IOException {
    }

    public static MediaPlayer create(Context context, int i6) {
        MediaPlayerWrapper mediaPlayerWrapper = new MediaPlayerWrapper();
        synchronized (MediaPlayerWrapper.class) {
            try {
                if (TTPlayerConfiger.isOnTTPlayer()) {
                    try {
                        Class<?> cls = Class.forName(OWN_PLAYER_CLASS_NAME);
                        Method declaredMethod = cls.getDeclaredMethod("create", MediaPlayer.class, Context.class);
                        declaredMethod.setAccessible(true);
                        mediaPlayerWrapper.mClient = (MediaPlayerClient) declaredMethod.invoke(cls, mediaPlayerWrapper, context);
                    } catch (Throwable th) {
                        vl.j(th);
                    }
                    if (mediaPlayerWrapper.mClient == null && i6 == 0) {
                        try {
                            Class<?> cls2 = Class.forName(OWN_LITE_PLAYER_CLASS_NAME);
                            MyLog.i("fsl", "create lite player");
                            Method declaredMethod2 = cls2.getDeclaredMethod("create", MediaPlayer.class, Context.class);
                            declaredMethod2.setAccessible(true);
                            mediaPlayerWrapper.mClient = (MediaPlayerClient) declaredMethod2.invoke(cls2, mediaPlayerWrapper, context);
                        } catch (Throwable th2) {
                            vl.j(th2);
                        }
                    }
                }
                if (mediaPlayerWrapper.mClient == null) {
                    MyLog.i("fsl", "create osplayer");
                    mediaPlayerWrapper.mClient = OSPlayerClient.create(mediaPlayerWrapper, context);
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return mediaPlayerWrapper;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void deselectTrack(int i6) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.deselectTrack(i6);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public int getCurrentPosition() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public String getDataSource() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getDataSource();
        }
        return null;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public int getDuration() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getDuration();
        }
        return 0;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public float getFloatOption(int i6, float f6) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        return mediaPlayerClient != null ? mediaPlayerClient.getFloatOption(i6, f6) : f6;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public int getIntOption(int i6, int i7) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        return mediaPlayerClient != null ? mediaPlayerClient.getIntOption(i6, i7) : i7;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public long getLongOption(int i6, long j6) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        return mediaPlayerClient != null ? mediaPlayerClient.getLongOption(i6, j6) : j6;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public int getPlayerType() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getType();
        }
        return 0;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public int getSelectedTrack(int i6) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getSelectedTrack(i6);
        }
        return -1;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public String getStringOption(int i6) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getStringOption(i6);
        }
        return null;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public MediaPlayer.TrackInfo[] getTrackInfo() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getTrackInfo();
        }
        return null;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public int getVideoHeight() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getVideoHeight();
        }
        return 0;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public int getVideoType() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getVideoType();
        }
        return 0;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public int getVideoWidth() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getVideoWidth();
        }
        return 0;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public boolean isLooping() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.isLooping();
        }
        return false;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public boolean isMute() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.isMute();
        }
        return false;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public boolean isOSPlayer() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        return mediaPlayerClient == null || (mediaPlayerClient instanceof OSPlayerClient);
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public boolean isPlaying() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.isPlaying();
        }
        return false;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void mouseEvent(int i6, int i7, int i8) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.mouseEvent(i6, i7, i8);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void pause() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.pause();
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void prepare() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.prepare();
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void prepareAsync() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.prepareAsync();
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void prevClose() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.prevClose();
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void release() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.release();
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void releaseAsync() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.releaseAsync();
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void reset() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.reset();
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void rotateCamera(float f6, float f7) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.rotateCamera(f6, f7);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void seekTo(int i6) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.seekTo(i6);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setCacheFile(String str, int i6) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setCacheFile(str, i6);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor, long j6, long j7) throws IllegalStateException, IllegalArgumentException, IOException {
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setDisplay(surfaceHolder);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public int setFloatOption(int i6, float f6) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.setFloatOption(i6, f6);
        }
        return -1;
    }

    public void setFrameMetadataListener(Object obj) {
        if (this.mClient != null) {
            try {
                Method method = Class.forName(OWN_PLAYER_CLASS_NAME).getMethod("setFrameMetadataListener", FrameMetadataListener.class);
                method.setAccessible(true);
                method.invoke(this.mClient, obj);
            } catch (Throwable th) {
                vl.j(th);
            }
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setIntOption(int i6, int i7) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setIntOption(i6, i7);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setIsMute(boolean z5) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setIsMute(z5);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public long setLongOption(int i6, long j6) {
        if (this.mClient != null) {
            return r0.setLongOption(i6, j6);
        }
        return -1L;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setLooping(boolean z5) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setLooping(z5);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setMediaTransport(MediaTransport mediaTransport) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setMediaTransport(mediaTransport);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnBufferingUpdateListener(onBufferingUpdateListener);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnCompletionListener(onCompletionListener);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnErrorListener(onErrorListener);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnInfoListener(onInfoListener);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setOnLogListener(MediaPlayer.OnLogListener onLogListener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnLogListener(onLogListener);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnPreparedListener(onPreparedListener);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setOnSARChangedListener(MediaPlayer.onSARChangedListener onsarchangedlistener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnSARChangedListener(onsarchangedlistener);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnSeekCompleteListener(onSeekCompleteListener);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setOnVideoSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setPanoVideoControlModel(int i6) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setPanoVideoControlModel(i6);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setPlaybackParams(PlaybackParams playbackParams) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setPlaybackParams(playbackParams);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setScreenOnWhilePlaying(boolean z5) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setScreenOnWhilePlaying(z5);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setStringOption(int i6, String str) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setStringOption(i6, str);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setSurface(Surface surface) {
        if (this.mClient == null || surface == null || !surface.isValid()) {
            return;
        }
        this.mClient.setSurface(surface);
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setVolume(float f6, float f7) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setVolume(f6, f7);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setWakeMode(Context context, int i6) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setWakeMode(context, i6);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void start() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.start();
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void stop() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.stop();
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void takeScreenshot(MediaPlayer.OnScreenshotListener onScreenshotListener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.takeScreenshot(onScreenshotListener);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setDataSource(context, uri, map);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setDataSource(String str) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setDataSource(str);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setDataSource(Context context, Uri uri) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setDataSource(context, uri);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void selectTrack(int i6) {
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setOnExternInfoListener(MediaPlayer.OnExternInfoListener onExternInfoListener) {
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void switchStream(int i6, int i7) {
    }
}
