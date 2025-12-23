package io.netty.handler.codec.redis;

import io.netty.buffer.ByteBuf;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface RedisMessagePool {
    byte[] getByteBufOfInteger(long j6);

    ErrorRedisMessage getError(ByteBuf byteBuf);

    ErrorRedisMessage getError(String str);

    IntegerRedisMessage getInteger(long j6);

    IntegerRedisMessage getInteger(ByteBuf byteBuf);

    SimpleStringRedisMessage getSimpleString(ByteBuf byteBuf);

    SimpleStringRedisMessage getSimpleString(String str);
}
