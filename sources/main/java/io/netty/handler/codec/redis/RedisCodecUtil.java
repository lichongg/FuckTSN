package io.netty.handler.codec.redis;

import io.netty.util.CharsetUtil;
import io.netty.util.internal.PlatformDependent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class RedisCodecUtil {
    static byte[] shortToBytes(short s5) {
        byte[] bArr = new byte[2];
        if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
            bArr[1] = (byte) ((s5 >> 8) & 255);
            bArr[0] = (byte) (s5 & 255);
            return bArr;
        }
        bArr[0] = (byte) ((s5 >> 8) & 255);
        bArr[1] = (byte) (s5 & 255);
        return bArr;
    }

    static short makeShort(char c6, char c7) {
        return (short) (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? c6 | (c7 << '\b') : (c6 << '\b') | c7);
    }

    private RedisCodecUtil() {
    }

    static byte[] longToAsciiBytes(long j6) {
        return Long.toString(j6).getBytes(CharsetUtil.US_ASCII);
    }
}
