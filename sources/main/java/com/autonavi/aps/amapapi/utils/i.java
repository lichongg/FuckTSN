package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class i {
    public static SharedPreferences.Editor a(Context context, String str) {
        return context.getSharedPreferences(str, 0).edit();
    }

    public static void a(SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        editor.apply();
    }

    public static void a(SharedPreferences.Editor editor, String str) {
        try {
            editor.remove(str);
        } catch (Throwable th) {
            b.a(th, "SpUtil", "setPrefsLong");
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, long j6) {
        try {
            editor.putLong(str, j6);
        } catch (Throwable th) {
            b.a(th, "SpUtil", "setPrefsLong");
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, boolean z5) {
        try {
            editor.putBoolean(str, z5);
        } catch (Throwable th) {
            b.a(th, "SpUtil", "updatePrefsBoolean");
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, String str2) {
        try {
            editor.putString(str, str2);
        } catch (Throwable th) {
            b.a(th, "SpUtil", "setPrefsStr");
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, int i6) {
        try {
            editor.putInt(str, i6);
        } catch (Throwable th) {
            b.a(th, "SpUtil", "setPrefsInt");
        }
    }

    public static long a(Context context, String str, String str2, long j6) {
        try {
            return context.getSharedPreferences(str, 0).getLong(str2, j6);
        } catch (Throwable th) {
            b.a(th, "SpUtil", "getPrefsLong");
            return j6;
        }
    }

    public static int a(Context context, String str, String str2, int i6) {
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, i6);
        } catch (Throwable th) {
            b.a(th, "SpUtil", "getPrefsInt");
            return i6;
        }
    }

    public static boolean a(Context context, String str, String str2, boolean z5) {
        try {
            return context.getSharedPreferences(str, 0).getBoolean(str2, z5);
        } catch (Throwable th) {
            b.a(th, "SpUtil", "getPrefsBoolean");
            return z5;
        }
    }

    public static String a(Context context, String str, String str2, String str3) {
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Throwable th) {
            b.a(th, "SpUtil", "getPrefsInt");
            return str3;
        }
    }

    public static String a(Context context) {
        return context == null ? "00:00:00:00:00:00" : a(context, "pref", "smac", "00:00:00:00:00:00");
    }
}
