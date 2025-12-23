package xyz.adscope.common.v2.persistent.sp;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class CommonSpHelper {
    private static final String SP_NAME_COMMON = "scope_com";
    private static final String SP_NAME_COMMON_BASIC = "scope_basic_%s";

    public static boolean appendStringSet(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return false;
        }
        HashSet hashSet = new HashSet();
        hashSet.add(str3);
        return appendStringSet(context, str, str2, hashSet);
    }

    public static boolean clearSet(Context context, String str, String str2) {
        SharedPreferences sharedPreferences;
        if (context == null || TextUtils.isEmpty(str2) || (sharedPreferences = context.getSharedPreferences(str, 0)) == null) {
            return false;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.remove(str2);
        return edit.commit();
    }

    public static Map<String, ?> getAll(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getAll();
        }
        return null;
    }

    public static String getBasicSPFile(String str) {
        return String.format(SP_NAME_COMMON_BASIC, str);
    }

    public static boolean getBoolean(Context context, String str, String str2) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(str2, false);
        }
        return false;
    }

    public static float getFloat(Context context, String str, String str2, float f6) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        return sharedPreferences != null ? sharedPreferences.getFloat(str2, f6) : f6;
    }

    public static int getInt(Context context, String str, String str2, int i6) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        return sharedPreferences != null ? sharedPreferences.getInt(str2, i6) : i6;
    }

    public static long getLong(Context context, String str, String str2, long j6) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        return sharedPreferences != null ? sharedPreferences.getLong(str2, j6) : j6;
    }

    public static String getString(Context context, String str, String str2, String str3) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        return sharedPreferences != null ? sharedPreferences.getString(str2, str3) : str3;
    }

    public static Set<String> getStringSet(Context context, String str, String str2) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getStringSet(str2, null);
        }
        return null;
    }

    public static boolean putStringSet(Context context, String str, String str2, Set<String> set) {
        SharedPreferences sharedPreferences;
        if (context == null || set == null || TextUtils.isEmpty(str2) || (sharedPreferences = context.getSharedPreferences(str, 0)) == null) {
            return false;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.remove(str2);
        edit.putStringSet(str2, new HashSet(set));
        return edit.commit();
    }

    public static boolean removeStringFromSet(Context context, String str, String str2, String str3) {
        SharedPreferences sharedPreferences;
        if (context == null || TextUtils.isEmpty(str2) || (sharedPreferences = context.getSharedPreferences(str, 0)) == null) {
            return false;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        HashSet hashSet = new HashSet(sharedPreferences.getStringSet(str2, new HashSet()));
        hashSet.remove(str3);
        edit.remove(str2);
        edit.putStringSet(str2, hashSet);
        return edit.commit();
    }

    public static String getCommonSPFile() {
        return SP_NAME_COMMON;
    }

    public static void putBoolean(Context context, String str, String str2, boolean z5) {
        SharedPreferences sharedPreferences;
        if (context == null || TextUtils.isEmpty(str2) || (sharedPreferences = context.getSharedPreferences(str, 0)) == null) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean(str2, z5);
        edit.apply();
    }

    public static void putFloat(Context context, String str, String str2, float f6) {
        SharedPreferences sharedPreferences;
        if (context == null || TextUtils.isEmpty(str2) || (sharedPreferences = context.getSharedPreferences(str, 0)) == null) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putFloat(str2, f6);
        edit.apply();
    }

    public static void putInt(Context context, String str, String str2, int i6) {
        SharedPreferences sharedPreferences;
        if (context == null || TextUtils.isEmpty(str2) || (sharedPreferences = context.getSharedPreferences(str, 0)) == null) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt(str2, i6);
        edit.apply();
    }

    public static void putLong(Context context, String str, String str2, long j6) {
        SharedPreferences sharedPreferences;
        if (context == null || TextUtils.isEmpty(str2) || (sharedPreferences = context.getSharedPreferences(str, 0)) == null) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putLong(str2, j6);
        edit.apply();
    }

    public static void putString(Context context, String str, String str2, String str3) {
        SharedPreferences sharedPreferences;
        if (context == null || TextUtils.isEmpty(str2) || (sharedPreferences = context.getSharedPreferences(str, 0)) == null) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(str2, str3);
        edit.apply();
    }

    public static void removeKey(Context context, String str, String str2) {
        SharedPreferences sharedPreferences;
        if (context == null || TextUtils.isEmpty(str2) || (sharedPreferences = context.getSharedPreferences(str, 0)) == null) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.remove(str2);
        edit.apply();
    }

    private CommonSpHelper() {
    }

    public static boolean containKey(Context context, String str, String str2) {
        SharedPreferences sharedPreferences;
        if (TextUtils.isEmpty(str2) || (sharedPreferences = context.getSharedPreferences(str, 0)) == null) {
            return false;
        }
        return sharedPreferences.contains(str2);
    }

    public static boolean appendStringSet(Context context, String str, String str2, Set<String> set) {
        SharedPreferences sharedPreferences;
        if (context == null || set == null || TextUtils.isEmpty(str2) || (sharedPreferences = context.getSharedPreferences(str, 0)) == null) {
            return false;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        HashSet hashSet = new HashSet(sharedPreferences.getStringSet(str2, new HashSet()));
        hashSet.addAll(set);
        edit.remove(str2);
        edit.putStringSet(str2, hashSet);
        return edit.commit();
    }
}
