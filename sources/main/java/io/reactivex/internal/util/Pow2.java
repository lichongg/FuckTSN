package io.reactivex.internal.util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class Pow2 {
    public static int roundToPowerOfTwo(int i6) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i6 - 1));
    }

    public static boolean isPowerOfTwo(int i6) {
        return (i6 & (i6 + (-1))) == 0;
    }

    private Pow2() {
        throw new IllegalStateException("No instances!");
    }
}
