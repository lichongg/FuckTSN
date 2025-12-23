package io.reactivex.internal.subscriptions;

import io.reactivex.internal.fuseable.QueueSubscription;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ScalarSubscription<T> extends AtomicInteger implements QueueSubscription<T> {
    static final int CANCELLED = 2;
    static final int NO_REQUEST = 0;
    static final int REQUESTED = 1;
    private static final long serialVersionUID = -3830916580126663321L;
    final Subscriber<? super T> subscriber;
    final T value;

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        lazySet(2);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        lazySet(1);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T t5) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T t5, T t6) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.internal.fuseable.QueueFuseable
    public int requestFusion(int i6) {
        return i6 & 1;
    }

    public ScalarSubscription(Subscriber<? super T> subscriber, T t5) {
        this.subscriber = subscriber;
        this.value = t5;
    }

    public boolean isCancelled() {
        if (get() == 2) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        if (get() != 0) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public T poll() {
        if (get() == 0) {
            lazySet(1);
            return this.value;
        }
        return null;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j6) {
        if (SubscriptionHelper.validate(j6) && compareAndSet(0, 1)) {
            Subscriber<? super T> subscriber = this.subscriber;
            subscriber.onNext(this.value);
            if (get() != 2) {
                subscriber.onComplete();
            }
        }
    }
}
