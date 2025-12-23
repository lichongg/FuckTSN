package com.bytedance.sdk.openadsdk.core.live.up;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {
    public static boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i6 = 0; i6 < length; i6++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i6);
                if (jSONObject != null) {
                    String optString = jSONObject.optString(CommonNetImpl.NAME, null);
                    if (TextUtils.equals(optString, "ec_reward_gold") || TextUtils.equals(optString, "reward_gold") || TextUtils.equals(optString, "auth_reward_gold")) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean j(n nVar) {
        JSONObject up;
        com.bytedance.sdk.openadsdk.core.ugeno.g.j h6 = nVar.h();
        return (h6 == null || (up = h6.up()) == null || up.optBoolean("landing_type", false)) ? false : true;
    }
}
