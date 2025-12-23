package com.tencent.open.web;

import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.open.log.SLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a {
    public static void a(WebView webView) {
        if (webView == null) {
            return;
        }
        b(webView);
        WebSettings settings = webView.getSettings();
        if (settings != null) {
            a(settings);
            b(settings);
        }
    }

    private static void b(WebView webView) {
        webView.removeJavascriptInterface("searchBoxJavaBridge_");
        webView.removeJavascriptInterface("accessibility");
        webView.removeJavascriptInterface("accessibilityTraversal");
    }

    private static void b(WebSettings webSettings) {
        webSettings.setJavaScriptEnabled(true);
    }

    private static void a(WebSettings webSettings) {
        try {
            webSettings.setSavePassword(false);
            webSettings.setAllowFileAccess(false);
            webSettings.setAllowFileAccessFromFileURLs(false);
            webSettings.setAllowUniversalAccessFromFileURLs(false);
        } catch (Exception e6) {
            SLog.e("WebViewUtils", "Exception", e6);
        }
    }
}
