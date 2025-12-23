package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class g7 {

    /* renamed from: a, reason: collision with root package name */
    static int f6355a = 1000;

    /* renamed from: b, reason: collision with root package name */
    static boolean f6356b = false;

    /* renamed from: c, reason: collision with root package name */
    private static WeakReference<c7> f6357c = null;

    /* renamed from: d, reason: collision with root package name */
    static int f6358d = 20;

    /* renamed from: e, reason: collision with root package name */
    private static int f6359e = 10;

    /* renamed from: f, reason: collision with root package name */
    static int f6360f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a extends b8 {

        /* renamed from: d, reason: collision with root package name */
        private int f6361d;

        /* renamed from: e, reason: collision with root package name */
        private Context f6362e;

        /* renamed from: g, reason: collision with root package name */
        private f7 f6363g;

        a(Context context, int i6) {
            this.f6362e = context;
            this.f6361d = i6;
        }

        @Override // com.amap.api.col.p0003l.b8
        public final void runTask() {
            int i6 = this.f6361d;
            if (i6 == 1) {
                try {
                    synchronized (g7.class) {
                        try {
                            String l6 = Long.toString(System.currentTimeMillis());
                            c7 a6 = j7.a(g7.f6357c);
                            j7.f(this.f6362e, a6, s5.f7239i, g7.f6355a, 2097152, "6");
                            if (a6.f5853e == null) {
                                a6.f5853e = new j6(new l6(new m6(new l6())));
                            }
                            d7.c(l6, this.f6363g.b(), a6);
                        } finally {
                        }
                    }
                    return;
                } catch (Throwable th) {
                    v5.p(th, "ofm", "aple");
                    return;
                }
            }
            if (i6 == 2) {
                try {
                    c7 a7 = j7.a(g7.f6357c);
                    j7.f(this.f6362e, a7, s5.f7239i, g7.f6355a, 2097152, "6");
                    a7.f5856h = 14400000;
                    if (a7.f5855g == null) {
                        a7.f5855g = new n7(new m7(this.f6362e, new r7(), new j6(new l6(new m6())), new String(f5.c()), f4.j(this.f6362e), i4.P(), i4.I(), i4.F(this.f6362e), i4.n(), Build.MANUFACTURER, Build.DEVICE, i4.U(), f4.g(this.f6362e), Build.MODEL, f4.h(this.f6362e), f4.e(this.f6362e), i4.D(this.f6362e), i4.o(this.f6362e), String.valueOf(Build.VERSION.SDK_INT), w4.a(this.f6362e).b()));
                    }
                    if (TextUtils.isEmpty(a7.f5857i)) {
                        a7.f5857i = "fKey";
                    }
                    Context context = this.f6362e;
                    a7.f5854f = new w7(context, a7.f5856h, a7.f5857i, new u7(context, g7.f6356b, g7.f6359e * 1024, g7.f6358d * 1024, "offLocKey", g7.f6360f * 1024));
                    d7.a(a7);
                } catch (Throwable th2) {
                    v5.p(th2, "ofm", "uold");
                }
            }
        }

        a(Context context, f7 f7Var) {
            this(context, 1);
            this.f6363g = f7Var;
        }
    }

    @Deprecated
    public static synchronized void b(int i6, boolean z5) {
        synchronized (g7.class) {
            f6355a = i6;
            f6356b = z5;
        }
    }

    public static synchronized void c(int i6, boolean z5, int i7, int i8) {
        synchronized (g7.class) {
            try {
                f6355a = i6;
                f6356b = z5;
                if (i7 < 10 || i7 > 100) {
                    i7 = 20;
                }
                f6358d = i7;
                if (i7 / 5 > f6359e) {
                    f6359e = i7 / 5;
                }
                f6360f = i8;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized void e(f7 f7Var, Context context) {
        synchronized (g7.class) {
            a8.h().b(new a(context, f7Var));
        }
    }

    public static void d(Context context) {
        a8.h().b(new a(context, 2));
    }
}
