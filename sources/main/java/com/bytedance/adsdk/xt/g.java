package com.bytedance.adsdk.xt;

import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class g implements tl {
    @Override // com.bytedance.adsdk.xt.tl
    public Object j(JSONObject jSONObject, Object[] objArr) {
        if (objArr == null || objArr.length < 2) {
            return null;
        }
        Object obj = objArr[0];
        Object obj2 = objArr[1];
        if (!(obj instanceof JSONArray) || !(obj2 instanceof Integer)) {
            return null;
        }
        JSONArray jSONArray = (JSONArray) obj;
        if (jSONArray.length() > 0) {
            return jSONArray.opt(((Integer) obj2).intValue() % jSONArray.length());
        }
        return null;
    }
}
