package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class BinaryMemcacheRequestEncoder extends AbstractBinaryMemcacheEncoder<BinaryMemcacheRequest> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheEncoder
    public void encodeHeader(ByteBuf byteBuf, BinaryMemcacheRequest binaryMemcacheRequest) {
        byteBuf.writeByte(binaryMemcacheRequest.magic());
        byteBuf.writeByte(binaryMemcacheRequest.opcode());
        byteBuf.writeShort(binaryMemcacheRequest.keyLength());
        byteBuf.writeByte(binaryMemcacheRequest.extrasLength());
        byteBuf.writeByte(binaryMemcacheRequest.dataType());
        byteBuf.writeShort(binaryMemcacheRequest.reserved());
        byteBuf.writeInt(binaryMemcacheRequest.totalBodyLength());
        byteBuf.writeInt(binaryMemcacheRequest.opaque());
        byteBuf.writeLong(binaryMemcacheRequest.cas());
    }
}
