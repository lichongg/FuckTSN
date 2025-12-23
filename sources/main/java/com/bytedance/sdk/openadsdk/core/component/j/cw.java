package com.bytedance.sdk.openadsdk.core.component.j;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.work.WorkRequest;
import com.bykv.vk.openvk.component.video.api.r.cw;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.utils.ws;
import com.bytedance.sdk.openadsdk.core.f.r;
import com.bytedance.sdk.openadsdk.core.live.EcMallWebView;
import com.bytedance.sdk.openadsdk.core.multipro.xt.j;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.rn.rn;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.ed;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.i.cw.xt.jy;
import com.bytedance.sdk.openadsdk.l.ae;
import com.bytedance.sdk.openadsdk.m.cw.i;
import com.bytedance.sdk.openadsdk.mediation.MediationNativeManagerDefault;
import com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.up;
import com.bytedance.sdk.openadsdk.res.layout.LazeLayout;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends com.bytedance.sdk.openadsdk.i.cw.xt implements cw.InterfaceC0306cw, cw.r, com.bykv.vk.openvk.component.video.api.xt.j, j.InterfaceC0466j, LazeLayout.j<NativeVideoTsView>, com.bytedance.sdk.openadsdk.res.layout.j<NativeVideoTsView> {
    private int ae;
    private n av;
    private volatile boolean az;
    int cw;

    /* renamed from: g, reason: collision with root package name */
    private boolean f28026g;

    /* renamed from: i, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.ch.j.xt.j.j f28027i;

    /* renamed from: j, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.multipro.xt.j f28028j;
    private com.bytedance.sdk.openadsdk.v.j.xt.j.xt jy;

    /* renamed from: m, reason: collision with root package name */
    private r f28029m;
    private LazeLayout oq;
    private volatile WeakReference<NativeVideoTsView> qv;

    /* renamed from: r, reason: collision with root package name */
    private int[] f28030r;
    private com.bytedance.sdk.openadsdk.v.j.xt.xt.j tl;
    private com.bytedance.sdk.openadsdk.v.j.xt.j.j up;
    private WeakReference<View> vl;
    private volatile int ws;
    com.bytedance.sdk.openadsdk.i.cw.cw.xt xt;

    cw(Context context, n nVar, int i6, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        super(new r(context, nVar, i6, xtVar, true));
        this.f28030r = null;
        this.f28026g = false;
        this.oq = null;
        this.qv = null;
        this.vl = null;
        this.f28027i = new com.bytedance.sdk.openadsdk.ch.j.xt.j.j(null) { // from class: com.bytedance.sdk.openadsdk.core.component.j.cw.4
            @Override // com.bytedance.sdk.openadsdk.ch.j.xt.j.j
            public void j(jy jyVar) {
            }

            @Override // com.bytedance.sdk.openadsdk.ch.j.xt.j.j
            public void j(View view, jy jyVar) {
                if (cw.this.qv == null || cw.this.qv.get() == null) {
                    return;
                }
                ((NativeVideoTsView) cw.this.qv.get()).oq();
            }

            @Override // com.bytedance.sdk.openadsdk.ch.j.xt.j.j
            public void xt(View view, jy jyVar) {
                if (cw.this.qv == null || cw.this.qv.get() == null) {
                    return;
                }
                ((NativeVideoTsView) cw.this.qv.get()).oq();
            }
        };
        r rVar = (r) gq();
        this.f28029m = rVar;
        rVar.r().j(this);
        this.cw = i6;
        this.xt = xtVar;
        this.f28028j = new com.bytedance.sdk.openadsdk.core.multipro.xt.j();
        this.av = nVar;
        int g6 = uf.g(nVar);
        this.ae = g6;
        j(g6);
        this.f28029m.j(this.f28027i);
    }

    private View rn() {
        View view;
        WeakReference<View> weakReference = this.vl;
        if (weakReference != null && (view = weakReference.get()) != null) {
            return view;
        }
        EcMallWebView ecMallWebView = new EcMallWebView(this.f28029m.getContext(), this.f28029m.s(), this.cw == 9 ? 6 : 1);
        ecMallWebView.setMaterialMeta(rn.j(this.av));
        this.vl = new WeakReference<>(ecMallWebView);
        return ecMallWebView;
    }

    private boolean uf() {
        if (this.f28029m.s() == null || this.jy == null) {
            return false;
        }
        int ff = this.f28029m.s().ff();
        return ff == 1 || ff == 2;
    }

    private int[] wq() {
        if (this.f28029m.s() == null) {
            return null;
        }
        if (this.f28029m.s().ve() == 166 && ed.j(this.f28029m.s())) {
            return new int[]{ed.vl(this.f28029m.s()), ed.jy(this.f28029m.s())};
        }
        if (this.f28029m.s().ly() == 1 && this.f28029m.s().qg() == 1 && ln.az(this.f28029m.s()) != null) {
            return ln.az(this.f28029m.s()).oq();
        }
        if (ln.ws(this.f28029m.s()) != null) {
            return ln.ws(this.f28029m.s()).oq();
        }
        return null;
    }

    public int a() {
        return this.cw;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public up ch() {
        return new MediationNativeManagerDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.oq
    public int cw() {
        r rVar = this.f28029m;
        if (rVar != null) {
            n s5 = rVar.s();
            int i6 = this.f28029m.i();
            if (com.bytedance.sdk.openadsdk.up.j.tl(s5) && (i6 == 5 || i6 == 15)) {
                return s5.fp().get(0).xt();
            }
        }
        try {
            if (this.f28030r == null) {
                this.f28030r = wq();
            }
            int[] iArr = this.f28030r;
            if (iArr != null && iArr.length >= 2) {
                return iArr[0];
            }
            return PredefinedCaptureConfigurations.f35648o;
        } catch (Throwable th) {
            vl.cw("TTFeedAdImpl", "getAdViewWidth error", th);
            return PredefinedCaptureConfigurations.f35648o;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt, com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public Map<String, Object> f() {
        Map<String, Object> f6 = this.f28029m.f();
        if (this.f28029m.s() != null && this.f28029m.s().ve() == 166 && com.bytedance.sdk.openadsdk.core.video.cw.j.j(this.f28029m.s())) {
            int r5 = ed.r(this.f28029m.s());
            int up = ed.up(this.f28029m.s());
            if (f6 == null) {
                f6 = new HashMap<>();
            }
            f6.put("live_author_follower_count", Integer.valueOf(r5));
            f6.put("live_watch_count", Integer.valueOf(up));
        }
        return f6;
    }

    boolean h() {
        return n.xt(this.f28029m.s());
    }

    public int l() {
        return this.ae;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.xt.j.InterfaceC0466j
    public com.bytedance.sdk.openadsdk.core.multipro.xt.j la() {
        return this.f28028j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.xt.j.InterfaceC0466j
    public boolean p() {
        return this.f28026g;
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw.r
    public void p_() {
        com.bytedance.sdk.openadsdk.v.j.xt.j.j jVar = this.up;
        if (jVar != null) {
            jVar.j(this);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw.InterfaceC0306cw
    public void q_() {
        com.bytedance.sdk.openadsdk.v.j.xt.j.j jVar = this.up;
        if (jVar != null) {
            jVar.xt(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.oq
    public int r() {
        r rVar = this.f28029m;
        if (rVar != null) {
            n s5 = rVar.s();
            int i6 = this.f28029m.i();
            if (com.bytedance.sdk.openadsdk.up.j.tl(s5) && (i6 == 5 || i6 == 15)) {
                return s5.fp().get(0).cw();
            }
        }
        try {
            if (this.f28030r == null) {
                this.f28030r = wq();
            }
            int[] iArr = this.f28030r;
            if (iArr != null && iArr.length >= 2) {
                return iArr[1];
            }
            return PredefinedCaptureConfigurations.f35647n;
        } catch (Throwable th) {
            vl.cw("TTFeedAdImpl", "getAdViewHeight error", th);
            return PredefinedCaptureConfigurations.f35647n;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw.InterfaceC0306cw
    public void r_() {
        com.bytedance.sdk.openadsdk.v.j.xt.j.j jVar = this.up;
        if (jVar != null) {
            jVar.cw(this);
        }
    }

    public NativeVideoTsView s() {
        if (this.qv != null) {
            return this.qv.get();
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw.InterfaceC0306cw
    public void s_() {
        com.bytedance.sdk.openadsdk.v.j.xt.j.j jVar = this.up;
        if (jVar != null) {
            jVar.r(this);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw.InterfaceC0306cw
    public void t_() {
        com.bytedance.sdk.openadsdk.v.j.xt.j.j jVar = this.up;
        if (jVar != null) {
            jVar.up(this);
        }
        if (!uf() || this.az) {
            return;
        }
        this.jy.j(0);
        this.az = true;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt, com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public View tj() {
        NativeVideoTsView nativeVideoTsView;
        NativeVideoTsView nativeVideoTsView2 = null;
        if (this.f28029m.s() == null || this.f28029m.getContext() == null) {
            return null;
        }
        if (com.bytedance.sdk.openadsdk.core.live.up.r.j(this.f28029m.s())) {
            return rn();
        }
        Context context = this.f28029m.getContext();
        if (!h()) {
            n s5 = this.f28029m.s();
            if (context != null && s5 != null && com.bytedance.sdk.openadsdk.up.j.tl(this.f28029m.s())) {
                return new UpieImageView(context, com.bytedance.sdk.openadsdk.up.j.g(s5), null);
            }
        } else {
            if (!ae.j() || !v.xt().fk().xt) {
                try {
                    nativeVideoTsView2 = xt(context);
                } catch (Throwable unused) {
                }
                if (nativeVideoTsView2 != null) {
                    j(nativeVideoTsView2);
                }
                return nativeVideoTsView2;
            }
            if (this.qv != null && (nativeVideoTsView = this.qv.get()) != null) {
                return nativeVideoTsView;
            }
            this.oq = new LazeLayout(context, this, this);
        }
        com.bytedance.sdk.openadsdk.core.ae.r.j().j(this.f28029m.s()).j(this.cw).xt(this.ae);
        return this.oq;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt, com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void x() {
        NativeVideoTsView nativeVideoTsView;
        if (this.qv != null && (nativeVideoTsView = this.qv.get()) != null) {
            nativeVideoTsView.mi();
        }
        LazeLayout lazeLayout = this.oq;
        if (lazeLayout != null) {
            lazeLayout.j();
        }
        super.x();
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.oq
    public com.bytedance.sdk.openadsdk.v.j.xt.xt.j xt() {
        if (!n.j(this.f28029m.s())) {
            return null;
        }
        if (this.tl == null) {
            this.tl = new com.bytedance.sdk.openadsdk.v.j.xt.xt.j() { // from class: com.bytedance.sdk.openadsdk.core.component.j.cw.3
                private long xt = 0;

                @Override // com.bytedance.sdk.openadsdk.v.j.xt.xt.j
                public void cw() {
                    if (this.xt == 0) {
                        this.xt = SystemClock.elapsedRealtime();
                    }
                    long j6 = ((long) cw.this.j()) * 1000;
                    long elapsedRealtime = (SystemClock.elapsedRealtime() - this.xt) - j6;
                    long j7 = elapsedRealtime >= 0 ? elapsedRealtime : 0L;
                    i.j jVar = new i.j();
                    jVar.j(j6);
                    jVar.cw(j6);
                    jVar.xt(j7);
                    jVar.m(0);
                    jVar.j(true);
                    com.bytedance.sdk.openadsdk.m.xt.r.r(cw.this, jVar);
                }

                @Override // com.bytedance.sdk.openadsdk.v.j.xt.xt.j
                public String j() {
                    if (cw.this.f28029m.s() == null || cw.this.f28029m.s().ol() != 1 || ln.ws(cw.this.f28029m.s()) == null) {
                        return null;
                    }
                    if (!cw.this.f28026g) {
                        cw.this.f28026g = true;
                    }
                    return ln.j(cw.this.f28029m.s());
                }

                @Override // com.bytedance.sdk.openadsdk.v.j.xt.xt.j
                public void xt() {
                    this.xt = SystemClock.elapsedRealtime();
                    i.j jVar = new i.j();
                    jVar.xt(true);
                    jVar.j(true);
                    com.bytedance.sdk.openadsdk.m.xt.r.j(cw.this, jVar);
                }

                @Override // com.bytedance.sdk.openadsdk.v.j.xt.xt.j
                public void r() {
                    com.bytedance.sdk.openadsdk.core.jy.cw.j(cw.this.f28029m.s(), uf.xt(cw.this.f28029m.s()), "feed_auto_play", 0L, 0, (Map<String, Object>) null);
                    if (ln.ws(cw.this.f28029m.s()) != null) {
                        com.bykv.vk.openvk.component.video.api.cw.r j6 = ln.j(4, cw.this.f28029m.s());
                        j6.j("material_meta", cw.this.f28029m.s());
                        com.bytedance.sdk.openadsdk.i.cw.cw.xt rr = cw.this.f28029m.s().rr();
                        j6.j("ad_slot", Integer.valueOf(rr != null ? rr.kt() : 0));
                        j6.up(-1);
                        com.bytedance.sdk.openadsdk.m.xt.r.j(cw.this.f28029m.s(), (com.bykv.vk.openvk.component.video.api.xt.j) cw.this, j6, true);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.v.j.xt.xt.j
                public void xt(long j6) {
                    if (this.xt == 0) {
                        this.xt = SystemClock.elapsedRealtime();
                    }
                    long elapsedRealtime = (SystemClock.elapsedRealtime() - this.xt) - j6;
                    long j7 = elapsedRealtime >= 0 ? elapsedRealtime : 0L;
                    i.j jVar = new i.j();
                    jVar.j(j6);
                    jVar.cw(((long) cw.this.j()) * 1000);
                    jVar.xt(j7);
                    jVar.j(true);
                    com.bytedance.sdk.openadsdk.m.xt.r.xt(cw.this, jVar);
                }

                @Override // com.bytedance.sdk.openadsdk.v.j.xt.xt.j
                public void j(long j6) {
                    if (this.xt == 0) {
                        this.xt = SystemClock.elapsedRealtime();
                    }
                    long elapsedRealtime = (SystemClock.elapsedRealtime() - this.xt) - j6;
                    long j7 = elapsedRealtime >= 0 ? elapsedRealtime : 0L;
                    i.j jVar = new i.j();
                    jVar.j(j6);
                    jVar.cw(((long) cw.this.j()) * 1000);
                    jVar.xt(j7);
                    jVar.j(true);
                    com.bytedance.sdk.openadsdk.m.xt.r.j(cw.this, jVar, -1);
                }

                @Override // com.bytedance.sdk.openadsdk.v.j.xt.xt.j
                public void cw(long j6) {
                    if (this.xt == 0) {
                        this.xt = SystemClock.elapsedRealtime();
                    }
                    long j7 = ((long) cw.this.j()) * 1000;
                    long elapsedRealtime = (SystemClock.elapsedRealtime() - this.xt) - j6;
                    long j8 = elapsedRealtime >= 0 ? elapsedRealtime : 0L;
                    i.j jVar = new i.j();
                    jVar.j(j6);
                    jVar.cw(j7);
                    jVar.xt(j8);
                    jVar.up(0);
                    jVar.m(0);
                    jVar.j(true);
                    com.bytedance.sdk.openadsdk.m.xt.r.j(cw.this, jVar, (Map<String, Object>) null, -1);
                }

                @Override // com.bytedance.sdk.openadsdk.v.j.xt.xt.j
                public void j(int i6, int i7) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("creative_id", cw.this.f28029m.s().fs());
                    hashMap.put("error_code", Integer.valueOf(i6));
                    hashMap.put("extra_error_code", Integer.valueOf(i7));
                    hashMap.put("is_customer", 1);
                    com.bykv.vk.openvk.component.video.api.cw.cw ws = ln.ws(cw.this.f28029m.s());
                    if (ws != null) {
                        hashMap.put("video_size", Long.valueOf(ws.up()));
                        hashMap.put("video_resolution", ws.g());
                    }
                    com.bytedance.sdk.openadsdk.core.jy.cw.cw(cw.this.f28029m.s(), uf.xt(cw.this.f28029m.s()), "play_start_error", hashMap);
                }

                @Override // com.bytedance.sdk.openadsdk.v.j.xt.xt.j
                public void j(long j6, int i6, int i7) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    if (this.xt == 0) {
                        this.xt = elapsedRealtime;
                    }
                    long j7 = elapsedRealtime - this.xt;
                    long j8 = ((long) cw.this.j()) * 1000;
                    long j9 = j7 - j6;
                    if (j9 < 0) {
                        j9 = 0;
                    }
                    int i8 = j7 == 0 ? 1 : 0;
                    i.j jVar = new i.j();
                    jVar.xt(j9);
                    jVar.cw(j8);
                    jVar.j(j6);
                    jVar.j(i6);
                    jVar.xt(i7);
                    jVar.j(true);
                    com.bytedance.sdk.openadsdk.m.xt.r.j(cw.this, jVar, "customer error", i8, false);
                }
            };
        }
        return this.tl;
    }

    public NativeVideoTsView j(boolean z5) {
        NativeVideoTsView nativeVideoTsView;
        if (z5) {
            nativeVideoTsView = new NativeDrawVideoTsView(this.f28029m.getContext(), this.f28029m.s());
        } else {
            nativeVideoTsView = new NativeVideoTsView(this.f28029m.getContext(), this.f28029m.s(), false, false, uf.xt(this.cw), false, false);
        }
        this.qv = new WeakReference<>(nativeVideoTsView);
        this.f28029m.j(this.qv);
        this.f28029m.xt();
        return nativeVideoTsView;
    }

    private void xt(long j6, long j7) {
        int i6;
        if (uf() && !this.az) {
            int ff = this.f28029m.s().ff();
            long j8 = ff == 1 ? 15000L : ff == 2 ? WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS : 0L;
            if (j7 <= j8) {
                i6 = (int) ((j7 - j6) / 1000);
            } else {
                i6 = (int) ((j8 - j6) / 1000);
            }
            if (i6 < 0) {
                i6 = 0;
            }
            if (i6 == this.ws) {
                return;
            }
            this.ws = i6;
            if (this.ws == 0) {
                this.az = true;
            }
            this.jy.j(this.ws);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.res.layout.j
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public NativeVideoTsView xt(Context context) {
        NativeVideoTsView j6 = j(false);
        j6.setVideoAdClickListenerTTNativeAd(this);
        j6.setAdCreativeClickListener(new NativeVideoTsView.j() { // from class: com.bytedance.sdk.openadsdk.core.component.j.cw.1
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.j
            public void j(View view, int i6) {
                if (cw.this.f28029m.r() != null) {
                    cw.this.f28029m.r().j(view, i6);
                }
            }
        });
        oq.i().j(-1L);
        j6.setControllerStatusCallBack(new NativeVideoTsView.r() { // from class: com.bytedance.sdk.openadsdk.core.component.j.cw.2
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.r
            public void j(boolean z5, long j7, long j8, long j9, boolean z6, boolean z7) {
                com.bytedance.sdk.openadsdk.core.multipro.xt.j jVar = cw.this.f28028j;
                if (jVar != null) {
                    jVar.f29581j = z5;
                    jVar.up = j7;
                    jVar.f29582m = j8;
                    jVar.ae = j9;
                    jVar.f29583r = z6;
                    jVar.tl = z7;
                }
            }
        });
        j6.setVideoAdLoadListener(this);
        j6.setVideoAdInteractionListener(this);
        if (5 == this.cw) {
            j6.setIsAutoPlay(this.f28029m.l() ? this.xt.up() : this.f28029m.a());
        } else {
            j6.setIsAutoPlay(this.f28029m.a());
        }
        j6.setIsQuiet(v.xt().r(this.ae));
        com.bytedance.sdk.openadsdk.core.qv.xt.cw j7 = this.f28029m.r().j();
        if (j7 != null) {
            j7.j(this);
        }
        return j6;
    }

    @Override // com.bytedance.sdk.openadsdk.res.layout.LazeLayout.j
    public void j(NativeVideoTsView nativeVideoTsView) {
        if (nativeVideoTsView != null) {
            nativeVideoTsView.j(0L, true, false);
        }
    }

    private void j(int i6) {
        int ae = v.xt().ae(i6);
        if (3 == ae) {
            this.f28029m.xt(false);
            this.f28029m.j(false);
            return;
        }
        if (1 == ae && ws.r(this.f28029m.getContext())) {
            this.f28029m.xt(false);
        } else if (2 == ae) {
            if (!ws.up(this.f28029m.getContext()) && !ws.r(this.f28029m.getContext()) && !ws.m(this.f28029m.getContext())) {
                return;
            } else {
                this.f28029m.xt(false);
            }
        } else if (4 == ae) {
            this.f28029m.xt(true);
            return;
        } else {
            if (5 != ae) {
                return;
            }
            if (!ws.r(this.f28029m.getContext()) && !ws.m(this.f28029m.getContext())) {
                return;
            }
        }
        this.f28029m.j(true);
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.oq
    public void j(com.bytedance.sdk.openadsdk.v.j.xt.j.j jVar) {
        this.up = jVar;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.oq
    public double j() {
        if (com.bytedance.sdk.openadsdk.l.oq.j(this.f28029m.s())) {
            return 0.0d;
        }
        return ln.m(this.f28029m.s());
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.oq
    public void j(com.bytedance.sdk.openadsdk.v.j.xt.j.xt xtVar) {
        this.jy = xtVar;
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw.r
    public void j(int i6, int i7) {
        com.bytedance.sdk.openadsdk.v.j.xt.j.j jVar = this.up;
        if (jVar != null) {
            jVar.j(i6, i7);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw.InterfaceC0306cw
    public void j(long j6, long j7) {
        com.bytedance.sdk.openadsdk.v.j.xt.j.j jVar = this.up;
        if (jVar != null) {
            jVar.j(j6, j7);
        }
        xt(j6, j7);
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void j(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.ch.j.xt.j.j jVar, com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j.r rVar) {
        View tj;
        try {
            j(viewGroup, (List<View>) null, list, list2, list3, (View) null, jVar);
            if (rVar != null) {
                View findViewById = viewGroup.findViewById(rVar.vl());
                if (findViewById != null && m() != null) {
                    findViewById.setVisibility(0);
                    if (findViewById instanceof ViewGroup) {
                        ((ViewGroup) findViewById).removeAllViews();
                        ImageView imageView = new ImageView(viewGroup.getContext());
                        imageView.setImageBitmap(m());
                        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                        layoutParams.width = com.bytedance.sdk.openadsdk.core.rn.ed.cw(viewGroup.getContext(), 38.0f);
                        layoutParams.height = com.bytedance.sdk.openadsdk.core.rn.ed.cw(viewGroup.getContext(), 38.0f);
                        findViewById.setLayoutParams(layoutParams);
                        ((ViewGroup) findViewById).addView(imageView, -1, -1);
                    } else if (findViewById instanceof ImageView) {
                        ((ImageView) findViewById).setImageBitmap(m());
                    }
                }
                FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(rVar.ae());
                if (frameLayout != null && (tj = tj()) != null) {
                    com.bytedance.sdk.openadsdk.core.rn.ed.tl(tj);
                    frameLayout.removeAllViews();
                    frameLayout.addView(tj, -1, -1);
                }
            }
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public void j(com.bytedance.sdk.openadsdk.ch.j.xt.j.xt xtVar) {
        r rVar = this.f28029m;
        if (rVar != null) {
            rVar.j(xtVar);
        }
    }
}
