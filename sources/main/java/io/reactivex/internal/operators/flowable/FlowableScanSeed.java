package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableScanSeed<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final BiFunction<R, ? super T, R> accumulator;
    final Callable<R> seedSupplier;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ScanSeedSubscriber<T, R> extends SinglePostCompleteSubscriber<T, R> {
        private static final long serialVersionUID = -1776795561228106469L;
        final BiFunction<R, ? super T, R> accumulator;

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.value = null;
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            complete(this.value);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            R r5 = this.value;
            try {
                this.value = (R) ObjectHelper.requireNonNull(this.accumulator.apply(r5, t5), "The accumulator returned a null value");
                this.produced++;
                this.actual.onNext(r5);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.f43414s.cancel();
                onError(th);
            }
        }

        ScanSeedSubscriber(Subscriber<? super R> subscriber, BiFunction<R, ? super T, R> biFunction, R r5) {
            super(subscriber);
            this.accumulator = biFunction;
            this.value = r5;
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super R> subscriber) {
        try {
            this.source.subscribe(new ScanSeedSubscriber(subscriber, this.accumulator, ObjectHelper.requireNonNull(this.seedSupplier.call(), "The seed supplied is null")));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }

    public FlowableScanSeed(Publisher<T> publisher, Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        super(publisher);
        this.accumulator = biFunction;
        this.seedSupplier = callable;
    }
}
