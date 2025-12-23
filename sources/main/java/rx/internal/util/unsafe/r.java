package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressAnimalSniffer
/* loaded from: D:\Downloads\app\classes9.dex */
public final class r<E> extends v<E> {
    @Override // java.util.Queue, rx.internal.util.unsafe.i
    public boolean offer(E e6) {
        if (e6 == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        E[] eArr = this.f54247r;
        long j6 = this.f54246q;
        long q5 = q();
        long a6 = a(q5);
        if (j(eArr, a6) != null) {
            if (q5 - t() > j6) {
                return false;
            }
            while (j(eArr, a6) != null) {
            }
        }
        p(eArr, a6, e6);
        r(q5 + 1);
        return true;
    }

    public r(int i6) {
        super(i6);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, rx.internal.util.unsafe.i
    public boolean isEmpty() {
        if (t() == q()) {
            return true;
        }
        return false;
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.i
    public E peek() {
        E g6;
        long u5 = u();
        do {
            long t5 = t();
            if (t5 >= u5) {
                long q5 = q();
                if (t5 >= q5) {
                    return null;
                }
                v(q5);
            }
            g6 = g(a(t5));
        } while (g6 == null);
        return g6;
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.i
    public E poll() {
        long t5;
        long u5 = u();
        do {
            t5 = t();
            if (t5 >= u5) {
                long q5 = q();
                if (t5 >= q5) {
                    return null;
                }
                v(q5);
            }
        } while (!s(t5, 1 + t5));
        long a6 = a(t5);
        E[] eArr = this.f54247r;
        E f6 = f(eArr, a6);
        n(eArr, a6, null);
        return f6;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, rx.internal.util.unsafe.i
    public int size() {
        long t5 = t();
        while (true) {
            long q5 = q();
            long t6 = t();
            if (t5 == t6) {
                return (int) (q5 - t6);
            }
            t5 = t6;
        }
    }
}
