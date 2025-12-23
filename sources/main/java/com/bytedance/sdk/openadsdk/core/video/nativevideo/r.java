package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.bykv.vk.openvk.component.video.api.j;
import com.bykv.vk.openvk.component.video.api.r.cw;
import com.bykv.vk.openvk.component.video.api.r.xt;
import com.bytedance.sdk.component.utils.ch;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.tl;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.utils.ws;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.multipro.xt.j;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.kc;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.widget.az;
import com.bytedance.sdk.openadsdk.i.cw.xt.jy;
import com.bytedance.sdk.openadsdk.l.oq;
import com.bytedance.sdk.openadsdk.m.cw.i;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.bytedance.sdk.openadsdk.res.layout.video.LayoutVideoDetail;
import com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r extends com.bytedance.sdk.openadsdk.core.video.j.j {

    /* renamed from: b, reason: collision with root package name */
    private long f31070b;

    /* renamed from: e, reason: collision with root package name */
    private int f31072e;
    private boolean gq;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f31073h;

    /* renamed from: k, reason: collision with root package name */
    private int f31074k;
    private String la;

    /* renamed from: n, reason: collision with root package name */
    private WeakReference<cw.r> f31076n;
    private WeakReference<j> nd;
    private int ol;

    /* renamed from: p, reason: collision with root package name */
    private cw.j f31077p;

    /* renamed from: q, reason: collision with root package name */
    private Map<String, Object> f31078q;
    private int rh;
    private boolean rn;

    /* renamed from: s, reason: collision with root package name */
    private ViewGroup f31079s;
    private long sm;
    private WeakReference<cw.xt> wq;

    /* renamed from: a, reason: collision with root package name */
    private long f31069a = 0;

    /* renamed from: l, reason: collision with root package name */
    private long f31075l = 0;
    private boolean uf = false;
    private boolean ed = false;

    /* renamed from: c, reason: collision with root package name */
    private boolean f31071c = true;
    private volatile boolean gx = false;
    private int hh = 0;

    /* renamed from: z, reason: collision with root package name */
    private boolean f31080z = false;
    private boolean hl = true;
    private j.InterfaceC0305j qb = new j.InterfaceC0305j() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.r.1
        @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
        public void j(com.bykv.vk.openvk.component.video.api.j jVar) {
            ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30966j.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.r.1.1
                @Override // java.lang.Runnable
                public void run() {
                    r.this.e();
                }
            });
            r.this.j(4);
            r.this.cw(4);
        }

        @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
        public void xt(com.bykv.vk.openvk.component.video.api.j jVar, int i6) {
        }

        @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
        public void cw(com.bykv.vk.openvk.component.video.api.j jVar) {
            r.this.kc();
        }

        @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
        public void xt(com.bykv.vk.openvk.component.video.api.j jVar) {
            if (!r.this.f31073h || oq.j(((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30967m)) {
                r.this.xq();
            }
            ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30966j.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.r.1.3
                @Override // java.lang.Runnable
                public void run() {
                    if (r.this.f31076n != null && r.this.f31076n.get() != null) {
                        ((cw.r) r.this.f31076n.get()).p_();
                    }
                    if (((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).up != null && (!r.this.k() || !v.xt().px())) {
                        ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).up.xt();
                    }
                    ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30966j.removeCallbacks(r.this.ch);
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
        public void j(com.bykv.vk.openvk.component.video.api.j jVar, long j6) {
            ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30966j.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.r.1.2
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).up != null) {
                        if (r.this.k() && v.xt().px()) {
                            ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).up.a();
                        } else {
                            ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).up.xt();
                        }
                        ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30966j.removeCallbacks(r.this.ch);
                        r.this.f31080z = false;
                    }
                    if (r.this.nd != null && r.this.nd.get() != null) {
                        ((j) r.this.nd.get()).C_();
                    }
                    ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30966j.removeCallbacks(r.this.ch);
                }
            });
            r.this.xq();
            r.this.f31070b = System.currentTimeMillis();
            r.this.rr();
        }

        @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
        public void j(com.bykv.vk.openvk.component.video.api.j jVar, final com.bykv.vk.openvk.component.video.api.cw.xt xtVar) {
            ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30966j.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.r.1.4
                /* JADX WARN: Removed duplicated region for block: B:22:0x00d7  */
                /* JADX WARN: Removed duplicated region for block: B:25:0x00ec  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void run() {
                    /*
                        Method dump skipped, instructions count: 327
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.video.nativevideo.r.AnonymousClass1.AnonymousClass4.run():void");
                }
            });
            r.this.j(xtVar.j(), xtVar.cw());
        }

        @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
        public void j(com.bykv.vk.openvk.component.video.api.j jVar, boolean z5) {
            ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30966j.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.r.1.5
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).up != null) {
                        ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).up.xt();
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
        public void j(com.bykv.vk.openvk.component.video.api.j jVar, final int i6, final int i7) {
            ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30966j.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.r.1.6
                @Override // java.lang.Runnable
                public void run() {
                    r.this.xt(i6, i7);
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
        public void j(com.bykv.vk.openvk.component.video.api.j jVar, int i6, int i7, int i8) {
            ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30966j.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.r.1.7
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).up != null) {
                        ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).up.v();
                        ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30966j.postDelayed(r.this.ch, 8000L);
                        r.this.f31080z = true;
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
        public void j(com.bykv.vk.openvk.component.video.api.j jVar, int i6) {
            ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30966j.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.r.1.8
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).up != null) {
                        ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).up.xt();
                    }
                    ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30966j.removeCallbacks(r.this.ch);
                    r.this.f31080z = false;
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
        public void j(com.bykv.vk.openvk.component.video.api.j jVar, final long j6, final long j7) {
            if (Math.abs(j6 - ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).ae) < 50) {
                return;
            }
            ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30966j.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.r.1.9
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30970v != null) {
                        ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30970v.j(j6, j7);
                    }
                    r.this.xt(j6, j7);
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
        public void j(com.bykv.vk.openvk.component.video.api.j jVar, JSONObject jSONObject, String str) {
            if (com.bytedance.sdk.openadsdk.core.oq.i().z()) {
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
            com.bytedance.sdk.openadsdk.core.jy.cw.j((Context) ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30964g.get(), ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30967m, r.this.la, "pangle_live_sdk_monitor", jSONObject);
        }
    };
    private int ya = 0;
    Runnable ch = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.r.4
        @Override // java.lang.Runnable
        public void run() {
            if (((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).up != null) {
                ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).up.j2(((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30967m, ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30964g, false);
                ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).up.xt();
                r.this.cw(true);
                vl.r("NativeVideoController", "出错后展示结果页、、、、、、、showAdCard");
            }
        }
    };
    private final ch.j xq = new ch.j() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.r.6
        @Override // com.bytedance.sdk.component.utils.ch.j
        public void j(Context context, Intent intent, boolean z5, int i6) {
            r.this.cw(context, i6);
        }
    };
    private boolean ff = false;

    public interface j {
        void C_();

        void g();

        void j(int i6);
    }

    public r(Context context, ViewGroup viewGroup, n nVar, String str, boolean z5, boolean z6, boolean z7) {
        this.la = "embeded_ad";
        this.gq = false;
        this.rn = true;
        this.rh = 0;
        this.ol = 0;
        this.f31074k = 1;
        this.f31074k = ws.cw(context);
        j(z5);
        this.la = str;
        try {
            this.rh = viewGroup.getWidth();
            this.ol = viewGroup.getHeight();
        } catch (Throwable unused) {
        }
        this.f31079s = viewGroup;
        this.f30964g = new WeakReference<>(context);
        this.f30967m = nVar;
        j(context);
        this.f31073h = true;
        this.gq = z6;
        this.rn = z7;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.j.j
    public boolean a() {
        return true;
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public boolean cw() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.j.j, com.bykv.vk.openvk.component.video.api.r.cw
    public boolean r() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.j.j, com.bykv.vk.openvk.component.video.api.r.cw
    public boolean up() {
        return false;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.nativevideo.r$9, reason: invalid class name */
    static /* synthetic */ class AnonymousClass9 {

        /* renamed from: j, reason: collision with root package name */
        static final /* synthetic */ int[] f31098j;

        static {
            int[] iArr = new int[az.j.values().length];
            f31098j = iArr;
            try {
                iArr[az.j.PAUSE_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31098j[az.j.RELEASE_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31098j[az.j.START_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
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
            this.up.ae();
        }
    }

    private boolean b() {
        n nVar = this.f30967m;
        if (com.bytedance.sdk.openadsdk.up.j.xt(nVar)) {
            com.bykv.vk.openvk.component.video.api.renderview.xt v5 = v();
            if (v5 == null) {
                if (this.qb != null) {
                    StringBuilder sb = new StringBuilder("创建lottie播放器时，iRenderView为null, mediaLayout is null: ");
                    sb.append(this.up == null);
                    this.qb.j((com.bykv.vk.openvk.component.video.api.j) null, new com.bykv.vk.openvk.component.video.api.cw.xt(60008, 10005, sb.toString()));
                }
                vl.r("tag_video_play", "[video] invoke NativeVideoController#playVideo error: iRenderView为null");
                return false;
            }
            this.f30968r = new com.bytedance.sdk.openadsdk.upie.video.lottie.j(v5, com.bytedance.sdk.openadsdk.up.j.g(nVar), new com.bykv.vk.openvk.component.video.j.r.r(String.valueOf(uf.tl(this.f30967m))), ln.i(nVar));
        } else if (com.bytedance.sdk.openadsdk.up.j.cw(nVar)) {
            com.bykv.vk.openvk.component.video.api.renderview.xt v6 = v();
            if (v6 == null) {
                if (this.qb != null) {
                    StringBuilder sb2 = new StringBuilder("创建Upie播放器时，iRenderView为null, mediaLayout is null: ");
                    sb2.append(this.up == null);
                    this.qb.j((com.bykv.vk.openvk.component.video.api.j) null, new com.bykv.vk.openvk.component.video.api.cw.xt(60008, 10005, sb2.toString()));
                }
                vl.r("tag_video_play", "[video] invoke NativeVideoController#playVideo error: iRenderView为null");
                return false;
            }
            int tl = uf.tl(this.f30967m);
            this.f30968r = new com.bytedance.sdk.openadsdk.upie.video.lottie.xt((h.r() && this.f30963f.w() == 1) ? new com.bytedance.sdk.component.vl.xt.xt(v.getContext(), String.valueOf(tl)) : new com.bykv.vk.openvk.component.video.j.r.r(String.valueOf(tl)), com.bytedance.sdk.openadsdk.up.j.g(nVar), v6);
        } else {
            int tl2 = uf.tl(this.f30967m);
            if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(this.f30967m)) {
                this.f30968r = new com.bytedance.sdk.component.vl.j.j(v.getContext(), a(), (long) ln.m(this.f30967m), v.xt().pz(), null);
            } else if (h.r() && this.f30963f.w() == 1) {
                this.f30968r = new com.bytedance.sdk.component.vl.xt.xt(v.getContext(), String.valueOf(tl2));
            } else {
                this.f30968r = new com.bykv.vk.openvk.component.video.j.r.r(String.valueOf(tl2));
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        m mVar;
        this.ya++;
        if (l() && (mVar = this.up) != null) {
            mVar.xt();
            cw.j jVar = this.f31077p;
            if (jVar != null) {
                jVar.j(this.f31075l, com.bykv.vk.openvk.component.video.j.up.j.j(this.ae, this.av));
            }
            this.f31075l = System.currentTimeMillis() - this.f31069a;
            this.up.up(true);
            boolean j6 = com.bytedance.sdk.openadsdk.core.video.cw.j.j(this.f30967m);
            int ya = this.f30967m.ya();
            boolean z5 = ya <= 0;
            boolean z6 = !z5 && this.ya >= ya;
            boolean cw = uf.cw(this.f30967m);
            if (!cw || z6 || j6) {
                this.up.j2(this.f30967m, this.f30964g, true);
            }
            if (!this.tj.j(64) || q() || qb()) {
                this.tj.cw(64);
                long j7 = this.av;
                xt(j7, j7);
                long j8 = this.av;
                this.ae = j8;
                this.tl = j8;
                i.j jVar2 = new i.j();
                jVar2.j(qv());
                jVar2.cw(ws());
                jVar2.xt(vl());
                jVar2.m(jy());
                com.bytedance.sdk.openadsdk.m.xt.r.r(this.up, jVar2);
            }
            if (!this.vl && this.kt) {
                up(this.up, null);
            }
            this.mi = true;
            if (j6) {
                return;
            }
            if (cw && (z5 || this.ya < ya)) {
                ch();
                return;
            }
            boolean z7 = ws() / 1000 < 10;
            if (oq.j(this.f30967m) && z7 && this.ya < 2) {
                ch();
            }
        }
    }

    private boolean ff() {
        kc bw;
        if (!k()) {
            return false;
        }
        n nVar = this.f30967m;
        return nVar == null || (bw = nVar.bw()) == null || bw.j() != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k() {
        return TextUtils.equals(this.la, "splash_ad") || TextUtils.equals(this.la, "cache_splash_ad");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kc() {
        m mVar;
        if (!this.gx || (mVar = this.up) == null || mVar.cw() == null) {
            return;
        }
        this.gx = false;
        this.up.cw().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.r.5
            @Override // java.lang.Runnable
            public void run() {
                if (((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30963f == null) {
                    return;
                }
                ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30963f.xt(((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30967m.fs());
                ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30963f.xt(r.this.rh);
                ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30963f.cw(r.this.ol);
                ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30963f.j((List<String>) null);
                ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30963f.cw(((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30967m.os());
                ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30963f.j(0L);
                ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30963f.xt(r.this.mi());
                ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30963f.j(((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30963f.up());
                r rVar = r.this;
                rVar.j(((com.bytedance.sdk.openadsdk.core.video.j.j) rVar).f30963f);
                r.this.cw(false);
            }
        });
    }

    private boolean q() {
        return this.ya > 0 && uf.cw(this.f30967m);
    }

    private boolean qb() {
        return this.ya > 0 && oq.j(this.f30967m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r(int i6, int i7) {
        boolean z5 = i6 == -1010 || i6 == -1007 || i6 == -1004 || i6 == -110 || i6 == 100 || i6 == 200 || i6 == 60008;
        if (i7 == 1 || i7 == 700 || i7 == 800) {
            return true;
        }
        return z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rr() {
        if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(this.f30967m) && !TextUtils.isEmpty(this.la)) {
            boolean j6 = this.tj.j(1024);
            long longValue = this.tj.xt(1).longValue();
            if (j6) {
                return;
            }
            this.tj.cw(1024);
            if (this.la.equals("embeded_ad")) {
                com.bytedance.sdk.openadsdk.core.jy.cw.j(this.f30967m, "embeded_ad", System.currentTimeMillis() - longValue, com.bytedance.sdk.openadsdk.m.xt.r.j(this.up));
            } else if (this.la.equals("draw_ad")) {
                com.bytedance.sdk.openadsdk.core.jy.cw.j(this.f30967m, "draw_ad", System.currentTimeMillis() - longValue, com.bytedance.sdk.openadsdk.m.xt.r.j(this.up));
            }
        }
    }

    private boolean ry() {
        n nVar = this.f30967m;
        return nVar != null && nVar.ry() == 1 && "draw_ad".equals(this.la) && this.f31079s != null;
    }

    private void sm() {
        com.bykv.vk.openvk.component.video.api.cw.r rVar;
        vl.j("NativeVideoController", "resumeVideo:  mIsSurfaceValid = ", Boolean.valueOf(this.oq));
        com.bykv.vk.openvk.component.video.api.j jVar = this.f30968r;
        if (jVar != null) {
            if (jVar.ws() && !ya()) {
                if (this.oq || (((rVar = this.f30963f) != null && rVar.ae()) || com.bytedance.sdk.openadsdk.up.j.xt(this.f30967m))) {
                    ed();
                } else {
                    xt(this.f30972x);
                }
                vl.j("NativeVideoController", "resumeVideo: isPaused = true , mIsSurfaceValid = ", Boolean.valueOf(this.oq));
            } else if (ya()) {
                this.ae = com.bytedance.sdk.openadsdk.core.oq.i().k();
                com.bytedance.sdk.openadsdk.core.oq.i().j(-1L);
                this.f30968r.j(this.ae);
                this.f30968r.xt();
            } else {
                this.f30968r.j(false, this.ae, this.f30965i);
            }
        }
        if (this.tj.j(2)) {
            i.j jVar2 = new i.j();
            jVar2.j(qv());
            jVar2.cw(ws());
            jVar2.xt(vl());
            xt(w(), jVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xq() {
        if (!this.tj.j(2) || q()) {
            i.j jVar = new i.j();
            if (k()) {
                this.f31071c = true;
            }
            jVar.xt(this.f31071c);
            jVar.cw(ws());
            this.tj.cw(2);
            com.bytedance.sdk.openadsdk.m.xt.r.j(this.up, jVar);
        }
    }

    private boolean ya() {
        return this.vl && com.bytedance.sdk.openadsdk.core.oq.i().k() > 0;
    }

    private void zz() {
        if (l()) {
            g(!this.kt);
            if (this.f30964g.get() instanceof Activity) {
                m mVar = this.up;
                if (mVar != null) {
                    mVar.xt(this.f31079s);
                    this.up.cw(false);
                }
                m(1);
                WeakReference<cw.xt> weakReference = this.wq;
                cw.xt xtVar = weakReference != null ? weakReference.get() : null;
                if (xtVar != null) {
                    xtVar.j(this.kt);
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

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public int az() {
        return com.bykv.vk.openvk.component.video.j.up.j.j(this.tl, this.av);
    }

    public void ch() {
        if (ws.cw(v.getContext()) == 0) {
            return;
        }
        m mVar = this.up;
        if (mVar != null) {
            mVar.j();
        }
        cw(false);
        if (this.f30968r != null) {
            this.tj.j();
            rh();
            this.f30968r.j();
            xq();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public boolean f() {
        return this.f31080z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void g() {
        j(true, 3);
    }

    public boolean hh() {
        com.bykv.vk.openvk.component.video.api.j jVar = this.f30968r;
        return jVar != null && jVar.jy();
    }

    public void hl() {
        if (this.ff) {
            this.ff = false;
            try {
                ch.j(this.xq);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public int jy() {
        if (i() == null) {
            return 0;
        }
        return i().i();
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void m() {
        com.bykv.vk.openvk.component.video.api.j jVar = this.f30968r;
        if (jVar != null) {
            jVar.cw();
        }
        if ((!this.tj.j(64) || q()) && this.tj.j(2)) {
            i.j jVar2 = new i.j();
            jVar2.j(qv());
            jVar2.cw(ws());
            jVar2.xt(vl());
            j(this.up, jVar2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.j.j
    protected Map<String, Object> ol() {
        return this.f31078q;
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void oq() {
        cw(ws() == 0 ? -2 : -1);
        com.bykv.vk.openvk.component.video.api.j jVar = this.f30968r;
        if (jVar != null) {
            jVar.up();
            this.f30968r = null;
        }
        n nVar = this.f30967m;
        int ya = nVar == null ? 2 : nVar.ya();
        boolean z5 = ya > 0 && this.ya == ya;
        if (!uf.cw(this.f30967m) || z5) {
            try {
                this.up.j2(this.f30967m, this.f30964g, true);
            } catch (Exception e6) {
                vl.r("NativeVideoController", e6.getMessage());
            }
        }
        l lVar = this.f30966j;
        if (lVar != null) {
            lVar.removeCallbacksAndMessages(null);
        }
        List<Runnable> list = this.qv;
        if (list != null) {
            list.clear();
        }
        hl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.j.j
    public void rh() {
        if (this.f30964g == null) {
            return;
        }
        this.tj.cw(1);
        com.bytedance.sdk.openadsdk.m.xt.r.j(this.f30967m, this.up, this.f30963f, this.f31071c);
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public boolean tj() {
        return this.f31071c;
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void tl() {
        m mVar = this.up;
        if (mVar != null) {
            mVar.j();
        }
        m mVar2 = this.up;
        if (mVar2 != null) {
            mVar2.x();
        }
        sm();
    }

    protected com.bykv.vk.openvk.component.video.api.renderview.xt v() {
        m mVar;
        WeakReference<Context> weakReference = this.f30964g;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        if ((this.f30964g.get().getResources().getConfiguration().orientation == 1 || com.bytedance.sdk.openadsdk.up.j.j(this.f30967m)) && (mVar = this.up) != null) {
            return mVar.i();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.j.j, com.bykv.vk.openvk.component.video.api.r.cw
    public long vl() {
        if (i() == null) {
            return 0L;
        }
        return i().av();
    }

    public boolean x() {
        com.bykv.vk.openvk.component.video.api.j jVar = this.f30968r;
        return jVar == null || jVar.g();
    }

    public void z() {
        if (this.ff || !this.hl) {
            return;
        }
        this.ff = true;
        ch.j(this.xq, StubApp.getOrigApplicationContext(v.getContext().getApplicationContext()));
    }

    private boolean cw(int i6, int i7) {
        return i6 < i7 && ry();
    }

    private View xt(Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387720);
        relativeLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout2.setId(2114387906);
        relativeLayout2.setBackgroundColor(0);
        relativeLayout2.setGravity(17);
        relativeLayout2.setLayoutParams(layoutParams);
        relativeLayout.addView(relativeLayout2);
        ImageView imageView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        imageView.setId(2114387657);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(layoutParams2);
        relativeLayout2.addView(imageView);
        TTProgressBar tTProgressBar = new TTProgressBar(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        tTProgressBar.setId(2114387637);
        layoutParams3.addRule(13, -1);
        tTProgressBar.setLayoutParams(layoutParams3);
        tTProgressBar.setIndeterminateDrawable(kt.cw(context, "tt_video_loading_progress_bar"));
        relativeLayout2.addView(tTProgressBar);
        View xt = new com.bytedance.sdk.openadsdk.res.layout.video.r().xt(context);
        xt.setId(2114387694);
        xt.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.addView(xt);
        ImageView imageView2 = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        imageView2.setId(2114387632);
        layoutParams4.addRule(13, -1);
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        kt.j(context, "tt_play_movebar_textpage", imageView2);
        imageView2.setVisibility(8);
        imageView2.setLayoutParams(layoutParams4);
        relativeLayout.addView(imageView2);
        TTProgressBar tTProgressBar2 = new TTProgressBar(context, null, kt.tl(context, "tt_Widget_ProgressBar_Horizontal"));
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 1.5f, resources.getDisplayMetrics()));
        tTProgressBar2.setMax(100);
        tTProgressBar2.setId(2114387659);
        tTProgressBar2.setBackgroundColor(0);
        tTProgressBar2.setIndeterminateDrawable(null);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#A5FFFFFF"));
        float cw = ed.cw(context, 1.0f);
        gradientDrawable.setCornerRadius(cw);
        int cw2 = ed.cw(context, 2.0f);
        gradientDrawable.setSize(-1, cw2);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Color.parseColor("#FFFFFFFF"));
        gradientDrawable2.setCornerRadius(cw);
        gradientDrawable2.setSize(-1, cw2);
        ClipDrawable clipDrawable = new ClipDrawable(gradientDrawable2, 3, 1);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(Color.parseColor("#FFF85959"));
        gradientDrawable3.setCornerRadius(cw);
        gradientDrawable3.setSize(-1, cw2);
        tTProgressBar2.setProgressDrawable(new LayerDrawable(new Drawable[]{gradientDrawable, clipDrawable, new ClipDrawable(gradientDrawable3, 3, 1)}));
        tTProgressBar2.setVisibility(8);
        layoutParams5.addRule(12, -1);
        tTProgressBar2.setLayoutParams(layoutParams5);
        relativeLayout.addView(tTProgressBar2);
        View tTViewStub = new TTViewStub(context, new com.bytedance.sdk.openadsdk.res.layout.video.m());
        ViewGroup.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -1);
        tTViewStub.setId(2114387750);
        tTViewStub.setLayoutParams(layoutParams6);
        relativeLayout.addView(tTViewStub);
        View tTViewStub2 = new TTViewStub(context, new com.bytedance.sdk.openadsdk.res.layout.video.xt());
        ViewGroup.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -1);
        tTViewStub2.setId(2114387672);
        tTViewStub2.setLayoutParams(layoutParams7);
        relativeLayout.addView(tTViewStub2);
        View tTViewStub3 = new TTViewStub(context, new com.bytedance.sdk.openadsdk.res.layout.video.ae());
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(13, -1);
        tTViewStub3.setId(2114387834);
        tTViewStub3.setLayoutParams(layoutParams8);
        relativeLayout.addView(tTViewStub3);
        return relativeLayout;
    }

    public void up(int i6) {
        this.f31072e = i6;
    }

    private boolean ae(int i6) {
        m mVar = this.up;
        return mVar != null && mVar.cw(i6);
    }

    private void r(com.bykv.vk.openvk.component.video.api.cw.r rVar) {
        if (rVar == null) {
            j("model is null");
            return;
        }
        final long cw = cw(rVar);
        if (this.f30968r != null) {
            n nVar = this.f30967m;
            if (nVar != null) {
                rVar.r(String.valueOf(uf.g(nVar)));
            }
            rVar.r(0);
            this.f30968r.j(rVar);
            this.f30968r.j(gq());
        }
        this.f31069a = System.currentTimeMillis();
        if (!TextUtils.isEmpty(rVar.av())) {
            m mVar = this.up;
            if (mVar != null) {
                mVar.up(8);
                this.up.up(0);
            }
            boolean cw2 = uf.cw(this.f30967m);
            m mVar2 = this.up;
            boolean xt = mVar2 != null ? com.bytedance.sdk.openadsdk.core.uf.xt(mVar2.f31041j, 50, 9) : true;
            Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.r.3
                @Override // java.lang.Runnable
                public void run() {
                    r.this.tj.j();
                    r.this.rh();
                    r.this.f31069a = System.currentTimeMillis();
                    if (((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).up != null) {
                        ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).up.r(0);
                    }
                    if (((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30968r != null && ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).ae == 0) {
                        ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30968r.j(true, cw, ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30965i);
                    } else if (((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30968r != null) {
                        ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30968r.j(true, ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).ae, ((com.bytedance.sdk.openadsdk.core.video.j.j) r.this).f30965i);
                    }
                }
            };
            if (cw2 && !xt) {
                xt(runnable);
                tl(true);
                WeakReference<j> weakReference = this.nd;
                if (weakReference != null && weakReference.get() != null) {
                    this.nd.get().g();
                }
            } else {
                j(runnable);
            }
        } else {
            j("url is null");
        }
        if (this.vl) {
            z();
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

    @Override // com.bykv.vk.openvk.component.video.api.r.j
    public void up(com.bykv.vk.openvk.component.video.api.r.xt xtVar, View view) {
        j(xtVar, view, false);
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void up(boolean z5) {
        this.hl = z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tl(int i6) {
        n nVar;
        int cw = ws.cw(v.getContext());
        if (cw == 0) {
            m();
            this.az = true;
            m mVar = this.up;
            if (mVar != null) {
                mVar.j2(this.f30967m, this.f30964g, false);
            }
        }
        if (cw != 4 && cw != 0) {
            m mVar2 = this.up;
            if (mVar2 != null) {
                mVar2.j();
            }
            m();
            this.az = true;
            this.uf = false;
            m mVar3 = this.up;
            if (mVar3 != null && (nVar = this.f30967m) != null) {
                return mVar3.j(i6, ln.ws(nVar), this.rn);
            }
        } else if (cw == 4) {
            this.az = false;
            m mVar4 = this.up;
            if (mVar4 != null) {
                mVar4.kt();
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw(Context context, int i6) {
        xt(context, i6);
        if (i6 == 4) {
            this.az = false;
        }
    }

    public void j(n nVar) {
        this.f30967m = nVar;
    }

    public void m(boolean z5) {
        m mVar = this.up;
        if (mVar != null) {
            mVar.j();
        }
        m mVar2 = this.up;
        if (mVar2 != null && z5) {
            mVar2.x();
        }
        sm();
    }

    public void j(com.bytedance.sdk.openadsdk.f.j.xt.j.j jVar) {
        m mVar = this.up;
        if (mVar != null) {
            mVar.j(jVar);
        }
    }

    public void j(final NativeVideoTsView.j jVar) {
        m mVar;
        if (!this.vl || (mVar = this.up) == null) {
            return;
        }
        mVar.j(new NativeVideoTsView.j() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.r.2
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.j
            public void j(View view, int i6) {
                NativeVideoTsView.j jVar2 = jVar;
                if (jVar2 != null) {
                    jVar2.j(view, i6);
                }
            }
        });
    }

    public void j(jy jyVar) {
        m mVar;
        if (!this.vl || (mVar = this.up) == null) {
            return;
        }
        mVar.j(jyVar);
    }

    public void m(int i6) {
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

    public void j(int i6, int i7) {
        if (i6 == 0 || i7 == 0) {
            return;
        }
        this.rh = i6;
        this.ol = i7;
    }

    @SuppressLint({"InflateParams"})
    private void j(Context context) {
        EnumSet<xt.j> noneOf = EnumSet.noneOf(xt.j.class);
        noneOf.add(xt.j.hideCloseBtn);
        noneOf.add(xt.j.hideBackBtn);
        try {
            m j6 = j(context, noneOf);
            this.up = j6;
            if (j6 != null) {
                j6.j((com.bykv.vk.openvk.component.video.api.r.j) this);
                this.up.j((j.InterfaceC0466j) this);
            }
        } catch (Throwable th) {
            vl.r("NativeVideoController", th.getMessage());
        }
    }

    protected m j(Context context, EnumSet<xt.j> enumSet) {
        View layoutVideoDetail;
        if (this.vl) {
            layoutVideoDetail = xt(context);
        } else {
            layoutVideoDetail = new LayoutVideoDetail(context);
        }
        View view = layoutVideoDetail;
        if (view == null) {
            return null;
        }
        if (this.vl) {
            return new m(context, view, true, enumSet, this.f30967m, this, gx(), null);
        }
        return new up(context, view, true, enumSet, this.f30967m, this, false);
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.j
    public void r(com.bykv.vk.openvk.component.video.api.r.xt xtVar, View view) {
        if (this.kt) {
            g(false);
            m mVar = this.up;
            if (mVar != null) {
                mVar.xt(this.f31079s);
            }
            m(1);
            return;
        }
        j(1);
        j(true, 3);
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void j(cw.r rVar) {
        this.f31076n = new WeakReference<>(rVar);
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public boolean j(com.bykv.vk.openvk.component.video.api.cw.r rVar) {
        rVar.av();
        if (TextUtils.isEmpty(rVar.av())) {
            j("url is null");
            vl.r("tag_video_play", "[video] play video stop , because no video info");
            return false;
        }
        this.f30963f = rVar;
        this.f30965i = rVar.qv();
        this.ae = rVar.oq();
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
            if (this.ya == 0) {
                this.up.ae();
            }
            this.up.cw(rVar.tl(), rVar.g());
            this.up.cw(this.f31079s);
            this.up.j(rVar.tl(), rVar.g());
        }
        try {
            if (this.f30968r == null) {
                if (!b()) {
                    j("create video error");
                    return false;
                }
                this.f30968r.j(this.qb);
            }
            s();
            this.f31075l = 0L;
            r(rVar);
            return true;
        } catch (Throwable th) {
            j(th.getMessage());
            vl.r("tag_video_play", "[video] invoke NativeVideoController#playVideo cause exception :" + th.toString());
            return false;
        }
    }

    public r(Context context, ViewGroup viewGroup, n nVar, String str, boolean z5, boolean z6) {
        this.la = "embeded_ad";
        this.gq = false;
        this.rn = true;
        this.rh = 0;
        this.ol = 0;
        this.f31074k = 1;
        this.f31074k = ws.cw(context);
        try {
            this.rh = viewGroup.getWidth();
            this.ol = viewGroup.getHeight();
        } catch (Throwable unused) {
        }
        this.f31079s = viewGroup;
        this.la = str;
        this.f30964g = new WeakReference<>(context);
        this.f30967m = nVar;
        j(context);
        this.f31073h = true;
        this.gq = z5;
        this.rn = z6;
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void r(boolean z5) {
        this.f31071c = z5;
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void j(cw.xt xtVar) {
        this.wq = new WeakReference<>(xtVar);
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void j(cw.j jVar) {
        this.f31077p = jVar;
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void j(Map<String, Object> map) {
        com.bykv.vk.openvk.component.video.api.j jVar = this.f30968r;
        if (jVar != null) {
            jVar.cw();
        }
        if ((!this.tj.j(64) || q()) && this.tj.j(2)) {
            i.j jVar2 = new i.j();
            jVar2.j(qv());
            jVar2.cw(ws());
            jVar2.xt(vl());
            if (map != null) {
                jVar2.j(map);
            }
            j(this.up, jVar2);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void j(long j6) {
        this.ae = j6;
        long j7 = this.tl;
        if (j7 > j6) {
            j6 = j7;
        }
        this.tl = j6;
        m mVar = this.up;
        if (mVar != null) {
            mVar.j();
        }
        com.bykv.vk.openvk.component.video.api.j jVar = this.f30968r;
        if (jVar != null) {
            jVar.j(true, this.ae, this.f30965i);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void j(boolean z5, int i6) {
        if (this.vl) {
            j(1);
        }
        long ws = ws();
        if ((!this.tj.j(64) || q()) && this.tj.j(1) && ws > 0) {
            if (z5) {
                i.j jVar = new i.j();
                jVar.j(qv());
                jVar.cw(ws);
                jVar.xt(vl());
                jVar.up(i6);
                jVar.m(jy());
                this.tj.cw(32);
                com.bytedance.sdk.openadsdk.m.xt.r.j(this.up, jVar, this.f31078q, !this.tj.j(2) ? 1 : 0);
            } else {
                i.j jVar2 = new i.j();
                jVar2.j(qv());
                jVar2.cw(ws);
                jVar2.xt(vl());
                j(this.up, jVar2);
            }
        }
        oq();
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void xt(Map<String, Object> map) {
        this.f31078q = map;
    }

    protected void xt(int i6, int i7) {
        com.bykv.vk.openvk.component.video.api.j jVar;
        ViewGroup viewGroup;
        int i8;
        int i9;
        ViewGroup.LayoutParams layoutParams;
        try {
            WeakReference<Context> weakReference = this.f30964g;
            if (weakReference != null && weakReference.get() != null && v() != null && (jVar = this.f30968r) != null && (viewGroup = this.f31079s) != null && viewGroup != null) {
                if (i6 < 0 && i7 < 0) {
                    i6 = jVar.qv();
                    i7 = this.f30968r.vl();
                }
                int width = this.f31079s.getWidth();
                int height = this.f31079s.getHeight();
                if (width > 0 && height > 0 && i7 > 0 && i6 > 0) {
                    if (i6 == i7) {
                        i9 = width > height ? height : width;
                        i8 = i9;
                    } else if (i6 > i7) {
                        i8 = (int) Math.round((width * 1.0d) / ((i6 * 1.0f) / i7));
                        i9 = width;
                    } else if (ff()) {
                        i8 = 0;
                        i9 = 0;
                    } else {
                        i9 = (int) Math.round((height * 1.0f) / ((i7 * 1.0f) / i6));
                        i8 = height;
                    }
                    if (i8 > height || i8 <= 0) {
                        i8 = height;
                    }
                    if (xt(i6, i7, i9, width)) {
                        i9 = width;
                    }
                    if (ff()) {
                        j(i6, i7, width, height);
                        return;
                    }
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i9, i8);
                    layoutParams2.addRule(13);
                    Object v5 = v();
                    if (v5 instanceof TextureView) {
                        ((TextureView) v5).setLayoutParams(layoutParams2);
                    } else if (v5 instanceof UpieVideoView) {
                        ((UpieVideoView) v5).setLayoutParams(layoutParams2);
                    } else if (v5 instanceof SurfaceView) {
                        ((SurfaceView) v5).setLayoutParams(layoutParams2);
                    }
                    if (!cw(i6, i7) || (layoutParams = this.f31079s.getLayoutParams()) == null) {
                        return;
                    }
                    layoutParams.height = i8;
                    layoutParams.width = i9;
                    this.f31079s.setLayoutParams(layoutParams);
                    m mVar = this.up;
                    if (mVar != null) {
                        mVar.j(layoutParams.width, layoutParams.height);
                        return;
                    }
                    return;
                }
                return;
            }
            WeakReference<Context> weakReference2 = this.f30964g;
            if (weakReference2 != null) {
                weakReference2.get();
            }
            v();
        } catch (Throwable unused) {
        }
    }

    private void j(int i6, int i7, int i8, int i9) {
        Matrix matrix;
        if (i8 == 0 || i9 == 0) {
            return;
        }
        float f6 = i8;
        float f7 = i6;
        float f8 = f6 / f7;
        float f9 = i9;
        float f10 = i7;
        float f11 = f9 / f10;
        try {
            Object v5 = v();
            if (v5 instanceof TextureView) {
                matrix = ((TextureView) v5).getMatrix();
            } else if (v5 instanceof UpieVideoView) {
                matrix = ((UpieVideoView) v5).getMatrix();
            } else {
                matrix = v5 instanceof SurfaceView ? ((SurfaceView) v5).getMatrix() : null;
            }
            float max = Math.max(f8, f11);
            if (matrix == null) {
                matrix = new Matrix();
            } else {
                matrix.reset();
            }
            matrix.preTranslate((i8 - i6) / 2, (i9 - i7) / 2);
            matrix.preScale(f7 / f6, f10 / f9);
            matrix.postScale(max, max, i8 / 2, i9 / 2);
            if (v5 instanceof TextureView) {
                ((TextureView) v5).setTransform(matrix);
                ((TextureView) v5).postInvalidate();
            } else if (v5 instanceof UpieVideoView) {
                if (Build.VERSION.SDK_INT >= 29) {
                    ((UpieVideoView) v5).setAnimationMatrix(matrix);
                }
                ((UpieVideoView) v5).postInvalidate();
            } else if (v5 instanceof SurfaceView) {
                if (Build.VERSION.SDK_INT >= 29) {
                    ((SurfaceView) v5).setAnimationMatrix(matrix);
                }
                ((SurfaceView) v5).postInvalidate();
            }
        } catch (Exception unused) {
        }
    }

    private boolean xt(int i6, int i7, int i8, int i9) {
        return (i8 > i9 && !cw(i6, i7)) || i8 <= 0;
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
        this.av = j7;
        m mVar = this.up;
        if (mVar != null) {
            mVar.j(j6, j7);
            this.up.xt(com.bykv.vk.openvk.component.video.j.up.j.j(j6, j7));
        }
        try {
            cw.j jVar = this.f31077p;
            if (jVar != null) {
                jVar.j(j6, j7);
            }
        } catch (Throwable th) {
            vl.cw("NativeVideoController", "onProgressUpdate error: ", th);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.j
    public void j(com.bykv.vk.openvk.component.video.api.r.xt xtVar, View view) {
        if (this.f30968r == null || !l()) {
            return;
        }
        if (this.f30968r.jy()) {
            m();
            m mVar = this.up;
            if (mVar != null) {
                mVar.xt(true, false);
                this.up.m();
                return;
            }
            return;
        }
        if (!this.f30968r.ws()) {
            m mVar2 = this.up;
            if (mVar2 != null) {
                mVar2.cw(this.f31079s);
            }
            j(this.ae);
            m mVar3 = this.up;
            if (mVar3 != null) {
                mVar3.xt(false, false);
                return;
            }
            return;
        }
        m(false);
        m mVar4 = this.up;
        if (mVar4 != null) {
            mVar4.xt(false, false);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.j
    public void xt(com.bykv.vk.openvk.component.video.api.r.xt xtVar, View view) {
        xt(xtVar, view, false, false);
    }

    public void xt(com.bykv.vk.openvk.component.video.api.r.xt xtVar, View view, boolean z5, boolean z6) {
        if (l()) {
            g(!this.kt);
            if (this.f30964g.get() instanceof Activity) {
                if (this.kt) {
                    m(z5 ? 8 : 0);
                    m mVar = this.up;
                    if (mVar != null) {
                        mVar.j(this.f31079s);
                        this.up.cw(false);
                    }
                } else {
                    m(1);
                    m mVar2 = this.up;
                    if (mVar2 != null) {
                        mVar2.xt(this.f31079s);
                        this.up.cw(false);
                    }
                }
                WeakReference<cw.xt> weakReference = this.wq;
                cw.xt xtVar2 = weakReference != null ? weakReference.get() : null;
                if (xtVar2 != null) {
                    xtVar2.j(this.kt);
                }
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.j
    public void j(com.bykv.vk.openvk.component.video.api.r.xt xtVar, int i6) {
        if (this.f30968r == null) {
            return;
        }
        j(this.sm, ae(i6));
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.j
    public void j(com.bykv.vk.openvk.component.video.api.r.xt xtVar, int i6, boolean z5) {
        if (l()) {
            long j6 = (long) (((i6 * r0) * 1.0f) / 100.0f);
            if (this.av > 0) {
                this.sm = (int) j6;
            } else {
                this.sm = 0L;
            }
            m mVar = this.up;
            if (mVar != null) {
                mVar.j(this.sm);
            }
        }
    }

    private void xt(Context context, int i6) {
        if (!l() || context == null || this.f31074k == i6) {
            return;
        }
        this.f31074k = i6;
        if (i6 != 4 && i6 != 0) {
            this.uf = false;
        }
        if (!this.uf && !kt() && this.gq) {
            tl.xt().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.r.7
                @Override // java.lang.Runnable
                public void run() {
                    r.this.tl(2);
                }
            });
        }
        WeakReference<j> weakReference = this.nd;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.nd.get().j(this.f31074k);
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.j
    public void j(com.bykv.vk.openvk.component.video.api.r.xt xtVar, View view, boolean z5, boolean z6) {
        if (this.vl) {
            m();
        }
        if (this.up == null) {
            return;
        }
        if (z5 && !this.vl && !x()) {
            this.up.xt(!hh(), false);
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

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void xt(com.bykv.vk.openvk.component.video.api.cw.r rVar) {
        this.f30963f = rVar;
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void xt() {
        if (this.f30968r != null) {
            cw(false);
            this.f30968r.j();
        }
    }

    public void j(com.bykv.vk.openvk.component.video.api.r.xt xtVar, View view, boolean z5) {
        zz();
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.j
    public void j() {
        if (ws.cw(v.getContext()) == 0) {
            return;
        }
        this.gx = true;
        if (this.f30968r == null) {
            oq();
            kc();
        } else {
            oq();
        }
    }

    private void j(long j6, boolean z5) {
        if (this.f30968r == null) {
            return;
        }
        if (z5) {
            aq();
        }
        this.f30968r.j(j6);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.xt
    public void j(az.j jVar, String str) {
        int i6 = AnonymousClass9.f31098j[jVar.ordinal()];
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
            this.uf = true;
        }
    }

    public void j(Context context, int i6) {
        xt(context, i6);
        if (i6 == 4) {
            this.az = false;
            tl.xt().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.r.8
                @Override // java.lang.Runnable
                public void run() {
                    r.this.tl();
                }
            });
        }
    }

    public void j(j jVar) {
        this.nd = new WeakReference<>(jVar);
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void j(int i6) {
        if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(this.f30967m)) {
            if (this.f31070b <= 0) {
                this.f31070b = System.currentTimeMillis();
            }
            long currentTimeMillis = System.currentTimeMillis() - this.f31070b;
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
                if (this.la.equals("embeded_ad")) {
                    com.bytedance.sdk.openadsdk.core.jy.cw.j(this.f30967m, "embeded_ad", currentTimeMillis, jSONObject, com.bytedance.sdk.openadsdk.m.xt.r.j(this.up));
                } else if (this.la.equals("draw_ad")) {
                    com.bytedance.sdk.openadsdk.core.jy.cw.j(this.f30967m, "draw_ad", currentTimeMillis, jSONObject, com.bytedance.sdk.openadsdk.m.xt.r.j(this.up));
                }
            }
            if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(this.f30967m)) {
                if (com.bytedance.sdk.openadsdk.core.live.xt.j().j(this.f30967m)) {
                    com.bytedance.sdk.openadsdk.core.live.xt.j().j(v0.a.f54681c, this.f30967m, currentTimeMillis);
                } else {
                    com.bytedance.sdk.openadsdk.core.video.cw.j.j(v0.a.f54681c, this.f30967m, currentTimeMillis);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i6, String str) {
        if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(this.f30967m)) {
            if (this.la.equals("embeded_ad")) {
                com.bytedance.sdk.openadsdk.core.jy.cw.j(this.f30967m, "embeded_ad", i6, str, com.bytedance.sdk.openadsdk.m.xt.r.j(this.up));
            } else if (this.la.equals("draw_ad")) {
                com.bytedance.sdk.openadsdk.core.jy.cw.j(this.f30967m, "draw_ad", i6, str, com.bytedance.sdk.openadsdk.m.xt.r.j(this.up));
            }
        }
    }
}
