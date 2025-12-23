package cn.jiguang.m;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import cn.jiguang.bb.f;
import cn.jiguang.bz.w;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.kwad.library.solder.lib.ext.PluginError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressLint({"CommitPrefEdits"})
/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static List<Integer> f3090a;

    /* renamed from: b, reason: collision with root package name */
    private static SharedPreferences f3091b;

    /* renamed from: c, reason: collision with root package name */
    private static HashMap<String, Long> f3092c;

    private static long b(String str, String str2) {
        try {
            return f3092c.get(a(str, str2)).longValue();
        } catch (NullPointerException unused) {
            return 0L;
        }
    }

    public static long c(Context context, int i6) {
        return p(context).getLong(b(i6, "method_freq_time_"), 0L);
    }

    public static long d(Context context, int i6) {
        return p(context).getLong(b(i6, "method_freq_ex_time_"), 0L);
    }

    public static int e(Context context) {
        return p(context).getInt("rrat", 1);
    }

    public static int f(Context context) {
        return p(context).getInt("rrpt", 1);
    }

    public static long g(Context context, String str) {
        return p(context).getLong(a(str, "_bi"), b(str, "_bi"));
    }

    public static String h(Context context) {
        return p(context).getString(a("JLocation", "wifiSSID"), "");
    }

    public static long i(Context context, String str) {
        return p(context).getLong(a(str, "_rlt"), 0L);
    }

    public static long j(Context context, String str) {
        return p(context).getLong(a(str, "_ri"), b(str, "_ri"));
    }

    public static boolean k(Context context) {
        return p(context).getBoolean("del_acm", false);
    }

    public static String l(Context context) {
        return p(context).getString("JDeviceIds", "");
    }

    public static String m(Context context) {
        return p(context).getString("lo_cf", "");
    }

    public static int n(Context context, String str) {
        if (w.a(str)) {
            return Integer.MAX_VALUE;
        }
        return p(context).getInt(str, 0);
    }

    private static void o(Context context) {
        f3091b = context.getSharedPreferences("cn.jiguang.common", 0);
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SharedPreferences p(Context context) {
        if (f3091b == null) {
            o(context);
        }
        return f3091b;
    }

    public static int q(Context context, String str) {
        return p(context).getInt(a("JType", "ktsv_" + str), 0);
    }

    static {
        ArrayList arrayList = new ArrayList();
        f3090a = arrayList;
        arrayList.add(Integer.valueOf(GLMapStaticValue.AM_PARAMETERNAME_SETISSTIMAP));
        f3090a.add(Integer.valueOf(PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW));
        f3090a.add(Integer.valueOf(PluginError.ERROR_UPD_FILE_NOT_FOUND));
        f3090a.add(2002);
        f3090a.add(Integer.valueOf(PluginError.ERROR_UPD_REQUEST));
        f3090a.add(Integer.valueOf(PluginError.ERROR_UPD_NO_DOWNLOADER));
        f3090a.add(2014);
        f3090a.add(Integer.valueOf(PointerIconCompat.TYPE_GRAB));
    }

    public static String a(Context context, int i6, boolean z5) {
        String string = p(context).getString(b(i6, c(i6)), "");
        return !TextUtils.isEmpty(string) ? z5 ? cn.jiguang.d.a.c(string) : string : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(int i6) {
        return f3090a.contains(Integer.valueOf(i6)) ? "method_freq_cache_new" : "method_freq_cache_";
    }

    public static String d(Context context) {
        return p(context).getString("JWakeLocalState", "");
    }

    public static void e(Context context, String str) {
        a(context, str, System.currentTimeMillis());
    }

    public static long f(Context context, String str) {
        return p(context).getLong(a(str, "_blt"), 0L);
    }

    public static String g(Context context) {
        return p(context).getString(a("JLocation", "info"), "");
    }

    public static void h(Context context, String str) {
        f.f("JCommonConfig", "update " + str + " lastReportTime");
        p(context).edit().putLong(a(str, "_rlt"), System.currentTimeMillis()).apply();
    }

    public static String i(Context context) {
        return p(context).getString("JNotificationState", "");
    }

    public static String j(Context context) {
        return p(context).getString("JDevicesession", "");
    }

    public static boolean k(Context context, String str) {
        return p(context).getBoolean(a(str, "_ace"), true);
    }

    public static boolean l(Context context, String str) {
        return p(context).getBoolean(a(str, "_aue"), true);
    }

    public static void m(Context context, String str) {
        if (w.a(str)) {
            return;
        }
        String q5 = q(context);
        if (q5 != null && !q5.equals(str)) {
            p(context).edit().remove(q5).apply();
        }
        p(context).edit().putString("current_time_key", str).apply();
    }

    public static void o(Context context, String str) {
        p(context).edit().putString("JWakeLocalState", str).apply();
    }

    public static String p(Context context, String str) {
        return p(context).getString(a("JType", str), "-1,-1");
    }

    private static String q(Context context) {
        return p(context).getString("current_time_key", null);
    }

    public static void r(Context context, String str) {
        p(context).edit().putString(a("JLocation", "info"), str).apply();
    }

    public static void s(Context context, String str) {
        p(context).edit().putString(a("JLocation", "wifiSSID"), str).apply();
    }

    public static void u(Context context, String str) {
        f.f("JCommonConfig", "update deviceSession");
        p(context).edit().putString("JDevicesession", str).apply();
    }

    private static String a(String str, String str2) {
        return str + str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(int i6, String str) {
        return str + i6;
    }

    public static void c(Context context, String str, long j6) {
        if (j6 < 0) {
            return;
        }
        String a6 = a(str, "_ri");
        f.f("JCommonConfig", "update " + str + " reportInterval:" + j6);
        p(context).edit().putLong(a6, j6).apply();
    }

    public static boolean d(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        long i6 = i(context, str);
        long j6 = j(context, str);
        boolean z5 = currentTimeMillis - i6 > j6;
        f.f("JCommonConfig", "is " + str + " reportTime:" + z5 + ",curTime:" + currentTimeMillis + ",lastReportTime:" + i6 + ",reportInterval:" + j6);
        return z5;
    }

    public static void t(Context context, String str) {
        p(context).edit().putString("JNotificationState", str).apply();
    }

    public static void v(Context context, String str) {
        p(context).edit().putString("JDeviceIds", str).apply();
    }

    public static void w(Context context, String str) {
        p(context).edit().putString("lo_cf", str).apply();
    }

    public static boolean x(Context context, String str) {
        boolean z5;
        long currentTimeMillis = System.currentTimeMillis();
        long f6 = f(context, str);
        long b6 = cn.jiguang.g.a.a().b("JAppAll");
        if (currentTimeMillis - f6 > b6) {
            z5 = true;
        } else {
            z5 = false;
        }
        f.f("JCommonConfig", "is " + str + " businessTime:" + z5 + ",curTime:" + currentTimeMillis + ",lastBusinessTime:" + f6 + ",businessInterval:" + b6);
        return z5;
    }

    public static boolean y(Context context, String str) {
        boolean z5;
        long currentTimeMillis = System.currentTimeMillis();
        long i6 = i(context, str);
        long d6 = cn.jiguang.g.a.a().d("JAppAll");
        if (currentTimeMillis - i6 > d6) {
            z5 = true;
        } else {
            z5 = false;
        }
        f.f("JCommonConfig", "is " + str + " reportTime:" + z5 + ",curTime:" + currentTimeMillis + ",lastReportTime:" + i6 + ",reportInterval:" + d6);
        return z5;
    }

    private static void a() {
        HashMap<String, Long> hashMap = new HashMap<>();
        f3092c = hashMap;
        hashMap.put(a("JDataConfigManager", "_bi"), 86400000L);
        f3092c.put(a("JWakeReport", "_ri"), 3600000L);
    }

    public static void b(Context context) {
        String q5 = q(context);
        p(context).edit().putInt(q5, p(context).getInt(q5, 0) + 1).apply();
    }

    public static boolean c(Context context) {
        return p(context).getBoolean(a("user_wake", "_aue"), true);
    }

    public static void a(Context context) {
        p(context).edit().clear().apply();
    }

    public static void b(Context context, int i6) {
        p(context).edit().putInt("rrpt", i6).apply();
    }

    public static boolean c(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        long i6 = i(context, str);
        long d6 = cn.jiguang.g.a.a().d(str);
        boolean z5 = currentTimeMillis - i6 > d6;
        f.f("JCommonConfig", "is " + str + " reportTime:" + z5 + ",curTime:" + currentTimeMillis + ",lastReportTime:" + i6 + ",reportInterval:" + d6);
        return z5;
    }

    public static void a(Context context, int i6) {
        p(context).edit().putInt("rrat", i6).apply();
    }

    public static void b(Context context, int i6, long j6) {
        if (j6 < 0) {
            return;
        }
        String b6 = b(i6, "method_freq_ex_time_");
        f.f("JCommonConfig", "update " + i6 + " method time :" + j6);
        p(context).edit().putLong(b6, j6).apply();
    }

    public static void a(Context context, int i6, long j6) {
        if (j6 < 0) {
            return;
        }
        String b6 = b(i6, "method_freq_time_");
        f.f("JCommonConfig", "update " + i6 + " method time :" + j6);
        p(context).edit().putLong(b6, j6).apply();
    }

    public static void b(Context context, String str, long j6) {
        if (j6 < 0) {
            return;
        }
        if (!str.contains("JLocation") || j6 <= j(context, "JLocationv2")) {
            String a6 = a(str, "_bi");
            f.f("JCommonConfig", "update " + str + " businessInterval:" + j6);
            p(context).edit().putLong(a6, j6).apply();
        }
    }

    public static void a(final Context context, final int i6, final String str, final boolean z5) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        cn.jiguang.be.b.e(new Runnable() { // from class: cn.jiguang.m.b.1
            @Override // java.lang.Runnable
            public void run() {
                int i7 = i6;
                String b6 = b.b(i7, b.c(i7));
                f.f("JCommonConfig", "update " + i6 + " method cache :" + str);
                String str2 = str;
                if (z5) {
                    str2 = cn.jiguang.d.a.b(str2);
                }
                b.p(context).edit().putString(b6, str2).apply();
            }
        });
    }

    public static void b(Context context, String str, boolean z5) {
        p(context).edit().putBoolean(a(str, "_aue"), z5).apply();
    }

    public static void a(Context context, String str, int i6) {
        p(context).edit().putInt(a("JType", "ktsv_" + str), i6).apply();
    }

    public static void b(Context context, boolean z5) {
        p(context).edit().putBoolean("del_acm", z5).apply();
    }

    public static void a(Context context, String str, long j6) {
        String a6 = a(str, "_blt");
        f.f("JCommonConfig", "update " + str + " lastBusinessTime:" + j6);
        p(context).edit().putLong(a6, j6).apply();
    }

    public static boolean b(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        long f6 = f(context, str);
        long g6 = g(context, str);
        boolean z5 = currentTimeMillis - f6 > g6;
        f.f("JCommonConfig", "is " + str + " businessTime:" + z5 + ",curTime:" + currentTimeMillis + ",lastBusinessTime:" + f6 + ",businessInterval:" + g6);
        return z5;
    }

    public static void a(Context context, String str, String str2) {
        p(context).edit().putString(a("JType", str), str2).apply();
    }

    public static void a(Context context, String str, boolean z5) {
        p(context).edit().putBoolean(a(str, "_ace"), z5).apply();
    }

    public static void a(Context context, boolean z5) {
        p(context).edit().putBoolean(a("user_wake", "_aue"), z5).apply();
    }

    public static boolean a(int i6) {
        boolean z5 = !cn.jiguang.be.b.f2036b.get() && cn.jiguang.g.a.a().c(i6) == 0;
        f.a(i6, "JCommonConfig", "configId : " + i6 + ", isBackgroundBusiness : " + z5);
        return z5;
    }

    public static boolean a(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        long f6 = f(context, str);
        long b6 = cn.jiguang.g.a.a().b(str);
        boolean z5 = currentTimeMillis - f6 > b6;
        f.f("JCommonConfig", "is " + str + " businessTime:" + z5 + ",curTime:" + currentTimeMillis + ",lastBusinessTime:" + f6 + ",businessInterval:" + b6);
        return z5;
    }
}
