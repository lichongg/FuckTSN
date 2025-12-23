package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableWindow<T> extends AbstractObservableWithUpstream<T, Observable<T>> {
    final int capacityHint;
    final long count;
    final long skip;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class WindowExactObserver<T> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = -7481782523886138128L;
        final Observer<? super Observable<T>> actual;
        volatile boolean cancelled;
        final int capacityHint;
        final long count;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43371s;
        long size;
        UnicastSubject<T> window;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            UnicastSubject<T> unicastSubject = this.window;
            if (unicastSubject != null) {
                this.window = null;
                unicastSubject.onComplete();
            }
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            UnicastSubject<T> unicastSubject = this.window;
            if (unicastSubject != null) {
                this.window = null;
                unicastSubject.onError(th);
            }
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            UnicastSubject<T> unicastSubject = this.window;
            if (unicastSubject == null && !this.cancelled) {
                unicastSubject = UnicastSubject.create(this.capacityHint, this);
                this.window = unicastSubject;
                this.actual.onNext(unicastSubject);
            }
            if (unicastSubject != null) {
                unicastSubject.onNext(t5);
                long j6 = this.size + 1;
                this.size = j6;
                if (j6 >= this.count) {
                    this.size = 0L;
                    this.window = null;
                    unicastSubject.onComplete();
                    if (this.cancelled) {
                        this.f43371s.dispose();
                    }
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43371s, disposable)) {
                this.f43371s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.cancelled) {
                this.f43371s.dispose();
            }
        }

        WindowExactObserver(Observer<? super Observable<T>> observer, long j6, int i6) {
            this.actual = observer;
            this.count = j6;
            this.capacityHint = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class WindowSkipObserver<T> extends AtomicBoolean implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = 3366976432059579510L;
        final Observer<? super Observable<T>> actual;
        volatile boolean cancelled;
        final int capacityHint;
        final long count;
        long firstEmission;
        long index;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43372s;
        final long skip;
        final AtomicInteger wip = new AtomicInteger();
        final ArrayDeque<UnicastSubject<T>> windows = new ArrayDeque<>();

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.windows;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onComplete();
            }
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.windows;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onError(th);
            }
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.windows;
            long j6 = this.index;
            long j7 = this.skip;
            if (j6 % j7 == 0 && !this.cancelled) {
                this.wip.getAndIncrement();
                UnicastSubject<T> create = UnicastSubject.create(this.capacityHint, this);
                arrayDeque.offer(create);
                this.actual.onNext(create);
            }
            long j8 = this.firstEmission + 1;
            Iterator<UnicastSubject<T>> it = arrayDeque.iterator();
            while (it.hasNext()) {
                it.next().onNext(t5);
            }
            if (j8 >= this.count) {
                arrayDeque.poll().onComplete();
                if (arrayDeque.isEmpty() && this.cancelled) {
                    this.f43372s.dispose();
                    return;
                }
                this.firstEmission = j8 - j7;
            } else {
                this.firstEmission = j8;
            }
            this.index = j6 + 1;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43372s, disposable)) {
                this.f43372s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.wip.decrementAndGet() == 0 && this.cancelled) {
                this.f43372s.dispose();
            }
        }

        WindowSkipObserver(Observer<? super Observable<T>> observer, long j6, long j7, int i6) {
            this.actual = observer;
            this.count = j6;
            this.skip = j7;
            this.capacityHint = i6;
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Observable<T>> observer) {
        if (this.count == this.skip) {
            this.source.subscribe(new WindowExactObserver(observer, this.count, this.capacityHint));
        } else {
            this.source.subscribe(new WindowSkipObserver(observer, this.count, this.skip, this.capacityHint));
        }
    }

    public ObservableWindow(ObservableSource<T> observableSource, long j6, long j7, int i6) {
        super(observableSource);
        this.count = j6;
        this.skip = j7;
        this.capacityHint = i6;
    }
}
