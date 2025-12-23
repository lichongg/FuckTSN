package com.bytedance.sdk.openadsdk.core.up.xt;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {

    /* renamed from: j, reason: collision with root package name */
    public int f30946j;
    public Map<String, JSONObject> xt;

    public boolean j() {
        int i6 = this.f30946j;
        return i6 > 20000 && i6 < 100000;
    }

    public static up j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int optInt = jSONObject.optInt("code");
        JSONArray optJSONArray = jSONObject.optJSONArray("result");
        HashMap hashMap = new HashMap();
        if (optJSONArray != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("id", "");
                    String optString2 = optJSONObject.optString("req_id", "");
                    if (!TextUtils.isEmpty(j(optString, optString2))) {
                        hashMap.put(j(optString, optString2), optJSONObject);
                    }
                }
            }
        }
        up upVar = new up();
        upVar.xt = hashMap;
        upVar.f30946j = optInt;
        return upVar;
    }

    public static String j(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return str2 + "_" + str;
    }
}
