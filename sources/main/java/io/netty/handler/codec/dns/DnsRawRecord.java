package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface DnsRawRecord extends DnsRecord, ByteBufHolder {
    @Override // io.netty.buffer.ByteBufHolder
    DnsRawRecord copy();

    @Override // io.netty.buffer.ByteBufHolder
    DnsRawRecord duplicate();

    @Override // io.netty.buffer.ByteBufHolder
    DnsRawRecord replace(ByteBuf byteBuf);

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    DnsRawRecord retain();

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    DnsRawRecord retain(int i6);

    @Override // io.netty.buffer.ByteBufHolder
    DnsRawRecord retainedDuplicate();

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    DnsRawRecord touch();

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    DnsRawRecord touch(Object obj);
}
