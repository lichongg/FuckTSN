package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableAll<T> extends AbstractFlowableWithUpstream<T, Boolean> {
    final Predicate<? super T> predicate;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class AllSubscriber<T> extends DeferredScalarSubscription<Boolean> implements Subscriber<T> {
        private static final long serialVersionUID = -3521127104134758517L;
        boolean done;
        final Predicate<? super T> predicate;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43141s;

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            complete(Boolean.TRUE);
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
            try {
                if (this.predicate.test(t5)) {
                    return;
                }
                this.done = true;
                this.f43141s.cancel();
                complete(Boolean.FALSE);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.f43141s.cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43141s, subscription)) {
                this.f43141s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        AllSubscriber(Subscriber<? super Boolean> subscriber, Predicate<? super T> predicate) {
            super(subscriber);
            this.predicate = predicate;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.f43141s.cancel();
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super Boolean> subscriber) {
        this.source.subscribe(new AllSubscriber(subscriber, this.predicate));
    }

    public FlowableAll(Publisher<T> publisher, Predicate<? super T> predicate) {
        super(publisher);
        this.predicate = predicate;
    }
}
