package io.netty.handler.codec.redis;

import io.netty.util.AbstractReferenceCounted;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ArrayRedisMessage extends AbstractReferenceCounted implements RedisMessage {
    private final List<RedisMessage> children;
    public static final ArrayRedisMessage NULL_INSTANCE = new ArrayRedisMessage() { // from class: io.netty.handler.codec.redis.ArrayRedisMessage.1
        @Override // io.netty.handler.codec.redis.ArrayRedisMessage
        public boolean isNull() {
            return true;
        }

        @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
        public boolean release() {
            return false;
        }

        @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
        public ArrayRedisMessage retain() {
            return this;
        }

        @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
        public ArrayRedisMessage touch() {
            return this;
        }

        @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
        public boolean release(int i6) {
            return false;
        }

        @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
        public ArrayRedisMessage retain(int i6) {
            return this;
        }

        @Override // io.netty.handler.codec.redis.ArrayRedisMessage
        public String toString() {
            return "NullArrayRedisMessage";
        }

        @Override // io.netty.handler.codec.redis.ArrayRedisMessage, io.netty.util.ReferenceCounted
        public ArrayRedisMessage touch(Object obj) {
            return this;
        }
    };
    public static final ArrayRedisMessage EMPTY_INSTANCE = new ArrayRedisMessage() { // from class: io.netty.handler.codec.redis.ArrayRedisMessage.2
        @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
        public boolean release() {
            return false;
        }

        @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
        public ArrayRedisMessage retain() {
            return this;
        }

        @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
        public ArrayRedisMessage touch() {
            return this;
        }

        @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
        public boolean release(int i6) {
            return false;
        }

        @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
        public ArrayRedisMessage retain(int i6) {
            return this;
        }

        @Override // io.netty.handler.codec.redis.ArrayRedisMessage
        public String toString() {
            return "EmptyArrayRedisMessage";
        }

        @Override // io.netty.handler.codec.redis.ArrayRedisMessage, io.netty.util.ReferenceCounted
        public ArrayRedisMessage touch(Object obj) {
            return this;
        }
    };

    public boolean isNull() {
        return false;
    }

    private ArrayRedisMessage() {
        this.children = Collections.EMPTY_LIST;
    }

    public final List<RedisMessage> children() {
        return this.children;
    }

    @Override // io.netty.util.AbstractReferenceCounted
    protected void deallocate() {
        Iterator<RedisMessage> it = this.children.iterator();
        while (it.hasNext()) {
            ReferenceCountUtil.release(it.next());
        }
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "[children=" + this.children.size() + ']';
    }

    @Override // io.netty.util.ReferenceCounted
    public ArrayRedisMessage touch(Object obj) {
        Iterator<RedisMessage> it = this.children.iterator();
        while (it.hasNext()) {
            ReferenceCountUtil.touch(it.next());
        }
        return this;
    }

    public ArrayRedisMessage(List<RedisMessage> list) {
        this.children = (List) ObjectUtil.checkNotNull(list, "children");
    }
}
