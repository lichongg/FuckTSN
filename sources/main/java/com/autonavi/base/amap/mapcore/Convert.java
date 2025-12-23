package com.autonavi.base.amap.mapcore;

import java.io.ByteArrayOutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class Convert {
    public static byte[] covertBytes(byte b6) {
        return new byte[]{b6};
    }

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

    public static int getNum(byte b6, int i6, int i7) {
        int i8 = 31 - i7;
        return ((b6 << i8) >>> i8) >>> i6;
    }

    public static final String bytesToHexString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        for (byte b6 : bArr) {
            String hexString = Integer.toHexString(b6 & 255);
            if (hexString.length() < 2) {
                stringBuffer.append(0);
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        return stringBuffer.toString();
    }

    public static void convert1bString(byte[] bArr, int i6, ConvertString convertString) {
        try {
            byte b6 = bArr[i6];
            convertString.byteLength = b6;
            convertString.value = new String(bArr, i6 + 1, b6, "UTF-8");
        } catch (Exception e6) {
            e6.printStackTrace();
            convertString.byteLength = 0;
            convertString.value = "";
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

    public static byte[] copyString(byte[] bArr, int i6, int i7) {
        byte[] bArr2 = new byte[i7];
        System.arraycopy(bArr, i6, bArr2, 0, i7);
        return bArr2;
    }

    public static byte[] get2BString(String str) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes = str.getBytes("UTF-8");
            byteArrayOutputStream.write(convertShort(bytes.length));
            byteArrayOutputStream.write(bytes);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e6) {
            e6.printStackTrace();
            return new byte[1];
        }
    }

    public static boolean getBit(byte b6, int i6) {
        int i7 = 32 - i6;
        return (((b6 << i7) >>> i7) >>> (i6 - 1)) > 0;
    }

    public static byte[] getDouble(double d6) {
        byte[] bArr = new byte[8];
        String hexString = Long.toHexString(Double.doubleToLongBits(d6));
        for (int i6 = 0; i6 < 8; i6++) {
            int i7 = i6 * 2;
            bArr[7 - i6] = (byte) Integer.parseInt(hexString.substring(i7, i7 + 2), 16);
        }
        return bArr;
    }

    public static int getInt(byte[] bArr, int i6) {
        int i7 = bArr[i6 + 3] & 255;
        int i8 = bArr[i6 + 2] & 255;
        int i9 = bArr[i6 + 1] & 255;
        return (i7 << 24) + (i8 << 16) + (i9 << 8) + (bArr[i6] & 255);
    }

    public static int getNum(short s5, int i6, int i7) {
        int i8 = 32 - i7;
        return ((s5 << i8) >>> i8) >>> (i6 - 1);
    }

    public static short getShort(byte[] bArr, int i6) {
        int i7 = bArr[i6 + 1] & 255;
        return (short) ((i7 << 8) + (bArr[i6] & 255));
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

    public static void convert2bString(byte[] bArr, int i6, ConvertString convertString) {
        try {
            short s5 = getShort(bArr, i6);
            convertString.byteLength = s5;
            convertString.value = new String(bArr, i6 + 2, s5, "UTF-8");
        } catch (Exception e6) {
            e6.printStackTrace();
            convertString.byteLength = 0;
            convertString.value = "";
        }
    }

    public static void writeInt(byte[] bArr, int i6, int i7) {
        System.arraycopy(convertInt(i7), 0, bArr, i6, 4);
    }

    public static void writeShort(byte[] bArr, int i6, short s5) {
        System.arraycopy(convertShort(s5), 0, bArr, i6, 2);
    }
}
