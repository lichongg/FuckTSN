package io.netty.handler.codec.memcache.binary;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface BinaryMemcacheResponse extends BinaryMemcacheMessage {
    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage, io.netty.handler.codec.memcache.MemcacheMessage, io.netty.util.ReferenceCounted
    BinaryMemcacheResponse retain();

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage, io.netty.handler.codec.memcache.MemcacheMessage, io.netty.util.ReferenceCounted
    BinaryMemcacheResponse retain(int i6);

    BinaryMemcacheResponse setStatus(short s5);

    short status();

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage, io.netty.handler.codec.memcache.MemcacheMessage, io.netty.util.ReferenceCounted
    BinaryMemcacheResponse touch();

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage, io.netty.handler.codec.memcache.MemcacheMessage, io.netty.util.ReferenceCounted
    BinaryMemcacheResponse touch(Object obj);
}
