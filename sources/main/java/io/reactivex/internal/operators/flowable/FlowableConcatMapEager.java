package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscribers.InnerQueuedSubscriber;
import io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableConcatMapEager<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final int maxConcurrency;
    final int prefetch;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ConcatMapEagerDelayErrorSubscriber<T, R> extends AtomicInteger implements Subscriber<T>, Subscription, InnerQueuedSubscriberSupport<R> {
        private static final long serialVersionUID = -4255299542215038287L;
        final Subscriber<? super R> actual;
        volatile boolean cancelled;
        volatile InnerQueuedSubscriber<R> current;
        volatile boolean done;
        final ErrorMode errorMode;
        final Function<? super T, ? extends Publisher<? extends R>> mapper;
        final int maxConcurrency;
        final int prefetch;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43161s;
        final SpscLinkedArrayQueue<InnerQueuedSubscriber<R>> subscribers;
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicLong requested = new AtomicLong();

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f43161s.cancel();
            drainAndCancel();
        }

        void cancelAll() {
            while (true) {
                InnerQueuedSubscriber<R> poll = this.subscribers.poll();
                if (poll == null) {
                    return;
                } else {
                    poll.cancel();
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:50:0x00cc, code lost:
        
            if (r12 != r6) goto L74;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00d0, code lost:
        
            if (r19.cancelled == false) goto L63;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00d8, code lost:
        
            if (r3 != io.reactivex.internal.util.ErrorMode.IMMEDIATE) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00e2, code lost:
        
            if (r19.errors.get() == null) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00e4, code lost:
        
            r19.current = null;
            r8.cancel();
            cancelAll();
            r2.onError(r19.errors.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00f5, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00f6, code lost:
        
            r9 = r8.isDone();
            r10 = r11.isEmpty();
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00fe, code lost:
        
            if (r9 == false) goto L74;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x0100, code lost:
        
            if (r10 == false) goto L74;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x0102, code lost:
        
            r19.current = null;
            r19.f43161s.request(1);
            r8 = null;
            r0 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00d2, code lost:
        
            cancelAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x00d5, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x00cb, code lost:
        
            r0 = false;
         */
        @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void drain() {
            /*
                Method dump skipped, instructions count: 305
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableConcatMapEager.ConcatMapEagerDelayErrorSubscriber.drain():void");
        }

        @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
        public void innerError(InnerQueuedSubscriber<R> innerQueuedSubscriber, Throwable th) {
            if (!this.errors.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            innerQueuedSubscriber.setDone();
            if (this.errorMode != ErrorMode.END) {
                this.f43161s.cancel();
            }
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else {
                this.done = true;
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            try {
                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.mapper.apply(t5), "The mapper returned a null Publisher");
                InnerQueuedSubscriber<R> innerQueuedSubscriber = new InnerQueuedSubscriber<>(this, this.prefetch);
                if (this.cancelled) {
                    return;
                }
                this.subscribers.offer(innerQueuedSubscriber);
                if (this.cancelled) {
                    return;
                }
                publisher.subscribe(innerQueuedSubscriber);
                if (this.cancelled) {
                    innerQueuedSubscriber.cancel();
                    drainAndCancel();
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.f43161s.cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43161s, subscription)) {
                this.f43161s = subscription;
                this.actual.onSubscribe(this);
                int i6 = this.maxConcurrency;
                subscription.request(i6 == Integer.MAX_VALUE ? Long.MAX_VALUE : i6);
            }
        }

        ConcatMapEagerDelayErrorSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i6, int i7, ErrorMode errorMode) {
            this.actual = subscriber;
            this.mapper = function;
            this.maxConcurrency = i6;
            this.prefetch = i7;
            this.errorMode = errorMode;
            this.subscribers = new SpscLinkedArrayQueue<>(Math.min(i7, i6));
        }

        void drainAndCancel() {
            if (getAndIncrement() == 0) {
                do {
                    cancelAll();
                } while (decrementAndGet() != 0);
            }
        }

        @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
        public void innerComplete(InnerQueuedSubscriber<R> innerQueuedSubscriber) {
            innerQueuedSubscriber.setDone();
            drain();
        }

        @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
        public void innerNext(InnerQueuedSubscriber<R> innerQueuedSubscriber, R r5) {
            if (innerQueuedSubscriber.queue().offer(r5)) {
                drain();
            } else {
                innerQueuedSubscriber.cancel();
                innerError(innerQueuedSubscriber, new MissingBackpressureException());
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            if (SubscriptionHelper.validate(j6)) {
                BackpressureHelper.add(this.requested, j6);
                drain();
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super R> subscriber) {
        this.source.subscribe(new ConcatMapEagerDelayErrorSubscriber(subscriber, this.mapper, this.maxConcurrency, this.prefetch, this.errorMode));
    }

    public FlowableConcatMapEager(Publisher<T> publisher, Function<? super T, ? extends Publisher<? extends R>> function, int i6, int i7, ErrorMode errorMode) {
        super(publisher);
        this.mapper = function;
        this.maxConcurrency = i6;
        this.prefetch = i7;
        this.errorMode = errorMode;
    }
}
