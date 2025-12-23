package com.bytedance.sdk.openadsdk.core.g.j.xt;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.rn;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.kt;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

@com.bytedance.sdk.component.qv.xt.xt
/* loaded from: D:\Downloads\app\classes4.dex */
public class g implements com.bytedance.sdk.component.qv.j.j.cw {

    /* renamed from: a, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "end_card_width")
    private int f29027a;
    protected com.bytedance.sdk.openadsdk.core.widget.j.r ae;

    @com.bytedance.sdk.component.qv.xt.j(j = "end_card_param")
    private com.bytedance.sdk.openadsdk.core.g.j.cw.j ch;
    private boolean ed;

    /* renamed from: f, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "close_button")
    private View f29029f;
    private double gq;

    /* renamed from: i, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "web_view")
    private WeakReference<SSWebView> f29032i;

    /* renamed from: j, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = TTDownloadField.TT_ACTIVITY)
    protected TTBaseVideoActivity f29033j;

    @com.bytedance.sdk.component.qv.xt.j(j = "is_reward")
    private boolean kt;

    /* renamed from: l, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "end_card_height")
    private int f29034l;
    private double la;

    /* renamed from: m, reason: collision with root package name */
    protected String f29035m;

    @com.bytedance.sdk.component.qv.xt.j(j = "event_tag")
    private String mi;

    /* renamed from: p, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "action_type")
    private int f29037p;

    /* renamed from: r, reason: collision with root package name */
    protected rn f29038r;
    private double rn;

    /* renamed from: s, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "orientation")
    private int f29039s;

    @com.bytedance.sdk.component.qv.xt.j(j = "extra_map")
    private Map<String, Object> tj;
    com.bytedance.sdk.openadsdk.core.jy.r tl;
    private String uf;
    protected com.bytedance.sdk.openadsdk.core.jy.tl up;

    /* renamed from: v, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "download_listener")
    private DownloadListener f29040v;

    /* renamed from: w, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "material_meta")
    private n f29041w;
    private double wq;

    /* renamed from: x, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "show_type")
    private int f29042x;

    /* renamed from: h, reason: collision with root package name */
    private final Map<String, Bitmap> f29031h = new HashMap();
    int xt = 0;
    int cw = 0;

    /* renamed from: g, reason: collision with root package name */
    int f29030g = 0;
    String oq = "";
    protected boolean qv = false;
    protected boolean vl = false;
    protected final AtomicBoolean jy = new AtomicBoolean(true);

    /* renamed from: c, reason: collision with root package name */
    private Handler f29028c = new Handler(Looper.myLooper()) { // from class: com.bytedance.sdk.openadsdk.core.g.j.xt.g.1
        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    g.this.jy();
                    break;
                case 2:
                    g.this.up();
                    break;
                case 3:
                    g.this.ae();
                    break;
                case 4:
                    g.this.tl();
                    break;
                case 5:
                    g.this.g();
                    break;
                case 6:
                    g.this.oq();
                    break;
                case 7:
                    g.this.qv();
                    break;
                case 8:
                    g.this.vl();
                    break;
                case 9:
                    g.this.ws();
                    break;
                case 10:
                    g.this.az();
                    break;
                case 11:
                    g.this.av();
                    break;
                case 12:
                    g.this.i();
                    break;
                case 13:
                    g.this.w();
                    break;
                case 14:
                    g.this.mi();
                    break;
            }
        }
    };
    protected AtomicBoolean ws = new AtomicBoolean(false);
    protected com.bytedance.sdk.openadsdk.core.w.j az = new com.bytedance.sdk.openadsdk.core.w.j() { // from class: com.bytedance.sdk.openadsdk.core.g.j.xt.g.6
        @Override // com.bytedance.sdk.openadsdk.core.w.j
        public int j() {
            SSWebView sSWebView = g.this.f29032i != null ? (SSWebView) g.this.f29032i.get() : null;
            int measuredHeight = sSWebView != null ? sSWebView.getMeasuredHeight() : -1;
            return measuredHeight <= 0 ? ed.up((Context) g.this.f29033j) : measuredHeight;
        }

        @Override // com.bytedance.sdk.openadsdk.core.w.j
        public int xt() {
            SSWebView sSWebView = g.this.f29032i != null ? (SSWebView) g.this.f29032i.get() : null;
            int measuredWidth = sSWebView != null ? sSWebView.getMeasuredWidth() : -1;
            return measuredWidth <= 0 ? ed.r((Context) g.this.f29033j) : measuredWidth;
        }
    };
    protected com.bytedance.sdk.openadsdk.core.w.m av = new com.bytedance.sdk.openadsdk.core.w.m() { // from class: com.bytedance.sdk.openadsdk.core.g.j.xt.g.7
        @Override // com.bytedance.sdk.openadsdk.core.w.m
        public void j() {
            SSWebView sSWebView = g.this.f29032i != null ? (SSWebView) g.this.f29032i.get() : null;
            if (sSWebView == null) {
                return;
            }
            sSWebView.onPause();
        }

        @Override // com.bytedance.sdk.openadsdk.core.w.m
        public void xt() {
            SSWebView sSWebView = g.this.f29032i != null ? (SSWebView) g.this.f29032i.get() : null;
            if (sSWebView == null) {
                return;
            }
            sSWebView.pauseTimers();
        }
    };
    private final com.bytedance.sdk.openadsdk.core.w.xt gx = new com.bytedance.sdk.openadsdk.core.w.xt() { // from class: com.bytedance.sdk.openadsdk.core.g.j.xt.g.8
        @Override // com.bytedance.sdk.openadsdk.core.w.xt
        public void j(boolean z5, int i6, String str) {
            if (z5) {
                g gVar = g.this;
                gVar.vl = true;
                if (gVar.ed) {
                    g gVar2 = g.this;
                    gVar2.j(gVar2.la, g.this.gq, g.this.rn, g.this.wq, g.this.uf);
                    g.this.ed = false;
                }
            }
            if (ln.oq(g.this.f29041w)) {
                g.this.j(z5, i6, str);
            }
        }
    };

    /* renamed from: n, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.qv.j f29036n = new com.bytedance.sdk.openadsdk.qv.j() { // from class: com.bytedance.sdk.openadsdk.core.g.j.xt.g.9
        @Override // com.bytedance.sdk.openadsdk.qv.j
        public void j() {
            g.this.f29033j.tl(1);
        }
    };

    public void g() {
        this.up = null;
    }

    private void f() {
        WeakReference<SSWebView> weakReference;
        if (this.ws.getAndSet(true) || (weakReference = this.f29032i) == null) {
            return;
        }
        try {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(weakReference.get(), "translationY", ed.up((Context) this.f29033j), 0.0f);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.setDuration(1000L);
            ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.g.j.xt.g.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    g.this.ws.set(false);
                }
            });
            ofFloat.start();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
    }

    private void kt() {
        com.bytedance.sdk.openadsdk.core.g.j.cw.j jVar = this.ch;
        if (jVar == null) {
            return;
        }
        jVar.j(new com.bytedance.sdk.openadsdk.core.g.j.cw.j() { // from class: com.bytedance.sdk.openadsdk.core.g.j.xt.g.10
        });
    }

    private void tj() {
        this.f29035m = ln.tl(this.f29041w);
        float uo = this.f29041w.uo();
        if (TextUtils.isEmpty(this.f29035m)) {
            return;
        }
        if (this.f29039s == 1) {
            if (this.f29035m.contains("?")) {
                this.f29035m += "&orientation=portrait";
            } else {
                this.f29035m += "?orientation=portrait";
            }
        }
        if (this.f29035m.contains("?")) {
            this.f29035m += "&height=" + this.f29034l + "&width=" + this.f29027a + "&aspect_ratio=" + uo;
        } else {
            this.f29035m += "?height=" + this.f29034l + "&width=" + this.f29027a + "&aspect_ratio=" + uo;
        }
        this.f29035m = com.bytedance.sdk.openadsdk.core.component.reward.up.j.j(this.f29035m);
    }

    private void v() {
        WeakReference<SSWebView> weakReference;
        final SSWebView sSWebView;
        if (this.ws.getAndSet(true) || (weakReference = this.f29032i) == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(sSWebView, "translationY", 0.0f, ed.up((Context) this.f29033j));
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setDuration(1000L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.g.j.xt.g.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ed.j((View) sSWebView, 8);
                g.this.ws.set(false);
            }
        });
        ofFloat.start();
    }

    private void x() {
        rn rnVar = this.f29038r;
        if (rnVar == null) {
            return;
        }
        rnVar.j(new SSWebView.xt() { // from class: com.bytedance.sdk.openadsdk.core.g.j.xt.g.5
            @Override // com.bytedance.sdk.component.widget.SSWebView.xt
            public void j(int i6) {
                rn rnVar2 = g.this.f29038r;
                if (rnVar2 != null) {
                    rnVar2.j(i6);
                }
            }
        });
    }

    public void ae() {
        com.bytedance.sdk.openadsdk.core.jy.r rVar = this.tl;
        if (rVar != null) {
            rVar.j(System.currentTimeMillis());
        }
    }

    public void av() {
        com.bytedance.sdk.openadsdk.core.jy.tl tlVar = this.up;
        if (tlVar != null) {
            tlVar.qv();
        }
    }

    public void az() {
        com.bytedance.sdk.openadsdk.core.jy.tl tlVar = this.up;
        if (tlVar != null) {
            tlVar.g();
        }
    }

    public void cw() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.f29032i;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.j.r rVar = new com.bytedance.sdk.openadsdk.core.widget.j.r(this.f29033j, this.f29038r, this.f29041w.fs(), this.tl) { // from class: com.bytedance.sdk.openadsdk.core.g.j.xt.g.13
            @Override // com.bytedance.sdk.openadsdk.core.widget.j.r, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i6, String str, String str2) {
                g.this.jy.set(false);
                g gVar = g.this;
                gVar.f29030g = i6;
                gVar.oq = str;
                if (gVar.up != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (Build.VERSION.SDK_INT >= 23) {
                            jSONObject.put("code", i6);
                            jSONObject.put("msg", str);
                        }
                        g.this.up.xt(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                super.onReceivedError(webView, i6, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.j.r, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                WebResourceResponse j6 = g.this.j(str);
                return j6 != null ? j6 : super.shouldInterceptRequest(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.j.r, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                com.bytedance.sdk.openadsdk.core.jy.tl tlVar = g.this.up;
                if (tlVar != null) {
                    tlVar.ae();
                }
                super.onPageFinished(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.j.r, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                com.bytedance.sdk.openadsdk.core.jy.tl tlVar = g.this.up;
                if (tlVar != null) {
                    tlVar.m();
                }
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.j.r, android.webkit.WebViewClient
            @TargetApi(21)
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (g.this.up != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", webResourceResponse.getStatusCode());
                        jSONObject.put("msg", webResourceResponse.getReasonPhrase());
                        g.this.up.xt(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                if (g.this.f29035m.equals(String.valueOf(webResourceRequest.getUrl()))) {
                    if (webResourceRequest.isForMainFrame()) {
                        g.this.jy.set(false);
                    }
                    if (webResourceResponse != null) {
                        g.this.f29030g = webResourceResponse.getStatusCode();
                        g.this.oq = "onReceivedHttpError";
                    }
                }
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.j.r, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                try {
                    String uri = webResourceRequest.getUrl().toString();
                    if (g.this.f29041w != null) {
                        WebResourceResponse j6 = g.this.j(uri);
                        if (j6 != null) {
                            return j6;
                        }
                        if (TextUtils.isEmpty(g.this.f29041w.el())) {
                            return super.shouldInterceptRequest(webView, uri);
                        }
                        g.this.xt++;
                        return super.shouldInterceptRequest(webView, uri);
                    }
                    return super.shouldInterceptRequest(webView, uri);
                } catch (Throwable unused) {
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.j.r, android.webkit.WebViewClient
            @TargetApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                int errorCode;
                CharSequence description;
                int errorCode2;
                CharSequence description2;
                if (webResourceRequest.isForMainFrame()) {
                    g.this.jy.set(false);
                }
                if (g.this.up != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (Build.VERSION.SDK_INT >= 23) {
                            errorCode = webResourceError.getErrorCode();
                            jSONObject.put("code", errorCode);
                            description = webResourceError.getDescription();
                            jSONObject.put("msg", description);
                        }
                        g.this.up.xt(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                g gVar = g.this;
                errorCode2 = webResourceError.getErrorCode();
                gVar.f29030g = errorCode2;
                g gVar2 = g.this;
                description2 = webResourceError.getDescription();
                gVar2.oq = String.valueOf(description2);
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }
        };
        this.ae = rVar;
        sSWebView.setWebViewClient(rVar);
        j(sSWebView);
        sSWebView.setBackgroundColor(-1);
        sSWebView.setDisplayZoomControls(false);
        sSWebView.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.j.cw(this.f29038r, this.tl) { // from class: com.bytedance.sdk.openadsdk.core.g.j.xt.g.2
            @Override // com.bytedance.sdk.openadsdk.core.widget.j.cw, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i6) {
                super.onProgressChanged(webView, i6);
            }
        });
        sSWebView.setDownloadListener(this.f29040v);
    }

    public void i() {
        com.bytedance.sdk.openadsdk.core.jy.tl tlVar = this.up;
        if (tlVar != null) {
            tlVar.vl();
        }
    }

    public void jy() {
        WeakReference<SSWebView> weakReference = this.f29032i;
        SSWebView sSWebView = weakReference != null ? weakReference.get() : null;
        if (sSWebView != null) {
            c.j(this.f29033j, sSWebView);
            c.j(sSWebView);
            sSWebView.destroy();
        }
        WeakReference<SSWebView> weakReference2 = this.f29032i;
        if (weakReference2 != null) {
            weakReference2.clear();
        }
        rn rnVar = this.f29038r;
        if (rnVar != null) {
            rnVar.l();
        }
        com.bytedance.sdk.openadsdk.core.jy.tl tlVar = this.up;
        if (tlVar != null) {
            tlVar.j(true);
            this.up.av();
        }
        com.bytedance.sdk.openadsdk.core.jy.r rVar = this.tl;
        if (rVar != null) {
            rVar.m();
        }
        this.f29031h.clear();
    }

    public void m() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.f29032i;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        ed.j((View) sSWebView, 0);
        if (this.f29042x == 1) {
            ed.j((View) sSWebView, 0.0f);
        }
        if (this.f29042x == 2) {
            f();
        }
        rn rnVar = this.f29038r;
        if (rnVar != null) {
            rnVar.j(uf.av(this.f29041w), false);
        }
        j(true);
        xt(true);
        j(false, true);
    }

    public void mi() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.f29032i;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        sSWebView.loadUrl("about:blank");
    }

    public void oq() {
        WeakReference<SSWebView> weakReference = this.f29032i;
        SSWebView sSWebView = weakReference != null ? weakReference.get() : null;
        if (sSWebView != null) {
            sSWebView.onResume();
        }
        rn rnVar = this.f29038r;
        if (rnVar != null) {
            rnVar.s();
            if (sSWebView != null) {
                if (sSWebView.getVisibility() == 0) {
                    this.f29038r.m(true);
                    j(true);
                    j(false, true);
                } else {
                    this.f29038r.m(false);
                    j(false);
                    j(true, false);
                }
            }
        }
        com.bytedance.sdk.openadsdk.core.jy.r rVar = this.tl;
        if (rVar != null) {
            rVar.r();
        }
        com.bytedance.sdk.openadsdk.core.widget.j.r rVar2 = this.ae;
        if (rVar2 != null) {
            rVar2.xt(false);
        }
    }

    public void qv() {
        WeakReference<SSWebView> weakReference = this.f29032i;
        SSWebView sSWebView = weakReference != null ? weakReference.get() : null;
        if (sSWebView != null) {
            sSWebView.onPause();
        }
        rn rnVar = this.f29038r;
        if (rnVar != null) {
            rnVar.a();
            this.f29038r.m(false);
            j(false);
            j(true, false);
        }
        com.bytedance.sdk.openadsdk.core.widget.j.r rVar = this.ae;
        if (rVar != null) {
            rVar.cw();
        }
    }

    protected boolean r() {
        String str = this.f29035m;
        if (str == null) {
            return false;
        }
        try {
            return Uri.parse(str).getQueryParameterNames().contains("show_landingpage");
        } catch (Exception unused) {
            return false;
        }
    }

    public void tl() {
        if (this.f29033j.e() instanceof com.bytedance.sdk.openadsdk.core.component.reward.r.g) {
            v();
            return;
        }
        WeakReference<SSWebView> weakReference = this.f29032i;
        if (weakReference == null) {
            return;
        }
        ed.j((View) weakReference.get(), 8);
    }

    public void up() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.f29032i;
        if (weakReference == null || (sSWebView = weakReference.get()) == null || this.qv) {
            return;
        }
        sSWebView.loadUrl(this.f29035m);
        this.qv = true;
    }

    public void vl() {
        com.bytedance.sdk.openadsdk.core.jy.r rVar = this.tl;
        if (rVar != null) {
            rVar.up();
        }
    }

    public void w() {
        com.bytedance.sdk.openadsdk.core.jy.tl tlVar = this.up;
        if (tlVar != null) {
            tlVar.cw();
            this.up.r();
        }
    }

    public void ws() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.f29032i;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        sSWebView.onResume();
        sSWebView.resumeTimers();
        ed.j((View) sSWebView, 1.0f);
        x();
    }

    public void xt() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.f29032i;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        com.bytedance.sdk.openadsdk.core.jy.tl tlVar = new com.bytedance.sdk.openadsdk.core.jy.tl(this.mi, this.f29041w, jSONObject);
        this.up = tlVar;
        tlVar.j(jSONObject, "webview_source", (Object) 2);
        com.bytedance.sdk.openadsdk.core.jy.r xt = new com.bytedance.sdk.openadsdk.core.jy.r(this.f29041w, sSWebView).xt(true);
        this.tl = xt;
        xt.j(true);
        tj();
        this.tl.j(r() ? "landingpage_endcard" : this.kt ? "reward_endcard" : "fullscreen_endcard");
        rn rnVar = new rn(this.f29033j) { // from class: com.bytedance.sdk.openadsdk.core.g.j.xt.g.12
        };
        this.f29038r = rnVar;
        rnVar.xt(sSWebView).j(this.f29041w).xt(this.f29041w.fs()).cw(this.f29041w.os()).cw(this.kt ? 7 : 5).j(this.az).r(uf.av(this.f29041w)).j(sSWebView).xt(com.bytedance.sdk.openadsdk.core.qv.cw.oq.j(this.f29041w)).j(this.up).j(this.mi).j(this.tj).j(this.av).j(this.f29029f).j(this.f29036n);
        this.f29038r.j(this.gx);
    }

    @Override // com.bytedance.sdk.component.qv.j.j.cw
    public boolean j(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.qv.j.j jVar) {
        if (this.f29037p != 0) {
            m();
            return true;
        }
        j();
        xt();
        cw();
        kt();
        return true;
    }

    public void j(boolean z5, int i6, String str) {
        com.bytedance.sdk.openadsdk.core.jy.tl tlVar = this.up;
        if (tlVar == null) {
            return;
        }
        if (z5) {
            tlVar.xt();
        } else {
            tlVar.j(i6, str);
        }
    }

    protected void j() {
        final SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.f29032i;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        sSWebView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.g.j.xt.g.11
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                SSWebView sSWebView2 = sSWebView;
                if (sSWebView2 == null || sSWebView2.getViewTreeObserver() == null) {
                    return;
                }
                sSWebView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int measuredWidth = sSWebView.getMeasuredWidth();
                int measuredHeight = sSWebView.getMeasuredHeight();
                if (sSWebView.getVisibility() == 0) {
                    g.this.j(measuredWidth, measuredHeight);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i6, int i7) {
        if (this.f29038r == null || this.f29033j.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", i6);
            jSONObject.put("height", i7);
            this.f29038r.j("resize", jSONObject);
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    protected void j(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.j.xt.j(this.f29033j).j(false).xt(false).j(sSWebView);
        kt.j(sSWebView, h.xt, n.r(this.f29041w));
        ed.j((com.bytedance.sdk.component.jy.cw) sSWebView);
        int i6 = Build.VERSION.SDK_INT;
        sSWebView.setMixedContentMode(0);
        if (i6 < 24) {
            sSWebView.setLayerType(0, null);
        }
    }

    public void xt(boolean z5) {
        if (this.f29038r == null || this.f29033j.isFinishing()) {
            return;
        }
        try {
            this.f29038r.m(z5);
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    public void j(boolean z5) {
        if (this.f29038r == null || this.f29033j.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewStatus", z5 ? 1 : 0);
            this.f29038r.j("viewableChange", jSONObject);
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    public void j(boolean z5, boolean z6) {
        if (this.f29038r == null || this.f29033j.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z5);
            jSONObject.put("endcard_show", z6);
            this.f29038r.j("endcard_control_event", jSONObject);
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    public void j(double d6, double d7, double d8, double d9, String str) {
        if (this.f29038r == null || this.f29033j.isFinishing()) {
            return;
        }
        if (!this.vl) {
            this.la = d6;
            this.gq = d7;
            this.wq = d9;
            this.rn = d8;
            this.uf = str;
            this.ed = true;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("x", d6);
            jSONObject.put("y", d7);
            jSONObject.put("width", d8);
            jSONObject.put("height", d9);
            jSONObject.put("videoFrameKey", str);
            this.f29038r.j("endcardTransform", jSONObject);
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebResourceResponse j(String str) {
        if (!str.startsWith("csjclientimg://")) {
            return null;
        }
        Bitmap bitmap = this.f29031h.get(str.replace("csjclientimg://", ""));
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return new WebResourceResponse("text/html", "UTF-8", new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
    }
}
