package com.beizi.ad.internal.h;

import android.annotation.SuppressLint;
import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.WebView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class x {
    public static String a() {
        return null;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static void a(WebView webView) {
        if (webView == null) {
            return;
        }
        try {
            webView.getSettings().setBuiltInZoomControls(false);
            webView.getSettings().setSupportZoom(true);
            webView.getSettings().setUseWideViewPort(true);
            webView.getSettings().setJavaScriptEnabled(true);
            int i6 = Build.VERSION.SDK_INT;
            webView.getSettings().setMixedContentMode(0);
            webView.getSettings().setDomStorageEnabled(true);
            webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
            webView.getSettings().setAllowFileAccess(false);
            webView.getSettings().setAllowContentAccess(false);
            webView.getSettings().setSavePassword(false);
            webView.getSettings().setAllowFileAccessFromFileURLs(false);
            webView.getSettings().setAllowUniversalAccessFromFileURLs(false);
            CookieManager cookieManager = CookieManager.getInstance();
            if (cookieManager != null) {
                cookieManager.setAcceptThirdPartyCookies(webView, true);
            }
            if (i6 <= 33) {
                webView.getSettings().setAppCachePath(webView.getContext().getCacheDir().getAbsolutePath());
                webView.getSettings().setAppCacheEnabled(true);
            }
            webView.getSettings().setCacheMode(-1);
            WebView.setWebContentsDebuggingEnabled(false);
            webView.getSettings().setGeolocationEnabled(false);
        } catch (Throwable unused) {
        }
    }

    public static void b(WebView webView) {
        if (webView == null) {
            return;
        }
        try {
            WebView.class.getDeclaredMethod("onResume", null).invoke(webView, null);
        } catch (Exception unused) {
        }
    }

    public static void c(WebView webView) {
        if (webView == null) {
            return;
        }
        try {
            WebView.class.getDeclaredMethod("onPause", null).invoke(webView, null);
        } catch (Exception unused) {
        }
    }
}
