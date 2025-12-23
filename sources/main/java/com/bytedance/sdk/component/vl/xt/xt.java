package com.bytedance.sdk.component.vl.xt;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bykv.vk.component.ttvideo.SeekCompletionListener;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback;
import com.bykv.vk.component.ttvideo.log.VideoEventEngineUploader;
import com.bykv.vk.component.ttvideo.player.TTPlayerClient;
import com.bykv.vk.component.ttvideo.playerwrapper.MediaPlayerWrapper;
import com.bykv.vk.component.ttvideo.utils.Error;
import com.bykv.vk.openvk.component.video.api.cw;
import com.bykv.vk.openvk.component.video.api.cw.r;
import com.bykv.vk.openvk.component.video.api.j;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.vl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements com.bykv.vk.openvk.component.video.api.j, l.j {

    /* renamed from: j, reason: collision with root package name */
    public static volatile boolean f26934j;

    /* renamed from: f, reason: collision with root package name */
    private SurfaceHolder f26936f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f26938h;
    private int kt;
    private int mi;
    private long oq;
    private SurfaceTexture tj;

    /* renamed from: x, reason: collision with root package name */
    private volatile l f26947x;
    private TTVideoEngine xt;
    private boolean cw = false;

    /* renamed from: r, reason: collision with root package name */
    private boolean f26943r = false;
    private boolean up = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f26941m = false;
    private boolean ae = false;
    private boolean tl = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f26937g = false;
    private long qv = 0;
    private long vl = 0;
    private long jy = 0;
    private int ws = 0;
    private int az = 0;
    private boolean av = false;

    /* renamed from: i, reason: collision with root package name */
    private AtomicBoolean f26939i = new AtomicBoolean(false);

    /* renamed from: w, reason: collision with root package name */
    private AtomicBoolean f26946w = new AtomicBoolean(false);

    /* renamed from: v, reason: collision with root package name */
    private final List<WeakReference<j.InterfaceC0305j>> f26945v = Collections.synchronizedList(new ArrayList());
    private volatile boolean ch = false;

    /* renamed from: s, reason: collision with root package name */
    private volatile int f26944s = 200;

    /* renamed from: a, reason: collision with root package name */
    private long f26935a = 0;

    /* renamed from: l, reason: collision with root package name */
    private Runnable f26940l = new Runnable() { // from class: com.bytedance.sdk.component.vl.xt.xt.1
        @Override // java.lang.Runnable
        public void run() {
            long mi = xt.this.mi();
            if (xt.this.w() > 0) {
                if (xt.this.f26935a != mi) {
                    if (cw.r()) {
                        com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_TTVideo", "run: lastCur = ", Long.valueOf(xt.this.f26935a), "  curPosition=", Long.valueOf(mi));
                    }
                    xt xtVar = xt.this;
                    xtVar.j(mi, xtVar.w());
                }
                xt.this.f26935a = mi;
            }
            if (xt.this.f26941m) {
                xt xtVar2 = xt.this;
                xtVar2.j(xtVar2.w(), xt.this.w());
            } else if (xt.this.f26947x != null) {
                xt.this.f26947x.postDelayed(this, xt.this.f26944s);
            }
        }
    };

    /* renamed from: p, reason: collision with root package name */
    private final ArrayList<Runnable> f26942p = new ArrayList<>();

    private void s() {
        this.cw = false;
        this.f26943r = false;
        this.f26941m = false;
        this.ae = false;
        this.tl = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tj() {
        this.tl = true;
        this.f26943r = true;
        if (this.f26947x != null) {
            this.f26947x.sendEmptyMessage(100);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(float f6) {
    }

    private void ch() {
        this.xt.setVideoEngineSimpleCallback(new VideoEngineSimpleCallback() { // from class: com.bytedance.sdk.component.vl.xt.xt.2
            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onBufferEnd(int i6) {
                if (xt.this.ws == i6) {
                    xt.this.vl += System.currentTimeMillis() - xt.this.jy;
                }
                com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_TTVideo", "onBufferEnd: code =", Integer.valueOf(i6));
                for (WeakReference weakReference : xt.this.f26945v) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((j.InterfaceC0305j) weakReference.get()).j((com.bykv.vk.openvk.component.video.api.j) xt.this, i6);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onBufferStart(int i6, int i7, int i8) {
                xt.this.ws = i6;
                xt.this.az++;
                xt.this.jy = System.currentTimeMillis();
                com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_TTVideo", "onBufferStart: reason =", Integer.valueOf(i6), "  afterFirstFrame =", Integer.valueOf(i7), "  action=", Integer.valueOf(i8));
                for (WeakReference weakReference : xt.this.f26945v) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((j.InterfaceC0305j) weakReference.get()).j(xt.this, i6, i7, i8);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onCompletion(TTVideoEngine tTVideoEngine) {
                com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_TTVideo", "onCompletion: ");
                xt.this.f26941m = true;
                if (xt.this.f26947x != null) {
                    xt.this.f26947x.removeCallbacks(xt.this.f26940l);
                }
                for (WeakReference weakReference : xt.this.f26945v) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((j.InterfaceC0305j) weakReference.get()).j(xt.this);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onError(Error error) {
                com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_TTVideo", "onError: ");
                com.bykv.vk.openvk.component.video.api.cw.xt xtVar = new com.bykv.vk.openvk.component.video.api.cw.xt(error.getCode(), error.getInternalCode());
                for (WeakReference weakReference : xt.this.f26945v) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((j.InterfaceC0305j) weakReference.get()).j(xt.this, xtVar);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onPrepare(TTVideoEngine tTVideoEngine) {
                com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_TTVideo", "onPrepare: ");
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onPrepared(TTVideoEngine tTVideoEngine) {
                com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_TTVideo", "onPrepared: ");
                xt.this.ae = true;
                for (WeakReference weakReference : xt.this.f26945v) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((j.InterfaceC0305j) weakReference.get()).xt(xt.this);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onRenderStart(TTVideoEngine tTVideoEngine) {
                com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_TTVideo", "onRenderStart: ");
                xt.this.qv = System.currentTimeMillis() - xt.this.oq;
                for (WeakReference weakReference : xt.this.f26945v) {
                    if (weakReference != null && weakReference.get() != null) {
                        j.InterfaceC0305j interfaceC0305j = (j.InterfaceC0305j) weakReference.get();
                        xt xtVar = xt.this;
                        interfaceC0305j.j(xtVar, xtVar.qv);
                    }
                }
                xt.this.av = true;
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onUseMDLCacheEnd() {
                com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_TTVideo", "onUseMDLCacheEnd: ");
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onBufferingUpdate(TTVideoEngine tTVideoEngine, int i6) {
                com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_TTVideo", "onBufferingUpdate: percent =", Integer.valueOf(i6));
                for (WeakReference weakReference : xt.this.f26945v) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((j.InterfaceC0305j) weakReference.get()).xt(xt.this, i6);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onLoadStateChanged(TTVideoEngine tTVideoEngine, int i6) {
                com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_TTVideo", "onLoadStateChanged: loadState =", Integer.valueOf(i6));
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onMDLHitCache(String str, long j6) {
                com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_TTVideo", "onMDLHitCache: MDLPlayTaskKey =", str, " hitCacheSize = ", Long.valueOf(j6));
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onPlaybackStateChanged(TTVideoEngine tTVideoEngine, int i6) {
                com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_TTVideo", "onPlaybackStateChanged: playbackState =", Integer.valueOf(i6));
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onRenderSeekComplete(int i6) {
                com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_TTVideo", "onRenderSeekComplete: isSeekInCached = ", Integer.valueOf(i6));
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onRetry(int i6) {
                com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_TTVideo", "onRetry: playType = ", Integer.valueOf(i6));
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onVideoSizeChanged(TTVideoEngine tTVideoEngine, int i6, int i7) {
                com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_TTVideo", "onVideoSizeChanged: width = ", Integer.valueOf(i6), " height = ", Integer.valueOf(i7));
                xt.this.mi = i6;
                xt.this.kt = i7;
                for (WeakReference weakReference : xt.this.f26945v) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((j.InterfaceC0305j) weakReference.get()).j((com.bykv.vk.openvk.component.video.api.j) xt.this, i6, i7);
                    }
                }
            }
        });
    }

    private void f() {
        if (this.f26938h) {
            return;
        }
        this.f26938h = true;
        Iterator it = new ArrayList(this.f26942p).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.f26942p.clear();
        this.f26938h = false;
    }

    public static boolean kt() {
        return f26934j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        ArrayList<Runnable> arrayList = this.f26942p;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        f();
    }

    private void x() {
        ArrayList<Runnable> arrayList = this.f26942p;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.f26942p.clear();
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public SurfaceHolder ae() {
        return this.f26936f;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public long av() {
        if (this.az == 0) {
            return 0L;
        }
        if (this.vl == 0 && this.jy != 0) {
            this.vl = System.currentTimeMillis() - this.jy;
        }
        return this.vl;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public boolean az() {
        return this.up;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public boolean g() {
        return this.f26941m;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public int i() {
        return this.az;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(int i6) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public boolean jy() {
        return this.xt.getPlaybackState() == 1;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public boolean m() {
        return this.av;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public long mi() {
        try {
            return this.xt.getCurrentPlaybackTime();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.m.cw.xt(th.getMessage());
            return 0L;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public boolean oq() {
        return this.tl;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public int qv() {
        com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_TTVideo", "getVideoWidth: ");
        return this.mi;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public SurfaceTexture tl() {
        return this.tj;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void up() {
        x();
        l lVar = this.f26947x;
        if (lVar != null) {
            lVar.removeCallbacksAndMessages(null);
            lVar.sendEmptyMessage(103);
            if (lVar.getLooper() != null) {
                lVar.post(new Runnable() { // from class: com.bytedance.sdk.component.vl.xt.xt.9
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (!xt.this.ch) {
                                com.bytedance.sdk.component.oq.xt.j.j().j(xt.this.f26947x);
                            }
                            xt.this.f26947x = null;
                        } catch (Throwable th) {
                            com.bykv.vk.openvk.component.video.api.m.cw.cw("CSJ_VIDEO_TTVideo", "release error:" + th.getMessage());
                        }
                    }
                });
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public int vl() {
        com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_TTVideo", "getVideoHeight: ");
        return this.kt;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public long w() {
        return this.xt.getDuration();
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public boolean ws() {
        return this.xt.getPlaybackState() == 2;
    }

    public xt(Context context, String str) {
        j(context, "vd_".concat(String.valueOf(str)), (Looper) null);
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void r() {
        com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_TTVideo", "stop: ");
        if (this.f26947x != null) {
            this.f26947x.sendEmptyMessage(105);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void cw() {
        com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_TTVideo", "pause: ");
        l lVar = this.f26947x;
        if (lVar != null) {
            lVar.removeMessages(100);
            lVar.sendEmptyMessage(101);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void xt() {
        com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_TTVideo", "play: ");
        l lVar = this.f26947x;
        if (lVar != null) {
            lVar.postDelayed(this.f26940l, this.f26944s);
            lVar.post(new Runnable() { // from class: com.bytedance.sdk.component.vl.xt.xt.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (xt.this.xt != null) {
                            xt.this.xt.play();
                            for (WeakReference weakReference : xt.this.f26945v) {
                                if (weakReference != null && weakReference.get() != null) {
                                    weakReference.get();
                                }
                            }
                        }
                    } catch (Throwable th) {
                        com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_TTVideo", "play: catch exception:" + th.getMessage());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(long j6, long j7) {
        long j8;
        long j9;
        for (WeakReference<j.InterfaceC0305j> weakReference : this.f26945v) {
            if (weakReference == null || weakReference.get() == null) {
                j8 = j6;
                j9 = j7;
            } else {
                j8 = j6;
                j9 = j7;
                weakReference.get().j(this, j8, j9);
            }
            j6 = j8;
            j7 = j9;
        }
    }

    private void xt(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (!this.up) {
            runnable.run();
        } else {
            j(runnable);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void cw(boolean z5) {
        this.xt.setLooping(z5);
    }

    private void j(Context context, String str, Looper looper) {
        this.xt = j.j(context);
        if (looper != null) {
            this.f26947x = new l(looper, this);
            this.ch = true;
        } else if (this.f26947x == null) {
            this.f26947x = com.bytedance.sdk.component.oq.xt.j.j().j(this, "csj_".concat(String.valueOf(str)));
        }
        ch();
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void xt(boolean z5) {
        this.f26937g = z5;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void xt(int i6) {
        this.f26944s = i6;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(final SurfaceHolder surfaceHolder) {
        com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_TTVideo", "setDisplay:  SurfaceView");
        xt(true);
        this.f26936f = surfaceHolder;
        xt(new Runnable() { // from class: com.bytedance.sdk.component.vl.xt.xt.3
            @Override // java.lang.Runnable
            public void run() {
                if (xt.this.f26947x != null) {
                    xt.this.f26947x.obtainMessage(110, surfaceHolder).sendToTarget();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(final SurfaceTexture surfaceTexture) {
        xt(true);
        this.tj = surfaceTexture;
        xt(new Runnable() { // from class: com.bytedance.sdk.component.vl.xt.xt.4
            @Override // java.lang.Runnable
            public void run() {
                if (xt.this.f26947x != null) {
                    xt.this.f26947x.obtainMessage(111, surfaceTexture).sendToTarget();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(r rVar) {
        this.xt.setDirectUrlUseDataLoader(rVar.av(), rVar.i(), (String) null, rVar.up());
        this.cw = true;
        this.az = 0;
        com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_TTVideo", "TTVideoPlayer setDirectUrlUseDataLoader:  url =", rVar.av(), " isH265=", Boolean.valueOf(rVar.ws()), " presize=", Integer.valueOf(rVar.m()), " path=", rVar.up(), " fileName =", rVar.i());
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j() {
        TTVideoEngine tTVideoEngine = this.xt;
        boolean isMute = tTVideoEngine != null ? tTVideoEngine.isMute() : false;
        this.az = 0;
        this.vl = 0L;
        this.jy = 0L;
        this.f26941m = false;
        j(true, 0L, isMute);
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(boolean z5, long j6, boolean z6) {
        com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_TTVideo", "start: firstSeek:" + j6 + " first:" + z5 + " quiet:" + z6);
        if (this.f26947x != null) {
            this.f26947x.postDelayed(this.f26940l, this.f26944s);
        }
        this.oq = System.currentTimeMillis();
        this.xt.setStartTime((int) j6);
        this.xt.setIsMute(z6);
        if (this.f26946w.get() && this.cw) {
            tj();
        } else {
            com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_TTVideo", "seekTo: ", "Can not exec play, please exec setDataSource && setSurface before seek");
            j(new Runnable() { // from class: com.bytedance.sdk.component.vl.xt.xt.5
                @Override // java.lang.Runnable
                public void run() {
                    xt.this.tj();
                }
            });
        }
        com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_TTVideo", "start:end");
        this.f26939i.set(true);
        if (!this.f26946w.get() || this.f26947x == null) {
            return;
        }
        this.f26947x.post(new Runnable() { // from class: com.bytedance.sdk.component.vl.xt.xt.6
            @Override // java.lang.Runnable
            public void run() {
                xt.this.v();
            }
        });
    }

    private synchronized void j(Runnable runnable) {
        this.f26942p.add(runnable);
    }

    @Override // com.bytedance.sdk.component.utils.l.j
    public void j(Message message) {
        int i6 = message.what;
        try {
            if (i6 == 105) {
                TTVideoEngine tTVideoEngine = this.xt;
                if (tTVideoEngine != null) {
                    tTVideoEngine.stop();
                    return;
                }
                return;
            }
            if (i6 == 110) {
                TTVideoEngine tTVideoEngine2 = this.xt;
                if (tTVideoEngine2 != null) {
                    tTVideoEngine2.setSurfaceHolder((SurfaceHolder) message.obj);
                    this.f26946w.set(true);
                    if (this.f26939i.get()) {
                        v();
                        return;
                    }
                    return;
                }
                return;
            }
            if (i6 != 111) {
                switch (i6) {
                    case 100:
                        TTVideoEngine tTVideoEngine3 = this.xt;
                        if (tTVideoEngine3 != null) {
                            tTVideoEngine3.play();
                            break;
                        }
                        break;
                    case 101:
                        if (this.xt != null && this.f26947x != null) {
                            this.xt.pause();
                            for (WeakReference<j.InterfaceC0305j> weakReference : this.f26945v) {
                                if (weakReference != null && weakReference.get() != null) {
                                    weakReference.get();
                                }
                            }
                            this.f26947x.removeCallbacks(this.f26940l);
                            break;
                        }
                        break;
                    case 102:
                        s();
                        break;
                    case 103:
                        TTVideoEngine tTVideoEngine4 = this.xt;
                        if (tTVideoEngine4 != null) {
                            tTVideoEngine4.release();
                        }
                        this.up = true;
                        for (WeakReference<j.InterfaceC0305j> weakReference2 : this.f26945v) {
                            if (weakReference2 != null && weakReference2.get() != null) {
                                weakReference2.get().cw(this);
                            }
                        }
                        break;
                }
                return;
            }
            if (this.xt != null) {
                SurfaceTexture surfaceTexture = (SurfaceTexture) message.obj;
                com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_TTVideo", "setSurface: TextureView ");
                this.xt.setSurface(new Surface(surfaceTexture));
                this.f26946w.set(true);
                if (this.f26939i.get()) {
                    v();
                }
            }
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(long j6) {
        com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_TTVideo", "seekTo: ");
        if (!this.f26943r) {
            com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_TTVideo", "seekTo: ", "Can not exec seek, please exec setDataSource before seek");
        } else {
            this.xt.seekTo((int) j6, new SeekCompletionListener() { // from class: com.bytedance.sdk.component.vl.xt.xt.8
                @Override // com.bykv.vk.component.ttvideo.SeekCompletionListener
                public void onCompletion(boolean z5) {
                    for (WeakReference weakReference : xt.this.f26945v) {
                        if (weakReference != null && weakReference.get() != null) {
                            ((j.InterfaceC0305j) weakReference.get()).j(xt.this, z5);
                        }
                    }
                    com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_TTVideo", "seekTo: ", " isSuccess =", Boolean.valueOf(z5));
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(j.InterfaceC0305j interfaceC0305j) {
        if (interfaceC0305j == null) {
            return;
        }
        for (WeakReference<j.InterfaceC0305j> weakReference : this.f26945v) {
            if (weakReference != null && weakReference.get() == interfaceC0305j) {
                return;
            }
        }
        this.f26945v.add(new WeakReference<>(interfaceC0305j));
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(boolean z5) {
        com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_TTVideo", "setIsMute: ");
        this.xt.setIsMute(z5);
    }

    public static void j(Context context, String str, int i6, String[] strArr, long[] jArr, boolean z5, VideoEventEngineUploader videoEventEngineUploader) {
        boolean z6;
        try {
            TTPlayerClient.create(new MediaPlayerWrapper(), cw.getContext()).release();
            j.j(context, str, i6, strArr, jArr, videoEventEngineUploader);
            j.j(z5);
            z6 = true;
        } catch (Throwable unused) {
            z6 = false;
        }
        f26934j = z6;
    }
}
