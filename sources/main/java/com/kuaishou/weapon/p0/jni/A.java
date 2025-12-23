package com.kuaishou.weapon.p0.jni;

import android.content.Context;
import com.kuaishou.weapon.p0.dp;
import com.kuaishou.weapon.p0.w;
import org.json.JSONArray;

/* loaded from: D:\Downloads\app\classes6.dex */
public class A {
    private static int flag;
    private static JSONArray jsonObject;

    public static JSONArray getJsonObject() {
        return jsonObject;
    }

    public static void setA(Context context) {
        if (context != null) {
            jsonObject = new w(context).b(flag);
        }
    }

    public static void setJsonObject(JSONArray jSONArray) {
        jsonObject = jSONArray;
    }

    public A(Context context, int i6) {
        flag = i6;
        if (Engine.loadSuccess) {
            Engine.getInstance(context).qrs();
        } else {
            setA(context);
        }
    }

    public static String getE(String str) {
        try {
            dp a6 = dp.a();
            if (a6 != null) {
                return a6.a(str, "");
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void setE(String str, String str2) {
        try {
            dp a6 = dp.a();
            if (a6 != null) {
                a6.b(str, str2);
            }
        } catch (Exception unused) {
        }
    }
}
