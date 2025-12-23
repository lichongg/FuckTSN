package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableScan<T> extends AbstractFlowableWithUpstream<T, T> {
    final BiFunction<T, T, T> accumulator;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ScanSubscriber<T> implements Subscriber<T>, Subscription {
        final BiFunction<T, T, T> accumulator;
        final Subscriber<? super T> actual;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43204s;
        T value;

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f43204s.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.Object] */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            Subscriber<? super T> subscriber = this.actual;
            T t6 = this.value;
            if (t6 == null) {
                this.value = t5;
                subscriber.onNext(t5);
                return;
            }
            try {
                ?? r42 = (T) ObjectHelper.requireNonNull(this.accumulator.apply(t6, t5), "The value returned by the accumulator is null");
                this.value = r42;
                subscriber.onNext(r42);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.f43204s.cancel();
                subscriber.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43204s, subscription)) {
                this.f43204s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            this.f43204s.request(j6);
        }

        ScanSubscriber(Subscriber<? super T> subscriber, BiFunction<T, T, T> biFunction) {
            this.actual = subscriber;
            this.accumulator = biFunction;
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new ScanSubscriber(subscriber, this.accumulator));
    }

    public FlowableScan(Publisher<T> publisher, BiFunction<T, T, T> biFunction) {
        super(publisher);
        this.accumulator = biFunction;
    }
}
