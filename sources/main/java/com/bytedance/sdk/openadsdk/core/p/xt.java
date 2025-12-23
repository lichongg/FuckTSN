package com.bytedance.sdk.openadsdk.core.p;

import com.bytedance.sdk.component.utils.vl;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class xt {

    /* renamed from: j, reason: collision with root package name */
    private boolean f29844j;

    /* renamed from: r, reason: collision with root package name */
    private JSONObject f29845r;
    private String xt;
    private long cw = 0;
    private boolean up = r.xt;

    public static xt j(JSONObject jSONObject) {
        xt xtVar = new xt();
        if (jSONObject != null) {
            xtVar.j(jSONObject.optString("ec_mall_back_url"));
            xtVar.f29844j = jSONObject.optBoolean("sub_process", false);
            xtVar.cw = jSONObject.optLong("init_delay", r.f29833j);
            xtVar.f29845r = jSONObject.optJSONObject("live_tob_init_extra");
            xtVar.j(jSONObject.optString("ec_mall_back_url"));
            xtVar.up = jSONObject.optBoolean("init_after_click", r.xt);
        }
        return xtVar;
    }

    public JSONObject cw() {
        return this.f29845r;
    }

    public String r() {
        return this.xt;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ec_mall_back_url", this.xt);
            jSONObject.put("sub_process", this.f29844j);
            jSONObject.put("init_delay", this.cw);
            jSONObject.put("live_tob_init_extra", this.f29845r);
            jSONObject.put("init_after_click", this.up);
        } catch (Exception e6) {
            vl.xt("AppLiveConfig", e6);
        }
        return jSONObject.toString();
    }

    public boolean up() {
        return this.up;
    }

    public long xt() {
        return this.cw;
    }

    public boolean j() {
        return this.f29844j;
    }

    public void j(String str) {
        this.xt = str;
    }
}
