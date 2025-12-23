package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f35263a = "";

    /* renamed from: b, reason: collision with root package name */
    private static final String f35264b = "HexUtil";

    public static String b(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b6 : bArr) {
            String hexString = Integer.toHexString(b6 & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static byte[] c(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        int length = upperCase.length() / 2;
        byte[] bArr = new byte[length];
        try {
            byte[] bytes = upperCase.getBytes("UTF-8");
            for (int i6 = 0; i6 < length; i6++) {
                StringBuilder sb = new StringBuilder();
                sb.append("0x");
                int i7 = i6 * 2;
                sb.append(new String(new byte[]{bytes[i7]}, "UTF-8"));
                bArr[i6] = (byte) (((byte) (Byte.decode(sb.toString()).byteValue() << 4)) ^ Byte.decode("0x" + new String(new byte[]{bytes[i7 + 1]}, "UTF-8")).byteValue());
            }
        } catch (UnsupportedEncodingException e6) {
            e = e6;
            e.getMessage();
        } catch (NumberFormatException e7) {
            e = e7;
            e.getMessage();
        } catch (Exception e8) {
            e8.getMessage();
        }
        return bArr;
    }

    private c() {
    }

    public static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return b(str.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e6) {
                e6.getMessage();
                return "";
            } catch (Exception e7) {
                e7.getMessage();
                return "";
            }
        }
        return "";
    }
}
