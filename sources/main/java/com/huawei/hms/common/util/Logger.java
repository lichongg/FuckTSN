package com.huawei.hms.common.util;

import android.annotation.SuppressLint;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.Locale;
import org.json.JSONException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class Logger {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f33114a = false;

    /* renamed from: b, reason: collision with root package name */
    public static final String f33115b = "Logger";

    /* renamed from: c, reason: collision with root package name */
    public static final String f33116c = "|";

    /* renamed from: d, reason: collision with root package name */
    public static final int f33117d = 8;

    /* renamed from: e, reason: collision with root package name */
    public static final int f33118e = 20;

    /* renamed from: f, reason: collision with root package name */
    public static final String f33119f = "dynamic-api_";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b extends Throwable {

        /* renamed from: d, reason: collision with root package name */
        public static final long f33120d = 7129050843360571879L;

        /* renamed from: a, reason: collision with root package name */
        public String f33121a;

        /* renamed from: b, reason: collision with root package name */
        public Throwable f33122b;

        /* renamed from: c, reason: collision with root package name */
        public Throwable f33123c;

        public b(Throwable th) {
            this.f33123c = th;
        }

        public /* synthetic */ b(Throwable th, a aVar) {
            this(th);
        }

        public void a(String str) {
            this.f33121a = str;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            Throwable th = this.f33122b;
            if (th == this) {
                return null;
            }
            return th;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.f33121a;
        }

        @Override // java.lang.Throwable
        public String toString() {
            Throwable th = this.f33123c;
            if (th == null) {
                return "";
            }
            String name = th.getClass().getName();
            if (this.f33121a == null) {
                return name;
            }
            String str = name + ": ";
            if (this.f33121a.startsWith(str)) {
                return this.f33121a;
            }
            return str + this.f33121a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Throwable th) {
            this.f33122b = th;
        }
    }

    public static int a(int i6, String str, String str2) {
        return Log.println(i6, a(str), a(str2, 7));
    }

    @SuppressLint({"LogTagMismatch"})
    public static void d(String str, Object obj) {
        println(3, str, obj);
    }

    public static void e(String str, Object obj) {
        println(6, str, obj);
    }

    @SuppressLint({"LogTagMismatch"})
    public static void i(String str, Object obj) {
        println(4, str, obj);
    }

    public static void println(int i6, String str, Object obj) {
        if (i6 >= 3 && isLoggable(i6)) {
            a(i6, str, obj == null ? "null" : obj.toString());
        }
    }

    public static void v(String str, Object obj) {
        println(2, str, obj);
    }

    public static void w(String str, Object obj) {
        println(5, str, obj);
    }

    public static String a(int i6) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length <= i6) {
            return "";
        }
        StackTraceElement stackTraceElement = stackTrace[i6];
        return Process.myPid() + "-" + Process.myTid() + f33116c + stackTraceElement.getFileName() + f33116c + stackTraceElement.getClassName() + f33116c + stackTraceElement.getMethodName() + f33116c + stackTraceElement.getLineNumber();
    }

    public static String anonymizeMessage(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i6 = 0; i6 < charArray.length; i6++) {
            if (i6 % 2 == 1) {
                charArray[i6] = '*';
            }
        }
        return new String(charArray);
    }

    @SuppressLint({"LogTagMismatch"})
    public static void d(String str, String str2, Object... objArr) {
        println(3, str, str2, objArr);
    }

    public static void e(String str, String str2, Throwable th) {
        a(str);
        a(str2, 5);
        a(th);
    }

    public static String format(String str, Object... objArr) {
        return str == null ? "" : String.format(Locale.ROOT, str, objArr);
    }

    @SuppressLint({"LogTagMismatch"})
    public static void i(String str, String str2, Object... objArr) {
        println(4, str, str2, objArr);
    }

    public static boolean isLoggable(int i6) {
        return Log.isLoggable(f33119f, i6);
    }

    public static void println(int i6, String str, String str2, Object... objArr) {
        if (i6 >= 3 && str2 != null) {
            try {
                if (isLoggable(i6)) {
                    a(i6, str, format(str2, objArr));
                }
            } catch (IllegalFormatException e6) {
                w(f33115b, "log format error" + str2, e6);
            }
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        println(2, str, str2, objArr);
    }

    public static void w(String str, String str2, Throwable th) {
        a(str);
        a(str2, 5);
        a(th);
    }

    public static String a(String str) {
        return f33119f + str;
    }

    public static void e(String str, String str2, Object... objArr) {
        println(6, str, str2, objArr);
    }

    public static void w(String str, String str2, Object... objArr) {
        println(5, str, str2, objArr);
    }

    public static String a(String str, int i6) {
        if (TextUtils.isEmpty(str)) {
            return a(i6);
        }
        return a(i6) + f33116c + str;
    }

    public static Throwable a(Throwable th) {
        if (isLoggable(3)) {
            return th;
        }
        a aVar = null;
        if (th == null) {
            return null;
        }
        int i6 = ((th instanceof IOException) || (th instanceof JSONException)) ? 8 : 20;
        b bVar = new b(th, aVar);
        StackTraceElement[] stackTrace = bVar.getStackTrace();
        if (stackTrace.length > i6) {
            bVar.setStackTrace((StackTraceElement[]) Arrays.copyOf(stackTrace, i6));
        } else {
            bVar.setStackTrace(stackTrace);
        }
        bVar.a(anonymizeMessage(th.getMessage()));
        Throwable cause = th.getCause();
        b bVar2 = bVar;
        while (cause != null) {
            b bVar3 = new b(cause, aVar);
            bVar3.a(anonymizeMessage(cause.getMessage()));
            bVar2.a(bVar3);
            cause = cause.getCause();
            bVar2 = bVar3;
        }
        return bVar;
    }
}
