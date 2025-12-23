package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bykv.vk.openvk.component.video.api.r.cw;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.video.j.j;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import java.util.HashSet;

/* loaded from: D:\Downloads\app\classes4.dex */
public class NativeExpressVideoView extends NativeExpressView implements cw.InterfaceC0306cw, cw.r, qv {
    private HashSet<String> ch;
    boolean cw;

    /* renamed from: f, reason: collision with root package name */
    private long f29596f;

    /* renamed from: j, reason: collision with root package name */
    int f29597j;

    /* renamed from: r, reason: collision with root package name */
    int f29598r;
    private com.bytedance.sdk.openadsdk.core.multipro.xt.j tj;
    boolean up;

    /* renamed from: v, reason: collision with root package name */
    private long f29599v;

    /* renamed from: x, reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.xt.r f29600x;
    boolean xt;

    public NativeExpressVideoView(Context context, n nVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, String str) {
        super(context, nVar, xtVar, str, true);
        this.f29597j = 1;
        this.xt = false;
        this.cw = true;
        this.up = true;
        this.mi = com.bytedance.sdk.openadsdk.core.v.xt().r(uf.g(this.f29612g));
        ws();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void j(float f6) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw.InterfaceC0306cw
    public void q_() {
        this.up = false;
        cw.InterfaceC0306cw interfaceC0306cw = this.vl;
        if (interfaceC0306cw != null) {
            interfaceC0306cw.q_();
        }
        this.f29597j = 2;
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw.InterfaceC0306cw
    public void r_() {
        this.up = false;
        cw.InterfaceC0306cw interfaceC0306cw = this.vl;
        if (interfaceC0306cw != null) {
            interfaceC0306cw.r_();
        }
        this.ws = true;
        this.f29597j = 3;
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw.InterfaceC0306cw
    public void s_() {
        this.up = false;
        cw.InterfaceC0306cw interfaceC0306cw = this.vl;
        if (interfaceC0306cw != null) {
            interfaceC0306cw.s_();
        }
        this.ws = false;
        this.f29597j = 2;
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw.InterfaceC0306cw
    public void t_() {
        this.up = false;
        com.bytedance.sdk.component.adexpress.xt.r rVar = this.f29600x;
        if (rVar != null) {
            if (rVar instanceof com.bytedance.sdk.component.adexpress.dynamic.j.j) {
                ((com.bytedance.sdk.component.adexpress.dynamic.j.j) rVar).r();
            }
            com.bytedance.sdk.component.adexpress.xt.r rVar2 = this.f29600x;
            if (rVar2 instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.r) {
                ((com.bytedance.sdk.openadsdk.core.ugeno.express.r) rVar2).vl();
            }
        }
        cw.InterfaceC0306cw interfaceC0306cw = this.vl;
        if (interfaceC0306cw != null) {
            interfaceC0306cw.t_();
        }
        this.f29597j = 5;
        com.bytedance.sdk.openadsdk.core.multipro.xt.j jVar = this.tj;
        if (jVar != null) {
            jVar.f29581j = true;
        }
    }

    private void setShowAdInteractionView(boolean z5) {
        ExpressVideoView expressVideoView = this.oq;
        if (expressVideoView != null) {
            expressVideoView.setShowAdInteractionView(z5);
        }
    }

    private void v() {
        try {
            this.tj = new com.bytedance.sdk.openadsdk.core.multipro.xt.j();
            ExpressVideoView j6 = j(this.f29618m, this.f29612g, this.ae);
            this.oq = j6;
            j6.setNativeExpressVideoView(this);
            this.oq.setAdCreativeClickListener(new NativeVideoTsView.j() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.1
                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.j
                public void j(View view, int i6) {
                    j expressInteractionListener = NativeExpressVideoView.this.getExpressInteractionListener();
                    if (expressInteractionListener == null) {
                        return;
                    }
                    expressInteractionListener.j(view, i6);
                }
            });
            this.oq.setShouldCheckNetChange(false);
            this.oq.setControllerStatusCallBack(new NativeVideoTsView.r() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.2
                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.r
                public void j(boolean z5, long j7, long j8, long j9, boolean z6, boolean z7) {
                    NativeExpressVideoView.this.tj.f29581j = z5;
                    NativeExpressVideoView.this.tj.up = j7;
                    NativeExpressVideoView.this.tj.f29582m = j8;
                    NativeExpressVideoView.this.tj.ae = j9;
                    NativeExpressVideoView.this.tj.f29583r = z6;
                    NativeExpressVideoView.this.tj.tl = z7;
                }
            });
            this.oq.setVideoAdLoadListener(this);
            this.oq.setVideoAdInteractionListener(this);
            if ("embeded_ad".equals(this.ae)) {
                this.oq.setIsAutoPlay(this.xt ? this.tl.up() : this.cw);
            } else if ("splash_ad".equals(this.ae)) {
                this.oq.setIsAutoPlay(true);
            } else {
                this.oq.setIsAutoPlay(this.cw);
            }
            if ("splash_ad".equals(this.ae)) {
                this.oq.setIsQuiet(true);
            } else {
                this.oq.setIsQuiet(com.bytedance.sdk.openadsdk.core.v.xt().r(this.f29598r));
            }
            this.oq.cw();
        } catch (Exception e6) {
            this.oq = null;
            com.bytedance.sdk.component.utils.vl.r("NativeExpressVideoView", "（dev ignore）ExpressVideoView-->print:" + e6.toString());
        }
    }

    private void x() {
        ExpressVideoView expressVideoView;
        com.bytedance.sdk.component.adexpress.xt.r rVar = this.f29600x;
        if (((rVar instanceof com.bytedance.sdk.component.adexpress.dynamic.j.j) || (rVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.r)) && (expressVideoView = this.oq) != null) {
            expressVideoView.xt(true);
            if (this.oq.A_()) {
                this.oq.setPauseIcon(true);
                this.oq.setVideoPlayStatus(2);
            } else {
                this.oq.setVideoPlayStatus(3);
                this.oq.setPauseIcon(false);
            }
            this.oq.performClick();
            this.oq.m();
        }
    }

    public void az() {
        this.oq.oq();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public com.bykv.vk.openvk.component.video.api.r.cw getVideoController() {
        ExpressVideoView expressVideoView = this.oq;
        if (expressVideoView != null) {
            return expressVideoView.getVideoController();
        }
        return null;
    }

    public com.bytedance.sdk.openadsdk.core.multipro.xt.j getVideoModel() {
        return this.tj;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void j(float f6, float f7, float f8, float f9, int i6) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw.r
    public void p_() {
        cw.r rVar = this.qv;
        if (rVar != null) {
            rVar.p_();
        }
        com.bytedance.sdk.component.adexpress.xt.r rVar2 = this.f29600x;
        if (rVar2 != null) {
            if (rVar2 instanceof com.bytedance.sdk.component.adexpress.dynamic.j.j) {
                ((com.bytedance.sdk.component.adexpress.dynamic.j.j) rVar2).up();
            }
            com.bytedance.sdk.component.adexpress.xt.r rVar3 = this.f29600x;
            if (rVar3 instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.r) {
                ((com.bytedance.sdk.openadsdk.core.ugeno.express.r) rVar3).jy();
            }
        }
    }

    public void setCanInterruptVideoPlay(boolean z5) {
        ExpressVideoView expressVideoView = this.oq;
        if (expressVideoView != null) {
            expressVideoView.setCanInterruptVideoPlay(z5);
        }
    }

    protected void ws() {
        this.jy = new FrameLayout(this.f29618m);
        this.f29598r = uf.g(this.f29612g);
        this.ch = new HashSet<>();
        cw(this.f29598r);
        v();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void xt(com.bytedance.sdk.component.adexpress.xt.r<? extends View> rVar, com.bytedance.sdk.component.adexpress.xt.ws wsVar) {
        ExpressVideoView expressVideoView;
        this.f29600x = rVar;
        if ((rVar instanceof az) && ((az) rVar).D_() != null) {
            ((az) this.f29600x).D_().j((qv) this);
        }
        if (wsVar != null && wsVar.cw()) {
            if ((wsVar.xt() == 2 || wsVar.xt() == 7) && (expressVideoView = this.oq) != null) {
                expressVideoView.j(this.f29618m, 25, ln.xt(this.f29612g));
            }
            j(wsVar);
        }
        com.bytedance.sdk.component.adexpress.xt.r rVar2 = this.f29600x;
        if (rVar2 != null && (rVar2 instanceof com.bytedance.sdk.component.adexpress.dynamic.j.j)) {
            ((com.bytedance.sdk.component.adexpress.dynamic.j.j) rVar2).j(com.bytedance.sdk.openadsdk.core.v.xt().r(this.f29598r));
        }
        super.xt(rVar, wsVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void ae() {
        super.ae();
    }

    void cw(int i6) {
        int ae = com.bytedance.sdk.openadsdk.core.v.xt().ae(i6);
        if (3 == ae) {
            this.xt = false;
            this.cw = false;
        } else if (1 == ae) {
            this.xt = false;
            this.cw = com.bytedance.sdk.component.utils.ws.r(this.f29618m);
        } else if (2 == ae) {
            if (com.bytedance.sdk.component.utils.ws.up(this.f29618m) || com.bytedance.sdk.component.utils.ws.r(this.f29618m) || com.bytedance.sdk.component.utils.ws.m(this.f29618m)) {
                this.xt = false;
                this.cw = true;
            }
        } else if (5 == ae) {
            if (com.bytedance.sdk.component.utils.ws.r(this.f29618m) || com.bytedance.sdk.component.utils.ws.m(this.f29618m)) {
                this.xt = false;
                this.cw = true;
            }
        } else if (4 == ae) {
            this.xt = true;
        }
        if (!this.cw) {
            this.f29597j = 3;
        }
        com.bytedance.sdk.component.utils.vl.j("NativeVideoAdView", "mIsAutoPlay=" + this.cw + ",status=" + ae);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void jy() {
        super.jy();
        ExpressVideoView expressVideoView = this.oq;
        if (expressVideoView != null) {
            expressVideoView.mi();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        ExpressVideoView expressVideoView;
        int i6;
        super.onAttachedToWindow();
        com.bytedance.sdk.component.adexpress.xt.r rVar = this.f29600x;
        if (((rVar instanceof com.bytedance.sdk.component.adexpress.dynamic.j.j) || (rVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.r)) && (expressVideoView = this.oq) != null && (i6 = this.f29597j) != 2 && i6 != 5) {
            expressVideoView.setNeedNativeVideoPlayBtnVisible(true);
            this.oq.z_();
            this.oq.y_();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, android.view.View
    public void onWindowFocusChanged(boolean z5) {
        ExpressVideoView expressVideoView;
        ImageView imageView;
        super.onWindowFocusChanged(z5);
        com.bytedance.sdk.component.adexpress.xt.r rVar = this.f29600x;
        if (((rVar instanceof com.bytedance.sdk.component.adexpress.dynamic.j.j) || (rVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.r)) && (expressVideoView = this.oq) != null && z5 && (imageView = expressVideoView.xt) != null && imageView.getVisibility() == 0) {
            this.oq.xt.setVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void tl() {
        super.tl();
    }

    protected ExpressVideoView j(Context context, n nVar, String str) {
        return new ExpressVideoView(context, nVar, str, false);
    }

    private void j(final com.bytedance.sdk.component.adexpress.xt.ws wsVar) {
        if (wsVar == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            xt(wsVar);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.3
                @Override // java.lang.Runnable
                public void run() {
                    NativeExpressVideoView.this.xt(wsVar);
                }
            });
        }
    }

    public NativeExpressVideoView(boolean z5, Context context, n nVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, String str) {
        super(z5, context, nVar, xtVar, str, true);
        this.f29597j = 1;
        this.xt = false;
        this.cw = true;
        this.up = true;
        this.mi = com.bytedance.sdk.openadsdk.core.v.xt().r(uf.g(this.f29612g));
        ws();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void j(boolean z5) {
        super.j(z5);
        this.mi = z5;
        this.oq.xt(z5, true);
        ExpressVideoView expressVideoView = this.oq;
        if (expressVideoView != null && expressVideoView.getNativeVideoController() != null) {
            this.oq.getNativeVideoController().xt(z5);
        }
        com.bytedance.sdk.component.adexpress.xt.r rVar = this.f29600x;
        if (rVar == null || !(rVar instanceof com.bytedance.sdk.component.adexpress.dynamic.j.j)) {
            return;
        }
        ((com.bytedance.sdk.component.adexpress.dynamic.j.j) rVar).j(z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(com.bytedance.sdk.component.adexpress.xt.ws wsVar) {
        if (wsVar == null) {
            return;
        }
        double m6 = wsVar.m();
        double ae = wsVar.ae();
        double tl = wsVar.tl();
        double g6 = wsVar.g();
        int cw = ed.cw(this.f29618m, (float) m6);
        int cw2 = ed.cw(this.f29618m, (float) ae);
        int cw3 = ed.cw(this.f29618m, (float) tl);
        int cw4 = ed.cw(this.f29618m, (float) g6);
        float cw5 = wsVar.vl() > 0.0f ? ed.cw(this.f29618m, wsVar.vl()) : 0.0f;
        float cw6 = wsVar.jy() > 0.0f ? ed.cw(this.f29618m, wsVar.jy()) : 0.0f;
        float cw7 = wsVar.ws() > 0.0f ? ed.cw(this.f29618m, wsVar.ws()) : 0.0f;
        float cw8 = wsVar.az() > 0.0f ? ed.cw(this.f29618m, wsVar.az()) : 0.0f;
        if (cw6 < cw5) {
            cw5 = cw6;
        }
        if (cw7 >= cw5) {
            cw7 = cw5;
        }
        if (cw8 >= cw7) {
            cw8 = cw7;
        }
        if (wsVar.xt() != 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jy.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(cw3, cw4);
            }
            layoutParams.width = cw3;
            layoutParams.height = cw4;
            layoutParams.topMargin = cw2;
            layoutParams.leftMargin = cw;
            this.jy.setLayoutParams(layoutParams);
        }
        ed.xt(this.jy, cw8);
        this.jy.removeAllViews();
        ExpressVideoView expressVideoView = this.oq;
        if (expressVideoView != null) {
            this.jy.addView(expressVideoView);
            this.oq.j(0L, true, false);
            cw(this.f29598r);
            if (!com.bytedance.sdk.component.utils.ws.r(this.f29618m) && !this.cw && this.up) {
                this.oq.z_();
            }
            setShowAdInteractionView(false);
        }
        ViewGroup viewGroup = (ViewGroup) this.jy.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.jy);
        }
        if (wsVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.cw) {
            FrameLayout av = ((com.bytedance.sdk.openadsdk.core.ugeno.express.cw) wsVar).av();
            if (av != null) {
                ExpressVideoView expressVideoView2 = this.oq;
                if (expressVideoView2 != null) {
                    expressVideoView2.setClickable(false);
                }
                av.addView(this.jy, new FrameLayout.LayoutParams(-1, -1));
                return;
            }
            return;
        }
        if (wsVar.xt() == 2) {
            View j6 = wsVar.j();
            if (j6 instanceof ViewGroup) {
                ExpressVideoView expressVideoView3 = this.oq;
                if (expressVideoView3 != null) {
                    expressVideoView3.setClickable(false);
                }
                ((ViewGroup) j6).addView(this.jy);
                return;
            }
            return;
        }
        this.kt.addView(this.jy);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void j(int i6) {
        ExpressVideoView expressVideoView = this.oq;
        if (expressVideoView == null) {
            com.bytedance.sdk.component.utils.vl.r("NativeExpressVideoView", "onChangeVideoState,ExpressVideoView is null !!!!!!!!!!!!");
            return;
        }
        if (i6 == 1) {
            expressVideoView.j(0L, true, false);
            return;
        }
        if (i6 == 2 || i6 == 3) {
            expressVideoView.setVideoPlayStatus(i6);
            this.oq.setCanInterruptVideoPlay(true);
            this.oq.performClick();
        } else if (i6 == 4) {
            expressVideoView.getNativeVideoController().oq();
        } else {
            if (i6 != 5) {
                return;
            }
            expressVideoView.j(0L, true, false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void g() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void m() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void oq() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void qv() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.component.adexpress.xt.tl
    public void j(View view, int i6, com.bytedance.sdk.component.adexpress.cw cwVar) {
        if (i6 == -1 || cwVar == null) {
            return;
        }
        if (i6 == 4) {
            x();
        } else if (i6 != 5) {
            super.j(view, i6, cwVar);
        } else {
            j(!this.mi);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.component.adexpress.xt.tl
    public void j(View view, int i6, com.bytedance.sdk.component.adexpress.cw cwVar, int i7) {
        if (i6 == -1 || cwVar == null) {
            return;
        }
        if (i6 != 4) {
            if (i6 != 5) {
                super.j(view, i6, cwVar, i7);
                return;
            }
        } else if (this.ae == "draw_ad") {
            ExpressVideoView expressVideoView = this.oq;
            if (expressVideoView != null) {
                expressVideoView.performClick();
                return;
            }
            return;
        }
        j(!this.mi);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void setPauseFromExpressView(boolean z5) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public long j() {
        return this.f29596f;
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw.InterfaceC0306cw
    public void j(long j6, long j7) {
        this.up = false;
        cw.InterfaceC0306cw interfaceC0306cw = this.vl;
        if (interfaceC0306cw != null) {
            interfaceC0306cw.j(j6, j7);
        }
        if (j(j6)) {
            this.f29597j = 2;
        }
        this.f29596f = j6;
        this.f29599v = j7;
        if (!this.ch.isEmpty()) {
            com.bykv.vk.openvk.component.video.api.r.cw videoController = this.oq.getVideoController();
            if (videoController instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.r) {
                ((com.bytedance.sdk.openadsdk.core.video.nativevideo.r) videoController).r(50);
            }
        }
        com.bytedance.sdk.openadsdk.core.multipro.xt.j jVar = this.tj;
        if (jVar != null) {
            jVar.ae = j6;
        }
        com.bytedance.sdk.component.adexpress.xt.r rVar = this.f29600x;
        if (rVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.r) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.express.r) rVar).j(j6, j7);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw.r
    public void j(int i6, int i7) {
        cw.r rVar = this.qv;
        if (rVar != null) {
            rVar.j(i6, i7);
        }
        this.f29596f = this.f29599v;
        this.f29597j = 4;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void j(final int i6, final String str) {
        super.j(i6, str);
        com.bykv.vk.openvk.component.video.api.r.cw videoController = this.oq.getVideoController();
        if (videoController instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.r) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.r rVar = (com.bytedance.sdk.openadsdk.core.video.nativevideo.r) videoController;
            rVar.r(50);
            rVar.j(new j.InterfaceC0491j() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.4
                @Override // com.bytedance.sdk.openadsdk.core.video.j.j.InterfaceC0491j
                public void j(long j6, long j7) {
                    int abs = (int) Math.abs(i6 - j6);
                    int i7 = i6;
                    if (i7 < 0 || abs > 50 || i7 > j7 || abs >= 50 || NativeExpressVideoView.this.ch.contains(str)) {
                        return;
                    }
                    if (i6 > j6) {
                        NativeExpressVideoView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                NativeExpressVideoView.this.oq.setVideoPlayStatus(2);
                                NativeExpressVideoView.this.oq.setCanInterruptVideoPlay(true);
                                NativeExpressVideoView.this.oq.performClick();
                                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                NativeExpressVideoView.this.xt(i6, str);
                            }
                        }, abs);
                    } else {
                        NativeExpressVideoView.this.oq.setVideoPlayStatus(2);
                        NativeExpressVideoView.this.oq.setCanInterruptVideoPlay(true);
                        NativeExpressVideoView.this.oq.performClick();
                        NativeExpressVideoView.this.xt(i6, str);
                    }
                    NativeExpressVideoView.this.ch.add(str);
                }
            });
        }
    }

    private boolean j(long j6) {
        int i6 = this.f29597j;
        if (i6 != 5 && i6 != 3 && j6 > this.f29596f) {
            return true;
        }
        ExpressVideoView expressVideoView = this.oq;
        return expressVideoView != null && expressVideoView.A_();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public int xt() {
        ExpressVideoView expressVideoView;
        if (this.f29597j == 3 && (expressVideoView = this.oq) != null) {
            expressVideoView.cw();
        }
        ExpressVideoView expressVideoView2 = this.oq;
        if (expressVideoView2 == null || !expressVideoView2.getNativeVideoController().f()) {
            return this.f29597j;
        }
        return 1;
    }
}
