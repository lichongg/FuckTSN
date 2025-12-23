package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* loaded from: D:\Downloads\app\classes6.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final int f36032a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f36033b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f36034c = 2;

    /* renamed from: d, reason: collision with root package name */
    public static final int f36035d = 3;

    /* renamed from: e, reason: collision with root package name */
    public static final int f36036e = -1;

    /* renamed from: f, reason: collision with root package name */
    public static int f36037f = -1;

    /* renamed from: g, reason: collision with root package name */
    static ThreadLocal<StringBuilder> f36038g = new ThreadLocal<>();

    /* renamed from: h, reason: collision with root package name */
    private static int f36039h;

    private static void a(int i6, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length < 3) {
            return;
        }
        String fileName = stackTrace[2].getFileName();
        int lineNumber = stackTrace[2].getLineNumber();
        String methodName = stackTrace[2].getMethodName();
        if (fileName.length() > 5) {
            fileName = fileName.substring(0, fileName.length() - 5);
        }
        StringBuilder sb = f36038g.get();
        if (sb == null) {
            sb = new StringBuilder();
            f36038g.set(sb);
        }
        synchronized (sb) {
            sb.setLength(0);
            sb.append("[");
            sb.append(f36039h);
            sb.append("][");
            sb.append(fileName);
            sb.append(':');
            sb.append(lineNumber);
            sb.append('.');
            sb.append(methodName);
            sb.append("] ");
            sb.append(str);
            f36039h++;
        }
    }

    public static void b(String str) {
        int i6 = f36037f;
        if (i6 == -1 || i6 == 0 || i6 == 1) {
            a(1, str);
        }
    }

    public static void c(String str) {
        int i6 = f36037f;
        if (i6 == -1 || i6 == 0 || i6 == 1 || i6 == 2) {
            a(2, str);
        }
    }

    public static void b(String str, Throwable th) {
        int i6 = f36037f;
        if (i6 == -1 || i6 == 0 || i6 == 1) {
            a(1, str + com.snail.antifake.deviceid.e.f37542d + a(th));
        }
    }

    public static void c(String str, Throwable th) {
        int i6 = f36037f;
        if (i6 == -1 || i6 == 0 || i6 == 1 || i6 == 2) {
            a(2, str + com.snail.antifake.deviceid.e.f37542d + a(th));
        }
    }

    public static void a(String str) {
        int i6 = f36037f;
        if (i6 == -1 || i6 == 0) {
            a(0, str);
        }
    }

    public static void d(String str) {
    }

    public static void a(String str, Throwable th) {
        int i6 = f36037f;
        if (i6 == -1 || i6 == 0) {
            a(0, str + com.snail.antifake.deviceid.e.f37542d + a(th));
        }
    }

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
