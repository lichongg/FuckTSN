package com.kwad.sdk.utils;

import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.MainThread;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class cb {
    @MainThread
    public static WebSettings a(WebView webView) {
        webView.getSettings().setAllowFileAccess(false);
        return b(webView);
    }

    private static WebSettings b(WebView webView) {
        WebSettings settings = webView.getSettings();
        settings.setAllowContentAccess(false);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setTextZoom(100);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setMixedContentMode(0);
        CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
        webView.setSaveEnabled(false);
        return settings;
    }
}
