package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableCombineLatest<T, R> extends Flowable<R> {
    final Publisher<? extends T>[] array;
    final int bufferSize;
    final Function<? super Object[], ? extends R> combiner;
    final boolean delayErrors;
    final Iterable<? extends Publisher<? extends T>> iterable;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class CombineLatestCoordinator<T, R> extends BasicIntQueueSubscription<R> {
        private static final long serialVersionUID = -5082275438355852221L;
        final Subscriber<? super R> actual;
        volatile boolean cancelled;
        final Function<? super Object[], ? extends R> combiner;
        int completedSources;
        final boolean delayErrors;
        volatile boolean done;
        final AtomicReference<Throwable> error;
        final Object[] latest;
        int nonEmptySources;
        boolean outputFused;
        final SpscLinkedArrayQueue<Object> queue;
        final AtomicLong requested;
        final CombineLatestInnerSubscriber<T>[] subscribers;

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            cancelAll();
        }

        void innerComplete(int i6) {
            synchronized (this) {
                try {
                    Object[] objArr = this.latest;
                    if (objArr[i6] != null) {
                        int i7 = this.completedSources + 1;
                        if (i7 != objArr.length) {
                            this.completedSources = i7;
                            return;
                        }
                        this.done = true;
                    } else {
                        this.done = true;
                    }
                    drain();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        void innerValue(int i6, T t5) {
            boolean z5;
            synchronized (this) {
                try {
                    Object[] objArr = this.latest;
                    int i7 = this.nonEmptySources;
                    if (objArr[i6] == null) {
                        i7++;
                        this.nonEmptySources = i7;
                    }
                    objArr[i6] = t5;
                    if (objArr.length == i7) {
                        this.queue.offer(this.subscribers[i6], objArr.clone());
                        z5 = false;
                    } else {
                        z5 = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z5) {
                this.subscribers[i6].requestOne();
            } else {
                drain();
            }
        }

        void cancelAll() {
            for (CombineLatestInnerSubscriber<T> combineLatestInnerSubscriber : this.subscribers) {
                combineLatestInnerSubscriber.cancel();
            }
        }

        boolean checkTerminated(boolean z5, boolean z6, Subscriber<?> subscriber, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            if (this.cancelled) {
                cancelAll();
                spscLinkedArrayQueue.clear();
                return true;
            }
            if (!z5) {
                return false;
            }
            if (this.delayErrors) {
                if (!z6) {
                    return false;
                }
                Throwable terminate = ExceptionHelper.terminate(this.error);
                if (terminate == null || terminate == ExceptionHelper.TERMINATED) {
                    subscriber.onComplete();
                } else {
                    subscriber.onError(terminate);
                }
                return true;
            }
            Throwable terminate2 = ExceptionHelper.terminate(this.error);
            if (terminate2 != null && terminate2 != ExceptionHelper.TERMINATED) {
                cancelAll();
                spscLinkedArrayQueue.clear();
                subscriber.onError(terminate2);
                return true;
            }
            if (!z6) {
                return false;
            }
            cancelAll();
            subscriber.onComplete();
            return true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.queue.clear();
        }

        void drainAsync() {
            Subscriber<? super R> subscriber = this.actual;
            SpscLinkedArrayQueue<?> spscLinkedArrayQueue = this.queue;
            int i6 = 1;
            do {
                long j6 = this.requested.get();
                long j7 = 0;
                while (j7 != j6) {
                    boolean z5 = this.done;
                    Object poll = spscLinkedArrayQueue.poll();
                    boolean z6 = poll == null;
                    if (checkTerminated(z5, z6, subscriber, spscLinkedArrayQueue)) {
                        return;
                    }
                    if (z6) {
                        break;
                    }
                    try {
                        subscriber.onNext((Object) ObjectHelper.requireNonNull(this.combiner.apply((Object[]) spscLinkedArrayQueue.poll()), "The combiner returned a null value"));
                        ((CombineLatestInnerSubscriber) poll).requestOne();
                        j7++;
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        cancelAll();
                        ExceptionHelper.addThrowable(this.error, th);
                        subscriber.onError(ExceptionHelper.terminate(this.error));
                        return;
                    }
                }
                if (j7 == j6 && checkTerminated(this.done, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                    return;
                }
                if (j7 != 0 && j6 != Long.MAX_VALUE) {
                    this.requested.addAndGet(-j7);
                }
                i6 = addAndGet(-i6);
            } while (i6 != 0);
        }

        void drainOutput() {
            Subscriber<? super R> subscriber = this.actual;
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
            int i6 = 1;
            while (!this.cancelled) {
                Throwable th = this.error.get();
                if (th != null) {
                    spscLinkedArrayQueue.clear();
                    subscriber.onError(th);
                    return;
                }
                boolean z5 = this.done;
                boolean isEmpty = spscLinkedArrayQueue.isEmpty();
                if (!isEmpty) {
                    subscriber.onNext(null);
                }
                if (z5 && isEmpty) {
                    subscriber.onComplete();
                    return;
                } else {
                    i6 = addAndGet(-i6);
                    if (i6 == 0) {
                        return;
                    }
                }
            }
            spscLinkedArrayQueue.clear();
        }

        void innerError(int i6, Throwable th) {
            if (!ExceptionHelper.addThrowable(this.error, th)) {
                RxJavaPlugins.onError(th);
            } else {
                if (this.delayErrors) {
                    innerComplete(i6);
                    return;
                }
                cancelAll();
                this.done = true;
                drain();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public R poll() throws Exception {
            Object poll = this.queue.poll();
            if (poll == null) {
                return null;
            }
            R apply = this.combiner.apply((Object[]) this.queue.poll());
            ((CombineLatestInnerSubscriber) poll).requestOne();
            return apply;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i6) {
            if ((i6 & 4) != 0) {
                return 0;
            }
            int i7 = i6 & 2;
            this.outputFused = i7 != 0;
            return i7;
        }

        void subscribe(Publisher<? extends T>[] publisherArr, int i6) {
            CombineLatestInnerSubscriber<T>[] combineLatestInnerSubscriberArr = this.subscribers;
            for (int i7 = 0; i7 < i6 && !this.done && !this.cancelled; i7++) {
                publisherArr[i7].subscribe(combineLatestInnerSubscriberArr[i7]);
            }
        }

        CombineLatestCoordinator(Subscriber<? super R> subscriber, Function<? super Object[], ? extends R> function, int i6, int i7, boolean z5) {
            this.actual = subscriber;
            this.combiner = function;
            CombineLatestInnerSubscriber<T>[] combineLatestInnerSubscriberArr = new CombineLatestInnerSubscriber[i6];
            for (int i8 = 0; i8 < i6; i8++) {
                combineLatestInnerSubscriberArr[i8] = new CombineLatestInnerSubscriber<>(this, i8, i7);
            }
            this.subscribers = combineLatestInnerSubscriberArr;
            this.latest = new Object[i6];
            this.queue = new SpscLinkedArrayQueue<>(i7);
            this.requested = new AtomicLong();
            this.error = new AtomicReference<>();
            this.delayErrors = z5;
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.outputFused) {
                drainOutput();
            } else {
                drainAsync();
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
    static final class CombineLatestInnerSubscriber<T> extends AtomicReference<Subscription> implements Subscriber<T> {
        private static final long serialVersionUID = -8730235182291002949L;
        final int index;
        final int limit;
        final CombineLatestCoordinator<T, ?> parent;
        final int prefetch;
        int produced;

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.parent.innerComplete(this.index);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.parent.innerError(this.index, th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            this.parent.innerValue(this.index, t5);
        }

        public void requestOne() {
            int i6 = this.produced + 1;
            if (i6 != this.limit) {
                this.produced = i6;
            } else {
                this.produced = 0;
                get().request(i6);
            }
        }

        CombineLatestInnerSubscriber(CombineLatestCoordinator<T, ?> combineLatestCoordinator, int i6, int i7) {
            this.parent = combineLatestCoordinator;
            this.index = i6;
            this.prefetch = i7;
            this.limit = i7 - (i7 >> 2);
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                subscription.request(this.prefetch);
            }
        }
    }

    public FlowableCombineLatest(Publisher<? extends T>[] publisherArr, Function<? super Object[], ? extends R> function, int i6, boolean z5) {
        this.array = publisherArr;
        this.iterable = null;
        this.combiner = function;
        this.bufferSize = i6;
        this.delayErrors = z5;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        int length;
        Publisher<? extends T>[] publisherArr = this.array;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            try {
                Iterator it = (Iterator) ObjectHelper.requireNonNull(this.iterable.iterator(), "The iterator returned is null");
                length = 0;
                while (it.hasNext()) {
                    try {
                        try {
                            Publisher<? extends T> publisher = (Publisher) ObjectHelper.requireNonNull(it.next(), "The publisher returned by the iterator is null");
                            if (length == publisherArr.length) {
                                Publisher<? extends T>[] publisherArr2 = new Publisher[(length >> 2) + length];
                                System.arraycopy(publisherArr, 0, publisherArr2, 0, length);
                                publisherArr = publisherArr2;
                            }
                            publisherArr[length] = publisher;
                            length++;
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            EmptySubscription.error(th, subscriber);
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        EmptySubscription.error(th2, subscriber);
                        return;
                    }
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                EmptySubscription.error(th3, subscriber);
                return;
            }
        } else {
            length = publisherArr.length;
        }
        int i6 = length;
        if (i6 == 0) {
            EmptySubscription.complete(subscriber);
        } else {
            if (i6 == 1) {
                new FlowableMap(publisherArr[0], new Function<T, R>() { // from class: io.reactivex.internal.operators.flowable.FlowableCombineLatest.1
                    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
                    @Override // io.reactivex.functions.Function
                    public R apply(T t5) throws Exception {
                        return FlowableCombineLatest.this.combiner.apply(new Object[]{t5});
                    }
                }).subscribe(subscriber);
                return;
            }
            CombineLatestCoordinator combineLatestCoordinator = new CombineLatestCoordinator(subscriber, this.combiner, i6, this.bufferSize, this.delayErrors);
            subscriber.onSubscribe(combineLatestCoordinator);
            combineLatestCoordinator.subscribe(publisherArr, i6);
        }
    }

    public FlowableCombineLatest(Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i6, boolean z5) {
        this.array = null;
        this.iterable = iterable;
        this.combiner = function;
        this.bufferSize = i6;
        this.delayErrors = z5;
    }
}
