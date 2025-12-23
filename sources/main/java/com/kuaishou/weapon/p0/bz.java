package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class bz {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f35827a;

    public String a(String str) {
        JSONObject jSONObject = this.f35827a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public bz(Context context) {
        if (Engine.loadSuccess) {
            String fgh = Engine.getInstance(context).fgh();
            if (!TextUtils.isEmpty(fgh)) {
                try {
                    this.f35827a = new JSONObject(fgh);
                } catch (Exception unused) {
                }
            }
        }
    }
}
