package io.reactivex.internal.operators.flowable;

import androidx.camera.view.p;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableFlatMap<T, U> extends AbstractFlowableWithUpstream<T, U> {
    final int bufferSize;
    final boolean delayErrors;
    final Function<? super T, ? extends Publisher<? extends U>> mapper;
    final int maxConcurrency;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class InnerSubscriber<T, U> extends AtomicReference<Subscription> implements Subscriber<U>, Disposable {
        private static final long serialVersionUID = -4606175640614850599L;
        final int bufferSize;
        volatile boolean done;
        int fusionMode;
        final long id;
        final int limit;
        final MergeSubscriber<T, U> parent;
        long produced;
        volatile SimpleQueue<U> queue;

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.parent.errs.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else {
                this.done = true;
                this.parent.drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(U u5) {
            if (this.fusionMode != 2) {
                this.parent.tryEmit(u5, this);
            } else {
                this.parent.drain();
            }
        }

        void requestMore(long j6) {
            if (this.fusionMode != 1) {
                long j7 = this.produced + j6;
                if (j7 < this.limit) {
                    this.produced = j7;
                } else {
                    this.produced = 0L;
                    get().request(j7);
                }
            }
        }

        InnerSubscriber(MergeSubscriber<T, U> mergeSubscriber, long j6) {
            this.id = j6;
            this.parent = mergeSubscriber;
            int i6 = mergeSubscriber.bufferSize;
            this.bufferSize = i6;
            this.limit = i6 >> 2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() == SubscriptionHelper.CANCELLED) {
                return true;
            }
            return false;
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.parent.drain();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = queueSubscription;
                    }
                }
                subscription.request(this.bufferSize);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class MergeSubscriber<T, U> extends AtomicInteger implements Subscription, Subscriber<T> {
        private static final long serialVersionUID = -2117620485640801370L;
        final Subscriber<? super U> actual;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final AtomicThrowable errs = new AtomicThrowable();
        long lastId;
        int lastIndex;
        final Function<? super T, ? extends Publisher<? extends U>> mapper;
        final int maxConcurrency;
        volatile SimplePlainQueue<U> queue;
        final AtomicLong requested;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43176s;
        int scalarEmitted;
        final int scalarLimit;
        final AtomicReference<InnerSubscriber<?, ?>[]> subscribers;
        long uniqueId;
        static final InnerSubscriber<?, ?>[] EMPTY = new InnerSubscriber[0];
        static final InnerSubscriber<?, ?>[] CANCELLED = new InnerSubscriber[0];

        void addInner(InnerSubscriber<T, U> innerSubscriber) {
            InnerSubscriber<?, ?>[] innerSubscriberArr;
            InnerSubscriber[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.subscribers.get();
                if (innerSubscriberArr == CANCELLED) {
                    innerSubscriber.dispose();
                    return;
                }
                int length = innerSubscriberArr.length;
                innerSubscriberArr2 = new InnerSubscriber[length + 1];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                innerSubscriberArr2[length] = innerSubscriber;
            } while (!p.a(this.subscribers, innerSubscriberArr, innerSubscriberArr2));
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SimplePlainQueue<U> simplePlainQueue;
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f43176s.cancel();
            disposeAll();
            if (getAndIncrement() != 0 || (simplePlainQueue = this.queue) == null) {
                return;
            }
            simplePlainQueue.clear();
        }

        boolean checkTerminate() {
            if (this.cancelled) {
                SimplePlainQueue<U> simplePlainQueue = this.queue;
                if (simplePlainQueue != null) {
                    simplePlainQueue.clear();
                }
                return true;
            }
            if (this.delayErrors || this.errs.get() == null) {
                return false;
            }
            this.actual.onError(this.errs.terminate());
            return true;
        }

        void disposeAll() {
            InnerSubscriber<?, ?>[] andSet;
            InnerSubscriber<?, ?>[] innerSubscriberArr = this.subscribers.get();
            InnerSubscriber<?, ?>[] innerSubscriberArr2 = CANCELLED;
            if (innerSubscriberArr == innerSubscriberArr2 || (andSet = this.subscribers.getAndSet(innerSubscriberArr2)) == innerSubscriberArr2) {
                return;
            }
            for (InnerSubscriber<?, ?> innerSubscriber : andSet) {
                innerSubscriber.dispose();
            }
            Throwable terminate = this.errs.terminate();
            if (terminate == null || terminate == ExceptionHelper.TERMINATED) {
                return;
            }
            RxJavaPlugins.onError(terminate);
        }

        /* JADX WARN: Code restructure failed: missing block: B:100:0x017a, code lost:
        
            r24.lastIndex = r3;
            r24.lastId = r7[r3].id;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00b0, code lost:
        
            if (r7[r0].id != r9) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:99:0x016a, code lost:
        
            r9 = r0;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drainLoop() {
            /*
                Method dump skipped, instructions count: 418
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFlatMap.MergeSubscriber.drainLoop():void");
        }

        SimpleQueue<U> getInnerQueue(InnerSubscriber<T, U> innerSubscriber) {
            SimpleQueue<U> simpleQueue = innerSubscriber.queue;
            if (simpleQueue != null) {
                return simpleQueue;
            }
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.bufferSize);
            innerSubscriber.queue = spscArrayQueue;
            return spscArrayQueue;
        }

        SimpleQueue<U> getMainQueue() {
            SimplePlainQueue<U> simplePlainQueue = this.queue;
            if (simplePlainQueue == null) {
                simplePlainQueue = this.maxConcurrency == Integer.MAX_VALUE ? new SpscLinkedArrayQueue<>(this.bufferSize) : new SpscArrayQueue<>(this.maxConcurrency);
                this.queue = simplePlainQueue;
            }
            return simplePlainQueue;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
            } else if (!this.errs.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else {
                this.done = true;
                drain();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (this.done) {
                return;
            }
            try {
                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.mapper.apply(t5), "The mapper returned a null Publisher");
                if (!(publisher instanceof Callable)) {
                    long j6 = this.uniqueId;
                    this.uniqueId = 1 + j6;
                    InnerSubscriber innerSubscriber = new InnerSubscriber(this, j6);
                    addInner(innerSubscriber);
                    publisher.subscribe(innerSubscriber);
                    return;
                }
                try {
                    Object call = ((Callable) publisher).call();
                    if (call != null) {
                        tryEmitScalar(call);
                        return;
                    }
                    if (this.maxConcurrency == Integer.MAX_VALUE || this.cancelled) {
                        return;
                    }
                    int i6 = this.scalarEmitted + 1;
                    this.scalarEmitted = i6;
                    int i7 = this.scalarLimit;
                    if (i6 == i7) {
                        this.scalarEmitted = 0;
                        this.f43176s.request(i7);
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.errs.addThrowable(th);
                    drain();
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f43176s.cancel();
                onError(th2);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43176s, subscription)) {
                this.f43176s = subscription;
                this.actual.onSubscribe(this);
                if (this.cancelled) {
                    return;
                }
                int i6 = this.maxConcurrency;
                if (i6 == Integer.MAX_VALUE) {
                    subscription.request(Long.MAX_VALUE);
                } else {
                    subscription.request(i6);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void removeInner(InnerSubscriber<T, U> innerSubscriber) {
            InnerSubscriber<?, ?>[] innerSubscriberArr;
            InnerSubscriber<?, ?>[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.subscribers.get();
                if (innerSubscriberArr == CANCELLED || innerSubscriberArr == EMPTY) {
                    return;
                }
                int length = innerSubscriberArr.length;
                int i6 = 0;
                while (true) {
                    if (i6 >= length) {
                        i6 = -1;
                        break;
                    } else if (innerSubscriberArr[i6] == innerSubscriber) {
                        break;
                    } else {
                        i6++;
                    }
                }
                if (i6 < 0) {
                    return;
                }
                if (length == 1) {
                    innerSubscriberArr2 = EMPTY;
                } else {
                    InnerSubscriber<?, ?>[] innerSubscriberArr3 = new InnerSubscriber[length - 1];
                    System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr3, 0, i6);
                    System.arraycopy(innerSubscriberArr, i6 + 1, innerSubscriberArr3, i6, (length - i6) - 1);
                    innerSubscriberArr2 = innerSubscriberArr3;
                }
            } while (!p.a(this.subscribers, innerSubscriberArr, innerSubscriberArr2));
        }

        MergeSubscriber(Subscriber<? super U> subscriber, Function<? super T, ? extends Publisher<? extends U>> function, boolean z5, int i6, int i7) {
            AtomicReference<InnerSubscriber<?, ?>[]> atomicReference = new AtomicReference<>();
            this.subscribers = atomicReference;
            this.requested = new AtomicLong();
            this.actual = subscriber;
            this.mapper = function;
            this.delayErrors = z5;
            this.maxConcurrency = i6;
            this.bufferSize = i7;
            this.scalarLimit = Math.max(1, i6 >> 1);
            atomicReference.lazySet(EMPTY);
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            if (SubscriptionHelper.validate(j6)) {
                BackpressureHelper.add(this.requested, j6);
                drain();
            }
        }

        void tryEmit(U u5, InnerSubscriber<T, U> innerSubscriber) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j6 = this.requested.get();
                SimpleQueue<U> simpleQueue = innerSubscriber.queue;
                if (j6 != 0 && (simpleQueue == null || simpleQueue.isEmpty())) {
                    this.actual.onNext(u5);
                    if (j6 != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    innerSubscriber.requestMore(1L);
                } else {
                    if (simpleQueue == null) {
                        simpleQueue = getInnerQueue(innerSubscriber);
                    }
                    if (!simpleQueue.offer(u5)) {
                        onError(new MissingBackpressureException("Inner queue full?!"));
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                SimpleQueue simpleQueue2 = innerSubscriber.queue;
                if (simpleQueue2 == null) {
                    simpleQueue2 = new SpscArrayQueue(this.bufferSize);
                    innerSubscriber.queue = simpleQueue2;
                }
                if (!simpleQueue2.offer(u5)) {
                    onError(new MissingBackpressureException("Inner queue full?!"));
                    return;
                } else if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        void tryEmitScalar(U u5) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j6 = this.requested.get();
                SimpleQueue<U> simpleQueue = this.queue;
                if (j6 != 0 && (simpleQueue == null || simpleQueue.isEmpty())) {
                    this.actual.onNext(u5);
                    if (j6 != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    if (this.maxConcurrency != Integer.MAX_VALUE && !this.cancelled) {
                        int i6 = this.scalarEmitted + 1;
                        this.scalarEmitted = i6;
                        int i7 = this.scalarLimit;
                        if (i6 == i7) {
                            this.scalarEmitted = 0;
                            this.f43176s.request(i7);
                        }
                    }
                } else {
                    if (simpleQueue == null) {
                        simpleQueue = getMainQueue();
                    }
                    if (!simpleQueue.offer(u5)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!getMainQueue().offer(u5)) {
                onError(new IllegalStateException("Scalar queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super U> subscriber) {
        if (FlowableScalarXMap.tryScalarXMapSubscribe(this.source, subscriber, this.mapper)) {
            return;
        }
        this.source.subscribe(new MergeSubscriber(subscriber, this.mapper, this.delayErrors, this.maxConcurrency, this.bufferSize));
    }

    public FlowableFlatMap(Publisher<T> publisher, Function<? super T, ? extends Publisher<? extends U>> function, boolean z5, int i6, int i7) {
        super(publisher);
        this.mapper = function;
        this.delayErrors = z5;
        this.maxConcurrency = i6;
        this.bufferSize = i7;
    }
}
