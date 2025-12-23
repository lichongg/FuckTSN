package rx.internal.producers;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.g;
import rx.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class SingleProducer<T> extends AtomicBoolean implements g {
    private static final long serialVersionUID = -3353584923995471404L;
    final l<? super T> child;
    final T value;

    @Override // rx.g
    public void request(long j6) {
        if (j6 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j6 != 0 && compareAndSet(false, true)) {
            l<? super T> lVar = this.child;
            if (lVar.isUnsubscribed()) {
                return;
            }
            T t5 = this.value;
            try {
                lVar.onNext(t5);
                if (lVar.isUnsubscribed()) {
                    return;
                }
                lVar.onCompleted();
            } catch (Throwable th) {
                rx.exceptions.a.g(th, lVar, t5);
            }
        }
    }

    public SingleProducer(l<? super T> lVar, T t5) {
        this.child = lVar;
        this.value = t5;
    }
}
