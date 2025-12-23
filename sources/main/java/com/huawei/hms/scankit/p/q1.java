package com.huawei.hms.scankit.p;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class q1 {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f34693a = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f34694b = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();

    /* renamed from: c, reason: collision with root package name */
    private static final BigInteger[] f34695c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum b {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    private static boolean a(int i6) {
        return i6 == 901 || i6 == 924 || i6 == 902 || i6 == 928 || i6 == 923 || i6 == 922;
    }

    private static int b(int[] iArr, int i6, StringBuilder sb) throws com.huawei.hms.scankit.p.a {
        int i7 = iArr[0];
        int[] iArr2 = new int[(i7 - i6) * 2];
        int[] iArr3 = new int[(i7 - i6) * 2];
        boolean z5 = false;
        int i8 = 0;
        while (i6 < iArr[0] && !z5) {
            int i9 = i6 + 1;
            int i10 = iArr[i6];
            if (i10 < 900) {
                iArr2[i8] = i10 / 30;
                iArr2[i8 + 1] = i10 % 30;
                i8 += 2;
            } else if (i10 == 900) {
                iArr2[i8] = 900;
                i8++;
            } else if (i10 == 913) {
                iArr2[i8] = 913;
                i6 += 2;
                iArr3[i8] = iArr[i9];
                i8++;
            } else {
                if (!a(i10)) {
                    throw com.huawei.hms.scankit.p.a.a();
                }
                z5 = true;
            }
            i6 = i9;
        }
        a(iArr2, iArr3, i8, sb);
        return i6;
    }

    private static b[] c(StringBuilder sb, int[] iArr, b bVar, b bVar2, int[] iArr2) throws com.huawei.hms.scankit.p.a {
        b bVar3;
        int i6 = iArr2[1];
        if (i6 < 26) {
            iArr2[2] = (char) (i6 + 97);
        } else if (i6 == 900) {
            bVar = b.ALPHA;
        } else if (i6 != 913) {
            switch (i6) {
                case 26:
                    iArr2[2] = 32;
                    break;
                case 27:
                    bVar3 = b.ALPHA_SHIFT;
                    bVar2 = bVar;
                    bVar = bVar3;
                    break;
                case 28:
                    bVar = b.MIXED;
                    break;
                case 29:
                    bVar3 = b.PUNCT_SHIFT;
                    bVar2 = bVar;
                    bVar = bVar3;
                    break;
                default:
                    throw com.huawei.hms.scankit.p.a.a();
            }
        } else {
            sb.append((char) iArr[iArr2[0]]);
        }
        return new b[]{bVar, bVar2};
    }

    private static b[] d(StringBuilder sb, int[] iArr, b bVar, b bVar2, int[] iArr2) throws com.huawei.hms.scankit.p.a {
        int i6 = iArr2[1];
        if (i6 < 25) {
            iArr2[2] = f34694b[i6];
        } else {
            if (i6 != 900) {
                if (i6 != 913) {
                    switch (i6) {
                        case 25:
                            bVar = b.PUNCT;
                            break;
                        case 26:
                            iArr2[2] = 32;
                            break;
                        case 27:
                            bVar = b.LOWER;
                            break;
                        case 28:
                            break;
                        case 29:
                            bVar2 = bVar;
                            bVar = b.PUNCT_SHIFT;
                            break;
                        default:
                            throw com.huawei.hms.scankit.p.a.a();
                    }
                } else {
                    sb.append((char) iArr[iArr2[0]]);
                }
            }
            bVar = b.ALPHA;
        }
        return new b[]{bVar, bVar2};
    }

    private static b[] e(StringBuilder sb, int[] iArr, b bVar, b bVar2, int[] iArr2) throws com.huawei.hms.scankit.p.a {
        int i6 = iArr2[1];
        if (i6 < 29) {
            iArr2[2] = f34693a[i6];
        } else if (i6 == 29 || i6 == 900) {
            bVar = b.ALPHA;
        } else {
            if (i6 != 913) {
                throw com.huawei.hms.scankit.p.a.a();
            }
            sb.append((char) iArr[iArr2[0]]);
        }
        return new b[]{bVar, bVar2};
    }

    private static b[] f(StringBuilder sb, int[] iArr, b bVar, b bVar2, int[] iArr2) throws com.huawei.hms.scankit.p.a {
        b bVar3;
        int i6 = iArr2[1];
        if (i6 < 29) {
            iArr2[2] = f34693a[i6];
        } else {
            if (i6 == 29 || i6 == 900) {
                bVar3 = b.ALPHA;
                return new b[]{bVar3, bVar2};
            }
            if (i6 != 913) {
                throw com.huawei.hms.scankit.p.a.a();
            }
            sb.append((char) iArr[iArr2[0]]);
        }
        bVar3 = bVar2;
        return new b[]{bVar3, bVar2};
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f34696a;

        static {
            int[] iArr = new int[b.values().length];
            f34696a = iArr;
            try {
                iArr[b.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34696a[b.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f34696a[b.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f34696a[b.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f34696a[b.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f34696a[b.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        f34695c = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = valueOf;
        int i6 = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = f34695c;
            if (i6 >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i6] = bigIntegerArr2[i6 - 1].multiply(valueOf);
            i6++;
        }
    }

    static w1 a(int[] iArr, String str, Map<l1, ?> map) throws com.huawei.hms.scankit.p.a {
        int i6;
        int[] iArr2;
        int a6;
        StringBuilder sb = new StringBuilder(iArr.length * 2);
        Charset charset = StandardCharsets.ISO_8859_1;
        int i7 = iArr[1];
        s5 s5Var = new s5();
        Charset charset2 = charset;
        int i8 = i7;
        int i9 = 2;
        while (true) {
            int i10 = iArr[0];
            if (i9 > i10 || (i9 == i10 && sb.length() > 0)) {
                break;
            }
            if (i8 == 927) {
                a6 = i9 + 1;
                charset2 = Charset.forName(o0.a(iArr[i9]).name());
                iArr2 = iArr;
            } else {
                iArr2 = iArr;
                a6 = a(sb, i8, iArr2, i9, charset2, s5Var);
            }
            if (a6 >= iArr2.length) {
                throw com.huawei.hms.scankit.p.a.a();
            }
            i9 = a6 + 1;
            i8 = iArr2[a6];
            iArr = iArr2;
        }
        if (sb.length() == 0) {
            throw com.huawei.hms.scankit.p.a.a();
        }
        if (charset2 != StandardCharsets.ISO_8859_1) {
            w1 w1Var = new w1(null, sb.toString(), null, str);
            w1Var.a(s5Var);
            return w1Var;
        }
        int length = sb.length();
        byte[] bArr = new byte[length];
        for (i6 = 0; i6 < length; i6++) {
            bArr[i6] = (byte) sb.charAt(i6);
        }
        try {
            w1 w1Var2 = new w1(null, new String(bArr, c7.a(bArr, map)), null, str);
            w1Var2.a(s5Var);
            return w1Var2;
        } catch (UnsupportedEncodingException unused) {
            throw com.huawei.hms.scankit.p.a.a();
        }
    }

    private static b[] b(StringBuilder sb, int[] iArr, b bVar, b bVar2, int[] iArr2) throws com.huawei.hms.scankit.p.a {
        b bVar3;
        int i6 = iArr2[1];
        if (i6 < 26) {
            iArr2[2] = (char) (i6 + 65);
        } else {
            if (i6 != 26) {
                if (i6 == 900) {
                    bVar3 = b.ALPHA;
                    return new b[]{bVar3, bVar2};
                }
                throw com.huawei.hms.scankit.p.a.a();
            }
            iArr2[2] = 32;
        }
        bVar3 = bVar2;
        return new b[]{bVar3, bVar2};
    }

    private static int a(StringBuilder sb, int i6, int[] iArr, int i7, Charset charset, s5 s5Var) throws com.huawei.hms.scankit.p.a {
        if (i6 == 913) {
            int i8 = i7 + 1;
            sb.append((char) iArr[i7]);
            return i8;
        }
        if (i6 != 928) {
            switch (i6) {
                case 900:
                    return b(iArr, i7, sb);
                case 901:
                    break;
                case 902:
                    return a(iArr, i7, sb);
                default:
                    switch (i6) {
                        case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_TIMEOUT /* 922 */:
                        case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_MODE /* 923 */:
                            throw com.huawei.hms.scankit.p.a.a();
                        case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_STREAM_FIN_AND_RST /* 924 */:
                            break;
                        case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_VERSION /* 925 */:
                            return i7 + 1;
                        case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_TIMER_VERSION /* 926 */:
                            return i7 + 2;
                        default:
                            return b(iArr, i7 - 1, sb);
                    }
            }
            return a(i6, iArr, charset, i7, sb);
        }
        return a(iArr, i7, s5Var);
    }

    static int a(int[] iArr, int i6, s5 s5Var) throws com.huawei.hms.scankit.p.a {
        int i7 = 0;
        if (i6 + 2 <= iArr[0]) {
            int[] iArr2 = new int[2];
            while (i7 < 2) {
                iArr2[i7] = iArr[i6];
                i7++;
                i6++;
            }
            try {
                s5Var.c(Integer.parseInt(a(iArr2, 2)));
                StringBuilder sb = new StringBuilder();
                int b6 = b(iArr, i6, sb);
                s5Var.b(sb.toString());
                int i8 = iArr[b6] == 923 ? b6 + 1 : -1;
                a(b6, iArr, s5Var);
                if (i8 != -1) {
                    int i9 = b6 - i8;
                    if (s5Var.a()) {
                        i9--;
                    }
                    s5Var.a(Arrays.copyOfRange(iArr, i8, i9 + i8));
                }
                return b6;
            } catch (Exception unused) {
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    private static void a(int i6, int[] iArr, s5 s5Var) throws com.huawei.hms.scankit.p.a {
        while (i6 < iArr[0]) {
            int i7 = iArr[i6];
            if (i7 == 923) {
                int i8 = iArr[i6 + 1];
                if (i8 == 0) {
                    StringBuilder sb = new StringBuilder();
                    i6 = b(iArr, i6 + 2, sb);
                    s5Var.c(sb.toString());
                } else if (i8 == 3) {
                    StringBuilder sb2 = new StringBuilder();
                    i6 = b(iArr, i6 + 2, sb2);
                    s5Var.d(sb2.toString());
                } else if (i8 == 4) {
                    StringBuilder sb3 = new StringBuilder();
                    i6 = b(iArr, i6 + 2, sb3);
                    s5Var.a(sb3.toString());
                } else if (i8 == 1) {
                    StringBuilder sb4 = new StringBuilder();
                    i6 = a(iArr, i6 + 2, sb4);
                    s5Var.b(Integer.parseInt(sb4.toString()));
                } else if (i8 == 2) {
                    StringBuilder sb5 = new StringBuilder();
                    i6 = a(iArr, i6 + 2, sb5);
                    s5Var.b(Long.parseLong(sb5.toString()));
                } else if (i8 == 6) {
                    StringBuilder sb6 = new StringBuilder();
                    i6 = a(iArr, i6 + 2, sb6);
                    s5Var.a(Integer.parseInt(sb6.toString()));
                } else if (i8 == 5) {
                    StringBuilder sb7 = new StringBuilder();
                    i6 = a(iArr, i6 + 2, sb7);
                    s5Var.a(Long.parseLong(sb7.toString()));
                } else {
                    throw com.huawei.hms.scankit.p.a.a();
                }
            } else if (i7 == 922) {
                i6++;
                s5Var.a(true);
            } else {
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
    }

    private static void a(int[] iArr, int[] iArr2, int i6, StringBuilder sb) throws com.huawei.hms.scankit.p.a {
        b bVar = b.ALPHA;
        b bVar2 = bVar;
        int i7 = 0;
        while (i7 < i6) {
            int[] iArr3 = {i7, iArr[i7], 0};
            b[] bVarArr = {bVar, bVar2};
            switch (a.f34696a[bVar.ordinal()]) {
                case 1:
                    bVarArr = a(sb, iArr2, bVar, bVar2, iArr3);
                    break;
                case 2:
                    bVarArr = c(sb, iArr2, bVar, bVar2, iArr3);
                    break;
                case 3:
                    bVarArr = d(sb, iArr2, bVar, bVar2, iArr3);
                    break;
                case 4:
                    bVarArr = e(sb, iArr2, bVar, bVar2, iArr3);
                    break;
                case 5:
                    bVarArr = b(sb, iArr2, bVar, bVar2, iArr3);
                    break;
                case 6:
                    bVarArr = f(sb, iArr2, bVar, bVar2, iArr3);
                    break;
            }
            bVar = bVarArr[0];
            bVar2 = bVarArr[1];
            int i8 = iArr3[0];
            char c6 = (char) iArr3[2];
            if (c6 != 0) {
                sb.append(c6);
            }
            i7 = i8 + 1;
        }
    }

    private static b[] a(StringBuilder sb, int[] iArr, b bVar, b bVar2, int[] iArr2) throws com.huawei.hms.scankit.p.a {
        int i6 = iArr2[1];
        if (i6 < 26) {
            iArr2[2] = (char) (i6 + 65);
        } else if (i6 == 900) {
            bVar = b.ALPHA;
        } else if (i6 != 913) {
            switch (i6) {
                case 26:
                    iArr2[2] = 32;
                    break;
                case 27:
                    bVar = b.LOWER;
                    break;
                case 28:
                    bVar = b.MIXED;
                    break;
                case 29:
                    bVar2 = bVar;
                    bVar = b.PUNCT_SHIFT;
                    break;
                default:
                    throw com.huawei.hms.scankit.p.a.a();
            }
        } else {
            sb.append((char) iArr[iArr2[0]]);
        }
        return new b[]{bVar, bVar2};
    }

    private static int a(int i6, int[] iArr, Charset charset, int i7, StringBuilder sb) throws com.huawei.hms.scankit.p.a {
        int a6;
        int i8;
        int i9;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i10 = 0;
        long j6 = 0;
        boolean z5 = false;
        if (i6 == 901) {
            int[] iArr2 = new int[6];
            int i11 = i7 + 1;
            int i12 = iArr[i7];
            while (true) {
                i9 = iArr[0];
                if (i11 < i9 && !z5) {
                    int i13 = i10 + 1;
                    iArr2[i10] = i12;
                    j6 = (j6 * 900) + i12;
                    int i14 = i11 + 1;
                    i12 = iArr[i11];
                    if (i12 != 928) {
                        switch (i12) {
                            case 900:
                            case 901:
                            case 902:
                                break;
                            default:
                                switch (i12) {
                                    case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_TIMEOUT /* 922 */:
                                    case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_MODE /* 923 */:
                                    case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_STREAM_FIN_AND_RST /* 924 */:
                                        break;
                                    default:
                                        if (i13 % 5 != 0 || i13 <= 0) {
                                            i11 = i14;
                                            i10 = i13;
                                            break;
                                        } else {
                                            for (int i15 = 0; i15 < 6; i15++) {
                                                byteArrayOutputStream.write((byte) (j6 >> ((5 - i15) * 8)));
                                            }
                                            j6 = 0;
                                            i11 = i14;
                                            i10 = 0;
                                            break;
                                        }
                                }
                        }
                    }
                    z5 = true;
                    i10 = i13;
                }
            }
            if (i11 == i9 && i12 < 900) {
                iArr2[i10] = i12;
                i10++;
            }
            for (i8 = 0; i8 < i10; i8++) {
                byteArrayOutputStream.write((byte) iArr2[i8]);
            }
            a6 = i11;
        } else {
            a6 = i6 == 924 ? a(i7, iArr, false, 0, 0L, byteArrayOutputStream) : i7;
        }
        sb.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return a6;
    }

    private static int a(int i6, int[] iArr, boolean z5, int i7, long j6, ByteArrayOutputStream byteArrayOutputStream) throws com.huawei.hms.scankit.p.a {
        while (i6 < iArr[0] && !z5) {
            int i8 = i6 + 1;
            int i9 = iArr[i6];
            if (i9 < 900) {
                i7++;
                j6 = (j6 * 900) + i9;
                i6 = i8;
            } else {
                if (i9 != 928) {
                    switch (i9) {
                        default:
                            switch (i9) {
                                case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_TIMEOUT /* 922 */:
                                case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_MODE /* 923 */:
                                case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_STREAM_FIN_AND_RST /* 924 */:
                                    break;
                                default:
                                    throw com.huawei.hms.scankit.p.a.a();
                            }
                        case 900:
                        case 901:
                        case 902:
                            z5 = true;
                            break;
                    }
                }
                z5 = true;
            }
            if (i7 % 5 == 0 && i7 > 0) {
                for (int i10 = 0; i10 < 6; i10++) {
                    byteArrayOutputStream.write((byte) (j6 >> ((5 - i10) * 8)));
                }
                j6 = 0;
                i7 = 0;
            }
        }
        return i6;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0046, code lost:
    
        return r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(int[] r8, int r9, java.lang.StringBuilder r10) throws com.huawei.hms.scankit.p.a {
        /*
            r0 = 15
            int[] r0 = new int[r0]
            r1 = 0
            r2 = 0
        L6:
            r3 = 0
        L7:
            r4 = r8[r1]
            if (r9 >= r4) goto L46
            if (r2 != 0) goto L46
            int r5 = r9 + 1
            r6 = r8[r9]
            r7 = 1
            if (r5 != r4) goto L15
            r2 = 1
        L15:
            r4 = 900(0x384, float:1.261E-42)
            if (r6 >= r4) goto L1f
            r0[r3] = r6
            int r3 = r3 + 1
            r9 = r5
            goto L32
        L1f:
            if (r6 == r4) goto L31
            r2 = 901(0x385, float:1.263E-42)
            if (r6 == r2) goto L31
            r2 = 928(0x3a0, float:1.3E-42)
            if (r6 == r2) goto L31
            switch(r6) {
                case 922: goto L31;
                case 923: goto L31;
                case 924: goto L31;
                default: goto L2c;
            }
        L2c:
            com.huawei.hms.scankit.p.a r8 = com.huawei.hms.scankit.p.a.a()
            throw r8
        L31:
            r2 = 1
        L32:
            int r4 = r3 % 15
            if (r4 == 0) goto L3c
            r4 = 902(0x386, float:1.264E-42)
            if (r6 == r4) goto L3c
            if (r2 == 0) goto L7
        L3c:
            if (r3 <= 0) goto L7
            java.lang.String r3 = a(r0, r3)
            r10.append(r3)
            goto L6
        L46:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.q1.a(int[], int, java.lang.StringBuilder):int");
    }

    private static String a(int[] iArr, int i6) throws com.huawei.hms.scankit.p.a {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i7 = 0; i7 < i6; i7++) {
            bigInteger = bigInteger.add(f34695c[(i6 - i7) - 1].multiply(BigInteger.valueOf(iArr[i7])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw com.huawei.hms.scankit.p.a.a();
    }
}
