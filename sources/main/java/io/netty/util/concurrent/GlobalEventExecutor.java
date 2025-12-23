package io.netty.util.concurrent;

import io.netty.util.internal.PriorityQueue;
import io.netty.util.internal.ThreadExecutorMap;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class GlobalEventExecutor extends AbstractScheduledEventExecutor implements OrderedEventExecutor {
    final ScheduledFutureTask<Void> quietPeriodTask;
    private final AtomicBoolean started;
    final BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue();
    private final TaskRunner taskRunner;
    private final Future<?> terminationFuture;
    volatile Thread thread;
    final ThreadFactory threadFactory;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) GlobalEventExecutor.class);
    private static final long SCHEDULE_QUIET_PERIOD_INTERVAL = TimeUnit.SECONDS.toNanos(1);
    public static final GlobalEventExecutor INSTANCE = new GlobalEventExecutor();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class TaskRunner implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        TaskRunner() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                Runnable takeTask = GlobalEventExecutor.this.takeTask();
                if (takeTask != null) {
                    try {
                        takeTask.run();
                    } catch (Throwable th) {
                        GlobalEventExecutor.logger.warn("Unexpected exception from the global event executor: ", th);
                    }
                    if (takeTask != GlobalEventExecutor.this.quietPeriodTask) {
                        continue;
                    }
                }
                GlobalEventExecutor globalEventExecutor = GlobalEventExecutor.this;
                PriorityQueue<ScheduledFutureTask<?>> priorityQueue = globalEventExecutor.scheduledTaskQueue;
                if (globalEventExecutor.taskQueue.isEmpty() && (priorityQueue == null || priorityQueue.size() == 1)) {
                    GlobalEventExecutor.this.started.compareAndSet(true, false);
                    if ((GlobalEventExecutor.this.taskQueue.isEmpty() && (priorityQueue == null || priorityQueue.size() == 1)) || !GlobalEventExecutor.this.started.compareAndSet(false, true)) {
                        return;
                    }
                }
            }
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j6, TimeUnit timeUnit) {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return false;
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public boolean isShuttingDown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return false;
    }

    private void addTask(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("task");
        }
        this.taskQueue.add(runnable);
    }

    private void startThread() {
        if (this.started.compareAndSet(false, true)) {
            final Thread newThread = this.threadFactory.newThread(this.taskRunner);
            AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: io.netty.util.concurrent.GlobalEventExecutor.2
                @Override // java.security.PrivilegedAction
                public Void run() {
                    newThread.setContextClassLoader(null);
                    return null;
                }
            });
            this.thread = newThread;
            newThread.start();
        }
    }

    public boolean awaitInactivity(long j6, TimeUnit timeUnit) throws InterruptedException {
        if (timeUnit == null) {
            throw new NullPointerException("unit");
        }
        Thread thread = this.thread;
        if (thread == null) {
            throw new IllegalStateException("thread was not started");
        }
        thread.join(timeUnit.toMillis(j6));
        return !thread.isAlive();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("task");
        }
        addTask(runnable);
        if (inEventLoop()) {
            return;
        }
        startThread();
    }

    @Override // io.netty.util.concurrent.EventExecutor
    public boolean inEventLoop(Thread thread) {
        return thread == this.thread;
    }

    public int pendingTasks() {
        return this.taskQueue.size();
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ExecutorService, io.netty.util.concurrent.EventExecutorGroup
    @Deprecated
    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    Runnable takeTask() {
        Runnable poll;
        BlockingQueue<Runnable> blockingQueue = this.taskQueue;
        do {
            ScheduledFutureTask<?> peekScheduledTask = peekScheduledTask();
            if (peekScheduledTask == null) {
                try {
                    return blockingQueue.take();
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            long delayNanos = peekScheduledTask.delayNanos();
            if (delayNanos > 0) {
                try {
                    poll = blockingQueue.poll(delayNanos, TimeUnit.NANOSECONDS);
                } catch (InterruptedException unused2) {
                    return null;
                }
            } else {
                poll = blockingQueue.poll();
            }
            if (poll == null) {
                fetchFromScheduledTaskQueue();
                poll = blockingQueue.poll();
            }
        } while (poll == null);
        return poll;
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> terminationFuture() {
        return this.terminationFuture;
    }

    private GlobalEventExecutor() {
        Callable callable = Executors.callable(new Runnable() { // from class: io.netty.util.concurrent.GlobalEventExecutor.1
            @Override // java.lang.Runnable
            public void run() {
            }
        }, null);
        long j6 = SCHEDULE_QUIET_PERIOD_INTERVAL;
        ScheduledFutureTask<Void> scheduledFutureTask = new ScheduledFutureTask<>(this, (Callable<Void>) callable, ScheduledFutureTask.deadlineNanos(j6), -j6);
        this.quietPeriodTask = scheduledFutureTask;
        this.taskRunner = new TaskRunner();
        this.started = new AtomicBoolean();
        this.terminationFuture = new FailedFuture(this, new UnsupportedOperationException());
        scheduledTaskQueue().add(scheduledFutureTask);
        this.threadFactory = ThreadExecutorMap.apply(new DefaultThreadFactory(DefaultThreadFactory.toPoolName(GlobalEventExecutor.class), false, 5, null), this);
    }

    private void fetchFromScheduledTaskQueue() {
        long nanoTime = AbstractScheduledEventExecutor.nanoTime();
        Runnable pollScheduledTask = pollScheduledTask(nanoTime);
        while (pollScheduledTask != null) {
            this.taskQueue.add(pollScheduledTask);
            pollScheduledTask = pollScheduledTask(nanoTime);
        }
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> shutdownGracefully(long j6, long j7, TimeUnit timeUnit) {
        return terminationFuture();
    }
}
