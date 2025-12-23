package io.reactivex.internal.operators.observable;

import androidx.camera.view.p;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableBufferBoundarySupplier<T, U extends Collection<? super T>, B> extends AbstractObservableWithUpstream<T, U> {
    final Callable<? extends ObservableSource<B>> boundarySupplier;
    final Callable<U> bufferSupplier;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class BufferBoundaryObserver<T, U extends Collection<? super T>, B> extends DisposableObserver<B> {
        boolean once;
        final BufferBoundarySupplierObserver<T, U, B> parent;

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.once) {
                return;
            }
            this.once = true;
            this.parent.next();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.once) {
                RxJavaPlugins.onError(th);
            } else {
                this.once = true;
                this.parent.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(B b6) {
            if (this.once) {
                return;
            }
            this.once = true;
            dispose();
            this.parent.next();
        }

        BufferBoundaryObserver(BufferBoundarySupplierObserver<T, U, B> bufferBoundarySupplierObserver) {
            this.parent = bufferBoundarySupplierObserver;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class BufferBoundarySupplierObserver<T, U extends Collection<? super T>, B> extends QueueDrainObserver<T, U, U> implements Observer<T>, Disposable {
        final Callable<? extends ObservableSource<B>> boundarySupplier;
        U buffer;
        final Callable<U> bufferSupplier;
        final AtomicReference<Disposable> other;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43288s;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        public /* bridge */ /* synthetic */ void accept(Observer observer, Object obj) {
            accept((Observer<? super Observer>) observer, (Observer) obj);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
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
                        QueueDrainHelper.drainLoop(this.queue, this.actual, false, this, this);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
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

        BufferBoundarySupplierObserver(Observer<? super U> observer, Callable<U> callable, Callable<? extends ObservableSource<B>> callable2) {
            super(observer, new MpscLinkedQueue());
            this.other = new AtomicReference<>();
            this.bufferSupplier = callable;
            this.boundarySupplier = callable2;
        }

        public void accept(Observer<? super U> observer, U u5) {
            this.actual.onNext(u5);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f43288s.dispose();
            disposeOther();
            if (enter()) {
                this.queue.clear();
            }
        }

        void disposeOther() {
            DisposableHelper.dispose(this.other);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        void next() {
            try {
                U u5 = (U) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The buffer supplied is null");
                try {
                    ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.boundarySupplier.call(), "The boundary publisher supplied is null");
                    BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(this);
                    if (p.a(this.other, this.other.get(), bufferBoundaryObserver)) {
                        synchronized (this) {
                            try {
                                U u6 = this.buffer;
                                if (u6 == null) {
                                    return;
                                }
                                this.buffer = u5;
                                observableSource.subscribe(bufferBoundaryObserver);
                                fastPathEmit(u6, false, this);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.cancelled = true;
                    this.f43288s.dispose();
                    this.actual.onError(th2);
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                dispose();
                this.actual.onError(th3);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43288s, disposable)) {
                this.f43288s = disposable;
                Observer<? super V> observer = this.actual;
                try {
                    this.buffer = (U) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The buffer supplied is null");
                    try {
                        ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.boundarySupplier.call(), "The boundary publisher supplied is null");
                        BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(this);
                        this.other.set(bufferBoundaryObserver);
                        observer.onSubscribe(this);
                        if (this.cancelled) {
                            return;
                        }
                        observableSource.subscribe(bufferBoundaryObserver);
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.cancelled = true;
                        disposable.dispose();
                        EmptyDisposable.error(th, observer);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.cancelled = true;
                    disposable.dispose();
                    EmptyDisposable.error(th2, observer);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            dispose();
            this.actual.onError(th);
        }
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super U> observer) {
        this.source.subscribe(new BufferBoundarySupplierObserver(new SerializedObserver(observer), this.bufferSupplier, this.boundarySupplier));
    }

    public ObservableBufferBoundarySupplier(ObservableSource<T> observableSource, Callable<? extends ObservableSource<B>> callable, Callable<U> callable2) {
        super(observableSource);
        this.boundarySupplier = callable;
        this.bufferSupplier = callable2;
    }
}
