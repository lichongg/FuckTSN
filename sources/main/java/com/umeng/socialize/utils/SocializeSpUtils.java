package com.umeng.socialize.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class SocializeSpUtils {
    public static synchronized String getShareBoardConfig(Context context) {
        synchronized (SocializeSpUtils.class) {
            SharedPreferences sharedPreferences = getSharedPreferences(context);
            if (sharedPreferences == null) {
                return null;
            }
            return sharedPreferences.getString("shareboardconfig", null);
        }
    }

    private static SharedPreferences getSharedPreferences(Context context) {
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences(SocializeConstants.SOCIAL_PREFERENCE_NAME, 0);
    }

    public static synchronized boolean putShareBoardConfig(Context context, String str) {
        synchronized (SocializeSpUtils.class) {
            SharedPreferences sharedPreferences = getSharedPreferences(context);
            if (sharedPreferences == null) {
                return false;
            }
            return sharedPreferences.edit().putString("shareboardconfig", str).commit();
        }
    }

    public static int getInt(Context context, String str, int i6) {
        return getSharedPreferences(context).getInt(str, i6);
    }

    public static String getMac(Context context) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString(SocializeProtocolConstants.PROTOCOL_KEY_MAC, null);
    }

    public static String getString(Context context, String str) {
        return getSharedPreferences(context).getString(str, "");
    }

    public static long getTime(Context context) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        if (sharedPreferences == null) {
            return 0L;
        }
        return sharedPreferences.getLong(SocializeConstants.TIME, 0L);
    }

    public static String getUMEk(Context context) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString(SocializeProtocolConstants.PROTOCOL_KEY_ENTITY_KEY, null);
    }

    public static String getUMId(Context context) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString("uid", null);
    }

    public static void putInt(Context context, String str, int i6) {
        getSharedPreferences(context).edit().putInt(str, i6).commit();
    }

    public static boolean putMac(Context context, String str) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        if (sharedPreferences == null) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return sharedPreferences.edit().putString(SocializeProtocolConstants.PROTOCOL_KEY_MAC, str).commit();
    }

    public static void putString(Context context, String str, String str2) {
        getSharedPreferences(context).edit().putString(str, str2).commit();
    }

    public static boolean putTime(Context context) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        if (sharedPreferences != null && sharedPreferences.edit().putLong(SocializeConstants.TIME, System.currentTimeMillis()).commit()) {
            return true;
        }
        return false;
    }

    public static boolean putUMEk(Context context, String str) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        if (sharedPreferences == null) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return sharedPreferences.edit().putString(SocializeProtocolConstants.PROTOCOL_KEY_ENTITY_KEY, str).commit();
    }

    public static boolean putUMId(Context context, String str) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        if (sharedPreferences == null) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return sharedPreferences.edit().putString("uid", str).commit();
    }

    public static void remove(Context context, String str) {
        getSharedPreferences(context).edit().remove(str).commit();
    }
}
