package com.kuaishou.weapon.p0;

/* loaded from: D:\Downloads\app\classes6.dex */
public class i {
    public static byte[] a(byte[] bArr, String str) {
        if (bArr == null || str == null) {
            return null;
        }
        return c(bArr, str);
    }

    public static byte[] b(byte[] bArr, String str) {
        if (bArr == null || str == null) {
            return null;
        }
        return c(bArr, str);
    }

    private static byte[] c(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        byte[] bytes = str.getBytes();
        for (int i6 = 0; i6 < length; i6++) {
            int i7 = i6 * 2;
            bArr[i6] = a(bytes[i7], bytes[i7 + 1]);
        }
        return bArr;
    }

    public static String a(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        return new String(c(c(str), str2));
    }

    private static byte[] b(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        return c(str.getBytes(), str2);
    }

    private static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        for (byte b6 : bArr) {
            stringBuffer.append((char) b6);
        }
        return stringBuffer.toString();
    }

    private static String b(String str) {
        String str2 = "";
        for (int i6 = 0; i6 < str.length(); i6++) {
            String hexString = Integer.toHexString(str.charAt(i6) & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            str2 = str2 + hexString;
        }
        return str2;
    }

    private static byte[] c(byte[] bArr, String str) {
        byte[] a6 = a(str);
        byte[] bArr2 = new byte[bArr.length];
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < bArr.length; i8++) {
            i6 = (i6 + 1) & 255;
            byte b6 = a6[i6];
            i7 = ((b6 & 255) + i7) & 255;
            a6[i6] = a6[i7];
            a6[i7] = b6;
            int i9 = ((a6[i6] & 255) + (b6 & 255)) & 255;
            bArr2[i8] = (byte) (a6[i9] ^ bArr[i8]);
        }
        return bArr2;
    }

    private static byte[] a(String str) {
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[256];
        for (int i6 = 0; i6 < 256; i6++) {
            bArr[i6] = (byte) i6;
        }
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < 256; i9++) {
            int i10 = bytes[i7] & 255;
            byte b6 = bArr[i9];
            i8 = (i10 + (b6 & 255) + i8) & 255;
            bArr[i9] = bArr[i8];
            bArr[i8] = b6;
            i7 = (i7 + 1) % bytes.length;
        }
        return bArr;
    }

    private static byte a(byte b6, byte b7) {
        return (byte) (((char) (((char) Byte.decode("0x" + new String(new byte[]{b6})).byteValue()) << 4)) ^ ((char) Byte.decode("0x" + new String(new byte[]{b7})).byteValue()));
    }
}
