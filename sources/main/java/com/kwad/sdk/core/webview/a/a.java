package com.kwad.sdk.core.webview.a;

import android.annotation.TargetApi;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.kwad.sdk.core.config.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a extends WebViewClient {
    private boolean aNa = true;
    protected String mUniqueId = "";

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (!this.aNa || !e.FF()) {
            return super.shouldInterceptRequest(webView, str);
        }
        com.kwad.sdk.core.d.c.d("HybridWebViewClient", "shouldInterceptRequest: " + str);
        WebResourceResponse aa = com.kwad.sdk.core.webview.b.a.KT().aa(str, this.mUniqueId);
        return aa == null ? super.shouldInterceptRequest(webView, str) : aa;
    }

    public final void setNeedHybridLoad(boolean z5) {
        this.aNa = z5;
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (this.aNa && e.FF()) {
            String uri = webResourceRequest.getUrl().toString();
            com.kwad.sdk.core.d.c.d("HybridWebViewClient", "shouldInterceptRequestAPI 21: " + uri);
            WebResourceResponse aa = com.kwad.sdk.core.webview.b.a.KT().aa(uri, this.mUniqueId);
            return aa == null ? super.shouldInterceptRequest(webView, webResourceRequest) : aa;
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }
}
