package cn.jiguang.api.utils;

import cn.jiguang.api.JResponse;
import cn.jiguang.bx.d;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/* loaded from: D:\Downloads\app\classes2.dex */
public class ByteBufferUtils {
    public static final int ERROR_CODE = 10000;
    private static final String TAG = "ByteBufferUtils";

    public static Byte get(ByteBuffer byteBuffer, JResponse jResponse) {
        try {
            return Byte.valueOf(byteBuffer.get());
        } catch (BufferOverflowException | BufferUnderflowException | Exception e6) {
            onException(e6.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse == null) {
                return null;
            }
            jResponse.code = 10000;
            return null;
        }
    }

    private static String generalExtraStr(Throwable th, JResponse jResponse, ByteBuffer byteBuffer) {
        StringBuilder sb = new StringBuilder();
        if (jResponse != null) {
            sb.append(jResponse.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("|bytebuffer:");
            sb2.append(byteBuffer == null ? "byteBuffer is null" : byteBuffer.toString());
            sb.append(sb2.toString());
        }
        d.f(TAG, "byteBuffer info:" + sb.toString());
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            d.f(TAG, "parse data error stackTrace:" + stringWriter.toString());
        } catch (Exception unused) {
        }
        return sb.toString();
    }

    public static ByteBuffer get(ByteBuffer byteBuffer, byte[] bArr, JResponse jResponse) {
        try {
            return byteBuffer.get(bArr);
        } catch (BufferOverflowException | BufferUnderflowException | Exception e6) {
            onException(e6.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse == null) {
                return null;
            }
            jResponse.code = 10000;
            return null;
        }
    }

    public static int getInt(ByteBuffer byteBuffer, JResponse jResponse) {
        try {
            return byteBuffer.getInt();
        } catch (BufferOverflowException | BufferUnderflowException | Exception e6) {
            onException(e6.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse != null) {
                jResponse.code = 10000;
                return -1;
            }
            return -1;
        }
    }

    public static long getLong(ByteBuffer byteBuffer, JResponse jResponse) {
        try {
            return byteBuffer.getLong();
        } catch (BufferOverflowException | BufferUnderflowException | Exception e6) {
            onException(e6.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse != null) {
                jResponse.code = 10000;
                return 0L;
            }
            return 0L;
        }
    }

    public static short getShort(ByteBuffer byteBuffer, JResponse jResponse) {
        try {
            return byteBuffer.getShort();
        } catch (BufferOverflowException | BufferUnderflowException | Exception e6) {
            onException(e6.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse != null) {
                jResponse.code = 10000;
                return (short) -1;
            }
            return (short) -1;
        }
    }

    private static void onException(Throwable th, JResponse jResponse, ByteBuffer byteBuffer) {
        generalExtraStr(th, jResponse, byteBuffer);
    }
}
