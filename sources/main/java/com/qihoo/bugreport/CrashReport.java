package com.qihoo.bugreport;

import android.content.Context;
import com.qihoo.bugreport.javacrash.ExceptionHandleReporter;
import java.lang.Thread;

/* loaded from: D:\Downloads\app\classes10.dex */
public class CrashReport {

    /* renamed from: a, reason: collision with root package name */
    private static Thread.UncaughtExceptionHandler f36514a;

    /* renamed from: b, reason: collision with root package name */
    private static ExceptionHandleReporter f36515b;

    /* renamed from: c, reason: collision with root package name */
    private static Context f36516c;

    public static void prepareInit() {
        if (f36514a == null) {
            f36514a = Thread.getDefaultUncaughtExceptionHandler();
        }
    }

    public static void init(Context context) {
        if (context != null) {
            try {
                if (f36514a != null) {
                    if (f36516c == null || f36515b == null) {
                        f36516c = context;
                        f36515b = ExceptionHandleReporter.a(context, f36514a);
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    public static ExceptionHandleReporter getExceptionHandlerInstance() {
        return f36515b;
    }

    public static Context a() {
        return f36516c;
    }
}
