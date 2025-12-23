package io.netty.handler.codec.redis;

import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ArrayHeaderRedisMessage implements RedisMessage {
    private final long length;

    public boolean isNull() {
        return this.length == -1;
    }

    public final long length() {
        return this.length;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "[length=" + this.length + ']';
    }

    public ArrayHeaderRedisMessage(long j6) {
        if (j6 >= -1) {
            this.length = j6;
            return;
        }
        throw new RedisCodecException("length: " + j6 + " (expected: >= -1)");
    }
}
