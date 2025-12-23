package com.baidu.mobads.sdk.api;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import com.baidu.mobads.sdk.internal.dh;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class BaiduHybridAdManager {
    private dh mAdProd;
    private String mAppSid;
    private WebView mWebView;
    private BaiduHybridAdViewListener mBaiduHybridAdViewListener = new BaiduHybridAdViewListener() { // from class: com.baidu.mobads.sdk.api.BaiduHybridAdManager.1
        @Override // com.baidu.mobads.sdk.api.BaiduHybridAdViewListener
        public void onAdClick(int i6, String str) {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduHybridAdViewListener
        public void onAdShow(int i6, String str) {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduHybridAdViewListener
        public void onAdFailed(int i6, String str, String str2) {
        }
    };
    private boolean mAppPageReceivedError = false;

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.mAppPageReceivedError = false;
    }

    public void onReceivedError(WebView webView, int i6, String str, String str2) {
        this.mAppPageReceivedError = true;
    }

    public void injectJavaScriptBridge(WebView webView) {
        if (this.mAppPageReceivedError) {
            return;
        }
        this.mWebView = webView;
        dh dhVar = new dh(this.mWebView);
        this.mAdProd = dhVar;
        dhVar.h(this.mAppSid);
        this.mAdProd.a(this.mBaiduHybridAdViewListener);
        this.mAdProd.a();
    }

    public void setAppSid(String str) {
        this.mAppSid = str;
    }

    public void setBaiduHybridAdViewListener(BaiduHybridAdViewListener baiduHybridAdViewListener) {
        this.mBaiduHybridAdViewListener = baiduHybridAdViewListener;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        dh dhVar;
        if (!this.mAppPageReceivedError && (dhVar = this.mAdProd) != null) {
            dhVar.b(webView, str);
        }
        try {
            Uri parse = Uri.parse(str);
            if ("mobadssdk".equals(parse.getScheme())) {
                return true;
            }
            return "mobads".equals(parse.getScheme());
        } catch (Exception unused) {
            System.err.getClass();
            return false;
        }
    }
}
