package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultHttpContent extends DefaultHttpObject implements HttpContent {
    private final ByteBuf content;

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        return this.content.release();
    }

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        return this.content;
    }

    @Override // io.netty.buffer.ByteBufHolder
    public HttpContent copy() {
        return replace(this.content.copy());
    }

    @Override // io.netty.buffer.ByteBufHolder
    public HttpContent duplicate() {
        return replace(this.content.duplicate());
    }

    @Override // io.netty.util.ReferenceCounted
    public int refCnt() {
        return this.content.refCnt();
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release(int i6) {
        return this.content.release(i6);
    }

    @Override // io.netty.buffer.ByteBufHolder
    public HttpContent replace(ByteBuf byteBuf) {
        return new DefaultHttpContent(byteBuf);
    }

    @Override // io.netty.buffer.ByteBufHolder
    public HttpContent retainedDuplicate() {
        return replace(this.content.retainedDuplicate());
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "(data: " + content() + ", decoderResult: " + decoderResult() + ')';
    }

    public DefaultHttpContent(ByteBuf byteBuf) {
        if (byteBuf != null) {
            this.content = byteBuf;
            return;
        }
        throw new NullPointerException("content");
    }

    @Override // io.netty.util.ReferenceCounted
    public HttpContent retain() {
        this.content.retain();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public HttpContent touch() {
        this.content.touch();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public HttpContent retain(int i6) {
        this.content.retain(i6);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public HttpContent touch(Object obj) {
        this.content.touch(obj);
        return this;
    }
}
