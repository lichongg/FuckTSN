package com.bytedance.sdk.gromore.init;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    public static com.bytedance.msdk.api.r.m j(com.bytedance.sdk.openadsdk.mediation.init.j.xt.j.cw cwVar) {
        if (cwVar == null) {
            return null;
        }
        com.bytedance.msdk.api.r.m mVar = new com.bytedance.msdk.api.r.m();
        mVar.j(cwVar.xt());
        mVar.r(cwVar.m());
        mVar.xt(cwVar.cw());
        mVar.cw(cwVar.r());
        mVar.j(cwVar.up());
        mVar.up(cwVar.ae());
        mVar.j(cwVar.j());
        return mVar;
    }

    public static Map<String, String> j(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue().toString());
            }
        }
        return hashMap;
    }
}
