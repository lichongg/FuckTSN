package junit.framework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class g extends a implements f {

    /* renamed from: a, reason: collision with root package name */
    private String f43482a;

    public g() {
        this.f43482a = null;
    }

    @Override // junit.framework.f
    public int c() {
        return 1;
    }

    protected j O() {
        return new j();
    }

    public String P() {
        return this.f43482a;
    }

    protected void S() throws Throwable {
        Method method;
        z("TestCase.fName cannot be null", this.f43482a);
        try {
            method = getClass().getMethod(this.f43482a, null);
        } catch (NoSuchMethodException unused) {
            J("Method \"" + this.f43482a + "\" not found");
            method = null;
        }
        if (!Modifier.isPublic(method.getModifiers())) {
            J("Method \"" + this.f43482a + "\" should be public");
        }
        try {
            method.invoke(this, null);
        } catch (IllegalAccessException e6) {
            e6.fillInStackTrace();
            throw e6;
        } catch (InvocationTargetException e7) {
            e7.fillInStackTrace();
            throw e7.getTargetException();
        }
    }

    public void T(String str) {
        this.f43482a = str;
    }

    public String toString() {
        return P() + "(" + getClass().getName() + ")";
    }

    public g(String str) {
        this.f43482a = str;
    }

    public static void A(Object obj, Object obj2) {
        a.A(obj, obj2);
    }

    public static void B(String str, Object obj, Object obj2) {
        a.B(str, obj, obj2);
    }

    public static void C(Object obj) {
        a.C(obj);
    }

    public static void D(String str, Object obj) {
        a.D(str, obj);
    }

    public static void E(Object obj, Object obj2) {
        a.E(obj, obj2);
    }

    public static void F(String str, Object obj, Object obj2) {
        a.F(str, obj, obj2);
    }

    public static void G(String str, boolean z5) {
        a.G(str, z5);
    }

    public static void H(boolean z5) {
        a.H(z5);
    }

    public static void I() {
        a.I();
    }

    public static void J(String str) {
        a.J(str);
    }

    public static void K(String str, Object obj, Object obj2) {
        a.K(str, obj, obj2);
    }

    public static void L(String str, Object obj, Object obj2) {
        a.L(str, obj, obj2);
    }

    public static void M(String str) {
        a.M(str);
    }

    public static String N(String str, Object obj, Object obj2) {
        return a.N(str, obj, obj2);
    }

    public static void b(byte b6, byte b7) {
        a.b(b6, b7);
    }

    public static void d(char c6, char c7) {
        a.d(c6, c7);
    }

    public static void e(double d6, double d7, double d8) {
        a.e(d6, d7, d8);
    }

    public static void f(float f6, float f7, float f8) {
        a.f(f6, f7, f8);
    }

    public static void g(int i6, int i7) {
        a.g(i6, i7);
    }

    public static void h(long j6, long j7) {
        a.h(j6, j7);
    }

    public static void i(Object obj, Object obj2) {
        a.i(obj, obj2);
    }

    public static void j(String str, byte b6, byte b7) {
        a.j(str, b6, b7);
    }

    public static void k(String str, char c6, char c7) {
        a.k(str, c6, c7);
    }

    public static void l(String str, double d6, double d7, double d8) {
        a.l(str, d6, d7, d8);
    }

    public static void m(String str, float f6, float f7, float f8) {
        a.m(str, f6, f7, f8);
    }

    public static void n(String str, int i6, int i7) {
        a.n(str, i6, i7);
    }

    public static void o(String str, long j6, long j7) {
        a.o(str, j6, j7);
    }

    public static void p(String str, Object obj, Object obj2) {
        a.p(str, obj, obj2);
    }

    public static void q(String str, String str2) {
        a.q(str, str2);
    }

    public static void r(String str, String str2, String str3) {
        a.r(str, str2, str3);
    }

    public static void s(String str, short s5, short s6) {
        a.s(str, s5, s6);
    }

    public static void t(String str, boolean z5, boolean z6) {
        a.t(str, z5, z6);
    }

    public static void u(short s5, short s6) {
        a.u(s5, s6);
    }

    public static void v(boolean z5, boolean z6) {
        a.v(z5, z6);
    }

    public static void w(String str, boolean z5) {
        a.w(str, z5);
    }

    public static void x(boolean z5) {
        a.x(z5);
    }

    public static void y(Object obj) {
        a.y(obj);
    }

    public static void z(String str, Object obj) {
        a.z(str, obj);
    }

    public j Q() {
        j O = O();
        a(O);
        return O;
    }

    public void R() throws Throwable {
        U();
        try {
            S();
            try {
                V();
                th = null;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                V();
            } catch (Throwable unused) {
            }
        }
        if (th == null) {
        } else {
            throw th;
        }
    }

    @Override // junit.framework.f
    public void a(j jVar) {
        jVar.k(this);
    }

    protected void U() throws Exception {
    }

    protected void V() throws Exception {
    }
}
