package com.kwad.sdk.core.video.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaDataSource;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import com.kwad.sdk.o.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.video.ksvodplayerkit.IKSVodPlayer;
import com.kwai.video.ksvodplayerkit.KSVodConstants;
import com.kwai.video.ksvodplayerkit.KSVodPlayerWrapper;
import com.kwai.video.ksvodplayerkit.KSVodVideoContext;
import com.kwai.video.player.IKwaiMediaPlayer;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d extends com.kwad.sdk.core.video.a.a {
    private static volatile boolean aKq;
    private static final Queue<d> aKr = new ConcurrentLinkedQueue();
    private final String TAG;
    private com.kwad.sdk.contentalliance.a.a.b ZN;
    private MediaDataSource aKm;
    private final KSVodPlayerWrapper aKn;
    private final a aKo;
    private boolean aKp;
    private boolean aKs;
    private final Object aaK;
    private String aaL;
    private boolean aaQ;
    private boolean aaR;
    private int mSarDen;
    private int mSarNum;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements IKSVodPlayer.OnBufferingUpdateListener, IKSVodPlayer.OnErrorListener, IKSVodPlayer.OnEventListener, IKSVodPlayer.OnPreparedListener, IKSVodPlayer.OnVideoSizeChangedListener, IKSVodPlayer.OnVodPlayerReleaseListener {
        final String TAG;
        final WeakReference<d> mWeakMediaPlayer;

        private d JZ() {
            return this.mWeakMediaPlayer.get();
        }

        public final void onEvent(@KSVodConstants.KSVodPlayerEventType int i6, int i7) {
            com.kwad.sdk.core.d.c.i(this.TAG, "onEvent, what: " + i6);
            try {
                d JZ = JZ();
                if (JZ != null) {
                    if (i6 == 10100) {
                        JZ.notifyOnSeekComplete();
                    } else {
                        if (i6 == 10101) {
                            JZ.notifyOnCompletion();
                            return;
                        }
                        if (i6 == 10209) {
                            JZ.JY();
                        }
                        JZ.notifyOnInfo(i6, i7);
                    }
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }

        public final void onPlayerRelease() {
            com.kwad.sdk.core.d.c.i(this.TAG, "onPlayerRelease");
        }

        public final void onPrepared() {
            com.kwad.sdk.core.d.c.i(this.TAG, "onPrepared");
            d JZ = JZ();
            if (JZ != null) {
                JZ.notifyOnPrepared();
            }
        }

        public final void onVideoSizeChanged(int i6, int i7, int i8, int i9) {
            com.kwad.sdk.core.d.c.i(this.TAG, "onVideoSizeChanged width: " + i6 + ", height: " + i7 + ", sarNum:" + i8 + ", sarDen:" + i9);
            d JZ = JZ();
            if (JZ != null) {
                JZ.x(i6, i7);
                JZ.mSarNum = i8;
                JZ.mSarDen = i9;
            }
        }

        a(d dVar, String str) {
            this.mWeakMediaPlayer = new WeakReference<>(dVar);
            this.TAG = str;
        }

        public final void onBufferingUpdate(int i6) {
            d JZ = JZ();
            if (JZ != null) {
                JZ.notifyOnBufferingUpdate(i6);
            }
        }

        public final void onError(int i6, int i7) {
            d JZ = JZ();
            if (JZ != null) {
                d.a(JZ, false);
                JZ.notifyOnError(i6, i7);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getMediaPlayerType() {
        return 2;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void reset() {
        this.aaR = false;
        try {
            IKwaiMediaPlayer kwaiMediaPlayer = this.aKn.getKwaiMediaPlayer();
            if (kwaiMediaPlayer != null) {
                kwaiMediaPlayer.reset();
            }
        } catch (IllegalStateException unused) {
        }
        JW();
        resetListeners();
        tX();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(Context context, Uri uri) {
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

    private void JX() {
        com.kwad.sdk.core.d.c.i(this.TAG, "realPrepare hasCallPrepare: " + this.aaR);
        if (this.aaR) {
            return;
        }
        try {
            this.aaR = true;
            int prepareAsync = this.aKn.prepareAsync();
            JV();
            com.kwad.sdk.core.d.c.i(this.TAG, "realPrepare result: " + prepareAsync);
        } catch (IllegalStateException e6) {
            com.kwad.sdk.core.d.c.e(this.TAG, "realPrepare failed ", e6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JY() {
        Iterator<d> it = aKr.iterator();
        int i6 = 0;
        while (true) {
            if (!it.hasNext()) {
                i6 = 0;
                break;
            } else if (it.next() == this) {
                break;
            } else {
                i6++;
            }
        }
        com.kwad.sdk.core.d.c.i(this.TAG, "preloadNextPlayer next player index: " + i6);
        int i7 = i6 + 1;
        if (i7 < aKr.size()) {
            com.kwad.sdk.core.d.c.i(this.TAG, "----------------preloadNextPlayer prepare next player----------------");
            for (int i8 = 0; i8 < i7; i8++) {
                aKr.poll();
            }
            Queue<d> queue = aKr;
            d poll = queue.poll();
            queue.clear();
            if (poll != null) {
                poll.prepareAsync();
            } else {
                com.kwad.sdk.core.d.c.i(this.TAG, "----------------preloadNextPlayer prepareAsync next player is null----------------");
            }
        }
    }

    private void tX() {
        this.aKn.setOnPreparedListener(this.aKo);
        this.aKn.setBufferingUpdateListener(this.aKo);
        this.aKn.setOnEventListener(this.aKo);
        this.aKn.setVideoSizeChangedListener(this.aKo);
        this.aKn.setOnErrorListener(this.aKo);
    }

    private void tY() {
        this.aKn.setOnPreparedListener((IKSVodPlayer.OnPreparedListener) null);
        this.aKn.setBufferingUpdateListener((IKSVodPlayer.OnBufferingUpdateListener) null);
        this.aKn.setOnEventListener((IKSVodPlayer.OnEventListener) null);
        this.aKn.setVideoSizeChangedListener((IKSVodPlayer.OnVideoSizeChangedListener) null);
        this.aKn.setOnErrorListener((IKSVodPlayer.OnErrorListener) null);
    }

    public final void bu(boolean z5) {
        this.aKs = z5;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getAudioSessionId() {
        return this.aKn.getKwaiMediaPlayer().getAudioSessionId();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getCurrentPlayingUrl() {
        KSVodPlayerWrapper kSVodPlayerWrapper = this.aKn;
        return kSVodPlayerWrapper == null ? "" : kSVodPlayerWrapper.getCurrentPlayUrl();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getCurrentPosition() {
        try {
            return this.aKn.getCurrentPosition();
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
            return this.aKn.getDuration();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoHeight() {
        return this.aKn.getKwaiMediaPlayer().getVideoHeight();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoWidth() {
        return this.aKn.getKwaiMediaPlayer().getVideoWidth();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isLooping() {
        return this.aKp;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isPlaying() {
        try {
            return this.aKn.isPlaying();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void pause() {
        this.aKn.pause();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean prepareAsync() {
        if (!this.aKs) {
            JX();
            return true;
        }
        Queue<d> queue = aKr;
        if (!queue.contains(this)) {
            queue.offer(this);
        }
        int size = queue.size();
        if (size == 1) {
            com.kwad.sdk.core.d.c.i(this.TAG, "prepareAsync first");
            JX();
            return true;
        }
        com.kwad.sdk.core.d.c.i(this.TAG, "prepareAsync pending size: " + size);
        return false;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void release() {
        Queue<d> queue = aKr;
        boolean remove = queue.remove(this);
        com.kwad.sdk.core.d.c.i(this.TAG, "release remote player ret: " + remove + ", player list size: " + queue.size());
        this.aaQ = true;
        this.aKn.releaseAsync(new IKSVodPlayer.OnVodPlayerReleaseListener() { // from class: com.kwad.sdk.core.video.a.d.1
            public final void onPlayerRelease() {
                com.kwad.sdk.core.d.c.i(d.this.TAG, "onPlayerRelease");
            }
        });
        try {
            JW();
            resetListeners();
            tY();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void seekTo(long j6) {
        this.aKn.seekTo((int) j6);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(Context context, Uri uri, Map<String, String> map) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDisplay(SurfaceHolder surfaceHolder) {
        synchronized (this.aaK) {
            try {
                if (!this.aaQ) {
                    this.aKn.setDisplay(surfaceHolder);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setLooping(boolean z5) {
        this.aKp = z5;
        this.aKn.setLooping(z5);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setSpeed(float f6) {
        this.aKn.setSpeed(f6);
    }

    @Override // com.kwad.sdk.core.video.a.c
    @TargetApi(14)
    public final void setSurface(Surface surface) {
        this.aKn.setSurface(surface);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setVolume(float f6, float f7) {
        this.aKn.setVolume(f6, f7);
        com.kwad.sdk.core.video.a.a.h(f6);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void start() {
        com.kwad.sdk.core.d.c.i(this.TAG, "start");
        this.aKn.start();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void stop() {
        this.aKn.stop();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean tW() {
        com.kwad.sdk.core.d.c.i(this.TAG, "forcePrepareAsync");
        JX();
        return true;
    }

    public d(int i6) {
        Object obj = new Object();
        this.aaK = obj;
        this.aaR = false;
        this.aKs = true;
        synchronized (obj) {
            this.aKn = new KSVodPlayerWrapper(m.Ta());
        }
        String str = "KSMediaPlayer[" + i6 + "]";
        this.TAG = str;
        this.aKo = new a(this, str);
        tX();
        setLooping(false);
        com.kwad.sdk.core.d.c.i(str, "create KwaiMediaPlayer");
    }

    static /* synthetic */ boolean a(d dVar, boolean z5) {
        dVar.aaR = false;
        return false;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void b(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar) {
        this.ZN = bVar;
        a(bVar.awz);
        f fVar = (f) ServiceProvider.get(f.class);
        if (!TextUtils.isEmpty(bVar.manifest) && fVar != null && fVar.wn()) {
            setDataSource(bVar.manifest, (Map<String, String>) null);
        } else {
            setDataSource(bVar.videoUrl, (Map<String, String>) null);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(FileDescriptor fileDescriptor) {
    }

    public final void a(com.kwad.sdk.contentalliance.a.a.a aVar) {
        if (this.aKn == null || aVar == null) {
            return;
        }
        KSVodVideoContext kSVodVideoContext = new KSVodVideoContext();
        kSVodVideoContext.mVideoId = String.valueOf(aVar.photoId);
        kSVodVideoContext.mClickTime = aVar.clickTime;
        kSVodVideoContext.mExtra = aVar.Ek();
        this.aKn.updateVideoContext(kSVodVideoContext);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(String str) {
        setDataSource(str, (Map<String, String>) null);
    }

    private void setDataSource(String str, Map<String, String> map) {
        this.aaL = str;
        this.aKn.setDataSource(str, (Map) null);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setAudioStreamType(int i6) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setScreenOnWhilePlaying(boolean z5) {
    }
}
