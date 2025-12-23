package com.amap.api.col.p0003l;

import com.amap.api.col.p0003l.o6;
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
public final class d7 {
    public static void c(String str, byte[] bArr, c7 c7Var) throws IOException, CertificateException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        o6 o6Var;
        OutputStream outputStream = null;
        try {
            if (d(c7Var.f5849a, str)) {
                return;
            }
            File file = new File(c7Var.f5849a);
            if (!file.exists()) {
                file.mkdirs();
            }
            o6Var = o6.b(file, c7Var.f5850b);
            try {
                o6Var.e(c7Var.f5852d);
                byte[] b6 = c7Var.f5853e.b(bArr);
                o6.d k6 = o6Var.k(str);
                outputStream = k6.b();
                outputStream.write(b6);
                k6.c();
                o6Var.o();
                try {
                    outputStream.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                try {
                    o6Var.close();
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
                if (o6Var == null) {
                    throw th;
                }
                try {
                    o6Var.close();
                    throw th;
                } catch (Throwable th5) {
                    th5.printStackTrace();
                    throw th;
                }
            }
        } catch (Throwable th6) {
            th = th6;
            o6Var = null;
        }
    }

    private static byte[] e(o6 o6Var, c7 c7Var, List<String> list) {
        try {
            File l6 = o6Var.l();
            if (l6 != null && l6.exists()) {
                int i6 = 0;
                for (String str : l6.list()) {
                    if (str.contains(".0")) {
                        String str2 = str.split("\\.")[0];
                        byte[] g6 = j7.g(o6Var, str2);
                        i6 += g6.length;
                        list.add(str2);
                        if (i6 > c7Var.f5854f.a()) {
                            break;
                        }
                        c7Var.f5855g.c(g6);
                    }
                }
                if (i6 <= 0) {
                    return null;
                }
                return c7Var.f5855g.a();
            }
        } catch (Throwable th) {
            v5.p(th, "leg", "gCo");
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
    public static int a(com.amap.api.col.p0003l.c7 r10) {
        /*
            java.lang.String r0 = "code"
            r1 = -1
            r2 = 0
            com.amap.api.col.3l.x7 r3 = r10.f5854f     // Catch: java.lang.Throwable -> L7d
            boolean r3 = r3.e()     // Catch: java.lang.Throwable -> L7d
            if (r3 == 0) goto L8a
            com.amap.api.col.3l.x7 r3 = r10.f5854f     // Catch: java.lang.Throwable -> L7d
            r4 = 1
            r3.c(r4)     // Catch: java.lang.Throwable -> L7d
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L7d
            java.lang.String r5 = r10.f5849a     // Catch: java.lang.Throwable -> L7d
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L7d
            long r5 = r10.f5850b     // Catch: java.lang.Throwable -> L7d
            com.amap.api.col.3l.o6 r3 = com.amap.api.col.p0003l.o6.b(r3, r5)     // Catch: java.lang.Throwable -> L7d
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L5d
            r5.<init>()     // Catch: java.lang.Throwable -> L5d
            byte[] r6 = e(r3, r10, r5)     // Catch: java.lang.Throwable -> L5d
            if (r6 == 0) goto L81
            int r7 = r6.length     // Catch: java.lang.Throwable -> L5d
            if (r7 != 0) goto L2e
            goto L81
        L2e:
            com.amap.api.col.3l.t5 r7 = new com.amap.api.col.3l.t5     // Catch: java.lang.Throwable -> L5d
            java.lang.String r8 = r10.f5851c     // Catch: java.lang.Throwable -> L5d
            r7.<init>(r6, r8)     // Catch: java.lang.Throwable -> L5d
            com.amap.api.col.p0003l.r6.b()     // Catch: java.lang.Throwable -> L5d
            com.amap.api.col.3l.z6 r7 = com.amap.api.col.p0003l.r6.d(r7)     // Catch: java.lang.Throwable -> L5d
            byte[] r7 = r7.f7800a     // Catch: java.lang.Throwable -> L5d
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L5d
            java.lang.String r9 = new java.lang.String     // Catch: java.lang.Throwable -> L5d
            r9.<init>(r7)     // Catch: java.lang.Throwable -> L5d
            r8.<init>(r9)     // Catch: java.lang.Throwable -> L5d
            boolean r7 = r8.has(r0)     // Catch: java.lang.Throwable -> L5d
            if (r7 == 0) goto L7f
            int r0 = r8.getInt(r0)     // Catch: java.lang.Throwable -> L5d
            if (r0 != r4) goto L7f
            com.amap.api.col.3l.x7 r0 = r10.f5854f     // Catch: java.lang.Throwable -> L5d
            if (r0 == 0) goto L60
            int r4 = r6.length     // Catch: java.lang.Throwable -> L5d
            r0.b(r4)     // Catch: java.lang.Throwable -> L5d
            goto L60
        L5d:
            r10 = move-exception
            r2 = r3
            goto L95
        L60:
            com.amap.api.col.3l.x7 r10 = r10.f5854f     // Catch: java.lang.Throwable -> L5d
            int r10 = r10.a()     // Catch: java.lang.Throwable -> L5d
            r0 = 2147483647(0x7fffffff, float:NaN)
            if (r10 >= r0) goto L6f
            b(r3, r5)     // Catch: java.lang.Throwable -> L5d
            goto L7b
        L6f:
            r3.s()     // Catch: java.lang.Throwable -> L73
            goto L7b
        L73:
            r10 = move-exception
            java.lang.String r0 = "ofm"
            java.lang.String r4 = "dlo"
            com.amap.api.col.p0003l.v5.p(r10, r0, r4)     // Catch: java.lang.Throwable -> L5d
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
            com.amap.api.col.p0003l.v5.p(r10, r0, r3)     // Catch: java.lang.Throwable -> La0
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
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.d7.a(com.amap.api.col.3l.c7):int");
    }

    private static void b(o6 o6Var, List<String> list) {
        if (o6Var != null) {
            try {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    o6Var.q(it.next());
                }
                o6Var.close();
            } catch (Throwable th) {
                v5.p(th, "ofm", "dlo");
            }
        }
    }

    private static boolean d(String str, String str2) {
        try {
            return new File(str, str2 + ".0").exists();
        } catch (Throwable th) {
            v5.p(th, "leg", IAdInterListener.AdReqParam.FET);
            return false;
        }
    }
}
