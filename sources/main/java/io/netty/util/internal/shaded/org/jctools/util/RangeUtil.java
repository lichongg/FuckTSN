package io.netty.util.internal.shaded.org.jctools.util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class RangeUtil {
    public static int checkLessThanOrEqual(int i6, long j6, String str) {
        if (i6 <= j6) {
            return i6;
        }
        throw new IllegalArgumentException(str + ": " + i6 + " (expected: <= " + j6 + ')');
    }

    public static int checkGreaterThanOrEqual(int i6, int i7, String str) {
        if (i6 >= i7) {
            return i6;
        }
        throw new IllegalArgumentException(str + ": " + i6 + " (expected: >= " + i7 + ')');
    }

    public static int checkLessThan(int i6, int i7, String str) {
        if (i6 < i7) {
            return i6;
        }
        throw new IllegalArgumentException(str + ": " + i6 + " (expected: < " + i7 + ')');
    }

    public static long checkPositive(long j6, String str) {
        if (j6 > 0) {
            return j6;
        }
        throw new IllegalArgumentException(str + ": " + j6 + " (expected: > 0)");
    }

    public static int checkPositiveOrZero(int i6, String str) {
        if (i6 >= 0) {
            return i6;
        }
        throw new IllegalArgumentException(str + ": " + i6 + " (expected: >= 0)");
    }
}
