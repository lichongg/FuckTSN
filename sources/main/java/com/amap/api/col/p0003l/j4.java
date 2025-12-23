package com.amap.api.col.p0003l;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okio.Utf8;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class j4 {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f6626a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f6627b = new byte[128];

    public static byte[] g(String str) {
        int i6;
        byte b6;
        int i7;
        byte b7;
        int i8 = 0;
        if (str == null) {
            return new byte[0];
        }
        byte[] o5 = q4.o(str);
        int length = o5.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        while (i8 < length) {
            while (true) {
                i6 = i8 + 1;
                b6 = f6627b[o5[i8]];
                if (i6 >= length || b6 != -1) {
                    break;
                }
                i8 = i6;
            }
            if (b6 == -1) {
                break;
            }
            while (true) {
                i7 = i6 + 1;
                b7 = f6627b[o5[i6]];
                if (i7 >= length || b7 != -1) {
                    break;
                }
                i6 = i7;
            }
            if (b7 == -1) {
                break;
            }
            byteArrayOutputStream.write((b6 << 2) | ((b7 & 48) >>> 4));
            while (i7 != length) {
                int i9 = i7 + 1;
                byte b8 = o5[i7];
                if (b8 == 61) {
                    return byteArrayOutputStream.toByteArray();
                }
                byte b9 = f6627b[b8];
                if (i9 >= length || b9 != -1) {
                    if (b9 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(((b7 & 15) << 4) | ((b9 & 60) >>> 2));
                    while (i9 != length) {
                        int i10 = i9 + 1;
                        byte b10 = o5[i9];
                        if (b10 == 61) {
                            return byteArrayOutputStream.toByteArray();
                        }
                        byte b11 = f6627b[b10];
                        if (i10 < length && b11 == -1) {
                            i9 = i10;
                        } else {
                            if (b11 == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(b11 | ((b9 & 3) << 6));
                            i8 = i10;
                        }
                    }
                    return byteArrayOutputStream.toByteArray();
                }
                i7 = i9;
            }
            return byteArrayOutputStream.toByteArray();
        }
        return byteArrayOutputStream.toByteArray();
    }

    static {
        for (int i6 = 0; i6 < 128; i6++) {
            f6627b[i6] = -1;
        }
        for (int i7 = 65; i7 <= 90; i7++) {
            f6627b[i7] = (byte) (i7 - 65);
        }
        for (int i8 = 97; i8 <= 122; i8++) {
            f6627b[i8] = (byte) (i8 - 71);
        }
        for (int i9 = 48; i9 <= 57; i9++) {
            f6627b[i9] = (byte) (i9 + 4);
        }
        byte[] bArr = f6627b;
        bArr[43] = 62;
        bArr[47] = Utf8.REPLACEMENT_BYTE;
    }

    public static byte[] b(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(q4.u("EQUVT"));
        if (keyGenerator == null) {
            return null;
        }
        keyGenerator.init(256);
        byte[] encoded = keyGenerator.generateKey().getEncoded();
        PublicKey x5 = q4.x();
        if (x5 == null) {
            return null;
        }
        byte[] c6 = c(encoded, x5);
        byte[] d6 = d(encoded, bArr);
        byte[] bArr2 = new byte[c6.length + d6.length];
        System.arraycopy(c6, 0, bArr2, 0, c6.length);
        System.arraycopy(d6, 0, bArr2, c6.length, d6.length);
        return bArr2;
    }

    static byte[] c(byte[] bArr, Key key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(q4.u("CUlNBL0VDQi9QS0NTMVBhZGRpbmc"));
        cipher.init(1, key);
        return cipher.doFinal(bArr);
    }

    public static byte[] e(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, q4.u("EQUVT"));
        Cipher cipher = Cipher.getInstance(q4.u("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
        cipher.init(2, secretKeySpec, ivParameterSpec);
        return cipher.doFinal(bArr2);
    }

    private static byte[] j(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, q4.u("EQUVT"));
        Cipher cipher = Cipher.getInstance(q4.u("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
        try {
            cipher.init(1, secretKeySpec, ivParameterSpec);
        } catch (InvalidAlgorithmParameterException e6) {
            e6.printStackTrace();
        }
        return cipher.doFinal(bArr2);
    }

    private static String k(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i6 = 0;
        while (true) {
            if (i6 >= length) {
                break;
            }
            int i7 = i6 + 1;
            byte b6 = bArr[i6];
            int i8 = b6 & 255;
            if (i7 == length) {
                char[] cArr = f6626a;
                stringBuffer.append(cArr[i8 >>> 2]);
                stringBuffer.append(cArr[(b6 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i9 = i6 + 2;
            byte b7 = bArr[i7];
            if (i9 == length) {
                char[] cArr2 = f6626a;
                stringBuffer.append(cArr2[i8 >>> 2]);
                stringBuffer.append(cArr2[((b6 & 3) << 4) | ((b7 & 240) >>> 4)]);
                stringBuffer.append(cArr2[(b7 & 15) << 2]);
                stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
                break;
            }
            i6 += 3;
            byte b8 = bArr[i9];
            char[] cArr3 = f6626a;
            stringBuffer.append(cArr3[i8 >>> 2]);
            stringBuffer.append(cArr3[((b6 & 3) << 4) | ((b7 & 240) >>> 4)]);
            stringBuffer.append(cArr3[((b7 & 15) << 2) | ((b8 & 192) >>> 6)]);
            stringBuffer.append(cArr3[b8 & Utf8.REPLACEMENT_BYTE]);
        }
        return stringBuffer.toString();
    }

    public static String a(String str) {
        return q4.g(g(str));
    }

    private static byte[] d(byte[] bArr, byte[] bArr2) {
        try {
            return j(bArr, bArr2, q4.v());
        } catch (Throwable th) {
            r5.e(th, "er", "asEn");
            return null;
        }
    }

    public static String f(byte[] bArr) {
        try {
            return k(bArr);
        } catch (Throwable th) {
            r5.e(th, "er", "e64");
            return null;
        }
    }

    public static byte[] h(byte[] bArr, byte[] bArr2, byte[] bArr3) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        return j(bArr, bArr2, bArr3);
    }

    public static String i(byte[] bArr) {
        try {
            return k(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
