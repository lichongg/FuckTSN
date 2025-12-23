package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;
import rx.internal.util.atomic.LinkedQueueNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressAnimalSniffer
/* loaded from: D:\Downloads\app\classes9.dex */
abstract class e<E> extends c<E> {

    /* renamed from: q, reason: collision with root package name */
    protected static final long f54241q = n0.a(e.class, "producerNode");
    protected LinkedQueueNode<E> producerNode;

    protected final LinkedQueueNode<E> a() {
        return this.producerNode;
    }

    protected final LinkedQueueNode<E> d() {
        return (LinkedQueueNode) n0.f54298a.getObjectVolatile(this, f54241q);
    }

    protected final void e(LinkedQueueNode<E> linkedQueueNode) {
        this.producerNode = linkedQueueNode;
    }

    e() {
    }
}
