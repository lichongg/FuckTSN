package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends AbstractObservableWithUpstream<T, U> {
    final Function<? super Open, ? extends ObservableSource<? extends Close>> bufferClose;
    final ObservableSource<? extends Open> bufferOpen;
    final Callable<U> bufferSupplier;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class BufferBoundaryObserver<T, U extends Collection<? super T>, Open, Close> extends QueueDrainObserver<T, U, U> implements Disposable {
        final Function<? super Open, ? extends ObservableSource<? extends Close>> bufferClose;
        final ObservableSource<? extends Open> bufferOpen;
        final Callable<U> bufferSupplier;
        final List<U> buffers;
        final CompositeDisposable resources;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43287s;
        final AtomicInteger windows;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        public /* bridge */ /* synthetic */ void accept(Observer observer, Object obj) {
            accept((Observer<? super Observer>) observer, (Observer) obj);
        }

        void close(U u5, Disposable disposable) {
            boolean remove;
            synchronized (this) {
                remove = this.buffers.remove(u5);
            }
            if (remove) {
                fastPathOrderedEmit(u5, false, this);
            }
            if (this.resources.remove(disposable) && this.windows.decrementAndGet() == 0) {
                complete();
            }
        }

        void complete() {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.buffers);
                this.buffers.clear();
            }
            SimpleQueue<U> simpleQueue = this.queue;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                simpleQueue.offer((Collection) it.next());
            }
            this.done = true;
            if (enter()) {
                QueueDrainHelper.drainLoop(simpleQueue, this.actual, false, this, this);
            }
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

        BufferBoundaryObserver(Observer<? super U> observer, ObservableSource<? extends Open> observableSource, Function<? super Open, ? extends ObservableSource<? extends Close>> function, Callable<U> callable) {
            super(observer, new MpscLinkedQueue());
            this.windows = new AtomicInteger();
            this.bufferOpen = observableSource;
            this.bufferClose = function;
            this.bufferSupplier = callable;
            this.buffers = new LinkedList();
            this.resources = new CompositeDisposable();
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
            this.resources.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.windows.decrementAndGet() == 0) {
                complete();
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43287s, disposable)) {
                this.f43287s = disposable;
                BufferOpenObserver bufferOpenObserver = new BufferOpenObserver(this);
                this.resources.add(bufferOpenObserver);
                this.actual.onSubscribe(this);
                this.windows.lazySet(1);
                this.bufferOpen.subscribe(bufferOpenObserver);
            }
        }

        void open(Open open) {
            if (this.cancelled) {
                return;
            }
            try {
                Collection collection = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The buffer supplied is null");
                try {
                    ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.bufferClose.apply(open), "The buffer closing Observable is null");
                    if (this.cancelled) {
                        return;
                    }
                    synchronized (this) {
                        try {
                            if (this.cancelled) {
                                return;
                            }
                            this.buffers.add(collection);
                            BufferCloseObserver bufferCloseObserver = new BufferCloseObserver(collection, this);
                            this.resources.add(bufferCloseObserver);
                            this.windows.getAndIncrement();
                            observableSource.subscribe(bufferCloseObserver);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    onError(th2);
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                onError(th3);
            }
        }

        void openFinished(Disposable disposable) {
            if (this.resources.remove(disposable) && this.windows.decrementAndGet() == 0) {
                complete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            dispose();
            this.cancelled = true;
            synchronized (this) {
                this.buffers.clear();
            }
            this.actual.onError(th);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class BufferCloseObserver<T, U extends Collection<? super T>, Open, Close> extends DisposableObserver<Close> {
        boolean done;
        final BufferBoundaryObserver<T, U, Open, Close> parent;
        final U value;

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.parent.close(this.value, this);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
            } else {
                this.parent.onError(th);
            }
        }

        BufferCloseObserver(U u5, BufferBoundaryObserver<T, U, Open, Close> bufferBoundaryObserver) {
            this.parent = bufferBoundaryObserver;
            this.value = u5;
        }

        @Override // io.reactivex.Observer
        public void onNext(Close close) {
            onComplete();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class BufferOpenObserver<T, U extends Collection<? super T>, Open, Close> extends DisposableObserver<Open> {
        boolean done;
        final BufferBoundaryObserver<T, U, Open, Close> parent;

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.parent.openFinished(this);
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
        public void onNext(Open open) {
            if (this.done) {
                return;
            }
            this.parent.open(open);
        }

        BufferOpenObserver(BufferBoundaryObserver<T, U, Open, Close> bufferBoundaryObserver) {
            this.parent = bufferBoundaryObserver;
        }
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super U> observer) {
        this.source.subscribe(new BufferBoundaryObserver(new SerializedObserver(observer), this.bufferOpen, this.bufferClose, this.bufferSupplier));
    }

    public ObservableBufferBoundary(ObservableSource<T> observableSource, ObservableSource<? extends Open> observableSource2, Function<? super Open, ? extends ObservableSource<? extends Close>> function, Callable<U> callable) {
        super(observableSource);
        this.bufferOpen = observableSource2;
        this.bufferClose = function;
        this.bufferSupplier = callable;
    }
}
