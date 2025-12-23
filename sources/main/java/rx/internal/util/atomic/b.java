package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
abstract class b<E> extends AbstractQueue<E> {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference<LinkedQueueNode<E>> f54106a = new AtomicReference<>();

    /* renamed from: b, reason: collision with root package name */
    private final AtomicReference<LinkedQueueNode<E>> f54107b = new AtomicReference<>();

    protected final LinkedQueueNode<E> a() {
        return this.f54107b.get();
    }

    protected final LinkedQueueNode<E> d() {
        return this.f54106a.get();
    }

    protected final LinkedQueueNode<E> e() {
        return this.f54107b.get();
    }

    protected final LinkedQueueNode<E> f() {
        return this.f54106a.get();
    }

    protected final void g(LinkedQueueNode<E> linkedQueueNode) {
        this.f54107b.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    protected final void j(LinkedQueueNode<E> linkedQueueNode) {
        this.f54106a.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> m(LinkedQueueNode<E> linkedQueueNode) {
        return this.f54106a.getAndSet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        if (e() == f()) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> e6 = e();
        LinkedQueueNode<E> f6 = f();
        int i6 = 0;
        while (e6 != f6 && i6 < Integer.MAX_VALUE) {
            do {
                lvNext = e6.lvNext();
            } while (lvNext == null);
            i6++;
            e6 = lvNext;
        }
        return i6;
    }
}
