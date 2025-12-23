package io.netty.handler.codec.redis;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface BulkStringRedisContent extends RedisMessage, ByteBufHolder {
    @Override // io.netty.buffer.ByteBufHolder
    BulkStringRedisContent copy();

    @Override // io.netty.buffer.ByteBufHolder
    BulkStringRedisContent duplicate();

    @Override // io.netty.buffer.ByteBufHolder
    BulkStringRedisContent replace(ByteBuf byteBuf);

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    BulkStringRedisContent retain();

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    BulkStringRedisContent retain(int i6);

    @Override // io.netty.buffer.ByteBufHolder
    BulkStringRedisContent retainedDuplicate();

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    BulkStringRedisContent touch();

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    BulkStringRedisContent touch(Object obj);
}
