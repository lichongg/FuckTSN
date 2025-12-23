package com.amap.api.col.s;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class f3 {

    /* renamed from: a, reason: collision with root package name */
    static int f8073a = 1000;

    /* renamed from: b, reason: collision with root package name */
    static boolean f8074b = false;

    /* renamed from: c, reason: collision with root package name */
    private static WeakReference<c3> f8075c = null;

    /* renamed from: d, reason: collision with root package name */
    static int f8076d = 20;

    /* renamed from: e, reason: collision with root package name */
    private static int f8077e = 10;

    /* renamed from: f, reason: collision with root package name */
    static int f8078f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a extends z3 {

        /* renamed from: b, reason: collision with root package name */
        private int f8079b = 2;

        /* renamed from: c, reason: collision with root package name */
        private Context f8080c;

        /* renamed from: d, reason: collision with root package name */
        private e3 f8081d;

        @Override // com.amap.api.col.s.z3
        public final void a() {
            int i6 = this.f8079b;
            if (i6 == 1) {
                try {
                    synchronized (f3.class) {
                        try {
                            String l6 = Long.toString(System.currentTimeMillis());
                            c3 a6 = i3.a(f3.f8075c);
                            i3.e(this.f8080c, a6, e2.f8058i, f3.f8073a, 2097152, "6");
                            if (a6.f7935e == null) {
                                a6.f7935e = new m2(new o2(new p2(new o2())));
                            }
                            d3.c(l6, this.f8081d.b(), a6);
                        } finally {
                        }
                    }
                    return;
                } catch (Throwable th) {
                    g2.o(th, "ofm", "aple");
                    return;
                }
            }
            if (i6 == 2) {
                try {
                    c3 a7 = i3.a(f3.f8075c);
                    i3.e(this.f8080c, a7, e2.f8058i, f3.f8073a, 2097152, "6");
                    a7.f7938h = 14400000;
                    if (a7.f7937g == null) {
                        a7.f7937g = new m3(new l3(this.f8080c, new q3(), new m2(new o2(new p2())), new String(s1.c()), x0.i(this.f8080c), c1.H(), c1.C(), c1.y(this.f8080c), c1.i(), Build.MANUFACTURER, Build.DEVICE, c1.M(), x0.f(this.f8080c), Build.MODEL, x0.g(this.f8080c), x0.d(this.f8080c), c1.w(this.f8080c), c1.j(this.f8080c), String.valueOf(Build.VERSION.SDK_INT), o1.a(this.f8080c).b()));
                    }
                    if (TextUtils.isEmpty(a7.f7939i)) {
                        a7.f7939i = "fKey";
                    }
                    Context context = this.f8080c;
                    a7.f7936f = new u3(context, a7.f7938h, a7.f7939i, new s3(context, f3.f8074b, f3.f8077e * 1024, f3.f8076d * 1024, "offLocKey", f3.f8078f * 1024));
                    d3.a(a7);
                } catch (Throwable th2) {
                    g2.o(th2, "ofm", "uold");
                }
            }
        }

        a(Context context) {
            this.f8080c = context;
        }
    }

    public static void b(Context context) {
        y3.e().c(new a(context));
    }
}
