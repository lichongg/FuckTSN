package com.kwad.components.core.video;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import com.stub.StubApp;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    private static boolean ZG;
    private static final AtomicInteger ZH = new AtomicInteger(0);
    private final String TAG;
    private volatile int ZI;
    private com.kwad.sdk.core.video.a.c ZJ;
    private int ZK;
    private long ZL;
    private Runnable ZM;
    private com.kwad.sdk.contentalliance.a.a.b ZN;
    private int ZO;
    private List<c.d> ZP;
    private final AtomicBoolean ZQ;
    private boolean ZR;
    private boolean ZS;
    private final int ZU;
    private boolean ZV;
    private volatile List<l> ZW;
    private volatile List<com.kwad.components.core.video.a.c> ZX;
    private volatile List<c.e> ZY;
    private final c.f ZZ;
    private int Zo;
    private int Zp;
    private c.e aaa;
    private c.i aab;
    private c.b aac;
    private c.InterfaceC0691c aad;
    private c.d aae;
    private c.a aaf;
    private Handler iK;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private DetailVideoView mDetailVideoView;
    private float mSpeed;
    private long mStartTime;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        @WorkerThread
        void onReleaseSuccess();
    }

    public b(@Nullable DetailVideoView detailVideoView) {
        this(detailVideoView, 0);
    }

    public final void prepareAsync() {
        aS(false);
    }

    public final void release() {
        a((a) null);
    }

    public final void releaseAsync() {
        a((a) null, true);
    }

    public final void setTKPlayer() {
        this.ZV = true;
    }

    public final void start() {
        try {
            if (this.ZJ == null) {
                return;
            }
            com.kwad.sdk.core.d.c.i(this.TAG, "start state: " + getStateString(this.ZI));
            bb(0);
            if (this.ZI == 0) {
                com.kwad.sdk.core.d.c.i(this.TAG, "start still not prepared well forcePrepare");
                aS(true);
                return;
            }
            if (this.ZI != 2 && this.ZI != 9) {
                if (this.ZI == 3) {
                    this.ZJ.start();
                    return;
                } else {
                    if (this.ZI == 5) {
                        resume();
                        return;
                    }
                    return;
                }
            }
            this.mStartTime = System.currentTimeMillis();
            if (this.ZL != 0) {
                this.ZJ.seekTo((int) r5);
            }
            this.ZJ.start();
            com.kwad.sdk.core.video.a.a.a.eE("videoStartPlay");
            com.kwad.sdk.core.d.c.i(this.TAG, "start:" + getStateString(this.ZI) + "->STATE_STARTED");
            com.kwad.sdk.contentalliance.a.a.b bVar = this.ZN;
            if (bVar != null && bVar.videoPlayerStatus != null) {
                if (this.ZI == 2) {
                    if (this.ZN.videoPlayerStatus.mVideoPlayerType == 0) {
                        setPlayType(1);
                    } else {
                        setPlayType(3);
                    }
                } else if (this.ZI == 9) {
                    setPlayType(3);
                }
            }
            this.ZI = 3;
            onPlayStateChanged(this.ZI);
            tD();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private b(@Nullable DetailVideoView detailVideoView, int i6) {
        this.ZI = 0;
        this.iK = new Handler(Looper.getMainLooper());
        this.mStartTime = 0L;
        this.ZO = 0;
        this.ZP = new CopyOnWriteArrayList();
        this.ZQ = new AtomicBoolean(false);
        this.ZR = false;
        this.ZS = false;
        this.ZV = false;
        this.mSpeed = 1.0f;
        this.ZW = new CopyOnWriteArrayList();
        this.ZX = new CopyOnWriteArrayList();
        this.ZY = new CopyOnWriteArrayList();
        this.ZZ = new c.f() { // from class: com.kwad.components.core.video.b.1
            @Override // com.kwad.sdk.core.video.a.c.f
            public final void tG() {
                b.this.ZI = 1;
                b bVar = b.this;
                bVar.onPlayStateChanged(bVar.ZI);
            }
        };
        this.aaa = new c.e() { // from class: com.kwad.components.core.video.b.4
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                try {
                    com.kwad.sdk.core.d.c.i(b.this.TAG, "onPrepared:" + b.getStateString(b.this.ZI) + "->STATE_PREPARED");
                    b.this.ZI = 2;
                    b bVar = b.this;
                    bVar.onPlayStateChanged(bVar.ZI);
                    Iterator it = b.this.ZY.iterator();
                    while (it.hasNext()) {
                        ((c.e) it.next()).a(b.this.ZJ);
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        };
        this.aab = new c.i() { // from class: com.kwad.components.core.video.b.5
            @Override // com.kwad.sdk.core.video.a.c.i
            public final void l(int i7, int i8) {
                if (b.this.mDetailVideoView != null) {
                    b.this.mDetailVideoView.adaptVideoSize(i7, i8);
                }
                com.kwad.sdk.core.d.c.i(b.this.TAG, "onVideoSizeChanged ——> width：" + i7 + "， height：" + i8);
            }
        };
        this.aac = new c.b() { // from class: com.kwad.components.core.video.b.6
            @Override // com.kwad.sdk.core.video.a.c.b
            public final void qK() {
                b.this.ZI = 9;
                b bVar = b.this;
                bVar.onPlayStateChanged(bVar.ZI);
                com.kwad.sdk.core.video.a.a.a.eE("videoFinishPlay");
            }
        };
        this.aad = new c.InterfaceC0691c() { // from class: com.kwad.components.core.video.b.7
            @Override // com.kwad.sdk.core.video.a.c.InterfaceC0691c
            public final boolean m(int i7, int i8) {
                if (i7 == -38) {
                    return true;
                }
                b.this.ZI = -1;
                b.this.Zo = i7;
                b.this.Zp = i8;
                b bVar = b.this;
                bVar.onPlayStateChanged(bVar.ZI);
                com.kwad.sdk.core.d.c.i(b.this.TAG, "onError ——> STATE_ERROR ———— what：" + i7 + ", extra: " + i8);
                return true;
            }
        };
        this.aae = new c.d() { // from class: com.kwad.components.core.video.b.8
            @Override // com.kwad.sdk.core.video.a.c.d
            public final boolean n(int i7, int i8) {
                if (i7 == 3) {
                    b.this.ZI = 4;
                    b bVar = b.this;
                    bVar.onPlayStateChanged(bVar.ZI);
                    com.kwad.sdk.core.d.c.i(b.this.TAG, "onInfo:" + b.getStateString(b.this.ZI) + "->STATE_PLAYING, time: " + (System.currentTimeMillis() - b.this.mStartTime));
                } else if (i7 == 701) {
                    if (b.this.ZI == 5 || b.this.ZI == 7) {
                        b.this.ZI = 7;
                        com.kwad.sdk.core.d.c.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED");
                    } else {
                        b.this.ZI = 6;
                        com.kwad.sdk.core.d.c.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING");
                    }
                    b bVar2 = b.this;
                    bVar2.onPlayStateChanged(bVar2.ZI);
                } else if (i7 == 702) {
                    if (b.this.ZI == 6) {
                        b.this.ZI = 4;
                        b bVar3 = b.this;
                        bVar3.onPlayStateChanged(bVar3.ZI);
                        com.kwad.sdk.core.d.c.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                    }
                    if (b.this.ZI == 7) {
                        b.this.ZI = 5;
                        b bVar4 = b.this;
                        bVar4.onPlayStateChanged(bVar4.ZI);
                        com.kwad.sdk.core.d.c.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED");
                    }
                } else if (i7 != 10001) {
                    if (i7 == 801) {
                        com.kwad.sdk.core.d.c.i(b.this.TAG, "视频不能seekTo，为直播视频");
                    } else {
                        com.kwad.sdk.core.d.c.i(b.this.TAG, "onInfo ——> what：" + i7);
                    }
                }
                b bVar5 = b.this;
                bVar5.a(bVar5.ZJ, i7, i8);
                return true;
            }
        };
        this.aaf = new c.a() { // from class: com.kwad.components.core.video.b.9
            @Override // com.kwad.sdk.core.video.a.c.a
            public final void aK(int i7) {
                b.this.ZK = i7;
            }
        };
        this.mDetailVideoView = detailVideoView;
        if (detailVideoView != null) {
            this.mContext = StubApp.getOrigApplicationContext(detailVideoView.getContext().getApplicationContext());
        }
        this.ZU = 0;
        String str = "DetailMediaPlayerImpl[0]";
        this.TAG = str;
        com.kwad.sdk.core.d.c.i(str, "create DetailMediaPlayerImpl");
    }

    private void aS(final boolean z5) {
        if (this.ZJ == null) {
            return;
        }
        com.kwad.sdk.core.d.c.i(this.TAG, "start prepareAsync");
        if (this.ZR) {
            if (this.ZQ.compareAndSet(false, true)) {
                com.kwad.sdk.utils.h.execute(new bg() { // from class: com.kwad.components.core.video.b.10
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.i(b.this.TAG, "prepareAsync now:" + b.getStateString(b.this.ZI));
                        if (b.this.ZJ == null) {
                            return;
                        }
                        try {
                            synchronized (b.this.ZJ) {
                                b.this.aT(z5);
                            }
                        } finally {
                            try {
                            } finally {
                            }
                        }
                        try {
                            synchronized (b.this.ZQ) {
                                b.this.ZQ.notifyAll();
                            }
                        } catch (Exception e6) {
                            com.kwad.sdk.core.d.c.printStackTrace(e6);
                        }
                    }
                });
                return;
            }
            return;
        }
        try {
            aT(z5);
        } catch (Throwable th) {
            if (getMediaPlayerType() != 2) {
                int i6 = this.ZO;
                this.ZO = i6 + 1;
                if (i6 <= 4) {
                    tC();
                }
            }
            com.kwad.sdk.core.d.c.i(this.TAG, "prepareAsync Exception:" + getStateString(this.ZI));
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aT(boolean z5) {
        b(this.ZN);
        boolean tW = z5 ? this.ZJ.tW() : this.ZJ.prepareAsync();
        com.kwad.sdk.core.d.c.i(this.TAG, "prepareAsync forcePrepare: " + z5 + ", result: " + tW);
    }

    private void bb(int i6) {
        for (com.kwad.components.core.video.a.c cVar : this.ZX) {
            if (i6 == 0) {
                cVar.onStart();
            } else if (i6 == 1) {
                cVar.onReset();
            } else if (i6 == 2) {
                try {
                    cVar.onRelease();
                } catch (Exception e6) {
                    com.kwad.sdk.core.d.c.printStackTrace(e6);
                }
            }
        }
    }

    private void reset() {
        com.kwad.sdk.core.d.c.i(this.TAG, "reset:" + getStateString(this.ZI) + "->STATE_IDLE");
        bb(1);
        this.ZJ.reset();
        this.ZI = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeepScreenOn(boolean z5) {
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            detailVideoView.setKeepScreenOn(z5);
        }
    }

    private void setPlayType(int i6) {
        VideoPlayerStatus videoPlayerStatus;
        com.kwad.sdk.contentalliance.a.a.b bVar = this.ZN;
        if (bVar == null || (videoPlayerStatus = bVar.videoPlayerStatus) == null) {
            return;
        }
        videoPlayerStatus.mVideoPlayerType = i6;
    }

    private void tA() {
        this.ZJ.a(this.ZZ);
        this.ZJ.b(this.aaa);
        this.ZJ.a(this.aab);
        this.ZJ.a(this.aac);
        this.ZJ.a(this.aad);
        this.ZJ.c(this.aae);
        this.ZJ.a(this.aaf);
    }

    private void tB() {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar == null) {
            return;
        }
        cVar.a((c.InterfaceC0691c) null);
        this.ZJ.a((c.b) null);
        this.ZJ.b((c.e) null);
        this.ZJ.a((c.i) null);
        this.ZJ.c(null);
        this.ZJ.a((c.g) null);
        this.ZJ.a((c.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tE() {
        Runnable runnable = this.ZM;
        if (runnable != null) {
            this.iK.removeCallbacks(runnable);
            this.ZM = null;
        }
    }

    private boolean tF() {
        if (this.ZS && ((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aBS)).booleanValue()) {
            return true;
        }
        return ((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aBS)).booleanValue() && ((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aBT)).booleanValue();
    }

    public final void clear() {
        this.ZW.clear();
        this.ZX.clear();
    }

    public final void complete() {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar != null) {
            cVar.pause();
            this.ZJ.seekTo(0L);
        }
        this.ZI = 9;
        onPlayStateChanged(this.ZI);
        com.kwad.sdk.core.video.a.a.a.eE("videoFinishPlay");
    }

    public final boolean getAlphaVideoValid() {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar != null) {
            return cVar instanceof g;
        }
        return false;
    }

    public final int getBufferPercentage() {
        return this.ZK;
    }

    public final String getCurrentPlayingUrl() {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        return cVar == null ? "" : cVar.getCurrentPlayingUrl();
    }

    public final long getCurrentPosition() {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar != null) {
            return cVar.getCurrentPosition();
        }
        return 0L;
    }

    public final long getDuration() {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar != null) {
            return cVar.getDuration();
        }
        return 0L;
    }

    public final int getMediaPlayerType() {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar != null) {
            return cVar.getMediaPlayerType();
        }
        return 0;
    }

    public final long getPlayDuration() {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar != null) {
            return cVar.getCurrentPosition();
        }
        return 0L;
    }

    public final int getVideoHeight() {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar != null) {
            return cVar.getVideoHeight();
        }
        return 0;
    }

    public final int getVideoWidth() {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar != null) {
            return cVar.getVideoWidth();
        }
        return 0;
    }

    public final boolean isPlaying() {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar != null) {
            return cVar.isPlaying();
        }
        return false;
    }

    @Deprecated
    public final boolean isPrepared() {
        return this.ZI == 2 || this.ZI == 3 || this.ZI == 5 || this.ZI == 8 || this.ZI == 9;
    }

    @Deprecated
    public final boolean isPreparing() {
        return this.ZI == 1;
    }

    public final void onPlayStateChanged(final int i6) {
        if (this.ZW == null) {
            return;
        }
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.video.b.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                for (l lVar : b.this.ZW) {
                    switch (i6) {
                        case -1:
                            b.this.setKeepScreenOn(false);
                            b.this.tE();
                            lVar.onMediaPlayError(b.this.Zo, b.this.Zp);
                            break;
                        case 1:
                            lVar.onMediaPreparing();
                            break;
                        case 2:
                            lVar.onMediaPrepared();
                            break;
                        case 3:
                            b.this.setKeepScreenOn(true);
                            lVar.onMediaPlayStart();
                            break;
                        case 4:
                            b.this.setKeepScreenOn(true);
                            lVar.onMediaPlaying();
                            break;
                        case 5:
                            b.this.setKeepScreenOn(false);
                            lVar.onMediaPlayPaused();
                            break;
                        case 6:
                            lVar.onVideoPlayBufferingPlaying();
                            break;
                        case 7:
                            lVar.onVideoPlayBufferingPaused();
                            break;
                        case 9:
                            if (b.this.ZJ != null && !b.this.ZJ.isLooping()) {
                                b.this.setKeepScreenOn(false);
                                b.this.tE();
                            }
                            lVar.onMediaPlayCompleted();
                            break;
                    }
                }
            }
        });
    }

    public final boolean pause() {
        boolean z5;
        com.kwad.sdk.core.d.c.i(this.TAG, "pause mCurrentState: " + getStateString(this.ZI));
        if (this.ZI == 4) {
            this.ZJ.pause();
            com.kwad.sdk.core.d.c.i(this.TAG, "pause STATE_PLAYING->STATE_PAUSED");
            this.ZI = 5;
            onPlayStateChanged(this.ZI);
            com.kwad.sdk.core.video.a.a.a.eE("videoPausePlay");
            z5 = true;
        } else {
            z5 = false;
        }
        if (this.ZI == 6) {
            this.ZJ.pause();
            com.kwad.sdk.core.d.c.i(this.TAG, "pause STATE_BUFFERING_PLAYING->STATE_PAUSED");
            this.ZI = 7;
            onPlayStateChanged(this.ZI);
            z5 = true;
        }
        if (this.ZI == 3) {
            this.ZJ.pause();
            com.kwad.sdk.core.d.c.i(this.TAG, "pause STATE_STARTED->STATE_PAUSED");
            this.ZI = 5;
            onPlayStateChanged(this.ZI);
            com.kwad.sdk.core.video.a.a.a.eE("videoPausePlay");
            z5 = true;
        }
        if (this.ZI != 9 || !this.ZJ.isLooping()) {
            return z5;
        }
        this.ZJ.pause();
        com.kwad.sdk.core.d.c.i(this.TAG, "pause " + getStateString(this.ZI) + "->STATE_PAUSED");
        this.ZI = 5;
        onPlayStateChanged(this.ZI);
        return true;
    }

    public final void restart() {
        if (this.ZJ != null && this.ZI == 9) {
            start();
        }
        setPlayType(3);
    }

    public final void resume() {
        try {
            if (this.ZJ == null) {
                com.kwad.sdk.core.d.c.e(this.TAG, "resume but mMediaPlayer is null");
                return;
            }
            com.kwad.sdk.core.d.c.i(this.TAG, "resume state: " + getStateString(this.ZI));
            if (this.ZI != 2 && this.ZI != 3 && this.ZI != 0) {
                if (this.ZI == 5) {
                    this.ZJ.start();
                    com.kwad.sdk.core.d.c.i(this.TAG, "resume:" + getStateString(this.ZI) + "->STATE_PLAYING");
                    this.ZI = 4;
                    onPlayStateChanged(this.ZI);
                    setPlayType(2);
                    com.kwad.sdk.core.video.a.a.a.eE("videoResumePlay");
                    return;
                }
                if (this.ZI == 7) {
                    this.ZJ.start();
                    com.kwad.sdk.core.d.c.i(this.TAG, "resume:" + getStateString(this.ZI) + "->STATE_BUFFERING_PLAYING");
                    this.ZI = 6;
                    onPlayStateChanged(this.ZI);
                    return;
                }
                if (this.ZI == 9) {
                    start();
                    return;
                }
                if (this.ZI != 1) {
                    com.kwad.sdk.core.d.c.w(this.TAG, "resume: " + getStateString(this.ZI) + " 此时不能调用resume()方法.");
                    return;
                }
                return;
            }
            com.kwad.sdk.core.d.c.i(this.TAG, "resume:" + getStateString(this.ZI) + "->start()");
            start();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void seekTo(long j6) {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar != null) {
            cVar.seekTo(j6);
        }
    }

    public final void setAudioEnabled(boolean z5) {
        if (z5) {
            setVolume(1.0f, 1.0f);
        } else {
            setVolume(0.0f, 0.0f);
        }
    }

    public final void setIsAlphaVideoPlayer(boolean z5) {
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            detailVideoView.setIsAlphaVideoView(z5);
        }
        this.ZS = z5;
    }

    public final void setRadius(float f6, float f7, float f8, float f9) {
        this.mDetailVideoView.setRadius(f6, f7, f8, f9);
    }

    public final void setSpeed(float f6) {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar == null) {
            return;
        }
        if (f6 > 0.0f) {
            this.mSpeed = f6;
        }
        cVar.setSpeed(f6);
    }

    public final void setSurface(Surface surface) {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar != null) {
            cVar.setSurface(surface);
        }
    }

    public final void setVolume(float f6, float f7) {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar == null) {
            return;
        }
        try {
            cVar.setVolume(f6, f7);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    public final void stopAndPrepareAsync() {
        com.kwad.sdk.core.d.c.i(this.TAG, "stopAndPrepareAsync state: " + getStateString(this.ZI));
        if (this.ZI == 1 || this.ZI == 2) {
            return;
        }
        if (this.ZI == 3 || this.ZI == 4 || this.ZI == 5 || this.ZI == 6 || this.ZI == 7 || this.ZI == 8 || this.ZI == 9) {
            try {
                this.ZJ.stop();
                this.ZI = 8;
                onPlayStateChanged(this.ZI);
                prepareAsync();
                return;
            } catch (Exception unused) {
            }
        }
        release();
    }

    public final void tC() {
        if (this.ZJ == null) {
            com.kwad.sdk.core.d.c.w("resetAndPlay", "mMediaPlayer is null");
            return;
        }
        if (this.ZI == 2 || this.ZI == 3 || this.ZI == 4 || this.ZI == 5) {
            com.kwad.sdk.core.d.c.w("resetAndPlay", "can not resetAndPlay in state:");
            return;
        }
        reset();
        tB();
        tA();
        prepareAsync();
    }

    public final com.kwad.sdk.core.video.a.c tz() {
        return this.ZJ;
    }

    public static String getStateString(int i6) {
        switch (i6) {
            case -1:
                return "STATE_ERROR";
            case 0:
                return "STATE_IDLE";
            case 1:
                return "STATE_PREPARING";
            case 2:
                return "STATE_PREPARED";
            case 3:
                return "STATE_STARTED";
            case 4:
                return "STATE_PLAYING";
            case 5:
                return "STATE_PAUSED";
            case 6:
                return "STATE_BUFFERING_PLAYING";
            case 7:
                return "STATE_BUFFERING_PAUSED";
            case 8:
                return "PLAYER_STATE_STOPPED";
            case 9:
                return "STATE_COMPLETED";
            default:
                return "STATE_UNKNOWN";
        }
    }

    private void tD() {
        tE();
        if (this.ZM == null) {
            this.ZM = new bg() { // from class: com.kwad.components.core.video.b.3
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    b.this.tx();
                    if (b.this.ZM != null) {
                        b.this.iK.postDelayed(b.this.ZM, (long) (500.0f / b.this.mSpeed));
                    }
                }
            };
        }
        this.iK.post(this.ZM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tx() {
        long currentPosition = getCurrentPosition();
        long duration = getDuration();
        if (this.ZW != null) {
            Iterator<l> it = this.ZW.iterator();
            while (it.hasNext()) {
                it.next().onMediaPlayProgress(duration, currentPosition);
            }
        }
    }

    public final void c(l lVar) {
        this.ZW.add(lVar);
    }

    public final void d(l lVar) {
        this.ZW.remove(lVar);
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar, @NonNull DetailVideoView detailVideoView) {
        a(bVar, true, false, detailVideoView);
    }

    public final void b(c.d dVar) {
        if (dVar == null) {
            return;
        }
        this.ZP.remove(dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(@androidx.annotation.NonNull com.kwad.sdk.contentalliance.a.a.b r6, boolean r7, boolean r8, @androidx.annotation.NonNull com.kwad.components.core.video.DetailVideoView r9) {
        /*
            r5 = this;
            java.lang.String r0 = r5.TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "initMediaPlayer enablePreLoad:"
            r1.<init>(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            com.kwad.sdk.core.d.c.i(r0, r1)
            if (r6 == 0) goto L8a
            if (r9 != 0) goto L19
            goto L8a
        L19:
            com.kwad.sdk.core.config.e.Bi()
            boolean r0 = r5.tF()
            r1 = 0
            if (r0 == 0) goto L42
            com.kwad.components.core.video.g r0 = new com.kwad.components.core.video.g     // Catch: java.lang.Throwable -> L3a
            com.kwad.sdk.core.response.model.AdTemplate r2 = r5.mAdTemplate     // Catch: java.lang.Throwable -> L3a
            r0.<init>(r6, r2)     // Catch: java.lang.Throwable -> L3a
            boolean r2 = com.kwad.components.core.video.g.isWaynePlayerReady()     // Catch: java.lang.Throwable -> L3a
            if (r2 == 0) goto L42
            java.lang.String r1 = r5.TAG     // Catch: java.lang.Throwable -> L38
            java.lang.String r2 = "constructPlayer KwaiWaynePlayer"
            com.kwad.sdk.core.d.c.i(r1, r2)     // Catch: java.lang.Throwable -> L38
            goto L41
        L38:
            r1 = move-exception
            goto L3e
        L3a:
            r0 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L3e:
            com.kwad.sdk.service.ServiceProvider.reportSdkCaughtException(r1)
        L41:
            r1 = r0
        L42:
            if (r1 != 0) goto L54
            android.content.Context r0 = r5.mContext
            boolean r1 = com.kwad.sdk.core.config.e.Bi()
            boolean r2 = com.kwad.sdk.core.config.e.Bj()
            int r3 = r5.ZU
            com.kwad.sdk.core.video.a.c r1 = com.kwad.sdk.core.video.a.e.a(r0, r7, r1, r2, r3)
        L54:
            if (r1 == 0) goto L83
            com.kwad.components.core.video.DetailVideoView r7 = r5.mDetailVideoView     // Catch: java.lang.Throwable -> L62
            if (r7 == 0) goto L64
            int r0 = r1.getMediaPlayerType()     // Catch: java.lang.Throwable -> L62
            r7.bc(r0)     // Catch: java.lang.Throwable -> L62
            goto L64
        L62:
            r7 = move-exception
            goto L80
        L64:
            java.lang.String r7 = r5.TAG     // Catch: java.lang.Throwable -> L62
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L62
            java.lang.String r2 = "initMediaPlayer "
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L62
            java.lang.Class r2 = r1.getClass()     // Catch: java.lang.Throwable -> L62
            java.lang.String r2 = r2.getName()     // Catch: java.lang.Throwable -> L62
            r0.append(r2)     // Catch: java.lang.Throwable -> L62
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L62
            com.kwad.sdk.core.d.c.i(r7, r0)     // Catch: java.lang.Throwable -> L62
            goto L83
        L80:
            com.kwad.sdk.core.d.c.printStackTraceOnly(r7)
        L83:
            r7 = 0
            r1.setLooping(r7)
            r5.a(r6, r8, r9, r1)
        L8a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.video.b.a(com.kwad.sdk.contentalliance.a.a.b, boolean, boolean, com.kwad.components.core.video.DetailVideoView):void");
    }

    public final void b(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar) {
        try {
            if (!TextUtils.isEmpty(bVar.videoUrl)) {
                com.kwad.sdk.core.d.c.d(this.TAG, "videoUrl=" + bVar.videoUrl);
                this.ZJ.b(bVar);
                return;
            }
            com.kwad.sdk.core.d.c.e(this.TAG, "videoUrl is null");
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
        }
    }

    private void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar, boolean z5, @NonNull DetailVideoView detailVideoView, @NonNull com.kwad.sdk.core.video.a.c cVar) {
        com.kwad.sdk.core.d.c.i(this.TAG, "initMediaPlayer " + this.ZJ);
        if (bVar == null || detailVideoView == null || cVar == null) {
            return;
        }
        if (this.mContext == null) {
            this.mContext = StubApp.getOrigApplicationContext(detailVideoView.getContext().getApplicationContext());
        }
        this.ZR = z5;
        this.ZN = bVar;
        com.kwad.components.core.video.a.a a6 = com.kwad.components.core.video.a.d.a(bVar.adTemplate, this.mAdTemplate, bVar.videoUrl, cVar.getMediaPlayerType(), this.ZV);
        c(a6);
        a(a6);
        DetailVideoView detailVideoView2 = this.mDetailVideoView;
        if (detailVideoView2 != detailVideoView) {
            com.kwad.sdk.core.d.c.i(this.TAG, "initMediaPlayer videoView changed");
            if (detailVideoView2 != null) {
                detailVideoView2.setMediaPlayer(null);
                detailVideoView.setKeepScreenOn(detailVideoView2.getKeepScreenOn());
                detailVideoView2.setKeepScreenOn(false);
            }
            this.mDetailVideoView = detailVideoView;
        }
        detailVideoView.setMediaPlayer(this);
        if (this.ZJ != cVar) {
            com.kwad.sdk.core.d.c.i(this.TAG, "initMediaPlayer mediaPlayer changed");
            com.kwad.sdk.core.video.a.c cVar2 = this.ZJ;
            if (cVar2 != null) {
                cVar.setLooping(cVar2.isLooping());
                tB();
                this.ZJ.release();
            }
            this.ZJ = cVar;
            reset();
            tA();
            cVar.setAudioStreamType(3);
        } else {
            com.kwad.sdk.core.d.c.i(this.TAG, "initMediaPlayer mediaPlayer not changed");
            reset();
            tB();
            tA();
        }
        this.ZJ.setSurface(detailVideoView.aap);
    }

    public b(@Nullable DetailVideoView detailVideoView, @NonNull AdTemplate adTemplate) {
        this(detailVideoView);
        this.mAdTemplate = adTemplate;
    }

    public final void start(long j6) {
        this.ZL = j6;
        start();
    }

    public final void a(c.e eVar) {
        this.ZY.add(eVar);
    }

    public final void a(c.d dVar) {
        if (dVar == null) {
            return;
        }
        this.ZP.add(dVar);
    }

    public final void a(com.kwad.sdk.core.video.a.c cVar, int i6, int i7) {
        Iterator<c.d> it = this.ZP.iterator();
        while (it.hasNext()) {
            c.d next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.n(i6, i7);
            }
        }
    }

    public final void a(final a aVar, boolean z5) {
        if (this.ZJ == null) {
            return;
        }
        com.kwad.sdk.core.d.c.i(this.TAG, "release:" + getStateString(this.ZI) + "->STATE_IDLE");
        setKeepScreenOn(false);
        this.iK.removeCallbacksAndMessages(null);
        tE();
        tB();
        this.mDetailVideoView = null;
        final com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar != null) {
            if (z5) {
                com.kwad.sdk.utils.h.execute(new bg() { // from class: com.kwad.components.core.video.b.11
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        b.this.a(cVar, aVar);
                    }
                });
            } else {
                a(cVar, aVar);
            }
            this.ZJ = null;
        }
        this.ZI = 0;
        this.ZO = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.core.video.a.c cVar, a aVar) {
        if (cVar == null) {
            return;
        }
        com.kwad.sdk.core.d.c.i(this.TAG, "releaseMediaPlayer:" + getStateString(this.ZI) + "->STATE_IDLE");
        try {
            bb(2);
            cVar.release();
            if (aVar != null) {
                aVar.onReleaseSuccess();
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    public final void a(a aVar) {
        a(aVar, true);
    }

    private void a(com.kwad.components.core.video.a.c cVar) {
        this.ZX.add(cVar);
    }

    public final void a(com.kwad.sdk.contentalliance.a.a.a aVar) {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar instanceof com.kwad.sdk.core.video.a.d) {
            ((com.kwad.sdk.core.video.a.d) cVar).a(aVar);
        }
    }
}
