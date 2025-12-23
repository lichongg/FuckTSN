package xyz.adscope.ad.ad.nativead.render.view.asnp.prefab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.CookieManager;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class BasicWebView extends WebView {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b extends WebChromeClient {
        private b() {
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            if (callback != null) {
                callback.invoke(str, false, false);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class c extends WebViewClient {
        private c() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
                return super.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
            String uri = webResourceRequest.getUrl().toString();
            if (BasicWebView.this.a(uri)) {
                return true;
            }
            Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
            if (requestHeaders == null || requestHeaders.isEmpty()) {
                requestHeaders = new HashMap<>();
            }
            requestHeaders.put("X-Requested-With", "");
            webView.loadUrl(uri, requestHeaders);
            return true;
        }

        /* synthetic */ c(BasicWebView basicWebView, a aVar) {
            this();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (BasicWebView.this.a(str)) {
                return true;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("X-Requested-With", "");
            webView.loadUrl(str, hashMap);
            return true;
        }
    }

    public BasicWebView(@NonNull Context context) {
        super(context);
        d();
    }

    private void e() {
        a aVar = null;
        setWebViewClient(new c(this, aVar));
        setWebChromeClient(new b(aVar));
    }

    protected boolean a(String str) {
        return !str.startsWith(master.flame.danmaku.danmaku.parser.b.f50154a);
    }

    public BasicWebView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
    }

    private void d() {
        f();
        e();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void f() {
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setBuiltInZoomControls(false);
        settings.setLoadsImagesAutomatically(true);
        settings.setSupportZoom(false);
        settings.setUseWideViewPort(false);
        settings.setEnableSmoothTransition(true);
        settings.setLightTouchEnabled(false);
        settings.setPluginState(WebSettings.PluginState.ON);
        settings.setSavePassword(false);
        int i6 = Build.VERSION.SDK_INT;
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setMixedContentMode(0);
        WebView.setWebContentsDebuggingEnabled(false);
        if (i6 <= 32) {
            settings.setAppCachePath(getContext().getCacheDir().getAbsolutePath());
            settings.setAppCacheEnabled(true);
        }
        settings.setCacheMode(-1);
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        settings.setGeolocationEnabled(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        CookieManager cookieManager = CookieManager.getInstance();
        if (cookieManager != null) {
            cookieManager.setAcceptThirdPartyCookies(this, true);
        }
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setScrollBarStyle(0);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollbarOverlay(false);
    }

    public BasicWebView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        d();
    }

    public BasicWebView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        d();
    }
}
