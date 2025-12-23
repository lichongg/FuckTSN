package io.netty.handler.ssl.ocsp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.ssl.ReferenceCountedOpenSslEngine;
import io.netty.handler.ssl.SslHandshakeCompletionEvent;
import io.netty.util.internal.ObjectUtil;
import javax.net.ssl.SSLHandshakeException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class OcspClientHandler extends ChannelInboundHandlerAdapter {
    private final ReferenceCountedOpenSslEngine engine;

    protected abstract boolean verify(ChannelHandlerContext channelHandlerContext, ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine) throws Exception;

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (obj instanceof SslHandshakeCompletionEvent) {
            channelHandlerContext.pipeline().remove(this);
            if (((SslHandshakeCompletionEvent) obj).isSuccess() && !verify(channelHandlerContext, this.engine)) {
                throw new SSLHandshakeException("Bad OCSP response");
            }
        }
        channelHandlerContext.fireUserEventTriggered(obj);
    }

    protected OcspClientHandler(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine) {
        this.engine = (ReferenceCountedOpenSslEngine) ObjectUtil.checkNotNull(referenceCountedOpenSslEngine, "engine");
    }
}
