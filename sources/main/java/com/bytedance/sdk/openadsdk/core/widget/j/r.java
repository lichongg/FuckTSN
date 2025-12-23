package com.bytedance.sdk.openadsdk.core.widget.j;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.sdk.component.adexpress.up.up;
import com.bytedance.sdk.component.utils.qv;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.utils.ws;
import com.bytedance.sdk.component.utils.xt;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.jy.m;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ae;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.qv.tl;
import com.bytedance.sdk.openadsdk.core.rn;
import com.bytedance.sdk.openadsdk.core.rn.kt;
import com.bytedance.sdk.openadsdk.core.rn.la;
import com.bytedance.sdk.openadsdk.core.rn.n;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.gq;
import com.bytedance.sdk.openadsdk.core.tj.p;
import com.bytedance.sdk.openadsdk.core.v;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r extends WebViewClient implements SSWebView.cw {
    private static final HashSet<String> qv;
    protected final Context cw;

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.jy.r f31209j;

    /* renamed from: r, reason: collision with root package name */
    protected final String f31211r;
    protected com.bytedance.sdk.openadsdk.core.jy.r up;
    protected final rn xt;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f31210m = true;
    protected boolean ae = true;
    protected volatile AtomicInteger tl = new AtomicInteger(0);

    /* renamed from: g, reason: collision with root package name */
    private long f31208g = -1;
    private boolean oq = false;

    public r(Context context, rn rnVar, String str) {
        this.cw = context;
        this.xt = rnVar;
        this.f31211r = str;
    }

    private boolean j(Uri uri) {
        File xt = com.bytedance.sdk.openadsdk.api.plugin.xt.xt(v.getContext());
        if (uri == null) {
            return false;
        }
        try {
            String lastPathSegment = uri.getLastPathSegment();
            if (lastPathSegment == null) {
                return false;
            }
            File canonicalFile = new File(xt, lastPathSegment).getCanonicalFile();
            if (canonicalFile.exists()) {
                return !canonicalFile.getPath().startsWith(xt.toString());
            }
            return false;
        } catch (Exception e6) {
            vl.j(e6);
            return false;
        }
    }

    private static String xt(String str) {
        int lastIndexOf;
        String substring;
        if (str == null || (lastIndexOf = str.lastIndexOf(46)) < 0 || lastIndexOf == str.length() - 1 || (substring = str.substring(lastIndexOf)) == null || !qv.contains(substring.toLowerCase(Locale.getDefault()))) {
            return null;
        }
        return "image/" + substring;
    }

    public void cw() {
        this.oq = true;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i6, String str, String str2) {
        super.onReceivedError(webView, i6, str, str2);
        com.bytedance.sdk.openadsdk.core.jy.r rVar = this.up;
        if (rVar != null) {
            rVar.j(i6, str, str2, xt(str2));
        }
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest != null && j(webResourceRequest.getUrl())) {
            return null;
        }
        WebResourceResponse shouldInterceptRequest = super.shouldInterceptRequest(webView, webResourceRequest);
        if (this.f31209j != null) {
            shouldInterceptRequest = this.f31209j.j(webView, new com.bytedance.sdk.openadsdk.jy.xt(webResourceRequest, null), shouldInterceptRequest);
        }
        if (j(webView, webResourceRequest)) {
            return new WebResourceResponse("", "", null);
        }
        List<p.cw> j6 = n.j().j(webResourceRequest.getUrl().toString());
        if (j6 == null || j6.isEmpty()) {
            return shouldInterceptRequest;
        }
        n j7 = n.j();
        String uri = webResourceRequest.getUrl().toString();
        com.bytedance.sdk.openadsdk.core.jy.r rVar = this.up;
        return j7.j(shouldInterceptRequest, uri, j6, rVar != null ? rVar.tl() : null);
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        qv = hashSet;
        hashSet.add("png");
        hashSet.add("ico");
        hashSet.add("jpg");
        hashSet.add("gif");
        hashSet.add("svg");
        hashSet.add("jpeg");
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        com.bytedance.sdk.openadsdk.core.jy.r rVar = this.up;
        if (rVar != null) {
            rVar.j(webView);
        }
        if (webView != null && this.f31210m) {
            try {
                String j6 = xt.j(v.xt().ed(), this.f31211r);
                if (!TextUtils.isEmpty(j6)) {
                    qv.j(webView, j6);
                }
            } catch (Throwable unused) {
            }
        }
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslErrorHandler != null) {
            try {
                sslErrorHandler.cancel();
            } catch (Throwable unused) {
            }
        }
        if (this.up != null) {
            int i6 = 0;
            String str = "SslError: unknown";
            String str2 = null;
            if (sslError != null) {
                try {
                    i6 = sslError.getPrimaryError();
                    str = "SslError: " + String.valueOf(sslError);
                    str2 = sslError.getUrl();
                } catch (Throwable unused2) {
                }
            }
            this.up.j(i6, str, str2, xt(str2));
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        boolean didCrash;
        if (Build.VERSION.SDK_INT < 26) {
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }
        didCrash = renderProcessGoneDetail.didCrash();
        if (didCrash) {
            vl.r("WebChromeClient", "The WebView rendering process crashed!");
            if (webView != null) {
                ViewGroup viewGroup = (ViewGroup) webView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(webView);
                }
                webView.destroy();
                up.j().xt();
            }
            return true;
        }
        vl.r("WebChromeClient", "System killed the WebView rendering process to reclaim memory. Recreating...");
        if (webView != null) {
            ViewGroup viewGroup2 = (ViewGroup) webView.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(webView);
            }
            webView.destroy();
            up.j().xt();
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        com.bytedance.sdk.openadsdk.core.jy.r rVar = this.up;
        if (rVar != null) {
            rVar.j(webView, str, bitmap);
        }
        if (this.ae) {
            xt.j(this.cw).j(true).j(webView);
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        String str;
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (this.up != null && webResourceResponse != null) {
            Uri url = webResourceRequest.getUrl();
            String str2 = "";
            if (url == null) {
                str = "";
            } else {
                str = url.toString();
            }
            Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
            if (requestHeaders.containsKey("Accept")) {
                str2 = requestHeaders.get("Accept");
            } else if (requestHeaders.containsKey("accept")) {
                str2 = requestHeaders.get("accept");
            }
            this.up.j(webResourceResponse.getStatusCode(), String.valueOf(webResourceResponse.getReasonPhrase()), str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        rn rnVar;
        Object apply;
        boolean z5;
        j(str);
        try {
        } catch (Exception e6) {
            vl.xt("WebChromeClient", "shouldOverrideUrlLoading", e6);
            rn rnVar2 = this.xt;
            if (rnVar2 != null && rnVar2.g()) {
                return true;
            }
        }
        if (j(webView, str)) {
            return true;
        }
        com.bytedance.sdk.openadsdk.jy.r rVar = this.f31209j;
        if (rVar != null) {
            rVar.j(webView, str);
        }
        Uri parse = Uri.parse(str);
        String lowerCase = parse.getScheme().toLowerCase();
        if ("bytedance".equals(lowerCase)) {
            kt.j(parse, this.xt);
            return true;
        }
        if (oq.i().gx() != null) {
            boolean z6 = false;
            apply = oq.i().gx().apply(com.bytedance.sdk.openadsdk.i.r.j().j(15).j(Boolean.class).j(0, new la().j(ContentProviderManager.PROVIDER_URI, parse)).xt());
            if (((Boolean) apply).booleanValue()) {
                rn rnVar3 = this.xt;
                if (rnVar3 != null && rnVar3.tl() != null) {
                    if (v.xt().sf() != 1) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.j(str) && z5) {
                        com.bytedance.sdk.openadsdk.core.tj.n tl = this.xt.tl();
                        com.bytedance.sdk.openadsdk.core.qv.xt.cw xt = tl.xt(this.cw, tl, this.xt.ch(), true);
                        if (xt instanceof com.bytedance.sdk.openadsdk.core.qv.cw.up) {
                            ((com.bytedance.sdk.openadsdk.core.qv.cw.up) xt).m(true);
                        }
                        xt.j(tl, false);
                        z6 = true;
                    } else {
                        z6 = com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.j(parse, this.xt.tl(), this.cw, this.xt.ch(), hashCode());
                    }
                }
                com.bytedance.sdk.openadsdk.core.xt.j().j("is_landing_page_open_market", true);
                if (z6) {
                    return true;
                }
            }
        }
        if (!ws.j(str) && (rnVar = this.xt) != null && rnVar.tl() != null) {
            final String ch = this.xt.ch();
            final com.bytedance.sdk.openadsdk.core.tj.n tl2 = this.xt.tl();
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            intent.addFlags(268435456);
            com.bytedance.sdk.openadsdk.core.jy.cw.xt(tl2, ch, "lp_open_dpl", lowerCase);
            if (uf.xt(this.cw)) {
                if (uf.j(this.cw, intent)) {
                    com.bytedance.sdk.component.utils.xt.j(this.cw, intent, new xt.j() { // from class: com.bytedance.sdk.openadsdk.core.widget.j.r.1
                        @Override // com.bytedance.sdk.component.utils.xt.j
                        public void j() {
                            com.bytedance.sdk.openadsdk.core.jy.cw.j(tl2, ch, "lp_openurl", (Throwable) null);
                            com.bytedance.sdk.openadsdk.core.jy.cw.j(tl2, ch, "lp_deeplink_success_realtime", (Throwable) null);
                        }

                        @Override // com.bytedance.sdk.component.utils.xt.j
                        public void j(Throwable th) {
                            com.bytedance.sdk.openadsdk.core.jy.cw.j(tl2, ch, "lp_openurl_failed", th);
                            com.bytedance.sdk.openadsdk.core.jy.cw.j(tl2, ch, "lp_deeplink_fail_realtime", th);
                        }
                    }, TextUtils.equals("main", UMModuleRegister.INNER));
                    m.j().j(tl2, ch, true);
                } else {
                    com.bytedance.sdk.openadsdk.core.jy.cw.j(tl2, ch, "lp_openurl_failed", (Throwable) null);
                    com.bytedance.sdk.openadsdk.core.jy.cw.j(tl2, ch, "lp_deeplink_fail_realtime", (Throwable) null);
                }
            } else {
                try {
                    j(this.cw, intent);
                    com.bytedance.sdk.openadsdk.core.jy.cw.j(tl2, ch, "lp_openurl", (Throwable) null);
                    com.bytedance.sdk.openadsdk.core.jy.cw.j(tl2, ch, "lp_deeplink_success_realtime", (Throwable) null);
                    m.j().j(tl2, ch, true);
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.core.jy.cw.j(tl2, ch, "lp_openurl_failed", th);
                    com.bytedance.sdk.openadsdk.core.jy.cw.j(tl2, ch, "lp_deeplink_fail_realtime", th);
                }
            }
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        int errorCode;
        CharSequence description;
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (this.up == null || webResourceError == null) {
            return;
        }
        Uri url = webResourceRequest.getUrl();
        String str = "";
        String uri = url != null ? url.toString() : "";
        Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
        if (requestHeaders.containsKey("Accept")) {
            str = requestHeaders.get("Accept");
        } else if (requestHeaders.containsKey("accept")) {
            str = requestHeaders.get("accept");
        }
        com.bytedance.sdk.openadsdk.core.jy.r rVar = this.up;
        errorCode = webResourceError.getErrorCode();
        description = webResourceError.getDescription();
        rVar.j(errorCode, String.valueOf(description), uri, str);
    }

    protected boolean j(WebView webView, WebResourceRequest webResourceRequest) {
        return gq.j(webView, this.tl, this.xt, webResourceRequest, false, xt()) && !(this instanceof ae);
    }

    public boolean j(WebView webView, String str) {
        return gq.j(webView, this.tl, this.xt, str, false, xt()) && !(this instanceof ae);
    }

    public boolean xt() {
        return System.currentTimeMillis() - this.f31208g < 1000;
    }

    private void j(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.contains("weixin://wap/pay") || str.contains("weixin://dl/business/?ticket") || str.contains("alipays://platformapi/startapp?appId")) {
            com.bytedance.sdk.openadsdk.core.jy.cw.cw(this.xt.tl(), "landingpage", "lp_pay");
        }
    }

    public void xt(boolean z5) {
        if (!z5 || this.oq) {
            this.f31208g = System.currentTimeMillis();
        }
    }

    public r(Context context, rn rnVar, String str, com.bytedance.sdk.openadsdk.core.jy.r rVar) {
        this.cw = context;
        this.xt = rnVar;
        this.f31211r = str;
        this.up = rVar;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (str != null && j(Uri.parse(str))) {
            return null;
        }
        WebResourceResponse shouldInterceptRequest = super.shouldInterceptRequest(webView, str);
        if (this.f31209j != null) {
            shouldInterceptRequest = this.f31209j.j(webView, new com.bytedance.sdk.openadsdk.jy.xt(null, str), shouldInterceptRequest);
        }
        if (j(webView, str)) {
            return new WebResourceResponse("", "", null);
        }
        List<p.cw> j6 = n.j().j(str);
        if (j6 == null || j6.isEmpty()) {
            return shouldInterceptRequest;
        }
        n j7 = n.j();
        com.bytedance.sdk.openadsdk.core.jy.r rVar = this.up;
        return j7.j(shouldInterceptRequest, str, j6, rVar != null ? rVar.tl() : null);
    }

    private void j(Context context, Intent intent) {
        if (intent != null) {
            try {
                ComponentName resolveActivity = intent.resolveActivity(context.getPackageManager());
                if ((resolveActivity == null || !resolveActivity.getPackageName().equals(context.getPackageName())) && (intent.getFlags() & MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO) == 0) {
                    com.bytedance.sdk.component.utils.xt.j(context, intent, null, TextUtils.equals("main", UMModuleRegister.INNER));
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView.cw
    public void j(boolean z5) {
        rn rnVar = this.xt;
        if (rnVar != null) {
            rnVar.cw(z5);
        }
    }

    public r(Context context, rn rnVar, String str, com.bytedance.sdk.openadsdk.core.jy.r rVar, com.bytedance.sdk.openadsdk.jy.r rVar2) {
        this.cw = context;
        this.xt = rnVar;
        this.f31211r = str;
        this.up = rVar;
        this.f31209j = rVar2;
    }
}
