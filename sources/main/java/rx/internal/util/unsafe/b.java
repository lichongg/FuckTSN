package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;
import rx.internal.util.atomic.LinkedQueueNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressAnimalSniffer
/* loaded from: D:\Downloads\app\classes9.dex */
abstract class b<E> extends d<E> {
    protected static final long H = n0.a(b.class, "consumerNode");
    protected LinkedQueueNode<E> consumerNode;

    protected final LinkedQueueNode<E> f() {
        return this.consumerNode;
    }

    protected final LinkedQueueNode<E> g() {
        return (LinkedQueueNode) n0.f54298a.getObjectVolatile(this, H);
    }

    protected final void j(LinkedQueueNode<E> linkedQueueNode) {
        this.consumerNode = linkedQueueNode;
    }

    b() {
    }
}
