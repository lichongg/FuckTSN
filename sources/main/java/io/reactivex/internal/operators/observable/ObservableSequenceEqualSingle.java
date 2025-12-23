package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableSequenceEqualSingle<T> extends Single<Boolean> implements FuseToObservable<Boolean> {
    final int bufferSize;
    final BiPredicate<? super T, ? super T> comparer;
    final ObservableSource<? extends T> first;
    final ObservableSource<? extends T> second;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class EqualCoordinator<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = -6178010334400373240L;
        final SingleObserver<? super Boolean> actual;
        volatile boolean cancelled;
        final BiPredicate<? super T, ? super T> comparer;
        final ObservableSource<? extends T> first;
        final EqualObserver<T>[] observers;
        final ArrayCompositeDisposable resources = new ArrayCompositeDisposable(2);
        final ObservableSource<? extends T> second;

        /* renamed from: v1, reason: collision with root package name */
        T f43342v1;

        /* renamed from: v2, reason: collision with root package name */
        T f43343v2;

        void cancel(SpscLinkedArrayQueue<T> spscLinkedArrayQueue, SpscLinkedArrayQueue<T> spscLinkedArrayQueue2) {
            this.cancelled = true;
            spscLinkedArrayQueue.clear();
            spscLinkedArrayQueue2.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.resources.dispose();
            if (getAndIncrement() == 0) {
                EqualObserver<T>[] equalObserverArr = this.observers;
                equalObserverArr[0].queue.clear();
                equalObserverArr[1].queue.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        boolean setDisposable(Disposable disposable, int i6) {
            return this.resources.setResource(i6, disposable);
        }

        void subscribe() {
            EqualObserver<T>[] equalObserverArr = this.observers;
            this.first.subscribe(equalObserverArr[0]);
            this.second.subscribe(equalObserverArr[1]);
        }

        EqualCoordinator(SingleObserver<? super Boolean> singleObserver, int i6, ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate) {
            this.actual = singleObserver;
            this.first = observableSource;
            this.second = observableSource2;
            this.comparer = biPredicate;
            this.observers = new EqualObserver[]{new EqualObserver<>(this, 0, i6), new EqualObserver<>(this, 1, i6)};
        }

        void drain() {
            boolean z5;
            boolean z6;
            Throwable th;
            Throwable th2;
            if (getAndIncrement() == 0) {
                EqualObserver<T>[] equalObserverArr = this.observers;
                EqualObserver<T> equalObserver = equalObserverArr[0];
                SpscLinkedArrayQueue<T> spscLinkedArrayQueue = equalObserver.queue;
                EqualObserver<T> equalObserver2 = equalObserverArr[1];
                SpscLinkedArrayQueue<T> spscLinkedArrayQueue2 = equalObserver2.queue;
                int i6 = 1;
                while (!this.cancelled) {
                    boolean z7 = equalObserver.done;
                    if (z7 && (th2 = equalObserver.error) != null) {
                        cancel(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                        this.actual.onError(th2);
                        return;
                    }
                    boolean z8 = equalObserver2.done;
                    if (z8 && (th = equalObserver2.error) != null) {
                        cancel(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                        this.actual.onError(th);
                        return;
                    }
                    if (this.f43342v1 == null) {
                        this.f43342v1 = spscLinkedArrayQueue.poll();
                    }
                    if (this.f43342v1 == null) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (this.f43343v2 == null) {
                        this.f43343v2 = spscLinkedArrayQueue2.poll();
                    }
                    T t5 = this.f43343v2;
                    if (t5 == null) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (z7 && z8 && z5 && z6) {
                        this.actual.onSuccess(Boolean.TRUE);
                        return;
                    }
                    if (z7 && z8 && z5 != z6) {
                        cancel(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                        this.actual.onSuccess(Boolean.FALSE);
                        return;
                    }
                    if (!z5 && !z6) {
                        try {
                            if (!this.comparer.test(this.f43342v1, t5)) {
                                cancel(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                                this.actual.onSuccess(Boolean.FALSE);
                                return;
                            } else {
                                this.f43342v1 = null;
                                this.f43343v2 = null;
                            }
                        } catch (Throwable th3) {
                            Exceptions.throwIfFatal(th3);
                            cancel(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                            this.actual.onError(th3);
                            return;
                        }
                    }
                    if (z5 || z6) {
                        i6 = addAndGet(-i6);
                        if (i6 == 0) {
                            return;
                        }
                    }
                }
                spscLinkedArrayQueue.clear();
                spscLinkedArrayQueue2.clear();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class EqualObserver<T> implements Observer<T> {
        volatile boolean done;
        Throwable error;
        final int index;
        final EqualCoordinator<T> parent;
        final SpscLinkedArrayQueue<T> queue;

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            this.parent.drain();
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
            this.parent.setDisposable(disposable, this.index);
        }

        EqualObserver(EqualCoordinator<T> equalCoordinator, int i6, int i7) {
            this.parent = equalCoordinator;
            this.index = i6;
            this.queue = new SpscLinkedArrayQueue<>(i7);
        }
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public Observable<Boolean> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableSequenceEqual(this.first, this.second, this.comparer, this.bufferSize));
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(singleObserver, this.bufferSize, this.first, this.second, this.comparer);
        singleObserver.onSubscribe(equalCoordinator);
        equalCoordinator.subscribe();
    }

    public ObservableSequenceEqualSingle(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate, int i6) {
        this.first = observableSource;
        this.second = observableSource2;
        this.comparer = biPredicate;
        this.bufferSize = i6;
    }
}
