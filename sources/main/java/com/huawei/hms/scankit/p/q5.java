package com.huawei.hms.scankit.p;

import com.google.common.primitives.SignedBytes;
import com.huawei.hms.hmsscankit.WriterException;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import okio.Utf8;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class q5 {

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f34711c;

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f34709a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, HttpConstants.COMMA, HttpConstants.COLON, BinaryMemcacheOpcodes.GATK, 45, 46, BinaryMemcacheOpcodes.GATKQ, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0};

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f34710b = {HttpConstants.SEMICOLON, 60, 62, SignedBytes.MAX_POWER_OF_TWO, 91, 92, 93, 95, 96, 126, BinaryMemcacheOpcodes.SASL_AUTH, 13, 9, HttpConstants.COMMA, HttpConstants.COLON, 10, 45, 46, BinaryMemcacheOpcodes.GATKQ, 47, 34, 124, 42, 40, 41, Utf8.REPLACEMENT_BYTE, 123, 125, 39, 0};

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f34712d = new byte[128];

    /* renamed from: e, reason: collision with root package name */
    private static final Charset f34713e = StandardCharsets.ISO_8859_1;

    private static boolean a(char c6) {
        if (c6 != ' ') {
            return c6 >= 'a' && c6 <= 'z';
        }
        return true;
    }

    private static boolean b(char c6) {
        if (c6 != ' ') {
            return c6 >= 'A' && c6 <= 'Z';
        }
        return true;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f34714a;

        static {
            int[] iArr = new int[y0.values().length];
            f34714a = iArr;
            try {
                iArr[y0.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34714a[y0.BYTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f34714a[y0.NUMERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        byte[] bArr = new byte[128];
        f34711c = bArr;
        Arrays.fill(bArr, (byte) -1);
        int i6 = 0;
        int i7 = 0;
        while (true) {
            byte[] bArr2 = f34709a;
            if (i7 >= bArr2.length) {
                break;
            }
            byte b6 = bArr2[i7];
            if (b6 > 0) {
                f34711c[b6] = (byte) i7;
            }
            i7++;
        }
        Arrays.fill(f34712d, (byte) -1);
        while (true) {
            byte[] bArr3 = f34710b;
            if (i6 >= bArr3.length) {
                return;
            }
            byte b7 = bArr3[i6];
            if (b7 > 0) {
                f34712d[b7] = (byte) i6;
            }
            i6++;
        }
    }

    static String a(String str, y0 y0Var, Charset charset) throws WriterException {
        StringBuilder sb = new StringBuilder(str.length());
        if (charset == null) {
            charset = f34713e;
        } else if (f34713e.equals(charset)) {
            o4.a("PDF417", "else");
        } else {
            o0 a6 = o0.a(charset.name());
            if (a6 != null) {
                a(a6.a(), sb);
            }
        }
        int length = str.length();
        int i6 = a.f34714a[y0Var.ordinal()];
        if (i6 == 1) {
            a(str, 0, length, sb, 0);
        } else if (i6 == 2) {
            byte[] bytes = str.getBytes(charset);
            a(bytes, 0, bytes.length, 1, sb);
        } else if (i6 != 3) {
            int i7 = 0;
            int i8 = 0;
            loop0: while (true) {
                int i9 = 0;
                while (i7 < length) {
                    int a7 = a(str, i7);
                    if (a7 >= 13) {
                        sb.append((char) 902);
                        a(str, i7, a7, sb);
                        i7 += a7;
                        i8 = 2;
                    } else {
                        int b6 = b(str, i7);
                        if (b6 >= 5 || a7 == length) {
                            if (i8 != 0) {
                                sb.append((char) 900);
                                i8 = 0;
                                i9 = 0;
                            }
                            i9 = a(str, i7, b6, sb, i9);
                            i7 += b6;
                        } else {
                            int a8 = a(str, i7, charset);
                            if (a8 == 0) {
                                a8 = 1;
                            }
                            int i10 = a8 + i7;
                            byte[] bytes2 = str.substring(i7, i10).getBytes(charset);
                            if (bytes2.length == 1 && i8 == 0) {
                                a(bytes2, 0, 1, 0, sb);
                                i7 = i10;
                            } else {
                                a(bytes2, 0, bytes2.length, i8, sb);
                                i7 = i10;
                                i8 = 1;
                            }
                        }
                    }
                }
                break loop0;
            }
        } else {
            sb.append((char) 902);
            a(str, 0, length, sb);
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0027, code lost:
    
        return (r1 - r7) - r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int b(java.lang.CharSequence r6, int r7) {
        /*
            int r0 = r6.length()
            r1 = r7
        L5:
            if (r1 >= r0) goto L39
            char r2 = r6.charAt(r1)
            r3 = 0
        Lc:
            r4 = 13
            if (r3 >= r4) goto L23
            boolean r5 = c(r2)
            if (r5 == 0) goto L23
            if (r1 >= r0) goto L23
            int r3 = r3 + 1
            int r1 = r1 + 1
            if (r1 >= r0) goto Lc
            char r2 = r6.charAt(r1)
            goto Lc
        L23:
            if (r3 < r4) goto L28
            int r1 = r1 - r7
            int r1 = r1 - r3
            return r1
        L28:
            if (r3 <= 0) goto L2b
            goto L5
        L2b:
            char r2 = r6.charAt(r1)
            boolean r2 = f(r2)
            if (r2 != 0) goto L36
            goto L39
        L36:
            int r1 = r1 + 1
            goto L5
        L39:
            int r1 = r1 - r7
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.q5.b(java.lang.CharSequence, int):int");
    }

    private static boolean c(char c6) {
        return c6 >= '0' && c6 <= '9';
    }

    private static boolean d(char c6) {
        byte[] bArr = f34711c;
        if (w7.a(bArr, (int) c6)) {
            return bArr[c6] != -1;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    private static boolean e(char c6) {
        if (w7.a(f34711c, (int) c6)) {
            return f34712d[c6] != -1;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    private static boolean f(char c6) {
        if (c6 == '\t' || c6 == '\n' || c6 == '\r') {
            return true;
        }
        return c6 >= ' ' && c6 <= '~';
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00f4 A[EDGE_INSN: B:21:0x00f4->B:22:0x00f4 BREAK  A[LOOP:0: B:2:0x000f->B:16:0x000f], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x000f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(java.lang.CharSequence r16, int r17, int r18, java.lang.StringBuilder r19, int r20) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.q5.a(java.lang.CharSequence, int, int, java.lang.StringBuilder, int):int");
    }

    private static void a(byte[] bArr, int i6, int i7, int i8, StringBuilder sb) {
        int i9;
        if (i7 == 1 && i8 == 0) {
            sb.append((char) 913);
        } else if (i7 % 6 == 0) {
            sb.append((char) 924);
        } else {
            sb.append((char) 901);
        }
        if (i7 >= 6) {
            char[] cArr = new char[5];
            i9 = i6;
            while ((i6 + i7) - i9 >= 6) {
                long j6 = 0;
                for (int i10 = 0; i10 < 6; i10++) {
                    j6 = (j6 << 8) + (bArr[i9 + i10] & 255);
                }
                for (int i11 = 0; i11 < 5; i11++) {
                    cArr[i11] = (char) (j6 % 900);
                    j6 /= 900;
                }
                for (int i12 = 4; i12 >= 0; i12--) {
                    sb.append(cArr[i12]);
                }
                i9 += 6;
            }
        } else {
            i9 = i6;
        }
        while (i9 < i6 + i7) {
            sb.append((char) (bArr[i9] & 255));
            i9++;
        }
    }

    private static void a(String str, int i6, int i7, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder((i7 / 3) + 1);
        BigInteger valueOf = BigInteger.valueOf(900L);
        BigInteger valueOf2 = BigInteger.valueOf(0L);
        int i8 = 0;
        while (i8 < i7) {
            sb2.setLength(0);
            int min = Math.min(44, i7 - i8);
            if (str.length() > 0) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append('1');
                int i9 = i6 + i8;
                sb3.append(str.substring(i9, i9 + min));
                BigInteger bigInteger = new BigInteger(sb3.toString());
                do {
                    sb2.append((char) bigInteger.mod(valueOf).intValue());
                    bigInteger = bigInteger.divide(valueOf);
                } while (!bigInteger.equals(valueOf2));
            }
            for (int length = sb2.length() - 1; length >= 0; length--) {
                sb.append(sb2.charAt(length));
            }
            i8 += min;
        }
    }

    private static int a(CharSequence charSequence, int i6) {
        return d4.a(charSequence, i6);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0029, code lost:
    
        return r1 - r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(java.lang.String r5, int r6, java.nio.charset.Charset r7) throws com.huawei.hms.hmsscankit.WriterException {
        /*
            java.nio.charset.CharsetEncoder r7 = r7.newEncoder()
            int r0 = r5.length()
            r1 = r6
        L9:
            if (r1 >= r0) goto L5b
            char r2 = r5.charAt(r1)
            r3 = 0
        L10:
            r4 = 13
            if (r3 >= r4) goto L26
            boolean r2 = c(r2)
            if (r2 == 0) goto L26
            int r3 = r3 + 1
            int r2 = r1 + r3
            if (r2 < r0) goto L21
            goto L26
        L21:
            char r2 = r5.charAt(r2)
            goto L10
        L26:
            if (r3 < r4) goto L2a
            int r1 = r1 - r6
            return r1
        L2a:
            char r2 = r5.charAt(r1)
            boolean r3 = r7.canEncode(r2)
            if (r3 == 0) goto L37
            int r1 = r1 + 1
            goto L9
        L37:
            com.huawei.hms.hmsscankit.WriterException r5 = new com.huawei.hms.hmsscankit.WriterException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Non-encodable character detected: "
            r6.append(r7)
            r6.append(r2)
            java.lang.String r7 = " (Unicode: "
            r6.append(r7)
            r6.append(r2)
            r7 = 41
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L5b:
            int r1 = r1 - r6
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.q5.a(java.lang.String, int, java.nio.charset.Charset):int");
    }

    private static void a(int i6, StringBuilder sb) throws WriterException {
        if (i6 >= 0 && i6 < 900) {
            sb.append((char) 927);
            sb.append((char) i6);
            return;
        }
        if (i6 < 810900) {
            sb.append((char) 926);
            sb.append((char) ((i6 / 900) - 1));
            sb.append((char) (i6 % 900));
        } else if (i6 < 811800) {
            sb.append((char) 925);
            sb.append((char) (810900 - i6));
        } else {
            throw new WriterException("ECI number not in valid range from 0..811799, but was " + i6);
        }
    }
}
