package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements e.a<T> {
    final rx.functions.b<? super rx.m> connection;
    final int numberOfSubscribers;
    final rx.observables.c<? extends T> source;

    @Override // rx.functions.b
    public void call(rx.l<? super T> lVar) {
        this.source.J6(rx.observers.h.f(lVar));
        if (incrementAndGet() == this.numberOfSubscribers) {
            this.source.A7(this.connection);
        }
    }

    public OnSubscribeAutoConnect(rx.observables.c<? extends T> cVar, int i6, rx.functions.b<? super rx.m> bVar) {
        if (i6 > 0) {
            this.source = cVar;
            this.numberOfSubscribers = i6;
            this.connection = bVar;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }
}
