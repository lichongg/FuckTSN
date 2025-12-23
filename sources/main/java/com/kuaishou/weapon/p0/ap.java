package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class ap {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f35737a;

    public JSONObject a(String str) {
        JSONObject jSONObject = this.f35737a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string) || string.length() <= 3) {
                return null;
            }
            return new JSONObject(string);
        } catch (Exception unused) {
            return null;
        }
    }

    public String b(String str) {
        JSONObject jSONObject = this.f35737a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (!TextUtils.isEmpty(string)) {
                    if (string.contains("{}")) {
                        return null;
                    }
                    return string;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public ap(Context context) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.f35874g).intValue(), 0, 0, "");
                if (!TextUtils.isEmpty(pqr)) {
                    this.f35737a = new JSONObject(pqr);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
