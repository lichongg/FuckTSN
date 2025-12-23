package io.netty.handler.codec.http2;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class Http2ChannelDuplexHandler extends ChannelDuplexHandler {
    private volatile Http2FrameCodec frameCodec;

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public final void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        try {
            handlerRemoved0(channelHandlerContext);
        } finally {
            this.frameCodec = null;
        }
    }

    protected final void forEachActiveStream(Http2FrameStreamVisitor http2FrameStreamVisitor) throws Http2Exception {
        this.frameCodec.forEachActiveStream(http2FrameStreamVisitor);
    }

    public final Http2FrameStream newStream() {
        Http2FrameCodec http2FrameCodec = this.frameCodec;
        if (http2FrameCodec != null) {
            return http2FrameCodec.newStream();
        }
        throw new IllegalStateException(StringUtil.simpleClassName((Class<?>) Http2FrameCodec.class) + " not found. Has the handler been added to a pipeline?");
    }

    private static Http2FrameCodec requireHttp2FrameCodec(ChannelHandlerContext channelHandlerContext) {
        ChannelHandlerContext context = channelHandlerContext.pipeline().context(Http2FrameCodec.class);
        if (context != null) {
            return (Http2FrameCodec) context.handler();
        }
        throw new IllegalArgumentException(Http2FrameCodec.class.getSimpleName() + " was not found in the channel pipeline.");
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public final void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.frameCodec = requireHttp2FrameCodec(channelHandlerContext);
        handlerAdded0(channelHandlerContext);
    }

    protected void handlerAdded0(ChannelHandlerContext channelHandlerContext) throws Exception {
    }

    protected void handlerRemoved0(ChannelHandlerContext channelHandlerContext) throws Exception {
    }
}
