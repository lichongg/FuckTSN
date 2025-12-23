package xyz.adscope.common.network.secure;

import com.baidu.mobads.sdk.internal.by;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class Encryption {
    public static String byteArrayToHex(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i6 : bArr) {
            while (i6 < 0) {
                i6 += 256;
            }
            if (i6 < 16) {
                sb.append("0");
            }
            sb.append(Integer.toString(i6, 16));
        }
        return sb.toString();
    }

    public static Secret createSecret(String str) {
        try {
            return new AESSecret(str);
        } catch (GeneralSecurityException unused) {
            return new SafeSecret();
        }
    }

    public static String getMD5ForString(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            byte[] digest = MessageDigest.getInstance(by.f10823a).digest(str.getBytes());
            int length = digest.length;
            for (int i6 = 0; i6 < length; i6++) {
                int i7 = digest[i6];
                if (i7 < 0) {
                    i7 += 256;
                }
                if (i7 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i7));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            return str;
        }
    }

    public static byte[] hexToByteArray(String str) {
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        byte[] bArr = new byte[length / 2];
        for (int i6 = 0; i6 < length; i6 += 2) {
            bArr[i6 / 2] = (byte) Integer.parseInt(new String(bytes, i6, 2), 16);
        }
        return bArr;
    }
}
