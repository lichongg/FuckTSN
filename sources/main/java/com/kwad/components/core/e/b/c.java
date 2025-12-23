package com.kwad.components.core.e.b;

import java.nio.ByteBuffer;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    private final int[] OF;

    public static c a(int[] iArr) {
        return new c(iArr);
    }

    private static long b(long j6, int[] iArr) {
        int i6 = 31;
        while (i6 > 23) {
            j6 = d(i6, iArr, j6);
            i6--;
        }
        while (i6 > 15) {
            j6 = c(i6, iArr, j6);
            i6--;
        }
        while (i6 > 7) {
            j6 = d(i6, iArr, j6);
            i6--;
        }
        while (i6 >= 0) {
            j6 = c(i6, iArr, j6);
            i6--;
        }
        return j6;
    }

    private static long a(long j6, int[] iArr) {
        int i6 = 0;
        while (i6 < 8) {
            j6 = a(i6, iArr, j6);
            i6++;
        }
        while (i6 < 16) {
            j6 = b(i6, iArr, j6);
            i6++;
        }
        while (i6 < 24) {
            j6 = a(i6, iArr, j6);
            i6++;
        }
        while (i6 < 32) {
            j6 = b(i6, iArr, j6);
            i6++;
        }
        return j6;
    }

    private static long c(int i6, int[] iArr, long j6) {
        long j7 = j6 >>> 48;
        long j8 = (j6 >> 32) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long j9 = (j6 >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        return ((i6 + 1) ^ (j7 ^ j8)) | ((j6 & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | (f(i6, iArr, j8) << 48) | (j9 << 32);
    }

    private static long d(int i6, int[] iArr, long j6) {
        long j7 = j6 >>> 48;
        long j8 = (j6 >> 32) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long j9 = (j6 >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long j10 = j6 & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        return (((i6 + 1) ^ (f(i6, iArr, j8) ^ j9)) << 32) | (f(i6, iArr, j8) << 48) | (j10 << 16) | j7;
    }

    private static long e(int i6, int[] iArr, long j6) {
        int i7 = (int) (j6 >>> 8);
        int i8 = (int) (j6 & 255);
        int i9 = i6 * 4;
        int i10 = iArr[i9 % 10];
        int i11 = iArr[(i9 + 1) % 10];
        int i12 = iArr[(i9 + 2) % 10];
        int i13 = iArr[(i9 + 3) % 10];
        int[] iArr2 = b.OE;
        int i14 = iArr2[i10 ^ i8] ^ i7;
        return ((i14 ^ iArr2[(i8 ^ iArr2[i11 ^ i14]) ^ i12]) << 8) | (iArr2[i13 ^ r7] ^ r8);
    }

    private static long f(int i6, int[] iArr, long j6) {
        int i7 = (int) (255 & j6);
        int i8 = (int) (j6 >>> 8);
        int i9 = i6 * 4;
        int i10 = iArr[(i9 + 3) % 10];
        int i11 = iArr[(i9 + 2) % 10];
        int i12 = iArr[(i9 + 1) % 10];
        int i13 = iArr[i9 % 10];
        int[] iArr2 = b.OE;
        int i14 = iArr2[i10 ^ i8] ^ i7;
        return ((iArr2[i13 ^ r6] ^ r7) << 8) | (i14 ^ iArr2[(i8 ^ iArr2[i14 ^ i11]) ^ i12]);
    }

    public final String z(long j6) {
        return com.kwad.sdk.core.a.c.Hg().encodeToString(ByteBuffer.allocate(8).putLong(a(j6, this.OF)).array());
    }

    private c(int[] iArr) {
        this.OF = iArr;
    }

    public final long aj(String str) {
        byte[] decode = com.kwad.sdk.core.a.c.Hj().decode(str);
        if (decode != null && decode.length == 8) {
            return b(ByteBuffer.wrap(decode).getLong(), this.OF);
        }
        throw new RuntimeException("fail to decode: " + str);
    }

    private static long b(int i6, int[] iArr, long j6) {
        long j7 = j6 >>> 48;
        long j8 = (j6 >> 32) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        return (((i6 + 1) ^ (j7 ^ j8)) << 16) | ((j6 & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | (e(i6, iArr, j7) << 32) | ((j6 >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
    }

    private static long a(int i6, int[] iArr, long j6) {
        long j7 = j6 >>> 48;
        long j8 = (j6 >> 32) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        return (e(i6, iArr, j7) << 32) | ((((j6 & WebSocketProtocol.PAYLOAD_SHORT_MAX) ^ e(i6, iArr, j7)) ^ (i6 + 1)) << 48) | (j8 << 16) | ((j6 >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
    }
}
