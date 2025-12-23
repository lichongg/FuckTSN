package io.netty.handler.codec.redis;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class AbstractStringRedisMessage implements RedisMessage {
    private final String content;

    public final String content() {
        return this.content;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "[content=" + this.content + ']';
    }

    AbstractStringRedisMessage(String str) {
        this.content = (String) ObjectUtil.checkNotNull(str, "content");
    }
}
