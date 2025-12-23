package com.amap.api.col.p0003l;

import com.google.common.base.Ascii;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import okio.Utf8;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class j5 {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f6628a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f6629b = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, HttpConstants.COLON, HttpConstants.SEMICOLON, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, Ascii.ESC, 28, 29, 30, Ascii.US, 32, BinaryMemcacheOpcodes.SASL_AUTH, 34, BinaryMemcacheOpcodes.GATK, BinaryMemcacheOpcodes.GATKQ, 37, 38, 39, 40, 41, 42, 43, HttpConstants.COMMA, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f6630c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f6631d = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, HttpConstants.COLON, HttpConstants.SEMICOLON, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, Utf8.REPLACEMENT_BYTE, -9, 26, Ascii.ESC, 28, 29, 30, Ascii.US, 32, BinaryMemcacheOpcodes.SASL_AUTH, 34, BinaryMemcacheOpcodes.GATK, BinaryMemcacheOpcodes.GATKQ, 37, 38, 39, 40, 41, 42, 43, HttpConstants.COMMA, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: e, reason: collision with root package name */
    private static final byte[] f6632e = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};

    /* renamed from: f, reason: collision with root package name */
    private static final byte[] f6633f = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, Ascii.ESC, 28, 29, 30, Ascii.US, 32, BinaryMemcacheOpcodes.SASL_AUTH, 34, BinaryMemcacheOpcodes.GATK, BinaryMemcacheOpcodes.GATKQ, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, HttpConstants.COMMA, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, HttpConstants.COLON, HttpConstants.SEMICOLON, 60, 61, 62, Utf8.REPLACEMENT_BYTE, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: g, reason: collision with root package name */
    static final /* synthetic */ boolean f6634g = true;

    public static String a(byte[] bArr) {
        String str;
        try {
            str = b(bArr, bArr.length);
        } catch (IOException e6) {
            if (!f6634g) {
                throw new AssertionError(e6.getMessage());
            }
            str = null;
        }
        if (f6634g || str != null) {
            return str;
        }
        throw new AssertionError();
    }

    private static String b(byte[] bArr, int i6) throws IOException {
        if (bArr == null) {
            throw new NullPointerException("Cannot serialize a null array.");
        }
        if (i6 < 0) {
            throw new IllegalArgumentException("Cannot have length offset: ".concat(String.valueOf(i6)));
        }
        if (i6 > bArr.length) {
            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", 0, Integer.valueOf(i6), Integer.valueOf(bArr.length)));
        }
        int i7 = ((i6 / 3) * 4) + (i6 % 3 <= 0 ? 0 : 4);
        byte[] bArr2 = new byte[i7];
        int i8 = i6 - 2;
        int i9 = 0;
        int i10 = 0;
        while (i9 < i8) {
            d(bArr, i9, 3, bArr2, i10);
            i9 += 3;
            i10 += 4;
        }
        if (i9 < i6) {
            d(bArr, i9, i6 - i9, bArr2, i10);
            i10 += 4;
        }
        if (i10 <= i7 - 1) {
            byte[] bArr3 = new byte[i10];
            System.arraycopy(bArr2, 0, bArr3, 0, i10);
            bArr2 = bArr3;
        }
        try {
            return new String(bArr2, "US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr2);
        }
    }

    private static byte[] d(byte[] bArr, int i6, int i7, byte[] bArr2, int i8) {
        byte[] bArr3 = f6628a;
        int i9 = (i7 > 0 ? (bArr[i6] << 24) >>> 8 : 0) | (i7 > 1 ? (bArr[i6 + 1] << 24) >>> 16 : 0) | (i7 > 2 ? (bArr[i6 + 2] << 24) >>> 24 : 0);
        if (i7 == 1) {
            bArr2[i8] = bArr3[i9 >>> 18];
            bArr2[i8 + 1] = bArr3[(i9 >>> 12) & 63];
            bArr2[i8 + 2] = 61;
            bArr2[i8 + 3] = 61;
            return bArr2;
        }
        if (i7 == 2) {
            bArr2[i8] = bArr3[i9 >>> 18];
            bArr2[i8 + 1] = bArr3[(i9 >>> 12) & 63];
            bArr2[i8 + 2] = bArr3[(i9 >>> 6) & 63];
            bArr2[i8 + 3] = 61;
            return bArr2;
        }
        if (i7 != 3) {
            return bArr2;
        }
        bArr2[i8] = bArr3[i9 >>> 18];
        bArr2[i8 + 1] = bArr3[(i9 >>> 12) & 63];
        bArr2[i8 + 2] = bArr3[(i9 >>> 6) & 63];
        bArr2[i8 + 3] = bArr3[i9 & 63];
        return bArr2;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:30:0x0055
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    private static byte[] e(java.lang.String r6) throws java.io.IOException {
        /*
            if (r6 == 0) goto L84
            java.lang.String r0 = "US-ASCII"
            byte[] r6 = r6.getBytes(r0)     // Catch: java.io.UnsupportedEncodingException -> L9
            goto Ld
        L9:
            byte[] r6 = r6.getBytes()
        Ld:
            int r0 = r6.length
            byte[] r6 = f(r6, r0)
            int r0 = r6.length
            r1 = 4
            if (r0 < r1) goto L83
            r0 = 0
            r1 = r6[r0]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = 1
            r2 = r6[r2]
            int r2 = r2 << 8
            r3 = 65280(0xff00, float:9.1477E-41)
            r2 = r2 & r3
            r1 = r1 | r2
            r2 = 35615(0x8b1f, float:4.9907E-41)
            if (r2 != r1) goto L83
            r1 = 2048(0x800, float:2.87E-42)
            byte[] r1 = new byte[r1]
            r2 = 0
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6e
            r3.<init>()     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6e
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L66
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L66
            java.util.zip.GZIPInputStream r5 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5f
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5f
        L3e:
            int r2 = r5.read(r1)     // Catch: java.lang.Throwable -> L48 java.io.IOException -> L4b
            if (r2 < 0) goto L4e
            r3.write(r1, r0, r2)     // Catch: java.lang.Throwable -> L48 java.io.IOException -> L4b
            goto L3e
        L48:
            r6 = move-exception
        L49:
            r2 = r3
            goto L79
        L4b:
            r0 = move-exception
        L4c:
            r2 = r3
            goto L71
        L4e:
            byte[] r6 = r3.toByteArray()     // Catch: java.lang.Throwable -> L48 java.io.IOException -> L4b
            r3.close()     // Catch: java.lang.Exception -> L55
        L55:
            r5.close()     // Catch: java.lang.Exception -> L58
        L58:
            r4.close()     // Catch: java.lang.Exception -> L83
            goto L83
        L5c:
            r6 = move-exception
            r5 = r2
            goto L49
        L5f:
            r0 = move-exception
            r5 = r2
            goto L4c
        L62:
            r6 = move-exception
            r4 = r2
            r5 = r4
            goto L49
        L66:
            r0 = move-exception
            r4 = r2
            r5 = r4
            goto L4c
        L6a:
            r6 = move-exception
            r4 = r2
            r5 = r4
            goto L79
        L6e:
            r0 = move-exception
            r4 = r2
            r5 = r4
        L71:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L78
            r2.close()     // Catch: java.lang.Exception -> L55
            goto L55
        L78:
            r6 = move-exception
        L79:
            r2.close()     // Catch: java.lang.Exception -> L7c
        L7c:
            r5.close()     // Catch: java.lang.Exception -> L7f
        L7f:
            r4.close()     // Catch: java.lang.Exception -> L82
        L82:
            throw r6
        L83:
            return r6
        L84:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException
            java.lang.String r0 = "Input string was null."
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.j5.e(java.lang.String):byte[]");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0114 A[EDGE_INSN: B:31:0x0114->B:32:0x0114 BREAK  A[LOOP:0: B:12:0x0021->B:30:0x00e9], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] f(byte[] r19, int r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.j5.f(byte[], int):byte[]");
    }

    private j5() {
    }

    public static byte[] c(String str) throws IOException {
        return e(str);
    }
}
