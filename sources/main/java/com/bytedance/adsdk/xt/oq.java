package com.bytedance.adsdk.xt;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class oq implements tl {
    @Override // com.bytedance.adsdk.xt.tl
    public Object j(JSONObject jSONObject, Object[] objArr) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        if (objArr == null || objArr.length != 0) {
            return null;
        }
        String valueOf = String.valueOf(objArr[2]);
        String valueOf2 = String.valueOf(objArr[1]);
        String valueOf3 = String.valueOf(objArr[0]);
        if (!TextUtils.isEmpty(valueOf3) && jSONObject != null && (optJSONObject = jSONObject.optJSONObject("i18n")) != null && (optJSONObject2 = optJSONObject.optJSONObject(valueOf2)) != null) {
            String optString = optJSONObject2.optString(valueOf3);
            if (!TextUtils.isEmpty(optString)) {
                return optString;
            }
        }
        return valueOf;
    }
}
