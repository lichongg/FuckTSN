package io.netty.util.concurrent;

import androidx.concurrent.futures.a;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.ThreadExecutorMap;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class SingleThreadEventExecutor extends AbstractScheduledEventExecutor implements OrderedEventExecutor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ST_NOT_STARTED = 1;
    private static final int ST_SHUTDOWN = 4;
    private static final int ST_SHUTTING_DOWN = 3;
    private static final int ST_STARTED = 2;
    private static final int ST_TERMINATED = 5;
    private final boolean addTaskWakesUp;
    private final Executor executor;
    private volatile long gracefulShutdownQuietPeriod;
    private long gracefulShutdownStartTime;
    private volatile long gracefulShutdownTimeout;
    private volatile boolean interrupted;
    private long lastExecutionTime;
    private final int maxPendingTasks;
    private final RejectedExecutionHandler rejectedExecutionHandler;
    private final Set<Runnable> shutdownHooks;
    private volatile int state;
    private final Queue<Runnable> taskQueue;
    private final Promise<?> terminationFuture;
    private volatile Thread thread;
    private final CountDownLatch threadLock;
    private volatile ThreadProperties threadProperties;
    static final int DEFAULT_MAX_PENDING_EXECUTOR_TASKS = Math.max(16, SystemPropertyUtil.getInt("io.netty.eventexecutor.maxPendingTasks", Integer.MAX_VALUE));
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) SingleThreadEventExecutor.class);
    private static final Runnable WAKEUP_TASK = new Runnable() { // from class: io.netty.util.concurrent.SingleThreadEventExecutor.1
        @Override // java.lang.Runnable
        public void run() {
        }
    };
    private static final Runnable NOOP_TASK = new Runnable() { // from class: io.netty.util.concurrent.SingleThreadEventExecutor.2
        @Override // java.lang.Runnable
        public void run() {
        }
    };
    private static final AtomicIntegerFieldUpdater<SingleThreadEventExecutor> STATE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(SingleThreadEventExecutor.class, "state");
    private static final AtomicReferenceFieldUpdater<SingleThreadEventExecutor, ThreadProperties> PROPERTIES_UPDATER = AtomicReferenceFieldUpdater.newUpdater(SingleThreadEventExecutor.class, ThreadProperties.class, "threadProperties");
    private static final long SCHEDULE_PURGE_INTERVAL = TimeUnit.SECONDS.toNanos(1);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class DefaultThreadProperties implements ThreadProperties {

        /* renamed from: t, reason: collision with root package name */
        private final Thread f43089t;

        @Override // io.netty.util.concurrent.ThreadProperties
        public long id() {
            return this.f43089t.getId();
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public boolean isAlive() {
            return this.f43089t.isAlive();
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public boolean isDaemon() {
            return this.f43089t.isDaemon();
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public boolean isInterrupted() {
            return this.f43089t.isInterrupted();
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public String name() {
            return this.f43089t.getName();
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public int priority() {
            return this.f43089t.getPriority();
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public StackTraceElement[] stackTrace() {
            return this.f43089t.getStackTrace();
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public Thread.State state() {
            return this.f43089t.getState();
        }

        DefaultThreadProperties(Thread thread) {
            this.f43089t = thread;
        }
    }

    protected SingleThreadEventExecutor(EventExecutorGroup eventExecutorGroup, ThreadFactory threadFactory, boolean z5) {
        this(eventExecutorGroup, new ThreadPerTaskExecutor(threadFactory), z5);
    }

    private boolean ensureThreadStarted(int i6) {
        if (i6 != 1) {
            return false;
        }
        try {
            doStartThread();
            return false;
        } catch (Throwable th) {
            STATE_UPDATER.set(this, 5);
            this.terminationFuture.tryFailure(th);
            if (!(th instanceof Exception)) {
                PlatformDependent.throwException(th);
            }
            return true;
        }
    }

    protected static void reject() {
        throw new RejectedExecutionException("event executor terminated");
    }

    private boolean runShutdownHooks() {
        boolean z5 = false;
        while (!this.shutdownHooks.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.shutdownHooks);
            this.shutdownHooks.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    ((Runnable) it.next()).run();
                } catch (Throwable th) {
                    logger.warn("Shutdown hook raised an exception.", th);
                }
                z5 = true;
            }
        }
        if (z5) {
            this.lastExecutionTime = ScheduledFutureTask.nanoTime();
        }
        return z5;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> List<java.util.concurrent.Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        throwIfInEventLoop("invokeAll");
        return super.invokeAll(collection);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        throwIfInEventLoop("invokeAny");
        return (T) super.invokeAny(collection);
    }

    @Deprecated
    protected Queue<Runnable> newTaskQueue() {
        return newTaskQueue(this.maxPendingTasks);
    }

    protected abstract void run();

    protected boolean runAllTasks() {
        boolean fetchFromScheduledTaskQueue;
        boolean z5 = false;
        do {
            fetchFromScheduledTaskQueue = fetchFromScheduledTaskQueue();
            if (runAllTasksFrom(this.taskQueue)) {
                z5 = true;
            }
        } while (!fetchFromScheduledTaskQueue);
        if (z5) {
            this.lastExecutionTime = ScheduledFutureTask.nanoTime();
        }
        afterRunningAllTasks();
        return z5;
    }

    protected boolean wakesUpForTask(Runnable runnable) {
        return true;
    }

    protected SingleThreadEventExecutor(EventExecutorGroup eventExecutorGroup, ThreadFactory threadFactory, boolean z5, int i6, RejectedExecutionHandler rejectedExecutionHandler) {
        this(eventExecutorGroup, new ThreadPerTaskExecutor(threadFactory), z5, i6, rejectedExecutionHandler);
    }

    private void doStartThread() {
        this.executor.execute(new Runnable() { // from class: io.netty.util.concurrent.SingleThreadEventExecutor.5
            /* JADX WARN: Code restructure failed: missing block: B:135:0x03e6, code lost:
            
                r1 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:136:0x03e7, code lost:
            
                io.netty.util.concurrent.FastThreadLocal.removeAll();
                io.netty.util.concurrent.SingleThreadEventExecutor.STATE_UPDATER.set(r9.this$0, 5);
                r9.this$0.threadLock.countDown();
             */
            /* JADX WARN: Code restructure failed: missing block: B:137:0x0404, code lost:
            
                if (io.netty.util.concurrent.SingleThreadEventExecutor.logger.isWarnEnabled() != false) goto L109;
             */
            /* JADX WARN: Code restructure failed: missing block: B:140:0x0412, code lost:
            
                io.netty.util.concurrent.SingleThreadEventExecutor.logger.warn("An event executor terminated with non-empty task queue (" + r9.this$0.taskQueue.size() + ')');
             */
            /* JADX WARN: Code restructure failed: missing block: B:141:0x0435, code lost:
            
                r9.this$0.terminationFuture.setSuccess(null);
             */
            /* JADX WARN: Code restructure failed: missing block: B:142:0x043e, code lost:
            
                throw r1;
             */
            /* JADX WARN: Code restructure failed: missing block: B:33:0x00eb, code lost:
            
                r1 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:40:0x0143, code lost:
            
                throw r1;
             */
            /* JADX WARN: Code restructure failed: missing block: B:85:0x025c, code lost:
            
                r1 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:86:0x025d, code lost:
            
                io.netty.util.concurrent.FastThreadLocal.removeAll();
                io.netty.util.concurrent.SingleThreadEventExecutor.STATE_UPDATER.set(r9.this$0, 5);
                r9.this$0.threadLock.countDown();
             */
            /* JADX WARN: Code restructure failed: missing block: B:87:0x027a, code lost:
            
                if (io.netty.util.concurrent.SingleThreadEventExecutor.logger.isWarnEnabled() != false) goto L69;
             */
            /* JADX WARN: Code restructure failed: missing block: B:90:0x0288, code lost:
            
                io.netty.util.concurrent.SingleThreadEventExecutor.logger.warn("An event executor terminated with non-empty task queue (" + r9.this$0.taskQueue.size() + ')');
             */
            /* JADX WARN: Code restructure failed: missing block: B:91:0x02ab, code lost:
            
                r9.this$0.terminationFuture.setSuccess(null);
             */
            /* JADX WARN: Code restructure failed: missing block: B:92:0x02b4, code lost:
            
                throw r1;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 1270
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: io.netty.util.concurrent.SingleThreadEventExecutor.AnonymousClass5.run():void");
            }
        });
    }

    private void startThread() {
        if (this.state == 1 && STATE_UPDATER.compareAndSet(this, 1, 2)) {
            try {
                doStartThread();
            } catch (Throwable th) {
                STATE_UPDATER.compareAndSet(this, 2, 1);
                throw th;
            }
        }
    }

    protected void addTask(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("task");
        }
        if (offerTask(runnable)) {
            return;
        }
        reject(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j6, TimeUnit timeUnit) throws InterruptedException {
        if (timeUnit == null) {
            throw new NullPointerException("unit");
        }
        if (inEventLoop()) {
            throw new IllegalStateException("cannot await termination of the current thread");
        }
        this.threadLock.await(j6, timeUnit);
        return isTerminated();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        boolean z5;
        if (runnable == null) {
            throw new NullPointerException("task");
        }
        boolean inEventLoop = inEventLoop();
        addTask(runnable);
        if (!inEventLoop) {
            startThread();
            if (isShutdown()) {
                try {
                    z5 = removeTask(runnable);
                } catch (UnsupportedOperationException unused) {
                    z5 = false;
                }
                if (z5) {
                    reject();
                }
            }
        }
        if (this.addTaskWakesUp || !wakesUpForTask(runnable)) {
            return;
        }
        wakeup(inEventLoop);
    }

    protected boolean hasTasks() {
        return !this.taskQueue.isEmpty();
    }

    @Override // io.netty.util.concurrent.EventExecutor
    public boolean inEventLoop(Thread thread) {
        return thread == this.thread;
    }

    protected void interruptThread() {
        Thread thread = this.thread;
        if (thread == null) {
            this.interrupted = true;
        } else {
            thread.interrupt();
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.state >= 4;
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public boolean isShuttingDown() {
        return this.state >= 3;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.state == 5;
    }

    protected Queue<Runnable> newTaskQueue(int i6) {
        return new LinkedBlockingQueue(i6);
    }

    protected Runnable peekTask() {
        return this.taskQueue.peek();
    }

    public int pendingTasks() {
        return this.taskQueue.size();
    }

    protected Runnable pollTask() {
        return pollTaskFrom(this.taskQueue);
    }

    protected final void reject(Runnable runnable) {
        this.rejectedExecutionHandler.rejected(runnable, this);
    }

    protected boolean removeTask(Runnable runnable) {
        if (runnable != null) {
            return this.taskQueue.remove(runnable);
        }
        throw new NullPointerException("task");
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> shutdownGracefully(long j6, long j7, TimeUnit timeUnit) {
        if (j6 < 0) {
            throw new IllegalArgumentException("quietPeriod: " + j6 + " (expected >= 0)");
        }
        if (j7 < j6) {
            throw new IllegalArgumentException("timeout: " + j7 + " (expected >= quietPeriod (" + j6 + "))");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit");
        }
        if (isShuttingDown()) {
            return terminationFuture();
        }
        boolean inEventLoop = inEventLoop();
        while (!isShuttingDown()) {
            int i6 = this.state;
            int i7 = 3;
            boolean z5 = true;
            if (!inEventLoop && i6 != 1 && i6 != 2) {
                z5 = false;
                i7 = i6;
            }
            if (STATE_UPDATER.compareAndSet(this, i6, i7)) {
                this.gracefulShutdownQuietPeriod = timeUnit.toNanos(j6);
                this.gracefulShutdownTimeout = timeUnit.toNanos(j7);
                if (ensureThreadStarted(i6)) {
                    return this.terminationFuture;
                }
                if (z5) {
                    wakeup(inEventLoop);
                }
                return terminationFuture();
            }
        }
        return terminationFuture();
    }

    protected Runnable takeTask() {
        Runnable runnable;
        Queue<Runnable> queue = this.taskQueue;
        if (!(queue instanceof BlockingQueue)) {
            throw new UnsupportedOperationException();
        }
        BlockingQueue blockingQueue = (BlockingQueue) queue;
        do {
            ScheduledFutureTask<?> peekScheduledTask = peekScheduledTask();
            runnable = null;
            if (peekScheduledTask == null) {
                try {
                    Runnable runnable2 = (Runnable) blockingQueue.take();
                    try {
                        if (runnable2 == WAKEUP_TASK) {
                            return null;
                        }
                        return runnable2;
                    } catch (InterruptedException unused) {
                        return runnable2;
                    }
                } catch (InterruptedException unused2) {
                    return null;
                }
            }
            long delayNanos = peekScheduledTask.delayNanos();
            if (delayNanos > 0) {
                try {
                    runnable = (Runnable) blockingQueue.poll(delayNanos, TimeUnit.NANOSECONDS);
                } catch (InterruptedException unused3) {
                    return null;
                }
            }
            if (runnable == null) {
                fetchFromScheduledTaskQueue();
                runnable = (Runnable) blockingQueue.poll();
            }
        } while (runnable == null);
        return runnable;
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> terminationFuture() {
        return this.terminationFuture;
    }

    public final ThreadProperties threadProperties() {
        ThreadProperties threadProperties = this.threadProperties;
        if (threadProperties != null) {
            return threadProperties;
        }
        Thread thread = this.thread;
        if (thread == null) {
            submit(NOOP_TASK).syncUninterruptibly();
            thread = this.thread;
        }
        DefaultThreadProperties defaultThreadProperties = new DefaultThreadProperties(thread);
        return !a.a(PROPERTIES_UPDATER, this, null, defaultThreadProperties) ? this.threadProperties : defaultThreadProperties;
    }

    protected void wakeup(boolean z5) {
        if (!z5 || this.state == 3) {
            this.taskQueue.offer(WAKEUP_TASK);
        }
    }

    protected SingleThreadEventExecutor(EventExecutorGroup eventExecutorGroup, Executor executor, boolean z5) {
        this(eventExecutorGroup, executor, z5, DEFAULT_MAX_PENDING_EXECUTOR_TASKS, RejectedExecutionHandlers.reject());
    }

    private boolean fetchFromScheduledTaskQueue() {
        long nanoTime = AbstractScheduledEventExecutor.nanoTime();
        Runnable pollScheduledTask = pollScheduledTask(nanoTime);
        while (pollScheduledTask != null) {
            if (!this.taskQueue.offer(pollScheduledTask)) {
                scheduledTaskQueue().add((ScheduledFutureTask) pollScheduledTask);
                return false;
            }
            pollScheduledTask = pollScheduledTask(nanoTime);
        }
        return true;
    }

    protected static Runnable pollTaskFrom(Queue<Runnable> queue) {
        Runnable poll;
        do {
            poll = queue.poll();
        } while (poll == WAKEUP_TASK);
        return poll;
    }

    private void throwIfInEventLoop(String str) {
        if (!inEventLoop()) {
            return;
        }
        throw new RejectedExecutionException("Calling " + str + " from within the EventLoop is not allowed");
    }

    public void addShutdownHook(final Runnable runnable) {
        if (inEventLoop()) {
            this.shutdownHooks.add(runnable);
        } else {
            execute(new Runnable() { // from class: io.netty.util.concurrent.SingleThreadEventExecutor.3
                @Override // java.lang.Runnable
                public void run() {
                    SingleThreadEventExecutor.this.shutdownHooks.add(runnable);
                }
            });
        }
    }

    protected boolean confirmShutdown() {
        if (!isShuttingDown()) {
            return false;
        }
        if (inEventLoop()) {
            cancelScheduledTasks();
            if (this.gracefulShutdownStartTime == 0) {
                this.gracefulShutdownStartTime = ScheduledFutureTask.nanoTime();
            }
            if (!runAllTasks() && !runShutdownHooks()) {
                long nanoTime = ScheduledFutureTask.nanoTime();
                if (isShutdown() || nanoTime - this.gracefulShutdownStartTime > this.gracefulShutdownTimeout || nanoTime - this.lastExecutionTime > this.gracefulShutdownQuietPeriod) {
                    return true;
                }
                wakeup(true);
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException unused) {
                }
                return false;
            }
            if (isShutdown() || this.gracefulShutdownQuietPeriod == 0) {
                return true;
            }
            wakeup(true);
            return false;
        }
        throw new IllegalStateException("must be invoked from an event loop");
    }

    protected long deadlineNanos() {
        ScheduledFutureTask<?> peekScheduledTask = peekScheduledTask();
        if (peekScheduledTask == null) {
            return AbstractScheduledEventExecutor.nanoTime() + SCHEDULE_PURGE_INTERVAL;
        }
        return peekScheduledTask.deadlineNanos();
    }

    protected long delayNanos(long j6) {
        ScheduledFutureTask<?> peekScheduledTask = peekScheduledTask();
        if (peekScheduledTask == null) {
            return SCHEDULE_PURGE_INTERVAL;
        }
        return peekScheduledTask.delayNanos(j6);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> List<java.util.concurrent.Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j6, TimeUnit timeUnit) throws InterruptedException {
        throwIfInEventLoop("invokeAll");
        return super.invokeAll(collection, j6, timeUnit);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j6, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        throwIfInEventLoop("invokeAny");
        return (T) super.invokeAny(collection, j6, timeUnit);
    }

    final boolean offerTask(Runnable runnable) {
        if (isShutdown()) {
            reject();
        }
        return this.taskQueue.offer(runnable);
    }

    public void removeShutdownHook(final Runnable runnable) {
        if (inEventLoop()) {
            this.shutdownHooks.remove(runnable);
        } else {
            execute(new Runnable() { // from class: io.netty.util.concurrent.SingleThreadEventExecutor.4
                @Override // java.lang.Runnable
                public void run() {
                    SingleThreadEventExecutor.this.shutdownHooks.remove(runnable);
                }
            });
        }
    }

    protected final boolean runAllTasksFrom(Queue<Runnable> queue) {
        Runnable pollTaskFrom = pollTaskFrom(queue);
        if (pollTaskFrom == null) {
            return false;
        }
        do {
            AbstractEventExecutor.safeExecute(pollTaskFrom);
            pollTaskFrom = pollTaskFrom(queue);
        } while (pollTaskFrom != null);
        return true;
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ExecutorService, io.netty.util.concurrent.EventExecutorGroup
    @Deprecated
    public void shutdown() {
        if (!isShutdown()) {
            boolean inEventLoop = inEventLoop();
            while (!isShuttingDown()) {
                int i6 = this.state;
                int i7 = 4;
                boolean z5 = true;
                if (!inEventLoop && i6 != 1 && i6 != 2 && i6 != 3) {
                    z5 = false;
                    i7 = i6;
                }
                if (STATE_UPDATER.compareAndSet(this, i6, i7)) {
                    if (!ensureThreadStarted(i6) && z5) {
                        wakeup(inEventLoop);
                        return;
                    }
                    return;
                }
            }
        }
    }

    protected void updateLastExecutionTime() {
        this.lastExecutionTime = ScheduledFutureTask.nanoTime();
    }

    protected SingleThreadEventExecutor(EventExecutorGroup eventExecutorGroup, Executor executor, boolean z5, int i6, RejectedExecutionHandler rejectedExecutionHandler) {
        super(eventExecutorGroup);
        this.threadLock = new CountDownLatch(1);
        this.shutdownHooks = new LinkedHashSet();
        this.state = 1;
        this.terminationFuture = new DefaultPromise(GlobalEventExecutor.INSTANCE);
        this.addTaskWakesUp = z5;
        int max = Math.max(16, i6);
        this.maxPendingTasks = max;
        this.executor = ThreadExecutorMap.apply(executor, this);
        this.taskQueue = newTaskQueue(max);
        this.rejectedExecutionHandler = (RejectedExecutionHandler) ObjectUtil.checkNotNull(rejectedExecutionHandler, "rejectedHandler");
    }

    protected boolean runAllTasks(long j6) {
        long nanoTime;
        fetchFromScheduledTaskQueue();
        Runnable pollTask = pollTask();
        if (pollTask == null) {
            afterRunningAllTasks();
            return false;
        }
        long nanoTime2 = ScheduledFutureTask.nanoTime() + j6;
        long j7 = 0;
        while (true) {
            AbstractEventExecutor.safeExecute(pollTask);
            j7++;
            if ((63 & j7) == 0) {
                nanoTime = ScheduledFutureTask.nanoTime();
                if (nanoTime >= nanoTime2) {
                    break;
                }
            }
            pollTask = pollTask();
            if (pollTask == null) {
                nanoTime = ScheduledFutureTask.nanoTime();
                break;
            }
        }
        afterRunningAllTasks();
        this.lastExecutionTime = nanoTime;
        return true;
    }

    protected SingleThreadEventExecutor(EventExecutorGroup eventExecutorGroup, Executor executor, boolean z5, Queue<Runnable> queue, RejectedExecutionHandler rejectedExecutionHandler) {
        super(eventExecutorGroup);
        this.threadLock = new CountDownLatch(1);
        this.shutdownHooks = new LinkedHashSet();
        this.state = 1;
        this.terminationFuture = new DefaultPromise(GlobalEventExecutor.INSTANCE);
        this.addTaskWakesUp = z5;
        this.maxPendingTasks = DEFAULT_MAX_PENDING_EXECUTOR_TASKS;
        this.executor = ThreadExecutorMap.apply(executor, this);
        this.taskQueue = (Queue) ObjectUtil.checkNotNull(queue, "taskQueue");
        this.rejectedExecutionHandler = (RejectedExecutionHandler) ObjectUtil.checkNotNull(rejectedExecutionHandler, "rejectedHandler");
    }

    protected void afterRunningAllTasks() {
    }

    protected void cleanup() {
    }
}
