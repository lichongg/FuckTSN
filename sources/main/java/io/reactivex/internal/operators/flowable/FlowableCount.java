package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableCount<T> extends AbstractFlowableWithUpstream<T, Long> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class CountSubscriber extends DeferredScalarSubscription<Long> implements Subscriber<Object> {
        private static final long serialVersionUID = 4973004223787171406L;
        long count;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43162s;

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            complete(Long.valueOf(this.count));
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            this.count++;
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43162s, subscription)) {
                this.f43162s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        CountSubscriber(Subscriber<? super Long> subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.f43162s.cancel();
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super Long> subscriber) {
        this.source.subscribe(new CountSubscriber(subscriber));
    }

    public FlowableCount(Publisher<T> publisher) {
        super(publisher);
    }
}
