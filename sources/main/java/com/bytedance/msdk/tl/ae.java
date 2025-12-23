package com.bytedance.msdk.tl;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ae {
    public static JSONObject j() {
        Map<String, com.bytedance.msdk.j.j.r> xt = com.bytedance.msdk.m.xt.xt.j().xt();
        if (xt == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, com.bytedance.msdk.j.j.r> entry : xt.entrySet()) {
            if (entry.getKey() != null) {
                String[] split = entry.getKey().split("\\.");
                if (split.length >= 5) {
                    try {
                        jSONObject.put(split[4] + "Adapter", entry.getValue().j());
                    } catch (JSONException e6) {
                        com.bytedance.sdk.component.utils.vl.j(e6);
                    }
                }
            }
        }
        return jSONObject;
    }
}
