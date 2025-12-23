package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.buffer.Unpooled;
import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class DefaultHttp2UnknownFrame extends DefaultByteBufHolder implements Http2UnknownFrame {
    private final Http2Flags flags;
    private final byte frameType;
    private Http2FrameStream stream;

    public DefaultHttp2UnknownFrame(byte b6, Http2Flags http2Flags) {
        this(b6, http2Flags, Unpooled.EMPTY_BUFFER);
    }

    public DefaultHttp2UnknownFrame(byte b6, Http2Flags http2Flags, ByteBuf byteBuf) {
        super(byteBuf);
        this.frameType = b6;
        this.flags = http2Flags;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder
    public boolean equals(Object obj) {
        if (!(obj instanceof DefaultHttp2UnknownFrame)) {
            return false;
        }
        DefaultHttp2UnknownFrame defaultHttp2UnknownFrame = (DefaultHttp2UnknownFrame) obj;
        return (super.equals(defaultHttp2UnknownFrame) && flags().equals(defaultHttp2UnknownFrame.flags()) && frameType() == defaultHttp2UnknownFrame.frameType() && stream() == null && defaultHttp2UnknownFrame.stream() == null) || stream().equals(defaultHttp2UnknownFrame.stream());
    }

    @Override // io.netty.handler.codec.http2.Http2UnknownFrame
    public Http2Flags flags() {
        return this.flags;
    }

    @Override // io.netty.handler.codec.http2.Http2UnknownFrame
    public byte frameType() {
        return this.frameType;
    }

    @Override // io.netty.handler.codec.http2.Http2Frame
    public String name() {
        return "UNKNOWN";
    }

    @Override // io.netty.buffer.DefaultByteBufHolder
    public String toString() {
        return StringUtil.simpleClassName(this) + "(frameType=" + ((int) frameType()) + ", stream=" + stream() + ", flags=" + flags() + ", content=" + contentToString() + ')';
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public DefaultHttp2UnknownFrame copy() {
        return replace(content().copy());
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public DefaultHttp2UnknownFrame duplicate() {
        return replace(content().duplicate());
    }

    @Override // io.netty.buffer.DefaultByteBufHolder
    public int hashCode() {
        int hashCode = (((super.hashCode() * 31) + frameType()) * 31) + flags().hashCode();
        if (stream() != null) {
            return (hashCode * 31) + stream().hashCode();
        }
        return hashCode;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public DefaultHttp2UnknownFrame replace(ByteBuf byteBuf) {
        return new DefaultHttp2UnknownFrame(this.frameType, this.flags, byteBuf).stream(stream());
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public DefaultHttp2UnknownFrame retainedDuplicate() {
        return replace(content().retainedDuplicate());
    }

    @Override // io.netty.handler.codec.http2.Http2UnknownFrame, io.netty.handler.codec.http2.Http2StreamFrame
    public Http2FrameStream stream() {
        return this.stream;
    }

    @Override // io.netty.handler.codec.http2.Http2UnknownFrame, io.netty.handler.codec.http2.Http2StreamFrame
    public DefaultHttp2UnknownFrame stream(Http2FrameStream http2FrameStream) {
        this.stream = http2FrameStream;
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public DefaultHttp2UnknownFrame retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public DefaultHttp2UnknownFrame touch() {
        super.touch();
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public DefaultHttp2UnknownFrame retain(int i6) {
        super.retain(i6);
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public DefaultHttp2UnknownFrame touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
