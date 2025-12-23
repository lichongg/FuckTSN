package org.apache.commons.net.util;

import com.google.common.base.Ascii;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import okio.Utf8;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a {

    /* renamed from: m, reason: collision with root package name */
    private static final int f51231m = 2;

    /* renamed from: n, reason: collision with root package name */
    private static final int f51232n = 8192;

    /* renamed from: o, reason: collision with root package name */
    static final int f51233o = 76;

    /* renamed from: t, reason: collision with root package name */
    private static final byte f51238t = 61;

    /* renamed from: v, reason: collision with root package name */
    private static final int f51240v = 63;

    /* renamed from: w, reason: collision with root package name */
    private static final int f51241w = 255;

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f51242a;

    /* renamed from: b, reason: collision with root package name */
    private final int f51243b;

    /* renamed from: c, reason: collision with root package name */
    private final byte[] f51244c;

    /* renamed from: d, reason: collision with root package name */
    private final int f51245d;

    /* renamed from: e, reason: collision with root package name */
    private final int f51246e;

    /* renamed from: f, reason: collision with root package name */
    private byte[] f51247f;

    /* renamed from: g, reason: collision with root package name */
    private int f51248g;

    /* renamed from: h, reason: collision with root package name */
    private int f51249h;

    /* renamed from: i, reason: collision with root package name */
    private int f51250i;

    /* renamed from: j, reason: collision with root package name */
    private int f51251j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f51252k;

    /* renamed from: l, reason: collision with root package name */
    private int f51253l;

    /* renamed from: p, reason: collision with root package name */
    private static final byte[] f51234p = {13, 10};

    /* renamed from: q, reason: collision with root package name */
    private static final byte[] f51235q = new byte[0];

    /* renamed from: r, reason: collision with root package name */
    private static final byte[] f51236r = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: s, reason: collision with root package name */
    private static final byte[] f51237s = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* renamed from: u, reason: collision with root package name */
    private static final byte[] f51239u = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, HttpConstants.COLON, HttpConstants.SEMICOLON, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, Utf8.REPLACEMENT_BYTE, -1, 26, Ascii.ESC, 28, 29, 30, Ascii.US, 32, BinaryMemcacheOpcodes.SASL_AUTH, 34, BinaryMemcacheOpcodes.GATK, BinaryMemcacheOpcodes.GATKQ, 37, 38, 39, 40, 41, 42, 43, HttpConstants.COMMA, 45, 46, 47, 48, 49, 50, 51};

    public a() {
        this(false);
    }

    public static boolean B(byte[] bArr) {
        for (int i6 = 0; i6 < bArr.length; i6++) {
            if (!C(bArr[i6]) && !E(bArr[i6])) {
                return false;
            }
        }
        return true;
    }

    private void H() {
        this.f51247f = null;
        this.f51248g = 0;
        this.f51249h = 0;
        this.f51250i = 0;
        this.f51251j = 0;
        this.f51252k = false;
    }

    private static boolean b(byte[] bArr) {
        for (byte b6 : bArr) {
            if (C(b6)) {
                return true;
            }
        }
        return false;
    }

    public static byte[] k(byte[] bArr) {
        return l(bArr, false);
    }

    public static byte[] l(byte[] bArr, boolean z5) {
        return m(bArr, z5, false);
    }

    public static byte[] o(byte[] bArr) {
        return l(bArr, true);
    }

    public static String p(byte[] bArr) {
        return F(l(bArr, true));
    }

    public static String r(byte[] bArr) {
        return F(l(bArr, false));
    }

    public static byte[] s(byte[] bArr) {
        return m(bArr, false, true);
    }

    public static String t(byte[] bArr) {
        return F(m(bArr, false, true));
    }

    public a(boolean z5) {
        this(76, f51234p, z5);
    }

    public static boolean C(byte b6) {
        if (b6 == 61) {
            return true;
        }
        if (b6 < 0) {
            return false;
        }
        byte[] bArr = f51239u;
        return b6 < bArr.length && bArr[b6] != -1;
    }

    private static boolean E(byte b6) {
        return b6 == 9 || b6 == 10 || b6 == 13 || b6 == 32;
    }

    private static String F(byte[] bArr) {
        try {
            return new String(bArr, "UTF8");
        } catch (UnsupportedEncodingException e6) {
            throw new RuntimeException(e6);
        }
    }

    private void I() {
        byte[] bArr = this.f51247f;
        if (bArr == null) {
            this.f51247f = new byte[8192];
            this.f51248g = 0;
            this.f51249h = 0;
        } else {
            byte[] bArr2 = new byte[bArr.length * 2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.f51247f = bArr2;
        }
    }

    public static byte[] f(String str) {
        return new a().d(str);
    }

    public static byte[] g(byte[] bArr) {
        return new a().e(bArr);
    }

    public static BigInteger h(byte[] bArr) {
        return new BigInteger(1, g(bArr));
    }

    public static byte[] n(byte[] bArr, boolean z5, boolean z6, int i6) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        long x5 = x(bArr, z5 ? 76 : 0, z5 ? f51234p : f51235q);
        if (x5 <= i6) {
            return (z5 ? new a(z6) : new a(0, f51234p, z6)).j(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + x5 + ") than the specified maxium size of " + i6);
    }

    public static byte[] u(BigInteger bigInteger) {
        if (bigInteger != null) {
            return l(K(bigInteger), false);
        }
        throw new NullPointerException("encodeInteger called with null parameter");
    }

    private byte[] w(String str) {
        try {
            return str.getBytes("UTF8");
        } catch (UnsupportedEncodingException e6) {
            throw new RuntimeException(e6);
        }
    }

    private static long x(byte[] bArr, int i6, byte[] bArr2) {
        int i7 = (i6 / 4) * 4;
        long length = (bArr.length * 4) / 3;
        long j6 = length % 4;
        if (j6 != 0) {
            length += 4 - j6;
        }
        if (i7 <= 0) {
            return length;
        }
        long j7 = i7;
        boolean z5 = length % j7 == 0;
        long length2 = length + ((length / j7) * bArr2.length);
        return !z5 ? length2 + bArr2.length : length2;
    }

    boolean A() {
        return this.f51247f != null;
    }

    public boolean D() {
        return this.f51242a == f51237s;
    }

    int G(byte[] bArr, int i6, int i7) {
        if (this.f51247f == null) {
            return this.f51252k ? -1 : 0;
        }
        int min = Math.min(a(), i7);
        byte[] bArr2 = this.f51247f;
        if (bArr2 == bArr) {
            this.f51247f = null;
            return min;
        }
        System.arraycopy(bArr2, this.f51249h, bArr, i6, min);
        int i8 = this.f51249h + min;
        this.f51249h = i8;
        if (i8 >= this.f51248g) {
            this.f51247f = null;
        }
        return min;
    }

    void J(byte[] bArr, int i6, int i7) {
        if (bArr == null || bArr.length != i7) {
            return;
        }
        this.f51247f = bArr;
        this.f51248g = i6;
        this.f51249h = i6;
    }

    int a() {
        if (this.f51247f != null) {
            return this.f51248g - this.f51249h;
        }
        return 0;
    }

    void c(byte[] bArr, int i6, int i7) {
        int i8;
        byte b6;
        if (this.f51252k) {
            return;
        }
        if (i7 < 0) {
            this.f51252k = true;
        }
        int i9 = 0;
        while (true) {
            if (i9 >= i7) {
                break;
            }
            byte[] bArr2 = this.f51247f;
            if (bArr2 == null || bArr2.length - this.f51248g < this.f51245d) {
                I();
            }
            int i10 = i6 + 1;
            byte b7 = bArr[i6];
            if (b7 == 61) {
                this.f51252k = true;
                break;
            }
            if (b7 >= 0) {
                byte[] bArr3 = f51239u;
                if (b7 < bArr3.length && (b6 = bArr3[b7]) >= 0) {
                    int i11 = (this.f51251j + 1) % 4;
                    this.f51251j = i11;
                    int i12 = (this.f51253l << 6) + b6;
                    this.f51253l = i12;
                    if (i11 == 0) {
                        byte[] bArr4 = this.f51247f;
                        int i13 = this.f51248g;
                        int i14 = i13 + 1;
                        this.f51248g = i14;
                        bArr4[i13] = (byte) ((i12 >> 16) & 255);
                        int i15 = i13 + 2;
                        this.f51248g = i15;
                        bArr4[i14] = (byte) ((i12 >> 8) & 255);
                        this.f51248g = i13 + 3;
                        bArr4[i15] = (byte) (i12 & 255);
                    }
                }
            }
            i9++;
            i6 = i10;
        }
        if (!this.f51252k || (i8 = this.f51251j) == 0) {
            return;
        }
        int i16 = this.f51253l;
        int i17 = i16 << 6;
        this.f51253l = i17;
        if (i8 == 2) {
            int i18 = i16 << 12;
            this.f51253l = i18;
            byte[] bArr5 = this.f51247f;
            int i19 = this.f51248g;
            this.f51248g = i19 + 1;
            bArr5[i19] = (byte) ((i18 >> 16) & 255);
            return;
        }
        if (i8 != 3) {
            return;
        }
        byte[] bArr6 = this.f51247f;
        int i20 = this.f51248g;
        int i21 = i20 + 1;
        this.f51248g = i21;
        bArr6[i20] = (byte) ((i17 >> 16) & 255);
        this.f51248g = i20 + 2;
        bArr6[i21] = (byte) ((i17 >> 8) & 255);
    }

    void i(byte[] bArr, int i6, int i7) {
        int i8;
        if (this.f51252k) {
            return;
        }
        if (i7 >= 0) {
            int i9 = 0;
            while (i9 < i7) {
                byte[] bArr2 = this.f51247f;
                if (bArr2 == null || bArr2.length - this.f51248g < this.f51246e) {
                    I();
                }
                int i10 = (this.f51251j + 1) % 3;
                this.f51251j = i10;
                int i11 = i6 + 1;
                int i12 = bArr[i6];
                if (i12 < 0) {
                    i12 += 256;
                }
                int i13 = (this.f51253l << 8) + i12;
                this.f51253l = i13;
                if (i10 == 0) {
                    byte[] bArr3 = this.f51247f;
                    int i14 = this.f51248g;
                    int i15 = i14 + 1;
                    this.f51248g = i15;
                    byte[] bArr4 = this.f51242a;
                    bArr3[i14] = bArr4[(i13 >> 18) & 63];
                    int i16 = i14 + 2;
                    this.f51248g = i16;
                    bArr3[i15] = bArr4[(i13 >> 12) & 63];
                    int i17 = i14 + 3;
                    this.f51248g = i17;
                    bArr3[i16] = bArr4[(i13 >> 6) & 63];
                    int i18 = i14 + 4;
                    this.f51248g = i18;
                    bArr3[i17] = bArr4[i13 & 63];
                    int i19 = this.f51250i + 4;
                    this.f51250i = i19;
                    int i20 = this.f51243b;
                    if (i20 > 0 && i20 <= i19) {
                        byte[] bArr5 = this.f51244c;
                        System.arraycopy(bArr5, 0, bArr3, i18, bArr5.length);
                        this.f51248g += this.f51244c.length;
                        this.f51250i = 0;
                    }
                }
                i9++;
                i6 = i11;
            }
            return;
        }
        this.f51252k = true;
        byte[] bArr6 = this.f51247f;
        if (bArr6 == null || bArr6.length - this.f51248g < this.f51246e) {
            I();
        }
        int i21 = this.f51251j;
        if (i21 == 1) {
            byte[] bArr7 = this.f51247f;
            int i22 = this.f51248g;
            int i23 = i22 + 1;
            this.f51248g = i23;
            byte[] bArr8 = this.f51242a;
            int i24 = this.f51253l;
            bArr7[i22] = bArr8[(i24 >> 2) & 63];
            int i25 = i22 + 2;
            this.f51248g = i25;
            bArr7[i23] = bArr8[(i24 << 4) & 63];
            if (bArr8 == f51236r) {
                int i26 = i22 + 3;
                this.f51248g = i26;
                bArr7[i25] = 61;
                this.f51248g = i22 + 4;
                bArr7[i26] = 61;
            }
        } else if (i21 == 2) {
            byte[] bArr9 = this.f51247f;
            int i27 = this.f51248g;
            int i28 = i27 + 1;
            this.f51248g = i28;
            byte[] bArr10 = this.f51242a;
            int i29 = this.f51253l;
            bArr9[i27] = bArr10[(i29 >> 10) & 63];
            int i30 = i27 + 2;
            this.f51248g = i30;
            bArr9[i28] = bArr10[(i29 >> 4) & 63];
            int i31 = i27 + 3;
            this.f51248g = i31;
            bArr9[i30] = bArr10[(i29 << 2) & 63];
            if (bArr10 == f51236r) {
                this.f51248g = i27 + 4;
                bArr9[i31] = 61;
            }
        }
        if (this.f51243b <= 0 || (i8 = this.f51248g) <= 0) {
            return;
        }
        byte[] bArr11 = this.f51244c;
        System.arraycopy(bArr11, 0, this.f51247f, i8, bArr11.length);
        this.f51248g += this.f51244c.length;
    }

    int y() {
        return this.f51243b;
    }

    byte[] z() {
        return (byte[]) this.f51244c.clone();
    }

    public a(int i6) {
        this(i6, f51234p);
    }

    static byte[] K(BigInteger bigInteger) {
        int bitLength = ((bigInteger.bitLength() + 7) >> 3) << 3;
        byte[] byteArray = bigInteger.toByteArray();
        int i6 = 1;
        if (bigInteger.bitLength() % 8 != 0 && (bigInteger.bitLength() / 8) + 1 == bitLength / 8) {
            return byteArray;
        }
        int length = byteArray.length;
        if (bigInteger.bitLength() % 8 == 0) {
            length--;
        } else {
            i6 = 0;
        }
        int i7 = bitLength / 8;
        int i8 = i7 - length;
        byte[] bArr = new byte[i7];
        System.arraycopy(byteArray, i6, bArr, i8, length);
        return bArr;
    }

    public static byte[] m(byte[] bArr, boolean z5, boolean z6) {
        return n(bArr, z5, z6, Integer.MAX_VALUE);
    }

    public static String q(byte[] bArr, boolean z5) {
        return F(l(bArr, z5));
    }

    public byte[] d(String str) {
        return e(w(str));
    }

    public byte[] e(byte[] bArr) {
        H();
        if (bArr != null && bArr.length != 0) {
            J(new byte[r1], 0, r1);
            c(bArr, 0, bArr.length);
            c(bArr, 0, -1);
            int i6 = this.f51248g;
            byte[] bArr2 = new byte[i6];
            G(bArr2, 0, i6);
            return bArr2;
        }
        return bArr;
    }

    public byte[] j(byte[] bArr) {
        int i6;
        H();
        if (bArr != null && bArr.length != 0) {
            int x5 = (int) x(bArr, this.f51243b, this.f51244c);
            byte[] bArr2 = new byte[x5];
            J(bArr2, 0, x5);
            i(bArr, 0, bArr.length);
            i(bArr, 0, -1);
            if (this.f51247f != bArr2) {
                G(bArr2, 0, x5);
            }
            if (D() && (i6 = this.f51248g) < x5) {
                byte[] bArr3 = new byte[i6];
                System.arraycopy(bArr2, 0, bArr3, 0, i6);
                return bArr3;
            }
            return bArr2;
        }
        return bArr;
    }

    public String v(byte[] bArr) {
        return F(j(bArr));
    }

    public a(int i6, byte[] bArr) {
        this(i6, bArr, false);
    }

    public a(int i6, byte[] bArr, boolean z5) {
        if (bArr == null) {
            bArr = f51235q;
            i6 = 0;
        }
        this.f51243b = i6 > 0 ? (i6 / 4) * 4 : 0;
        byte[] bArr2 = new byte[bArr.length];
        this.f51244c = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        if (i6 > 0) {
            this.f51246e = bArr.length + 4;
        } else {
            this.f51246e = 4;
        }
        this.f51245d = this.f51246e - 1;
        if (!b(bArr)) {
            this.f51242a = z5 ? f51237s : f51236r;
            return;
        }
        throw new IllegalArgumentException("lineSeperator must not contain base64 characters: [" + F(bArr) + "]");
    }
}
