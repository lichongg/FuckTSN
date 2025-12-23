package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class cf {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f35861a;

    public String a(String str) {
        JSONObject jSONObject = this.f35861a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONArray b(String str) {
        JSONObject jSONObject = this.f35861a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(string);
            try {
                if (jSONArray.length() > 0) {
                    for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i6);
                        String a6 = f.a(jSONObject2.optString("1"));
                        String a7 = f.a(jSONObject2.optString("2"));
                        if (!TextUtils.isEmpty(a6)) {
                            jSONObject2.put("1", a6);
                        }
                        if (!TextUtils.isEmpty(a7)) {
                            jSONObject2.put("2", a7);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            return jSONArray;
        } catch (Exception unused2) {
            return null;
        }
    }

    public cf(Context context) {
        if (Engine.loadSuccess) {
            String nop = Engine.getInstance(context).nop();
            if (!TextUtils.isEmpty(nop)) {
                try {
                    this.f35861a = new JSONObject(nop);
                } catch (Exception unused) {
                }
            }
        }
    }
}
