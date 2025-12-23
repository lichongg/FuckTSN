package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ContinuationWebSocketFrame extends WebSocketFrame {
    public ContinuationWebSocketFrame() {
        this(Unpooled.buffer(0));
    }

    public ContinuationWebSocketFrame(ByteBuf byteBuf) {
        super(byteBuf);
    }

    private static ByteBuf fromText(String str) {
        return (str == null || str.isEmpty()) ? Unpooled.EMPTY_BUFFER : Unpooled.copiedBuffer(str, CharsetUtil.UTF_8);
    }

    public ContinuationWebSocketFrame(boolean z5, int i6, ByteBuf byteBuf) {
        super(z5, i6, byteBuf);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public ContinuationWebSocketFrame copy() {
        return (ContinuationWebSocketFrame) super.copy();
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public ContinuationWebSocketFrame duplicate() {
        return (ContinuationWebSocketFrame) super.duplicate();
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public ContinuationWebSocketFrame replace(ByteBuf byteBuf) {
        return new ContinuationWebSocketFrame(isFinalFragment(), rsv(), byteBuf);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public ContinuationWebSocketFrame retainedDuplicate() {
        return (ContinuationWebSocketFrame) super.retainedDuplicate();
    }

    public String text() {
        return content().toString(CharsetUtil.UTF_8);
    }

    public ContinuationWebSocketFrame(boolean z5, int i6, String str) {
        this(z5, i6, fromText(str));
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public ContinuationWebSocketFrame retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public ContinuationWebSocketFrame touch() {
        super.touch();
        return this;
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public ContinuationWebSocketFrame retain(int i6) {
        super.retain(i6);
        return this;
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public ContinuationWebSocketFrame touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
