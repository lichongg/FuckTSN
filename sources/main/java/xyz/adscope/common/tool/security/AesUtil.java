package xyz.adscope.common.tool.security;

import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AesUtil {

    /* renamed from: a, reason: collision with root package name */
    private static String f56749a = decryptStr("\u007f}{y<usqomkigeca");

    public static byte[] decryptByte(byte[] bArr) {
        return decryptByte(KeyGenerator.generateAesKey(), f56749a, bArr);
    }

    public static byte[] encryptByte(byte[] bArr) {
        return encryptByte(KeyGenerator.generateAesKey(), f56749a, bArr);
    }

    public static String decrypt(String str, String str2) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(f56749a.getBytes("UTF-8"));
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return new String(cipher.doFinal(Base64.decode(str2, 0)));
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public static byte[] decryptByte(String str, String str2, byte[] bArr) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes("UTF-8"));
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public static String decryptStr(String str) {
        try {
            StringBuilder sb = new StringBuilder(str);
            sb.reverse();
            for (int i6 = 0; i6 < sb.length(); i6++) {
                sb.setCharAt(i6, (char) (sb.charAt(i6) - i6));
            }
            return sb.toString();
        } catch (Exception e6) {
            e6.printStackTrace();
            return "";
        }
    }

    public static String encrypt(String str, String str2) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(f56749a.getBytes("UTF-8"));
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return Base64.encodeToString(cipher.doFinal(str2.getBytes()), 2);
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public static byte[] encryptByte(String str, String str2, byte[] bArr) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes("UTF-8"));
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public static String encryptStr(String str) {
        try {
            StringBuilder sb = new StringBuilder(str);
            for (int i6 = 0; i6 < sb.length(); i6++) {
                sb.setCharAt(i6, (char) (sb.charAt(i6) + i6));
            }
            sb.reverse();
            return sb.toString();
        } catch (Exception e6) {
            e6.printStackTrace();
            return "";
        }
    }
}
