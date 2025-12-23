package io.netty.handler.codec.http.websocketx.extensions.compression;

import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.ContinuationWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionFilter;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class PerFrameDeflateEncoder extends DeflateEncoder {
    PerFrameDeflateEncoder(int i6, int i7, boolean z5) {
        super(i6, i7, z5, WebSocketExtensionFilter.NEVER_SKIP);
    }

    @Override // io.netty.handler.codec.http.websocketx.extensions.compression.DeflateEncoder
    protected boolean removeFrameTail(WebSocketFrame webSocketFrame) {
        return true;
    }

    PerFrameDeflateEncoder(int i6, int i7, boolean z5, WebSocketExtensionFilter webSocketExtensionFilter) {
        super(i6, i7, z5, webSocketExtensionFilter);
    }

    @Override // io.netty.handler.codec.MessageToMessageEncoder
    public boolean acceptOutboundMessage(Object obj) throws Exception {
        if (!super.acceptOutboundMessage(obj)) {
            return false;
        }
        WebSocketFrame webSocketFrame = (WebSocketFrame) obj;
        if (extensionEncoderFilter().mustSkip(webSocketFrame)) {
            return false;
        }
        if ((!(obj instanceof TextWebSocketFrame) && !(obj instanceof BinaryWebSocketFrame) && !(obj instanceof ContinuationWebSocketFrame)) || webSocketFrame.content().readableBytes() <= 0 || (webSocketFrame.rsv() & 4) != 0) {
            return false;
        }
        return true;
    }

    @Override // io.netty.handler.codec.http.websocketx.extensions.compression.DeflateEncoder
    protected int rsv(WebSocketFrame webSocketFrame) {
        return webSocketFrame.rsv() | 4;
    }
}
