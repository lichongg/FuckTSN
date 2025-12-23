package com.bxkj.base.util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static byte[] f16595a = {1, 2, 3, 4, 5, 6, 7, 8};

    /* JADX WARN: Can't wrap try/catch for region: R(11:0|1|(2:2|3)|4|5|6|7|(2:8|9)|10|11|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002b, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0030, code lost:
    
        r0.printStackTrace();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r3, java.lang.String r4) {
        /*
            javax.crypto.spec.IvParameterSpec r0 = new javax.crypto.spec.IvParameterSpec
            byte[] r1 = com.bxkj.base.util.e.f16595a
            r0.<init>(r1)
            javax.crypto.spec.SecretKeySpec r1 = new javax.crypto.spec.SecretKeySpec
            byte[] r4 = r4.getBytes()
            java.lang.String r2 = "DES"
            r1.<init>(r4, r2)
            java.lang.String r4 = "DES/CBC/PKCS5Padding"
            javax.crypto.Cipher r4 = javax.crypto.Cipher.getInstance(r4)     // Catch: javax.crypto.NoSuchPaddingException -> L19 java.security.NoSuchAlgorithmException -> L1b
            goto L25
        L19:
            r4 = move-exception
            goto L1d
        L1b:
            r4 = move-exception
            goto L21
        L1d:
            r4.printStackTrace()
            goto L24
        L21:
            r4.printStackTrace()
        L24:
            r4 = 0
        L25:
            r2 = 1
            r4.init(r2, r1, r0)     // Catch: java.security.InvalidAlgorithmParameterException -> L2a java.security.InvalidKeyException -> L2f
            goto L33
        L2a:
            r0 = move-exception
            r0.printStackTrace()
            goto L33
        L2f:
            r0 = move-exception
            r0.printStackTrace()
        L33:
            r0 = 0
            byte[] r0 = new byte[r0]
            byte[] r3 = r3.getBytes()     // Catch: javax.crypto.BadPaddingException -> L3f javax.crypto.IllegalBlockSizeException -> L41
            byte[] r0 = r4.doFinal(r3)     // Catch: javax.crypto.BadPaddingException -> L3f javax.crypto.IllegalBlockSizeException -> L41
            goto L4a
        L3f:
            r3 = move-exception
            goto L43
        L41:
            r3 = move-exception
            goto L47
        L43:
            r3.printStackTrace()
            goto L4a
        L47:
            r3.printStackTrace()
        L4a:
            java.lang.String r3 = cn.bluemobi.dylan.base.utils.b.b(r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.base.util.e.a(java.lang.String, java.lang.String):java.lang.String");
    }
}
