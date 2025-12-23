package io.netty.channel;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ChannelHandler.Sharable
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class ChannelInitializer<C extends Channel> extends ChannelInboundHandlerAdapter {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ChannelInitializer.class);
    private final Set<ChannelHandlerContext> initMap = Collections.newSetFromMap(new ConcurrentHashMap());

    /* JADX WARN: Multi-variable type inference failed */
    private boolean initChannel(ChannelHandlerContext channelHandlerContext) throws Exception {
        ChannelHandlerContext context;
        if (!this.initMap.add(channelHandlerContext)) {
            return false;
        }
        try {
            initChannel((ChannelInitializer<C>) channelHandlerContext.channel());
            if (context == null) {
                return true;
            }
        } catch (Throwable th) {
            try {
                exceptionCaught(channelHandlerContext, th);
                ChannelPipeline pipeline = channelHandlerContext.pipeline();
                if (pipeline.context(this) == null) {
                    return true;
                }
            } finally {
                ChannelPipeline pipeline2 = channelHandlerContext.pipeline();
                if (pipeline2.context(this) != null) {
                    pipeline2.remove(this);
                }
            }
        }
        return true;
    }

    protected abstract void initChannel(C c6) throws Exception;

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        InternalLogger internalLogger = logger;
        if (internalLogger.isWarnEnabled()) {
            internalLogger.warn("Failed to initialize a channel. Closing: " + channelHandlerContext.channel(), th);
        }
        channelHandlerContext.close();
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.initMap.remove(channelHandlerContext);
    }

    private void removeState(final ChannelHandlerContext channelHandlerContext) {
        if (channelHandlerContext.isRemoved()) {
            this.initMap.remove(channelHandlerContext);
        } else {
            channelHandlerContext.executor().execute(new Runnable() { // from class: io.netty.channel.ChannelInitializer.1
                @Override // java.lang.Runnable
                public void run() {
                    ChannelInitializer.this.initMap.remove(channelHandlerContext);
                }
            });
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public final void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (initChannel(channelHandlerContext)) {
            channelHandlerContext.pipeline().fireChannelRegistered();
            removeState(channelHandlerContext);
        } else {
            channelHandlerContext.fireChannelRegistered();
        }
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (channelHandlerContext.channel().isRegistered() && initChannel(channelHandlerContext)) {
            removeState(channelHandlerContext);
        }
    }
}
