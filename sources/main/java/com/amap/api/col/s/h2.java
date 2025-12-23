package com.amap.api.col.s;

import android.content.Context;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class h2 {

    /* renamed from: a, reason: collision with root package name */
    private static WeakReference<c3> f8111a = null;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f8112b = true;

    /* renamed from: c, reason: collision with root package name */
    private static WeakReference<v3> f8113c;

    /* renamed from: d, reason: collision with root package name */
    private static WeakReference<v3> f8114d;

    /* renamed from: e, reason: collision with root package name */
    private static String[] f8115e = new String[10];

    /* renamed from: f, reason: collision with root package name */
    private static int f8116f;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f8117g;

    /* renamed from: h, reason: collision with root package name */
    private static int f8118h;

    /* renamed from: i, reason: collision with root package name */
    private static i1 f8119i;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a extends z3 {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f8120b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f8121c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ v3 f8122d;

        a(Context context, String str, v3 v3Var) {
            this.f8120b = context;
            this.f8121c = str;
            this.f8122d = v3Var;
        }

        @Override // com.amap.api.col.s.z3
        public final void a() {
            try {
                synchronized (h2.class) {
                    try {
                        c3 a6 = i3.a(h2.f8111a);
                        i3.e(this.f8120b, a6, this.f8121c, 1000, 4096000, "1");
                        a6.f7936f = this.f8122d;
                        if (a6.f7937g == null) {
                            a6.f7937g = new m3(new l3(this.f8120b, new q3(), new m2(new o2(new p2())), "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", x0.i(this.f8120b), c1.H(), c1.K(this.f8120b), x0.f(this.f8120b), Build.MODEL, x0.d(this.f8120b), x0.g(this.f8120b), Build.VERSION.RELEASE));
                        }
                        a6.f7938h = 3600000;
                        d3.a(a6);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                g2.o(th2, "lg", "pul");
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x00fc, code lost:
    
        if (r4 == null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x00d7, code lost:
    
        if (r4 == null) goto L90;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0108 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String b(java.util.List<com.amap.api.col.s.i1> r11) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.h2.b(java.util.List):java.lang.String");
    }

    private static boolean i(i1 i1Var) {
        return i1Var != null && i1Var.h();
    }

    private static String j() {
        StringBuilder sb = new StringBuilder();
        try {
            for (int i6 = f8116f; i6 < 10 && i6 <= 9; i6++) {
                sb.append(f8115e[i6]);
            }
            for (int i7 = 0; i7 < f8116f; i7++) {
                sb.append(f8115e[i7]);
            }
        } catch (Throwable th) {
            g2.o(th, "alg", "gLI");
        }
        return sb.toString();
    }

    static void k(Context context) {
        t3 t3Var = new t3(f8112b);
        f8112b = false;
        f(context, t3Var, e2.f8052c);
    }

    static void l(Context context) {
        WeakReference<v3> weakReference = f8113c;
        if (weakReference == null || weakReference.get() == null) {
            f8113c = new WeakReference<>(new u3(context, 3600000, "hKey", new w3(context)));
        }
        f(context, f8113c.get(), e2.f8053d);
    }

    static void m(Context context) {
        WeakReference<v3> weakReference = f8114d;
        if (weakReference == null || weakReference.get() == null) {
            f8114d = new WeakReference<>(new u3(context, 3600000, "gKey", new w3(context)));
        }
        f(context, f8114d.get(), e2.f8051b);
    }

    private static i1 a(String str) {
        List<i1> b6 = e2.b();
        if (b6 == null) {
            b6 = new ArrayList();
        }
        if (str != null && !"".equals(str)) {
            for (i1 i1Var : b6) {
                if (e2.f(i1Var.i(), str)) {
                    return i1Var;
                }
            }
            if (str.contains("com.amap.api.col")) {
                try {
                    return j1.a();
                } catch (bv e6) {
                    e6.printStackTrace();
                }
            }
            if (str.contains("com.amap.co") || str.contains("com.amap.opensdk.co") || str.contains("com.amap.location")) {
                try {
                    i1 p5 = j1.p();
                    p5.b();
                    return p5;
                } catch (bv e7) {
                    e7.printStackTrace();
                }
            }
        }
        return null;
    }

    static void d(Context context) {
        String b6;
        i1 i1Var;
        List<i1> b7 = e2.b();
        if (b7 != null && b7.size() != 0 && (b6 = b(b7)) != null && !"".equals(b6) && (i1Var = f8119i) != null) {
            e(context, i1Var, 2, "ANR", b6);
        }
    }

    private static void e(Context context, i1 i1Var, int i6, String str, String str2) {
        String str3;
        String b6 = i3.b();
        String c6 = i3.c(context, i1Var);
        x0.a(context);
        String d6 = i3.d(c6, b6, i6, str, str2);
        if (d6 != null && !"".equals(d6)) {
            String d7 = g1.d(str2);
            if (i6 == 1) {
                str3 = e2.f8051b;
            } else if (i6 == 2) {
                str3 = e2.f8053d;
            } else if (i6 == 0) {
                str3 = e2.f8052c;
            } else {
                return;
            }
            String str4 = str3;
            c3 a6 = i3.a(f8111a);
            i3.e(context, a6, str4, 1000, 4096000, "1");
            if (a6.f7935e == null) {
                a6.f7935e = new l2(new m2(new o2(new p2())));
            }
            try {
                d3.c(d7, j1.o(d6.replaceAll(com.snail.antifake.deviceid.e.f37542d, "<br/>")), a6);
            } catch (Throwable unused) {
            }
        }
    }

    private static void f(Context context, v3 v3Var, String str) {
        y3.e().c(new a(context, str, v3Var));
    }

    public static void g(Context context, Throwable th, int i6, String str, String str2) {
        String e6 = j1.e(th);
        i1 a6 = a(e6);
        if (i(a6)) {
            String replaceAll = e6.replaceAll(com.snail.antifake.deviceid.e.f37542d, "<br/>");
            String th2 = th.toString();
            if (th2 != null && !"".equals(th2)) {
                StringBuilder sb = new StringBuilder();
                if (str != null) {
                    sb.append("class:");
                    sb.append(str);
                }
                if (str2 != null) {
                    sb.append(" method:");
                    sb.append(str2);
                    sb.append("$<br/>");
                }
                sb.append(replaceAll);
                e(context, a6, i6, th2, sb.toString());
            }
        }
    }

    static void h(i1 i1Var, Context context, String str, String str2) {
        if (i(i1Var) && str != null && !"".equals(str)) {
            e(context, i1Var, 1, str, str2);
        }
    }
}
