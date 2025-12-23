package org.junit;

import java.util.Arrays;
import org.hamcrest.d;
import org.hamcrest.j;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b {
    public static void a(String str, boolean z5) {
        h(str, !z5);
    }

    public static void b(boolean z5) {
        i(!z5);
    }

    public static void h(String str, boolean z5) {
        if (!z5) {
            throw new AssumptionViolatedException(str);
        }
    }

    public static void c(String str, Throwable th) {
        g(str, th, d.L());
    }

    public static void d(Throwable th) {
        f(th, d.L());
    }

    public static void e(Object... objArr) {
        f(Arrays.asList(objArr), d.x(d.J()));
    }

    public static <T> void f(T t5, j<T> jVar) {
        if (jVar.c(t5)) {
        } else {
            throw new AssumptionViolatedException(t5, jVar);
        }
    }

    public static <T> void g(String str, T t5, j<T> jVar) {
        if (jVar.c(t5)) {
        } else {
            throw new AssumptionViolatedException(str, t5, jVar);
        }
    }

    public static void i(boolean z5) {
        f(Boolean.valueOf(z5), d.E(Boolean.TRUE));
    }
}
