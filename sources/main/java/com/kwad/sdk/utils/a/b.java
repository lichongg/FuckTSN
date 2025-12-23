package com.kwad.sdk.utils.a;

import com.google.common.base.Ascii;
import java.nio.charset.Charset;
import okio.Utf8;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    private char[] bbU;
    public byte[] bbV;
    public int position;

    public b(int i6) {
        this(new byte[i6], 0);
    }

    private long getLong(int i6) {
        byte[] bArr = this.bbV;
        return (bArr[i6 + 7] << 56) | (bArr[i6] & 255) | ((bArr[i6 + 1] & 255) << 8) | ((bArr[i6 + 2] & 255) << 16) | ((bArr[i6 + 3] & 255) << 24) | ((bArr[i6 + 4] & 255) << 32) | ((bArr[i6 + 5] & 255) << 40) | ((255 & bArr[i6 + 6]) << 48);
    }

    static String j(byte[] bArr, int i6) {
        char[] cArr = new char[bArr.length];
        int i7 = 0;
        int i8 = 0;
        while (i7 < i6) {
            int i9 = i7 + 1;
            byte b6 = bArr[i7];
            if (b6 > 0) {
                cArr[i8] = (char) (b6 ^ 1);
                i8++;
                i7 = i9;
            } else if (b6 < -32) {
                i7 += 2;
                byte b7 = bArr[i9];
                cArr[i8] = (char) ((b7 & Utf8.REPLACEMENT_BYTE) | ((b6 & Ascii.US) << 6));
                i8++;
            } else if (b6 < -16) {
                int i10 = i7 + 2;
                byte b8 = bArr[i9];
                i7 += 3;
                byte b9 = bArr[i10];
                cArr[i8] = (char) (((b8 & Utf8.REPLACEMENT_BYTE) << 6) | ((b6 & 15) << 12) | (b9 & Utf8.REPLACEMENT_BYTE));
                i8++;
            } else {
                byte b10 = bArr[i9];
                int i11 = i7 + 3;
                byte b11 = bArr[i7 + 2];
                i7 += 4;
                byte b12 = bArr[i11];
                int i12 = ((b10 & Utf8.REPLACEMENT_BYTE) << 12) | ((b6 & 7) << 18) | ((b11 & Utf8.REPLACEMENT_BYTE) << 6) | (b12 & Utf8.REPLACEMENT_BYTE);
                int i13 = i8 + 1;
                cArr[i8] = (char) ((i12 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                i8 += 2;
                cArr[i13] = (char) ((i12 & 1023) + Utf8.LOG_SURROGATE_HEADER);
            }
        }
        if (i7 <= i6) {
            return new String(cArr, 0, i8);
        }
        throw new IllegalArgumentException("Invalid String");
    }

    public final void k(byte[] bArr) {
        int length = bArr.length;
        if (length > 0) {
            System.arraycopy(bArr, 0, this.bbV, this.position, length);
            this.position += length;
        }
    }

    public b(byte[] bArr) {
        this(bArr, 0);
    }

    private int E(int i6, int i7) {
        while ((i7 & (-128)) != 0) {
            this.bbV[i6] = (byte) ((i7 & 127) | 128);
            i7 >>>= 7;
            i6++;
        }
        int i8 = i6 + 1;
        this.bbV[i6] = (byte) i7;
        return i8;
    }

    public static int fa(int i6) {
        if ((i6 >> 7) == 0) {
            return 1;
        }
        if ((i6 >> 14) == 0) {
            return 2;
        }
        if ((i6 >> 21) == 0) {
            return 3;
        }
        return (i6 >> 28) == 0 ? 4 : 5;
    }

    private char[] fc(int i6) {
        char[] cArr = this.bbU;
        if (cArr == null) {
            if (i6 <= 256) {
                this.bbU = new char[256];
            } else {
                this.bbU = new char[2048];
            }
        } else if (cArr.length < i6) {
            this.bbU = new char[2048];
        }
        return this.bbU;
    }

    private String fd(int i6) {
        if (i6 > 2048) {
            return new String(this.bbV, this.position, i6, UTF_8);
        }
        char[] fc = fc(i6);
        byte[] bArr = this.bbV;
        int i7 = this.position;
        int i8 = i6 + i7;
        int i9 = 0;
        while (i7 < i8) {
            int i10 = i7 + 1;
            byte b6 = bArr[i7];
            if (b6 > 0) {
                fc[i9] = (char) (b6 ^ 1);
                i9++;
                i7 = i10;
            } else if (b6 < -32) {
                i7 += 2;
                byte b7 = bArr[i10];
                fc[i9] = (char) ((b7 & Utf8.REPLACEMENT_BYTE) | ((b6 & Ascii.US) << 6));
                i9++;
            } else if (b6 < -16) {
                int i11 = i7 + 2;
                byte b8 = bArr[i10];
                i7 += 3;
                byte b9 = bArr[i11];
                fc[i9] = (char) (((b8 & Utf8.REPLACEMENT_BYTE) << 6) | ((b6 & 15) << 12) | (b9 & Utf8.REPLACEMENT_BYTE));
                i9++;
            } else {
                byte b10 = bArr[i10];
                int i12 = i7 + 3;
                byte b11 = bArr[i7 + 2];
                i7 += 4;
                byte b12 = bArr[i12];
                int i13 = ((b10 & Utf8.REPLACEMENT_BYTE) << 12) | ((b6 & 7) << 18) | ((b11 & Utf8.REPLACEMENT_BYTE) << 6) | (b12 & Utf8.REPLACEMENT_BYTE);
                int i14 = i9 + 1;
                fc[i9] = (char) ((i13 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                i9 += 2;
                fc[i14] = (char) ((i13 & 1023) + Utf8.LOG_SURROGATE_HEADER);
            }
        }
        if (i7 <= i8) {
            return new String(fc, 0, i9);
        }
        throw new IllegalArgumentException("Invalid String");
    }

    private String fe(int i6) {
        if (i6 > 2048) {
            return new String(this.bbV, this.position, i6, UTF_8);
        }
        char[] fc = fc(i6);
        byte[] bArr = this.bbV;
        int i7 = this.position;
        int i8 = i6 + i7;
        int i9 = 0;
        while (i7 < i8) {
            int i10 = i7 + 1;
            byte b6 = bArr[i7];
            if (b6 > 0) {
                fc[i9] = (char) b6;
                i9++;
                i7 = i10;
            } else if (b6 < -32) {
                i7 += 2;
                byte b7 = bArr[i10];
                fc[i9] = (char) ((b7 & Utf8.REPLACEMENT_BYTE) | ((b6 & Ascii.US) << 6));
                i9++;
            } else if (b6 < -16) {
                int i11 = i7 + 2;
                byte b8 = bArr[i10];
                i7 += 3;
                byte b9 = bArr[i11];
                fc[i9] = (char) (((b8 & Utf8.REPLACEMENT_BYTE) << 6) | ((b6 & 15) << 12) | (b9 & Utf8.REPLACEMENT_BYTE));
                i9++;
            } else {
                byte b10 = bArr[i10];
                int i12 = i7 + 3;
                byte b11 = bArr[i7 + 2];
                i7 += 4;
                byte b12 = bArr[i12];
                int i13 = ((b10 & Utf8.REPLACEMENT_BYTE) << 12) | ((b6 & 7) << 18) | ((b11 & Utf8.REPLACEMENT_BYTE) << 6) | (b12 & Utf8.REPLACEMENT_BYTE);
                int i14 = i9 + 1;
                fc[i9] = (char) ((i13 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                i9 += 2;
                fc[i14] = (char) ((i13 & 1023) + Utf8.LOG_SURROGATE_HEADER);
            }
        }
        if (i7 <= i8) {
            return new String(fc, 0, i9);
        }
        throw new IllegalArgumentException("Invalid String");
    }

    private void hE(String str) {
        byte[] bArr = this.bbV;
        int i6 = this.position;
        int length = str.length();
        int i7 = 0;
        while (i7 < length) {
            int i8 = i7 + 1;
            char charAt = str.charAt(i7);
            if (charAt < 128) {
                bArr[i6] = (byte) (charAt ^ 1);
                i6++;
            } else if (charAt < 2048) {
                int i9 = i6 + 1;
                bArr[i6] = (byte) ((charAt >>> 6) | 192);
                i6 += 2;
                bArr[i9] = (byte) ((charAt & '?') | 128);
            } else if (charAt < 55296 || charAt > 57343) {
                bArr[i6] = (byte) ((charAt >>> '\f') | 224);
                int i10 = i6 + 2;
                bArr[i6 + 1] = (byte) (((charAt >>> 6) & 63) | 128);
                i6 += 3;
                bArr[i10] = (byte) ((charAt & '?') | 128);
            } else {
                i7 += 2;
                int charAt2 = ((charAt << '\n') + str.charAt(i8)) - 56613888;
                bArr[i6] = (byte) ((charAt2 >>> 18) | 240);
                bArr[i6 + 1] = (byte) (((charAt2 >>> 12) & 63) | 128);
                int i11 = i6 + 3;
                bArr[i6 + 2] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i6 += 4;
                bArr[i11] = (byte) ((charAt2 & 63) | 128);
            }
            i7 = i8;
        }
        this.position = i6;
    }

    public final void D(int i6, int i7) {
        byte[] bArr = this.bbV;
        bArr[i6] = (byte) i7;
        bArr[i6 + 1] = (byte) (i7 >> 8);
        bArr[i6 + 2] = (byte) (i7 >> 16);
        bArr[i6 + 3] = (byte) (i7 >> 24);
    }

    final long F(int i6, int i7) {
        long j6 = 0;
        if (i7 <= 0) {
            return 0L;
        }
        int i8 = i7 >> 3;
        int i9 = i7 & 7;
        int i10 = 0;
        int i11 = i6;
        for (int i12 = 0; i12 < i8; i12++) {
            j6 ^= getLong(i11);
            i11 += 8;
        }
        while (i10 < (i9 << 3)) {
            j6 ^= (this.bbV[i11] & 255) << i10;
            i10 += 8;
            i11++;
        }
        int i13 = (i6 & 7) << 3;
        return (j6 >>> (64 - i13)) | (j6 << i13);
    }

    public final int Sq() {
        byte[] bArr = this.bbV;
        int i6 = this.position;
        int i7 = i6 + 1;
        this.position = i7;
        byte b6 = bArr[i6];
        if ((b6 >> 7) == 0) {
            return b6;
        }
        int i8 = i6 + 2;
        this.position = i8;
        int i9 = (bArr[i7] << 7) | (b6 & Byte.MAX_VALUE);
        if ((i9 >> 14) == 0) {
            return i9;
        }
        int i10 = i6 + 3;
        this.position = i10;
        int i11 = (i9 & 16383) | (bArr[i8] << 14);
        if ((i11 >> 21) == 0) {
            return i11;
        }
        int i12 = i6 + 4;
        this.position = i12;
        int i13 = (i11 & 2097151) | (bArr[i10] << 21);
        if ((i13 >> 28) == 0) {
            return i13;
        }
        this.position = i6 + 5;
        return (bArr[i12] << 28) | (i13 & 268435455);
    }

    public final void a(short s5) {
        byte[] bArr = this.bbV;
        int i6 = this.position;
        int i7 = i6 + 1;
        this.position = i7;
        bArr[i6] = (byte) s5;
        this.position = i6 + 2;
        bArr[i7] = (byte) (s5 >> 8);
    }

    public final void bb(long j6) {
        f(this.position, j6);
        this.position += 8;
    }

    public final void e(byte b6) {
        byte[] bArr = this.bbV;
        int i6 = this.position;
        this.position = i6 + 1;
        bArr[i6] = b6;
    }

    public final void eY(int i6) {
        byte[] bArr = this.bbV;
        int i7 = this.position;
        int i8 = i7 + 1;
        this.position = i8;
        bArr[i7] = (byte) i6;
        int i9 = i7 + 2;
        this.position = i9;
        bArr[i8] = (byte) (i6 >> 8);
        int i10 = i7 + 3;
        this.position = i10;
        bArr[i9] = (byte) (i6 >> 16);
        this.position = i7 + 4;
        bArr[i10] = (byte) (i6 >> 24);
    }

    public final void eZ(int i6) {
        this.position = E(this.position, i6);
    }

    public final void f(int i6, long j6) {
        byte[] bArr = this.bbV;
        bArr[i6] = (byte) j6;
        bArr[i6 + 1] = (byte) (j6 >> 8);
        bArr[i6 + 2] = (byte) (j6 >> 16);
        bArr[i6 + 3] = (byte) (j6 >> 24);
        bArr[i6 + 4] = (byte) (j6 >> 32);
        bArr[i6 + 5] = (byte) (j6 >> 40);
        bArr[i6 + 6] = (byte) (j6 >> 48);
        bArr[i6 + 7] = (byte) (j6 >> 56);
    }

    public final String fb(int i6) {
        if (i6 < 0) {
            return null;
        }
        if (i6 == 0) {
            return "";
        }
        String fe = fe(i6);
        this.position += i6;
        return fe;
    }

    public final byte get() {
        byte[] bArr = this.bbV;
        int i6 = this.position;
        this.position = i6 + 1;
        return bArr[i6];
    }

    public final byte[] getBytes(int i6) {
        byte[] bArr = new byte[i6];
        System.arraycopy(this.bbV, this.position, bArr, 0, i6);
        this.position += i6;
        return bArr;
    }

    public final int getInt() {
        byte[] bArr = this.bbV;
        int i6 = this.position;
        int i7 = i6 + 1;
        this.position = i7;
        int i8 = bArr[i6] & 255;
        int i9 = i6 + 2;
        this.position = i9;
        int i10 = ((bArr[i7] & 255) << 8) | i8;
        int i11 = i6 + 3;
        this.position = i11;
        int i12 = i10 | ((bArr[i9] & 255) << 16);
        this.position = i6 + 4;
        return (bArr[i11] << 24) | i12;
    }

    public final long getLong() {
        long j6 = getLong(this.position);
        this.position += 8;
        return j6;
    }

    public final short getShort() {
        byte[] bArr = this.bbV;
        int i6 = this.position;
        int i7 = i6 + 1;
        this.position = i7;
        int i8 = bArr[i6] & 255;
        this.position = i6 + 2;
        return (short) ((bArr[i7] << 8) | i8);
    }

    public final String getString(int i6) {
        if (i6 < 0) {
            return null;
        }
        if (i6 == 0) {
            return "";
        }
        String fd = fd(i6);
        this.position += i6;
        return fd;
    }

    public final void hC(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        hE(str);
    }

    public b(byte[] bArr, int i6) {
        this.bbU = null;
        this.bbV = bArr;
        this.position = i6;
    }

    public static int hD(String str) {
        int length = str.length();
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            int i8 = i6 + 1;
            char charAt = str.charAt(i6);
            if (charAt < 128) {
                i7++;
            } else if (charAt < 2048) {
                i7 += 2;
            } else if (charAt >= 55296 && charAt <= 57343) {
                i6 += 2;
                i7 += 4;
            } else {
                i7 += 3;
            }
            i6 = i8;
        }
        return i7;
    }

    public static byte[] hF(String str) {
        byte[] bArr = new byte[hD(str)];
        int length = str.length();
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            int i8 = i6 + 1;
            char charAt = str.charAt(i6);
            if (charAt < 128) {
                bArr[i7] = (byte) (charAt ^ 1);
                i7++;
            } else if (charAt < 2048) {
                int i9 = i7 + 1;
                bArr[i7] = (byte) ((charAt >>> 6) | 192);
                i7 += 2;
                bArr[i9] = (byte) ((charAt & '?') | 128);
            } else if (charAt >= 55296 && charAt <= 57343) {
                i6 += 2;
                int charAt2 = ((charAt << '\n') + str.charAt(i8)) - 56613888;
                bArr[i7] = (byte) ((charAt2 >>> 18) | 240);
                bArr[i7 + 1] = (byte) (((charAt2 >>> 12) & 63) | 128);
                int i10 = i7 + 3;
                bArr[i7 + 2] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i7 += 4;
                bArr[i10] = (byte) ((charAt2 & 63) | 128);
            } else {
                bArr[i7] = (byte) ((charAt >>> '\f') | 224);
                int i11 = i7 + 2;
                bArr[i7 + 1] = (byte) (((charAt >>> 6) & 63) | 128);
                i7 += 3;
                bArr[i11] = (byte) ((charAt & '?') | 128);
            }
            i6 = i8;
        }
        return bArr;
    }

    public final double getDouble() {
        return Double.longBitsToDouble(getLong());
    }

    public final float getFloat() {
        return Float.intBitsToFloat(getInt());
    }
}
