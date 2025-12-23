package com.huawei.secure.android.common.webview;

import android.webkit.WebSettings;
import android.webkit.WebView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b {
    public static void a(WebSettings webSettings) {
        webSettings.setAllowContentAccess(false);
    }

    public static void b(WebSettings webSettings) {
        webSettings.setAllowFileAccess(false);
        webSettings.setAllowFileAccessFromFileURLs(false);
        webSettings.setAllowUniversalAccessFromFileURLs(false);
    }

    public static void c(WebSettings webSettings) {
        webSettings.setGeolocationEnabled(false);
    }

    public static void d(WebSettings webSettings) {
        webSettings.setMixedContentMode(1);
    }

    public static void g(WebView webView) {
        webView.removeJavascriptInterface("searchBoxJavaBridge_");
        webView.removeJavascriptInterface("accessibility");
        webView.removeJavascriptInterface("accessibilityTraversal");
    }

    public static void f(WebView webView) {
        WebSettings settings = webView.getSettings();
        b(settings);
        g(webView);
        e(settings);
        c(settings);
        d(settings);
        a(settings);
    }

    public static void e(WebSettings webSettings) {
    }
}
