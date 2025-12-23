package io.netty.handler.codec.redis;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public enum RedisMessageType {
    INLINE_COMMAND(null, true),
    SIMPLE_STRING((byte) 43, true),
    ERROR((byte) 45, true),
    INTEGER(Byte.valueOf(HttpConstants.COLON), true),
    BULK_STRING(Byte.valueOf(BinaryMemcacheOpcodes.GATKQ), false),
    ARRAY_HEADER((byte) 42, false);

    private final boolean inline;
    private final Byte value;

    private static RedisMessageType valueOf(byte b6) {
        return b6 != 36 ? b6 != 45 ? b6 != 58 ? b6 != 42 ? b6 != 43 ? INLINE_COMMAND : SIMPLE_STRING : ARRAY_HEADER : INTEGER : ERROR : BULK_STRING;
    }

    public boolean isInline() {
        return this.inline;
    }

    public int length() {
        return this.value != null ? 1 : 0;
    }

    public void writeTo(ByteBuf byteBuf) {
        Byte b6 = this.value;
        if (b6 == null) {
            return;
        }
        byteBuf.writeByte(b6.byteValue());
    }

    RedisMessageType(Byte b6, boolean z5) {
        this.value = b6;
        this.inline = z5;
    }

    public static RedisMessageType readFrom(ByteBuf byteBuf, boolean z5) {
        int readerIndex = byteBuf.readerIndex();
        RedisMessageType valueOf = valueOf(byteBuf.readByte());
        if (valueOf == INLINE_COMMAND) {
            if (z5) {
                byteBuf.readerIndex(readerIndex);
                return valueOf;
            }
            throw new RedisCodecException("Decoding of inline commands is disabled");
        }
        return valueOf;
    }
}
