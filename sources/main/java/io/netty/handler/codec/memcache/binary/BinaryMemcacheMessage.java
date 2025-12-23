package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.memcache.MemcacheMessage;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface BinaryMemcacheMessage extends MemcacheMessage {
    long cas();

    byte dataType();

    ByteBuf extras();

    byte extrasLength();

    ByteBuf key();

    short keyLength();

    byte magic();

    int opaque();

    byte opcode();

    @Override // io.netty.handler.codec.memcache.MemcacheMessage, io.netty.util.ReferenceCounted
    BinaryMemcacheMessage retain();

    @Override // io.netty.handler.codec.memcache.MemcacheMessage, io.netty.util.ReferenceCounted
    BinaryMemcacheMessage retain(int i6);

    BinaryMemcacheMessage setCas(long j6);

    BinaryMemcacheMessage setDataType(byte b6);

    BinaryMemcacheMessage setExtras(ByteBuf byteBuf);

    BinaryMemcacheMessage setKey(ByteBuf byteBuf);

    BinaryMemcacheMessage setMagic(byte b6);

    BinaryMemcacheMessage setOpaque(int i6);

    BinaryMemcacheMessage setOpcode(byte b6);

    BinaryMemcacheMessage setTotalBodyLength(int i6);

    int totalBodyLength();

    @Override // io.netty.handler.codec.memcache.MemcacheMessage, io.netty.util.ReferenceCounted
    BinaryMemcacheMessage touch();

    @Override // io.netty.handler.codec.memcache.MemcacheMessage, io.netty.util.ReferenceCounted
    BinaryMemcacheMessage touch(Object obj);
}
