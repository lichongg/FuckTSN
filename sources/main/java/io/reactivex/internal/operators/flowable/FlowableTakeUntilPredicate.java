package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableTakeUntilPredicate<T> extends AbstractFlowableWithUpstream<T, T> {
    final Predicate<? super T> predicate;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class InnerSubscriber<T> implements Subscriber<T>, Subscription {
        final Subscriber<? super T> actual;
        boolean done;
        final Predicate<? super T> predicate;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43224s;

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f43224s.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
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
            this.actual.onNext(t5);
            try {
                if (this.predicate.test(t5)) {
                    this.done = true;
                    this.f43224s.cancel();
                    this.actual.onComplete();
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.f43224s.cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43224s, subscription)) {
                this.f43224s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            this.f43224s.request(j6);
        }

        InnerSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate) {
            this.actual = subscriber;
            this.predicate = predicate;
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new InnerSubscriber(subscriber, this.predicate));
    }

    public FlowableTakeUntilPredicate(Publisher<T> publisher, Predicate<? super T> predicate) {
        super(publisher);
        this.predicate = predicate;
    }
}
