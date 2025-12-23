package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Build;
import com.snail.antifake.deviceid.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class w5 {

    /* renamed from: a, reason: collision with root package name */
    private static WeakReference<c7> f7514a = null;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f7515b = true;

    /* renamed from: c, reason: collision with root package name */
    private static WeakReference<x7> f7516c;

    /* renamed from: d, reason: collision with root package name */
    private static WeakReference<x7> f7517d;

    /* renamed from: e, reason: collision with root package name */
    private static String[] f7518e = new String[10];

    /* renamed from: f, reason: collision with root package name */
    private static int f7519f;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f7520g;

    /* renamed from: h, reason: collision with root package name */
    private static int f7521h;

    /* renamed from: i, reason: collision with root package name */
    private static p4 f7522i;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a extends b8 {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f7523d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ p4 f7524e;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f7525g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f7526h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ c7 f7527i;

        a(Context context, p4 p4Var, String str, String str2, c7 c7Var) {
            this.f7523d = context;
            this.f7524e = p4Var;
            this.f7525g = str;
            this.f7526h = str2;
            this.f7527i = c7Var;
        }

        @Override // com.amap.api.col.p0003l.b8
        public final void runTask() {
            String b6 = w5.b(this.f7523d, this.f7524e, this.f7525g, this.f7526h);
            c7 c7Var = this.f7527i;
            if (c7Var.f5853e == null) {
                c7Var.f5853e = new i6(new j6(new l6(new m6())));
            }
            try {
                d7.c(m4.e(b6), q4.o(b6), this.f7527i);
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b extends b8 {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f7528d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f7529e;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ x7 f7530g;

        b(Context context, String str, x7 x7Var) {
            this.f7528d = context;
            this.f7529e = str;
            this.f7530g = x7Var;
        }

        @Override // com.amap.api.col.p0003l.b8
        public final void runTask() {
            try {
                synchronized (w5.class) {
                    try {
                        c7 a6 = j7.a(w5.f7514a);
                        j7.f(this.f7528d, a6, this.f7529e, 1000, 4096000, "1");
                        a6.f5854f = this.f7530g;
                        if (a6.f5855g == null) {
                            a6.f5855g = new n7(new m7(this.f7528d, new r7(), new j6(new l6(new m6())), "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", f4.j(this.f7528d), i4.P(), i4.Z(this.f7528d), f4.g(this.f7528d), Build.MODEL, f4.e(this.f7528d), f4.h(this.f7528d), Build.VERSION.RELEASE));
                        }
                        a6.f5856h = 3600000;
                        d7.a(a6);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                v5.p(th2, "lg", "pul");
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class c extends b8 {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c7 f7531d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f7532e;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ d f7533g;

        c(c7 c7Var, Context context, d dVar) {
            this.f7531d = c7Var;
            this.f7532e = context;
            this.f7533g = dVar;
        }

        @Override // com.amap.api.col.p0003l.b8
        public final void runTask() {
            try {
                synchronized (w5.class) {
                    try {
                        c7 c7Var = this.f7531d;
                        if (c7Var.f5855g == null) {
                            c7Var.f5855g = new n7(new m7(this.f7532e, new r7(), new j6(new l6(new m6())), "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", f4.j(this.f7532e), i4.P(), i4.Z(this.f7532e), f4.g(this.f7532e), Build.MODEL, f4.e(this.f7532e), f4.h(this.f7532e), Build.VERSION.RELEASE));
                        }
                        int a6 = d7.a(this.f7531d);
                        d dVar = this.f7533g;
                        if (dVar != null) {
                            dVar.a(a6);
                        }
                    } finally {
                    }
                }
            } catch (Throwable th) {
                v5.p(th, "lg", "pul");
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface d {
        void a(int i6);
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
    private static java.lang.String c(java.util.List<com.amap.api.col.p0003l.p4> r11) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.w5.c(java.util.List):java.lang.String");
    }

    public static void g(Context context, p4 p4Var, String str, int i6, String str2, String str3) {
        if (str2 == null || "".equals(str2)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("class:");
        sb.append(str2);
        if (str3 != null) {
            sb.append(" method:");
            sb.append(str3);
            sb.append("$<br/>");
        }
        sb.append(str);
        f(context, p4Var, i6, str2, sb.toString());
    }

    private static boolean m(p4 p4Var) {
        return p4Var != null && p4Var.h();
    }

    private static String n() {
        StringBuilder sb = new StringBuilder();
        try {
            for (int i6 = f7519f; i6 < 10 && i6 <= 9; i6++) {
                sb.append(f7518e[i6]);
            }
            for (int i7 = 0; i7 < f7519f; i7++) {
                sb.append(f7518e[i7]);
            }
        } catch (Throwable th) {
            v5.p(th, "alg", "gLI");
        }
        return sb.toString();
    }

    static void o(Context context) {
        v7 v7Var = new v7(f7515b);
        f7515b = false;
        j(context, v7Var, s5.f7233c);
    }

    static void p(Context context) {
        WeakReference<x7> weakReference = f7516c;
        if (weakReference == null || weakReference.get() == null) {
            f7516c = new WeakReference<>(new w7(context, 3600000, "hKey", new y7(context, false)));
        }
        j(context, f7516c.get(), s5.f7234d);
    }

    static void q(Context context) {
        WeakReference<x7> weakReference = f7517d;
        if (weakReference == null || weakReference.get() == null) {
            f7517d = new WeakReference<>(new w7(context, 3600000, "gKey", new y7(context, false)));
        }
        j(context, f7517d.get(), s5.f7232b);
    }

    private static p4 a(String str) {
        List<p4> b6 = s5.b();
        if (b6 == null) {
            b6 = new ArrayList();
        }
        if (str != null && !"".equals(str)) {
            for (p4 p4Var : b6) {
                if (s5.f(p4Var.i(), str)) {
                    return p4Var;
                }
            }
            if (str.contains("com.amap.api.col")) {
                try {
                    return q4.a();
                } catch (fk e6) {
                    e6.printStackTrace();
                }
            }
            if (str.contains("com.amap.co") || str.contains("com.amap.opensdk.co") || str.contains("com.amap.location")) {
                try {
                    p4 p5 = q4.p();
                    p5.c(true);
                    return p5;
                } catch (fk e7) {
                    e7.printStackTrace();
                }
            }
        }
        return null;
    }

    static /* synthetic */ String b(Context context, p4 p4Var, String str, String str2) {
        String b6 = j7.b();
        String c6 = j7.c(context, p4Var);
        f4.a(context);
        return j7.e(c6, b6, str, str2);
    }

    static void e(Context context) {
        String c6;
        p4 p4Var;
        List<p4> b6 = s5.b();
        if (b6 != null && b6.size() != 0 && (c6 = c(b6)) != null && !"".equals(c6) && (p4Var = f7522i) != null) {
            f(context, p4Var, 2, "ANR", c6);
        }
    }

    private static void f(Context context, p4 p4Var, int i6, String str, String str2) {
        String str3;
        String b6 = j7.b();
        String c6 = j7.c(context, p4Var);
        f4.a(context);
        String d6 = j7.d(c6, b6, i6, str, str2);
        if (d6 != null && !"".equals(d6)) {
            String e6 = m4.e(str2);
            if (i6 == 1) {
                str3 = s5.f7232b;
            } else if (i6 == 2) {
                str3 = s5.f7234d;
            } else if (i6 == 0) {
                str3 = s5.f7233c;
            } else {
                return;
            }
            String str4 = str3;
            c7 a6 = j7.a(f7514a);
            j7.f(context, a6, str4, 1000, 4096000, "1");
            if (a6.f5853e == null) {
                a6.f5853e = new i6(new j6(new l6(new m6())));
            }
            try {
                d7.c(e6, q4.o(d6.replaceAll(e.f37542d, "<br/>")), a6);
            } catch (Throwable unused) {
            }
        }
    }

    public static void h(Context context, p4 p4Var, String str, c7 c7Var, String str2) {
        try {
            a8.h().b(new a(context, p4Var, str, str2, c7Var));
        } catch (Throwable unused) {
        }
    }

    public static void i(Context context, c7 c7Var, d dVar) {
        try {
            a8.h().b(new c(c7Var, context, dVar));
        } catch (Throwable unused) {
        }
    }

    private static void j(Context context, x7 x7Var, String str) {
        a8.h().b(new b(context, str, x7Var));
    }

    public static void k(Context context, Throwable th, int i6, String str, String str2) {
        String e6 = q4.e(th);
        p4 a6 = a(e6);
        if (m(a6)) {
            String replaceAll = e6.replaceAll(e.f37542d, "<br/>");
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
                f(context, a6, i6, th2, sb.toString());
            }
        }
    }

    static void l(p4 p4Var, Context context, String str, String str2) {
        if (m(p4Var) && str != null && !"".equals(str)) {
            f(context, p4Var, 1, str, str2);
        }
    }
}
