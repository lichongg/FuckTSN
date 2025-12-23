package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.HttpServerUpgradeHandler;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class CleartextHttp2ServerUpgradeHandler extends ChannelHandlerAdapter {
    private static final ByteBuf CONNECTION_PREFACE = Unpooled.unreleasableBuffer(Http2CodecUtil.connectionPrefaceBuf());
    private final ChannelHandler http2ServerHandler;
    private final HttpServerCodec httpServerCodec;
    private final HttpServerUpgradeHandler httpServerUpgradeHandler;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.http2.CleartextHttp2ServerUpgradeHandler$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class PriorKnowledgeHandler extends ByteToMessageDecoder {
        private PriorKnowledgeHandler() {
        }

        /* synthetic */ PriorKnowledgeHandler(CleartextHttp2ServerUpgradeHandler cleartextHttp2ServerUpgradeHandler, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // io.netty.handler.codec.ByteToMessageDecoder
        protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
            int readableBytes = CleartextHttp2ServerUpgradeHandler.CONNECTION_PREFACE.readableBytes();
            int min = Math.min(byteBuf.readableBytes(), readableBytes);
            if (!ByteBufUtil.equals(CleartextHttp2ServerUpgradeHandler.CONNECTION_PREFACE, CleartextHttp2ServerUpgradeHandler.CONNECTION_PREFACE.readerIndex(), byteBuf, byteBuf.readerIndex(), min)) {
                channelHandlerContext.pipeline().remove(this);
            } else if (min == readableBytes) {
                channelHandlerContext.pipeline().remove(CleartextHttp2ServerUpgradeHandler.this.httpServerCodec).remove(CleartextHttp2ServerUpgradeHandler.this.httpServerUpgradeHandler);
                channelHandlerContext.pipeline().addAfter(channelHandlerContext.name(), null, CleartextHttp2ServerUpgradeHandler.this.http2ServerHandler);
                channelHandlerContext.pipeline().remove(this);
                channelHandlerContext.fireUserEventTriggered((Object) PriorKnowledgeUpgradeEvent.INSTANCE);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class PriorKnowledgeUpgradeEvent {
        private static final PriorKnowledgeUpgradeEvent INSTANCE = new PriorKnowledgeUpgradeEvent();

        private PriorKnowledgeUpgradeEvent() {
        }
    }

    public CleartextHttp2ServerUpgradeHandler(HttpServerCodec httpServerCodec, HttpServerUpgradeHandler httpServerUpgradeHandler, ChannelHandler channelHandler) {
        this.httpServerCodec = (HttpServerCodec) ObjectUtil.checkNotNull(httpServerCodec, "httpServerCodec");
        this.httpServerUpgradeHandler = (HttpServerUpgradeHandler) ObjectUtil.checkNotNull(httpServerUpgradeHandler, "httpServerUpgradeHandler");
        this.http2ServerHandler = (ChannelHandler) ObjectUtil.checkNotNull(channelHandler, "http2ServerHandler");
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.pipeline().addBefore(channelHandlerContext.name(), null, new PriorKnowledgeHandler(this, null)).addBefore(channelHandlerContext.name(), null, this.httpServerCodec).replace(this, (String) null, this.httpServerUpgradeHandler);
    }
}
