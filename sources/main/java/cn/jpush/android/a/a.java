package cn.jpush.android.a;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static SharedPreferences f3337a;

    public static void a(Context context) {
        if (f3337a == null) {
            f3337a = context.getSharedPreferences("asus_push_sdk_preferences", 0);
        }
    }

    protected static Boolean b(String str, boolean z5) {
        SharedPreferences sharedPreferences = f3337a;
        return sharedPreferences != null ? Boolean.valueOf(sharedPreferences.getBoolean(str, true)) : Boolean.TRUE;
    }

    protected static void a(String str, String str2) {
        SharedPreferences sharedPreferences = f3337a;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(str, str2);
            edit.apply();
        }
    }

    protected static String b(String str, String str2) {
        SharedPreferences sharedPreferences = f3337a;
        return sharedPreferences != null ? sharedPreferences.getString(str, str2) : str2;
    }

    protected static void a(String str, boolean z5) {
        SharedPreferences sharedPreferences = f3337a;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean(str, false);
            edit.apply();
        }
    }
}
