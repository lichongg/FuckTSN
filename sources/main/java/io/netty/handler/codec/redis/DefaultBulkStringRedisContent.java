package io.netty.handler.codec.redis;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultBulkStringRedisContent extends DefaultByteBufHolder implements BulkStringRedisContent {
    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public BulkStringRedisContent copy() {
        return (BulkStringRedisContent) super.copy();
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public BulkStringRedisContent duplicate() {
        return (BulkStringRedisContent) super.duplicate();
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public BulkStringRedisContent replace(ByteBuf byteBuf) {
        return new DefaultBulkStringRedisContent(byteBuf);
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public BulkStringRedisContent retainedDuplicate() {
        return (BulkStringRedisContent) super.retainedDuplicate();
    }

    @Override // io.netty.buffer.DefaultByteBufHolder
    public String toString() {
        return StringUtil.simpleClassName(this) + "[content=" + content() + ']';
    }

    public DefaultBulkStringRedisContent(ByteBuf byteBuf) {
        super(byteBuf);
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public BulkStringRedisContent retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public BulkStringRedisContent touch() {
        super.touch();
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public BulkStringRedisContent retain(int i6) {
        super.retain(i6);
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public BulkStringRedisContent touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
