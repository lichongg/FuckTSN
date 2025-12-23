package com.bytedance.embedapplog;

/* loaded from: D:\Downloads\app\classes3.dex */
public class pz {
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0038, code lost:
    
        if (r1 == null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] j(java.lang.String r4) {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r1 = 8192(0x2000, float:1.148E-41)
            r0.<init>(r1)
            r1 = 0
            boolean r2 = com.bytedance.embedapplog.j.ae()     // Catch: java.lang.Throwable -> L21
            java.lang.String r3 = "UTF-8"
            if (r2 == 0) goto L23
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L21
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L21
            byte[] r4 = r4.getBytes(r3)     // Catch: java.lang.Throwable -> L1e
            r2.write(r4)     // Catch: java.lang.Throwable -> L1e
            r1 = r2
            goto L2a
        L1e:
            r4 = move-exception
            r1 = r2
            goto L35
        L21:
            r4 = move-exception
            goto L35
        L23:
            byte[] r4 = r4.getBytes(r3)     // Catch: java.lang.Throwable -> L21
            r0.write(r4)     // Catch: java.lang.Throwable -> L21
        L2a:
            if (r1 == 0) goto L3b
        L2c:
            r1.close()     // Catch: java.io.IOException -> L30
            goto L3b
        L30:
            r4 = move-exception
            com.bytedance.embedapplog.uc.xt(r4)
            goto L3b
        L35:
            com.bytedance.embedapplog.uc.xt(r4)     // Catch: java.lang.Throwable -> L4b
            if (r1 == 0) goto L3b
            goto L2c
        L3b:
            byte[] r4 = r0.toByteArray()
            boolean r0 = com.bytedance.embedapplog.j.ae()
            if (r0 == 0) goto L4a
            int r0 = r4.length
            byte[] r4 = com.bytedance.embedapplog.util.TTEncryptUtils.a(r4, r0)
        L4a:
            return r4
        L4b:
            r4 = move-exception
            if (r1 == 0) goto L56
            r1.close()     // Catch: java.io.IOException -> L52
            goto L56
        L52:
            r0 = move-exception
            com.bytedance.embedapplog.uc.xt(r0)
        L56:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.pz.j(java.lang.String):byte[]");
    }
}
