package com.bytedance.sdk.openadsdk.core.ugeno.g;

import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    private JSONObject cw;

    /* renamed from: j, reason: collision with root package name */
    private JSONArray f30734j;

    /* renamed from: r, reason: collision with root package name */
    private JSONObject f30735r;
    private JSONObject up;
    private JSONObject xt;

    public JSONObject cw() {
        return this.cw;
    }

    public JSONArray j() {
        return this.f30734j;
    }

    public JSONObject r() {
        return this.f30735r;
    }

    public JSONObject xt() {
        return this.xt;
    }

    public void cw(JSONObject jSONObject) {
        this.f30735r = jSONObject;
    }

    public void j(JSONArray jSONArray) {
        this.f30734j = jSONArray;
    }

    public void r(JSONObject jSONObject) {
        this.up = jSONObject;
    }

    public JSONObject up() {
        return this.up;
    }

    public void xt(JSONObject jSONObject) {
        this.cw = jSONObject;
    }

    public void j(JSONObject jSONObject) {
        this.xt = jSONObject;
    }
}
