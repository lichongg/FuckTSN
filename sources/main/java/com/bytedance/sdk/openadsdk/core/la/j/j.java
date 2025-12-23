package com.bytedance.sdk.openadsdk.core.la.j;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.sdk.openadsdk.core.la.g;
import com.bytedance.sdk.openadsdk.core.la.oq;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    public static void j(g gVar, int i6, String str) throws Exception {
        if (gVar == null) {
            return;
        }
        String[] j6 = oq.j(false);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ipv4List", j6[0]);
        jSONObject.put("ipv6List", j6[1]);
        jSONObject.put("networkType", String.valueOf(i6));
        jSONObject.put(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME, str);
        String jSONObject2 = jSONObject.toString();
        byte[] j7 = j(16);
        String j8 = j(j7, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkzi87lcyX1t/OSjlmjmj\nUFTAb0Y0wPZ79j10sjVrDtV+lMZXz/hOalITFyXRpmS8g8I1H3AlhihQQsierIFa\nQj5omUsXhzvNO+4DorkMJ14n1o1sfL0iOLTrzydghuUpyspj0M8v5bJTBbLv8DGM\nreKtJ8sbIYC5aj8pAdxn+YTnZ4Rhp/pNRbmIAlxs4Btu3whJt/RTfEASgsDRaTgO\nr9Rlj2YDiyEM4T3d0LsLjNed7B0Ogulzj6OzvHj+foIyb+YEEn6C5F9r+uNY2l2i\nYlHfaizd1HKfISrcAseJu6lGKRP0I3mv538Twqg1u0DFV6waQ9gwgOhq4ORCiNpd\nIQIDAQAB");
        String j9 = j(jSONObject2.getBytes(), j7);
        gVar.j("sdkSecret", j8);
        gVar.j("sdkData", j9);
    }

    public static String j(byte[] bArr, byte[] bArr2) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(1, new SecretKeySpec(bArr2, "AES"), new GCMParameterSpec(128, Arrays.copyOf(bArr2, 12)));
        return Base64.encodeToString(cipher.doFinal(bArr), 2);
    }

    public static String j(byte[] bArr, String str) throws Exception {
        if (bArr == null || TextUtils.isEmpty(str)) {
            return null;
        }
        RSAPublicKey j6 = j(str);
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        cipher.init(1, j6);
        return Base64.encodeToString(j(bArr, cipher, (j6.getModulus().bitLength() / 8) - 66), 2);
    }

    private static RSAPublicKey j(String str) throws Exception {
        return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
    }

    private static byte[] j(byte[] bArr, Cipher cipher, int i6) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            int length = bArr.length;
            int i7 = 0;
            int i8 = 0;
            while (true) {
                int i9 = length - i7;
                if (i9 > 0) {
                    byte[] doFinal = cipher.doFinal(bArr, i7, Math.min(i9, i6));
                    byteArrayOutputStream.write(doFinal, 0, doFinal.length);
                    i8++;
                    i7 = i8 * i6;
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static byte[] j(int i6) {
        byte[] bArr = new byte[i6];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }
}
