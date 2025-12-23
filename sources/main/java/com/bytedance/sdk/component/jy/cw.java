package com.bytedance.sdk.component.jy;

import android.graphics.Paint;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* loaded from: D:\Downloads\app\classes4.dex */
public interface cw extends xt {
    void addJavascriptInterface(Object obj, String str);

    boolean canGoBack();

    void clearCache(boolean z5);

    void clearHistory();

    void clearView();

    void computeScroll();

    void destroy();

    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    int getContentHeight();

    int getProgress();

    String getUrl();

    String getUserAgentString();

    View getView();

    WebView getWebView();

    void goBack();

    void j(String str, String str2, Object obj);

    void loadUrl(String str);

    void onPause();

    void onResume();

    void pauseTimers();

    void removeAllViews();

    void removeJavascriptInterface(String str);

    void resumeTimers();

    void setAllowFileAccess(boolean z5);

    void setAllowFileAccessFromFileURLs(boolean z5);

    void setAllowUniversalAccessFromFileURLs(boolean z5);

    void setAlpha(float f6);

    void setAppCacheEnabled(boolean z5);

    void setBackgroundColor(int i6);

    void setBackgroundResource(int i6);

    void setBlockNetworkImage(boolean z5);

    void setBuiltInZoomControls(boolean z5);

    void setCacheMode(int i6);

    void setDatabaseEnabled(boolean z5);

    void setDefaultFontSize(int i6);

    void setDefaultTextEncodingName(String str);

    void setDisplayZoomControls(boolean z5);

    void setDomStorageEnabled(boolean z5);

    void setDownloadListener(DownloadListener downloadListener);

    void setJavaScriptCanOpenWindowsAutomatically(boolean z5);

    void setJavaScriptEnabled(boolean z5);

    void setLayerType(int i6, Paint paint);

    void setLayoutAlgorithm(WebSettings.LayoutAlgorithm layoutAlgorithm);

    void setLoadWithOverviewMode(boolean z5);

    void setMediaPlaybackRequiresUserGesture(boolean z5);

    void setMixedContentMode(int i6);

    void setNetworkAvailable(boolean z5);

    void setOnScrollChangeListener(View.OnScrollChangeListener onScrollChangeListener);

    void setOverScrollMode(int i6);

    void setSavePassword(boolean z5);

    void setSupportZoom(boolean z5);

    void setUseWideViewPort(boolean z5);

    void setUserAgentString(String str);

    void setVisibility(int i6);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);
}
