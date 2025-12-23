package io.reactivex.internal.operators.flowable;

import io.reactivex.Emitter;
import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableGenerate<T, S> extends Flowable<T> {
    final Consumer<? super S> disposeState;
    final BiFunction<S, Emitter<T>, S> generator;
    final Callable<S> stateSupplier;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class GeneratorSubscription<T, S> extends AtomicLong implements Emitter<T>, Subscription {
        private static final long serialVersionUID = 7565982551505011832L;
        final Subscriber<? super T> actual;
        volatile boolean cancelled;
        final Consumer<? super S> disposeState;
        final BiFunction<S, ? super Emitter<T>, S> generator;
        S state;
        boolean terminate;

        @Override // io.reactivex.Emitter
        public void onComplete() {
            this.terminate = true;
            this.actual.onComplete();
        }

        private void dispose(S s5) {
            try {
                this.disposeState.accept(s5);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            if (BackpressureHelper.add(this, 1L) == 0) {
                dispose(this.state);
            }
        }

        @Override // io.reactivex.Emitter
        public void onError(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.terminate = true;
            this.actual.onError(th);
        }

        @Override // io.reactivex.Emitter
        public void onNext(T t5) {
            if (t5 == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.actual.onNext(t5);
            }
        }

        GeneratorSubscription(Subscriber<? super T> subscriber, BiFunction<S, ? super Emitter<T>, S> biFunction, Consumer<? super S> consumer, S s5) {
            this.actual = subscriber;
            this.generator = biFunction;
            this.disposeState = consumer;
            this.state = s5;
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x004a, code lost:
        
            r8.state = r0;
            r9 = addAndGet(-r4);
         */
        @Override // org.reactivestreams.Subscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void request(long r9) {
            /*
                r8 = this;
                boolean r0 = io.reactivex.internal.subscriptions.SubscriptionHelper.validate(r9)
                if (r0 != 0) goto L7
                goto L55
            L7:
                long r0 = io.reactivex.internal.util.BackpressureHelper.add(r8, r9)
                r2 = 0
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 == 0) goto L12
                goto L55
            L12:
                S r0 = r8.state
                io.reactivex.functions.BiFunction<S, ? super io.reactivex.Emitter<T>, S> r1 = r8.generator
            L16:
                r4 = r2
            L17:
                int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
                if (r6 == 0) goto L42
                boolean r6 = r8.cancelled
                if (r6 == 0) goto L23
                r8.dispose(r0)
                return
            L23:
                r6 = 1
                java.lang.Object r0 = r1.apply(r0, r8)     // Catch: java.lang.Throwable -> L36
                boolean r7 = r8.terminate
                if (r7 == 0) goto L32
                r8.cancelled = r6
                r8.dispose(r0)
                return
            L32:
                r6 = 1
                long r4 = r4 + r6
                goto L17
            L36:
                r9 = move-exception
                io.reactivex.exceptions.Exceptions.throwIfFatal(r9)
                r8.cancelled = r6
                org.reactivestreams.Subscriber<? super T> r10 = r8.actual
                r10.onError(r9)
                return
            L42:
                long r9 = r8.get()
                int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
                if (r6 != 0) goto L17
                r8.state = r0
                long r9 = -r4
                long r9 = r8.addAndGet(r9)
                int r4 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
                if (r4 != 0) goto L16
            L55:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableGenerate.GeneratorSubscription.request(long):void");
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            subscriber.onSubscribe(new GeneratorSubscription(subscriber, this.generator, this.disposeState, this.stateSupplier.call()));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }

    public FlowableGenerate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction, Consumer<? super S> consumer) {
        this.stateSupplier = callable;
        this.generator = biFunction;
        this.disposeState = consumer;
    }
}
