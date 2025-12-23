package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class bc {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f35759a;

    public String a(String str) {
        JSONObject jSONObject = this.f35759a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public bc(Context context, String str, int i6) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(i6, 0, cu.a() ? 1 : 0, str);
                if (!TextUtils.isEmpty(pqr)) {
                    this.f35759a = new JSONObject(pqr);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
