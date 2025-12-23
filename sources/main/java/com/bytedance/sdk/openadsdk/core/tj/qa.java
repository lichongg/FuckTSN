package com.bytedance.sdk.openadsdk.core.tj;

import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class qa {
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    private JSONObject f30399j;

    /* renamed from: r, reason: collision with root package name */
    private String f30400r;
    private boolean up;
    private int xt;

    public JSONObject j() {
        return this.f30399j;
    }

    public int cw() {
        return this.xt;
    }

    public void j(boolean z5) {
        this.up = z5;
    }

    public boolean m() {
        return this.up;
    }

    public String r() {
        return this.cw;
    }

    public String up() {
        return this.f30400r;
    }

    public JSONObject xt() {
        return this.f30399j;
    }

    public qa(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f30399j = jSONObject;
            this.xt = jSONObject.optInt("dialog_type");
            this.cw = jSONObject.optString("template_url");
            this.f30400r = jSONObject.optString("template_md5");
        }
        com.bytedance.sdk.openadsdk.core.ugeno.m.j jVar = new com.bytedance.sdk.openadsdk.core.ugeno.m.j();
        jVar.xt(up());
        jVar.cw(r());
    }
}
