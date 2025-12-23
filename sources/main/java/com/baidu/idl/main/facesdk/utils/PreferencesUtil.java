package com.baidu.idl.main.facesdk.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"NewApi"})
/* loaded from: D:\Downloads\app\classes2.dex */
public class PreferencesUtil {
    private static final String LEFT_MOUNT = "[";
    private static final String LENGTH_SUFFIX = "#LENGTH";
    private static final String RIGHT_MOUNT = "]";
    private static SharedPreferences mPrefs;

    public static SharedPreferences getPreferences() {
        SharedPreferences sharedPreferences = mPrefs;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        throw new RuntimeException("please call iniPrefs(context) in the Application class onCreate.");
    }

    public static void initPrefs(Context context) {
        if (mPrefs == null) {
            String packageName = context.getPackageName();
            if (packageName == null) {
                throw new NullPointerException("Prefs key may not be null");
            }
            mPrefs = context.getSharedPreferences(packageName, 4);
        }
    }

    @Deprecated
    public static void reInit(Context context) {
        if (context != null) {
            String packageName = context.getPackageName();
            if (packageName == null) {
                throw new NullPointerException("Prefs key may not be null");
            }
            mPrefs = context.getSharedPreferences(packageName, 4);
        }
    }

    public static boolean contains(String str) {
        return getPreferences().contains(str);
    }

    public static Map<String, ?> getAll() {
        return getPreferences().getAll();
    }

    public static boolean getBoolean(String str, boolean z5) {
        return getPreferences().getBoolean(str, z5);
    }

    public static float getFloat(String str, float f6) {
        return getPreferences().getFloat(str, f6);
    }

    public static int getInt(String str, int i6) {
        return getPreferences().getInt(str, i6);
    }

    public static long getLong(String str, long j6) {
        return getPreferences().getLong(str, j6);
    }

    public static String getString(String str, String str2) {
        return getPreferences().getString(str, str2);
    }

    @TargetApi(11)
    public static Set<String> getStringSet(String str, Set<String> set) {
        return getPreferences().getStringSet(str, set);
    }

    public static void putBoolean(String str, boolean z5) {
        SharedPreferences.Editor edit = getPreferences().edit();
        edit.putBoolean(str, z5);
        edit.apply();
    }

    public static void putFloat(String str, float f6) {
        SharedPreferences.Editor edit = getPreferences().edit();
        edit.putFloat(str, f6);
        edit.apply();
    }

    public static void putInt(String str, int i6) {
        SharedPreferences.Editor edit = getPreferences().edit();
        edit.putInt(str, i6);
        edit.apply();
    }

    public static void putLong(String str, long j6) {
        SharedPreferences.Editor edit = getPreferences().edit();
        edit.putLong(str, j6);
        edit.apply();
    }

    public static void putString(String str, String str2) {
        SharedPreferences.Editor edit = getPreferences().edit();
        edit.putString(str, str2);
        edit.apply();
    }

    @TargetApi(11)
    public static void putStringSet(String str, Set<String> set) {
        SharedPreferences.Editor edit = getPreferences().edit();
        edit.putStringSet(str, set);
        edit.apply();
    }

    public static void remove(String str) {
        SharedPreferences preferences = getPreferences();
        SharedPreferences.Editor edit = preferences.edit();
        if (preferences.contains(str + LENGTH_SUFFIX)) {
            int i6 = preferences.getInt(str + LENGTH_SUFFIX, -1);
            if (i6 >= 0) {
                edit.remove(str + LENGTH_SUFFIX);
                for (int i7 = 0; i7 < i6; i7++) {
                    edit.remove(str + LEFT_MOUNT + i7 + RIGHT_MOUNT);
                }
            }
        }
        edit.remove(str);
        edit.apply();
    }
}
