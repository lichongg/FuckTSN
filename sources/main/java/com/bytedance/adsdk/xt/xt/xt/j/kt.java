package com.bytedance.adsdk.xt.xt.xt.j;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class kt implements com.bytedance.adsdk.xt.xt.xt.j {

    /* renamed from: j, reason: collision with root package name */
    private final String f23972j;

    @Override // com.bytedance.adsdk.xt.xt.xt.j
    public Object j(Map<String, JSONObject> map) {
        return this.f23972j;
    }

    @Override // com.bytedance.adsdk.xt.xt.xt.j
    public com.bytedance.adsdk.xt.xt.r.up j() {
        return com.bytedance.adsdk.xt.xt.r.m.STRING;
    }

    @Override // com.bytedance.adsdk.xt.xt.xt.j
    public String xt() {
        return "'" + this.f23972j + "'";
    }

    public kt(String str) {
        this.f23972j = str;
    }

    public String toString() {
        return xt();
    }
}
