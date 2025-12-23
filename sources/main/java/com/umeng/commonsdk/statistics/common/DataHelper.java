package com.umeng.commonsdk.statistics.common;

import android.annotation.SuppressLint;
import cn.jpush.android.local.JPushConstants;
import com.baidu.mobads.sdk.internal.by;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.MessageDigest;
import java.util.Locale;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DataHelper {
    public static long ENVELOPE_ENTITY_RAW_LENGTH_MAX = 2097152;
    public static long ENVELOPE_EXTRA_LENGTH = 614400;
    public static long ENVELOPE_LENGTH_MAX = 204800;
    private static String UMENG_PLUS = "umeng+0123456789";

    public static String convertExceptionToString(Throwable th) {
        String str = null;
        if (th == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                cause.printStackTrace(printWriter);
            }
            str = stringWriter.toString();
            printWriter.close();
            stringWriter.close();
            return str;
        } catch (Exception unused) {
            return str;
        }
    }

    public static byte[] reverseHexString(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length % 2 != 0) {
            return null;
        }
        byte[] bArr = new byte[length / 2];
        int i6 = 0;
        while (i6 < length) {
            int i7 = i6 + 2;
            bArr[i6 / 2] = (byte) Integer.valueOf(str.substring(i6, i7), 16).intValue();
            i6 = i7;
        }
        return bArr;
    }

    public static String assembleStatelessURL(String str) {
        return JPushConstants.HTTPS_PRE + str;
    }

    public static String assembleURL(String str) {
        return JPushConstants.HTTPS_PRE + str;
    }

    static String bytes2Hex(byte[] bArr) {
        String str = "";
        for (byte b6 : bArr) {
            String hexString = Integer.toHexString(b6 & 255);
            if (hexString.length() == 1) {
                str = str + "0";
            }
            str = str + hexString;
        }
        return str;
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(2, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(UMUtils.genIv()));
        return cipher.doFinal(bArr);
    }

    @SuppressLint({"TrulyRandom"})
    public static byte[] encrypt(byte[] bArr, byte[] bArr2) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(1, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(UMUtils.genIv()));
        return cipher.doFinal(bArr);
    }

    public static byte[] hash(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(by.f10823a);
            messageDigest.reset();
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean largeThanMaxSize(long j6, long j7) {
        return j6 > j7;
    }

    public static int random(int i6, String str) {
        if (new Random().nextFloat() < 0.001d) {
            int i7 = 0;
            if (str == null) {
                MLog.e("--->", "null signature..");
            }
            try {
                i7 = Integer.parseInt(str.substring(9, 11), 16);
            } catch (Exception unused) {
            }
            return (i7 | 128) * 1000;
        }
        int nextInt = new Random().nextInt(i6);
        if (nextInt > 255000 || nextInt < 128000) {
            return nextInt;
        }
        return 127000;
    }

    public static String toHexString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b6 : bArr) {
            stringBuffer.append(String.format("%02X", Byte.valueOf(b6)));
        }
        return stringBuffer.toString().toLowerCase(Locale.US);
    }

    public static String encryptBySHA1(String str) {
        byte[] bytes = str.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(bytes);
            return bytes2Hex(messageDigest.digest());
        } catch (Exception unused) {
            return null;
        }
    }
}
