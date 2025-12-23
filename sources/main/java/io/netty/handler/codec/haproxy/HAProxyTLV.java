package io.netty.handler.codec.haproxy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class HAProxyTLV extends DefaultByteBufHolder {
    private final Type type;
    private final byte typeByteValue;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum Type {
        PP2_TYPE_ALPN,
        PP2_TYPE_AUTHORITY,
        PP2_TYPE_SSL,
        PP2_TYPE_SSL_VERSION,
        PP2_TYPE_SSL_CN,
        PP2_TYPE_NETNS,
        OTHER;

        public static Type typeForByteValue(byte b6) {
            if (b6 == 1) {
                return PP2_TYPE_ALPN;
            }
            if (b6 == 2) {
                return PP2_TYPE_AUTHORITY;
            }
            if (b6 == 48) {
                return PP2_TYPE_NETNS;
            }
            switch (b6) {
                case 32:
                    return PP2_TYPE_SSL;
                case 33:
                    return PP2_TYPE_SSL_VERSION;
                case 34:
                    return PP2_TYPE_SSL_CN;
                default:
                    return OTHER;
            }
        }
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public HAProxyTLV copy() {
        return replace(content().copy());
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public HAProxyTLV duplicate() {
        return replace(content().duplicate());
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public HAProxyTLV replace(ByteBuf byteBuf) {
        return new HAProxyTLV(this.type, this.typeByteValue, byteBuf);
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public HAProxyTLV retainedDuplicate() {
        return replace(content().retainedDuplicate());
    }

    public Type type() {
        return this.type;
    }

    public byte typeByteValue() {
        return this.typeByteValue;
    }

    HAProxyTLV(Type type, byte b6, ByteBuf byteBuf) {
        super(byteBuf);
        ObjectUtil.checkNotNull(type, "type");
        this.type = type;
        this.typeByteValue = b6;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public HAProxyTLV retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public HAProxyTLV touch() {
        super.touch();
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public HAProxyTLV retain(int i6) {
        super.retain(i6);
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public HAProxyTLV touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
