package com.baidu.liantian.b;

import android.content.pm.Signature;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class d {
    private static Certificate[] a(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(jarFile.getInputStream(jarEntry));
            while (bufferedInputStream.read(bArr, 0, 8192) != -1) {
            }
            bufferedInputStream.close();
            if (jarEntry != null) {
                return jarEntry.getCertificates();
            }
            return null;
        } catch (IOException unused) {
            e.a();
            return null;
        } catch (RuntimeException unused2) {
            e.a();
            return null;
        } catch (Throwable unused3) {
            e.a();
            return null;
        }
    }

    public static PublicKey a(Signature signature) {
        CertificateFactory certificateFactory = CertificateFactory.getInstance(com.huawei.hms.feature.dynamic.f.e.f33254b);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(signature.toByteArray());
        Certificate generateCertificate = certificateFactory.generateCertificate(byteArrayInputStream);
        try {
            byteArrayInputStream.close();
        } catch (Throwable unused) {
        }
        return generateCertificate.getPublicKey();
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0059, code lost:
    
        if (r3.length == r4.length) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005c, code lost:
    
        r6 = r6 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.security.PublicKey a(java.lang.String r10) {
        /*
            r0 = 0
            boolean r1 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Throwable -> L75
            if (r1 == 0) goto L8
            return r0
        L8:
            r1 = 8192(0x2000, float:1.148E-41)
            byte[] r1 = new byte[r1]     // Catch: java.lang.Throwable -> L75
            java.util.jar.JarFile r2 = new java.util.jar.JarFile     // Catch: java.lang.Throwable -> L75
            r2.<init>(r10)     // Catch: java.lang.Throwable -> L75
            java.util.Enumeration r10 = r2.entries()     // Catch: java.lang.Throwable -> L75
            r3 = r0
        L16:
            boolean r4 = r10.hasMoreElements()     // Catch: java.lang.Throwable -> L75
            r5 = 0
            if (r4 == 0) goto L66
            java.lang.Object r4 = r10.nextElement()     // Catch: java.lang.Throwable -> L75
            java.util.jar.JarEntry r4 = (java.util.jar.JarEntry) r4     // Catch: java.lang.Throwable -> L75
            boolean r6 = r4.isDirectory()     // Catch: java.lang.Throwable -> L75
            if (r6 != 0) goto L16
            java.lang.String r6 = r4.getName()     // Catch: java.lang.Throwable -> L75
            java.lang.String r7 = "META-INF/"
            boolean r6 = r6.startsWith(r7)     // Catch: java.lang.Throwable -> L75
            if (r6 != 0) goto L16
            java.security.cert.Certificate[] r4 = a(r2, r4, r1)     // Catch: java.lang.Throwable -> L75
            if (r4 != 0) goto L3f
            r2.close()     // Catch: java.lang.Throwable -> L75
            return r0
        L3f:
            if (r3 != 0) goto L43
            r3 = r4
            goto L16
        L43:
            r6 = 0
        L44:
            int r7 = r3.length     // Catch: java.lang.Throwable -> L75
            if (r6 >= r7) goto L16
            r7 = 0
        L48:
            int r8 = r4.length     // Catch: java.lang.Throwable -> L75
            if (r7 >= r8) goto L62
            r8 = r3[r6]     // Catch: java.lang.Throwable -> L75
            if (r8 == 0) goto L5f
            r9 = r4[r7]     // Catch: java.lang.Throwable -> L75
            boolean r8 = r8.equals(r9)     // Catch: java.lang.Throwable -> L75
            if (r8 == 0) goto L5f
            int r7 = r3.length     // Catch: java.lang.Throwable -> L75
            int r8 = r4.length     // Catch: java.lang.Throwable -> L75
            if (r7 == r8) goto L5c
            goto L62
        L5c:
            int r6 = r6 + 1
            goto L44
        L5f:
            int r7 = r7 + 1
            goto L48
        L62:
            r2.close()     // Catch: java.lang.Throwable -> L75
            return r0
        L66:
            r2.close()     // Catch: java.lang.Throwable -> L75
            if (r3 == 0) goto L75
            int r10 = r3.length     // Catch: java.lang.Throwable -> L75
            if (r10 <= 0) goto L75
            r10 = r3[r5]     // Catch: java.lang.Throwable -> L75
            java.security.PublicKey r10 = r10.getPublicKey()     // Catch: java.lang.Throwable -> L75
            return r10
        L75:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.b.d.a(java.lang.String):java.security.PublicKey");
    }
}
