package com.bytedance.adsdk.xt;

import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j implements tl {
    @Override // com.bytedance.adsdk.xt.tl
    public Object j(JSONObject jSONObject, Object[] objArr) {
        if (objArr == null || objArr.length != 2) {
            return null;
        }
        String valueOf = String.valueOf(objArr[0]);
        JSONArray jSONArray = new JSONArray();
        try {
            JSONArray jSONArray2 = new JSONArray(valueOf);
            int parseInt = Integer.parseInt(String.valueOf(objArr[1]));
            for (int i6 = 0; i6 < jSONArray2.length(); i6 += parseInt) {
                JSONObject jSONObject2 = new JSONObject();
                JSONArray jSONArray3 = new JSONArray();
                for (int i7 = 0; i7 < parseInt; i7++) {
                    int i8 = i6 + i7;
                    if (i8 >= jSONArray2.length()) {
                        break;
                    }
                    jSONArray3.put(jSONArray2.optJSONObject(i8));
                }
                jSONObject2.put("$chunk", jSONArray3);
                jSONArray.put(jSONObject2);
            }
        } catch (Throwable unused) {
        }
        return jSONArray;
    }
}
