package com.bytedance.sdk.openadsdk.core.component.splash.r;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bykv.vk.openvk.component.video.api.r.cw;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.component.splash.TsView;
import com.bytedance.sdk.openadsdk.core.component.splash.countdown.xt;
import com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae;
import com.bytedance.sdk.openadsdk.core.component.splash.cw.j.g;
import com.bytedance.sdk.openadsdk.core.component.splash.r.j;
import com.bytedance.sdk.openadsdk.core.multipro.xt.j;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.SplashExpressBackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.m;
import com.bytedance.sdk.openadsdk.core.nativeexpress.s;
import com.bytedance.sdk.openadsdk.core.nativeexpress.up;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.a;
import com.bytedance.sdk.openadsdk.core.tj.hh;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.x;
import com.bytedance.sdk.openadsdk.core.tj.zz;
import com.bytedance.sdk.openadsdk.core.ugeno.component.interact.r;
import com.bytedance.sdk.openadsdk.core.v;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt extends j implements cw.InterfaceC0306cw, cw.r, j.xt, j.InterfaceC0466j {
    private NativeExpressView gx;
    private final AtomicBoolean hh = new AtomicBoolean(false);
    private r hl;

    /* renamed from: n, reason: collision with root package name */
    private Context f28777n;
    private com.bytedance.sdk.openadsdk.i.cw.cw.xt nd;
    private int ol;
    private String rh;

    /* renamed from: z, reason: collision with root package name */
    private WeakReference<ViewGroup> f28778z;

    /* renamed from: com.bytedance.sdk.openadsdk.core.component.splash.r.xt$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.component.splash.j.j ae;
        final /* synthetic */ String cw;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ Context f28779j;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.r f28780m;

        /* renamed from: r, reason: collision with root package name */
        final /* synthetic */ int f28781r;
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.component.splash.cw.j.cw up;
        final /* synthetic */ com.bytedance.sdk.openadsdk.i.cw.cw.xt xt;

        AnonymousClass1(Context context, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, String str, int i6, com.bytedance.sdk.openadsdk.core.component.splash.cw.j.cw cwVar, com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.r rVar, com.bytedance.sdk.openadsdk.core.component.splash.j.j jVar) {
            this.f28779j = context;
            this.xt = xtVar;
            this.cw = str;
            this.f28781r = i6;
            this.up = cwVar;
            this.f28780m = rVar;
            this.ae = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                xt.this.f28777n = this.f28779j;
                xt.this.nd = this.xt;
                xt.this.rh = this.cw;
                xt.this.ol = this.f28781r;
                xt xtVar = xt.this;
                xtVar.j((j.xt) xtVar);
                xt.this.j(this.up, this.f28780m, this.ae);
                xt xtVar2 = xt.this;
                xtVar2.hl = new r(xtVar2.xt, false, new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.j() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.r.xt.1.1
                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
                    public int cw() {
                        return 0;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
                    public long j() {
                        return 0L;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
                    public int xt() {
                        return 0;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
                    public long getActualPlayDuration() {
                        return 0L;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
                    public void j(float f6) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
                    public void xt(int i6) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
                    public void j(int i6) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.j
                    public void xt(View view, int i6, com.bytedance.sdk.component.adexpress.cw cwVar) {
                        if (xt.this.gx != null) {
                            xt.this.gx.j(view, i6, cwVar);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
                    public void j(int i6, String str) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.j
                    public void j(View view) {
                        xt xtVar3 = xt.this;
                        com.bytedance.sdk.openadsdk.r.j.xt.j.j jVar = xtVar3.tl;
                        if (jVar != null) {
                            jVar.xt(xtVar3);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.j
                    public void j(View view, int i6, com.bytedance.sdk.component.adexpress.cw cwVar) {
                        if (xt.this.gx != null) {
                            xt.this.gx.j(view, i6, cwVar);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.j
                    public void j(ViewGroup viewGroup) {
                        if (a.m(xt.this.xt).m()) {
                            TextView textView = new TextView(xt.this.f28777n);
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                            textView.setTextSize(1, 20.0f);
                            int cw = ed.cw(v.getContext(), 80.0f);
                            textView.setText("跳转至详情页或第三方应用");
                            layoutParams.bottomMargin = cw;
                            int i6 = cw / 3;
                            layoutParams.leftMargin = i6;
                            layoutParams.rightMargin = i6;
                            layoutParams.gravity = 81;
                            textView.setTextColor(-1);
                            int i7 = cw / 6;
                            textView.setPadding(0, i7, 0, i7);
                            textView.setGravity(17);
                            textView.setLayoutParams(layoutParams);
                            textView.setClickable(true);
                            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.r.xt.1.1.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    if (xt.this.gx != null) {
                                        xt.this.gx.j(view, 2, new x.j().j());
                                    }
                                }
                            });
                            textView.bringToFront();
                            viewGroup.addView(textView);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
                    public void m() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
                    public void r() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
                    public void up() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
                    public void setPauseFromExpressView(boolean z5) {
                    }
                });
            } catch (Throwable th) {
                vl.r("splrender", th.getMessage());
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw.InterfaceC0306cw
    public void j(long j6, long j7) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.xt.j.InterfaceC0466j
    public boolean p() {
        return false;
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw.InterfaceC0306cw
    public void t_() {
        this.f28756v = false;
        com.bytedance.sdk.openadsdk.core.jy.cw.xt(this.av, this.xt);
        com.bytedance.sdk.openadsdk.r.j.xt.j.j jVar = this.tl;
        if (jVar != null) {
            this.qv = true;
            jVar.j(this, 4);
            cw(false);
        }
        ws();
    }

    private void av() {
        if (this.xt.zw() == 2) {
            this.gx = new NativeExpressView(true, this.f28777n, this.xt, this.nd, this.rh, true);
        } else {
            this.gx = new NativeExpressView(false, this.f28777n, this.xt, this.nd, this.rh, true);
        }
    }

    private void i() {
        if (this.xt.zw() == 2) {
            this.gx = new NativeExpressVideoView(true, this.f28777n, this.xt, this.nd, this.rh);
        } else {
            this.gx = new NativeExpressVideoView(false, this.f28777n, this.xt, this.nd, this.rh);
        }
        if (this.gx.getVideoController() instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.r) {
            this.la = (com.bytedance.sdk.openadsdk.core.video.nativevideo.r) this.gx.getVideoController();
        }
        this.gx.setVideoAdListener(this);
        this.gx.setVideoAdInteractionListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mi() {
        NativeExpressView nativeExpressView = this.gx;
        if (nativeExpressView == null) {
            return;
        }
        nativeExpressView.xt(this.vl, 0);
        this.gx.setDynamicSkipListener(new com.bytedance.sdk.openadsdk.core.component.splash.countdown.cw() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.r.xt.4
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.cw
            public void j() {
                xt.this.oq();
            }
        });
        ((j) this).f28747j.xt();
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.xt xtVar = new com.bytedance.sdk.openadsdk.core.component.splash.countdown.xt();
        this.f28741c = xtVar;
        xtVar.j(this.vl);
        this.f28741c.j(new xt.j() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.r.xt.5
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.xt.j
            public void j() {
                xt.this.jy();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.xt.j
            public void j(int i6) {
                if (xt.this.gx != null) {
                    xt.this.gx.xt(xt.this.vl, i6);
                }
            }
        });
        if (this.uf.get()) {
            this.f28741c.xt();
        }
    }

    private void w() {
        if (this.wq > 0) {
            return;
        }
        if (this.rn == 1) {
            this.wq = 1;
        } else {
            this.wq = 2;
        }
    }

    public void az() {
        NativeExpressView nativeExpressView = this.gx;
        if (nativeExpressView == null) {
            return;
        }
        nativeExpressView.up(this.ol);
        this.gx.i();
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.xt.j.InterfaceC0466j
    public com.bytedance.sdk.openadsdk.core.multipro.xt.j la() {
        NativeExpressView nativeExpressView;
        com.bytedance.sdk.openadsdk.core.multipro.xt.j jVar = new com.bytedance.sdk.openadsdk.core.multipro.xt.j();
        cw cwVar = this.la;
        if (cwVar == null && (nativeExpressView = this.gx) != null) {
            cwVar = nativeExpressView.getVideoController();
        }
        if (cwVar != null) {
            jVar.ae = cwVar.qv();
            jVar.f29581j = cwVar.kt();
            jVar.tl = cwVar.mi();
        }
        return jVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.r.j.xt
    public void w_() {
        n nVar = this.xt;
        if (nVar == null || this.mi == null) {
            return;
        }
        if (hh.j(nVar) == 2) {
            if (this.hh.get()) {
                NativeExpressView nativeExpressView = this.gx;
                if (nativeExpressView != null) {
                    nativeExpressView.av();
                    s.j(this.mi, this.xt, this.gx);
                }
                this.mi.put("splash_show_type", 3);
            }
        } else if (this.f28752p) {
            if (TextUtils.isEmpty(ln.j(this.xt))) {
                this.mi.put("splash_show_type", 2);
            }
            this.mi.put("splash_show_type", 1);
        } else {
            this.mi.put("splash_show_type", 0);
        }
        j(this.xt);
    }

    public void xt(int i6) {
        this.ol = i6;
    }

    public xt(Context context, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, String str, int i6, com.bytedance.sdk.openadsdk.core.component.splash.cw.j.cw cwVar, com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.r<g, ae> rVar, com.bytedance.sdk.openadsdk.core.component.splash.j.j jVar) {
        com.bytedance.sdk.openadsdk.l.ae.j(new AnonymousClass1(context, xtVar, str, i6, cwVar, rVar, jVar));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.r.j, com.bytedance.sdk.openadsdk.core.component.splash.TsView.j
    public void g() {
        super.g();
        NativeExpressView nativeExpressView = this.gx;
        if (nativeExpressView != null) {
            nativeExpressView.jy();
        }
        this.gx = null;
        this.ae = null;
        this.f28750m = null;
        Map<String, Object> map = this.oq;
        if (map != null) {
            map.clear();
        }
        r rVar = this.hl;
        if (rVar != null) {
            rVar.xt();
        }
        cw(false);
        ws();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.r.j, com.bytedance.sdk.openadsdk.i.cw.xt.xt
    public View xt() {
        if (this.wq == -1) {
            this.wq = 0;
        }
        return ((j) this).f28747j;
    }

    public void j(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.cw cwVar, com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.r<g, ae> rVar) {
        this.jy = 3;
        j(rVar);
        az();
    }

    private void j(final com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.r<g, ae> rVar) {
        if (rVar == null || this.xt == null) {
            return;
        }
        if (this.f28752p) {
            this.tj = true;
            i();
        } else {
            this.tj = false;
            av();
        }
        this.ch.j(this);
        NativeExpressView nativeExpressView = this.gx;
        if (nativeExpressView == null) {
            this.ch.xt(3);
            this.ch.j("no render express");
            rVar.j(this.ch);
        } else {
            nativeExpressView.setBackupListener(new com.bytedance.sdk.component.adexpress.xt.cw() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.r.xt.2
                @Override // com.bytedance.sdk.component.adexpress.xt.cw
                public boolean j(ViewGroup viewGroup, int i6) {
                    try {
                        SplashExpressBackupView splashExpressBackupView = new SplashExpressBackupView(xt.this.f28777n);
                        xt xtVar = xt.this;
                        splashExpressBackupView.j(xtVar.f28749l, xtVar.xt, (NativeExpressView) viewGroup);
                        if (splashExpressBackupView.getVideoController() instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.r) {
                            xt.this.la = (com.bytedance.sdk.openadsdk.core.video.nativevideo.r) splashExpressBackupView.getVideoController();
                        }
                        splashExpressBackupView.setVideoAdListener(xt.this);
                        xt.this.vl();
                        TsView tsView = ((j) xt.this).f28747j;
                        if (tsView == null) {
                            return true;
                        }
                        tsView.j();
                        return true;
                    } catch (Exception unused) {
                        return false;
                    }
                }
            });
            this.jy = 3;
            this.gx.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.j() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.r.xt.3
                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.j
                public void j(View view, int i6) {
                    xt xtVar = xt.this;
                    com.bytedance.sdk.openadsdk.core.jy.cw.xt(xtVar.av, xtVar.xt);
                    xt xtVar2 = xt.this;
                    com.bytedance.sdk.openadsdk.r.j.xt.j.j jVar = xtVar2.tl;
                    if (jVar != null) {
                        jVar.xt(xtVar2);
                    }
                    xt.this.qv();
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.j
                public void j(View view, String str, int i6) {
                    vl.r("splash", "onRenderFail:".concat(String.valueOf(str)));
                    xt.this.ch.xt(3);
                    xt.this.ch.j("render splash express fail");
                    rVar.j(xt.this.ch);
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.j
                public void j(View view, float f6, float f7) {
                    if (view != null && f6 > 0.0f && f7 > 0.0f) {
                        g gVar = new g(xt.this.gq.get(), xt.this);
                        boolean tj = xt.this.gx.tj();
                        if (xt.this.gx != null && !tj) {
                            ((j) xt.this).f28747j.setComplianceBarVisibility(8);
                        }
                        gVar.j(tj);
                        xt.this.ed.set(tj ? 1 : 2);
                        xt.this.f28755s.set(true);
                        xt xtVar = xt.this;
                        ((j) xtVar).f28747j.setExpressView(xtVar.gx);
                        xt.this.hh.set(true);
                        if (xt.this.f28739a.get()) {
                            xt xtVar2 = xt.this;
                            xtVar2.j((WeakReference<ViewGroup>) xtVar2.f28778z);
                            xt.this.f28739a.set(false);
                        }
                        if (!xt.this.f28744g.get() && !tj && zz.j(xt.this.xt)) {
                            xt.this.mi();
                        }
                        rVar.xt(gVar);
                        xt.this.hl.j(((j) xt.this).f28747j.getEasyPlayableLayout(), xt.this.gx.getVideoContainer());
                        return;
                    }
                    xt.this.ch.xt(3);
                    xt.this.ch.j("render splash view error");
                    rVar.j(xt.this.ch);
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw.r
    public void p_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw.InterfaceC0306cw
    public void q_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw.InterfaceC0306cw
    public void r_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw.InterfaceC0306cw
    public void s_() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.r.j, com.bytedance.sdk.openadsdk.i.cw.xt.xt
    public void j(ViewGroup viewGroup) {
        if (viewGroup == null) {
            vl.r("splash", "展示开屏的容器不能为空");
            return;
        }
        w();
        WeakReference<ViewGroup> weakReference = new WeakReference<>(viewGroup);
        this.f28778z = weakReference;
        if (this.f28755s.get() && ((j) this).f28747j != null) {
            j(weakReference);
        } else {
            this.f28739a.set(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(WeakReference<ViewGroup> weakReference) {
        ViewGroup viewGroup;
        if (weakReference == null || (viewGroup = weakReference.get()) == null) {
            return;
        }
        if (((j) this).f28747j.getParent() != null) {
            ((ViewGroup) ((j) this).f28747j.getParent()).removeView(((j) this).f28747j);
        }
        viewGroup.addView(((j) this).f28747j);
    }

    private void j(n nVar) {
        if (this.gx == null || nVar == null) {
            return;
        }
        Context context = this.f28777n;
        String str = this.rh;
        m mVar = new m(context, nVar, str, uf.xt(str));
        mVar.j(this.gx);
        ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) mVar.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(this.cw);
        ((com.bytedance.sdk.openadsdk.core.xt.j.cw.j) mVar.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.j.class)).j(this.oq);
        this.gx.setClickListener(mVar);
        Context context2 = this.f28777n;
        String str2 = this.rh;
        up upVar = new up(context2, nVar, str2, uf.xt(str2));
        ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) upVar.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(this);
        upVar.j(this.gx);
        ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) upVar.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(this.cw);
        ((com.bytedance.sdk.openadsdk.core.xt.j.cw.j) upVar.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.j.class)).j(this.oq);
        this.gx.setClickCreativeListener(upVar);
        com.bytedance.sdk.openadsdk.core.qv.xt.cw cwVar = this.cw;
        if (cwVar != null) {
            cwVar.j(this);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw.r
    public void j(int i6, int i7) {
        this.f28756v = false;
    }
}
