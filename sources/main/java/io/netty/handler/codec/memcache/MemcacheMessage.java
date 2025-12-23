package io.netty.handler.codec.memcache;

import io.netty.util.ReferenceCounted;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface MemcacheMessage extends MemcacheObject, ReferenceCounted {
    MemcacheMessage retain();

    MemcacheMessage retain(int i6);

    MemcacheMessage touch();

    MemcacheMessage touch(Object obj);
}
