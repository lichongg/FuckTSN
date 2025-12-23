package io.netty.channel.epoll;

import io.netty.channel.DefaultSelectStrategyFactory;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopTaskQueueFactory;
import io.netty.channel.MultithreadEventLoopGroup;
import io.netty.channel.SelectStrategyFactory;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.EventExecutorChooserFactory;
import io.netty.util.concurrent.RejectedExecutionHandler;
import io.netty.util.concurrent.RejectedExecutionHandlers;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class EpollEventLoopGroup extends MultithreadEventLoopGroup {
    public EpollEventLoopGroup() {
        this(0);
    }

    public EpollEventLoopGroup(int i6) {
        this(i6, (ThreadFactory) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.MultithreadEventLoopGroup, io.netty.util.concurrent.MultithreadEventExecutorGroup
    public EventLoop newChild(Executor executor, Object... objArr) throws Exception {
        return new EpollEventLoop(this, executor, ((Integer) objArr[0]).intValue(), ((SelectStrategyFactory) objArr[1]).newSelectStrategy(), (RejectedExecutionHandler) objArr[2], objArr.length == 4 ? (EventLoopTaskQueueFactory) objArr[3] : null);
    }

    public EpollEventLoopGroup(int i6, SelectStrategyFactory selectStrategyFactory) {
        this(i6, (ThreadFactory) null, selectStrategyFactory);
    }

    public void setIoRatio(int i6) {
        Iterator<EventExecutor> it = iterator();
        while (it.hasNext()) {
            ((EpollEventLoop) it.next()).setIoRatio(i6);
        }
    }

    public EpollEventLoopGroup(int i6, ThreadFactory threadFactory) {
        this(i6, threadFactory, 0);
    }

    public EpollEventLoopGroup(int i6, Executor executor) {
        this(i6, executor, DefaultSelectStrategyFactory.INSTANCE);
    }

    public EpollEventLoopGroup(int i6, ThreadFactory threadFactory, SelectStrategyFactory selectStrategyFactory) {
        this(i6, threadFactory, 0, selectStrategyFactory);
    }

    @Deprecated
    public EpollEventLoopGroup(int i6, ThreadFactory threadFactory, int i7) {
        this(i6, threadFactory, i7, DefaultSelectStrategyFactory.INSTANCE);
    }

    @Deprecated
    public EpollEventLoopGroup(int i6, ThreadFactory threadFactory, int i7, SelectStrategyFactory selectStrategyFactory) {
        super(i6, threadFactory, Integer.valueOf(i7), selectStrategyFactory, RejectedExecutionHandlers.reject());
        Epoll.ensureAvailability();
    }

    public EpollEventLoopGroup(int i6, Executor executor, SelectStrategyFactory selectStrategyFactory) {
        super(i6, executor, 0, selectStrategyFactory, RejectedExecutionHandlers.reject());
        Epoll.ensureAvailability();
    }

    public EpollEventLoopGroup(int i6, Executor executor, EventExecutorChooserFactory eventExecutorChooserFactory, SelectStrategyFactory selectStrategyFactory) {
        super(i6, executor, eventExecutorChooserFactory, 0, selectStrategyFactory, RejectedExecutionHandlers.reject());
        Epoll.ensureAvailability();
    }

    public EpollEventLoopGroup(int i6, Executor executor, EventExecutorChooserFactory eventExecutorChooserFactory, SelectStrategyFactory selectStrategyFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i6, executor, eventExecutorChooserFactory, 0, selectStrategyFactory, rejectedExecutionHandler);
        Epoll.ensureAvailability();
    }

    public EpollEventLoopGroup(int i6, Executor executor, EventExecutorChooserFactory eventExecutorChooserFactory, SelectStrategyFactory selectStrategyFactory, RejectedExecutionHandler rejectedExecutionHandler, EventLoopTaskQueueFactory eventLoopTaskQueueFactory) {
        super(i6, executor, eventExecutorChooserFactory, 0, selectStrategyFactory, rejectedExecutionHandler, eventLoopTaskQueueFactory);
        Epoll.ensureAvailability();
    }
}
