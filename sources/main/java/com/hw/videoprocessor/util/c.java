package com.hw.videoprocessor.util;

import android.util.Log;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f35443a;

    /* renamed from: b, reason: collision with root package name */
    private static int f35444b;

    private static String i(String str, Object... objArr) {
        return objArr.length == 0 ? str : String.format(str, objArr);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        String f35445a;

        /* renamed from: b, reason: collision with root package name */
        String f35446b;

        /* renamed from: c, reason: collision with root package name */
        int f35447c;

        a() {
        }
    }

    private static String a(a aVar, String str, Object... objArr) {
        return "[" + aVar.f35445a + "." + aVar.f35446b + "():" + aVar.f35447c + "]" + i(str, objArr);
    }

    private static String b(a aVar, String str, Object... objArr) {
        return "[" + aVar.f35446b + "():" + aVar.f35447c + "]" + i(str, objArr);
    }

    public static void c(String str, Object... objArr) {
        if (f35443a) {
            a j6 = j(new Throwable().getStackTrace());
            b(j6, str, objArr);
            String str2 = j6.f35445a;
        }
    }

    public static void d(Throwable th) {
        if (f35443a) {
            String str = j(th.getStackTrace()).f35445a;
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (f35443a) {
            a(j(new Throwable().getStackTrace()), str2, objArr);
        }
    }

    public static void f(String str, Object... objArr) {
        if (f35443a) {
            a j6 = j(new Throwable().getStackTrace());
            b(j6, str, objArr);
            String str2 = j6.f35445a;
        }
    }

    public static void g(Throwable th) {
        if (f35443a) {
            String str = j(th.getStackTrace()).f35445a;
        }
    }

    public static void h(String str, String str2, Object... objArr) {
        if (f35443a) {
            a(j(new Throwable().getStackTrace()), str2, objArr);
        }
    }

    private static a j(StackTraceElement[] stackTraceElementArr) {
        a aVar = new a();
        if (stackTraceElementArr.length > 1) {
            String fileName = stackTraceElementArr[1].getFileName();
            aVar.f35445a = fileName;
            if (fileName.endsWith(".java")) {
                aVar.f35445a = aVar.f35445a.substring(0, r1.length() - 5);
            }
            aVar.f35446b = stackTraceElementArr[1].getMethodName();
            aVar.f35447c = stackTraceElementArr[1].getLineNumber();
        }
        return aVar;
    }

    public static void k(String str, Object... objArr) {
        if (f35443a) {
            a j6 = j(new Throwable().getStackTrace());
            b(j6, str, objArr);
            String str2 = j6.f35445a;
        }
    }

    public static void l(Throwable th) {
        if (f35443a) {
            String str = j(th.getStackTrace()).f35445a;
        }
    }

    public static boolean m() {
        return f35443a;
    }

    public static void n(String str, String str2, Object... objArr) {
        if (f35443a) {
            a(j(new Throwable().getStackTrace()), str2, objArr);
        }
    }

    public static void o(String str) {
        if (f35443a) {
            Log.getStackTraceString(new Throwable());
        }
    }

    public static void p(boolean z5) {
        int i6 = f35444b + 1;
        f35444b = i6;
        if (i6 > 1) {
            return;
        }
        f35443a = z5;
    }

    public static void q(String str, Object... objArr) {
        if (f35443a) {
            a j6 = j(new Throwable().getStackTrace());
            b(j6, str, objArr);
            String str2 = j6.f35445a;
        }
    }

    public static void r(Throwable th) {
        if (f35443a) {
            String str = j(th.getStackTrace()).f35445a;
        }
    }

    public static void s(String str, String str2, Object... objArr) {
        if (f35443a) {
            a(j(new Throwable().getStackTrace()), str2, objArr);
        }
    }

    public static void t(String str, Object... objArr) {
        if (f35443a) {
            a j6 = j(new Throwable().getStackTrace());
            b(j6, str, objArr);
            String str2 = j6.f35445a;
        }
    }

    public static void u(Throwable th) {
        if (f35443a) {
            String str = j(th.getStackTrace()).f35445a;
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        if (f35443a) {
            a(j(new Throwable().getStackTrace()), str2, objArr);
        }
    }

    public static void w(String str, Object... objArr) {
        if (f35443a) {
            a j6 = j(new Throwable().getStackTrace());
            Log.wtf(j6.f35445a, b(j6, str, objArr));
        }
    }

    private c() {
    }
}
