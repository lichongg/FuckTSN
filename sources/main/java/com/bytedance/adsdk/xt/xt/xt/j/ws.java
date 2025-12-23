package com.bytedance.adsdk.xt.xt.xt.j;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ws extends i {
    public ws() {
        super(com.bytedance.adsdk.xt.xt.r.cw.NOT_EQ);
    }

    @Override // com.bytedance.adsdk.xt.xt.xt.j
    public Object j(Map<String, JSONObject> map) {
        Object j6 = this.f23971j.j(map);
        Object j7 = this.xt.j(map);
        return (j6 == null && j7 == null) ? Boolean.FALSE : (j6 != null || j7 == null) ? (j6 == null || j7 != null) ? ((j6 instanceof Number) && (j7 instanceof Number)) ? Boolean.valueOf(!com.bytedance.adsdk.xt.xt.up.j.xt.j((Number) j6, (Number) j7)) : Boolean.valueOf(!j6.equals(j7)) : Boolean.TRUE : Boolean.TRUE;
    }
}
