package com.bytedance.sdk.openadsdk.core.component.reward.endcard;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Patterns;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.r.g;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.jy.tl;
import com.bytedance.sdk.openadsdk.core.rn;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.kt;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.w.m;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class j {
    protected SSWebView ae;
    protected String cw;

    /* renamed from: g, reason: collision with root package name */
    protected tl f28246g;

    /* renamed from: j, reason: collision with root package name */
    protected TTBaseVideoActivity f28248j;
    protected int kt;
    protected int mi;
    protected String oq;
    protected com.bytedance.sdk.openadsdk.core.widget.j.r qv;

    /* renamed from: r, reason: collision with root package name */
    protected boolean f28250r;
    protected int tj;
    protected rn tl;
    com.bytedance.sdk.openadsdk.core.jy.r vl;

    /* renamed from: w, reason: collision with root package name */
    protected AtomicInteger f28252w;
    protected n xt;
    int up = 0;

    /* renamed from: m, reason: collision with root package name */
    int f28249m = 0;
    int jy = 0;
    String ws = "";
    protected boolean az = false;
    protected boolean av = false;

    /* renamed from: i, reason: collision with root package name */
    protected final AtomicBoolean f28247i = new AtomicBoolean(true);

    /* renamed from: f, reason: collision with root package name */
    protected AtomicBoolean f28245f = new AtomicBoolean(false);

    /* renamed from: v, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.w.j f28251v = new com.bytedance.sdk.openadsdk.core.w.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.j.1
        @Override // com.bytedance.sdk.openadsdk.core.w.j
        public int j() {
            SSWebView sSWebView = j.this.ae;
            int measuredHeight = sSWebView != null ? sSWebView.getMeasuredHeight() : -1;
            vl.j("TTAndroidObject", "mWebView>>>>height=".concat(String.valueOf(measuredHeight)));
            return measuredHeight <= 0 ? ed.up((Context) j.this.f28248j) : measuredHeight;
        }

        @Override // com.bytedance.sdk.openadsdk.core.w.j
        public int xt() {
            SSWebView sSWebView = j.this.ae;
            int measuredWidth = sSWebView != null ? sSWebView.getMeasuredWidth() : -1;
            vl.j("TTAndroidObject", "mWebView>>>>width=".concat(String.valueOf(measuredWidth)));
            return measuredWidth <= 0 ? ed.r((Context) j.this.f28248j) : measuredWidth;
        }
    };

    /* renamed from: x, reason: collision with root package name */
    protected m f28253x = new m() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.j.2
        @Override // com.bytedance.sdk.openadsdk.core.w.m
        public void j() {
            SSWebView sSWebView = j.this.ae;
            if (sSWebView == null) {
                return;
            }
            sSWebView.onPause();
        }

        @Override // com.bytedance.sdk.openadsdk.core.w.m
        public void xt() {
            SSWebView sSWebView = j.this.ae;
            if (sSWebView == null) {
                return;
            }
            sSWebView.pauseTimers();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(int i6, int i7) {
        if (this.tl == null || this.f28248j.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", i6);
            jSONObject.put("height", i7);
            this.tl.j("resize", jSONObject);
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    public void cw(boolean z5) {
        if (this.tl == null || this.f28248j.isFinishing()) {
            return;
        }
        try {
            this.tl.m(z5);
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    public void g() {
        this.f28246g = null;
    }

    public abstract void j(DownloadListener downloadListener, com.bytedance.sdk.openadsdk.core.xt.xt xtVar);

    public abstract void j(boolean z5, Map<String, Object> map, View view);

    public void r(boolean z5) {
    }

    public abstract String x();

    private void a() {
        if (this.f28245f.getAndSet(true)) {
            return;
        }
        try {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ae, "translationY", ed.up((Context) this.f28248j), 0.0f);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.setDuration(1000L);
            ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.j.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    j.this.f28245f.set(false);
                }
            });
            ofFloat.start();
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    private void l() {
        if (this.f28245f.getAndSet(true)) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ae, "translationY", 0.0f, ed.up((Context) this.f28248j));
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setDuration(1000L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.j.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ed.j((View) j.this.ae, 8);
                j.this.f28245f.set(false);
            }
        });
        ofFloat.start();
    }

    public boolean ae() {
        SSWebView sSWebView = this.ae;
        if (sSWebView != null) {
            return sSWebView.canGoBack();
        }
        return false;
    }

    public void av() {
        SSWebView sSWebView = this.ae;
        if (sSWebView != null) {
            sSWebView.onResume();
            this.ae.resumeTimers();
            ed.j((View) this.ae, 1.0f);
            s();
        }
    }

    public void az() {
        rn rnVar = this.tl;
        if (rnVar != null) {
            rnVar.l();
        }
        tl tlVar = this.f28246g;
        if (tlVar != null) {
            tlVar.j(true);
            this.f28246g.av();
        }
        com.bytedance.sdk.openadsdk.core.jy.r rVar = this.vl;
        if (rVar != null) {
            rVar.m();
        }
        SSWebView sSWebView = this.ae;
        if (sSWebView != null) {
            c.j(this.f28248j, sSWebView);
            c.j(this.ae);
            this.ae.destroy();
        }
        this.ae = null;
    }

    public boolean f() {
        return j(this.oq);
    }

    public void i() {
        tl tlVar = this.f28246g;
        if (tlVar != null) {
            tlVar.g();
        }
    }

    protected void j() {
        SSWebView sSWebView = this.ae;
        if (sSWebView != null) {
            sSWebView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.j.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    SSWebView sSWebView2 = j.this.ae;
                    if (sSWebView2 == null || sSWebView2.getViewTreeObserver() == null) {
                        return;
                    }
                    j.this.ae.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    int measuredWidth = j.this.ae.getMeasuredWidth();
                    int measuredHeight = j.this.ae.getMeasuredHeight();
                    if (j.this.ae.getVisibility() == 0) {
                        j.this.xt(measuredWidth, measuredHeight);
                    }
                }
            });
        }
    }

    public void jy() {
        SSWebView sSWebView = this.ae;
        if (sSWebView != null) {
            sSWebView.onPause();
        }
        rn rnVar = this.tl;
        if (rnVar != null) {
            rnVar.a();
            this.tl.m(false);
            j(false);
            j(true, false);
        }
        com.bytedance.sdk.openadsdk.core.widget.j.r rVar = this.qv;
        if (rVar != null) {
            rVar.cw();
        }
    }

    public void kt() {
        tl tlVar = this.f28246g;
        if (tlVar != null) {
            tlVar.cw();
            this.f28246g.r();
        }
    }

    public void m() {
        if (this.f28248j.e() instanceof g) {
            l();
        } else {
            ed.j((View) this.ae, 8);
        }
    }

    public void mi() {
        tl tlVar = this.f28246g;
        if (tlVar != null) {
            tlVar.vl();
        }
    }

    public int oq() {
        return this.jy;
    }

    public String qv() {
        return this.ws;
    }

    public boolean r() {
        return this.az;
    }

    public void s() {
        rn rnVar = this.tl;
        if (rnVar == null) {
            return;
        }
        rnVar.j(new SSWebView.xt() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.j.6
            @Override // com.bytedance.sdk.component.widget.SSWebView.xt
            public void j(int i6) {
                rn rnVar2 = j.this.tl;
                if (rnVar2 != null) {
                    rnVar2.j(i6);
                }
            }
        });
    }

    public boolean tj() {
        rn rnVar = this.tl;
        if (rnVar == null) {
            return false;
        }
        return rnVar.kt();
    }

    public void tl() {
        SSWebView sSWebView = this.ae;
        if (sSWebView == null || !sSWebView.canGoBack()) {
            return;
        }
        this.ae.goBack();
    }

    public void up() {
        com.bytedance.sdk.openadsdk.core.jy.r rVar = this.vl;
        if (rVar != null) {
            rVar.j(System.currentTimeMillis());
        }
    }

    public void v() {
        SSWebView sSWebView = this.ae;
        if (sSWebView != null) {
            sSWebView.loadUrl("about:blank");
        }
    }

    public void vl() {
        SSWebView sSWebView = this.ae;
        if (sSWebView != null) {
            sSWebView.onResume();
        }
        rn rnVar = this.tl;
        if (rnVar != null) {
            rnVar.s();
            SSWebView sSWebView2 = this.ae;
            if (sSWebView2 != null) {
                if (sSWebView2.getVisibility() == 0) {
                    this.tl.m(true);
                    j(true);
                    j(false, true);
                } else {
                    this.tl.m(false);
                    j(false);
                    j(true, false);
                }
            }
        }
        com.bytedance.sdk.openadsdk.core.jy.r rVar = this.vl;
        if (rVar != null) {
            rVar.r();
        }
        com.bytedance.sdk.openadsdk.core.widget.j.r rVar2 = this.qv;
        if (rVar2 != null) {
            rVar2.xt(false);
        }
    }

    public void w() {
        tl tlVar = this.f28246g;
        if (tlVar != null) {
            tlVar.qv();
        }
    }

    public void ws() {
        com.bytedance.sdk.openadsdk.core.jy.r rVar = this.vl;
        if (rVar != null) {
            rVar.up();
        }
    }

    public j(TTBaseVideoActivity tTBaseVideoActivity, n nVar, String str, int i6, int i7, boolean z5) {
        this.f28248j = tTBaseVideoActivity;
        this.xt = nVar;
        this.cw = str;
        this.mi = nVar.zw();
        if (v.xt().gs()) {
            float f6 = this.f28248j.getResources().getDisplayMetrics().density;
            float f7 = Resources.getSystem().getDisplayMetrics().density;
            this.kt = ed.xt(f7, ed.j(f6, i6));
            this.tj = ed.xt(f7, ed.j(f6, i7));
        } else {
            this.kt = i6;
            this.tj = i7;
        }
        this.f28250r = z5;
    }

    public boolean cw() {
        if (!f()) {
            return false;
        }
        AtomicInteger atomicInteger = this.f28252w;
        if (atomicInteger == null || atomicInteger.get() == 0) {
            return this.f28247i.get();
        }
        return true;
    }

    public void j(boolean z5) {
        if (this.tl == null || this.f28248j.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewStatus", z5 ? 1 : 0);
            this.tl.j("viewableChange", jSONObject);
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    public void xt(boolean z5) {
        if (this.tl == null || this.f28248j.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z5);
            this.tl.j("volumeChange", jSONObject);
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    public void j(boolean z5, boolean z6) {
        if (this.tl == null || this.f28248j.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z5);
            jSONObject.put("endcard_show", z6);
            this.tl.j("endcard_control_event", jSONObject);
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    public boolean xt() {
        return this.av;
    }

    public void j(int i6, int i7) {
        if (this.tl == null || this.f28248j.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("downloadStatus", i6);
            jSONObject.put("downloadProcessRate", i7);
            this.tl.xt("showDownloadStatus", jSONObject);
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    public void ch() {
    }

    public void j(long j6, long j7, int i6) {
        if (j7 > 0) {
            j(i6, (int) ((j6 * 100) / j7));
        }
    }

    protected void j(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.j.xt.j(this.f28248j).j(false).xt(false).j(sSWebView);
        kt.j(sSWebView, h.xt, n.r(this.xt));
        ed.j((com.bytedance.sdk.component.jy.cw) sSWebView);
        int i6 = Build.VERSION.SDK_INT;
        sSWebView.setMixedContentMode(0);
        if (i6 < 24) {
            this.ae.setLayerType(0, null);
        }
    }

    public void j(int i6) {
        ed.j((View) this.ae, 0);
        if (i6 == 1) {
            ed.j((View) this.ae, 0.0f);
        }
        if (i6 == 2) {
            a();
        }
        rn rnVar = this.tl;
        if (rnVar != null) {
            rnVar.j(uf.av(this.xt), false);
        }
    }

    public void j(Map<String, Object> map) {
        tl tlVar = this.f28246g;
        if (tlVar != null) {
            tlVar.oq();
        }
    }

    public void j(boolean z5, int i6, String str) {
        tl tlVar = this.f28246g;
        if (tlVar == null) {
            return;
        }
        if (z5) {
            tlVar.xt();
        } else {
            tlVar.j(i6, str);
        }
    }

    private boolean j(String str) {
        try {
            new URL(str);
            if (URLUtil.isValidUrl(str)) {
                if (Patterns.WEB_URL.matcher(str).matches()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public void j(JSONObject jSONObject) {
        rn rnVar = this.tl;
        if (rnVar == null) {
            vl.r("BaseEndCard", "mJsObject is null!");
        } else {
            rnVar.j("showPlayAgainEntrance", jSONObject);
        }
    }

    public void j(n nVar) {
        this.xt = nVar;
        this.az = false;
    }
}
