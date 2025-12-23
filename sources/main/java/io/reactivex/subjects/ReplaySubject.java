package io.reactivex.subjects;

import androidx.camera.view.p;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ReplaySubject<T> extends Subject<T> {
    final ReplayBuffer<T> buffer;
    boolean done;
    final AtomicReference<ReplayDisposable<T>[]> observers = new AtomicReference<>(EMPTY);
    static final ReplayDisposable[] EMPTY = new ReplayDisposable[0];
    static final ReplayDisposable[] TERMINATED = new ReplayDisposable[0];
    private static final Object[] EMPTY_ARRAY = new Object[0];

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface ReplayBuffer<T> {
        void add(T t5);

        void addFinal(Object obj);

        boolean compareAndSet(Object obj, Object obj2);

        Object get();

        T getValue();

        T[] getValues(T[] tArr);

        void replay(ReplayDisposable<T> replayDisposable);

        int size();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ReplayDisposable<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 466549804534799122L;
        final Observer<? super T> actual;
        volatile boolean cancelled;
        Object index;
        final ReplaySubject<T> state;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.state.remove(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        ReplayDisposable(Observer<? super T> observer, ReplaySubject<T> replaySubject) {
            this.actual = observer;
            this.state = replaySubject;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class SizeAndTimeBoundReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = -8056260896137901749L;
        volatile boolean done;
        volatile TimedNode<Object> head;
        final long maxAge;
        final int maxSize;
        final Scheduler scheduler;
        int size;
        TimedNode<Object> tail;
        final TimeUnit unit;

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void add(T t5) {
            TimedNode<Object> timedNode = new TimedNode<>(t5, this.scheduler.now(this.unit));
            TimedNode<Object> timedNode2 = this.tail;
            this.tail = timedNode;
            this.size++;
            timedNode2.set(timedNode);
            trim();
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void addFinal(Object obj) {
            TimedNode<Object> timedNode = new TimedNode<>(obj, Long.MAX_VALUE);
            TimedNode<Object> timedNode2 = this.tail;
            this.tail = timedNode;
            this.size++;
            timedNode2.lazySet(timedNode);
            trimFinal();
            this.done = true;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
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

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
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

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
        
            return r1;
         */
        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int size() {
            /*
                r3 = this;
                io.reactivex.subjects.ReplaySubject$TimedNode<java.lang.Object> r0 = r3.head
                r1 = 0
            L3:
                r2 = 2147483647(0x7fffffff, float:NaN)
                if (r1 == r2) goto L25
                java.lang.Object r2 = r0.get()
                io.reactivex.subjects.ReplaySubject$TimedNode r2 = (io.reactivex.subjects.ReplaySubject.TimedNode) r2
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
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.subjects.ReplaySubject.SizeAndTimeBoundReplayBuffer.size():int");
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

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void replay(ReplayDisposable<T> replayDisposable) {
            if (replayDisposable.getAndIncrement() == 0) {
                Observer<? super T> observer = replayDisposable.actual;
                TimedNode<Object> timedNode = (TimedNode) replayDisposable.index;
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
                while (!replayDisposable.cancelled) {
                    while (!replayDisposable.cancelled) {
                        TimedNode<T> timedNode4 = timedNode.get();
                        if (timedNode4 == null) {
                            if (timedNode.get() == null) {
                                replayDisposable.index = timedNode;
                                i6 = replayDisposable.addAndGet(-i6);
                                if (i6 == 0) {
                                    return;
                                }
                            }
                        } else {
                            T t5 = timedNode4.value;
                            if (this.done && timedNode4.get() == null) {
                                if (NotificationLite.isComplete(t5)) {
                                    observer.onComplete();
                                } else {
                                    observer.onError(NotificationLite.getError(t5));
                                }
                                replayDisposable.index = null;
                                replayDisposable.cancelled = true;
                                return;
                            }
                            observer.onNext(t5);
                            timedNode = timedNode4;
                        }
                    }
                    replayDisposable.index = null;
                    return;
                }
                replayDisposable.index = null;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class SizeBoundReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 1107649250281456395L;
        volatile boolean done;
        volatile Node<Object> head;
        final int maxSize;
        int size;
        Node<Object> tail;

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void add(T t5) {
            Node<Object> node = new Node<>(t5);
            Node<Object> node2 = this.tail;
            this.tail = node;
            this.size++;
            node2.set(node);
            trim();
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void addFinal(Object obj) {
            Node<Object> node = new Node<>(obj);
            Node<Object> node2 = this.tail;
            this.tail = node;
            this.size++;
            node2.lazySet(node);
            this.done = true;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
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

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
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
        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int size() {
            /*
                r3 = this;
                io.reactivex.subjects.ReplaySubject$Node<java.lang.Object> r0 = r3.head
                r1 = 0
            L3:
                r2 = 2147483647(0x7fffffff, float:NaN)
                if (r1 == r2) goto L25
                java.lang.Object r2 = r0.get()
                io.reactivex.subjects.ReplaySubject$Node r2 = (io.reactivex.subjects.ReplaySubject.Node) r2
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
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.subjects.ReplaySubject.SizeBoundReplayBuffer.size():int");
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

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void replay(ReplayDisposable<T> replayDisposable) {
            if (replayDisposable.getAndIncrement() == 0) {
                Observer<? super T> observer = replayDisposable.actual;
                Node<Object> node = (Node) replayDisposable.index;
                if (node == null) {
                    node = this.head;
                }
                int i6 = 1;
                while (!replayDisposable.cancelled) {
                    Node<T> node2 = node.get();
                    if (node2 == null) {
                        if (node.get() != null) {
                            continue;
                        } else {
                            replayDisposable.index = node;
                            i6 = replayDisposable.addAndGet(-i6);
                            if (i6 == 0) {
                                return;
                            }
                        }
                    } else {
                        T t5 = node2.value;
                        if (this.done && node2.get() == null) {
                            if (NotificationLite.isComplete(t5)) {
                                observer.onComplete();
                            } else {
                                observer.onError(NotificationLite.getError(t5));
                            }
                            replayDisposable.index = null;
                            replayDisposable.cancelled = true;
                            return;
                        }
                        observer.onNext(t5);
                        node = node2;
                    }
                }
                replayDisposable.index = null;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class UnboundedReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = -733876083048047795L;
        final List<Object> buffer;
        volatile boolean done;
        volatile int size;

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void add(T t5) {
            this.buffer.add(t5);
            this.size++;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void addFinal(Object obj) {
            this.buffer.add(obj);
            this.size++;
            this.done = true;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
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

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
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

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
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

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void replay(ReplayDisposable<T> replayDisposable) {
            int i6;
            int i7;
            if (replayDisposable.getAndIncrement() == 0) {
                List<Object> list = this.buffer;
                Observer<? super T> observer = replayDisposable.actual;
                Integer num = (Integer) replayDisposable.index;
                if (num != null) {
                    i6 = num.intValue();
                } else {
                    i6 = 0;
                    replayDisposable.index = 0;
                }
                int i8 = 1;
                while (!replayDisposable.cancelled) {
                    int i9 = this.size;
                    while (i9 != i6) {
                        if (replayDisposable.cancelled) {
                            replayDisposable.index = null;
                            return;
                        }
                        Object obj = list.get(i6);
                        if (this.done && (i7 = i6 + 1) == i9 && i7 == (i9 = this.size)) {
                            if (NotificationLite.isComplete(obj)) {
                                observer.onComplete();
                            } else {
                                observer.onError(NotificationLite.getError(obj));
                            }
                            replayDisposable.index = null;
                            replayDisposable.cancelled = true;
                            return;
                        }
                        observer.onNext(obj);
                        i6++;
                    }
                    if (i6 == this.size) {
                        replayDisposable.index = Integer.valueOf(i6);
                        i8 = replayDisposable.addAndGet(-i8);
                        if (i8 == 0) {
                            return;
                        }
                    }
                }
                replayDisposable.index = null;
            }
        }
    }

    public static <T> ReplaySubject<T> create() {
        return new ReplaySubject<>(new UnboundedReplayBuffer(16));
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

    public static <T> ReplaySubject<T> create(int i6) {
        return new ReplaySubject<>(new UnboundedReplayBuffer(i6));
    }

    static <T> ReplaySubject<T> createUnbounded() {
        return new ReplaySubject<>(new SizeBoundReplayBuffer(Integer.MAX_VALUE));
    }

    public static <T> ReplaySubject<T> createWithSize(int i6) {
        return new ReplaySubject<>(new SizeBoundReplayBuffer(i6));
    }

    public static <T> ReplaySubject<T> createWithTime(long j6, TimeUnit timeUnit, Scheduler scheduler) {
        return new ReplaySubject<>(new SizeAndTimeBoundReplayBuffer(Integer.MAX_VALUE, j6, timeUnit, scheduler));
    }

    public static <T> ReplaySubject<T> createWithTimeAndSize(long j6, TimeUnit timeUnit, Scheduler scheduler, int i6) {
        return new ReplaySubject<>(new SizeAndTimeBoundReplayBuffer(i6, j6, timeUnit, scheduler));
    }

    boolean add(ReplayDisposable<T> replayDisposable) {
        ReplayDisposable<T>[] replayDisposableArr;
        ReplayDisposable[] replayDisposableArr2;
        do {
            replayDisposableArr = this.observers.get();
            if (replayDisposableArr == TERMINATED) {
                return false;
            }
            int length = replayDisposableArr.length;
            replayDisposableArr2 = new ReplayDisposable[length + 1];
            System.arraycopy(replayDisposableArr, 0, replayDisposableArr2, 0, length);
            replayDisposableArr2[length] = replayDisposable;
        } while (!p.a(this.observers, replayDisposableArr, replayDisposableArr2));
        return true;
    }

    @Override // io.reactivex.subjects.Subject
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

    @Override // io.reactivex.subjects.Subject
    public boolean hasComplete() {
        return NotificationLite.isComplete(this.buffer.get());
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasObservers() {
        return this.observers.get().length != 0;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasThrowable() {
        return NotificationLite.isError(this.buffer.get());
    }

    public boolean hasValue() {
        return this.buffer.size() != 0;
    }

    int observerCount() {
        return this.observers.get().length;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        Object complete = NotificationLite.complete();
        ReplayBuffer<T> replayBuffer = this.buffer;
        replayBuffer.addFinal(complete);
        for (ReplayDisposable<T> replayDisposable : terminate(complete)) {
            replayBuffer.replay(replayDisposable);
        }
    }

    @Override // io.reactivex.Observer
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
        for (ReplayDisposable<T> replayDisposable : terminate(error)) {
            replayBuffer.replay(replayDisposable);
        }
    }

    @Override // io.reactivex.Observer
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
        for (ReplayDisposable<T> replayDisposable : this.observers.get()) {
            replayBuffer.replay(replayDisposable);
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        if (this.done) {
            disposable.dispose();
        }
    }

    void remove(ReplayDisposable<T> replayDisposable) {
        ReplayDisposable<T>[] replayDisposableArr;
        ReplayDisposable[] replayDisposableArr2;
        do {
            replayDisposableArr = this.observers.get();
            if (replayDisposableArr == TERMINATED || replayDisposableArr == EMPTY) {
                return;
            }
            int length = replayDisposableArr.length;
            int i6 = 0;
            while (true) {
                if (i6 >= length) {
                    i6 = -1;
                    break;
                } else if (replayDisposableArr[i6] == replayDisposable) {
                    break;
                } else {
                    i6++;
                }
            }
            if (i6 < 0) {
                return;
            }
            if (length == 1) {
                replayDisposableArr2 = EMPTY;
            } else {
                ReplayDisposable[] replayDisposableArr3 = new ReplayDisposable[length - 1];
                System.arraycopy(replayDisposableArr, 0, replayDisposableArr3, 0, i6);
                System.arraycopy(replayDisposableArr, i6 + 1, replayDisposableArr3, i6, (length - i6) - 1);
                replayDisposableArr2 = replayDisposableArr3;
            }
        } while (!p.a(this.observers, replayDisposableArr, replayDisposableArr2));
    }

    int size() {
        return this.buffer.size();
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        ReplayDisposable<T> replayDisposable = new ReplayDisposable<>(observer, this);
        observer.onSubscribe(replayDisposable);
        if (replayDisposable.cancelled) {
            return;
        }
        if (add(replayDisposable) && replayDisposable.cancelled) {
            remove(replayDisposable);
        } else {
            this.buffer.replay(replayDisposable);
        }
    }

    ReplayDisposable<T>[] terminate(Object obj) {
        return this.buffer.compareAndSet(null, obj) ? this.observers.getAndSet(TERMINATED) : TERMINATED;
    }

    ReplaySubject(ReplayBuffer<T> replayBuffer) {
        this.buffer = replayBuffer;
    }

    public T[] getValues(T[] tArr) {
        return this.buffer.getValues(tArr);
    }
}
