package com.kwad.components.core.o.b.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.webview.BaseKsWebView;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.cc;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends BaseKsWebView {
    private KsAdWebView SR;
    private boolean enableScroll;

    private void init(Context context) {
        setBackgroundColor(0);
        this.SR = new KsAdWebView(context);
        this.SR.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.SR.setBackgroundColor(0);
        this.SR.setClientConfig(this.SR.getClientConfig().b(new KsAdWebView.e() { // from class: com.kwad.components.core.o.b.d.a.3
            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
                if (a.this.mWebLoadListener != null) {
                    a.this.mWebLoadListener.onPageFinished();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageStart() {
                if (a.this.mWebLoadListener != null) {
                    a.this.mWebLoadListener.onPageStart();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i6, String str, String str2) {
                if (a.this.mWebLoadListener != null) {
                    a.this.mWebLoadListener.onReceivedHttpError(i6, str, str2);
                }
            }
        }).a(new KsAdWebView.b() { // from class: com.kwad.components.core.o.b.d.a.2
            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onFailed() {
                if (a.this.mDeeplinkListener != null) {
                    a.this.mDeeplinkListener.onFailed();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onSuccess() {
                if (a.this.mDeeplinkListener != null) {
                    a.this.mDeeplinkListener.onSuccess();
                }
            }
        }).a(new KsAdWebView.d() { // from class: com.kwad.components.core.o.b.d.a.1
            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (a.this.mWebLoadListener != null) {
                    return a.this.mWebLoadListener.shouldOverrideUrlLoading(webView, str);
                }
                return false;
            }
        }));
        addView(this.SR);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void callJs(String str) {
        cc.a(this.SR, str, (String) null);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    public final void addJavascriptInterface(Object obj, String str) {
        this.SR.addJavascriptInterface(obj, str);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void callJs(String str, String str2) {
        cc.a(this.SR, str, str2);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final boolean canGoBack() {
        return this.SR.canGoBack();
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final boolean canGoForward() {
        return this.SR.canGoForward();
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void destroy() {
        this.SR.destroy();
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void goBack() {
        this.SR.goBack();
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void goForward() {
        this.SR.goForward();
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void loadUrl(String str) {
        this.SR.loadUrl(str);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView, android.view.View
    public final void scrollBy(int i6, int i7) {
        if (this.enableScroll) {
            this.SR.scrollBy(i6, i7);
        }
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView, android.view.View
    public final void scrollTo(int i6, int i7) {
        if (this.enableScroll) {
            this.SR.scrollTo(i6, i7);
        }
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAdTemplateString(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            AdTemplate adTemplate = new AdTemplate();
            adTemplate.parseJson(jSONObject);
            this.SR.getClientConfig().eJ(adTemplate);
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAllowContentAccess(boolean z5) {
        this.SR.getSettings().setAllowContentAccess(z5);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAllowFileAccess(boolean z5) {
        this.SR.getSettings().setAllowFileAccess(z5);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAllowFileAccessFromFileURLs(boolean z5) {
        this.SR.getSettings().setAllowFileAccessFromFileURLs(z5);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAllowUniversalAccessFromFileURLs(boolean z5) {
        this.SR.getSettings().setAllowUniversalAccessFromFileURLs(z5);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setCacheMode(int i6) {
        this.SR.getSettings().setCacheMode(i6);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setDeeplinkEnabled(boolean z5) {
        if (this.SR.getClientConfig() != null) {
            this.SR.getClientConfig().bB(z5);
        }
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setEnableScroll(boolean z5) {
        this.enableScroll = z5;
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setEnableWebCache(boolean z5) {
        this.SR.setNeedHybridLoad(z5);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setInnerDownloadEnabled(boolean z5) {
        if (this.SR.getClientConfig() != null) {
            this.SR.getClientConfig().bC(z5);
        }
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setJavaScriptEnabled(boolean z5) {
        this.SR.getSettings().setJavaScriptEnabled(z5);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setMixedContentMode(int i6) {
        this.SR.getSettings().setMixedContentMode(i6);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setSavePassword(boolean z5) {
        this.SR.getSettings().setSavePassword(z5);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setTextZoom(int i6) {
        this.SR.getSettings().setTextZoom(i6);
    }

    public a(@NonNull Context context) {
        super(context);
        init(context);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAcceptThirdPartyCookies(boolean z5) {
        CookieManager.getInstance().setAcceptThirdPartyCookies(this.SR, z5);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAdCacheId(int i6, String str) {
        AdTemplate a6 = c.a(com.kwad.components.core.o.a.e.a.a.aI(i6), str);
        if (a6 != null && this.SR.getClientConfig() != null) {
            this.SR.getClientConfig().eJ(a6);
        }
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setContextUniqId(int i6) {
        AdTemplate r5 = c.r(com.kwad.components.core.o.a.e.a.a.aI(i6));
        if (r5 != null && this.SR.getClientConfig() != null) {
            this.SR.getClientConfig().eJ(r5);
        }
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setDebugEnabled(boolean z5) {
        WebView.setWebContentsDebuggingEnabled(z5);
    }
}
