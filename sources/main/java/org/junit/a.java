package org.junit;

import org.hamcrest.j;
import org.hamcrest.k;
import org.junit.internal.ArrayComparisonFailure;
import org.junit.internal.c;
import org.junit.internal.d;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a {
    public static void F(boolean z5) {
        E(null, z5);
    }

    public static void G(double d6, double d7, double d8) {
        K(null, d6, d7, d8);
    }

    public static void H(float f6, float f7, float f8) {
        L(null, f6, f7, f8);
    }

    public static void I(long j6, long j7) {
        M(null, j6, j7);
    }

    public static void J(Object obj, Object obj2) {
        N(null, obj, obj2);
    }

    public static void O(Object obj) {
        P(null, obj);
    }

    public static void Q(Object obj, Object obj2) {
        R(null, obj, obj2);
    }

    public static void S(Object obj) {
        T(null, obj);
    }

    public static void U(Object obj, Object obj2) {
        V(null, obj, obj2);
    }

    public static void Z(boolean z5) {
        Y(null, z5);
    }

    public static void c0() {
        d0(null);
    }

    public static void j(byte[] bArr, byte[] bArr2) {
        a(null, bArr, bArr2);
    }

    public static void k(char[] cArr, char[] cArr2) {
        b(null, cArr, cArr2);
    }

    public static void l(double[] dArr, double[] dArr2, double d6) {
        c(null, dArr, dArr2, d6);
    }

    public static void m(float[] fArr, float[] fArr2, float f6) {
        d(null, fArr, fArr2, f6);
    }

    public static void n(int[] iArr, int[] iArr2) {
        e(null, iArr, iArr2);
    }

    public static void o(long[] jArr, long[] jArr2) {
        f(null, jArr, jArr2);
    }

    public static void p(Object[] objArr, Object[] objArr2) {
        g(null, objArr, objArr2);
    }

    public static void q(short[] sArr, short[] sArr2) {
        h(null, sArr, sArr2);
    }

    public static void r(boolean[] zArr, boolean[] zArr2) {
        i(null, zArr, zArr2);
    }

    @Deprecated
    public static void s(double d6, double d7) {
        x(null, d6, d7);
    }

    public static void t(double d6, double d7, double d8) {
        y(null, d6, d7, d8);
    }

    public static void u(float f6, float f7, float f8) {
        z(null, f6, f7, f8);
    }

    public static void v(long j6, long j7) {
        A(null, j6, j7);
    }

    public static void w(Object obj, Object obj2) {
        B(null, obj, obj2);
    }

    public static void A(String str, long j6, long j7) {
        if (j6 != j7) {
            f0(str, Long.valueOf(j6), Long.valueOf(j7));
        }
    }

    public static void E(String str, boolean z5) {
        Y(str, !z5);
    }

    public static void M(String str, long j6, long j7) {
        if (j6 == j7) {
            e0(str, Long.valueOf(j7));
        }
    }

    public static void P(String str, Object obj) {
        Y(str, obj != null);
    }

    public static void R(String str, Object obj, Object obj2) {
        if (obj == obj2) {
            i0(str);
        }
    }

    public static void T(String str, Object obj) {
        if (obj == null) {
            return;
        }
        g0(str, obj);
    }

    public static void V(String str, Object obj, Object obj2) {
        if (obj == obj2) {
            return;
        }
        h0(str, obj, obj2);
    }

    public static <T> void W(T t5, j<? super T> jVar) {
        X("", t5, jVar);
    }

    public static void Y(String str, boolean z5) {
        if (z5) {
            return;
        }
        d0(str);
    }

    private static boolean b0(Object obj, Object obj2) {
        return obj == null ? obj2 == null : n0(obj, obj2);
    }

    public static void c(String str, double[] dArr, double[] dArr2, double d6) throws ArrayComparisonFailure {
        new d(d6).a(str, dArr, dArr2);
    }

    public static void d(String str, float[] fArr, float[] fArr2, float f6) throws ArrayComparisonFailure {
        new d(f6).a(str, fArr, fArr2);
    }

    public static void d0(String str) {
        if (str != null) {
            throw new AssertionError(str);
        }
        throw new AssertionError();
    }

    private static void e0(String str, Object obj) {
        String str2;
        if (str != null) {
            str2 = str + ". ";
        } else {
            str2 = "Values should be different. ";
        }
        d0(str2 + "Actual: " + obj);
    }

    private static void g0(String str, Object obj) {
        String str2;
        if (str != null) {
            str2 = str + " ";
        } else {
            str2 = "";
        }
        d0(str2 + "expected null, but was:<" + obj + ">");
    }

    private static void h0(String str, Object obj, Object obj2) {
        String str2;
        if (str != null) {
            str2 = str + " ";
        } else {
            str2 = "";
        }
        d0(str2 + "expected same:<" + obj + "> was not:<" + obj2 + ">");
    }

    private static void i0(String str) {
        String str2;
        if (str != null) {
            str2 = str + " ";
        } else {
            str2 = "";
        }
        d0(str2 + "expected not same");
    }

    static String k0(String str, Object obj, Object obj2) {
        String str2 = "";
        if (str != null && !str.equals("")) {
            str2 = str + " ";
        }
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        if (valueOf.equals(valueOf2)) {
            return str2 + "expected: " + l0(obj, valueOf) + " but was: " + l0(obj2, valueOf2);
        }
        return str2 + "expected:<" + valueOf + "> but was:<" + valueOf2 + ">";
    }

    private static String l0(Object obj, String str) {
        return (obj == null ? "null" : obj.getClass().getName()) + "<" + str + ">";
    }

    private static void m0(String str, Object obj, Object obj2) throws ArrayComparisonFailure {
        new c().a(str, obj, obj2);
    }

    @Deprecated
    public static void x(String str, double d6, double d7) {
        d0("Use assertEquals(expected, actual, delta) to compare floating-point numbers");
    }

    protected a() {
    }

    public static void B(String str, Object obj, Object obj2) {
        if (b0(obj, obj2)) {
            return;
        }
        if ((obj instanceof String) && (obj2 instanceof String)) {
            if (str == null) {
                str = "";
            }
            throw new ComparisonFailure(str, (String) obj, (String) obj2);
        }
        f0(str, obj, obj2);
    }

    @Deprecated
    public static void C(String str, Object[] objArr, Object[] objArr2) {
        g(str, objArr, objArr2);
    }

    @Deprecated
    public static void D(Object[] objArr, Object[] objArr2) {
        p(objArr, objArr2);
    }

    public static void K(String str, double d6, double d7, double d8) {
        if (!a0(d6, d7, d8)) {
            e0(str, Double.valueOf(d7));
        }
    }

    public static void L(String str, float f6, float f7, float f8) {
        if (!j0(f6, f7, f8)) {
            e0(str, Float.valueOf(f7));
        }
    }

    public static void N(String str, Object obj, Object obj2) {
        if (b0(obj, obj2)) {
            e0(str, obj2);
        }
    }

    public static <T> void X(String str, T t5, j<? super T> jVar) {
        k.b(str, t5, jVar);
    }

    public static void a(String str, byte[] bArr, byte[] bArr2) throws ArrayComparisonFailure {
        m0(str, bArr, bArr2);
    }

    private static boolean a0(double d6, double d7, double d8) {
        if (Double.compare(d6, d7) == 0 || Math.abs(d6 - d7) <= d8) {
            return false;
        }
        return true;
    }

    public static void b(String str, char[] cArr, char[] cArr2) throws ArrayComparisonFailure {
        m0(str, cArr, cArr2);
    }

    public static void e(String str, int[] iArr, int[] iArr2) throws ArrayComparisonFailure {
        m0(str, iArr, iArr2);
    }

    public static void f(String str, long[] jArr, long[] jArr2) throws ArrayComparisonFailure {
        m0(str, jArr, jArr2);
    }

    private static void f0(String str, Object obj, Object obj2) {
        d0(k0(str, obj, obj2));
    }

    public static void g(String str, Object[] objArr, Object[] objArr2) throws ArrayComparisonFailure {
        m0(str, objArr, objArr2);
    }

    public static void h(String str, short[] sArr, short[] sArr2) throws ArrayComparisonFailure {
        m0(str, sArr, sArr2);
    }

    public static void i(String str, boolean[] zArr, boolean[] zArr2) throws ArrayComparisonFailure {
        m0(str, zArr, zArr2);
    }

    private static boolean j0(float f6, float f7, float f8) {
        if (Float.compare(f6, f7) == 0 || Math.abs(f6 - f7) <= f8) {
            return false;
        }
        return true;
    }

    private static boolean n0(Object obj, Object obj2) {
        return obj.equals(obj2);
    }

    public static void y(String str, double d6, double d7, double d8) {
        if (a0(d6, d7, d8)) {
            f0(str, Double.valueOf(d6), Double.valueOf(d7));
        }
    }

    public static void z(String str, float f6, float f7, float f8) {
        if (j0(f6, f7, f8)) {
            f0(str, Float.valueOf(f6), Float.valueOf(f7));
        }
    }
}
