package io.reactivex.internal.operators.observable;

import defpackage.H5BaseWebChromeClient;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.InnerQueuedObserver;
import io.reactivex.internal.observers.InnerQueuedObserverSupport;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableConcatMapEager<T, R> extends AbstractObservableWithUpstream<T, R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
    final int maxConcurrency;
    final int prefetch;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ConcatMapEagerMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable, InnerQueuedObserverSupport<R> {
        private static final long serialVersionUID = 8080567949447303262L;
        int activeCount;
        final Observer<? super R> actual;
        volatile boolean cancelled;
        InnerQueuedObserver<R> current;

        /* renamed from: d, reason: collision with root package name */
        Disposable f43302d;
        volatile boolean done;
        final ErrorMode errorMode;
        final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
        final int maxConcurrency;
        final int prefetch;
        SimpleQueue<T> queue;
        int sourceMode;
        final AtomicThrowable error = new AtomicThrowable();
        final ArrayDeque<InnerQueuedObserver<R>> observers = new ArrayDeque<>();

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
            if (getAndIncrement() == 0) {
                this.queue.clear();
                disposeAll();
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            drain();
        }

        void disposeAll() {
            InnerQueuedObserver<R> innerQueuedObserver = this.current;
            if (innerQueuedObserver != null) {
                innerQueuedObserver.dispose();
            }
            while (true) {
                InnerQueuedObserver<R> poll = this.observers.poll();
                if (poll == null) {
                    return;
                } else {
                    poll.dispose();
                }
            }
        }

        @Override // io.reactivex.internal.observers.InnerQueuedObserverSupport
        public void innerError(InnerQueuedObserver<R> innerQueuedObserver, Throwable th) {
            if (!this.error.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (this.errorMode == ErrorMode.IMMEDIATE) {
                this.f43302d.dispose();
            }
            innerQueuedObserver.setDone();
            drain();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
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
            if (DisposableHelper.validate(this.f43302d, disposable)) {
                this.f43302d = disposable;
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
                this.queue = QueueDrainHelper.createQueue(this.prefetch);
                this.actual.onSubscribe(this);
            }
        }

        ConcatMapEagerMainObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, int i6, int i7, ErrorMode errorMode) {
            this.actual = observer;
            this.mapper = function;
            this.maxConcurrency = i6;
            this.prefetch = i7;
            this.errorMode = errorMode;
        }

        @Override // io.reactivex.internal.observers.InnerQueuedObserverSupport
        public void drain() {
            R poll;
            boolean z5;
            boolean z6;
            if (getAndIncrement() == 0) {
                SimpleQueue<T> simpleQueue = this.queue;
                ArrayDeque<InnerQueuedObserver<R>> arrayDeque = this.observers;
                Observer<? super R> observer = this.actual;
                ErrorMode errorMode = this.errorMode;
                int i6 = 1;
                while (true) {
                    int i7 = this.activeCount;
                    while (i7 != this.maxConcurrency) {
                        if (this.cancelled) {
                            simpleQueue.clear();
                            disposeAll();
                            return;
                        }
                        if (errorMode == ErrorMode.IMMEDIATE && this.error.get() != null) {
                            simpleQueue.clear();
                            disposeAll();
                            observer.onError(this.error.terminate());
                            return;
                        }
                        try {
                            T poll2 = simpleQueue.poll();
                            if (poll2 == null) {
                                break;
                            }
                            ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.mapper.apply(poll2), "The mapper returned a null ObservableSource");
                            if (observableSource instanceof Callable) {
                                try {
                                    H5BaseWebChromeClient h5BaseWebChromeClient = (Object) ((Callable) observableSource).call();
                                    if (h5BaseWebChromeClient != null) {
                                        observer.onNext(h5BaseWebChromeClient);
                                    }
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    this.error.addThrowable(th);
                                }
                            } else {
                                InnerQueuedObserver<R> innerQueuedObserver = new InnerQueuedObserver<>(this, this.prefetch);
                                arrayDeque.offer(innerQueuedObserver);
                                observableSource.subscribe(innerQueuedObserver);
                                i7++;
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            this.f43302d.dispose();
                            simpleQueue.clear();
                            disposeAll();
                            this.error.addThrowable(th2);
                            observer.onError(this.error.terminate());
                            return;
                        }
                    }
                    this.activeCount = i7;
                    if (this.cancelled) {
                        simpleQueue.clear();
                        disposeAll();
                        return;
                    }
                    if (errorMode == ErrorMode.IMMEDIATE && this.error.get() != null) {
                        simpleQueue.clear();
                        disposeAll();
                        observer.onError(this.error.terminate());
                        return;
                    }
                    InnerQueuedObserver<R> innerQueuedObserver2 = this.current;
                    if (innerQueuedObserver2 == null) {
                        if (errorMode == ErrorMode.BOUNDARY && this.error.get() != null) {
                            simpleQueue.clear();
                            disposeAll();
                            observer.onError(this.error.terminate());
                            return;
                        }
                        boolean z7 = this.done;
                        InnerQueuedObserver<R> poll3 = arrayDeque.poll();
                        if (poll3 == null) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (z7 && z6) {
                            if (this.error.get() != null) {
                                simpleQueue.clear();
                                disposeAll();
                                observer.onError(this.error.terminate());
                                return;
                            }
                            observer.onComplete();
                            return;
                        }
                        if (!z6) {
                            this.current = poll3;
                        }
                        innerQueuedObserver2 = poll3;
                    }
                    if (innerQueuedObserver2 != null) {
                        SimpleQueue<R> queue = innerQueuedObserver2.queue();
                        while (!this.cancelled) {
                            boolean isDone = innerQueuedObserver2.isDone();
                            if (errorMode == ErrorMode.IMMEDIATE && this.error.get() != null) {
                                simpleQueue.clear();
                                disposeAll();
                                observer.onError(this.error.terminate());
                                return;
                            }
                            try {
                                poll = queue.poll();
                                if (poll == null) {
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                            } catch (Throwable th3) {
                                Exceptions.throwIfFatal(th3);
                                this.error.addThrowable(th3);
                                this.current = null;
                                this.activeCount--;
                            }
                            if (isDone && z5) {
                                this.current = null;
                                this.activeCount--;
                            } else if (!z5) {
                                observer.onNext(poll);
                            }
                        }
                        simpleQueue.clear();
                        disposeAll();
                        return;
                    }
                    i6 = addAndGet(-i6);
                    if (i6 == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.internal.observers.InnerQueuedObserverSupport
        public void innerComplete(InnerQueuedObserver<R> innerQueuedObserver) {
            innerQueuedObserver.setDone();
            drain();
        }

        @Override // io.reactivex.internal.observers.InnerQueuedObserverSupport
        public void innerNext(InnerQueuedObserver<R> innerQueuedObserver, R r5) {
            innerQueuedObserver.queue().offer(r5);
            drain();
        }
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super R> observer) {
        this.source.subscribe(new ConcatMapEagerMainObserver(observer, this.mapper, this.maxConcurrency, this.prefetch, this.errorMode));
    }

    public ObservableConcatMapEager(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends R>> function, ErrorMode errorMode, int i6, int i7) {
        super(observableSource);
        this.mapper = function;
        this.errorMode = errorMode;
        this.maxConcurrency = i6;
        this.prefetch = i7;
    }
}
