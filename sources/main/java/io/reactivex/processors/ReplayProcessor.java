package io.reactivex.processors;

import androidx.camera.view.p;
import io.reactivex.Scheduler;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ReplayProcessor<T> extends FlowableProcessor<T> {
    final ReplayBuffer<T> buffer;
    boolean done;
    final AtomicReference<ReplaySubscription<T>[]> subscribers = new AtomicReference<>(EMPTY);
    private static final Object[] EMPTY_ARRAY = new Object[0];
    static final ReplaySubscription[] EMPTY = new ReplaySubscription[0];
    static final ReplaySubscription[] TERMINATED = new ReplaySubscription[0];

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface ReplayBuffer<T> {
        void add(T t5);

        void addFinal(Object obj);

        Object get();

        T getValue();

        T[] getValues(T[] tArr);

        void replay(ReplaySubscription<T> replaySubscription);

        int size();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ReplaySubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 466549804534799122L;
        final Subscriber<? super T> actual;
        volatile boolean cancelled;
        Object index;
        final AtomicLong requested = new AtomicLong();
        final ReplayProcessor<T> state;

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.state.remove(this);
        }

        ReplaySubscription(Subscriber<? super T> subscriber, ReplayProcessor<T> replayProcessor) {
            this.actual = subscriber;
            this.state = replayProcessor;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            if (SubscriptionHelper.validate(j6)) {
                BackpressureHelper.add(this.requested, j6);
                this.state.buffer.replay(this);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class SizeAndTimeBoundReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 1242561386470847675L;
        volatile boolean done;
        volatile TimedNode<Object> head;
        final long maxAge;
        final int maxSize;
        final Scheduler scheduler;
        int size;
        TimedNode<Object> tail;
        final TimeUnit unit;

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void add(T t5) {
            TimedNode<Object> timedNode = new TimedNode<>(t5, this.scheduler.now(this.unit));
            TimedNode<Object> timedNode2 = this.tail;
            this.tail = timedNode;
            this.size++;
            timedNode2.set(timedNode);
            trim();
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public T getValue() {
            TimedNode<Object> timedNode = this.head;
            TimedNode<Object> timedNode2 = null;
            while (true) {
                TimedNode<T> timedNode3 = timedNode.get();
                if (timedNode3 == null) {
                    break;
                }
                timedNode2 = timedNode;
                timedNode = timedNode3;
            }
            T t5 = (T) timedNode.value;
            if (t5 == null) {
                return null;
            }
            return (NotificationLite.isComplete(t5) || NotificationLite.isError(t5)) ? (T) timedNode2.value : t5;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public T[] getValues(T[] tArr) {
            TimedNode<T> timedNode = this.head;
            int size = size();
            if (size == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            if (tArr.length < size) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
            }
            for (int i6 = 0; i6 != size; i6++) {
                timedNode = timedNode.get();
                tArr[i6] = timedNode.value;
            }
            if (tArr.length > size) {
                tArr[size] = null;
            }
            return tArr;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void replay(ReplaySubscription<T> replaySubscription) {
            if (replaySubscription.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = replaySubscription.actual;
            TimedNode<Object> timedNode = (TimedNode) replaySubscription.index;
            if (timedNode == null) {
                timedNode = this.head;
                if (!this.done) {
                    long now = this.scheduler.now(this.unit) - this.maxAge;
                    TimedNode<T> timedNode2 = timedNode.get();
                    while (timedNode2 != null && timedNode2.time <= now) {
                        TimedNode<T> timedNode3 = timedNode2;
                        timedNode2 = timedNode2.get();
                        timedNode = timedNode3;
                    }
                }
            }
            int i6 = 1;
            do {
                long j6 = replaySubscription.requested.get();
                long j7 = 0;
                while (!replaySubscription.cancelled) {
                    TimedNode<T> timedNode4 = timedNode.get();
                    if (timedNode4 != null) {
                        T t5 = timedNode4.value;
                        if (this.done && timedNode4.get() == null) {
                            if (NotificationLite.isComplete(t5)) {
                                subscriber.onComplete();
                            } else {
                                subscriber.onError(NotificationLite.getError(t5));
                            }
                            replaySubscription.index = null;
                            replaySubscription.cancelled = true;
                            return;
                        }
                        if (j6 == 0) {
                            j6 = replaySubscription.requested.get() + j7;
                            if (j6 == 0) {
                            }
                        }
                        subscriber.onNext(t5);
                        j6--;
                        j7--;
                        timedNode = timedNode4;
                    }
                    if (j7 != 0 && replaySubscription.requested.get() != Long.MAX_VALUE) {
                        replaySubscription.requested.addAndGet(j7);
                    }
                    replaySubscription.index = timedNode;
                    i6 = replaySubscription.addAndGet(-i6);
                }
                replaySubscription.index = null;
                return;
            } while (i6 != 0);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
        
            return r1;
         */
        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int size() {
            /*
                r3 = this;
                io.reactivex.processors.ReplayProcessor$TimedNode<java.lang.Object> r0 = r3.head
                r1 = 0
            L3:
                r2 = 2147483647(0x7fffffff, float:NaN)
                if (r1 == r2) goto L25
                java.lang.Object r2 = r0.get()
                io.reactivex.processors.ReplayProcessor$TimedNode r2 = (io.reactivex.processors.ReplayProcessor.TimedNode) r2
                if (r2 != 0) goto L21
                T r0 = r0.value
                boolean r2 = io.reactivex.internal.util.NotificationLite.isComplete(r0)
                if (r2 != 0) goto L1e
                boolean r0 = io.reactivex.internal.util.NotificationLite.isError(r0)
                if (r0 == 0) goto L25
            L1e:
                int r1 = r1 + (-1)
                return r1
            L21:
                int r1 = r1 + 1
                r0 = r2
                goto L3
            L25:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.processors.ReplayProcessor.SizeAndTimeBoundReplayBuffer.size():int");
        }

        void trim() {
            int i6 = this.size;
            if (i6 > this.maxSize) {
                this.size = i6 - 1;
                this.head = this.head.get();
            }
            long now = this.scheduler.now(this.unit) - this.maxAge;
            TimedNode<Object> timedNode = this.head;
            while (true) {
                TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2 == null) {
                    this.head = timedNode;
                    return;
                } else {
                    if (timedNode2.time > now) {
                        this.head = timedNode;
                        return;
                    }
                    timedNode = timedNode2;
                }
            }
        }

        void trimFinal() {
            long now = this.scheduler.now(this.unit) - this.maxAge;
            TimedNode<Object> timedNode = this.head;
            while (true) {
                TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2.get() == null) {
                    this.head = timedNode;
                    return;
                } else {
                    if (timedNode2.time > now) {
                        this.head = timedNode;
                        return;
                    }
                    timedNode = timedNode2;
                }
            }
        }

        SizeAndTimeBoundReplayBuffer(int i6, long j6, TimeUnit timeUnit, Scheduler scheduler) {
            this.maxSize = ObjectHelper.verifyPositive(i6, "maxSize");
            this.maxAge = ObjectHelper.verifyPositive(j6, "maxAge");
            this.unit = (TimeUnit) ObjectHelper.requireNonNull(timeUnit, "unit is null");
            this.scheduler = (Scheduler) ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            TimedNode<Object> timedNode = new TimedNode<>(null, 0L);
            this.tail = timedNode;
            this.head = timedNode;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void addFinal(Object obj) {
            lazySet(obj);
            TimedNode<Object> timedNode = new TimedNode<>(obj, Long.MAX_VALUE);
            TimedNode<Object> timedNode2 = this.tail;
            this.tail = timedNode;
            this.size++;
            timedNode2.set(timedNode);
            trimFinal();
            this.done = true;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class SizeBoundReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 3027920763113911982L;
        volatile boolean done;
        volatile Node<Object> head;
        final int maxSize;
        int size;
        Node<Object> tail;

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void add(T t5) {
            Node<Object> node = new Node<>(t5);
            Node<Object> node2 = this.tail;
            this.tail = node;
            this.size++;
            node2.set(node);
            trim();
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public T getValue() {
            Node<Object> node = this.head;
            Node<Object> node2 = null;
            while (true) {
                Node<T> node3 = node.get();
                if (node3 == null) {
                    break;
                }
                node2 = node;
                node = node3;
            }
            T t5 = (T) node.value;
            if (t5 == null) {
                return null;
            }
            return (NotificationLite.isComplete(t5) || NotificationLite.isError(t5)) ? (T) node2.value : t5;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public T[] getValues(T[] tArr) {
            Node<T> node = this.head;
            int size = size();
            if (size == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            if (tArr.length < size) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
            }
            for (int i6 = 0; i6 != size; i6++) {
                node = node.get();
                tArr[i6] = node.value;
            }
            if (tArr.length > size) {
                tArr[size] = null;
            }
            return tArr;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
        
            return r1;
         */
        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int size() {
            /*
                r3 = this;
                io.reactivex.processors.ReplayProcessor$Node<java.lang.Object> r0 = r3.head
                r1 = 0
            L3:
                r2 = 2147483647(0x7fffffff, float:NaN)
                if (r1 == r2) goto L25
                java.lang.Object r2 = r0.get()
                io.reactivex.processors.ReplayProcessor$Node r2 = (io.reactivex.processors.ReplayProcessor.Node) r2
                if (r2 != 0) goto L21
                T r0 = r0.value
                boolean r2 = io.reactivex.internal.util.NotificationLite.isComplete(r0)
                if (r2 != 0) goto L1e
                boolean r0 = io.reactivex.internal.util.NotificationLite.isError(r0)
                if (r0 == 0) goto L25
            L1e:
                int r1 = r1 + (-1)
                return r1
            L21:
                int r1 = r1 + 1
                r0 = r2
                goto L3
            L25:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.processors.ReplayProcessor.SizeBoundReplayBuffer.size():int");
        }

        void trim() {
            int i6 = this.size;
            if (i6 > this.maxSize) {
                this.size = i6 - 1;
                this.head = this.head.get();
            }
        }

        SizeBoundReplayBuffer(int i6) {
            this.maxSize = ObjectHelper.verifyPositive(i6, "maxSize");
            Node<Object> node = new Node<>(null);
            this.tail = node;
            this.head = node;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void addFinal(Object obj) {
            lazySet(obj);
            Node<Object> node = new Node<>(obj);
            Node<Object> node2 = this.tail;
            this.tail = node;
            this.size++;
            node2.set(node);
            this.done = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void replay(ReplaySubscription<T> replaySubscription) {
            if (replaySubscription.getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = replaySubscription.actual;
                Node<Object> node = (Node) replaySubscription.index;
                if (node == null) {
                    node = this.head;
                }
                int i6 = 1;
                do {
                    long j6 = replaySubscription.requested.get();
                    long j7 = 0;
                    while (!replaySubscription.cancelled) {
                        Node<T> node2 = node.get();
                        if (node2 != null) {
                            T t5 = node2.value;
                            if (this.done && node2.get() == null) {
                                if (NotificationLite.isComplete(t5)) {
                                    subscriber.onComplete();
                                } else {
                                    subscriber.onError(NotificationLite.getError(t5));
                                }
                                replaySubscription.index = null;
                                replaySubscription.cancelled = true;
                                return;
                            }
                            if (j6 == 0) {
                                j6 = replaySubscription.requested.get() + j7;
                                if (j6 == 0) {
                                }
                            }
                            subscriber.onNext(t5);
                            j6--;
                            j7--;
                            node = node2;
                        }
                        if (j7 != 0 && replaySubscription.requested.get() != Long.MAX_VALUE) {
                            replaySubscription.requested.addAndGet(j7);
                        }
                        replaySubscription.index = node;
                        i6 = replaySubscription.addAndGet(-i6);
                    }
                    replaySubscription.index = null;
                    return;
                } while (i6 != 0);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class UnboundedReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = -4457200895834877300L;
        final List<Object> buffer;
        volatile boolean done;
        volatile int size;

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void add(T t5) {
            this.buffer.add(t5);
            this.size++;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public T getValue() {
            int i6 = this.size;
            if (i6 == 0) {
                return null;
            }
            List<Object> list = this.buffer;
            T t5 = (T) list.get(i6 - 1);
            if (!NotificationLite.isComplete(t5) && !NotificationLite.isError(t5)) {
                return t5;
            }
            if (i6 == 1) {
                return null;
            }
            return (T) list.get(i6 - 2);
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public T[] getValues(T[] tArr) {
            int i6 = this.size;
            if (i6 == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            List<Object> list = this.buffer;
            Object obj = list.get(i6 - 1);
            if ((NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) && i6 - 1 == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            if (tArr.length < i6) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i6));
            }
            for (int i7 = 0; i7 < i6; i7++) {
                tArr[i7] = list.get(i7);
            }
            if (tArr.length > i6) {
                tArr[i6] = null;
            }
            return tArr;
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0086, code lost:
        
            if (r13 == r16) goto L44;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0095, code lost:
        
            if (r19.requested.get() == Long.MAX_VALUE) goto L44;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0097, code lost:
        
            r9 = r19.requested.addAndGet(r13);
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x009f, code lost:
        
            if (r4 == r18.size) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00a3, code lost:
        
            if (r9 == r16) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00a7, code lost:
        
            r19.index = java.lang.Integer.valueOf(r4);
            r6 = r19.addAndGet(-r6);
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00b2, code lost:
        
            if (r6 != 0) goto L60;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0025, code lost:
        
            continue;
         */
        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void replay(io.reactivex.processors.ReplayProcessor.ReplaySubscription<T> r19) {
            /*
                r18 = this;
                r0 = r18
                r1 = r19
                int r2 = r1.getAndIncrement()
                if (r2 == 0) goto Lc
                goto Lb4
            Lc:
                java.util.List<java.lang.Object> r2 = r0.buffer
                org.reactivestreams.Subscriber<? super T> r3 = r1.actual
                java.lang.Object r4 = r1.index
                java.lang.Integer r4 = (java.lang.Integer) r4
                r5 = 1
                if (r4 == 0) goto L1d
                int r4 = r4.intValue()
            L1b:
                r6 = 1
                goto L25
            L1d:
                r4 = 0
                java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
                r1.index = r6
                goto L1b
            L25:
                boolean r7 = r1.cancelled
                r8 = 0
                if (r7 == 0) goto L2d
                r1.index = r8
                return
            L2d:
                int r7 = r0.size
                java.util.concurrent.atomic.AtomicLong r9 = r1.requested
                long r9 = r9.get()
                r13 = 0
            L37:
                if (r7 == r4) goto L82
                boolean r15 = r1.cancelled
                if (r15 == 0) goto L40
                r1.index = r8
                return
            L40:
                java.lang.Object r15 = r2.get(r4)
                r16 = 0
                boolean r11 = r0.done
                if (r11 == 0) goto L68
                int r11 = r4 + 1
                if (r11 != r7) goto L68
                int r7 = r0.size
                if (r11 != r7) goto L68
                boolean r2 = io.reactivex.internal.util.NotificationLite.isComplete(r15)
                if (r2 == 0) goto L5c
                r3.onComplete()
                goto L63
            L5c:
                java.lang.Throwable r2 = io.reactivex.internal.util.NotificationLite.getError(r15)
                r3.onError(r2)
            L63:
                r1.index = r8
                r1.cancelled = r5
                return
            L68:
                int r11 = (r9 > r16 ? 1 : (r9 == r16 ? 0 : -1))
                if (r11 != 0) goto L78
                java.util.concurrent.atomic.AtomicLong r9 = r1.requested
                long r9 = r9.get()
                long r9 = r9 + r13
                int r11 = (r9 > r16 ? 1 : (r9 == r16 ? 0 : -1))
                if (r11 != 0) goto L78
                goto L84
            L78:
                r3.onNext(r15)
                r11 = 1
                long r9 = r9 - r11
                long r13 = r13 - r11
                int r4 = r4 + 1
                goto L37
            L82:
                r16 = 0
            L84:
                int r7 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
                if (r7 == 0) goto L9d
                java.util.concurrent.atomic.AtomicLong r7 = r1.requested
                long r7 = r7.get()
                r11 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r15 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
                if (r15 == 0) goto L9d
                java.util.concurrent.atomic.AtomicLong r7 = r1.requested
                long r9 = r7.addAndGet(r13)
            L9d:
                int r7 = r0.size
                if (r4 == r7) goto La7
                int r7 = (r9 > r16 ? 1 : (r9 == r16 ? 0 : -1))
                if (r7 == 0) goto La7
                goto L25
            La7:
                java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
                r1.index = r7
                int r6 = -r6
                int r6 = r1.addAndGet(r6)
                if (r6 != 0) goto L25
            Lb4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.processors.ReplayProcessor.UnboundedReplayBuffer.replay(io.reactivex.processors.ReplayProcessor$ReplaySubscription):void");
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public int size() {
            int i6 = this.size;
            if (i6 == 0) {
                return 0;
            }
            int i7 = i6 - 1;
            Object obj = this.buffer.get(i7);
            return (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? i7 : i6;
        }

        UnboundedReplayBuffer(int i6) {
            this.buffer = new ArrayList(ObjectHelper.verifyPositive(i6, "capacityHint"));
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void addFinal(Object obj) {
            lazySet(obj);
            this.buffer.add(obj);
            this.size++;
            this.done = true;
        }
    }

    public static <T> ReplayProcessor<T> create() {
        return new ReplayProcessor<>(new UnboundedReplayBuffer(16));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Object[] getValues() {
        Object[] objArr = EMPTY_ARRAY;
        Object[] values = getValues(objArr);
        return values == objArr ? new Object[0] : values;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class Node<T> extends AtomicReference<Node<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final T value;

        Node(T t5) {
            this.value = t5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final long time;
        final T value;

        TimedNode(T t5, long j6) {
            this.value = t5;
            this.time = j6;
        }
    }

    public static <T> ReplayProcessor<T> create(int i6) {
        return new ReplayProcessor<>(new UnboundedReplayBuffer(i6));
    }

    static <T> ReplayProcessor<T> createUnbounded() {
        return new ReplayProcessor<>(new SizeBoundReplayBuffer(Integer.MAX_VALUE));
    }

    public static <T> ReplayProcessor<T> createWithSize(int i6) {
        return new ReplayProcessor<>(new SizeBoundReplayBuffer(i6));
    }

    public static <T> ReplayProcessor<T> createWithTime(long j6, TimeUnit timeUnit, Scheduler scheduler) {
        return new ReplayProcessor<>(new SizeAndTimeBoundReplayBuffer(Integer.MAX_VALUE, j6, timeUnit, scheduler));
    }

    public static <T> ReplayProcessor<T> createWithTimeAndSize(long j6, TimeUnit timeUnit, Scheduler scheduler, int i6) {
        return new ReplayProcessor<>(new SizeAndTimeBoundReplayBuffer(i6, j6, timeUnit, scheduler));
    }

    boolean add(ReplaySubscription<T> replaySubscription) {
        ReplaySubscription<T>[] replaySubscriptionArr;
        ReplaySubscription[] replaySubscriptionArr2;
        do {
            replaySubscriptionArr = this.subscribers.get();
            if (replaySubscriptionArr == TERMINATED) {
                return false;
            }
            int length = replaySubscriptionArr.length;
            replaySubscriptionArr2 = new ReplaySubscription[length + 1];
            System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr2, 0, length);
            replaySubscriptionArr2[length] = replaySubscription;
        } while (!p.a(this.subscribers, replaySubscriptionArr, replaySubscriptionArr2));
        return true;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public Throwable getThrowable() {
        Object obj = this.buffer.get();
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    public T getValue() {
        return this.buffer.getValue();
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasComplete() {
        return NotificationLite.isComplete(this.buffer.get());
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasSubscribers() {
        return this.subscribers.get().length != 0;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasThrowable() {
        return NotificationLite.isError(this.buffer.get());
    }

    public boolean hasValue() {
        return this.buffer.size() != 0;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        Object complete = NotificationLite.complete();
        ReplayBuffer<T> replayBuffer = this.buffer;
        replayBuffer.addFinal(complete);
        for (ReplaySubscription<T> replaySubscription : this.subscribers.getAndSet(TERMINATED)) {
            replayBuffer.replay(replaySubscription);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        if (this.done) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.done = true;
        Object error = NotificationLite.error(th);
        ReplayBuffer<T> replayBuffer = this.buffer;
        replayBuffer.addFinal(error);
        for (ReplaySubscription<T> replaySubscription : this.subscribers.getAndSet(TERMINATED)) {
            replayBuffer.replay(replaySubscription);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t5) {
        if (t5 == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        if (this.done) {
            return;
        }
        ReplayBuffer<T> replayBuffer = this.buffer;
        replayBuffer.add(t5);
        for (ReplaySubscription<T> replaySubscription : this.subscribers.get()) {
            replayBuffer.replay(replaySubscription);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (this.done) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    void remove(ReplaySubscription<T> replaySubscription) {
        ReplaySubscription<T>[] replaySubscriptionArr;
        ReplaySubscription[] replaySubscriptionArr2;
        do {
            replaySubscriptionArr = this.subscribers.get();
            if (replaySubscriptionArr == TERMINATED || replaySubscriptionArr == EMPTY) {
                return;
            }
            int length = replaySubscriptionArr.length;
            int i6 = 0;
            while (true) {
                if (i6 >= length) {
                    i6 = -1;
                    break;
                } else if (replaySubscriptionArr[i6] == replaySubscription) {
                    break;
                } else {
                    i6++;
                }
            }
            if (i6 < 0) {
                return;
            }
            if (length == 1) {
                replaySubscriptionArr2 = EMPTY;
            } else {
                ReplaySubscription[] replaySubscriptionArr3 = new ReplaySubscription[length - 1];
                System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr3, 0, i6);
                System.arraycopy(replaySubscriptionArr, i6 + 1, replaySubscriptionArr3, i6, (length - i6) - 1);
                replaySubscriptionArr2 = replaySubscriptionArr3;
            }
        } while (!p.a(this.subscribers, replaySubscriptionArr, replaySubscriptionArr2));
    }

    int size() {
        return this.buffer.size();
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        ReplaySubscription<T> replaySubscription = new ReplaySubscription<>(subscriber, this);
        subscriber.onSubscribe(replaySubscription);
        if (add(replaySubscription) && replaySubscription.cancelled) {
            remove(replaySubscription);
        } else {
            this.buffer.replay(replaySubscription);
        }
    }

    int subscriberCount() {
        return this.subscribers.get().length;
    }

    ReplayProcessor(ReplayBuffer<T> replayBuffer) {
        this.buffer = replayBuffer;
    }

    public T[] getValues(T[] tArr) {
        return this.buffer.getValues(tArr);
    }
}
