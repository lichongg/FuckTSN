package io.reactivex.internal.operators.observable;

import defpackage.H5BaseWebChromeClient;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableConcatMap<T, U> extends AbstractObservableWithUpstream<T, U> {
    final int bufferSize;
    final ErrorMode delayErrors;
    final Function<? super T, ? extends ObservableSource<? extends U>> mapper;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ConcatMapDelayErrorObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -6951100001833242599L;
        volatile boolean active;
        final Observer<? super R> actual;
        final int bufferSize;
        volatile boolean cancelled;

        /* renamed from: d, reason: collision with root package name */
        Disposable f43300d;
        volatile boolean done;
        final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
        final DelayErrorInnerObserver<R> observer;
        SimpleQueue<T> queue;
        int sourceMode;
        final boolean tillTheEnd;
        final AtomicThrowable error = new AtomicThrowable();
        final SequentialDisposable arbiter = new SequentialDisposable();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static final class DelayErrorInnerObserver<R> implements Observer<R> {
            final Observer<? super R> actual;
            final ConcatMapDelayErrorObserver<?, R> parent;

            @Override // io.reactivex.Observer
            public void onComplete() {
                ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.parent;
                concatMapDelayErrorObserver.active = false;
                concatMapDelayErrorObserver.drain();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.parent;
                if (!concatMapDelayErrorObserver.error.addThrowable(th)) {
                    RxJavaPlugins.onError(th);
                    return;
                }
                if (!concatMapDelayErrorObserver.tillTheEnd) {
                    concatMapDelayErrorObserver.f43300d.dispose();
                }
                concatMapDelayErrorObserver.active = false;
                concatMapDelayErrorObserver.drain();
            }

            @Override // io.reactivex.Observer
            public void onNext(R r5) {
                this.actual.onNext(r5);
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
                this.parent.arbiter.replace(disposable);
            }

            DelayErrorInnerObserver(Observer<? super R> observer, ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver) {
                this.actual = observer;
                this.parent = concatMapDelayErrorObserver;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
            this.f43300d.dispose();
            this.arbiter.dispose();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f43300d.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (!this.error.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else {
                this.done = true;
                drain();
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            if (this.sourceMode == 0) {
                this.queue.offer(t5);
            }
            drain();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43300d, disposable)) {
                this.f43300d = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueDisposable;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        drain();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueDisposable;
                        this.actual.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new SpscLinkedArrayQueue(this.bufferSize);
                this.actual.onSubscribe(this);
            }
        }

        ConcatMapDelayErrorObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, int i6, boolean z5) {
            this.actual = observer;
            this.mapper = function;
            this.bufferSize = i6;
            this.tillTheEnd = z5;
            this.observer = new DelayErrorInnerObserver<>(observer, this);
        }

        void drain() {
            boolean z5;
            if (getAndIncrement() == 0) {
                Observer<? super R> observer = this.actual;
                SimpleQueue<T> simpleQueue = this.queue;
                AtomicThrowable atomicThrowable = this.error;
                while (true) {
                    if (!this.active) {
                        if (this.cancelled) {
                            simpleQueue.clear();
                            return;
                        }
                        if (!this.tillTheEnd && atomicThrowable.get() != null) {
                            simpleQueue.clear();
                            observer.onError(atomicThrowable.terminate());
                            return;
                        }
                        boolean z6 = this.done;
                        try {
                            T poll = simpleQueue.poll();
                            if (poll == null) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            if (z6 && z5) {
                                Throwable terminate = atomicThrowable.terminate();
                                if (terminate != null) {
                                    observer.onError(terminate);
                                    return;
                                } else {
                                    observer.onComplete();
                                    return;
                                }
                            }
                            if (!z5) {
                                try {
                                    ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.mapper.apply(poll), "The mapper returned a null ObservableSource");
                                    if (observableSource instanceof Callable) {
                                        try {
                                            H5BaseWebChromeClient h5BaseWebChromeClient = (Object) ((Callable) observableSource).call();
                                            if (h5BaseWebChromeClient != null && !this.cancelled) {
                                                observer.onNext(h5BaseWebChromeClient);
                                            }
                                        } catch (Throwable th) {
                                            Exceptions.throwIfFatal(th);
                                            atomicThrowable.addThrowable(th);
                                        }
                                    } else {
                                        this.active = true;
                                        observableSource.subscribe(this.observer);
                                    }
                                } catch (Throwable th2) {
                                    Exceptions.throwIfFatal(th2);
                                    this.f43300d.dispose();
                                    simpleQueue.clear();
                                    atomicThrowable.addThrowable(th2);
                                    observer.onError(atomicThrowable.terminate());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            Exceptions.throwIfFatal(th3);
                            this.f43300d.dispose();
                            atomicThrowable.addThrowable(th3);
                            observer.onError(atomicThrowable.terminate());
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class SourceObserver<T, U> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 8828587559905699186L;
        volatile boolean active;
        final Observer<? super U> actual;
        final int bufferSize;
        volatile boolean disposed;
        volatile boolean done;
        int fusionMode;
        final Observer<U> inner;
        final Function<? super T, ? extends ObservableSource<? extends U>> mapper;
        SimpleQueue<T> queue;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43301s;
        final SequentialDisposable sa = new SequentialDisposable();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static final class InnerObserver<U> implements Observer<U> {
            final Observer<? super U> actual;
            final SourceObserver<?, ?> parent;

            @Override // io.reactivex.Observer
            public void onComplete() {
                this.parent.innerComplete();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                this.parent.dispose();
                this.actual.onError(th);
            }

            @Override // io.reactivex.Observer
            public void onNext(U u5) {
                this.actual.onNext(u5);
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
                this.parent.innerSubscribe(disposable);
            }

            InnerObserver(Observer<? super U> observer, SourceObserver<?, ?> sourceObserver) {
                this.actual = observer;
                this.parent = sourceObserver;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.disposed = true;
            this.sa.dispose();
            this.f43301s.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        void innerComplete() {
            this.active = false;
            drain();
        }

        void innerSubscribe(Disposable disposable) {
            this.sa.update(disposable);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
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
                return;
            }
            this.done = true;
            dispose();
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            if (this.done) {
                return;
            }
            if (this.fusionMode == 0) {
                this.queue.offer(t5);
            }
            drain();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43301s, disposable)) {
                this.f43301s = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(3);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = queueDisposable;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        drain();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = queueDisposable;
                        this.actual.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new SpscLinkedArrayQueue(this.bufferSize);
                this.actual.onSubscribe(this);
            }
        }

        SourceObserver(Observer<? super U> observer, Function<? super T, ? extends ObservableSource<? extends U>> function, int i6) {
            this.actual = observer;
            this.mapper = function;
            this.bufferSize = i6;
            this.inner = new InnerObserver(observer, this);
        }

        void drain() {
            boolean z5;
            if (getAndIncrement() == 0) {
                while (!this.disposed) {
                    if (!this.active) {
                        boolean z6 = this.done;
                        try {
                            T poll = this.queue.poll();
                            if (poll == null) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            if (z6 && z5) {
                                this.actual.onComplete();
                                return;
                            }
                            if (!z5) {
                                try {
                                    ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.mapper.apply(poll), "The mapper returned a null ObservableSource");
                                    this.active = true;
                                    observableSource.subscribe(this.inner);
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    dispose();
                                    this.queue.clear();
                                    this.actual.onError(th);
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            dispose();
                            this.queue.clear();
                            this.actual.onError(th2);
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                this.queue.clear();
            }
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super U> observer) {
        if (ObservableScalarXMap.tryScalarXMapSubscribe(this.source, observer, this.mapper)) {
            return;
        }
        if (this.delayErrors == ErrorMode.IMMEDIATE) {
            this.source.subscribe(new SourceObserver(new SerializedObserver(observer), this.mapper, this.bufferSize));
        } else {
            this.source.subscribe(new ConcatMapDelayErrorObserver(observer, this.mapper, this.bufferSize, this.delayErrors == ErrorMode.END));
        }
    }

    public ObservableConcatMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends U>> function, int i6, ErrorMode errorMode) {
        super(observableSource);
        this.mapper = function;
        this.delayErrors = errorMode;
        this.bufferSize = Math.max(8, i6);
    }
}
