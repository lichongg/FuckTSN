package com.bytedance.sdk.openadsdk.core.i.j;

import com.bytedance.sdk.component.widget.SSWebView;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ch extends com.bytedance.sdk.component.j.up<JSONObject, JSONObject> {

    /* renamed from: j, reason: collision with root package name */
    private SSWebView f29129j;
    private String xt;

    public static void j(com.bytedance.sdk.component.j.i iVar, SSWebView sSWebView, String str) {
        iVar.j("close_wobble_observer", (com.bytedance.sdk.component.j.up<?, ?>) new ch(sSWebView, str));
    }

    public JSONObject cw() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.bytedance.sdk.openadsdk.core.oq.i().j(com.bytedance.sdk.openadsdk.core.v.getContext()) && this.f29129j != null) {
                jSONObject.put("code", 0);
                jSONObject.put("codeMsg", "success");
                this.f29129j.I_();
                return jSONObject;
            }
            jSONObject.put("code", -1);
            jSONObject.put("codeMsg", "unavailable");
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public ch(SSWebView sSWebView, String str) {
        this.f29129j = sSWebView;
        this.xt = str;
    }

    @Override // com.bytedance.sdk.component.j.up
    public JSONObject j(JSONObject jSONObject, com.bytedance.sdk.component.j.m mVar) throws Exception {
        return cw();
    }
}
