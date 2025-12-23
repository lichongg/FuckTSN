package com.bytedance.sdk.openadsdk.core.i.j;

import com.bytedance.sdk.component.widget.SSWebView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class v extends com.bytedance.sdk.component.j.up<JSONObject, JSONObject> {

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<SSWebView> f29162j;

    public static void j(com.bytedance.sdk.component.j.i iVar, SSWebView sSWebView) {
        iVar.j("preventTouchEvent", (com.bytedance.sdk.component.j.up<?, ?>) new v(sSWebView));
    }

    public v(SSWebView sSWebView) {
        this.f29162j = new WeakReference<>(sSWebView);
    }

    @Override // com.bytedance.sdk.component.j.up
    public JSONObject j(JSONObject jSONObject, com.bytedance.sdk.component.j.m mVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        try {
            boolean optBoolean = jSONObject.optBoolean("isPrevent", false);
            SSWebView sSWebView = this.f29162j.get();
            if (sSWebView != null) {
                sSWebView.setIsPreventTouchEvent(optBoolean);
                jSONObject2.put("success", true);
                return jSONObject2;
            }
            jSONObject2.put("success", false);
            return jSONObject2;
        } catch (Throwable unused) {
            jSONObject2.put("success", false);
            return jSONObject2;
        }
    }
}
