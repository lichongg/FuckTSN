package rx.internal.util.unsafe;

import java.util.Iterator;
import rx.internal.util.SuppressAnimalSniffer;
import rx.internal.util.atomic.LinkedQueueNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressAnimalSniffer
/* loaded from: D:\Downloads\app\classes9.dex */
abstract class a<E> extends b<E> {
    long I;
    long J;
    long K;
    long L;
    long M;
    long N;
    long O;
    long P;
    long Q;
    long R;
    long S;
    long T;
    long U;
    long V;
    long W;
    long X;

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    a() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        if (g() == d()) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> g6 = g();
        LinkedQueueNode<E> d6 = d();
        int i6 = 0;
        while (g6 != d6 && i6 < Integer.MAX_VALUE) {
            do {
                lvNext = g6.lvNext();
            } while (lvNext == null);
            i6++;
            g6 = lvNext;
        }
        return i6;
    }
}
