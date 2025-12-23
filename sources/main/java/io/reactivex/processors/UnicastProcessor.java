package io.reactivex.processors;

import androidx.camera.view.p;
import io.reactivex.Flowable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class UnicastProcessor<T> extends FlowableProcessor<T> {
    final AtomicReference<Subscriber<? super T>> actual;
    volatile boolean cancelled;
    volatile boolean done;
    boolean enableOperatorFusion;
    Throwable error;
    final AtomicReference<Runnable> onTerminate;
    final AtomicBoolean once;
    final SpscLinkedArrayQueue<T> queue;
    final AtomicLong requested;
    final BasicIntQueueSubscription<T> wip;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class UnicastQueueSubscription extends BasicIntQueueSubscription<T> {
        private static final long serialVersionUID = -4896760517184205454L;

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i6) {
            if ((i6 & 2) == 0) {
                return 0;
            }
            UnicastProcessor.this.enableOperatorFusion = true;
            return 2;
        }

        UnicastQueueSubscription() {
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (UnicastProcessor.this.cancelled) {
                return;
            }
            UnicastProcessor.this.cancelled = true;
            UnicastProcessor.this.doTerminate();
            UnicastProcessor unicastProcessor = UnicastProcessor.this;
            if (unicastProcessor.enableOperatorFusion || unicastProcessor.wip.getAndIncrement() != 0) {
                return;
            }
            UnicastProcessor.this.queue.clear();
            UnicastProcessor.this.actual.lazySet(null);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            UnicastProcessor.this.queue.clear();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return UnicastProcessor.this.queue.isEmpty();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() {
            return UnicastProcessor.this.queue.poll();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            if (SubscriptionHelper.validate(j6)) {
                BackpressureHelper.add(UnicastProcessor.this.requested, j6);
                UnicastProcessor.this.drain();
            }
        }
    }

    UnicastProcessor(int i6) {
        this.queue = new SpscLinkedArrayQueue<>(ObjectHelper.verifyPositive(i6, "capacityHint"));
        this.onTerminate = new AtomicReference<>();
        this.actual = new AtomicReference<>();
        this.once = new AtomicBoolean();
        this.wip = new UnicastQueueSubscription();
        this.requested = new AtomicLong();
    }

    public static <T> UnicastProcessor<T> create() {
        return new UnicastProcessor<>(Flowable.bufferSize());
    }

    public static <T> UnicastProcessor<T> create(int i6) {
        return new UnicastProcessor<>(i6);
    }

    boolean checkTerminated(boolean z5, boolean z6, Subscriber<? super T> subscriber, SpscLinkedArrayQueue<T> spscLinkedArrayQueue) {
        if (this.cancelled) {
            spscLinkedArrayQueue.clear();
            this.actual.lazySet(null);
            return true;
        }
        if (!z5 || !z6) {
            return false;
        }
        Throwable th = this.error;
        this.actual.lazySet(null);
        if (th != null) {
            subscriber.onError(th);
        } else {
            subscriber.onComplete();
        }
        return true;
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
        Subscriber<? super T> subscriber = this.actual.get();
        int i6 = 1;
        while (subscriber == null) {
            i6 = this.wip.addAndGet(-i6);
            if (i6 == 0) {
                return;
            } else {
                subscriber = this.actual.get();
            }
        }
        if (this.enableOperatorFusion) {
            drainFused(subscriber);
        } else {
            drainRegular(subscriber);
        }
    }

    void drainFused(Subscriber<? super T> subscriber) {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
        int i6 = 1;
        while (!this.cancelled) {
            boolean z5 = this.done;
            subscriber.onNext(null);
            if (z5) {
                this.actual.lazySet(null);
                Throwable th = this.error;
                if (th != null) {
                    subscriber.onError(th);
                    return;
                } else {
                    subscriber.onComplete();
                    return;
                }
            }
            i6 = this.wip.addAndGet(-i6);
            if (i6 == 0) {
                return;
            }
        }
        spscLinkedArrayQueue.clear();
        this.actual.lazySet(null);
    }

    void drainRegular(Subscriber<? super T> subscriber) {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
        int i6 = 1;
        do {
            long j6 = this.requested.get();
            long j7 = 0;
            while (j6 != j7) {
                boolean z5 = this.done;
                T poll = spscLinkedArrayQueue.poll();
                boolean z6 = poll == null;
                if (checkTerminated(z5, z6, subscriber, spscLinkedArrayQueue)) {
                    return;
                }
                if (z6) {
                    break;
                }
                subscriber.onNext(poll);
                j7++;
            }
            if (j6 == j7 && checkTerminated(this.done, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                return;
            }
            if (j7 != 0 && j6 != Long.MAX_VALUE) {
                this.requested.addAndGet(-j7);
            }
            i6 = this.wip.addAndGet(-i6);
        } while (i6 != 0);
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public Throwable getThrowable() {
        if (this.done) {
            return this.error;
        }
        return null;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasComplete() {
        return this.done && this.error == null;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasSubscribers() {
        return this.actual.get() != null;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasThrowable() {
        return this.done && this.error != null;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.done || this.cancelled) {
            return;
        }
        this.done = true;
        doTerminate();
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (this.done || this.cancelled) {
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

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t5) {
        if (this.done || this.cancelled) {
            return;
        }
        if (t5 == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        } else {
            this.queue.offer(t5);
            drain();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (this.done || this.cancelled) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        if (this.once.get() || !this.once.compareAndSet(false, true)) {
            EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), subscriber);
            return;
        }
        subscriber.onSubscribe(this.wip);
        this.actual.set(subscriber);
        if (this.cancelled) {
            this.actual.lazySet(null);
        } else {
            drain();
        }
    }

    public static <T> UnicastProcessor<T> create(int i6, Runnable runnable) {
        return new UnicastProcessor<>(i6, runnable);
    }

    UnicastProcessor(int i6, Runnable runnable) {
        this.queue = new SpscLinkedArrayQueue<>(ObjectHelper.verifyPositive(i6, "capacityHint"));
        this.onTerminate = new AtomicReference<>(ObjectHelper.requireNonNull(runnable, "onTerminate"));
        this.actual = new AtomicReference<>();
        this.once = new AtomicBoolean();
        this.wip = new UnicastQueueSubscription();
        this.requested = new AtomicLong();
    }
}
