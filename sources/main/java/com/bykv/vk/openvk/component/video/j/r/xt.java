package com.bykv.vk.openvk.component.video.j.r;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bytedance.component.sdk.annotation.RequiresApi;
import com.bytedance.sdk.component.utils.vl;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt extends com.bykv.vk.openvk.component.video.j.r.j {
    private volatile boolean ae;
    private final j cw;

    /* renamed from: m, reason: collision with root package name */
    private final Object f23035m;

    /* renamed from: r, reason: collision with root package name */
    private com.bykv.vk.openvk.component.video.j.j.j f23036r;
    private Surface up;
    private final MediaPlayer xt;

    private static class j implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {

        /* renamed from: j, reason: collision with root package name */
        private final WeakReference<xt> f23037j;

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i6) {
            try {
                xt xtVar = this.f23037j.get();
                if (xtVar != null) {
                    xtVar.j(i6);
                }
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.m.cw.cw("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onBufferingUpdate error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            try {
                xt xtVar = this.f23037j.get();
                if (xtVar != null) {
                    xtVar.cw();
                }
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.m.cw.cw("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onCompletion error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i6, int i7) {
            try {
                com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO", "onError: ", Integer.valueOf(i6), Integer.valueOf(i7));
                xt xtVar = this.f23037j.get();
                if (xtVar != null) {
                    if (xtVar.j(i6, i7)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.m.cw.cw("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onError error: ", th);
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i6, int i7) {
            try {
                com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO", "onInfo: ");
                xt xtVar = this.f23037j.get();
                if (xtVar != null) {
                    if (xtVar.xt(i6, i7)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.m.cw.cw("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onInfo error: ", th);
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            try {
                xt xtVar = this.f23037j.get();
                if (xtVar != null) {
                    xtVar.xt();
                }
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.m.cw.cw("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onPrepared error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            try {
                xt xtVar = this.f23037j.get();
                if (xtVar != null) {
                    xtVar.r();
                }
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.m.cw.cw("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onSeekComplete error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i6, int i7) {
            try {
                xt xtVar = this.f23037j.get();
                if (xtVar != null) {
                    xtVar.j(i6, i7, 1, 1);
                }
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.m.cw.cw("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onVideoSizeChanged error: ", th);
            }
        }

        public j(xt xtVar) {
            this.f23037j = new WeakReference<>(xtVar);
        }
    }

    private void j(MediaPlayer mediaPlayer) {
        if (Build.VERSION.SDK_INT >= 28) {
            return;
        }
        try {
            Class<?> cls = Class.forName("android.media.MediaTimeProvider");
            Class<?> cls2 = Class.forName("android.media.SubtitleController");
            Class<?> cls3 = Class.forName("android.media.SubtitleController$Anchor");
            Object newInstance = cls2.getConstructor(Context.class, cls, Class.forName("android.media.SubtitleController$Listener")).newInstance(com.bykv.vk.openvk.component.video.api.cw.getContext(), null, null);
            Field declaredField = cls2.getDeclaredField("mHandler");
            declaredField.setAccessible(true);
            try {
                declaredField.set(newInstance, new Handler());
                declaredField.setAccessible(false);
                mediaPlayer.getClass().getMethod("setSubtitleAnchor", cls2, cls3).invoke(mediaPlayer, newInstance, null);
            } catch (Throwable th) {
                try {
                    com.bykv.vk.openvk.component.video.api.m.cw.cw("CSJ_VIDEO", "subtitleInstance error: ", th);
                } finally {
                    declaredField.setAccessible(false);
                }
            }
        } catch (Throwable th2) {
            com.bykv.vk.openvk.component.video.api.m.cw.cw("CSJ_VIDEO", "setSubtitleController error: ", th2);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.j.r.cw
    public void up() throws Throwable {
        this.xt.start();
    }

    private void av() {
        this.xt.setOnPreparedListener(this.cw);
        this.xt.setOnBufferingUpdateListener(this.cw);
        this.xt.setOnCompletionListener(this.cw);
        this.xt.setOnSeekCompleteListener(this.cw);
        this.xt.setOnVideoSizeChangedListener(this.cw);
        this.xt.setOnErrorListener(this.cw);
        this.xt.setOnInfoListener(this.cw);
    }

    private void az() {
        com.bykv.vk.openvk.component.video.j.j.j jVar;
        if (Build.VERSION.SDK_INT < 23 || (jVar = this.f23036r) == null) {
            return;
        }
        try {
            jVar.close();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.m.cw.cw("CSJ_VIDEO", "releaseMediaDataSource error: ", th);
        }
        this.f23036r = null;
    }

    private void i() {
        try {
            Surface surface = this.up;
            if (surface != null) {
                surface.release();
                this.up = null;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bykv.vk.openvk.component.video.j.r.cw
    public void ae() throws Throwable {
        this.xt.pause();
    }

    @Override // com.bykv.vk.openvk.component.video.j.r.cw
    public void cw(boolean z5) throws Throwable {
        this.xt.setLooping(z5);
    }

    @Override // com.bykv.vk.openvk.component.video.j.r.cw
    public long g() {
        try {
            return this.xt.getCurrentPosition();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.m.cw.cw("CSJ_VIDEO", "getCurrentPosition error: ", th);
            return 0L;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.j.r.cw
    public int jy() {
        MediaPlayer mediaPlayer = this.xt;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.bykv.vk.openvk.component.video.j.r.cw
    public void m() throws Throwable {
        this.xt.stop();
    }

    @Override // com.bykv.vk.openvk.component.video.j.r.cw
    public long oq() {
        try {
            return this.xt.getDuration();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.m.cw.cw("CSJ_VIDEO", "getDuration error: ", th);
            return 0L;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.j.r.cw
    public void qv() throws Throwable {
        synchronized (this.f23035m) {
            try {
                if (!this.ae) {
                    this.xt.release();
                    this.ae = true;
                    i();
                    az();
                    j();
                    av();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.j.r.cw
    public void r(boolean z5) throws Throwable {
        MediaPlayer mediaPlayer = this.xt;
        if (mediaPlayer == null) {
            return;
        }
        if (z5) {
            mediaPlayer.setVolume(0.0f, 0.0f);
        } else {
            mediaPlayer.setVolume(1.0f, 1.0f);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.j.r.cw
    public void tl() {
        MediaPlayer mediaPlayer = this.xt;
        if (mediaPlayer != null) {
            mediaPlayer.prepareAsync();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.j.r.cw
    public void up(boolean z5) {
        try {
            MediaPlayer mediaPlayer = this.xt;
            if (mediaPlayer != null) {
                mediaPlayer.setLooping(z5);
            }
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.j.r.cw
    public void vl() throws Throwable {
        try {
            this.xt.reset();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.m.cw.cw("CSJ_VIDEO", "reset error: ", th);
        }
        az();
        j();
        av();
    }

    @Override // com.bykv.vk.openvk.component.video.j.r.cw
    public int ws() {
        MediaPlayer mediaPlayer = this.xt;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.bykv.vk.openvk.component.video.j.r.cw
    public void xt(boolean z5) throws Throwable {
        this.xt.setScreenOnWhilePlaying(z5);
    }

    public xt() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.f23035m = obj;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.xt = mediaPlayer;
        }
        j(mediaPlayer);
        try {
            mediaPlayer.setAudioStreamType(3);
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.m.cw.cw("CSJ_VIDEO", "setAudioStreamType error: ", th);
        }
        this.cw = new j(this);
        av();
    }

    protected void finalize() throws Throwable {
        super.finalize();
        i();
    }

    @Override // com.bykv.vk.openvk.component.video.j.r.cw
    public void j(SurfaceHolder surfaceHolder) throws Throwable {
        synchronized (this.f23035m) {
            try {
                if (!this.ae && surfaceHolder != null && surfaceHolder.getSurface() != null && this.f22998j) {
                    this.xt.setDisplay(surfaceHolder);
                }
            } finally {
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.j.r.cw
    @TargetApi(14)
    public void j(Surface surface) {
        i();
        this.up = surface;
        this.xt.setSurface(surface);
    }

    @Override // com.bykv.vk.openvk.component.video.j.r.cw
    @RequiresApi(api = 23)
    public void j(com.bykv.vk.openvk.component.video.api.xt xtVar) throws Throwable {
        PlaybackParams playbackParams;
        PlaybackParams speed;
        if (Build.VERSION.SDK_INT >= 23) {
            playbackParams = this.xt.getPlaybackParams();
            speed = playbackParams.setSpeed(xtVar.j());
            this.xt.setPlaybackParams(speed);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.j.r.cw
    public void j(String str) throws Throwable {
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (!TextUtils.isEmpty(scheme) && scheme.equalsIgnoreCase(master.flame.danmaku.danmaku.parser.b.f50156c)) {
            this.xt.setDataSource(parse.getPath());
        } else {
            this.xt.setDataSource(str);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.j.r.cw
    public void j(FileDescriptor fileDescriptor) throws Throwable {
        this.xt.setDataSource(fileDescriptor);
    }

    @Override // com.bykv.vk.openvk.component.video.j.r.cw
    @RequiresApi(api = 23)
    public synchronized void j(com.bykv.vk.openvk.component.video.api.cw.r rVar) {
        this.f23036r = com.bykv.vk.openvk.component.video.j.j.j.j(com.bykv.vk.openvk.component.video.api.cw.getContext(), rVar);
        com.bykv.vk.openvk.component.video.j.j.xt.cw.j(rVar);
        this.xt.setDataSource(this.f23036r);
    }

    @Override // com.bykv.vk.openvk.component.video.j.r.cw
    public void j(long j6, int i6) throws Throwable {
        if (Build.VERSION.SDK_INT < 26) {
            this.xt.seekTo((int) j6);
            return;
        }
        if (i6 == 0) {
            this.xt.seekTo((int) j6, 0);
            return;
        }
        if (i6 == 1) {
            this.xt.seekTo((int) j6, 1);
            return;
        }
        if (i6 == 2) {
            this.xt.seekTo((int) j6, 2);
        } else if (i6 == 3) {
            this.xt.seekTo((int) j6, 3);
        } else {
            this.xt.seekTo((int) j6);
        }
    }
}
