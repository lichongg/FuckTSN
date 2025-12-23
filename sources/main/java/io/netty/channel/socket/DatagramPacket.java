package io.netty.channel.socket;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.DefaultAddressedEnvelope;
import java.net.InetSocketAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class DatagramPacket extends DefaultAddressedEnvelope<ByteBuf, InetSocketAddress> implements ByteBufHolder {
    public DatagramPacket(ByteBuf byteBuf, InetSocketAddress inetSocketAddress) {
        super(byteBuf, inetSocketAddress);
    }

    public DatagramPacket(ByteBuf byteBuf, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2) {
        super(byteBuf, inetSocketAddress, inetSocketAddress2);
    }

    @Override // io.netty.buffer.ByteBufHolder
    public DatagramPacket copy() {
        return replace(content().copy());
    }

    @Override // io.netty.buffer.ByteBufHolder
    public DatagramPacket duplicate() {
        return replace(content().duplicate());
    }

    @Override // io.netty.buffer.ByteBufHolder
    public DatagramPacket replace(ByteBuf byteBuf) {
        return new DatagramPacket(byteBuf, recipient(), sender());
    }

    @Override // io.netty.buffer.ByteBufHolder
    public DatagramPacket retainedDuplicate() {
        return replace(content().retainedDuplicate());
    }

    @Override // io.netty.channel.DefaultAddressedEnvelope, io.netty.channel.AddressedEnvelope
    public /* bridge */ /* synthetic */ ByteBuf content() {
        return (ByteBuf) super.content();
    }

    @Override // io.netty.channel.DefaultAddressedEnvelope, io.netty.util.ReferenceCounted
    public DatagramPacket retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.channel.DefaultAddressedEnvelope, io.netty.util.ReferenceCounted
    public DatagramPacket touch() {
        super.touch();
        return this;
    }

    @Override // io.netty.channel.DefaultAddressedEnvelope, io.netty.util.ReferenceCounted
    public DatagramPacket retain(int i6) {
        super.retain(i6);
        return this;
    }

    @Override // io.netty.channel.DefaultAddressedEnvelope, io.netty.util.ReferenceCounted
    public DatagramPacket touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
