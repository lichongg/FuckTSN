package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EmptyComponent;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableDetach<T> extends AbstractFlowableWithUpstream<T, T> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class DetachSubscriber<T> implements Subscriber<T>, Subscription {
        Subscriber<? super T> actual;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43169s;

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Subscription subscription = this.f43169s;
            this.f43169s = EmptyComponent.INSTANCE;
            this.actual = EmptyComponent.asSubscriber();
            subscription.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Subscriber<? super T> subscriber = this.actual;
            this.f43169s = EmptyComponent.INSTANCE;
            this.actual = EmptyComponent.asSubscriber();
            subscriber.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Subscriber<? super T> subscriber = this.actual;
            this.f43169s = EmptyComponent.INSTANCE;
            this.actual = EmptyComponent.asSubscriber();
            subscriber.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            this.actual.onNext(t5);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43169s, subscription)) {
                this.f43169s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            this.f43169s.request(j6);
        }

        DetachSubscriber(Subscriber<? super T> subscriber) {
            this.actual = subscriber;
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new DetachSubscriber(subscriber));
    }

    public FlowableDetach(Publisher<T> publisher) {
        super(publisher);
    }
}
