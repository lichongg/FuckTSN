package com.amap.api.col.s;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class e2 {

    /* renamed from: a, reason: collision with root package name */
    public static final String f8050a = "/a/";

    /* renamed from: b, reason: collision with root package name */
    static final String f8051b = "b";

    /* renamed from: c, reason: collision with root package name */
    static final String f8052c = "c";

    /* renamed from: d, reason: collision with root package name */
    static final String f8053d = "d";

    /* renamed from: e, reason: collision with root package name */
    public static String f8054e = "s";

    /* renamed from: f, reason: collision with root package name */
    public static final String f8055f = "g";

    /* renamed from: g, reason: collision with root package name */
    public static final String f8056g = "h";

    /* renamed from: h, reason: collision with root package name */
    public static final String f8057h = "e";

    /* renamed from: i, reason: collision with root package name */
    public static final String f8058i = "f";

    /* renamed from: j, reason: collision with root package name */
    public static final String f8059j = "j";

    /* renamed from: k, reason: collision with root package name */
    public static final String f8060k = "k";

    /* renamed from: l, reason: collision with root package name */
    private static long f8061l;

    /* renamed from: m, reason: collision with root package name */
    private static Vector<i1> f8062m = new Vector<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a extends z3 {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f8063b;

        a(Context context) {
            this.f8063b = context;
        }

        @Override // com.amap.api.col.s.z3
        public final void a() {
            try {
                h2.k(this.f8063b);
                h2.m(this.f8063b);
                h2.l(this.f8063b);
                h3.b(this.f8063b);
                f3.b(this.f8063b);
            } catch (RejectedExecutionException unused) {
            } catch (Throwable th) {
                g2.o(th, "Lg", "proL");
            }
        }
    }

    static boolean f(String[] strArr, String str) {
        if (strArr != null && str != null) {
            try {
                String[] split = str.split(com.snail.antifake.deviceid.e.f37542d);
                for (String str2 : split) {
                    String trim = str2.trim();
                    if (!TextUtils.isEmpty(trim) && trim.startsWith("at ") && trim.contains("uncaughtException")) {
                        return false;
                    }
                }
                for (String str3 : split) {
                    if (h(strArr, str3.trim())) {
                        return true;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    static boolean h(String[] strArr, String str) {
        if (strArr != null && str != null) {
            try {
                for (String str2 : strArr) {
                    str = str.trim();
                    if (str.startsWith("at ")) {
                        if (str.contains(str2 + ".") && str.endsWith(")") && !str.contains("uncaughtException")) {
                            return true;
                        }
                    }
                }
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static String a(Context context, String str) {
        return context.getSharedPreferences("AMSKLG_CFG", 0).getString(str, "");
    }

    @TargetApi(9)
    public static void d(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static void g(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.remove(str);
        edit.apply();
    }

    public static String i(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + f8050a + str;
    }

    static List<i1> b() {
        Vector<i1> vector;
        try {
            synchronized (Looper.getMainLooper()) {
                vector = f8062m;
            }
            return vector;
        } catch (Throwable th) {
            th.printStackTrace();
            return f8062m;
        }
    }

    public static void c(Context context) {
        try {
            if (System.currentTimeMillis() - f8061l < 60000) {
                return;
            }
            f8061l = System.currentTimeMillis();
            y3.e().c(new a(context));
        } catch (Throwable th) {
            g2.o(th, "Lg", "proL");
        }
    }

    public static void e(i1 i1Var) {
        try {
            synchronized (Looper.getMainLooper()) {
                try {
                    if (i1Var == null) {
                        return;
                    }
                    if (f8062m.contains(i1Var)) {
                        return;
                    }
                    f8062m.add(i1Var);
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable unused) {
        }
    }
}
