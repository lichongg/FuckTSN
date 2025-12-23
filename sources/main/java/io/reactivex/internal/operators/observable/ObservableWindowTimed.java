package io.reactivex.internal.operators.observable;

import androidx.camera.view.p;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.subjects.UnicastSubject;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableWindowTimed<T> extends AbstractObservableWithUpstream<T, Observable<T>> {
    final int bufferSize;
    final long maxSize;
    final boolean restartTimerOnMaxSize;
    final Scheduler scheduler;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class WindowExactBoundedObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable {
        final int bufferSize;
        long count;
        final long maxSize;
        long producerIndex;
        final boolean restartTimerOnMaxSize;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43378s;
        final Scheduler scheduler;
        volatile boolean terminated;
        final AtomicReference<Disposable> timer;
        final long timespan;
        final TimeUnit unit;
        UnicastSubject<T> window;
        Scheduler.Worker worker;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static final class ConsumerIndexHolder implements Runnable {
            final long index;
            final WindowExactBoundedObserver<?> parent;

            @Override // java.lang.Runnable
            public void run() {
                WindowExactBoundedObserver<?> windowExactBoundedObserver = this.parent;
                if (((QueueDrainObserver) windowExactBoundedObserver).cancelled) {
                    windowExactBoundedObserver.terminated = true;
                    windowExactBoundedObserver.disposeTimer();
                } else {
                    ((QueueDrainObserver) windowExactBoundedObserver).queue.offer(this);
                }
                if (windowExactBoundedObserver.enter()) {
                    windowExactBoundedObserver.drainLoop();
                }
            }

            ConsumerIndexHolder(long j6, WindowExactBoundedObserver<?> windowExactBoundedObserver) {
                this.index = j6;
                this.parent = windowExactBoundedObserver;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            disposeTimer();
            this.actual.onComplete();
        }

        WindowExactBoundedObserver(Observer<? super Observable<T>> observer, long j6, TimeUnit timeUnit, Scheduler scheduler, int i6, long j7, boolean z5) {
            super(observer, new MpscLinkedQueue());
            this.timer = new AtomicReference<>();
            this.timespan = j6;
            this.unit = timeUnit;
            this.scheduler = scheduler;
            this.bufferSize = i6;
            this.maxSize = j7;
            this.restartTimerOnMaxSize = z5;
        }

        void disposeTimer() {
            DisposableHelper.dispose(this.timer);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [io.reactivex.subjects.UnicastSubject<T>] */
        void drainLoop() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.queue;
            Observer<? super V> observer = this.actual;
            UnicastSubject<T> unicastSubject = this.window;
            int i6 = 1;
            while (!this.terminated) {
                boolean z5 = this.done;
                Object poll = mpscLinkedQueue.poll();
                boolean z6 = poll == null;
                boolean z7 = poll instanceof ConsumerIndexHolder;
                if (z5 && (z6 || z7)) {
                    this.window = null;
                    mpscLinkedQueue.clear();
                    disposeTimer();
                    Throwable th = this.error;
                    if (th != null) {
                        unicastSubject.onError(th);
                        return;
                    } else {
                        unicastSubject.onComplete();
                        return;
                    }
                }
                if (z6) {
                    i6 = leave(-i6);
                    if (i6 == 0) {
                        return;
                    }
                } else if (!z7) {
                    unicastSubject.onNext(NotificationLite.getValue(poll));
                    long j6 = this.count + 1;
                    if (j6 >= this.maxSize) {
                        this.producerIndex++;
                        this.count = 0L;
                        unicastSubject.onComplete();
                        unicastSubject = (UnicastSubject<T>) UnicastSubject.create(this.bufferSize);
                        this.window = unicastSubject;
                        this.actual.onNext(unicastSubject);
                        if (this.restartTimerOnMaxSize) {
                            Disposable disposable = this.timer.get();
                            disposable.dispose();
                            Scheduler.Worker worker = this.worker;
                            ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.producerIndex, this);
                            long j7 = this.timespan;
                            Disposable schedulePeriodically = worker.schedulePeriodically(consumerIndexHolder, j7, j7, this.unit);
                            if (!p.a(this.timer, disposable, schedulePeriodically)) {
                                schedulePeriodically.dispose();
                            }
                        }
                    } else {
                        this.count = j6;
                    }
                } else if (this.producerIndex == ((ConsumerIndexHolder) poll).index) {
                    unicastSubject = (UnicastSubject<T>) UnicastSubject.create(this.bufferSize);
                    this.window = unicastSubject;
                    observer.onNext(unicastSubject);
                }
            }
            this.f43378s.dispose();
            mpscLinkedQueue.clear();
            disposeTimer();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            disposeTimer();
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            if (this.terminated) {
                return;
            }
            if (fastEnter()) {
                UnicastSubject<T> unicastSubject = this.window;
                unicastSubject.onNext(t5);
                long j6 = this.count + 1;
                if (j6 >= this.maxSize) {
                    this.producerIndex++;
                    this.count = 0L;
                    unicastSubject.onComplete();
                    UnicastSubject<T> create = UnicastSubject.create(this.bufferSize);
                    this.window = create;
                    this.actual.onNext(create);
                    if (this.restartTimerOnMaxSize) {
                        this.timer.get().dispose();
                        Scheduler.Worker worker = this.worker;
                        ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.producerIndex, this);
                        long j7 = this.timespan;
                        DisposableHelper.replace(this.timer, worker.schedulePeriodically(consumerIndexHolder, j7, j7, this.unit));
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

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Disposable disposable2;
            if (DisposableHelper.validate(this.f43378s, disposable)) {
                this.f43378s = disposable;
                Observer<? super V> observer = this.actual;
                observer.onSubscribe(this);
                if (this.cancelled) {
                    return;
                }
                UnicastSubject<T> create = UnicastSubject.create(this.bufferSize);
                this.window = create;
                observer.onNext(create);
                ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.producerIndex, this);
                if (this.restartTimerOnMaxSize) {
                    Scheduler.Worker createWorker = this.scheduler.createWorker();
                    this.worker = createWorker;
                    long j6 = this.timespan;
                    createWorker.schedulePeriodically(consumerIndexHolder, j6, j6, this.unit);
                    disposable2 = createWorker;
                } else {
                    Scheduler scheduler = this.scheduler;
                    long j7 = this.timespan;
                    disposable2 = scheduler.schedulePeriodicallyDirect(consumerIndexHolder, j7, j7, this.unit);
                }
                DisposableHelper.replace(this.timer, disposable2);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class WindowExactUnboundedObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Observer<T>, Disposable, Runnable {
        static final Object NEXT = new Object();
        final int bufferSize;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43379s;
        final Scheduler scheduler;
        volatile boolean terminated;
        final AtomicReference<Disposable> timer;
        final long timespan;
        final TimeUnit unit;
        UnicastSubject<T> window;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            disposeTimer();
            this.actual.onComplete();
        }

        WindowExactUnboundedObserver(Observer<? super Observable<T>> observer, long j6, TimeUnit timeUnit, Scheduler scheduler, int i6) {
            super(observer, new MpscLinkedQueue());
            this.timer = new AtomicReference<>();
            this.timespan = j6;
            this.unit = timeUnit;
            this.scheduler = scheduler;
            this.bufferSize = i6;
        }

        void disposeTimer() {
            DisposableHelper.dispose(this.timer);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
        
            r2.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
        
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
        
            r7.window = null;
            r0.clear();
            disposeTimer();
            r0 = r7.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
        
            if (r0 == null) goto L12;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [io.reactivex.subjects.UnicastSubject<T>] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drainLoop() {
            /*
                r7 = this;
                io.reactivex.internal.fuseable.SimpleQueue<U> r0 = r7.queue
                io.reactivex.internal.queue.MpscLinkedQueue r0 = (io.reactivex.internal.queue.MpscLinkedQueue) r0
                io.reactivex.Observer<? super V> r1 = r7.actual
                io.reactivex.subjects.UnicastSubject<T> r2 = r7.window
                r3 = 1
            L9:
                boolean r4 = r7.terminated
                boolean r5 = r7.done
                java.lang.Object r6 = r0.poll()
                if (r5 == 0) goto L2e
                if (r6 == 0) goto L19
                java.lang.Object r5 = io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowExactUnboundedObserver.NEXT
                if (r6 != r5) goto L2e
            L19:
                r1 = 0
                r7.window = r1
                r0.clear()
                r7.disposeTimer()
                java.lang.Throwable r0 = r7.error
                if (r0 == 0) goto L2a
                r2.onError(r0)
                return
            L2a:
                r2.onComplete()
                return
            L2e:
                if (r6 != 0) goto L38
                int r3 = -r3
                int r3 = r7.leave(r3)
                if (r3 != 0) goto L9
                return
            L38:
                java.lang.Object r5 = io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowExactUnboundedObserver.NEXT
                if (r6 != r5) goto L53
                r2.onComplete()
                if (r4 != 0) goto L4d
                int r2 = r7.bufferSize
                io.reactivex.subjects.UnicastSubject r2 = io.reactivex.subjects.UnicastSubject.create(r2)
                r7.window = r2
                r1.onNext(r2)
                goto L9
            L4d:
                io.reactivex.disposables.Disposable r4 = r7.f43379s
                r4.dispose()
                goto L9
            L53:
                java.lang.Object r4 = io.reactivex.internal.util.NotificationLite.getValue(r6)
                r2.onNext(r4)
                goto L9
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowExactUnboundedObserver.drainLoop():void");
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            disposeTimer();
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
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

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43379s, disposable)) {
                this.f43379s = disposable;
                this.window = UnicastSubject.create(this.bufferSize);
                Observer<? super V> observer = this.actual;
                observer.onSubscribe(this);
                observer.onNext(this.window);
                if (!this.cancelled) {
                    Scheduler scheduler = this.scheduler;
                    long j6 = this.timespan;
                    DisposableHelper.replace(this.timer, scheduler.schedulePeriodicallyDirect(this, j6, j6, this.unit));
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.cancelled) {
                this.terminated = true;
                disposeTimer();
            }
            this.queue.offer(NEXT);
            if (enter()) {
                drainLoop();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class WindowSkipObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable, Runnable {
        final int bufferSize;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43380s;
        volatile boolean terminated;
        final long timeskip;
        final long timespan;
        final TimeUnit unit;
        final List<UnicastSubject<T>> windows;
        final Scheduler.Worker worker;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            disposeWorker();
            this.actual.onComplete();
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static final class SubjectWork<T> {
            final boolean open;

            /* renamed from: w, reason: collision with root package name */
            final UnicastSubject<T> f43381w;

            SubjectWork(UnicastSubject<T> unicastSubject, boolean z5) {
                this.f43381w = unicastSubject;
                this.open = z5;
            }
        }

        WindowSkipObserver(Observer<? super Observable<T>> observer, long j6, long j7, TimeUnit timeUnit, Scheduler.Worker worker, int i6) {
            super(observer, new MpscLinkedQueue());
            this.timespan = j6;
            this.timeskip = j7;
            this.unit = timeUnit;
            this.worker = worker;
            this.bufferSize = i6;
            this.windows = new LinkedList();
        }

        void complete(UnicastSubject<T> unicastSubject) {
            this.queue.offer(new SubjectWork(unicastSubject, false));
            if (enter()) {
                drainLoop();
            }
        }

        void disposeWorker() {
            this.worker.dispose();
        }

        /* JADX WARN: Multi-variable type inference failed */
        void drainLoop() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.queue;
            Observer<? super V> observer = this.actual;
            List<UnicastSubject<T>> list = this.windows;
            int i6 = 1;
            while (!this.terminated) {
                boolean z5 = this.done;
                Object poll = mpscLinkedQueue.poll();
                boolean z6 = poll == null;
                boolean z7 = poll instanceof SubjectWork;
                if (z5 && (z6 || z7)) {
                    mpscLinkedQueue.clear();
                    disposeWorker();
                    Throwable th = this.error;
                    if (th != null) {
                        Iterator<UnicastSubject<T>> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().onError(th);
                        }
                    } else {
                        Iterator<UnicastSubject<T>> it2 = list.iterator();
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
                        list.remove(subjectWork.f43381w);
                        subjectWork.f43381w.onComplete();
                        if (list.isEmpty() && this.cancelled) {
                            this.terminated = true;
                        }
                    } else if (!this.cancelled) {
                        final UnicastSubject<T> create = UnicastSubject.create(this.bufferSize);
                        list.add(create);
                        observer.onNext(create);
                        this.worker.schedule(new Runnable() { // from class: io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowSkipObserver.2
                            @Override // java.lang.Runnable
                            public void run() {
                                WindowSkipObserver.this.complete(create);
                            }
                        }, this.timespan, this.unit);
                    }
                } else {
                    Iterator<UnicastSubject<T>> it3 = list.iterator();
                    while (it3.hasNext()) {
                        it3.next().onNext(poll);
                    }
                }
            }
            this.f43380s.dispose();
            disposeWorker();
            mpscLinkedQueue.clear();
            list.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            disposeWorker();
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43380s, disposable)) {
                this.f43380s = disposable;
                this.actual.onSubscribe(this);
                if (this.cancelled) {
                    return;
                }
                final UnicastSubject<T> create = UnicastSubject.create(this.bufferSize);
                this.windows.add(create);
                this.actual.onNext(create);
                this.worker.schedule(new Runnable() { // from class: io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowSkipObserver.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WindowSkipObserver.this.complete(create);
                    }
                }, this.timespan, this.unit);
                Scheduler.Worker worker = this.worker;
                long j6 = this.timeskip;
                worker.schedulePeriodically(this, j6, j6, this.unit);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            SubjectWork subjectWork = new SubjectWork(UnicastSubject.create(this.bufferSize), true);
            if (!this.cancelled) {
                this.queue.offer(subjectWork);
            }
            if (enter()) {
                drainLoop();
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            if (fastEnter()) {
                Iterator<UnicastSubject<T>> it = this.windows.iterator();
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
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Observable<T>> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        long j6 = this.timespan;
        long j7 = this.timeskip;
        if (j6 != j7) {
            this.source.subscribe(new WindowSkipObserver(serializedObserver, j6, j7, this.unit, this.scheduler.createWorker(), this.bufferSize));
            return;
        }
        long j8 = this.maxSize;
        if (j8 == Long.MAX_VALUE) {
            this.source.subscribe(new WindowExactUnboundedObserver(serializedObserver, this.timespan, this.unit, this.scheduler, this.bufferSize));
        } else {
            this.source.subscribe(new WindowExactBoundedObserver(serializedObserver, j6, this.unit, this.scheduler, this.bufferSize, j8, this.restartTimerOnMaxSize));
        }
    }

    public ObservableWindowTimed(ObservableSource<T> observableSource, long j6, long j7, TimeUnit timeUnit, Scheduler scheduler, long j8, int i6, boolean z5) {
        super(observableSource);
        this.timespan = j6;
        this.timeskip = j7;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.maxSize = j8;
        this.bufferSize = i6;
        this.restartTimerOnMaxSize = z5;
    }
}
