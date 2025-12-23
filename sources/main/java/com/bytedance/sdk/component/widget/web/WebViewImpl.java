package com.bytedance.sdk.component.widget.web;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.sdk.component.jy.cw;
import com.bytedance.sdk.component.jy.xt;
import com.bytedance.sdk.component.utils.tl;
import com.bytedance.sdk.component.widget.SSWebView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import master.flame.danmaku.danmaku.parser.b;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class WebViewImpl extends BaseWebView implements cw {

    /* renamed from: h, reason: collision with root package name */
    private static boolean f27188h;
    private volatile boolean gq;
    private Map<String, j> la;
    private final com.bytedance.sdk.component.jy.j rn;

    public WebViewImpl(com.bytedance.sdk.component.jy.j jVar, Context context) {
        super(j(context));
        this.gq = false;
        this.rn = jVar;
        xt(context);
    }

    private void cw(Context context) {
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.webkit.WebView
    @TargetApi(19)
    public void loadUrl(final String str, final Map<String, String> map) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.23
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.setJavaScriptEnabled(str);
                    WebViewImpl.super.loadUrl(str, map);
                    com.bytedance.sdk.component.widget.xt xtVar = WebViewImpl.this.xt;
                    if (xtVar != null) {
                        xtVar.j(str);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setJavaScriptEnabled(final boolean z5) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.20
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.f27126a = Boolean.valueOf(z5);
                    WebViewImpl.this.getSettings().setJavaScriptEnabled(z5);
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJavaScriptEnabled(String str) {
        WebSettings settings;
        try {
            if (!TextUtils.isEmpty(str) && (settings = getSettings()) != null && !f27188h) {
                if (Uri.parse(str).getScheme().equals(b.f50156c)) {
                    settings.setJavaScriptEnabled(false);
                } else {
                    settings.setJavaScriptEnabled(true);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.jy.cw
    @SuppressLint({"JavascriptInterface"})
    public void addJavascriptInterface(final Object obj, final String str) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.19
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (WebViewImpl.this.la == null) {
                        WebViewImpl.this.la = new HashMap();
                    }
                    xt xtVar = new xt(obj, str, WebViewImpl.this.rn, WebViewImpl.this);
                    WebViewImpl.this.hashCode();
                    WebViewImpl.super.addJavascriptInterface(xtVar, str);
                    WebViewImpl.this.la.put(str, xtVar);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.jy.cw
    public void clearCache(final boolean z5) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.clearCache(z5);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void clearFormData() {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.clearFormData();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.jy.cw
    public void clearHistory() {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.clearHistory();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.jy.cw
    public void clearView() {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.47
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.clearView();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, android.view.View, com.bytedance.sdk.component.jy.cw
    public void computeScroll() {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.16
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.computeScroll();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.widget.web.BaseWebView, android.webkit.WebView
    public void destroy() {
        if (this.gq) {
            return;
        }
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.27
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (WebViewImpl.this.gq) {
                        return;
                    }
                    WebViewImpl.this.xt();
                    if (WebViewImpl.this.la != null) {
                        Iterator it = WebViewImpl.this.la.keySet().iterator();
                        while (it.hasNext()) {
                            WebViewImpl.super.removeJavascriptInterface((String) it.next());
                        }
                        WebViewImpl.this.la = null;
                    }
                    WebViewImpl.super.destroy();
                    WebViewImpl.this.hashCode();
                    WebViewImpl.this.rn.hashCode();
                    WebViewImpl.this.gq = true;
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.jy.cw
    public void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.26
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.evaluateJavascript(str, valueCallback);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.widget.web.BaseWebView
    public WebChromeClient getChromeClient() {
        return this.cw;
    }

    @Override // com.bytedance.sdk.component.widget.web.BaseWebView
    public com.bytedance.sdk.component.widget.xt getClient() {
        return this.xt;
    }

    @Override // com.bytedance.sdk.component.widget.web.BaseWebView
    public Map<String, j> getJavascriptInterfaces() {
        return this.la;
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.jy.cw
    public void goBack() {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.goBack();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void goBackOrForward(final int i6) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.goBackOrForward(i6);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void goForward() {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.goForward();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void loadData(final String str, final String str2, final String str3) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.56
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.loadData(str, str2, str3);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(final String str, final String str2, final String str3, final String str4, final String str5) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.58
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.setJavaScriptEnabled(str);
                    WebViewImpl.super.loadDataWithBaseURL(str, str2, str3, str4, str5);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.jy.cw
    public void loadUrl(final String str) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.34
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.setJavaScriptEnabled(str);
                    WebViewImpl.super.loadUrl(str);
                    com.bytedance.sdk.component.widget.xt xtVar = WebViewImpl.this.xt;
                    if (xtVar != null) {
                        xtVar.j(str);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.jy.cw
    public void onPause() {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.24
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.onPause();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.jy.cw
    public void onResume() {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.4
            @Override // java.lang.Runnable
            public void run() {
                WebViewImpl.super.onResume();
            }
        });
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Pair<Boolean, Boolean> j6;
        xt.j jVar = this.f27133p;
        return (jVar == null || (j6 = jVar.j(this, motionEvent)) == null || !((Boolean) j6.first).booleanValue()) ? super.onTouchEvent(motionEvent) : ((Boolean) j6.second).booleanValue();
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.jy.cw
    public void pauseTimers() {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.48
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.pauseTimers();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void postUrl(final String str, final byte[] bArr) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.45
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.setJavaScriptEnabled(str);
                    WebViewImpl.super.postUrl(str, bArr);
                    com.bytedance.sdk.component.widget.xt xtVar = WebViewImpl.this.xt;
                    if (xtVar != null) {
                        xtVar.j(str);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void reload() {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.60
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.reload();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.view.ViewGroup, com.bytedance.sdk.component.jy.cw
    public void removeAllViews() {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.50
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.removeAllViews();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.jy.cw
    public void removeJavascriptInterface(final String str) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.28
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (WebViewImpl.this.gq) {
                        return;
                    }
                    WebViewImpl.this.hashCode();
                    WebViewImpl.super.removeJavascriptInterface(str);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.jy.cw
    public void resumeTimers() {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.49
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.resumeTimers();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setAllowFileAccess(final boolean z5) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.46
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.vl = Boolean.valueOf(z5);
                    WebViewImpl.this.getSettings().setAllowFileAccess(z5);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setAllowFileAccessFromFileURLs(final boolean z5) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.52
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.oq = Boolean.valueOf(z5);
                    WebViewImpl.this.getSettings().setAllowFileAccessFromFileURLs(z5);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setAllowUniversalAccessFromFileURLs(final boolean z5) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.53
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.f27128g = Boolean.valueOf(z5);
                    WebViewImpl.this.getSettings().setAllowUniversalAccessFromFileURLs(z5);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setAppCacheEnabled(final boolean z5) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.29
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.f27138x = Boolean.valueOf(z5);
                    WebViewImpl.this.getSettings().setAppCacheEnabled(z5);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, android.view.View, com.bytedance.sdk.component.jy.cw
    public void setBackgroundColor(final int i6) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.15
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.up = Integer.valueOf(i6);
                    WebViewImpl.super.setBackgroundColor(i6);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setBlockNetworkImage(final boolean z5) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.51
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.qv = Boolean.valueOf(z5);
                    WebViewImpl.this.getSettings().setBlockNetworkImage(z5);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setBuiltInZoomControls(final boolean z5) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.35
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.mi = Boolean.valueOf(z5);
                    WebViewImpl.this.getSettings().setBuiltInZoomControls(z5);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setCacheMode(final int i6) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.22
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.ch = Integer.valueOf(i6);
                    WebViewImpl.this.getSettings().setCacheMode(i6);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setDatabaseEnabled(final boolean z5) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.42
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.jy = Boolean.valueOf(z5);
                    WebViewImpl.this.getSettings().setDatabaseEnabled(z5);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setDefaultFontSize(final int i6) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.40
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.az = Integer.valueOf(i6);
                    WebViewImpl.this.getSettings().setDefaultFontSize(i6);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setDefaultTextEncodingName(final String str) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.39
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl webViewImpl = WebViewImpl.this;
                    webViewImpl.av = str;
                    webViewImpl.getSettings().setDefaultTextEncodingName(str);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setDisplayZoomControls(final boolean z5) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.21
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.f27135s = Boolean.valueOf(z5);
                    WebViewImpl.this.getSettings().setDisplayZoomControls(z5);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setDomStorageEnabled(final boolean z5) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.33
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.kt = Boolean.valueOf(z5);
                    WebViewImpl.this.getSettings().setDomStorageEnabled(z5);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.jy.cw
    public void setDownloadListener(final DownloadListener downloadListener) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.13
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl webViewImpl = WebViewImpl.this;
                    DownloadListener downloadListener2 = downloadListener;
                    webViewImpl.f27134r = downloadListener2;
                    WebViewImpl.super.setDownloadListener(downloadListener2);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setJavaScriptCanOpenWindowsAutomatically(final boolean z5) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.32
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.tj = Boolean.valueOf(z5);
                    WebViewImpl.this.getSettings().setJavaScriptCanOpenWindowsAutomatically(z5);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, android.view.View, com.bytedance.sdk.component.jy.cw
    public void setLayerType(final int i6, final Paint paint) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.17
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.setLayerType(i6, paint);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setLayoutAlgorithm(final WebSettings.LayoutAlgorithm layoutAlgorithm) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.36
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl webViewImpl = WebViewImpl.this;
                    webViewImpl.f27137w = layoutAlgorithm;
                    webViewImpl.getSettings().setLayoutAlgorithm(layoutAlgorithm);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setLoadWithOverviewMode(final boolean z5) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.37
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.f27129i = Boolean.valueOf(z5);
                    WebViewImpl.this.getSettings().setLoadWithOverviewMode(z5);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setMediaPlaybackRequiresUserGesture(final boolean z5) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.55
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.ae = Boolean.valueOf(z5);
                    WebViewImpl.this.getSettings().setMediaPlaybackRequiresUserGesture(z5);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setMixedContentMode(final int i6) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.41
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.ws = Integer.valueOf(i6);
                    WebViewImpl.this.getSettings().setMixedContentMode(i6);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.jy.cw
    public void setNetworkAvailable(final boolean z5) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.12
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.f27131l = Boolean.valueOf(z5);
                    WebViewImpl.super.setNetworkAvailable(z5);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.view.View, com.bytedance.sdk.component.jy.cw
    public void setOnScrollChangeListener(final View.OnScrollChangeListener onScrollChangeListener) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.57
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (Build.VERSION.SDK_INT >= 23) {
                        WebViewImpl webViewImpl = WebViewImpl.this;
                        View.OnScrollChangeListener onScrollChangeListener2 = onScrollChangeListener;
                        webViewImpl.f27132m = onScrollChangeListener2;
                        WebViewImpl.super.setOnScrollChangeListener(onScrollChangeListener2);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setSavePassword(final boolean z5) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.54
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.tl = Boolean.valueOf(z5);
                    WebViewImpl.this.getSettings().setSavePassword(z5);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setSupportZoom(final boolean z5) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.30
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.f27127f = Boolean.valueOf(z5);
                    WebViewImpl.this.getSettings().setSupportZoom(z5);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.jy.xt
    public void setTouchEventListener(xt.j jVar) {
        this.f27133p = jVar;
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setUseWideViewPort(final boolean z5) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.31
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.f27136v = Boolean.valueOf(z5);
                    WebViewImpl.this.getSettings().setUseWideViewPort(z5);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setUserAgentString(final String str) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.38
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.getSettings().setUserAgentString(str);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.view.View, com.bytedance.sdk.component.jy.cw
    public void setVisibility(final int i6) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.43
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.setVisibility(i6);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.jy.cw
    public void setWebChromeClient(final WebChromeClient webChromeClient) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl webViewImpl = WebViewImpl.this;
                    WebChromeClient webChromeClient2 = webChromeClient;
                    webViewImpl.cw = webChromeClient2;
                    WebViewImpl.super.setWebChromeClient(webChromeClient2);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.jy.cw
    public void setWebViewClient(final WebViewClient webViewClient) {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.11
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewClient webViewClient2 = webViewClient;
                    if (webViewClient2 == null) {
                        webViewClient2 = new SSWebView.j();
                    } else if (webViewClient2 instanceof com.bytedance.sdk.component.widget.xt) {
                        webViewClient2 = ((com.bytedance.sdk.component.widget.xt) webViewClient2).j();
                    }
                    WebViewImpl.this.xt = new com.bytedance.sdk.component.widget.xt(webViewClient2);
                    WebViewImpl webViewImpl = WebViewImpl.this;
                    WebViewImpl.super.setWebViewClient(webViewImpl.xt);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void stopLoading() {
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.59
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.stopLoading();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.jy.cw
    public boolean canGoBack() {
        if (j()) {
            try {
                return super.canGoBack();
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    @Override // android.webkit.WebView
    public boolean canGoBackOrForward(int i6) {
        try {
            return super.canGoBackOrForward(i6);
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // android.webkit.WebView
    public boolean canGoForward() {
        try {
            return super.canGoForward();
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.jy.cw
    public int getContentHeight() {
        if (j()) {
            try {
                return super.getContentHeight();
            } catch (Throwable unused) {
                return 1;
            }
        }
        final Object obj = new Object();
        final int[] iArr = {-1};
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.7
            @Override // java.lang.Runnable
            public void run() {
                iArr[0] = WebViewImpl.super.getContentHeight();
                synchronized (obj) {
                    obj.notifyAll();
                }
            }
        });
        try {
            if (iArr[0] < 0) {
                synchronized (obj) {
                    obj.wait(5000L);
                }
            }
        } catch (InterruptedException unused2) {
        }
        return iArr[0];
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.jy.cw
    public int getProgress() {
        if (j()) {
            try {
                return super.getProgress();
            } catch (Throwable unused) {
                return 100;
            }
        }
        final Object obj = new Object();
        final int[] iArr = {-1};
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.6
            @Override // java.lang.Runnable
            public void run() {
                iArr[0] = WebViewImpl.super.getProgress();
                synchronized (obj) {
                    obj.notifyAll();
                }
            }
        });
        try {
            if (iArr[0] < 0) {
                synchronized (obj) {
                    obj.wait(5000L);
                }
            }
        } catch (InterruptedException unused2) {
        }
        return iArr[0];
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.jy.cw
    public String getUrl() {
        if (j()) {
            try {
                return super.getUrl();
            } catch (Throwable unused) {
            }
        }
        com.bytedance.sdk.component.widget.xt xtVar = this.xt;
        if (xtVar != null) {
            return xtVar.xt();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public String getUserAgentString() {
        if (j()) {
            try {
                return getSettings().getUserAgentString();
            } catch (Throwable unused) {
                return "";
            }
        }
        final Object obj = new Object();
        final String[] strArr = {""};
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.25
            @Override // java.lang.Runnable
            public void run() {
                strArr[0] = WebViewImpl.this.getSettings().getUserAgentString();
                synchronized (obj) {
                    obj.notifyAll();
                }
            }
        });
        try {
            String str = strArr[0];
            if (str == null || str.length() == 0) {
                synchronized (obj) {
                    obj.wait(5000L);
                }
            }
        } catch (InterruptedException unused2) {
        }
        return strArr[0];
    }

    @Override // android.view.View, com.bytedance.sdk.component.jy.cw
    public void setAlpha(final float f6) {
        super.setAlpha(f6);
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.44
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.setAlpha(f6);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, android.view.View, com.bytedance.sdk.component.jy.cw
    public void setOverScrollMode(final int i6) {
        super.setOverScrollMode(i6);
        tl.xt().post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.18
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.setOverScrollMode(i6);
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void r() {
        try {
            WebSettings settings = getSettings();
            if (settings != null) {
                settings.setSavePassword(false);
            }
        } catch (Throwable unused) {
        }
    }

    public WebViewImpl(com.bytedance.sdk.component.jy.j jVar, Context context, AttributeSet attributeSet) {
        super(j(context), attributeSet);
        this.gq = false;
        this.rn = jVar;
        xt(context);
    }

    private void xt(Context context) {
        cw(context);
        r();
        cw();
    }

    private void cw() {
        try {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.widget.web.BaseWebView
    public void xt() {
        super.xt();
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.1
            @Override // java.lang.Runnable
            @SuppressLint({"[ByDesign3.3]AvoidContentOrFileExecuteJS", "SetJavaScriptEnabled"})
            public void run() {
                try {
                    WebSettings settings = WebViewImpl.this.getSettings();
                    WebViewImpl.this.removeAllViews();
                    WebViewImpl.this.stopLoading();
                    WebViewImpl.this.setWebChromeClient(null);
                    WebViewImpl.this.setWebViewClient(null);
                    WebViewImpl.this.setDownloadListener(null);
                    settings.setJavaScriptEnabled(true);
                    settings.setAppCacheEnabled(false);
                    settings.setSupportZoom(false);
                    settings.setUseWideViewPort(true);
                    settings.setJavaScriptCanOpenWindowsAutomatically(true);
                    settings.setDomStorageEnabled(true);
                    settings.setBuiltInZoomControls(false);
                    settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
                    settings.setLoadWithOverviewMode(false);
                    settings.setDefaultTextEncodingName("UTF-8");
                    settings.setDefaultFontSize(16);
                    if (WebViewImpl.this.la != null) {
                        Iterator it = WebViewImpl.this.la.keySet().iterator();
                        while (it.hasNext()) {
                            WebViewImpl.this.removeJavascriptInterface((String) it.next());
                        }
                        WebViewImpl.this.la = null;
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    public WebViewImpl(com.bytedance.sdk.component.jy.j jVar, Context context, AttributeSet attributeSet, int i6) {
        super(j(context), attributeSet, i6);
        this.gq = false;
        this.rn = jVar;
        xt(context);
    }

    private static Context j(Context context) {
        return Build.VERSION.SDK_INT < 23 ? context.createConfigurationContext(new Configuration()) : context;
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public View getView() {
        return this;
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public WebView getWebView() {
        return this;
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void j(String str, String str2, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("event", str2);
            jSONObject.putOpt("param", obj);
            xt(str, "csjEventListener", jSONObject);
        } catch (JSONException unused) {
        }
    }
}
