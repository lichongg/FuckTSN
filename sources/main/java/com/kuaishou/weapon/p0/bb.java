package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class bb {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f35758a;

    public static boolean a(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                return g.a(context, g.f36049i) != -1;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public bb(Context context, int i6, String str, boolean z5) {
        if (Engine.loadSuccess && z5) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.f35873f).intValue(), 0, i6, str);
                if (!TextUtils.isEmpty(pqr)) {
                    this.f35758a = new JSONObject(pqr);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f35758a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject a() {
        return this.f35758a;
    }
}
