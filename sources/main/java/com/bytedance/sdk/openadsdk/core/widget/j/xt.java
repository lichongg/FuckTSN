package com.bytedance.sdk.openadsdk.core.widget.j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.l.ae;
import java.lang.ref.WeakReference;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<Context> f31213j;
    private boolean xt = true;
    private boolean cw = true;

    /* renamed from: r, reason: collision with root package name */
    private boolean f31215r = true;
    private boolean up = true;

    /* renamed from: m, reason: collision with root package name */
    private boolean f31214m = true;
    private boolean ae = true;
    private boolean tl = true;

    public static xt j(Context context) {
        return new xt(context);
    }

    public xt xt(boolean z5) {
        this.cw = z5;
        return this;
    }

    private void xt(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            vl.cw(th.toString());
        }
    }

    public xt j(boolean z5) {
        this.tl = z5;
        return this;
    }

    private xt(Context context) {
        this.f31213j = new WeakReference<>(context);
    }

    public void j(final com.bytedance.sdk.component.jy.cw cwVar) {
        ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.widget.j.xt.1
            @Override // java.lang.Runnable
            public void run() {
                xt.this.j(cwVar.getWebView());
            }
        });
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0069 -> B:22:0x006c). Please report as a decompilation issue!!! */
    @SuppressLint({"SetJavaScriptEnabled"})
    public void j(WebView webView) {
        if (webView == null || this.f31213j.get() == null) {
            return;
        }
        xt(webView);
        WebSettings settings = webView.getSettings();
        j(settings);
        if (settings == null) {
            return;
        }
        try {
            settings.setJavaScriptEnabled(true);
        } catch (Exception e6) {
            vl.j(e6);
        }
        try {
            if (this.cw) {
                settings.setSupportZoom(true);
                settings.setBuiltInZoomControls(true);
            } else {
                settings.setSupportZoom(false);
            }
        } catch (Throwable th) {
            vl.j(th);
        }
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(this.f31215r);
        settings.setDomStorageEnabled(this.up);
        settings.setAllowFileAccess(false);
        settings.setBlockNetworkImage(true ^ this.ae);
        settings.setDisplayZoomControls(false);
        if (Build.VERSION.SDK_INT < 28) {
            this.tl = false;
        }
        try {
            boolean z5 = this.tl;
            if (!z5) {
                webView.setLayerType(0, null);
            } else if (z5) {
                webView.setLayerType(2, null);
            }
        } catch (Throwable th2) {
            vl.j(th2);
        }
    }

    private void j(WebSettings webSettings) {
        try {
            webSettings.setMediaPlaybackRequiresUserGesture(false);
        } catch (Throwable th) {
            vl.cw(th.toString());
        }
    }

    public static String j(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || "0".equals(str2) || !str.contains("{{ad_id}}")) {
            return null;
        }
        return "javascript:(function () {    var JS_ACTLOG_URL = '" + str.replace("{{ad_id}}", str2) + "';    var head = document.getElementsByTagName('head')[0];    var script = document.createElement('script');    script.type = 'text/javascript';    script.src = JS_ACTLOG_URL;    head.appendChild(script);})();";
    }
}
