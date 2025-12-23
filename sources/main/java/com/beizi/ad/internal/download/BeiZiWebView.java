package com.beizi.ad.internal.download;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.CookieManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class BeiZiWebView extends WebView {
    public BeiZiWebView(Context context) {
        super(context);
        a();
    }

    public BeiZiWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        try {
            b();
        } catch (Throwable unused) {
        }
    }

    private void b() {
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setBuiltInZoomControls(false);
        settings.setEnableSmoothTransition(true);
        settings.setLightTouchEnabled(false);
        settings.setPluginState(WebSettings.PluginState.ON);
        settings.setLoadsImagesAutomatically(true);
        settings.setSavePassword(false);
        settings.setSupportZoom(false);
        settings.setUseWideViewPort(false);
        int i6 = Build.VERSION.SDK_INT;
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setMixedContentMode(0);
        WebView.setWebContentsDebuggingEnabled(false);
        if (i6 <= 33) {
            settings.setAppCachePath(getContext().getCacheDir().getAbsolutePath());
            settings.setAppCacheEnabled(true);
        }
        settings.setCacheMode(-1);
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setGeolocationEnabled(false);
        CookieManager cookieManager = CookieManager.getInstance();
        if (cookieManager != null) {
            cookieManager.setAcceptThirdPartyCookies(this, true);
        }
        setHorizontalScrollbarOverlay(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setScrollBarStyle(0);
        setWebViewClient(new WebViewClient() { // from class: com.beizi.ad.internal.download.BeiZiWebView.1
            @Override // android.webkit.WebViewClient
            @RequiresApi(api = 21)
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                try {
                    Uri url = webResourceRequest.getUrl();
                    if (url == null) {
                        return false;
                    }
                    return !url.toString().startsWith(master.flame.danmaku.danmaku.parser.b.f50154a);
                } catch (Exception e6) {
                    e6.printStackTrace();
                    return false;
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return !str.startsWith(master.flame.danmaku.danmaku.parser.b.f50154a);
            }
        });
    }

    public BeiZiWebView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        a();
    }
}
