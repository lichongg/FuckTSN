package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressAnimalSniffer
/* loaded from: D:\Downloads\app\classes9.dex */
abstract class x<E> extends t<E> {
    protected static final long L = n0.a(x.class, "producerIndex");
    private volatile long producerIndex;

    protected final long q() {
        return this.producerIndex;
    }

    protected final void r(long j6) {
        n0.f54298a.putOrderedLong(this, L, j6);
    }

    public x(int i6) {
        super(i6);
    }
}
