package cn.jiguang.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static SharedPreferences f2939a;

    public static void a(Context context, int i6) {
        f(context).edit().putInt("log_ref_count", i6).apply();
    }

    public static long b(Context context) {
        return f(context).getLong("log_last_timestamp", 0L);
    }

    public static void a(Context context, long j6) {
        f(context).edit().putLong("log_last_timestamp", j6).apply();
    }

    public static void b(Context context, int i6) {
        f(context).edit().putInt("server_upload_state", i6).apply();
    }

    private static synchronized SharedPreferences f(Context context) {
        String a6;
        String str;
        synchronized (c.class) {
            try {
                try {
                    a6 = cn.jiguang.bz.a.a(context);
                } finally {
                    return f2939a;
                }
                if (!TextUtils.isEmpty(a6) && !TextUtils.equals(a6, context.getPackageName())) {
                    String str2 = a6.split(":")[1];
                    if (f2939a == null) {
                        str = "cn.jiguang.sdk.log_config_" + str2;
                        f2939a = context.getSharedPreferences(str, 0);
                    }
                }
                if (f2939a == null) {
                    str = "cn.jiguang.sdk.log_config";
                    f2939a = context.getSharedPreferences(str, 0);
                }
            } catch (Throwable th) {
            }
        }
        return f2939a;
    }

    public static void a(Context context, boolean z5) {
        f(context).edit().putBoolean("external_log_enabled", z5).apply();
    }

    public static void b(Context context, boolean z5) {
        f(context).edit().putBoolean("local_upload_enable", z5).apply();
    }

    public static int c(Context context) {
        return f(context).getInt("log_ref_count", 0);
    }

    public static boolean d(Context context) {
        return f(context).getBoolean("local_upload_enable", false);
    }

    public static int e(Context context) {
        return f(context).getInt("server_upload_state", 2);
    }

    public static boolean a(Context context) {
        return f(context).getBoolean("external_log_enabled", false);
    }
}
