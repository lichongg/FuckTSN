package io.reactivex.internal.operators.flowable;

import io.reactivex.Scheduler;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableObserveOn<T> extends AbstractFlowableWithUpstream<T, T> {
    final boolean delayError;
    final int prefetch;
    final Scheduler scheduler;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static abstract class BaseObserveOnSubscriber<T> extends BasicIntQueueSubscription<T> implements Runnable, Subscriber<T> {
        private static final long serialVersionUID = -8241002408341274697L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final int limit;
        boolean outputFused;
        final int prefetch;
        long produced;
        SimpleQueue<T> queue;
        final AtomicLong requested = new AtomicLong();

        /* renamed from: s, reason: collision with root package name */
        Subscription f43191s;
        int sourceMode;
        final Scheduler.Worker worker;

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i6) {
            if ((i6 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        abstract void runAsync();

        abstract void runBackfused();

        abstract void runSync();

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f43191s.cancel();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        final boolean checkTerminated(boolean z5, boolean z6, Subscriber<?> subscriber) {
            if (this.cancelled) {
                clear();
                return true;
            }
            if (!z5) {
                return false;
            }
            if (this.delayError) {
                if (!z6) {
                    return false;
                }
                Throwable th = this.error;
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                this.worker.dispose();
                return true;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                clear();
                subscriber.onError(th2);
                this.worker.dispose();
                return true;
            }
            if (!z6) {
                return false;
            }
            subscriber.onComplete();
            this.worker.dispose();
            return true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.queue.clear();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            trySchedule();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.error = th;
            this.done = true;
            trySchedule();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t5) {
            if (this.done) {
                return;
            }
            if (this.sourceMode == 2) {
                trySchedule();
                return;
            }
            if (!this.queue.offer(t5)) {
                this.f43191s.cancel();
                this.error = new MissingBackpressureException("Queue is full?!");
                this.done = true;
            }
            trySchedule();
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.outputFused) {
                runBackfused();
            } else if (this.sourceMode == 1) {
                runSync();
            } else {
                runAsync();
            }
        }

        BaseObserveOnSubscriber(Scheduler.Worker worker, boolean z5, int i6) {
            this.worker = worker;
            this.delayError = z5;
            this.prefetch = i6;
            this.limit = i6 - (i6 >> 2);
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j6) {
            if (SubscriptionHelper.validate(j6)) {
                BackpressureHelper.add(this.requested, j6);
                trySchedule();
            }
        }

        final void trySchedule() {
            if (getAndIncrement() != 0) {
                return;
            }
            this.worker.schedule(this);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ObserveOnConditionalSubscriber<T> extends BaseObserveOnSubscriber<T> {
        private static final long serialVersionUID = 644624475404284533L;
        final ConditionalSubscriber<? super T> actual;
        long consumed;

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runBackfused() {
            int i6 = 1;
            while (!this.cancelled) {
                boolean z5 = this.done;
                this.actual.onNext(null);
                if (z5) {
                    Throwable th = this.error;
                    if (th != null) {
                        this.actual.onError(th);
                    } else {
                        this.actual.onComplete();
                    }
                    this.worker.dispose();
                    return;
                }
                i6 = addAndGet(-i6);
                if (i6 == 0) {
                    return;
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43191s, subscription)) {
                this.f43191s = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = 1;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        return;
                    }
                    if (requestFusion == 2) {
                        this.sourceMode = 2;
                        this.queue = queueSubscription;
                        this.actual.onSubscribe(this);
                        subscription.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                this.actual.onSubscribe(this);
                subscription.request(this.prefetch);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            T poll = this.queue.poll();
            if (poll != null && this.sourceMode != 1) {
                long j6 = this.consumed + 1;
                if (j6 == this.limit) {
                    this.consumed = 0L;
                    this.f43191s.request(j6);
                    return poll;
                }
                this.consumed = j6;
            }
            return poll;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runAsync() {
            ConditionalSubscriber<? super T> conditionalSubscriber = this.actual;
            SimpleQueue<T> simpleQueue = this.queue;
            long j6 = this.produced;
            long j7 = this.consumed;
            int i6 = 1;
            while (true) {
                long j8 = this.requested.get();
                while (j6 != j8) {
                    boolean z5 = this.done;
                    try {
                        T poll = simpleQueue.poll();
                        boolean z6 = poll == null;
                        if (checkTerminated(z5, z6, conditionalSubscriber)) {
                            return;
                        }
                        if (z6) {
                            break;
                        }
                        if (conditionalSubscriber.tryOnNext(poll)) {
                            j6++;
                        }
                        j7++;
                        if (j7 == this.limit) {
                            this.f43191s.request(j7);
                            j7 = 0;
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.f43191s.cancel();
                        simpleQueue.clear();
                        conditionalSubscriber.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (j6 == j8 && checkTerminated(this.done, simpleQueue.isEmpty(), conditionalSubscriber)) {
                    return;
                }
                int i7 = get();
                if (i6 == i7) {
                    this.produced = j6;
                    this.consumed = j7;
                    i6 = addAndGet(-i6);
                    if (i6 == 0) {
                        return;
                    }
                } else {
                    i6 = i7;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runSync() {
            ConditionalSubscriber<? super T> conditionalSubscriber = this.actual;
            SimpleQueue<T> simpleQueue = this.queue;
            long j6 = this.produced;
            int i6 = 1;
            while (true) {
                long j7 = this.requested.get();
                while (j6 != j7) {
                    try {
                        T poll = simpleQueue.poll();
                        if (this.cancelled) {
                            return;
                        }
                        if (poll == null) {
                            conditionalSubscriber.onComplete();
                            this.worker.dispose();
                            return;
                        } else if (conditionalSubscriber.tryOnNext(poll)) {
                            j6++;
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.f43191s.cancel();
                        conditionalSubscriber.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (this.cancelled) {
                    return;
                }
                if (simpleQueue.isEmpty()) {
                    conditionalSubscriber.onComplete();
                    this.worker.dispose();
                    return;
                }
                int i7 = get();
                if (i6 == i7) {
                    this.produced = j6;
                    i6 = addAndGet(-i6);
                    if (i6 == 0) {
                        return;
                    }
                } else {
                    i6 = i7;
                }
            }
        }

        ObserveOnConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Scheduler.Worker worker, boolean z5, int i6) {
            super(worker, z5, i6);
            this.actual = conditionalSubscriber;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ObserveOnSubscriber<T> extends BaseObserveOnSubscriber<T> implements Subscriber<T> {
        private static final long serialVersionUID = -4547113800637756442L;
        final Subscriber<? super T> actual;

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runBackfused() {
            int i6 = 1;
            while (!this.cancelled) {
                boolean z5 = this.done;
                this.actual.onNext(null);
                if (z5) {
                    Throwable th = this.error;
                    if (th != null) {
                        this.actual.onError(th);
                    } else {
                        this.actual.onComplete();
                    }
                    this.worker.dispose();
                    return;
                }
                i6 = addAndGet(-i6);
                if (i6 == 0) {
                    return;
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43191s, subscription)) {
                this.f43191s = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = 1;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        return;
                    }
                    if (requestFusion == 2) {
                        this.sourceMode = 2;
                        this.queue = queueSubscription;
                        this.actual.onSubscribe(this);
                        subscription.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                this.actual.onSubscribe(this);
                subscription.request(this.prefetch);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            T poll = this.queue.poll();
            if (poll != null && this.sourceMode != 1) {
                long j6 = this.produced + 1;
                if (j6 == this.limit) {
                    this.produced = 0L;
                    this.f43191s.request(j6);
                    return poll;
                }
                this.produced = j6;
            }
            return poll;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runAsync() {
            Subscriber<? super T> subscriber = this.actual;
            SimpleQueue<T> simpleQueue = this.queue;
            long j6 = this.produced;
            int i6 = 1;
            while (true) {
                long j7 = this.requested.get();
                while (j6 != j7) {
                    boolean z5 = this.done;
                    try {
                        T poll = simpleQueue.poll();
                        boolean z6 = poll == null;
                        if (checkTerminated(z5, z6, subscriber)) {
                            return;
                        }
                        if (z6) {
                            break;
                        }
                        subscriber.onNext(poll);
                        j6++;
                        if (j6 == this.limit) {
                            if (j7 != Long.MAX_VALUE) {
                                j7 = this.requested.addAndGet(-j6);
                            }
                            this.f43191s.request(j6);
                            j6 = 0;
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.f43191s.cancel();
                        simpleQueue.clear();
                        subscriber.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (j6 == j7 && checkTerminated(this.done, simpleQueue.isEmpty(), subscriber)) {
                    return;
                }
                int i7 = get();
                if (i6 == i7) {
                    this.produced = j6;
                    i6 = addAndGet(-i6);
                    if (i6 == 0) {
                        return;
                    }
                } else {
                    i6 = i7;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runSync() {
            Subscriber<? super T> subscriber = this.actual;
            SimpleQueue<T> simpleQueue = this.queue;
            long j6 = this.produced;
            int i6 = 1;
            while (true) {
                long j7 = this.requested.get();
                while (j6 != j7) {
                    try {
                        T poll = simpleQueue.poll();
                        if (this.cancelled) {
                            return;
                        }
                        if (poll == null) {
                            subscriber.onComplete();
                            this.worker.dispose();
                            return;
                        } else {
                            subscriber.onNext(poll);
                            j6++;
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.f43191s.cancel();
                        subscriber.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (this.cancelled) {
                    return;
                }
                if (simpleQueue.isEmpty()) {
                    subscriber.onComplete();
                    this.worker.dispose();
                    return;
                }
                int i7 = get();
                if (i6 == i7) {
                    this.produced = j6;
                    i6 = addAndGet(-i6);
                    if (i6 == 0) {
                        return;
                    }
                } else {
                    i6 = i7;
                }
            }
        }

        ObserveOnSubscriber(Subscriber<? super T> subscriber, Scheduler.Worker worker, boolean z5, int i6) {
            super(worker, z5, i6);
            this.actual = subscriber;
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        if (subscriber instanceof ConditionalSubscriber) {
            this.source.subscribe(new ObserveOnConditionalSubscriber((ConditionalSubscriber) subscriber, createWorker, this.delayError, this.prefetch));
        } else {
            this.source.subscribe(new ObserveOnSubscriber(subscriber, createWorker, this.delayError, this.prefetch));
        }
    }

    public FlowableObserveOn(Publisher<T> publisher, Scheduler scheduler, boolean z5, int i6) {
        super(publisher);
        this.scheduler = scheduler;
        this.delayError = z5;
        this.prefetch = i6;
    }
}
