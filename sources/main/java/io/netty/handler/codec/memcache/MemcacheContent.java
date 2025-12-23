package io.netty.handler.codec.memcache;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface MemcacheContent extends MemcacheObject, ByteBufHolder {
    @Override // io.netty.buffer.ByteBufHolder
    MemcacheContent copy();

    @Override // io.netty.buffer.ByteBufHolder
    MemcacheContent duplicate();

    @Override // io.netty.buffer.ByteBufHolder
    MemcacheContent replace(ByteBuf byteBuf);

    MemcacheContent retain();

    MemcacheContent retain(int i6);

    @Override // io.netty.buffer.ByteBufHolder
    MemcacheContent retainedDuplicate();

    MemcacheContent touch();

    MemcacheContent touch(Object obj);
}
