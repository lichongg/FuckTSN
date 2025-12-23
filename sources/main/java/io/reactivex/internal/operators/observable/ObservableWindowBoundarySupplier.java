package io.reactivex.internal.operators.observable;

import androidx.camera.view.p;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableWindowBoundarySupplier<T, B> extends AbstractObservableWithUpstream<T, Observable<T>> {
    final int bufferSize;
    final Callable<? extends ObservableSource<B>> other;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class WindowBoundaryInnerObserver<T, B> extends DisposableObserver<B> {
        boolean done;
        final WindowBoundaryMainObserver<T, B> parent;

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.parent.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
            } else {
                this.done = true;
                this.parent.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(B b6) {
            if (this.done) {
                return;
            }
            this.done = true;
            dispose();
            this.parent.next();
        }

        WindowBoundaryInnerObserver(WindowBoundaryMainObserver<T, B> windowBoundaryMainObserver) {
            this.parent = windowBoundaryMainObserver;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class WindowBoundaryMainObserver<T, B> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable {
        static final Object NEXT = new Object();
        final AtomicReference<Disposable> boundary;
        final int bufferSize;
        final Callable<? extends ObservableSource<B>> other;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43377s;
        UnicastSubject<T> window;
        final AtomicLong windows;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
        }

        WindowBoundaryMainObserver(Observer<? super Observable<T>> observer, Callable<? extends ObservableSource<B>> callable, int i6) {
            super(observer, new MpscLinkedQueue());
            this.boundary = new AtomicReference<>();
            AtomicLong atomicLong = new AtomicLong();
            this.windows = atomicLong;
            this.other = callable;
            this.bufferSize = i6;
            atomicLong.lazySet(1L);
        }

        /* JADX WARN: Multi-variable type inference failed */
        void drainLoop() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.queue;
            Observer<? super V> observer = this.actual;
            UnicastSubject<T> unicastSubject = this.window;
            int i6 = 1;
            while (true) {
                boolean z5 = this.done;
                Object poll = mpscLinkedQueue.poll();
                boolean z6 = poll == null;
                if (z5 && z6) {
                    DisposableHelper.dispose(this.boundary);
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
                } else if (poll == NEXT) {
                    unicastSubject.onComplete();
                    if (this.windows.decrementAndGet() == 0) {
                        DisposableHelper.dispose(this.boundary);
                        return;
                    }
                    if (this.cancelled) {
                        continue;
                    } else {
                        try {
                            ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.other.call(), "The ObservableSource supplied is null");
                            UnicastSubject<T> create = UnicastSubject.create(this.bufferSize);
                            this.windows.getAndIncrement();
                            this.window = create;
                            observer.onNext(create);
                            WindowBoundaryInnerObserver windowBoundaryInnerObserver = new WindowBoundaryInnerObserver(this);
                            AtomicReference<Disposable> atomicReference = this.boundary;
                            if (p.a(atomicReference, atomicReference.get(), windowBoundaryInnerObserver)) {
                                observableSource.subscribe(windowBoundaryInnerObserver);
                            }
                            unicastSubject = create;
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            DisposableHelper.dispose(this.boundary);
                            observer.onError(th2);
                            return;
                        }
                    }
                } else {
                    unicastSubject.onNext(NotificationLite.getValue(poll));
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        void next() {
            this.queue.offer(NEXT);
            if (enter()) {
                drainLoop();
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            if (this.windows.decrementAndGet() == 0) {
                DisposableHelper.dispose(this.boundary);
            }
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.error = th;
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            if (this.windows.decrementAndGet() == 0) {
                DisposableHelper.dispose(this.boundary);
            }
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43377s, disposable)) {
                this.f43377s = disposable;
                Observer<? super V> observer = this.actual;
                observer.onSubscribe(this);
                if (this.cancelled) {
                    return;
                }
                try {
                    ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.other.call(), "The first window ObservableSource supplied is null");
                    UnicastSubject<T> create = UnicastSubject.create(this.bufferSize);
                    this.window = create;
                    observer.onNext(create);
                    WindowBoundaryInnerObserver windowBoundaryInnerObserver = new WindowBoundaryInnerObserver(this);
                    if (p.a(this.boundary, null, windowBoundaryInnerObserver)) {
                        this.windows.getAndIncrement();
                        observableSource.subscribe(windowBoundaryInnerObserver);
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    disposable.dispose();
                    observer.onError(th);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
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
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Observable<T>> observer) {
        this.source.subscribe(new WindowBoundaryMainObserver(new SerializedObserver(observer), this.other, this.bufferSize));
    }

    public ObservableWindowBoundarySupplier(ObservableSource<T> observableSource, Callable<? extends ObservableSource<B>> callable, int i6) {
        super(observableSource);
        this.other = callable;
        this.bufferSize = i6;
    }
}
