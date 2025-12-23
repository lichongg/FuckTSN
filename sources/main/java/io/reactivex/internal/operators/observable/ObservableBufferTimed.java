package io.reactivex.internal.operators.observable;

import androidx.camera.view.p;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableBufferTimed<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {
    final Callable<U> bufferSupplier;
    final int maxSize;
    final boolean restartTimerOnMaxSize;
    final Scheduler scheduler;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class BufferExactBoundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {
        U buffer;
        final Callable<U> bufferSupplier;
        long consumerIndex;
        final int maxSize;
        long producerIndex;
        final boolean restartTimerOnMaxSize;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43290s;
        Disposable timer;
        final long timespan;
        final TimeUnit unit;

        /* renamed from: w, reason: collision with root package name */
        final Scheduler.Worker f43291w;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        public /* bridge */ /* synthetic */ void accept(Observer observer, Object obj) {
            accept((Observer<? super Observer>) observer, (Observer) obj);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:60:0x0080
            	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
            	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
            	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
            */
        @Override // io.reactivex.Observer
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
                r12.fastPathOrderedEmit(r0, r13, r12)
                java.util.concurrent.Callable<U extends java.util.Collection<? super T>> r13 = r12.bufferSupplier     // Catch: java.lang.Throwable -> L6c
                java.lang.Object r13 = r13.call()     // Catch: java.lang.Throwable -> L6c
                java.lang.String r0 = "The buffer supplied is null"
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
                io.reactivex.Scheduler$Worker r5 = r12.f43291w
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
                r12.dispose()
                io.reactivex.Observer<? super V> r0 = r6.actual
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
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableBufferTimed.BufferExactBoundedObserver.onNext(java.lang.Object):void");
        }

        BufferExactBoundedObserver(Observer<? super U> observer, Callable<U> callable, long j6, TimeUnit timeUnit, int i6, boolean z5, Scheduler.Worker worker) {
            super(observer, new MpscLinkedQueue());
            this.bufferSupplier = callable;
            this.timespan = j6;
            this.unit = timeUnit;
            this.maxSize = i6;
            this.restartTimerOnMaxSize = z5;
            this.f43291w = worker;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void accept(Observer<? super U> observer, U u5) {
            observer.onNext(u5);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f43291w.dispose();
            synchronized (this) {
                this.buffer = null;
            }
            this.f43290s.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            U u5;
            this.f43291w.dispose();
            synchronized (this) {
                u5 = this.buffer;
                this.buffer = null;
            }
            this.queue.offer(u5);
            this.done = true;
            if (enter()) {
                QueueDrainHelper.drainLoop(this.queue, this.actual, false, this, this);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f43291w.dispose();
            synchronized (this) {
                this.buffer = null;
            }
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43290s, disposable)) {
                this.f43290s = disposable;
                try {
                    this.buffer = (U) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The buffer supplied is null");
                    this.actual.onSubscribe(this);
                    Scheduler.Worker worker = this.f43291w;
                    long j6 = this.timespan;
                    this.timer = worker.schedulePeriodically(this, j6, j6, this.unit);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.f43291w.dispose();
                    disposable.dispose();
                    EmptyDisposable.error(th, this.actual);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U u5 = (U) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    U u6 = this.buffer;
                    if (u6 != null && this.producerIndex == this.consumerIndex) {
                        this.buffer = u5;
                        fastPathOrderedEmit(u6, false, this);
                    }
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                dispose();
                this.actual.onError(th);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class BufferExactUnboundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {
        U buffer;
        final Callable<U> bufferSupplier;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43292s;
        final Scheduler scheduler;
        final AtomicReference<Disposable> timer;
        final long timespan;
        final TimeUnit unit;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        public /* bridge */ /* synthetic */ void accept(Observer observer, Object obj) {
            accept((Observer<? super Observer>) observer, (Observer) obj);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            synchronized (this) {
                try {
                    U u5 = this.buffer;
                    if (u5 == null) {
                        return;
                    }
                    u5.add(t5);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        BufferExactUnboundedObserver(Observer<? super U> observer, Callable<U> callable, long j6, TimeUnit timeUnit, Scheduler scheduler) {
            super(observer, new MpscLinkedQueue());
            this.timer = new AtomicReference<>();
            this.bufferSupplier = callable;
            this.timespan = j6;
            this.unit = timeUnit;
            this.scheduler = scheduler;
        }

        public void accept(Observer<? super U> observer, U u5) {
            this.actual.onNext(u5);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.timer);
            this.f43292s.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.timer.get() == DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            U u5;
            DisposableHelper.dispose(this.timer);
            synchronized (this) {
                u5 = this.buffer;
                this.buffer = null;
            }
            if (u5 != null) {
                this.queue.offer(u5);
                this.done = true;
                if (enter()) {
                    QueueDrainHelper.drainLoop(this.queue, this.actual, false, this, this);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.timer);
            synchronized (this) {
                this.buffer = null;
            }
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43292s, disposable)) {
                this.f43292s = disposable;
                try {
                    this.buffer = (U) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The buffer supplied is null");
                    this.actual.onSubscribe(this);
                    if (!this.cancelled) {
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
                    dispose();
                    EmptyDisposable.error(th, this.actual);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            U u5;
            try {
                U u6 = (U) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer");
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
                    fastPathEmit(u5, false, this);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                dispose();
                this.actual.onError(th2);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class BufferSkipBoundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {
        final Callable<U> bufferSupplier;
        final List<U> buffers;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43293s;
        final long timeskip;
        final long timespan;
        final TimeUnit unit;

        /* renamed from: w, reason: collision with root package name */
        final Scheduler.Worker f43294w;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        public /* bridge */ /* synthetic */ void accept(Observer observer, Object obj) {
            accept((Observer<? super Observer>) observer, (Observer) obj);
        }

        void clear() {
            synchronized (this) {
                this.buffers.clear();
            }
        }

        @Override // io.reactivex.Observer
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
                QueueDrainHelper.drainLoop(this.queue, this.actual, false, this.f43294w, this);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.done = true;
            this.f43294w.dispose();
            clear();
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
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

        BufferSkipBoundedObserver(Observer<? super U> observer, Callable<U> callable, long j6, long j7, TimeUnit timeUnit, Scheduler.Worker worker) {
            super(observer, new MpscLinkedQueue());
            this.bufferSupplier = callable;
            this.timespan = j6;
            this.timeskip = j7;
            this.unit = timeUnit;
            this.f43294w = worker;
            this.buffers = new LinkedList();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void accept(Observer<? super U> observer, U u5) {
            observer.onNext(u5);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f43294w.dispose();
            clear();
            this.f43293s.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43293s, disposable)) {
                this.f43293s = disposable;
                try {
                    final Collection collection = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The buffer supplied is null");
                    this.buffers.add(collection);
                    this.actual.onSubscribe(this);
                    Scheduler.Worker worker = this.f43294w;
                    long j6 = this.timeskip;
                    worker.schedulePeriodically(this, j6, j6, this.unit);
                    this.f43294w.schedule(new Runnable() { // from class: io.reactivex.internal.operators.observable.ObservableBufferTimed.BufferSkipBoundedObserver.1
                        @Override // java.lang.Runnable
                        public void run() {
                            synchronized (BufferSkipBoundedObserver.this) {
                                BufferSkipBoundedObserver.this.buffers.remove(collection);
                            }
                            BufferSkipBoundedObserver bufferSkipBoundedObserver = BufferSkipBoundedObserver.this;
                            bufferSkipBoundedObserver.fastPathOrderedEmit(collection, false, bufferSkipBoundedObserver.f43294w);
                        }
                    }, this.timespan, this.unit);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.f43294w.dispose();
                    disposable.dispose();
                    EmptyDisposable.error(th, this.actual);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.cancelled) {
                return;
            }
            try {
                final Collection collection = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    try {
                        if (this.cancelled) {
                            return;
                        }
                        this.buffers.add(collection);
                        this.f43294w.schedule(new Runnable() { // from class: io.reactivex.internal.operators.observable.ObservableBufferTimed.BufferSkipBoundedObserver.2
                            @Override // java.lang.Runnable
                            public void run() {
                                synchronized (BufferSkipBoundedObserver.this) {
                                    BufferSkipBoundedObserver.this.buffers.remove(collection);
                                }
                                BufferSkipBoundedObserver bufferSkipBoundedObserver = BufferSkipBoundedObserver.this;
                                bufferSkipBoundedObserver.fastPathOrderedEmit(collection, false, bufferSkipBoundedObserver.f43294w);
                            }
                        }, this.timespan, this.unit);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                dispose();
                this.actual.onError(th2);
            }
        }
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super U> observer) {
        if (this.timespan == this.timeskip && this.maxSize == Integer.MAX_VALUE) {
            this.source.subscribe(new BufferExactUnboundedObserver(new SerializedObserver(observer), this.bufferSupplier, this.timespan, this.unit, this.scheduler));
            return;
        }
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        if (this.timespan == this.timeskip) {
            this.source.subscribe(new BufferExactBoundedObserver(new SerializedObserver(observer), this.bufferSupplier, this.timespan, this.unit, this.maxSize, this.restartTimerOnMaxSize, createWorker));
        } else {
            this.source.subscribe(new BufferSkipBoundedObserver(new SerializedObserver(observer), this.bufferSupplier, this.timespan, this.timeskip, this.unit, createWorker));
        }
    }

    public ObservableBufferTimed(ObservableSource<T> observableSource, long j6, long j7, TimeUnit timeUnit, Scheduler scheduler, Callable<U> callable, int i6, boolean z5) {
        super(observableSource);
        this.timespan = j6;
        this.timeskip = j7;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.bufferSupplier = callable;
        this.maxSize = i6;
        this.restartTimerOnMaxSize = z5;
    }
}
