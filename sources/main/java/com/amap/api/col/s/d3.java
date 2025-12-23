package com.amap.api.col.s;

import com.amap.api.col.s.r2;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.Iterator;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class d3 {
    public static void c(String str, byte[] bArr, c3 c3Var) throws IOException, CertificateException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        r2 r2Var;
        OutputStream outputStream = null;
        try {
            if (d(c3Var.f7931a, str)) {
                return;
            }
            File file = new File(c3Var.f7931a);
            if (!file.exists()) {
                file.mkdirs();
            }
            r2Var = r2.b(file, c3Var.f7932b);
            try {
                r2Var.e(c3Var.f7934d);
                byte[] b6 = c3Var.f7935e.b(bArr);
                r2.d k6 = r2Var.k(str);
                outputStream = k6.b();
                outputStream.write(b6);
                k6.c();
                r2Var.l();
                try {
                    outputStream.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                try {
                    r2Var.close();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            } catch (Throwable th3) {
                th = th3;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                }
                if (r2Var == null) {
                    throw th;
                }
                try {
                    r2Var.close();
                    throw th;
                } catch (Throwable th5) {
                    th5.printStackTrace();
                    throw th;
                }
            }
        } catch (Throwable th6) {
            th = th6;
            r2Var = null;
        }
    }

    private static byte[] e(r2 r2Var, c3 c3Var, List<String> list) {
        try {
            File c6 = r2Var.c();
            if (c6 != null && c6.exists()) {
                int i6 = 0;
                for (String str : c6.list()) {
                    if (str.contains(".0")) {
                        String str2 = str.split("\\.")[0];
                        byte[] f6 = i3.f(r2Var, str2);
                        i6 += f6.length;
                        list.add(str2);
                        if (i6 > c3Var.f7936f.d()) {
                            break;
                        }
                        c3Var.f7937g.c(f6);
                    }
                }
                if (i6 <= 0) {
                    return null;
                }
                return c3Var.f7937g.a();
            }
        } catch (Throwable th) {
            g2.o(th, "leg", "gCo");
        }
        return new byte[0];
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x009c, code lost:
    
        if (r2 == null) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(com.amap.api.col.s.c3 r10) {
        /*
            java.lang.String r0 = "code"
            r1 = -1
            r2 = 0
            com.amap.api.col.s.v3 r3 = r10.f7936f     // Catch: java.lang.Throwable -> L7d
            boolean r3 = r3.e()     // Catch: java.lang.Throwable -> L7d
            if (r3 == 0) goto L8a
            com.amap.api.col.s.v3 r3 = r10.f7936f     // Catch: java.lang.Throwable -> L7d
            r4 = 1
            r3.b(r4)     // Catch: java.lang.Throwable -> L7d
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L7d
            java.lang.String r5 = r10.f7931a     // Catch: java.lang.Throwable -> L7d
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L7d
            long r5 = r10.f7932b     // Catch: java.lang.Throwable -> L7d
            com.amap.api.col.s.r2 r3 = com.amap.api.col.s.r2.b(r3, r5)     // Catch: java.lang.Throwable -> L7d
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L5d
            r5.<init>()     // Catch: java.lang.Throwable -> L5d
            byte[] r6 = e(r3, r10, r5)     // Catch: java.lang.Throwable -> L5d
            if (r6 == 0) goto L81
            int r7 = r6.length     // Catch: java.lang.Throwable -> L5d
            if (r7 != 0) goto L2e
            goto L81
        L2e:
            com.amap.api.col.s.f2 r7 = new com.amap.api.col.s.f2     // Catch: java.lang.Throwable -> L5d
            java.lang.String r8 = r10.f7933c     // Catch: java.lang.Throwable -> L5d
            r7.<init>(r6, r8)     // Catch: java.lang.Throwable -> L5d
            com.amap.api.col.s.u2.b()     // Catch: java.lang.Throwable -> L5d
            com.amap.api.col.s.b3 r7 = com.amap.api.col.s.u2.d(r7)     // Catch: java.lang.Throwable -> L5d
            byte[] r7 = r7.f7876a     // Catch: java.lang.Throwable -> L5d
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L5d
            java.lang.String r9 = new java.lang.String     // Catch: java.lang.Throwable -> L5d
            r9.<init>(r7)     // Catch: java.lang.Throwable -> L5d
            r8.<init>(r9)     // Catch: java.lang.Throwable -> L5d
            boolean r7 = r8.has(r0)     // Catch: java.lang.Throwable -> L5d
            if (r7 == 0) goto L7f
            int r0 = r8.getInt(r0)     // Catch: java.lang.Throwable -> L5d
            if (r0 != r4) goto L7f
            com.amap.api.col.s.v3 r0 = r10.f7936f     // Catch: java.lang.Throwable -> L5d
            if (r0 == 0) goto L60
            int r4 = r6.length     // Catch: java.lang.Throwable -> L5d
            r0.a(r4)     // Catch: java.lang.Throwable -> L5d
            goto L60
        L5d:
            r10 = move-exception
            r2 = r3
            goto L95
        L60:
            com.amap.api.col.s.v3 r10 = r10.f7936f     // Catch: java.lang.Throwable -> L5d
            int r10 = r10.d()     // Catch: java.lang.Throwable -> L5d
            r0 = 2147483647(0x7fffffff, float:NaN)
            if (r10 >= r0) goto L6f
            b(r3, r5)     // Catch: java.lang.Throwable -> L5d
            goto L7b
        L6f:
            r3.o()     // Catch: java.lang.Throwable -> L73
            goto L7b
        L73:
            r10 = move-exception
            java.lang.String r0 = "ofm"
            java.lang.String r4 = "dlo"
            com.amap.api.col.s.g2.o(r10, r0, r4)     // Catch: java.lang.Throwable -> L5d
        L7b:
            int r10 = r6.length     // Catch: java.lang.Throwable -> L7d
            return r10
        L7d:
            r10 = move-exception
            goto L95
        L7f:
            r2 = r3
            goto L8a
        L81:
            r3.close()     // Catch: java.lang.Throwable -> L85
            goto L89
        L85:
            r10 = move-exception
            r10.printStackTrace()
        L89:
            return r1
        L8a:
            if (r2 == 0) goto L9f
        L8c:
            r2.close()     // Catch: java.lang.Throwable -> L90
            goto L9f
        L90:
            r10 = move-exception
            r10.printStackTrace()
            goto L9f
        L95:
            java.lang.String r0 = "leg"
            java.lang.String r3 = "uts"
            com.amap.api.col.s.g2.o(r10, r0, r3)     // Catch: java.lang.Throwable -> La0
            if (r2 == 0) goto L9f
            goto L8c
        L9f:
            return r1
        La0:
            r10 = move-exception
            if (r2 == 0) goto Lab
            r2.close()     // Catch: java.lang.Throwable -> La7
            goto Lab
        La7:
            r0 = move-exception
            r0.printStackTrace()
        Lab:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.d3.a(com.amap.api.col.s.c3):int");
    }

    private static void b(r2 r2Var, List<String> list) {
        if (r2Var != null) {
            try {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    r2Var.q(it.next());
                }
                r2Var.close();
            } catch (Throwable th) {
                g2.o(th, "ofm", "dlo");
            }
        }
    }

    private static boolean d(String str, String str2) {
        try {
            return new File(str, str2 + ".0").exists();
        } catch (Throwable th) {
            g2.o(th, "leg", IAdInterListener.AdReqParam.FET);
            return false;
        }
    }
}
