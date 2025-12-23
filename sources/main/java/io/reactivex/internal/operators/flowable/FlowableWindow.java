package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableWindow<T> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final int bufferSize;
    final long size;
    final long skip;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class WindowExactSubscriber<T> extends AtomicInteger implements Subscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -2365647875069161133L;
        final Subscriber<? super Flowable<T>> actual;
        final int bufferSize;
        boolean done;
        long index;
        final AtomicBoolean once;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43236s;
        final long size;
        UnicastProcessor<T> window;

        WindowExactSubscriber(Subscriber<? super Flowable<T>> subscriber, long j6, int i6) {
            super(1);
            this.actual = subscriber;
            this.size = j6;
            this.once = new AtomicBoolean();
            this.bufferSize = i6;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.once.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            UnicastProcessor<T> unicastProcessor = this.window;
            if (unicastProcessor != null) {
                this.window = null;
                unicastProcessor.onComplete();
            }
            this.actual.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            UnicastProcessor<T> unicastProcessor = this.window;
            if (unicastProcessor != null) {
                this.window = null;
                unicastProcessor.onError(th);
            }
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (this.done) {
                return;
            }
            long j6 = this.index;
            UnicastProcessor<T> unicastProcessor = this.window;
            if (j6 == 0) {
                getAndIncrement();
                unicastProcessor = UnicastProcessor.create(this.bufferSize, this);
                this.window = unicastProcessor;
                this.actual.onNext(unicastProcessor);
            }
            long j7 = j6 + 1;
            unicastProcessor.onNext(t5);
            if (j7 != this.size) {
                this.index = j7;
                return;
            }
            this.index = 0L;
            this.window = null;
            unicastProcessor.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43236s, subscription)) {
                this.f43236s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            if (SubscriptionHelper.validate(j6)) {
                this.f43236s.request(BackpressureHelper.multiplyCap(this.size, j6));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.f43236s.cancel();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class WindowOverlapSubscriber<T> extends AtomicInteger implements Subscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 2428527070996323976L;
        final Subscriber<? super Flowable<T>> actual;
        final int bufferSize;
        volatile boolean cancelled;
        volatile boolean done;
        Throwable error;
        final AtomicBoolean firstRequest;
        long index;
        final AtomicBoolean once;
        long produced;
        final SpscLinkedArrayQueue<UnicastProcessor<T>> queue;
        final AtomicLong requested;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43237s;
        final long size;
        final long skip;
        final ArrayDeque<UnicastProcessor<T>> windows;
        final AtomicInteger wip;

        WindowOverlapSubscriber(Subscriber<? super Flowable<T>> subscriber, long j6, long j7, int i6) {
            super(1);
            this.actual = subscriber;
            this.size = j6;
            this.skip = j7;
            this.queue = new SpscLinkedArrayQueue<>(i6);
            this.windows = new ArrayDeque<>();
            this.once = new AtomicBoolean();
            this.firstRequest = new AtomicBoolean();
            this.requested = new AtomicLong();
            this.wip = new AtomicInteger();
            this.bufferSize = i6;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            if (this.once.compareAndSet(false, true)) {
                run();
            }
        }

        boolean checkTerminated(boolean z5, boolean z6, Subscriber<?> subscriber, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            if (this.cancelled) {
                spscLinkedArrayQueue.clear();
                return true;
            }
            if (!z5) {
                return false;
            }
            Throwable th = this.error;
            if (th != null) {
                spscLinkedArrayQueue.clear();
                subscriber.onError(th);
                return true;
            }
            if (!z6) {
                return false;
            }
            subscriber.onComplete();
            return true;
        }

        void drain() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super Flowable<T>> subscriber = this.actual;
            SpscLinkedArrayQueue<UnicastProcessor<T>> spscLinkedArrayQueue = this.queue;
            int i6 = 1;
            do {
                long j6 = this.requested.get();
                long j7 = 0;
                while (j7 != j6) {
                    boolean z5 = this.done;
                    UnicastProcessor<T> poll = spscLinkedArrayQueue.poll();
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
                if (j7 == j6 && checkTerminated(this.done, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                    return;
                }
                if (j7 != 0 && j6 != Long.MAX_VALUE) {
                    this.requested.addAndGet(-j7);
                }
                i6 = this.wip.addAndGet(-i6);
            } while (i6 != 0);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            Iterator<UnicastProcessor<T>> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onComplete();
            }
            this.windows.clear();
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            Iterator<UnicastProcessor<T>> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onError(th);
            }
            this.windows.clear();
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (this.done) {
                return;
            }
            long j6 = this.index;
            if (j6 == 0 && !this.cancelled) {
                getAndIncrement();
                UnicastProcessor<T> create = UnicastProcessor.create(this.bufferSize, this);
                this.windows.offer(create);
                this.queue.offer(create);
                drain();
            }
            long j7 = j6 + 1;
            Iterator<UnicastProcessor<T>> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onNext(t5);
            }
            long j8 = this.produced + 1;
            if (j8 == this.size) {
                this.produced = j8 - this.skip;
                UnicastProcessor<T> poll = this.windows.poll();
                if (poll != null) {
                    poll.onComplete();
                }
            } else {
                this.produced = j8;
            }
            if (j7 == this.skip) {
                this.index = 0L;
            } else {
                this.index = j7;
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43237s, subscription)) {
                this.f43237s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            if (SubscriptionHelper.validate(j6)) {
                BackpressureHelper.add(this.requested, j6);
                if (!this.firstRequest.get() && this.firstRequest.compareAndSet(false, true)) {
                    this.f43237s.request(BackpressureHelper.addCap(this.size, BackpressureHelper.multiplyCap(this.skip, j6 - 1)));
                } else {
                    this.f43237s.request(BackpressureHelper.multiplyCap(this.skip, j6));
                }
                drain();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.f43237s.cancel();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class WindowSkipSubscriber<T> extends AtomicInteger implements Subscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -8792836352386833856L;
        final Subscriber<? super Flowable<T>> actual;
        final int bufferSize;
        boolean done;
        final AtomicBoolean firstRequest;
        long index;
        final AtomicBoolean once;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43238s;
        final long size;
        final long skip;
        UnicastProcessor<T> window;

        WindowSkipSubscriber(Subscriber<? super Flowable<T>> subscriber, long j6, long j7, int i6) {
            super(1);
            this.actual = subscriber;
            this.size = j6;
            this.skip = j7;
            this.once = new AtomicBoolean();
            this.firstRequest = new AtomicBoolean();
            this.bufferSize = i6;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.once.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            UnicastProcessor<T> unicastProcessor = this.window;
            if (unicastProcessor != null) {
                this.window = null;
                unicastProcessor.onComplete();
            }
            this.actual.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            UnicastProcessor<T> unicastProcessor = this.window;
            if (unicastProcessor != null) {
                this.window = null;
                unicastProcessor.onError(th);
            }
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (this.done) {
                return;
            }
            long j6 = this.index;
            UnicastProcessor<T> unicastProcessor = this.window;
            if (j6 == 0) {
                getAndIncrement();
                unicastProcessor = UnicastProcessor.create(this.bufferSize, this);
                this.window = unicastProcessor;
                this.actual.onNext(unicastProcessor);
            }
            long j7 = j6 + 1;
            if (unicastProcessor != null) {
                unicastProcessor.onNext(t5);
            }
            if (j7 == this.size) {
                this.window = null;
                unicastProcessor.onComplete();
            }
            if (j7 == this.skip) {
                this.index = 0L;
            } else {
                this.index = j7;
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43238s, subscription)) {
                this.f43238s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            if (SubscriptionHelper.validate(j6)) {
                if (!this.firstRequest.get() && this.firstRequest.compareAndSet(false, true)) {
                    this.f43238s.request(BackpressureHelper.addCap(BackpressureHelper.multiplyCap(this.size, j6), BackpressureHelper.multiplyCap(this.skip - this.size, j6 - 1)));
                } else {
                    this.f43238s.request(BackpressureHelper.multiplyCap(this.skip, j6));
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.f43238s.cancel();
            }
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        long j6 = this.skip;
        long j7 = this.size;
        if (j6 == j7) {
            this.source.subscribe(new WindowExactSubscriber(subscriber, this.size, this.bufferSize));
        } else if (j6 > j7) {
            this.source.subscribe(new WindowSkipSubscriber(subscriber, this.size, this.skip, this.bufferSize));
        } else {
            this.source.subscribe(new WindowOverlapSubscriber(subscriber, this.size, this.skip, this.bufferSize));
        }
    }

    public FlowableWindow(Publisher<T> publisher, long j6, long j7, int i6) {
        super(publisher);
        this.size = j6;
        this.skip = j7;
        this.bufferSize = i6;
    }
}
