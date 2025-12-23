package io.netty.util.internal.shaded.org.jctools.util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class Pow2 {
    public static final int MAX_POW2 = 1073741824;

    public static boolean isPowerOfTwo(int i6) {
        return (i6 & (i6 + (-1))) == 0;
    }

    public static int roundToPowerOfTwo(int i6) {
        if (i6 > 1073741824) {
            throw new IllegalArgumentException("There is no larger power of 2 int for value:" + i6 + " since it exceeds 2^31.");
        }
        if (i6 >= 0) {
            return 1 << (32 - Integer.numberOfLeadingZeros(i6 - 1));
        }
        throw new IllegalArgumentException("Given value:" + i6 + ". Expecting value >= 0.");
    }

    public static long align(long j6, int i6) {
        if (isPowerOfTwo(i6)) {
            return (j6 + (i6 - 1)) & (~r4);
        }
        throw new IllegalArgumentException("alignment must be a power of 2:" + i6);
    }
}
