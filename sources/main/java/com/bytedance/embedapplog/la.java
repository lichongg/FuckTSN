package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
class la extends l {
    private final Context up;

    la(Context context) {
        super(false, false);
        this.up = context;
    }

    @Override // com.bytedance.embedapplog.l
    protected boolean j(JSONObject jSONObject) {
        SharedPreferences xt = com.bytedance.sdk.openadsdk.api.plugin.xt.xt(this.up, "snssdk_openudid", 0);
        String xt2 = xt(xt.getString("custom_a", null));
        if (TextUtils.isEmpty(xt2)) {
            xt2 = xt.getString("clientudid", null);
        }
        if (!wq.j(xt2)) {
            try {
                xt2 = UUID.randomUUID().toString();
                xt2 = j("clientudid.dat", xt2);
            } catch (Exception unused) {
            }
            String j6 = j(xt2);
            SharedPreferences.Editor edit = xt.edit();
            edit.putString("custom_a", j6);
            edit.apply();
        }
        jSONObject.put("clientudid", xt2);
        return true;
    }

    public static String xt(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(Base64.decode(str.getBytes("UTF-8"), 0));
        } catch (UnsupportedEncodingException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return str;
        }
    }

    public static String j(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return Base64.encodeToString(str.getBytes("UTF-8"), 0);
        } catch (UnsupportedEncodingException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return str;
        }
    }
}
