package com.bytedance.sdk.component.tl.xt.m;

import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
class r {
    private boolean cw;

    /* renamed from: j, reason: collision with root package name */
    private String f26791j;

    /* renamed from: m, reason: collision with root package name */
    private int f26792m;

    /* renamed from: r, reason: collision with root package name */
    private int f26793r;
    private JSONObject up;
    private String xt;

    public JSONObject j() {
        if (this.up == null) {
            this.up = new JSONObject();
        }
        return this.up;
    }

    public String cw() {
        return this.xt;
    }

    public boolean r() {
        return this.cw;
    }

    public int up() {
        return this.f26793r;
    }

    public String xt() {
        return this.f26791j;
    }

    r(String str, String str2, boolean z5, int i6, JSONObject jSONObject, int i7) {
        this.f26791j = str;
        this.xt = str2;
        this.cw = z5;
        this.f26793r = i6;
        this.up = jSONObject;
        this.f26792m = i7;
    }

    public void j(int i6) {
        this.f26793r = i6;
    }
}
