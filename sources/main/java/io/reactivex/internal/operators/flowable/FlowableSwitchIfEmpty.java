package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableSwitchIfEmpty<T> extends AbstractFlowableWithUpstream<T, T> {
    final Publisher<? extends T> other;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class SwitchIfEmptySubscriber<T> implements Subscriber<T> {
        final Subscriber<? super T> actual;
        final Publisher<? extends T> other;
        boolean empty = true;
        final SubscriptionArbiter arbiter = new SubscriptionArbiter();

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.empty) {
                this.actual.onComplete();
            } else {
                this.empty = false;
                this.other.subscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (this.empty) {
                this.empty = false;
            }
            this.actual.onNext(t5);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            this.arbiter.setSubscription(subscription);
        }

        SwitchIfEmptySubscriber(Subscriber<? super T> subscriber, Publisher<? extends T> publisher) {
            this.actual = subscriber;
            this.other = publisher;
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        SwitchIfEmptySubscriber switchIfEmptySubscriber = new SwitchIfEmptySubscriber(subscriber, this.other);
        subscriber.onSubscribe(switchIfEmptySubscriber.arbiter);
        this.source.subscribe(switchIfEmptySubscriber);
    }

    public FlowableSwitchIfEmpty(Publisher<T> publisher, Publisher<? extends T> publisher2) {
        super(publisher);
        this.other = publisher2;
    }
}
