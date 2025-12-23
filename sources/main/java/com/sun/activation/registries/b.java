package com.sun.activation.registries;

import java.io.PrintStream;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f39148a;

    /* renamed from: b, reason: collision with root package name */
    private static Logger f39149b;

    /* renamed from: c, reason: collision with root package name */
    private static final Level f39150c = Level.FINE;

    static {
        try {
            f39148a = Boolean.getBoolean("javax.activation.debug");
        } catch (Throwable unused) {
        }
        f39149b = Logger.getLogger("javax.activation");
    }

    public static boolean a() {
        return f39148a || f39149b.isLoggable(f39150c);
    }

    public static void b(String str) {
        if (f39148a) {
            System.out.getClass();
        }
        f39149b.log(f39150c, str);
    }

    public static void c(String str, Throwable th) {
        if (f39148a) {
            PrintStream printStream = System.out;
            Objects.toString(th);
            printStream.getClass();
        }
        f39149b.log(f39150c, str, th);
    }

    private b() {
    }
}
