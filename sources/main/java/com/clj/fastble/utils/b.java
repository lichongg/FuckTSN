package com.clj.fastble.utils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f32146a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f32147b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static byte[] b(char[] cArr) {
        int length = cArr.length;
        if ((length & 1) != 0) {
            throw new RuntimeException("Odd number of characters.");
        }
        byte[] bArr = new byte[length >> 1];
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            int i8 = i6 + 1;
            int m6 = (m(cArr[i6], i6) << 4) | m(cArr[i8], i8);
            i6 += 2;
            bArr[i7] = (byte) (m6 & 255);
            i7++;
        }
        return bArr;
    }

    public static char[] c(byte[] bArr) {
        return d(bArr, true);
    }

    public static String f(byte[] bArr) {
        return g(bArr, true);
    }

    public static String j(byte[] bArr) {
        return k(bArr, false);
    }

    public static byte a(char c6) {
        return (byte) "0123456789ABCDEF".indexOf(c6);
    }

    public static char[] d(byte[] bArr, boolean z5) {
        return e(bArr, z5 ? f32146a : f32147b);
    }

    protected static char[] e(byte[] bArr, char[] cArr) {
        if (bArr == null) {
            return null;
        }
        char[] cArr2 = new char[bArr.length << 1];
        int i6 = 0;
        for (byte b6 : bArr) {
            int i7 = i6 + 1;
            cArr2[i6] = cArr[(b6 & 240) >>> 4];
            i6 += 2;
            cArr2[i7] = cArr[b6 & 15];
        }
        return cArr2;
    }

    public static String g(byte[] bArr, boolean z5) {
        return h(bArr, z5 ? f32146a : f32147b);
    }

    protected static String h(byte[] bArr, char[] cArr) {
        return new String(e(bArr, cArr));
    }

    public static String i(byte[] bArr, int i6) {
        return j(new byte[]{bArr[i6]});
    }

    public static String k(byte[] bArr, boolean z5) {
        if (bArr == null || bArr.length < 1) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (byte b6 : bArr) {
            String hexString = Integer.toHexString(b6 & 255);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            sb.append(hexString);
            if (z5) {
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static byte[] l(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        String upperCase = str.trim().toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i6 = 0; i6 < length; i6++) {
            int i7 = i6 * 2;
            bArr[i6] = (byte) (a(charArray[i7 + 1]) | (a(charArray[i7]) << 4));
        }
        return bArr;
    }

    protected static int m(char c6, int i6) {
        int digit = Character.digit(c6, 16);
        if (digit != -1) {
            return digit;
        }
        throw new RuntimeException("Illegal hexadecimal character " + c6 + " at index " + i6);
    }
}
