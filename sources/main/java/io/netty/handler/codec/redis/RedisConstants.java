package io.netty.handler.codec.redis;

import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class RedisConstants {
    static final int EOL_LENGTH = 2;
    static final int LONG_MAX_LENGTH = 20;
    static final int NULL_LENGTH = 2;
    static final int NULL_VALUE = -1;
    static final int POSITIVE_LONG_MAX_LENGTH = 19;
    static final int REDIS_INLINE_MESSAGE_MAX_LENGTH = 65536;
    static final int REDIS_MESSAGE_MAX_LENGTH = 536870912;
    static final int TYPE_LENGTH = 1;
    static final short NULL_SHORT = RedisCodecUtil.makeShort('-', '1');
    static final short EOL_SHORT = RedisCodecUtil.makeShort(StringUtil.CARRIAGE_RETURN, '\n');

    private RedisConstants() {
    }
}
