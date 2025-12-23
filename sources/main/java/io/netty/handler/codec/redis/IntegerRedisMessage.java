package io.netty.handler.codec.redis;

import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class IntegerRedisMessage implements RedisMessage {
    private final long value;

    public String toString() {
        return StringUtil.simpleClassName(this) + "[value=" + this.value + ']';
    }

    public long value() {
        return this.value;
    }

    public IntegerRedisMessage(long j6) {
        this.value = j6;
    }
}
