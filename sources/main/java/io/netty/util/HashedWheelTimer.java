package io.netty.util;

import com.bykv.vk.component.ttvideo.player.C;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.Collections;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class HashedWheelTimer implements Timer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int INSTANCE_COUNT_LIMIT = 64;
    public static final int WORKER_STATE_INIT = 0;
    public static final int WORKER_STATE_SHUTDOWN = 2;
    public static final int WORKER_STATE_STARTED = 1;
    private final Queue<HashedWheelTimeout> cancelledTimeouts;
    private final ResourceLeakTracker<HashedWheelTimer> leak;
    private final int mask;
    private final long maxPendingTimeouts;
    private final AtomicLong pendingTimeouts;
    private volatile long startTime;
    private final CountDownLatch startTimeInitialized;
    private final long tickDuration;
    private final Queue<HashedWheelTimeout> timeouts;
    private final HashedWheelBucket[] wheel;
    private final Worker worker;
    private volatile int workerState;
    private final Thread workerThread;
    static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) HashedWheelTimer.class);
    private static final AtomicInteger INSTANCE_COUNTER = new AtomicInteger();
    private static final AtomicBoolean WARNED_TOO_MANY_INSTANCES = new AtomicBoolean();
    private static final long MILLISECOND_NANOS = TimeUnit.MILLISECONDS.toNanos(1);
    private static final ResourceLeakDetector<HashedWheelTimer> leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(HashedWheelTimer.class, 1);
    private static final AtomicIntegerFieldUpdater<HashedWheelTimer> WORKER_STATE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(HashedWheelTimer.class, "workerState");

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.util.HashedWheelTimer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class HashedWheelBucket {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private HashedWheelTimeout head;
        private HashedWheelTimeout tail;

        private HashedWheelBucket() {
        }

        /* synthetic */ HashedWheelBucket(AnonymousClass1 anonymousClass1) {
            this();
        }

        private HashedWheelTimeout pollTimeout() {
            HashedWheelTimeout hashedWheelTimeout = this.head;
            if (hashedWheelTimeout == null) {
                return null;
            }
            HashedWheelTimeout hashedWheelTimeout2 = hashedWheelTimeout.next;
            if (hashedWheelTimeout2 == null) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = hashedWheelTimeout2;
                hashedWheelTimeout2.prev = null;
            }
            hashedWheelTimeout.next = null;
            hashedWheelTimeout.prev = null;
            hashedWheelTimeout.bucket = null;
            return hashedWheelTimeout;
        }

        public void addTimeout(HashedWheelTimeout hashedWheelTimeout) {
            hashedWheelTimeout.bucket = this;
            if (this.head == null) {
                this.tail = hashedWheelTimeout;
                this.head = hashedWheelTimeout;
            } else {
                HashedWheelTimeout hashedWheelTimeout2 = this.tail;
                hashedWheelTimeout2.next = hashedWheelTimeout;
                hashedWheelTimeout.prev = hashedWheelTimeout2;
                this.tail = hashedWheelTimeout;
            }
        }

        public void expireTimeouts(long j6) {
            HashedWheelTimeout hashedWheelTimeout = this.head;
            while (hashedWheelTimeout != null) {
                HashedWheelTimeout hashedWheelTimeout2 = hashedWheelTimeout.next;
                if (hashedWheelTimeout.remainingRounds <= 0) {
                    hashedWheelTimeout2 = remove(hashedWheelTimeout);
                    if (hashedWheelTimeout.deadline > j6) {
                        throw new IllegalStateException(String.format("timeout.deadline (%d) > deadline (%d)", Long.valueOf(hashedWheelTimeout.deadline), Long.valueOf(j6)));
                    }
                    hashedWheelTimeout.expire();
                } else if (hashedWheelTimeout.isCancelled()) {
                    hashedWheelTimeout = remove(hashedWheelTimeout);
                } else {
                    hashedWheelTimeout.remainingRounds--;
                }
                hashedWheelTimeout = hashedWheelTimeout2;
            }
        }

        public HashedWheelTimeout remove(HashedWheelTimeout hashedWheelTimeout) {
            HashedWheelTimeout hashedWheelTimeout2 = hashedWheelTimeout.next;
            HashedWheelTimeout hashedWheelTimeout3 = hashedWheelTimeout.prev;
            if (hashedWheelTimeout3 != null) {
                hashedWheelTimeout3.next = hashedWheelTimeout2;
            }
            HashedWheelTimeout hashedWheelTimeout4 = hashedWheelTimeout.next;
            if (hashedWheelTimeout4 != null) {
                hashedWheelTimeout4.prev = hashedWheelTimeout3;
            }
            if (hashedWheelTimeout == this.head) {
                if (hashedWheelTimeout == this.tail) {
                    this.tail = null;
                    this.head = null;
                } else {
                    this.head = hashedWheelTimeout2;
                }
            } else if (hashedWheelTimeout == this.tail) {
                this.tail = hashedWheelTimeout.prev;
            }
            hashedWheelTimeout.prev = null;
            hashedWheelTimeout.next = null;
            hashedWheelTimeout.bucket = null;
            hashedWheelTimeout.timer.pendingTimeouts.decrementAndGet();
            return hashedWheelTimeout2;
        }

        public void clearTimeouts(Set<Timeout> set) {
            while (true) {
                HashedWheelTimeout pollTimeout = pollTimeout();
                if (pollTimeout == null) {
                    return;
                }
                if (!pollTimeout.isExpired() && !pollTimeout.isCancelled()) {
                    set.add(pollTimeout);
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class HashedWheelTimeout implements Timeout {
        private static final AtomicIntegerFieldUpdater<HashedWheelTimeout> STATE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(HashedWheelTimeout.class, "state");
        private static final int ST_CANCELLED = 1;
        private static final int ST_EXPIRED = 2;
        private static final int ST_INIT = 0;
        HashedWheelBucket bucket;
        private final long deadline;
        HashedWheelTimeout next;
        HashedWheelTimeout prev;
        long remainingRounds;
        private volatile int state = 0;
        private final TimerTask task;
        private final HashedWheelTimer timer;

        @Override // io.netty.util.Timeout
        public boolean cancel() {
            if (!compareAndSetState(0, 1)) {
                return false;
            }
            this.timer.cancelledTimeouts.add(this);
            return true;
        }

        public void expire() {
            if (compareAndSetState(0, 2)) {
                try {
                    this.task.run(this);
                } catch (Throwable th) {
                    InternalLogger internalLogger = HashedWheelTimer.logger;
                    if (internalLogger.isWarnEnabled()) {
                        internalLogger.warn("An exception was thrown by " + TimerTask.class.getSimpleName() + '.', th);
                    }
                }
            }
        }

        public boolean compareAndSetState(int i6, int i7) {
            return STATE_UPDATER.compareAndSet(this, i6, i7);
        }

        void remove() {
            HashedWheelBucket hashedWheelBucket = this.bucket;
            if (hashedWheelBucket != null) {
                hashedWheelBucket.remove(this);
            } else {
                this.timer.pendingTimeouts.decrementAndGet();
            }
        }

        public int state() {
            return this.state;
        }

        @Override // io.netty.util.Timeout
        public TimerTask task() {
            return this.task;
        }

        @Override // io.netty.util.Timeout
        public Timer timer() {
            return this.timer;
        }

        HashedWheelTimeout(HashedWheelTimer hashedWheelTimer, TimerTask timerTask, long j6) {
            this.timer = hashedWheelTimer;
            this.task = timerTask;
            this.deadline = j6;
        }

        @Override // io.netty.util.Timeout
        public boolean isCancelled() {
            if (state() == 1) {
                return true;
            }
            return false;
        }

        @Override // io.netty.util.Timeout
        public boolean isExpired() {
            if (state() == 2) {
                return true;
            }
            return false;
        }

        public String toString() {
            long nanoTime = (this.deadline - System.nanoTime()) + this.timer.startTime;
            StringBuilder sb = new StringBuilder(192);
            sb.append(StringUtil.simpleClassName(this));
            sb.append('(');
            sb.append("deadline: ");
            if (nanoTime > 0) {
                sb.append(nanoTime);
                sb.append(" ns later");
            } else if (nanoTime < 0) {
                sb.append(-nanoTime);
                sb.append(" ns ago");
            } else {
                sb.append("now");
            }
            if (isCancelled()) {
                sb.append(", cancelled");
            }
            sb.append(", task: ");
            sb.append(task());
            sb.append(')');
            return sb.toString();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class Worker implements Runnable {
        private long tick;
        private final Set<Timeout> unprocessedTimeouts;

        private Worker() {
            this.unprocessedTimeouts = new HashSet();
        }

        private void transferTimeoutsToBuckets() {
            HashedWheelTimeout hashedWheelTimeout;
            for (int i6 = 0; i6 < 100000 && (hashedWheelTimeout = (HashedWheelTimeout) HashedWheelTimer.this.timeouts.poll()) != null; i6++) {
                if (hashedWheelTimeout.state() != 1) {
                    long j6 = hashedWheelTimeout.deadline / HashedWheelTimer.this.tickDuration;
                    hashedWheelTimeout.remainingRounds = (j6 - this.tick) / HashedWheelTimer.this.wheel.length;
                    HashedWheelTimer.this.wheel[(int) (Math.max(j6, this.tick) & HashedWheelTimer.this.mask)].addTimeout(hashedWheelTimeout);
                }
            }
        }

        private void processCancelledTasks() {
            while (true) {
                HashedWheelTimeout hashedWheelTimeout = (HashedWheelTimeout) HashedWheelTimer.this.cancelledTimeouts.poll();
                if (hashedWheelTimeout == null) {
                    return;
                }
                try {
                    hashedWheelTimeout.remove();
                } catch (Throwable th) {
                    if (HashedWheelTimer.logger.isWarnEnabled()) {
                        HashedWheelTimer.logger.warn("An exception was thrown while process a cancellation task", th);
                    }
                }
            }
        }

        private long waitForNextTick() {
            long j6 = HashedWheelTimer.this.tickDuration * (this.tick + 1);
            while (true) {
                long nanoTime = System.nanoTime() - HashedWheelTimer.this.startTime;
                long j7 = ((j6 - nanoTime) + 999999) / C.MICROS_PER_SECOND;
                if (j7 <= 0) {
                    if (nanoTime == Long.MIN_VALUE) {
                        return -9223372036854775807L;
                    }
                    return nanoTime;
                }
                if (PlatformDependent.isWindows()) {
                    j7 = (j7 / 10) * 10;
                }
                try {
                    Thread.sleep(j7);
                } catch (InterruptedException unused) {
                    if (HashedWheelTimer.WORKER_STATE_UPDATER.get(HashedWheelTimer.this) == 2) {
                        return Long.MIN_VALUE;
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            HashedWheelTimer.this.startTime = System.nanoTime();
            if (HashedWheelTimer.this.startTime == 0) {
                HashedWheelTimer.this.startTime = 1L;
            }
            HashedWheelTimer.this.startTimeInitialized.countDown();
            do {
                long waitForNextTick = waitForNextTick();
                if (waitForNextTick > 0) {
                    int i6 = (int) (this.tick & HashedWheelTimer.this.mask);
                    processCancelledTasks();
                    HashedWheelBucket hashedWheelBucket = HashedWheelTimer.this.wheel[i6];
                    transferTimeoutsToBuckets();
                    hashedWheelBucket.expireTimeouts(waitForNextTick);
                    this.tick++;
                }
            } while (HashedWheelTimer.WORKER_STATE_UPDATER.get(HashedWheelTimer.this) == 1);
            for (HashedWheelBucket hashedWheelBucket2 : HashedWheelTimer.this.wheel) {
                hashedWheelBucket2.clearTimeouts(this.unprocessedTimeouts);
            }
            while (true) {
                HashedWheelTimeout hashedWheelTimeout = (HashedWheelTimeout) HashedWheelTimer.this.timeouts.poll();
                if (hashedWheelTimeout == null) {
                    processCancelledTasks();
                    return;
                } else if (!hashedWheelTimeout.isCancelled()) {
                    this.unprocessedTimeouts.add(hashedWheelTimeout);
                }
            }
        }

        public Set<Timeout> unprocessedTimeouts() {
            return Collections.unmodifiableSet(this.unprocessedTimeouts);
        }

        /* synthetic */ Worker(HashedWheelTimer hashedWheelTimer, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public HashedWheelTimer() {
        this(Executors.defaultThreadFactory());
    }

    private static int normalizeTicksPerWheel(int i6) {
        int i7 = 1;
        while (i7 < i6) {
            i7 <<= 1;
        }
        return i7;
    }

    protected void finalize() throws Throwable {
        try {
            super.finalize();
        } finally {
            if (WORKER_STATE_UPDATER.getAndSet(this, 2) != 2) {
                INSTANCE_COUNTER.decrementAndGet();
            }
        }
    }

    public HashedWheelTimer(long j6, TimeUnit timeUnit) {
        this(Executors.defaultThreadFactory(), j6, timeUnit);
    }

    private static HashedWheelBucket[] createWheel(int i6) {
        if (i6 <= 0) {
            throw new IllegalArgumentException("ticksPerWheel must be greater than 0: " + i6);
        }
        if (i6 > 1073741824) {
            throw new IllegalArgumentException("ticksPerWheel may not be greater than 2^30: " + i6);
        }
        int normalizeTicksPerWheel = normalizeTicksPerWheel(i6);
        HashedWheelBucket[] hashedWheelBucketArr = new HashedWheelBucket[normalizeTicksPerWheel];
        for (int i7 = 0; i7 < normalizeTicksPerWheel; i7++) {
            hashedWheelBucketArr[i7] = new HashedWheelBucket(null);
        }
        return hashedWheelBucketArr;
    }

    private static void reportTooManyInstances() {
        InternalLogger internalLogger = logger;
        if (internalLogger.isErrorEnabled()) {
            String simpleClassName = StringUtil.simpleClassName((Class<?>) HashedWheelTimer.class);
            internalLogger.error("You are creating too many " + simpleClassName + " instances. " + simpleClassName + " is a shared resource that must be reused across the JVM,so that only a few instances are created.");
        }
    }

    @Override // io.netty.util.Timer
    public Timeout newTimeout(TimerTask timerTask, long j6, TimeUnit timeUnit) {
        if (timerTask == null) {
            throw new NullPointerException("task");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit");
        }
        long incrementAndGet = this.pendingTimeouts.incrementAndGet();
        long j7 = this.maxPendingTimeouts;
        if (j7 <= 0 || incrementAndGet <= j7) {
            start();
            long nanoTime = (System.nanoTime() + timeUnit.toNanos(j6)) - this.startTime;
            if (j6 > 0 && nanoTime < 0) {
                nanoTime = Long.MAX_VALUE;
            }
            HashedWheelTimeout hashedWheelTimeout = new HashedWheelTimeout(this, timerTask, nanoTime);
            this.timeouts.add(hashedWheelTimeout);
            return hashedWheelTimeout;
        }
        this.pendingTimeouts.decrementAndGet();
        throw new RejectedExecutionException("Number of pending timeouts (" + incrementAndGet + ") is greater than or equal to maximum allowed pending timeouts (" + this.maxPendingTimeouts + ")");
    }

    public long pendingTimeouts() {
        return this.pendingTimeouts.get();
    }

    public void start() {
        AtomicIntegerFieldUpdater<HashedWheelTimer> atomicIntegerFieldUpdater = WORKER_STATE_UPDATER;
        int i6 = atomicIntegerFieldUpdater.get(this);
        if (i6 != 0) {
            if (i6 != 1) {
                if (i6 == 2) {
                    throw new IllegalStateException("cannot be started once stopped");
                }
                throw new Error("Invalid WorkerState");
            }
        } else if (atomicIntegerFieldUpdater.compareAndSet(this, 0, 1)) {
            this.workerThread.start();
        }
        while (this.startTime == 0) {
            try {
                this.startTimeInitialized.await();
            } catch (InterruptedException unused) {
            }
        }
    }

    public HashedWheelTimer(long j6, TimeUnit timeUnit, int i6) {
        this(Executors.defaultThreadFactory(), j6, timeUnit, i6);
    }

    @Override // io.netty.util.Timer
    public Set<Timeout> stop() {
        if (Thread.currentThread() != this.workerThread) {
            AtomicIntegerFieldUpdater<HashedWheelTimer> atomicIntegerFieldUpdater = WORKER_STATE_UPDATER;
            if (!atomicIntegerFieldUpdater.compareAndSet(this, 1, 2)) {
                if (atomicIntegerFieldUpdater.getAndSet(this, 2) != 2) {
                }
                return Collections.EMPTY_SET;
            }
            boolean z5 = false;
            while (this.workerThread.isAlive()) {
                try {
                    this.workerThread.interrupt();
                    try {
                        this.workerThread.join(100L);
                    } catch (InterruptedException unused) {
                        z5 = true;
                    }
                } finally {
                    INSTANCE_COUNTER.decrementAndGet();
                    ResourceLeakTracker<HashedWheelTimer> resourceLeakTracker = this.leak;
                    if (resourceLeakTracker != null) {
                        resourceLeakTracker.close(this);
                    }
                }
            }
            if (z5) {
                Thread.currentThread().interrupt();
            }
            INSTANCE_COUNTER.decrementAndGet();
            ResourceLeakTracker<HashedWheelTimer> resourceLeakTracker2 = this.leak;
            if (resourceLeakTracker2 != null) {
                resourceLeakTracker2.close(this);
            }
            return this.worker.unprocessedTimeouts();
        }
        throw new IllegalStateException(HashedWheelTimer.class.getSimpleName() + ".stop() cannot be called from " + TimerTask.class.getSimpleName());
    }

    public HashedWheelTimer(ThreadFactory threadFactory) {
        this(threadFactory, 100L, TimeUnit.MILLISECONDS);
    }

    public HashedWheelTimer(ThreadFactory threadFactory, long j6, TimeUnit timeUnit) {
        this(threadFactory, j6, timeUnit, 512);
    }

    public HashedWheelTimer(ThreadFactory threadFactory, long j6, TimeUnit timeUnit, int i6) {
        this(threadFactory, j6, timeUnit, i6, true);
    }

    public HashedWheelTimer(ThreadFactory threadFactory, long j6, TimeUnit timeUnit, int i6, boolean z5) {
        this(threadFactory, j6, timeUnit, i6, z5, -1L);
    }

    public HashedWheelTimer(ThreadFactory threadFactory, long j6, TimeUnit timeUnit, int i6, boolean z5, long j7) {
        Worker worker = new Worker(this, 0 == true ? 1 : 0);
        this.worker = worker;
        this.startTimeInitialized = new CountDownLatch(1);
        this.timeouts = PlatformDependent.newMpscQueue();
        this.cancelledTimeouts = PlatformDependent.newMpscQueue();
        this.pendingTimeouts = new AtomicLong(0L);
        if (threadFactory == null) {
            throw new NullPointerException("threadFactory");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit");
        }
        if (j6 <= 0) {
            throw new IllegalArgumentException("tickDuration must be greater than 0: " + j6);
        }
        if (i6 > 0) {
            HashedWheelBucket[] createWheel = createWheel(i6);
            this.wheel = createWheel;
            this.mask = createWheel.length - 1;
            long nanos = timeUnit.toNanos(j6);
            if (nanos < Long.MAX_VALUE / createWheel.length) {
                long j8 = MILLISECOND_NANOS;
                if (nanos < j8) {
                    InternalLogger internalLogger = logger;
                    if (internalLogger.isWarnEnabled()) {
                        internalLogger.warn("Configured tickDuration %d smaller then %d, using 1ms.", Long.valueOf(j6), Long.valueOf(j8));
                    }
                    this.tickDuration = j8;
                } else {
                    this.tickDuration = nanos;
                }
                Thread newThread = threadFactory.newThread(worker);
                this.workerThread = newThread;
                this.leak = (z5 || !newThread.isDaemon()) ? leakDetector.track(this) : null;
                this.maxPendingTimeouts = j7;
                if (INSTANCE_COUNTER.incrementAndGet() <= 64 || !WARNED_TOO_MANY_INSTANCES.compareAndSet(false, true)) {
                    return;
                }
                reportTooManyInstances();
                return;
            }
            throw new IllegalArgumentException(String.format("tickDuration: %d (expected: 0 < tickDuration in nanos < %d", Long.valueOf(j6), Long.valueOf(Long.MAX_VALUE / createWheel.length)));
        }
        throw new IllegalArgumentException("ticksPerWheel must be greater than 0: " + i6);
    }
}
