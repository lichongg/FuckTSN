package rx.internal.util.unsafe;

import java.lang.reflect.Field;
import rx.internal.util.SuppressAnimalSniffer;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressAnimalSniffer
/* loaded from: D:\Downloads\app\classes9.dex */
public final class n0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Unsafe f54298a;

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f54299b;

    static {
        f54299b = System.getProperty("rx.unsafe-disable") != null;
        Unsafe unsafe = null;
        try {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            unsafe = (Unsafe) declaredField.get(null);
        } catch (Throwable unused) {
        }
        f54298a = unsafe;
    }

    public static boolean b(Object obj, long j6, int i6, int i7) {
        return f54298a.compareAndSwapInt(obj, j6, i6, i7);
    }

    public static int c(Object obj, long j6, int i6) {
        while (true) {
            Unsafe unsafe = f54298a;
            int intVolatile = unsafe.getIntVolatile(obj, j6);
            Object obj2 = obj;
            long j7 = j6;
            if (unsafe.compareAndSwapInt(obj2, j7, intVolatile, intVolatile + i6)) {
                return intVolatile;
            }
            obj = obj2;
            j6 = j7;
        }
    }

    public static int d(Object obj, long j6) {
        while (true) {
            Unsafe unsafe = f54298a;
            int intVolatile = unsafe.getIntVolatile(obj, j6);
            Object obj2 = obj;
            long j7 = j6;
            if (unsafe.compareAndSwapInt(obj2, j7, intVolatile, intVolatile + 1)) {
                return intVolatile;
            }
            obj = obj2;
            j6 = j7;
        }
    }

    public static int e(Object obj, long j6, int i6) {
        while (true) {
            Unsafe unsafe = f54298a;
            int intVolatile = unsafe.getIntVolatile(obj, j6);
            Object obj2 = obj;
            long j7 = j6;
            int i7 = i6;
            if (unsafe.compareAndSwapInt(obj2, j7, intVolatile, i7)) {
                return intVolatile;
            }
            obj = obj2;
            j6 = j7;
            i6 = i7;
        }
    }

    public static boolean f() {
        return (f54298a == null || f54299b) ? false : true;
    }

    private n0() {
        throw new IllegalStateException("No instances!");
    }

    public static long a(Class<?> cls, String str) {
        try {
            return f54298a.objectFieldOffset(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e6) {
            InternalError internalError = new InternalError();
            internalError.initCause(e6);
            throw internalError;
        }
    }
}
