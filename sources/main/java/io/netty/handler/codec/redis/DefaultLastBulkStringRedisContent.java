package io.netty.handler.codec.redis;

import io.netty.buffer.ByteBuf;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class DefaultLastBulkStringRedisContent extends DefaultBulkStringRedisContent implements LastBulkStringRedisContent {
    public DefaultLastBulkStringRedisContent(ByteBuf byteBuf) {
        super(byteBuf);
    }

    @Override // io.netty.handler.codec.redis.DefaultBulkStringRedisContent, io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public LastBulkStringRedisContent copy() {
        return (LastBulkStringRedisContent) super.copy();
    }

    @Override // io.netty.handler.codec.redis.DefaultBulkStringRedisContent, io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public LastBulkStringRedisContent duplicate() {
        return (LastBulkStringRedisContent) super.duplicate();
    }

    @Override // io.netty.handler.codec.redis.DefaultBulkStringRedisContent, io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public LastBulkStringRedisContent replace(ByteBuf byteBuf) {
        return new DefaultLastBulkStringRedisContent(byteBuf);
    }

    @Override // io.netty.handler.codec.redis.DefaultBulkStringRedisContent, io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public LastBulkStringRedisContent retainedDuplicate() {
        return (LastBulkStringRedisContent) super.retainedDuplicate();
    }

    @Override // io.netty.handler.codec.redis.DefaultBulkStringRedisContent, io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public LastBulkStringRedisContent retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.handler.codec.redis.DefaultBulkStringRedisContent, io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public LastBulkStringRedisContent touch() {
        super.touch();
        return this;
    }

    @Override // io.netty.handler.codec.redis.DefaultBulkStringRedisContent, io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public LastBulkStringRedisContent retain(int i6) {
        super.retain(i6);
        return this;
    }

    @Override // io.netty.handler.codec.redis.DefaultBulkStringRedisContent, io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public LastBulkStringRedisContent touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
