package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressAnimalSniffer
/* loaded from: D:\Downloads\app\classes9.dex */
public final class z<E> extends e0<E> {
    private long q() {
        return n0.f54298a.getLongVolatile(this, b0.f54209p0);
    }

    private long r() {
        return n0.f54298a.getLongVolatile(this, f0.O);
    }

    private void s(long j6) {
        n0.f54298a.putOrderedLong(this, b0.f54209p0, j6);
    }

    private void t(long j6) {
        n0.f54298a.putOrderedLong(this, f0.O, j6);
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.i
    public boolean offer(E e6) {
        if (e6 == null) {
            throw new NullPointerException("null elements not allowed");
        }
        E[] eArr = this.f54247r;
        long j6 = this.producerIndex;
        long a6 = a(j6);
        if (j(eArr, a6) != null) {
            return false;
        }
        n(eArr, a6, e6);
        t(j6 + 1);
        return true;
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.i
    public E peek() {
        return g(a(this.consumerIndex));
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.i
    public E poll() {
        long j6 = this.consumerIndex;
        long a6 = a(j6);
        E[] eArr = this.f54247r;
        E j7 = j(eArr, a6);
        if (j7 == null) {
            return null;
        }
        n(eArr, a6, null);
        s(j6 + 1);
        return j7;
    }

    public z(int i6) {
        super(i6);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, rx.internal.util.unsafe.i
    public boolean isEmpty() {
        if (r() == q()) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, rx.internal.util.unsafe.i
    public int size() {
        long q5 = q();
        while (true) {
            long r5 = r();
            long q6 = q();
            if (q5 == q6) {
                return (int) (r5 - q6);
            }
            q5 = q6;
        }
    }
}
