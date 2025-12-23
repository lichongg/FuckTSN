package io.netty.buffer;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class AbstractDerivedByteBuf extends AbstractByteBuf {
    @Override // io.netty.util.ReferenceCounted
    public final boolean release() {
        return release0();
    }

    boolean release0() {
        return unwrap().release();
    }

    ByteBuf retain0() {
        unwrap().retain();
        return this;
    }

    ByteBuf touch0() {
        unwrap().touch();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public final boolean release(int i6) {
        return release0(i6);
    }

    boolean release0(int i6) {
        return unwrap().release(i6);
    }

    ByteBuf retain0(int i6) {
        unwrap().retain(i6);
        return this;
    }

    ByteBuf touch0(Object obj) {
        unwrap().touch(obj);
        return this;
    }

    protected AbstractDerivedByteBuf(int i6) {
        super(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int i6, int i7) {
        return nioBuffer(i6, i7);
    }

    @Override // io.netty.buffer.ByteBuf
    final boolean isAccessible() {
        return unwrap().isAccessible();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public boolean isReadOnly() {
        return unwrap().isReadOnly();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i6, int i7) {
        return unwrap().nioBuffer(i6, i7);
    }

    @Override // io.netty.util.ReferenceCounted
    public final int refCnt() {
        return refCnt0();
    }

    int refCnt0() {
        return unwrap().refCnt();
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public final ByteBuf retain() {
        return retain0();
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public final ByteBuf touch() {
        return touch0();
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public final ByteBuf retain(int i6) {
        return retain0(i6);
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public final ByteBuf touch(Object obj) {
        return touch0(obj);
    }
}
