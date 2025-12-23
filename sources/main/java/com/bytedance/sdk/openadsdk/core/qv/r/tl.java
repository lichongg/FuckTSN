package com.bytedance.sdk.openadsdk.core.qv.r;

import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tl {
    private JSONObject cw;

    /* renamed from: j, reason: collision with root package name */
    private String f29984j;

    /* renamed from: r, reason: collision with root package name */
    private JSONObject f29985r;
    private String xt;

    public static tl j() {
        return new tl();
    }

    public tl xt(String str) {
        this.xt = str;
        return this;
    }

    public String cw() {
        return this.xt;
    }

    public tl j(JSONObject jSONObject) {
        this.f29985r = jSONObject;
        return this;
    }

    public JSONObject r() {
        return this.cw;
    }

    public JSONObject up() {
        return this.f29985r;
    }

    public tl xt(JSONObject jSONObject) {
        this.cw = jSONObject;
        return this;
    }

    public tl j(String str) {
        this.f29984j = str;
        return this;
    }

    public String xt() {
        return this.f29984j;
    }
}
