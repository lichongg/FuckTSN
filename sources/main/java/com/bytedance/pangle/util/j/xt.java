package com.bytedance.pangle.util.j;

import android.util.Pair;
import com.bytedance.pangle.util.m;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private static String f25543j = "";

    public static String[] j(File file) {
        String str;
        String str2 = "";
        try {
            ByteBuffer xt = xt(file);
            if (j(xt)) {
                str2 = m.j(xt.array());
                str = "";
            } else {
                str = "without v2 & v3 signature.";
            }
        } catch (Exception unused) {
            str = str2;
        }
        return new String[]{str2, f25543j, str};
    }

    private static ByteBuffer xt(File file) throws Exception {
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, t.f36150k);
            try {
                Pair<ByteBuffer, Long> j6 = j(randomAccessFile2);
                ByteBuffer byteBuffer = (ByteBuffer) j6.first;
                long longValue = ((Long) j6.second).longValue();
                if (cw.j(randomAccessFile2, longValue)) {
                    throw new Exception("ZIP64 APK not supported");
                }
                ByteBuffer byteBuffer2 = (ByteBuffer) j(randomAccessFile2, j(byteBuffer, longValue)).first;
                randomAccessFile2.close();
                return byteBuffer2;
            } catch (Throwable th) {
                th = th;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static Pair<ByteBuffer, Long> j(RandomAccessFile randomAccessFile) throws Exception {
        Pair<ByteBuffer, Long> j6 = cw.j(randomAccessFile);
        if (j6 != null) {
            return j6;
        }
        throw new Exception("Not an APK file: ZIP End of Central Directory record not found");
    }

    private static long j(ByteBuffer byteBuffer, long j6) throws Exception {
        long j7 = cw.j(byteBuffer);
        if (j7 <= j6) {
            if (cw.xt(byteBuffer) + j7 == j6) {
                return j7;
            }
            throw new Exception("ZIP Central Directory is not immediately followed by End of Central Directory");
        }
        throw new Exception("ZIP Central Directory offset out of range: " + j7 + ". ZIP End of Central Directory offset: " + j6);
    }

    private static void xt(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    static Pair<ByteBuffer, Long> j(RandomAccessFile randomAccessFile, long j6) throws Exception {
        if (j6 >= 32) {
            ByteBuffer allocate = ByteBuffer.allocate(24);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            allocate.order(byteOrder);
            randomAccessFile.seek(j6 - allocate.capacity());
            randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
            if (allocate.getLong(8) == 2334950737559900225L && allocate.getLong(16) == 3617552046287187010L) {
                long j7 = allocate.getLong(0);
                if (j7 < allocate.capacity() || j7 > 2147483639) {
                    throw new Exception("APK Signing Block size out of range: ".concat(String.valueOf(j7)));
                }
                int i6 = (int) (8 + j7);
                long j8 = j6 - i6;
                if (j8 >= 0) {
                    ByteBuffer allocate2 = ByteBuffer.allocate(i6);
                    allocate2.order(byteOrder);
                    randomAccessFile.seek(j8);
                    randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                    long j9 = allocate2.getLong(0);
                    if (j9 == j7) {
                        return Pair.create(allocate2, Long.valueOf(j8));
                    }
                    throw new Exception("APK Signing Block sizes in header and footer do not match: " + j9 + " vs " + j7);
                }
                throw new Exception("APK Signing Block offset out of range: ".concat(String.valueOf(j8)));
            }
            throw new Exception("No APK Signing Block before ZIP Central Directory");
        }
        throw new Exception("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(j6)));
    }

    private static boolean j(ByteBuffer byteBuffer) throws Exception {
        xt(byteBuffer);
        ByteBuffer j6 = j(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i6 = 0;
        while (j6.hasRemaining()) {
            i6++;
            if (j6.remaining() >= 8) {
                long j7 = j6.getLong();
                if (j7 < 4 || j7 > 2147483647L) {
                    throw new Exception("APK Signing Block entry #" + i6 + " size out of range: " + j7);
                }
                int i7 = (int) j7;
                int position = j6.position() + i7;
                if (i7 > j6.remaining()) {
                    throw new Exception("APK Signing Block entry #" + i6 + " size out of range: " + i7 + ", available: " + j6.remaining());
                }
                int i8 = j6.getInt();
                if (i8 == -262969152) {
                    f25543j = "V3";
                    return true;
                }
                if (i8 == 1896449818) {
                    f25543j = "V2";
                    return true;
                }
                j6.position(position);
            } else {
                throw new Exception("Insufficient data to read size of APK Signing Block entry #".concat(String.valueOf(i6)));
            }
        }
        return false;
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
