package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultBinaryMemcacheResponse extends AbstractBinaryMemcacheMessage implements BinaryMemcacheResponse {
    public static final byte RESPONSE_MAGIC_BYTE = -127;
    private short status;

    public DefaultBinaryMemcacheResponse() {
        this(null, null);
    }

    public DefaultBinaryMemcacheResponse(ByteBuf byteBuf) {
        this(byteBuf, null);
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheResponse
    public BinaryMemcacheResponse setStatus(short s5) {
        this.status = s5;
        return this;
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheResponse
    public short status() {
        return this.status;
    }

    public DefaultBinaryMemcacheResponse(ByteBuf byteBuf, ByteBuf byteBuf2) {
        super(byteBuf, byteBuf2);
        setMagic(RESPONSE_MAGIC_BYTE);
    }

    void copyMeta(DefaultBinaryMemcacheResponse defaultBinaryMemcacheResponse) {
        super.copyMeta((AbstractBinaryMemcacheMessage) defaultBinaryMemcacheResponse);
        defaultBinaryMemcacheResponse.status = this.status;
    }

    @Override // io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheMessage, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public BinaryMemcacheResponse retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheMessage, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public BinaryMemcacheResponse touch() {
        super.touch();
        return this;
    }

    @Override // io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheMessage, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public BinaryMemcacheResponse retain(int i6) {
        super.retain(i6);
        return this;
    }

    @Override // io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheMessage, io.netty.util.ReferenceCounted
    public BinaryMemcacheResponse touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
