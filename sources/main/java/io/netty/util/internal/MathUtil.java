package io.netty.util.internal;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class MathUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static int compare(int i6, int i7) {
        if (i6 < i7) {
            return -1;
        }
        return i6 > i7 ? 1 : 0;
    }

    public static int findNextPositivePowerOfTwo(int i6) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i6 - 1));
    }

    public static int compare(long j6, long j7) {
        if (j6 < j7) {
            return -1;
        }
        return j6 > j7 ? 1 : 0;
    }

    public static boolean isOutOfBounds(int i6, int i7, int i8) {
        int i9 = i6 | i7;
        int i10 = i6 + i7;
        return ((i9 | i10) | (i8 - i10)) < 0;
    }

    public static int safeFindNextPositivePowerOfTwo(int i6) {
        if (i6 <= 0) {
            return 1;
        }
        if (i6 >= 1073741824) {
            return 1073741824;
        }
        return findNextPositivePowerOfTwo(i6);
    }

    private MathUtil() {
    }
}
