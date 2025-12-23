package cn.jiguang.api.utils;

import cn.jiguang.api.JResponse;
import cn.jiguang.bx.d;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: D:\Downloads\app\classes2.dex */
public class ProtocolUtil {
    private static final String ENCODING_UTF_8 = "UTF-8";
    private static final String TAG = "ProtocolUtil";

    public static byte[] fixedStringToBytes(String str, int i6) {
        byte[] bArr;
        if (str != null && !"".equals(str)) {
            try {
                bArr = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused) {
                bArr = null;
            }
            if (bArr != null) {
                byte[] defaultByte = getDefaultByte(i6);
                if (bArr.length <= i6) {
                    i6 = bArr.length;
                }
                System.arraycopy(bArr, 0, defaultByte, 0, i6);
                return defaultByte;
            }
        }
        return new byte[]{0, 0, 0, 0};
    }

    public static byte[] getBytes(ByteBuffer byteBuffer) {
        try {
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.asReadOnlyBuffer().flip();
            byteBuffer.get(bArr);
            return bArr;
        } catch (NegativeArraySizeException unused) {
            d.c(TAG, "[getBytes] - ByteBuffer error.");
            return null;
        } catch (Exception unused2) {
            return null;
        }
    }

    public static byte[] getBytesConsumed(ByteBuffer byteBuffer) {
        try {
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return bArr;
        } catch (NegativeArraySizeException unused) {
            d.c(TAG, "[getBytesConsumed] - ByteBuffer error.");
            return null;
        } catch (Exception unused2) {
            return null;
        }
    }

    public static String getTlv2(ByteBuffer byteBuffer) {
        try {
            byte[] bArr = new byte[byteBuffer.getShort()];
            byteBuffer.get(bArr);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException | Exception unused) {
            return null;
        }
    }

    public static byte[] tlv2ToByteArray(String str) {
        byte[] bArr;
        if (str != null && !"".equals(str)) {
            try {
                bArr = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused) {
                bArr = null;
            }
            if (bArr != null) {
                short length = (short) bArr.length;
                byte[] bArr2 = new byte[length + 2];
                System.arraycopy(short2ByteArray(length), 0, bArr2, 0, 2);
                System.arraycopy(bArr, 0, bArr2, 2, length);
                return bArr2;
            }
        }
        return new byte[]{0, 0};
    }

    public static byte[] getDefaultByte(int i6) {
        byte[] bArr = new byte[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            bArr[0] = 0;
        }
        return bArr;
    }

    public static String getString(ByteBuffer byteBuffer, int i6) {
        byte[] bArr = new byte[i6];
        byteBuffer.get(bArr);
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static String getTlv2(ByteBuffer byteBuffer, JResponse jResponse) {
        int i6 = ByteBufferUtils.getShort(byteBuffer, jResponse);
        if (i6 < 0) {
            d.c(TAG, "[getTlv2] - ByteBuffer error.");
            return null;
        }
        byte[] bArr = new byte[i6];
        ByteBufferUtils.get(byteBuffer, bArr, jResponse);
        try {
            return new String(bArr, "UTF-8");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] int2ByteArray(int i6) {
        return new byte[]{(byte) (i6 >>> 24), (byte) (i6 >>> 16), (byte) (i6 >>> 8), (byte) i6};
    }

    public static byte[] long2ByteArray(long j6) {
        return new byte[]{(byte) (j6 >>> 56), (byte) (j6 >>> 48), (byte) (j6 >>> 40), (byte) (j6 >>> 32), (byte) (j6 >>> 24), (byte) (j6 >>> 16), (byte) (j6 >>> 8), (byte) j6};
    }

    public static byte[] short2ByteArray(short s5) {
        return new byte[]{(byte) (s5 >>> 8), (byte) s5};
    }

    public static void fillIntData(byte[] bArr, int i6, int i7) {
        System.arraycopy(int2ByteArray(i6), 0, bArr, i7, 4);
    }

    public static void fillStringData(byte[] bArr, String str, int i6) {
        byte[] bytes = str.getBytes();
        System.arraycopy(bytes, 0, bArr, i6, bytes.length);
    }
}
