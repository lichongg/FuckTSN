package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableCombineLatest<T, R> extends Observable<R> {
    final int bufferSize;
    final Function<? super Object[], ? extends R> combiner;
    final boolean delayError;
    final ObservableSource<? extends T>[] sources;
    final Iterable<? extends ObservableSource<? extends T>> sourcesIterable;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class CombinerObserver<T, R> implements Observer<T> {
        final int index;
        final LatestCoordinator<T, R> parent;

        /* renamed from: s, reason: collision with root package name */
        final AtomicReference<Disposable> f43299s = new AtomicReference<>();

        public void dispose() {
            DisposableHelper.dispose(this.f43299s);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.parent.combine(null, this.index);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.parent.onError(th);
            this.parent.combine(null, this.index);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            this.parent.combine(t5, this.index);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f43299s, disposable);
        }

        CombinerObserver(LatestCoordinator<T, R> latestCoordinator, int i6) {
            this.parent = latestCoordinator;
            this.index = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class LatestCoordinator<T, R> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 8567835998786448817L;
        int active;
        final Observer<? super R> actual;
        volatile boolean cancelled;
        final Function<? super Object[], ? extends R> combiner;
        int complete;
        final boolean delayError;
        volatile boolean done;
        final AtomicThrowable errors = new AtomicThrowable();
        final T[] latest;
        final CombinerObserver<T, R>[] observers;
        final SpscLinkedArrayQueue<Object> queue;

        void clear(SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            synchronized (this) {
                Arrays.fill(this.latest, (Object) null);
            }
            spscLinkedArrayQueue.clear();
        }

        boolean checkTerminated(boolean z5, boolean z6, Observer<?> observer, SpscLinkedArrayQueue<?> spscLinkedArrayQueue, boolean z7) {
            if (this.cancelled) {
                cancel(spscLinkedArrayQueue);
                return true;
            }
            if (!z5) {
                return false;
            }
            if (z7) {
                if (!z6) {
                    return false;
                }
                clear(this.queue);
                Throwable terminate = this.errors.terminate();
                if (terminate != null) {
                    observer.onError(terminate);
                } else {
                    observer.onComplete();
                }
                return true;
            }
            if (this.errors.get() != null) {
                cancel(spscLinkedArrayQueue);
                observer.onError(this.errors.terminate());
                return true;
            }
            if (!z6) {
                return false;
            }
            clear(this.queue);
            observer.onComplete();
            return true;
        }

        void combine(T t5, int i6) {
            CombinerObserver<T, R> combinerObserver = this.observers[i6];
            synchronized (this) {
                try {
                    if (this.cancelled) {
                        return;
                    }
                    T[] tArr = this.latest;
                    int length = tArr.length;
                    T t6 = tArr[i6];
                    int i7 = this.active;
                    if (t6 == null) {
                        i7++;
                        this.active = i7;
                    }
                    int i8 = this.complete;
                    if (t5 == null) {
                        i8++;
                        this.complete = i8;
                    } else {
                        tArr[i6] = t5;
                    }
                    boolean z5 = i7 == length;
                    if (i8 != length && (t5 != null || t6 != null)) {
                        if (t5 != null && z5) {
                            this.queue.offer(combinerObserver, tArr.clone());
                        } else if (t5 == null && this.errors.get() != null) {
                            this.done = true;
                        }
                        if (!z5 || t5 == null) {
                            drain();
                        }
                        return;
                    }
                    this.done = true;
                    if (z5) {
                    }
                    drain();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            if (getAndIncrement() == 0) {
                cancel(this.queue);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        void onError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public void subscribe(ObservableSource<? extends T>[] observableSourceArr) {
            CombinerObserver<T, R>[] combinerObserverArr = this.observers;
            int length = combinerObserverArr.length;
            for (int i6 = 0; i6 < length; i6++) {
                combinerObserverArr[i6] = new CombinerObserver<>(this, i6);
            }
            lazySet(0);
            this.actual.onSubscribe(this);
            for (int i7 = 0; i7 < length && !this.cancelled; i7++) {
                observableSourceArr[i7].subscribe(combinerObserverArr[i7]);
            }
        }

        LatestCoordinator(Observer<? super R> observer, Function<? super Object[], ? extends R> function, int i6, int i7, boolean z5) {
            this.actual = observer;
            this.combiner = function;
            this.delayError = z5;
            this.latest = (T[]) new Object[i6];
            this.observers = new CombinerObserver[i6];
            this.queue = new SpscLinkedArrayQueue<>(i7);
        }

        void cancel(SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            clear(spscLinkedArrayQueue);
            for (CombinerObserver<T, R> combinerObserver : this.observers) {
                combinerObserver.dispose();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x0034, code lost:
        
            r0 = addAndGet(-r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0039, code lost:
        
            if (r0 != 0) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drain() {
            /*
                r8 = this;
                int r0 = r8.getAndIncrement()
                if (r0 == 0) goto L8
                r1 = r8
                goto L3b
            L8:
                io.reactivex.internal.queue.SpscLinkedArrayQueue<java.lang.Object> r5 = r8.queue
                io.reactivex.Observer<? super R> r4 = r8.actual
                boolean r6 = r8.delayError
                r7 = 1
                r0 = 1
            L10:
                boolean r2 = r8.done
                boolean r3 = r5.isEmpty()
                r1 = r8
                boolean r2 = r1.checkTerminated(r2, r3, r4, r5, r6)
                if (r2 == 0) goto L1e
                goto L3b
            L1e:
                boolean r2 = r1.done
                java.lang.Object r3 = r5.poll()
                io.reactivex.internal.operators.observable.ObservableCombineLatest$CombinerObserver r3 = (io.reactivex.internal.operators.observable.ObservableCombineLatest.CombinerObserver) r3
                if (r3 != 0) goto L2a
                r3 = 1
                goto L2b
            L2a:
                r3 = 0
            L2b:
                boolean r2 = r1.checkTerminated(r2, r3, r4, r5, r6)
                if (r2 == 0) goto L32
                goto L3b
            L32:
                if (r3 == 0) goto L3c
                int r0 = -r0
                int r0 = r8.addAndGet(r0)
                if (r0 != 0) goto L10
            L3b:
                return
            L3c:
                java.lang.Object r2 = r5.poll()
                java.lang.Object[] r2 = (java.lang.Object[]) r2
                io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> r3 = r1.combiner     // Catch: java.lang.Throwable -> L52
                java.lang.Object r2 = r3.apply(r2)     // Catch: java.lang.Throwable -> L52
                java.lang.String r3 = "The combiner returned a null"
                java.lang.Object r2 = io.reactivex.internal.functions.ObjectHelper.requireNonNull(r2, r3)     // Catch: java.lang.Throwable -> L52
                r4.onNext(r2)
                goto L1e
            L52:
                r0 = move-exception
                io.reactivex.exceptions.Exceptions.throwIfFatal(r0)
                r1.cancelled = r7
                r8.cancel(r5)
                r4.onError(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest.LatestCoordinator.drain():void");
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
        int i6 = length;
        if (i6 == 0) {
            EmptyDisposable.complete(observer);
        } else {
            new LatestCoordinator(observer, this.combiner, i6, this.bufferSize, this.delayError).subscribe(observableSourceArr);
        }
    }

    public ObservableCombineLatest(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i6, boolean z5) {
        this.sources = observableSourceArr;
        this.sourcesIterable = iterable;
        this.combiner = function;
        this.bufferSize = i6;
        this.delayError = z5;
    }
}
