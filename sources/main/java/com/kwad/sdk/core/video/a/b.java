package com.kwad.sdk.core.video.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.media.TimedText;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import com.bykv.vk.component.ttvideo.player.h;
import com.kwad.sdk.service.ServiceProvider;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends com.kwad.sdk.core.video.a.a {
    private final MediaPlayer aKk;
    private final a aKl;
    private MediaDataSource aKm;
    private final Object aaK;
    private String aaL;
    private boolean aaQ;
    private boolean aaS;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnTimedTextListener, MediaPlayer.OnVideoSizeChangedListener {
        final WeakReference<b> mWeakMediaPlayer;

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i6) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.notifyOnBufferingUpdate(i6);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public final void onCompletion(MediaPlayer mediaPlayer) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.notifyOnCompletion();
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public final boolean onError(MediaPlayer mediaPlayer, int i6, int i7) {
            b bVar = this.mWeakMediaPlayer.get();
            return bVar != null && bVar.notifyOnError(i6, i7);
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public final boolean onInfo(MediaPlayer mediaPlayer, int i6, int i7) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar == null) {
                return false;
            }
            if (i6 != 3) {
                return bVar.notifyOnInfo(i6, i7);
            }
            if (bVar.aaS) {
                return false;
            }
            b.a(bVar, true);
            return bVar.notifyOnInfo(i6, i7);
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public final void onPrepared(MediaPlayer mediaPlayer) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.notifyOnPrepared();
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public final void onSeekComplete(MediaPlayer mediaPlayer) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.notifyOnSeekComplete();
            }
        }

        @Override // android.media.MediaPlayer.OnTimedTextListener
        public final void onTimedText(MediaPlayer mediaPlayer, TimedText timedText) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.b(timedText);
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i6, int i7) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.x(i6, i7);
            }
        }

        a(b bVar) {
            this.mWeakMediaPlayer = new WeakReference<>(bVar);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getMediaPlayerType() {
        return 1;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void release() {
        try {
            this.aaQ = true;
            this.aKk.release();
            JW();
            resetListeners();
            tY();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(Context context, Uri uri) {
        this.aKk.setDataSource(context, uri);
    }

    private void JW() {
        MediaDataSource mediaDataSource = this.aKm;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e6) {
                e6.printStackTrace();
            }
            this.aKm = null;
        }
    }

    static /* synthetic */ boolean a(b bVar, boolean z5) {
        bVar.aaS = true;
        return true;
    }

    private void tX() {
        this.aKk.setOnPreparedListener(this.aKl);
        this.aKk.setOnBufferingUpdateListener(this.aKl);
        this.aKk.setOnCompletionListener(this.aKl);
        this.aKk.setOnSeekCompleteListener(this.aKl);
        this.aKk.setOnVideoSizeChangedListener(this.aKl);
        this.aKk.setOnErrorListener(this.aKl);
        this.aKk.setOnInfoListener(this.aKl);
        this.aKk.setOnTimedTextListener(this.aKl);
    }

    private void tY() {
        this.aKk.setOnPreparedListener(null);
        this.aKk.setOnBufferingUpdateListener(null);
        this.aKk.setOnCompletionListener(null);
        this.aKk.setOnSeekCompleteListener(null);
        this.aKk.setOnVideoSizeChangedListener(null);
        this.aKk.setOnErrorListener(null);
        this.aKk.setOnInfoListener(null);
        this.aKk.setOnTimedTextListener(null);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void b(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar) {
        if (!bVar.isNoCache) {
            setDataSource(bVar.videoUrl);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "video/mp4");
        hashMap.put("Accept-Ranges", "bytes");
        hashMap.put("Status", "206");
        hashMap.put("Cache-control", "no-cache");
        setDataSource(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext(), Uri.parse(bVar.videoUrl), hashMap);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getAudioSessionId() {
        return this.aKk.getAudioSessionId();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getCurrentPlayingUrl() {
        return "";
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getCurrentPosition() {
        try {
            return this.aKk.getCurrentPosition();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getDataSource() {
        return this.aaL;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getDuration() {
        try {
            return this.aKk.getDuration();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoHeight() {
        return this.aKk.getVideoHeight();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoWidth() {
        return this.aKk.getVideoWidth();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isLooping() {
        return this.aKk.isLooping();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isPlaying() {
        try {
            return this.aKk.isPlaying();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void pause() {
        this.aKk.pause();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean prepareAsync() {
        this.aKk.prepareAsync();
        JV();
        return true;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void reset() {
        try {
            this.aKk.reset();
            this.aaS = false;
        } catch (IllegalStateException unused) {
        }
        JW();
        resetListeners();
        tX();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void seekTo(long j6) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.aKk.seekTo((int) j6, 3);
        } else {
            this.aKk.seekTo((int) j6);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setAudioStreamType(int i6) {
        this.aKk.setAudioStreamType(i6);
    }

    @Override // com.kwad.sdk.core.video.a.c
    @TargetApi(14)
    public final void setDataSource(Context context, Uri uri, Map<String, String> map) {
        this.aKk.setDataSource(context, uri, map);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDisplay(SurfaceHolder surfaceHolder) {
        synchronized (this.aaK) {
            try {
                if (!this.aaQ) {
                    this.aKk.setDisplay(surfaceHolder);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setLooping(boolean z5) {
        this.aKk.setLooping(z5);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setScreenOnWhilePlaying(boolean z5) {
        this.aKk.setScreenOnWhilePlaying(z5);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setSpeed(float f6) {
        PlaybackParams playbackParams;
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                playbackParams = this.aKk.getPlaybackParams();
                if (playbackParams == null) {
                    g.a();
                    playbackParams = h.a();
                }
                playbackParams.setSpeed(f6);
                this.aKk.setPlaybackParams(playbackParams);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    @TargetApi(14)
    public final void setSurface(Surface surface) {
        this.aKk.setSurface(surface);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setVolume(float f6, float f7) {
        this.aKk.setVolume(f6, f7);
        com.kwad.sdk.core.video.a.a.h(f6);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void start() {
        this.aKk.start();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void stop() {
        this.aKk.stop();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean tW() {
        this.aKk.prepareAsync();
        JV();
        return true;
    }

    public b() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.aaK = obj;
        this.aaS = false;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.aKk = mediaPlayer;
        }
        mediaPlayer.setAudioStreamType(3);
        this.aKl = new a(this);
        tX();
        setLooping(false);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(FileDescriptor fileDescriptor) {
        this.aKk.setDataSource(fileDescriptor);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(String str) {
        this.aaL = str;
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (!TextUtils.isEmpty(scheme) && scheme.equalsIgnoreCase(master.flame.danmaku.danmaku.parser.b.f50156c)) {
            this.aKk.setDataSource(parse.getPath());
        } else {
            this.aKk.setDataSource(str);
        }
    }
}
