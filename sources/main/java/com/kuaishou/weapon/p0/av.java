package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class av {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f35746a;

    public String a(String str) {
        JSONObject jSONObject = this.f35746a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            if (string.length() > 2) {
                return string;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public av(Context context, int i6) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.f35870c).intValue(), 4, i6, "");
                if (!TextUtils.isEmpty(pqr)) {
                    this.f35746a = new JSONObject(pqr);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
