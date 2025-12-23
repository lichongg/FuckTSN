package io.netty.handler.ssl;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class ApplicationProtocolNegotiationHandler extends ChannelInboundHandlerAdapter {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ApplicationProtocolNegotiationHandler.class);
    private final String fallbackProtocol;

    protected abstract void configurePipeline(ChannelHandlerContext channelHandlerContext, String str) throws Exception;

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        logger.warn("{} Failed to select the application-level protocol:", channelHandlerContext.channel(), th);
        channelHandlerContext.fireExceptionCaught(th);
        channelHandlerContext.close();
    }

    protected void handshakeFailure(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        logger.warn("{} TLS handshake failed:", channelHandlerContext.channel(), th);
        channelHandlerContext.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0052, code lost:
    
        if (r0.context(r2) == null) goto L30;
     */
    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void userEventTriggered(io.netty.channel.ChannelHandlerContext r3, java.lang.Object r4) throws java.lang.Exception {
        /*
            r2 = this;
            boolean r0 = r4 instanceof io.netty.handler.ssl.SslHandshakeCompletionEvent
            if (r0 == 0) goto L64
            r0 = r4
            io.netty.handler.ssl.SslHandshakeCompletionEvent r0 = (io.netty.handler.ssl.SslHandshakeCompletionEvent) r0     // Catch: java.lang.Throwable -> L28
            boolean r1 = r0.isSuccess()     // Catch: java.lang.Throwable -> L28
            if (r1 == 0) goto L32
            io.netty.channel.ChannelPipeline r0 = r3.pipeline()     // Catch: java.lang.Throwable -> L28
            java.lang.Class<io.netty.handler.ssl.SslHandler> r1 = io.netty.handler.ssl.SslHandler.class
            io.netty.channel.ChannelHandler r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L28
            io.netty.handler.ssl.SslHandler r0 = (io.netty.handler.ssl.SslHandler) r0     // Catch: java.lang.Throwable -> L28
            if (r0 == 0) goto L2a
            java.lang.String r0 = r0.applicationProtocol()     // Catch: java.lang.Throwable -> L28
            if (r0 == 0) goto L22
            goto L24
        L22:
            java.lang.String r0 = r2.fallbackProtocol     // Catch: java.lang.Throwable -> L28
        L24:
            r2.configurePipeline(r3, r0)     // Catch: java.lang.Throwable -> L28
            goto L39
        L28:
            r0 = move-exception
            goto L47
        L2a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L28
            java.lang.String r1 = "cannot find a SslHandler in the pipeline (required for application-level protocol negotiation)"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L28
            throw r0     // Catch: java.lang.Throwable -> L28
        L32:
            java.lang.Throwable r0 = r0.cause()     // Catch: java.lang.Throwable -> L28
            r2.handshakeFailure(r3, r0)     // Catch: java.lang.Throwable -> L28
        L39:
            io.netty.channel.ChannelPipeline r0 = r3.pipeline()
            io.netty.channel.ChannelHandlerContext r1 = r0.context(r2)
            if (r1 == 0) goto L64
        L43:
            r0.remove(r2)
            goto L64
        L47:
            r2.exceptionCaught(r3, r0)     // Catch: java.lang.Throwable -> L55
            io.netty.channel.ChannelPipeline r0 = r3.pipeline()
            io.netty.channel.ChannelHandlerContext r1 = r0.context(r2)
            if (r1 == 0) goto L64
            goto L43
        L55:
            r4 = move-exception
            io.netty.channel.ChannelPipeline r3 = r3.pipeline()
            io.netty.channel.ChannelHandlerContext r0 = r3.context(r2)
            if (r0 == 0) goto L63
            r3.remove(r2)
        L63:
            throw r4
        L64:
            r3.fireUserEventTriggered(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.ApplicationProtocolNegotiationHandler.userEventTriggered(io.netty.channel.ChannelHandlerContext, java.lang.Object):void");
    }

    protected ApplicationProtocolNegotiationHandler(String str) {
        this.fallbackProtocol = (String) ObjectUtil.checkNotNull(str, "fallbackProtocol");
    }
}
