package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class PemValue extends AbstractReferenceCounted implements PemEncoded {
    private final ByteBuf content;
    private final boolean sensitive;

    @Override // io.netty.util.AbstractReferenceCounted
    protected void deallocate() {
        if (this.sensitive) {
            SslUtils.zeroout(this.content);
        }
        this.content.release();
    }

    @Override // io.netty.handler.ssl.PemEncoded
    public boolean isSensitive() {
        return this.sensitive;
    }

    PemValue(ByteBuf byteBuf, boolean z5) {
        this.content = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "content");
        this.sensitive = z5;
    }

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        int refCnt = refCnt();
        if (refCnt > 0) {
            return this.content;
        }
        throw new IllegalReferenceCountException(refCnt);
    }

    @Override // io.netty.handler.ssl.PemEncoded, io.netty.buffer.ByteBufHolder
    public PemValue copy() {
        return replace(this.content.copy());
    }

    @Override // io.netty.handler.ssl.PemEncoded, io.netty.buffer.ByteBufHolder
    public PemValue duplicate() {
        return replace(this.content.duplicate());
    }

    @Override // io.netty.handler.ssl.PemEncoded, io.netty.buffer.ByteBufHolder
    public PemValue replace(ByteBuf byteBuf) {
        return new PemValue(byteBuf, this.sensitive);
    }

    @Override // io.netty.handler.ssl.PemEncoded, io.netty.buffer.ByteBufHolder
    public PemValue retainedDuplicate() {
        return replace(this.content.retainedDuplicate());
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public PemValue retain() {
        return (PemValue) super.retain();
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public PemValue touch() {
        return (PemValue) super.touch();
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public PemValue retain(int i6) {
        return (PemValue) super.retain(i6);
    }

    @Override // io.netty.util.ReferenceCounted
    public PemValue touch(Object obj) {
        this.content.touch(obj);
        return this;
    }
}
