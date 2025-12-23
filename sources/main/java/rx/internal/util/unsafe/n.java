package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressAnimalSniffer
/* loaded from: D:\Downloads\app\classes9.dex */
abstract class n<E> extends l<E> {
    private static final long O = n0.a(n.class, "producerIndex");
    private volatile long producerIndex;

    protected final boolean t(long j6, long j7) {
        return n0.f54298a.compareAndSwapLong(this, O, j6, j7);
    }

    protected final long u() {
        return this.producerIndex;
    }

    public n(int i6) {
        super(i6);
    }
}
