package com.bytedance.sdk.openadsdk.core.component.splash.r;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.av.j;
import com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn;
import com.bytedance.sdk.openadsdk.core.component.splash.TsView;
import com.bytedance.sdk.openadsdk.core.component.splash.ae;
import com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.r;
import com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae;
import com.bytedance.sdk.openadsdk.core.component.splash.cw.j.g;
import com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m;
import com.bytedance.sdk.openadsdk.core.component.splash.cw.j.tl;
import com.bytedance.sdk.openadsdk.core.component.splash.up;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.qv.xt.cw;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.j;
import com.bytedance.sdk.openadsdk.core.rn.rn;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.ff;
import com.bytedance.sdk.openadsdk.core.tj.h;
import com.bytedance.sdk.openadsdk.core.tj.hh;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.qv;
import com.bytedance.sdk.openadsdk.core.tj.xq;
import com.bytedance.sdk.openadsdk.core.tj.zz;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.core.xt.j.cw.cw;
import com.bytedance.sdk.openadsdk.core.xt.j.j.j;
import com.bytedance.sdk.openadsdk.mediation.MediationSplashManagerDefault;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends com.bytedance.sdk.openadsdk.i.cw.xt.xt implements l.j, TsView.j {
    protected xt ae;
    private com.bytedance.sdk.openadsdk.core.component.splash.j.j aq;
    protected ae ch;
    protected cw cw;

    /* renamed from: e, reason: collision with root package name */
    private boolean f28742e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f28743f;
    private Context gx;

    /* renamed from: i, reason: collision with root package name */
    protected m f28746i;

    /* renamed from: j, reason: collision with root package name */
    protected TsView f28747j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f28748k;
    private r<g, ae> kc;

    /* renamed from: l, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.v.j.xt f28749l;
    protected com.bytedance.sdk.openadsdk.core.video.nativevideo.r la;

    /* renamed from: m, reason: collision with root package name */
    protected View.OnTouchListener f28750m;

    /* renamed from: n, reason: collision with root package name */
    private String f28751n;
    private float nd;

    /* renamed from: p, reason: collision with root package name */
    protected boolean f28752p;

    /* renamed from: r, reason: collision with root package name */
    protected SoftReference<com.bytedance.sdk.openadsdk.i.cw.j.cw> f28754r;
    private float rh;
    private com.bytedance.sdk.openadsdk.core.component.splash.ae ry;
    private com.bytedance.sdk.openadsdk.r.j.xt.j.xt sm;
    protected boolean tj;
    protected com.bytedance.sdk.openadsdk.r.j.xt.j.j tl;
    protected com.bytedance.sdk.openadsdk.core.xt.j up;

    /* renamed from: w, reason: collision with root package name */
    protected tl f28757w;
    private Activity xq;
    protected n xt;
    private com.bytedance.sdk.openadsdk.i.cw.cw.xt zz;

    /* renamed from: g, reason: collision with root package name */
    protected AtomicBoolean f28744g = new AtomicBoolean(false);
    protected final Map<String, Object> oq = new HashMap();
    private Double ol = null;
    private boolean hh = false;

    /* renamed from: z, reason: collision with root package name */
    private boolean f28759z = false;
    protected boolean qv = false;
    protected int vl = 3;
    protected int jy = -1;
    private final l hl = new l(Looper.getMainLooper(), this);
    protected boolean ws = false;
    protected boolean az = false;
    protected long av = 0;
    protected Map<String, Object> mi = new HashMap();
    protected AtomicBoolean kt = new AtomicBoolean(false);

    /* renamed from: v, reason: collision with root package name */
    protected boolean f28756v = true;

    /* renamed from: x, reason: collision with root package name */
    protected boolean f28758x = false;

    /* renamed from: b, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.splash.j f28740b = new com.bytedance.sdk.openadsdk.core.component.splash.j();

    /* renamed from: q, reason: collision with root package name */
    private boolean f28753q = false;
    private long qb = 0;
    private long ya = 5;

    /* renamed from: s, reason: collision with root package name */
    protected AtomicBoolean f28755s = new AtomicBoolean(false);

    /* renamed from: a, reason: collision with root package name */
    protected AtomicBoolean f28739a = new AtomicBoolean(false);

    /* renamed from: h, reason: collision with root package name */
    protected AtomicBoolean f28745h = new AtomicBoolean(false);
    private boolean ff = true;
    protected AtomicBoolean gq = new AtomicBoolean(false);
    protected int rn = -1;
    protected int wq = -1;
    protected final AtomicBoolean uf = new AtomicBoolean(false);
    private final AtomicBoolean rr = new AtomicBoolean(false);
    protected final AtomicInteger ed = new AtomicInteger(0);

    /* renamed from: c, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.component.splash.countdown.xt f28741c = null;
    private boolean st = false;
    private int pz = 0;

    /* renamed from: com.bytedance.sdk.openadsdk.core.component.splash.r.j$j, reason: collision with other inner class name */
    private static class C0451j implements j.xt {

        /* renamed from: j, reason: collision with root package name */
        n f28776j;

        @Override // com.bytedance.sdk.openadsdk.core.rn.j.xt
        public void j() {
            com.bytedance.sdk.openadsdk.core.jy.cw.xt(this.f28776j, "splash_ad", "splash_enter_foreground", System.currentTimeMillis());
        }

        @Override // com.bytedance.sdk.openadsdk.core.rn.j.xt
        public void xt() {
            com.bytedance.sdk.openadsdk.core.jy.cw.xt(this.f28776j, "splash_ad", "splash_enter_background", System.currentTimeMillis());
        }

        public C0451j(n nVar) {
            this.f28776j = nVar;
        }
    }

    public interface xt {
        void w_();
    }

    private void f() {
        this.f28748k = false;
        com.bytedance.sdk.openadsdk.core.component.splash.ae aeVar = new com.bytedance.sdk.openadsdk.core.component.splash.ae();
        this.ry = aeVar;
        aeVar.j(this.gx, this.xt);
        if (this.f28740b.cw() || !tj()) {
            return;
        }
        SoftReference<com.bytedance.sdk.openadsdk.i.cw.j.cw> softReference = this.f28754r;
        if (softReference == null) {
            this.ry.j(this.f28751n, this.jy, this.f28740b, null);
        } else {
            this.ry.j(this.f28751n, this.jy, this.f28740b, softReference.get());
        }
        this.f28743f = true;
        this.ry.j(2);
        com.bytedance.sdk.openadsdk.core.component.splash.j jVar = this.f28740b;
        if (jVar != null) {
            jVar.j(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.xt
    public void j(ViewGroup viewGroup) {
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.xt
    public View xt() {
        return null;
    }

    private void av() {
        if (!this.f28752p || this.f28747j == null) {
            return;
        }
        n nVar = this.xt;
        if (nVar != null && nVar.bw() != null && this.xt.bw().xt() == 0) {
            this.f28747j.setVideoViewVisibility(8);
        } else {
            this.f28747j.setVideoViewVisibility(0);
            this.f28747j.setVoiceViewListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.r.j.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.f28747j.setVoiceViewImageDrawable(j.this.ff ? kt.cw(j.this.gx, "tt_splash_unmute") : kt.cw(j.this.gx, "tt_splash_mute"));
                    j.this.ff = !r2.ff;
                    j jVar = j.this;
                    com.bytedance.sdk.openadsdk.core.video.nativevideo.r rVar = jVar.la;
                    if (rVar != null) {
                        rVar.xt(jVar.ff);
                    }
                }
            });
        }
    }

    private void az() {
        if (this.xt == null) {
            return;
        }
        try {
            this.qv = false;
            TsView tsView = new TsView(this.gx, this.f28751n, this.xt);
            this.f28747j = tsView;
            tsView.setAttachedToWindowListener(this);
            av();
            this.f28747j.setCountDownViewPosition(this.xt);
            if (this.xt.zz() == 0) {
                TsView tsView2 = this.f28747j;
                if (tsView2 != null) {
                    tsView2.setAdlogoViewVisibility(8);
                }
            } else {
                TsView tsView3 = this.f28747j;
                if (tsView3 != null) {
                    tsView3.setAdlogoViewVisibility(0);
                }
            }
            if (this.xt.fz() <= 0) {
                xt(3);
            } else {
                int fz = this.xt.fz();
                this.vl = fz;
                xt(fz);
            }
            j(this.xt);
            i();
        } catch (ArrayIndexOutOfBoundsException e6) {
            vl.r("sbr", e6.getMessage());
        }
    }

    private void i() {
        EmptyView emptyView = new EmptyView(this.gx, this.f28747j, this.xt.at());
        emptyView.j(this.xt, this.f28751n);
        emptyView.setAdType(3);
        this.f28747j.addView(emptyView);
        emptyView.setCallback(new EmptyView.j() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.r.j.4
            private volatile boolean xt = false;

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.j
            public void j(boolean z5) {
                cw cwVar = j.this.cw;
                if (cwVar == null || !z5) {
                    return;
                }
                cwVar.j();
            }

            private void cw() {
                boolean z5 = true;
                if (!this.xt) {
                    this.xt = true;
                    if (j.this.xt.jl() == 4) {
                        com.bytedance.sdk.openadsdk.l.ae.j(new com.bytedance.sdk.component.oq.g("splash_register_download") { // from class: com.bytedance.sdk.openadsdk.core.component.splash.r.j.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                TsView tsView;
                                Context context;
                                j jVar = j.this;
                                jVar.up(hh.j(jVar.xt) != 1);
                                cw cwVar = j.this.cw;
                                if (cwVar != null) {
                                    cwVar.j(false);
                                }
                                j jVar2 = j.this;
                                if (jVar2.cw == null || (tsView = jVar2.f28747j) == null || tsView.getParent() == null) {
                                    return;
                                }
                                try {
                                    context = ((View) j.this.f28747j.getParent()).getContext();
                                } catch (Exception unused) {
                                    context = null;
                                }
                                if (context instanceof Activity) {
                                    j.this.cw.j((Activity) context);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                cw cwVar = j.this.cw;
                if (cwVar != null) {
                    try {
                        cwVar.j(false);
                        j jVar = j.this;
                        if (hh.j(jVar.xt) == 1) {
                            z5 = false;
                        }
                        jVar.m(z5);
                    } catch (Exception unused) {
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.j
            public void j() {
                cw();
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.j
            public void j(View view, Map<String, Object> map) {
                m mVar;
                cw();
                j.this.av = System.currentTimeMillis();
                xt xtVar = j.this.ae;
                if (xtVar != null) {
                    xtVar.w_();
                }
                j jVar = j.this;
                n nVar = jVar.xt;
                if (nVar != null && (mVar = jVar.f28746i) != null) {
                    nVar.tl(mVar.up());
                    j.this.mi.put("cache_type", Integer.valueOf(v.xt().g(uf.g(j.this.xt))));
                    j jVar2 = j.this;
                    jVar2.mi.put("splash_show_time_type", Integer.valueOf(jVar2.wq));
                }
                if (map != null && map.containsKey("show_send_type")) {
                    j.this.mi.put("show_send_type", map.get("show_send_type"));
                }
                j jVar3 = j.this;
                jVar3.mi.put("is_repeat", Boolean.valueOf(jVar3.kt.get()));
                j.this.uf.set(true);
                if (!j.this.rr.get()) {
                    j.this.rr.set(true);
                    j jVar4 = j.this;
                    n nVar2 = jVar4.xt;
                    String str = jVar4.f28751n;
                    j jVar5 = j.this;
                    com.bytedance.sdk.openadsdk.core.jy.cw.j(nVar2, str, jVar5.mi, jVar5.ol);
                    com.bytedance.sdk.openadsdk.core.a.j.j().r();
                    n nVar3 = j.this.xt;
                    rn.j(nVar3 != null ? nVar3.ae() : 0);
                }
                j.this.kt();
                if (!j.this.st) {
                    j.this.mi();
                }
                j jVar6 = j.this;
                jVar6.r(jVar6.f28744g.get());
                boolean rs = v.xt().rs();
                j jVar7 = j.this;
                if (jVar7.tl != null && (!jVar7.kt.getAndSet(true) || rs)) {
                    j jVar8 = j.this;
                    jVar8.tl.j(jVar8);
                    n nVar4 = j.this.xt;
                    if (nVar4 != null && nVar4.up() && j.this.xt.m111if() != null) {
                        com.bytedance.sdk.openadsdk.ae.j.j().j(j.this.gx, j.this.xt.m111if().xt());
                    }
                }
                j.this.w();
                j.this.f28745h.set(true);
                TsView tsView = j.this.f28747j;
                if (tsView != null) {
                    tsView.setIsShowSuccess(true);
                }
                j.this.cw(true);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.j
            public void xt() {
            }
        });
        if (!this.st) {
            emptyView.setNeedCheckingShow(true);
        }
        this.oq.put("splash_show_type", Integer.valueOf(this.jy));
        com.bytedance.sdk.openadsdk.core.xt.j jVar = new com.bytedance.sdk.openadsdk.core.xt.j(this.gx, this.xt, this.f28751n, 4) { // from class: com.bytedance.sdk.openadsdk.core.component.splash.r.j.5
            @Override // com.bytedance.sdk.openadsdk.core.xt.xt, com.bytedance.sdk.openadsdk.core.xt.r
            public void j(View view, qv qvVar) {
                if ((view instanceof SplashClickBarBtn) && j.this.qv) {
                    return;
                }
                super.j(view, qvVar);
            }
        };
        this.up = jVar;
        ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) jVar.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(this);
        ((com.bytedance.sdk.openadsdk.core.xt.j.cw.j) this.up.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.j.class)).j(this.oq);
        j((com.bytedance.sdk.openadsdk.core.xt.j.cw.cw) this.up.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.cw.class), emptyView);
        this.up.xt(this.f28747j.getDislikeView());
        ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) this.up.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(new j.InterfaceC0499j() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.r.j.6
            @Override // com.bytedance.sdk.openadsdk.core.xt.j.j.j.InterfaceC0499j
            public void j(View view, int i6) {
                j jVar2 = j.this;
                com.bytedance.sdk.openadsdk.core.jy.cw.xt(jVar2.av, jVar2.xt);
                j jVar3 = j.this;
                com.bytedance.sdk.openadsdk.r.j.xt.j.j jVar4 = jVar3.tl;
                if (jVar4 != null) {
                    jVar4.xt(jVar3);
                }
                j.this.qv();
            }
        });
        this.f28747j.setSkipListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.r.j.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.oq();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kt() {
        TsView tsView = this.f28747j;
        if (tsView != null) {
            tsView.j(this.xt.im(), this.up);
            if (hh.j(this.xt) == 1) {
                vl();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(final boolean z5) {
        final String fs = this.xt.fs();
        this.cw.j(new com.bytedance.sdk.openadsdk.core.qv.xt.j() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.r.j.2
            @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
            public void j() {
                SoftReference<com.bytedance.sdk.openadsdk.i.cw.j.cw> softReference = j.this.f28754r;
                if (softReference != null && softReference.get() != null) {
                    j.this.f28754r.get().j();
                }
                if (z5) {
                    j.C0431j.j(fs, 1, 0);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
            public void cw(long j6, long j7, String str, String str2) {
                long j8;
                long j9;
                SoftReference<com.bytedance.sdk.openadsdk.i.cw.j.cw> softReference = j.this.f28754r;
                if (softReference == null || softReference.get() == null) {
                    j8 = j6;
                    j9 = j7;
                } else {
                    j8 = j6;
                    j9 = j7;
                    j.this.f28754r.get().cw(j8, j9, str, str2);
                }
                if (!z5 || j8 <= 0) {
                    return;
                }
                j.C0431j.j(fs, 4, (int) ((j9 * 100) / j8));
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
            public void xt(long j6, long j7, String str, String str2) {
                long j8;
                long j9;
                SoftReference<com.bytedance.sdk.openadsdk.i.cw.j.cw> softReference = j.this.f28754r;
                if (softReference == null || softReference.get() == null) {
                    j8 = j6;
                    j9 = j7;
                } else {
                    j8 = j6;
                    j9 = j7;
                    j.this.f28754r.get().xt(j8, j9, str, str2);
                }
                if (!z5 || j8 <= 0) {
                    return;
                }
                j.C0431j.j(fs, 2, (int) ((j9 * 100) / j8));
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
            public void j(long j6, long j7, String str, String str2) {
                long j8;
                long j9;
                SoftReference<com.bytedance.sdk.openadsdk.i.cw.j.cw> softReference = j.this.f28754r;
                if (softReference == null || softReference.get() == null) {
                    j8 = j6;
                    j9 = j7;
                } else {
                    j8 = j6;
                    j9 = j7;
                    j.this.f28754r.get().j(j8, j9, str, str2);
                }
                if (!z5 || j8 <= 0) {
                    return;
                }
                j.C0431j.j(fs, 3, (int) ((j9 * 100) / j8));
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
            public void j(long j6, String str, String str2) {
                SoftReference<com.bytedance.sdk.openadsdk.i.cw.j.cw> softReference = j.this.f28754r;
                if (softReference != null && softReference.get() != null) {
                    j.this.f28754r.get().j(j6, str, str2);
                }
                if (z5) {
                    j.C0431j.j(fs, 5, 100);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
            public void j(String str, String str2) {
                SoftReference<com.bytedance.sdk.openadsdk.i.cw.j.cw> softReference = j.this.f28754r;
                if (softReference != null && softReference.get() != null) {
                    j.this.f28754r.get().j(str, str2);
                }
                if (z5) {
                    j.C0431j.j(fs, 6, 100);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mi() {
        TsView tsView = this.f28747j;
        if (tsView != null && tsView.getChildCount() > 0) {
            for (int i6 = 0; i6 < this.f28747j.getChildCount(); i6++) {
                View childAt = this.f28747j.getChildAt(i6);
                if (childAt != null && (childAt instanceof EmptyView)) {
                    this.f28747j.removeView(childAt);
                    return;
                }
            }
        }
    }

    private boolean tj() {
        return (!xq.j(this.xt) || this.ws || this.az || this.tj) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void up(boolean z5) {
        this.cw = com.bytedance.sdk.openadsdk.core.qv.tl.j(this.gx, this.xt, this.f28751n, false);
        m(z5);
        com.bytedance.sdk.openadsdk.core.xt.j jVar = this.up;
        if (jVar != null) {
            ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) jVar.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(this.cw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (!this.f28742e) {
            this.f28756v = false;
            return;
        }
        if (this.f28753q) {
            return;
        }
        this.f28753q = true;
        com.bytedance.sdk.openadsdk.core.component.splash.j jVar = this.f28740b;
        if (jVar != null) {
            jVar.j();
            this.f28740b = null;
        }
        com.bytedance.sdk.openadsdk.core.video.nativevideo.r rVar = this.la;
        if (rVar != null) {
            rVar.oq();
        }
        this.tl = null;
        this.cw = null;
        this.xq = null;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.xt
    public com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.ae ae() {
        return new MediationSplashManagerDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.TsView.j
    public void g() {
        cw cwVar = this.cw;
        if (cwVar != null) {
            cwVar.xt();
        }
        n nVar = this.xt;
        if (nVar != null) {
            x.j(nVar.uv());
        }
        n nVar2 = this.xt;
        rn.xt(nVar2 != null ? nVar2.ae() : 0);
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.xt xtVar = this.f28741c;
        if (xtVar != null) {
            xtVar.j();
        }
        up.j(1, this.xt, this.f28751n, this.pz);
    }

    protected void jy() {
        f();
        com.bytedance.sdk.openadsdk.core.jy.cw.xt(this.av, this.xt);
        com.bytedance.sdk.openadsdk.r.j.xt.j.j jVar = this.tl;
        if (jVar != null && !this.qv) {
            this.qv = true;
            jVar.j(this, 2);
            cw(false);
        }
        ws();
    }

    protected void oq() {
        if (!this.az) {
            this.az = true;
            this.qv = true;
            if (!TextUtils.isEmpty(this.xt.os())) {
                com.bytedance.sdk.openadsdk.core.jy.cw.j(this.av > 0 ? System.currentTimeMillis() - this.av : 0L, this.xt);
            }
            f();
            com.bytedance.sdk.openadsdk.core.jy.cw.xt(this.av, this.xt);
            cw(false);
            ws();
        }
        com.bytedance.sdk.openadsdk.r.j.xt.j.j jVar = this.tl;
        if (jVar != null) {
            jVar.j(this, 1);
        }
    }

    protected void qv() {
        this.hl.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.r.j.9
            @Override // java.lang.Runnable
            public void run() {
                j.this.ws = true;
                if (!com.bytedance.sdk.openadsdk.core.qv.cw.cw.m.f29896j) {
                    if (j.this.ry != null) {
                        j.this.ry.xt();
                    }
                } else {
                    com.bytedance.sdk.openadsdk.core.qv.cw.cw.m.f29896j = false;
                    cw cwVar = j.this.cw;
                    if (cwVar instanceof com.bytedance.sdk.openadsdk.core.qv.cw.up) {
                        ((com.bytedance.sdk.openadsdk.core.qv.cw.up) cwVar).tl().j(new com.bytedance.sdk.openadsdk.core.qv.cw.j.j() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.r.j.9.1
                            @Override // com.bytedance.sdk.openadsdk.core.qv.cw.j.j
                            public void j() {
                                if (j.this.ry != null) {
                                    j.this.ry.xt();
                                }
                            }
                        });
                    }
                }
            }
        }, 100L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.TsView.j
    public void tl() {
        AtomicBoolean atomicBoolean = this.f28745h;
        if (atomicBoolean != null && atomicBoolean.get()) {
            vl.cw("开屏view重复展示");
            TsView tsView = this.f28747j;
            if (tsView != null && tsView.getCountDownView() != null && this.f28747j.getCountDownView().getView() != null) {
                this.f28747j.getCountDownView().getView().setVisibility(0);
            }
            r(this.f28744g.get());
        }
        this.pz = 1;
    }

    protected void vl() {
        ff gr;
        n nVar = this.xt;
        if (nVar == null || (gr = nVar.gr()) == null || gr.g() != 5) {
            return;
        }
        final int az = gr.az();
        final ff.j ws = gr.ws();
        View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.r.j.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                j jVar;
                com.bytedance.sdk.openadsdk.core.xt.j jVar2;
                TsView tsView;
                int r5 = ed.r(j.this.gx, view.getWidth());
                int r6 = ed.r(j.this.gx, view.getHeight());
                int r7 = ed.r(j.this.gx, motionEvent.getX());
                int r8 = ed.r(j.this.gx, motionEvent.getY());
                boolean z5 = r7 >= ws.j() && r8 >= ws.cw() && r5 - r7 >= ws.xt() && r6 - r8 >= ws.r();
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            j.this.rh = motionEvent.getY();
                        }
                    } else {
                        if (!z5) {
                            return false;
                        }
                        j.this.rh = motionEvent.getY();
                        int r9 = ed.r(j.this.gx, Math.abs(j.this.rh - j.this.nd));
                        if (j.this.rh - j.this.nd < 0.0f && r9 > az && (jVar2 = (jVar = j.this).up) != null && (tsView = jVar.f28747j) != null) {
                            jVar2.onClick(tsView);
                        }
                    }
                } else {
                    if (!z5) {
                        return false;
                    }
                    j.this.nd = motionEvent.getY();
                }
                return true;
            }
        };
        this.f28750m = onTouchListener;
        TsView tsView = this.f28747j;
        if (tsView != null) {
            tsView.setSlideUpTouchListener(onTouchListener);
        }
    }

    protected void ws() {
        oq.i().g(true);
        com.bytedance.sdk.openadsdk.core.rn.j r5 = oq.i().r();
        if (r5 == null) {
            return;
        }
        r5.xt((j.xt) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        oq.i().r().xt(new C0451j(this.xt));
    }

    protected void cw(boolean z5) {
        com.bytedance.sdk.openadsdk.core.component.splash.j.j jVar = this.aq;
        if (jVar != null) {
            jVar.j(this.kc, this.xt, this.zz, z5);
        }
    }

    protected void r(boolean z5) {
        if (z5 || this.f28747j == null) {
            return;
        }
        if (this.ed.get() == 2 && zz.j(this.xt)) {
            com.bytedance.sdk.openadsdk.core.component.splash.countdown.xt xtVar = this.f28741c;
            if (xtVar != null) {
                xtVar.xt();
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.r countDownView = this.f28747j.getCountDownView();
        if (countDownView != null) {
            countDownView.setCountdownListener(new com.bytedance.sdk.openadsdk.core.component.splash.countdown.j() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.r.j.11
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.j
                public void j() {
                    j.this.jy();
                }
            });
            countDownView.j(false);
            countDownView.j();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.xt
    public void m() {
        if (!this.f28744g.getAndSet(true)) {
            up.j(2, this.xt, this.f28751n, 0);
        }
        TsView tsView = this.f28747j;
        if (tsView != null) {
            tsView.setSkipIconVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.xt
    public View cw() {
        com.bytedance.sdk.openadsdk.core.component.splash.ae aeVar;
        if (this.f28743f && (aeVar = this.ry) != null) {
            return aeVar.j();
        }
        return null;
    }

    protected void j(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.cw cwVar, r<g, ae> rVar, com.bytedance.sdk.openadsdk.core.component.splash.j.j jVar) {
        if (cwVar == null || rVar == null) {
            return;
        }
        this.aq = jVar;
        this.gq.set(cwVar.g());
        this.kc = rVar;
        ae aeVar = new ae();
        this.ch = aeVar;
        aeVar.xt(cwVar.g());
        this.ch.j(cwVar.xt());
        this.ch.j(this);
        this.gx = cwVar.getContext();
        this.f28751n = cwVar.m();
        this.f28746i = cwVar.r();
        boolean z5 = true;
        j(cwVar.up(), true);
        this.zz = cwVar.ae();
        m mVar = this.f28746i;
        if (mVar == null) {
            this.ch.xt(3);
            this.ch.j("render splash ad model is null");
            rVar.j(this.ch);
        } else {
            if (this.f28757w == null) {
                this.ch.xt(3);
                this.ch.j("render splash material is null");
                rVar.j(this.ch);
                return;
            }
            this.xt = mVar.xt();
            boolean lv = v.xt().lv();
            if (!v.xt().ua() && !lv) {
                z5 = false;
            }
            this.st = z5;
            az();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.xt
    public Map<String, Object> up() {
        n nVar = this.xt;
        if (nVar == null) {
            return null;
        }
        h hVar = nVar.fp().get(0);
        if (hVar == null) {
            return this.xt.lg();
        }
        if (!hVar.m()) {
            return this.xt.lg();
        }
        String j6 = hVar.j();
        Map<String, Object> lg = this.xt.lg();
        lg.put("image_url", j6);
        return lg;
    }

    public void xt(boolean z5) {
        this.f28752p = z5;
        av();
    }

    private void xt(int i6) {
        TsView tsView = this.f28747j;
        if (tsView != null) {
            tsView.setCountDownTime(i6);
        }
    }

    private void xt(ViewGroup viewGroup) {
        TsView tsView;
        if (!this.f28743f || (tsView = this.f28747j) == null || this.xt == null || this.ry == null || this.f28742e) {
            return;
        }
        ViewParent parent = tsView.getParent();
        this.f28742e = true;
        ViewGroup j6 = this.ry.j();
        if (j6 == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.video.nativevideo.r rVar = this.la;
        if (rVar != null) {
            rVar.m();
        }
        if (j6.getParent() != null) {
            ((ViewGroup) j6.getParent()).removeView(j6);
        }
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).addView(j6);
            ed.tl(this.f28747j);
            this.f28747j.removeAllViews();
            this.f28747j = null;
        }
        j6.setOnClickListener(null);
        j6.setOnTouchListener(null);
        if (this.f28758x) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.r rVar2 = this.la;
            if (rVar2 != null) {
                rVar2.oq();
            }
            this.la = null;
        }
        this.ry.j(this.la, new ae.j() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.r.j.3
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.ae.j
            public void j(long j7) {
                j.this.hl.removeMessages(1);
                if (j7 < 0) {
                    j.this.hl.sendEmptyMessageDelayed(1, 1000L);
                } else {
                    if (j7 == 0) {
                        j.this.hl.sendEmptyMessage(2);
                        return;
                    }
                    j.this.ya = j7;
                    j.this.qb = 0L;
                    j.this.hl.sendEmptyMessageDelayed(1, 1000L);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.ae.j
            public Context getActivity() {
                return j.this.xq;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.ae.j
            public void xt() {
                j.this.f28748k = true;
                j.this.v();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.ae.j
            public void j() {
                j.this.hl.removeMessages(1);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.xt
    public int r() {
        n nVar = this.xt;
        if (nVar == null) {
            return -1;
        }
        return nVar.jl();
    }

    public synchronized void j(tl tlVar, boolean z5) {
        if (this.f28757w == null || !z5) {
            this.f28757w = tlVar;
            if (tlVar != null) {
                xt(tlVar.up());
                this.f28749l = tlVar.r();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void xt(Double d6) {
        this.ol = d6;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.xt
    public PluginValueSet j() {
        return e.j(super.j()).e(1, com.bytedance.sdk.openadsdk.core.h.xt).k();
    }

    protected void j(xt xtVar) {
        this.ae = xtVar;
    }

    private void j(n nVar) {
        TsView tsView;
        if (nVar == null || (tsView = this.f28747j) == null) {
            return;
        }
        tsView.j(nVar);
    }

    public void j(final com.bytedance.sdk.openadsdk.core.xt.j.cw.cw cwVar, final EmptyView emptyView) {
        cwVar.j(new cw.j() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.r.j.8
            @Override // com.bytedance.sdk.openadsdk.core.xt.j.cw.cw.j
            public boolean j() {
                cwVar.j(emptyView);
                cwVar.j(j.this.mi);
                cwVar.j(j.this.f28751n);
                cwVar.j(j.this.ol);
                return j.this.uf.get();
            }
        });
    }

    @Override // com.bytedance.sdk.component.utils.l.j
    public void j(Message message) {
        int i6 = message.what;
        if (i6 == 1) {
            long j6 = this.qb + 1;
            this.qb = j6;
            if (j6 >= this.ya) {
                this.hl.sendEmptyMessage(2);
                return;
            } else {
                this.hl.sendEmptyMessageDelayed(1, 1000L);
                return;
            }
        }
        if (i6 != 2) {
            return;
        }
        if (!this.f28748k && xq.j(this.xt)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("splash_card_close_type", 0);
                com.bytedance.sdk.openadsdk.core.jy.cw.xt(this.xt, "splash_ad", "splash_card_close", jSONObject);
            } catch (JSONException e6) {
                vl.j(e6);
            }
        }
        v();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.TsView.j
    public void j(boolean z5) {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.xt xtVar = this.f28741c;
        if (xtVar != null) {
            xtVar.j(z5);
        }
        this.pz++;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.xt
    public void j(com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar) {
        if (cwVar == null) {
            return;
        }
        this.f28754r = new SoftReference<>(cwVar);
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.xt
    public void j(com.bytedance.sdk.openadsdk.r.j.xt.j.j jVar) {
        this.tl = jVar;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.xt
    public void j(com.bytedance.sdk.openadsdk.r.j.xt.j.xt xtVar) {
        this.sm = xtVar;
        com.bytedance.sdk.openadsdk.core.component.splash.j jVar = this.f28740b;
        if (jVar != null) {
            jVar.j(xtVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.xt
    public void j(ViewGroup viewGroup, Activity activity) {
        this.xq = activity;
        xt(viewGroup);
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(Double d6) {
        if (this.hh) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.rn.l.j(this.xt, d6);
        this.hh = true;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(Double d6, String str, String str2) {
        if (this.f28759z) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.rn.l.j(this.xt, d6, str, str2);
        this.f28759z = true;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(com.bytedance.sdk.openadsdk.i.cw.j.xt xtVar) {
        n nVar = this.xt;
        if (nVar != null) {
            x.j(nVar.uv(), xtVar, com.bytedance.sdk.openadsdk.i.cw.j.xt.class);
        }
    }

    public void j(int i6) {
        this.rn = i6;
    }
}
