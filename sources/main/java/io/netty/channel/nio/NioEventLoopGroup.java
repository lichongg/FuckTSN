package io.netty.channel.nio;

import io.netty.channel.DefaultSelectStrategyFactory;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopTaskQueueFactory;
import io.netty.channel.MultithreadEventLoopGroup;
import io.netty.channel.SelectStrategyFactory;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.EventExecutorChooserFactory;
import io.netty.util.concurrent.RejectedExecutionHandler;
import io.netty.util.concurrent.RejectedExecutionHandlers;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class NioEventLoopGroup extends MultithreadEventLoopGroup {
    public NioEventLoopGroup() {
        this(0);
    }

    public NioEventLoopGroup(int i6) {
        this(i6, (Executor) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.MultithreadEventLoopGroup, io.netty.util.concurrent.MultithreadEventExecutorGroup
    public EventLoop newChild(Executor executor, Object... objArr) throws Exception {
        return new NioEventLoop(this, executor, (SelectorProvider) objArr[0], ((SelectStrategyFactory) objArr[1]).newSelectStrategy(), (RejectedExecutionHandler) objArr[2], objArr.length == 4 ? (EventLoopTaskQueueFactory) objArr[3] : null);
    }

    public NioEventLoopGroup(int i6, ThreadFactory threadFactory) {
        this(i6, threadFactory, SelectorProvider.provider());
    }

    public void rebuildSelectors() {
        Iterator<EventExecutor> it = iterator();
        while (it.hasNext()) {
            ((NioEventLoop) it.next()).rebuildSelector();
        }
    }

    public void setIoRatio(int i6) {
        Iterator<EventExecutor> it = iterator();
        while (it.hasNext()) {
            ((NioEventLoop) it.next()).setIoRatio(i6);
        }
    }

    public NioEventLoopGroup(int i6, Executor executor) {
        this(i6, executor, SelectorProvider.provider());
    }

    public NioEventLoopGroup(int i6, ThreadFactory threadFactory, SelectorProvider selectorProvider) {
        this(i6, threadFactory, selectorProvider, DefaultSelectStrategyFactory.INSTANCE);
    }

    public NioEventLoopGroup(int i6, ThreadFactory threadFactory, SelectorProvider selectorProvider, SelectStrategyFactory selectStrategyFactory) {
        super(i6, threadFactory, selectorProvider, selectStrategyFactory, RejectedExecutionHandlers.reject());
    }

    public NioEventLoopGroup(int i6, Executor executor, SelectorProvider selectorProvider) {
        this(i6, executor, selectorProvider, DefaultSelectStrategyFactory.INSTANCE);
    }

    public NioEventLoopGroup(int i6, Executor executor, SelectorProvider selectorProvider, SelectStrategyFactory selectStrategyFactory) {
        super(i6, executor, selectorProvider, selectStrategyFactory, RejectedExecutionHandlers.reject());
    }

    public NioEventLoopGroup(int i6, Executor executor, EventExecutorChooserFactory eventExecutorChooserFactory, SelectorProvider selectorProvider, SelectStrategyFactory selectStrategyFactory) {
        super(i6, executor, eventExecutorChooserFactory, selectorProvider, selectStrategyFactory, RejectedExecutionHandlers.reject());
    }

    public NioEventLoopGroup(int i6, Executor executor, EventExecutorChooserFactory eventExecutorChooserFactory, SelectorProvider selectorProvider, SelectStrategyFactory selectStrategyFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i6, executor, eventExecutorChooserFactory, selectorProvider, selectStrategyFactory, rejectedExecutionHandler);
    }

    public NioEventLoopGroup(int i6, Executor executor, EventExecutorChooserFactory eventExecutorChooserFactory, SelectorProvider selectorProvider, SelectStrategyFactory selectStrategyFactory, RejectedExecutionHandler rejectedExecutionHandler, EventLoopTaskQueueFactory eventLoopTaskQueueFactory) {
        super(i6, executor, eventExecutorChooserFactory, selectorProvider, selectStrategyFactory, rejectedExecutionHandler, eventLoopTaskQueueFactory);
    }
}
