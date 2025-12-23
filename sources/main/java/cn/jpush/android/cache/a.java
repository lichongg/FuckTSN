package cn.jpush.android.cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import cn.jpush.android.ad.l;
import cn.jpush.android.ad.m;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.helper.Logger;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static SharedPreferences f3580a;

    public static void a(Context context) {
        f3580a = context.getSharedPreferences("cn.jpush.config", 0);
    }

    public static int b(Context context) {
        SharedPreferences reload = Sp.reload(context, "cn.jpush.config");
        if (reload == null) {
            reload = v(context);
        }
        int i6 = reload.getInt("service_stoped", -1);
        if (i6 >= 0) {
            return i6;
        }
        int i7 = context.getSharedPreferences("cn.jpush.android.user.profile", 0).getInt("service_stoped", 0);
        a(context, i7);
        return i7;
    }

    public static long c(Context context, long j6) {
        long j7 = v(context).getLong("geofence_interval", -1L);
        if (j7 == -1) {
            j7 = context.getSharedPreferences("cn.jpush.android.user.profile", 0).getLong("geofence_interval", -1L);
            if (j7 != -1) {
                b(context, j7);
            }
        }
        return j7 == -1 ? j6 : j7;
    }

    public static String d(Context context, String str) {
        String string = v(context).getString("jpush_save_custom_builder" + str, "");
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String string2 = context.getSharedPreferences("cn.jpush.android.user.profile", 0).getString("jpush_save_custom_builder" + str, "");
        a(context, str, string2);
        return string2;
    }

    public static int e(Context context, int i6) {
        int i7 = v(context).getInt("geofence_max_num", -1);
        if (i7 == -1 && (i7 = context.getSharedPreferences("cn.jpush.android.user.profile", 0).getInt("geofence_max_num", -1)) != -1) {
            d(context, i7);
        }
        return i7 == -1 ? i6 : i7;
    }

    public static String f(Context context) {
        String string = v(context).getString("mobile_number", null);
        return !TextUtils.isEmpty(string) ? l.b(string, m.f3488a) : string;
    }

    public static String g(Context context, String str) {
        return (String) Sp.get(context, Key.JAppKey(str));
    }

    public static String h(Context context) {
        return v(context).getString("setting_push_time", "");
    }

    public static String i(Context context) {
        return v(context).getString("setting_silence_push_time", "");
    }

    public static int j(Context context) {
        return v(context).getInt("notification_num", JPushInterface.DEFAULT_NOTIFICATION_NUM);
    }

    public static void a(Context context, int i6) {
        v(context).edit().putInt("service_stoped", i6).apply();
    }

    public static void b(Context context, long j6) {
        v(context).edit().putLong("geofence_interval", j6).apply();
    }

    public static void c(Context context, int i6) {
        v(context).edit().putInt("notification_num", i6).apply();
    }

    public static void d(Context context, int i6) {
        v(context).edit().putInt("geofence_max_num", i6).apply();
    }

    public static void e(Context context, String str) {
        v(context).edit().putString("geofence_pull_limit", str).apply();
    }

    public static void f(Context context, int i6) {
        Sp.set(context, Key.registerType().set(Integer.valueOf(i6)));
    }

    public static void g(Context context, boolean z5) {
        v(context).edit().putBoolean("push_data_insights_enable", z5).apply();
    }

    public static String h(Context context, String str) {
        return (String) Sp.get(context, Key.MAppKey(str));
    }

    public static String i(Context context, String str) {
        return (String) Sp.get(context, Key.MAppId(str));
    }

    public static String j(Context context, String str) {
        return (String) Sp.get(context, Key.MAppSecret(str));
    }

    private static SharedPreferences v(Context context) {
        if (f3580a == null) {
            a(context);
        }
        return f3580a;
    }

    public static void a(Context context, long j6) {
        if (j6 < 0) {
            Logger.w("PushConfig", "freeze end time was incorrect!");
            return;
        }
        if (j6 > 1800) {
            Logger.i("PushConfig", "freeze end time was greate than half an hour");
            j6 = 1800;
        }
        v(context).edit().putLong("TAFreezeSetTime", System.currentTimeMillis()).putLong("TAFreezeEndTime", j6 * 1000).apply();
    }

    public static void b(Context context, String str) {
        v(context).edit().putString("setting_push_time", str).apply();
    }

    public static void c(Context context, String str) {
        v(context).edit().putString("setting_silence_push_time", str).apply();
    }

    public static void d(Context context, long j6) {
        v(context).edit().putLong("p_last_time", j6).apply();
    }

    public static void e(Context context, String str, String str2) {
        Sp.set(context, Key.MAppSecret(str).set(str2));
    }

    public static void f(Context context, String str) {
        v(context).edit().putString("geofence_last_pull_state", str).apply();
    }

    public static boolean g(Context context) {
        return v(context).getBoolean("notification_enabled", true);
    }

    public static void h(Context context, boolean z5) {
        v(context).edit().putBoolean("push_notification_callback_enable", z5).apply();
    }

    public static void i(Context context, boolean z5) {
        v(context).edit().putBoolean("push_smart_enable", z5).apply();
    }

    public static boolean k(Context context) {
        long j6 = v(context).getLong("TAFreezeEndTime", -1L);
        if (j6 > 1800) {
            j6 = 0;
        }
        long j7 = v(context).getLong("TAFreezeSetTime", -1L);
        if (j6 == -1 || j7 == -1) {
            return false;
        }
        if (System.currentTimeMillis() - j7 >= 0 && System.currentTimeMillis() - j7 <= j6) {
            return false;
        }
        v(context).edit().putLong("TAFreezeSetTime", -1L).putLong("TAFreezeEndTime", -1L).apply();
        Logger.w("PushConfig", "incorrect timestamp");
        return true;
    }

    public static boolean l(Context context) {
        return v(context).getBoolean("geofence_pull_enable", false);
    }

    public static String m(Context context) {
        return v(context).getString("geofence_pull_limit", "");
    }

    public static String n(Context context) {
        return v(context).getString("geofence_last_pull_state", "");
    }

    public static boolean o(Context context) {
        return v(context).getBoolean("push_geofence_enable", true);
    }

    public static boolean p(Context context) {
        return v(context).getBoolean("push_link_enable", true);
    }

    public static boolean q(Context context) {
        return v(context).getBoolean("push_data_insights_enable", true);
    }

    public static boolean r(Context context) {
        return v(context).getBoolean("push_notification_callback_enable", false);
    }

    public static boolean s(Context context) {
        return v(context).getBoolean("push_smart_enable", true);
    }

    public static long t(Context context) {
        return v(context).getLong("p_last_time", 0L);
    }

    public static int u(Context context) {
        return ((Integer) Sp.get(context, Key.registerType())).intValue();
    }

    public static void a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            str = l.a(str, m.f3488a);
        }
        v(context).edit().putString("mobile_number", str).apply();
    }

    public static void b(Context context, String str, String str2) {
        Sp.set(context, Key.JAppKey(str).set(str2));
    }

    public static void c(Context context, String str, String str2) {
        Sp.set(context, Key.MAppKey(str).set(str2));
    }

    public static void d(Context context, String str, String str2) {
        Sp.set(context, Key.MAppId(str).set(str2));
    }

    public static void e(Context context, boolean z5) {
        v(context).edit().putBoolean("push_geofence_enable", z5).apply();
    }

    public static void f(Context context, boolean z5) {
        v(context).edit().putBoolean("push_link_enable", z5).apply();
    }

    public static void a(Context context, String str, String str2) {
        v(context).edit().putString("jpush_save_custom_builder" + str, str2).apply();
    }

    public static void b(Context context, boolean z5) {
        v(context).edit().putBoolean("tcp_state", z5).apply();
    }

    public static void c(Context context, boolean z5) {
        v(context).edit().putBoolean("notification_enabled", z5).apply();
    }

    public static void d(Context context, boolean z5) {
        v(context).edit().putBoolean("geofence_pull_enable", z5).apply();
    }

    public static boolean e(Context context) {
        String str;
        if (b(context) >= 1 || d(context)) {
            str = "The service is stopped, it will give up all the actions until you call resumePush method to resume the service.";
        } else if (!c(context)) {
            str = "The service is stopped, it will give up all the actions until you call JPushUPSManager.trunOn method to resume the service.";
        } else {
            if (((Boolean) Sp.get(context, Key.UPSRegister())).booleanValue()) {
                return false;
            }
            str = "The service is stopped, it will give up all the actions until you call JPushUPSManager.registerToken method to resume the service.";
        }
        Logger.dd("PushConfig", str);
        return true;
    }

    public static void a(Context context, boolean z5) {
        v(context).edit().putBoolean("ups_state", z5).apply();
    }

    public static boolean b(Context context, int i6) {
        String str;
        if (i6 != 0 && b(context) >= 1) {
            str = "The service is stopped, it will give up all the actions until you call resumePush method to resume the service.";
        } else if (i6 != 1 && !c(context)) {
            str = "The service is stopped, it will give up all the actions until you call JPushUPSManager.trunOn method to resume the service.";
        } else {
            if (i6 == 2 || ((Boolean) Sp.get(context, Key.UPSRegister())).booleanValue()) {
                return false;
            }
            str = "The service is stopped, it will give up all the actions until you call JPushUPSManager.registerToken method to resume the service.";
        }
        Logger.ww("PushConfig", str);
        return true;
    }

    public static boolean c(Context context) {
        return v(context).getBoolean("ups_state", true);
    }

    public static boolean d(Context context) {
        return v(context).getBoolean("tcp_state", false);
    }
}
