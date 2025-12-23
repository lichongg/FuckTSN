package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableWithLatestFromMany<T, R> extends AbstractObservableWithUpstream<T, R> {
    final Function<? super Object[], R> combiner;
    final ObservableSource<?>[] otherArray;
    final Iterable<? extends ObservableSource<?>> otherIterable;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class WithLatestFromObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 1577321883966341961L;
        final Observer<? super R> actual;
        final Function<? super Object[], R> combiner;

        /* renamed from: d, reason: collision with root package name */
        final AtomicReference<Disposable> f43383d;
        volatile boolean done;
        final AtomicThrowable error;
        final WithLatestInnerObserver[] observers;
        final AtomicReferenceArray<Object> values;

        void innerError(int i6, Throwable th) {
            this.done = true;
            DisposableHelper.dispose(this.f43383d);
            cancelAllBut(i6);
            HalfSerializer.onError(this.actual, th, this, this.error);
        }

        void cancelAllBut(int i6) {
            WithLatestInnerObserver[] withLatestInnerObserverArr = this.observers;
            for (int i7 = 0; i7 < withLatestInnerObserverArr.length; i7++) {
                if (i7 != i6) {
                    withLatestInnerObserverArr[i7].dispose();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.f43383d);
            for (WithLatestInnerObserver withLatestInnerObserver : this.observers) {
                withLatestInnerObserver.dispose();
            }
        }

        void innerComplete(int i6, boolean z5) {
            if (z5) {
                return;
            }
            this.done = true;
            cancelAllBut(i6);
            HalfSerializer.onComplete(this.actual, this, this.error);
        }

        void innerNext(int i6, Object obj) {
            this.values.set(i6, obj);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f43383d.get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            cancelAllBut(-1);
            HalfSerializer.onComplete(this.actual, this, this.error);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            cancelAllBut(-1);
            HalfSerializer.onError(this.actual, th, this, this.error);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            if (this.done) {
                return;
            }
            AtomicReferenceArray<Object> atomicReferenceArray = this.values;
            int length = atomicReferenceArray.length();
            Object[] objArr = new Object[length + 1];
            int i6 = 0;
            objArr[0] = t5;
            while (i6 < length) {
                Object obj = atomicReferenceArray.get(i6);
                if (obj == null) {
                    return;
                }
                i6++;
                objArr[i6] = obj;
            }
            try {
                HalfSerializer.onNext(this.actual, ObjectHelper.requireNonNull(this.combiner.apply(objArr), "combiner returned a null value"), this, this.error);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f43383d, disposable);
        }

        void subscribe(ObservableSource<?>[] observableSourceArr, int i6) {
            WithLatestInnerObserver[] withLatestInnerObserverArr = this.observers;
            AtomicReference<Disposable> atomicReference = this.f43383d;
            for (int i7 = 0; i7 < i6 && !DisposableHelper.isDisposed(atomicReference.get()) && !this.done; i7++) {
                observableSourceArr[i7].subscribe(withLatestInnerObserverArr[i7]);
            }
        }

        WithLatestFromObserver(Observer<? super R> observer, Function<? super Object[], R> function, int i6) {
            this.actual = observer;
            this.combiner = function;
            WithLatestInnerObserver[] withLatestInnerObserverArr = new WithLatestInnerObserver[i6];
            for (int i7 = 0; i7 < i6; i7++) {
                withLatestInnerObserverArr[i7] = new WithLatestInnerObserver(this, i7);
            }
            this.observers = withLatestInnerObserverArr;
            this.values = new AtomicReferenceArray<>(i6);
            this.f43383d = new AtomicReference<>();
            this.error = new AtomicThrowable();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class WithLatestInnerObserver extends AtomicReference<Disposable> implements Observer<Object> {
        private static final long serialVersionUID = 3256684027868224024L;
        boolean hasValue;
        final int index;
        final WithLatestFromObserver<?, ?> parent;

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.parent.innerComplete(this.index, this.hasValue);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.parent.innerError(this.index, th);
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            if (!this.hasValue) {
                this.hasValue = true;
            }
            this.parent.innerNext(this.index, obj);
        }

        WithLatestInnerObserver(WithLatestFromObserver<?, ?> withLatestFromObserver, int i6) {
            this.parent = withLatestFromObserver;
            this.index = i6;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public ObservableWithLatestFromMany(ObservableSource<T> observableSource, ObservableSource<?>[] observableSourceArr, Function<? super Object[], R> function) {
        super(observableSource);
        this.otherArray = observableSourceArr;
        this.otherIterable = null;
        this.combiner = function;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super R> observer) {
        int length;
        ObservableSource<?>[] observableSourceArr = this.otherArray;
        if (observableSourceArr == null) {
            observableSourceArr = new ObservableSource[8];
            try {
                length = 0;
                for (ObservableSource<?> observableSource : this.otherIterable) {
                    if (length == observableSourceArr.length) {
                        observableSourceArr = (ObservableSource[]) Arrays.copyOf(observableSourceArr, (length >> 1) + length);
                    }
                    int i6 = length + 1;
                    observableSourceArr[length] = observableSource;
                    length = i6;
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, observer);
                return;
            }
        } else {
            length = observableSourceArr.length;
        }
        if (length == 0) {
            new ObservableMap(this.source, new Function<T, R>() { // from class: io.reactivex.internal.operators.observable.ObservableWithLatestFromMany.1
                /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
                @Override // io.reactivex.functions.Function
                public R apply(T t5) throws Exception {
                    return ObservableWithLatestFromMany.this.combiner.apply(new Object[]{t5});
                }
            }).subscribeActual(observer);
            return;
        }
        WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver(observer, this.combiner, length);
        observer.onSubscribe(withLatestFromObserver);
        withLatestFromObserver.subscribe(observableSourceArr, length);
        this.source.subscribe(withLatestFromObserver);
    }

    public ObservableWithLatestFromMany(ObservableSource<T> observableSource, Iterable<? extends ObservableSource<?>> iterable, Function<? super Object[], R> function) {
        super(observableSource);
        this.otherArray = null;
        this.otherIterable = iterable;
        this.combiner = function;
    }
}
