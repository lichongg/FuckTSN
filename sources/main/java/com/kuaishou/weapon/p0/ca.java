package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class ca {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f35856a;

    public String a(String str) {
        JSONObject jSONObject = this.f35856a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public ca(Context context) {
        if (Engine.loadSuccess) {
            String efg = Engine.getInstance(context).efg();
            if (!TextUtils.isEmpty(efg)) {
                try {
                    this.f35856a = new JSONObject(efg);
                } catch (Exception unused) {
                }
            }
        }
    }
}
