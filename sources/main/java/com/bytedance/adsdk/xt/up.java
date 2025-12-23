package com.bytedance.adsdk.xt;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class up implements tl {
    @Override // com.bytedance.adsdk.xt.tl
    public Object j(JSONObject jSONObject, Object[] objArr) {
        if (objArr != null && objArr.length > 0) {
            for (Object obj : objArr) {
                String valueOf = String.valueOf(obj);
                if (!TextUtils.isEmpty(valueOf) && !TextUtils.equals(valueOf, "null")) {
                    return valueOf;
                }
            }
        }
        return null;
    }
}
