package com.kwad.sdk.core.a;

import android.text.TextUtils;
import java.nio.charset.Charset;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    private static final Charset ISO_8859_1 = Charset.forName(org.apache.commons.net.ftp.b.T);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {
        private static final int[] fromBase64;
        private final boolean isMIME;
        private final boolean isURL;
        static final a aDM = new a(false, false);
        static final a aDN = new a(true, false);
        static final a aDO = new a(false, true);
        private static final int[] fromBase64URL = new int[256];

        public final byte[] decode(byte[] bArr) {
            int outLength = outLength(bArr, 0, bArr.length);
            byte[] bArr2 = new byte[outLength];
            int decode0 = decode0(bArr, 0, bArr.length, bArr2);
            return decode0 != outLength ? Arrays.copyOf(bArr2, decode0) : bArr2;
        }

        static {
            int[] iArr = new int[256];
            fromBase64 = iArr;
            Arrays.fill(iArr, -1);
            for (int i6 = 0; i6 < b.toBase64.length; i6++) {
                fromBase64[b.toBase64[i6]] = i6;
            }
            fromBase64[61] = -2;
            Arrays.fill(fromBase64URL, -1);
            for (int i7 = 0; i7 < b.toBase64URL.length; i7++) {
                fromBase64URL[b.toBase64URL[i7]] = i7;
            }
            fromBase64URL[61] = -2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x002c, code lost:
        
            if (r12[r8] == 61) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0030, code lost:
        
            if (r4 != 18) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x007b, code lost:
        
            if (r4 != 6) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x007d, code lost:
        
            r15[r5] = (byte) (r3 >> 16);
            r5 = r5 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x009b, code lost:
        
            if (r13 >= r14) goto L57;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x009f, code lost:
        
            if (r11.isMIME == false) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00a1, code lost:
        
            r15 = r13 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00a7, code lost:
        
            if (r0[r12[r13]] >= 0) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00a9, code lost:
        
            r13 = r15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00ab, code lost:
        
            r13 = r15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00bf, code lost:
        
            throw new java.lang.IllegalArgumentException("Input byte array has incorrect ending byte at " + r13);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00c0, code lost:
        
            return r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0086, code lost:
        
            if (r4 != 0) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0088, code lost:
        
            r1 = r5 + 1;
            r15[r5] = (byte) (r3 >> 16);
            r5 = r5 + 2;
            r15[r1] = (byte) (r3 >> 8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0099, code lost:
        
            if (r4 == 12) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00c8, code lost:
        
            throw new java.lang.IllegalArgumentException("Last unit does not have enough valid bits");
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private int decode0(byte[] r12, int r13, int r14, byte[] r15) {
            /*
                Method dump skipped, instructions count: 201
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.a.c.a.decode0(byte[], int, int, byte[]):int");
        }

        private int outLength(byte[] bArr, int i6, int i7) {
            int i8;
            int[] iArr = this.isURL ? fromBase64URL : fromBase64;
            int i9 = 0;
            if (i7 == 0) {
                return 0;
            }
            if (i7 < 2) {
                if (this.isMIME && iArr[0] == -1) {
                    return 0;
                }
                throw new IllegalArgumentException("Input byte[] should at least have 2 bytes for base64 bytes");
            }
            if (this.isMIME) {
                int i10 = 0;
                while (true) {
                    if (i6 >= i7) {
                        break;
                    }
                    int i11 = i6 + 1;
                    int i12 = bArr[i6] & 255;
                    if (i12 == 61) {
                        i7 -= (i7 - i11) + 1;
                        break;
                    }
                    if (iArr[i12] == -1) {
                        i10++;
                    }
                    i6 = i11;
                }
                i7 -= i10;
            } else if (bArr[i7 - 1] == 61) {
                i9 = bArr[i7 + (-2)] == 61 ? 2 : 1;
            }
            if (i9 == 0 && (i8 = i7 & 3) != 0) {
                i9 = 4 - i8;
            }
            return (((i7 + 3) / 4) * 3) - i9;
        }

        private a(boolean z5, boolean z6) {
            this.isURL = z5;
            this.isMIME = z6;
        }

        public final byte[] decode(String str) {
            return decode(str.getBytes(c.ISO_8859_1));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b {
        static final b aDP = new b(false, null, -1, true);
        static final b aDQ = new b(true, null, -1, false);
        private static final char[] toBase64 = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        private static final char[] toBase64URL = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'};
        private final boolean doPadding;
        private final boolean isURL;
        private final byte[] newline = null;
        private final int linemax = -1;

        public final byte[] encode(byte[] bArr) {
            int outLength = outLength(bArr.length);
            byte[] bArr2 = new byte[outLength];
            int encode0 = encode0(bArr, 0, bArr.length, bArr2);
            return encode0 != outLength ? Arrays.copyOf(bArr2, encode0) : bArr2;
        }

        private int encode0(byte[] bArr, int i6, int i7, byte[] bArr2) {
            char[] cArr = this.isURL ? toBase64URL : toBase64;
            int i8 = (i7 / 3) * 3;
            int i9 = this.linemax;
            int i10 = (i9 <= 0 || i8 <= (i9 / 4) * 3) ? i8 : (i9 / 4) * 3;
            int i11 = 0;
            int i12 = 0;
            while (i11 < i8) {
                int min = Math.min(i11 + i10, i8);
                int i13 = i11;
                int i14 = i12;
                while (i13 < min) {
                    int i15 = i13 + 2;
                    int i16 = ((bArr[i13 + 1] & 255) << 8) | ((bArr[i13] & 255) << 16);
                    i13 += 3;
                    int i17 = i16 | (bArr[i15] & 255);
                    bArr2[i14] = (byte) cArr[(i17 >>> 18) & 63];
                    bArr2[i14 + 1] = (byte) cArr[(i17 >>> 12) & 63];
                    int i18 = i14 + 3;
                    bArr2[i14 + 2] = (byte) cArr[(i17 >>> 6) & 63];
                    i14 += 4;
                    bArr2[i18] = (byte) cArr[i17 & 63];
                }
                int i19 = ((min - i11) / 3) * 4;
                i12 += i19;
                if (i19 == this.linemax && min < i7) {
                    byte[] bArr3 = this.newline;
                    int length = bArr3.length;
                    int i20 = 0;
                    while (i20 < length) {
                        bArr2[i12] = bArr3[i20];
                        i20++;
                        i12++;
                    }
                }
                i11 = min;
            }
            if (i11 >= i7) {
                return i12;
            }
            int i21 = i11 + 1;
            int i22 = bArr[i11] & 255;
            int i23 = i12 + 1;
            bArr2[i12] = (byte) cArr[i22 >> 2];
            if (i21 == i7) {
                int i24 = i12 + 2;
                bArr2[i23] = (byte) cArr[(i22 << 4) & 63];
                if (!this.doPadding) {
                    return i24;
                }
                int i25 = i12 + 3;
                bArr2[i24] = 61;
                int i26 = i12 + 4;
                bArr2[i25] = 61;
                return i26;
            }
            int i27 = bArr[i21] & 255;
            bArr2[i23] = (byte) cArr[((i22 << 4) & 63) | (i27 >> 4)];
            int i28 = i12 + 3;
            bArr2[i12 + 2] = (byte) cArr[(i27 << 2) & 63];
            if (!this.doPadding) {
                return i28;
            }
            int i29 = i12 + 4;
            bArr2[i28] = 61;
            return i29;
        }

        private final int outLength(int i6) {
            int i7;
            if (this.doPadding) {
                i7 = ((i6 + 2) / 3) * 4;
            } else {
                int i8 = i6 % 3;
                i7 = ((i6 / 3) * 4) + (i8 == 0 ? 0 : i8 + 1);
            }
            int i9 = this.linemax;
            return i9 > 0 ? i7 + (((i7 - 1) / i9) * this.newline.length) : i7;
        }

        private b(boolean z5, byte[] bArr, int i6, boolean z6) {
            this.isURL = z5;
            this.doPadding = z6;
        }

        public final String encodeToString(byte[] bArr) {
            byte[] encode = encode(bArr);
            return new String(encode, 0, 0, encode.length);
        }
    }

    public static b Hf() {
        return b.aDP;
    }

    public static b Hg() {
        return b.aDQ;
    }

    public static a Hh() {
        return a.aDM;
    }

    public static a Hi() {
        return a.aDO;
    }

    public static a Hj() {
        return a.aDN;
    }

    public static String decodeKsSdk(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith("sDAkk/dS")) {
            return new String(Hh().decode(str.substring(8)), com.kwad.sdk.crash.utils.a.UTF_8);
        }
        return str;
    }

    public static String encodeKsSdk(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "sDAkk/dS" + new String(Hf().encode(str.getBytes()), com.kwad.sdk.crash.utils.a.UTF_8);
    }

    public static boolean isEncodeKsSdk(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("sDAkk/dS");
    }
}
