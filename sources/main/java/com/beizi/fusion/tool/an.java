package com.beizi.fusion.tool;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class an {
    public static void a(Context context, String str, Object obj) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("fusion_config", 0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (obj instanceof Boolean) {
                edit.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Float) {
                edit.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Integer) {
                edit.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                edit.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                edit.putString(str, (String) obj);
            } else if (obj instanceof Set) {
                edit.remove(str);
                edit.putStringSet(str, (Set) obj);
            }
            edit.apply();
        }
    }

    public static Object b(Context context, String str, Object obj) {
        SharedPreferences sharedPreferences;
        try {
            sharedPreferences = context.getSharedPreferences("fusion_config", 0);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        if (sharedPreferences == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
        }
        if (obj instanceof String) {
            return sharedPreferences.getString(str, (String) obj);
        }
        if (obj instanceof Set) {
            return sharedPreferences.getStringSet(str, (Set) obj);
        }
        return null;
    }

    public static long b(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("beizisdk_config", 0)) == null) {
            return 0L;
        }
        return sharedPreferences.getLong(str, 0L);
    }

    public static String a(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("beizisdk_config", 0)) == null) {
            return null;
        }
        return sharedPreferences.getString(str, "");
    }

    public static void a(Context context, String str, String str2) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("beizisdk_config", 0).edit();
            edit.putString(str, str2);
            edit.commit();
        }
    }

    public static void a(Context context, String str, Long l6) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("beizisdk_config", 0).edit();
            edit.putLong(str, l6.longValue());
            edit.commit();
        }
    }
}
