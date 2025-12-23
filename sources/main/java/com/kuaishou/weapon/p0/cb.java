package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class cb {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f35857a;

    public String a(String str) {
        JSONObject jSONObject = this.f35857a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public cb(Context context) {
        if (Engine.loadSuccess) {
            String ghi = Engine.getInstance(context).ghi();
            if (!TextUtils.isEmpty(ghi)) {
                try {
                    this.f35857a = new JSONObject(ghi);
                } catch (Exception unused) {
                }
            }
        }
    }
}
