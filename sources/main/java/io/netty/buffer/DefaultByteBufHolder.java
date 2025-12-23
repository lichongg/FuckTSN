package io.netty.buffer;

import io.netty.util.IllegalReferenceCountException;
import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultByteBufHolder implements ByteBufHolder {
    private final ByteBuf data;

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        return this.data.release();
    }

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        if (this.data.refCnt() > 0) {
            return this.data;
        }
        throw new IllegalReferenceCountException(this.data.refCnt());
    }

    protected final String contentToString() {
        return this.data.toString();
    }

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBufHolder copy() {
        return replace(this.data.copy());
    }

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBufHolder duplicate() {
        return replace(this.data.duplicate());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ByteBufHolder) {
            return this.data.equals(((ByteBufHolder) obj).content());
        }
        return false;
    }

    public int hashCode() {
        return this.data.hashCode();
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
    public ByteBufHolder replace(ByteBuf byteBuf) {
        return new DefaultByteBufHolder(byteBuf);
    }

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBufHolder retainedDuplicate() {
        return replace(this.data.retainedDuplicate());
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + '(' + contentToString() + ')';
    }

    public DefaultByteBufHolder(ByteBuf byteBuf) {
        if (byteBuf != null) {
            this.data = byteBuf;
            return;
        }
        throw new NullPointerException("data");
    }

    @Override // io.netty.util.ReferenceCounted
    public ByteBufHolder retain() {
        this.data.retain();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public ByteBufHolder touch() {
        this.data.touch();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public ByteBufHolder retain(int i6) {
        this.data.retain(i6);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public ByteBufHolder touch(Object obj) {
        this.data.touch(obj);
        return this;
    }
}
