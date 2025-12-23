package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class dk {
    public static JSONObject a() {
        try {
            String str = System.getenv("LD_PRELOAD");
            String str2 = System.getenv("LD_LIBRARY_PATH");
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("0", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("1", str2);
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static int b() {
        try {
            String a6 = bk.a();
            if (!TextUtils.isEmpty(a6) && !a6.contains("arm64")) {
                if (!a6.contains("64")) {
                    return 1;
                }
                return 0;
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }
}
