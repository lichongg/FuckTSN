package com.bytedance.sdk.component.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.widget.web.BizWebView;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class SSWebView extends BizWebView {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f26960a;
    private JSONObject ae;
    private float av;
    private float az;
    private AtomicInteger ch;

    /* renamed from: f, reason: collision with root package name */
    private AtomicBoolean f26961f;

    /* renamed from: g, reason: collision with root package name */
    private float f26962g;

    /* renamed from: i, reason: collision with root package name */
    private float f26963i;
    private long jy;
    private xt kt;

    /* renamed from: l, reason: collision with root package name */
    private JSONObject f26964l;

    /* renamed from: m, reason: collision with root package name */
    private String f26965m;
    private int mi;
    private float oq;

    /* renamed from: p, reason: collision with root package name */
    private cw f26966p;
    private long qv;

    /* renamed from: s, reason: collision with root package name */
    private JSONObject f26967s;
    private f tj;
    private boolean tl;
    private com.bytedance.sdk.component.widget.xt.j up;

    /* renamed from: v, reason: collision with root package name */
    private AtomicBoolean f26968v;
    private long vl;

    /* renamed from: w, reason: collision with root package name */
    private int f26969w;
    private boolean ws;

    /* renamed from: x, reason: collision with root package name */
    private AtomicBoolean f26970x;

    public interface cw {
        void j(boolean z5);
    }

    public static class j extends WebViewClient {
        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (Build.VERSION.SDK_INT < 26) {
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            if (webView == null) {
                return true;
            }
            ViewGroup viewGroup = (ViewGroup) webView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(webView);
            }
            webView.destroy();
            return true;
        }
    }

    public interface xt {
        void j(int i6);
    }

    private void m() {
        this.tj = null;
        this.kt = null;
        setTouchStateListener(null);
        I_();
        this.up = null;
        this.ae = null;
        this.tl = false;
    }

    private static boolean xt(View view) {
        try {
            Class<?> loadClass = view.getClass().getClassLoader().loadClass("androidx.viewpager.widget.ViewPager");
            if (loadClass != null) {
                if (loadClass.isInstance(view)) {
                    return true;
                }
            }
        } catch (Throwable th) {
            vl.j(th);
        }
        try {
            Class<?> loadClass2 = view.getClass().getClassLoader().loadClass("androidx.viewpager.widget.ViewPager");
            if (loadClass2 != null) {
                return loadClass2.isInstance(view);
            }
            return false;
        } catch (Throwable th2) {
            vl.j(th2);
            return false;
        }
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected ViewParent j(View view) {
        ViewParent parent = view.getParent();
        if ((parent instanceof AbsListView) || (parent instanceof ScrollView) || (parent instanceof HorizontalScrollView) || !(parent instanceof View)) {
            return parent;
        }
        View view2 = (View) parent;
        return (xt(view2) || cw(view2)) ? parent : j(view2);
    }

    private boolean cw(View view) {
        try {
            Class<?> loadClass = view.getClass().getClassLoader().loadClass("androidx.core.view.ScrollingView");
            if (loadClass != null) {
                if (loadClass.isInstance(view)) {
                    return true;
                }
            }
        } catch (Throwable th) {
            vl.j(th);
        }
        try {
            Class<?> loadClass2 = view.getClass().getClassLoader().loadClass("androidx.core.view.ScrollingView");
            if (loadClass2 != null) {
                return loadClass2.isInstance(view);
            }
            return false;
        } catch (Throwable th2) {
            vl.j(th2);
            return false;
        }
    }

    public boolean H_() {
        f fVar = this.tj;
        if (fVar == null) {
            return false;
        }
        return fVar.j();
    }

    public void I_() {
        this.f26968v.set(false);
        f fVar = this.tj;
        if (fVar != null) {
            com.bytedance.sdk.component.widget.xt.j jVar = this.up;
            fVar.r(jVar != null ? jVar.j() : 0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        cw cwVar = this.f26966p;
        if (cwVar != null) {
            cwVar.j(true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public com.bytedance.sdk.component.widget.xt.j getMaterialMeta() {
        return this.up;
    }

    @Override // android.view.View
    public String getTag() {
        return this.f26965m;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z5) {
        f fVar = this.tj;
        if (fVar != null) {
            if (z5) {
                com.bytedance.sdk.component.widget.xt.j jVar = this.up;
                fVar.j(jVar != null ? jVar.j() : 0);
            } else {
                com.bytedance.sdk.component.widget.xt.j jVar2 = this.up;
                fVar.xt(jVar2 != null ? jVar2.j() : 0);
            }
        }
    }

    public void setCalculationMethod(int i6) {
        this.f26969w = i6;
    }

    public void setCalculationTwistMethod(int i6) {
        this.mi = i6;
    }

    public void setDeepShakeValue(float f6) {
        this.av = f6;
    }

    public void setIsPreventTouchEvent(boolean z5) {
        this.ws = z5;
    }

    public void setLandingPage(boolean z5) {
        this.tl = z5;
    }

    public void setMaterialMeta(com.bytedance.sdk.component.widget.xt.j jVar) {
        this.up = jVar;
    }

    public void setOnShakeListener(xt xtVar) {
        this.kt = xtVar;
    }

    public void setShakeInteractConf(JSONObject jSONObject) {
        this.f26960a = jSONObject;
    }

    public void setShakeValue(float f6) {
        this.az = f6;
    }

    public void setTag(String str) {
        this.f26965m = str;
    }

    public void setTouchStateListener(cw cwVar) {
        this.f26966p = cwVar;
    }

    public void setTwistConfig(JSONObject jSONObject) {
        this.f26967s = jSONObject;
    }

    public void setTwistInteractConf(JSONObject jSONObject) {
        this.f26964l = jSONObject;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.jy.cw
    public void setWebViewClient(WebViewClient webViewClient) {
        if (webViewClient instanceof cw) {
            setTouchStateListener((cw) webViewClient);
        } else {
            setTouchStateListener(null);
        }
        if (webViewClient == 0) {
            webViewClient = new j();
        }
        super.setWebViewClient(webViewClient);
    }

    public void setWriggleValue(float f6) {
        this.f26963i = f6;
    }

    public SSWebView(Context context) {
        super(context);
        this.f26962g = 0.0f;
        this.oq = 0.0f;
        this.qv = 0L;
        this.vl = 0L;
        this.jy = 0L;
        this.ws = false;
        this.az = 20.0f;
        this.f26963i = 50.0f;
        this.f26961f = new AtomicBoolean();
        this.f26968v = new AtomicBoolean();
        this.f26970x = new AtomicBoolean(true);
        this.ch = new AtomicInteger();
    }

    @Override // com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.widget.web.MultiWebview
    public void G_() {
        m();
        super.G_();
    }

    @Override // com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.widget.web.MultiWebview, com.bytedance.sdk.component.jy.cw
    public void destroy() {
        super.destroy();
        m();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f26961f.set(true);
        if (this.f26968v.get()) {
            xt(this.ch.get(), this.f26970x.get());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i6 = 0;
        this.f26961f.set(false);
        f fVar = this.tj;
        if (fVar != null) {
            com.bytedance.sdk.component.widget.xt.j jVar = this.up;
            if (jVar != null) {
                i6 = jVar.j();
            }
            fVar.xt(i6);
        }
    }

    @Override // android.view.ViewGroup
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewParent j6;
        try {
            j(motionEvent);
            boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            if ((motionEvent.getActionMasked() == 2 || motionEvent.getActionMasked() == 0) && this.ws && (j6 = j((View) this)) != null) {
                j6.requestDisallowInterceptTouchEvent(true);
            }
            return onInterceptTouchEvent;
        } catch (Throwable unused) {
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.jy.cw
    public void onPause() {
        super.onPause();
        cw cwVar = this.f26966p;
        if (cwVar != null) {
            cwVar.j(false);
        }
    }

    public void j(int i6, boolean z5) {
        this.f26970x.set(z5);
        this.ch.set(i6);
        this.f26968v.set(true);
        if (this.f26961f.get()) {
            xt(i6, z5);
        }
    }

    private void xt(int i6, boolean z5) {
        f fVar = this.tj;
        if (fVar == null) {
            this.tj = new f(getContext(), i6, z5);
        } else {
            fVar.j(z5);
        }
        this.tj.j(this.az);
        this.tj.cw(this.av);
        this.tj.xt(this.f26963i);
        this.tj.j(this.f26967s);
        this.tj.cw(this.f26960a);
        this.tj.xt(this.f26964l);
        this.tj.up(this.f26969w);
        this.tj.m(this.mi);
        this.tj.j(new f.j() { // from class: com.bytedance.sdk.component.widget.SSWebView.1
            @Override // com.bytedance.sdk.component.utils.f.j
            public void j(int i7) {
                if (i7 == 1) {
                    SSWebView.this.j(1);
                } else {
                    if (i7 != 2) {
                        return;
                    }
                    SSWebView.this.j(2);
                }
            }
        });
        f fVar2 = this.tj;
        com.bytedance.sdk.component.widget.xt.j jVar = this.up;
        fVar2.cw(jVar != null ? jVar.j() : 0);
    }

    public void j(int i6) {
        xt xtVar = this.kt;
        if (xtVar != null) {
            xtVar.j(i6);
        }
    }

    private void j(MotionEvent motionEvent) {
        if (!this.tl || this.up == null) {
            return;
        }
        if ((this.f26965m == null && this.ae == null) || motionEvent == null) {
            return;
        }
        try {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f26962g = motionEvent.getRawX();
                this.oq = motionEvent.getRawY();
                this.qv = System.currentTimeMillis();
                this.ae = new JSONObject();
                if (this.xt != null) {
                    this.xt.setTag(2064056319, Long.valueOf(this.qv));
                    return;
                }
                return;
            }
            if (action == 1 || action == 3) {
                this.ae.put("start_x", String.valueOf(this.f26962g));
                this.ae.put("start_y", String.valueOf(this.oq));
                this.ae.put("offset_x", String.valueOf(motionEvent.getRawX() - this.f26962g));
                this.ae.put("offset_y", String.valueOf(motionEvent.getRawY() - this.oq));
                this.ae.put("url", String.valueOf(getUrl()));
                this.ae.put(CommonNetImpl.TAG, "");
                this.vl = System.currentTimeMillis();
                if (this.xt != null) {
                    this.xt.setTag(2064056318, Long.valueOf(this.vl));
                }
                this.ae.put("down_time", this.qv);
                this.ae.put("up_time", this.vl);
                if (com.bytedance.sdk.component.widget.j.j.j().xt() != null) {
                    long j6 = this.jy;
                    long j7 = this.qv;
                    if (j6 != j7) {
                        this.jy = j7;
                        com.bytedance.sdk.component.widget.j.j.j();
                    }
                }
            }
        } catch (Throwable th) {
            vl.j(th);
        }
    }
}
