package io.netty.handler.codec.memcache;

import io.netty.buffer.ByteBuf;
import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultMemcacheContent extends AbstractMemcacheObject implements MemcacheContent {
    private final ByteBuf content;

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        return this.content;
    }

    @Override // io.netty.buffer.ByteBufHolder
    public MemcacheContent copy() {
        return replace(this.content.copy());
    }

    @Override // io.netty.util.AbstractReferenceCounted
    protected void deallocate() {
        this.content.release();
    }

    @Override // io.netty.buffer.ByteBufHolder
    public MemcacheContent duplicate() {
        return replace(this.content.duplicate());
    }

    @Override // io.netty.buffer.ByteBufHolder
    public MemcacheContent replace(ByteBuf byteBuf) {
        return new DefaultMemcacheContent(byteBuf);
    }

    @Override // io.netty.buffer.ByteBufHolder
    public MemcacheContent retainedDuplicate() {
        return replace(this.content.retainedDuplicate());
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "(data: " + content() + ", decoderResult: " + decoderResult() + ')';
    }

    public DefaultMemcacheContent(ByteBuf byteBuf) {
        if (byteBuf != null) {
            this.content = byteBuf;
            return;
        }
        throw new NullPointerException("Content cannot be null.");
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public MemcacheContent retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public MemcacheContent touch() {
        super.touch();
        return this;
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public MemcacheContent retain(int i6) {
        super.retain(i6);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public MemcacheContent touch(Object obj) {
        this.content.touch(obj);
        return this;
    }
}
