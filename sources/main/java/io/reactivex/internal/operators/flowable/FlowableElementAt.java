package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableElementAt<T> extends AbstractFlowableWithUpstream<T, T> {
    final T defaultValue;
    final long index;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ElementAtSubscriber<T> extends DeferredScalarSubscription<T> implements Subscriber<T> {
        private static final long serialVersionUID = 4066607327284737757L;
        long count;
        final T defaultValue;
        boolean done;
        final long index;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43173s;

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            T t5 = this.defaultValue;
            if (t5 == null) {
                this.actual.onComplete();
            } else {
                complete(t5);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (this.done) {
                return;
            }
            long j6 = this.count;
            if (j6 != this.index) {
                this.count = j6 + 1;
                return;
            }
            this.done = true;
            this.f43173s.cancel();
            complete(t5);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43173s, subscription)) {
                this.f43173s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        ElementAtSubscriber(Subscriber<? super T> subscriber, long j6, T t5) {
            super(subscriber);
            this.index = j6;
            this.defaultValue = t5;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.f43173s.cancel();
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new ElementAtSubscriber(subscriber, this.index, this.defaultValue));
    }

    public FlowableElementAt(Publisher<T> publisher, long j6, T t5) {
        super(publisher);
        this.index = j6;
        this.defaultValue = t5;
    }
}
