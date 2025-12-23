package com.bxkj.base.v2.data.spp;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class c {
    public static boolean a(Context context, String str, String str2) {
        return b(context, str, str2, false);
    }

    public static boolean b(Context context, String str, String str2, boolean z5) {
        return context.getSharedPreferences(str, 0).getBoolean(str2, z5);
    }

    public static SharedPreferences.Editor c(Context context, String str) {
        return context.getSharedPreferences(str, 0).edit();
    }

    public static float e(Context context, String str, String str2, float f6) {
        return context.getSharedPreferences(str, 0).getFloat(str2, f6);
    }

    public static int f(Context context, String str, String str2) {
        return g(context, str, str2, -1);
    }

    public static int g(Context context, String str, String str2, int i6) {
        return context.getSharedPreferences(str, 0).getInt(str2, i6);
    }

    public static long i(Context context, String str, String str2, long j6) {
        return context.getSharedPreferences(str, 0).getLong(str2, j6);
    }

    public static String j(Context context, String str, String str2) {
        return k(context, str, str2, null);
    }

    public static String k(Context context, String str, String str2, String str3) {
        return context.getSharedPreferences(str, 0).getString(str2, str3);
    }

    public static boolean l(Context context, String str, String str2, boolean z5) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putBoolean(str2, z5);
        return edit.commit();
    }

    public static boolean m(Context context, String str, String str2, float f6) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putFloat(str2, f6);
        return edit.commit();
    }

    public static boolean n(Context context, String str, String str2, int i6) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putInt(str2, i6);
        return edit.commit();
    }

    public static boolean o(Context context, String str, String str2, long j6) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putLong(str2, j6);
        return edit.commit();
    }

    public static boolean p(Context context, String str, String str2, String str3) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        return edit.commit();
    }

    public static boolean q(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.remove(str2);
        return edit.commit();
    }

    public static float d(Context context, String str, String str2) {
        return e(context, str, str2, -1.0f);
    }

    public static long h(Context context, String str, String str2) {
        return i(context, str, str2, -1L);
    }
}
