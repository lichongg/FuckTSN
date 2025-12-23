package io.netty.channel;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class CombinedChannelDuplexHandler<I extends ChannelInboundHandler, O extends ChannelOutboundHandler> extends ChannelDuplexHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) CombinedChannelDuplexHandler.class);
    private volatile boolean handlerAdded;
    private DelegatingChannelHandlerContext inboundCtx;
    private I inboundHandler;
    private DelegatingChannelHandlerContext outboundCtx;
    private O outboundHandler;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class DelegatingChannelHandlerContext implements ChannelHandlerContext {
        private final ChannelHandlerContext ctx;
        private final ChannelHandler handler;
        boolean removed;

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture bind(SocketAddress socketAddress) {
            return this.ctx.bind(socketAddress);
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture close() {
            return this.ctx.close();
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture connect(SocketAddress socketAddress) {
            return this.ctx.connect(socketAddress);
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture deregister() {
            return this.ctx.deregister();
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture disconnect() {
            return this.ctx.disconnect();
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture write(Object obj) {
            return this.ctx.write(obj);
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture writeAndFlush(Object obj, ChannelPromise channelPromise) {
            return this.ctx.writeAndFlush(obj, channelPromise);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void remove0() {
            if (this.removed) {
                return;
            }
            this.removed = true;
            try {
                this.handler.handlerRemoved(this);
            } catch (Throwable th) {
                fireExceptionCaught((Throwable) new ChannelPipelineException(this.handler.getClass().getName() + ".handlerRemoved() has thrown an exception.", th));
            }
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public ByteBufAllocator alloc() {
            return this.ctx.alloc();
        }

        @Override // io.netty.channel.ChannelHandlerContext, io.netty.util.AttributeMap
        public <T> Attribute<T> attr(AttributeKey<T> attributeKey) {
            return this.ctx.channel().attr(attributeKey);
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture bind(SocketAddress socketAddress, ChannelPromise channelPromise) {
            return this.ctx.bind(socketAddress, channelPromise);
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public Channel channel() {
            return this.ctx.channel();
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture close(ChannelPromise channelPromise) {
            return this.ctx.close(channelPromise);
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress2) {
            return this.ctx.connect(socketAddress, socketAddress2);
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture deregister(ChannelPromise channelPromise) {
            return this.ctx.deregister(channelPromise);
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture disconnect(ChannelPromise channelPromise) {
            return this.ctx.disconnect(channelPromise);
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public EventExecutor executor() {
            return this.ctx.executor();
        }

        @Override // io.netty.channel.ChannelInboundInvoker
        public ChannelHandlerContext fireChannelActive() {
            this.ctx.fireChannelActive();
            return this;
        }

        @Override // io.netty.channel.ChannelInboundInvoker
        public ChannelHandlerContext fireChannelInactive() {
            this.ctx.fireChannelInactive();
            return this;
        }

        @Override // io.netty.channel.ChannelInboundInvoker
        public ChannelHandlerContext fireChannelRead(Object obj) {
            this.ctx.fireChannelRead(obj);
            return this;
        }

        @Override // io.netty.channel.ChannelInboundInvoker
        public ChannelHandlerContext fireChannelReadComplete() {
            this.ctx.fireChannelReadComplete();
            return this;
        }

        @Override // io.netty.channel.ChannelInboundInvoker
        public ChannelHandlerContext fireChannelRegistered() {
            this.ctx.fireChannelRegistered();
            return this;
        }

        @Override // io.netty.channel.ChannelInboundInvoker
        public ChannelHandlerContext fireChannelUnregistered() {
            this.ctx.fireChannelUnregistered();
            return this;
        }

        @Override // io.netty.channel.ChannelInboundInvoker
        public ChannelHandlerContext fireChannelWritabilityChanged() {
            this.ctx.fireChannelWritabilityChanged();
            return this;
        }

        @Override // io.netty.channel.ChannelInboundInvoker
        public ChannelHandlerContext fireExceptionCaught(Throwable th) {
            this.ctx.fireExceptionCaught(th);
            return this;
        }

        @Override // io.netty.channel.ChannelInboundInvoker
        public ChannelHandlerContext fireUserEventTriggered(Object obj) {
            this.ctx.fireUserEventTriggered(obj);
            return this;
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelHandlerContext flush() {
            this.ctx.flush();
            return this;
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public ChannelHandler handler() {
            return this.ctx.handler();
        }

        @Override // io.netty.channel.ChannelHandlerContext, io.netty.util.AttributeMap
        public <T> boolean hasAttr(AttributeKey<T> attributeKey) {
            return this.ctx.channel().hasAttr(attributeKey);
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public boolean isRemoved() {
            return this.removed || this.ctx.isRemoved();
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public String name() {
            return this.ctx.name();
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture newFailedFuture(Throwable th) {
            return this.ctx.newFailedFuture(th);
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelProgressivePromise newProgressivePromise() {
            return this.ctx.newProgressivePromise();
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelPromise newPromise() {
            return this.ctx.newPromise();
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture newSucceededFuture() {
            return this.ctx.newSucceededFuture();
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public ChannelPipeline pipeline() {
            return this.ctx.pipeline();
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelHandlerContext read() {
            this.ctx.read();
            return this;
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelPromise voidPromise() {
            return this.ctx.voidPromise();
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture write(Object obj, ChannelPromise channelPromise) {
            return this.ctx.write(obj, channelPromise);
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture writeAndFlush(Object obj) {
            return this.ctx.writeAndFlush(obj);
        }

        DelegatingChannelHandlerContext(ChannelHandlerContext channelHandlerContext, ChannelHandler channelHandler) {
            this.ctx = channelHandlerContext;
            this.handler = channelHandler;
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture connect(SocketAddress socketAddress, ChannelPromise channelPromise) {
            return this.ctx.connect(socketAddress, channelPromise);
        }

        final void remove() {
            EventExecutor executor = executor();
            if (executor.inEventLoop()) {
                remove0();
            } else {
                executor.execute(new Runnable() { // from class: io.netty.channel.CombinedChannelDuplexHandler.DelegatingChannelHandlerContext.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DelegatingChannelHandlerContext.this.remove0();
                    }
                });
            }
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
            return this.ctx.connect(socketAddress, socketAddress2, channelPromise);
        }
    }

    protected CombinedChannelDuplexHandler() {
        ensureNotSharable();
    }

    private void checkAdded() {
        if (!this.handlerAdded) {
            throw new IllegalStateException("handler not added to pipeline yet");
        }
    }

    private void validate(I i6, O o5) {
        if (this.inboundHandler != null) {
            throw new IllegalStateException("init() can not be invoked if " + CombinedChannelDuplexHandler.class.getSimpleName() + " was constructed with non-default constructor.");
        }
        if (i6 == null) {
            throw new NullPointerException("inboundHandler");
        }
        if (o5 == null) {
            throw new NullPointerException("outboundHandler");
        }
        if (i6 instanceof ChannelOutboundHandler) {
            throw new IllegalArgumentException("inboundHandler must not implement " + ChannelOutboundHandler.class.getSimpleName() + " to get combined.");
        }
        if (o5 instanceof ChannelInboundHandler) {
            throw new IllegalArgumentException("outboundHandler must not implement " + ChannelInboundHandler.class.getSimpleName() + " to get combined.");
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void bind(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, ChannelPromise channelPromise) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.outboundCtx;
        if (delegatingChannelHandlerContext.removed) {
            delegatingChannelHandlerContext.bind(socketAddress, channelPromise);
        } else {
            this.outboundHandler.bind(delegatingChannelHandlerContext, socketAddress, channelPromise);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (delegatingChannelHandlerContext.removed) {
            delegatingChannelHandlerContext.fireChannelActive();
        } else {
            this.inboundHandler.channelActive(delegatingChannelHandlerContext);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (delegatingChannelHandlerContext.removed) {
            delegatingChannelHandlerContext.fireChannelInactive();
        } else {
            this.inboundHandler.channelInactive(delegatingChannelHandlerContext);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (delegatingChannelHandlerContext.removed) {
            delegatingChannelHandlerContext.fireChannelRead(obj);
        } else {
            this.inboundHandler.channelRead(delegatingChannelHandlerContext, obj);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (delegatingChannelHandlerContext.removed) {
            delegatingChannelHandlerContext.fireChannelReadComplete();
        } else {
            this.inboundHandler.channelReadComplete(delegatingChannelHandlerContext);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (delegatingChannelHandlerContext.removed) {
            delegatingChannelHandlerContext.fireChannelRegistered();
        } else {
            this.inboundHandler.channelRegistered(delegatingChannelHandlerContext);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelUnregistered(ChannelHandlerContext channelHandlerContext) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (delegatingChannelHandlerContext.removed) {
            delegatingChannelHandlerContext.fireChannelUnregistered();
        } else {
            this.inboundHandler.channelUnregistered(delegatingChannelHandlerContext);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (delegatingChannelHandlerContext.removed) {
            delegatingChannelHandlerContext.fireChannelWritabilityChanged();
        } else {
            this.inboundHandler.channelWritabilityChanged(delegatingChannelHandlerContext);
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.outboundCtx;
        if (delegatingChannelHandlerContext.removed) {
            delegatingChannelHandlerContext.close(channelPromise);
        } else {
            this.outboundHandler.close(delegatingChannelHandlerContext, channelPromise);
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.outboundCtx;
        if (delegatingChannelHandlerContext.removed) {
            delegatingChannelHandlerContext.connect(socketAddress2, channelPromise);
        } else {
            this.outboundHandler.connect(delegatingChannelHandlerContext, socketAddress, socketAddress2, channelPromise);
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void deregister(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.outboundCtx;
        if (delegatingChannelHandlerContext.removed) {
            delegatingChannelHandlerContext.deregister(channelPromise);
        } else {
            this.outboundHandler.deregister(delegatingChannelHandlerContext, channelPromise);
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.outboundCtx;
        if (delegatingChannelHandlerContext.removed) {
            delegatingChannelHandlerContext.disconnect(channelPromise);
        } else {
            this.outboundHandler.disconnect(delegatingChannelHandlerContext, channelPromise);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (delegatingChannelHandlerContext.removed) {
            delegatingChannelHandlerContext.fireExceptionCaught(th);
        } else {
            this.inboundHandler.exceptionCaught(delegatingChannelHandlerContext, th);
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext channelHandlerContext) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.outboundCtx;
        if (delegatingChannelHandlerContext.removed) {
            delegatingChannelHandlerContext.flush();
        } else {
            this.outboundHandler.flush(delegatingChannelHandlerContext);
        }
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.inboundHandler != null) {
            this.outboundCtx = new DelegatingChannelHandlerContext(channelHandlerContext, this.outboundHandler);
            this.inboundCtx = new DelegatingChannelHandlerContext(channelHandlerContext, this.inboundHandler) { // from class: io.netty.channel.CombinedChannelDuplexHandler.1
                @Override // io.netty.channel.CombinedChannelDuplexHandler.DelegatingChannelHandlerContext, io.netty.channel.ChannelInboundInvoker
                public ChannelHandlerContext fireExceptionCaught(Throwable th) {
                    if (CombinedChannelDuplexHandler.this.outboundCtx.removed) {
                        super.fireExceptionCaught(th);
                        return this;
                    }
                    try {
                        CombinedChannelDuplexHandler.this.outboundHandler.exceptionCaught(CombinedChannelDuplexHandler.this.outboundCtx, th);
                        return this;
                    } catch (Throwable th2) {
                        if (CombinedChannelDuplexHandler.logger.isDebugEnabled()) {
                            CombinedChannelDuplexHandler.logger.debug("An exception {}was thrown by a user handler's exceptionCaught() method while handling the following exception:", ThrowableUtil.stackTraceToString(th2), th);
                        } else if (CombinedChannelDuplexHandler.logger.isWarnEnabled()) {
                            CombinedChannelDuplexHandler.logger.warn("An exception '{}' [enable DEBUG level for full stacktrace] was thrown by a user handler's exceptionCaught() method while handling the following exception:", th2, th);
                        }
                        return this;
                    }
                }
            };
            this.handlerAdded = true;
            try {
                this.inboundHandler.handlerAdded(this.inboundCtx);
                return;
            } finally {
                this.outboundHandler.handlerAdded(this.outboundCtx);
            }
        }
        throw new IllegalStateException("init() must be invoked before being added to a " + ChannelPipeline.class.getSimpleName() + " if " + CombinedChannelDuplexHandler.class.getSimpleName() + " was constructed with the default constructor.");
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        try {
            this.inboundCtx.remove();
        } finally {
            this.outboundCtx.remove();
        }
    }

    protected final I inboundHandler() {
        return this.inboundHandler;
    }

    protected final O outboundHandler() {
        return this.outboundHandler;
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void read(ChannelHandlerContext channelHandlerContext) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.outboundCtx;
        if (delegatingChannelHandlerContext.removed) {
            delegatingChannelHandlerContext.read();
        } else {
            this.outboundHandler.read(delegatingChannelHandlerContext);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (delegatingChannelHandlerContext.removed) {
            delegatingChannelHandlerContext.fireUserEventTriggered(obj);
        } else {
            this.inboundHandler.userEventTriggered(delegatingChannelHandlerContext, obj);
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.outboundCtx;
        if (delegatingChannelHandlerContext.removed) {
            delegatingChannelHandlerContext.write(obj, channelPromise);
        } else {
            this.outboundHandler.write(delegatingChannelHandlerContext, obj, channelPromise);
        }
    }

    public CombinedChannelDuplexHandler(I i6, O o5) {
        ensureNotSharable();
        init(i6, o5);
    }

    protected final void init(I i6, O o5) {
        validate(i6, o5);
        this.inboundHandler = i6;
        this.outboundHandler = o5;
    }

    public final void removeInboundHandler() {
        checkAdded();
        this.inboundCtx.remove();
    }

    public final void removeOutboundHandler() {
        checkAdded();
        this.outboundCtx.remove();
    }
}
