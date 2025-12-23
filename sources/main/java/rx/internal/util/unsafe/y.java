package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressAnimalSniffer
/* loaded from: D:\Downloads\app\classes9.dex */
abstract class y<E> extends w<E> {
    private volatile long R0;

    protected final long u() {
        return this.R0;
    }

    protected final void v(long j6) {
        this.R0 = j6;
    }

    public y(int i6) {
        super(i6);
    }
}
