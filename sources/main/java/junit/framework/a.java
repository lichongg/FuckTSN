package junit.framework;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes8.dex */
public class a {
    public static void A(Object obj, Object obj2) {
        B(null, obj, obj2);
    }

    public static void E(Object obj, Object obj2) {
        F(null, obj, obj2);
    }

    public static void H(boolean z5) {
        G(null, z5);
    }

    public static void I() {
        J(null);
    }

    public static void b(byte b6, byte b7) {
        j(null, b6, b7);
    }

    public static void d(char c6, char c7) {
        k(null, c6, c7);
    }

    public static void e(double d6, double d7, double d8) {
        l(null, d6, d7, d8);
    }

    public static void f(float f6, float f7, float f8) {
        m(null, f6, f7, f8);
    }

    public static void g(int i6, int i7) {
        n(null, i6, i7);
    }

    public static void h(long j6, long j7) {
        o(null, j6, j7);
    }

    public static void i(Object obj, Object obj2) {
        p(null, obj, obj2);
    }

    public static void q(String str, String str2) {
        r(null, str, str2);
    }

    public static void u(short s5, short s6) {
        s(null, s5, s6);
    }

    public static void v(boolean z5, boolean z6) {
        t(null, z5, z6);
    }

    public static void x(boolean z5) {
        w(null, z5);
    }

    public static void y(Object obj) {
        z(null, obj);
    }

    public static void B(String str, Object obj, Object obj2) {
        if (obj == obj2) {
            M(str);
        }
    }

    public static void C(Object obj) {
        if (obj != null) {
            D("Expected: <null> but was: " + obj.toString(), obj);
        }
    }

    public static void D(String str, Object obj) {
        G(str, obj == null);
    }

    public static void F(String str, Object obj, Object obj2) {
        if (obj == obj2) {
            return;
        }
        L(str, obj, obj2);
    }

    public static void G(String str, boolean z5) {
        if (z5) {
            return;
        }
        J(str);
    }

    public static void J(String str) {
        if (str != null) {
            throw new AssertionFailedError(str);
        }
        throw new AssertionFailedError();
    }

    public static void L(String str, Object obj, Object obj2) {
        String str2;
        if (str != null) {
            str2 = str + " ";
        } else {
            str2 = "";
        }
        J(str2 + "expected same:<" + obj + "> was not:<" + obj2 + ">");
    }

    public static void M(String str) {
        String str2;
        if (str != null) {
            str2 = str + " ";
        } else {
            str2 = "";
        }
        J(str2 + "expected not same");
    }

    public static String N(String str, Object obj, Object obj2) {
        String str2;
        if (str == null || str.length() <= 0) {
            str2 = "";
        } else {
            str2 = str + " ";
        }
        return str2 + "expected:<" + obj + "> but was:<" + obj2 + ">";
    }

    public static void p(String str, Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return;
        }
        if (obj == null || !obj.equals(obj2)) {
            K(str, obj, obj2);
        }
    }

    public static void r(String str, String str2, String str3) {
        if (str2 == null && str3 == null) {
            return;
        }
        if (str2 == null || !str2.equals(str3)) {
            if (str == null) {
                str = "";
            }
            throw new ComparisonFailure(str, str2, str3);
        }
    }

    public static void w(String str, boolean z5) {
        G(str, !z5);
    }

    public static void z(String str, Object obj) {
        G(str, obj != null);
    }

    protected a() {
    }

    public static void K(String str, Object obj, Object obj2) {
        J(N(str, obj, obj2));
    }

    public static void j(String str, byte b6, byte b7) {
        p(str, Byte.valueOf(b6), Byte.valueOf(b7));
    }

    public static void k(String str, char c6, char c7) {
        p(str, Character.valueOf(c6), Character.valueOf(c7));
    }

    public static void l(String str, double d6, double d7, double d8) {
        if (Double.compare(d6, d7) != 0 && Math.abs(d6 - d7) > d8) {
            K(str, new Double(d6), new Double(d7));
        }
    }

    public static void m(String str, float f6, float f7, float f8) {
        if (Float.compare(f6, f7) != 0 && Math.abs(f6 - f7) > f8) {
            K(str, new Float(f6), new Float(f7));
        }
    }

    public static void n(String str, int i6, int i7) {
        p(str, Integer.valueOf(i6), Integer.valueOf(i7));
    }

    public static void o(String str, long j6, long j7) {
        p(str, Long.valueOf(j6), Long.valueOf(j7));
    }

    public static void s(String str, short s5, short s6) {
        p(str, Short.valueOf(s5), Short.valueOf(s6));
    }

    public static void t(String str, boolean z5, boolean z6) {
        p(str, Boolean.valueOf(z5), Boolean.valueOf(z6));
    }
}
