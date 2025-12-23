package io.reactivex.internal.operators.observable;

import androidx.camera.view.p;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableDebounce<T, U> extends AbstractObservableWithUpstream<T, T> {
    final Function<? super T, ? extends ObservableSource<U>> debounceSelector;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class DebounceObserver<T, U> implements Observer<T>, Disposable {
        final Observer<? super T> actual;
        final Function<? super T, ? extends ObservableSource<U>> debounceSelector;
        final AtomicReference<Disposable> debouncer = new AtomicReference<>();
        boolean done;
        volatile long index;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43305s;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static final class DebounceInnerObserver<T, U> extends DisposableObserver<U> {
            boolean done;
            final long index;
            final AtomicBoolean once = new AtomicBoolean();
            final DebounceObserver<T, U> parent;
            final T value;

            void emit() {
                if (this.once.compareAndSet(false, true)) {
                    this.parent.emit(this.index, this.value);
                }
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                if (this.done) {
                    return;
                }
                this.done = true;
                emit();
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
            public void onNext(U u5) {
                if (this.done) {
                    return;
                }
                this.done = true;
                dispose();
                emit();
            }

            DebounceInnerObserver(DebounceObserver<T, U> debounceObserver, long j6, T t5) {
                this.parent = debounceObserver;
                this.index = j6;
                this.value = t5;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f43305s.dispose();
            DisposableHelper.dispose(this.debouncer);
        }

        void emit(long j6, T t5) {
            if (j6 == this.index) {
                this.actual.onNext(t5);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f43305s.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            Disposable disposable = this.debouncer.get();
            if (disposable != DisposableHelper.DISPOSED) {
                ((DebounceInnerObserver) disposable).emit();
                DisposableHelper.dispose(this.debouncer);
                this.actual.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.debouncer);
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            if (this.done) {
                return;
            }
            long j6 = this.index + 1;
            this.index = j6;
            Disposable disposable = this.debouncer.get();
            if (disposable != null) {
                disposable.dispose();
            }
            try {
                ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.debounceSelector.apply(t5), "The publisher supplied is null");
                DebounceInnerObserver debounceInnerObserver = new DebounceInnerObserver(this, j6, t5);
                if (p.a(this.debouncer, disposable, debounceInnerObserver)) {
                    observableSource.subscribe(debounceInnerObserver);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                dispose();
                this.actual.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43305s, disposable)) {
                this.f43305s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        DebounceObserver(Observer<? super T> observer, Function<? super T, ? extends ObservableSource<U>> function) {
            this.actual = observer;
            this.debounceSelector = function;
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DebounceObserver(new SerializedObserver(observer), this.debounceSelector));
    }

    public ObservableDebounce(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<U>> function) {
        super(observableSource);
        this.debounceSelector = function;
    }
}
