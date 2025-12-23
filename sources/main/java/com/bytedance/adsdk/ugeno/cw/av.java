package com.bytedance.adsdk.ugeno.cw;

import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class av {
    private JSONObject cw;

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.adsdk.ugeno.xt.cw f23578j;

    /* renamed from: r, reason: collision with root package name */
    private av f23579r;
    private av up;
    private int xt;

    public com.bytedance.adsdk.ugeno.xt.cw j() {
        return this.f23578j;
    }

    public int xt() {
        return this.xt;
    }

    public JSONObject cw() {
        return this.cw;
    }

    public void j(com.bytedance.adsdk.ugeno.xt.cw cwVar) {
        this.f23578j = cwVar;
    }

    public av r() {
        return this.f23579r;
    }

    public String toString() {
        return "UGenEvent{mWidget=" + this.f23578j + ", mEventType=" + this.xt + ", mEvent=" + this.cw + '}';
    }

    public void xt(av avVar) {
        this.up = avVar;
    }

    public void j(int i6) {
        this.xt = i6;
    }

    public void j(JSONObject jSONObject) {
        this.cw = jSONObject;
    }

    public void j(av avVar) {
        this.f23579r = avVar;
    }
}
