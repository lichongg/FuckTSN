package com.bytedance.sdk.openadsdk.core.live.up;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {
    public static int j(Map<String, Object> map) {
        try {
            return ((Integer) map.get("live_saas_param_interaction_type")).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    private static boolean xt(String str) {
        JSONObject optJSONObject;
        if (TextUtils.isEmpty(str) || (optJSONObject = new JSONObject(str).optJSONObject("enter_request")) == null) {
            return false;
        }
        int optInt = optJSONObject.optInt("activity_type");
        JSONArray optJSONArray = optJSONObject.optJSONArray("incr_coupon");
        if (optInt == 1 && optJSONArray != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i6);
                if (optJSONObject2.optInt("interaction_type") == 1 && optJSONObject2.optInt("task_time") > 0 && optJSONObject2.optLong("value") > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean j(String str) {
        try {
            if (TextUtils.isEmpty(str) || new JSONObject(str).optJSONObject("enter_request") == null) {
                return false;
            }
            return !xt(str);
        } catch (Exception unused) {
            return false;
        }
    }
}
