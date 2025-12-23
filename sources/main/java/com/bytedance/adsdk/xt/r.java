package com.bytedance.adsdk.xt;

import android.net.Uri;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r implements tl {
    @Override // com.bytedance.adsdk.xt.tl
    public Object j(JSONObject jSONObject, Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        String valueOf = String.valueOf(objArr[0]);
        if (TextUtils.isEmpty(valueOf)) {
            return null;
        }
        return Uri.encode(valueOf);
    }
}
