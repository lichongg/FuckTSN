package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class x {
    public JSONArray a(Context context) {
        try {
            JSONArray jSONArray = new JSONArray();
            String e6 = bh.e();
            if (!TextUtils.isEmpty(e6) && !e6.startsWith("RISK")) {
                JSONArray jSONArray2 = new JSONArray(e6);
                for (int i6 = 0; i6 < jSONArray2.length(); i6++) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("1", jSONArray2.getJSONObject(i6).getString("appName"));
                    jSONObject.put("2", jSONArray2.getJSONObject(i6).getString("pkgName"));
                    jSONObject.put("3", jSONArray2.getJSONObject(i6).getString("appVersion"));
                    jSONObject.put("5", jSONArray2.getJSONObject(i6).getString("system_app"));
                    jSONObject.put("6", jSONArray2.getJSONObject(i6).getString("firstInstallTime"));
                    jSONObject.put("7", jSONArray2.getJSONObject(i6).getString("lastUpdateTime"));
                    jSONArray.put(jSONObject);
                }
                return jSONArray;
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
