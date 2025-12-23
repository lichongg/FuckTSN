package rx.internal.operators;

import java.util.concurrent.Callable;
import rx.e;
import rx.internal.producers.SingleDelayedProducer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class m0<T> implements e.a<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Callable<? extends T> f53168a;

    @Override // rx.functions.b
    public void call(rx.l<? super T> lVar) {
        SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(lVar);
        lVar.setProducer(singleDelayedProducer);
        try {
            singleDelayedProducer.setValue(this.f53168a.call());
        } catch (Throwable th) {
            rx.exceptions.a.f(th, lVar);
        }
    }

    public m0(Callable<? extends T> callable) {
        this.f53168a = callable;
    }
}
