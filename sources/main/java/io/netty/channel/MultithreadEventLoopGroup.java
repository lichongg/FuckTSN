package io.netty.channel;

import io.netty.util.NettyRuntime;
import io.netty.util.concurrent.DefaultThreadFactory;
import io.netty.util.concurrent.EventExecutorChooserFactory;
import io.netty.util.concurrent.MultithreadEventExecutorGroup;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class MultithreadEventLoopGroup extends MultithreadEventExecutorGroup implements EventLoopGroup {
    private static final int DEFAULT_EVENT_LOOP_THREADS;
    private static final InternalLogger logger;

    protected MultithreadEventLoopGroup(int i6, Executor executor, Object... objArr) {
        super(i6 == 0 ? DEFAULT_EVENT_LOOP_THREADS : i6, executor, objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.util.concurrent.MultithreadEventExecutorGroup
    public abstract EventLoop newChild(Executor executor, Object... objArr) throws Exception;

    @Override // io.netty.channel.EventLoopGroup
    public ChannelFuture register(Channel channel) {
        return next().register(channel);
    }

    static {
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) MultithreadEventLoopGroup.class);
        logger = internalLoggerFactory;
        int max = Math.max(1, SystemPropertyUtil.getInt("io.netty.eventLoopThreads", NettyRuntime.availableProcessors() * 2));
        DEFAULT_EVENT_LOOP_THREADS = max;
        if (internalLoggerFactory.isDebugEnabled()) {
            internalLoggerFactory.debug("-Dio.netty.eventLoopThreads: {}", Integer.valueOf(max));
        }
    }

    protected MultithreadEventLoopGroup(int i6, ThreadFactory threadFactory, Object... objArr) {
        super(i6 == 0 ? DEFAULT_EVENT_LOOP_THREADS : i6, threadFactory, objArr);
    }

    @Override // io.netty.util.concurrent.MultithreadEventExecutorGroup
    protected ThreadFactory newDefaultThreadFactory() {
        return new DefaultThreadFactory(getClass(), 10);
    }

    @Override // io.netty.util.concurrent.MultithreadEventExecutorGroup, io.netty.util.concurrent.EventExecutorGroup, io.netty.channel.EventLoopGroup
    public EventLoop next() {
        return (EventLoop) super.next();
    }

    @Override // io.netty.channel.EventLoopGroup
    public ChannelFuture register(ChannelPromise channelPromise) {
        return next().register(channelPromise);
    }

    protected MultithreadEventLoopGroup(int i6, Executor executor, EventExecutorChooserFactory eventExecutorChooserFactory, Object... objArr) {
        super(i6 == 0 ? DEFAULT_EVENT_LOOP_THREADS : i6, executor, eventExecutorChooserFactory, objArr);
    }

    @Override // io.netty.channel.EventLoopGroup
    @Deprecated
    public ChannelFuture register(Channel channel, ChannelPromise channelPromise) {
        return next().register(channel, channelPromise);
    }
}
