package io.netty.channel;

import io.netty.util.concurrent.DefaultThreadFactory;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultEventLoop extends SingleThreadEventLoop {
    public DefaultEventLoop() {
        this((EventLoopGroup) null);
    }

    public DefaultEventLoop(ThreadFactory threadFactory) {
        this((EventLoopGroup) null, threadFactory);
    }

    public DefaultEventLoop(Executor executor) {
        this((EventLoopGroup) null, executor);
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    protected void run() {
        do {
            Runnable takeTask = takeTask();
            if (takeTask != null) {
                takeTask.run();
                updateLastExecutionTime();
            }
        } while (!confirmShutdown());
    }

    public DefaultEventLoop(EventLoopGroup eventLoopGroup) {
        this(eventLoopGroup, new DefaultThreadFactory((Class<?>) DefaultEventLoop.class));
    }

    public DefaultEventLoop(EventLoopGroup eventLoopGroup, ThreadFactory threadFactory) {
        super(eventLoopGroup, threadFactory, true);
    }

    public DefaultEventLoop(EventLoopGroup eventLoopGroup, Executor executor) {
        super(eventLoopGroup, executor, true);
    }
}
