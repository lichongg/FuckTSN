package com.huawei.agconnect.config.impl;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: D:\Downloads\app\classes5.dex */
class k {
    public static SecretKey a(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i6) throws NoSuchAlgorithmException, InvalidKeySpecException {
        if (bArr.length != 16 || bArr2.length != 16 || bArr3.length != 16) {
            throw new IllegalArgumentException("invalid data for generating the key.");
        }
        return new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(a.c(e(bArr, bArr2, bArr3)).toCharArray(), bArr4, i6, 128)).getEncoded(), "AES");
    }

    public static byte[] e(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return d(c(d(c(bArr, -4), bArr2), 6), bArr3);
    }

    static byte[] b(SecretKey secretKey, byte[] bArr) throws GeneralSecurityException {
        if (secretKey == null || bArr == null) {
            throw new NullPointerException("key or cipherText must not be null.");
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, 1, 17);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKey, new IvParameterSpec(copyOfRange));
        return cipher.doFinal(bArr, copyOfRange.length + 1, (bArr.length - copyOfRange.length) - 1);
    }

    private static byte[] c(byte[] bArr, int i6) {
        if (bArr == null) {
            throw new NullPointerException("bytes must not be null.");
        }
        for (int i7 = 0; i7 < bArr.length; i7++) {
            if (i6 < 0) {
                bArr[i7] = (byte) (bArr[i7] << (-i6));
            } else {
                bArr[i7] = (byte) (bArr[i7] >> i6);
            }
        }
        return bArr;
    }

    private static byte[] d(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            throw new NullPointerException("left or right must not be null.");
        }
        if (bArr.length != bArr2.length) {
            throw new IllegalArgumentException("left and right must be the same length.");
        }
        byte[] bArr3 = new byte[bArr.length];
        for (int i6 = 0; i6 < bArr.length; i6++) {
            bArr3[i6] = (byte) (bArr[i6] ^ bArr2[i6]);
        }
        return bArr3;
    }
}
