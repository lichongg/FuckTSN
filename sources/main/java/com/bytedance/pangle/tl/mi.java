package com.bytedance.pangle.tl;

import android.util.Pair;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.j1;

/* loaded from: D:\Downloads\app\classes4.dex */
abstract class mi {
    static Pair<ByteBuffer, Long> j(RandomAccessFile randomAccessFile) throws IOException {
        if (randomAccessFile.length() < 22) {
            return null;
        }
        Pair<ByteBuffer, Long> j6 = j(randomAccessFile, 0);
        return j6 != null ? j6 : j(randomAccessFile, 65535);
    }

    public static long xt(ByteBuffer byteBuffer) {
        r(byteBuffer);
        return xt(byteBuffer, byteBuffer.position() + 12);
    }

    private static int cw(ByteBuffer byteBuffer) {
        r(byteBuffer);
        int capacity = byteBuffer.capacity();
        if (capacity < 22) {
            return -1;
        }
        int i6 = capacity - 22;
        int min = Math.min(i6, 65535);
        for (int i7 = 0; i7 <= min; i7++) {
            int i8 = i6 - i7;
            if (byteBuffer.getInt(i8) == 101010256 && j(byteBuffer, i8 + 20) == i7) {
                return i8;
            }
        }
        return -1;
    }

    private static void r(ByteBuffer byteBuffer) {
        if (byteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
        } else {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static Pair<ByteBuffer, Long> j(RandomAccessFile randomAccessFile, int i6) throws IOException {
        if (i6 >= 0 && i6 <= 65535) {
            long length = randomAccessFile.length();
            if (length < 22) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(((int) Math.min(i6, length - 22)) + 22);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            allocate.order(byteOrder);
            long capacity = length - allocate.capacity();
            randomAccessFile.seek(capacity);
            randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
            int cw = cw(allocate);
            if (cw == -1) {
                return null;
            }
            allocate.position(cw);
            ByteBuffer slice = allocate.slice();
            slice.order(byteOrder);
            return Pair.create(slice, Long.valueOf(capacity + cw));
        }
        throw new IllegalArgumentException("maxCommentSize: ".concat(String.valueOf(i6)));
    }

    private static long xt(ByteBuffer byteBuffer, int i6) {
        return byteBuffer.getInt(i6) & 4294967295L;
    }

    public static final boolean j(RandomAccessFile randomAccessFile, long j6) throws IOException {
        long j7 = j6 - 20;
        if (j7 < 0) {
            return false;
        }
        randomAccessFile.seek(j7);
        return randomAccessFile.readInt() == 1347094023;
    }

    public static long j(ByteBuffer byteBuffer) {
        r(byteBuffer);
        return xt(byteBuffer, byteBuffer.position() + 16);
    }

    public static void j(ByteBuffer byteBuffer, long j6) {
        r(byteBuffer);
        j(byteBuffer, byteBuffer.position() + 16, j6);
    }

    private static int j(ByteBuffer byteBuffer, int i6) {
        return byteBuffer.getShort(i6) & j1.f43986d;
    }

    private static void j(ByteBuffer byteBuffer, int i6, long j6) {
        if (j6 >= 0 && j6 <= 4294967295L) {
            byteBuffer.putInt(byteBuffer.position() + i6, (int) j6);
            return;
        }
        throw new IllegalArgumentException("uint32 value of out range: ".concat(String.valueOf(j6)));
    }
}
