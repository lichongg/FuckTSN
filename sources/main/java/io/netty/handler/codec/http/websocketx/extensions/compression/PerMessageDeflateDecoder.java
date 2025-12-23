package io.netty.handler.codec.http.websocketx.extensions.compression;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.ContinuationWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionFilter;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class PerMessageDeflateDecoder extends DeflateDecoder {
    private boolean compressing;

    PerMessageDeflateDecoder(boolean z5) {
        super(z5, WebSocketExtensionFilter.NEVER_SKIP);
    }

    @Override // io.netty.handler.codec.http.websocketx.extensions.compression.DeflateDecoder, io.netty.handler.codec.MessageToMessageDecoder
    protected /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List list) throws Exception {
        decode(channelHandlerContext, webSocketFrame, (List<Object>) list);
    }

    PerMessageDeflateDecoder(boolean z5, WebSocketExtensionFilter webSocketExtensionFilter) {
        super(z5, webSocketExtensionFilter);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.codec.http.websocketx.extensions.compression.DeflateDecoder
    protected void decode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List<Object> list) throws Exception {
        super.decode2(channelHandlerContext, webSocketFrame, list);
        if (webSocketFrame.isFinalFragment()) {
            this.compressing = false;
        } else if ((webSocketFrame instanceof TextWebSocketFrame) || (webSocketFrame instanceof BinaryWebSocketFrame)) {
            this.compressing = true;
        }
    }

    @Override // io.netty.handler.codec.MessageToMessageDecoder
    public boolean acceptInboundMessage(Object obj) throws Exception {
        if (!super.acceptInboundMessage(obj)) {
            return false;
        }
        WebSocketFrame webSocketFrame = (WebSocketFrame) obj;
        if (extensionDecoderFilter().mustSkip(webSocketFrame)) {
            if (!this.compressing) {
                return false;
            }
            throw new IllegalStateException("Cannot skip per message deflate decoder, compression in progress");
        }
        if ((!(webSocketFrame instanceof TextWebSocketFrame) && !(webSocketFrame instanceof BinaryWebSocketFrame)) || (webSocketFrame.rsv() & 4) <= 0) {
            if (!(webSocketFrame instanceof ContinuationWebSocketFrame) || !this.compressing) {
                return false;
            }
            return true;
        }
        return true;
    }

    @Override // io.netty.handler.codec.http.websocketx.extensions.compression.DeflateDecoder
    protected boolean appendFrameTail(WebSocketFrame webSocketFrame) {
        return webSocketFrame.isFinalFragment();
    }

    @Override // io.netty.handler.codec.http.websocketx.extensions.compression.DeflateDecoder
    protected int newRsv(WebSocketFrame webSocketFrame) {
        if ((webSocketFrame.rsv() & 4) > 0) {
            return webSocketFrame.rsv() ^ 4;
        }
        return webSocketFrame.rsv();
    }
}
