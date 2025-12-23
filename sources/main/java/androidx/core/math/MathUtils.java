package androidx.core.math;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class MathUtils {
    public static int addExact(int i6, int i7) {
        int i8 = i6 + i7;
        if ((i6 >= 0) == (i7 >= 0)) {
            if ((i6 >= 0) != (i8 >= 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return i8;
    }

    public static double clamp(double d6, double d7, double d8) {
        return d6 < d7 ? d7 : d6 > d8 ? d8 : d6;
    }

    public static int decrementExact(int i6) {
        if (i6 != Integer.MIN_VALUE) {
            return i6 - 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int incrementExact(int i6) {
        if (i6 != Integer.MAX_VALUE) {
            return i6 + 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int multiplyExact(int i6, int i7) {
        int i8 = i6 * i7;
        if (i6 == 0 || i7 == 0 || (i8 / i6 == i7 && i8 / i7 == i6)) {
            return i8;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int negateExact(int i6) {
        if (i6 != Integer.MIN_VALUE) {
            return -i6;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int subtractExact(int i6, int i7) {
        int i8 = i6 - i7;
        if ((i6 < 0) != (i7 < 0)) {
            if ((i6 < 0) != (i8 < 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return i8;
    }

    public static long addExact(long j6, long j7) {
        long j8 = j6 + j7;
        if ((j6 >= 0) == (j7 >= 0)) {
            if ((j6 >= 0) != (j8 >= 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return j8;
    }

    public static float clamp(float f6, float f7, float f8) {
        return f6 < f7 ? f7 : f6 > f8 ? f8 : f6;
    }

    public static long decrementExact(long j6) {
        if (j6 != Long.MIN_VALUE) {
            return j6 - 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long incrementExact(long j6) {
        if (j6 != Long.MAX_VALUE) {
            return j6 + 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long negateExact(long j6) {
        if (j6 != Long.MIN_VALUE) {
            return -j6;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long subtractExact(long j6, long j7) {
        long j8 = j6 - j7;
        if ((j6 < 0) != (j7 < 0)) {
            if ((j6 < 0) != (j8 < 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return j8;
    }

    private MathUtils() {
    }

    public static int clamp(int i6, int i7, int i8) {
        return i6 < i7 ? i7 : i6 > i8 ? i8 : i6;
    }

    public static long multiplyExact(long j6, long j7) {
        long j8 = j6 * j7;
        if (j6 == 0 || j7 == 0 || (j8 / j6 == j7 && j8 / j7 == j6)) {
            return j8;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int toIntExact(long j6) {
        if (j6 <= 2147483647L && j6 >= -2147483648L) {
            return (int) j6;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long clamp(long j6, long j7, long j8) {
        return j6 < j7 ? j7 : j6 > j8 ? j8 : j6;
    }
}
