package io.reactivex.internal.operators.flowable;

import androidx.camera.view.p;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.subscribers.SubscriberResourceWrapper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Timed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableReplay<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T> {
    static final Callable DEFAULT_UNBOUNDED_FACTORY = new Callable() { // from class: io.reactivex.internal.operators.flowable.FlowableReplay.1
        @Override // java.util.concurrent.Callable
        public Object call() {
            return new UnboundedReplayBuffer(16);
        }
    };
    final Callable<? extends ReplayBuffer<T>> bufferFactory;
    final AtomicReference<ReplaySubscriber<T>> current;
    final Publisher<T> onSubscribe;
    final Publisher<T> source;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        long index;
        int size;
        Node tail;

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void replay(InnerSubscription<T> innerSubscription) {
            Node node;
            synchronized (innerSubscription) {
                try {
                    if (innerSubscription.emitting) {
                        innerSubscription.missed = true;
                        return;
                    }
                    innerSubscription.emitting = true;
                    while (!innerSubscription.isDisposed()) {
                        long j6 = innerSubscription.get();
                        boolean z5 = j6 == Long.MAX_VALUE;
                        Node node2 = (Node) innerSubscription.index();
                        if (node2 == null) {
                            node2 = get();
                            innerSubscription.index = node2;
                            BackpressureHelper.add(innerSubscription.totalRequested, node2.index);
                        }
                        long j7 = 0;
                        while (j6 != 0 && (node = node2.get()) != null) {
                            Object leaveTransform = leaveTransform(node.value);
                            try {
                                if (NotificationLite.accept(leaveTransform, innerSubscription.child)) {
                                    innerSubscription.index = null;
                                    return;
                                }
                                j7++;
                                j6--;
                                if (innerSubscription.isDisposed()) {
                                    return;
                                } else {
                                    node2 = node;
                                }
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                innerSubscription.index = null;
                                innerSubscription.dispose();
                                if (NotificationLite.isError(leaveTransform) || NotificationLite.isComplete(leaveTransform)) {
                                    return;
                                }
                                innerSubscription.child.onError(th);
                                return;
                            }
                        }
                        if (j7 != 0) {
                            innerSubscription.index = node2;
                            if (!z5) {
                                innerSubscription.produced(j7);
                            }
                        }
                        synchronized (innerSubscription) {
                            try {
                                if (!innerSubscription.missed) {
                                    innerSubscription.emitting = false;
                                    return;
                                }
                                innerSubscription.missed = false;
                            } finally {
                            }
                        }
                    }
                } finally {
                }
            }
        }

        final void addLast(Node node) {
            this.tail.set(node);
            this.tail = node;
            this.size++;
        }

        boolean hasCompleted() {
            Object obj = this.tail.value;
            return obj != null && NotificationLite.isComplete(leaveTransform(obj));
        }

        boolean hasError() {
            Object obj = this.tail.value;
            return obj != null && NotificationLite.isError(leaveTransform(obj));
        }

        BoundedReplayBuffer() {
            Node node = new Node(null, 0L);
            this.tail = node;
            set(node);
        }

        final void collect(Collection<? super T> collection) {
            Node node = get();
            while (true) {
                node = node.get();
                if (node != null) {
                    Object leaveTransform = leaveTransform(node.value);
                    if (!NotificationLite.isComplete(leaveTransform) && !NotificationLite.isError(leaveTransform)) {
                        collection.add((Object) NotificationLite.getValue(leaveTransform));
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void complete() {
            Object enterTransform = enterTransform(NotificationLite.complete());
            long j6 = this.index + 1;
            this.index = j6;
            addLast(new Node(enterTransform, j6));
            truncateFinal();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void error(Throwable th) {
            Object enterTransform = enterTransform(NotificationLite.error(th));
            long j6 = this.index + 1;
            this.index = j6;
            addLast(new Node(enterTransform, j6));
            truncateFinal();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void next(T t5) {
            Object enterTransform = enterTransform(NotificationLite.next(t5));
            long j6 = this.index + 1;
            this.index = j6;
            addLast(new Node(enterTransform, j6));
            truncate();
        }

        final void removeFirst() {
            Node node = get().get();
            if (node != null) {
                this.size--;
                setFirst(node);
                return;
            }
            throw new IllegalStateException("Empty list!");
        }

        final void removeSome(int i6) {
            Node node = get();
            while (i6 > 0) {
                node = node.get();
                i6--;
                this.size--;
            }
            setFirst(node);
        }

        final void setFirst(Node node) {
            set(node);
        }

        void truncate() {
        }

        void truncateFinal() {
        }

        Object enterTransform(Object obj) {
            return obj;
        }

        Object leaveTransform(Object obj) {
            return obj;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class InnerSubscription<T> extends AtomicLong implements Subscription, Disposable {
        static final long CANCELLED = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;
        final Subscriber<? super T> child;
        boolean emitting;
        Object index;
        boolean missed;
        final ReplaySubscriber<T> parent;
        final AtomicLong totalRequested = new AtomicLong();

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
                this.parent.manageRequests();
            }
        }

        <U> U index() {
            return (U) this.index;
        }

        InnerSubscription(ReplaySubscriber<T> replaySubscriber, Subscriber<? super T> subscriber) {
            this.parent = replaySubscriber;
            this.child = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() == Long.MIN_VALUE) {
                return true;
            }
            return false;
        }

        public long produced(long j6) {
            return BackpressureHelper.producedCancel(this, j6);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            long j7;
            if (SubscriptionHelper.validate(j6)) {
                do {
                    j7 = get();
                    if (j7 != Long.MIN_VALUE) {
                        if (j7 >= 0 && j6 == 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(j7, BackpressureHelper.addCap(j7, j6)));
                BackpressureHelper.add(this.totalRequested, j6);
                this.parent.manageRequests();
                this.parent.buffer.replay(this);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface ReplayBuffer<T> {
        void complete();

        void error(Throwable th);

        void next(T t5);

        void replay(InnerSubscription<T> innerSubscription);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ReplaySubscriber<T> implements Subscriber<T>, Disposable {
        static final InnerSubscription[] EMPTY = new InnerSubscription[0];
        static final InnerSubscription[] TERMINATED = new InnerSubscription[0];
        final ReplayBuffer<T> buffer;
        boolean done;
        long maxChildRequested;
        long maxUpstreamRequested;
        volatile Subscription subscription;
        final AtomicInteger management = new AtomicInteger();
        final AtomicReference<InnerSubscription<T>[]> subscribers = new AtomicReference<>(EMPTY);
        final AtomicBoolean shouldConnect = new AtomicBoolean();

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.subscribers.set(TERMINATED);
            this.subscription.cancel();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.subscribers.get() == TERMINATED;
        }

        void manageRequests() {
            if (this.management.getAndIncrement() != 0) {
                return;
            }
            int i6 = 1;
            while (!isDisposed()) {
                InnerSubscription<T>[] innerSubscriptionArr = this.subscribers.get();
                long j6 = this.maxChildRequested;
                long j7 = j6;
                for (InnerSubscription<T> innerSubscription : innerSubscriptionArr) {
                    j7 = Math.max(j7, innerSubscription.totalRequested.get());
                }
                long j8 = this.maxUpstreamRequested;
                Subscription subscription = this.subscription;
                long j9 = j7 - j6;
                if (j9 != 0) {
                    this.maxChildRequested = j7;
                    if (subscription == null) {
                        long j10 = j8 + j9;
                        if (j10 < 0) {
                            j10 = Long.MAX_VALUE;
                        }
                        this.maxUpstreamRequested = j10;
                    } else if (j8 != 0) {
                        this.maxUpstreamRequested = 0L;
                        subscription.request(j8 + j9);
                    } else {
                        subscription.request(j9);
                    }
                } else if (j8 != 0 && subscription != null) {
                    this.maxUpstreamRequested = 0L;
                    subscription.request(j8);
                }
                i6 = this.management.addAndGet(-i6);
                if (i6 == 0) {
                    return;
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.buffer.complete();
            for (InnerSubscription<T> innerSubscription : this.subscribers.getAndSet(TERMINATED)) {
                this.buffer.replay(innerSubscription);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.buffer.error(th);
            for (InnerSubscription<T> innerSubscription : this.subscribers.getAndSet(TERMINATED)) {
                this.buffer.replay(innerSubscription);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (this.done) {
                return;
            }
            this.buffer.next(t5);
            for (InnerSubscription<T> innerSubscription : this.subscribers.get()) {
                this.buffer.replay(innerSubscription);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.subscription, subscription)) {
                this.subscription = subscription;
                manageRequests();
                for (InnerSubscription<T> innerSubscription : this.subscribers.get()) {
                    this.buffer.replay(innerSubscription);
                }
            }
        }

        void remove(InnerSubscription<T> innerSubscription) {
            InnerSubscription<T>[] innerSubscriptionArr;
            InnerSubscription[] innerSubscriptionArr2;
            do {
                innerSubscriptionArr = this.subscribers.get();
                int length = innerSubscriptionArr.length;
                if (length == 0) {
                    return;
                }
                int i6 = 0;
                while (true) {
                    if (i6 >= length) {
                        i6 = -1;
                        break;
                    } else if (innerSubscriptionArr[i6].equals(innerSubscription)) {
                        break;
                    } else {
                        i6++;
                    }
                }
                if (i6 < 0) {
                    return;
                }
                if (length == 1) {
                    innerSubscriptionArr2 = EMPTY;
                } else {
                    InnerSubscription[] innerSubscriptionArr3 = new InnerSubscription[length - 1];
                    System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr3, 0, i6);
                    System.arraycopy(innerSubscriptionArr, i6 + 1, innerSubscriptionArr3, i6, (length - i6) - 1);
                    innerSubscriptionArr2 = innerSubscriptionArr3;
                }
            } while (!p.a(this.subscribers, innerSubscriptionArr, innerSubscriptionArr2));
        }

        ReplaySubscriber(ReplayBuffer<T> replayBuffer) {
            this.buffer = replayBuffer;
        }

        boolean add(InnerSubscription<T> innerSubscription) {
            InnerSubscription<T>[] innerSubscriptionArr;
            InnerSubscription[] innerSubscriptionArr2;
            innerSubscription.getClass();
            do {
                innerSubscriptionArr = this.subscribers.get();
                if (innerSubscriptionArr == TERMINATED) {
                    return false;
                }
                int length = innerSubscriptionArr.length;
                innerSubscriptionArr2 = new InnerSubscription[length + 1];
                System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr2, 0, length);
                innerSubscriptionArr2[length] = innerSubscription;
            } while (!p.a(this.subscribers, innerSubscriptionArr, innerSubscriptionArr2));
            return true;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        final int limit;
        final long maxAge;
        final Scheduler scheduler;
        final TimeUnit unit;

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        Object enterTransform(Object obj) {
            return new Timed(obj, this.scheduler.now(this.unit), this.unit);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        Object leaveTransform(Object obj) {
            return ((Timed) obj).value();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        void truncate() {
            Node node;
            long now = this.scheduler.now(this.unit) - this.maxAge;
            Node node2 = get();
            Node node3 = node2.get();
            int i6 = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 != null) {
                    int i7 = this.size;
                    if (i7 <= this.limit) {
                        if (((Timed) node2.value).time() > now) {
                            break;
                        }
                        i6++;
                        this.size--;
                        node3 = node2.get();
                    } else {
                        i6++;
                        this.size = i7 - 1;
                        node3 = node2.get();
                    }
                } else {
                    break;
                }
            }
            if (i6 != 0) {
                setFirst(node);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x003e, code lost:
        
            setFirst(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0041, code lost:
        
            return;
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void truncateFinal() {
            /*
                r10 = this;
                io.reactivex.Scheduler r0 = r10.scheduler
                java.util.concurrent.TimeUnit r1 = r10.unit
                long r0 = r0.now(r1)
                long r2 = r10.maxAge
                long r0 = r0 - r2
                java.lang.Object r2 = r10.get()
                io.reactivex.internal.operators.flowable.FlowableReplay$Node r2 = (io.reactivex.internal.operators.flowable.FlowableReplay.Node) r2
                java.lang.Object r3 = r2.get()
                io.reactivex.internal.operators.flowable.FlowableReplay$Node r3 = (io.reactivex.internal.operators.flowable.FlowableReplay.Node) r3
                r4 = 0
            L18:
                r9 = r3
                r3 = r2
                r2 = r9
                if (r2 == 0) goto L3c
                int r5 = r10.size
                r6 = 1
                if (r5 <= r6) goto L3c
                java.lang.Object r5 = r2.value
                io.reactivex.schedulers.Timed r5 = (io.reactivex.schedulers.Timed) r5
                long r7 = r5.time()
                int r5 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r5 > 0) goto L3c
                int r4 = r4 + 1
                int r3 = r10.size
                int r3 = r3 - r6
                r10.size = r3
                java.lang.Object r3 = r2.get()
                io.reactivex.internal.operators.flowable.FlowableReplay$Node r3 = (io.reactivex.internal.operators.flowable.FlowableReplay.Node) r3
                goto L18
            L3c:
                if (r4 == 0) goto L41
                r10.setFirst(r3)
            L41:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableReplay.SizeAndTimeBoundReplayBuffer.truncateFinal():void");
        }

        SizeAndTimeBoundReplayBuffer(int i6, long j6, TimeUnit timeUnit, Scheduler scheduler) {
            this.scheduler = scheduler;
            this.limit = i6;
            this.maxAge = j6;
            this.unit = timeUnit;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        final int limit;

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        void truncate() {
            if (this.size > this.limit) {
                removeFirst();
            }
        }

        SizeBoundReplayBuffer(int i6) {
            this.limit = i6;
        }
    }

    public static <T> ConnectableFlowable<T> create(Publisher<T> publisher, final int i6) {
        return i6 == Integer.MAX_VALUE ? createFrom(publisher) : create(publisher, new Callable<ReplayBuffer<T>>() { // from class: io.reactivex.internal.operators.flowable.FlowableReplay.4
            @Override // java.util.concurrent.Callable
            public ReplayBuffer<T> call() {
                return new SizeBoundReplayBuffer(i6);
            }
        });
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;
        final long index;
        final Object value;

        Node(Object obj, long j6) {
            this.value = obj;
            this.index = j6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        volatile int size;

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void replay(InnerSubscription<T> innerSubscription) {
            synchronized (innerSubscription) {
                try {
                    if (innerSubscription.emitting) {
                        innerSubscription.missed = true;
                        return;
                    }
                    innerSubscription.emitting = true;
                    Subscriber<? super T> subscriber = innerSubscription.child;
                    while (!innerSubscription.isDisposed()) {
                        int i6 = this.size;
                        Integer num = (Integer) innerSubscription.index();
                        int intValue = num != null ? num.intValue() : 0;
                        long j6 = innerSubscription.get();
                        long j7 = j6;
                        long j8 = 0;
                        while (j7 != 0 && intValue < i6) {
                            Object obj = get(intValue);
                            try {
                                if (NotificationLite.accept(obj, subscriber) || innerSubscription.isDisposed()) {
                                    return;
                                }
                                intValue++;
                                j7--;
                                j8++;
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                innerSubscription.dispose();
                                if (NotificationLite.isError(obj) || NotificationLite.isComplete(obj)) {
                                    return;
                                }
                                subscriber.onError(th);
                                return;
                            }
                        }
                        if (j8 != 0) {
                            innerSubscription.index = Integer.valueOf(intValue);
                            if (j6 != Long.MAX_VALUE) {
                                innerSubscription.produced(j8);
                            }
                        }
                        synchronized (innerSubscription) {
                            try {
                                if (!innerSubscription.missed) {
                                    innerSubscription.emitting = false;
                                    return;
                                }
                                innerSubscription.missed = false;
                            } finally {
                            }
                        }
                    }
                } finally {
                }
            }
        }

        UnboundedReplayBuffer(int i6) {
            super(i6);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void complete() {
            add(NotificationLite.complete());
            this.size++;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void error(Throwable th) {
            add(NotificationLite.error(th));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void next(T t5) {
            add(NotificationLite.next(t5));
            this.size++;
        }
    }

    public static <T> ConnectableFlowable<T> createFrom(Publisher<? extends T> publisher) {
        return create(publisher, DEFAULT_UNBOUNDED_FACTORY);
    }

    public static <U, R> Flowable<R> multicastSelector(final Callable<? extends ConnectableFlowable<U>> callable, final Function<? super Flowable<U>, ? extends Publisher<R>> function) {
        return Flowable.unsafeCreate(new Publisher<R>() { // from class: io.reactivex.internal.operators.flowable.FlowableReplay.2
            @Override // org.reactivestreams.Publisher
            public void subscribe(Subscriber<? super R> subscriber) {
                try {
                    ConnectableFlowable connectableFlowable = (ConnectableFlowable) ObjectHelper.requireNonNull(callable.call(), "The connectableFactory returned null");
                    try {
                        Publisher publisher = (Publisher) ObjectHelper.requireNonNull(function.apply(connectableFlowable), "The selector returned a null Publisher");
                        final SubscriberResourceWrapper subscriberResourceWrapper = new SubscriberResourceWrapper(subscriber);
                        publisher.subscribe(subscriberResourceWrapper);
                        connectableFlowable.connect(new Consumer<Disposable>() { // from class: io.reactivex.internal.operators.flowable.FlowableReplay.2.1
                            @Override // io.reactivex.functions.Consumer
                            public void accept(Disposable disposable) {
                                subscriberResourceWrapper.setResource(disposable);
                            }
                        });
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        EmptySubscription.error(th, subscriber);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    EmptySubscription.error(th2, subscriber);
                }
            }
        });
    }

    @Override // io.reactivex.flowables.ConnectableFlowable
    public void connect(Consumer<? super Disposable> consumer) {
        ReplaySubscriber<T> replaySubscriber;
        while (true) {
            replaySubscriber = this.current.get();
            if (replaySubscriber != null && !replaySubscriber.isDisposed()) {
                break;
            }
            try {
                ReplaySubscriber<T> replaySubscriber2 = new ReplaySubscriber<>(this.bufferFactory.call());
                if (p.a(this.current, replaySubscriber, replaySubscriber2)) {
                    replaySubscriber = replaySubscriber2;
                    break;
                }
            } finally {
                Exceptions.throwIfFatal(th);
                RuntimeException wrapOrThrow = ExceptionHelper.wrapOrThrow(th);
            }
        }
        boolean z5 = !replaySubscriber.shouldConnect.get() && replaySubscriber.shouldConnect.compareAndSet(false, true);
        try {
            consumer.accept(replaySubscriber);
            if (z5) {
                this.source.subscribe(replaySubscriber);
            }
        } catch (Throwable th) {
            if (z5) {
                replaySubscriber.shouldConnect.compareAndSet(true, false);
            }
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamPublisher
    public Publisher<T> source() {
        return this.source;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.onSubscribe.subscribe(subscriber);
    }

    private FlowableReplay(Publisher<T> publisher, Publisher<T> publisher2, AtomicReference<ReplaySubscriber<T>> atomicReference, Callable<? extends ReplayBuffer<T>> callable) {
        this.onSubscribe = publisher;
        this.source = publisher2;
        this.current = atomicReference;
        this.bufferFactory = callable;
    }

    public static <T> ConnectableFlowable<T> create(Publisher<T> publisher, long j6, TimeUnit timeUnit, Scheduler scheduler) {
        return create(publisher, j6, timeUnit, scheduler, Integer.MAX_VALUE);
    }

    public static <T> ConnectableFlowable<T> observeOn(final ConnectableFlowable<T> connectableFlowable, Scheduler scheduler) {
        final Flowable<T> observeOn = connectableFlowable.observeOn(scheduler);
        return RxJavaPlugins.onAssembly((ConnectableFlowable) new ConnectableFlowable<T>() { // from class: io.reactivex.internal.operators.flowable.FlowableReplay.3
            @Override // io.reactivex.flowables.ConnectableFlowable
            public void connect(Consumer<? super Disposable> consumer) {
                ConnectableFlowable.this.connect(consumer);
            }

            @Override // io.reactivex.Flowable
            protected void subscribeActual(Subscriber<? super T> subscriber) {
                observeOn.subscribe(subscriber);
            }
        });
    }

    public static <T> ConnectableFlowable<T> create(Publisher<T> publisher, final long j6, final TimeUnit timeUnit, final Scheduler scheduler, final int i6) {
        return create(publisher, new Callable<ReplayBuffer<T>>() { // from class: io.reactivex.internal.operators.flowable.FlowableReplay.5
            @Override // java.util.concurrent.Callable
            public ReplayBuffer<T> call() {
                return new SizeAndTimeBoundReplayBuffer(i6, j6, timeUnit, scheduler);
            }
        });
    }

    static <T> ConnectableFlowable<T> create(Publisher<T> publisher, final Callable<? extends ReplayBuffer<T>> callable) {
        final AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.onAssembly((ConnectableFlowable) new FlowableReplay(new Publisher<T>() { // from class: io.reactivex.internal.operators.flowable.FlowableReplay.6
            @Override // org.reactivestreams.Publisher
            public void subscribe(Subscriber<? super T> subscriber) {
                ReplaySubscriber replaySubscriber;
                while (true) {
                    replaySubscriber = (ReplaySubscriber) atomicReference.get();
                    if (replaySubscriber != null) {
                        break;
                    }
                    try {
                        ReplaySubscriber replaySubscriber2 = new ReplaySubscriber((ReplayBuffer) callable.call());
                        if (p.a(atomicReference, null, replaySubscriber2)) {
                            replaySubscriber = replaySubscriber2;
                            break;
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        throw ExceptionHelper.wrapOrThrow(th);
                    }
                }
                InnerSubscription<T> innerSubscription = new InnerSubscription<>(replaySubscriber, subscriber);
                subscriber.onSubscribe(innerSubscription);
                replaySubscriber.add(innerSubscription);
                if (innerSubscription.isDisposed()) {
                    replaySubscriber.remove(innerSubscription);
                } else {
                    replaySubscriber.manageRequests();
                    replaySubscriber.buffer.replay(innerSubscription);
                }
            }
        }, publisher, atomicReference, callable));
    }
}
