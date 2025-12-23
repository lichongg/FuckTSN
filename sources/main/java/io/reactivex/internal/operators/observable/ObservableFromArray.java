package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicQueueDisposable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableFromArray<T> extends Observable<T> {
    final T[] array;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class FromArrayDisposable<T> extends BasicQueueDisposable<T> {
        final Observer<? super T> actual;
        final T[] array;
        volatile boolean disposed;
        boolean fusionMode;
        int index;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.disposed = true;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i6) {
            if ((i6 & 1) == 0) {
                return 0;
            }
            this.fusionMode = true;
            return 1;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.index = this.array.length;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.index == this.array.length;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() {
            int i6 = this.index;
            T[] tArr = this.array;
            if (i6 == tArr.length) {
                return null;
            }
            this.index = i6 + 1;
            return (T) ObjectHelper.requireNonNull(tArr[i6], "The array element is null");
        }

        void run() {
            T[] tArr = this.array;
            int length = tArr.length;
            for (int i6 = 0; i6 < length && !isDisposed(); i6++) {
                T t5 = tArr[i6];
                if (t5 == null) {
                    this.actual.onError(new NullPointerException("The " + i6 + "th element is null"));
                    return;
                }
                this.actual.onNext(t5);
            }
            if (isDisposed()) {
                return;
            }
            this.actual.onComplete();
        }

        FromArrayDisposable(Observer<? super T> observer, T[] tArr) {
            this.actual = observer;
            this.array = tArr;
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        FromArrayDisposable fromArrayDisposable = new FromArrayDisposable(observer, this.array);
        observer.onSubscribe(fromArrayDisposable);
        if (fromArrayDisposable.fusionMode) {
            return;
        }
        fromArrayDisposable.run();
    }

    public ObservableFromArray(T[] tArr) {
        this.array = tArr;
    }
}
