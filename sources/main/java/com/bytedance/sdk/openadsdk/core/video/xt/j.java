package com.bytedance.sdk.openadsdk.core.video.xt;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bykv.vk.openvk.component.video.api.j;
import com.bykv.vk.openvk.component.video.api.r.cw;
import com.bykv.vk.openvk.component.video.api.r.xt;
import com.bykv.vk.openvk.component.video.j.r.r;
import com.bytedance.sdk.component.utils.ch;
import com.bytedance.sdk.component.utils.tl;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.utils.ws;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.jy.j;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.hh;
import com.bytedance.sdk.openadsdk.core.tj.kt;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.m;
import com.bytedance.sdk.openadsdk.core.widget.az;
import com.bytedance.sdk.openadsdk.res.layout.video.LayoutVideoPlayLayoutForLive;
import com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import master.flame.danmaku.danmaku.parser.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import v0.a;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class j extends com.bytedance.sdk.openadsdk.core.video.j.j {

    /* renamed from: b, reason: collision with root package name */
    private final String f31125b;

    /* renamed from: c, reason: collision with root package name */
    private cw.j f31126c;
    public long ch;
    private long hl;
    protected com.bytedance.sdk.openadsdk.core.xt.j la;

    /* renamed from: n, reason: collision with root package name */
    private InterfaceC0494j f31131n;
    private final int ol;

    /* renamed from: q, reason: collision with root package name */
    private int f31133q;
    private int qb;
    private WeakReference<cw.xt> rh;

    /* renamed from: s, reason: collision with root package name */
    protected ViewGroup f31134s;
    private int sm;
    private long ya;

    /* renamed from: a, reason: collision with root package name */
    protected long f31124a = 0;

    /* renamed from: l, reason: collision with root package name */
    protected boolean f31130l = false;

    /* renamed from: p, reason: collision with root package name */
    protected boolean f31132p = false;

    /* renamed from: h, reason: collision with root package name */
    protected Map<String, Object> f31128h = null;
    private final AtomicInteger rn = new AtomicInteger(0);
    private final AtomicInteger wq = new AtomicInteger(0);
    private long uf = 0;
    private long ed = 0;
    private final Runnable gx = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.xt.j.1
        @Override // java.lang.Runnable
        public void run() {
            if (j.this.f31126c != null) {
                j.this.f31126c.j();
            }
            if (j.this.f31131n != null) {
                j.this.f31131n.xt();
            }
        }
    };
    private boolean nd = false;
    private boolean hh = false;

    /* renamed from: z, reason: collision with root package name */
    private boolean f31135z = true;

    /* renamed from: e, reason: collision with root package name */
    private boolean f31127e = false;
    j.InterfaceC0305j gq = new j.InterfaceC0305j() { // from class: com.bytedance.sdk.openadsdk.core.video.xt.j.2
        @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
        public void j(com.bykv.vk.openvk.component.video.api.j jVar) {
            vl.j("BaseVideoController", "IVideoPlayerCallback onCompletion: ");
            ((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).f30966j.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.xt.j.2.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.m(false);
                }
            });
            j.this.j(4);
            j.this.cw(4);
        }

        @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
        public void xt(com.bykv.vk.openvk.component.video.api.j jVar) {
            vl.j("BaseVideoController", "IVideoPlayerCallback onPrepared: ");
            ((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).f30966j.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.xt.j.2.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).f30966j.removeCallbacks(j.this.gx);
                    if (((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).up != null) {
                        j.this.m(0);
                        ((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).up.xt();
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
        public void cw(com.bykv.vk.openvk.component.video.api.j jVar) {
            vl.j("BaseVideoController", "IVideoPlayerCallback onRelease: ");
        }

        @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
        public void xt(com.bykv.vk.openvk.component.video.api.j jVar, int i6) {
            vl.j("BaseVideoController", "IVideoPlayerCallback onBufferingUpdate: ");
        }

        @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
        public void j(com.bykv.vk.openvk.component.video.api.j jVar, long j6) {
            vl.j("BaseVideoController", "IVideoPlayerCallback onRenderStart: ");
            ((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).f30966j.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.xt.j.2.2
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).up != null) {
                        j.this.m(0);
                        ((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).up.xt();
                        ((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).f30966j.removeCallbacks(j.this.gx);
                        j.this.hh = false;
                    }
                }
            });
            j.this.j(j6, false);
            j.this.hl = System.currentTimeMillis();
            j.this.ff();
            if (j.this.f31131n != null) {
                j.this.f31131n.cw();
            }
        }

        @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
        public void j(final com.bykv.vk.openvk.component.video.api.j jVar, final com.bykv.vk.openvk.component.video.api.cw.xt xtVar) {
            if (xtVar == null) {
                return;
            }
            vl.j("BaseVideoController", "IVideoPlayerCallback video_pip_big_error onError: code:" + xtVar.j() + " msg:" + xtVar.cw());
            ((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).f30966j.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.xt.j.2.4
                @Override // java.lang.Runnable
                public void run() {
                    com.bykv.vk.openvk.component.video.api.j jVar2;
                    com.bykv.vk.openvk.component.video.api.j jVar3;
                    int kt;
                    int j6 = xtVar.j();
                    if (j6 == 308 && (jVar2 = ((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).f30968r) != null && jVar2 != (jVar3 = jVar) && (jVar3 instanceof r) && ((kt = ((r) jVar3).kt()) == 200 || kt == 203)) {
                        vl.r("BaseVideoController", "ignore errorCode:" + j6 + " state:" + kt);
                        return;
                    }
                    j.this.j(j6, xtVar.xt(), xtVar.cw(), (JSONArray) null);
                    ((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).f30966j.removeCallbacks(j.this.gx);
                    if (((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).up != null) {
                        j.this.m(0);
                        ((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).up.xt();
                    }
                    if (j.this.f31126c != null) {
                        j.this.f31126c.xt(j.this.ed, com.bykv.vk.openvk.component.video.j.up.j.j(((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).ae, j.this.ch));
                    }
                    if (j.this.f31131n != null) {
                        j.this.f31131n.j(j6, xtVar.cw());
                    }
                }
            });
            j.this.j(xtVar.j(), xtVar.cw());
        }

        @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
        public void j(com.bykv.vk.openvk.component.video.api.j jVar, boolean z5) {
            vl.j("BaseVideoController", "IVideoPlayerCallback onSeekCompletion: ");
            ((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).f30966j.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.xt.j.2.5
                @Override // java.lang.Runnable
                public void run() {
                    ((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).f30966j.removeCallbacks(j.this.gx);
                    if (((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).up != null) {
                        j.this.m(0);
                        ((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).up.xt();
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
        public void j(com.bykv.vk.openvk.component.video.api.j jVar, int i6, int i7) {
            vl.j("BaseVideoController", "IVideoPlayerCallback onVideoSizeChanged: ");
            j.this.f31133q = i6;
            j.this.qb = i7;
            j.this.ry();
        }

        @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
        public void j(com.bykv.vk.openvk.component.video.api.j jVar, int i6, int i7, int i8) {
            vl.j("BaseVideoController", "IVideoPlayerCallback onBufferStart: ");
            ((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).f30966j.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.xt.j.2.6
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).up != null) {
                        j.this.m(8);
                        ((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).up.v();
                        j.this.b();
                        j.this.hh = true;
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
        public void j(com.bykv.vk.openvk.component.video.api.j jVar, int i6) {
            vl.j("BaseVideoController", "IVideoPlayerCallback onBufferEnd: ");
            ((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).f30966j.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.xt.j.2.7
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).up != null) {
                        j.this.m(0);
                        ((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).up.xt();
                        ((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).f30966j.removeCallbacks(j.this.gx);
                        j.this.hh = false;
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
        public void j(final com.bykv.vk.openvk.component.video.api.j jVar, final long j6, final long j7) {
            if (Math.abs(j6 - ((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).ae) < 50) {
                return;
            }
            vl.j("BaseVideoController", "IVideoPlayerCallback onPlayPositionUpdate: current = ", Long.valueOf(j6), "; duration=", Long.valueOf(j7));
            ((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).f30966j.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.xt.j.2.8
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).f30970v != null) {
                        ((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).f30970v.j(j6, j7);
                    }
                    j.this.xt(j6, j7);
                    if (((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).f30967m.to() != 2 || j7 <= 60000 || j6 < 60000 || ((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).ws) {
                        return;
                    }
                    ((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).ws = true;
                    jVar.r();
                    j.this.m(false);
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
        public void j(com.bykv.vk.openvk.component.video.api.j jVar, JSONObject jSONObject, String str) {
            if (oq.i().z()) {
                jSONObject.optString("start");
                jSONObject.optString("sdk_dns_analysis_end");
                jSONObject.optString("player_dns_analysis_end");
                jSONObject.optString("tcp_connect_end");
                jSONObject.optString("tcp_first_package_end");
                jSONObject.optString("first_video_package_end");
                jSONObject.optString("first_frame_video_decode_end");
                jSONObject.optString("first_frame_render_end");
                jSONObject.optLong("first_frame_render_end");
                jSONObject.optLong("start");
            }
            com.bytedance.sdk.openadsdk.core.jy.cw.j((Context) ((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).f30964g.get(), ((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).f30967m, j.this.f31125b, "pangle_live_sdk_monitor", jSONObject);
        }
    };
    private final ch.j xq = new ch.j() { // from class: com.bytedance.sdk.openadsdk.core.video.xt.j.3
        @Override // com.bytedance.sdk.component.utils.ch.j
        public void j(Context context, Intent intent, boolean z5, int i6) {
            j.this.j(context, i6);
        }
    };

    /* renamed from: k, reason: collision with root package name */
    private boolean f31129k = false;
    private long ff = 0;
    private AtomicBoolean ry = new AtomicBoolean(false);

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.xt.j$j, reason: collision with other inner class name */
    public interface InterfaceC0494j {
        void cw();

        void j();

        void j(int i6, String str);

        void j(long j6, long j7);

        void xt();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.j.j
    public boolean a() {
        return true;
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void j(cw.r rVar) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void r(boolean z5) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public boolean tj() {
        return false;
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.j
    public void up(com.bykv.vk.openvk.component.video.api.r.xt xtVar, View view) {
    }

    protected abstract int v();

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.xt.j$9, reason: invalid class name */
    static /* synthetic */ class AnonymousClass9 {

        /* renamed from: j, reason: collision with root package name */
        static final /* synthetic */ int[] f31153j;

        static {
            int[] iArr = new int[az.j.values().length];
            f31153j = iArr;
            try {
                iArr[az.j.PAUSE_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31153j[az.j.RELEASE_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31153j[az.j.START_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void ae(boolean z5) {
        if (!this.tj.j(64) || cw() || r()) {
            this.tj.cw(64);
            if (!rn() || this.f30967m == null) {
                long j6 = this.ch;
                xt(j6, j6);
                long j7 = this.ch;
                this.ae = j7;
                this.tl = j7;
                n();
                return;
            }
            if (!z5) {
                long j8 = this.ch;
                xt(j8, j8);
                long j9 = this.ch;
                this.ae = j9;
                this.tl = j9;
                return;
            }
            n();
            if (this.f30967m.tz() != 8) {
                this.tj.j();
                rh();
                j(0L, true);
            }
        }
    }

    private void aq() {
        m mVar = this.up;
        if (mVar != null) {
            mVar.r(0);
            this.up.j(false, false);
            this.up.cw(false);
            this.up.up();
            m(8);
            this.up.ae();
        }
    }

    private com.bykv.vk.openvk.component.video.api.renderview.xt kc() {
        m mVar;
        WeakReference<Context> weakReference = this.f30964g;
        if (weakReference == null || weakReference.get() == null || (mVar = this.up) == null) {
            return null;
        }
        return mVar.i();
    }

    private void qv(boolean z5) {
        if (this.f31131n != null) {
            if (!rn() || z5) {
                this.f31131n.j();
            }
        }
    }

    private boolean x() {
        n nVar = this.f30967m;
        if (com.bytedance.sdk.openadsdk.up.j.xt(nVar)) {
            com.bykv.vk.openvk.component.video.api.renderview.xt kc = kc();
            if (kc == null) {
                if (this.gq != null) {
                    StringBuilder sb = new StringBuilder("创建lottie播放器时，iRenderView为null, mediaLayout is null: ");
                    sb.append(this.up == null);
                    this.gq.j((com.bykv.vk.openvk.component.video.api.j) null, new com.bykv.vk.openvk.component.video.api.cw.xt(60008, 10005, sb.toString()));
                }
                vl.r("BaseVideoController", "[video] invoke NativeVideoController#playVideo error: iRenderView为null");
                return false;
            }
            this.f30968r = new com.bytedance.sdk.openadsdk.upie.video.lottie.j(kc, com.bytedance.sdk.openadsdk.up.j.g(nVar), new r(String.valueOf(uf.tl(this.f30967m))), ln.i(nVar));
        } else if (com.bytedance.sdk.openadsdk.up.j.cw(nVar)) {
            com.bykv.vk.openvk.component.video.api.renderview.xt kc2 = kc();
            if (kc2 == null) {
                if (this.gq != null) {
                    StringBuilder sb2 = new StringBuilder("创建Upie播放器时，iRenderView为null, mediaLayout is null: ");
                    sb2.append(this.up == null);
                    this.gq.j((com.bykv.vk.openvk.component.video.api.j) null, new com.bykv.vk.openvk.component.video.api.cw.xt(60008, 10005, sb2.toString()));
                }
                vl.r("BaseVideoController", "[video] invoke NativeVideoController#playVideo error: iRenderView为null");
                return false;
            }
            int tl = uf.tl(this.f30967m);
            this.f30968r = new com.bytedance.sdk.openadsdk.upie.video.lottie.xt((h.r() && this.f30963f.w() == 1) ? new com.bytedance.sdk.component.vl.xt.xt(v.getContext(), String.valueOf(tl)) : new r(String.valueOf(tl)), com.bytedance.sdk.openadsdk.up.j.g(nVar), kc2);
        } else {
            int tl2 = uf.tl(this.f30967m);
            if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(this.f30967m)) {
                this.f30968r = new com.bytedance.sdk.component.vl.j.j(v.getContext(), a(), (long) ln.m(this.f30967m), v.xt().pz(), null);
            } else if (h.r() && this.f30963f.w() == 1) {
                this.f30968r = new com.bytedance.sdk.component.vl.xt.xt(v.getContext(), String.valueOf(tl2));
            } else {
                this.f30968r = new r(String.valueOf(tl2));
            }
        }
        return true;
    }

    private boolean zz() throws Throwable {
        n nVar;
        WeakReference<Context> weakReference = this.f30964g;
        return weakReference == null || weakReference.get() == null || kc() == null || this.f30968r == null || (nVar = this.f30967m) == null || hh.m(nVar) != null || hh.ae(this.f30967m) != null || this.f30967m.kc() == 1;
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public int az() {
        return com.bykv.vk.openvk.component.video.j.up.j.j(this.tl, this.ch);
    }

    protected void b() {
        int ym;
        int v5 = v();
        if (v5 != 2 && v5 != 1) {
            ym = 5;
            if (v5 != 5) {
                if (v5 == 3) {
                    ym = v.xt().g(String.valueOf(this.ol));
                }
                this.f30966j.removeCallbacks(this.gx);
                this.f30966j.postDelayed(this.gx, ym);
            }
        }
        ym = v.xt().ym() * 1000;
        this.f30966j.removeCallbacks(this.gx);
        this.f30966j.postDelayed(this.gx, ym);
    }

    public void e() {
        if (!this.tj.j(64) || cw() || r()) {
            if (this.tj.j(2) || com.bytedance.sdk.openadsdk.l.oq.j(this.f30967m)) {
                nd();
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public boolean f() {
        return this.hh;
    }

    protected void ff() {
        if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(this.f30967m)) {
            int v5 = v();
            boolean j6 = this.tj.j(1024);
            long longValue = this.tj.xt(1).longValue();
            if (j6) {
                return;
            }
            this.tj.cw(1024);
            if (v5 == 1) {
                com.bytedance.sdk.openadsdk.core.jy.cw.j(this.f30967m, "rewarded_video", System.currentTimeMillis() - longValue, com.bytedance.sdk.openadsdk.m.xt.r.j(this.up));
            } else if (v5 == 2) {
                com.bytedance.sdk.openadsdk.core.jy.cw.j(this.f30967m, "fullscreen_interstitial_ad", System.currentTimeMillis() - longValue, com.bytedance.sdk.openadsdk.m.xt.r.j(this.up));
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void g() {
        com.bykv.vk.openvk.component.video.api.j jVar = this.f30968r;
        if (jVar != null) {
            jVar.up();
            this.f30968r = null;
        }
        m mVar = this.up;
        if (mVar != null) {
            mVar.g();
        }
        this.f30966j.removeCallbacks(this.gx);
        this.f30966j.removeCallbacksAndMessages(null);
        this.f31126c = null;
        this.f31131n = null;
    }

    public long hh() {
        return this.ff;
    }

    public int hl() {
        return com.bytedance.sdk.openadsdk.l.oq.j(this.f30967m) ? this.wq.get() : this.rn.get();
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public int jy() {
        com.bykv.vk.openvk.component.video.api.j jVar = this.f30968r;
        if (jVar == null) {
            return 0;
        }
        return jVar.i();
    }

    public boolean k() {
        return rn() ? xq() : cw();
    }

    protected void m(boolean z5) {
        if (l() && this.up != null) {
            this.f30966j.removeCallbacks(this.gx);
            m(0);
            this.up.xt();
            this.ed = System.currentTimeMillis() - this.uf;
            this.up.up(true);
            if (uf.m(this.f30967m)) {
                this.up.j2(this.f30967m, this.f30964g, true);
            } else {
                this.up.s();
            }
            ae(z5);
            if (!z5) {
                this.ry.set(true);
            }
            cw.j jVar = this.f31126c;
            if (jVar != null) {
                jVar.j(this.ed, com.bykv.vk.openvk.component.video.j.up.j.j(this.ae, this.ch));
            }
            qv(z5);
            this.mi = true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.j.j
    protected Map<String, Object> ol() {
        HashMap hashMap = new HashMap();
        Map<String, Object> map = this.f31128h;
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<String, Object> entry2 : uf.j(this.f31124a, this.f30967m, i()).entrySet()) {
            hashMap.put(entry2.getKey(), entry2.getValue());
        }
        return hashMap;
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void oq() {
        cw(-1);
        g();
    }

    public boolean q() {
        return this.f31127e;
    }

    public boolean qb() {
        return this.ry.get();
    }

    public void ry() {
        this.f30966j.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.xt.j.8
            @Override // java.lang.Runnable
            public void run() {
                if (kt.r(((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).f30967m) || !j.this.v_()) {
                    j jVar = j.this;
                    jVar.j(jVar.f31133q, j.this.qb);
                    return;
                }
                if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).f30967m) && ((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).f30967m.zw() == 2 && j.this.v_()) {
                    return;
                }
                if (!j.this.v_()) {
                    j jVar2 = j.this;
                    jVar2.j(jVar2.f31133q, j.this.qb);
                    return;
                }
                if (((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).f30967m != null && ((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).f30967m.ry() == 0) {
                    j jVar3 = j.this;
                    jVar3.r(jVar3.f31133q, j.this.qb);
                } else if (((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).f30967m == null || ((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).f30967m.ry() != 2) {
                    j jVar4 = j.this;
                    jVar4.cw(jVar4.f31133q, j.this.qb);
                } else {
                    j jVar5 = j.this;
                    jVar5.xt(jVar5.f31133q, j.this.qb);
                }
            }
        });
    }

    public boolean sm() {
        com.bykv.vk.openvk.component.video.api.j jVar = this.f30968r;
        return jVar != null && jVar.jy();
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void tl() {
        com.bykv.vk.openvk.component.video.api.cw.r rVar;
        m mVar = this.up;
        if (mVar != null) {
            mVar.j();
            this.up.kt();
            this.up.x();
        }
        vl.j("BaseVideoController", "resumeVideo:  mIsSurfaceValid = ", Boolean.valueOf(this.oq));
        com.bykv.vk.openvk.component.video.api.j jVar = this.f30968r;
        if (jVar != null) {
            if (jVar.ws()) {
                if (this.oq || (((rVar = this.f30963f) != null && rVar.ae()) || com.bytedance.sdk.openadsdk.up.j.xt(this.f30967m))) {
                    ed();
                } else {
                    xt(this.f30972x);
                }
                vl.j("BaseVideoController", "resumeVideo: isPaused = true , mIsSurfaceValid = ", Boolean.valueOf(this.oq));
            } else {
                this.f30968r.j(false, this.ae, this.f30965i);
            }
        }
        if (!this.tj.j(64) || cw() || r()) {
            if (this.tj.j(2) || com.bytedance.sdk.openadsdk.l.oq.j(this.f30967m)) {
                nd();
            }
        }
    }

    protected boolean v_() {
        n nVar = this.f30967m;
        return nVar == null || nVar.uo() == 100.0f;
    }

    public boolean xq() {
        boolean cw = cw();
        if (!cw || hl() >= 2) {
            return cw;
        }
        return this.ff >= ws() - 400;
    }

    public boolean ya() {
        return this.f30968r.g();
    }

    public void z() {
        n nVar = this.f30967m;
        if (nVar != null) {
            new j.C0460j().xt("auto_replay").j(uf.xt(nVar)).up(this.f30967m.fs()).r(this.f30967m.os()).j(new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.video.xt.j.4
                @Override // com.bytedance.sdk.openadsdk.m.j.j
                public void j(JSONObject jSONObject) throws JSONException {
                    com.bykv.vk.openvk.component.video.api.cw.cw ch;
                    JSONObject jSONObject2 = new JSONObject();
                    if (com.bytedance.sdk.openadsdk.l.oq.j(((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).f30967m)) {
                        jSONObject2.put("is_audio", 1);
                    }
                    if (((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).f30963f != null && (ch = ((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).f30963f.ch()) != null && ch.ae() > 0.0d) {
                        jSONObject2.put("start", ch.ae());
                    }
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                }
            });
        }
    }

    protected j(Context context, ViewGroup viewGroup, n nVar, com.bytedance.sdk.openadsdk.core.xt.j jVar) {
        this.sm = 1;
        this.sm = ws.cw(context);
        this.f31134s = viewGroup;
        this.f30964g = new WeakReference<>(context);
        this.f30967m = nVar;
        this.la = jVar;
        j(context);
        this.ol = uf.g(this.f30967m);
        this.f31125b = uf.xt(this.f30967m);
    }

    public long up(long j6) {
        long wq = (j6 - wq()) + (ws() * hl());
        long j7 = this.ff;
        if (wq < j7) {
            return j7;
        }
        this.ff = wq;
        return wq;
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public boolean cw() {
        return this.rn.get() > 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.j.j, com.bykv.vk.openvk.component.video.api.r.cw
    public boolean r() {
        if (com.bytedance.sdk.openadsdk.l.oq.j(this.f30967m)) {
            return ((double) this.wq.get()) <= ((double) ln.av(this.f30967m).ae());
        }
        return super.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw(int i6, int i7) {
        Throwable th;
        float f6;
        try {
            vl.j("changeVideoSize", "changeVideoSize start.......mMaterialMeta.getAdSlot()=" + this.f30967m.rr());
            if (zz()) {
                return;
            }
            vl.j("changeVideoSize", "changeVideoSize start check condition complete ... go ..");
            int[] xt = ed.xt(v.getContext());
            boolean z5 = false;
            boolean z6 = this.f30967m.zw() == 1;
            float f7 = xt[0];
            float f8 = xt[1];
            float f9 = i6;
            float f10 = i7;
            try {
                if (z6) {
                    if (f9 > f10) {
                        try {
                            j(f7, f8, f9, f10, true);
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            vl.cw("changeVideoSize", "changeSize error", th);
                        }
                    }
                } else if (f9 < f10) {
                    j(f7, f8, f9, f10, false);
                    return;
                }
                float f11 = f9 / f10;
                float f12 = f7 / f8;
                if (z6) {
                    if (f12 < 0.5625f && f11 == 0.5625f) {
                        f6 = (f8 * 9.0f) / 16.0f;
                        f10 = f8;
                        z5 = true;
                    }
                    f6 = f9;
                } else {
                    if (f12 > 1.7777778f && f11 == 1.7777778f) {
                        f10 = (f7 * 9.0f) / 16.0f;
                        f6 = f7;
                        z5 = true;
                    }
                    f6 = f9;
                }
                vl.j("changeVideoSize", "适配后宽高：videoHeight=" + f10 + ",videoWidth=" + f6);
                if (z5) {
                    f7 = f6;
                    f8 = f10;
                } else {
                    vl.j("changeVideoSize", " 屏幕比例和视频比例相同，以及其他情况都按照屏幕宽高播放，videoHeight=" + f8 + "，videoWidth=" + f7);
                }
                int i8 = (int) f7;
                int i9 = (int) f8;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i8, i9);
                layoutParams.addRule(13);
                Object kc = kc();
                if ((kc instanceof TextureView) || (kc instanceof UpieVideoView)) {
                    if (kc instanceof TextureView) {
                        ((TextureView) kc).setLayoutParams(layoutParams);
                    } else {
                        ((UpieVideoView) kc).setLayoutParams(layoutParams);
                    }
                    ViewGroup.LayoutParams layoutParams2 = this.f31134s.getLayoutParams();
                    if (layoutParams2 != null) {
                        layoutParams2.height = i9;
                        layoutParams2.width = i8;
                        this.f31134s.setLayoutParams(layoutParams2);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                vl.cw("changeVideoSize", "changeSize error", th);
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void xt() {
        if (this.f30968r != null) {
            if (!up()) {
                this.rn.getAndAdd(1);
                z();
            }
            this.wq.getAndAdd(1);
            if (!rn()) {
                this.tj.j();
                rh();
                j(0L, true);
            }
            cw(false);
            this.f30968r.j();
        }
    }

    private void r(com.bykv.vk.openvk.component.video.api.cw.r rVar) throws Exception {
        if (rVar == null) {
            j("model is null");
            return;
        }
        this.f30963f = rVar;
        final long cw = cw(rVar);
        if (this.f30968r != null) {
            n nVar = this.f30967m;
            if (nVar != null) {
                rVar.r(String.valueOf(uf.g(nVar)));
            }
            rVar.r(1);
            this.f30968r.j(rVar);
            this.f30968r.j(gq());
        }
        this.uf = System.currentTimeMillis();
        if (!TextUtils.isEmpty(rVar.av())) {
            this.up.up(8);
            this.up.up(0);
            j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.xt.j.5
                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.tj.r(1)) {
                        j.this.j("multi play_start");
                        return;
                    }
                    j.this.tj.j();
                    if (!j.this.rn() || !j.this.xq()) {
                        j.this.rh();
                    }
                    j.this.uf = System.currentTimeMillis();
                    ((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).up.r(0);
                    if (((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).f30968r != null && ((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).ae == 0) {
                        ((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).f30968r.j(true, cw, ((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).f30965i);
                    } else if (((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).f30968r != null) {
                        ((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).f30968r.j(true, ((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).ae, ((com.bytedance.sdk.openadsdk.core.video.j.j) j.this).f30965i);
                    }
                }
            });
            return;
        }
        j("url is null");
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.j.j, com.bykv.vk.openvk.component.video.api.r.cw
    public boolean up() {
        if (com.bytedance.sdk.openadsdk.l.oq.j(this.f30967m)) {
            return ((double) this.wq.get()) < ((double) ln.av(this.f30967m).ae());
        }
        return super.r();
    }

    @SuppressLint({"InflateParams"})
    private void j(Context context) {
        EnumSet noneOf = EnumSet.noneOf(xt.j.class);
        noneOf.add(xt.j.hideCloseBtn);
        noneOf.add(xt.j.hideBackBtn);
        m mVar = new m(StubApp.getOrigApplicationContext(context.getApplicationContext()), new LayoutVideoPlayLayoutForLive(context), true, noneOf, this.f30967m, this, this.la);
        this.up = mVar;
        mVar.j((com.bykv.vk.openvk.component.video.api.r.j) this);
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void up(boolean z5) {
        this.f31135z = z5;
    }

    public void up(int i6) {
        if (l()) {
            boolean z5 = i6 == 0 || i6 == 8;
            Context context = this.f30964g.get();
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                try {
                    activity.setRequestedOrientation(i6);
                } catch (Throwable unused) {
                }
                if (!z5) {
                    activity.getWindow().setFlags(1024, 1024);
                } else {
                    activity.getWindow().clearFlags(1024);
                }
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void ae() {
        com.bykv.vk.openvk.component.video.api.j jVar = this.f30968r;
        if (jVar != null) {
            jVar.cw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tl(int i6) {
        n nVar;
        int cw = ws.cw(v.getContext());
        if (cw != 4 && cw != 0) {
            m();
            this.az = true;
            this.nd = false;
            m mVar = this.up;
            if (mVar != null && (nVar = this.f30967m) != null) {
                return mVar.j(i6, ln.ws(nVar), true);
            }
        } else if (cw == 4) {
            this.az = false;
            m mVar2 = this.up;
            if (mVar2 != null) {
                mVar2.kt();
            }
        }
        return true;
    }

    private boolean ae(int i6) {
        return this.up.cw(i6);
    }

    public void j(long j6, boolean z5) {
        if (this.tj.j(2)) {
            return;
        }
        this.f31124a = j6;
        oq(z5);
        this.f31132p = true;
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void xt(Map<String, Object> map) {
        this.f31128h = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(int i6, int i7) {
        Throwable th;
        j jVar;
        try {
            WeakReference<Context> weakReference = this.f30964g;
            if (weakReference == null || weakReference.get() == null || kc() == null || this.f30968r == null || this.f30967m == null) {
                return;
            }
            int[] xt = ed.xt(v.getContext());
            boolean z5 = this.f30967m.zw() == 1;
            float f6 = xt[0];
            float f7 = xt[1];
            float f8 = i6;
            float f9 = i7;
            try {
                if (z5) {
                    if (f8 > f9) {
                        try {
                            j(f6, f7, f8, f9, true);
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            vl.cw("changeVideoSize", "changeVideoSizeByWidth error", th);
                        }
                    }
                    f7 = (f9 * f6) / f8;
                    jVar = this;
                } else if (f8 < f9) {
                    j(f6, f7, f8, f9, false);
                    return;
                } else {
                    jVar = this;
                    f6 = (f8 * f7) / f9;
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) f6, (int) f7);
                layoutParams.addRule(13);
                if (jVar.f31134s != null) {
                    Object kc = kc();
                    if (kc instanceof TextureView) {
                        ((TextureView) kc).setLayoutParams(layoutParams);
                    } else if (kc instanceof UpieVideoView) {
                        ((UpieVideoView) kc).setLayoutParams(layoutParams);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                vl.cw("changeVideoSize", "changeVideoSizeByWidth error", th);
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void m() {
        com.bykv.vk.openvk.component.video.api.j jVar = this.f30968r;
        if (jVar != null) {
            jVar.cw();
        }
        if (!this.tj.j(64) || cw() || r()) {
            if (this.tj.j(2) || com.bytedance.sdk.openadsdk.l.oq.j(this.f30967m)) {
                cw((Map<String, Object>) null);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public boolean j(com.bykv.vk.openvk.component.video.api.cw.r rVar) {
        if (rVar == null) {
            j("model is null");
            return false;
        }
        com.bykv.vk.openvk.component.video.api.j jVar = this.f30968r;
        if (jVar != null && jVar.ws()) {
            this.f30968r.xt();
            return true;
        }
        this.f30963f = rVar;
        rVar.av();
        if (TextUtils.isEmpty(rVar.av())) {
            vl.r("BaseVideoController", "No video info");
            j("url is null");
            return false;
        }
        this.f31130l = (rVar.av().startsWith(b.f50154a) || com.bytedance.sdk.openadsdk.core.video.cw.j.j(this.f30967m)) ? false : true;
        this.f30965i = rVar.qv();
        if (rVar.oq() > 0) {
            long oq = rVar.oq();
            this.ae = oq;
            long j6 = this.tl;
            if (j6 > oq) {
                oq = j6;
            }
            this.tl = oq;
        }
        m mVar = this.up;
        if (mVar != null) {
            mVar.j();
            m(8);
            this.up.ae();
            this.up.cw(rVar.tl(), rVar.g());
            this.up.cw(this.f31134s);
        }
        try {
            if (this.f30968r == null) {
                if (!x()) {
                    j("create video error");
                    return false;
                }
                this.f30968r.j(this.gq);
            }
            s();
            this.ed = 0L;
            r(rVar);
            return true;
        } catch (Throwable th) {
            j(th.getMessage());
            vl.r("BaseVideoController", "create video error:" + th.getMessage());
            return false;
        }
    }

    protected void m(int i6) {
        Object obj;
        if (this.f30964g == null || !com.bytedance.sdk.openadsdk.core.video.cw.j.j(this.f30967m) || this.f30964g.get() == null || (obj = (Context) this.f30964g.get()) == null || !(obj instanceof com.bytedance.sdk.openadsdk.core.tl.xt)) {
            return;
        }
        ((com.bytedance.sdk.openadsdk.core.tl.xt) obj).j(i6 == 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i6, int i7) {
        n nVar;
        try {
            WeakReference<Context> weakReference = this.f30964g;
            if (weakReference != null && weakReference.get() != null && kc() != null && this.f30968r != null && (nVar = this.f30967m) != null) {
                boolean z5 = nVar.zw() == 1;
                int[] xt = ed.xt(v.getContext());
                j(xt[0], xt[1], i6, i7, z5);
            }
        } catch (Throwable unused) {
        }
    }

    private void cw(long j6, long j7) {
        if (rn()) {
            final int tz = this.f30967m.tz();
            if (xt(tz)) {
                long wq = wq();
                if (k() && j6 >= wq - 200 && this.ry.get() && Math.abs(j6 - j7) > 200) {
                    this.ry.set(false);
                    this.f30966j.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.xt.j.6
                        @Override // java.lang.Runnable
                        public void run() {
                            j.this.m(true);
                            if (tz == 8) {
                                j.this.i().r();
                            }
                        }
                    });
                }
            }
        }
        up(j6);
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.j
    public void r(com.bykv.vk.openvk.component.video.api.r.xt xtVar, View view) {
        if (this.kt) {
            g(false);
            m mVar = this.up;
            if (mVar != null) {
                mVar.xt(this.f31134s);
            }
            up(1);
            return;
        }
        j(1);
        j(true, 3);
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.j
    public void xt(com.bykv.vk.openvk.component.video.api.r.xt xtVar, int i6) {
        m mVar = this.up;
        if (mVar != null) {
            mVar.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(long j6, long j7) {
        this.ae = j6;
        this.ch = j7;
        this.up.j(j6, j7);
        int j8 = com.bykv.vk.openvk.component.video.j.up.j.j(j6, j7);
        if (!cw() && !r()) {
            this.up.xt(j8);
        } else {
            this.up.xt(100);
        }
        cw(j6, j7);
        try {
            cw.j jVar = this.f31126c;
            if (jVar != null) {
                jVar.j(j6, j7);
            }
            InterfaceC0494j interfaceC0494j = this.f31131n;
            if (interfaceC0494j != null) {
                interfaceC0494j.j(j6, j7);
            }
        } catch (Throwable th) {
            vl.cw("BaseVideoController", "onProgressUpdate error: ", th);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.j
    public void cw(com.bykv.vk.openvk.component.video.api.r.xt xtVar, View view) {
        m mVar = this.up;
        if (mVar != null) {
            mVar.g();
        }
        j(1);
        j(true, 3);
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void j(cw.xt xtVar) {
        this.rh = new WeakReference<>(xtVar);
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.j
    public void xt(com.bykv.vk.openvk.component.video.api.r.xt xtVar, View view) {
        xt(xtVar, view, false, false);
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void j(cw.j jVar) {
        this.f31126c = jVar;
    }

    public void xt(com.bykv.vk.openvk.component.video.api.r.xt xtVar, View view, boolean z5, boolean z6) {
        if (l()) {
            g(!this.kt);
            if (this.f30964g.get() instanceof Activity) {
                if (this.kt) {
                    up(z5 ? 8 : 0);
                    m mVar = this.up;
                    if (mVar != null) {
                        mVar.j(this.f31134s);
                        this.up.cw(false);
                    }
                } else {
                    up(1);
                    m mVar2 = this.up;
                    if (mVar2 != null) {
                        mVar2.xt(this.f31134s);
                        this.up.cw(false);
                    }
                }
                WeakReference<cw.xt> weakReference = this.rh;
                cw.xt xtVar2 = weakReference != null ? weakReference.get() : null;
                if (xtVar2 != null) {
                    xtVar2.j(this.kt);
                }
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void j(Map<String, Object> map) {
        com.bykv.vk.openvk.component.video.api.j jVar = this.f30968r;
        if (jVar != null) {
            jVar.cw();
        }
        if (!this.tj.j(64) || cw() || r()) {
            if (this.tj.j(2) || com.bytedance.sdk.openadsdk.l.oq.j(this.f30967m)) {
                cw(map);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void j(long j6) {
        this.ae = Math.max(j6, i().mi());
        this.tl = Math.max(this.tl, qv());
        m mVar = this.up;
        if (mVar != null) {
            mVar.j();
        }
        com.bykv.vk.openvk.component.video.api.j jVar = this.f30968r;
        if (jVar != null) {
            jVar.j(false, this.ae, this.f30965i);
            this.f30968r.j(this.ae);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void j(boolean z5, int i6) {
        cw(i6);
        g();
    }

    private void xt(long j6, boolean z5) {
        if (this.f30968r == null) {
            return;
        }
        if (z5) {
            aq();
        }
        this.f30968r.j(j6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i6, int i7) {
        ViewGroup viewGroup;
        try {
            if (kc() != null && this.f30968r != null && (viewGroup = this.f31134s) != null) {
                float f6 = i6;
                float f7 = i7;
                float width = viewGroup.getWidth();
                float f8 = f6 / (width * 1.0f);
                float height = this.f31134s.getHeight();
                if (f8 <= f7 / (height * 1.0f)) {
                    width = f6 * (height / (f7 * 1.0f));
                } else {
                    height = f7 * (width / (f6 * 1.0f));
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) width, (int) height);
                layoutParams.addRule(13);
                Object kc = kc();
                if (kc instanceof TextureView) {
                    ((TextureView) kc).setLayoutParams(layoutParams);
                } else if (kc instanceof UpieVideoView) {
                    ((UpieVideoView) kc).setLayoutParams(layoutParams);
                }
            }
        } catch (Throwable th) {
            vl.cw("changeVideoSize", "changeVideoSizeSupportInteraction error", th);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void xt(com.bykv.vk.openvk.component.video.api.cw.r rVar) {
        this.f30963f = rVar;
    }

    private void j(float f6, float f7, float f8, float f9, boolean z5) {
        RelativeLayout.LayoutParams layoutParams;
        if (f8 <= 0.0f || f9 <= 0.0f) {
            try {
                f8 = ln.r(this.f30967m);
                f9 = ln.cw(this.f30967m);
            } catch (Throwable unused) {
                return;
            }
        }
        if (f9 > 0.0f && f8 > 0.0f) {
            if (z5) {
                if (f8 < f9) {
                    return;
                }
                layoutParams = new RelativeLayout.LayoutParams((int) f6, (int) ((f9 * f6) / f8));
            } else if (f8 > f9) {
                return;
            } else {
                layoutParams = new RelativeLayout.LayoutParams((int) ((f8 * f7) / f9), (int) f7);
            }
            layoutParams.addRule(13);
            Object kc = kc();
            if (kc instanceof TextureView) {
                ((TextureView) kc).setLayoutParams(layoutParams);
            } else if (kc instanceof UpieVideoView) {
                ((UpieVideoView) kc).setLayoutParams(layoutParams);
            }
            this.f31127e = true;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.j
    public void j(com.bykv.vk.openvk.component.video.api.r.xt xtVar, View view) {
        if (this.f30968r == null || !l()) {
            return;
        }
        if (this.f30968r.jy()) {
            m();
            this.up.xt(true, false);
            this.up.m();
            return;
        }
        if (!this.f30968r.ws()) {
            m mVar = this.up;
            if (mVar != null) {
                mVar.cw(this.f31134s);
            }
            j(this.ae);
            m mVar2 = this.up;
            if (mVar2 != null) {
                mVar2.xt(false, false);
                return;
            }
            return;
        }
        tl();
        m mVar3 = this.up;
        if (mVar3 != null) {
            mVar3.xt(false, false);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.j
    public void j(com.bykv.vk.openvk.component.video.api.r.xt xtVar, int i6) {
        if (this.f30968r == null) {
            return;
        }
        xt(this.ya, ae(i6));
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.j
    public void j(com.bykv.vk.openvk.component.video.api.r.xt xtVar, int i6, boolean z5) {
        if (l()) {
            long j6 = (long) (((i6 * r0) * 1.0f) / 100.0f);
            if (this.ch > 0) {
                this.ya = (int) j6;
            } else {
                this.ya = 0L;
            }
            m mVar = this.up;
            if (mVar != null) {
                mVar.j(this.ya);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.j
    public void j(com.bykv.vk.openvk.component.video.api.r.xt xtVar, View view, boolean z5, boolean z6) {
        if (this.vl) {
            m();
        }
        if (z5 && !this.vl && !ya()) {
            this.up.xt(!sm(), false);
            this.up.j(z6, true, false);
        }
        com.bykv.vk.openvk.component.video.api.j jVar = this.f30968r;
        if (jVar != null && jVar.jy()) {
            this.up.m();
            this.up.up();
        } else {
            this.up.m();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.j
    public void j() {
        m mVar = this.up;
        if (mVar != null) {
            mVar.up();
            this.up.j();
        }
        m mVar2 = this.up;
        if (mVar2 != null) {
            mVar2.x();
        }
        j(-1L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.xt
    public void j(az.j jVar, String str) {
        int i6 = AnonymousClass9.f31153j[jVar.ordinal()];
        if (i6 == 1) {
            m();
            return;
        }
        if (i6 == 2) {
            j(true, 3);
        } else {
            if (i6 != 3) {
                return;
            }
            tl();
            this.az = false;
            this.nd = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Context context, int i6) {
        if (l() && this.sm != i6) {
            if (!this.nd) {
                tl.xt().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.xt.j.7
                    @Override // java.lang.Runnable
                    public void run() {
                        j.this.tl(2);
                    }
                });
            }
            this.sm = i6;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void j(int i6) {
        if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(this.f30967m)) {
            int v5 = v();
            long currentTimeMillis = System.currentTimeMillis() - this.hl;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("close_reason", Integer.valueOf(i6));
                jSONObject.putOpt("buffer_count", Integer.valueOf(jy()));
                jSONObject.putOpt("buffer_time", Long.valueOf(vl()));
            } catch (Exception e6) {
                vl.j(e6);
            }
            if (!this.tj.j(512)) {
                this.tj.cw(512);
                if (v5 == 1) {
                    com.bytedance.sdk.openadsdk.core.jy.cw.j(this.f30967m, "rewarded_video", currentTimeMillis, jSONObject, com.bytedance.sdk.openadsdk.m.xt.r.j(this.up));
                } else if (v5 == 2) {
                    com.bytedance.sdk.openadsdk.core.jy.cw.j(this.f30967m, "fullscreen_interstitial_ad", currentTimeMillis, jSONObject, com.bytedance.sdk.openadsdk.m.xt.r.j(this.up));
                }
            }
            if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(this.f30967m)) {
                if (com.bytedance.sdk.openadsdk.core.live.xt.j().j(this.f30967m)) {
                    com.bytedance.sdk.openadsdk.core.live.xt.j().j(a.f54681c, this.f30967m, currentTimeMillis);
                } else {
                    com.bytedance.sdk.openadsdk.core.video.cw.j.j(a.f54681c, this.f30967m, currentTimeMillis);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i6, String str) {
        if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(this.f30967m)) {
            int v5 = v();
            if (v5 == 1) {
                com.bytedance.sdk.openadsdk.core.jy.cw.j(this.f30967m, "rewarded_video", i6, str, com.bytedance.sdk.openadsdk.m.xt.r.j(this.up));
            } else if (v5 == 2) {
                com.bytedance.sdk.openadsdk.core.jy.cw.j(this.f30967m, "fullscreen_interstitial_ad", i6, str, com.bytedance.sdk.openadsdk.m.xt.r.j(this.up));
            }
        }
    }

    public void j(InterfaceC0494j interfaceC0494j) {
        this.f31131n = interfaceC0494j;
    }
}
