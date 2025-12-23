package com.bytedance.sdk.openadsdk.core.p.j;

import com.kuaishou.weapon.p0.bi;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    public static String j(byte[] bArr, int i6) {
        StringBuilder sb = new StringBuilder(".");
        for (int i7 = 0; i7 < bArr.length; i7++) {
            sb.append(String.format("%02X", Byte.valueOf(bArr[i7])));
            if (i7 > 0 && i7 % i6 == 0 && i7 != bArr.length - 1) {
                sb.append(bi.f35777j);
            }
        }
        return sb.toString();
    }

    public static byte[] j(String str) {
        String replaceAll = str.replaceAll("/", "").replaceAll("\\.", "");
        int length = replaceAll.length();
        byte[] bArr = new byte[length / 2];
        for (int i6 = 0; i6 < length; i6 += 2) {
            bArr[i6 / 2] = (byte) ((Character.digit(replaceAll.charAt(i6), 16) << 4) + Character.digit(replaceAll.charAt(i6 + 1), 16));
        }
        return bArr;
    }
}
