package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableBuffer<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {
    final Callable<U> bufferSupplier;
    final int count;
    final int skip;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class BufferExactObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {
        final Observer<? super U> actual;
        U buffer;
        final Callable<U> bufferSupplier;
        final int count;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43285s;
        int size;

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.buffer = null;
            this.actual.onError(th);
        }

        boolean createBuffer() {
            try {
                this.buffer = (U) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "Empty buffer supplied");
                return true;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.buffer = null;
                Disposable disposable = this.f43285s;
                if (disposable == null) {
                    EmptyDisposable.error(th, this.actual);
                    return false;
                }
                disposable.dispose();
                this.actual.onError(th);
                return false;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f43285s.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f43285s.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            U u5 = this.buffer;
            this.buffer = null;
            if (u5 != null && !u5.isEmpty()) {
                this.actual.onNext(u5);
            }
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            U u5 = this.buffer;
            if (u5 != null) {
                u5.add(t5);
                int i6 = this.size + 1;
                this.size = i6;
                if (i6 >= this.count) {
                    this.actual.onNext(u5);
                    this.size = 0;
                    createBuffer();
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43285s, disposable)) {
                this.f43285s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        BufferExactObserver(Observer<? super U> observer, int i6, Callable<U> callable) {
            this.actual = observer;
            this.count = i6;
            this.bufferSupplier = callable;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class BufferSkipObserver<T, U extends Collection<? super T>> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = -8223395059921494546L;
        final Observer<? super U> actual;
        final Callable<U> bufferSupplier;
        final ArrayDeque<U> buffers = new ArrayDeque<>();
        final int count;
        long index;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43286s;
        final int skip;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f43286s.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f43286s.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            while (!this.buffers.isEmpty()) {
                this.actual.onNext(this.buffers.poll());
            }
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.buffers.clear();
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            long j6 = this.index;
            this.index = 1 + j6;
            if (j6 % this.skip == 0) {
                try {
                    this.buffers.offer((Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources."));
                } catch (Throwable th) {
                    this.buffers.clear();
                    this.f43286s.dispose();
                    this.actual.onError(th);
                    return;
                }
            }
            Iterator<U> it = this.buffers.iterator();
            while (it.hasNext()) {
                U next = it.next();
                next.add(t5);
                if (this.count <= next.size()) {
                    it.remove();
                    this.actual.onNext(next);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43286s, disposable)) {
                this.f43286s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        BufferSkipObserver(Observer<? super U> observer, int i6, int i7, Callable<U> callable) {
            this.actual = observer;
            this.count = i6;
            this.skip = i7;
            this.bufferSupplier = callable;
        }
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super U> observer) {
        int i6 = this.skip;
        int i7 = this.count;
        if (i6 != i7) {
            this.source.subscribe(new BufferSkipObserver(observer, this.count, this.skip, this.bufferSupplier));
            return;
        }
        BufferExactObserver bufferExactObserver = new BufferExactObserver(observer, i7, this.bufferSupplier);
        if (bufferExactObserver.createBuffer()) {
            this.source.subscribe(bufferExactObserver);
        }
    }

    public ObservableBuffer(ObservableSource<T> observableSource, int i6, int i7, Callable<U> callable) {
        super(observableSource);
        this.count = i6;
        this.skip = i7;
        this.bufferSupplier = callable;
    }
}
