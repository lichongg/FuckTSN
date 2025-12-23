package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bykv.vk.openvk.component.video.api.r.xt;
import com.bykv.vk.openvk.component.video.api.renderview.SSRenderTextureView;
import com.bykv.vk.openvk.component.video.j.up.xt;
import com.bytedance.sdk.component.m.av;
import com.bytedance.sdk.component.m.qv;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.multipro.xt.j;
import com.bytedance.sdk.openadsdk.core.qv.tl;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.e;
import com.bytedance.sdk.openadsdk.core.tj.hh;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.widget.az;
import com.bytedance.sdk.openadsdk.core.widget.ws;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.core.xt.j.j.j;
import com.bytedance.sdk.openadsdk.i.cw.xt.jy;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.bytedance.sdk.openadsdk.upie.video.lottie.TTLottieVideoContainer;
import com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView;
import com.bytedance.sdk.openadsdk.widget.RoundImageView;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m implements com.bykv.vk.openvk.component.video.api.r.xt<n>, com.bykv.vk.openvk.component.video.api.renderview.j, l.j, az.xt, ws.j {

    /* renamed from: a, reason: collision with root package name */
    az f31033a;
    protected TTViewStub ae;
    private final int aq;
    protected TTViewStub av;
    TTProgressBar az;

    /* renamed from: b, reason: collision with root package name */
    private RelativeLayout f31034b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f31035c;
    n ch;
    ImageView cw;

    /* renamed from: e, reason: collision with root package name */
    private RoundImageView f31036e;
    private View ed;

    /* renamed from: f, reason: collision with root package name */
    volatile boolean f31037f;
    private j.InterfaceC0466j ff;

    /* renamed from: g, reason: collision with root package name */
    ImageView f31038g;
    com.bytedance.sdk.openadsdk.core.xt.j gq;
    private TextView gx;

    /* renamed from: h, reason: collision with root package name */
    com.bytedance.sdk.openadsdk.core.qv.xt.cw f31039h;
    private RelativeLayout hh;
    private View hl;

    /* renamed from: i, reason: collision with root package name */
    int f31040i;

    /* renamed from: j, reason: collision with root package name */
    View f31041j;
    TextView jy;

    /* renamed from: k, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.xt.j f31042k;
    private final int kc;
    int kt;

    /* renamed from: l, reason: collision with root package name */
    xt f31043l;
    com.bykv.vk.openvk.component.video.api.r.cw la;

    /* renamed from: m, reason: collision with root package name */
    ImageView f31044m;
    int mi;

    /* renamed from: n, reason: collision with root package name */
    private NativeVideoTsView.j f31045n;
    private RelativeLayout nd;
    private TextView ol;
    View oq;

    /* renamed from: p, reason: collision with root package name */
    boolean f31046p;

    /* renamed from: q, reason: collision with root package name */
    private TextView f31047q;
    private TextView qb;
    RoundImageView qv;

    /* renamed from: r, reason: collision with root package name */
    View f31048r;
    private RoundImageView rh;
    com.bytedance.sdk.openadsdk.core.xt.j rn;
    private AtomicBoolean rr;
    private ae ry;

    /* renamed from: s, reason: collision with root package name */
    Context f31049s;
    private int sm;
    boolean tj;
    View tl;
    boolean uf;
    View up;

    /* renamed from: v, reason: collision with root package name */
    int f31050v;
    TextView vl;

    /* renamed from: w, reason: collision with root package name */
    int f31051w;
    com.bytedance.sdk.openadsdk.f.j.xt.j.j wq;
    TextView ws;

    /* renamed from: x, reason: collision with root package name */
    EnumSet<xt.j> f31052x;
    private boolean xq;
    com.bykv.vk.openvk.component.video.api.renderview.xt xt;
    private String ya;

    /* renamed from: z, reason: collision with root package name */
    private TTViewStub f31053z;
    private final int zz;

    public m(Context context, View view, boolean z5, EnumSet<xt.j> enumSet, n nVar, com.bykv.vk.openvk.component.video.api.r.cw cwVar, boolean z6, com.bytedance.sdk.openadsdk.core.xt.j jVar) {
        this.tj = true;
        this.f31046p = true;
        this.uf = true;
        this.zz = 1;
        this.kc = 2;
        this.aq = 3;
        this.rr = new AtomicBoolean(false);
        if (this instanceof up) {
            return;
        }
        this.f31049s = StubApp.getOrigApplicationContext(v.getContext().getApplicationContext());
        r(z6);
        this.f31041j = view;
        this.tj = z5;
        this.f31052x = enumSet == null ? EnumSet.noneOf(xt.j.class) : enumSet;
        this.la = cwVar;
        this.f31042k = jVar;
        this.ch = nVar;
        p();
        r(8);
        j(context, this.f31041j, nVar);
        r();
        av();
    }

    private void p() {
        this.sm = 1;
        String xt = uf.xt(this.ch);
        String str = "embeded_ad_landingpage";
        if (xt == null) {
            xt = this.f31046p ? "embeded_ad" : "embeded_ad_landingpage";
        }
        this.sm = uf.xt(xt);
        if (!this.f31046p && xt.equals("draw_ad")) {
            str = "draw_ad_landingpage";
        } else if (this.f31046p || !xt.equals("embeded_ad")) {
            str = xt;
        }
        this.ya = str;
    }

    public void cw(boolean z5) {
    }

    public void j(long j6) {
    }

    public void m() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.az.xt
    public boolean oq() {
        return false;
    }

    public void up() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.az.xt
    public void vl() {
        j(true, false);
    }

    public void xt(ViewGroup viewGroup) {
    }

    private int ae(int i6) {
        if (this.mi <= 0 || this.kt <= 0) {
            return 0;
        }
        int cw = ed.cw(this.f31049s, 228.0f);
        int cw2 = ed.cw(this.f31049s, 160.0f);
        int i7 = (int) (this.kt * ((i6 * 1.0f) / this.mi));
        return i7 > cw ? cw : i7 < cw2 ? cw2 : i7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            layoutParams.addRule(15);
            View view = this.oq;
            if (view != null) {
                view.setLayoutParams(layoutParams);
            }
            View view2 = this.f31041j;
            if (view2 == null) {
                return;
            }
            int measuredWidth = view2.getMeasuredWidth();
            int measuredHeight = this.f31041j.getMeasuredHeight();
            int cw = ed.cw(this.f31049s, 200.0f);
            int cw2 = ed.cw(this.f31049s, 331.0f);
            int cw3 = ed.cw(this.f31049s, 110.0f);
            int cw4 = ed.cw(this.f31049s, 100.0f);
            if (measuredWidth >= cw && measuredHeight >= cw2) {
                m(1);
                return;
            }
            if (measuredWidth > cw3 && measuredHeight > cw4) {
                m(3);
                return;
            }
            m(2);
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    private void gq() {
        if (this.f31049s == null || this.f31041j == null) {
            return;
        }
        View view = new View(this.f31049s) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.m.8
            private final AtomicBoolean xt = new AtomicBoolean(true);

            @Override // android.view.View
            protected void onMeasure(int i6, int i7) {
                super.onMeasure(0, 0);
            }

            private void j() {
                if (this.xt.getAndSet(false) && (com.bytedance.sdk.openadsdk.core.video.cw.j.j(m.this.ch) || m.this.ch.jl() == 4)) {
                    m.this.h();
                }
                x.j(m.this.ch.hm(), m.this.ry, ae.class);
            }

            private void xt() {
                com.bytedance.sdk.openadsdk.core.qv.xt.cw cwVar;
                if (this.xt.getAndSet(true) || (cwVar = m.this.f31039h) == null) {
                    return;
                }
                cwVar.xt();
            }

            @Override // android.view.View
            protected void onAttachedToWindow() {
                super.onAttachedToWindow();
                m.this.rr.set(false);
                j();
            }

            @Override // android.view.View
            protected void onDetachedFromWindow() {
                super.onDetachedFromWindow();
                m.this.rr.set(true);
                xt();
            }

            @Override // android.view.View
            public void onFinishTemporaryDetach() {
                super.onFinishTemporaryDetach();
                j();
            }

            @Override // android.view.View
            public void onStartTemporaryDetach() {
                super.onStartTemporaryDetach();
                xt();
            }

            @Override // android.view.View
            public void onWindowFocusChanged(boolean z5) {
                super.onWindowFocusChanged(z5);
                com.bytedance.sdk.openadsdk.core.qv.xt.cw cwVar = m.this.f31039h;
                if (cwVar != null && z5) {
                    cwVar.j();
                }
            }
        };
        View view2 = this.f31041j;
        if (view2 instanceof ViewGroup) {
            ((ViewGroup) view2).addView(view, 0, new RelativeLayout.LayoutParams(0, 0));
        }
    }

    private boolean gx() {
        n nVar;
        return this.f31046p && this.oq != null && (nVar = this.ch) != null && nVar.rh() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        com.bytedance.sdk.openadsdk.l.ae.j(new g("native_video_layout_download_listener") { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.m.1
            @Override // java.lang.Runnable
            public void run() {
                m mVar = m.this;
                if (mVar.f31039h == null) {
                    mVar.f31039h = tl.j(mVar.f31049s, mVar.ch, mVar.ya, false);
                }
                com.bytedance.sdk.openadsdk.core.xt.j jVar = m.this.gq;
                if (jVar != null) {
                    ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) jVar.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(m.this.f31039h);
                }
                com.bytedance.sdk.openadsdk.core.xt.j jVar2 = m.this.rn;
                if (jVar2 != null) {
                    ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) jVar2.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(m.this.f31039h);
                }
                if (m.this.ff != null) {
                    m mVar2 = m.this;
                    mVar2.f31039h.j(mVar2.ff);
                }
                com.bytedance.sdk.openadsdk.core.qv.xt.cw cwVar = m.this.f31039h;
                if (cwVar != null) {
                    cwVar.j(false);
                }
            }
        });
    }

    private boolean la() {
        n nVar = this.ch;
        return nVar != null && hh.m(nVar) == null && hh.ae(this.ch) == null && this.ch.k() == 1 && n.xt(this.ch);
    }

    private boolean rn() {
        if (this.ch == null) {
            return false;
        }
        if ("fullscreen_interstitial_ad".equals(this.ya) || "rewarded_video".equals(this.ya)) {
            int zw = this.ch.zw();
            float uo = this.ch.uo();
            if (zw == 1 && uo == 100.0f) {
                return true;
            }
        }
        return false;
    }

    private void tl(int i6) {
        ed.j(this.oq, i6);
        ed.j(this.ed, i6);
    }

    private boolean uf() {
        return TextUtils.equals(this.ya, "splash_ad") || TextUtils.equals(this.ya, "cache_splash_ad");
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.ws.j
    public boolean az() {
        az azVar = this.f31033a;
        return azVar != null && azVar.j();
    }

    void ch() {
        ed.j(this.tl, 8);
        ed.j((View) this.f31038g, 8);
        ed.j(this.oq, 8);
        ed.j((View) this.qv, 8);
        ed.j((View) this.vl, 8);
        ed.j((View) this.jy, 8);
        ed.j((View) this.ws, 8);
        ed.j(this.hl, 8);
        ed.j((View) this.f31034b, 8);
    }

    public boolean cw(int i6) {
        return false;
    }

    protected void f() {
        ed.j(this.f31048r, 8);
        ed.j((View) this.nd, 0);
        wq();
    }

    public void g() {
        TTProgressBar tTProgressBar = this.az;
        if (tTProgressBar != null) {
            tTProgressBar.setProgress(0);
            this.az.setSecondaryProgress(0);
        }
        r(8);
        if (l()) {
            this.xt.setVisibility(8);
        }
        ImageView imageView = this.f31044m;
        if (imageView != null) {
            imageView.setImageDrawable(null);
            this.f31044m.setBackground(null);
        }
        ImageView imageView2 = this.f31038g;
        if (imageView2 != null) {
            imageView2.setImageDrawable(null);
            this.f31038g.setBackground(null);
        }
        r(8);
        ed.j(this.tl, 8);
        ed.j((View) this.f31038g, 8);
        ed.j(this.oq, 8);
        ed.j((View) this.qv, 8);
        ed.j((View) this.vl, 8);
        ed.j((View) this.jy, 8);
        ed.j(this.hl, 8);
        ed.j((View) this.f31034b, 8);
        az azVar = this.f31033a;
        if (azVar != null) {
            azVar.j(true);
        }
    }

    public com.bykv.vk.openvk.component.video.api.renderview.xt i() {
        return this.xt;
    }

    public void j(long j6, long j7) {
    }

    public boolean jy() {
        return this.f31037f;
    }

    public void kt() {
        az azVar = this.f31033a;
        if (azVar != null) {
            azVar.j(false);
        }
    }

    boolean l() {
        return !this.f31052x.contains(xt.j.alwayShowMediaView) || this.tj;
    }

    void mi() {
        if (this.f31043l == null || this.f31033a != null) {
            return;
        }
        System.currentTimeMillis();
        az azVar = new az();
        this.f31033a = azVar;
        azVar.j(this.f31049s, this.f31041j);
        this.f31033a.j(this.f31043l, this);
        System.currentTimeMillis();
    }

    public boolean qv() {
        return this.tj;
    }

    void r() {
        this.xt.j(this);
        ImageView imageView = this.cw;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.m.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (m.this.tj()) {
                        TextView textView = m.this.ws;
                        if (textView == null || textView.getVisibility() != 0) {
                            m mVar = m.this;
                            mVar.f31043l.j(mVar, view);
                        }
                    }
                }
            });
        }
    }

    public void s() {
        n nVar = this.ch;
        if (nVar == null) {
            return;
        }
        if (this.ch.tz() != 5 ? nVar.tz() == 1 && e.i(this.ch) : true) {
            j(false, this.tj);
            j(this.f31041j, v.getContext());
            if (this.f31038g == null || TextUtils.isEmpty(ln.xt(this.ch))) {
                return;
            }
            ed.j(this.tl, 0);
            ed.j((View) this.f31038g, 0);
            ed.j(this.oq, 8);
            com.bytedance.sdk.openadsdk.g.xt.j(ln.xt(this.ch)).j(this.f31038g);
            j(this.f31038g, ln.xt(this.ch));
        }
    }

    boolean tj() {
        if (this.f31043l != null) {
            return true;
        }
        vl.r("NewLiveViewLayout", "callback is null");
        return false;
    }

    public void v() {
        if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(this.ch)) {
            f();
        } else {
            ed.j((View) this.nd, 8);
            ed.m(this.f31048r);
            ed.m(this.up);
        }
        ImageView imageView = this.cw;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        ed.j((View) this.cw, 8);
    }

    protected void w() {
        if (this.ch == null) {
            return;
        }
        if (this.xq) {
            ed.j((View) this.qb, 8);
        }
        if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(this.ch)) {
            String g6 = com.bytedance.sdk.openadsdk.core.tj.ed.g(this.ch);
            String cw = com.bytedance.sdk.openadsdk.core.tj.ed.cw(this.ch);
            String tl = com.bytedance.sdk.openadsdk.core.tj.ed.tl(this.ch);
            ed.j(this.hl, 0);
            ed.j((View) this.f31034b, 0);
            if (!TextUtils.isEmpty(g6)) {
                com.bytedance.sdk.openadsdk.g.xt.j(g6).j(this.f31036e);
            }
            if (!TextUtils.isEmpty(cw)) {
                ed.j(this.f31047q, cw);
            }
            if (this.f31034b == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.g.xt.j(tl).cw(2).j(new av<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.m.9
                @Override // com.bytedance.sdk.component.m.av
                @ATSMethod(2)
                public void j(int i6, String str, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.m.av
                @ATSMethod(1)
                public void j(qv<Bitmap> qvVar) {
                    Bitmap j6 = com.bytedance.sdk.component.adexpress.r.xt.j(m.this.f31049s, qvVar.cw(), 25);
                    if (j6 == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(m.this.f31034b.getResources(), j6);
                    com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.m.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (m.this.f31034b != null) {
                                m.this.f31034b.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }
            }, 4);
        }
    }

    @TargetApi(14)
    public void x() {
        ed.j(this.f31041j, 0);
        com.bykv.vk.openvk.component.video.api.renderview.xt xtVar = this.xt;
        if (xtVar != null) {
            View view = xtVar.getView();
            ed.j(view, 8);
            ed.j(view, 0);
        }
    }

    public void xt(boolean z5) {
    }

    private void ed() {
        if (uf()) {
            ed.j((View) this.cw, 8);
            if (!v.xt().px()) {
                ed.j(this.f31048r, 8);
                ed.j(this.up, 8);
                ed.j((View) this.f31044m, 8);
                return;
            }
        }
        ed.j(this.f31048r, 0);
        ed.j((View) this.nd, 8);
        ed.m(this.f31048r);
        if (uf() && v.xt().px()) {
            ed.j(this.up, 8);
        } else {
            ed.m(this.up);
        }
        if (this.f31044m != null && !TextUtils.isEmpty(ln.xt(this.ch))) {
            ed.m(this.f31044m);
            com.bytedance.sdk.openadsdk.g.xt.j(ln.xt(this.ch)).j(this.f31044m);
            j(this.f31044m, ln.xt(this.ch));
        }
    }

    private void wq() {
        final long currentTimeMillis = System.currentTimeMillis();
        n nVar = this.ch;
        if (nVar != null && com.bytedance.sdk.openadsdk.core.video.cw.j.j(nVar)) {
            String g6 = com.bytedance.sdk.openadsdk.core.tj.ed.g(this.ch);
            if (!TextUtils.isEmpty(g6)) {
                com.bytedance.sdk.openadsdk.g.xt.j(g6).j(this.rh);
            }
            String cw = com.bytedance.sdk.openadsdk.core.tj.ed.cw(this.ch);
            String tl = com.bytedance.sdk.openadsdk.core.tj.ed.tl(this.ch);
            if (!TextUtils.isEmpty(cw)) {
                ed.j(this.ol, cw);
            }
            if (this.nd != null) {
                com.bytedance.sdk.openadsdk.g.xt.j(tl).cw(2).j(new av<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.m.10
                    @Override // com.bytedance.sdk.component.m.av
                    @ATSMethod(1)
                    public void j(qv<Bitmap> qvVar) {
                        Bitmap j6 = com.bytedance.sdk.component.adexpress.r.xt.j(m.this.f31049s, qvVar.cw(), 25);
                        if (j6 == null) {
                            return;
                        }
                        final BitmapDrawable bitmapDrawable = new BitmapDrawable(m.this.nd.getResources(), j6);
                        com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.m.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (m.this.nd != null) {
                                    m.this.nd.setBackground(bitmapDrawable);
                                }
                            }
                        });
                        m mVar = m.this;
                        com.bytedance.sdk.openadsdk.core.jy.cw.r(mVar.ch, mVar.ya, System.currentTimeMillis() - currentTimeMillis);
                    }

                    @Override // com.bytedance.sdk.component.m.av
                    @ATSMethod(2)
                    public void j(int i6, String str, Throwable th) {
                        m mVar = m.this;
                        com.bytedance.sdk.openadsdk.core.jy.cw.j(mVar.ch, mVar.ya, i6, str);
                    }
                }, 4);
            }
        }
    }

    public void a() {
        if (uf()) {
            ed.j((View) this.cw, 8);
            ed.up(this.f31048r);
            ed.up(this.up);
            ImageView imageView = this.f31044m;
            if (imageView != null) {
                ed.up(imageView);
            }
        }
    }

    void av() {
        View view;
        p();
        if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(this.ch)) {
            com.bytedance.sdk.openadsdk.core.xt.j jVar = this.f31042k;
            if (jVar != null) {
                this.gq = jVar;
            } else {
                this.gq = new com.bytedance.sdk.openadsdk.core.xt.j(this.f31049s, this.ch, this.ya, this.sm);
            }
            ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) this.gq.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(new j.InterfaceC0499j() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.m.5
                @Override // com.bytedance.sdk.openadsdk.core.xt.j.j.j.InterfaceC0499j
                public void j(View view2, int i6) {
                    if (m.this.f31045n != null) {
                        m.this.f31045n.j(view2, i6);
                    }
                }
            });
            if (this.f31042k == null && (view = this.f31041j) != null) {
                view.setOnClickListener(this.gq);
                this.f31041j.setOnTouchListener(this.gq);
            }
            if (ed.r(this.hh)) {
                this.hh.setOnClickListener(this.gq);
                this.hh.setOnTouchListener(this.gq);
                return;
            }
            return;
        }
        gq();
        com.bytedance.sdk.openadsdk.core.xt.j jVar2 = new com.bytedance.sdk.openadsdk.core.xt.j(this.f31049s, this.ch, this.ya, this.sm);
        this.gq = jVar2;
        ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) jVar2.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).xt(true);
        ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) this.gq.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(new j.InterfaceC0499j() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.m.6
            @Override // com.bytedance.sdk.openadsdk.core.xt.j.j.j.InterfaceC0499j
            public void j(View view2, int i6) {
                if (m.this.f31045n != null) {
                    m.this.f31045n.j(view2, i6);
                }
            }
        });
        xt(this.gq);
        if (this.f31046p) {
            ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) this.gq.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).cw(true);
        } else {
            ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) this.gq.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).cw(false);
            ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) this.gq.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(true);
        }
        if (la()) {
            com.bytedance.sdk.openadsdk.core.xt.j jVar3 = new com.bytedance.sdk.openadsdk.core.xt.j(this.f31049s, this.ch, this.ya, this.sm);
            this.rn = jVar3;
            xt(jVar3);
            this.ry = new ae(this);
            ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) this.rn.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).xt(true);
            ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) this.rn.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(new j.InterfaceC0499j() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.m.7
                @Override // com.bytedance.sdk.openadsdk.core.xt.j.j.j.InterfaceC0499j
                public void j(View view2, int i6) {
                    if (m.this.f31045n != null) {
                        m.this.f31045n.j(view2, i6);
                    }
                }
            });
            if (this.f31046p) {
                ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) this.rn.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).cw(true);
            } else {
                ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) this.rn.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).cw(false);
            }
            j(this.rn);
            View view2 = this.f31041j;
            if (view2 != null) {
                view2.setOnClickListener(this.rn);
                this.f31041j.setOnTouchListener(this.rn);
            }
        }
    }

    @Override // com.bytedance.sdk.component.utils.l.j
    public void j(Message message) {
    }

    public void m(int i6) {
        n nVar;
        if (this.qv == null || (nVar = this.ch) == null || nVar.ig() == null || this.ch.ig().j() == null) {
            return;
        }
        if (i6 == 1) {
            int cw = ed.cw(this.f31049s, 71.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(cw, cw);
            layoutParams.addRule(14);
            this.qv.setLayoutParams(layoutParams);
            this.vl.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.bottomMargin = ed.cw(this.f31049s, 16.0f);
            layoutParams2.topMargin = ed.cw(this.f31049s, 8.0f);
            layoutParams2.leftMargin = ed.cw(this.f31049s, 16.0f);
            layoutParams2.rightMargin = ed.cw(this.f31049s, 16.0f);
            layoutParams2.addRule(3, this.qv.getId());
            layoutParams2.addRule(14);
            this.jy.setLayoutParams(layoutParams2);
            this.jy.setTextSize(16.0f);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, ed.cw(this.f31049s, 32.0f));
            layoutParams3.addRule(14);
            layoutParams3.addRule(3, this.jy.getId());
            layoutParams3.leftMargin = ed.cw(this.f31049s, 20.0f);
            layoutParams3.rightMargin = ed.cw(this.f31049s, 20.0f);
            this.ws.setPadding(ed.cw(this.f31049s, 36.0f), ed.cw(this.f31049s, 7.0f), ed.cw(this.f31049s, 36.0f), ed.cw(this.f31049s, 8.0f));
            this.ws.setLayoutParams(layoutParams3);
            this.ws.setEllipsize(TextUtils.TruncateAt.END);
            this.ws.setSingleLine(true);
            this.ws.setTextSize(14.0f);
            return;
        }
        if (i6 == 2) {
            int cw2 = ed.cw(this.f31049s, 40.0f);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(cw2, cw2);
            layoutParams4.addRule(14);
            this.qv.setLayoutParams(layoutParams4);
            this.vl.setLayoutParams(layoutParams4);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams5.bottomMargin = ed.cw(this.f31049s, 8.0f);
            layoutParams5.topMargin = ed.cw(this.f31049s, 8.0f);
            layoutParams5.addRule(3, this.qv.getId());
            layoutParams5.addRule(14);
            this.jy.setLayoutParams(layoutParams5);
            this.jy.setTextSize(10.0f);
            ed.j((View) this.ws, 8);
            return;
        }
        int cw3 = ed.cw(this.f31049s, 49.0f);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(cw3, cw3);
        layoutParams6.addRule(14);
        this.qv.setLayoutParams(layoutParams6);
        this.vl.setLayoutParams(layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.bottomMargin = ed.cw(this.f31049s, 8.0f);
        layoutParams7.topMargin = ed.cw(this.f31049s, 8.0f);
        layoutParams7.addRule(3, this.qv.getId());
        layoutParams7.addRule(14);
        this.jy.setLayoutParams(layoutParams7);
        this.jy.setTextSize(13.0f);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, ed.cw(this.f31049s, 28.0f));
        layoutParams8.addRule(13);
        layoutParams8.addRule(3, this.jy.getId());
        int cw4 = ed.cw(this.f31049s, 20.0f);
        int cw5 = ed.cw(this.f31049s, 25.0f);
        int cw6 = ed.cw(this.f31049s, 6.0f);
        TextPaint paint = this.ws.getPaint();
        Rect rect = new Rect();
        CharSequence text = this.ws.getText();
        if (TextUtils.isEmpty(text)) {
            text = "";
        }
        String charSequence = text.toString();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        this.ws.setTextSize(13.0f);
        if (this.ws.getWidth() > (cw5 * 2) + rect.width() && this.ws.getHeight() > (cw6 * 2) + rect.height()) {
            layoutParams8.leftMargin = cw4;
            layoutParams8.rightMargin = cw4;
            this.ws.setPadding(cw5, ed.cw(this.f31049s, 5.0f), cw5, cw6);
        }
        this.ws.setEllipsize(TextUtils.TruncateAt.END);
        this.ws.setSingleLine(true);
        this.ws.setLayoutParams(layoutParams8);
    }

    public void up(int i6) {
        ed.j(this.f31041j, 0);
        com.bykv.vk.openvk.component.video.api.renderview.xt xtVar = this.xt;
        if (xtVar != null) {
            xtVar.setVisibility(i6);
        }
    }

    private void xt(com.bytedance.sdk.openadsdk.core.xt.j jVar) {
        n nVar;
        if (jVar == null || (nVar = this.ch) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.i.cw.xt.ws j6 = com.bytedance.sdk.openadsdk.core.video.r.j.j(Integer.valueOf(nVar.hashCode()));
        if (j6 instanceof com.bytedance.sdk.openadsdk.core.nativeexpress.v) {
            ((com.bytedance.sdk.openadsdk.core.nativeexpress.v) j6).j((com.bytedance.sdk.openadsdk.core.xt.j.cw.cw) jVar.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.cw.class));
        }
    }

    public void cw(int i6, int i7) {
        this.mi = i6;
        this.kt = i7;
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.ws.j
    public void j(View view, boolean z5) {
    }

    public void tl() {
        if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(this.ch)) {
            ed.j((View) this.nd, 8);
        } else {
            ed.up(this.f31048r);
        }
    }

    public void j(ViewGroup viewGroup) {
    }

    public void r(boolean z5) {
        this.f31046p = z5;
        if (z5) {
            com.bytedance.sdk.openadsdk.core.xt.j jVar = this.gq;
            if (jVar != null) {
                ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) jVar.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).cw(true);
            }
            com.bytedance.sdk.openadsdk.core.xt.j jVar2 = this.rn;
            if (jVar2 != null) {
                ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) jVar2.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).cw(true);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.xt.j jVar3 = this.gq;
        if (jVar3 != null) {
            ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) jVar3.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).cw(true);
            ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) this.gq.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(true);
        }
        com.bytedance.sdk.openadsdk.core.xt.j jVar4 = this.rn;
        if (jVar4 != null) {
            ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) jVar4.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).cw(true);
            ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) this.rn.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(true);
        }
    }

    public void cw(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        if (this.f31041j.getParent() == null) {
            viewGroup.addView(this.f31041j);
        }
        r(0);
    }

    public void j(String str) {
    }

    public void up(boolean z5) {
        this.xq = z5;
    }

    public void ae() {
        if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(this.ch)) {
            f();
        } else {
            ed();
        }
        ImageView imageView = this.cw;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        ed.j((View) this.cw, 8);
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.xt
    @SuppressLint({"ClickableViewAccessibility"})
    public /* bridge */ /* synthetic */ void j(n nVar, WeakReference weakReference, boolean z5) {
        j2(nVar, (WeakReference<Context>) weakReference, z5);
    }

    private void j(com.bytedance.sdk.openadsdk.core.xt.j jVar) {
        n nVar;
        if (jVar == null || (nVar = this.ch) == null || !com.bytedance.sdk.openadsdk.core.video.cw.j.j(nVar)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("click_live_element", "click_live_feed");
        ((com.bytedance.sdk.openadsdk.core.xt.j.cw.j) jVar.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.j.class)).j(hashMap);
    }

    private void xt(Context context, View view) {
        if (view == null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(2114387894);
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(2114387694);
        if (rn()) {
            ed.j((View) relativeLayout, 0);
            ed.j((View) relativeLayout2, 8);
            this.nd = relativeLayout;
        } else {
            ed.j((View) relativeLayout2, 0);
            ed.j((View) relativeLayout, 8);
            this.nd = relativeLayout2;
        }
        RelativeLayout relativeLayout3 = this.nd;
        if (relativeLayout3 == null) {
            return;
        }
        this.rh = (RoundImageView) relativeLayout3.findViewById(2114387837);
        this.ol = (TextView) this.nd.findViewById(2114387748);
        this.hh = (RelativeLayout) this.nd.findViewById(2114387699);
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.xt
    public View cw() {
        return this.f31041j;
    }

    public void j(NativeVideoTsView.j jVar) {
        this.f31045n = jVar;
    }

    public void j(jy jyVar) {
        j(jyVar, this.gq);
        j(jyVar, this.rn);
    }

    private void j(jy jyVar, com.bytedance.sdk.openadsdk.core.xt.j jVar) {
        f r5;
        if (jVar == null) {
            return;
        }
        ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) jVar.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(jyVar);
        com.bytedance.sdk.openadsdk.core.xt.j.cw.cw cwVar = (com.bytedance.sdk.openadsdk.core.xt.j.cw.cw) jVar.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.cw.class);
        if ((jyVar instanceof com.bytedance.sdk.openadsdk.core.f.r) && (r5 = ((com.bytedance.sdk.openadsdk.core.f.r) jyVar).r()) != null) {
            r5.j(cwVar);
        }
    }

    public void r(int i6) {
        this.f31050v = i6;
        ed.j(this.f31041j, i6);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.ws.j
    public void ws() {
    }

    private void xt(View view, Context context) {
        TTViewStub tTViewStub;
        if (view == null || context == null || (tTViewStub = this.av) == null || tTViewStub.getParent() == null || this.ed != null) {
            return;
        }
        this.av.j();
        this.ed = view.findViewById(2114387680);
        this.f31035c = (TextView) view.findViewById(2114387874);
        this.gx = (TextView) view.findViewById(2114387848);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.bytedance.sdk.openadsdk.upie.video.lottie.TTLottieVideoContainer] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView] */
    void j(Context context, View view, n nVar) {
        SSRenderTextureView sSRenderTextureView;
        System.currentTimeMillis();
        if (view != null) {
            view.setKeepScreenOn(true);
        }
        if (com.bytedance.sdk.openadsdk.up.j.xt(nVar)) {
            sSRenderTextureView = new TTLottieVideoContainer(this.f31049s);
        } else if (com.bytedance.sdk.openadsdk.up.j.cw(nVar)) {
            sSRenderTextureView = new UpieVideoView(context, com.bytedance.sdk.openadsdk.up.j.g(nVar));
        } else {
            sSRenderTextureView = new SSRenderTextureView(this.f31049s);
        }
        if (view instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            ((RelativeLayout) view).addView(sSRenderTextureView, 0, layoutParams);
            if (uf()) {
                view.setBackgroundColor(0);
            } else {
                view.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            }
        }
        ed.j((View) sSRenderTextureView, 8);
        this.xt = sSRenderTextureView;
        this.cw = (ImageView) view.findViewById(2114387632);
        this.az = (TTProgressBar) view.findViewById(2114387659);
        this.f31048r = view.findViewById(2114387906);
        this.up = view.findViewById(2114387637);
        this.f31044m = (ImageView) view.findViewById(2114387657);
        this.ae = (TTViewStub) view.findViewById(2114387750);
        this.f31053z = (TTViewStub) view.findViewById(2114387672);
        this.av = (TTViewStub) view.findViewById(2114387834);
        if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(nVar)) {
            xt(context, view);
        }
        System.currentTimeMillis();
    }

    public m(Context context, View view, boolean z5, EnumSet<xt.j> enumSet, n nVar, com.bykv.vk.openvk.component.video.api.r.cw cwVar, com.bytedance.sdk.openadsdk.core.xt.j jVar) {
        this(context, view, z5, enumSet, nVar, cwVar, true, jVar);
    }

    public void xt(boolean z5, boolean z6) {
        ImageView imageView = this.cw;
        if (imageView != null) {
            if (z5) {
                kt.j(this.f31049s, "tt_play_movebar_textpage", imageView);
            } else {
                kt.j(this.f31049s, "tt_stop_movebar_textpage", imageView);
            }
        }
    }

    public void xt(int i6, int i7) {
        ViewGroup.LayoutParams layoutParams;
        View view = this.f31041j;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        if (i6 == -1 || i6 == -2 || i6 > 0) {
            layoutParams.width = i6;
        }
        if (i7 == -1 || i7 == -2 || i7 > 0) {
            layoutParams.height = i7;
        }
        this.f31041j.setLayoutParams(layoutParams);
    }

    public void xt(int i6) {
        vl.j("Progress", "setSeekProgress-percent=".concat(String.valueOf(i6)));
        ed.j((View) this.az, 0);
        TTProgressBar tTProgressBar = this.az;
        if (tTProgressBar != null) {
            tTProgressBar.setProgress(i6);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.xt
    public void xt() {
        if (uf()) {
            ed.j(this.f31048r, 8);
            ed.j(this.up, 8);
            ed.j((View) this.f31044m, 8);
            ed.j((View) this.cw, 8);
            return;
        }
        ed.j((View) this.nd, 8);
        ed.up(this.f31048r);
        ed.up(this.up);
        ImageView imageView = this.f31044m;
        if (imageView != null) {
            ed.up(imageView);
        }
    }

    protected void j(Context context, View view) {
        TTViewStub tTViewStub;
        if (view == null || context == null || (tTViewStub = this.f31053z) == null || tTViewStub.getParent() == null || this.hl != null) {
            return;
        }
        this.hl = this.f31053z.j();
        this.f31034b = (RelativeLayout) view.findViewById(2114387953);
        this.f31036e = (RoundImageView) view.findViewById(2114387958);
        this.f31047q = (TextView) view.findViewById(2114387932);
        this.qb = (TextView) view.findViewById(2114387883);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.j
    public void xt(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != this.xt.getHolder()) {
            return;
        }
        this.f31037f = false;
        if (tj()) {
            this.f31043l.xt(this, surfaceHolder);
        }
    }

    void j(View view, Context context) {
        TTViewStub tTViewStub;
        if (view == null || context == null || (tTViewStub = this.ae) == null || tTViewStub.getParent() == null || this.tl != null) {
            return;
        }
        this.tl = this.ae.j();
        this.ae.setVisibility(0);
        this.f31038g = (ImageView) view.findViewById(2114387810);
        this.oq = view.findViewById(2114387961);
        this.qv = (RoundImageView) view.findViewById(2114387670);
        this.vl = (TextView) view.findViewById(2114387957);
        this.jy = (TextView) view.findViewById(2114387770);
        this.ws = (TextView) view.findViewById(2114387692);
    }

    public boolean j(int i6, com.bykv.vk.openvk.component.video.api.cw.cw cwVar, boolean z5) {
        az azVar = this.f31033a;
        return azVar == null || azVar.j(i6, cwVar, z5);
    }

    public void j(com.bykv.vk.openvk.component.video.api.r.j jVar) {
        if (jVar instanceof xt) {
            this.f31043l = (xt) jVar;
            mi();
        }
    }

    public void j(int i6, int i7) {
        if (i6 == -1) {
            i6 = ed.r(this.f31049s);
        }
        if (i6 <= 0) {
            return;
        }
        this.f31040i = i6;
        if (!qv() && !oq() && !this.f31052x.contains(xt.j.fixedSize)) {
            this.f31051w = ae(i6);
        } else {
            this.f31051w = i7;
        }
        xt(this.f31040i, this.f31051w);
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.xt
    public void j() {
        j(false, this.tj);
        ch();
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.xt
    public void j(boolean z5) {
        this.uf = z5;
    }

    protected void j(final ImageView imageView, String str) {
        if (imageView == null || !com.bytedance.sdk.openadsdk.up.j.j(this.ch) || com.bytedance.sdk.openadsdk.up.j.ae(this.ch)) {
            return;
        }
        com.bytedance.sdk.openadsdk.g.xt.j(str).j(Bitmap.Config.ARGB_4444).cw(2).j(new av<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.m.12
            @Override // com.bytedance.sdk.component.m.av
            @ATSMethod(2)
            public void j(int i6, String str2, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.m.av
            @ATSMethod(1)
            public void j(qv<Bitmap> qvVar) {
                Bitmap cw;
                if (qvVar == null || (cw = qvVar.cw()) == null) {
                    return;
                }
                final Bitmap j6 = com.bytedance.sdk.component.adexpress.r.xt.j(m.this.f31049s, cw, 25);
                com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.m.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j6 != null) {
                            imageView.setBackground(new BitmapDrawable(j6));
                        }
                    }
                });
            }
        }, 4);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: j, reason: avoid collision after fix types in other method */
    public void j2(n nVar, WeakReference<Context> weakReference, boolean z5) {
        String str;
        n nVar2;
        if (nVar == null || uf()) {
            return;
        }
        j(false, this.tj);
        if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(nVar)) {
            j(v.getContext(), this.f31041j);
            w();
            return;
        }
        j(this.f31041j, v.getContext());
        View view = this.tl;
        if (view != null) {
            ed.j(view, 0);
        }
        ImageView imageView = this.f31038g;
        if (imageView != null) {
            ed.j((View) imageView, 0);
        }
        if (uf.cw(this.ch)) {
            xt(this.f31041j, v.getContext());
            ed.j(this.oq, 8);
            ed.j((View) this.f31038g, 0);
            ed.j(this.ed, 0);
            ed.j((View) this.f31035c, 0);
            ed.j((View) this.gx, 0);
            if (this.gx != null && com.bytedance.sdk.component.utils.ws.cw(v.getContext()) == 0) {
                ed.j((View) this.gx, 8);
            }
            View view2 = this.tl;
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.m.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        com.bykv.vk.openvk.component.video.api.r.cw cwVar = m.this.la;
                        if (cwVar != null) {
                            ((com.bykv.vk.openvk.component.video.api.r.j) cwVar).j();
                            com.bytedance.sdk.openadsdk.f.j.xt.j.j jVar = m.this.wq;
                            if (jVar != null) {
                                jVar.j();
                            }
                        }
                    }
                });
            }
            if (this.f31038g != null && !TextUtils.isEmpty(ln.xt(this.ch))) {
                if (com.bytedance.sdk.openadsdk.up.j.xt(nVar)) {
                    com.bytedance.sdk.openadsdk.g.xt.j(ln.xt(this.ch)).j(this.f31038g);
                    j(this.f31038g, ln.xt(this.ch));
                } else {
                    com.bykv.vk.openvk.component.video.j.up.xt.j(2147483647L, ln.j(this.ch), new xt.InterfaceC0309xt() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.m.3
                        @Override // com.bykv.vk.openvk.component.video.j.up.xt.InterfaceC0309xt
                        public void j(Bitmap bitmap) {
                            if (bitmap == null) {
                                com.bytedance.sdk.openadsdk.g.xt.j(ln.xt(m.this.ch)).j(m.this.f31038g);
                                return;
                            }
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) m.this.f31038g.getLayoutParams();
                            if (bitmap.getWidth() > bitmap.getHeight()) {
                                float height = (bitmap.getHeight() * ed.r(v.getContext())) / bitmap.getWidth();
                                layoutParams.width = ed.r(v.getContext());
                                layoutParams.height = (int) height;
                                layoutParams.addRule(13);
                                m.this.f31038g.setLayoutParams(layoutParams);
                            }
                            m.this.f31038g.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        } else {
            ed.j(this.oq, 0);
            if (this.f31038g != null && !TextUtils.isEmpty(ln.xt(this.ch))) {
                com.bytedance.sdk.openadsdk.g.xt.j(ln.xt(this.ch)).j(this.f31038g);
                j(this.f31038g, ln.xt(this.ch));
            }
            if (gx()) {
                this.oq.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.m.4
                    @Override // java.lang.Runnable
                    public void run() {
                        m.this.c();
                    }
                });
            }
        }
        if (!TextUtils.isEmpty(nVar.rs())) {
            str = nVar.rs();
        } else if (!TextUtils.isEmpty(nVar.hw())) {
            str = nVar.hw();
        } else if (!TextUtils.isEmpty(nVar.zk())) {
            str = nVar.zk();
        } else {
            str = "";
        }
        if (this.qv != null && (nVar2 = this.ch) != null && nVar2.ig() != null && this.ch.ig().j() != null) {
            ed.j((View) this.qv, 0);
            ed.j((View) this.vl, 4);
            com.bytedance.sdk.openadsdk.g.xt.j(this.ch.ig()).j(this.qv);
            if (la()) {
                this.qv.setOnClickListener(this.rn);
                this.qv.setOnTouchListener(this.rn);
            } else {
                this.qv.setOnClickListener(this.gq);
                this.qv.setOnTouchListener(this.gq);
            }
        } else if (!TextUtils.isEmpty(str)) {
            ed.j((View) this.qv, 4);
            ed.j((View) this.vl, 0);
            TextView textView = this.vl;
            if (textView != null) {
                textView.setText(str.substring(0, 1));
                if (la()) {
                    this.vl.setOnClickListener(this.rn);
                    this.vl.setOnTouchListener(this.rn);
                } else {
                    this.vl.setOnClickListener(this.gq);
                    this.vl.setOnTouchListener(this.gq);
                }
            }
        }
        if (this.jy != null && !TextUtils.isEmpty(str)) {
            this.jy.setText(str);
        }
        ed.j((View) this.jy, 0);
        ed.j((View) this.ws, 0);
        String sf = nVar.sf();
        if (TextUtils.isEmpty(sf)) {
            int jl = nVar.jl();
            if (jl == 4) {
                sf = "立即下载";
            } else if (jl != 5) {
                sf = "查看详情";
            } else {
                sf = "立即拨打";
            }
        }
        TextView textView2 = this.ws;
        if (textView2 != null) {
            textView2.setText(sf);
            this.ws.setOnClickListener(this.gq);
            this.ws.setOnTouchListener(this.gq);
        }
        TextView textView3 = this.f31035c;
        if (textView3 != null) {
            textView3.setText(sf);
            this.f31035c.setOnClickListener(this.gq);
            this.f31035c.setOnTouchListener(this.gq);
        }
        if (this.uf) {
            return;
        }
        tl(4);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.j
    public void j(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != this.xt.getHolder()) {
            return;
        }
        this.f31037f = true;
        if (tj()) {
            this.f31043l.j(this, surfaceHolder);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.j
    public void j(SurfaceHolder surfaceHolder, int i6, int i7, int i8) {
        if (surfaceHolder != this.xt.getHolder()) {
            return;
        }
        tj();
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.j
    public void j(SurfaceTexture surfaceTexture, int i6, int i7) {
        this.f31037f = true;
        if (tj()) {
            this.f31043l.j(this, surfaceTexture);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.j
    public boolean j(SurfaceTexture surfaceTexture) {
        this.f31037f = false;
        if (!tj()) {
            return true;
        }
        this.f31043l.xt(this, surfaceTexture);
        return true;
    }

    public void j(boolean z5, boolean z6, boolean z7) {
        ed.j((View) this.az, 0);
        ed.j((View) this.cw, (z5 && (ed.r(this.f31048r) && ed.r(this.nd))) ? 0 : 8);
    }

    public void j(boolean z5, boolean z6) {
        ed.j((View) this.az, z5 ? 0 : 8);
        ed.j((View) this.cw, 8);
    }

    public void j(com.bytedance.sdk.openadsdk.f.j.xt.j.j jVar) {
        this.wq = jVar;
        com.bytedance.sdk.openadsdk.core.xt.j jVar2 = this.gq;
        if (jVar2 != null) {
            ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) jVar2.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(jVar);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.xt
    public void j(Drawable drawable) {
        View view = this.f31041j;
        if (view != null) {
            view.setBackgroundDrawable(drawable);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.xt
    public void j(int i6) {
        ed.j((View) this.hh, i6);
    }

    public void j(j.InterfaceC0466j interfaceC0466j) {
        this.ff = interfaceC0466j;
        com.bytedance.sdk.openadsdk.core.qv.xt.cw cwVar = this.f31039h;
        if (cwVar != null) {
            cwVar.j(interfaceC0466j);
        }
    }
}
