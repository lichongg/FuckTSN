package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultFullBinaryMemcacheResponse extends DefaultBinaryMemcacheResponse implements FullBinaryMemcacheResponse {
    private final ByteBuf content;

    public DefaultFullBinaryMemcacheResponse(ByteBuf byteBuf, ByteBuf byteBuf2) {
        this(byteBuf, byteBuf2, Unpooled.buffer(0));
    }

    public DefaultFullBinaryMemcacheResponse(ByteBuf byteBuf, ByteBuf byteBuf2, ByteBuf byteBuf3) {
        super(byteBuf, byteBuf2);
        if (byteBuf3 == null) {
            throw new NullPointerException("Supplied content is null.");
        }
        this.content = byteBuf3;
        setTotalBodyLength(keyLength() + extrasLength() + byteBuf3.readableBytes());
    }

    private FullBinaryMemcacheResponse newInstance(ByteBuf byteBuf, ByteBuf byteBuf2, ByteBuf byteBuf3) {
        DefaultFullBinaryMemcacheResponse defaultFullBinaryMemcacheResponse = new DefaultFullBinaryMemcacheResponse(byteBuf, byteBuf2, byteBuf3);
        copyMeta((DefaultBinaryMemcacheResponse) defaultFullBinaryMemcacheResponse);
        return defaultFullBinaryMemcacheResponse;
    }

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        return this.content;
    }

    @Override // io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheMessage, io.netty.util.AbstractReferenceCounted
    protected void deallocate() {
        super.deallocate();
        this.content.release();
    }

    @Override // io.netty.handler.codec.memcache.MemcacheContent, io.netty.buffer.ByteBufHolder
    public FullBinaryMemcacheResponse copy() {
        ByteBuf key = key();
        if (key != null) {
            key = key.copy();
        }
        ByteBuf extras = extras();
        if (extras != null) {
            extras = extras.copy();
        }
        return newInstance(key, extras, content().copy());
    }

    @Override // io.netty.handler.codec.memcache.MemcacheContent, io.netty.buffer.ByteBufHolder
    public FullBinaryMemcacheResponse duplicate() {
        ByteBuf key = key();
        if (key != null) {
            key = key.duplicate();
        }
        ByteBuf extras = extras();
        if (extras != null) {
            extras = extras.duplicate();
        }
        return newInstance(key, extras, content().duplicate());
    }

    @Override // io.netty.handler.codec.memcache.MemcacheContent, io.netty.buffer.ByteBufHolder
    public FullBinaryMemcacheResponse replace(ByteBuf byteBuf) {
        ByteBuf key = key();
        if (key != null) {
            key = key.retainedDuplicate();
        }
        ByteBuf extras = extras();
        if (extras != null) {
            extras = extras.retainedDuplicate();
        }
        return newInstance(key, extras, byteBuf);
    }

    @Override // io.netty.handler.codec.memcache.MemcacheContent, io.netty.buffer.ByteBufHolder
    public FullBinaryMemcacheResponse retainedDuplicate() {
        return replace(content().retainedDuplicate());
    }

    @Override // io.netty.handler.codec.memcache.binary.DefaultBinaryMemcacheResponse, io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheMessage, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public FullBinaryMemcacheResponse retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.handler.codec.memcache.binary.DefaultBinaryMemcacheResponse, io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheMessage, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public FullBinaryMemcacheResponse touch() {
        super.touch();
        return this;
    }

    @Override // io.netty.handler.codec.memcache.binary.DefaultBinaryMemcacheResponse, io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheMessage, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public FullBinaryMemcacheResponse retain(int i6) {
        super.retain(i6);
        return this;
    }

    @Override // io.netty.handler.codec.memcache.binary.DefaultBinaryMemcacheResponse, io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheMessage, io.netty.util.ReferenceCounted
    public FullBinaryMemcacheResponse touch(Object obj) {
        super.touch(obj);
        this.content.touch(obj);
        return this;
    }
}
