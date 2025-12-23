package com.bytedance.sdk.component.panglearmor.j.j.xt.j;

import com.bytedance.sdk.component.panglearmor.j.j.j.xt;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    public static cw j(com.bytedance.sdk.component.panglearmor.j.xt.xt xtVar, com.bytedance.sdk.component.panglearmor.j.j.cw.xt xtVar2, int i6) throws IOException, Exception {
        try {
            xt.j j6 = com.bytedance.sdk.component.panglearmor.j.j.j.xt.j(xtVar, xtVar2);
            long j7 = j6.j();
            com.bytedance.sdk.component.panglearmor.j.xt.xt xt = j6.xt();
            ByteBuffer j8 = xt.j(0L, (int) xt.j());
            j8.order(ByteOrder.LITTLE_ENDIAN);
            return new cw(j(j8, i6), j7, xtVar2.j(), xtVar2.r(), xtVar2.up());
        } catch (Exception e6) {
            throw new Exception(e6.getMessage(), e6);
        }
    }

    private static ByteBuffer xt(ByteBuffer byteBuffer, int i6) {
        if (i6 < 0) {
            throw new IllegalArgumentException("size: ".concat(String.valueOf(i6)));
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        int i7 = i6 + position;
        if (i7 < position || i7 > limit) {
            throw new BufferUnderflowException();
        }
        byteBuffer.limit(i7);
        try {
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            byteBuffer.position(i7);
            return slice;
        } finally {
            byteBuffer.limit(limit);
        }
    }

    public static byte[] cw(ByteBuffer byteBuffer) throws Exception {
        int i6 = byteBuffer.getInt();
        if (i6 >= 0) {
            if (i6 <= byteBuffer.remaining()) {
                byte[] bArr = new byte[i6];
                byteBuffer.get(bArr);
                return bArr;
            }
            throw new Exception("Underflow while reading length-prefixed value. Length: " + i6 + ", available: " + byteBuffer.remaining());
        }
        throw new Exception("Negative length");
    }

    public static ByteBuffer xt(ByteBuffer byteBuffer) throws Exception {
        if (byteBuffer.remaining() >= 4) {
            int i6 = byteBuffer.getInt();
            if (i6 >= 0) {
                if (i6 <= byteBuffer.remaining()) {
                    return xt(byteBuffer, i6);
                }
                throw new Exception("Length-prefixed field longer than remaining buffer. Field length: " + i6 + ", remaining: " + byteBuffer.remaining());
            }
            throw new IllegalArgumentException("Negative length");
        }
        throw new Exception("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
    }

    public static ByteBuffer j(ByteBuffer byteBuffer, int i6) throws Exception {
        j(byteBuffer);
        ByteBuffer j6 = j(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i7 = 0;
        while (j6.hasRemaining()) {
            i7++;
            if (j6.remaining() >= 8) {
                long j7 = j6.getLong();
                if (j7 < 4 || j7 > 2147483647L) {
                    throw new Exception("APK Signing Block entry #" + i7 + " size out of range: " + j7);
                }
                int i8 = (int) j7;
                int position = j6.position() + i8;
                if (i8 > j6.remaining()) {
                    throw new Exception("APK Signing Block entry #" + i7 + " size out of range: " + i8 + ", available: " + j6.remaining());
                }
                if (j6.getInt() == i6) {
                    return xt(j6, i8 - 4);
                }
                j6.position(position);
            } else {
                throw new Exception("Insufficient data to read size of APK Signing Block entry #".concat(String.valueOf(i7)));
            }
        }
        throw new Exception("No APK Signature Scheme block in APK Signing Block with ID: ".concat(String.valueOf(i6)));
    }

    public static void j(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static ByteBuffer j(ByteBuffer byteBuffer, int i6, int i7) {
        if (i6 < 0) {
            throw new IllegalArgumentException("start: ".concat(String.valueOf(i6)));
        }
        if (i7 >= i6) {
            int capacity = byteBuffer.capacity();
            if (i7 <= byteBuffer.capacity()) {
                int limit = byteBuffer.limit();
                int position = byteBuffer.position();
                try {
                    byteBuffer.position(0);
                    byteBuffer.limit(i7);
                    byteBuffer.position(i6);
                    ByteBuffer slice = byteBuffer.slice();
                    slice.order(byteBuffer.order());
                    return slice;
                } finally {
                    byteBuffer.position(0);
                    byteBuffer.limit(limit);
                    byteBuffer.position(position);
                }
            }
            throw new IllegalArgumentException("end > capacity: " + i7 + " > " + capacity);
        }
        throw new IllegalArgumentException("end < start: " + i7 + " < " + i6);
    }
}
