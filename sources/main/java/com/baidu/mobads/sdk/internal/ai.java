package com.baidu.mobads.sdk.internal;

import android.webkit.WebView;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class ai implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ JSONObject f10573a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ WebView f10574b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ae f10575c;

    ai(ae aeVar, JSONObject jSONObject, WebView webView) {
        this.f10575c = aeVar;
        this.f10573a = jSONObject;
        this.f10574b = webView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f10573a == null || this.f10574b == null) {
            return;
        }
        this.f10574b.loadUrl("javascript:window.sdkCallback.userInteractCb(\"" + this.f10573a.toString().replace("\"", "\\\"") + "\")");
    }
}
