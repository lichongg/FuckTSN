package com.bykv.vk.component.ttvideo;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bykv.vk.component.ttvideo.player.IMediaDataSource;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.component.ttvideo.player.MediaPlayerClient;
import com.bykv.vk.component.ttvideo.player.MediaTransport;
import com.bykv.vk.component.ttvideo.player.OSPlayerClient;
import com.bykv.vk.component.ttvideo.player.PlaybackParams;
import com.bykv.vk.component.ttvideo.player.TTPlayerClient;
import com.bykv.vk.component.ttvideo.utils.TTVideoEngineLog;
import java.io.FileDescriptor;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class a implements MediaPlayer {

    /* renamed from: a, reason: collision with root package name */
    private MediaPlayerClient f22884a;

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public int getSelectedTrack(int i6) {
        return 0;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public MediaPlayer.TrackInfo[] getTrackInfo() {
        return new MediaPlayer.TrackInfo[0];
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setDataSource(Context context, Uri uri) {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setDataSource(context, uri);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public int setFloatOption(int i6, float f6) {
        return 0;
    }

    public static MediaPlayer a(Context context, int i6) {
        String str;
        String str2;
        a aVar = new a();
        synchronized (a.class) {
            try {
                if (i6 == 1) {
                    aVar.f22884a = OSPlayerClient.create(aVar, context);
                    str = "MediaPlayerWrapper";
                    str2 = "create player type OS";
                } else {
                    aVar.f22884a = TTPlayerClient.create(aVar, context);
                    str = "MediaPlayerWrapper";
                    str2 = "create player type OWN";
                }
                TTVideoEngineLog.i(str, str2);
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public int getCurrentPosition() {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public String getDataSource() {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getDataSource();
        }
        return null;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public int getDuration() {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getDuration();
        }
        return 0;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public int getIntOption(int i6, int i7) {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        return mediaPlayerClient != null ? mediaPlayerClient.getIntOption(i6, i7) : i7;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public int getPlayerType() {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getType();
        }
        return 0;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public String getStringOption(int i6) {
        return "";
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public int getVideoHeight() {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getVideoHeight();
        }
        return 0;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public int getVideoType() {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getVideoType();
        }
        return 0;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public int getVideoWidth() {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getVideoWidth();
        }
        return 0;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public boolean isLooping() {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.isLooping();
        }
        return false;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public boolean isMute() {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.isMute();
        }
        return false;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public boolean isOSPlayer() {
        return this.f22884a instanceof OSPlayerClient;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public boolean isPlaying() {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.isPlaying();
        }
        return false;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void pause() {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.pause();
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void prepare() {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.prepare();
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void prepareAsync() {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.prepareAsync();
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void release() {
        TTVideoEngineLog.i("MediaPlayerWrapper", "release");
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.release();
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void releaseAsync() {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.releaseAsync();
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void reset() {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.reset();
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void seekTo(int i6) {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.seekTo(i6);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setCacheFile(String str, int i6) {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setCacheFile(str, i6);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setDataSource(context, uri, map);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setDisplay(surfaceHolder);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setIntOption(int i6, int i7) {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setIntOption(i6, i7);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setIsMute(boolean z5) {
        if (this.f22884a == null) {
            return;
        }
        if (!isOSPlayer()) {
            this.f22884a.setIsMute(z5);
            return;
        }
        float f6 = z5 ? 0.0f : 1.0f;
        try {
            this.f22884a.setVolume(f6, f6);
        } catch (Exception unused) {
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public long setLongOption(int i6, long j6) {
        return -1L;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setLooping(boolean z5) {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setLooping(z5);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnBufferingUpdateListener(onBufferingUpdateListener);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnCompletionListener(onCompletionListener);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnErrorListener(onErrorListener);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnInfoListener(onInfoListener);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setOnLogListener(MediaPlayer.OnLogListener onLogListener) {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnLogListener(onLogListener);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnPreparedListener(onPreparedListener);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setOnSARChangedListener(MediaPlayer.onSARChangedListener onsarchangedlistener) {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnSARChangedListener(onsarchangedlistener);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnSeekCompleteListener(onSeekCompleteListener);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setOnVideoSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setPanoVideoControlModel(int i6) {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setPanoVideoControlModel(i6);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setScreenOnWhilePlaying(boolean z5) {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setScreenOnWhilePlaying(z5);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setStringOption(int i6, String str) {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setStringOption(i6, str);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setSurface(Surface surface) {
        MediaPlayerClient mediaPlayerClient;
        if ((surface == null || surface.isValid()) && (mediaPlayerClient = this.f22884a) != null) {
            mediaPlayerClient.setSurface(surface);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setVolume(float f6, float f7) {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setVolume(f6, f7);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setWakeMode(Context context, int i6) {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setWakeMode(context, i6);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void start() {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.start();
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void stop() {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.stop();
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setDataSource(IMediaDataSource iMediaDataSource) {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setDataSource(iMediaDataSource);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor, long j6, long j7) {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setDataSource(fileDescriptor, j6, j7);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setDataSource(String str) {
        MediaPlayerClient mediaPlayerClient = this.f22884a;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setDataSource(str);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void deselectTrack(int i6) {
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void prevClose() {
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void selectTrack(int i6) {
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setMediaTransport(MediaTransport mediaTransport) {
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setOnExternInfoListener(MediaPlayer.OnExternInfoListener onExternInfoListener) {
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setPlaybackParams(PlaybackParams playbackParams) {
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void takeScreenshot(MediaPlayer.OnScreenshotListener onScreenshotListener) {
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public float getFloatOption(int i6, float f6) {
        return f6;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public long getLongOption(int i6, long j6) {
        return j6;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void rotateCamera(float f6, float f7) {
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void switchStream(int i6, int i7) {
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void mouseEvent(int i6, int i7, int i8) {
    }
}
