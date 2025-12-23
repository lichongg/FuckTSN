package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.baidu.mobads.sdk.api.BaiduHybridAdViewListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IXHybridAdRenderer;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class dh extends bj {

    /* renamed from: a, reason: collision with root package name */
    private WebView f11012a;

    /* renamed from: t, reason: collision with root package name */
    private BaiduHybridAdViewListener f11013t;

    /* renamed from: u, reason: collision with root package name */
    private IXHybridAdRenderer f11014u;

    public void a(BaiduHybridAdViewListener baiduHybridAdViewListener) {
        this.f11013t = baiduHybridAdViewListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void h() {
        IXHybridAdRenderer iXHybridAdRenderer = (IXHybridAdRenderer) av.a(z.f11220j, bt.a(this.f10729i), (Class<?>[]) new Class[]{Context.class}, this.f10729i);
        this.f11014u = iXHybridAdRenderer;
        this.f10733m = iXHybridAdRenderer;
        if (this.f10734n) {
            return;
        }
        a();
    }

    public void a(WebView webView, String str, Bitmap bitmap) {
        IXHybridAdRenderer iXHybridAdRenderer = this.f11014u;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onPageStarted(webView, str, bitmap);
        }
    }

    public boolean b(WebView webView, String str) {
        IXHybridAdRenderer iXHybridAdRenderer = this.f11014u;
        if (iXHybridAdRenderer == null) {
            return false;
        }
        return iXHybridAdRenderer.shouldOverrideUrlLoading(webView, str);
    }

    public dh(WebView webView) {
        super(webView.getContext());
        this.f11012a = webView;
        webView.removeJavascriptInterface("searchBoxJavaBridge_");
        this.f11012a.removeJavascriptInterface("accessibility");
        this.f11012a.removeJavascriptInterface("accessibilityTraversal");
        this.f11012a.getSettings().setAllowContentAccess(false);
        this.f11012a.getSettings().setSavePassword(false);
        this.f11012a.getSettings().setAllowFileAccess(false);
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void q() {
        super.q();
        BaiduHybridAdViewListener baiduHybridAdViewListener = this.f11013t;
        if (baiduHybridAdViewListener != null) {
            baiduHybridAdViewListener.onAdShow(0, null);
        }
    }

    public void a(WebView webView, String str) {
        IXHybridAdRenderer iXHybridAdRenderer = this.f11014u;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onPageFinished(webView, str);
        }
    }

    public void a(WebView webView, int i6, String str, String str2) {
        IXHybridAdRenderer iXHybridAdRenderer = this.f11014u;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onReceivedError(webView, i6, str, str2);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void h(IOAdEvent iOAdEvent) {
        super.h(iOAdEvent);
        BaiduHybridAdViewListener baiduHybridAdViewListener = this.f11013t;
        if (baiduHybridAdViewListener != null) {
            baiduHybridAdViewListener.onAdClick(0, null);
        }
    }

    public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        IXHybridAdRenderer iXHybridAdRenderer = this.f11014u;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a() {
        if (this.f11014u == null) {
            this.f10734n = false;
            return;
        }
        this.f10734n = true;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_JSSDK);
            this.f11014u.createProdHandler(jSONObject3);
            m();
            if (!TextUtils.isEmpty(this.f10737q)) {
                jSONObject.put("appid", this.f10737q);
            }
            jSONObject.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_JSSDK);
            jSONObject2.put("timeout", 10000);
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
        this.f11014u.loadAd(jSONObject, jSONObject2);
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void a(IOAdEvent iOAdEvent) {
        this.f11014u.setCustomerWebView(this.f11012a);
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void a(String str, int i6, String str2) {
        super.a(str, i6, str2);
        BaiduHybridAdViewListener baiduHybridAdViewListener = this.f11013t;
        if (baiduHybridAdViewListener != null) {
            baiduHybridAdViewListener.onAdFailed(0, "", str);
        }
    }
}
