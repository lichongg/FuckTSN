package com.ss.android.cw;

import com.bytedance.sdk.component.utils.vl;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;

/* loaded from: D:\Downloads\app\classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f37549a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: com.ss.android.cw.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0730a {
    }

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private int f37550a;

        /* renamed from: b, reason: collision with root package name */
        private int f37551b;

        /* renamed from: c, reason: collision with root package name */
        private int f37552c;

        /* renamed from: d, reason: collision with root package name */
        private long f37553d;

        /* renamed from: e, reason: collision with root package name */
        private String f37554e;

        private b() {
        }

        /* synthetic */ b(C0730a c0730a) {
            this();
        }
    }

    public static int a(String str, File file) {
        return b(str, file, null);
    }

    private static String e(long j6) {
        return Long.toHexString((j6 << 4) + 31);
    }

    public static int b(String str, File file, c cVar) {
        int i6;
        long j6;
        String str2;
        if (str == null || str.length() == 0) {
            return 2;
        }
        try {
            if (cVar != null) {
                if (cVar.j() <= 0) {
                    try {
                        cVar.xt();
                    } catch (Throwable unused) {
                    }
                    return 5;
                }
            } else if (file == null || !file.exists()) {
                return 5;
            }
            try {
                b c6 = c(str);
                if (c6 == null) {
                    i6 = -1;
                    j6 = -1;
                } else {
                    if (c6.f37550a > 1) {
                        return 3;
                    }
                    i6 = c6.f37552c;
                    j6 = c6.f37553d;
                }
                b bVar = null;
                try {
                    str2 = cVar != null ? f(cVar, i6, j6) : l(file, i6, j6);
                } catch (Throwable th) {
                    vl.j(th);
                    str2 = null;
                }
                if (str2 != null && str2.length() != 0) {
                    if (c6 != null && (c6.f37550a != 1 || c6.f37551b != 1)) {
                        if (c6.f37554e != null) {
                            try {
                                bVar = c(str2);
                            } catch (Throwable unused2) {
                            }
                            if (bVar != null && c6.f37552c == bVar.f37552c && c6.f37553d == bVar.f37553d && c6.f37554e.equals(bVar.f37554e)) {
                                return 0;
                            }
                        }
                    }
                    return str2.equals(str) ? 0 : 1;
                }
                return 6;
            } catch (Throwable unused3) {
                return 4;
            }
        } catch (Throwable unused4) {
            return 99;
        }
    }

    private static b c(String str) throws Exception {
        C0730a c0730a = null;
        if (!str.startsWith("ttmd5:")) {
            return null;
        }
        String[] split = str.split(";");
        String[] split2 = split[0].split(":");
        b bVar = new b(c0730a);
        bVar.f37550a = Integer.parseInt(split2[1]);
        if (bVar.f37550a > 1) {
            return bVar;
        }
        bVar.f37551b = Integer.parseInt(split2[2]);
        String[] split3 = split2[3].split("g");
        bVar.f37552c = (int) k(split3[0]);
        bVar.f37553d = k(split3[1]);
        bVar.f37554e = split[1];
        return bVar;
    }

    private static String d(int i6, long j6) {
        return "ttmd5:1:1:" + e(i6) + "g" + e(j6);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:5|6|(6:13|14|(3:16|(1:18)|19)|(1:21)|22|(4:31|33|34|35)(3:26|27|28))|38|14|(0)|(0)|22|(1:24)|31|33|34|35) */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003e A[Catch: all -> 0x002c, TryCatch #2 {all -> 0x002c, blocks: (B:6:0x000d, B:10:0x001a, B:14:0x0030, B:16:0x003e, B:18:0x004b, B:21:0x005a, B:22:0x0061, B:31:0x0073), top: B:5:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005a A[Catch: all -> 0x002c, TryCatch #2 {all -> 0x002c, blocks: (B:6:0x000d, B:10:0x001a, B:14:0x0030, B:16:0x003e, B:18:0x004b, B:21:0x005a, B:22:0x0061, B:31:0x0073), top: B:5:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String f(com.ss.android.cw.c r16, int r17, long r18) throws java.lang.Exception {
        /*
            r0 = r17
            java.lang.String r1 = "MD5"
            java.security.MessageDigest r3 = java.security.MessageDigest.getInstance(r1)
            if (r3 != 0) goto Ld
            java.lang.String r0 = ""
            return r0
        Ld:
            long r9 = r16.j()     // Catch: java.lang.Throwable -> L2c
            r11 = 0
            r1 = 1
            if (r0 <= 0) goto L2e
            int r2 = (r18 > r11 ? 1 : (r18 == r11 ? 0 : -1))
            if (r2 <= 0) goto L2e
            long r4 = (long) r0     // Catch: java.lang.Throwable -> L2c
            long r4 = r4 * r18
            r6 = 8
            long r6 = r6 * r9
            r13 = 10
            long r6 = r6 / r13
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 <= 0) goto L29
            goto L2e
        L29:
            r7 = r18
            goto L30
        L2c:
            r0 = move-exception
            goto L8f
        L2e:
            r7 = r9
            r0 = 1
        L30:
            r2 = 8192(0x2000, float:1.148E-41)
            byte[] r4 = new byte[r2]     // Catch: java.lang.Throwable -> L2c
            r5 = 0
            r2 = r16
            j(r2, r3, r4, r5, r7)     // Catch: java.lang.Throwable -> L2c
            r2 = 2
            if (r0 <= r2) goto L58
            long r5 = (long) r0     // Catch: java.lang.Throwable -> L2c
            long r5 = r5 * r7
            long r5 = r9 - r5
            int r13 = r0 + (-1)
            long r14 = (long) r13     // Catch: java.lang.Throwable -> L2c
            long r14 = r5 / r14
            r2 = 1
        L49:
            if (r2 >= r13) goto L58
            long r5 = r7 + r14
            long r5 = r5 + r11
            r11 = r2
            r2 = r16
            j(r2, r3, r4, r5, r7)     // Catch: java.lang.Throwable -> L2c
            int r2 = r11 + 1
            r11 = r5
            goto L49
        L58:
            if (r0 <= r1) goto L61
            long r5 = r9 - r7
            r2 = r16
            j(r2, r3, r4, r5, r7)     // Catch: java.lang.Throwable -> L2c
        L61:
            byte[] r2 = r3.digest()     // Catch: java.lang.Throwable -> L2c
            java.lang.String r2 = i(r2)     // Catch: java.lang.Throwable -> L2c
            if (r0 != r1) goto L73
            int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r1 != 0) goto L73
            r16.xt()     // Catch: java.lang.Throwable -> L72
        L72:
            return r2
        L73:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2c
            r1.<init>()     // Catch: java.lang.Throwable -> L2c
            java.lang.String r0 = d(r0, r7)     // Catch: java.lang.Throwable -> L2c
            r1.append(r0)     // Catch: java.lang.Throwable -> L2c
            java.lang.String r0 = ";"
            r1.append(r0)     // Catch: java.lang.Throwable -> L2c
            r1.append(r2)     // Catch: java.lang.Throwable -> L2c
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> L2c
            r16.xt()     // Catch: java.lang.Throwable -> L8e
        L8e:
            return r0
        L8f:
            r16.xt()     // Catch: java.lang.Throwable -> L92
        L92:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.cw.a.f(com.ss.android.cw.c, int, long):java.lang.String");
    }

    public static String g(File file) {
        return h(file, 9, 8192L);
    }

    public static String h(File file, int i6, long j6) {
        if (file != null) {
            try {
                if (file.exists()) {
                    return l(file, i6, j6);
                }
            } catch (Throwable th) {
                vl.j(th);
            }
        }
        return "";
    }

    private static String i(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        int length = bArr.length * 2;
        char[] cArr = new char[length];
        int i6 = 0;
        for (byte b6 : bArr) {
            int i7 = i6 + 1;
            char[] cArr2 = f37549a;
            cArr[i6] = cArr2[(b6 & 255) >> 4];
            i6 += 2;
            cArr[i7] = cArr2[b6 & 15];
        }
        return new String(cArr, 0, length);
    }

    private static long k(String str) throws RuntimeException {
        return (Long.parseLong(str, 16) - 31) >> 4;
    }

    private static String l(File file, int i6, long j6) throws Exception {
        return f(new com.ss.android.cw.b(file), i6, j6);
    }

    private static void j(c cVar, MessageDigest messageDigest, byte[] bArr, long j6, long j7) throws IOException {
        cVar.j(j6, j7);
        long j8 = 0;
        while (j8 < j7) {
            int j9 = cVar.j(bArr, 0, (int) Math.min(j7 - j8, bArr.length));
            if (j9 > 0) {
                messageDigest.update(bArr, 0, j9);
                j8 += j9;
            } else {
                throw new IOException("updateSample unexpected readCount <= 0, readCount = " + j9 + ", readTotalCount = " + j8 + ", sampleSize = " + j7);
            }
        }
    }
}
