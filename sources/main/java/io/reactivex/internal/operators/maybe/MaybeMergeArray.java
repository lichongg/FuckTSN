package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Subscriber;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class MaybeMergeArray<T> extends Flowable<T> {
    final MaybeSource<? extends T>[] sources;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ClqSimpleQueue<T> extends ConcurrentLinkedQueue<T> implements SimpleQueueWithConsumerIndex<T> {
        private static final long serialVersionUID = -4025173261791142821L;
        int consumerIndex;
        final AtomicInteger producerIndex = new AtomicInteger();

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(T t5, T t6) {
            throw new UnsupportedOperationException();
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public int consumerIndex() {
            return this.consumerIndex;
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(T t5) {
            this.producerIndex.getAndIncrement();
            return super.offer(t5);
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public int producerIndex() {
            return this.producerIndex.get();
        }

        ClqSimpleQueue() {
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public void drop() {
            poll();
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex, io.reactivex.internal.fuseable.SimpleQueue
        public T poll() {
            T t5 = (T) super.poll();
            if (t5 != null) {
                this.consumerIndex++;
            }
            return t5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class MergeMaybeObserver<T> extends BasicIntQueueSubscription<T> implements MaybeObserver<T> {
        private static final long serialVersionUID = -660395290758764731L;
        final Subscriber<? super T> actual;
        volatile boolean cancelled;
        long consumed;
        boolean outputFused;
        final SimpleQueueWithConsumerIndex<Object> queue;
        final int sourceCount;
        final CompositeDisposable set = new CompositeDisposable();
        final AtomicLong requested = new AtomicLong();
        final AtomicThrowable error = new AtomicThrowable();

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i6) {
            if ((i6 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.set.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.queue.clear();
        }

        void drainFused() {
            Subscriber<? super T> subscriber = this.actual;
            SimpleQueueWithConsumerIndex<Object> simpleQueueWithConsumerIndex = this.queue;
            int i6 = 1;
            while (!this.cancelled) {
                Throwable th = this.error.get();
                if (th != null) {
                    simpleQueueWithConsumerIndex.clear();
                    subscriber.onError(th);
                    return;
                }
                boolean z5 = simpleQueueWithConsumerIndex.producerIndex() == this.sourceCount;
                if (!simpleQueueWithConsumerIndex.isEmpty()) {
                    subscriber.onNext(null);
                }
                if (z5) {
                    subscriber.onComplete();
                    return;
                } else {
                    i6 = addAndGet(-i6);
                    if (i6 == 0) {
                        return;
                    }
                }
            }
            simpleQueueWithConsumerIndex.clear();
        }

        void drainNormal() {
            Subscriber<? super T> subscriber = this.actual;
            SimpleQueueWithConsumerIndex<Object> simpleQueueWithConsumerIndex = this.queue;
            long j6 = this.consumed;
            int i6 = 1;
            do {
                long j7 = this.requested.get();
                while (j6 != j7) {
                    if (this.cancelled) {
                        simpleQueueWithConsumerIndex.clear();
                        return;
                    }
                    if (this.error.get() != null) {
                        simpleQueueWithConsumerIndex.clear();
                        subscriber.onError(this.error.terminate());
                        return;
                    } else {
                        if (simpleQueueWithConsumerIndex.consumerIndex() == this.sourceCount) {
                            subscriber.onComplete();
                            return;
                        }
                        Object poll = simpleQueueWithConsumerIndex.poll();
                        if (poll == null) {
                            break;
                        } else if (poll != NotificationLite.COMPLETE) {
                            subscriber.onNext(poll);
                            j6++;
                        }
                    }
                }
                if (j6 == j7) {
                    if (this.error.get() != null) {
                        simpleQueueWithConsumerIndex.clear();
                        subscriber.onError(this.error.terminate());
                        return;
                    } else {
                        while (simpleQueueWithConsumerIndex.peek() == NotificationLite.COMPLETE) {
                            simpleQueueWithConsumerIndex.drop();
                        }
                        if (simpleQueueWithConsumerIndex.consumerIndex() == this.sourceCount) {
                            subscriber.onComplete();
                            return;
                        }
                    }
                }
                this.consumed = j6;
                i6 = addAndGet(-i6);
            } while (i6 != 0);
        }

        boolean isCancelled() {
            return this.cancelled;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.queue.offer(NotificationLite.COMPLETE);
            drain();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            if (!this.error.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.set.dispose();
            this.queue.offer(NotificationLite.COMPLETE);
            drain();
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            this.set.add(disposable);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t5) {
            this.queue.offer(t5);
            drain();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            T t5;
            do {
                t5 = (T) this.queue.poll();
            } while (t5 == NotificationLite.COMPLETE);
            return t5;
        }

        MergeMaybeObserver(Subscriber<? super T> subscriber, int i6, SimpleQueueWithConsumerIndex<Object> simpleQueueWithConsumerIndex) {
            this.actual = subscriber;
            this.sourceCount = i6;
            this.queue = simpleQueueWithConsumerIndex;
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.outputFused) {
                drainFused();
            } else {
                drainNormal();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            if (SubscriptionHelper.validate(j6)) {
                BackpressureHelper.add(this.requested, j6);
                drain();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class MpscFillOnceSimpleQueue<T> extends AtomicReferenceArray<T> implements SimpleQueueWithConsumerIndex<T> {
        private static final long serialVersionUID = -7969063454040569579L;
        int consumerIndex;
        final AtomicInteger producerIndex;

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(T t5) {
            ObjectHelper.requireNonNull(t5, "value is null");
            int andIncrement = this.producerIndex.getAndIncrement();
            if (andIncrement >= length()) {
                return false;
            }
            lazySet(andIncrement, t5);
            return true;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public int consumerIndex() {
            return this.consumerIndex;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public void drop() {
            int i6 = this.consumerIndex;
            lazySet(i6, null);
            this.consumerIndex = i6 + 1;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.consumerIndex == producerIndex();
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public T peek() {
            int i6 = this.consumerIndex;
            if (i6 == length()) {
                return null;
            }
            return get(i6);
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex, java.util.Queue, io.reactivex.internal.fuseable.SimpleQueue
        public T poll() {
            int i6 = this.consumerIndex;
            if (i6 == length()) {
                return null;
            }
            AtomicInteger atomicInteger = this.producerIndex;
            do {
                T t5 = get(i6);
                if (t5 != null) {
                    this.consumerIndex = i6 + 1;
                    lazySet(i6, null);
                    return t5;
                }
            } while (atomicInteger.get() != i6);
            return null;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public int producerIndex() {
            return this.producerIndex.get();
        }

        MpscFillOnceSimpleQueue(int i6) {
            super(i6);
            this.producerIndex = new AtomicInteger();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            while (poll() != null && !isEmpty()) {
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(T t5, T t6) {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface SimpleQueueWithConsumerIndex<T> extends SimpleQueue<T> {
        int consumerIndex();

        void drop();

        T peek();

        @Override // java.util.Queue, io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex, io.reactivex.internal.fuseable.SimpleQueue
        T poll();

        int producerIndex();
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        MaybeSource[] maybeSourceArr = this.sources;
        int length = maybeSourceArr.length;
        MergeMaybeObserver mergeMaybeObserver = new MergeMaybeObserver(subscriber, length, length <= Flowable.bufferSize() ? new MpscFillOnceSimpleQueue(length) : new ClqSimpleQueue());
        subscriber.onSubscribe(mergeMaybeObserver);
        AtomicThrowable atomicThrowable = mergeMaybeObserver.error;
        for (MaybeSource maybeSource : maybeSourceArr) {
            if (mergeMaybeObserver.isCancelled() || atomicThrowable.get() != null) {
                return;
            }
            maybeSource.subscribe(mergeMaybeObserver);
        }
    }

    public MaybeMergeArray(MaybeSource<? extends T>[] maybeSourceArr) {
        this.sources = maybeSourceArr;
    }
}
