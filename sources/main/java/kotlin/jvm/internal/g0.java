package kotlin.jvm.internal;

import com.daimajia.numberprogressbar.BuildConfig;
import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.SinceKotlin;
import kotlin.UninitializedPropertyAccessException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class g0 {
    @SinceKotlin(version = "1.1")
    public static boolean d(Double d6, Double d7) {
        return d6 == null ? d7 == null : d7 != null && d6.doubleValue() == d7.doubleValue();
    }

    @SinceKotlin(version = "1.1")
    public static boolean f(Float f6, Float f7) {
        return f6 == null ? f7 == null : f7 != null && f6.floatValue() == f7.floatValue();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static class a {
        private a() {
        }
    }

    private static <T extends Throwable> T A(T t5) {
        return (T) B(t5, g0.class.getName());
    }

    public static String C(String str, Object obj) {
        return str + obj;
    }

    public static void D() {
        throw ((AssertionError) A(new AssertionError()));
    }

    public static void E(String str) {
        throw ((AssertionError) A(new AssertionError(str)));
    }

    public static void F() {
        throw ((IllegalArgumentException) A(new IllegalArgumentException()));
    }

    public static void G(String str) {
        throw ((IllegalArgumentException) A(new IllegalArgumentException(str)));
    }

    public static void H() {
        throw ((IllegalStateException) A(new IllegalStateException()));
    }

    public static void I(String str) {
        throw ((IllegalStateException) A(new IllegalStateException(str)));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static void J() {
        throw ((NullPointerException) A(new NullPointerException()));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static void K(String str) {
        throw ((NullPointerException) A(new NullPointerException(str)));
    }

    public static void L() {
        throw ((KotlinNullPointerException) A(new KotlinNullPointerException()));
    }

    public static void M(String str) {
        throw ((KotlinNullPointerException) A(new KotlinNullPointerException(str)));
    }

    private static void N(String str) {
        throw ((IllegalArgumentException) A(new IllegalArgumentException(v(str))));
    }

    private static void O(String str) {
        throw ((NullPointerException) A(new NullPointerException(v(str))));
    }

    public static void P() {
        Q("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void Q(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void R(String str) {
        throw ((UninitializedPropertyAccessException) A(new UninitializedPropertyAccessException(str)));
    }

    public static void S(String str) {
        R("lateinit property " + str + " has not been initialized");
    }

    @SinceKotlin(version = "1.1")
    public static boolean a(double d6, Double d7) {
        return d7 != null && d6 == d7.doubleValue();
    }

    @SinceKotlin(version = "1.1")
    public static boolean b(float f6, Float f7) {
        return f7 != null && f6 == f7.floatValue();
    }

    @SinceKotlin(version = "1.1")
    public static boolean c(Double d6, double d7) {
        return d6 != null && d6.doubleValue() == d7;
    }

    @SinceKotlin(version = "1.1")
    public static boolean e(Float f6, float f7) {
        return f6 != null && f6.floatValue() == f7;
    }

    public static boolean g(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void h(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) A(new IllegalStateException(str + " must not be null")));
    }

    public static void i(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) A(new IllegalStateException(str)));
        }
    }

    public static void j(Object obj, String str, String str2) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) A(new IllegalStateException("Field specified as non-null is null: " + str + "." + str2)));
    }

    public static void k(String str) throws ClassNotFoundException {
        String replace = str.replace('/', '.');
        try {
            Class.forName(replace);
        } catch (ClassNotFoundException e6) {
            throw ((ClassNotFoundException) A(new ClassNotFoundException("Class " + replace + " is not found. Please update the Kotlin runtime to the latest version", e6)));
        }
    }

    public static void l(String str, String str2) throws ClassNotFoundException {
        String replace = str.replace('/', '.');
        try {
            Class.forName(replace);
        } catch (ClassNotFoundException e6) {
            throw ((ClassNotFoundException) A(new ClassNotFoundException("Class " + replace + " is not found: this code requires the Kotlin runtime of version at least " + str2, e6)));
        }
    }

    public static void m(Object obj) {
        if (obj == null) {
            J();
        }
    }

    public static void n(Object obj, String str) {
        if (obj == null) {
            K(str);
        }
    }

    public static void o(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((NullPointerException) A(new NullPointerException(str + " must not be null")));
    }

    public static void p(Object obj, String str) {
        if (obj == null) {
            O(str);
        }
    }

    public static void q(Object obj, String str) {
        if (obj == null) {
            N(str);
        }
    }

    public static void r(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) A(new IllegalStateException(str)));
        }
    }

    public static void s(Object obj, String str, String str2) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) A(new IllegalStateException("Method specified as non-null returned null: " + str + "." + str2)));
    }

    public static int t(int i6, int i7) {
        if (i6 < i7) {
            return -1;
        }
        return i6 == i7 ? 0 : 1;
    }

    public static int u(long j6, long j7) {
        if (j6 < j7) {
            return -1;
        }
        return j6 == j7 ? 0 : 1;
    }

    private g0() {
    }

    static <T extends Throwable> T B(T t5, String str) {
        StackTraceElement[] stackTrace = t5.getStackTrace();
        int length = stackTrace.length;
        int i6 = -1;
        for (int i7 = 0; i7 < length; i7++) {
            if (str.equals(stackTrace[i7].getClassName())) {
                i6 = i7;
            }
        }
        t5.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i6 + 1, length));
        return t5;
    }

    private static String v(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = g0.class.getName();
        int i6 = 0;
        while (!stackTrace[i6].getClassName().equals(name)) {
            i6++;
        }
        while (stackTrace[i6].getClassName().equals(name)) {
            i6++;
        }
        StackTraceElement stackTraceElement = stackTrace[i6];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    public static void w() {
        P();
    }

    public static void x(String str) {
        Q(str);
    }

    public static void y(int i6, String str) {
        P();
    }

    public static void z(int i6, String str, String str2) {
        Q(str2);
    }
}
