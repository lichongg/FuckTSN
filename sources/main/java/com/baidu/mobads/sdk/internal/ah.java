package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.view.View;
import android.webkit.WebView;
import com.baidu.mobads.sdk.api.NativeCPUManager;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class ah implements NativeCPUManager.DataPostBackListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Object f10571a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ae f10572b;

    ah(ae aeVar, Object obj) {
        this.f10572b = aeVar;
        this.f10571a = obj;
    }

    @Override // com.baidu.mobads.sdk.api.NativeCPUManager.DataPostBackListener
    public void postback(JSONObject jSONObject) {
        Object obj = this.f10571a;
        if (obj instanceof Activity) {
            View findViewById = ((Activity) obj).findViewById(17);
            if (findViewById instanceof WebView) {
                this.f10572b.a((WebView) findViewById, jSONObject);
            }
        }
    }
}
