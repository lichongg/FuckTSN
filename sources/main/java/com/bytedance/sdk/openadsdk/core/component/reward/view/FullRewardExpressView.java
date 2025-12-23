package com.bytedance.sdk.openadsdk.core.component.reward.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.xt.cw;
import com.bytedance.sdk.component.adexpress.xt.r;
import com.bytedance.sdk.component.adexpress.xt.ws;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.FullRewardExpressBackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.qv;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.e;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.z;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.video.j.j;
import java.util.HashSet;

/* loaded from: D:\Downloads\app\classes4.dex */
public class FullRewardExpressView extends NativeExpressView implements qv {

    /* renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ugeno.oq.j f28432a;
    private j.InterfaceC0491j ch;
    com.bytedance.sdk.openadsdk.core.video.xt.j cw;

    /* renamed from: f, reason: collision with root package name */
    private HashSet<String> f28433f;

    /* renamed from: j, reason: collision with root package name */
    qv f28434j;

    /* renamed from: r, reason: collision with root package name */
    private r f28435r;

    /* renamed from: s, reason: collision with root package name */
    private FullSwiperItemView.j f28436s;
    private ImageView tj;
    private ws up;

    /* renamed from: v, reason: collision with root package name */
    private j f28437v;

    /* renamed from: x, reason: collision with root package name */
    private View f28438x;
    FullRewardExpressBackupView xt;

    public interface j {
        void j(int i6);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    protected void vl() {
        this.az = true;
        this.jy = new FrameLayout(this.f29618m);
        super.vl();
        az();
        if (getJsObject() != null) {
            getJsObject().vl(this.mi);
        }
    }

    private void az() {
        setBackupListener(new cw() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.1
            @Override // com.bytedance.sdk.component.adexpress.xt.cw
            public boolean j(ViewGroup viewGroup, int i6) {
                try {
                    ((NativeExpressView) viewGroup).mi();
                    FullRewardExpressView.this.xt = new FullRewardExpressBackupView(viewGroup.getContext());
                    FullRewardExpressView fullRewardExpressView = FullRewardExpressView.this;
                    fullRewardExpressView.xt.j(((NativeExpressView) fullRewardExpressView).f29612g, (NativeExpressView) viewGroup);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
    }

    private void v() {
        com.bytedance.sdk.openadsdk.core.video.xt.j jVar;
        if ((this.f28435r instanceof com.bytedance.sdk.component.adexpress.dynamic.j.j) && (jVar = this.cw) != null) {
            if (jVar.sm()) {
                this.cw.m();
                xt(true);
            } else {
                this.cw.tl();
                xt(false);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public int cw() {
        qv qvVar = this.f28434j;
        if (qvVar != null) {
            return qvVar.cw();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void g() {
        qv qvVar = this.f28434j;
        if (qvVar != null) {
            qvVar.g();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public long getActualPlayDuration() {
        qv qvVar = this.f28434j;
        if (qvVar != null) {
            return qvVar.getActualPlayDuration();
        }
        return 0L;
    }

    public ws getRenderResult() {
        return this.up;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public com.bykv.vk.openvk.component.video.api.r.cw getVideoController() {
        return this.cw;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void m() {
        qv qvVar = this.f28434j;
        if (qvVar != null) {
            qvVar.m();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void oq() {
        qv qvVar = this.f28434j;
        if (qvVar != null) {
            qvVar.oq();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void qv() {
        qv qvVar = this.f28434j;
        if (qvVar != null) {
            qvVar.qv();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void r() {
        qv qvVar = this.f28434j;
        if (qvVar != null) {
            qvVar.r();
        }
    }

    public void setEasyPlayableContainer(View view) {
        this.f28438x = view;
    }

    public void setExpressVideoListenerProxy(qv qvVar) {
        this.f28434j = qvVar;
    }

    public void setInteractListener(FullSwiperItemView.j jVar) {
        this.f28436s = jVar;
    }

    public void setOnVideoSizeChangeListener(j jVar) {
        this.f28437v = jVar;
    }

    public void setVideoController(com.bykv.vk.openvk.component.video.api.r.cw cwVar) {
        if (cwVar instanceof com.bytedance.sdk.openadsdk.core.video.xt.j) {
            com.bytedance.sdk.openadsdk.core.video.xt.j jVar = (com.bytedance.sdk.openadsdk.core.video.xt.j) cwVar;
            this.cw = jVar;
            jVar.r(50);
            this.cw.j(this.ch);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void tl() {
        qv qvVar = this.f28434j;
        if (qvVar != null) {
            qvVar.tl();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void up() {
        qv qvVar = this.f28434j;
        if (qvVar != null) {
            qvVar.up();
        }
    }

    public boolean ws() {
        ws wsVar = this.up;
        if (wsVar == null) {
            return true;
        }
        return wsVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.cw ? ((com.bytedance.sdk.openadsdk.core.ugeno.express.cw) wsVar).av() != null : (wsVar.tl() == 0.0d || this.up.g() == 0.0d) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x007d  */
    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void xt(com.bytedance.sdk.component.adexpress.xt.r<? extends android.view.View> r4, com.bytedance.sdk.component.adexpress.xt.ws r5) {
        /*
            r3 = this;
            r3.f28435r = r4
            boolean r0 = r4 instanceof com.bytedance.sdk.openadsdk.core.nativeexpress.az
            if (r0 == 0) goto L16
            r0 = r4
            com.bytedance.sdk.openadsdk.core.nativeexpress.az r0 = (com.bytedance.sdk.openadsdk.core.nativeexpress.az) r0
            com.bytedance.sdk.openadsdk.core.rn r1 = r0.D_()
            if (r1 == 0) goto L16
            com.bytedance.sdk.openadsdk.core.rn r0 = r0.D_()
            r0.j(r3)
        L16:
            boolean r0 = r4 instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.j
            if (r0 == 0) goto L20
            r0 = r4
            com.bytedance.sdk.openadsdk.core.ugeno.express.j r0 = (com.bytedance.sdk.openadsdk.core.ugeno.express.j) r0
            r0.j(r3)
        L20:
            if (r5 == 0) goto L87
            boolean r0 = r5.cw()
            if (r0 == 0) goto L87
            r3.up = r5
            int r0 = r5.xt()
            r1 = 2
            if (r0 != r1) goto L43
            android.view.View r0 = r5.j()
            boolean r1 = r0 instanceof android.view.ViewGroup
            if (r1 == 0) goto L43
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            android.view.ViewGroup r1 = r3.getVideoContainer()
            r0.addView(r1)
            goto L49
        L43:
            android.widget.FrameLayout r0 = r3.jy
            r1 = 1
            r3.j(r0, r1)
        L49:
            int r0 = r5.xt()
            r1 = 10
            if (r0 != r1) goto L5e
            boolean r0 = r5 instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.cw
            if (r0 == 0) goto L5e
            r0 = r5
            com.bytedance.sdk.openadsdk.core.ugeno.express.cw r0 = (com.bytedance.sdk.openadsdk.core.ugeno.express.cw) r0
            com.bytedance.sdk.openadsdk.core.ugeno.oq.j r0 = r0.w()
            r3.f28432a = r0
        L5e:
            int r0 = r5.xt()
            if (r0 != r1) goto L87
            boolean r0 = r5 instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.cw
            if (r0 == 0) goto L87
            r0 = r5
            com.bytedance.sdk.openadsdk.core.ugeno.express.cw r0 = (com.bytedance.sdk.openadsdk.core.ugeno.express.cw) r0
            android.widget.FrameLayout r0 = r0.i()
            if (r0 == 0) goto L87
            android.view.View r1 = r3.f28438x
            if (r1 == 0) goto L87
            android.view.ViewParent r1 = r1.getParent()
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            if (r1 == 0) goto L82
            android.view.View r2 = r3.f28438x
            r1.removeView(r2)
        L82:
            android.view.View r1 = r3.f28438x
            r0.addView(r1)
        L87:
            super.xt(r4, r5)
            int r4 = r3.getVisibility()
            r3.r(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.xt(com.bytedance.sdk.component.adexpress.xt.r, com.bytedance.sdk.component.adexpress.xt.ws):void");
    }

    public FullRewardExpressView(Context context, n nVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, String str, boolean z5) {
        super(context, nVar, xtVar, str, z5);
        this.f28433f = new HashSet<>();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void ae() {
        super.ae();
        qv qvVar = this.f28434j;
        if (qvVar != null) {
            qvVar.ae();
        }
    }

    public FrameLayout getVideoFrameLayout() {
        if (tj()) {
            return this.xt.getVideoContainer();
        }
        return this.jy;
    }

    public void j(final ViewGroup viewGroup, final boolean z5) {
        if (this.up == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            xt(viewGroup, z5);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.2
                @Override // java.lang.Runnable
                public void run() {
                    FullRewardExpressView.this.xt(viewGroup, z5);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void jy() {
        super.jy();
        this.f28433f.clear();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, android.view.View
    public void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        cw(z5);
    }

    private void cw(boolean z5) {
        com.bytedance.sdk.openadsdk.core.video.xt.j jVar;
        if ((this.f28435r instanceof com.bytedance.sdk.component.adexpress.dynamic.j.j) && z5) {
            ImageView imageView = this.tj;
            if (imageView != null && imageView.getVisibility() == 0 && (jVar = this.cw) != null) {
                jVar.m();
            } else {
                j(this.mi);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void j(boolean z5) {
        super.j(z5);
        this.mi = z5;
        qv qvVar = this.f28434j;
        if (qvVar != null) {
            qvVar.j(z5);
        }
        r rVar = this.f28435r;
        if (rVar == null || !(rVar instanceof com.bytedance.sdk.component.adexpress.dynamic.j.j)) {
            return;
        }
        ((com.bytedance.sdk.component.adexpress.dynamic.j.j) rVar).j(z5);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void j(int i6) {
        qv qvVar = this.f28434j;
        if (qvVar != null) {
            qvVar.j(i6);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public long j() {
        qv qvVar = this.f28434j;
        if (qvVar != null) {
            return qvVar.j();
        }
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void j(float f6, float f7, float f8, float f9, int i6) {
        qv qvVar = this.f28434j;
        if (qvVar != null) {
            qvVar.j(f6, f7, f8, f9, i6);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void j(final int i6, final String str) {
        this.ch = new j.InterfaceC0491j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.3
            @Override // com.bytedance.sdk.openadsdk.core.video.j.j.InterfaceC0491j
            public void j(long j6, long j7) {
                qv qvVar;
                int abs = (int) Math.abs(i6 - j6);
                if (FullRewardExpressView.this.cw.rn() && (qvVar = FullRewardExpressView.this.f28434j) != null) {
                    abs = (int) Math.abs(i6 - qvVar.getActualPlayDuration());
                }
                FullRewardExpressView fullRewardExpressView = FullRewardExpressView.this;
                int i7 = fullRewardExpressView.cw instanceof com.bytedance.sdk.openadsdk.core.component.reward.draw.r ? 200 : 50;
                int i8 = i6;
                if (i8 < 0 || abs > i7 || i8 > j7 || abs >= i7 || fullRewardExpressView.f28433f.contains(str)) {
                    return;
                }
                if (i6 > j6) {
                    FullRewardExpressView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FullRewardExpressView.this.cw.m();
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            FullRewardExpressView.this.xt(i6, str);
                            if (e.i(((NativeExpressView) FullRewardExpressView.this).f29612g) || z.j(((NativeExpressView) FullRewardExpressView.this).f29612g)) {
                                FullRewardExpressView.this.f28434j.j(2);
                            }
                            qv qvVar2 = FullRewardExpressView.this.f28434j;
                            if (qvVar2 != null) {
                                qvVar2.setPauseFromExpressView(true);
                            }
                        }
                    }, abs);
                } else {
                    FullRewardExpressView.this.cw.m();
                    FullRewardExpressView.this.xt(i6, str);
                    if (e.i(((NativeExpressView) FullRewardExpressView.this).f29612g) || z.j(((NativeExpressView) FullRewardExpressView.this).f29612g)) {
                        FullRewardExpressView.this.f28434j.j(2);
                    }
                    qv qvVar2 = FullRewardExpressView.this.f28434j;
                    if (qvVar2 != null) {
                        qvVar2.setPauseFromExpressView(true);
                    }
                }
                FullRewardExpressView.this.f28433f.add(str);
            }
        };
        com.bytedance.sdk.openadsdk.core.video.xt.j jVar = this.cw;
        if (jVar != null) {
            jVar.r(50);
            this.cw.j(this.ch);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void j(float f6) {
        qv qvVar = this.f28434j;
        if (qvVar != null) {
            qvVar.j(f6);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.component.adexpress.xt.tl
    public void j(View view, int i6, com.bytedance.sdk.component.adexpress.cw cwVar) {
        FullSwiperItemView.j jVar = this.f28436s;
        if (jVar != null) {
            jVar.j();
        }
        if (i6 != -1 && cwVar != null && i6 == 3) {
            oq();
            return;
        }
        if (i6 == 5) {
            j(!this.mi);
        } else if (i6 == 4) {
            v();
        } else {
            super.j(view, i6, cwVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void setPauseFromExpressView(boolean z5) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(ViewGroup viewGroup, boolean z5) {
        j jVar;
        ws wsVar = this.up;
        if (wsVar == null) {
            return;
        }
        double m6 = wsVar.m();
        double ae = this.up.ae();
        double tl = this.up.tl();
        double g6 = this.up.g();
        int cw = ed.cw(this.f29618m, (float) m6);
        int cw2 = ed.cw(this.f29618m, (float) ae);
        int cw3 = ed.cw(this.f29618m, (float) tl);
        int cw4 = ed.cw(this.f29618m, (float) g6);
        float cw5 = this.up.vl() > 0.0f ? ed.cw(this.f29618m, this.up.vl()) : 0.0f;
        float cw6 = this.up.jy() > 0.0f ? ed.cw(this.f29618m, this.up.jy()) : 0.0f;
        float cw7 = this.up.ws() > 0.0f ? ed.cw(this.f29618m, this.up.ws()) : 0.0f;
        float cw8 = this.up.az() > 0.0f ? ed.cw(this.f29618m, this.up.az()) : 0.0f;
        if (cw6 < cw5) {
            cw5 = cw6;
        }
        if (cw7 >= cw5) {
            cw7 = cw5;
        }
        if (cw8 >= cw7) {
            cw8 = cw7;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(cw3, cw4);
        }
        layoutParams.width = cw3;
        layoutParams.height = cw4;
        layoutParams.topMargin = cw2;
        layoutParams.leftMargin = cw;
        viewGroup.setLayoutParams(layoutParams);
        ed.xt(viewGroup, cw8);
        if (z5) {
            viewGroup.removeAllViews();
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(viewGroup);
            }
            if (this.f28435r.cw() == 7 || this.f28435r.cw() == 10) {
                ws wsVar2 = this.up;
                if (wsVar2 instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.cw) {
                    FrameLayout av = ((com.bytedance.sdk.openadsdk.core.ugeno.express.cw) wsVar2).av();
                    if (av != null) {
                        av.addView(viewGroup, new FrameLayout.LayoutParams(-1, -1));
                    }
                    jVar = this.f28437v;
                    if (jVar != null || cw4 == 0) {
                    }
                    jVar.j(cw4);
                    return;
                }
            }
            this.kt.addView(viewGroup);
            jVar = this.f28437v;
            if (jVar != null) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.component.adexpress.xt.tl
    public void j(View view, int i6, com.bytedance.sdk.component.adexpress.cw cwVar, int i7) {
        FullSwiperItemView.j jVar = this.f28436s;
        if (jVar != null) {
            jVar.j();
        }
        if (i6 != -1 && cwVar != null && i6 == 3) {
            oq();
        } else {
            super.j(view, i6, cwVar, i7);
        }
    }

    public void j(int i6, int i7, int i8, int i9) {
        com.bytedance.sdk.openadsdk.core.ugeno.oq.j jVar = this.f28432a;
        if (jVar != null) {
            jVar.j(i6, i7, i8, i9);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public int xt() {
        qv qvVar = this.f28434j;
        if (qvVar != null) {
            return qvVar.xt();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void xt(int i6) {
        qv qvVar = this.f28434j;
        if (qvVar != null) {
            qvVar.xt(i6);
        }
    }

    protected void xt(boolean z5) {
        if (this.tj == null) {
            this.tj = new ImageView(getContext());
            if (oq.i().rh() != null) {
                this.tj.setImageBitmap(oq.i().rh());
            } else {
                kt.j(v.getContext(), "tt_new_play_video", this.tj);
            }
            this.tj.setScaleType(ImageView.ScaleType.FIT_XY);
            int cw = ed.cw(getContext(), 50.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(cw, cw);
            layoutParams.gravity = 17;
            this.jy.addView(this.tj, layoutParams);
        }
        if (z5) {
            this.tj.setVisibility(0);
        } else {
            this.tj.setVisibility(8);
        }
    }
}
