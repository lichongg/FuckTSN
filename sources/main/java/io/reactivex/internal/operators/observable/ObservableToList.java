package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Collection;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableToList<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {
    final Callable<U> collectionSupplier;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ToListObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {
        final Observer<? super U> actual;
        U collection;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43367s;

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.collection = null;
            this.actual.onError(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f43367s.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f43367s.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            U u5 = this.collection;
            this.collection = null;
            this.actual.onNext(u5);
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            this.collection.add(t5);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43367s, disposable)) {
                this.f43367s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        ToListObserver(Observer<? super U> observer, U u5) {
            this.actual = observer;
            this.collection = u5;
        }
    }

    public ObservableToList(ObservableSource<T> observableSource, int i6) {
        super(observableSource);
        this.collectionSupplier = Functions.createArrayList(i6);
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super U> observer) {
        try {
            this.source.subscribe(new ToListObserver(observer, (Collection) ObjectHelper.requireNonNull(this.collectionSupplier.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, observer);
        }
    }

    public ObservableToList(ObservableSource<T> observableSource, Callable<U> callable) {
        super(observableSource);
        this.collectionSupplier = callable;
    }
}
