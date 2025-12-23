package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bykv.vk.openvk.component.video.api.r.cw;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.m.av;
import com.bytedance.sdk.component.m.qv;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.tl;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.utils.ws;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.kt;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.h;
import com.bytedance.sdk.openadsdk.core.rn.i;
import com.bytedance.sdk.openadsdk.core.tj.az;
import com.bytedance.sdk.openadsdk.core.tj.hh;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.uf;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.r;
import com.bytedance.sdk.openadsdk.i.cw.xt.jy;
import com.bytedance.sdk.openadsdk.l.g;
import com.bytedance.sdk.openadsdk.l.oq;
import com.bytedance.sdk.openadsdk.m.cw.i;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"ViewConstructor"})
/* loaded from: D:\Downloads\app\classes4.dex */
public class NativeVideoTsView extends FrameLayout implements cw.j, l.j, r.j {
    private static volatile com.bytedance.sdk.component.r.j.xt ya;

    /* renamed from: a, reason: collision with root package name */
    private NativeExpressVideoView f30979a;
    protected FrameLayout ae;
    protected int av;
    protected String az;

    /* renamed from: b, reason: collision with root package name */
    private ViewTreeObserver f30980b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f30981c;
    private boolean ch;
    protected final Context cw;

    /* renamed from: e, reason: collision with root package name */
    private View.OnAttachStateChangeListener f30982e;
    private cw.InterfaceC0306cw ed;

    /* renamed from: f, reason: collision with root package name */
    private boolean f30983f;
    private boolean ff;

    /* renamed from: g, reason: collision with root package name */
    protected boolean f30984g;
    private final String gq;
    private boolean gx;

    /* renamed from: h, reason: collision with root package name */
    private final l f30985h;
    private boolean hh;
    private ViewTreeObserver.OnGlobalLayoutListener hl;

    /* renamed from: i, reason: collision with root package name */
    AtomicBoolean f30986i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f30987j;
    protected ImageView jy;

    /* renamed from: k, reason: collision with root package name */
    private boolean f30988k;
    protected final AtomicBoolean kt;

    /* renamed from: l, reason: collision with root package name */
    private boolean f30989l;
    private boolean la;

    /* renamed from: m, reason: collision with root package name */
    protected ViewGroup f30990m;
    public r mi;

    /* renamed from: n, reason: collision with root package name */
    private int f30991n;
    private int nd;
    private boolean ol;
    protected RelativeLayout oq;

    /* renamed from: p, reason: collision with root package name */
    private long f30992p;

    /* renamed from: q, reason: collision with root package name */
    private ViewGroup f30993q;
    private com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ae qb;
    protected ImageView qv;

    /* renamed from: r, reason: collision with root package name */
    protected n f30994r;
    private boolean rh;
    private TTViewStub rn;
    private volatile boolean ry;

    /* renamed from: s, reason: collision with root package name */
    private boolean f30995s;
    private xt sm;
    private String tj;
    protected boolean tl;
    private long uf;
    protected com.bykv.vk.openvk.component.video.api.r.cw up;

    /* renamed from: v, reason: collision with root package name */
    private boolean f30996v;
    protected ImageView vl;

    /* renamed from: w, reason: collision with root package name */
    boolean f30997w;
    private long wq;
    protected boolean ws;

    /* renamed from: x, reason: collision with root package name */
    private boolean f30998x;
    private boolean xq;
    private boolean xt;

    /* renamed from: z, reason: collision with root package name */
    private cw f30999z;
    private AtomicBoolean zz;

    public static class cw implements av {
        private int ae;
        private WeakReference<GifView> cw = new WeakReference<>(null);

        /* renamed from: j, reason: collision with root package name */
        private az f31008j;

        /* renamed from: m, reason: collision with root package name */
        private int f31009m;

        /* renamed from: r, reason: collision with root package name */
        private n f31010r;
        private String up;
        private WeakReference<ViewGroup> xt;

        public cw(az azVar, ViewGroup viewGroup, n nVar, String str, int i6, int i7) {
            this.f31008j = azVar;
            this.xt = new WeakReference<>(viewGroup);
            this.f31010r = nVar;
            this.up = str;
            this.f31009m = i6;
            this.ae = i7;
        }

        @Override // com.bytedance.sdk.component.m.av
        @ATSMethod(1)
        public void j(final qv qvVar) {
            try {
                ViewGroup viewGroup = this.xt.get();
                if (viewGroup == null) {
                    return;
                }
                viewGroup.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.cw.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            ViewGroup viewGroup2 = (ViewGroup) cw.this.xt.get();
                            if (viewGroup2 == null) {
                                return;
                            }
                            Context context = viewGroup2.getContext();
                            cw cwVar = cw.this;
                            cwVar.j(context, cwVar.f31008j, qvVar, viewGroup2);
                        } catch (Exception e6) {
                            vl.j(e6);
                        }
                    }
                }, 100L);
            } catch (Exception e6) {
                j(1002, "", e6);
            }
        }

        @Override // com.bytedance.sdk.component.m.av
        @ATSMethod(2)
        public void j(int i6, String str, Throwable th) {
            vl.r("copflg", "fail: ".concat(String.valueOf(str)));
            GifView gifView = this.cw.get();
            if (gifView != null) {
                gifView.setVisibility(8);
            }
            com.bytedance.sdk.openadsdk.core.jy.cw.j(this.f31010r, this.up, 2);
        }

        private int j() {
            if (this.f31008j.m() > 0.0d) {
                return (int) (this.ae * this.f31008j.m());
            }
            return this.ae / 2;
        }

        private void j(Context context, FrameLayout.LayoutParams layoutParams, int i6) {
            if (this.f31008j.cw() == 2) {
                layoutParams.gravity = 8388693;
                layoutParams.rightMargin = i6;
                layoutParams.bottomMargin = i6;
            } else {
                layoutParams.gravity = 8388659;
                layoutParams.leftMargin = i6;
                layoutParams.topMargin = ed.cw(context, 19.0f);
            }
        }

        private void j(Object obj, qv qvVar, GifView gifView) {
            if (obj instanceof byte[]) {
                if (qvVar.tl()) {
                    gifView.j((byte[]) obj, false);
                    gifView.setRepeatConfig(false);
                } else {
                    gifView.setImageDrawable(i.j((byte[]) obj, 0));
                }
            }
        }

        private void j(GifView gifView) {
            if (gifView == null || gifView.getParent() == null) {
                return;
            }
            ((ViewGroup) gifView.getParent()).removeView(gifView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(Context context, az azVar, qv qvVar, ViewGroup viewGroup) {
            FrameLayout.LayoutParams layoutParams;
            GifView gifView = new GifView(context);
            gifView.setAdjustViewBounds(true);
            gifView.setBackgroundColor(0);
            int cw = ed.cw(context, 12.0f);
            this.f31009m = viewGroup.getWidth() <= 0 ? this.f31009m : viewGroup.getWidth();
            this.ae = viewGroup.getHeight() <= 0 ? this.ae : viewGroup.getHeight();
            int j6 = j();
            if (azVar.j() == 3) {
                if (j6 > ed.cw(context, 88.0f)) {
                    j6 = ed.cw(context, 88.0f);
                }
            } else if (azVar.j() == 4 && j6 > ed.cw(context, 178.0f)) {
                j6 = ed.cw(context, 178.0f);
            }
            int i6 = this.f31009m - cw;
            int ae = (int) (j6 * azVar.ae());
            if (ae > i6 && ae > 0 && i6 > 0) {
                layoutParams = new FrameLayout.LayoutParams(i6, -2);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, j6);
            }
            j(context, layoutParams, cw);
            gifView.setVisibility(0);
            j(qvVar.cw(), qvVar, gifView);
            j(this.cw.get());
            viewGroup.addView(gifView, layoutParams);
            this.cw = new WeakReference<>(gifView);
            com.bytedance.sdk.openadsdk.core.jy.cw.j(this.f31010r, this.up, 0);
        }
    }

    public interface j {
        void j(View view, int i6);
    }

    public interface r {
        void j(boolean z5, long j6, long j7, long j8, boolean z6, boolean z7);
    }

    private class xt implements Runnable {
        private volatile boolean xt;

        private xt() {
        }

        public Runnable j(boolean z5) {
            this.xt = z5;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeVideoTsView.this.xt(this.xt);
        }
    }

    public NativeVideoTsView(Context context, n nVar) {
        this(context, nVar, false, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.r.j
    public void g() {
        this.ry = true;
        if (this.f30985h.hasMessages(1)) {
            return;
        }
        this.f30985h.sendEmptyMessage(1);
    }

    public void up() {
        this.mi = null;
        i();
        jy();
    }

    public NativeVideoTsView(Context context) {
        this(context, null, false, false);
    }

    private boolean a() {
        View view;
        if (!oq.j(this.f30994r)) {
            view = this;
        } else if (hh.j(this.f30994r) == 2) {
            view = this.f30979a;
        } else {
            ViewParent parent = getParent();
            view = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        }
        return uf.xt(view, 50, 5);
    }

    private boolean ch() {
        return TextUtils.equals(this.az, "splash_ad") || TextUtils.equals(this.az, "cache_splash_ad");
    }

    private void f() {
        if (!(this instanceof NativeDrawVideoTsView) || this.f30986i.get() || com.bytedance.sdk.openadsdk.core.oq.i().rh() == null) {
            return;
        }
        this.jy.setImageBitmap(com.bytedance.sdk.openadsdk.core.oq.i().rh());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jy.getLayoutParams();
        int cw2 = ed.cw(getContext(), this.av);
        layoutParams.width = cw2;
        layoutParams.height = cw2;
        this.jy.setLayoutParams(layoutParams);
        this.f30986i.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.component.r.j.xt getKvCache() {
        return h.j("sp_multi_native_video_data");
    }

    private boolean gq() {
        return 2 == v.xt().ae(com.bytedance.sdk.openadsdk.core.rn.uf.g(this.f30994r));
    }

    private void h() {
        if (this.f30993q == null) {
            return;
        }
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.setClipChildren(false);
                if (viewGroup.hashCode() == this.f30993q.hashCode()) {
                    this.f30993q.hashCode();
                    return;
                }
            }
        }
    }

    private void la() {
        if (ya == null) {
            ya = getKvCache();
        }
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.up;
        if (cwVar == null || av() || !ya.xt("key_video_is_update_flag", false)) {
            return;
        }
        boolean xt2 = ya.xt("key_native_video_complete", false);
        long xt3 = ya.xt("key_video_current_play_position", -1L);
        long xt4 = ya.xt("key_video_total_play_duration", cwVar.ws() + cwVar.vl());
        long xt5 = ya.xt("key_video_duration", cwVar.ws());
        cwVar.cw(xt2);
        if (xt2) {
            cwVar.xt(xt5);
        } else {
            cwVar.xt(xt3);
        }
        cwVar.cw(xt4);
        cwVar.r(xt5);
        ya.j("key_video_is_update_flag", false);
    }

    private boolean rn() {
        return 5 == v.xt().ae(com.bytedance.sdk.openadsdk.core.rn.uf.g(this.f30994r));
    }

    private void tj() {
        addView(j(this.cw));
        B_();
    }

    private void tl() {
        j(0L, 0);
        this.ed = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        ViewTreeObserver viewTreeObserver = this.f30980b;
        if (viewTreeObserver == null || (onGlobalLayoutListener = this.hl) == null) {
            return;
        }
        viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    private void wq() {
        ed.up(this.vl);
        ed.up(this.oq);
    }

    private void x() {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.up;
        if (cwVar == null) {
            return;
        }
        cwVar.r(this.f30987j);
        ((com.bytedance.sdk.openadsdk.core.video.nativevideo.r) this.up).j((r.j) this);
        this.up.j(this);
    }

    protected void B_() {
        this.up = j(this.cw, this.ae, this.f30994r, this.az, !av(), this.f30998x, this.ch);
        x();
        this.f30982e = new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.3
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                NativeVideoTsView nativeVideoTsView = NativeVideoTsView.this;
                nativeVideoTsView.f30980b = nativeVideoTsView.f30990m.getViewTreeObserver();
                if (NativeVideoTsView.this.f30980b == null || NativeVideoTsView.this.hl == null) {
                    return;
                }
                NativeVideoTsView.this.f30980b.addOnGlobalLayoutListener(NativeVideoTsView.this.hl);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                NativeVideoTsView.this.v();
            }
        };
        this.hl = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int width = NativeVideoTsView.this.f30990m.getWidth();
                int height = NativeVideoTsView.this.f30990m.getHeight();
                ((com.bytedance.sdk.openadsdk.core.video.nativevideo.r) NativeVideoTsView.this.up).j(width, height);
                NativeVideoTsView.this.v();
                NativeVideoTsView.this.xt(width, height);
            }
        };
    }

    public void C_() {
        ed.j((View) this.oq, 8);
        cw.InterfaceC0306cw interfaceC0306cw = this.ed;
        if (interfaceC0306cw != null && !this.ff) {
            this.ff = true;
            interfaceC0306cw.q_();
        }
        ed.j((View) this.oq, 8);
        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ae aeVar = this.qb;
        if (aeVar != null) {
            aeVar.j();
        }
    }

    protected void ae() {
        n nVar = this.f30994r;
        if (nVar == null) {
            return;
        }
        int g6 = com.bytedance.sdk.openadsdk.core.rn.uf.g(nVar);
        int ae = v.xt().ae(g6);
        if (ae == 1) {
            this.f30987j = ws.r(this.cw);
        } else if (ae == 2) {
            this.f30987j = ws.up(this.cw) || ws.r(this.cw) || ws.m(this.cw) || ws.cw(v.getContext()) == 1;
        } else if (ae == 3) {
            this.f30987j = false;
        } else if (ae == 4) {
            this.f30997w = true;
        } else if (ae == 5) {
            this.f30987j = ws.r(this.cw) || ws.m(this.cw);
        }
        if (this.xt) {
            this.tl = false;
        } else {
            this.tl = v.xt().r(g6);
        }
        if ("splash_ad".equals(this.az)) {
            this.f30987j = true;
            this.tl = true;
        }
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.up;
        if (cwVar != null) {
            cwVar.r(this.f30987j);
        }
    }

    public boolean av() {
        return this.xt;
    }

    public boolean az() {
        return this.tl;
    }

    public void cw(boolean z5) {
        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ae aeVar = this.qb;
        if (aeVar != null) {
            aeVar.j(z5);
        }
    }

    public com.bykv.vk.openvk.component.video.api.r.cw getNativeVideoController() {
        return this.up;
    }

    public boolean getVideoError() {
        return this.f30996v;
    }

    public void i() {
        com.bykv.vk.openvk.component.video.api.r.xt w5;
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.up;
        if (cwVar == null || (w5 = cwVar.w()) == null) {
            return;
        }
        w5.j();
        View cw2 = w5.cw();
        if (cw2 != null) {
            cw2.setVisibility(8);
            if (cw2.getParent() != null) {
                ((ViewGroup) cw2.getParent()).removeView(cw2);
            }
        }
    }

    public void jy() {
        if (!this.kt.get()) {
            this.kt.set(true);
            if (this.up != null) {
                l lVar = this.f30985h;
                if (lVar != null) {
                    lVar.removeCallbacksAndMessages(null);
                }
                this.up.j(true, 3);
            }
        }
        this.zz.set(false);
    }

    public void mi() {
        l lVar = this.f30985h;
        if (lVar != null) {
            lVar.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i6) {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar;
        com.bykv.vk.openvk.component.video.api.r.cw cwVar2;
        com.bykv.vk.openvk.component.video.api.r.cw cwVar3;
        super.onWindowVisibilityChanged(i6);
        if (this.rh) {
            h();
            la();
            if (this.f30988k) {
                this.f30988k = i6 == 0;
            }
            if (l() && (cwVar3 = this.up) != null && cwVar3.kt()) {
                p();
                ed.j((View) this.oq, 8);
                r(true);
                tl();
                return;
            }
            ae();
            if (av() || !ws() || (cwVar = this.up) == null || cwVar.av() || this.f30994r == null) {
                return;
            }
            boolean xt2 = uf.xt(this, 20, 5);
            isShown();
            if (this.f30989l && ln.ws(this.f30994r) != null && xt2) {
                com.bykv.vk.openvk.component.video.api.cw.r j6 = ln.j(4, this.f30994r);
                j6.xt(this.f30994r.fs());
                j6.xt(this.f30990m.getWidth());
                j6.cw(this.f30990m.getHeight());
                j6.cw(this.f30994r.os());
                j6.j(this.f30992p);
                j6.xt(az());
                j(j6);
                ed.j((View) this.oq, 8);
            } else {
                try {
                    StringBuilder sb = new StringBuilder("onWindowVisibilityChanged materialMeta.getVideo() is null ");
                    sb.append(this.oq == null);
                    sb.append(" ");
                    sb.append(this.f30988k);
                    sb.append(" ");
                    sb.append(hashCode());
                    vl.r("NativeVideoAdView", sb.toString());
                    if (this.f30988k && this.oq == null) {
                        qv();
                        ed.j((View) this.oq, 0);
                    }
                } catch (Throwable th) {
                    vl.j(th);
                }
            }
            if (i6 != 0 || !this.f30981c || this.f30985h == null || (cwVar2 = this.up) == null || cwVar2.kt()) {
                return;
            }
            this.f30985h.obtainMessage(1).sendToTarget();
        }
    }

    public void oq() {
        r rVar;
        com.bykv.vk.openvk.component.video.api.r.cw cwVar;
        if (this.xt || (rVar = this.mi) == null || (cwVar = this.up) == null) {
            return;
        }
        rVar.j(cwVar.kt(), this.up.ws(), this.up.ws() + this.up.vl(), this.up.qv(), this.f30987j, this.tl);
    }

    public void r() {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.up;
        if (cwVar == null) {
            B_();
        } else if ((cwVar instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.r) && !av()) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.r) this.up).z();
        }
        if (this.up == null || !this.kt.get()) {
            return;
        }
        this.kt.set(false);
        ae();
        if (!ws()) {
            if (this.up.kt()) {
                r(true);
                return;
            }
            vl.j("NativeVideoAdView", "attachTask.......mRlImgCover.....VISIBLE");
            qv();
            ed.j((View) this.oq, 0);
            return;
        }
        ImageView imageView = this.vl;
        if (imageView != null) {
            ed.j((View) imageView, 8);
        }
        if (ln.ws(this.f30994r) == null) {
            vl.r("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
            return;
        }
        com.bykv.vk.openvk.component.video.api.cw.r j6 = ln.j(4, this.f30994r);
        j6.xt(this.f30994r.fs());
        j6.xt(this.f30990m.getWidth());
        j6.cw(this.f30990m.getHeight());
        j6.cw(this.f30994r.os());
        j6.j(0L);
        j6.j(oq.j(this.f30994r));
        j6.xt(az());
        if (ch()) {
            String cw2 = g.j(0).cw();
            if (this.f30994r.ih()) {
                cw2 = g.j();
            }
            j6.j(cw2);
        }
        j(j6);
        this.up.cw(false);
    }

    public void setAdCreativeClickListener(j jVar) {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.up;
        if (cwVar != null) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.r) cwVar).j(jVar);
        }
    }

    public void setComplete(boolean z5) {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.up;
        if (cwVar != null) {
            cwVar.cw(z5);
        }
    }

    public void setControllerStatusCallBack(r rVar) {
        this.mi = rVar;
    }

    public void setDrawVideoListener(com.bytedance.sdk.openadsdk.f.j.xt.j.j jVar) {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.up;
        if (cwVar != null) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.r) cwVar).j(jVar);
        }
    }

    public void setEasyPlayableEventSender(com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ae aeVar) {
        this.qb = aeVar;
    }

    public void setEnableAutoCheck(boolean z5) {
        this.rh = z5;
    }

    public void setEnableBlur(boolean z5) {
        this.f30984g = z5;
    }

    public void setIsAutoPlay(boolean z5) {
        n nVar;
        if (this.la || (nVar = this.f30994r) == null) {
            return;
        }
        int ae = v.xt().ae(com.bytedance.sdk.openadsdk.core.rn.uf.g(nVar));
        if (z5 && ae != 4 && (!ws.up(this.cw) ? !(!ws.m(this.cw) ? ws.r(this.cw) : gq() || rn()) : !gq())) {
            z5 = false;
        }
        this.f30987j = z5;
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.up;
        if (cwVar != null) {
            cwVar.r(z5);
        }
        if (this.f30987j) {
            ed.j((View) this.oq, 8);
        } else {
            qv();
            RelativeLayout relativeLayout = this.oq;
            if (relativeLayout != null) {
                ed.j((View) relativeLayout, 0);
                if (ln.ws(this.f30994r) != null) {
                    com.bytedance.sdk.openadsdk.g.xt.j(ln.xt(this.f30994r)).j(this.qv);
                    j(this.qv, ln.xt(this.f30994r));
                } else {
                    vl.r("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
                }
            }
        }
        this.la = true;
    }

    public void setIsQuiet(boolean z5) {
        this.tl = z5;
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.up;
        if (cwVar != null) {
            cwVar.xt(z5);
        }
    }

    public void setMaterialMeta(n nVar) {
        this.f30994r = nVar;
    }

    public void setNativeExpressVideoView(NativeExpressVideoView nativeExpressVideoView) {
        this.f30979a = nativeExpressVideoView;
    }

    public void setNativeVideoAdListener(cw.j jVar) {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.up;
        if (cwVar != null) {
            cwVar.j(jVar);
        }
    }

    public void setNativeVideoController(com.bykv.vk.openvk.component.video.api.r.cw cwVar) {
        this.up = cwVar;
    }

    public void setNeedNativeVideoPlayBtnVisible(boolean z5) {
        this.ws = z5;
    }

    public void setVideoAdClickListenerTTNativeAd(jy jyVar) {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.up;
        if (cwVar != null) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.r) cwVar).j(jyVar);
        }
    }

    public void setVideoAdInteractionListener(cw.InterfaceC0306cw interfaceC0306cw) {
        this.ed = interfaceC0306cw;
    }

    public void setVideoAdLoadListener(cw.r rVar) {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.up;
        if (cwVar != null) {
            cwVar.j(rVar);
        }
    }

    public void setVideoCacheUrl(String str) {
        this.tj = str;
    }

    public boolean vl() {
        n nVar = this.f30994r;
        return nVar != null && nVar.to() == 4 && hh.j(this.f30994r) == 1 && !TextUtils.equals("draw_ad", this.az);
    }

    public void w() {
        if (this.up != null) {
            wq();
            this.up.xt();
        }
    }

    public boolean ws() {
        return this.f30987j;
    }

    public void xt(long j6, int i6) {
        this.f30996v = true;
    }

    public NativeVideoTsView(Context context, n nVar, boolean z5, boolean z6) {
        this(context, nVar, z5, z6, "embeded_ad", false, false);
    }

    private boolean l() {
        if (av()) {
            return false;
        }
        if (ya == null) {
            ya = getKvCache();
        }
        boolean xt2 = ya.xt("key_video_isfromvideodetailpage", false);
        if (!ya.xt("key_video_is_from_detail_page", false) && !xt2) {
            return false;
        }
        return true;
    }

    private void p() {
        if (av()) {
            return;
        }
        if (ya == null) {
            ya = getKvCache();
        }
        ya.j("key_video_isfromvideodetailpage", false);
        ya.j("key_video_is_from_detail_page", false);
    }

    private void s() {
        boolean a6 = a();
        if (this.ry && a6) {
            com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.up;
            if (cwVar instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.r) {
                ((com.bytedance.sdk.openadsdk.core.video.nativevideo.r) cwVar).h();
            }
            this.ry = false;
        } else {
            if (this.sm == null) {
                this.sm = new xt();
            } else {
                tl.xt().removeCallbacks(this.sm);
            }
            this.sm.j(a6);
            tl.xt().post(this.sm);
        }
        this.f30985h.sendEmptyMessageDelayed(1, this.wq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(int i6, int i7) {
        if (av()) {
            return;
        }
        n nVar = this.f30994r;
        az vd = nVar == null ? null : nVar.vd();
        if (vd != null && i7 > 0) {
            if (!vd.tl()) {
                com.bytedance.sdk.openadsdk.core.jy.cw.j(this.f30994r, this.az, 1);
                return;
            }
            this.f30991n = i6;
            this.nd = i7;
            if (this.f30999z == null) {
                this.f30999z = new cw(vd, this.f30990m, this.f30994r, this.az, i6, i7);
            }
            com.bytedance.sdk.openadsdk.g.xt.j(vd.up()).cw(3).j(Bitmap.Config.RGB_565).j(this.f30999z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        super.onAttachedToWindow();
        if (!this.rh) {
            return;
        }
        ViewGroup viewGroup = this.f30990m;
        if (viewGroup != null && (onAttachStateChangeListener = this.f30982e) != null) {
            viewGroup.addOnAttachStateChangeListener(onAttachStateChangeListener);
        }
        r();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        super.onDetachedFromWindow();
        ViewGroup viewGroup = this.f30990m;
        if (viewGroup != null && (onAttachStateChangeListener = this.f30982e) != null) {
            viewGroup.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        }
        up();
        this.f30999z = null;
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (!this.rh) {
            return;
        }
        r();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        oq();
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        up();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z5) {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar;
        com.bykv.vk.openvk.component.video.api.r.cw cwVar2;
        com.bykv.vk.openvk.component.video.api.r.cw cwVar3;
        com.bykv.vk.openvk.component.video.api.r.cw cwVar4;
        super.onWindowFocusChanged(z5);
        if (this.rh) {
            this.f30981c = z5;
            la();
            if (l() && (cwVar4 = this.up) != null && cwVar4.kt()) {
                p();
                ed.j((View) this.oq, 8);
                r(true);
                tl();
                return;
            }
            ae();
            if (!av() && ws() && (cwVar2 = this.up) != null && !cwVar2.av()) {
                if (this.f30985h != null) {
                    if (z5 && (cwVar3 = this.up) != null && !cwVar3.kt()) {
                        this.f30985h.obtainMessage(1).sendToTarget();
                        return;
                    } else {
                        this.f30985h.removeMessages(1);
                        xt(false);
                        return;
                    }
                }
                return;
            }
            if (!ws()) {
                if (!z5 && (cwVar = this.up) != null && cwVar.i() != null && this.up.i().jy()) {
                    this.f30985h.removeMessages(1);
                    xt(false);
                } else if (z5) {
                    this.f30985h.obtainMessage(1).sendToTarget();
                }
            }
        }
    }

    public void qv() {
        TTViewStub tTViewStub;
        if (!ch() && this.cw != null && (tTViewStub = this.rn) != null && tTViewStub.getParent() != null && this.f30994r != null && this.oq == null) {
            if (this.rn.getParent() != null && (this.rn.getParent() instanceof ViewGroup)) {
                this.oq = (RelativeLayout) this.rn.j();
            }
            this.qv = (ImageView) findViewById(2114387954);
            ImageView imageView = (ImageView) findViewById(2114387853);
            this.jy = imageView;
            if (this.ws) {
                ed.j((View) imageView, 0);
            }
            if (!TextUtils.isEmpty(ln.xt(this.f30994r))) {
                com.bytedance.sdk.openadsdk.g.xt.j(ln.xt(this.f30994r)).j(this.qv);
                j(this.qv, ln.xt(this.f30994r));
            }
            f();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i6) {
        super.setVisibility(i6);
        if (i6 != 4 && i6 != 8) {
            return;
        }
        jy();
    }

    public NativeVideoTsView(Context context, n nVar, String str, boolean z5, boolean z6) {
        this(context, nVar, false, false, str, z5, z6);
    }

    public NativeVideoTsView(Context context, n nVar, boolean z5, boolean z6, String str, boolean z7, boolean z8) {
        super(context);
        this.f30987j = true;
        this.tl = true;
        this.xt = false;
        this.f30983f = false;
        this.f30996v = false;
        this.f30998x = false;
        this.ch = true;
        this.f30995s = false;
        this.ws = true;
        this.az = "embeded_ad";
        this.av = 50;
        this.f30989l = true;
        this.f30986i = new AtomicBoolean(false);
        this.la = false;
        this.gq = kt.v();
        this.f30997w = false;
        this.wq = 50L;
        this.uf = 500L;
        this.f30981c = true;
        this.gx = false;
        this.rh = true;
        this.ol = true;
        this.xq = false;
        this.kt = new AtomicBoolean(false);
        this.f30988k = true;
        this.ry = false;
        this.zz = new AtomicBoolean(false);
        this.az = str;
        this.cw = context;
        this.f30994r = nVar;
        this.xt = z5;
        this.f30995s = z6;
        this.f30998x = z7;
        this.ch = z8;
        this.f30985h = new l(com.bytedance.sdk.openadsdk.l.ae.xt(), this);
        setContentDescription("NativeVideoAdView");
        ae();
        tj();
        com.bytedance.sdk.openadsdk.l.ae.xt(new com.bytedance.sdk.component.oq.g("ts_video") { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.1
            @Override // java.lang.Runnable
            public void run() {
                if (NativeVideoTsView.ya == null) {
                    com.bytedance.sdk.component.r.j.xt unused = NativeVideoTsView.ya = NativeVideoTsView.this.getKvCache();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw.j
    public void j(long j6, int i6) {
        this.xq = true;
        cw.InterfaceC0306cw interfaceC0306cw = this.ed;
        if (interfaceC0306cw != null) {
            interfaceC0306cw.t_();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw.j
    public void j() {
        if (this.ed == null || !ch()) {
            return;
        }
        this.ed.t_();
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw.j
    public void j(long j6, long j7) {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar;
        if (j6 != j7) {
            this.xq = false;
        }
        cw.InterfaceC0306cw interfaceC0306cw = this.ed;
        if (interfaceC0306cw != null) {
            interfaceC0306cw.j(j6, j7);
        }
        if (a() || (cwVar = this.up) == null) {
            return;
        }
        cwVar.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(boolean z5) {
        if (this.xq || this.f30983f == z5) {
            return;
        }
        if (!z5) {
            tl.xt().removeCallbacks(this.sm);
        }
        this.f30983f = z5;
        cw(z5);
        if (this.f30994r == null || this.up == null) {
            return;
        }
        boolean l6 = l();
        p();
        if (l6 && this.up.kt()) {
            r(true);
            tl();
            return;
        }
        if (z5 && !this.up.kt() && !this.up.av()) {
            if (this.up.i() != null && this.up.i().ws()) {
                if (this.f30987j) {
                    if ("ALP-AL00".equals(this.gq)) {
                        this.up.tl();
                    } else {
                        ((com.bytedance.sdk.openadsdk.core.video.nativevideo.r) this.up).m(l6);
                    }
                    cw.InterfaceC0306cw interfaceC0306cw = this.ed;
                    if (interfaceC0306cw != null) {
                        interfaceC0306cw.s_();
                        return;
                    }
                    return;
                }
                this.f30983f = false;
                return;
            }
            if (this.f30987j && this.up.i() == null) {
                if (!this.kt.get()) {
                    this.kt.set(true);
                }
                this.zz.set(false);
                r();
                return;
            }
            return;
        }
        if (this.up.i() == null || !this.up.i().jy()) {
            return;
        }
        this.up.m();
        cw.InterfaceC0306cw interfaceC0306cw2 = this.ed;
        if (interfaceC0306cw2 != null) {
            interfaceC0306cw2.r_();
        }
    }

    private View j(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        frameLayout.setId(2114387854);
        layoutParams.gravity = 17;
        frameLayout.setVisibility(8);
        this.f30990m = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        frameLayout2.setId(2114387762);
        layoutParams2.gravity = 17;
        frameLayout2.setLayoutParams(layoutParams2);
        frameLayout.addView(frameLayout2);
        this.ae = frameLayout2;
        TTViewStub tTViewStub = new TTViewStub(context, new com.bytedance.sdk.openadsdk.res.layout.video.up());
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        tTViewStub.setId(2114387613);
        tTViewStub.setLayoutParams(layoutParams3);
        frameLayout.addView(tTViewStub);
        this.rn = tTViewStub;
        return frameLayout;
    }

    protected void j(final ImageView imageView, String str) {
        if (imageView == null || !com.bytedance.sdk.openadsdk.up.j.j(this.f30994r) || com.bytedance.sdk.openadsdk.up.j.ae(this.f30994r)) {
            return;
        }
        com.bytedance.sdk.openadsdk.g.xt.j(str).j(Bitmap.Config.ARGB_4444).cw(2).j(new av<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.2
            @Override // com.bytedance.sdk.component.m.av
            @ATSMethod(2)
            public void j(int i6, String str2, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.m.av
            @ATSMethod(1)
            public void j(qv<Bitmap> qvVar) {
                Bitmap cw2;
                if (qvVar == null || (cw2 = qvVar.cw()) == null) {
                    return;
                }
                final Bitmap j6 = com.bytedance.sdk.component.adexpress.r.xt.j(NativeVideoTsView.this.cw, cw2, 25);
                com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.2.1
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

    public void r(boolean z5) {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.up;
        if (cwVar != null) {
            cwVar.cw(z5);
            com.bykv.vk.openvk.component.video.api.r.xt w5 = this.up.w();
            if (w5 != null) {
                w5.xt();
                View cw2 = w5.cw();
                if (cw2 != null) {
                    if (cw2.getParent() != null) {
                        ((ViewGroup) cw2.getParent()).removeView(cw2);
                    }
                    cw2.setVisibility(0);
                    addView(cw2);
                    w5.j(this.f30994r, new WeakReference<>(this.cw), false);
                }
            }
        }
    }

    public void j(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.rn.getParent() != null && (this.rn.getParent() instanceof ViewGroup)) {
            this.oq = (RelativeLayout) this.rn.j();
        }
        ImageView imageView = (ImageView) findViewById(2114387954);
        this.qv = imageView;
        imageView.setImageDrawable(null);
        this.jy = (ImageView) findViewById(2114387853);
        com.bytedance.sdk.openadsdk.g.xt.j(str).j(this.qv);
        j(this.qv, str);
        ed.j((View) this.oq, 0);
    }

    public void xt(boolean z5, boolean z6) {
        this.ol = z5;
        this.hh = z6;
    }

    protected void xt(int i6) {
        if (ws.cw(v.getContext()) == 0) {
            return;
        }
        if (this.up.i() != null) {
            if (this.up.i().jy() && i6 == 2) {
                xt(false);
                l lVar = this.f30985h;
                if (lVar != null) {
                    lVar.removeMessages(1);
                }
                j(true);
                return;
            }
            if (this.up.i().ws() && i6 == 3) {
                this.f30987j = true;
                xt(true);
                ae();
                l lVar2 = this.f30985h;
                if (lVar2 != null) {
                    lVar2.sendEmptyMessageDelayed(1, this.wq);
                }
                j(false);
                return;
            }
        }
        if (ws() || this.zz.get()) {
            return;
        }
        this.zz.set(true);
        if (ln.ws(this.f30994r) != null) {
            wq();
            com.bykv.vk.openvk.component.video.api.cw.r j6 = ln.j(4, this.f30994r);
            j6.xt(this.f30994r.fs());
            j6.xt(this.f30990m.getWidth());
            j6.cw(this.f30990m.getHeight());
            j6.cw(this.f30994r.os());
            j6.j(this.f30992p);
            j6.xt(az());
            j6.j(g.j(this.f30994r.ly()).r());
            j(j6);
        } else {
            vl.r("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
        }
        l lVar3 = this.f30985h;
        if (lVar3 != null) {
            lVar3.sendEmptyMessageDelayed(1, this.wq);
        }
        j(false);
    }

    protected com.bykv.vk.openvk.component.video.api.r.cw j(Context context, ViewGroup viewGroup, n nVar, String str, boolean z5, boolean z6, boolean z7) {
        return new com.bytedance.sdk.openadsdk.core.video.nativevideo.r(context, viewGroup, nVar, str, z5, z6, z7);
    }

    public boolean j(long j6, boolean z5, boolean z6) {
        boolean z7 = false;
        this.f30990m.setVisibility(0);
        if (this.up == null) {
            this.up = new com.bytedance.sdk.openadsdk.core.video.nativevideo.r(this.cw, this.ae, this.f30994r, this.az, this.f30998x, this.ch);
            x();
        }
        this.f30992p = j6;
        if (av()) {
            this.up.j(false);
            if (ln.ws(this.f30994r) != null) {
                com.bykv.vk.openvk.component.video.api.cw.r j7 = ln.j(4, this.f30994r);
                j7.xt(this.f30994r.fs());
                j7.xt(this.f30990m.getWidth());
                j7.cw(this.f30990m.getHeight());
                j7.cw(this.f30994r.os());
                j7.j(j6);
                j7.xt(az());
                if (z6) {
                    this.up.xt(j7);
                    return true;
                }
                z7 = j(j7);
            }
            if (((j6 > 0 && !z5 && !z6) || (j6 > 0 && z5 && !this.f30995s)) && (this.up instanceof com.bytedance.sdk.openadsdk.core.video.j.j)) {
                i.j jVar = new i.j();
                jVar.j(this.up.qv());
                jVar.cw(this.up.ws());
                jVar.xt(this.up.vl());
                com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.up;
                ((com.bytedance.sdk.openadsdk.core.video.j.j) cwVar).xt(cwVar.w(), jVar);
            }
            return z7;
        }
        if (vl() || this.f30984g) {
            j(this.cw, 25, ln.xt(this.f30994r));
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.utils.l.j
    public void j(Message message) {
        if (message.what != 1) {
            return;
        }
        s();
    }

    protected boolean j(com.bykv.vk.openvk.component.video.api.cw.r rVar) {
        if (this.up == null) {
            return false;
        }
        this.f30989l = false;
        this.wq = this.uf;
        if (this.hh) {
            rVar.xt(this.ol);
        }
        return this.up.j(rVar);
    }

    protected void xt() {
        if (ws.cw(v.getContext()) == 0) {
            return;
        }
        if (this.up.i() != null) {
            if (this.up.i().jy()) {
                xt(false);
                l lVar = this.f30985h;
                if (lVar != null) {
                    lVar.removeMessages(1);
                }
                j(true);
                return;
            }
            if (this.up.i().ws()) {
                this.f30987j = true;
                xt(true);
                ae();
                l lVar2 = this.f30985h;
                if (lVar2 != null) {
                    lVar2.sendEmptyMessageDelayed(1, this.wq);
                }
                j(false);
                return;
            }
        }
        if (ws() || this.zz.get()) {
            return;
        }
        this.zz.set(true);
        if (ln.ws(this.f30994r) != null) {
            wq();
            com.bykv.vk.openvk.component.video.api.cw.r j6 = ln.j(4, this.f30994r);
            j6.xt(this.f30994r.fs());
            j6.xt(this.f30990m.getWidth());
            j6.cw(this.f30990m.getHeight());
            j6.cw(this.f30994r.os());
            j6.j(this.f30992p);
            j6.xt(az());
            j(j6);
        } else {
            vl.r("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
        }
        l lVar3 = this.f30985h;
        if (lVar3 != null) {
            lVar3.sendEmptyMessageDelayed(1, this.wq);
        }
        j(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.r.j
    public void j(int i6) {
        ae();
    }

    protected void j(boolean z5) {
        if (this.vl == null) {
            this.vl = new ImageView(getContext());
            if (com.bytedance.sdk.openadsdk.core.oq.i().rh() != null) {
                this.vl.setImageBitmap(com.bytedance.sdk.openadsdk.core.oq.i().rh());
            } else {
                com.bytedance.sdk.component.utils.kt.j(v.getContext(), "tt_new_play_video", this.vl);
            }
            this.vl.setScaleType(ImageView.ScaleType.FIT_XY);
            int cw2 = ed.cw(getContext(), this.av);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(cw2, cw2);
            layoutParams.gravity = 17;
            this.f30990m.addView(this.vl, layoutParams);
        }
        if (z5) {
            this.vl.setVisibility(0);
        } else {
            this.vl.setVisibility(8);
        }
    }

    public void j(int i6, int i7) {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.up;
        if (cwVar != null) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.r) cwVar).j(i6, i7);
        }
    }

    public void j(final Context context, final int i6, String str) {
        final com.bykv.vk.openvk.component.video.api.r.xt w5;
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.up;
        if (cwVar == null || (w5 = cwVar.w()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.g.xt.j(str).j(Bitmap.Config.ARGB_4444).cw(2).j(new av<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.5
            @Override // com.bytedance.sdk.component.m.av
            @ATSMethod(2)
            public void j(int i7, String str2, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.m.av
            @ATSMethod(1)
            public void j(qv<Bitmap> qvVar) {
                Bitmap j6 = com.bytedance.sdk.component.adexpress.r.xt.j(context, qvVar.cw(), i6);
                if (j6 == null) {
                    return;
                }
                final BitmapDrawable bitmapDrawable = new BitmapDrawable(NativeVideoTsView.this.getResources(), j6);
                com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bykv.vk.openvk.component.video.api.r.xt xtVar = w5;
                        if (xtVar != null) {
                            xtVar.j(bitmapDrawable);
                        }
                    }
                });
            }
        }, 4);
    }
}
