package io.reactivex.internal.operators.observable;

import androidx.camera.view.p;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableFlatMap<T, U> extends AbstractObservableWithUpstream<T, U> {
    final int bufferSize;
    final boolean delayErrors;
    final Function<? super T, ? extends ObservableSource<? extends U>> mapper;
    final int maxConcurrency;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class InnerObserver<T, U> extends AtomicReference<Disposable> implements Observer<U> {
        private static final long serialVersionUID = -4606175640614850599L;
        volatile boolean done;
        int fusionMode;
        final long id;
        final MergeObserver<T, U> parent;
        volatile SimpleQueue<U> queue;

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (!this.parent.errors.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            MergeObserver<T, U> mergeObserver = this.parent;
            if (!mergeObserver.delayErrors) {
                mergeObserver.disposeAll();
            }
            this.done = true;
            this.parent.drain();
        }

        @Override // io.reactivex.Observer
        public void onNext(U u5) {
            if (this.fusionMode == 0) {
                this.parent.tryEmit(u5, this);
            } else {
                this.parent.drain();
            }
        }

        InnerObserver(MergeObserver<T, U> mergeObserver, long j6) {
            this.id = j6;
            this.parent = mergeObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable) && (disposable instanceof QueueDisposable)) {
                QueueDisposable queueDisposable = (QueueDisposable) disposable;
                int requestFusion = queueDisposable.requestFusion(3);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = queueDisposable;
                    this.done = true;
                    this.parent.drain();
                    return;
                }
                if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = queueDisposable;
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class MergeObserver<T, U> extends AtomicInteger implements Disposable, Observer<T> {
        private static final long serialVersionUID = -2117620485640801370L;
        final Observer<? super U> actual;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final AtomicThrowable errors = new AtomicThrowable();
        long lastId;
        int lastIndex;
        final Function<? super T, ? extends ObservableSource<? extends U>> mapper;
        final int maxConcurrency;
        final AtomicReference<InnerObserver<?, ?>[]> observers;
        volatile SimplePlainQueue<U> queue;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43316s;
        Queue<ObservableSource<? extends U>> sources;
        long uniqueId;
        int wip;
        static final InnerObserver<?, ?>[] EMPTY = new InnerObserver[0];
        static final InnerObserver<?, ?>[] CANCELLED = new InnerObserver[0];

        void addInner(InnerObserver<T, U> innerObserver) {
            InnerObserver<?, ?>[] innerObserverArr;
            InnerObserver[] innerObserverArr2;
            do {
                innerObserverArr = this.observers.get();
                if (innerObserverArr == CANCELLED) {
                    innerObserver.dispose();
                    return;
                }
                int length = innerObserverArr.length;
                innerObserverArr2 = new InnerObserver[length + 1];
                System.arraycopy(innerObserverArr, 0, innerObserverArr2, 0, length);
                innerObserverArr2[length] = innerObserver;
            } while (!p.a(this.observers, innerObserverArr, innerObserverArr2));
        }

        boolean checkTerminate() {
            if (this.cancelled) {
                return true;
            }
            Throwable th = this.errors.get();
            if (this.delayErrors || th == null) {
                return false;
            }
            disposeAll();
            this.actual.onError(this.errors.terminate());
            return true;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Throwable terminate;
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            if (!disposeAll() || (terminate = this.errors.terminate()) == null || terminate == ExceptionHelper.TERMINATED) {
                return;
            }
            RxJavaPlugins.onError(terminate);
        }

        boolean disposeAll() {
            InnerObserver<?, ?>[] andSet;
            this.f43316s.dispose();
            InnerObserver<?, ?>[] innerObserverArr = this.observers.get();
            InnerObserver<?, ?>[] innerObserverArr2 = CANCELLED;
            if (innerObserverArr == innerObserverArr2 || (andSet = this.observers.getAndSet(innerObserverArr2)) == innerObserverArr2) {
                return false;
            }
            for (InnerObserver<?, ?> innerObserver : andSet) {
                innerObserver.dispose();
            }
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void drainLoop() {
            Observer<? super U> observer = this.actual;
            int i6 = 1;
            while (!checkTerminate()) {
                SimplePlainQueue<U> simplePlainQueue = this.queue;
                if (simplePlainQueue != null) {
                    while (!checkTerminate()) {
                        U poll = simplePlainQueue.poll();
                        if (poll != null) {
                            observer.onNext(poll);
                        } else if (poll == null) {
                        }
                    }
                    return;
                }
                boolean z5 = this.done;
                SimplePlainQueue<U> simplePlainQueue2 = this.queue;
                InnerObserver<?, ?>[] innerObserverArr = this.observers.get();
                int length = innerObserverArr.length;
                if (z5 && ((simplePlainQueue2 == null || simplePlainQueue2.isEmpty()) && length == 0)) {
                    if (this.errors.get() == null) {
                        observer.onComplete();
                        return;
                    } else {
                        observer.onError(this.errors.terminate());
                        return;
                    }
                }
                boolean z6 = false;
                if (length != 0) {
                    long j6 = this.lastId;
                    int i7 = this.lastIndex;
                    if (length <= i7 || innerObserverArr[i7].id != j6) {
                        if (length <= i7) {
                            i7 = 0;
                        }
                        for (int i8 = 0; i8 < length && innerObserverArr[i7].id != j6; i8++) {
                            i7++;
                            if (i7 == length) {
                                i7 = 0;
                            }
                        }
                        this.lastIndex = i7;
                        this.lastId = innerObserverArr[i7].id;
                    }
                    int i9 = 0;
                    boolean z7 = false;
                    while (i9 < length) {
                        if (checkTerminate()) {
                            return;
                        }
                        InnerObserver<T, U> innerObserver = innerObserverArr[i7];
                        while (!checkTerminate()) {
                            SimpleQueue<U> simpleQueue = innerObserver.queue;
                            if (simpleQueue != null) {
                                do {
                                    try {
                                        U poll2 = simpleQueue.poll();
                                        if (poll2 != null) {
                                            observer.onNext(poll2);
                                        } else if (poll2 == null) {
                                        }
                                    } catch (Throwable th) {
                                        Exceptions.throwIfFatal(th);
                                        innerObserver.dispose();
                                        this.errors.addThrowable(th);
                                        if (checkTerminate()) {
                                            return;
                                        }
                                        removeInner(innerObserver);
                                        i9++;
                                        z7 = true;
                                    }
                                } while (!checkTerminate());
                                return;
                            }
                            boolean z8 = innerObserver.done;
                            SimpleQueue<U> simpleQueue2 = innerObserver.queue;
                            if (z8 && (simpleQueue2 == null || simpleQueue2.isEmpty())) {
                                removeInner(innerObserver);
                                if (checkTerminate()) {
                                    return;
                                } else {
                                    z7 = true;
                                }
                            }
                            i7++;
                            if (i7 == length) {
                                i7 = 0;
                            }
                            i9++;
                        }
                        return;
                    }
                    this.lastIndex = i7;
                    this.lastId = innerObserverArr[i7].id;
                    z6 = z7;
                }
                if (!z6) {
                    i6 = addAndGet(-i6);
                    if (i6 == 0) {
                        return;
                    }
                } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                    synchronized (this) {
                        try {
                            ObservableSource<? extends U> poll3 = this.sources.poll();
                            if (poll3 == null) {
                                this.wip--;
                            } else {
                                subscribeInner(poll3);
                            }
                        } finally {
                        }
                    }
                } else {
                    continue;
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
            } else if (!this.errors.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else {
                this.done = true;
                drain();
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            if (this.done) {
                return;
            }
            try {
                ObservableSource<? extends U> observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.mapper.apply(t5), "The mapper returned a null ObservableSource");
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    synchronized (this) {
                        try {
                            int i6 = this.wip;
                            if (i6 == this.maxConcurrency) {
                                this.sources.offer(observableSource);
                                return;
                            }
                            this.wip = i6 + 1;
                        } finally {
                        }
                    }
                }
                subscribeInner(observableSource);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.f43316s.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43316s, disposable)) {
                this.f43316s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void removeInner(InnerObserver<T, U> innerObserver) {
            InnerObserver<?, ?>[] innerObserverArr;
            InnerObserver<?, ?>[] innerObserverArr2;
            do {
                innerObserverArr = this.observers.get();
                int length = innerObserverArr.length;
                if (length == 0) {
                    return;
                }
                int i6 = 0;
                while (true) {
                    if (i6 >= length) {
                        i6 = -1;
                        break;
                    } else if (innerObserverArr[i6] == innerObserver) {
                        break;
                    } else {
                        i6++;
                    }
                }
                if (i6 < 0) {
                    return;
                }
                if (length == 1) {
                    innerObserverArr2 = EMPTY;
                } else {
                    InnerObserver<?, ?>[] innerObserverArr3 = new InnerObserver[length - 1];
                    System.arraycopy(innerObserverArr, 0, innerObserverArr3, 0, i6);
                    System.arraycopy(innerObserverArr, i6 + 1, innerObserverArr3, i6, (length - i6) - 1);
                    innerObserverArr2 = innerObserverArr3;
                }
            } while (!p.a(this.observers, innerObserverArr, innerObserverArr2));
        }

        void subscribeInner(ObservableSource<? extends U> observableSource) {
            while (observableSource instanceof Callable) {
                tryEmitScalar((Callable) observableSource);
                if (this.maxConcurrency == Integer.MAX_VALUE) {
                    return;
                }
                synchronized (this) {
                    try {
                        observableSource = this.sources.poll();
                        if (observableSource == null) {
                            this.wip--;
                            return;
                        }
                    } finally {
                    }
                }
            }
            long j6 = this.uniqueId;
            this.uniqueId = 1 + j6;
            InnerObserver<T, U> innerObserver = new InnerObserver<>(this, j6);
            addInner(innerObserver);
            observableSource.subscribe(innerObserver);
        }

        MergeObserver(Observer<? super U> observer, Function<? super T, ? extends ObservableSource<? extends U>> function, boolean z5, int i6, int i7) {
            this.actual = observer;
            this.mapper = function;
            this.delayErrors = z5;
            this.maxConcurrency = i6;
            this.bufferSize = i7;
            if (i6 != Integer.MAX_VALUE) {
                this.sources = new ArrayDeque(i6);
            }
            this.observers = new AtomicReference<>(EMPTY);
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        void tryEmit(U u5, InnerObserver<T, U> innerObserver) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.actual.onNext(u5);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                SimpleQueue simpleQueue = innerObserver.queue;
                if (simpleQueue == null) {
                    simpleQueue = new SpscLinkedArrayQueue(this.bufferSize);
                    innerObserver.queue = simpleQueue;
                }
                simpleQueue.offer(u5);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        void tryEmitScalar(Callable<? extends U> callable) {
            try {
                U call = callable.call();
                if (call != null) {
                    if (get() == 0 && compareAndSet(0, 1)) {
                        this.actual.onNext(call);
                        if (decrementAndGet() == 0) {
                            return;
                        }
                    } else {
                        SimplePlainQueue<U> simplePlainQueue = this.queue;
                        if (simplePlainQueue == null) {
                            if (this.maxConcurrency == Integer.MAX_VALUE) {
                                simplePlainQueue = new SpscLinkedArrayQueue<>(this.bufferSize);
                            } else {
                                simplePlainQueue = new SpscArrayQueue<>(this.maxConcurrency);
                            }
                            this.queue = simplePlainQueue;
                        }
                        if (!simplePlainQueue.offer(call)) {
                            onError(new IllegalStateException("Scalar queue full?!"));
                            return;
                        } else if (getAndIncrement() != 0) {
                            return;
                        }
                    }
                    drainLoop();
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.errors.addThrowable(th);
                drain();
            }
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super U> observer) {
        if (ObservableScalarXMap.tryScalarXMapSubscribe(this.source, observer, this.mapper)) {
            return;
        }
        this.source.subscribe(new MergeObserver(observer, this.mapper, this.delayErrors, this.maxConcurrency, this.bufferSize));
    }

    public ObservableFlatMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends U>> function, boolean z5, int i6, int i7) {
        super(observableSource);
        this.mapper = function;
        this.delayErrors = z5;
        this.maxConcurrency = i6;
        this.bufferSize = i7;
    }
}
