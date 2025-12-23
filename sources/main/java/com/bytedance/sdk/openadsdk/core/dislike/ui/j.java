package com.bytedance.sdk.openadsdk.core.dislike.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.bytedance.sdk.component.utils.tl;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.i.cw.xt.ae;
import com.bytedance.sdk.openadsdk.i.cw.xt.m;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends ae {
    private boolean ae;
    private cw cw;

    /* renamed from: g, reason: collision with root package name */
    private xt f28887g;

    /* renamed from: j, reason: collision with root package name */
    private final Context f28888j;

    /* renamed from: m, reason: collision with root package name */
    private AtomicBoolean f28889m;
    private InterfaceC0455j oq;
    private final List<com.bytedance.sdk.openadsdk.core.dislike.xt.j> qv;

    /* renamed from: r, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.dislike.ui.xt f28890r;
    private SoftReference<View> tl;
    private TTDislikeToast up;
    private com.bytedance.sdk.openadsdk.core.dislike.cw.xt xt;

    /* renamed from: com.bytedance.sdk.openadsdk.core.dislike.ui.j$j, reason: collision with other inner class name */
    public interface InterfaceC0455j {
        void j();

        void j(int i6, String str, boolean z5);

        void xt();
    }

    public j(Context context, com.bytedance.sdk.openadsdk.core.dislike.cw.xt xtVar, String str, boolean z5) {
        this.f28889m = new AtomicBoolean(false);
        this.qv = new ArrayList();
        xtVar.xt(str);
        xtVar.j("other");
        this.f28888j = context;
        if (context == null) {
            return;
        }
        if (!(context instanceof Activity)) {
            vl.cw("Dislike 初始化必须使用activity,请在TTAdManager.createAdNative(activity)中传入");
            return;
        }
        this.xt = xtVar;
        this.ae = z5;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            r();
        } else {
            tl.xt().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.r();
                }
            });
        }
    }

    public static class xt extends Handler {

        /* renamed from: j, reason: collision with root package name */
        public WeakReference<Context> f28896j;

        public xt(Context context) {
            this.f28896j = new WeakReference<>(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        com.bytedance.sdk.openadsdk.core.dislike.cw.xt xtVar = this.xt;
        if (xtVar == null) {
            return;
        }
        final String ae = xtVar.ae();
        if ("slide_banner_ad".equals(ae) || "banner_ad".equals(ae) || "embeded_ad".equals(ae)) {
            if (this.tl.get() != null && this.xt.tl()) {
                this.tl.get().setVisibility(8);
            }
            if (this.f28887g == null) {
                this.f28887g = new xt(this.f28888j);
            }
            this.f28887g.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.j.5
                @Override // java.lang.Runnable
                public void run() {
                    j.this.xt.xt("dislike");
                    if (j.this.tl == null || j.this.tl.get() == null || !((View) j.this.tl.get()).isShown()) {
                        com.bytedance.sdk.openadsdk.core.dislike.j.j.j().j(j.this.f28888j, j.this.xt, "close_success");
                    } else {
                        com.bytedance.sdk.openadsdk.core.dislike.j.j.j().j(j.this.f28888j, j.this.xt, "close_fail");
                    }
                    j.this.xt.xt(ae);
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        ViewGroup viewGroup;
        cw cwVar = new cw(this.f28888j, this.xt);
        this.cw = cwVar;
        cwVar.j(new com.bytedance.sdk.openadsdk.core.dislike.xt.cw() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.j.2
            @Override // com.bytedance.sdk.openadsdk.core.dislike.xt.cw
            public void j() {
                j.this.up();
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.xt.cw
            public void cw() {
                vl.r("TTAdDislikeImpl", "onDislikeHide: ");
                try {
                    if (j.this.oq == null || j.this.cw()) {
                        return;
                    }
                    j.this.oq.xt();
                } catch (Throwable th) {
                    vl.cw("TTAdDislikeImpl", "dislike callback cancel error: ", th);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.xt.cw
            public void j(int i6, m mVar) {
                try {
                    if (!j.this.qv.isEmpty()) {
                        String r5 = j.this.f28890r != null ? j.this.f28890r.r() : "";
                        Iterator it = j.this.qv.iterator();
                        while (it.hasNext()) {
                            ((com.bytedance.sdk.openadsdk.core.dislike.xt.j) it.next()).j(mVar, r5, j.this.f28890r);
                        }
                    }
                    if (!mVar.m()) {
                        if (j.this.oq != null) {
                            j.this.oq.j(i6, mVar.xt(), j.this.xt != null ? j.this.xt.tl() : false);
                        }
                        j.this.f28889m.set(true);
                        if (j.this.up != null) {
                            j.this.up.j();
                        }
                        j.this.m();
                    }
                    vl.r("TTAdDislikeImpl", "onDislikeSelected: " + i6 + ", " + mVar.xt());
                } catch (Throwable th) {
                    vl.cw("TTAdDislikeImpl", "dislike callback selected error: ", th);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.xt.cw
            public void xt() {
                if (j.this.oq != null) {
                    j.this.oq.j();
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.dislike.ui.xt xtVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.xt(this.f28888j, this.xt);
        this.f28890r = xtVar;
        xtVar.j(new com.bytedance.sdk.openadsdk.core.dislike.xt.xt() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.j.3
            @Override // com.bytedance.sdk.openadsdk.core.dislike.xt.xt
            public void j() {
                try {
                    if (j.this.f28889m.get()) {
                        return;
                    }
                    j.this.cw.show();
                    if (j.this.f28890r != null) {
                        String r5 = j.this.f28890r.r();
                        if (TextUtils.isEmpty(r5)) {
                            return;
                        }
                        j.this.cw.j(r5);
                    }
                } catch (Throwable th) {
                    vl.cw("TTAdDislikeImpl", "dislike callback selected error: ", th);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.xt.xt
            public void j(int i6, m mVar) {
                try {
                    if (mVar.m()) {
                        return;
                    }
                    if (j.this.oq != null) {
                        j.this.oq.j(i6, mVar.xt(), j.this.xt != null ? j.this.xt.tl() : false);
                    }
                    j.this.f28889m.set(true);
                    if (j.this.up != null) {
                        j.this.up.j();
                    }
                    j.this.m();
                } catch (Throwable th) {
                    vl.cw("TTAdDislikeImpl", "comment callback selected error: ", th);
                }
            }
        });
        if ((this.f28888j instanceof Activity) && this.ae) {
            this.up = new TTDislikeToast(this.f28888j);
            Window window = ((Activity) this.f28888j).getWindow();
            if (window == null || (viewGroup = (ViewGroup) window.getDecorView()) == null) {
                return;
            }
            viewGroup.addView(this.up);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void up() {
        Context context = this.f28888j;
        if (!(context instanceof Activity) || ((Activity) context).isFinishing() || this.f28890r.isShowing()) {
            return;
        }
        this.f28890r.show();
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ae
    public boolean cw() {
        if (!(this.f28888j instanceof Activity)) {
            return false;
        }
        cw cwVar = this.cw;
        boolean isShowing = cwVar != null ? cwVar.isShowing() : false;
        com.bytedance.sdk.openadsdk.core.dislike.ui.xt xtVar = this.f28890r;
        return xtVar != null ? xtVar.isShowing() | isShowing : isShowing;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ae
    public void j() {
        TTDislikeToast tTDislikeToast;
        Context context = this.f28888j;
        boolean z5 = (context instanceof Activity) && !((Activity) context).isFinishing();
        if (this.f28889m.get() && this.ae && (tTDislikeToast = this.up) != null) {
            tTDislikeToast.xt();
        } else {
            if (!z5 || cw()) {
                return;
            }
            this.cw.show();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ae
    public void xt() {
        if (this.f28888j instanceof Activity) {
            cw cwVar = this.cw;
            if (cwVar != null) {
                cwVar.hide();
            }
            com.bytedance.sdk.openadsdk.core.dislike.ui.xt xtVar = this.f28890r;
            if (xtVar != null) {
                xtVar.j();
            }
            TTDislikeToast tTDislikeToast = this.up;
            if (tTDislikeToast != null) {
                tTDislikeToast.cw();
            }
            this.f28889m.set(false);
        }
    }

    public void j(com.bytedance.sdk.openadsdk.core.dislike.cw.xt xtVar) {
        if ((this.f28888j instanceof Activity) && xtVar != null) {
            this.cw.j(xtVar);
            this.f28890r.j(xtVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ae
    public void j(final com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar) {
        this.oq = new InterfaceC0455j() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.j.4
            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.j.InterfaceC0455j
            public void j() {
                com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar2 = jVar;
                if (jVar2 != null) {
                    jVar2.j();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.j.InterfaceC0455j
            public void xt() {
                com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar2 = jVar;
                if (jVar2 != null) {
                    jVar2.xt();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.j.InterfaceC0455j
            public void j(int i6, String str, boolean z5) {
                com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar2 = jVar;
                if (jVar2 != null) {
                    jVar2.j(i6, str, z5);
                }
            }
        };
    }

    public void j(InterfaceC0455j interfaceC0455j) {
        this.oq = interfaceC0455j;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ae
    public void j(String str) {
        com.bytedance.sdk.openadsdk.core.dislike.cw.xt xtVar = this.xt;
        if (xtVar != null) {
            xtVar.j(str);
        }
    }

    public j(Context context, com.bytedance.sdk.openadsdk.core.dislike.cw.xt xtVar, boolean z5) {
        this(context, xtVar, null, z5);
    }

    public void j(View view) {
        this.tl = new SoftReference<>(view);
    }

    public void j(com.bytedance.sdk.openadsdk.core.dislike.xt.j jVar) {
        this.qv.add(jVar);
        com.bytedance.sdk.openadsdk.core.dislike.ui.xt xtVar = this.f28890r;
        if (xtVar != null) {
            xtVar.j(jVar);
        }
    }
}
