package cn.jpush.android.p;

import android.content.Context;
import android.content.SharedPreferences;
import com.stub.StubApp;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static SharedPreferences f3753a;

    public static long a(Context context) {
        return c(context).getLong("key_in_app_last_show_time", -1L);
    }

    public static void a(Context context, long j6) {
        c(context).edit().putLong("key_in_app_last_show_time", j6).apply();
    }

    private static SharedPreferences c(Context context) {
        if (f3753a == null) {
            f3753a = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences("cn.jiguang.union.ads.core.common.prefs", 0);
        }
        return f3753a;
    }

    public static void a(Context context, String str) {
        c(context).edit().putString("notify_inapp_latest_state", str).apply();
    }

    public static String b(Context context) {
        return c(context).getString("top_banner_latest_state", "");
    }
}
