package rx.internal.util.atomic;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c<E> extends b<E> {
    @Override // java.util.Queue
    public boolean offer(E e6) {
        if (e6 == null) {
            throw new NullPointerException("null elements not allowed");
        }
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>(e6);
        m(linkedQueueNode).soNext(linkedQueueNode);
        return true;
    }

    public c() {
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>();
        g(linkedQueueNode);
        m(linkedQueueNode);
    }

    @Override // java.util.Queue
    public E peek() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> a6 = a();
        LinkedQueueNode<E> lvNext2 = a6.lvNext();
        if (lvNext2 != null) {
            return lvNext2.lpValue();
        }
        if (a6 != f()) {
            do {
                lvNext = a6.lvNext();
            } while (lvNext == null);
            return lvNext.lpValue();
        }
        return null;
    }

    @Override // java.util.Queue
    public E poll() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> a6 = a();
        LinkedQueueNode<E> lvNext2 = a6.lvNext();
        if (lvNext2 != null) {
            E andNullValue = lvNext2.getAndNullValue();
            g(lvNext2);
            return andNullValue;
        }
        if (a6 != f()) {
            do {
                lvNext = a6.lvNext();
            } while (lvNext == null);
            E andNullValue2 = lvNext.getAndNullValue();
            g(lvNext);
            return andNullValue2;
        }
        return null;
    }
}
