package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;
import rx.internal.util.atomic.LinkedQueueNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressAnimalSniffer
/* loaded from: D:\Downloads\app\classes9.dex */
public final class o<E> extends a<E> {
    protected LinkedQueueNode<E> m(LinkedQueueNode<E> linkedQueueNode) {
        while (true) {
            LinkedQueueNode<E> linkedQueueNode2 = this.producerNode;
            LinkedQueueNode<E> linkedQueueNode3 = linkedQueueNode;
            if (com.google.android.gms.internal.mlkit_acceleration.a.a(n0.f54298a, this, e.f54241q, linkedQueueNode2, linkedQueueNode3)) {
                return linkedQueueNode2;
            }
            linkedQueueNode = linkedQueueNode3;
        }
    }

    @Override // java.util.Queue
    public boolean offer(E e6) {
        if (e6 == null) {
            throw new NullPointerException("null elements not allowed");
        }
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>(e6);
        m(linkedQueueNode).soNext(linkedQueueNode);
        return true;
    }

    @Override // java.util.Queue
    public E peek() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> linkedQueueNode = this.consumerNode;
        LinkedQueueNode<E> lvNext2 = linkedQueueNode.lvNext();
        if (lvNext2 != null) {
            return lvNext2.lpValue();
        }
        if (linkedQueueNode == d()) {
            return null;
        }
        do {
            lvNext = linkedQueueNode.lvNext();
        } while (lvNext == null);
        return lvNext.lpValue();
    }

    public o() {
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>();
        this.consumerNode = linkedQueueNode;
        m(linkedQueueNode);
    }

    @Override // java.util.Queue
    public E poll() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> f6 = f();
        LinkedQueueNode<E> lvNext2 = f6.lvNext();
        if (lvNext2 != null) {
            E andNullValue = lvNext2.getAndNullValue();
            j(lvNext2);
            return andNullValue;
        }
        if (f6 != d()) {
            do {
                lvNext = f6.lvNext();
            } while (lvNext == null);
            E andNullValue2 = lvNext.getAndNullValue();
            this.consumerNode = lvNext;
            return andNullValue2;
        }
        return null;
    }
}
