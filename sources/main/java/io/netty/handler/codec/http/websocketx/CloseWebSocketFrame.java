package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class CloseWebSocketFrame extends WebSocketFrame {
    public CloseWebSocketFrame() {
        super(Unpooled.buffer(0));
    }

    public CloseWebSocketFrame(WebSocketCloseStatus webSocketCloseStatus) {
        this(webSocketCloseStatus.code(), webSocketCloseStatus.reasonText());
    }

    private static ByteBuf newBinaryData(int i6, String str) {
        if (str == null) {
            str = "";
        }
        ByteBuf buffer = Unpooled.buffer(str.length() + 2);
        buffer.writeShort(i6);
        if (!str.isEmpty()) {
            buffer.writeCharSequence(str, CharsetUtil.UTF_8);
        }
        buffer.readerIndex(0);
        return buffer;
    }

    public CloseWebSocketFrame(WebSocketCloseStatus webSocketCloseStatus, String str) {
        this(webSocketCloseStatus.code(), str);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public CloseWebSocketFrame copy() {
        return (CloseWebSocketFrame) super.copy();
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public CloseWebSocketFrame duplicate() {
        return (CloseWebSocketFrame) super.duplicate();
    }

    public String reasonText() {
        ByteBuf content = content();
        if (content != null && content.capacity() > 2) {
            content.readerIndex(2);
            String byteBuf = content.toString(CharsetUtil.UTF_8);
            content.readerIndex(0);
            return byteBuf;
        }
        return "";
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public CloseWebSocketFrame replace(ByteBuf byteBuf) {
        return new CloseWebSocketFrame(isFinalFragment(), rsv(), byteBuf);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public CloseWebSocketFrame retainedDuplicate() {
        return (CloseWebSocketFrame) super.retainedDuplicate();
    }

    public int statusCode() {
        ByteBuf content = content();
        if (content != null && content.capacity() != 0) {
            content.readerIndex(0);
            return content.getShort(0);
        }
        return -1;
    }

    public CloseWebSocketFrame(int i6, String str) {
        this(true, 0, i6, str);
    }

    public CloseWebSocketFrame(boolean z5, int i6) {
        this(z5, i6, Unpooled.buffer(0));
    }

    public CloseWebSocketFrame(boolean z5, int i6, int i7, String str) {
        super(z5, i6, newBinaryData(i7, str));
    }

    public CloseWebSocketFrame(boolean z5, int i6, ByteBuf byteBuf) {
        super(z5, i6, byteBuf);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public CloseWebSocketFrame retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public CloseWebSocketFrame touch() {
        super.touch();
        return this;
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public CloseWebSocketFrame retain(int i6) {
        super.retain(i6);
        return this;
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public CloseWebSocketFrame touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
