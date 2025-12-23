package io.netty.handler.codec.memcache;

import io.netty.buffer.ByteBuf;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface FullMemcacheMessage extends MemcacheMessage, LastMemcacheContent {
    @Override // io.netty.handler.codec.memcache.LastMemcacheContent, io.netty.handler.codec.memcache.MemcacheContent, io.netty.buffer.ByteBufHolder
    FullMemcacheMessage copy();

    @Override // io.netty.handler.codec.memcache.LastMemcacheContent, io.netty.handler.codec.memcache.MemcacheContent, io.netty.buffer.ByteBufHolder
    FullMemcacheMessage duplicate();

    @Override // io.netty.handler.codec.memcache.LastMemcacheContent, io.netty.handler.codec.memcache.MemcacheContent, io.netty.buffer.ByteBufHolder
    FullMemcacheMessage replace(ByteBuf byteBuf);

    @Override // io.netty.handler.codec.memcache.MemcacheMessage, io.netty.util.ReferenceCounted
    FullMemcacheMessage retain();

    @Override // io.netty.handler.codec.memcache.MemcacheMessage, io.netty.util.ReferenceCounted
    FullMemcacheMessage retain(int i6);

    @Override // io.netty.handler.codec.memcache.LastMemcacheContent, io.netty.handler.codec.memcache.MemcacheContent, io.netty.buffer.ByteBufHolder
    FullMemcacheMessage retainedDuplicate();

    @Override // io.netty.handler.codec.memcache.MemcacheMessage, io.netty.util.ReferenceCounted
    FullMemcacheMessage touch();

    @Override // io.netty.handler.codec.memcache.MemcacheMessage, io.netty.util.ReferenceCounted
    FullMemcacheMessage touch(Object obj);
}
