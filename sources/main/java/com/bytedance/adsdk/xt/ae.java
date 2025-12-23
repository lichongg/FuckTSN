package com.bytedance.adsdk.xt;

import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ae implements tl {
    @Override // com.bytedance.adsdk.xt.tl
    /* renamed from: xt, reason: merged with bridge method [inline-methods] */
    public Boolean j(JSONObject jSONObject, Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return Boolean.FALSE;
        }
        try {
            Double.parseDouble(String.valueOf(objArr[0]));
            return Boolean.TRUE;
        } catch (NumberFormatException unused) {
            return Boolean.FALSE;
        }
    }
}
