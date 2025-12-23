package com.kwad.sdk.core.webview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.webview.a.c;
import com.kwad.sdk.o.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bz;
import com.kwad.sdk.utils.cb;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class KsAdWebView extends com.kwad.sdk.core.webview.c {
    private long Gn;
    private c.a Mh;
    private com.kwad.sdk.core.webview.a.c aMU;
    private String aMV;

    @Nullable
    private com.kwad.sdk.core.webview.d aMW;
    private String mUniqueId;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements DownloadListener {
        private a() {
        }

        /* synthetic */ a(KsAdWebView ksAdWebView, byte b6) {
            this();
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j6) {
            boolean o5 = bz.o(KsAdWebView.this, 100);
            com.kwad.sdk.core.d.c.d("KsAdWebView", "onDownloadStart: currentVisible " + o5);
            if (o5) {
                if (KsAdWebView.this.Mh == null || KsAdWebView.this.Mh.KQ()) {
                    if (KsAdWebView.this.Mh == null || KsAdWebView.this.Mh.getAdTemplate() == null || !KsAdWebView.this.Mh.KO()) {
                        try {
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                            intent.setFlags(268435456);
                            KsAdWebView.this.getContext().startActivity(intent);
                            return;
                        } catch (Exception e6) {
                            com.kwad.sdk.core.d.c.printStackTrace(e6);
                            return;
                        }
                    }
                    com.kwad.sdk.core.response.b.e.el(KsAdWebView.this.Mh.getAdTemplate()).adConversionInfo.appDownloadUrl = str;
                    KsAdWebView.this.Mh.getAdTemplate().isWebViewDownload = true;
                    c.a readyClientConfig = KsAdWebView.this.getReadyClientConfig();
                    if (readyClientConfig != null) {
                        readyClientConfig.eJ(KsAdWebView.this.Mh.getAdTemplate());
                    }
                    ((com.kwad.sdk.service.a.a) ServiceProvider.get(com.kwad.sdk.service.a.a.class)).h(m.wrapContextIfNeed(KsAdWebView.this.getContext()), KsAdWebView.this.Mh.getAdTemplate());
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void onFailed();

        void onSuccess();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface c {
        void rn();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface d {
        boolean shouldOverrideUrlLoading(WebView webView, String str);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface e {
        void onPageFinished();

        void onPageStart();

        void onReceivedHttpError(int i6, String str, String str2);
    }

    public KsAdWebView(Context context) {
        super(context);
        init(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a getReadyClientConfig() {
        com.kwad.sdk.core.webview.a.c cVar = this.aMU;
        if (cVar == null || cVar.getClientConfig() == null) {
            return null;
        }
        return this.aMU.getClientConfig();
    }

    private void init(Context context) {
        com.kwad.sdk.core.d.c.i("KsAdWebView", "init");
        setAccessibilityStateDisable(context);
        WebSettings a6 = cb.a(this);
        a6.setUseWideViewPort(true);
        a6.setDomStorageEnabled(true);
        setVerticalScrollBarEnabled(false);
        com.kwad.sdk.core.webview.a.c cVar = new com.kwad.sdk.core.webview.a.c() { // from class: com.kwad.sdk.core.webview.KsAdWebView.1
            @Override // com.kwad.sdk.core.webview.a.c, android.webkit.WebViewClient
            public final void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (KsAdWebView.this.aMW != null) {
                    KsAdWebView.this.aMW.c(KsAdWebView.this.Mh);
                }
            }

            @Override // com.kwad.sdk.core.webview.a.c, android.webkit.WebViewClient
            public final void onReceivedError(WebView webView, int i6, String str, String str2) {
                super.onReceivedError(webView, i6, str, str2);
                if (KsAdWebView.this.aMW != null) {
                    com.kwad.sdk.core.webview.d unused = KsAdWebView.this.aMW;
                    com.kwad.sdk.core.webview.d.d(KsAdWebView.this.Mh);
                }
            }
        };
        this.aMU = cVar;
        cVar.R(this.mUniqueId);
        setWebViewClient(this.aMU);
        setWebChromeClient(new com.kwad.sdk.core.webview.a.b());
        setDownloadListener(new a(this, (byte) 0));
        this.Mh = new c.a(getContext());
    }

    public c.a getClientConfig() {
        return this.Mh;
    }

    public long getLoadTime() {
        return this.Gn;
    }

    public String getLoadUrl() {
        return this.aMV;
    }

    public String getUniqueId() {
        return this.mUniqueId;
    }

    public final void onActivityCreate() {
        com.kwad.sdk.core.webview.d dVar = this.aMW;
        if (dVar != null) {
            dVar.a(this.Mh);
        }
    }

    public void setClientConfig(c.a aVar) {
        this.aMU.setClientConfig(aVar);
        c.a aVar2 = this.Mh;
        if (aVar2 == null || !aVar2.KP()) {
            return;
        }
        this.aMW = new com.kwad.sdk.core.webview.d();
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        if (com.kwad.framework.a.a.oz.booleanValue() && !(webChromeClient instanceof com.kwad.sdk.core.webview.a.b)) {
            throw new IllegalArgumentException("client is not instanceof KSWebChromeClient");
        }
        super.setWebChromeClient(webChromeClient);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        if (com.kwad.framework.a.a.oz.booleanValue() && !(webViewClient instanceof com.kwad.sdk.core.webview.a.a)) {
            throw new IllegalArgumentException("Not supported set webViewClient, please check it");
        }
        super.setWebViewClient(webViewClient);
    }

    public KsAdWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void a(Context context, WebSettings webSettings) {
        boolean z5;
        boolean z6;
        String userAgentString = webSettings.getUserAgentString();
        c.a aVar = this.Mh;
        if (aVar != null) {
            z5 = aVar.KR();
            z6 = this.Mh.KS();
        } else {
            z5 = false;
            z6 = false;
        }
        com.kwad.sdk.core.i.c j6 = com.kwad.sdk.core.i.a.j(z5, z6);
        com.kwad.sdk.core.d.c.d("KsAdWebView", "setWebViewUserAgent: uaGetter：" + j6);
        String str = userAgentString + j6.bJ(context);
        com.kwad.sdk.core.d.c.d("KsAdWebView", "setWebViewUserAgent: " + str);
        webSettings.setUserAgentString(str);
    }

    @Override // com.kwad.sdk.core.webview.c, android.webkit.WebView
    public void destroy() {
        super.destroy();
        c.a aVar = this.Mh;
        if (aVar != null) {
            aVar.release();
            this.Mh = null;
        }
        com.kwad.sdk.core.webview.a.c cVar = this.aMU;
        if (cVar != null) {
            cVar.destroy();
            this.aMU = null;
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        a(getContext(), getSettings());
        com.kwad.sdk.core.webview.b.c.b.ff(this.mUniqueId);
        this.aMV = str;
        this.Gn = System.currentTimeMillis();
        super.loadUrl(str);
    }

    public final void onActivityDestroy() {
        release();
        com.kwad.sdk.core.webview.d dVar = this.aMW;
        if (dVar != null) {
            dVar.b(this.Mh);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i6, int i7, int i8, int i9) {
        super.onScrollChanged(i6, i7, i8, i9);
        c.a aVar = this.Mh;
        if (aVar != null && aVar.rm() != null) {
            this.Mh.rm().rn();
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        c.a aVar;
        if (motionEvent.getAction() == 1 && (aVar = this.Mh) != null) {
            aVar.aM(System.currentTimeMillis());
        }
        return super.onTouchEvent(motionEvent);
    }

    public KsAdWebView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        init(context);
    }

    public KsAdWebView(Context context, AttributeSet attributeSet, int i6, boolean z5) {
        super(context, attributeSet, i6, z5);
        init(context);
    }

    private void setAccessibilityStateDisable(Context context) {
    }
}
