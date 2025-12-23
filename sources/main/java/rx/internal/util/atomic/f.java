package rx.internal.util.atomic;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f<E> extends b<E> {
    @Override // java.util.Queue
    public boolean offer(E e6) {
        if (e6 == null) {
            throw new NullPointerException("null elements not allowed");
        }
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>(e6);
        d().soNext(linkedQueueNode);
        j(linkedQueueNode);
        return true;
    }

    public f() {
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>();
        j(linkedQueueNode);
        g(linkedQueueNode);
        linkedQueueNode.soNext(null);
    }

    @Override // java.util.Queue
    public E peek() {
        LinkedQueueNode<E> lvNext = a().lvNext();
        if (lvNext != null) {
            return lvNext.lpValue();
        }
        return null;
    }

    @Override // java.util.Queue
    public E poll() {
        LinkedQueueNode<E> lvNext = a().lvNext();
        if (lvNext != null) {
            E andNullValue = lvNext.getAndNullValue();
            g(lvNext);
            return andNullValue;
        }
        return null;
    }
}
