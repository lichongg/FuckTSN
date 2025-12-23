package io.netty.util.concurrent;

import io.netty.util.internal.DefaultPriorityQueue;
import io.netty.util.internal.PriorityQueueNode;
import io.netty.util.internal.StringUtil;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class ScheduledFutureTask<V> extends PromiseTask<V> implements ScheduledFuture<V>, PriorityQueueNode {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private long deadlineNanos;
    private final long id;
    private final long periodNanos;
    private int queueIndex;
    private static final AtomicLong nextTaskId = new AtomicLong();
    private static final long START_TIME = System.nanoTime();

    ScheduledFutureTask(AbstractScheduledEventExecutor abstractScheduledEventExecutor, Runnable runnable, V v5, long j6) {
        this(abstractScheduledEventExecutor, PromiseTask.toCallable(runnable, v5), j6);
    }

    static long deadlineNanos(long j6) {
        long nanoTime = nanoTime() + j6;
        if (nanoTime < 0) {
            return Long.MAX_VALUE;
        }
        return nanoTime;
    }

    public long delayNanos() {
        return Math.max(0L, deadlineNanos() - nanoTime());
    }

    @Override // io.netty.util.internal.PriorityQueueNode
    public int priorityQueueIndex(DefaultPriorityQueue<?> defaultPriorityQueue) {
        return this.queueIndex;
    }

    ScheduledFutureTask(AbstractScheduledEventExecutor abstractScheduledEventExecutor, Callable<V> callable, long j6, long j7) {
        super(abstractScheduledEventExecutor, callable);
        this.id = nextTaskId.getAndIncrement();
        this.queueIndex = -1;
        if (j7 == 0) {
            throw new IllegalArgumentException("period: 0 (expected: != 0)");
        }
        this.deadlineNanos = j6;
        this.periodNanos = j7;
    }

    @Override // java.lang.Comparable
    public int compareTo(Delayed delayed) {
        if (this == delayed) {
            return 0;
        }
        ScheduledFutureTask scheduledFutureTask = (ScheduledFutureTask) delayed;
        long deadlineNanos = deadlineNanos() - scheduledFutureTask.deadlineNanos();
        if (deadlineNanos < 0) {
            return -1;
        }
        if (deadlineNanos > 0) {
            return 1;
        }
        long j6 = this.id;
        long j7 = scheduledFutureTask.id;
        if (j6 < j7) {
            return -1;
        }
        if (j6 != j7) {
            return 1;
        }
        throw new Error();
    }

    public long deadlineNanos() {
        return this.deadlineNanos;
    }

    public long delayNanos(long j6) {
        return Math.max(0L, deadlineNanos() - (j6 - START_TIME));
    }

    @Override // io.netty.util.internal.PriorityQueueNode
    public void priorityQueueIndex(DefaultPriorityQueue<?> defaultPriorityQueue, int i6) {
        this.queueIndex = i6;
    }

    @Override // io.netty.util.concurrent.PromiseTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        try {
            if (this.periodNanos == 0) {
                if (setUncancellableInternal()) {
                    setSuccessInternal(this.task.call());
                }
            } else {
                if (isCancelled()) {
                    return;
                }
                this.task.call();
                if (executor().isShutdown()) {
                    return;
                }
                long j6 = this.periodNanos;
                if (j6 > 0) {
                    this.deadlineNanos += j6;
                } else {
                    this.deadlineNanos = nanoTime() - j6;
                }
                if (isCancelled()) {
                    return;
                }
                ((AbstractScheduledEventExecutor) executor()).scheduledTaskQueue.add(this);
            }
        } catch (Throwable th) {
            setFailureInternal(th);
        }
    }

    static long nanoTime() {
        return System.nanoTime() - START_TIME;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future, java.util.concurrent.Future
    public boolean cancel(boolean z5) {
        boolean cancel = super.cancel(z5);
        if (cancel) {
            ((AbstractScheduledEventExecutor) executor()).removeScheduled(this);
        }
        return cancel;
    }

    boolean cancelWithoutRemove(boolean z5) {
        return super.cancel(z5);
    }

    @Override // io.netty.util.concurrent.DefaultPromise
    protected EventExecutor executor() {
        return super.executor();
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit timeUnit) {
        return timeUnit.convert(delayNanos(), TimeUnit.NANOSECONDS);
    }

    @Override // io.netty.util.concurrent.PromiseTask, io.netty.util.concurrent.DefaultPromise
    protected StringBuilder toStringBuilder() {
        StringBuilder stringBuilder = super.toStringBuilder();
        stringBuilder.setCharAt(stringBuilder.length() - 1, StringUtil.COMMA);
        stringBuilder.append(" id: ");
        stringBuilder.append(this.id);
        stringBuilder.append(", deadline: ");
        stringBuilder.append(this.deadlineNanos);
        stringBuilder.append(", period: ");
        stringBuilder.append(this.periodNanos);
        stringBuilder.append(')');
        return stringBuilder;
    }

    ScheduledFutureTask(AbstractScheduledEventExecutor abstractScheduledEventExecutor, Callable<V> callable, long j6) {
        super(abstractScheduledEventExecutor, callable);
        this.id = nextTaskId.getAndIncrement();
        this.queueIndex = -1;
        this.deadlineNanos = j6;
        this.periodNanos = 0L;
    }
}
