package com.bytedance.sdk.component.adexpress.dynamic.j;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.cw;
import com.bytedance.sdk.component.adexpress.dynamic.cw.m;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicRootView;
import com.bytedance.sdk.component.adexpress.r.up;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.adexpress.xt.ae;
import com.bytedance.sdk.component.adexpress.xt.jy;
import com.bytedance.sdk.component.adexpress.xt.qv;
import com.bytedance.sdk.component.adexpress.xt.r;
import com.bytedance.sdk.component.adexpress.xt.tl;
import com.bytedance.sdk.component.adexpress.xt.ws;
import com.bytedance.sdk.component.utils.vl;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements qv, r<DynamicRootView> {
    private ScheduledFuture<?> ae;
    private Context cw;

    /* renamed from: j, reason: collision with root package name */
    private DynamicRootView f25779j;

    /* renamed from: m, reason: collision with root package name */
    private jy f25780m;

    /* renamed from: r, reason: collision with root package name */
    private ae f25781r;
    private tl up;
    private com.bytedance.sdk.component.adexpress.dynamic.r.tl xt;
    private AtomicBoolean tl = new AtomicBoolean(false);

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f25778g = false;

    /* renamed from: com.bytedance.sdk.component.adexpress.dynamic.j.j$j, reason: collision with other inner class name */
    private class RunnableC0395j implements Runnable {
        private int xt;

        public RunnableC0395j(int i6) {
            this.xt = i6;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.xt == 2) {
                j.this.f25779j.j(j.this.xt instanceof com.bytedance.sdk.component.adexpress.dynamic.r.ae ? 127 : 117, (String) null);
            }
        }
    }

    private boolean g() {
        DynamicRootView dynamicRootView = this.f25779j;
        return (dynamicRootView == null || dynamicRootView.getChildCount() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oq() {
        try {
            ScheduledFuture<?> scheduledFuture = this.ae;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.ae.cancel(false);
            this.ae = null;
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tl() {
        this.f25780m.ae().xt(cw());
        JSONObject up = this.f25780m.up();
        if (com.bytedance.sdk.component.adexpress.j.xt.xt.j(up)) {
            this.xt.j(new com.bytedance.sdk.component.adexpress.dynamic.up.xt() { // from class: com.bytedance.sdk.component.adexpress.dynamic.j.j.3
                @Override // com.bytedance.sdk.component.adexpress.dynamic.up.xt
                public void j(final com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar) {
                    j.this.oq();
                    j.this.f25780m.ae().cw(j.this.cw());
                    j.this.j(tlVar);
                    j.this.xt(tlVar);
                    if (j.this.f25778g) {
                        j.this.cw(tlVar);
                    } else {
                        com.bytedance.sdk.component.utils.tl.xt().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.j.j.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                j.this.cw(tlVar);
                            }
                        });
                    }
                    if (j.this.f25779j == null || tlVar == null) {
                        return;
                    }
                    j.this.f25779j.setBgColor(tlVar.j());
                    j.this.f25779j.setBgMaterialCenterCalcColor(tlVar.xt());
                }
            });
            this.xt.j(this.f25780m);
            return;
        }
        int i6 = this.xt instanceof com.bytedance.sdk.component.adexpress.dynamic.r.ae ? 123 : 113;
        DynamicRootView dynamicRootView = this.f25779j;
        StringBuilder sb = new StringBuilder("data null is ");
        sb.append(up == null);
        dynamicRootView.j(i6, sb.toString());
    }

    public DynamicRootView m() {
        return this.f25779j;
    }

    public void r() {
        this.f25779j.j();
    }

    public void up() {
        this.f25779j.xt();
    }

    public j(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z5, com.bytedance.sdk.component.adexpress.dynamic.r.tl tlVar, jy jyVar, com.bytedance.sdk.component.adexpress.dynamic.up.j jVar) {
        this.cw = context;
        DynamicRootView dynamicRootView = new DynamicRootView(context, themeStatusBroadcastReceiver, z5, jyVar, jVar);
        this.f25779j = dynamicRootView;
        this.xt = tlVar;
        this.f25780m = jyVar;
        dynamicRootView.setRenderListener(this);
        this.f25780m = jyVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar) {
        float f6;
        float f7;
        List<com.bytedance.sdk.component.adexpress.dynamic.cw.tl> qv;
        if (tlVar == null) {
            return;
        }
        List<com.bytedance.sdk.component.adexpress.dynamic.cw.tl> qv2 = tlVar.qv();
        if (qv2 == null || qv2.size() <= 0) {
            f6 = 0.0f;
        } else {
            f6 = 0.0f;
            for (com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar2 : qv2) {
                if (tlVar2.ae() > tlVar.ae() - tlVar2.g() || (qv = tlVar2.qv()) == null || qv.size() <= 0) {
                    f7 = 0.0f;
                } else {
                    f7 = 0.0f;
                    for (com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar3 : qv) {
                        if (tlVar3.oq().getType().equals("logo-union")) {
                            f7 = tlVar3.oq().m();
                            f6 = (((-f7) + tlVar.ae()) - tlVar2.ae()) + tlVar2.oq().up().px();
                        }
                    }
                }
                xt(tlVar2);
                if (f7 <= -15.0f) {
                    tlVar2.m(tlVar2.g() - f7);
                    tlVar2.r(tlVar2.ae() + f7);
                    for (com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar4 : tlVar2.qv()) {
                        tlVar4.r(tlVar4.ae() - f7);
                    }
                }
            }
        }
        com.bytedance.sdk.component.adexpress.dynamic.cw.tl vl = tlVar.vl();
        if (vl == null) {
            return;
        }
        float m6 = tlVar.m() - vl.m();
        float ae = tlVar.ae() - vl.ae();
        tlVar.cw(m6);
        tlVar.r(ae);
        if (f6 > 0.0f) {
            tlVar.r(tlVar.ae() - f6);
            tlVar.m(tlVar.g() + f6);
            for (com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar5 : tlVar.qv()) {
                tlVar5.r(tlVar5.ae() + f6);
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.r
    public int cw() {
        return this.xt instanceof com.bytedance.sdk.component.adexpress.dynamic.r.ae ? 3 : 2;
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.r
    public void j(ae aeVar) {
        this.f25781r = aeVar;
        int tl = this.f25780m.tl();
        if (tl < 0) {
            int i6 = this.xt instanceof com.bytedance.sdk.component.adexpress.dynamic.r.ae ? 127 : 117;
            this.f25779j.j(i6, "time is " + tl);
            return;
        }
        this.ae = up.j(new RunnableC0395j(2), tl, TimeUnit.MILLISECONDS);
        if (this.f25778g) {
            com.bytedance.sdk.component.utils.tl.cw().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.j.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.tl();
                }
            }, this.f25780m.vl());
        } else if (Looper.getMainLooper() == Looper.myLooper() && this.f25780m.vl() <= 0) {
            tl();
        } else {
            com.bytedance.sdk.component.utils.tl.xt().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.j.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.tl();
                }
            }, this.f25780m.vl());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw(com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar) {
        if (tlVar == null) {
            this.f25779j.j(this.xt instanceof com.bytedance.sdk.component.adexpress.dynamic.r.ae ? 123 : 113, "layoutUnit is null");
            return;
        }
        this.f25780m.ae().r(cw());
        try {
            this.f25779j.j(tlVar, cw());
        } catch (Exception e6) {
            int i6 = this.xt instanceof com.bytedance.sdk.component.adexpress.dynamic.r.ae ? 128 : 118;
            this.f25779j.j(i6, "exception is " + e6.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar) {
        List<com.bytedance.sdk.component.adexpress.dynamic.cw.tl> qv;
        if (tlVar == null || (qv = tlVar.qv()) == null || qv.size() <= 0) {
            return;
        }
        Collections.sort(qv, new Comparator<com.bytedance.sdk.component.adexpress.dynamic.cw.tl>() { // from class: com.bytedance.sdk.component.adexpress.dynamic.j.j.4
            @Override // java.util.Comparator
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public int compare(com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar2, com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar3) {
                m up = tlVar2.oq().up();
                m up2 = tlVar3.oq().up();
                if (up != null && up2 != null) {
                    if (up.ri() >= up2.ri()) {
                        return 1;
                    }
                    return -1;
                }
                return 0;
            }
        });
        for (com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar2 : qv) {
            if (tlVar2 != null) {
                j(tlVar2);
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.r
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public DynamicRootView ae() {
        return m();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void j(View view) {
        if (view == 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            int i6 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i6 >= viewGroup.getChildCount()) {
                    break;
                }
                j(viewGroup.getChildAt(i6));
                i6++;
            }
        }
        if (view instanceof com.bytedance.sdk.component.adexpress.dynamic.dynamicview.up) {
            ((com.bytedance.sdk.component.adexpress.dynamic.dynamicview.up) view).xt();
        }
    }

    public void xt() {
        j(ae());
    }

    public void xt(boolean z5) {
        this.f25778g = z5;
    }

    public void j(boolean z5) {
        this.f25779j.setSoundMute(z5);
    }

    public void j(tl tlVar) {
        this.up = tlVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.qv
    public void j(ws wsVar) {
        if (this.tl.get()) {
            return;
        }
        this.tl.set(true);
        if (wsVar.cw() && g()) {
            this.f25779j.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f25781r.j(ae(), wsVar);
            return;
        }
        this.f25781r.j(wsVar.qv(), wsVar.oq());
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.qv
    public void j(View view, int i6, cw cwVar) {
        tl tlVar = this.up;
        if (tlVar != null) {
            tlVar.j(view, i6, cwVar);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.qv
    public void j(View view, int i6, cw cwVar, int i7) {
        tl tlVar = this.up;
        if (tlVar != null) {
            tlVar.j(view, i6, cwVar, i7);
        }
    }
}
