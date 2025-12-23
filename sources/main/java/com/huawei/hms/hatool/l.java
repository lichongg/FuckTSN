package com.huawei.hms.hatool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"ApplySharedPref"})
/* loaded from: D:\Downloads\app\classes5.dex */
public class l {
    public static long a(Context context, String str, String str2, long j6) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            j1.m("hmsSdk", "context is null or spName empty or spkey is empty");
            return j6;
        }
        SharedPreferences e6 = e(context, str);
        return e6 != null ? e6.getLong(str2, j6) : j6;
    }

    public static String b(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            j1.m("hmsSdk", "context is null or spName empty or spkey is empty");
            return str3;
        }
        SharedPreferences e6 = e(context, str);
        return e6 != null ? e6.getString(str2, str3) : str3;
    }

    public static void d(Context context, String str, String... strArr) {
        if (context == null || TextUtils.isEmpty(str)) {
            j1.m("hmsSdk", "clearData(): parameter error.context,spname");
            return;
        }
        if (strArr == null) {
            j1.m("hmsSdk", "clearData(): No data need to be deleted,keys is null");
            return;
        }
        SharedPreferences e6 = e(context, str);
        if (e6 != null) {
            SharedPreferences.Editor edit = e6.edit();
            if (strArr.length == 0) {
                edit.clear();
                edit.commit();
                return;
            }
            for (String str2 : strArr) {
                if (e6.contains(str2)) {
                    edit.remove(str2);
                    edit.commit();
                }
            }
        }
    }

    public static void f(Context context, String str, String str2, long j6) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            j1.m("hmsSdk", "context is null or spName empty or spkey is empty");
            return;
        }
        SharedPreferences e6 = e(context, str);
        if (e6 != null) {
            SharedPreferences.Editor edit = e6.edit();
            edit.putLong(str2, j6);
            edit.commit();
        }
    }

    public static void g(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            j1.l("hmsSdk", "context is null or spName empty or spkey is empty");
            return;
        }
        SharedPreferences e6 = e(context, str);
        if (e6 != null) {
            SharedPreferences.Editor edit = e6.edit();
            edit.putString(str2, str3);
            edit.commit();
        }
    }

    public static Map<String, ?> c(Context context, String str) {
        return e(context, str).getAll();
    }

    private static SharedPreferences e(Context context, String str) {
        return context.getSharedPreferences(h(context, str), 0);
    }

    public static String h(Context context, String str) {
        String packageName = context.getPackageName();
        String o5 = c.o("_hms_config_tag", "oper");
        if (TextUtils.isEmpty(o5)) {
            return "hms_" + str + "_" + packageName;
        }
        return "hms_" + str + "_" + packageName + "_" + o5;
    }
}
