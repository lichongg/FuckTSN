package io.netty.handler.codec.stomp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultStompFrame extends DefaultStompHeadersSubframe implements StompFrame {
    private final ByteBuf content;

    public DefaultStompFrame(StompCommand stompCommand) {
        this(stompCommand, Unpooled.buffer(0));
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        return this.content.release();
    }

    public DefaultStompFrame(StompCommand stompCommand, ByteBuf byteBuf) {
        this(stompCommand, byteBuf, null);
    }

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        return this.content;
    }

    @Override // io.netty.util.ReferenceCounted
    public int refCnt() {
        return this.content.refCnt();
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release(int i6) {
        return this.content.release(i6);
    }

    @Override // io.netty.handler.codec.stomp.DefaultStompHeadersSubframe
    public String toString() {
        return "DefaultStompFrame{command=" + this.command + ", headers=" + this.headers + ", content=" + this.content.toString(CharsetUtil.UTF_8) + '}';
    }

    DefaultStompFrame(StompCommand stompCommand, ByteBuf byteBuf, DefaultStompHeaders defaultStompHeaders) {
        super(stompCommand, defaultStompHeaders);
        if (byteBuf != null) {
            this.content = byteBuf;
            return;
        }
        throw new NullPointerException("content");
    }

    @Override // io.netty.handler.codec.stomp.StompContentSubframe, io.netty.buffer.ByteBufHolder
    public StompFrame copy() {
        return replace(this.content.copy());
    }

    @Override // io.netty.handler.codec.stomp.StompContentSubframe, io.netty.buffer.ByteBufHolder
    public StompFrame duplicate() {
        return replace(this.content.duplicate());
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [io.netty.handler.codec.stomp.DefaultStompHeaders] */
    @Override // io.netty.handler.codec.stomp.StompContentSubframe, io.netty.buffer.ByteBufHolder
    public StompFrame replace(ByteBuf byteBuf) {
        return new DefaultStompFrame(this.command, byteBuf, this.headers.copy());
    }

    @Override // io.netty.handler.codec.stomp.StompContentSubframe, io.netty.buffer.ByteBufHolder
    public StompFrame retainedDuplicate() {
        return replace(this.content.retainedDuplicate());
    }

    @Override // io.netty.util.ReferenceCounted
    public StompFrame retain() {
        this.content.retain();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public StompFrame touch() {
        this.content.touch();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public StompFrame retain(int i6) {
        this.content.retain(i6);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public StompFrame touch(Object obj) {
        this.content.touch(obj);
        return this;
    }
}
