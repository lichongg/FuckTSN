package com.bytedance.adsdk.xt.xt.xt.j;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class mi implements com.bytedance.adsdk.xt.xt.xt.xt {
    private com.bytedance.adsdk.xt.xt.xt.j cw;

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.adsdk.xt.xt.xt.j f23973j;
    private com.bytedance.adsdk.xt.xt.xt.j xt;

    @Override // com.bytedance.adsdk.xt.xt.xt.j
    public Object j(Map<String, JSONObject> map) {
        Object j6 = this.f23973j.j(map);
        if (j6 == null) {
            return null;
        }
        return ((Boolean) j6).booleanValue() ? this.xt.j(map) : this.cw.j(map);
    }

    @Override // com.bytedance.adsdk.xt.xt.xt.xt
    public void xt(com.bytedance.adsdk.xt.xt.xt.j jVar) {
        this.xt = jVar;
    }

    @Override // com.bytedance.adsdk.xt.xt.xt.xt
    public void cw(com.bytedance.adsdk.xt.xt.xt.j jVar) {
        this.cw = jVar;
    }

    @Override // com.bytedance.adsdk.xt.xt.xt.j
    public String xt() {
        return this.f23973j.xt() + "?" + this.xt.xt() + ":" + this.cw.xt();
    }

    public String toString() {
        return xt();
    }

    @Override // com.bytedance.adsdk.xt.xt.xt.j
    public com.bytedance.adsdk.xt.xt.r.up j() {
        return com.bytedance.adsdk.xt.xt.r.m.OPERATOR_RESULT;
    }

    @Override // com.bytedance.adsdk.xt.xt.xt.xt
    public void j(com.bytedance.adsdk.xt.xt.xt.j jVar) {
        this.f23973j = jVar;
    }
}
