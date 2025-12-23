package com.bytedance.sdk.openadsdk.core.rn;

import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class az {
    public static boolean j() {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject st = com.bytedance.sdk.openadsdk.core.v.xt().st();
        if (st == null) {
            return false;
        }
        long optLong = st.optLong("start", 1707480000000L);
        long optLong2 = st.optLong("end", 1707498000000L);
        if (currentTimeMillis < optLong || currentTimeMillis > optLong2) {
            return false;
        }
        return true;
    }

    public static boolean xt() {
        JSONObject st = com.bytedance.sdk.openadsdk.core.v.xt().st();
        if (st == null || !j() || st.optInt("force_drop", 0) != 1) {
            return false;
        }
        return true;
    }
}
