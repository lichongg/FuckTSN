package io.netty.channel.udt;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public final class UdtMessage extends DefaultByteBufHolder {
    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public UdtMessage copy() {
        return (UdtMessage) super.copy();
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public UdtMessage duplicate() {
        return (UdtMessage) super.duplicate();
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public UdtMessage replace(ByteBuf byteBuf) {
        return new UdtMessage(byteBuf);
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public UdtMessage retainedDuplicate() {
        return (UdtMessage) super.retainedDuplicate();
    }

    public UdtMessage(ByteBuf byteBuf) {
        super(byteBuf);
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public UdtMessage retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public UdtMessage touch() {
        super.touch();
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public UdtMessage retain(int i6) {
        super.retain(i6);
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public UdtMessage touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
