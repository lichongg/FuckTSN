package io.netty.util.concurrent;

import io.netty.util.internal.DefaultPriorityQueue;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PriorityQueue;
import java.util.Comparator;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class AbstractScheduledEventExecutor extends AbstractEventExecutor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator<ScheduledFutureTask<?>> SCHEDULED_FUTURE_TASK_COMPARATOR = new Comparator<ScheduledFutureTask<?>>() { // from class: io.netty.util.concurrent.AbstractScheduledEventExecutor.1
        @Override // java.util.Comparator
        public int compare(ScheduledFutureTask<?> scheduledFutureTask, ScheduledFutureTask<?> scheduledFutureTask2) {
            return scheduledFutureTask.compareTo((Delayed) scheduledFutureTask2);
        }
    };
    PriorityQueue<ScheduledFutureTask<?>> scheduledTaskQueue;

    protected AbstractScheduledEventExecutor() {
    }

    protected final Runnable pollScheduledTask() {
        return pollScheduledTask(nanoTime());
    }

    protected AbstractScheduledEventExecutor(EventExecutorGroup eventExecutorGroup) {
        super(eventExecutorGroup);
    }

    private static boolean isNullOrEmpty(Queue<ScheduledFutureTask<?>> queue) {
        return queue == null || queue.isEmpty();
    }

    protected void cancelScheduledTasks() {
        PriorityQueue<ScheduledFutureTask<?>> priorityQueue = this.scheduledTaskQueue;
        if (isNullOrEmpty(priorityQueue)) {
            return;
        }
        for (ScheduledFutureTask scheduledFutureTask : (ScheduledFutureTask[]) priorityQueue.toArray(new ScheduledFutureTask[0])) {
            scheduledFutureTask.cancelWithoutRemove(false);
        }
        priorityQueue.clearIgnoringIndexes();
    }

    protected final boolean hasScheduledTasks() {
        PriorityQueue<ScheduledFutureTask<?>> priorityQueue = this.scheduledTaskQueue;
        ScheduledFutureTask<?> peek = priorityQueue == null ? null : priorityQueue.peek();
        return peek != null && peek.deadlineNanos() <= nanoTime();
    }

    protected final long nextScheduledTaskNano() {
        PriorityQueue<ScheduledFutureTask<?>> priorityQueue = this.scheduledTaskQueue;
        ScheduledFutureTask<?> peek = priorityQueue == null ? null : priorityQueue.peek();
        if (peek == null) {
            return -1L;
        }
        return Math.max(0L, peek.deadlineNanos() - nanoTime());
    }

    final ScheduledFutureTask<?> peekScheduledTask() {
        PriorityQueue<ScheduledFutureTask<?>> priorityQueue = this.scheduledTaskQueue;
        if (priorityQueue == null) {
            return null;
        }
        return priorityQueue.peek();
    }

    protected final Runnable pollScheduledTask(long j6) {
        PriorityQueue<ScheduledFutureTask<?>> priorityQueue = this.scheduledTaskQueue;
        ScheduledFutureTask<?> peek = priorityQueue == null ? null : priorityQueue.peek();
        if (peek == null || peek.deadlineNanos() > j6) {
            return null;
        }
        priorityQueue.remove();
        return peek;
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j6, long j7, TimeUnit timeUnit) {
        ObjectUtil.checkNotNull(runnable, "command");
        ObjectUtil.checkNotNull(timeUnit, "unit");
        if (j6 < 0) {
            throw new IllegalArgumentException(String.format("initialDelay: %d (expected: >= 0)", Long.valueOf(j6)));
        }
        if (j7 <= 0) {
            throw new IllegalArgumentException(String.format("period: %d (expected: > 0)", Long.valueOf(j7)));
        }
        validateScheduled0(j6, timeUnit);
        validateScheduled0(j7, timeUnit);
        return schedule(new ScheduledFutureTask(this, Executors.callable(runnable, null), ScheduledFutureTask.deadlineNanos(timeUnit.toNanos(j6)), timeUnit.toNanos(j7)));
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j6, long j7, TimeUnit timeUnit) {
        ObjectUtil.checkNotNull(runnable, "command");
        ObjectUtil.checkNotNull(timeUnit, "unit");
        if (j6 < 0) {
            throw new IllegalArgumentException(String.format("initialDelay: %d (expected: >= 0)", Long.valueOf(j6)));
        }
        if (j7 <= 0) {
            throw new IllegalArgumentException(String.format("delay: %d (expected: > 0)", Long.valueOf(j7)));
        }
        validateScheduled0(j6, timeUnit);
        validateScheduled0(j7, timeUnit);
        return schedule(new ScheduledFutureTask(this, Executors.callable(runnable, null), ScheduledFutureTask.deadlineNanos(timeUnit.toNanos(j6)), -timeUnit.toNanos(j7)));
    }

    PriorityQueue<ScheduledFutureTask<?>> scheduledTaskQueue() {
        if (this.scheduledTaskQueue == null) {
            this.scheduledTaskQueue = new DefaultPriorityQueue(SCHEDULED_FUTURE_TASK_COMPARATOR, 11);
        }
        return this.scheduledTaskQueue;
    }

    protected static long nanoTime() {
        return ScheduledFutureTask.nanoTime();
    }

    private void validateScheduled0(long j6, TimeUnit timeUnit) {
        validateScheduled(j6, timeUnit);
    }

    final void removeScheduled(final ScheduledFutureTask<?> scheduledFutureTask) {
        if (inEventLoop()) {
            scheduledTaskQueue().removeTyped(scheduledFutureTask);
        } else {
            execute(new Runnable() { // from class: io.netty.util.concurrent.AbstractScheduledEventExecutor.3
                @Override // java.lang.Runnable
                public void run() {
                    AbstractScheduledEventExecutor.this.removeScheduled(scheduledFutureTask);
                }
            });
        }
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(Runnable runnable, long j6, TimeUnit timeUnit) {
        ObjectUtil.checkNotNull(runnable, "command");
        ObjectUtil.checkNotNull(timeUnit, "unit");
        if (j6 < 0) {
            j6 = 0;
        }
        validateScheduled0(j6, timeUnit);
        return schedule(new ScheduledFutureTask(this, runnable, (Object) null, ScheduledFutureTask.deadlineNanos(timeUnit.toNanos(j6))));
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ScheduledExecutorService
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j6, TimeUnit timeUnit) {
        ObjectUtil.checkNotNull(callable, "callable");
        ObjectUtil.checkNotNull(timeUnit, "unit");
        if (j6 < 0) {
            j6 = 0;
        }
        validateScheduled0(j6, timeUnit);
        return schedule(new ScheduledFutureTask<>(this, callable, ScheduledFutureTask.deadlineNanos(timeUnit.toNanos(j6))));
    }

    <V> ScheduledFuture<V> schedule(final ScheduledFutureTask<V> scheduledFutureTask) {
        if (inEventLoop()) {
            scheduledTaskQueue().add(scheduledFutureTask);
            return scheduledFutureTask;
        }
        execute(new Runnable() { // from class: io.netty.util.concurrent.AbstractScheduledEventExecutor.2
            @Override // java.lang.Runnable
            public void run() {
                AbstractScheduledEventExecutor.this.scheduledTaskQueue().add(scheduledFutureTask);
            }
        });
        return scheduledFutureTask;
    }

    @Deprecated
    protected void validateScheduled(long j6, TimeUnit timeUnit) {
    }
}
