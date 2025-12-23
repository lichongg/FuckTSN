package cn.jiguang.api;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: D:\Downloads\app\classes2.dex */
public class MultiSpHelper {
    private static final String SP_FILE = "cn.jpush.android.user.profile";
    private static final String TAG = "MultiSpHelper";
    private static SharedPreferences sharedPref;

    public static int getInt(Context context, String str, int i6) {
        SharedPreferences reload;
        return ((str.equals("jpush_register_code") || str.equals("service_stoped")) && (reload = reload(context)) != null) ? reload.getInt(str, i6) : getSp(context).getInt(str, i6);
    }

    private static SharedPreferences getSp(Context context) {
        if (sharedPref == null) {
            init(context);
        }
        return sharedPref;
    }

    private static void init(Context context) {
        sharedPref = context.getSharedPreferences(SP_FILE, 0);
    }

    private static SharedPreferences reload(Context context) {
        if (context == null) {
            return null;
        }
        context.getSharedPreferences(SP_FILE, 4);
        return context.getSharedPreferences(SP_FILE, 0);
    }

    private MultiSpHelper() {
    }

    public static void commitBoolean(Context context, String str, boolean z5) {
        getSp(context).edit().putBoolean(str, z5).apply();
    }

    public static void commitInt(Context context, String str, int i6) {
        getSp(context).edit().putInt(str, i6).apply();
    }

    public static void commitLong(Context context, String str, long j6) {
        getSp(context).edit().putLong(str, j6).apply();
    }

    public static void commitString(Context context, String str, String str2) {
        getSp(context).edit().putString(str, str2).apply();
    }

    public static boolean getBoolean(Context context, String str, boolean z5) {
        return getSp(context).getBoolean(str, z5);
    }

    public static long getLong(Context context, String str, long j6) {
        return getSp(context).getLong(str, j6);
    }

    public static String getString(Context context, String str, String str2) {
        return getSp(context).getString(str, str2);
    }
}
