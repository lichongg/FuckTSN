package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class TextWebSocketFrame extends WebSocketFrame {
    public TextWebSocketFrame() {
        super(Unpooled.buffer(0));
    }

    public TextWebSocketFrame(String str) {
        super(fromText(str));
    }

    private static ByteBuf fromText(String str) {
        return (str == null || str.isEmpty()) ? Unpooled.EMPTY_BUFFER : Unpooled.copiedBuffer(str, CharsetUtil.UTF_8);
    }

    public TextWebSocketFrame(ByteBuf byteBuf) {
        super(byteBuf);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public TextWebSocketFrame copy() {
        return (TextWebSocketFrame) super.copy();
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public TextWebSocketFrame duplicate() {
        return (TextWebSocketFrame) super.duplicate();
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public TextWebSocketFrame replace(ByteBuf byteBuf) {
        return new TextWebSocketFrame(isFinalFragment(), rsv(), byteBuf);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public TextWebSocketFrame retainedDuplicate() {
        return (TextWebSocketFrame) super.retainedDuplicate();
    }

    public String text() {
        return content().toString(CharsetUtil.UTF_8);
    }

    public TextWebSocketFrame(boolean z5, int i6, String str) {
        super(z5, i6, fromText(str));
    }

    public TextWebSocketFrame(boolean z5, int i6, ByteBuf byteBuf) {
        super(z5, i6, byteBuf);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public TextWebSocketFrame retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public TextWebSocketFrame touch() {
        super.touch();
        return this;
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public TextWebSocketFrame retain(int i6) {
        super.retain(i6);
        return this;
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public TextWebSocketFrame touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
