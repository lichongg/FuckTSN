package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableSkipWhile<T> extends AbstractFlowableWithUpstream<T, T> {
    final Predicate<? super T> predicate;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class SkipWhileSubscriber<T> implements Subscriber<T>, Subscription {
        final Subscriber<? super T> actual;
        boolean notSkipping;
        final Predicate<? super T> predicate;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43217s;

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f43217s.cancel();
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
            if (this.notSkipping) {
                this.actual.onNext(t5);
                return;
            }
            try {
                if (this.predicate.test(t5)) {
                    this.f43217s.request(1L);
                } else {
                    this.notSkipping = true;
                    this.actual.onNext(t5);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.f43217s.cancel();
                this.actual.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43217s, subscription)) {
                this.f43217s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            this.f43217s.request(j6);
        }

        SkipWhileSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate) {
            this.actual = subscriber;
            this.predicate = predicate;
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new SkipWhileSubscriber(subscriber, this.predicate));
    }

    public FlowableSkipWhile(Publisher<T> publisher, Predicate<? super T> predicate) {
        super(publisher);
        this.predicate = predicate;
    }
}
