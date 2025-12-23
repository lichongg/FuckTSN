package com.bytedance.sdk.openadsdk.core.tj;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class f {

    /* renamed from: j, reason: collision with root package name */
    int f30263j = 1;
    int xt = 1;

    public void j(int i6) {
        this.f30263j = i6;
    }

    public void xt(int i6) {
        this.xt = i6;
    }

    public JSONObject cw() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ah", this.f30263j);
            jSONObject.put(CommonNetImpl.AM, this.xt);
            return jSONObject;
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.cw(e6.toString());
            return jSONObject;
        }
    }

    public boolean j() {
        return this.f30263j == 1;
    }

    public boolean xt() {
        return this.xt == 1;
    }
}
