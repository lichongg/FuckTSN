package com.bytedance.sdk.openadsdk.core.tj;

import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xp {
    private String ae;
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    private String f30490j;

    /* renamed from: m, reason: collision with root package name */
    private int f30491m;

    /* renamed from: r, reason: collision with root package name */
    private String f30492r;
    private String tl;
    private int up;
    private int xt;

    public String cw() {
        return this.cw;
    }

    public String j() {
        return this.f30490j;
    }

    public String r() {
        return this.f30492r;
    }

    public int up() {
        return this.up;
    }

    public int xt() {
        return this.xt;
    }

    public String ae() {
        return this.ae;
    }

    public void cw(String str) {
        this.f30492r = str;
    }

    public JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wc_skip_type", xt());
            jSONObject.put("wc_miniapp_link", j());
            jSONObject.put("adv_id", cw());
            jSONObject.put("site_id", r());
            jSONObject.put("wc_open_method", m());
            jSONObject.put("wc_miniapp_sdk", ae());
            jSONObject.put("wc_appid", tl());
            return jSONObject;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.xt("toString failed:" + th.getMessage());
            return jSONObject;
        }
    }

    public void j(String str) {
        this.f30490j = str;
    }

    public int m() {
        return this.f30491m;
    }

    public void r(String str) {
        this.ae = str;
    }

    public String tl() {
        return this.tl;
    }

    public void up(String str) {
        this.tl = str;
    }

    public void xt(String str) {
        this.cw = str;
    }

    public void cw(int i6) {
        this.f30491m = i6;
    }

    public void j(int i6) {
        this.xt = i6;
    }

    public String toString() {
        return g().toString();
    }

    public void xt(int i6) {
        this.up = i6;
    }

    public static xp j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        xp xpVar = new xp();
        try {
            xpVar.j(jSONObject.optInt("wc_skip_type"));
            xpVar.j(jSONObject.optString("wc_miniapp_link"));
            xpVar.xt(jSONObject.optString("adv_id"));
            xpVar.cw(jSONObject.optString("site_id"));
            xpVar.cw(jSONObject.optInt("wc_open_method"));
            xpVar.r(jSONObject.optString("wc_miniapp_sdk"));
            xpVar.up(jSONObject.optString("wc_appid"));
            return xpVar;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.xt("parse WechatData failed:" + th.getMessage());
            return xpVar;
        }
    }
}
