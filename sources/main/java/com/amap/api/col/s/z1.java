package com.amap.api.col.s;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class z1 {
    public static byte[] b(byte[] bArr, PublicKey publicKey) {
        try {
            Cipher cipher = Cipher.getInstance(j1.t("CUlNBL0VDQi9QS0NTMVBhZGRpbmc"));
            cipher.init(1, publicKey);
            return cipher.doFinal(bArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static PublicKey a(String str) throws Exception {
        try {
            return KeyFactory.getInstance(j1.t("EUlNB")).generatePublic(new X509EncodedKeySpec(v1.c(str)));
        } catch (NullPointerException unused) {
            throw new Exception("公钥数据为空");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("公钥非法");
        }
    }
}
