package com.autonavi.base.amap.mapcore.tools;

import java.io.ByteArrayOutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class GLConvertUtil {
    public static byte[] get1BString(String str) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes = str.getBytes("UTF-8");
            byteArrayOutputStream.write(new byte[]{(byte) bytes.length});
            byteArrayOutputStream.write(bytes);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e6) {
            e6.printStackTrace();
            return new byte[1];
        }
    }

    public static double convertDouble(byte[] bArr, int i6) {
        long j6 = 0;
        for (int i7 = 0; i7 < 8; i7++) {
            j6 += (bArr[i7 + i6] & 255) << (i7 * 8);
        }
        return Double.longBitsToDouble(j6);
    }

    public static byte[] convertInt(int i6) {
        return new byte[]{(byte) (i6 & 255), (byte) ((i6 >> 8) & 255), (byte) ((i6 >> 16) & 255), (byte) ((i6 >> 24) & 255)};
    }

    public static byte[] convertShort(int i6) {
        return new byte[]{(byte) (i6 & 255), (byte) ((i6 >> 8) & 255)};
    }

    public static int getInt(byte[] bArr, int i6) {
        int i7 = bArr[i6 + 3] & 255;
        int i8 = bArr[i6 + 2] & 255;
        int i9 = bArr[i6 + 1] & 255;
        return (i7 << 24) + (i8 << 16) + (i9 << 8) + (bArr[i6] & 255);
    }

    public static int getInt2(byte[] bArr, int i6) {
        int i7 = bArr[i6] & 255;
        int i8 = bArr[i6 + 1] & 255;
        int i9 = bArr[i6 + 2] & 255;
        return (i7 << 24) + (i8 << 16) + (i9 << 8) + (bArr[i6 + 3] & 255);
    }

    public static long getLong(byte[] bArr, int i6) {
        return ((bArr[i6 + 7] & 255) << 56) + ((bArr[i6 + 6] & 255) << 48) + ((bArr[i6 + 5] & 255) << 40) + ((bArr[i6 + 4] & 255) << 32) + ((bArr[i6 + 3] & 255) << 24) + ((bArr[i6 + 2] & 255) << 16) + ((bArr[i6 + 1] & 255) << 8) + (bArr[i6] & 255);
    }

    public static short getShort(byte[] bArr, int i6) {
        int i7 = bArr[i6 + 1] & 255;
        return (short) ((i7 << 8) + (bArr[i6] & 255));
    }

    public static short getShort2(byte[] bArr, int i6) {
        int i7 = bArr[i6] & 255;
        return (short) ((i7 << 8) + (bArr[i6 + 1] & 255));
    }

    public static String getString(byte[] bArr, int i6, int i7) {
        try {
            return new String(bArr, i6, i7, "UTF-8");
        } catch (Exception unused) {
            return "";
        }
    }

    public static byte[] getSubBytes(byte[] bArr, int i6, int i7) {
        byte[] bArr2 = new byte[i7];
        System.arraycopy(bArr, i6, bArr2, 0, i7);
        return bArr2;
    }

    public static int getUShort(byte[] bArr, int i6) {
        int i7 = bArr[i6 + 1] & 255;
        return (i7 << 8) + (bArr[i6] & 255);
    }

    public static void moveArray(byte[] bArr, int i6, byte[] bArr2, int i7, int i8) {
        byte[] bArr3 = new byte[i8];
        System.arraycopy(bArr, i6, bArr3, 0, i8);
        System.arraycopy(bArr3, 0, bArr2, i7, i8);
    }

    public static void writeInt(byte[] bArr, int i6, int i7) {
        System.arraycopy(convertInt(i7), 0, bArr, i6, 4);
    }

    public static void writeShort(byte[] bArr, int i6, short s5) {
        System.arraycopy(convertShort(s5), 0, bArr, i6, 2);
    }
}
