package cn.jiguang.bz;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import io.netty.handler.codec.memcache.binary.DefaultBinaryMemcacheResponse;
import java.util.Arrays;
import okio.Utf8;

/* loaded from: D:\Downloads\app\classes2.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f2784a = {-42, -112, -23, -2, -52, -31, 61, -73, 22, -74, 20, -62, 40, -5, HttpConstants.COMMA, 5, 43, 103, -102, 118, 42, -66, 4, -61, -86, 68, 19, 38, 73, -122, 6, -103, -100, 66, 80, -12, -111, -17, -104, 122, 51, 84, 11, 67, -19, -49, -84, 98, -28, -77, 28, -87, -55, 8, -24, -107, Byte.MIN_VALUE, -33, -108, -6, 117, -113, Utf8.REPLACEMENT_BYTE, -90, 71, 7, -89, -4, -13, 115, 23, -70, -125, 89, 60, 25, -26, -123, 79, -88, 104, 107, DefaultBinaryMemcacheResponse.RESPONSE_MAGIC_BYTE, -78, 113, 100, -38, -117, -8, -21, 15, 75, 112, 86, -99, 53, 30, BinaryMemcacheOpcodes.GATKQ, 14, 94, 99, 88, -47, -94, 37, 34, 124, HttpConstants.SEMICOLON, 1, BinaryMemcacheOpcodes.SASL_AUTH, 120, -121, -44, 0, 70, 87, -97, -45, 39, 82, 76, 54, 2, -25, -96, -60, -56, -98, -22, -65, -118, -46, SignedBytes.MAX_POWER_OF_TWO, -57, 56, -75, -93, -9, -14, -50, -7, 97, 21, -95, -32, -82, 93, -92, -101, 52, 26, 85, -83, -109, 50, 48, -11, -116, -79, -29, 29, -10, -30, 46, -126, 102, -54, 96, -64, 41, BinaryMemcacheOpcodes.GATK, -85, 13, 83, 78, 111, -43, -37, 55, 69, -34, -3, -114, 47, 3, -1, 106, 114, 109, 108, 91, 81, -115, Ascii.ESC, -81, -110, -69, -35, -68, Byte.MAX_VALUE, 17, -39, 92, 65, Ascii.US, 16, 90, -40, 10, -63, 49, -120, -91, -51, 123, -67, 45, 116, -48, 18, -72, -27, -76, -80, -119, 105, -105, 74, 12, -106, 119, 126, 101, -71, -15, 9, -59, 110, -58, -124, 24, -16, 125, -20, HttpConstants.COLON, -36, 77, 32, 121, -18, 95, 62, -41, -53, 57, 72};

    /* renamed from: b, reason: collision with root package name */
    private int[] f2785b = {462357, 472066609, 943670861, 1415275113, 1886879365, -1936483679, -1464879427, -993275175, -521670923, -66909679, 404694573, 876298825, 1347903077, 1819507329, -2003855715, -1532251463, -1060647211, -589042959, -117504499, 337322537, 808926789, 1280531041, 1752135293, -2071227751, -1599623499, -1128019247, -656414995, -184876535, 269950501, 741554753, 1213159005, 1684763257};

    private static int a(char c6) {
        return (byte) "0123456789abcdef".indexOf(c6);
    }

    private int b(int i6) {
        return a(i6, 24) ^ (((a(i6, 2) ^ i6) ^ a(i6, 10)) ^ a(i6, 18));
    }

    private int c(int i6) {
        return a(i6, 23) ^ (a(i6, 13) ^ i6);
    }

    private int a(int i6) {
        byte[] bArr = this.f2784a;
        return (bArr[i6 & 255] & 255) | ((bArr[(i6 >>> 24) & 255] & 255) << 24) | ((bArr[(i6 >>> 16) & 255] & 255) << 16) | ((bArr[(i6 >>> 8) & 255] & 255) << 8);
    }

    private static byte[] b(byte[] bArr) {
        int length = 16 - (bArr.length % 16);
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length + length);
        for (int i6 = 0; i6 < length; i6++) {
            copyOf[bArr.length + i6] = (byte) length;
        }
        return copyOf;
    }

    private static byte[] c(byte[] bArr) {
        int length = bArr.length - bArr[bArr.length - 1];
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    private int a(int i6, int i7) {
        return (i6 >>> (32 - i7)) | (i6 << i7);
    }

    public byte[] b(byte[] bArr, String str) {
        return b(bArr, a(str), str.substring(0, 16).getBytes("utf-8"));
    }

    private static void a(byte[] bArr, byte[] bArr2) {
        for (int i6 = 0; i6 < bArr.length; i6++) {
            bArr[i6] = (byte) (bArr[i6] ^ bArr2[i6]);
        }
    }

    public byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        if (bArr2 == null || bArr2.length != 16) {
            throw new IllegalArgumentException("key's length should be 16");
        }
        if (bArr3 != null && bArr3.length != 16) {
            bArr3 = null;
        }
        int[] a6 = a(bArr2, true);
        byte[] bArr4 = new byte[16];
        byte[] bArr5 = new byte[16];
        byte[] bArr6 = new byte[bArr.length];
        int i6 = 0;
        while (true) {
            int i7 = i6 + 16;
            if (i7 > bArr.length) {
                return c(bArr6);
            }
            System.arraycopy(bArr, i6, bArr4, 0, 16);
            a(bArr4, bArr5, a6);
            if (bArr3 != null) {
                a(bArr5, bArr3);
            } else {
                bArr3 = new byte[16];
            }
            System.arraycopy(bArr, i6, bArr3, 0, 16);
            System.arraycopy(bArr5, 0, bArr6, i6, 16);
            i6 = i7;
        }
    }

    public void a(byte[] bArr, byte[] bArr2, int[] iArr) {
        int[] a6 = a(bArr);
        for (int i6 = 0; i6 < 32; i6 += 4) {
            int b6 = a6[0] ^ b(a(((a6[1] ^ a6[2]) ^ a6[3]) ^ iArr[i6]));
            a6[0] = b6;
            int b7 = b(a((b6 ^ (a6[2] ^ a6[3])) ^ iArr[i6 + 1])) ^ a6[1];
            a6[1] = b7;
            int b8 = b(a((b7 ^ (a6[3] ^ a6[0])) ^ iArr[i6 + 2])) ^ a6[2];
            a6[2] = b8;
            a6[3] = b(a((b8 ^ (a6[1] ^ a6[0])) ^ iArr[i6 + 3])) ^ a6[3];
        }
        for (int i7 = 0; i7 < 16; i7 += 4) {
            int i8 = a6[3 - (i7 / 4)];
            bArr2[i7] = (byte) ((i8 >>> 24) & 255);
            bArr2[i7 + 1] = (byte) ((i8 >>> 16) & 255);
            bArr2[i7 + 2] = (byte) ((i8 >>> 8) & 255);
            bArr2[i7 + 3] = (byte) (i8 & 255);
        }
    }

    public static byte[] a(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        char[] charArray = str.toLowerCase().toCharArray();
        for (int i6 = 0; i6 < length; i6++) {
            int i7 = i6 * 2;
            bArr[i6] = (byte) (a(charArray[i7 + 1]) | (a(charArray[i7]) << 4));
        }
        return bArr;
    }

    public byte[] a(byte[] bArr, String str) {
        byte[] a6 = a(str);
        String substring = str.substring(0, 16);
        cn.jiguang.bb.f.c("SM4", "seed=" + str);
        return a(bArr, a6, substring.getBytes("utf-8"));
    }

    public byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        if (bArr2 == null || bArr2.length != 16) {
            throw new IllegalArgumentException("key's length should be 16");
        }
        if (bArr3 != null && bArr3.length != 16) {
            bArr3 = null;
        }
        byte[] b6 = b(bArr);
        int[] a6 = a(bArr2, false);
        byte[] bArr4 = new byte[16];
        byte[] bArr5 = new byte[b6.length];
        int i6 = 0;
        while (true) {
            int i7 = i6 + 16;
            if (i7 > b6.length) {
                return bArr5;
            }
            System.arraycopy(b6, i6, bArr4, 0, 16);
            if (bArr3 != null) {
                a(bArr4, bArr3);
            } else {
                bArr3 = new byte[16];
            }
            a(bArr4, bArr3, a6);
            System.arraycopy(bArr3, 0, bArr5, i6, bArr3.length);
            i6 = i7;
        }
    }

    private int[] a(byte[] bArr) {
        int[] iArr = new int[4];
        for (int i6 = 0; i6 < 4; i6++) {
            int i7 = i6 * 4;
            iArr[i6] = (bArr[i7 + 3] & 255) | ((bArr[i7] & 255) << 24) | ((bArr[i7 + 1] & 255) << 16) | ((bArr[i7 + 2] & 255) << 8);
        }
        return iArr;
    }

    public int[] a(byte[] bArr, boolean z5) {
        int[] a6 = a(bArr);
        a6[0] = a6[0] ^ (-1548633402);
        a6[1] = a6[1] ^ 1453994832;
        a6[2] = a6[2] ^ 1736282519;
        a6[3] = a6[3] ^ (-1301273892);
        int[] iArr = new int[32];
        for (int i6 = 0; i6 < 32; i6 += 4) {
            int c6 = a6[0] ^ c(a(((a6[1] ^ a6[2]) ^ a6[3]) ^ this.f2785b[i6]));
            a6[0] = c6;
            iArr[i6] = c6;
            int i7 = i6 + 1;
            int c7 = a6[1] ^ c(a(((a6[2] ^ a6[3]) ^ a6[0]) ^ this.f2785b[i7]));
            a6[1] = c7;
            iArr[i7] = c7;
            int i8 = i6 + 2;
            int c8 = a6[2] ^ c(a(((a6[3] ^ a6[0]) ^ a6[1]) ^ this.f2785b[i8]));
            a6[2] = c8;
            iArr[i8] = c8;
            int i9 = i6 + 3;
            int c9 = a6[3] ^ c(a(((a6[0] ^ a6[1]) ^ a6[2]) ^ this.f2785b[i9]));
            a6[3] = c9;
            iArr[i9] = c9;
        }
        if (z5) {
            for (int i10 = 0; i10 < 16; i10++) {
                int i11 = iArr[i10];
                int i12 = 31 - i10;
                iArr[i10] = iArr[i12];
                iArr[i12] = i11;
            }
        }
        return iArr;
    }
}
