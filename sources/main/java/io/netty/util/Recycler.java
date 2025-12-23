package io.netty.util;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class Recycler<T> {
    private static final int DEFAULT_INITIAL_MAX_CAPACITY_PER_THREAD = 4096;
    private static final int DEFAULT_MAX_CAPACITY_PER_THREAD;
    private static final FastThreadLocal<Map<Stack<?>, WeakOrderQueue>> DELAYED_RECYCLED;
    private static final AtomicInteger ID_GENERATOR;
    private static final int INITIAL_CAPACITY;
    private static final int LINK_CAPACITY;
    private static final int MAX_DELAYED_QUEUES_PER_THREAD;
    private static final int MAX_SHARED_CAPACITY_FACTOR;
    private static final Handle NOOP_HANDLE;
    private static final int OWN_THREAD_ID;
    private static final int RATIO;
    private static final InternalLogger logger;
    private final int maxCapacityPerThread;
    private final int maxDelayedQueuesPerThread;
    private final int maxSharedCapacityFactor;
    private final int ratioMask;
    private final FastThreadLocal<Stack<T>> threadLocal;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class DefaultHandle<T> implements Handle<T> {
        boolean hasBeenRecycled;
        private int lastRecycledId;
        private int recycleId;
        private Stack<?> stack;
        private Object value;

        @Override // io.netty.util.Recycler.Handle
        public void recycle(Object obj) {
            if (obj != this.value) {
                throw new IllegalArgumentException("object does not belong to handle");
            }
            Stack<?> stack = this.stack;
            if (this.lastRecycledId != this.recycleId || stack == null) {
                throw new IllegalStateException("recycled already");
            }
            stack.push(this);
        }

        DefaultHandle(Stack<?> stack) {
            this.stack = stack;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Handle<T> {
        void recycle(T t5);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class Stack<T> {
        final AtomicInteger availableSharedCapacity;
        private WeakOrderQueue cursor;
        private DefaultHandle<?>[] elements;
        private int handleRecycleCount = -1;
        private volatile WeakOrderQueue head;
        private final int maxCapacity;
        final int maxDelayedQueues;
        final Recycler<T> parent;
        private WeakOrderQueue prev;
        private final int ratioMask;
        private int size;
        final WeakReference<Thread> threadRef;

        synchronized void setHead(WeakOrderQueue weakOrderQueue) {
            weakOrderQueue.setNext(this.head);
            this.head = weakOrderQueue;
        }

        boolean dropHandle(DefaultHandle<?> defaultHandle) {
            if (defaultHandle.hasBeenRecycled) {
                return false;
            }
            int i6 = this.handleRecycleCount + 1;
            this.handleRecycleCount = i6;
            if ((i6 & this.ratioMask) != 0) {
                return true;
            }
            defaultHandle.hasBeenRecycled = true;
            return false;
        }

        int increaseCapacity(int i6) {
            int length = this.elements.length;
            int i7 = this.maxCapacity;
            do {
                length <<= 1;
                if (length >= i6) {
                    break;
                }
            } while (length < i7);
            int min = Math.min(length, i7);
            DefaultHandle<?>[] defaultHandleArr = this.elements;
            if (min != defaultHandleArr.length) {
                this.elements = (DefaultHandle[]) Arrays.copyOf(defaultHandleArr, min);
            }
            return min;
        }

        DefaultHandle<T> newHandle() {
            return new DefaultHandle<>(this);
        }

        DefaultHandle<T> pop() {
            int i6 = this.size;
            if (i6 == 0) {
                if (!scavenge()) {
                    return null;
                }
                i6 = this.size;
            }
            int i7 = i6 - 1;
            Object[] objArr = this.elements;
            DefaultHandle<T> defaultHandle = (DefaultHandle<T>) objArr[i7];
            objArr[i7] = null;
            if (((DefaultHandle) defaultHandle).lastRecycledId != ((DefaultHandle) defaultHandle).recycleId) {
                throw new IllegalStateException("recycled multiple times");
            }
            ((DefaultHandle) defaultHandle).recycleId = 0;
            ((DefaultHandle) defaultHandle).lastRecycledId = 0;
            this.size = i7;
            return defaultHandle;
        }

        boolean scavengeSome() {
            WeakOrderQueue weakOrderQueue;
            boolean z5;
            WeakOrderQueue weakOrderQueue2;
            WeakOrderQueue weakOrderQueue3 = this.cursor;
            boolean z6 = false;
            if (weakOrderQueue3 == null) {
                weakOrderQueue3 = this.head;
                if (weakOrderQueue3 == null) {
                    return false;
                }
                weakOrderQueue = null;
            } else {
                weakOrderQueue = this.prev;
            }
            while (true) {
                z5 = true;
                if (weakOrderQueue3.transfer(this)) {
                    break;
                }
                weakOrderQueue2 = weakOrderQueue3.next;
                if (weakOrderQueue3.owner.get() == null) {
                    if (weakOrderQueue3.hasFinalData()) {
                        while (weakOrderQueue3.transfer(this)) {
                            z6 = true;
                        }
                    }
                    if (weakOrderQueue != null) {
                        weakOrderQueue.setNext(weakOrderQueue2);
                    }
                } else {
                    weakOrderQueue = weakOrderQueue3;
                }
                if (weakOrderQueue2 == null || z6) {
                    break;
                }
                weakOrderQueue3 = weakOrderQueue2;
            }
            z5 = z6;
            weakOrderQueue3 = weakOrderQueue2;
            this.prev = weakOrderQueue;
            this.cursor = weakOrderQueue3;
            return z5;
        }

        Stack(Recycler<T> recycler, Thread thread, int i6, int i7, int i8, int i9) {
            this.parent = recycler;
            this.threadRef = new WeakReference<>(thread);
            this.maxCapacity = i6;
            this.availableSharedCapacity = new AtomicInteger(Math.max(i6 / i7, Recycler.LINK_CAPACITY));
            this.elements = new DefaultHandle[Math.min(Recycler.INITIAL_CAPACITY, i6)];
            this.ratioMask = i8;
            this.maxDelayedQueues = i9;
        }

        private void pushLater(DefaultHandle<?> defaultHandle, Thread thread) {
            Map map = (Map) Recycler.DELAYED_RECYCLED.get();
            WeakOrderQueue weakOrderQueue = (WeakOrderQueue) map.get(this);
            if (weakOrderQueue == null) {
                if (map.size() >= this.maxDelayedQueues) {
                    map.put(this, WeakOrderQueue.DUMMY);
                    return;
                }
                weakOrderQueue = WeakOrderQueue.allocate(this, thread);
                if (weakOrderQueue != null) {
                    map.put(this, weakOrderQueue);
                } else {
                    return;
                }
            } else if (weakOrderQueue == WeakOrderQueue.DUMMY) {
                return;
            }
            weakOrderQueue.add(defaultHandle);
        }

        private void pushNow(DefaultHandle<?> defaultHandle) {
            if ((((DefaultHandle) defaultHandle).recycleId | ((DefaultHandle) defaultHandle).lastRecycledId) == 0) {
                ((DefaultHandle) defaultHandle).recycleId = ((DefaultHandle) defaultHandle).lastRecycledId = Recycler.OWN_THREAD_ID;
                int i6 = this.size;
                if (i6 < this.maxCapacity && !dropHandle(defaultHandle)) {
                    DefaultHandle<?>[] defaultHandleArr = this.elements;
                    if (i6 == defaultHandleArr.length) {
                        this.elements = (DefaultHandle[]) Arrays.copyOf(defaultHandleArr, Math.min(i6 << 1, this.maxCapacity));
                    }
                    this.elements[i6] = defaultHandle;
                    this.size = i6 + 1;
                    return;
                }
                return;
            }
            throw new IllegalStateException("recycled already");
        }

        void push(DefaultHandle<?> defaultHandle) {
            Thread currentThread = Thread.currentThread();
            if (this.threadRef.get() == currentThread) {
                pushNow(defaultHandle);
            } else {
                pushLater(defaultHandle, currentThread);
            }
        }

        boolean scavenge() {
            if (scavengeSome()) {
                return true;
            }
            this.prev = null;
            this.cursor = this.head;
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class WeakOrderQueue {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final WeakOrderQueue DUMMY = new WeakOrderQueue();
        private final Head head;
        private final int id;
        private WeakOrderQueue next;
        private final WeakReference<Thread> owner;
        private Link tail;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static final class Head {
            static final /* synthetic */ boolean $assertionsDisabled = false;
            private final AtomicInteger availableSharedCapacity;
            Link link;

            protected void finalize() throws Throwable {
                try {
                    super.finalize();
                } finally {
                    Link link = this.link;
                    this.link = null;
                    while (link != null) {
                        reclaimSpace(Recycler.LINK_CAPACITY);
                        Link link2 = link.next;
                        link.next = null;
                        link = link2;
                    }
                }
            }

            boolean reserveSpace(int i6) {
                return reserveSpace(this.availableSharedCapacity, i6);
            }

            static boolean reserveSpace(AtomicInteger atomicInteger, int i6) {
                int i7;
                do {
                    i7 = atomicInteger.get();
                    if (i7 < i6) {
                        return false;
                    }
                } while (!atomicInteger.compareAndSet(i7, i7 - i6));
                return true;
            }

            void reclaimSpace(int i6) {
                this.availableSharedCapacity.addAndGet(i6);
            }

            Head(AtomicInteger atomicInteger) {
                this.availableSharedCapacity = atomicInteger;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static final class Link extends AtomicInteger {
            private final DefaultHandle<?>[] elements = new DefaultHandle[Recycler.LINK_CAPACITY];
            Link next;
            private int readIndex;

            Link() {
            }
        }

        private WeakOrderQueue() {
            this.id = Recycler.ID_GENERATOR.getAndIncrement();
            this.owner = null;
            this.head = new Head(null);
        }

        static WeakOrderQueue allocate(Stack<?> stack, Thread thread) {
            if (Head.reserveSpace(stack.availableSharedCapacity, Recycler.LINK_CAPACITY)) {
                return newQueue(stack, thread);
            }
            return null;
        }

        static WeakOrderQueue newQueue(Stack<?> stack, Thread thread) {
            WeakOrderQueue weakOrderQueue = new WeakOrderQueue(stack, thread);
            stack.setHead(weakOrderQueue);
            return weakOrderQueue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNext(WeakOrderQueue weakOrderQueue) {
            this.next = weakOrderQueue;
        }

        void add(DefaultHandle<?> defaultHandle) {
            ((DefaultHandle) defaultHandle).lastRecycledId = this.id;
            Link link = this.tail;
            int i6 = link.get();
            if (i6 == Recycler.LINK_CAPACITY) {
                if (!this.head.reserveSpace(Recycler.LINK_CAPACITY)) {
                    return;
                }
                Link link2 = new Link();
                link.next = link2;
                this.tail = link2;
                i6 = link2.get();
                link = link2;
            }
            link.elements[i6] = defaultHandle;
            ((DefaultHandle) defaultHandle).stack = null;
            link.lazySet(i6 + 1);
        }

        boolean hasFinalData() {
            return this.tail.readIndex != this.tail.get();
        }

        boolean transfer(Stack<?> stack) {
            Link link = this.head.link;
            if (link == null) {
                return false;
            }
            if (link.readIndex == Recycler.LINK_CAPACITY) {
                link = link.next;
                if (link == null) {
                    return false;
                }
                Head head = this.head;
                head.link = link;
                head.reclaimSpace(Recycler.LINK_CAPACITY);
            }
            int i6 = link.readIndex;
            int i7 = link.get();
            int i8 = i7 - i6;
            if (i8 == 0) {
                return false;
            }
            int i9 = ((Stack) stack).size;
            int i10 = i8 + i9;
            if (i10 > ((Stack) stack).elements.length) {
                i7 = Math.min((stack.increaseCapacity(i10) + i6) - i9, i7);
            }
            if (i6 == i7) {
                return false;
            }
            DefaultHandle<?>[] defaultHandleArr = link.elements;
            DefaultHandle[] defaultHandleArr2 = ((Stack) stack).elements;
            while (i6 < i7) {
                DefaultHandle<?> defaultHandle = defaultHandleArr[i6];
                if (((DefaultHandle) defaultHandle).recycleId == 0) {
                    ((DefaultHandle) defaultHandle).recycleId = ((DefaultHandle) defaultHandle).lastRecycledId;
                } else if (((DefaultHandle) defaultHandle).recycleId != ((DefaultHandle) defaultHandle).lastRecycledId) {
                    throw new IllegalStateException("recycled already");
                }
                defaultHandleArr[i6] = null;
                if (!stack.dropHandle(defaultHandle)) {
                    ((DefaultHandle) defaultHandle).stack = stack;
                    defaultHandleArr2[i9] = defaultHandle;
                    i9++;
                }
                i6++;
            }
            if (i7 == Recycler.LINK_CAPACITY && link.next != null) {
                this.head.reclaimSpace(Recycler.LINK_CAPACITY);
                this.head.link = link.next;
            }
            link.readIndex = i7;
            if (((Stack) stack).size == i9) {
                return false;
            }
            ((Stack) stack).size = i9;
            return true;
        }

        private WeakOrderQueue(Stack<?> stack, Thread thread) {
            this.id = Recycler.ID_GENERATOR.getAndIncrement();
            this.tail = new Link();
            Head head = new Head(stack.availableSharedCapacity);
            this.head = head;
            head.link = this.tail;
            this.owner = new WeakReference<>(thread);
        }
    }

    protected Recycler() {
        this(DEFAULT_MAX_CAPACITY_PER_THREAD);
    }

    protected abstract T newObject(Handle<T> handle);

    static {
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) Recycler.class);
        logger = internalLoggerFactory;
        NOOP_HANDLE = new Handle() { // from class: io.netty.util.Recycler.1
            @Override // io.netty.util.Recycler.Handle
            public void recycle(Object obj) {
            }
        };
        AtomicInteger atomicInteger = new AtomicInteger(Integer.MIN_VALUE);
        ID_GENERATOR = atomicInteger;
        OWN_THREAD_ID = atomicInteger.getAndIncrement();
        int i6 = SystemPropertyUtil.getInt("io.netty.recycler.maxCapacityPerThread", SystemPropertyUtil.getInt("io.netty.recycler.maxCapacity", 4096));
        int i7 = i6 >= 0 ? i6 : 4096;
        DEFAULT_MAX_CAPACITY_PER_THREAD = i7;
        int max = Math.max(2, SystemPropertyUtil.getInt("io.netty.recycler.maxSharedCapacityFactor", 2));
        MAX_SHARED_CAPACITY_FACTOR = max;
        MAX_DELAYED_QUEUES_PER_THREAD = Math.max(0, SystemPropertyUtil.getInt("io.netty.recycler.maxDelayedQueuesPerThread", NettyRuntime.availableProcessors() * 2));
        int safeFindNextPositivePowerOfTwo = MathUtil.safeFindNextPositivePowerOfTwo(Math.max(SystemPropertyUtil.getInt("io.netty.recycler.linkCapacity", 16), 16));
        LINK_CAPACITY = safeFindNextPositivePowerOfTwo;
        int safeFindNextPositivePowerOfTwo2 = MathUtil.safeFindNextPositivePowerOfTwo(SystemPropertyUtil.getInt("io.netty.recycler.ratio", 8));
        RATIO = safeFindNextPositivePowerOfTwo2;
        if (internalLoggerFactory.isDebugEnabled()) {
            if (i7 == 0) {
                internalLoggerFactory.debug("-Dio.netty.recycler.maxCapacityPerThread: disabled");
                internalLoggerFactory.debug("-Dio.netty.recycler.maxSharedCapacityFactor: disabled");
                internalLoggerFactory.debug("-Dio.netty.recycler.linkCapacity: disabled");
                internalLoggerFactory.debug("-Dio.netty.recycler.ratio: disabled");
            } else {
                internalLoggerFactory.debug("-Dio.netty.recycler.maxCapacityPerThread: {}", Integer.valueOf(i7));
                internalLoggerFactory.debug("-Dio.netty.recycler.maxSharedCapacityFactor: {}", Integer.valueOf(max));
                internalLoggerFactory.debug("-Dio.netty.recycler.linkCapacity: {}", Integer.valueOf(safeFindNextPositivePowerOfTwo));
                internalLoggerFactory.debug("-Dio.netty.recycler.ratio: {}", Integer.valueOf(safeFindNextPositivePowerOfTwo2));
            }
        }
        INITIAL_CAPACITY = Math.min(i7, 256);
        DELAYED_RECYCLED = new FastThreadLocal<Map<Stack<?>, WeakOrderQueue>>() { // from class: io.netty.util.Recycler.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.util.concurrent.FastThreadLocal
            public Map<Stack<?>, WeakOrderQueue> initialValue() {
                return new WeakHashMap();
            }
        };
    }

    protected Recycler(int i6) {
        this(i6, MAX_SHARED_CAPACITY_FACTOR);
    }

    public final T get() {
        if (this.maxCapacityPerThread == 0) {
            return newObject(NOOP_HANDLE);
        }
        Stack<T> stack = this.threadLocal.get();
        DefaultHandle<T> pop = stack.pop();
        if (pop == null) {
            pop = stack.newHandle();
            ((DefaultHandle) pop).value = newObject(pop);
        }
        return (T) ((DefaultHandle) pop).value;
    }

    @Deprecated
    public final boolean recycle(T t5, Handle<T> handle) {
        if (handle == NOOP_HANDLE) {
            return false;
        }
        DefaultHandle defaultHandle = (DefaultHandle) handle;
        if (defaultHandle.stack.parent != this) {
            return false;
        }
        defaultHandle.recycle(t5);
        return true;
    }

    final int threadLocalCapacity() {
        return ((Stack) this.threadLocal.get()).elements.length;
    }

    final int threadLocalSize() {
        return ((Stack) this.threadLocal.get()).size;
    }

    protected Recycler(int i6, int i7) {
        this(i6, i7, RATIO, MAX_DELAYED_QUEUES_PER_THREAD);
    }

    protected Recycler(int i6, int i7, int i8, int i9) {
        this.threadLocal = new FastThreadLocal<Stack<T>>() { // from class: io.netty.util.Recycler.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.util.concurrent.FastThreadLocal
            public Stack<T> initialValue() {
                return new Stack<>(Recycler.this, Thread.currentThread(), Recycler.this.maxCapacityPerThread, Recycler.this.maxSharedCapacityFactor, Recycler.this.ratioMask, Recycler.this.maxDelayedQueuesPerThread);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.util.concurrent.FastThreadLocal
            public void onRemoval(Stack<T> stack) {
                if (stack.threadRef.get() == Thread.currentThread() && Recycler.DELAYED_RECYCLED.isSet()) {
                    ((Map) Recycler.DELAYED_RECYCLED.get()).remove(stack);
                }
            }
        };
        this.ratioMask = MathUtil.safeFindNextPositivePowerOfTwo(i8) - 1;
        if (i6 <= 0) {
            this.maxCapacityPerThread = 0;
            this.maxSharedCapacityFactor = 1;
            this.maxDelayedQueuesPerThread = 0;
        } else {
            this.maxCapacityPerThread = i6;
            this.maxSharedCapacityFactor = Math.max(1, i7);
            this.maxDelayedQueuesPerThread = Math.max(0, i9);
        }
    }
}
