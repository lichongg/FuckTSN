package io.netty.util.internal;

import java.util.Collection;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class ObjectUtil {
    public static <T> T[] checkNonEmpty(T[] tArr, String str) {
        checkNotNull(tArr, str);
        checkPositive(tArr.length, str + ".length");
        return tArr;
    }

    public static int checkPositive(int i6, String str) {
        if (i6 > 0) {
            return i6;
        }
        throw new IllegalArgumentException(str + ": " + i6 + " (expected: > 0)");
    }

    public static int checkPositiveOrZero(int i6, String str) {
        if (i6 >= 0) {
            return i6;
        }
        throw new IllegalArgumentException(str + ": " + i6 + " (expected: >= 0)");
    }

    public static <T> T checkNotNull(T t5, String str) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(str);
    }

    public static long checkPositive(long j6, String str) {
        if (j6 > 0) {
            return j6;
        }
        throw new IllegalArgumentException(str + ": " + j6 + " (expected: > 0)");
    }

    public static long checkPositiveOrZero(long j6, String str) {
        if (j6 >= 0) {
            return j6;
        }
        throw new IllegalArgumentException(str + ": " + j6 + " (expected: >= 0)");
    }

    public static int intValue(Integer num, int i6) {
        return num != null ? num.intValue() : i6;
    }

    public static long longValue(Long l6, long j6) {
        return l6 != null ? l6.longValue() : j6;
    }

    private ObjectUtil() {
    }

    public static <T extends Collection<?>> T checkNonEmpty(T t5, String str) {
        checkNotNull(t5, str);
        checkPositive(t5.size(), str + ".size");
        return t5;
    }
}
