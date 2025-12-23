package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressAnimalSniffer
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class h<E> extends f<E> {

    /* renamed from: x, reason: collision with root package name */
    private static final long f54264x;

    /* renamed from: y, reason: collision with root package name */
    private static final int f54265y;

    /* renamed from: w, reason: collision with root package name */
    protected final long[] f54266w;

    static {
        if (8 != n0.f54298a.arrayIndexScale(long[].class)) {
            throw new IllegalStateException("Unexpected long[] element size");
        }
        f54265y = f.f54242s + 3;
        f54264x = r0.arrayBaseOffset(long[].class) + (32 << (r3 - r2));
    }

    protected final long q(long j6) {
        return f54264x + ((j6 & this.f54246q) << f54265y);
    }

    protected final long r(long[] jArr, long j6) {
        return n0.f54298a.getLongVolatile(jArr, j6);
    }

    protected final void s(long[] jArr, long j6, long j7) {
        n0.f54298a.putOrderedLong(jArr, j6, j7);
    }

    public h(int i6) {
        super(i6);
        int i7 = (int) (this.f54246q + 1);
        this.f54266w = new long[(i7 << f.f54242s) + 64];
        for (long j6 = 0; j6 < i7; j6++) {
            s(this.f54266w, q(j6), j6);
        }
    }
}
