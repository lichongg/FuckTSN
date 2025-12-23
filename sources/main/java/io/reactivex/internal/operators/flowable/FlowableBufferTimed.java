package io.reactivex.internal.operators.flowable;

import androidx.camera.view.p;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableBufferTimed<T, U extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, U> {
    final Callable<U> bufferSupplier;
    final int maxSize;
    final boolean restartTimerOnMaxSize;
    final Scheduler scheduler;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class BufferExactBoundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable, Disposable {
        U buffer;
        final Callable<U> bufferSupplier;
        long consumerIndex;
        final int maxSize;
        long producerIndex;
        final boolean restartTimerOnMaxSize;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43151s;
        Disposable timer;
        final long timespan;
        final TimeUnit unit;

        /* renamed from: w, reason: collision with root package name */
        final Scheduler.Worker f43152w;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        public /* bridge */ /* synthetic */ boolean accept(Subscriber subscriber, Object obj) {
            return accept((Subscriber<? super Subscriber>) subscriber, (Subscriber) obj);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:60:0x0080
            	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
            	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
            	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
            */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T r13) {
            /*
                r12 = this;
                monitor-enter(r12)
                U extends java.util.Collection<? super T> r0 = r12.buffer     // Catch: java.lang.Throwable -> L7b
                if (r0 != 0) goto Lc
                monitor-exit(r12)     // Catch: java.lang.Throwable -> L7
                return
            L7:
                r0 = move-exception
                r13 = r0
                r6 = r12
                goto L7e
            Lc:
                r0.add(r13)     // Catch: java.lang.Throwable -> L7b
                int r13 = r0.size()     // Catch: java.lang.Throwable -> L7b
                int r1 = r12.maxSize     // Catch: java.lang.Throwable -> L7b
                if (r13 >= r1) goto L19
                monitor-exit(r12)     // Catch: java.lang.Throwable -> L7
                return
            L19:
                monitor-exit(r12)     // Catch: java.lang.Throwable -> L7b
                boolean r13 = r12.restartTimerOnMaxSize
                r1 = 1
                if (r13 == 0) goto L2d
                r13 = 0
                r12.buffer = r13
                long r3 = r12.producerIndex
                long r3 = r3 + r1
                r12.producerIndex = r3
                io.reactivex.disposables.Disposable r13 = r12.timer
                r13.dispose()
            L2d:
                r13 = 0
                r12.fastPathOrderedEmitMax(r0, r13, r12)
                java.util.concurrent.Callable<U extends java.util.Collection<? super T>> r13 = r12.bufferSupplier     // Catch: java.lang.Throwable -> L6c
                java.lang.Object r13 = r13.call()     // Catch: java.lang.Throwable -> L6c
                java.lang.String r0 = "The supplied buffer is null"
                java.lang.Object r13 = io.reactivex.internal.functions.ObjectHelper.requireNonNull(r13, r0)     // Catch: java.lang.Throwable -> L6c
                java.util.Collection r13 = (java.util.Collection) r13     // Catch: java.lang.Throwable -> L6c
                boolean r0 = r12.restartTimerOnMaxSize
                if (r0 == 0) goto L62
                monitor-enter(r12)
                r12.buffer = r13     // Catch: java.lang.Throwable -> L5b
                long r3 = r12.consumerIndex     // Catch: java.lang.Throwable -> L5b
                long r3 = r3 + r1
                r12.consumerIndex = r3     // Catch: java.lang.Throwable -> L5b
                monitor-exit(r12)     // Catch: java.lang.Throwable -> L5b
                io.reactivex.Scheduler$Worker r5 = r12.f43152w
                long r7 = r12.timespan
                java.util.concurrent.TimeUnit r11 = r12.unit
                r9 = r7
                r6 = r12
                io.reactivex.disposables.Disposable r13 = r5.schedulePeriodically(r6, r7, r9, r11)
                r6.timer = r13
                return
            L5b:
                r0 = move-exception
                r6 = r12
            L5d:
                r13 = r0
                monitor-exit(r12)     // Catch: java.lang.Throwable -> L60
                throw r13
            L60:
                r0 = move-exception
                goto L5d
            L62:
                r6 = r12
                monitor-enter(r12)
                r6.buffer = r13     // Catch: java.lang.Throwable -> L68
                monitor-exit(r12)     // Catch: java.lang.Throwable -> L68
                return
            L68:
                r0 = move-exception
                r13 = r0
                monitor-exit(r12)     // Catch: java.lang.Throwable -> L68
                throw r13
            L6c:
                r0 = move-exception
                r6 = r12
                r13 = r0
                io.reactivex.exceptions.Exceptions.throwIfFatal(r13)
                r12.cancel()
                org.reactivestreams.Subscriber<? super V> r0 = r6.actual
                r0.onError(r13)
                return
            L7b:
                r0 = move-exception
                r6 = r12
            L7d:
                r13 = r0
            L7e:
                monitor-exit(r12)     // Catch: java.lang.Throwable -> L80
                throw r13
            L80:
                r0 = move-exception
                goto L7d
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableBufferTimed.BufferExactBoundedSubscriber.onNext(java.lang.Object):void");
        }

        BufferExactBoundedSubscriber(Subscriber<? super U> subscriber, Callable<U> callable, long j6, TimeUnit timeUnit, int i6, boolean z5, Scheduler.Worker worker) {
            super(subscriber, new MpscLinkedQueue());
            this.bufferSupplier = callable;
            this.timespan = j6;
            this.unit = timeUnit;
            this.maxSize = i6;
            this.restartTimerOnMaxSize = z5;
            this.f43152w = worker;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean accept(Subscriber<? super U> subscriber, U u5) {
            subscriber.onNext(u5);
            return true;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f43152w.dispose();
            synchronized (this) {
                this.buffer = null;
            }
            this.f43151s.cancel();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f43152w.isDisposed();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            U u5;
            this.f43152w.dispose();
            synchronized (this) {
                u5 = this.buffer;
                this.buffer = null;
            }
            this.queue.offer(u5);
            this.done = true;
            if (enter()) {
                QueueDrainHelper.drainMaxLoop(this.queue, this.actual, false, this, this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f43152w.dispose();
            synchronized (this) {
                this.buffer = null;
            }
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43151s, subscription)) {
                this.f43151s = subscription;
                try {
                    this.buffer = (U) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The supplied buffer is null");
                    this.actual.onSubscribe(this);
                    Scheduler.Worker worker = this.f43152w;
                    long j6 = this.timespan;
                    this.timer = worker.schedulePeriodically(this, j6, j6, this.unit);
                    subscription.request(Long.MAX_VALUE);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.f43152w.dispose();
                    subscription.cancel();
                    EmptySubscription.error(th, this.actual);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U u5 = (U) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The supplied buffer is null");
                synchronized (this) {
                    U u6 = this.buffer;
                    if (u6 != null && this.producerIndex == this.consumerIndex) {
                        this.buffer = u5;
                        fastPathOrderedEmitMax(u6, false, this);
                    }
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                cancel();
                this.actual.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            requested(j6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class BufferExactUnboundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable, Disposable {
        U buffer;
        final Callable<U> bufferSupplier;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43153s;
        final Scheduler scheduler;
        final AtomicReference<Disposable> timer;
        final long timespan;
        final TimeUnit unit;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        public /* bridge */ /* synthetic */ boolean accept(Subscriber subscriber, Object obj) {
            return accept((Subscriber<? super Subscriber>) subscriber, (Subscriber) obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            synchronized (this) {
                try {
                    U u5 = this.buffer;
                    if (u5 != null) {
                        u5.add(t5);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        BufferExactUnboundedSubscriber(Subscriber<? super U> subscriber, Callable<U> callable, long j6, TimeUnit timeUnit, Scheduler scheduler) {
            super(subscriber, new MpscLinkedQueue());
            this.timer = new AtomicReference<>();
            this.bufferSupplier = callable;
            this.timespan = j6;
            this.unit = timeUnit;
            this.scheduler = scheduler;
        }

        public boolean accept(Subscriber<? super U> subscriber, U u5) {
            this.actual.onNext(u5);
            return true;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            DisposableHelper.dispose(this.timer);
            this.f43153s.cancel();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.timer.get() == DisposableHelper.DISPOSED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            DisposableHelper.dispose(this.timer);
            synchronized (this) {
                try {
                    U u5 = this.buffer;
                    if (u5 == null) {
                        return;
                    }
                    this.buffer = null;
                    this.queue.offer(u5);
                    this.done = true;
                    if (enter()) {
                        QueueDrainHelper.drainMaxLoop(this.queue, this.actual, false, this, this);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.timer);
            synchronized (this) {
                this.buffer = null;
            }
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43153s, subscription)) {
                this.f43153s = subscription;
                try {
                    this.buffer = (U) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The supplied buffer is null");
                    this.actual.onSubscribe(this);
                    if (!this.cancelled) {
                        subscription.request(Long.MAX_VALUE);
                        Scheduler scheduler = this.scheduler;
                        long j6 = this.timespan;
                        Disposable schedulePeriodicallyDirect = scheduler.schedulePeriodicallyDirect(this, j6, j6, this.unit);
                        if (p.a(this.timer, null, schedulePeriodicallyDirect)) {
                            return;
                        }
                        schedulePeriodicallyDirect.dispose();
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
                    EmptySubscription.error(th, this.actual);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            U u5;
            try {
                U u6 = (U) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The supplied buffer is null");
                synchronized (this) {
                    try {
                        u5 = this.buffer;
                        if (u5 != null) {
                            this.buffer = u6;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (u5 == null) {
                    DisposableHelper.dispose(this.timer);
                } else {
                    fastPathEmitMax(u5, false, this);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                cancel();
                this.actual.onError(th2);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            cancel();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            requested(j6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class BufferSkipBoundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable {
        final Callable<U> bufferSupplier;
        final List<U> buffers;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43154s;
        final long timeskip;
        final long timespan;
        final TimeUnit unit;

        /* renamed from: w, reason: collision with root package name */
        final Scheduler.Worker f43155w;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        public /* bridge */ /* synthetic */ boolean accept(Subscriber subscriber, Object obj) {
            return accept((Subscriber<? super Subscriber>) subscriber, (Subscriber) obj);
        }

        void clear() {
            synchronized (this) {
                this.buffers.clear();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.buffers);
                this.buffers.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.queue.offer((Collection) it.next());
            }
            this.done = true;
            if (enter()) {
                QueueDrainHelper.drainMaxLoop(this.queue, this.actual, false, this.f43155w, this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.done = true;
            this.f43155w.dispose();
            clear();
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            synchronized (this) {
                try {
                    Iterator<U> it = this.buffers.iterator();
                    while (it.hasNext()) {
                        it.next().add(t5);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        BufferSkipBoundedSubscriber(Subscriber<? super U> subscriber, Callable<U> callable, long j6, long j7, TimeUnit timeUnit, Scheduler.Worker worker) {
            super(subscriber, new MpscLinkedQueue());
            this.bufferSupplier = callable;
            this.timespan = j6;
            this.timeskip = j7;
            this.unit = timeUnit;
            this.f43155w = worker;
            this.buffers = new LinkedList();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean accept(Subscriber<? super U> subscriber, U u5) {
            subscriber.onNext(u5);
            return true;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f43155w.dispose();
            clear();
            this.f43154s.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43154s, subscription)) {
                this.f43154s = subscription;
                try {
                    final Collection collection = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The supplied buffer is null");
                    this.buffers.add(collection);
                    this.actual.onSubscribe(this);
                    subscription.request(Long.MAX_VALUE);
                    Scheduler.Worker worker = this.f43155w;
                    long j6 = this.timeskip;
                    worker.schedulePeriodically(this, j6, j6, this.unit);
                    this.f43155w.schedule(new Runnable() { // from class: io.reactivex.internal.operators.flowable.FlowableBufferTimed.BufferSkipBoundedSubscriber.1
                        @Override // java.lang.Runnable
                        public void run() {
                            synchronized (BufferSkipBoundedSubscriber.this) {
                                BufferSkipBoundedSubscriber.this.buffers.remove(collection);
                            }
                            BufferSkipBoundedSubscriber bufferSkipBoundedSubscriber = BufferSkipBoundedSubscriber.this;
                            bufferSkipBoundedSubscriber.fastPathOrderedEmitMax(collection, false, bufferSkipBoundedSubscriber.f43155w);
                        }
                    }, this.timespan, this.unit);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.f43155w.dispose();
                    subscription.cancel();
                    EmptySubscription.error(th, this.actual);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.cancelled) {
                return;
            }
            try {
                final Collection collection = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The supplied buffer is null");
                synchronized (this) {
                    try {
                        if (this.cancelled) {
                            return;
                        }
                        this.buffers.add(collection);
                        this.f43155w.schedule(new Runnable() { // from class: io.reactivex.internal.operators.flowable.FlowableBufferTimed.BufferSkipBoundedSubscriber.2
                            @Override // java.lang.Runnable
                            public void run() {
                                synchronized (BufferSkipBoundedSubscriber.this) {
                                    BufferSkipBoundedSubscriber.this.buffers.remove(collection);
                                }
                                BufferSkipBoundedSubscriber bufferSkipBoundedSubscriber = BufferSkipBoundedSubscriber.this;
                                bufferSkipBoundedSubscriber.fastPathOrderedEmitMax(collection, false, bufferSkipBoundedSubscriber.f43155w);
                            }
                        }, this.timespan, this.unit);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                cancel();
                this.actual.onError(th2);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            requested(j6);
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super U> subscriber) {
        if (this.timespan == this.timeskip && this.maxSize == Integer.MAX_VALUE) {
            this.source.subscribe(new BufferExactUnboundedSubscriber(new SerializedSubscriber(subscriber), this.bufferSupplier, this.timespan, this.unit, this.scheduler));
            return;
        }
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        if (this.timespan == this.timeskip) {
            this.source.subscribe(new BufferExactBoundedSubscriber(new SerializedSubscriber(subscriber), this.bufferSupplier, this.timespan, this.unit, this.maxSize, this.restartTimerOnMaxSize, createWorker));
        } else {
            this.source.subscribe(new BufferSkipBoundedSubscriber(new SerializedSubscriber(subscriber), this.bufferSupplier, this.timespan, this.timeskip, this.unit, createWorker));
        }
    }

    public FlowableBufferTimed(Publisher<T> publisher, long j6, long j7, TimeUnit timeUnit, Scheduler scheduler, Callable<U> callable, int i6, boolean z5) {
        super(publisher);
        this.timespan = j6;
        this.timeskip = j7;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.bufferSupplier = callable;
        this.maxSize = i6;
        this.restartTimerOnMaxSize = z5;
    }
}
