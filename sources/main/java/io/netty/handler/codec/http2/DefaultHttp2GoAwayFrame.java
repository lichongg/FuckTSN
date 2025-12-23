package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.buffer.Unpooled;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class DefaultHttp2GoAwayFrame extends DefaultByteBufHolder implements Http2GoAwayFrame {
    private final long errorCode;
    private int extraStreamIds;
    private final int lastStreamId;

    public DefaultHttp2GoAwayFrame(Http2Error http2Error) {
        this(http2Error.code());
    }

    public DefaultHttp2GoAwayFrame(long j6) {
        this(j6, Unpooled.EMPTY_BUFFER);
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public Http2GoAwayFrame copy() {
        return new DefaultHttp2GoAwayFrame(this.lastStreamId, this.errorCode, content().copy());
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public Http2GoAwayFrame duplicate() {
        return (Http2GoAwayFrame) super.duplicate();
    }

    @Override // io.netty.buffer.DefaultByteBufHolder
    public boolean equals(Object obj) {
        if (!(obj instanceof DefaultHttp2GoAwayFrame)) {
            return false;
        }
        DefaultHttp2GoAwayFrame defaultHttp2GoAwayFrame = (DefaultHttp2GoAwayFrame) obj;
        return this.errorCode == defaultHttp2GoAwayFrame.errorCode && this.extraStreamIds == defaultHttp2GoAwayFrame.extraStreamIds && super.equals(defaultHttp2GoAwayFrame);
    }

    @Override // io.netty.handler.codec.http2.Http2GoAwayFrame
    public long errorCode() {
        return this.errorCode;
    }

    @Override // io.netty.handler.codec.http2.Http2GoAwayFrame
    public int extraStreamIds() {
        return this.extraStreamIds;
    }

    @Override // io.netty.handler.codec.http2.Http2GoAwayFrame
    public int lastStreamId() {
        return this.lastStreamId;
    }

    @Override // io.netty.handler.codec.http2.Http2Frame
    public String name() {
        return "GOAWAY";
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public Http2GoAwayFrame replace(ByteBuf byteBuf) {
        return new DefaultHttp2GoAwayFrame(this.errorCode, byteBuf).setExtraStreamIds(this.extraStreamIds);
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public Http2GoAwayFrame retainedDuplicate() {
        return (Http2GoAwayFrame) super.retainedDuplicate();
    }

    @Override // io.netty.handler.codec.http2.Http2GoAwayFrame
    public Http2GoAwayFrame setExtraStreamIds(int i6) {
        ObjectUtil.checkPositiveOrZero(i6, "extraStreamIds");
        this.extraStreamIds = i6;
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder
    public String toString() {
        return StringUtil.simpleClassName(this) + "(errorCode=" + this.errorCode + ", content=" + content() + ", extraStreamIds=" + this.extraStreamIds + ", lastStreamId=" + this.lastStreamId + ')';
    }

    public DefaultHttp2GoAwayFrame(Http2Error http2Error, ByteBuf byteBuf) {
        this(http2Error.code(), byteBuf);
    }

    @Override // io.netty.buffer.DefaultByteBufHolder
    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        long j6 = this.errorCode;
        return ((hashCode + ((int) (j6 ^ (j6 >>> 32)))) * 31) + this.extraStreamIds;
    }

    public DefaultHttp2GoAwayFrame(long j6, ByteBuf byteBuf) {
        this(-1, j6, byteBuf);
    }

    DefaultHttp2GoAwayFrame(int i6, long j6, ByteBuf byteBuf) {
        super(byteBuf);
        this.errorCode = j6;
        this.lastStreamId = i6;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public Http2GoAwayFrame retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public Http2GoAwayFrame touch() {
        super.touch();
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public Http2GoAwayFrame retain(int i6) {
        super.retain(i6);
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public Http2GoAwayFrame touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
