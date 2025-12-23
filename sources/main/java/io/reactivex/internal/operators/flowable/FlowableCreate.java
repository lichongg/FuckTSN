package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableCreate<T> extends Flowable<T> {
    final BackpressureStrategy backpressure;
    final FlowableOnSubscribe<T> source;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static abstract class BaseEmitter<T> extends AtomicLong implements FlowableEmitter<T>, Subscription {
        private static final long serialVersionUID = 7326289992464377023L;
        final Subscriber<? super T> actual;
        final SequentialDisposable serial = new SequentialDisposable();

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.serial.dispose();
            onUnsubscribed();
        }

        @Override // io.reactivex.FlowableEmitter
        public final boolean isCancelled() {
            return this.serial.isDisposed();
        }

        @Override // io.reactivex.Emitter
        public void onError(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (isCancelled()) {
                RxJavaPlugins.onError(th);
                return;
            }
            try {
                this.actual.onError(th);
            } finally {
                this.serial.dispose();
            }
        }

        @Override // io.reactivex.FlowableEmitter
        public final FlowableEmitter<T> serialize() {
            return new SerializedEmitter(this);
        }

        @Override // io.reactivex.FlowableEmitter
        public final void setCancellable(Cancellable cancellable) {
            setDisposable(new CancellableDisposable(cancellable));
        }

        @Override // io.reactivex.FlowableEmitter
        public final void setDisposable(Disposable disposable) {
            this.serial.update(disposable);
        }

        BaseEmitter(Subscriber<? super T> subscriber) {
            this.actual = subscriber;
        }

        @Override // io.reactivex.Emitter
        public void onComplete() {
            if (isCancelled()) {
                return;
            }
            try {
                this.actual.onComplete();
            } finally {
                this.serial.dispose();
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j6) {
            if (SubscriptionHelper.validate(j6)) {
                BackpressureHelper.add(this, j6);
                onRequested();
            }
        }

        @Override // io.reactivex.FlowableEmitter
        public final long requested() {
            return get();
        }

        void onRequested() {
        }

        void onUnsubscribed() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class BufferAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 2427151001689639875L;
        volatile boolean done;
        Throwable error;
        final SpscLinkedArrayQueue<T> queue;
        final AtomicInteger wip;

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter, io.reactivex.Emitter
        public void onComplete() {
            this.done = true;
            drain();
        }

        void drain() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = this.actual;
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
            int i6 = 1;
            do {
                long j6 = get();
                long j7 = 0;
                while (j7 != j6) {
                    if (isCancelled()) {
                        spscLinkedArrayQueue.clear();
                        return;
                    }
                    boolean z5 = this.done;
                    T poll = spscLinkedArrayQueue.poll();
                    boolean z6 = poll == null;
                    if (z5 && z6) {
                        Throwable th = this.error;
                        if (th != null) {
                            super.onError(th);
                            return;
                        } else {
                            super.onComplete();
                            return;
                        }
                    }
                    if (z6) {
                        break;
                    }
                    subscriber.onNext(poll);
                    j7++;
                }
                if (j7 == j6) {
                    if (isCancelled()) {
                        spscLinkedArrayQueue.clear();
                        return;
                    }
                    boolean z7 = this.done;
                    boolean isEmpty = spscLinkedArrayQueue.isEmpty();
                    if (z7 && isEmpty) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            super.onError(th2);
                            return;
                        } else {
                            super.onComplete();
                            return;
                        }
                    }
                }
                if (j7 != 0) {
                    BackpressureHelper.produced(this, j7);
                }
                i6 = this.wip.addAndGet(-i6);
            } while (i6 != 0);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter, io.reactivex.Emitter
        public void onError(Throwable th) {
            if (this.done || isCancelled()) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // io.reactivex.Emitter
        public void onNext(T t5) {
            if (this.done || isCancelled()) {
                return;
            }
            if (t5 == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.queue.offer(t5);
                drain();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        void onUnsubscribed() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        BufferAsyncEmitter(Subscriber<? super T> subscriber, int i6) {
            super(subscriber);
            this.queue = new SpscLinkedArrayQueue<>(i6);
            this.wip = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        void onRequested() {
            drain();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ErrorAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long serialVersionUID = 338953216916120960L;

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.NoOverflowBaseAsyncEmitter
        void onOverflow() {
            onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
        }

        ErrorAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class LatestAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4023437720691792495L;
        volatile boolean done;
        Throwable error;
        final AtomicReference<T> queue;
        final AtomicInteger wip;

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter, io.reactivex.Emitter
        public void onComplete() {
            this.done = true;
            drain();
        }

        void drain() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = this.actual;
            AtomicReference<T> atomicReference = this.queue;
            int i6 = 1;
            do {
                long j6 = get();
                long j7 = 0;
                while (true) {
                    if (j7 == j6) {
                        break;
                    }
                    if (isCancelled()) {
                        atomicReference.lazySet(null);
                        return;
                    }
                    boolean z5 = this.done;
                    T andSet = atomicReference.getAndSet(null);
                    boolean z6 = andSet == null;
                    if (z5 && z6) {
                        Throwable th = this.error;
                        if (th != null) {
                            super.onError(th);
                            return;
                        } else {
                            super.onComplete();
                            return;
                        }
                    }
                    if (z6) {
                        break;
                    }
                    subscriber.onNext(andSet);
                    j7++;
                }
                if (j7 == j6) {
                    if (isCancelled()) {
                        atomicReference.lazySet(null);
                        return;
                    }
                    boolean z7 = this.done;
                    boolean z8 = atomicReference.get() == null;
                    if (z7 && z8) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            super.onError(th2);
                            return;
                        } else {
                            super.onComplete();
                            return;
                        }
                    }
                }
                if (j7 != 0) {
                    BackpressureHelper.produced(this, j7);
                }
                i6 = this.wip.addAndGet(-i6);
            } while (i6 != 0);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter, io.reactivex.Emitter
        public void onError(Throwable th) {
            if (this.done || isCancelled()) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (th == null) {
                onError(new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources."));
            }
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // io.reactivex.Emitter
        public void onNext(T t5) {
            if (this.done || isCancelled()) {
                return;
            }
            if (t5 == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.queue.set(t5);
                drain();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        void onUnsubscribed() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.lazySet(null);
            }
        }

        LatestAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
            this.queue = new AtomicReference<>();
            this.wip = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        void onRequested() {
            drain();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class SerializedEmitter<T> extends AtomicInteger implements FlowableEmitter<T> {
        private static final long serialVersionUID = 4883307006032401862L;
        volatile boolean done;
        final BaseEmitter<T> emitter;
        final AtomicThrowable error = new AtomicThrowable();
        final SimplePlainQueue<T> queue = new SpscLinkedArrayQueue(16);

        void drainLoop() {
            BaseEmitter<T> baseEmitter = this.emitter;
            SimplePlainQueue<T> simplePlainQueue = this.queue;
            AtomicThrowable atomicThrowable = this.error;
            int i6 = 1;
            while (!baseEmitter.isCancelled()) {
                if (atomicThrowable.get() != null) {
                    simplePlainQueue.clear();
                    baseEmitter.onError(atomicThrowable.terminate());
                    return;
                }
                boolean z5 = this.done;
                T poll = simplePlainQueue.poll();
                boolean z6 = poll == null;
                if (z5 && z6) {
                    baseEmitter.onComplete();
                    return;
                } else if (z6) {
                    i6 = addAndGet(-i6);
                    if (i6 == 0) {
                        return;
                    }
                } else {
                    baseEmitter.onNext(poll);
                }
            }
            simplePlainQueue.clear();
        }

        @Override // io.reactivex.FlowableEmitter
        public boolean isCancelled() {
            return this.emitter.isCancelled();
        }

        @Override // io.reactivex.Emitter
        public void onComplete() {
            if (this.emitter.isCancelled() || this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // io.reactivex.Emitter
        public void onError(Throwable th) {
            if (this.emitter.isCancelled() || this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (!this.error.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else {
                this.done = true;
                drain();
            }
        }

        @Override // io.reactivex.Emitter
        public void onNext(T t5) {
            if (this.emitter.isCancelled() || this.done) {
                return;
            }
            if (t5 == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            if (get() == 0 && compareAndSet(0, 1)) {
                this.emitter.onNext(t5);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                SimplePlainQueue<T> simplePlainQueue = this.queue;
                synchronized (simplePlainQueue) {
                    simplePlainQueue.offer(t5);
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // io.reactivex.FlowableEmitter
        public long requested() {
            return this.emitter.requested();
        }

        @Override // io.reactivex.FlowableEmitter
        public void setCancellable(Cancellable cancellable) {
            this.emitter.setCancellable(cancellable);
        }

        @Override // io.reactivex.FlowableEmitter
        public void setDisposable(Disposable disposable) {
            this.emitter.setDisposable(disposable);
        }

        SerializedEmitter(BaseEmitter<T> baseEmitter) {
            this.emitter = baseEmitter;
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        @Override // io.reactivex.FlowableEmitter
        public FlowableEmitter<T> serialize() {
            return this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.reactivex.internal.operators.flowable.FlowableCreate$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$reactivex$BackpressureStrategy;

        static {
            int[] iArr = new int[BackpressureStrategy.values().length];
            $SwitchMap$io$reactivex$BackpressureStrategy = iArr;
            try {
                iArr[BackpressureStrategy.MISSING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$reactivex$BackpressureStrategy[BackpressureStrategy.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$reactivex$BackpressureStrategy[BackpressureStrategy.DROP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$reactivex$BackpressureStrategy[BackpressureStrategy.LATEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class DropAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long serialVersionUID = 8360058422307496563L;

        DropAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.NoOverflowBaseAsyncEmitter
        void onOverflow() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class MissingEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 3776720187248809713L;

        MissingEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.Emitter
        public void onNext(T t5) {
            long j6;
            if (!isCancelled()) {
                if (t5 != null) {
                    this.actual.onNext(t5);
                    do {
                        j6 = get();
                        if (j6 == 0) {
                            return;
                        }
                    } while (!compareAndSet(j6, j6 - 1));
                    return;
                }
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static abstract class NoOverflowBaseAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4127754106204442833L;

        abstract void onOverflow();

        NoOverflowBaseAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.Emitter
        public final void onNext(T t5) {
            if (isCancelled()) {
                return;
            }
            if (t5 == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else if (get() != 0) {
                this.actual.onNext(t5);
                BackpressureHelper.produced(this, 1L);
            } else {
                onOverflow();
            }
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        int i6 = AnonymousClass1.$SwitchMap$io$reactivex$BackpressureStrategy[this.backpressure.ordinal()];
        BaseEmitter bufferAsyncEmitter = i6 != 1 ? i6 != 2 ? i6 != 3 ? i6 != 4 ? new BufferAsyncEmitter(subscriber, Flowable.bufferSize()) : new LatestAsyncEmitter(subscriber) : new DropAsyncEmitter(subscriber) : new ErrorAsyncEmitter(subscriber) : new MissingEmitter(subscriber);
        subscriber.onSubscribe(bufferAsyncEmitter);
        try {
            this.source.subscribe(bufferAsyncEmitter);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            bufferAsyncEmitter.onError(th);
        }
    }

    public FlowableCreate(FlowableOnSubscribe<T> flowableOnSubscribe, BackpressureStrategy backpressureStrategy) {
        this.source = flowableOnSubscribe;
        this.backpressure = backpressureStrategy;
    }
}
