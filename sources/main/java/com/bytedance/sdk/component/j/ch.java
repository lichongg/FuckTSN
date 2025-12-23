package com.bytedance.sdk.component.j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ch extends j {
    static final /* synthetic */ boolean oq = true;

    /* renamed from: g, reason: collision with root package name */
    protected com.bytedance.sdk.component.jy.cw f26478g;
    protected String tl;

    @Override // com.bytedance.sdk.component.j.j
    protected String j() {
        return this.f26478g.getUrl();
    }

    @SuppressLint({"AddJavascriptInterface"})
    protected void cw() {
        if (!oq && this.f26478g == null) {
            throw new AssertionError();
        }
        com.bytedance.sdk.component.jy.cw cwVar = this.f26478g;
        if (cwVar != null) {
            cwVar.addJavascriptInterface(this, this.tl);
        }
    }

    @Override // com.bytedance.sdk.component.j.j
    protected Context getContext(oq oqVar) {
        Context context = oqVar.up;
        if (context != null) {
            return context;
        }
        com.bytedance.sdk.component.jy.cw cwVar = oqVar.f26498j;
        if (cwVar != null) {
            View view = cwVar.getView();
            if (view != null) {
                return view.getContext();
            }
            WebView webView = oqVar.f26498j.getWebView();
            if (webView != null) {
                return webView.getContext();
            }
        }
        throw new IllegalStateException("WebView cannot be null!");
    }

    @Override // com.bytedance.sdk.component.j.j
    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    protected void j(oq oqVar) {
        this.f26478g = oqVar.f26498j;
        this.tl = oqVar.cw;
        if (oqVar.ws) {
            return;
        }
        cw();
    }

    protected void r() {
        com.bytedance.sdk.component.jy.cw cwVar = this.f26478g;
        if (cwVar != null) {
            cwVar.removeJavascriptInterface(this.tl);
        }
    }

    @Override // com.bytedance.sdk.component.j.j
    @JavascriptInterface
    public void invokeMethod(String str) {
        super.invokeMethod(str);
    }

    @Override // com.bytedance.sdk.component.j.j
    protected void xt() {
        super.xt();
        r();
    }

    private void j(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.f26489r.post(runnable);
        }
    }

    @Override // com.bytedance.sdk.component.j.j
    protected void j(String str, av avVar) {
        if (avVar != null && !TextUtils.isEmpty(avVar.tl)) {
            String str2 = avVar.tl;
            j(str, String.format("javascript:(function(){   const iframe = document.querySelector(atob('%s'));   if (iframe && iframe.contentWindow) {        iframe.contentWindow.postMessage(%s, atob('%s'));   }})()", Base64.encodeToString(String.format("iframe[src=\"%s\"", str2).getBytes(), 2), str, Base64.encodeToString(str2.getBytes(), 2)));
            return;
        }
        super.j(str, avVar);
    }

    @Override // com.bytedance.sdk.component.j.j
    protected void j(String str) {
        j(str, "javascript:" + this.tl + "._handleMessageFromToutiao(" + str + ")");
    }

    private void j(String str, final String str2) {
        if (this.f26488m || TextUtils.isEmpty(str2)) {
            return;
        }
        j(new Runnable() { // from class: com.bytedance.sdk.component.j.ch.1
            @Override // java.lang.Runnable
            public void run() {
                if (ch.this.f26488m) {
                    return;
                }
                try {
                    g.j("Invoking Jsb using evaluateJavascript: " + str2);
                    ch.this.f26478g.evaluateJavascript(str2, null);
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.vl.j(th);
                }
            }
        });
    }
}
