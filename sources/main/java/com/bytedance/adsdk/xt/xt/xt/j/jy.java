package com.bytedance.adsdk.xt.xt.xt.j;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class jy extends i {
    public jy() {
        super(com.bytedance.adsdk.xt.xt.r.cw.MULTI);
    }

    @Override // com.bytedance.adsdk.xt.xt.xt.j
    public Object j(Map<String, JSONObject> map) {
        Object j6;
        Object j7 = this.f23971j.j(map);
        if (j7 == null || (j6 = this.xt.j(map)) == null) {
            return null;
        }
        return com.bytedance.adsdk.xt.xt.up.j.ae.j((Number) j7, (Number) j6);
    }
}
