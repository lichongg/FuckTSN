package rx.internal.producers;

import java.util.concurrent.atomic.AtomicInteger;
import rx.g;
import rx.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class SingleDelayedProducer<T> extends AtomicInteger implements g {
    static final int HAS_REQUEST_HAS_VALUE = 3;
    static final int HAS_REQUEST_NO_VALUE = 2;
    static final int NO_REQUEST_HAS_VALUE = 1;
    static final int NO_REQUEST_NO_VALUE = 0;
    private static final long serialVersionUID = -2873467947112093874L;
    final l<? super T> child;
    T value;

    @Override // rx.g
    public void request(long j6) {
        if (j6 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j6 == 0) {
            return;
        }
        do {
            int i6 = get();
            if (i6 != 0) {
                if (i6 == 1 && compareAndSet(1, 3)) {
                    emit(this.child, this.value);
                    return;
                }
                return;
            }
        } while (!compareAndSet(0, 2));
    }

    public SingleDelayedProducer(l<? super T> lVar) {
        this.child = lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void emit(l<? super T> lVar, T t5) {
        if (!lVar.isUnsubscribed()) {
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

    public void setValue(T t5) {
        do {
            int i6 = get();
            if (i6 == 0) {
                this.value = t5;
            } else {
                if (i6 == 2 && compareAndSet(2, 3)) {
                    emit(this.child, t5);
                    return;
                }
                return;
            }
        } while (!compareAndSet(0, 1));
    }
}
