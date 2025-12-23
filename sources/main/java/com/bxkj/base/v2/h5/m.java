package com.bxkj.base.v2.h5;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.BaseApp;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nH5BaseWebViewClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 H5BaseWebViewClient.kt\ncom/bxkj/base/v2/h5/H5BaseWebViewClient\n+ 2 Uri.kt\nandroidx/core/net/UriKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,121:1\n29#2:122\n1#3:123\n*S KotlinDebug\n*F\n+ 1 H5BaseWebViewClient.kt\ncom/bxkj/base/v2/h5/H5BaseWebViewClient\n*L\n60#1:122\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public class m extends SmartWebView.c {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final FragmentActivity f17073c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private SmartWebView f17074d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private String f17075e;

    public m(@NotNull FragmentActivity mActivity, @NotNull SmartWebView smartWebView) {
        g0.p(mActivity, "mActivity");
        g0.p(smartWebView, "smartWebView");
        this.f17073c = mActivity;
        this.f17074d = smartWebView;
        smartWebView.setErrorPage(new ErrorPageView(this.f17074d.getContext(), this.f17074d));
        this.f17075e = "";
    }

    @NotNull
    public final SmartWebView d() {
        return this.f17074d;
    }

    public final void e(@NotNull SmartWebView smartWebView) {
        g0.p(smartWebView, "<set-?>");
        this.f17074d = smartWebView;
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(21)
    @Nullable
    public WebResourceResponse shouldInterceptRequest(@Nullable WebView webView, @NotNull WebResourceRequest request) {
        g0.p(request, "request");
        Map<String, String> requestHeaders = request.getRequestHeaders();
        if (requestHeaders.containsKey("Referer")) {
            this.f17075e = String.valueOf(requestHeaders.get("Referer"));
        }
        return super.shouldInterceptRequest(webView, request);
    }

    @Override // cn.bluemobi.dylan.smartwebview.SmartWebView.c, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(@NotNull WebView webView, @NotNull String url) {
        g0.p(webView, "webView");
        g0.p(url, "url");
        com.orhanobut.logger.j.d("smartWebView.shouldOverrideUrlLoading=" + url, new Object[0]);
        if (u.H2(url, "tel:", false, 2, null)) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
            intent.setFlags(268435456);
            BaseApp.c().startActivity(intent);
            return true;
        }
        if (u.H2(url, "https://wx.tenpay.com", false, 2, null)) {
            HashMap hashMap = new HashMap();
            if (TextUtils.isEmpty(this.f17075e)) {
                webView.loadUrl(url, hashMap);
            } else {
                hashMap.put("referer", this.f17075e);
                webView.loadUrl(url, hashMap);
            }
            return true;
        }
        if (!u.H2(url, "weixin://", false, 2, null) && !u.H2(url, "alipays://", false, 2, null) && !u.H2(url, "upwrp://", false, 2, null)) {
            return false;
        }
        this.f17073c.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
        return true;
    }

    @Override // cn.bluemobi.dylan.smartwebview.SmartWebView.c, android.webkit.WebViewClient
    public void onPageFinished(@Nullable WebView webView, @Nullable String str) {
        super.onPageFinished(webView, str);
        View childAt = this.f17074d.getChildAt(1);
        if (childAt != null) {
            childAt.setVisibility(8);
        }
        n.b(webView);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(@Nullable WebView webView, @Nullable String str, @Nullable Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        n.b(webView);
    }
}
