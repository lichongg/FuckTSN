package com.bytedance.sdk.openadsdk.core.widget.j;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.rn;
import com.bytedance.sdk.openadsdk.core.rn.kt;
import com.bytedance.sdk.openadsdk.core.tj.gq;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends WebChromeClient {

    /* renamed from: j, reason: collision with root package name */
    private static final String f31207j = WebChromeClient.class.getSimpleName();
    private com.bytedance.sdk.openadsdk.core.jy.r cw;
    private final rn xt;

    public cw(rn rnVar) {
        this.xt = rnVar;
    }

    @Override // android.webkit.WebChromeClient
    public void onConsoleMessage(String str, int i6, String str2) {
        if (!TextUtils.isEmpty(str)) {
            j(str);
        }
        super.onConsoleMessage(str, i6, str2);
    }

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        return Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if (!gq.j(this.xt, 1, str2)) {
            return false;
        }
        jsResult.confirm();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        if (!gq.j(this.xt, 4, str2)) {
            return false;
        }
        jsResult.confirm();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        if (!gq.j(this.xt, 2, str2)) {
            return false;
        }
        jsResult.confirm();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (!gq.j(this.xt, 3, str2)) {
            return false;
        }
        jsPromptResult.confirm();
        return true;
    }

    public cw(rn rnVar, com.bytedance.sdk.openadsdk.core.jy.r rVar) {
        this.xt = rnVar;
        this.cw = rVar;
    }

    private boolean j(String str) {
        oq.i().z();
        try {
            Uri parse = Uri.parse(str);
            if ("bytedance".equals(parse.getScheme().toLowerCase())) {
                kt.j(parse, this.xt);
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i6) {
        com.bytedance.sdk.openadsdk.core.jy.r rVar;
        super.onProgressChanged(webView, i6);
        com.bytedance.sdk.openadsdk.core.jy.r rVar2 = this.cw;
        if (rVar2 != null) {
            rVar2.j(webView, i6);
        }
        if (i6 > 90 && (rVar = this.cw) != null) {
            rVar.j(webView);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        super.onShowCustomView(view, customViewCallback);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage == null || TextUtils.isEmpty(consoleMessage.message()) || !j(consoleMessage.message())) {
            return super.onConsoleMessage(consoleMessage);
        }
        return true;
    }
}
