package com.bytedance.adsdk.xt.xt.xt.j;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class up extends i {
    public up() {
        super(com.bytedance.adsdk.xt.xt.r.cw.GT_EQ);
    }

    @Override // com.bytedance.adsdk.xt.xt.xt.j
    public Object j(Map<String, JSONObject> map) {
        Object j6;
        if (this.f23971j.j(map) == null || (j6 = this.xt.j(map)) == null) {
            return null;
        }
        return Boolean.valueOf(!((Boolean) com.bytedance.adsdk.xt.xt.up.j.r.j(r0, (Number) j6)).booleanValue());
    }
}
