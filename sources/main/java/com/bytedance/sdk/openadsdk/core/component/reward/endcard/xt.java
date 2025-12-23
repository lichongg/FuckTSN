package com.bytedance.sdk.openadsdk.core.component.reward.endcard;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bykv.vk.openvk.component.video.j.up.xt;
import com.bytedance.sdk.component.adexpress.xt.ws;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.r.up;
import com.bytedance.sdk.openadsdk.core.jy.tl;
import com.bytedance.sdk.openadsdk.core.qv.cw.oq;
import com.bytedance.sdk.openadsdk.core.rn;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.e;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt extends j {

    /* renamed from: a, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.w.xt f28271a;
    private final Map<String, Bitmap> ch;
    private String gq;

    /* renamed from: h, reason: collision with root package name */
    private double f28272h;

    /* renamed from: l, reason: collision with root package name */
    private double f28273l;
    private double la;

    /* renamed from: p, reason: collision with root package name */
    private double f28274p;
    private boolean rn;

    /* renamed from: s, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.qv.j f28275s;

    private void p() {
        this.oq = ln.tl(this.xt);
        float uo = this.xt.uo();
        if (TextUtils.isEmpty(this.oq)) {
            return;
        }
        if (this.mi == 1) {
            if (this.oq.contains("?")) {
                this.oq += "&orientation=portrait";
            } else {
                this.oq += "?orientation=portrait";
            }
        }
        if (this.oq.contains("?")) {
            this.oq += "&height=" + this.tj + "&width=" + this.kt + "&aspect_ratio=" + uo;
        } else {
            this.oq += "?height=" + this.tj + "&width=" + this.kt + "&aspect_ratio=" + uo;
        }
        this.oq = com.bytedance.sdk.openadsdk.core.component.reward.up.j.j(this.oq);
    }

    protected boolean a() {
        String str = this.oq;
        if (str == null) {
            return false;
        }
        try {
            return Uri.parse(str).getQueryParameterNames().contains("show_landingpage");
        } catch (Exception unused) {
            return false;
        }
    }

    public void l() {
        SSWebView sSWebView;
        if (this.az || (sSWebView = this.ae) == null || sSWebView.getWebView() == null) {
            return;
        }
        this.ae.loadUrl(this.oq);
        this.az = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.j
    public String x() {
        return "endcard";
    }

    public xt(TTBaseVideoActivity tTBaseVideoActivity, n nVar, String str, int i6, int i7, boolean z5, AbstractEndCardFrameLayout abstractEndCardFrameLayout) {
        super(tTBaseVideoActivity, nVar, str, i6, i7, z5);
        this.ch = new HashMap();
        this.f28275s = new com.bytedance.sdk.openadsdk.qv.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.xt.1
            @Override // com.bytedance.sdk.openadsdk.qv.j
            public void j() {
                xt.this.f28248j.tl(1);
            }
        };
        this.f28271a = new com.bytedance.sdk.openadsdk.core.w.xt() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.xt.2
            @Override // com.bytedance.sdk.openadsdk.core.w.xt
            public void j(boolean z6, int i8, String str2) {
                if (z6) {
                    xt xtVar = xt.this;
                    xtVar.av = true;
                    if (xtVar.rn) {
                        xt xtVar2 = xt.this;
                        xtVar2.j(xtVar2.f28273l, xt.this.f28274p, xt.this.f28272h, xt.this.la, xt.this.gq);
                        xt.this.rn = false;
                    }
                }
                if (ln.oq(xt.this.xt)) {
                    xt.this.j(z6, i8, str2);
                }
            }
        };
        this.ae = abstractEndCardFrameLayout.getEndCardWebView();
        j();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.j
    public void az() {
        super.az();
        this.ch.clear();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.j
    public void j(boolean z5, Map<String, Object> map, View view) {
        if (this.ae == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        tl tlVar = new tl(this.cw, this.xt, jSONObject);
        this.f28246g = tlVar;
        tlVar.j(jSONObject, "webview_source", (Object) 2);
        com.bytedance.sdk.openadsdk.core.jy.r xt = new com.bytedance.sdk.openadsdk.core.jy.r(this.xt, this.ae).xt(true);
        this.vl = xt;
        xt.j(true);
        p();
        this.vl.j(a() ? "landingpage_endcard" : z5 ? "reward_endcard" : "fullscreen_endcard");
        rn rnVar = new rn(this.f28248j);
        this.tl = rnVar;
        rnVar.xt(this.ae).j(this.xt).xt(this.xt.fs()).cw(this.xt.os()).cw(z5 ? 7 : 5).j(this.f28251v).r(uf.av(this.xt)).j(this.ae).xt(oq.j(this.xt)).j(this.f28246g).j(this.cw).j(map).j(this.f28253x).j(view).j(this.f28275s);
        this.tl.j(this.f28271a);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.j
    public void j(DownloadListener downloadListener, com.bytedance.sdk.openadsdk.core.xt.xt xtVar) {
        if (this.ae == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.j.r rVar = new com.bytedance.sdk.openadsdk.core.widget.j.r(this.f28248j, this.tl, this.xt.fs(), this.vl) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.xt.3
            @Override // com.bytedance.sdk.openadsdk.core.widget.j.r, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i6, String str, String str2) {
                xt.this.f28247i.set(false);
                xt.this.f28252w = this.tl;
                xt xtVar2 = xt.this;
                xtVar2.jy = i6;
                xtVar2.ws = str;
                if (xtVar2.f28246g != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (Build.VERSION.SDK_INT >= 23) {
                            jSONObject.put("code", i6);
                            jSONObject.put("msg", str);
                        }
                        xt.this.f28246g.xt(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                super.onReceivedError(webView, i6, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.j.r, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                WebResourceResponse j6 = xt.this.j(str);
                return j6 != null ? j6 : super.shouldInterceptRequest(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.j.r, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                tl tlVar = xt.this.f28246g;
                if (tlVar != null) {
                    tlVar.ae();
                }
                super.onPageFinished(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.j.r, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                tl tlVar = xt.this.f28246g;
                if (tlVar != null) {
                    tlVar.m();
                }
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.j.r, android.webkit.WebViewClient
            @TargetApi(21)
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (xt.this.f28246g != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", webResourceResponse.getStatusCode());
                        jSONObject.put("msg", webResourceResponse.getReasonPhrase());
                        xt.this.f28246g.xt(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                if (xt.this.oq.equals(String.valueOf(webResourceRequest.getUrl()))) {
                    if (webResourceRequest.isForMainFrame()) {
                        xt.this.f28247i.set(false);
                        xt.this.f28252w = this.tl;
                    }
                    if (webResourceResponse != null) {
                        xt.this.jy = webResourceResponse.getStatusCode();
                        xt.this.ws = "onReceivedHttpError";
                    }
                }
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.j.r, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                try {
                    String uri = webResourceRequest.getUrl().toString();
                    xt xtVar2 = xt.this;
                    if (xtVar2.xt != null) {
                        WebResourceResponse j6 = xtVar2.j(uri);
                        if (j6 != null) {
                            return j6;
                        }
                        if (TextUtils.isEmpty(xt.this.xt.el())) {
                            return super.shouldInterceptRequest(webView, uri);
                        }
                        xt.this.up++;
                        return super.shouldInterceptRequest(webView, uri);
                    }
                    return super.shouldInterceptRequest(webView, uri);
                } catch (Throwable th) {
                    vl.cw("CommonEndCard", "shouldInterceptRequest error1", th);
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
                    xt.this.f28247i.set(false);
                    xt.this.f28252w = this.tl;
                }
                if (xt.this.f28246g != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (Build.VERSION.SDK_INT >= 23) {
                            errorCode = webResourceError.getErrorCode();
                            jSONObject.put("code", errorCode);
                            description = webResourceError.getDescription();
                            jSONObject.put("msg", description);
                        }
                        xt.this.f28246g.xt(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                xt xtVar2 = xt.this;
                errorCode2 = webResourceError.getErrorCode();
                xtVar2.jy = errorCode2;
                xt xtVar3 = xt.this;
                description2 = webResourceError.getDescription();
                xtVar3.ws = String.valueOf(description2);
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }
        };
        this.qv = rVar;
        this.ae.setWebViewClient(rVar);
        j(this.ae);
        this.ae.setBackgroundColor(-1);
        this.ae.setDisplayZoomControls(false);
        this.ae.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.j.cw(this.tl, this.vl) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.xt.4
            @Override // com.bytedance.sdk.openadsdk.core.widget.j.cw, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i6) {
                super.onProgressChanged(webView, i6);
            }
        });
        this.ae.setDownloadListener(downloadListener);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.j
    public void j(int i6) {
        super.j(i6);
        j(true);
        cw(true);
        j(false, true);
    }

    public void j(double d6, double d7, double d8, double d9, String str) {
        if (this.tl == null || this.f28248j.isFinishing()) {
            return;
        }
        if (!this.av) {
            this.f28273l = d6;
            this.f28274p = d7;
            this.la = d9;
            this.f28272h = d8;
            this.gq = str;
            this.rn = true;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("x", d6);
            jSONObject.put("y", d7);
            jSONObject.put("width", d8);
            jSONObject.put("height", d9);
            jSONObject.put("videoFrameKey", str);
            this.tl.j("endcardTransform", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void j(ws wsVar) {
        double d6;
        double d7;
        double d8;
        double d9;
        if (e.x(this.xt)) {
            double d10 = this.kt;
            double d11 = this.tj;
            if (wsVar == null || !this.f28248j.e().ae() || (wsVar.tl() == 0.0d && wsVar.g() == 0.0d)) {
                d6 = d11;
                d7 = 0.0d;
                d8 = d10;
                d9 = 0.0d;
            } else {
                double m6 = wsVar.m();
                double ae = wsVar.ae();
                double tl = wsVar.tl();
                d6 = wsVar.g();
                d7 = ae;
                d9 = m6;
                d8 = tl;
            }
            j(d9, d7, d8, d6, null);
            if (this.f28248j.e() instanceof up) {
                return;
            }
            final double d12 = d6;
            final double d13 = d8;
            final double d14 = d7;
            final double d15 = d9;
            com.bykv.vk.openvk.component.video.j.up.xt.j(2147483647L, ln.j(this.xt), new xt.InterfaceC0309xt() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.xt.5
                @Override // com.bykv.vk.openvk.component.video.j.up.xt.InterfaceC0309xt
                public void j(Bitmap bitmap) {
                    if (bitmap != null) {
                        String valueOf = String.valueOf(bitmap.hashCode());
                        xt.this.ch.put(valueOf, bitmap);
                        xt.this.j(d15, d14, d13, d12, valueOf);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebResourceResponse j(String str) {
        if (!str.startsWith("csjclientimg://")) {
            return null;
        }
        Bitmap bitmap = this.ch.get(str.replace("csjclientimg://", ""));
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return new WebResourceResponse("text/html", "UTF-8", new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
    }
}
