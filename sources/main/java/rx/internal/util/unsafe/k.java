package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressAnimalSniffer
/* loaded from: D:\Downloads\app\classes9.dex */
abstract class k<E> extends m<E> {

    /* renamed from: p0, reason: collision with root package name */
    private static final long f54275p0 = n0.a(k.class, "consumerIndex");
    private volatile long consumerIndex;

    protected final boolean v(long j6, long j7) {
        return n0.f54298a.compareAndSwapLong(this, f54275p0, j6, j7);
    }

    protected final long w() {
        return this.consumerIndex;
    }

    public k(int i6) {
        super(i6);
    }
}
