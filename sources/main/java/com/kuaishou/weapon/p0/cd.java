package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class cd {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f35859a;

    public String a(String str) {
        JSONObject jSONObject = this.f35859a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public cd(Context context) {
        if (Engine.loadSuccess) {
            String hij = Engine.getInstance(context).hij();
            if (!TextUtils.isEmpty(hij)) {
                try {
                    this.f35859a = new JSONObject(hij);
                } catch (Exception unused) {
                }
            }
        }
    }
}
