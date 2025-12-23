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
class PerMessageDeflateEncoder extends DeflateEncoder {
    private boolean compressing;

    PerMessageDeflateEncoder(int i6, int i7, boolean z5) {
        super(i6, i7, z5, WebSocketExtensionFilter.NEVER_SKIP);
    }

    @Override // io.netty.handler.codec.http.websocketx.extensions.compression.DeflateEncoder, io.netty.handler.codec.MessageToMessageEncoder
    protected /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List list) throws Exception {
        encode(channelHandlerContext, webSocketFrame, (List<Object>) list);
    }

    PerMessageDeflateEncoder(int i6, int i7, boolean z5, WebSocketExtensionFilter webSocketExtensionFilter) {
        super(i6, i7, z5, webSocketExtensionFilter);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.codec.http.websocketx.extensions.compression.DeflateEncoder
    protected void encode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List<Object> list) throws Exception {
        super.encode2(channelHandlerContext, webSocketFrame, list);
        if (webSocketFrame.isFinalFragment()) {
            this.compressing = false;
        } else if ((webSocketFrame instanceof TextWebSocketFrame) || (webSocketFrame instanceof BinaryWebSocketFrame)) {
            this.compressing = true;
        }
    }

    @Override // io.netty.handler.codec.http.websocketx.extensions.compression.DeflateEncoder
    protected int rsv(WebSocketFrame webSocketFrame) {
        return ((webSocketFrame instanceof TextWebSocketFrame) || (webSocketFrame instanceof BinaryWebSocketFrame)) ? webSocketFrame.rsv() | 4 : webSocketFrame.rsv();
    }

    @Override // io.netty.handler.codec.MessageToMessageEncoder
    public boolean acceptOutboundMessage(Object obj) throws Exception {
        if (!super.acceptOutboundMessage(obj)) {
            return false;
        }
        WebSocketFrame webSocketFrame = (WebSocketFrame) obj;
        if (extensionEncoderFilter().mustSkip(webSocketFrame)) {
            if (!this.compressing) {
                return false;
            }
            throw new IllegalStateException("Cannot skip per message deflate encoder, compression in progress");
        }
        if ((!(webSocketFrame instanceof TextWebSocketFrame) && !(webSocketFrame instanceof BinaryWebSocketFrame)) || (webSocketFrame.rsv() & 4) != 0) {
            if (!(webSocketFrame instanceof ContinuationWebSocketFrame) || !this.compressing) {
                return false;
            }
            return true;
        }
        return true;
    }

    @Override // io.netty.handler.codec.http.websocketx.extensions.compression.DeflateEncoder
    protected boolean removeFrameTail(WebSocketFrame webSocketFrame) {
        return webSocketFrame.isFinalFragment();
    }
}
