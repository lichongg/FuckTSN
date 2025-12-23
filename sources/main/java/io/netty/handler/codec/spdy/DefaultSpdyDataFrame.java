package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultSpdyDataFrame extends DefaultSpdyStreamFrame implements SpdyDataFrame {
    private final ByteBuf data;

    public DefaultSpdyDataFrame(int i6) {
        this(i6, Unpooled.buffer(0));
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        return this.data.release();
    }

    public DefaultSpdyDataFrame(int i6, ByteBuf byteBuf) {
        super(i6);
        if (byteBuf == null) {
            throw new NullPointerException("data");
        }
        this.data = validate(byteBuf);
    }

    @Override // io.netty.handler.codec.spdy.SpdyDataFrame, io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        if (this.data.refCnt() > 0) {
            return this.data;
        }
        throw new IllegalReferenceCountException(this.data.refCnt());
    }

    @Override // io.netty.buffer.ByteBufHolder
    public SpdyDataFrame copy() {
        return replace(content().copy());
    }

    @Override // io.netty.buffer.ByteBufHolder
    public SpdyDataFrame duplicate() {
        return replace(content().duplicate());
    }

    @Override // io.netty.util.ReferenceCounted
    public int refCnt() {
        return this.data.refCnt();
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release(int i6) {
        return this.data.release(i6);
    }

    @Override // io.netty.buffer.ByteBufHolder
    public SpdyDataFrame replace(ByteBuf byteBuf) {
        DefaultSpdyDataFrame defaultSpdyDataFrame = new DefaultSpdyDataFrame(streamId(), byteBuf);
        defaultSpdyDataFrame.setLast(isLast());
        return defaultSpdyDataFrame;
    }

    @Override // io.netty.buffer.ByteBufHolder
    public SpdyDataFrame retainedDuplicate() {
        return replace(content().retainedDuplicate());
    }

    @Override // io.netty.handler.codec.spdy.DefaultSpdyStreamFrame, io.netty.handler.codec.spdy.SpdyStreamFrame, io.netty.handler.codec.spdy.SpdyDataFrame
    public SpdyDataFrame setLast(boolean z5) {
        super.setLast(z5);
        return this;
    }

    @Override // io.netty.handler.codec.spdy.DefaultSpdyStreamFrame, io.netty.handler.codec.spdy.SpdyStreamFrame, io.netty.handler.codec.spdy.SpdyDataFrame
    public SpdyDataFrame setStreamId(int i6) {
        super.setStreamId(i6);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.simpleClassName(this));
        sb.append("(last: ");
        sb.append(isLast());
        sb.append(')');
        String str = StringUtil.NEWLINE;
        sb.append(str);
        sb.append("--> Stream-ID = ");
        sb.append(streamId());
        sb.append(str);
        sb.append("--> Size = ");
        if (refCnt() == 0) {
            sb.append("(freed)");
        } else {
            sb.append(content().readableBytes());
        }
        return sb.toString();
    }

    private static ByteBuf validate(ByteBuf byteBuf) {
        if (byteBuf.readableBytes() <= 16777215) {
            return byteBuf;
        }
        throw new IllegalArgumentException("data payload cannot exceed 16777215 bytes");
    }

    @Override // io.netty.util.ReferenceCounted
    public SpdyDataFrame retain() {
        this.data.retain();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public SpdyDataFrame touch() {
        this.data.touch();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public SpdyDataFrame retain(int i6) {
        this.data.retain(i6);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public SpdyDataFrame touch(Object obj) {
        this.data.touch(obj);
        return this;
    }
}
