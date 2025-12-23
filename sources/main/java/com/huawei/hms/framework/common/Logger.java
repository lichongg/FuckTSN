package com.huawei.hms.framework.common;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.util.Arrays;
import java.util.IllegalFormatException;
import org.json.JSONException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class Logger {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f33311a = false;

    /* renamed from: b, reason: collision with root package name */
    private static final String f33312b = "NetworkKit_Logger";

    /* renamed from: c, reason: collision with root package name */
    private static final String f33313c = "|";

    /* renamed from: d, reason: collision with root package name */
    private static final int f33314d = 8;

    /* renamed from: e, reason: collision with root package name */
    private static final int f33315e = 20;

    /* renamed from: f, reason: collision with root package name */
    private static final String f33316f = "NetworkKit_";

    /* renamed from: g, reason: collision with root package name */
    private static final String f33317g = "NetworkSdk_";

    /* renamed from: h, reason: collision with root package name */
    private static ExtLogger f33318h = null;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f33319i = true;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.huawei.hms.framework.common.Logger$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class ThrowableWrapper extends Throwable {
        private static final long serialVersionUID = 7129050843360571879L;

        /* renamed from: a, reason: collision with root package name */
        private String f33320a;

        /* renamed from: b, reason: collision with root package name */
        private Throwable f33321b;

        /* renamed from: c, reason: collision with root package name */
        private Throwable f33322c;

        /* synthetic */ ThrowableWrapper(Throwable th, AnonymousClass1 anonymousClass1) {
            this(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void a(Throwable th) {
            this.f33321b = th;
        }

        @Override // java.lang.Throwable
        public synchronized Throwable getCause() {
            Throwable th;
            th = this.f33321b;
            if (th == this) {
                th = null;
            }
            return th;
        }

        private ThrowableWrapper(Throwable th) {
            this.f33322c = th;
            StackTraceElement[] stackTrace = th.getStackTrace();
            int i6 = ((th instanceof IOException) || (th instanceof JSONException)) ? 8 : 20;
            if (stackTrace.length > i6) {
                setStackTrace((StackTraceElement[]) Arrays.copyOf(stackTrace, i6));
            } else {
                setStackTrace(stackTrace);
            }
            setMessage(StringUtils.anonymizeMessage(th.getMessage()));
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.f33320a;
        }

        public void setMessage(String str) {
            this.f33320a = str;
        }

        @Override // java.lang.Throwable
        public String toString() {
            Throwable th = this.f33322c;
            if (th == null) {
                return "";
            }
            String name = th.getClass().getName();
            if (this.f33320a == null) {
                return name;
            }
            String str = name + ": ";
            if (this.f33320a.startsWith(str)) {
                return this.f33320a;
            }
            return str + this.f33320a;
        }
    }

    @SuppressLint({"LogTagMismatch"})
    public static void d(String str, Object obj) {
        println(3, str, obj);
    }

    public static void e(String str, Object obj) {
        println(6, str, obj);
    }

    private static void f(int i6, String str, String str2) {
        if (i6 == 2) {
            f33318h.v(str, str2);
            return;
        }
        if (i6 == 3) {
            f33318h.d(str, str2);
            return;
        }
        if (i6 == 4) {
            f33318h.i(str, str2);
        } else if (i6 == 5) {
            f33318h.w(str, str2);
        } else {
            if (i6 != 6) {
                return;
            }
            f33318h.e(str, str2);
        }
    }

    private static Throwable h(Throwable th) {
        if (isLoggable(3)) {
            return th;
        }
        AnonymousClass1 anonymousClass1 = null;
        if (th == null) {
            return null;
        }
        ThrowableWrapper throwableWrapper = new ThrowableWrapper(th, anonymousClass1);
        Throwable cause = th.getCause();
        ThrowableWrapper throwableWrapper2 = throwableWrapper;
        while (cause != null) {
            ThrowableWrapper throwableWrapper3 = new ThrowableWrapper(cause, anonymousClass1);
            throwableWrapper2.a(throwableWrapper3);
            cause = cause.getCause();
            throwableWrapper2 = throwableWrapper3;
        }
        return throwableWrapper;
    }

    @SuppressLint({"LogTagMismatch"})
    public static void i(String str, Object obj) {
        println(4, str, obj);
    }

    public static void println(int i6, String str, Object obj) {
        if (i6 < 3) {
            return;
        }
        l(i6, str, obj == null ? "null" : obj.toString());
    }

    public static void v(String str, String str2, Object... objArr) {
        println(2, str, str2, objArr);
    }

    public static void w(String str, Object obj) {
        println(5, str, obj);
    }

    private static String a(String str) {
        return f33317g + str;
    }

    private static String c(String str) {
        return f33316f + str;
    }

    @SuppressLint({"LogTagMismatch"})
    public static void d(String str, String str2, Object... objArr) {
        println(3, str, str2, objArr);
    }

    public static void e(String str, String str2, Object... objArr) {
        println(6, str, str2, objArr);
    }

    private static String g(int i6) {
        if (!Log.isLoggable(f33316f, 3)) {
            return "";
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length <= i6) {
            return "";
        }
        StackTraceElement stackTraceElement = stackTrace[i6];
        return Thread.currentThread().getName() + "|" + stackTraceElement.getFileName() + "|" + stackTraceElement.getClassName() + "|" + stackTraceElement.getMethodName() + "|" + stackTraceElement.getLineNumber();
    }

    @SuppressLint({"LogTagMismatch"})
    public static void i(String str, String str2, Object... objArr) {
        println(4, str, str2, objArr);
    }

    public static boolean isLoggable(int i6) {
        return Log.isLoggable(f33316f, i6);
    }

    private static boolean j(int i6) {
        return f33318h != null && i6 >= 3;
    }

    private static boolean k(int i6) {
        return f33319i && isLoggable(i6);
    }

    public static void println(int i6, String str, String str2, Object... objArr) {
        if (i6 >= 3 && str2 != null) {
            try {
                l(i6, str, StringUtils.format(str2, objArr));
            } catch (IllegalFormatException e6) {
                w(f33312b, "log format error" + str2, e6);
            }
        }
    }

    public static void setExtLogger(ExtLogger extLogger, boolean z5) {
        f33318h = extLogger;
        f33319i = z5;
        i(f33312b, "logger = " + extLogger + z5);
    }

    public static void v(String str, Object obj) {
        println(2, str, obj);
    }

    public static void w(String str, String str2, Object... objArr) {
        println(5, str, str2, objArr);
    }

    private static String b(String str, int i6) {
        if (!TextUtils.isEmpty(str)) {
            String g6 = g(i6);
            if (TextUtils.isEmpty(g6)) {
                return str;
            }
            return g6 + "|" + str;
        }
        return g(i6);
    }

    public static void e(String str, String str2, Throwable th) {
        if (j(6)) {
            f33318h.e(a(str), b(str2, 5), h(th));
        }
        if (f33319i) {
            c(str);
            b(str2, 5);
            h(th);
        }
    }

    private static int l(int i6, String str, String str2) {
        if (j(i6)) {
            f(i6, a(str), b(str2, 7));
        }
        if (k(i6)) {
            return Log.println(i6, c(str), b(str2, 7));
        }
        return 1;
    }

    public static void w(String str, String str2, Throwable th) {
        if (j(5)) {
            f33318h.w(a(str), b(str2, 5), h(th));
        }
        if (f33319i) {
            c(str);
            b(str2, 5);
            h(th);
        }
    }
}
