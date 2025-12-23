package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class DefaultHttp2DataFrame extends AbstractHttp2StreamFrame implements Http2DataFrame {
    private final ByteBuf content;
    private final boolean endStream;
    private final int initialFlowControlledBytes;
    private final int padding;

    public DefaultHttp2DataFrame(ByteBuf byteBuf) {
        this(byteBuf, false);
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        return this.content.release();
    }

    public DefaultHttp2DataFrame(boolean z5) {
        this(Unpooled.EMPTY_BUFFER, z5);
    }

    @Override // io.netty.handler.codec.http2.Http2DataFrame, io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        if (this.content.refCnt() > 0) {
            return this.content;
        }
        throw new IllegalReferenceCountException(this.content.refCnt());
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2StreamFrame
    public boolean equals(Object obj) {
        if (!(obj instanceof DefaultHttp2DataFrame)) {
            return false;
        }
        DefaultHttp2DataFrame defaultHttp2DataFrame = (DefaultHttp2DataFrame) obj;
        return super.equals(defaultHttp2DataFrame) && this.content.equals(defaultHttp2DataFrame.content()) && this.endStream == defaultHttp2DataFrame.endStream && this.padding == defaultHttp2DataFrame.padding;
    }

    @Override // io.netty.handler.codec.http2.Http2DataFrame
    public int initialFlowControlledBytes() {
        return this.initialFlowControlledBytes;
    }

    @Override // io.netty.handler.codec.http2.Http2DataFrame
    public boolean isEndStream() {
        return this.endStream;
    }

    @Override // io.netty.handler.codec.http2.Http2Frame
    public String name() {
        return "DATA";
    }

    @Override // io.netty.handler.codec.http2.Http2DataFrame
    public int padding() {
        return this.padding;
    }

    @Override // io.netty.util.ReferenceCounted
    public int refCnt() {
        return this.content.refCnt();
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release(int i6) {
        return this.content.release(i6);
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "(stream=" + stream() + ", content=" + this.content + ", endStream=" + this.endStream + ", padding=" + this.padding + ')';
    }

    public DefaultHttp2DataFrame(ByteBuf byteBuf, boolean z5) {
        this(byteBuf, z5, 0);
    }

    @Override // io.netty.handler.codec.http2.Http2DataFrame, io.netty.buffer.ByteBufHolder
    public DefaultHttp2DataFrame copy() {
        return replace(content().copy());
    }

    @Override // io.netty.handler.codec.http2.Http2DataFrame, io.netty.buffer.ByteBufHolder
    public DefaultHttp2DataFrame duplicate() {
        return replace(content().duplicate());
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2StreamFrame
    public int hashCode() {
        return (((((super.hashCode() * 31) + this.content.hashCode()) * 31) + (!this.endStream ? 1 : 0)) * 31) + this.padding;
    }

    @Override // io.netty.handler.codec.http2.Http2DataFrame, io.netty.buffer.ByteBufHolder
    public DefaultHttp2DataFrame replace(ByteBuf byteBuf) {
        return new DefaultHttp2DataFrame(byteBuf, this.endStream, this.padding);
    }

    @Override // io.netty.handler.codec.http2.Http2DataFrame, io.netty.buffer.ByteBufHolder
    public DefaultHttp2DataFrame retainedDuplicate() {
        return replace(content().retainedDuplicate());
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2StreamFrame, io.netty.handler.codec.http2.Http2StreamFrame
    public DefaultHttp2DataFrame stream(Http2FrameStream http2FrameStream) {
        super.stream(http2FrameStream);
        return this;
    }

    public DefaultHttp2DataFrame(ByteBuf byteBuf, boolean z5, int i6) {
        this.content = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "content");
        this.endStream = z5;
        Http2CodecUtil.verifyPadding(i6);
        this.padding = i6;
        if (content().readableBytes() + i6 <= 2147483647L) {
            this.initialFlowControlledBytes = content().readableBytes() + i6;
            return;
        }
        throw new IllegalArgumentException("content + padding must be <= Integer.MAX_VALUE");
    }

    @Override // io.netty.util.ReferenceCounted
    public DefaultHttp2DataFrame retain() {
        this.content.retain();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public DefaultHttp2DataFrame touch() {
        this.content.touch();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public DefaultHttp2DataFrame retain(int i6) {
        this.content.retain(i6);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public DefaultHttp2DataFrame touch(Object obj) {
        this.content.touch(obj);
        return this;
    }
}
