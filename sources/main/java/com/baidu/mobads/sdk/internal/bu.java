package com.baidu.mobads.sdk.internal;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class bu {

    /* renamed from: a, reason: collision with root package name */
    public static final String f10800a = "logger";

    /* renamed from: b, reason: collision with root package name */
    public static final int f10801b = 2;

    /* renamed from: c, reason: collision with root package name */
    public static final int f10802c = 3;

    /* renamed from: d, reason: collision with root package name */
    public static final int f10803d = 4;

    /* renamed from: e, reason: collision with root package name */
    public static final int f10804e = 5;

    /* renamed from: f, reason: collision with root package name */
    public static final int f10805f = 6;

    /* renamed from: g, reason: collision with root package name */
    public static final int f10806g = 7;

    /* renamed from: h, reason: collision with root package name */
    public static final int f10807h = -1;

    /* renamed from: i, reason: collision with root package name */
    private static volatile bu f10808i;

    public boolean a(String str, int i6) {
        return true;
    }

    public void b(String str) {
        if (a(5)) {
            try {
                az.c().e(str);
            } catch (Exception unused) {
            }
        }
    }

    public void c(Object... objArr) {
        if (a(6)) {
            c(e(objArr));
        }
    }

    public void d(String str) {
        b(f10800a, str);
    }

    public static bu a() {
        if (f10808i == null) {
            synchronized (bu.class) {
                try {
                    if (f10808i == null) {
                        f10808i = new bu();
                    }
                } finally {
                }
            }
        }
        return f10808i;
    }

    private String e(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            sb.append(obj);
            sb.append(' ');
        }
        return sb.toString();
    }

    public void d(Object... objArr) {
        if (a(4)) {
            d(e(objArr));
        }
    }

    private bu() {
    }

    public void b(Object... objArr) {
        if (a(5)) {
            b(e(objArr));
        }
    }

    public void c(String str) {
        if (a(6)) {
            try {
                az.c().f(str);
            } catch (Exception unused) {
            }
        }
    }

    public void d(String str, Throwable th) {
        if (a(4)) {
            try {
                az.c().c(th, str);
            } catch (Exception unused) {
            }
        }
    }

    public void b(String str, Throwable th) {
        if (a(5)) {
            try {
                az.c().d(th, str);
            } catch (Exception unused) {
            }
        }
    }

    public void c(Throwable th) {
        c("", th);
    }

    public void c(String str, Throwable th) {
        if (a(6)) {
            try {
                az.c().e(th, str);
            } catch (Exception unused) {
            }
        }
    }

    public void b(Throwable th) {
        b("", th);
    }

    public boolean a(int i6) {
        return a(f10800a, i6);
    }

    public void b(String str, String str2) {
        if (a(4)) {
            try {
                az.c().c(str, str2);
            } catch (Exception unused) {
            }
        }
    }

    public void a(Object... objArr) {
        if (a(3)) {
            a(e(objArr));
        }
    }

    public void a(String str) {
        a(f10800a, str);
    }

    public void a(String str, String str2) {
        if (a(3)) {
            try {
                az.h(str).c(str2);
            } catch (Exception unused) {
            }
        }
    }

    public void a(Throwable th) {
        a("", th);
    }

    public void a(String str, Throwable th) {
        if (a(3)) {
            try {
                az.h(f10800a).b(th, str);
            } catch (Exception unused) {
            }
        }
    }
}
