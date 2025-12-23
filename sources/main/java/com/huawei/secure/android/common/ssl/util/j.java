package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static final String f35242a = "aegis";

    /* renamed from: b, reason: collision with root package name */
    private static SharedPreferences f35243b;

    public static synchronized SharedPreferences f(Context context) {
        SharedPreferences sharedPreferences;
        Context createDeviceProtectedStorageContext;
        synchronized (j.class) {
            try {
                if (f35243b == null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
                        f35243b = createDeviceProtectedStorageContext.getSharedPreferences(f35242a, 0);
                    } else {
                        f35243b = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f35242a, 0);
                    }
                }
                sharedPreferences = f35243b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sharedPreferences;
    }

    public static int a(String str, int i6, Context context) {
        return f(context).getInt(str, i6);
    }

    public static long b(String str, long j6, Context context) {
        return f(context).getLong(str, j6);
    }

    public static String c(String str, String str2, Context context) {
        return f(context).getString(str, str2);
    }

    public static void d(Context context) {
        f(context).edit().clear().apply();
    }

    public static void e(String str, Context context) {
        f(context).edit().remove(str).apply();
    }

    public static void g(String str, int i6, Context context) {
        f(context).edit().putInt(str, i6).apply();
    }

    public static void h(String str, long j6, Context context) {
        f(context).edit().putLong(str, j6).apply();
    }

    public static void i(String str, String str2, Context context) {
        f(context).edit().putString(str, str2).apply();
    }
}
