package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableIgnoreElements<T> extends AbstractFlowableWithUpstream<T, T> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class IgnoreElementsSubscriber<T> implements QueueSubscription<T>, Subscriber<T> {
        final Subscriber<? super T> actual;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43186s;

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(T t5) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() {
            return null;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f43186s.cancel();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(T t5, T t6) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43186s, subscription)) {
                this.f43186s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i6) {
            return i6 & 2;
        }

        IgnoreElementsSubscriber(Subscriber<? super T> subscriber) {
            this.actual = subscriber;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new IgnoreElementsSubscriber(subscriber));
    }

    public FlowableIgnoreElements(Publisher<T> publisher) {
        super(publisher);
    }
}
