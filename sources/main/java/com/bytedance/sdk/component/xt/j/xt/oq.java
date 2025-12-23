package com.bytedance.sdk.component.xt.j.xt;

import java.net.IDN;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class oq {

    /* renamed from: j, reason: collision with root package name */
    public static final Charset f27325j = Charset.forName("UTF-8");

    public static int j(char c6) {
        if (c6 >= '0' && c6 <= '9') {
            return c6 - '0';
        }
        if (c6 >= 'a' && c6 <= 'f') {
            return c6 - 'W';
        }
        if (c6 < 'A' || c6 > 'F') {
            return -1;
        }
        return c6 - '7';
    }

    public static int xt(String str, int i6, int i7) {
        for (int i8 = i7 - 1; i8 >= i6; i8--) {
            char charAt = str.charAt(i8);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i8 + 1;
            }
        }
        return i6;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0077, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.net.InetAddress cw(java.lang.String r12, int r13, int r14) {
        /*
            r0 = 16
            byte[] r1 = new byte[r0]
            r2 = 0
            r3 = -1
            r4 = 0
            r5 = -1
            r6 = -1
        L9:
            r7 = 0
            if (r13 >= r14) goto L78
            if (r4 != r0) goto Lf
            return r7
        Lf:
            int r8 = r13 + 2
            r9 = 2
            if (r8 > r14) goto L27
            java.lang.String r10 = "::"
            boolean r10 = r12.regionMatches(r13, r10, r2, r9)
            if (r10 == 0) goto L27
            if (r5 == r3) goto L1f
            return r7
        L1f:
            int r4 = r4 + 2
            r5 = r4
            if (r8 != r14) goto L25
            goto L78
        L25:
            r6 = r8
            goto L4b
        L27:
            if (r4 == 0) goto L34
            java.lang.String r8 = ":"
            r10 = 1
            boolean r8 = r12.regionMatches(r13, r8, r2, r10)
            if (r8 == 0) goto L36
            int r13 = r13 + 1
        L34:
            r6 = r13
            goto L4b
        L36:
            java.lang.String r8 = "."
            boolean r13 = r12.regionMatches(r13, r8, r2, r10)
            if (r13 == 0) goto L4a
            int r13 = r4 + (-2)
            boolean r12 = j(r12, r6, r14, r1, r13)
            if (r12 != 0) goto L47
            return r7
        L47:
            int r4 = r4 + 2
            goto L78
        L4a:
            return r7
        L4b:
            r13 = r6
            r8 = 0
        L4d:
            if (r13 >= r14) goto L5f
            char r10 = r12.charAt(r13)
            int r10 = j(r10)
            if (r10 == r3) goto L5f
            int r8 = r8 << 4
            int r8 = r8 + r10
            int r13 = r13 + 1
            goto L4d
        L5f:
            int r10 = r13 - r6
            if (r10 == 0) goto L77
            r11 = 4
            if (r10 <= r11) goto L67
            goto L77
        L67:
            int r7 = r4 + 1
            int r10 = r8 >>> 8
            r10 = r10 & 255(0xff, float:3.57E-43)
            byte r10 = (byte) r10
            r1[r4] = r10
            int r4 = r4 + r9
            r8 = r8 & 255(0xff, float:3.57E-43)
            byte r8 = (byte) r8
            r1[r7] = r8
            goto L9
        L77:
            return r7
        L78:
            if (r4 == r0) goto L89
            if (r5 != r3) goto L7d
            return r7
        L7d:
            int r12 = r4 - r5
            int r13 = 16 - r12
            java.lang.System.arraycopy(r1, r5, r1, r13, r12)
            int r0 = r0 - r4
            int r0 = r0 + r5
            java.util.Arrays.fill(r1, r5, r0, r2)
        L89:
            java.net.InetAddress r12 = java.net.InetAddress.getByAddress(r1)     // Catch: java.net.UnknownHostException -> L8e
            return r12
        L8e:
            java.lang.AssertionError r12 = new java.lang.AssertionError
            r12.<init>()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.xt.j.xt.oq.cw(java.lang.String, int, int):java.net.InetAddress");
    }

    public static void j(long j6, long j7, long j8) {
        if ((j7 | j8) < 0 || j7 > j6 || j6 - j7 < j8) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private static boolean xt(String str) {
        for (int i6 = 0; i6 < str.length(); i6++) {
            char charAt = str.charAt(i6);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static <T> List<T> j(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static int j(String str, int i6, int i7) {
        while (i6 < i7) {
            char charAt = str.charAt(i6);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i6;
            }
            i6++;
        }
        return i7;
    }

    public static int j(String str, int i6, int i7, String str2) {
        while (i6 < i7) {
            if (str2.indexOf(str.charAt(i6)) != -1) {
                return i6;
            }
            i6++;
        }
        return i7;
    }

    public static int j(String str, int i6, int i7, char c6) {
        while (i6 < i7) {
            if (str.charAt(i6) == c6) {
                return i6;
            }
            i6++;
        }
        return i7;
    }

    public static String j(String str) {
        InetAddress cw;
        if (str.contains(":")) {
            if (str.startsWith("[") && str.endsWith("]")) {
                cw = cw(str, 1, str.length() - 1);
            } else {
                cw = cw(str, 0, str.length());
            }
            if (cw == null) {
                return null;
            }
            byte[] address = cw.getAddress();
            if (address.length == 16) {
                return j(address);
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + "'");
        }
        try {
            if (!str.contains("toutiao") && !str.contains("bytedance")) {
                str = IDN.toASCII(str);
            }
            String lowerCase = str.toLowerCase(Locale.US);
            if (lowerCase.isEmpty()) {
                return null;
            }
            if (xt(lowerCase)) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static String j(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    private static boolean j(String str, int i6, int i7, byte[] bArr, int i8) {
        int i9 = i8;
        while (i6 < i7) {
            if (i9 == bArr.length) {
                return false;
            }
            if (i9 != i8) {
                if (str.charAt(i6) != '.') {
                    return false;
                }
                i6++;
            }
            int i10 = i6;
            int i11 = 0;
            while (i10 < i7) {
                char charAt = str.charAt(i10);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                if ((i11 == 0 && i6 != i10) || (i11 = ((i11 * 10) + charAt) - 48) > 255) {
                    return false;
                }
                i10++;
            }
            if (i10 - i6 == 0) {
                return false;
            }
            bArr[i9] = (byte) i11;
            i9++;
            i6 = i10;
        }
        return i9 == i8 + 4;
    }

    private static String j(byte[] bArr) {
        int i6 = -1;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i8 < bArr.length) {
            int i10 = i8;
            while (i10 < 16 && bArr[i10] == 0 && bArr[i10 + 1] == 0) {
                i10 += 2;
            }
            int i11 = i10 - i8;
            if (i11 > i9 && i11 >= 4) {
                i6 = i8;
                i9 = i11;
            }
            i8 = i10 + 2;
        }
        j jVar = new j();
        while (i7 < bArr.length) {
            if (i7 == i6) {
                jVar.xt(58);
                i7 += i9;
                if (i7 == 16) {
                    jVar.xt(58);
                }
            } else {
                if (i7 > 0) {
                    jVar.xt(58);
                }
                jVar.xt(((bArr[i7] & 255) << 8) | (bArr[i7 + 1] & 255));
                i7 += 2;
            }
        }
        return jVar.cw();
    }

    public static boolean j(byte[] bArr, int i6, byte[] bArr2, int i7, int i8) {
        for (int i9 = 0; i9 < i8; i9++) {
            if (bArr[i9 + i6] != bArr2[i9 + i7]) {
                return false;
            }
        }
        return true;
    }
}
