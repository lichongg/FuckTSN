package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class ay {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f35749a;

    public String a(String str) {
        JSONObject jSONObject = this.f35749a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public ay(Context context, int i6) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.f35870c).intValue(), 2, i6, "");
                if (!TextUtils.isEmpty(pqr)) {
                    this.f35749a = new JSONObject(pqr);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public JSONObject a() {
        return this.f35749a;
    }
}
