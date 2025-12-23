package com.amap.api.col.p0003l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class z2 {

    /* renamed from: b, reason: collision with root package name */
    private static volatile z2 f7796b;

    /* renamed from: a, reason: collision with root package name */
    private a8 f7797a;

    public static z2 a() {
        if (f7796b == null) {
            synchronized (z2.class) {
                try {
                    if (f7796b == null) {
                        f7796b = new z2();
                    }
                } finally {
                }
            }
        }
        return f7796b;
    }

    public static void c() {
        if (f7796b != null) {
            try {
                if (f7796b.f7797a != null) {
                    f7796b.f7797a.g();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            f7796b.f7797a = null;
            f7796b = null;
        }
    }

    public static void d(b8 b8Var) {
        if (b8Var != null) {
            try {
                b8Var.cancelTask();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void b(b8 b8Var) {
        try {
            this.f7797a.b(b8Var);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private z2() {
        this.f7797a = null;
        this.f7797a = a3.b("AMapThreadUtil");
    }
}
