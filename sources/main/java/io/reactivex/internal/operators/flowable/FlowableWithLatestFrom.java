package io.reactivex.internal.operators.flowable;

import androidx.camera.view.p;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableWithLatestFrom<T, U, R> extends AbstractFlowableWithUpstream<T, R> {
    final BiFunction<? super T, ? super U, ? extends R> combiner;
    final Publisher<? extends U> other;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class WithLatestFromSubscriber<T, U, R> extends AtomicReference<U> implements Subscriber<T>, Subscription {
        private static final long serialVersionUID = -312246233408980075L;
        final Subscriber<? super R> actual;
        final BiFunction<? super T, ? super U, ? extends R> combiner;

        /* renamed from: s, reason: collision with root package name */
        final AtomicReference<Subscription> f43248s = new AtomicReference<>();
        final AtomicReference<Subscription> other = new AtomicReference<>();

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f43248s.get().cancel();
            SubscriptionHelper.cancel(this.other);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            SubscriptionHelper.cancel(this.other);
            this.actual.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            SubscriptionHelper.cancel(this.other);
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.f43248s, subscription)) {
                this.actual.onSubscribe(this);
            }
        }

        public void otherError(Throwable th) {
            AtomicReference<Subscription> atomicReference = this.f43248s;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (p.a(atomicReference, null, subscriptionHelper)) {
                EmptySubscription.error(th, this.actual);
            } else if (this.f43248s.get() == subscriptionHelper) {
                RxJavaPlugins.onError(th);
            } else {
                cancel();
                this.actual.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            this.f43248s.get().request(j6);
        }

        public boolean setOther(Subscription subscription) {
            return SubscriptionHelper.setOnce(this.other, subscription);
        }

        WithLatestFromSubscriber(Subscriber<? super R> subscriber, BiFunction<? super T, ? super U, ? extends R> biFunction) {
            this.actual = subscriber;
            this.combiner = biFunction;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            U u5 = get();
            if (u5 != null) {
                try {
                    this.actual.onNext(this.combiner.apply(t5, u5));
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
                    this.actual.onError(th);
                }
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super R> subscriber) {
        final WithLatestFromSubscriber withLatestFromSubscriber = new WithLatestFromSubscriber(new SerializedSubscriber(subscriber), this.combiner);
        this.other.subscribe(new Subscriber<U>() { // from class: io.reactivex.internal.operators.flowable.FlowableWithLatestFrom.1
            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                withLatestFromSubscriber.otherError(th);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(U u5) {
                withLatestFromSubscriber.lazySet(u5);
            }

            @Override // org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                if (withLatestFromSubscriber.setOther(subscription)) {
                    subscription.request(Long.MAX_VALUE);
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
            }
        });
        this.source.subscribe(withLatestFromSubscriber);
    }

    public FlowableWithLatestFrom(Publisher<T> publisher, BiFunction<? super T, ? super U, ? extends R> biFunction, Publisher<? extends U> publisher2) {
        super(publisher);
        this.combiner = biFunction;
        this.other = publisher2;
    }
}
