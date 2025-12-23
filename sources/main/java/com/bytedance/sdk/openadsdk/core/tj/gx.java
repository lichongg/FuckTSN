package com.bytedance.sdk.openadsdk.core.tj;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class gx {
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    private int f30289j;

    /* renamed from: r, reason: collision with root package name */
    private String f30290r;
    private int xt;

    public static gx j(String str) {
        try {
            return j(new JSONObject(str));
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.xt("LiveSdkConfig", "parse failed:".concat(String.valueOf(e6)));
            return new gx();
        }
    }

    public String cw() {
        return this.cw;
    }

    public int xt() {
        return this.xt;
    }

    public void cw(String str) {
        this.f30290r = str;
    }

    public String r() {
        return this.f30290r;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ad_live_status", j());
            jSONObject.put("app_id", xt());
            jSONObject.put("partner", cw());
            jSONObject.put("secure_key", r());
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        return jSONObject.toString();
    }

    public boolean up() {
        return this.f30289j == 1;
    }

    public void xt(int i6) {
        this.xt = i6;
    }

    public void xt(String str) {
        this.cw = str;
    }

    public static gx j(JSONObject jSONObject) {
        gx gxVar = new gx();
        gxVar.j(jSONObject.optInt("ad_live_status"));
        gxVar.xt(jSONObject.optInt("app_id"));
        gxVar.xt(jSONObject.optString("partner"));
        gxVar.cw(jSONObject.optString("secure_key"));
        return gxVar;
    }

    public int j() {
        return this.f30289j;
    }

    public void j(int i6) {
        this.f30289j = i6;
    }
}
