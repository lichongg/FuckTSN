package com.bytedance.sdk.openadsdk.core.live;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.sdk.component.adexpress.up.up;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.l.ae;

/* loaded from: D:\Downloads\app\classes4.dex */
public class EcBackUpWebView extends SSWebView {
    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        setWebViewClient(new WebViewClient() { // from class: com.bytedance.sdk.openadsdk.core.live.EcBackUpWebView.2
            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                boolean didCrash;
                if (Build.VERSION.SDK_INT < 26) {
                    return super.onRenderProcessGone(webView, renderProcessGoneDetail);
                }
                didCrash = renderProcessGoneDetail.didCrash();
                if (didCrash) {
                    if (webView != null) {
                        ViewGroup viewGroup = (ViewGroup) webView.getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(webView);
                        }
                        webView.destroy();
                        up.j().xt();
                    }
                    return true;
                }
                if (webView != null) {
                    ViewGroup viewGroup2 = (ViewGroup) webView.getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(webView);
                    }
                    webView.destroy();
                    up.j().xt();
                }
                return true;
            }
        });
        setWebChromeClient(new WebChromeClient());
        com.bytedance.sdk.openadsdk.core.p.xt ay = v.xt().ay();
        if (ay != null) {
            String r5 = ay.r();
            if (!TextUtils.isEmpty(r5)) {
                loadUrl(r5);
                return;
            }
        }
        loadUrl("https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/pattern-aggregation/pattern-aggregation-eCommerce-abtest/shoppingMall-defaultPage/index.html");
    }

    public EcBackUpWebView(Context context) {
        super(context);
        ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.live.EcBackUpWebView.1
            @Override // java.lang.Runnable
            public void run() {
                EcBackUpWebView.this.m();
            }
        });
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        super.destroy();
    }
}
