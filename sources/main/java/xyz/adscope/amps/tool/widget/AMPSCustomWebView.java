package xyz.adscope.amps.tool.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import master.flame.danmaku.danmaku.parser.b;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.common.tool.LogUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSCustomWebView extends WebView {
    public AMPSCustomWebView(Context context) {
        super(context);
        init();
    }

    private void setAdScopeWebViewClient() {
        setWebViewClient(new WebViewClient() { // from class: xyz.adscope.amps.tool.widget.AMPSCustomWebView.1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                LogUtil.i("AdscopeWebView_", "url : " + str);
                if (!TextUtils.isEmpty(str) && str.startsWith(b.f50154a)) {
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                AMPSCustomWebView.this.showJumpPromptDialog(webView.getContext(), str);
                return true;
            }
        });
    }

    public AMPSCustomWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        try {
            setWebViewSettings();
            setAdScopeWebViewClient();
        } catch (Throwable th) {
            LogUtil.e(AMPSConstants.AMPS_LOG_TAG, "e : " + th);
        }
    }

    private void openNativeIntent(String str) {
        Uri parse;
        if (TextUtils.isEmpty(str)) {
            parse = null;
        } else {
            parse = Uri.parse(str);
        }
        if (parse == null) {
            LogUtil.i(AMPSConstants.AMPS_LOG_TAG, "Failed to launch custom protocol: " + str);
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", parse);
        intent.setFlags(268435456);
        try {
            getContext().startActivity(intent);
            destroy();
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).finish();
            }
        } catch (Exception e6) {
            LogUtil.e(AMPSConstants.AMPS_LOG_TAG, "e : " + e6);
        }
    }

    private void setWebViewSettings() {
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
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setMixedContentMode(0);
        WebView.setWebContentsDebuggingEnabled(false);
        settings.setAppCachePath(getContext().getCacheDir().getAbsolutePath());
        settings.setAppCacheEnabled(true);
        settings.setCacheMode(-1);
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        CookieManager cookieManager = CookieManager.getInstance();
        if (cookieManager != null) {
            cookieManager.setAcceptThirdPartyCookies(this, true);
        }
        setHorizontalScrollbarOverlay(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setScrollBarStyle(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showJumpPromptDialog(Context context, String str) {
        try {
            if (!TextUtils.isEmpty(str) && context != null) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.setFlags(268435456);
                context.startActivity(intent);
            }
        } catch (Throwable th) {
            LogUtil.e(AMPSConstants.AMPS_LOG_TAG, "e : " + th);
        }
    }

    public AMPSCustomWebView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        init();
    }

    public AMPSCustomWebView(Context context, AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        init();
    }
}
