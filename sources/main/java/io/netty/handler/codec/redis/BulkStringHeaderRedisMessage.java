package io.netty.handler.codec.redis;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class BulkStringHeaderRedisMessage implements RedisMessage {
    private final int bulkStringLength;

    public final int bulkStringLength() {
        return this.bulkStringLength;
    }

    public boolean isNull() {
        return this.bulkStringLength == -1;
    }

    public BulkStringHeaderRedisMessage(int i6) {
        if (i6 > 0) {
            this.bulkStringLength = i6;
            return;
        }
        throw new RedisCodecException("bulkStringLength: " + i6 + " (expected: > 0)");
    }
}
