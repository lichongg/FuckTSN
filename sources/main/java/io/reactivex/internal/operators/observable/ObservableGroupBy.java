package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.observables.GroupedObservable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableGroupBy<T, K, V> extends AbstractObservableWithUpstream<T, GroupedObservable<K, V>> {
    final int bufferSize;
    final boolean delayError;
    final Function<? super T, ? extends K> keySelector;
    final Function<? super T, ? extends V> valueSelector;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class GroupByObserver<T, K, V> extends AtomicInteger implements Observer<T>, Disposable {
        static final Object NULL_KEY = new Object();
        private static final long serialVersionUID = -3688291656102519502L;
        final Observer<? super GroupedObservable<K, V>> actual;
        final int bufferSize;
        final boolean delayError;
        final Function<? super T, ? extends K> keySelector;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43323s;
        final Function<? super T, ? extends V> valueSelector;
        final AtomicBoolean cancelled = new AtomicBoolean();
        final Map<Object, GroupedUnicast<K, V>> groups = new ConcurrentHashMap();

        public void cancel(K k6) {
            if (k6 == null) {
                k6 = (K) NULL_KEY;
            }
            this.groups.remove(k6);
            if (decrementAndGet() == 0) {
                this.f43323s.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled.compareAndSet(false, true) && decrementAndGet() == 0) {
                this.f43323s.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled.get();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            ArrayList arrayList = new ArrayList(this.groups.values());
            this.groups.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((GroupedUnicast) it.next()).onComplete();
            }
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            ArrayList arrayList = new ArrayList(this.groups.values());
            this.groups.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((GroupedUnicast) it.next()).onError(th);
            }
            this.actual.onError(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [java.util.Map, java.util.Map<java.lang.Object, io.reactivex.internal.operators.observable.ObservableGroupBy$GroupedUnicast<K, V>>] */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v3, types: [io.reactivex.internal.operators.observable.ObservableGroupBy$GroupedUnicast] */
        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            try {
                K apply = this.keySelector.apply(t5);
                Object obj = apply != null ? apply : NULL_KEY;
                GroupedUnicast<K, V> groupedUnicast = this.groups.get(obj);
                ?? r22 = groupedUnicast;
                if (groupedUnicast == false) {
                    if (this.cancelled.get()) {
                        return;
                    }
                    Object createWith = GroupedUnicast.createWith(apply, this.bufferSize, this, this.delayError);
                    this.groups.put(obj, createWith);
                    getAndIncrement();
                    this.actual.onNext(createWith);
                    r22 = createWith;
                }
                try {
                    r22.onNext(ObjectHelper.requireNonNull(this.valueSelector.apply(t5), "The value supplied is null"));
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.f43323s.dispose();
                    onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f43323s.dispose();
                onError(th2);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43323s, disposable)) {
                this.f43323s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public GroupByObserver(Observer<? super GroupedObservable<K, V>> observer, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i6, boolean z5) {
            this.actual = observer;
            this.keySelector = function;
            this.valueSelector = function2;
            this.bufferSize = i6;
            this.delayError = z5;
            lazySet(1);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class GroupedUnicast<K, T> extends GroupedObservable<K, T> {
        final State<T, K> state;

        public static <T, K> GroupedUnicast<K, T> createWith(K k6, int i6, GroupByObserver<?, K, T> groupByObserver, boolean z5) {
            return new GroupedUnicast<>(k6, new State(i6, groupByObserver, k6, z5));
        }

        public void onComplete() {
            this.state.onComplete();
        }

        public void onError(Throwable th) {
            this.state.onError(th);
        }

        public void onNext(T t5) {
            this.state.onNext(t5);
        }

        @Override // io.reactivex.Observable
        protected void subscribeActual(Observer<? super T> observer) {
            this.state.subscribe(observer);
        }

        protected GroupedUnicast(K k6, State<T, K> state) {
            super(k6);
            this.state = state;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class State<T, K> extends AtomicInteger implements Disposable, ObservableSource<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final K key;
        final GroupByObserver<?, K, T> parent;
        final SpscLinkedArrayQueue<T> queue;
        final AtomicBoolean cancelled = new AtomicBoolean();
        final AtomicBoolean once = new AtomicBoolean();
        final AtomicReference<Observer<? super T>> actual = new AtomicReference<>();

        public void onComplete() {
            this.done = true;
            drain();
        }

        boolean checkTerminated(boolean z5, boolean z6, Observer<? super T> observer, boolean z7) {
            if (this.cancelled.get()) {
                this.queue.clear();
                this.parent.cancel(this.key);
                this.actual.lazySet(null);
                return true;
            }
            if (!z5) {
                return false;
            }
            if (z7) {
                if (!z6) {
                    return false;
                }
                Throwable th = this.error;
                this.actual.lazySet(null);
                if (th != null) {
                    observer.onError(th);
                } else {
                    observer.onComplete();
                }
                return true;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                this.queue.clear();
                this.actual.lazySet(null);
                observer.onError(th2);
                return true;
            }
            if (!z6) {
                return false;
            }
            this.actual.lazySet(null);
            observer.onComplete();
            return true;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.actual.lazySet(null);
                this.parent.cancel(this.key);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled.get();
        }

        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        public void onNext(T t5) {
            this.queue.offer(t5);
            drain();
        }

        @Override // io.reactivex.ObservableSource
        public void subscribe(Observer<? super T> observer) {
            if (!this.once.compareAndSet(false, true)) {
                EmptyDisposable.error(new IllegalStateException("Only one Observer allowed!"), observer);
                return;
            }
            observer.onSubscribe(this);
            this.actual.lazySet(observer);
            if (this.cancelled.get()) {
                this.actual.lazySet(null);
            } else {
                drain();
            }
        }

        State(int i6, GroupByObserver<?, K, T> groupByObserver, K k6, boolean z5) {
            this.queue = new SpscLinkedArrayQueue<>(i6);
            this.parent = groupByObserver;
            this.key = k6;
            this.delayError = z5;
        }

        void drain() {
            boolean z5;
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
                boolean z6 = this.delayError;
                Observer<? super T> observer = this.actual.get();
                int i6 = 1;
                while (true) {
                    if (observer != null) {
                        while (true) {
                            boolean z7 = this.done;
                            T poll = spscLinkedArrayQueue.poll();
                            if (poll == null) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            if (!checkTerminated(z7, z5, observer, z6)) {
                                if (z5) {
                                    break;
                                } else {
                                    observer.onNext(poll);
                                }
                            } else {
                                return;
                            }
                        }
                    }
                    i6 = addAndGet(-i6);
                    if (i6 == 0) {
                        return;
                    }
                    if (observer == null) {
                        observer = this.actual.get();
                    }
                }
            }
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super GroupedObservable<K, V>> observer) {
        this.source.subscribe(new GroupByObserver(observer, this.keySelector, this.valueSelector, this.bufferSize, this.delayError));
    }

    public ObservableGroupBy(ObservableSource<T> observableSource, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i6, boolean z5) {
        super(observableSource);
        this.keySelector = function;
        this.valueSelector = function2;
        this.bufferSize = i6;
        this.delayError = z5;
    }
}
