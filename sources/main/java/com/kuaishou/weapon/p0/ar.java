package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class ar {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f35739a;

    public String a(String str) {
        JSONObject jSONObject = this.f35739a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public ar(Context context) {
        if (Engine.loadSuccess) {
            try {
                String klm = Engine.getInstance(context).klm(56, context.getPackageName());
                if (!TextUtils.isEmpty(klm)) {
                    this.f35739a = new JSONObject(klm);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
