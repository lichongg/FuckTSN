package kotlin;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final /* synthetic */ class s0 {
    public static /* synthetic */ long a(long j6, long j7) {
        if (j7 < 0) {
            return (j6 ^ Long.MIN_VALUE) < (Long.MIN_VALUE ^ j7) ? j6 : j6 - j7;
        }
        if (j6 >= 0) {
            return j6 % j7;
        }
        long j8 = j6 - ((((j6 >>> 1) / j7) << 1) * j7);
        if ((j8 ^ Long.MIN_VALUE) < (Long.MIN_VALUE ^ j7)) {
            j7 = 0;
        }
        return j8 - j7;
    }
}
