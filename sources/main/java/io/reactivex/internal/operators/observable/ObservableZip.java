package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableZip<T, R> extends Observable<R> {
    final int bufferSize;
    final boolean delayError;
    final ObservableSource<? extends T>[] sources;
    final Iterable<? extends ObservableSource<? extends T>> sourcesIterable;
    final Function<? super Object[], ? extends R> zipper;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ZipCoordinator<T, R> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 2983708048395377667L;
        final Observer<? super R> actual;
        volatile boolean cancelled;
        final boolean delayError;
        final ZipObserver<T, R>[] observers;
        final T[] row;
        final Function<? super Object[], ? extends R> zipper;

        boolean checkTerminated(boolean z5, boolean z6, Observer<? super R> observer, boolean z7, ZipObserver<?, ?> zipObserver) {
            if (this.cancelled) {
                clear();
                return true;
            }
            if (!z5) {
                return false;
            }
            if (z7) {
                if (!z6) {
                    return false;
                }
                Throwable th = zipObserver.error;
                clear();
                if (th != null) {
                    observer.onError(th);
                } else {
                    observer.onComplete();
                }
                return true;
            }
            Throwable th2 = zipObserver.error;
            if (th2 != null) {
                clear();
                observer.onError(th2);
                return true;
            }
            if (!z6) {
                return false;
            }
            clear();
            observer.onComplete();
            return true;
        }

        void clear() {
            for (ZipObserver<T, R> zipObserver : this.observers) {
                zipObserver.dispose();
                zipObserver.queue.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            if (getAndIncrement() == 0) {
                clear();
            }
        }

        public void drain() {
            Throwable th;
            if (getAndIncrement() != 0) {
                return;
            }
            ZipObserver<T, R>[] zipObserverArr = this.observers;
            Observer<? super R> observer = this.actual;
            T[] tArr = this.row;
            boolean z5 = this.delayError;
            int i6 = 1;
            while (true) {
                int i7 = 0;
                int i8 = 0;
                for (ZipObserver<T, R> zipObserver : zipObserverArr) {
                    if (tArr[i8] == null) {
                        boolean z6 = zipObserver.done;
                        T poll = zipObserver.queue.poll();
                        boolean z7 = poll == null;
                        if (checkTerminated(z6, z7, observer, z5, zipObserver)) {
                            return;
                        }
                        if (z7) {
                            i7++;
                        } else {
                            tArr[i8] = poll;
                        }
                    } else if (zipObserver.done && !z5 && (th = zipObserver.error) != null) {
                        clear();
                        observer.onError(th);
                        return;
                    }
                    i8++;
                }
                if (i7 != 0) {
                    i6 = addAndGet(-i6);
                    if (i6 == 0) {
                        return;
                    }
                } else {
                    try {
                        observer.onNext((Object) ObjectHelper.requireNonNull(this.zipper.apply(tArr.clone()), "The zipper returned a null value"));
                        Arrays.fill(tArr, (Object) null);
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        clear();
                        observer.onError(th2);
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        public void subscribe(ObservableSource<? extends T>[] observableSourceArr, int i6) {
            ZipObserver<T, R>[] zipObserverArr = this.observers;
            int length = zipObserverArr.length;
            for (int i7 = 0; i7 < length; i7++) {
                zipObserverArr[i7] = new ZipObserver<>(this, i6);
            }
            lazySet(0);
            this.actual.onSubscribe(this);
            for (int i8 = 0; i8 < length && !this.cancelled; i8++) {
                observableSourceArr[i8].subscribe(zipObserverArr[i8]);
            }
        }

        ZipCoordinator(Observer<? super R> observer, Function<? super Object[], ? extends R> function, int i6, boolean z5) {
            this.actual = observer;
            this.zipper = function;
            this.observers = new ZipObserver[i6];
            this.row = (T[]) new Object[i6];
            this.delayError = z5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ZipObserver<T, R> implements Observer<T> {
        volatile boolean done;
        Throwable error;
        final ZipCoordinator<T, R> parent;
        final SpscLinkedArrayQueue<T> queue;

        /* renamed from: s, reason: collision with root package name */
        final AtomicReference<Disposable> f43384s = new AtomicReference<>();

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        public void dispose() {
            DisposableHelper.dispose(this.f43384s);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            this.parent.drain();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            this.queue.offer(t5);
            this.parent.drain();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f43384s, disposable);
        }

        ZipObserver(ZipCoordinator<T, R> zipCoordinator, int i6) {
            this.parent = zipCoordinator;
            this.queue = new SpscLinkedArrayQueue<>(i6);
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> observer) {
        int length;
        ObservableSource<? extends T>[] observableSourceArr = this.sources;
        if (observableSourceArr == null) {
            observableSourceArr = new Observable[8];
            length = 0;
            for (ObservableSource<? extends T> observableSource : this.sourcesIterable) {
                if (length == observableSourceArr.length) {
                    ObservableSource<? extends T>[] observableSourceArr2 = new ObservableSource[(length >> 2) + length];
                    System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, length);
                    observableSourceArr = observableSourceArr2;
                }
                observableSourceArr[length] = observableSource;
                length++;
            }
        } else {
            length = observableSourceArr.length;
        }
        if (length == 0) {
            EmptyDisposable.complete(observer);
        } else {
            new ZipCoordinator(observer, this.zipper, length, this.delayError).subscribe(observableSourceArr, this.bufferSize);
        }
    }

    public ObservableZip(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i6, boolean z5) {
        this.sources = observableSourceArr;
        this.sourcesIterable = iterable;
        this.zipper = function;
        this.bufferSize = i6;
        this.delayError = z5;
    }
}
