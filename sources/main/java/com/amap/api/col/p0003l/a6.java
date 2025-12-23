package com.amap.api.col.p0003l;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class a6 {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, String> f5632a = new HashMap<>();

    public static String a(Context context, p4 p4Var, String str) {
        if (p4Var == null || TextUtils.isEmpty(p4Var.a())) {
            return null;
        }
        String str2 = f5632a.get(p4Var.a() + str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        String str3 = str + p4Var.a();
        return (context == null || TextUtils.isEmpty(str3)) ? "" : q4.g(e4.e(q4.y(context.getSharedPreferences("d7afbc6a38848a6801f6e449f3ec8e53", 0).getString(str3, ""))));
    }

    public static void b(Context context, p4 p4Var, String str, String str2) {
        if (p4Var == null || TextUtils.isEmpty(p4Var.a())) {
            return;
        }
        String str3 = str + p4Var.a();
        f5632a.put(p4Var.a() + str, str2);
        if (context == null || TextUtils.isEmpty(str3) || TextUtils.isEmpty("d7afbc6a38848a6801f6e449f3ec8e53") || TextUtils.isEmpty(str2)) {
            return;
        }
        String E = q4.E(e4.c(q4.o(str2)));
        SharedPreferences.Editor edit = context.getSharedPreferences("d7afbc6a38848a6801f6e449f3ec8e53", 0).edit();
        edit.putString(str3, E);
        edit.commit();
    }
}
