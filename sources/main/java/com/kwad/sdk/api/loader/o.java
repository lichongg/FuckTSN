package com.kwad.sdk.api.loader;

import java.nio.charset.Charset;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class o {
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        return transform(bArr, bArr2, 2);
    }

    private static byte[] transform(byte[] bArr, byte[] bArr2, int i6) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance(com.acse.ottn.f.f4513a);
            cipher.init(2, secretKeySpec);
            return cipher.doFinal(bArr2);
        } catch (Exception unused) {
            return new byte[0];
        }
    }
}
