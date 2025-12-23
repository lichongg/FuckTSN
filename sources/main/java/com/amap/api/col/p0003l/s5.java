package com.amap.api.col.p0003l;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import com.snail.antifake.deviceid.e;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class s5 {

    /* renamed from: a, reason: collision with root package name */
    public static final String f7231a = "/a/";

    /* renamed from: b, reason: collision with root package name */
    static final String f7232b = "b";

    /* renamed from: c, reason: collision with root package name */
    static final String f7233c = "c";

    /* renamed from: d, reason: collision with root package name */
    static final String f7234d = "d";

    /* renamed from: e, reason: collision with root package name */
    public static String f7235e = "s";

    /* renamed from: f, reason: collision with root package name */
    public static final String f7236f = "g";

    /* renamed from: g, reason: collision with root package name */
    public static final String f7237g = "h";

    /* renamed from: h, reason: collision with root package name */
    public static final String f7238h = "e";

    /* renamed from: i, reason: collision with root package name */
    public static final String f7239i = "f";

    /* renamed from: j, reason: collision with root package name */
    public static final String f7240j = "j";

    /* renamed from: k, reason: collision with root package name */
    public static final String f7241k = "k";

    /* renamed from: l, reason: collision with root package name */
    private static long f7242l;

    /* renamed from: m, reason: collision with root package name */
    private static Vector<p4> f7243m = new Vector<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a extends b8 {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f7244d;

        a(Context context) {
            this.f7244d = context;
        }

        @Override // com.amap.api.col.p0003l.b8
        public final void runTask() {
            try {
                w5.o(this.f7244d);
                w5.q(this.f7244d);
                w5.p(this.f7244d);
                i7.b(this.f7244d);
                g7.d(this.f7244d);
            } catch (RejectedExecutionException unused) {
            } catch (Throwable th) {
                v5.p(th, "Lg", "proL");
            }
        }
    }

    static boolean f(String[] strArr, String str) {
        if (strArr != null && str != null) {
            try {
                String[] split = str.split(e.f37542d);
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
        return context.getFilesDir().getAbsolutePath() + f7231a + str;
    }

    static List<p4> b() {
        Vector<p4> vector;
        try {
            synchronized (Looper.getMainLooper()) {
                vector = f7243m;
            }
            return vector;
        } catch (Throwable th) {
            th.printStackTrace();
            return f7243m;
        }
    }

    public static void c(Context context) {
        try {
            if (System.currentTimeMillis() - f7242l < 60000) {
                return;
            }
            f7242l = System.currentTimeMillis();
            a8.h().b(new a(context));
        } catch (Throwable th) {
            v5.p(th, "Lg", "proL");
        }
    }

    public static void e(p4 p4Var) {
        try {
            synchronized (Looper.getMainLooper()) {
                try {
                    if (p4Var == null) {
                        return;
                    }
                    if (f7243m.contains(p4Var)) {
                        return;
                    }
                    f7243m.add(p4Var);
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable unused) {
        }
    }
}
