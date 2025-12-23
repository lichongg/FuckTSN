package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressAnimalSniffer
/* loaded from: D:\Downloads\app\classes9.dex */
abstract class s<E> extends u<E> {

    /* renamed from: b0, reason: collision with root package name */
    protected static final long f54300b0 = n0.a(s.class, "consumerIndex");
    private volatile long consumerIndex;

    protected final boolean s(long j6, long j7) {
        return n0.f54298a.compareAndSwapLong(this, f54300b0, j6, j7);
    }

    protected final long t() {
        return this.consumerIndex;
    }

    public s(int i6) {
        super(i6);
    }
}
