package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableWindowTimed<T> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final int bufferSize;
    final long maxSize;
    final boolean restartTimerOnMaxSize;
    final Scheduler scheduler;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class WindowExactBoundedSubscriber<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription {
        final int bufferSize;
        long count;
        final long maxSize;
        long producerIndex;
        final boolean restartTimerOnMaxSize;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43244s;
        final Scheduler scheduler;
        volatile boolean terminated;
        final SequentialDisposable timer;
        final long timespan;
        final TimeUnit unit;
        UnicastProcessor<T> window;
        Scheduler.Worker worker;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static final class ConsumerIndexHolder implements Runnable {
            final long index;
            final WindowExactBoundedSubscriber<?> parent;

            @Override // java.lang.Runnable
            public void run() {
                WindowExactBoundedSubscriber<?> windowExactBoundedSubscriber = this.parent;
                if (((QueueDrainSubscriber) windowExactBoundedSubscriber).cancelled) {
                    windowExactBoundedSubscriber.terminated = true;
                    windowExactBoundedSubscriber.dispose();
                } else {
                    ((QueueDrainSubscriber) windowExactBoundedSubscriber).queue.offer(this);
                }
                if (windowExactBoundedSubscriber.enter()) {
                    windowExactBoundedSubscriber.drainLoop();
                }
            }

            ConsumerIndexHolder(long j6, WindowExactBoundedSubscriber<?> windowExactBoundedSubscriber) {
                this.index = j6;
                this.parent = windowExactBoundedSubscriber;
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            dispose();
            this.actual.onComplete();
        }

        WindowExactBoundedSubscriber(Subscriber<? super Flowable<T>> subscriber, long j6, TimeUnit timeUnit, Scheduler scheduler, int i6, long j7, boolean z5) {
            super(subscriber, new MpscLinkedQueue());
            this.timer = new SequentialDisposable();
            this.timespan = j6;
            this.unit = timeUnit;
            this.scheduler = scheduler;
            this.bufferSize = i6;
            this.maxSize = j7;
            this.restartTimerOnMaxSize = z5;
        }

        public void dispose() {
            DisposableHelper.dispose(this.timer);
        }

        /* JADX WARN: Multi-variable type inference failed */
        void drainLoop() {
            SimpleQueue simpleQueue = this.queue;
            Subscriber<? super V> subscriber = this.actual;
            UnicastProcessor<T> unicastProcessor = this.window;
            int i6 = 1;
            while (!this.terminated) {
                boolean z5 = this.done;
                Object poll = simpleQueue.poll();
                boolean z6 = poll == null;
                boolean z7 = poll instanceof ConsumerIndexHolder;
                if (z5 && (z6 || z7)) {
                    this.window = null;
                    simpleQueue.clear();
                    dispose();
                    Throwable th = this.error;
                    if (th != null) {
                        ((UnicastProcessor) unicastProcessor).onError(th);
                        return;
                    } else {
                        ((UnicastProcessor) unicastProcessor).onComplete();
                        return;
                    }
                }
                if (z6) {
                    i6 = leave(-i6);
                    if (i6 == 0) {
                        return;
                    }
                } else {
                    int i7 = i6;
                    if (z7) {
                        unicastProcessor = unicastProcessor;
                        if (this.producerIndex == ((ConsumerIndexHolder) poll).index) {
                            UnicastProcessor<T> create = UnicastProcessor.create(this.bufferSize);
                            this.window = create;
                            long requested = requested();
                            if (requested == 0) {
                                this.window = null;
                                this.queue.clear();
                                this.f43244s.cancel();
                                dispose();
                                subscriber.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
                                return;
                            }
                            subscriber.onNext(create);
                            unicastProcessor = create;
                            if (requested != Long.MAX_VALUE) {
                                produced(1L);
                                unicastProcessor = create;
                            }
                        }
                    } else {
                        ((UnicastProcessor) unicastProcessor).onNext(NotificationLite.getValue(poll));
                        long j6 = this.count + 1;
                        if (j6 >= this.maxSize) {
                            this.producerIndex++;
                            this.count = 0L;
                            ((UnicastProcessor) unicastProcessor).onComplete();
                            long requested2 = requested();
                            if (requested2 == 0) {
                                this.window = null;
                                this.f43244s.cancel();
                                dispose();
                                this.actual.onError(new MissingBackpressureException("Could not deliver window due to lack of requests"));
                                return;
                            }
                            UnicastProcessor<T> create2 = UnicastProcessor.create(this.bufferSize);
                            this.window = create2;
                            this.actual.onNext(create2);
                            if (requested2 != Long.MAX_VALUE) {
                                produced(1L);
                            }
                            unicastProcessor = create2;
                            if (this.restartTimerOnMaxSize) {
                                Disposable disposable = this.timer.get();
                                disposable.dispose();
                                Scheduler.Worker worker = this.worker;
                                ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.producerIndex, this);
                                long j7 = this.timespan;
                                Disposable schedulePeriodically = worker.schedulePeriodically(consumerIndexHolder, j7, j7, this.unit);
                                unicastProcessor = create2;
                                if (!this.timer.compareAndSet(disposable, schedulePeriodically)) {
                                    schedulePeriodically.dispose();
                                    unicastProcessor = create2;
                                }
                            }
                        } else {
                            this.count = j6;
                            unicastProcessor = unicastProcessor;
                        }
                    }
                    i6 = i7;
                }
            }
            this.f43244s.cancel();
            simpleQueue.clear();
            dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            dispose();
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (this.terminated) {
                return;
            }
            if (fastEnter()) {
                UnicastProcessor<T> unicastProcessor = this.window;
                unicastProcessor.onNext(t5);
                long j6 = this.count + 1;
                if (j6 >= this.maxSize) {
                    this.producerIndex++;
                    this.count = 0L;
                    unicastProcessor.onComplete();
                    long requested = requested();
                    if (requested == 0) {
                        this.window = null;
                        this.f43244s.cancel();
                        dispose();
                        this.actual.onError(new MissingBackpressureException("Could not deliver window due to lack of requests"));
                        return;
                    }
                    UnicastProcessor<T> create = UnicastProcessor.create(this.bufferSize);
                    this.window = create;
                    this.actual.onNext(create);
                    if (requested != Long.MAX_VALUE) {
                        produced(1L);
                    }
                    if (this.restartTimerOnMaxSize) {
                        Disposable disposable = this.timer.get();
                        disposable.dispose();
                        Scheduler.Worker worker = this.worker;
                        ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.producerIndex, this);
                        long j7 = this.timespan;
                        Disposable schedulePeriodically = worker.schedulePeriodically(consumerIndexHolder, j7, j7, this.unit);
                        if (!this.timer.compareAndSet(disposable, schedulePeriodically)) {
                            schedulePeriodically.dispose();
                        }
                    }
                } else {
                    this.count = j6;
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.queue.offer(NotificationLite.next(t5));
                if (!enter()) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Disposable disposable;
            if (SubscriptionHelper.validate(this.f43244s, subscription)) {
                this.f43244s = subscription;
                Subscriber<? super V> subscriber = this.actual;
                subscriber.onSubscribe(this);
                if (this.cancelled) {
                    return;
                }
                UnicastProcessor<T> create = UnicastProcessor.create(this.bufferSize);
                this.window = create;
                long requested = requested();
                if (requested == 0) {
                    this.cancelled = true;
                    subscription.cancel();
                    subscriber.onError(new MissingBackpressureException("Could not deliver initial window due to lack of requests."));
                    return;
                }
                subscriber.onNext(create);
                if (requested != Long.MAX_VALUE) {
                    produced(1L);
                }
                ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.producerIndex, this);
                if (this.restartTimerOnMaxSize) {
                    Scheduler.Worker createWorker = this.scheduler.createWorker();
                    this.worker = createWorker;
                    long j6 = this.timespan;
                    createWorker.schedulePeriodically(consumerIndexHolder, j6, j6, this.unit);
                    disposable = createWorker;
                } else {
                    Scheduler scheduler = this.scheduler;
                    long j7 = this.timespan;
                    disposable = scheduler.schedulePeriodicallyDirect(consumerIndexHolder, j7, j7, this.unit);
                }
                if (this.timer.replace(disposable)) {
                    subscription.request(Long.MAX_VALUE);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            requested(j6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class WindowExactUnboundedSubscriber<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscriber<T>, Subscription, Runnable {
        static final Object NEXT = new Object();
        final int bufferSize;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43245s;
        final Scheduler scheduler;
        volatile boolean terminated;
        final SequentialDisposable timer;
        final long timespan;
        final TimeUnit unit;
        UnicastProcessor<T> window;

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            dispose();
            this.actual.onComplete();
        }

        WindowExactUnboundedSubscriber(Subscriber<? super Flowable<T>> subscriber, long j6, TimeUnit timeUnit, Scheduler scheduler, int i6) {
            super(subscriber, new MpscLinkedQueue());
            this.timer = new SequentialDisposable();
            this.timespan = j6;
            this.unit = timeUnit;
            this.scheduler = scheduler;
            this.bufferSize = i6;
        }

        public void dispose() {
            DisposableHelper.dispose(this.timer);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0024, code lost:
        
            r2.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0028, code lost:
        
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
        
            r10.window = null;
            r0.clear();
            dispose();
            r0 = r10.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
        
            if (r0 == null) goto L12;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [io.reactivex.processors.UnicastProcessor<T>] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drainLoop() {
            /*
                r10 = this;
                io.reactivex.internal.fuseable.SimplePlainQueue<U> r0 = r10.queue
                org.reactivestreams.Subscriber<? super V> r1 = r10.actual
                io.reactivex.processors.UnicastProcessor<T> r2 = r10.window
                r3 = 1
            L7:
                boolean r4 = r10.terminated
                boolean r5 = r10.done
                java.lang.Object r6 = r0.poll()
                r7 = 0
                if (r5 == 0) goto L2c
                if (r6 == 0) goto L18
                java.lang.Object r5 = io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowExactUnboundedSubscriber.NEXT
                if (r6 != r5) goto L2c
            L18:
                r10.window = r7
                r0.clear()
                r10.dispose()
                java.lang.Throwable r0 = r10.error
                if (r0 == 0) goto L28
                r2.onError(r0)
                return
            L28:
                r2.onComplete()
                return
            L2c:
                if (r6 != 0) goto L36
                int r3 = -r3
                int r3 = r10.leave(r3)
                if (r3 != 0) goto L7
                return
            L36:
                java.lang.Object r5 = io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowExactUnboundedSubscriber.NEXT
                if (r6 != r5) goto L83
                r2.onComplete()
                if (r4 != 0) goto L7d
                int r2 = r10.bufferSize
                io.reactivex.processors.UnicastProcessor r2 = io.reactivex.processors.UnicastProcessor.create(r2)
                r10.window = r2
                long r4 = r10.requested()
                r8 = 0
                int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
                if (r6 == 0) goto L63
                r1.onNext(r2)
                r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r8 == 0) goto L7
                r4 = 1
                r10.produced(r4)
                goto L7
            L63:
                r10.window = r7
                io.reactivex.internal.fuseable.SimplePlainQueue<U> r0 = r10.queue
                r0.clear()
                org.reactivestreams.Subscription r0 = r10.f43245s
                r0.cancel()
                r10.dispose()
                io.reactivex.exceptions.MissingBackpressureException r0 = new io.reactivex.exceptions.MissingBackpressureException
                java.lang.String r2 = "Could not deliver first window due to lack of requests."
                r0.<init>(r2)
                r1.onError(r0)
                return
            L7d:
                org.reactivestreams.Subscription r4 = r10.f43245s
                r4.cancel()
                goto L7
            L83:
                java.lang.Object r4 = io.reactivex.internal.util.NotificationLite.getValue(r6)
                r2.onNext(r4)
                goto L7
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowExactUnboundedSubscriber.drainLoop():void");
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            dispose();
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (this.terminated) {
                return;
            }
            if (fastEnter()) {
                this.window.onNext(t5);
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.queue.offer(NotificationLite.next(t5));
                if (!enter()) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43245s, subscription)) {
                this.f43245s = subscription;
                this.window = UnicastProcessor.create(this.bufferSize);
                Subscriber<? super V> subscriber = this.actual;
                subscriber.onSubscribe(this);
                long requested = requested();
                if (requested == 0) {
                    this.cancelled = true;
                    subscription.cancel();
                    subscriber.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
                    return;
                }
                subscriber.onNext(this.window);
                if (requested != Long.MAX_VALUE) {
                    produced(1L);
                }
                if (!this.cancelled) {
                    SequentialDisposable sequentialDisposable = this.timer;
                    Scheduler scheduler = this.scheduler;
                    long j6 = this.timespan;
                    if (sequentialDisposable.replace(scheduler.schedulePeriodicallyDirect(this, j6, j6, this.unit))) {
                        subscription.request(Long.MAX_VALUE);
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.cancelled) {
                this.terminated = true;
                dispose();
            }
            this.queue.offer(NEXT);
            if (enter()) {
                drainLoop();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            requested(j6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class WindowSkipSubscriber<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription, Runnable {
        final int bufferSize;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43246s;
        volatile boolean terminated;
        final long timeskip;
        final long timespan;
        final TimeUnit unit;
        final List<UnicastProcessor<T>> windows;
        final Scheduler.Worker worker;

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            dispose();
            this.actual.onComplete();
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static final class SubjectWork<T> {
            final boolean open;

            /* renamed from: w, reason: collision with root package name */
            final UnicastProcessor<T> f43247w;

            SubjectWork(UnicastProcessor<T> unicastProcessor, boolean z5) {
                this.f43247w = unicastProcessor;
                this.open = z5;
            }
        }

        WindowSkipSubscriber(Subscriber<? super Flowable<T>> subscriber, long j6, long j7, TimeUnit timeUnit, Scheduler.Worker worker, int i6) {
            super(subscriber, new MpscLinkedQueue());
            this.timespan = j6;
            this.timeskip = j7;
            this.unit = timeUnit;
            this.worker = worker;
            this.bufferSize = i6;
            this.windows = new LinkedList();
        }

        void complete(UnicastProcessor<T> unicastProcessor) {
            this.queue.offer(new SubjectWork(unicastProcessor, false));
            if (enter()) {
                drainLoop();
            }
        }

        public void dispose() {
            this.worker.dispose();
        }

        /* JADX WARN: Multi-variable type inference failed */
        void drainLoop() {
            SimpleQueue simpleQueue = this.queue;
            Subscriber<? super V> subscriber = this.actual;
            List<UnicastProcessor<T>> list = this.windows;
            int i6 = 1;
            while (!this.terminated) {
                boolean z5 = this.done;
                Object poll = simpleQueue.poll();
                boolean z6 = poll == null;
                boolean z7 = poll instanceof SubjectWork;
                if (z5 && (z6 || z7)) {
                    simpleQueue.clear();
                    dispose();
                    Throwable th = this.error;
                    if (th != null) {
                        Iterator<UnicastProcessor<T>> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().onError(th);
                        }
                    } else {
                        Iterator<UnicastProcessor<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onComplete();
                        }
                    }
                    list.clear();
                    return;
                }
                if (z6) {
                    i6 = leave(-i6);
                    if (i6 == 0) {
                        return;
                    }
                } else if (z7) {
                    SubjectWork subjectWork = (SubjectWork) poll;
                    if (!subjectWork.open) {
                        list.remove(subjectWork.f43247w);
                        subjectWork.f43247w.onComplete();
                        if (list.isEmpty() && this.cancelled) {
                            this.terminated = true;
                        }
                    } else if (!this.cancelled) {
                        long requested = requested();
                        if (requested != 0) {
                            final UnicastProcessor<T> create = UnicastProcessor.create(this.bufferSize);
                            list.add(create);
                            subscriber.onNext(create);
                            if (requested != Long.MAX_VALUE) {
                                produced(1L);
                            }
                            this.worker.schedule(new Runnable() { // from class: io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowSkipSubscriber.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    WindowSkipSubscriber.this.complete(create);
                                }
                            }, this.timespan, this.unit);
                        } else {
                            subscriber.onError(new MissingBackpressureException("Can't emit window due to lack of requests"));
                        }
                    }
                } else {
                    Iterator<UnicastProcessor<T>> it3 = list.iterator();
                    while (it3.hasNext()) {
                        it3.next().onNext(poll);
                    }
                }
            }
            this.f43246s.cancel();
            dispose();
            simpleQueue.clear();
            list.clear();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            dispose();
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43246s, subscription)) {
                this.f43246s = subscription;
                this.actual.onSubscribe(this);
                if (!this.cancelled) {
                    long requested = requested();
                    if (requested == 0) {
                        subscription.cancel();
                        this.actual.onError(new MissingBackpressureException("Could not emit the first window due to lack of requests"));
                        return;
                    }
                    final UnicastProcessor<T> create = UnicastProcessor.create(this.bufferSize);
                    this.windows.add(create);
                    this.actual.onNext(create);
                    if (requested != Long.MAX_VALUE) {
                        produced(1L);
                    }
                    this.worker.schedule(new Runnable() { // from class: io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowSkipSubscriber.1
                        @Override // java.lang.Runnable
                        public void run() {
                            WindowSkipSubscriber.this.complete(create);
                        }
                    }, this.timespan, this.unit);
                    Scheduler.Worker worker = this.worker;
                    long j6 = this.timeskip;
                    worker.schedulePeriodically(this, j6, j6, this.unit);
                    subscription.request(Long.MAX_VALUE);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            SubjectWork subjectWork = new SubjectWork(UnicastProcessor.create(this.bufferSize), true);
            if (!this.cancelled) {
                this.queue.offer(subjectWork);
            }
            if (enter()) {
                drainLoop();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (fastEnter()) {
                Iterator<UnicastProcessor<T>> it = this.windows.iterator();
                while (it.hasNext()) {
                    it.next().onNext(t5);
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.queue.offer(t5);
                if (!enter()) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            requested(j6);
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        long j6 = this.timespan;
        long j7 = this.timeskip;
        if (j6 != j7) {
            this.source.subscribe(new WindowSkipSubscriber(serializedSubscriber, j6, j7, this.unit, this.scheduler.createWorker(), this.bufferSize));
            return;
        }
        long j8 = this.maxSize;
        if (j8 == Long.MAX_VALUE) {
            this.source.subscribe(new WindowExactUnboundedSubscriber(serializedSubscriber, this.timespan, this.unit, this.scheduler, this.bufferSize));
        } else {
            this.source.subscribe(new WindowExactBoundedSubscriber(serializedSubscriber, j6, this.unit, this.scheduler, this.bufferSize, j8, this.restartTimerOnMaxSize));
        }
    }

    public FlowableWindowTimed(Publisher<T> publisher, long j6, long j7, TimeUnit timeUnit, Scheduler scheduler, long j8, int i6, boolean z5) {
        super(publisher);
        this.timespan = j6;
        this.timeskip = j7;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.maxSize = j8;
        this.bufferSize = i6;
        this.restartTimerOnMaxSize = z5;
    }
}
