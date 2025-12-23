package com.bytedance.adsdk.xt;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class m implements tl {
    @Override // com.bytedance.adsdk.xt.tl
    /* renamed from: xt, reason: merged with bridge method [inline-methods] */
    public String j(JSONObject jSONObject, Object[] objArr) {
        if (objArr != null && objArr.length >= 2) {
            String valueOf = String.valueOf(objArr[0]);
            if (TextUtils.isEmpty(valueOf)) {
                return null;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(valueOf);
                String valueOf2 = String.valueOf(objArr[1]);
                if (TextUtils.isEmpty(valueOf2)) {
                    return null;
                }
                Object j6 = com.bytedance.adsdk.xt.xt.j.j(valueOf2).j(jSONObject2);
                if (!TextUtils.isEmpty(String.valueOf(j6))) {
                    return String.valueOf(j6);
                }
                if (objArr.length >= 3) {
                    return String.valueOf(objArr[2]);
                }
                return null;
            } catch (JSONException e6) {
                vl.j(e6);
            }
        }
        return null;
    }
}
