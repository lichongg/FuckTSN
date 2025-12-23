package com.huawei.secure.android.common.webview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.huawei.secure.android.common.util.e;
import com.huawei.secure.android.common.webview.WebViewLoadCallBack;
import java.util.Arrays;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class SafeWebView extends WebView {

    /* renamed from: f, reason: collision with root package name */
    private static final String f35297f = "SafeWebView";

    /* renamed from: a, reason: collision with root package name */
    private String f35298a;

    /* renamed from: b, reason: collision with root package name */
    private String[] f35299b;

    /* renamed from: c, reason: collision with root package name */
    private String[] f35300c;

    /* renamed from: d, reason: collision with root package name */
    private String[] f35301d;

    /* renamed from: e, reason: collision with root package name */
    private WebViewLoadCallBack f35302e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        private final SslErrorHandler f35303a;

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i6) {
            this.f35303a.cancel();
        }

        b(SslErrorHandler sslErrorHandler) {
            this.f35303a = sslErrorHandler;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class c implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        private final SslErrorHandler f35304a;

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i6) {
            this.f35304a.proceed();
        }

        c(SslErrorHandler sslErrorHandler) {
            this.f35304a = sslErrorHandler;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class d extends WebViewClient {

        /* renamed from: a, reason: collision with root package name */
        private WebViewClient f35305a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f35306b;

        /* synthetic */ d(SafeWebView safeWebView, WebViewClient webViewClient, boolean z5, a aVar) {
            this(webViewClient, z5);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i6, String str, String str2) {
            WebViewClient webViewClient = this.f35305a;
            if (webViewClient != null) {
                webViewClient.onReceivedError(webView, i6, str, str2);
            } else {
                super.onReceivedError(webView, i6, str, str2);
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(21)
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            WebViewClient webViewClient = this.f35305a;
            return webViewClient != null ? webViewClient.shouldInterceptRequest(webView, webResourceRequest) : super.shouldInterceptRequest(webView, webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            WebViewClient webViewClient = this.f35305a;
            return webViewClient != null ? webViewClient.shouldOverrideUrlLoading(webView, str) : super.shouldOverrideUrlLoading(webView, str);
        }

        private d(WebViewClient webViewClient, boolean z5) {
            this.f35305a = webViewClient;
            this.f35306b = z5;
        }

        @Override // android.webkit.WebViewClient
        public void doUpdateVisitedHistory(WebView webView, String str, boolean z5) {
            WebViewClient webViewClient = this.f35305a;
            if (webViewClient != null) {
                webViewClient.doUpdateVisitedHistory(webView, str, z5);
            } else {
                super.doUpdateVisitedHistory(webView, str, z5);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onFormResubmission(WebView webView, Message message, Message message2) {
            WebViewClient webViewClient = this.f35305a;
            if (webViewClient != null) {
                webViewClient.onFormResubmission(webView, message, message2);
            } else {
                super.onFormResubmission(webView, message, message2);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            WebViewClient webViewClient = this.f35305a;
            if (webViewClient != null) {
                webViewClient.onLoadResource(webView, str);
            } else {
                super.onLoadResource(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(23)
        public void onPageCommitVisible(WebView webView, String str) {
            WebViewClient webViewClient = this.f35305a;
            if (webViewClient != null) {
                webViewClient.onPageCommitVisible(webView, str);
            } else {
                super.onPageCommitVisible(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            WebViewClient webViewClient = this.f35305a;
            if (webViewClient != null) {
                webViewClient.onPageFinished(webView, str);
            } else {
                super.onPageFinished(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            WebViewClient webViewClient = this.f35305a;
            if (webViewClient != null && !this.f35306b) {
                webViewClient.onPageStarted(webView, str, bitmap);
            } else if (SafeWebView.this.c(str)) {
                super.onPageStarted(webView, str, bitmap);
            } else {
                SafeWebView.this.d(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(21)
        public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
            WebViewClient webViewClient = this.f35305a;
            if (webViewClient != null) {
                webViewClient.onReceivedClientCertRequest(webView, clientCertRequest);
            } else {
                super.onReceivedClientCertRequest(webView, clientCertRequest);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            WebViewClient webViewClient = this.f35305a;
            if (webViewClient != null) {
                webViewClient.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            } else {
                super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(23)
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            WebViewClient webViewClient = this.f35305a;
            if (webViewClient != null) {
                webViewClient.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            } else {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(12)
        public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
            WebViewClient webViewClient = this.f35305a;
            if (webViewClient != null) {
                webViewClient.onReceivedLoginRequest(webView, str, str2, str3);
            } else {
                super.onReceivedLoginRequest(webView, str, str2, str3);
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(8)
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            WebViewClient webViewClient = this.f35305a;
            if (webViewClient != null) {
                webViewClient.onReceivedSslError(webView, sslErrorHandler, sslError);
            } else {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            boolean onRenderProcessGone;
            WebViewClient webViewClient = this.f35305a;
            if (webViewClient == null) {
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            onRenderProcessGone = webViewClient.onRenderProcessGone(webView, renderProcessGoneDetail);
            return onRenderProcessGone;
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i6, SafeBrowsingResponse safeBrowsingResponse) {
            WebViewClient webViewClient = this.f35305a;
            if (webViewClient != null) {
                webViewClient.onSafeBrowsingHit(webView, webResourceRequest, i6, safeBrowsingResponse);
            } else {
                super.onSafeBrowsingHit(webView, webResourceRequest, i6, safeBrowsingResponse);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onScaleChanged(WebView webView, float f6, float f7) {
            WebViewClient webViewClient = this.f35305a;
            if (webViewClient != null) {
                webViewClient.onScaleChanged(webView, f6, f7);
            } else {
                super.onScaleChanged(webView, f6, f7);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onTooManyRedirects(WebView webView, Message message, Message message2) {
            WebViewClient webViewClient = this.f35305a;
            if (webViewClient != null) {
                webViewClient.onTooManyRedirects(webView, message, message2);
            } else {
                super.onTooManyRedirects(webView, message, message2);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
            WebViewClient webViewClient = this.f35305a;
            if (webViewClient != null) {
                webViewClient.onUnhandledKeyEvent(webView, keyEvent);
            } else {
                super.onUnhandledKeyEvent(webView, keyEvent);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
            WebViewClient webViewClient = this.f35305a;
            return webViewClient != null ? webViewClient.shouldOverrideKeyEvent(webView, keyEvent) : super.shouldOverrideKeyEvent(webView, keyEvent);
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(23)
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            WebViewClient webViewClient = this.f35305a;
            if (webViewClient != null) {
                webViewClient.onReceivedError(webView, webResourceRequest, webResourceError);
            } else {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(11)
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            WebViewClient webViewClient = this.f35305a;
            if (webViewClient != null) {
                return webViewClient.shouldInterceptRequest(webView, str);
            }
            return super.shouldInterceptRequest(webView, str);
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(24)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            boolean shouldOverrideUrlLoading;
            WebViewClient webViewClient = this.f35305a;
            if (webViewClient != null) {
                shouldOverrideUrlLoading = webViewClient.shouldOverrideUrlLoading(webView, webResourceRequest);
                return shouldOverrideUrlLoading;
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
    }

    public SafeWebView(Context context) {
        super(context);
        a();
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        if (c(str)) {
            if (!b(str)) {
                super.loadUrl(str);
            } else if (!TextUtils.isEmpty(this.f35298a)) {
                super.loadUrl(this.f35298a);
            } else if (getWebViewLoadCallBack() != null) {
                getWebViewLoadCallBack().a(str, WebViewLoadCallBack.ErrorCode.HTTP_URL);
            }
        }
    }

    public final void d(WebView webView, String str) {
        e.m(f35297f, "onCheckError url is not in white list ", str);
        webView.stopLoading();
        String defaultErrorPage = getDefaultErrorPage();
        if (!TextUtils.isEmpty(defaultErrorPage)) {
            webView.loadUrl(defaultErrorPage);
        } else if (getWebViewLoadCallBack() != null) {
            getWebViewLoadCallBack().a(str, WebViewLoadCallBack.ErrorCode.URL_NOT_IN_WHITE_LIST);
        }
    }

    public void e(WebViewClient webViewClient, boolean z5) {
        super.setWebViewClient(new d(this, webViewClient, z5, null));
    }

    @Deprecated
    protected final void f(String str, String str2, String str3, String str4, SslErrorHandler sslErrorHandler) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        if (!TextUtils.isEmpty(str)) {
            builder.setTitle(str);
        }
        c cVar = new c(sslErrorHandler);
        b bVar = new b(sslErrorHandler);
        builder.setMessage(str2);
        builder.setPositiveButton(str3, cVar);
        builder.setNegativeButton(str4, bVar);
        builder.create().show();
    }

    public String getDefaultErrorPage() {
        return this.f35298a;
    }

    public WebViewLoadCallBack getWebViewLoadCallBack() {
        return this.f35302e;
    }

    @TargetApi(9)
    @Deprecated
    public String[] getWhitelist() {
        String[] strArr = this.f35299b;
        if (strArr == null) {
            return null;
        }
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public String[] getWhitelistNotMatchSubDomain() {
        String[] strArr = this.f35300c;
        if (strArr == null) {
            return null;
        }
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    @Deprecated
    public String[] getWhitelistNotMathcSubDomain() {
        String[] strArr = this.f35300c;
        if (strArr == null) {
            return null;
        }
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    @TargetApi(9)
    public String[] getWhitelistWithPath() {
        String[] strArr = this.f35301d;
        if (strArr == null) {
            return null;
        }
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public void setDefaultErrorPage(String str) {
        this.f35298a = str;
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(new d(this, webViewClient, true, null));
    }

    public void setWebViewLoadCallBack(WebViewLoadCallBack webViewLoadCallBack) {
        this.f35302e = webViewLoadCallBack;
    }

    @TargetApi(9)
    @Deprecated
    public void setWhitelist(String[] strArr) {
        this.f35299b = strArr == null ? null : (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public void setWhitelistNotMatchSubDomain(String[] strArr) {
        this.f35300c = strArr == null ? null : (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    @Deprecated
    public void setWhitelistNotMathcSubDomain(String[] strArr) {
        this.f35300c = strArr == null ? null : (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    @TargetApi(9)
    public void setWhitelistWithPath(String[] strArr) {
        this.f35301d = strArr == null ? null : (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public SafeWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        com.huawei.secure.android.common.webview.b.f(this);
        setWebViewClient(null);
    }

    private boolean b(String str) {
        return URLUtil.isHttpUrl(str);
    }

    @TargetApi(9)
    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            e.l(f35297f, "url is null");
            return false;
        }
        if (!URLUtil.isNetworkUrl(str)) {
            return true;
        }
        String[] whitelistWithPath = getWhitelistWithPath();
        String[] whitelistNotMatchSubDomain = getWhitelistNotMatchSubDomain();
        String[] whitelist = getWhitelist();
        if (whitelistWithPath != null && whitelistWithPath.length != 0) {
            return com.huawei.secure.android.common.webview.d.c(str, whitelistWithPath);
        }
        if (whitelistNotMatchSubDomain != null && whitelistNotMatchSubDomain.length != 0) {
            return com.huawei.secure.android.common.webview.d.h(str, whitelistNotMatchSubDomain);
        }
        return com.huawei.secure.android.common.webview.d.e(str, whitelist);
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (b(str)) {
            if (!TextUtils.isEmpty(this.f35298a)) {
                super.loadDataWithBaseURL(this.f35298a, str2, str3, str4, str5);
                return;
            } else {
                if (getWebViewLoadCallBack() != null) {
                    getWebViewLoadCallBack().a(str, WebViewLoadCallBack.ErrorCode.HTTP_URL);
                    return;
                }
                return;
            }
        }
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // android.webkit.WebView
    public void postUrl(String str, byte[] bArr) {
        if (!c(str)) {
            return;
        }
        if (b(str)) {
            if (!TextUtils.isEmpty(this.f35298a)) {
                super.postUrl(this.f35298a, bArr);
                return;
            } else {
                if (getWebViewLoadCallBack() != null) {
                    getWebViewLoadCallBack().a(str, WebViewLoadCallBack.ErrorCode.HTTP_URL);
                    return;
                }
                return;
            }
        }
        super.postUrl(str, bArr);
    }

    public SafeWebView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        a();
    }

    @TargetApi(21)
    public SafeWebView(Context context, AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        a();
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        if (c(str)) {
            if (b(str)) {
                if (!TextUtils.isEmpty(this.f35298a)) {
                    super.loadUrl(this.f35298a, map);
                    return;
                } else {
                    if (getWebViewLoadCallBack() != null) {
                        getWebViewLoadCallBack().a(str, WebViewLoadCallBack.ErrorCode.HTTP_URL);
                        return;
                    }
                    return;
                }
            }
            super.loadUrl(str, map);
        }
    }
}
