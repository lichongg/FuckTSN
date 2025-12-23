package io.reactivex.subjects;

import androidx.camera.view.p;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class UnicastSubject<T> extends Subject<T> {
    final AtomicReference<Observer<? super T>> actual;
    volatile boolean disposed;
    volatile boolean done;
    boolean enableOperatorFusion;
    Throwable error;
    final AtomicReference<Runnable> onTerminate;
    final AtomicBoolean once;
    final SpscLinkedArrayQueue<T> queue;
    final BasicIntQueueDisposable<T> wip;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class UnicastQueueDisposable extends BasicIntQueueDisposable<T> {
        private static final long serialVersionUID = 7926949470189395511L;

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i6) {
            if ((i6 & 2) == 0) {
                return 0;
            }
            UnicastSubject.this.enableOperatorFusion = true;
            return 2;
        }

        UnicastQueueDisposable() {
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            UnicastSubject.this.queue.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (UnicastSubject.this.disposed) {
                return;
            }
            UnicastSubject.this.disposed = true;
            UnicastSubject.this.doTerminate();
            UnicastSubject.this.actual.lazySet(null);
            if (UnicastSubject.this.wip.getAndIncrement() == 0) {
                UnicastSubject.this.actual.lazySet(null);
                UnicastSubject.this.queue.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return UnicastSubject.this.disposed;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return UnicastSubject.this.queue.isEmpty();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            return UnicastSubject.this.queue.poll();
        }
    }

    UnicastSubject(int i6) {
        this.queue = new SpscLinkedArrayQueue<>(ObjectHelper.verifyPositive(i6, "capacityHint"));
        this.onTerminate = new AtomicReference<>();
        this.actual = new AtomicReference<>();
        this.once = new AtomicBoolean();
        this.wip = new UnicastQueueDisposable();
    }

    public static <T> UnicastSubject<T> create() {
        return new UnicastSubject<>(Observable.bufferSize());
    }

    public static <T> UnicastSubject<T> create(int i6) {
        return new UnicastSubject<>(i6);
    }

    void doTerminate() {
        Runnable runnable = this.onTerminate.get();
        if (runnable == null || !p.a(this.onTerminate, runnable, null)) {
            return;
        }
        runnable.run();
    }

    void drain() {
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        Observer<? super T> observer = this.actual.get();
        int i6 = 1;
        while (observer == null) {
            i6 = this.wip.addAndGet(-i6);
            if (i6 == 0) {
                return;
            } else {
                observer = this.actual.get();
            }
        }
        if (this.enableOperatorFusion) {
            drainFused(observer);
        } else {
            drainNormal(observer);
        }
    }

    void drainFused(Observer<? super T> observer) {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
        int i6 = 1;
        while (!this.disposed) {
            boolean z5 = this.done;
            observer.onNext(null);
            if (z5) {
                this.actual.lazySet(null);
                Throwable th = this.error;
                if (th != null) {
                    observer.onError(th);
                    return;
                } else {
                    observer.onComplete();
                    return;
                }
            }
            i6 = this.wip.addAndGet(-i6);
            if (i6 == 0) {
                return;
            }
        }
        this.actual.lazySet(null);
        spscLinkedArrayQueue.clear();
    }

    void drainNormal(Observer<? super T> observer) {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
        int i6 = 1;
        while (!this.disposed) {
            boolean z5 = this.done;
            T poll = this.queue.poll();
            boolean z6 = poll == null;
            if (z5 && z6) {
                this.actual.lazySet(null);
                Throwable th = this.error;
                if (th != null) {
                    observer.onError(th);
                    return;
                } else {
                    observer.onComplete();
                    return;
                }
            }
            if (z6) {
                i6 = this.wip.addAndGet(-i6);
                if (i6 == 0) {
                    return;
                }
            } else {
                observer.onNext(poll);
            }
        }
        this.actual.lazySet(null);
        spscLinkedArrayQueue.clear();
    }

    @Override // io.reactivex.subjects.Subject
    public Throwable getThrowable() {
        if (this.done) {
            return this.error;
        }
        return null;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasComplete() {
        return this.done && this.error == null;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasObservers() {
        return this.actual.get() != null;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasThrowable() {
        return this.done && this.error != null;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.done || this.disposed) {
            return;
        }
        this.done = true;
        doTerminate();
        drain();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        if (this.done || this.disposed) {
            RxJavaPlugins.onError(th);
            return;
        }
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        this.error = th;
        this.done = true;
        doTerminate();
        drain();
    }

    @Override // io.reactivex.Observer
    public void onNext(T t5) {
        if (this.done || this.disposed) {
            return;
        }
        if (t5 == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        } else {
            this.queue.offer(t5);
            drain();
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        if (this.done || this.disposed) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        if (this.once.get() || !this.once.compareAndSet(false, true)) {
            EmptyDisposable.error(new IllegalStateException("Only a single observer allowed."), observer);
            return;
        }
        observer.onSubscribe(this.wip);
        this.actual.lazySet(observer);
        if (this.disposed) {
            this.actual.lazySet(null);
        } else {
            drain();
        }
    }

    public static <T> UnicastSubject<T> create(int i6, Runnable runnable) {
        return new UnicastSubject<>(i6, runnable);
    }

    UnicastSubject(int i6, Runnable runnable) {
        this.queue = new SpscLinkedArrayQueue<>(ObjectHelper.verifyPositive(i6, "capacityHint"));
        this.onTerminate = new AtomicReference<>(ObjectHelper.requireNonNull(runnable, "onTerminate"));
        this.actual = new AtomicReference<>();
        this.once = new AtomicBoolean();
        this.wip = new UnicastQueueDisposable();
    }
}
