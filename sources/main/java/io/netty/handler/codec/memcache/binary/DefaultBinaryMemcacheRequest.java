package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultBinaryMemcacheRequest extends AbstractBinaryMemcacheMessage implements BinaryMemcacheRequest {
    public static final byte REQUEST_MAGIC_BYTE = Byte.MIN_VALUE;
    private short reserved;

    public DefaultBinaryMemcacheRequest() {
        this(null, null);
    }

    public DefaultBinaryMemcacheRequest(ByteBuf byteBuf) {
        this(byteBuf, null);
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheRequest
    public short reserved() {
        return this.reserved;
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheRequest
    public BinaryMemcacheRequest setReserved(short s5) {
        this.reserved = s5;
        return this;
    }

    public DefaultBinaryMemcacheRequest(ByteBuf byteBuf, ByteBuf byteBuf2) {
        super(byteBuf, byteBuf2);
        setMagic(Byte.MIN_VALUE);
    }

    void copyMeta(DefaultBinaryMemcacheRequest defaultBinaryMemcacheRequest) {
        super.copyMeta((AbstractBinaryMemcacheMessage) defaultBinaryMemcacheRequest);
        defaultBinaryMemcacheRequest.reserved = this.reserved;
    }

    @Override // io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheMessage, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public BinaryMemcacheRequest retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheMessage, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public BinaryMemcacheRequest touch() {
        super.touch();
        return this;
    }

    @Override // io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheMessage, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public BinaryMemcacheRequest retain(int i6) {
        super.retain(i6);
        return this;
    }

    @Override // io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheMessage, io.netty.util.ReferenceCounted
    public BinaryMemcacheRequest touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
