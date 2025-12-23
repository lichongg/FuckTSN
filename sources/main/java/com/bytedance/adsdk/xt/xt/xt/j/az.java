package com.bytedance.adsdk.xt.xt.xt.j;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class az implements com.bytedance.adsdk.xt.xt.xt.j {

    /* renamed from: j, reason: collision with root package name */
    private Number f23969j;

    @Override // com.bytedance.adsdk.xt.xt.xt.j
    public Object j(Map<String, JSONObject> map) {
        return this.f23969j;
    }

    @Override // com.bytedance.adsdk.xt.xt.xt.j
    public com.bytedance.adsdk.xt.xt.r.up j() {
        return com.bytedance.adsdk.xt.xt.r.m.NUMBER;
    }

    @Override // com.bytedance.adsdk.xt.xt.xt.j
    public String xt() {
        return this.f23969j.toString();
    }

    public az(String str) {
        if (str.indexOf(46) >= 0) {
            Float valueOf = Float.valueOf(str);
            this.f23969j = valueOf;
            if (Float.isInfinite(valueOf.floatValue())) {
                this.f23969j = Double.valueOf(str);
                return;
            }
            return;
        }
        try {
            this.f23969j = Integer.valueOf(str);
        } catch (NumberFormatException unused) {
            this.f23969j = Long.valueOf(str);
        }
    }

    public String toString() {
        return xt();
    }
}
