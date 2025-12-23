package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.flowables.GroupedFlowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableGroupBy<T, K, V> extends AbstractFlowableWithUpstream<T, GroupedFlowable<K, V>> {
    final int bufferSize;
    final boolean delayError;
    final Function<? super T, ? extends K> keySelector;
    final Function<? super T, ? extends V> valueSelector;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class GroupBySubscriber<T, K, V> extends BasicIntQueueSubscription<GroupedFlowable<K, V>> implements Subscriber<T> {
        static final Object NULL_KEY = new Object();
        private static final long serialVersionUID = -3688291656102519502L;
        final Subscriber<? super GroupedFlowable<K, V>> actual;
        final int bufferSize;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final Function<? super T, ? extends K> keySelector;
        boolean outputFused;
        final SpscLinkedArrayQueue<GroupedFlowable<K, V>> queue;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43184s;
        final Function<? super T, ? extends V> valueSelector;
        final AtomicBoolean cancelled = new AtomicBoolean();
        final AtomicLong requested = new AtomicLong();
        final AtomicInteger groupCount = new AtomicInteger(1);
        final Map<Object, GroupedUnicast<K, V>> groups = new ConcurrentHashMap();

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled.compareAndSet(false, true) && this.groupCount.decrementAndGet() == 0) {
                this.f43184s.cancel();
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i6) {
            if ((i6 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        boolean checkTerminated(boolean z5, boolean z6, Subscriber<?> subscriber, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            if (this.cancelled.get()) {
                spscLinkedArrayQueue.clear();
                return true;
            }
            if (this.delayError) {
                if (!z5 || !z6) {
                    return false;
                }
                Throwable th = this.error;
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
            if (!z5) {
                return false;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                spscLinkedArrayQueue.clear();
                subscriber.onError(th2);
                return true;
            }
            if (!z6) {
                return false;
            }
            subscriber.onComplete();
            return true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.queue.clear();
        }

        void drainFused() {
            Throwable th;
            SpscLinkedArrayQueue<GroupedFlowable<K, V>> spscLinkedArrayQueue = this.queue;
            Subscriber<? super GroupedFlowable<K, V>> subscriber = this.actual;
            int i6 = 1;
            while (!this.cancelled.get()) {
                boolean z5 = this.done;
                if (z5 && !this.delayError && (th = this.error) != null) {
                    spscLinkedArrayQueue.clear();
                    subscriber.onError(th);
                    return;
                }
                subscriber.onNext(null);
                if (z5) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        subscriber.onError(th2);
                        return;
                    } else {
                        subscriber.onComplete();
                        return;
                    }
                }
                i6 = addAndGet(-i6);
                if (i6 == 0) {
                    return;
                }
            }
            spscLinkedArrayQueue.clear();
        }

        void drainNormal() {
            SpscLinkedArrayQueue<GroupedFlowable<K, V>> spscLinkedArrayQueue = this.queue;
            Subscriber<? super GroupedFlowable<K, V>> subscriber = this.actual;
            int i6 = 1;
            do {
                long j6 = this.requested.get();
                long j7 = 0;
                while (j7 != j6) {
                    boolean z5 = this.done;
                    GroupedFlowable<K, V> poll = spscLinkedArrayQueue.poll();
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
                if (j7 != 0) {
                    if (j6 != Long.MAX_VALUE) {
                        this.requested.addAndGet(-j7);
                    }
                    this.f43184s.request(j7);
                }
                i6 = addAndGet(-i6);
            } while (i6 != 0);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            Iterator<GroupedUnicast<K, V>> it = this.groups.values().iterator();
            while (it.hasNext()) {
                it.next().onComplete();
            }
            this.groups.clear();
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            Iterator<GroupedUnicast<K, V>> it = this.groups.values().iterator();
            while (it.hasNext()) {
                it.next().onError(th);
            }
            this.groups.clear();
            this.error = th;
            this.done = true;
            drain();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            boolean z5;
            GroupedUnicast groupedUnicast;
            if (this.done) {
                return;
            }
            SpscLinkedArrayQueue<GroupedFlowable<K, V>> spscLinkedArrayQueue = this.queue;
            try {
                K apply = this.keySelector.apply(t5);
                Object obj = apply != null ? apply : NULL_KEY;
                GroupedUnicast<K, V> groupedUnicast2 = this.groups.get(obj);
                if (groupedUnicast2 != null) {
                    z5 = false;
                    groupedUnicast = groupedUnicast2;
                } else {
                    if (this.cancelled.get()) {
                        return;
                    }
                    GroupedUnicast createWith = GroupedUnicast.createWith(apply, this.bufferSize, this, this.delayError);
                    this.groups.put(obj, createWith);
                    this.groupCount.getAndIncrement();
                    z5 = true;
                    groupedUnicast = createWith;
                }
                try {
                    groupedUnicast.onNext(ObjectHelper.requireNonNull(this.valueSelector.apply(t5), "The valueSelector returned null"));
                    if (z5) {
                        spscLinkedArrayQueue.offer(groupedUnicast);
                        drain();
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.f43184s.cancel();
                    onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f43184s.cancel();
                onError(th2);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43184s, subscription)) {
                this.f43184s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(this.bufferSize);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public GroupedFlowable<K, V> poll() {
            return this.queue.poll();
        }

        public GroupBySubscriber(Subscriber<? super GroupedFlowable<K, V>> subscriber, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i6, boolean z5) {
            this.actual = subscriber;
            this.keySelector = function;
            this.valueSelector = function2;
            this.bufferSize = i6;
            this.delayError = z5;
            this.queue = new SpscLinkedArrayQueue<>(i6);
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

        public void cancel(K k6) {
            if (k6 == null) {
                k6 = (K) NULL_KEY;
            }
            this.groups.remove(k6);
            if (this.groupCount.decrementAndGet() == 0) {
                this.f43184s.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class GroupedUnicast<K, T> extends GroupedFlowable<K, T> {
        final State<T, K> state;

        public static <T, K> GroupedUnicast<K, T> createWith(K k6, int i6, GroupBySubscriber<?, K, T> groupBySubscriber, boolean z5) {
            return new GroupedUnicast<>(k6, new State(i6, groupBySubscriber, k6, z5));
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

        @Override // io.reactivex.Flowable
        protected void subscribeActual(Subscriber<? super T> subscriber) {
            this.state.subscribe(subscriber);
        }

        protected GroupedUnicast(K k6, State<T, K> state) {
            super(k6);
            this.state = state;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class State<T, K> extends BasicIntQueueSubscription<T> implements Publisher<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final K key;
        boolean outputFused;
        final GroupBySubscriber<?, K, T> parent;
        int produced;
        final SpscLinkedArrayQueue<T> queue;
        final AtomicLong requested = new AtomicLong();
        final AtomicBoolean cancelled = new AtomicBoolean();
        final AtomicReference<Subscriber<? super T>> actual = new AtomicReference<>();
        final AtomicBoolean once = new AtomicBoolean();

        public void onComplete() {
            this.done = true;
            drain();
        }

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
            if (this.cancelled.compareAndSet(false, true)) {
                this.parent.cancel(this.key);
            }
        }

        boolean checkTerminated(boolean z5, boolean z6, Subscriber<? super T> subscriber, boolean z7) {
            if (this.cancelled.get()) {
                this.queue.clear();
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
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                this.queue.clear();
                subscriber.onError(th2);
                return true;
            }
            if (!z6) {
                return false;
            }
            subscriber.onComplete();
            return true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.queue.clear();
        }

        void drainFused() {
            Throwable th;
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
            Subscriber<? super T> subscriber = this.actual.get();
            int i6 = 1;
            while (true) {
                if (subscriber != null) {
                    if (this.cancelled.get()) {
                        spscLinkedArrayQueue.clear();
                        return;
                    }
                    boolean z5 = this.done;
                    if (z5 && !this.delayError && (th = this.error) != null) {
                        spscLinkedArrayQueue.clear();
                        subscriber.onError(th);
                        return;
                    }
                    subscriber.onNext(null);
                    if (z5) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            subscriber.onError(th2);
                            return;
                        } else {
                            subscriber.onComplete();
                            return;
                        }
                    }
                }
                i6 = addAndGet(-i6);
                if (i6 == 0) {
                    return;
                }
                if (subscriber == null) {
                    subscriber = this.actual.get();
                }
            }
        }

        void drainNormal() {
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
            boolean z5 = this.delayError;
            Subscriber<? super T> subscriber = this.actual.get();
            int i6 = 1;
            while (true) {
                if (subscriber != null) {
                    long j6 = this.requested.get();
                    long j7 = 0;
                    while (j7 != j6) {
                        boolean z6 = this.done;
                        T poll = spscLinkedArrayQueue.poll();
                        boolean z7 = poll == null;
                        if (checkTerminated(z6, z7, subscriber, z5)) {
                            return;
                        }
                        if (z7) {
                            break;
                        }
                        subscriber.onNext(poll);
                        j7++;
                    }
                    if (j7 == j6 && checkTerminated(this.done, spscLinkedArrayQueue.isEmpty(), subscriber, z5)) {
                        return;
                    }
                    if (j7 != 0) {
                        if (j6 != Long.MAX_VALUE) {
                            this.requested.addAndGet(-j7);
                        }
                        this.parent.f43184s.request(j7);
                    }
                }
                i6 = addAndGet(-i6);
                if (i6 == 0) {
                    return;
                }
                if (subscriber == null) {
                    subscriber = this.actual.get();
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.queue.isEmpty();
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

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() {
            T poll = this.queue.poll();
            if (poll != null) {
                this.produced++;
                return poll;
            }
            int i6 = this.produced;
            if (i6 == 0) {
                return null;
            }
            this.produced = 0;
            this.parent.f43184s.request(i6);
            return null;
        }

        @Override // org.reactivestreams.Publisher
        public void subscribe(Subscriber<? super T> subscriber) {
            if (!this.once.compareAndSet(false, true)) {
                EmptySubscription.error(new IllegalStateException("Only one Subscriber allowed!"), subscriber);
                return;
            }
            subscriber.onSubscribe(this);
            this.actual.lazySet(subscriber);
            drain();
        }

        State(int i6, GroupBySubscriber<?, K, T> groupBySubscriber, K k6, boolean z5) {
            this.queue = new SpscLinkedArrayQueue<>(i6);
            this.parent = groupBySubscriber;
            this.key = k6;
            this.delayError = z5;
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

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super GroupedFlowable<K, V>> subscriber) {
        this.source.subscribe(new GroupBySubscriber(subscriber, this.keySelector, this.valueSelector, this.bufferSize, this.delayError));
    }

    public FlowableGroupBy(Publisher<T> publisher, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i6, boolean z5) {
        super(publisher);
        this.keySelector = function;
        this.valueSelector = function2;
        this.bufferSize = i6;
        this.delayError = z5;
    }
}
