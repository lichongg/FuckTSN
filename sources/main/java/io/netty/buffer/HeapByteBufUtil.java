package io.netty.buffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class HeapByteBufUtil {
    static void setByte(byte[] bArr, int i6, int i7) {
        bArr[i6] = (byte) i7;
    }

    static void setIntLE(byte[] bArr, int i6, int i7) {
        bArr[i6] = (byte) i7;
        bArr[i6 + 1] = (byte) (i7 >>> 8);
        bArr[i6 + 2] = (byte) (i7 >>> 16);
        bArr[i6 + 3] = (byte) (i7 >>> 24);
    }

    static void setLongLE(byte[] bArr, int i6, long j6) {
        bArr[i6] = (byte) j6;
        bArr[i6 + 1] = (byte) (j6 >>> 8);
        bArr[i6 + 2] = (byte) (j6 >>> 16);
        bArr[i6 + 3] = (byte) (j6 >>> 24);
        bArr[i6 + 4] = (byte) (j6 >>> 32);
        bArr[i6 + 5] = (byte) (j6 >>> 40);
        bArr[i6 + 6] = (byte) (j6 >>> 48);
        bArr[i6 + 7] = (byte) (j6 >>> 56);
    }

    static void setMediumLE(byte[] bArr, int i6, int i7) {
        bArr[i6] = (byte) i7;
        bArr[i6 + 1] = (byte) (i7 >>> 8);
        bArr[i6 + 2] = (byte) (i7 >>> 16);
    }

    static void setShortLE(byte[] bArr, int i6, int i7) {
        bArr[i6] = (byte) i7;
        bArr[i6 + 1] = (byte) (i7 >>> 8);
    }

    static byte getByte(byte[] bArr, int i6) {
        return bArr[i6];
    }

    static int getInt(byte[] bArr, int i6) {
        return (bArr[i6 + 3] & 255) | ((bArr[i6] & 255) << 24) | ((bArr[i6 + 1] & 255) << 16) | ((bArr[i6 + 2] & 255) << 8);
    }

    static int getIntLE(byte[] bArr, int i6) {
        return ((bArr[i6 + 3] & 255) << 24) | (bArr[i6] & 255) | ((bArr[i6 + 1] & 255) << 8) | ((bArr[i6 + 2] & 255) << 16);
    }

    static long getLong(byte[] bArr, int i6) {
        return (bArr[i6 + 7] & 255) | ((bArr[i6] & 255) << 56) | ((bArr[i6 + 1] & 255) << 48) | ((bArr[i6 + 2] & 255) << 40) | ((bArr[i6 + 3] & 255) << 32) | ((bArr[i6 + 4] & 255) << 24) | ((bArr[i6 + 5] & 255) << 16) | ((bArr[i6 + 6] & 255) << 8);
    }

    static long getLongLE(byte[] bArr, int i6) {
        return ((bArr[i6 + 7] & 255) << 56) | (bArr[i6] & 255) | ((bArr[i6 + 1] & 255) << 8) | ((bArr[i6 + 2] & 255) << 16) | ((bArr[i6 + 3] & 255) << 24) | ((bArr[i6 + 4] & 255) << 32) | ((bArr[i6 + 5] & 255) << 40) | ((bArr[i6 + 6] & 255) << 48);
    }

    static short getShort(byte[] bArr, int i6) {
        return (short) ((bArr[i6 + 1] & 255) | (bArr[i6] << 8));
    }

    static short getShortLE(byte[] bArr, int i6) {
        return (short) ((bArr[i6 + 1] << 8) | (bArr[i6] & 255));
    }

    static int getUnsignedMedium(byte[] bArr, int i6) {
        return (bArr[i6 + 2] & 255) | ((bArr[i6] & 255) << 16) | ((bArr[i6 + 1] & 255) << 8);
    }

    static int getUnsignedMediumLE(byte[] bArr, int i6) {
        return ((bArr[i6 + 2] & 255) << 16) | (bArr[i6] & 255) | ((bArr[i6 + 1] & 255) << 8);
    }

    static void setInt(byte[] bArr, int i6, int i7) {
        bArr[i6] = (byte) (i7 >>> 24);
        bArr[i6 + 1] = (byte) (i7 >>> 16);
        bArr[i6 + 2] = (byte) (i7 >>> 8);
        bArr[i6 + 3] = (byte) i7;
    }

    static void setLong(byte[] bArr, int i6, long j6) {
        bArr[i6] = (byte) (j6 >>> 56);
        bArr[i6 + 1] = (byte) (j6 >>> 48);
        bArr[i6 + 2] = (byte) (j6 >>> 40);
        bArr[i6 + 3] = (byte) (j6 >>> 32);
        bArr[i6 + 4] = (byte) (j6 >>> 24);
        bArr[i6 + 5] = (byte) (j6 >>> 16);
        bArr[i6 + 6] = (byte) (j6 >>> 8);
        bArr[i6 + 7] = (byte) j6;
    }

    static void setMedium(byte[] bArr, int i6, int i7) {
        bArr[i6] = (byte) (i7 >>> 16);
        bArr[i6 + 1] = (byte) (i7 >>> 8);
        bArr[i6 + 2] = (byte) i7;
    }

    static void setShort(byte[] bArr, int i6, int i7) {
        bArr[i6] = (byte) (i7 >>> 8);
        bArr[i6 + 1] = (byte) i7;
    }

    private HeapByteBufUtil() {
    }
}
