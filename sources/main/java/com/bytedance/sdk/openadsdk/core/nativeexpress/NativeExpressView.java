package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.bykv.vk.openvk.component.video.api.r.cw;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.adexpress.xt.jy;
import com.bytedance.sdk.component.adexpress.xt.oq;
import com.bytedance.sdk.component.qv.j.xt;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.rn;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.h;
import com.bytedance.sdk.openadsdk.core.tj.hh;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.ya;
import com.bytedance.sdk.openadsdk.core.uf;
import com.bytedance.sdk.openadsdk.core.ugeno.express.xt;
import com.bytedance.sdk.openadsdk.core.xt.r;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.umeng.analytics.pro.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class NativeExpressView extends FrameLayout implements com.bytedance.sdk.component.adexpress.dynamic.r, com.bytedance.sdk.component.adexpress.theme.j, com.bytedance.sdk.component.adexpress.xt.az, com.bytedance.sdk.component.adexpress.xt.tl, qv {

    /* renamed from: w, reason: collision with root package name */
    public static int f29606w = 500;

    /* renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.m.j f29607a;
    protected String ae;
    private float aq;
    protected com.bytedance.sdk.component.adexpress.xt.cw av;
    protected boolean az;

    /* renamed from: b, reason: collision with root package name */
    private volatile com.bytedance.sdk.component.adexpress.xt.ws f29608b;

    /* renamed from: c, reason: collision with root package name */
    private ThemeStatusBroadcastReceiver f29609c;
    private float ch;
    private com.bytedance.sdk.openadsdk.core.dislike.ui.j cw;

    /* renamed from: e, reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.xt.g f29610e;
    private final Runnable ed;

    /* renamed from: f, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.xt.xt f29611f;
    private boolean ff;

    /* renamed from: g, reason: collision with root package name */
    protected n f29612g;
    private FrameLayout gq;
    private s gx;

    /* renamed from: h, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ugeno.oq.j f29613h;
    private com.bytedance.sdk.component.adexpress.xt.xt hh;
    private com.bytedance.sdk.openadsdk.core.ugeno.express.up hl;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f29614i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f29615j;
    protected FrameLayout jy;

    /* renamed from: k, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.splash.countdown.cw f29616k;
    private float kc;
    protected FrameLayout kt;

    /* renamed from: l, reason: collision with root package name */
    private boolean f29617l;
    private FrameLayout la;

    /* renamed from: m, reason: collision with root package name */
    protected final Context f29618m;
    protected boolean mi;

    /* renamed from: n, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ugeno.express.m f29619n;
    private oq.j nd;
    private com.bytedance.sdk.component.adexpress.xt.av ol;
    protected ExpressVideoView oq;

    /* renamed from: p, reason: collision with root package name */
    private ya f29620p;
    private View pz;

    /* renamed from: q, reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.xt.r<? extends View> f29621q;
    private com.bytedance.sdk.component.adexpress.xt.jy qb;
    protected cw.r qv;

    /* renamed from: r, reason: collision with root package name */
    private Dialog f29622r;
    private List<com.bytedance.sdk.component.adexpress.xt.oq> rh;
    private final ViewTreeObserver.OnScrollChangedListener rn;
    private float rr;
    private SparseArray<r.j> ry;

    /* renamed from: s, reason: collision with root package name */
    private float f29623s;
    private boolean sm;
    private long st;
    private com.bytedance.sdk.openadsdk.core.xt.j tj;
    protected com.bytedance.sdk.openadsdk.i.cw.cw.xt tl;
    private final Runnable uf;
    private j up;

    /* renamed from: v, reason: collision with root package name */
    private final AtomicBoolean f29624v;
    protected cw.InterfaceC0306cw vl;
    private final Runnable wq;
    protected boolean ws;

    /* renamed from: x, reason: collision with root package name */
    private String f29625x;
    private f xq;
    private int xt;
    private i ya;

    /* renamed from: z, reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.xt.m f29626z;
    private float zz;

    public NativeExpressView(Context context, n nVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, String str) {
        super(context);
        this.f29615j = true;
        this.xt = 0;
        this.ae = "embeded_ad";
        this.f29624v = new AtomicBoolean(false);
        this.f29625x = null;
        this.az = false;
        this.f29614i = false;
        this.mi = false;
        this.f29617l = false;
        this.rn = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                NativeExpressView nativeExpressView = NativeExpressView.this;
                nativeExpressView.removeCallbacks(nativeExpressView.wq);
                NativeExpressView nativeExpressView2 = NativeExpressView.this;
                nativeExpressView2.postDelayed(nativeExpressView2.wq, 500L);
            }
        };
        this.wq = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.2
            @Override // java.lang.Runnable
            public void run() {
                if (!uf.xt(NativeExpressView.this, 0, 5)) {
                    NativeExpressView.this.r(8);
                } else {
                    NativeExpressView nativeExpressView = NativeExpressView.this;
                    nativeExpressView.r(nativeExpressView.getVisibility());
                }
            }
        };
        this.uf = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.3
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.r(0);
            }
        };
        this.ed = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.4
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.r(8);
            }
        };
        this.ry = new SparseArray<>();
        this.zz = -1.0f;
        this.kc = -1.0f;
        this.aq = -1.0f;
        this.rr = -1.0f;
        this.st = 0L;
        this.ae = str;
        this.f29618m = context;
        this.f29612g = nVar;
        this.tl = xtVar;
        vl();
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.az
    public void a_(final int i6) {
        this.ff = true;
        if (!this.f29615j) {
            this.f29610e.qv();
        }
        this.f29610e.vl();
        com.bytedance.sdk.component.adexpress.xt.g gVar = this.f29610e;
        if (gVar instanceof oq) {
            ((oq) gVar).ws();
        }
        if (this.up != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.up.j(this, com.bytedance.sdk.openadsdk.core.g.j(i6), i6);
            } else {
                com.bytedance.sdk.openadsdk.core.tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (NativeExpressView.this.up != null) {
                            NativeExpressView.this.up.j(NativeExpressView.this, com.bytedance.sdk.openadsdk.core.g.j(i6), i6);
                        }
                    }
                });
            }
        }
    }

    public int cw() {
        return 0;
    }

    public com.bykv.vk.openvk.component.video.api.r.cw getVideoController() {
        return null;
    }

    public long j() {
        return 0L;
    }

    public void r() {
    }

    public void up() {
    }

    public int xt() {
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v17, types: [com.bytedance.sdk.component.adexpress.xt.jy$j] */
    private void ch() {
        xt.j jVar;
        List<h> fp;
        h hVar;
        boolean tl = hh.tl(this.f29612g);
        JSONObject jSONObject = null;
        if (!az()) {
            if (tl) {
                jSONObject = com.bytedance.sdk.openadsdk.core.nativeexpress.xt.xt.j(this.f29612g, com.bytedance.sdk.openadsdk.core.nativeexpress.xt.xt.j(this.ch, this.f29623s, this.az), com.bytedance.sdk.openadsdk.core.nativeexpress.xt.xt.j(this.f29612g), false);
            } else if (!com.bytedance.sdk.openadsdk.core.ugeno.oq.g(this.f29612g)) {
                jSONObject = com.bytedance.sdk.openadsdk.core.nativeexpress.xt.xt.j(this.ch, this.f29623s, this.az, this.f29612g);
            } else if (hh.m(this.f29612g) != null && !TextUtils.isEmpty(hh.m(this.f29612g).g())) {
                jSONObject = com.bytedance.sdk.openadsdk.core.ugeno.oq.xt(hh.m(this.f29612g).oq(), hh.m(this.f29612g).g());
            }
            if (hh.m(this.f29612g) != null) {
                com.bytedance.sdk.openadsdk.core.r.j().j(hh.m(this.f29612g).xt());
            }
            if (hh.ae(this.f29612g) != null) {
                com.bytedance.sdk.openadsdk.core.r.j().j(hh.ae(this.f29612g).j());
            }
        }
        this.f29607a = p();
        if (az()) {
            this.f29610e = new kt();
        } else {
            this.f29610e = new oq(this.f29607a, this.ae, this.f29612g, this.f29625x);
        }
        boolean l6 = l();
        if (com.bytedance.sdk.openadsdk.core.ugeno.oq.g(this.f29612g) || com.bytedance.sdk.openadsdk.core.ugeno.oq.oq(this.f29612g) || com.bytedance.sdk.openadsdk.core.ugeno.j.j.xt(this.f29612g) || s()) {
            xt.j jVar2 = new xt.j();
            jVar2.up(com.bytedance.sdk.openadsdk.core.ugeno.oq.j(this.f29612g, (View) this, false));
            jVar2.j((com.bytedance.adsdk.ugeno.cw.f) this.f29610e);
            jVar2.j(this.ch);
            jVar2.xt(this.f29623s);
            jVar2.r(s());
            jVar = jVar2;
        } else {
            jVar = new jy.j();
        }
        jVar.cw(tl);
        if (TextUtils.equals(this.ae, "splash_ad")) {
            jVar.m(com.bytedance.sdk.openadsdk.l.g.up());
        }
        if (hh.xt(this.f29612g) == 3 && com.bytedance.sdk.openadsdk.up.j.r(this.f29612g) && (fp = this.f29612g.fp()) != null && !fp.isEmpty() && (hVar = fp.get(0)) != null) {
            jVar.g(hVar.j());
            jVar.j(new UpieImageView(this.f29618m, com.bytedance.sdk.openadsdk.up.j.g(this.f29612g), com.bytedance.sdk.openadsdk.up.j.oq(this.f29612g)));
        }
        this.qb = jVar.j(this.ae).xt(this.f29612g.fs()).cw(com.bytedance.sdk.openadsdk.core.rn.uf.av(this.f29612g)).r(this.f29612g.os()).j(jSONObject).j(this.f29610e).j(com.bytedance.sdk.openadsdk.core.v.xt().j(this.ae, hh.xt(this.f29612g))).xt(l6).xt(this.f29612g.ry()).cw(this.f29612g.jl()).up(com.bytedance.sdk.openadsdk.core.nativeexpress.xt.xt.r(this.f29612g)).j(com.bytedance.sdk.openadsdk.core.nativeexpress.xt.xt.up(this.f29612g)).r(getRenderThread()).up(this.f29612g.si()).m(this.f29612g.ho()).ae(this.f29612g.km()).xt(this.f29612g.mt()).cw(this.f29612g.xn()).r(this.f29612g.lr()).g(this.f29612g.qo()).tl(this.f29612g.wo()).ae(this.f29612g.ek()).tl("https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/").j(com.bytedance.sdk.openadsdk.core.oq.i().up()).oq(this.f29612g.ae()).j();
    }

    private boolean h() {
        return TextUtils.equals(this.ae, "splash_ad") || TextUtils.equals(this.ae, "cache_splash_ad");
    }

    private boolean l() {
        if (TextUtils.equals(this.ae, "rewarded_video") || TextUtils.equals(this.ae, "fullscreen_interstitial_ad")) {
            return this.f29612g.xa();
        }
        return true;
    }

    private void la() {
        NativeExpressView nativeExpressView;
        this.xt = hh.xt(this.f29612g);
        if (h() && hh.j(this.f29612g) == 1) {
            this.xt = 1000;
        }
        com.bytedance.sdk.openadsdk.core.vl.j.j jVar = new com.bytedance.sdk.openadsdk.core.vl.j.j(this.f29612g, new WeakReference(this));
        int i6 = this.xt;
        if (i6 != 3) {
            if (i6 == 7) {
                com.bytedance.sdk.openadsdk.core.ugeno.express.r rVar = new com.bytedance.sdk.openadsdk.core.ugeno.express.r(this.f29618m, this.f29612g, (com.bytedance.sdk.openadsdk.core.ugeno.express.xt) this.qb, this);
                this.f29617l = rVar.g();
                com.bytedance.sdk.openadsdk.core.ugeno.express.up upVar = new com.bytedance.sdk.openadsdk.core.ugeno.express.up(this.f29618m, rVar, this, this.qb);
                this.hl = upVar;
                this.rh.add(upVar);
            } else if (i6 == 10) {
                com.bytedance.sdk.openadsdk.core.ugeno.express.m mVar = new com.bytedance.sdk.openadsdk.core.ugeno.express.m(this.f29618m, this.f29612g, (com.bytedance.sdk.openadsdk.core.ugeno.express.xt) this.qb, this);
                this.f29619n = mVar;
                this.f29617l = mVar.g();
                com.bytedance.sdk.openadsdk.core.ugeno.express.up upVar2 = new com.bytedance.sdk.openadsdk.core.ugeno.express.up(this.f29618m, this.f29619n, this, this.qb);
                this.hl = upVar2;
                this.rh.add(upVar2);
            } else if (i6 != 1000) {
                s sVar = new s(this.f29618m, this.qb, this.f29609c, this.f29607a, this.f29612g, this.f29610e);
                this.gx = sVar;
                com.bytedance.sdk.component.adexpress.xt.av avVar = new com.bytedance.sdk.component.adexpress.xt.av(this.f29618m, this.qb, sVar, this);
                this.ol = avVar;
                this.rh.add(avVar);
            }
            nativeExpressView = this;
        } else {
            nativeExpressView = this;
            com.bytedance.sdk.component.adexpress.xt.xt xtVar = new com.bytedance.sdk.component.adexpress.xt.xt(this.f29618m, this.qb, this.f29609c, this.mi, new com.bytedance.sdk.component.adexpress.dynamic.r.ae(), nativeExpressView, jVar);
            nativeExpressView.hh = xtVar;
            nativeExpressView.rh.add(xtVar);
            nativeExpressView.hh.j(com.bytedance.sdk.openadsdk.core.v.xt().ot());
        }
        int cw = hh.cw(nativeExpressView.f29612g);
        if (cw > 0 && s() && TextUtils.equals(nativeExpressView.ae, "embeded_ad")) {
            nativeExpressView.rh.add(new com.bytedance.sdk.openadsdk.core.ugeno.express.up(nativeExpressView.f29618m, new com.bytedance.sdk.openadsdk.core.ugeno.j.cw(nativeExpressView.f29618m, nativeExpressView.f29612g, (com.bytedance.sdk.openadsdk.core.ugeno.express.xt) nativeExpressView.qb, this), this, nativeExpressView.qb));
        } else {
            boolean z5 = cw == 1;
            nativeExpressView.f29615j = z5;
            if (z5 || nativeExpressView.xt == 1000) {
                com.bytedance.sdk.component.adexpress.xt.m mVar2 = new com.bytedance.sdk.component.adexpress.xt.m(nativeExpressView.f29618m, nativeExpressView.qb, new mi(this, nativeExpressView.f29609c, nativeExpressView.qb));
                nativeExpressView.f29626z = mVar2;
                nativeExpressView.rh.add(mVar2);
            } else if (com.bytedance.sdk.openadsdk.core.ugeno.j.j.xt(nativeExpressView.f29612g)) {
                nativeExpressView.rh.add(new com.bytedance.sdk.openadsdk.core.ugeno.express.up(nativeExpressView.f29618m, new com.bytedance.sdk.openadsdk.core.ugeno.j.cw(nativeExpressView.f29618m, nativeExpressView.f29612g, (com.bytedance.sdk.openadsdk.core.ugeno.express.xt) nativeExpressView.qb, this), this, nativeExpressView.qb));
            }
        }
        nativeExpressView.nd = new com.bytedance.sdk.component.adexpress.xt.vl(nativeExpressView.rh, nativeExpressView.f29610e);
    }

    private com.bytedance.sdk.openadsdk.m.j p() {
        JSONObject jSONObject = new JSONObject();
        com.bytedance.sdk.openadsdk.core.jy.tl tlVar = new com.bytedance.sdk.openadsdk.core.jy.tl(this.ae, this.f29612g, jSONObject);
        tlVar.j(jSONObject, "webview_source", (Object) 1);
        return tlVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rn() {
        com.bytedance.sdk.openadsdk.m.j jVar = this.f29607a;
        if (jVar instanceof com.bytedance.sdk.openadsdk.core.jy.tl) {
            ((com.bytedance.sdk.openadsdk.core.jy.tl) jVar).xt(this.qb.tl());
        }
        this.f29607a.j();
        this.nd.j(this);
        this.nd.j();
    }

    private boolean s() {
        com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar = this.tl;
        return xtVar != null && com.bytedance.sdk.openadsdk.core.h.xt >= 5900 && xtVar.s();
    }

    private boolean uf() {
        n nVar = this.f29612g;
        return nVar != null && nVar.k() == 1 && n.xt(this.f29612g);
    }

    private void v() {
        com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar;
        if (TextUtils.equals(this.ae, "splash_ad") && (xtVar = this.tl) != null && this.f29623s == xtVar.ae() && this.ch == this.tl.m()) {
            this.f29623s = ed.r(this.f29618m, this.f29623s);
            int r5 = ed.r(this.f29618m);
            if (this.ch < r5) {
                this.ch = ed.r(this.f29618m, r0);
            } else {
                this.ch = ed.r(this.f29618m, r1);
            }
        }
    }

    private void wq() {
        Dialog dialog = this.f29622r;
        if (dialog != null) {
            dialog.show();
            return;
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.j jVar = this.cw;
        if (jVar != null) {
            jVar.j();
        } else {
            TTDelegateActivity.j(getContext(), this.f29612g);
        }
    }

    private void ws() {
        ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver = new ThemeStatusBroadcastReceiver();
        this.f29609c = themeStatusBroadcastReceiver;
        themeStatusBroadcastReceiver.j(this);
    }

    private void x() {
        try {
            if (this.f29609c == null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.bytedance.openadsdk.themeTypeChangeReceiver");
            this.f29618m.registerReceiver(this.f29609c, intentFilter, com.bytedance.sdk.openadsdk.core.rn.uf.s(), null);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
    }

    public void ae() {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.cw cwVar = this.f29616k;
        if (cwVar != null) {
            cwVar.j();
        }
    }

    public void av() {
        com.bytedance.sdk.component.adexpress.xt.r<? extends View> rVar = this.f29621q;
        if (rVar instanceof ws) {
            ((ws) rVar).tl();
        }
        gq();
    }

    @Override // com.bytedance.sdk.component.adexpress.theme.j
    public void b_(int i6) {
        com.bytedance.sdk.component.adexpress.xt.r<? extends View> rVar = this.f29621q;
        if (rVar == null || !(rVar instanceof ws)) {
            return;
        }
        ((ws) rVar).b_(i6);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i6;
        com.bytedance.sdk.openadsdk.core.xt.j jVar = this.tj;
        if (jVar != null) {
            jVar.cw(motionEvent.getDeviceId());
            this.tj.xt(motionEvent.getSource());
            this.tj.r(motionEvent.getToolType(0));
        }
        com.bytedance.sdk.openadsdk.core.xt.xt xtVar = this.f29611f;
        if (xtVar != null) {
            xtVar.cw(motionEvent.getDeviceId());
            this.f29611f.xt(motionEvent.getSource());
            this.f29611f.r(motionEvent.getToolType(0));
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.zz = motionEvent.getRawX();
            this.kc = motionEvent.getRawY();
            this.st = System.currentTimeMillis();
            i6 = 0;
        } else if (actionMasked == 1) {
            i6 = 3;
        } else if (actionMasked != 2) {
            i6 = actionMasked != 3 ? -1 : 4;
        } else {
            this.aq += Math.abs(motionEvent.getX() - this.zz);
            this.rr += Math.abs(motionEvent.getY() - this.kc);
            this.zz = motionEvent.getX();
            this.kc = motionEvent.getY();
            i6 = (System.currentTimeMillis() - this.st <= 200 || (this.aq <= 8.0f && this.rr <= 8.0f)) ? 2 : 1;
        }
        SparseArray<r.j> sparseArray = this.ry;
        if (sparseArray != null) {
            sparseArray.put(motionEvent.getActionMasked(), new r.j(i6, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void f() {
        f fVar = this.xq;
        if (fVar != null) {
            fVar.r();
        }
    }

    public long getActualPlayDuration() {
        return 0L;
    }

    public com.bytedance.sdk.openadsdk.core.xt.j getClickCreativeListener() {
        return this.tj;
    }

    public com.bytedance.sdk.openadsdk.core.xt.xt getClickListener() {
        return this.f29611f;
    }

    public int getDynamicShowType() {
        com.bytedance.sdk.component.adexpress.xt.r<? extends View> rVar = this.f29621q;
        if (rVar != null) {
            return rVar.cw();
        }
        return 0;
    }

    public FrameLayout getEasyPlayableLayout() {
        return this.gq;
    }

    public int getExpectExpressHeight() {
        return Float.valueOf(this.f29623s).intValue();
    }

    public int getExpectExpressWidth() {
        return Float.valueOf(this.ch).intValue();
    }

    public j getExpressInteractionListener() {
        return this.up;
    }

    public rn getJsObject() {
        s sVar = this.gx;
        if (sVar != null) {
            return sVar.D_();
        }
        return null;
    }

    public int getRenderEngineCacheType() {
        ae az;
        com.bytedance.sdk.component.adexpress.xt.r<? extends View> rVar = this.f29621q;
        if (!(rVar instanceof s) || (az = ((s) rVar).az()) == null) {
            return 0;
        }
        return az.j();
    }

    public com.bytedance.sdk.openadsdk.core.ugeno.express.m getUGenV3Render() {
        return this.f29619n;
    }

    public ViewGroup getVideoContainer() {
        return this.jy;
    }

    public SSWebView getWebView() {
        s sVar = this.gx;
        if (sVar == null) {
            return null;
        }
        return sVar.j();
    }

    public void j(float f6) {
    }

    public void kt() {
        com.bytedance.sdk.component.adexpress.xt.r<? extends View> rVar = this.f29621q;
        if (!(rVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.r) || (rVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.m)) {
            return;
        }
        ((com.bytedance.sdk.openadsdk.core.ugeno.express.r) rVar).xt();
    }

    public void mi() {
        try {
            FrameLayout frameLayout = this.jy;
            if (frameLayout == null || frameLayout.getParent() == null) {
                return;
            }
            removeView(this.jy);
        } catch (Throwable unused) {
        }
    }

    public void r(int i6) {
        com.bytedance.sdk.component.adexpress.xt.r<? extends View> rVar = this.f29621q;
        if (rVar == null || !(rVar instanceof ws)) {
            return;
        }
        ((ws) rVar).xt(i6);
    }

    public void setBackupListener(com.bytedance.sdk.component.adexpress.xt.cw cwVar) {
        this.av = cwVar;
        com.bytedance.sdk.component.adexpress.xt.m mVar = this.f29626z;
        if (mVar != null) {
            mVar.j(cwVar);
        }
    }

    public void setClickCreativeListener(com.bytedance.sdk.openadsdk.core.xt.j jVar) {
        this.tj = jVar;
    }

    public void setClickListener(com.bytedance.sdk.openadsdk.core.xt.xt xtVar) {
        this.f29611f = xtVar;
    }

    public void setDislike(com.bytedance.sdk.openadsdk.core.dislike.ui.j jVar) {
        BackupView backupView;
        com.bytedance.sdk.component.adexpress.xt.r<? extends View> rVar = this.f29621q;
        if (rVar != null && (rVar instanceof mi) && (backupView = (BackupView) rVar.ae()) != null) {
            backupView.setDislikeInner(jVar);
        }
        this.cw = jVar;
    }

    public void setDynamicSkipListener(com.bytedance.sdk.openadsdk.core.component.splash.countdown.cw cwVar) {
        this.f29616k = cwVar;
    }

    public void setEasyPlayableSender(com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ae aeVar) {
        ExpressVideoView expressVideoView = this.oq;
        if (expressVideoView == null) {
            return;
        }
        expressVideoView.setEasyPlayableEventSender(aeVar);
    }

    public void setExpressInteractionListener(j jVar) {
        this.up = jVar;
    }

    public void setOuterDislike(Dialog dialog) {
        BackupView backupView;
        com.bytedance.sdk.component.adexpress.xt.r<? extends View> rVar = this.f29621q;
        if (rVar != null && (rVar instanceof mi) && (backupView = (BackupView) rVar.ae()) != null) {
            backupView.setDislikeOuter(dialog);
        }
        this.f29622r = dialog;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.r
    public void setSoundMute(boolean z5) {
        this.mi = z5;
        com.bytedance.sdk.component.adexpress.xt.xt xtVar = this.hh;
        if (xtVar != null && xtVar.xt() != null) {
            this.hh.xt().setSoundMute(z5);
        }
        if (this.f29621q.cw() == 7) {
            com.bytedance.sdk.component.adexpress.xt.r<? extends View> rVar = this.f29621q;
            if (rVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.r) {
                ((com.bytedance.sdk.component.adexpress.dynamic.r) rVar).setSoundMute(z5);
            }
        }
    }

    public void setVideoAdInteractionListener(cw.InterfaceC0306cw interfaceC0306cw) {
        this.vl = interfaceC0306cw;
    }

    public void setVideoAdListener(cw.r rVar) {
        this.qv = rVar;
    }

    public boolean tj() {
        com.bytedance.sdk.component.adexpress.xt.r<? extends View> rVar = this.f29621q;
        return rVar != null && rVar.cw() == 1;
    }

    public void up(int i6) {
        this.qb.j(i6);
    }

    protected void vl() {
        this.kt = new FrameLayout(this.f29618m);
        this.la = new FrameLayout(this.f29618m);
        this.gq = new FrameLayout(this.f29618m);
        addView(this.kt);
        addView(this.la);
        addView(this.gq);
        this.rh = new ArrayList();
        com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar = this.tl;
        if (xtVar != null) {
            this.ch = xtVar.tl();
            this.f29623s = this.tl.g();
            v();
            this.f29625x = this.tl.r();
        }
        if (!az()) {
            setBackgroundColor(0);
            setBackgroundResource(R.color.transparent);
            ws();
        }
        ch();
        la();
        com.bytedance.sdk.component.adexpress.xt.av avVar = this.ol;
        if (avVar != null) {
            this.gx = (s) avVar.xt();
        }
        if (s()) {
            this.ya = new i(this);
        }
    }

    public void w() {
        s sVar = this.gx;
        if (sVar == null || sVar.ae() == null) {
            return;
        }
        this.gx.up();
    }

    public void xt(int i6) {
    }

    private boolean a() {
        if (com.bytedance.sdk.openadsdk.core.v.xt().g(com.bytedance.sdk.openadsdk.core.rn.uf.g(this.f29612g)) == 4 && h()) {
            return true;
        }
        return false;
    }

    private boolean az() {
        if (h() && hh.j(this.f29612g) == 1) {
            return true;
        }
        return false;
    }

    private void cw(n nVar, Context context, String str) {
        if (nVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.rn.m.j(context, nVar, str);
    }

    private int getRenderThread() {
        if (a() || (com.bytedance.sdk.openadsdk.core.cw.up.j().vl() & 2) == 2) {
            return 1;
        }
        return hh.r(this.f29612g);
    }

    private void gq() {
        if (!az()) {
            x();
        }
    }

    public void i() {
        if (com.bytedance.sdk.openadsdk.core.v.xt().fs() && this.ff) {
            if (this.up != null) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    this.up.j(this, com.bytedance.sdk.openadsdk.core.g.j(-16), -16);
                    return;
                } else {
                    com.bytedance.sdk.openadsdk.core.tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.5
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NativeExpressView.this.up != null) {
                                NativeExpressView.this.up.j(NativeExpressView.this, com.bytedance.sdk.openadsdk.core.g.j(-16), -16);
                            }
                        }
                    });
                    return;
                }
            }
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.v.xt().ot() && com.bytedance.sdk.openadsdk.l.ae.j()) {
            com.bytedance.sdk.component.utils.tl.cw().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.6
                @Override // java.lang.Runnable
                public void run() {
                    NativeExpressView.this.rn();
                }
            });
        } else {
            rn();
        }
    }

    public void j(float f6, float f7, float f8, float f9, int i6) {
    }

    public void jy() {
        ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver;
        try {
            removeAllViews();
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            Iterator<com.bytedance.sdk.component.adexpress.xt.oq> it = this.rh.iterator();
            while (it.hasNext()) {
                it.next().j();
            }
            this.cw = null;
            this.f29622r = null;
            this.tl = null;
            this.f29612g = null;
            this.tj = null;
            this.av = null;
            this.f29611f = null;
            this.qv = null;
            this.vl = null;
            this.up = null;
            Context context = this.f29618m;
            if (context != null && (themeStatusBroadcastReceiver = this.f29609c) != null) {
                context.unregisterReceiver(themeStatusBroadcastReceiver);
            }
            ExpressVideoView expressVideoView = this.oq;
            if (expressVideoView != null) {
                expressVideoView.mi();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.cw("NativeExpressView", "detach error", th);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.sdk.component.utils.vl.r("webviewpool", "onAttachedToWindow+++");
        getViewTreeObserver().addOnScrollChangedListener(this.rn);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            com.bytedance.sdk.openadsdk.m.j jVar = this.f29607a;
            if (jVar != null) {
                jVar.xt(true);
            }
            getViewTreeObserver().removeOnScrollChangedListener(this.rn);
        } catch (Exception unused) {
        }
        com.bytedance.sdk.component.utils.vl.r("webviewpool", "onDetachedFromWindow===");
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.bytedance.sdk.component.utils.vl.r("webviewpool", "onFinishTemporaryDetach+++");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        i iVar;
        if (s() && (iVar = this.ya) != null) {
            return iVar.j(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.bytedance.sdk.component.utils.vl.r("webviewpool", "onStartTemporaryDetach===");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        i iVar;
        if (s() && (iVar = this.ya) != null) {
            return iVar.xt(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z5) {
        int i6;
        super.onWindowFocusChanged(z5);
        if (Build.VERSION.SDK_INT < 28) {
            if (z5) {
                i6 = getVisibility();
            } else {
                i6 = 8;
            }
            onWindowVisibilityChanged(i6);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i6) {
        super.onWindowVisibilityChanged(i6);
        removeCallbacks(this.ed);
        removeCallbacks(this.uf);
        if (i6 == 0) {
            postDelayed(this.uf, 50L);
        } else {
            postDelayed(this.ed, 50L);
        }
    }

    public void tl() {
        if (s() && TextUtils.equals(this.ae, "embeded_ad")) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            com.bytedance.sdk.openadsdk.core.dislike.cw.xt xtVar = new com.bytedance.sdk.openadsdk.core.dislike.cw.xt(this.f29612g.tv(), com.bytedance.sdk.openadsdk.core.dislike.r.j());
            xtVar.xt("dislike");
            com.bytedance.sdk.openadsdk.core.dislike.j.j.j().j(this.f29618m, xtVar, "close_success");
        }
    }

    private void xt(View view, com.bytedance.sdk.openadsdk.core.tj.x xVar, com.bytedance.sdk.openadsdk.core.tj.qv qvVar, int i6, String str, int i7) {
        if (n.up(this.f29612g)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.xt.xt xtVar = this.f29611f;
        if (xtVar != null) {
            xtVar.j(xVar);
            com.bytedance.sdk.openadsdk.core.xt.j.cw.j jVar = (com.bytedance.sdk.openadsdk.core.xt.j.cw.j) this.f29611f.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.j.class);
            j(jVar);
            jVar.xt(str);
            this.f29611f.j(qvVar);
            Map<String, Object> j6 = com.bytedance.sdk.component.qv.up.j.j().j(this.f29612g.hashCode() + this.f29612g.ej());
            j6.put("convert_tag", xVar.f30479i);
            j(xVar, j6);
            this.f29611f.j(view, qvVar);
        }
        j jVar2 = this.up;
        if (jVar2 != null) {
            jVar2.j(this, i7);
        }
    }

    public void j(int i6) {
    }

    public void j(int i6, String str) {
    }

    public void j(View view, int i6, com.bytedance.sdk.component.adexpress.cw cwVar, ya yaVar) {
        this.f29620p = yaVar;
        j(view, i6, cwVar);
        this.f29620p = null;
    }

    public void j(View view, int i6, com.bytedance.sdk.component.adexpress.cw cwVar) {
        com.bytedance.sdk.openadsdk.core.tj.qv qvVar;
        com.bytedance.sdk.openadsdk.core.xt.j.cw.j jVar;
        com.bytedance.sdk.openadsdk.core.xt.j jVar2;
        com.bytedance.sdk.openadsdk.core.xt.xt xtVar;
        if (i6 == -1 || cwVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.tj.x xVar = (com.bytedance.sdk.openadsdk.core.tj.x) cwVar;
        com.bytedance.sdk.openadsdk.core.xt.j jVar3 = this.tj;
        if (jVar3 != null) {
            jVar3.up(getDynamicShowType());
        }
        com.bytedance.sdk.openadsdk.core.xt.xt xtVar2 = this.f29611f;
        if (xtVar2 != null) {
            xtVar2.up(getDynamicShowType());
        }
        if (i6 != 1 || (xtVar = this.f29611f) == null) {
            qvVar = null;
            jVar = null;
        } else {
            qvVar = xtVar.xt();
            jVar = (com.bytedance.sdk.openadsdk.core.xt.j.cw.j) this.f29611f.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.j.class);
            jVar.j(jVar.up());
        }
        if (i6 == 2 && (jVar2 = this.tj) != null) {
            qvVar = jVar2.xt();
            jVar = (com.bytedance.sdk.openadsdk.core.xt.j.cw.j) this.tj.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.j.class);
            jVar.j(jVar.up());
        }
        try {
            Object obj = xVar.j().get("click_extra_map");
            if (jVar != null && (obj instanceof Map)) {
                jVar.j((Map<String, Object>) obj);
            }
        } catch (JSONException unused) {
        }
        if (qvVar == null) {
            qvVar = new com.bytedance.sdk.openadsdk.core.tj.qv();
        }
        com.bytedance.sdk.openadsdk.core.tj.qv qvVar2 = qvVar;
        if (this.f29620p != null) {
            qvVar2.xt(this);
        }
        qvVar2.j(xVar.f30480j);
        qvVar2.xt(xVar.xt);
        qvVar2.cw(xVar.cw);
        qvVar2.r(xVar.f30482r);
        qvVar2.j(xVar.az);
        qvVar2.ae(xVar.f30483w);
        qvVar2.j(com.bytedance.sdk.openadsdk.core.tj.v.r(this.f29612g, xVar.f30479i));
        qvVar2.xt(xVar.f30479i);
        SparseArray<r.j> sparseArray = xVar.av;
        if (sparseArray == null || sparseArray.size() == 0) {
            sparseArray = this.ry;
        }
        qvVar2.j(sparseArray);
        JSONObject j6 = xVar.j();
        qvVar2.cw(j6.optBoolean("is_compliant_download"));
        String optString = j6.optString("uchain_event_name");
        qvVar2.cw(optString);
        int optInt = j6.optInt("convertActionType", Integer.MIN_VALUE);
        if (optInt == 1) {
            if (i6 == 2) {
                com.bytedance.sdk.openadsdk.core.xt.j jVar4 = this.tj;
                if (jVar4 != null) {
                    jVar4.cw();
                }
            } else {
                com.bytedance.sdk.openadsdk.core.xt.xt xtVar3 = this.f29611f;
                if (xtVar3 != null) {
                    xtVar3.cw();
                }
            }
        } else if (optInt == 2) {
            if (i6 == 2) {
                com.bytedance.sdk.openadsdk.core.xt.j jVar5 = this.tj;
                if (jVar5 != null) {
                    jVar5.r();
                }
            } else {
                com.bytedance.sdk.openadsdk.core.xt.xt xtVar4 = this.f29611f;
                if (xtVar4 != null) {
                    xtVar4.r();
                }
            }
        }
        View view2 = view == null ? this : view;
        String str = xVar.qv;
        n nVar = this.f29612g;
        int jl = nVar != null ? nVar.jl() : 0;
        switch (i6) {
            case 1:
                View view3 = view2;
                int i7 = jl;
                FrameLayout frameLayout = this.jy;
                if (frameLayout != null) {
                    frameLayout.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                xt(view3, xVar, qvVar2, 0, str, i7);
                break;
            case 2:
                j(view2, xVar, qvVar2, 0, str, jl);
                break;
            case 3:
                wq();
                break;
            case 4:
                FrameLayout frameLayout2 = this.jy;
                if (frameLayout2 != null) {
                    frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                com.bytedance.sdk.openadsdk.core.rn.uf.tj(this.f29612g);
                if ("embeded_ad".equals(this.ae) && uf() && !this.ws && com.bytedance.sdk.openadsdk.core.rn.uf.tj(this.f29612g)) {
                    j(view2, xVar, qvVar2, 0, str, jl);
                    break;
                } else {
                    xt(view2, xVar, qvVar2, 0, str, jl);
                    break;
                }
                break;
            case 5:
                j(!this.mi);
                break;
            case 6:
                ae();
                break;
            case 7:
                if (!j(optString)) {
                    com.bytedance.sdk.openadsdk.core.rn.m.j(this.f29618m, this.f29612g);
                    break;
                }
                break;
            case 8:
                tl();
                break;
            case 9:
                xt(this.f29612g, this.f29618m, this.ae);
                break;
            case 10:
                j(this.f29612g, this.f29618m, this.ae);
                break;
            case 12:
                cw(this.f29612g, this.f29618m, this.ae);
                break;
            case 13:
                String optString2 = j6.optString("openCommonWebUrl", "");
                String optString3 = j6.optString("openCommonWebTitle", "");
                if (!TextUtils.isEmpty(optString2)) {
                    TTDelegateActivity.r(this.f29618m, optString2, optString3);
                    break;
                }
                break;
        }
    }

    private void xt(View view, int i6, com.bytedance.sdk.openadsdk.core.tj.x xVar, com.bytedance.sdk.openadsdk.core.tj.qv qvVar, int i7) {
        if (n.up(this.f29612g)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.xt.j jVar = this.tj;
        if (jVar != null) {
            j(((com.bytedance.sdk.openadsdk.core.xt.j.j.j) jVar.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(), i6);
            this.tj.j(xVar);
            this.tj.j(qvVar);
            this.tj.j(view, qvVar);
        }
        j jVar2 = this.up;
        if (jVar2 != null) {
            jVar2.j(this, i7);
        }
    }

    public void g() {
    }

    public void m() {
    }

    public void oq() {
    }

    public void qv() {
    }

    public NativeExpressView(boolean z5, Context context, n nVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, String str, boolean z6) {
        super(context);
        this.f29615j = true;
        this.xt = 0;
        this.ae = "embeded_ad";
        this.f29624v = new AtomicBoolean(false);
        this.f29625x = null;
        this.az = false;
        this.f29614i = false;
        this.mi = false;
        this.f29617l = false;
        this.rn = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                NativeExpressView nativeExpressView = NativeExpressView.this;
                nativeExpressView.removeCallbacks(nativeExpressView.wq);
                NativeExpressView nativeExpressView2 = NativeExpressView.this;
                nativeExpressView2.postDelayed(nativeExpressView2.wq, 500L);
            }
        };
        this.wq = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.2
            @Override // java.lang.Runnable
            public void run() {
                if (!uf.xt(NativeExpressView.this, 0, 5)) {
                    NativeExpressView.this.r(8);
                } else {
                    NativeExpressView nativeExpressView = NativeExpressView.this;
                    nativeExpressView.r(nativeExpressView.getVisibility());
                }
            }
        };
        this.uf = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.3
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.r(0);
            }
        };
        this.ed = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.4
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.r(8);
            }
        };
        this.ry = new SparseArray<>();
        this.zz = -1.0f;
        this.kc = -1.0f;
        this.aq = -1.0f;
        this.rr = -1.0f;
        this.st = 0L;
        this.ae = str;
        this.f29618m = context;
        this.f29612g = nVar;
        this.tl = xtVar;
        this.az = z5;
        this.mi = z6;
        vl();
    }

    public void xt(com.bytedance.sdk.component.adexpress.xt.r<? extends View> rVar, com.bytedance.sdk.component.adexpress.xt.ws wsVar) {
        try {
            this.f29621q = rVar;
            this.f29608b = wsVar;
            if (rVar.cw() != 1) {
                View ae = rVar.ae();
                this.pz = ae;
                if (ae.getParent() != null) {
                    ((ViewGroup) this.pz.getParent()).removeView(this.pz);
                }
                this.la.addView(this.pz);
                ViewGroup.LayoutParams layoutParams = this.pz.getLayoutParams();
                if (layoutParams instanceof FrameLayout.LayoutParams) {
                    ((FrameLayout.LayoutParams) layoutParams).gravity = 1;
                }
                if (this.xq != null && (rVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.r) && !(rVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.m)) {
                    this.xq.j(((com.bytedance.sdk.openadsdk.core.ugeno.express.r) rVar).tl());
                    this.xq.j(this);
                }
            }
            com.bytedance.sdk.component.adexpress.xt.g gVar = this.f29610e;
            if (gVar instanceof oq) {
                ((oq) gVar).ws();
            }
            if (this.f29607a != null && rVar.cw() != 0) {
                this.f29607a.j(rVar.cw(), wsVar.qv(), wsVar.oq());
            }
            com.bytedance.sdk.component.adexpress.xt.r<? extends View> rVar2 = this.f29621q;
            if ((rVar2 instanceof az) && ((az) rVar2).D_() != null) {
                ((az) this.f29621q).D_().j((qv) this);
            }
            if (wsVar.xt() == 10 && (wsVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.cw)) {
                this.f29613h = ((com.bytedance.sdk.openadsdk.core.ugeno.express.cw) wsVar).w();
            }
            j jVar = this.up;
            if (jVar != null) {
                jVar.j(this, (float) wsVar.r(), (float) wsVar.up());
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void setPauseFromExpressView(boolean z5) {
    }

    public void setTimeUpdate(int i6) {
    }

    public NativeExpressView(Context context, n nVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, String str, boolean z5) {
        super(context);
        this.f29615j = true;
        this.xt = 0;
        this.ae = "embeded_ad";
        this.f29624v = new AtomicBoolean(false);
        this.f29625x = null;
        this.az = false;
        this.f29614i = false;
        this.mi = false;
        this.f29617l = false;
        this.rn = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                NativeExpressView nativeExpressView = NativeExpressView.this;
                nativeExpressView.removeCallbacks(nativeExpressView.wq);
                NativeExpressView nativeExpressView2 = NativeExpressView.this;
                nativeExpressView2.postDelayed(nativeExpressView2.wq, 500L);
            }
        };
        this.wq = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.2
            @Override // java.lang.Runnable
            public void run() {
                if (!uf.xt(NativeExpressView.this, 0, 5)) {
                    NativeExpressView.this.r(8);
                } else {
                    NativeExpressView nativeExpressView = NativeExpressView.this;
                    nativeExpressView.r(nativeExpressView.getVisibility());
                }
            }
        };
        this.uf = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.3
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.r(0);
            }
        };
        this.ed = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.4
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.r(8);
            }
        };
        this.ry = new SparseArray<>();
        this.zz = -1.0f;
        this.kc = -1.0f;
        this.aq = -1.0f;
        this.rr = -1.0f;
        this.st = 0L;
        this.ae = str;
        this.f29618m = context;
        this.f29612g = nVar;
        this.tl = xtVar;
        this.mi = z5;
        if (xtVar.kt() == 9) {
            this.az = xtVar.az() == 2;
        }
        vl();
    }

    private void xt(n nVar, Context context, String str) {
        if (nVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.rn.m.xt(nVar, context, str);
    }

    public void xt(int i6, String str) {
        rn D_;
        com.bytedance.sdk.component.adexpress.xt.r<? extends View> rVar = this.f29621q;
        if (rVar == null || !(rVar instanceof s) || (D_ = ((s) rVar).D_()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("time", i6);
            jSONObject.put("flag", str);
            D_.j("onVideoPaused", jSONObject);
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    public void xt(int i6, int i7) {
        com.bytedance.sdk.openadsdk.core.ugeno.oq.j jVar = this.f29613h;
        if (jVar != null) {
            jVar.j(i6, i7);
        }
    }

    private void j(View view, com.bytedance.sdk.openadsdk.core.tj.x xVar, com.bytedance.sdk.openadsdk.core.tj.qv qvVar, int i6, String str, int i7) {
        if (n.up(this.f29612g)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.xt.j jVar = this.tj;
        if (jVar != null) {
            jVar.j(xVar);
            com.bytedance.sdk.openadsdk.core.xt.j.cw.j jVar2 = (com.bytedance.sdk.openadsdk.core.xt.j.cw.j) this.tj.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.j.class);
            j(jVar2);
            jVar2.xt(str);
            this.tj.j(qvVar);
            Map<String, Object> j6 = com.bytedance.sdk.component.qv.up.j.j().j(this.f29612g.hashCode() + this.f29612g.ej());
            j6.put("convert_tag", xVar.f30479i);
            j(xVar, j6);
            this.tj.j(view, qvVar);
        }
        j jVar3 = this.up;
        if (jVar3 != null) {
            jVar3.j(this, i7);
        }
    }

    public void j(com.bytedance.sdk.openadsdk.core.tj.x xVar, Map<String, Object> map) {
        try {
            map.put("live_saas_interaction_type", Integer.valueOf(xVar.j().optInt("live_saas_param_interaction_type", -1)));
        } catch (Exception unused) {
        }
    }

    private void j(com.bytedance.sdk.openadsdk.core.xt.j.cw.j jVar) {
        ya yaVar = this.f29620p;
        if (yaVar != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("custom_express_gesture", 1);
            hashMap.put("express_gesture_type", Integer.valueOf(yaVar.xt()));
            hashMap.put("express_slide_direction", Integer.valueOf(yaVar.r()));
            hashMap.put("express_slide_threshold", Double.valueOf(yaVar.cw()));
            jVar.j(hashMap);
        }
    }

    public void j(View view, int i6, com.bytedance.sdk.component.adexpress.cw cwVar, int i7) {
        if (i6 == -1 || cwVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.tj.x xVar = (com.bytedance.sdk.openadsdk.core.tj.x) cwVar;
        com.bytedance.sdk.openadsdk.core.tj.qv qvVar = new com.bytedance.sdk.openadsdk.core.tj.qv();
        qvVar.j(xVar.av);
        qvVar.j(xVar.f30480j);
        qvVar.xt(xVar.xt);
        qvVar.cw(xVar.cw);
        qvVar.r(xVar.f30482r);
        qvVar.j(xVar.az);
        JSONObject j6 = xVar.j();
        int optInt = j6.optInt("convertActionType", Integer.MIN_VALUE);
        qvVar.cw(j6.optBoolean("is_compliant_download"));
        if (optInt == 1) {
            if (i6 == 2) {
                this.tj.cw();
            } else {
                this.f29611f.cw();
            }
        } else if (optInt == 2) {
            if (i6 == 2) {
                this.tj.r();
            } else {
                this.f29611f.r();
            }
        }
        View view2 = view == null ? this : view;
        com.bytedance.sdk.openadsdk.core.xt.j jVar = this.tj;
        if (jVar != null) {
            jVar.up(getDynamicShowType());
        }
        com.bytedance.sdk.openadsdk.core.xt.xt xtVar = this.f29611f;
        if (xtVar != null) {
            xtVar.up(getDynamicShowType());
        }
        n nVar = this.f29612g;
        int jl = nVar != null ? nVar.jl() : 0;
        switch (i6) {
            case 1:
                View view3 = view2;
                int i8 = jl;
                FrameLayout frameLayout = this.jy;
                if (frameLayout != null) {
                    frameLayout.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                j(view3, i7, xVar, qvVar, i8);
                break;
            case 2:
                xt(view2, i7, xVar, qvVar, jl);
                break;
            case 3:
                wq();
                break;
            case 4:
                FrameLayout frameLayout2 = this.jy;
                if (frameLayout2 != null) {
                    frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                com.bytedance.sdk.openadsdk.core.rn.uf.tj(this.f29612g);
                if ("embeded_ad".equals(this.ae) && uf() && !this.ws && com.bytedance.sdk.openadsdk.core.rn.uf.tj(this.f29612g)) {
                    xt(view2, i7, xVar, qvVar, jl);
                    break;
                } else {
                    j(view2, i7, xVar, qvVar, jl);
                    break;
                }
                break;
            case 5:
                j(!this.mi);
                break;
            case 6:
                ae();
                break;
            case 8:
                tl();
                break;
        }
    }

    private boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.rn.uf.a();
        HashMap hashMap = new HashMap();
        hashMap.put("material_meta", this.f29612g);
        hashMap.put(d.X, this.f29618m);
        new xt.j(str).j(this.f29612g.tv()).j(hashMap).j().j();
        return true;
    }

    private void j(View view, int i6, com.bytedance.sdk.openadsdk.core.tj.x xVar, com.bytedance.sdk.openadsdk.core.tj.qv qvVar, int i7) {
        if (n.up(this.f29612g)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.xt.xt xtVar = this.f29611f;
        if (xtVar != null) {
            j(((com.bytedance.sdk.openadsdk.core.xt.j.j.j) xtVar.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(), i6);
            this.f29611f.j(xVar);
            this.f29611f.j(qvVar);
            this.f29611f.j(view, qvVar);
        }
        j jVar = this.up;
        if (jVar != null) {
            jVar.j(this, i7);
        }
    }

    private void j(com.bytedance.sdk.openadsdk.core.qv.xt.cw cwVar, int i6) {
        if (cwVar != null && (cwVar instanceof com.bytedance.sdk.openadsdk.core.qv.cw.up)) {
            com.bytedance.sdk.openadsdk.core.qv.cw.cw.cw tl = ((com.bytedance.sdk.openadsdk.core.qv.cw.up) cwVar).tl();
            tl.xt(true);
            tl.j(i6);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.az
    public void j(final com.bytedance.sdk.component.adexpress.xt.r<? extends View> rVar, final com.bytedance.sdk.component.adexpress.xt.ws wsVar) {
        this.ff = true;
        com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.7
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.xt(rVar, wsVar);
            }
        });
    }

    public void j(MotionEvent motionEvent) {
        View view = this.pz;
        if (view != null) {
            view.dispatchTouchEvent(motionEvent);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.r
    public void j(CharSequence charSequence, int i6, int i7, boolean z5) {
        j(Integer.parseInt(String.valueOf(charSequence)), i6, z5);
    }

    protected void j(int i6, int i7, boolean z5) {
        int up;
        if (TextUtils.equals(this.ae, "fullscreen_interstitial_ad")) {
            up = rn.j(this.tl.kt(), this.f29612g) ? 0 : com.bytedance.sdk.openadsdk.core.v.xt().m(Integer.parseInt(this.f29625x));
        } else if (!TextUtils.equals(this.ae, "rewarded_video")) {
            return;
        } else {
            up = com.bytedance.sdk.openadsdk.core.v.xt().up(Integer.parseInt(this.f29625x));
        }
        int i8 = (i7 >= up || z5) ? 1 : 0;
        int i9 = i7 <= up ? up - i7 : 0;
        com.bytedance.sdk.component.adexpress.xt.xt xtVar = this.hh;
        if (xtVar != null && xtVar.xt() != null) {
            this.hh.xt().j(String.valueOf(i6), i8, i9, z5);
        }
        if (this.f29621q.cw() == 7 || this.f29621q.cw() == 10) {
            com.bytedance.sdk.component.adexpress.xt.r<? extends View> rVar = this.f29621q;
            if (rVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.r) {
                ((com.bytedance.sdk.component.adexpress.dynamic.r) rVar).j(String.valueOf(i6), i8, i9, z5);
            }
        }
    }

    private void j(n nVar, Context context, String str) {
        if (nVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.rn.m.cw(nVar, context, str);
    }

    public void j(boolean z5) {
        if (this.f29621q.cw() == 7) {
            com.bytedance.sdk.component.adexpress.xt.r<? extends View> rVar = this.f29621q;
            if (rVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.r) {
                ((com.bytedance.sdk.component.adexpress.dynamic.r) rVar).setSoundMute(z5);
            }
        }
    }

    public void j(JSONObject jSONObject) {
        boolean ws = com.bytedance.sdk.openadsdk.core.v.xt().ws();
        this.sm = ws;
        if (ws && com.bytedance.sdk.openadsdk.core.rn.uf.r(this.f29612g)) {
            this.xq = new f(this.f29612g, jSONObject, this);
        }
    }
}
