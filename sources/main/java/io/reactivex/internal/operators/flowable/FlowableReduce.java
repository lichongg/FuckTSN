package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableReduce<T> extends AbstractFlowableWithUpstream<T, T> {
    final BiFunction<T, T, T> reducer;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ReduceSubscriber<T> extends DeferredScalarSubscription<T> implements Subscriber<T> {
        private static final long serialVersionUID = -4663883003264602070L;
        final BiFunction<T, T, T> reducer;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43200s;

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Subscription subscription = this.f43200s;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription == subscriptionHelper) {
                return;
            }
            this.f43200s = subscriptionHelper;
            T t5 = this.value;
            if (t5 != null) {
                complete(t5);
            } else {
                this.actual.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Subscription subscription = this.f43200s;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription == subscriptionHelper) {
                RxJavaPlugins.onError(th);
            } else {
                this.f43200s = subscriptionHelper;
                this.actual.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (this.f43200s == SubscriptionHelper.CANCELLED) {
                return;
            }
            T t6 = this.value;
            if (t6 == null) {
                this.value = t5;
                return;
            }
            try {
                this.value = (T) ObjectHelper.requireNonNull(this.reducer.apply(t6, t5), "The reducer returned a null value");
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.f43200s.cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43200s, subscription)) {
                this.f43200s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        ReduceSubscriber(Subscriber<? super T> subscriber, BiFunction<T, T, T> biFunction) {
            super(subscriber);
            this.reducer = biFunction;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.f43200s.cancel();
            this.f43200s = SubscriptionHelper.CANCELLED;
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new ReduceSubscriber(subscriber, this.reducer));
    }

    public FlowableReduce(Publisher<T> publisher, BiFunction<T, T, T> biFunction) {
        super(publisher);
        this.reducer = biFunction;
    }
}
