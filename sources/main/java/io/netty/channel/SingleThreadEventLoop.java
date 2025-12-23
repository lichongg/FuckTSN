package io.netty.channel;

import io.netty.util.concurrent.RejectedExecutionHandler;
import io.netty.util.concurrent.RejectedExecutionHandlers;
import io.netty.util.concurrent.SingleThreadEventExecutor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SystemPropertyUtil;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class SingleThreadEventLoop extends SingleThreadEventExecutor implements EventLoop {
    protected static final int DEFAULT_MAX_PENDING_TASKS = Math.max(16, SystemPropertyUtil.getInt("io.netty.eventLoop.maxPendingTasks", Integer.MAX_VALUE));
    private final Queue<Runnable> tailTasks;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface NonWakeupRunnable extends Runnable {
    }

    protected SingleThreadEventLoop(EventLoopGroup eventLoopGroup, ThreadFactory threadFactory, boolean z5) {
        this(eventLoopGroup, threadFactory, z5, DEFAULT_MAX_PENDING_TASKS, RejectedExecutionHandlers.reject());
    }

    @Override // io.netty.channel.EventLoopGroup
    public ChannelFuture register(Channel channel) {
        return register(new DefaultChannelPromise(channel, this));
    }

    public int registeredChannels() {
        return -1;
    }

    protected SingleThreadEventLoop(EventLoopGroup eventLoopGroup, Executor executor, boolean z5) {
        this(eventLoopGroup, executor, z5, DEFAULT_MAX_PENDING_TASKS, RejectedExecutionHandlers.reject());
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    protected void afterRunningAllTasks() {
        runAllTasksFrom(this.tailTasks);
    }

    public final void executeAfterEventLoopIteration(Runnable runnable) {
        ObjectUtil.checkNotNull(runnable, "task");
        if (isShutdown()) {
            SingleThreadEventExecutor.reject();
        }
        if (!this.tailTasks.offer(runnable)) {
            reject(runnable);
        }
        if (wakesUpForTask(runnable)) {
            wakeup(inEventLoop());
        }
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, io.netty.util.concurrent.EventExecutor, io.netty.util.concurrent.EventExecutorGroup, io.netty.channel.EventLoopGroup
    public EventLoop next() {
        return (EventLoop) super.next();
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, io.netty.util.concurrent.EventExecutor, io.netty.channel.EventLoop
    public EventLoopGroup parent() {
        return (EventLoopGroup) super.parent();
    }

    @Override // io.netty.channel.EventLoopGroup
    public ChannelFuture register(ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(channelPromise, "promise");
        channelPromise.channel().unsafe().register(this, channelPromise);
        return channelPromise;
    }

    final boolean removeAfterEventLoopIterationTask(Runnable runnable) {
        return this.tailTasks.remove(ObjectUtil.checkNotNull(runnable, "task"));
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    protected boolean wakesUpForTask(Runnable runnable) {
        return !(runnable instanceof NonWakeupRunnable);
    }

    protected SingleThreadEventLoop(EventLoopGroup eventLoopGroup, ThreadFactory threadFactory, boolean z5, int i6, RejectedExecutionHandler rejectedExecutionHandler) {
        super(eventLoopGroup, threadFactory, z5, i6, rejectedExecutionHandler);
        this.tailTasks = newTaskQueue(i6);
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    protected boolean hasTasks() {
        if (!super.hasTasks() && this.tailTasks.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    public int pendingTasks() {
        return super.pendingTasks() + this.tailTasks.size();
    }

    @Override // io.netty.channel.EventLoopGroup
    @Deprecated
    public ChannelFuture register(Channel channel, ChannelPromise channelPromise) {
        if (channel == null) {
            throw new NullPointerException("channel");
        }
        if (channelPromise != null) {
            channel.unsafe().register(this, channelPromise);
            return channelPromise;
        }
        throw new NullPointerException("promise");
    }

    protected SingleThreadEventLoop(EventLoopGroup eventLoopGroup, Executor executor, boolean z5, int i6, RejectedExecutionHandler rejectedExecutionHandler) {
        super(eventLoopGroup, executor, z5, i6, rejectedExecutionHandler);
        this.tailTasks = newTaskQueue(i6);
    }

    protected SingleThreadEventLoop(EventLoopGroup eventLoopGroup, Executor executor, boolean z5, Queue<Runnable> queue, Queue<Runnable> queue2, RejectedExecutionHandler rejectedExecutionHandler) {
        super(eventLoopGroup, executor, z5, queue, rejectedExecutionHandler);
        this.tailTasks = (Queue) ObjectUtil.checkNotNull(queue2, "tailTaskQueue");
    }
}
