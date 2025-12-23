package rx.internal.util.unsafe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class p {
    public static int b(int i6) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i6 - 1));
    }

    public static boolean a(int i6) {
        return (i6 & (i6 + (-1))) == 0;
    }

    private p() {
        throw new IllegalStateException("No instances!");
    }
}
