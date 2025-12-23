package xyz.adscope.common.v2.encrypt.impl;

import android.util.Base64;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import xyz.adscope.common.v2.log.SDKLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AesUtil implements IBaseEncrypt {
    private static final String ALGORITHM_AES = "AES";
    private static final String ALGORITHM_TRANSFORMATION = "AES/CBC/PKCS5PADDING";
    private static final String ALGORITHM_TRANSFORMATION_FCB = "AES/CFB/NoPadding";
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String TAG = "AesUtil";
    private final IAESConfig mGenerate;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface IAESConfig {
        String generateAesKey();

        String generateAesVector();
    }

    public static byte[] decryptByte(byte[] bArr, IAESConfig iAESConfig) {
        if (iAESConfig != null) {
            return decryptByte(iAESConfig.generateAesKey(), iAESConfig.generateAesVector(), bArr);
        }
        SDKLog.e(TAG, "configGenerate is null");
        return null;
    }

    public static byte[] encryptByte(byte[] bArr, IAESConfig iAESConfig) {
        if (iAESConfig != null) {
            return encryptByte(iAESConfig.generateAesKey(), iAESConfig.generateAesVector(), bArr);
        }
        SDKLog.e(TAG, "configGenerate is null");
        return null;
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, ALGORITHM_AES);
        Cipher cipher = Cipher.getInstance(ALGORITHM_TRANSFORMATION_FCB);
        int blockSize = cipher.getBlockSize();
        byte[] bArr3 = new byte[blockSize];
        new SecureRandom().nextBytes(bArr3);
        cipher.init(1, secretKeySpec, new IvParameterSpec(bArr3));
        byte[] doFinal = cipher.doFinal(bArr2);
        byte[] bArr4 = new byte[doFinal.length + blockSize];
        System.arraycopy(bArr3, 0, bArr4, 0, blockSize);
        System.arraycopy(doFinal, 0, bArr4, blockSize, doFinal.length);
        return bArr4;
    }

    public static String encryptCFB(String str) {
        try {
            Charset charset = StandardCharsets.UTF_8;
            return Base64.encodeToString(encrypt("666f430a0400462dbf62eb4e175186db".getBytes(charset), Base64.encode(str.getBytes(charset), 10)), 10);
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // xyz.adscope.common.v2.encrypt.impl.IBaseEncrypt
    public byte[] decode(byte[] bArr) {
        return decryptByte(bArr, this.mGenerate);
    }

    @Override // xyz.adscope.common.v2.encrypt.impl.IBaseEncrypt
    public byte[] encode(byte[] bArr) {
        return encryptByte(bArr, this.mGenerate);
    }

    AesUtil(IAESConfig iAESConfig) {
        this.mGenerate = iAESConfig;
    }

    private static byte[] decryptByte(String str, String str2, byte[] bArr) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes("UTF-8"));
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes("UTF-8"), ALGORITHM_AES);
            Cipher cipher = Cipher.getInstance(ALGORITHM_TRANSFORMATION);
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Exception e6) {
            SDKLog.stack(e6);
            return null;
        }
    }

    private static byte[] encryptByte(String str, String str2, byte[] bArr) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes("UTF-8"));
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes("UTF-8"), ALGORITHM_AES);
            Cipher cipher = Cipher.getInstance(ALGORITHM_TRANSFORMATION);
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Exception e6) {
            SDKLog.stack(e6);
            return null;
        }
    }
}
