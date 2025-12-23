package io.netty.channel;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public class ThreadPerChannelEventLoop extends SingleThreadEventLoop {
    private Channel ch;
    private final ThreadPerChannelEventLoopGroup parent;

    protected void deregister() {
        this.ch = null;
        this.parent.activeChildren.remove(this);
        this.parent.idleChildren.add(this);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [io.netty.channel.ChannelFuture] */
    @Override // io.netty.channel.SingleThreadEventLoop, io.netty.channel.EventLoopGroup
    public ChannelFuture register(ChannelPromise channelPromise) {
        return super.register(channelPromise).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.ThreadPerChannelEventLoop.1
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if (!channelFuture.isSuccess()) {
                    ThreadPerChannelEventLoop.this.deregister();
                } else {
                    ThreadPerChannelEventLoop.this.ch = channelFuture.channel();
                }
            }
        });
    }

    @Override // io.netty.channel.SingleThreadEventLoop
    public int registeredChannels() {
        return 1;
    }

    public ThreadPerChannelEventLoop(ThreadPerChannelEventLoopGroup threadPerChannelEventLoopGroup) {
        super((EventLoopGroup) threadPerChannelEventLoopGroup, threadPerChannelEventLoopGroup.executor, true);
        this.parent = threadPerChannelEventLoopGroup;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [io.netty.channel.ChannelFuture] */
    @Override // io.netty.channel.SingleThreadEventLoop, io.netty.channel.EventLoopGroup
    @Deprecated
    public ChannelFuture register(Channel channel, ChannelPromise channelPromise) {
        return super.register(channel, channelPromise).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.ThreadPerChannelEventLoop.2
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if (!channelFuture.isSuccess()) {
                    ThreadPerChannelEventLoop.this.deregister();
                } else {
                    ThreadPerChannelEventLoop.this.ch = channelFuture.channel();
                }
            }
        });
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    protected void run() {
        while (true) {
            Runnable takeTask = takeTask();
            if (takeTask != null) {
                takeTask.run();
                updateLastExecutionTime();
            }
            Channel channel = this.ch;
            if (isShuttingDown()) {
                if (channel != null) {
                    channel.unsafe().close(channel.unsafe().voidPromise());
                }
                if (confirmShutdown()) {
                    return;
                }
            } else if (channel != null && !channel.isRegistered()) {
                runAllTasks();
                deregister();
            }
        }
    }
}
