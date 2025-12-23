package com.tsn.chat.utils;

import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class e {
    public static int a(byte[] bArr) {
        return (bArr[3] << 24) | (bArr[0] & 255) | ((bArr[1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | ((bArr[2] << 24) >>> 8);
    }

    public static short b(byte[] bArr) {
        return (short) (((short) (((short) (bArr[1] & 255)) << 8)) | ((short) (bArr[0] & 255)));
    }

    public static String c(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        int i6 = 0;
        for (byte b6 : bArr) {
            i6++;
            sb.append("0123456789abcdef".charAt((b6 >> 4) & 15));
            sb.append("0123456789abcdef".charAt(b6 & 15));
            sb.append(" ");
            if (i6 == 8) {
                sb.append("  ");
            } else if (i6 == 16) {
                sb.append(com.snail.antifake.deviceid.e.f37542d);
                i6 = 0;
            }
        }
        return sb.toString();
    }

    public static String d(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b6 : bArr) {
            sb.append("0123456789abcdef".charAt((b6 >> 4) & 15));
            sb.append("0123456789abcdef".charAt(b6 & 15));
            sb.append("-");
        }
        return sb.toString().substring(0, sb.toString().length() - 1);
    }

    public static String e(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b6 : bArr) {
            sb.append("0123456789abcdef".charAt((b6 >> 4) & 15));
            sb.append("0123456789abcdef".charAt(b6 & 15));
        }
        return sb.toString();
    }

    public static byte[] f(byte b6) {
        byte[] bArr = new byte[8];
        for (int i6 = 7; i6 >= 0; i6--) {
            bArr[i6] = (byte) (b6 & 1);
            b6 = (byte) (b6 >> 1);
        }
        return bArr;
    }

    public static byte[] i(int i6) {
        return new byte[]{(byte) (i6 & 255), (byte) ((65280 & i6) >> 8), (byte) ((16711680 & i6) >> 16), (byte) ((i6 & ViewCompat.MEASURED_STATE_MASK) >> 24)};
    }

    public static String j(String str) {
        String str2 = "";
        for (int i6 = 0; i6 < str.length(); i6++) {
            str2 = String.valueOf(str2) + Integer.toHexString(str.charAt(i6));
        }
        return str2;
    }

    private static byte k(String str, String str2) {
        return (byte) (((byte) (Byte.decode("0x" + str).byteValue() << 4)) | Byte.decode("0x" + str2).byteValue());
    }

    public static byte[] g(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i6 = 0; i6 < length; i6++) {
            int i7 = i6 * 2;
            int i8 = i7 + 1;
            bArr[i6] = k(str.substring(i7, i8), str.substring(i8, i7 + 2));
        }
        return bArr;
    }

    public static String h(String str) {
        char[] charArray = str.toCharArray();
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i6 = 0; i6 < length; i6++) {
            int i7 = i6 * 2;
            bArr[i6] = (byte) ((("0123456789ABCDEF".indexOf(charArray[i7]) * 16) + "0123456789ABCDEF".indexOf(charArray[i7 + 1])) & 255);
        }
        return new String(bArr);
    }
}
