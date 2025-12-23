package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableSkip<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: n, reason: collision with root package name */
    final long f43212n;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class SkipSubscriber<T> implements Subscriber<T>, Subscription {
        final Subscriber<? super T> actual;
        long remaining;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43213s;

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f43213s.cancel();
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
        public void onNext(T t5) {
            long j6 = this.remaining;
            if (j6 != 0) {
                this.remaining = j6 - 1;
            } else {
                this.actual.onNext(t5);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43213s, subscription)) {
                long j6 = this.remaining;
                this.f43213s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(j6);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            this.f43213s.request(j6);
        }

        SkipSubscriber(Subscriber<? super T> subscriber, long j6) {
            this.actual = subscriber;
            this.remaining = j6;
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new SkipSubscriber(subscriber, this.f43212n));
    }

    public FlowableSkip(Publisher<T> publisher, long j6) {
        super(publisher);
        this.f43212n = j6;
    }
}
