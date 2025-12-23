package com.bytedance.sdk.component.panglearmor.j.j.xt.xt;

import android.util.Pair;
import com.bytedance.sdk.component.panglearmor.j.xt.xt;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.j1;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class j {
    public static long j(ByteBuffer byteBuffer) {
        r(byteBuffer);
        return xt(byteBuffer, byteBuffer.position() + 16);
    }

    public static long xt(ByteBuffer byteBuffer) {
        r(byteBuffer);
        return xt(byteBuffer, byteBuffer.position() + 12);
    }

    public static int cw(ByteBuffer byteBuffer) {
        r(byteBuffer);
        return j(byteBuffer, byteBuffer.position() + 10);
    }

    static void r(ByteBuffer byteBuffer) {
        if (byteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
        } else {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static int up(ByteBuffer byteBuffer) {
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

    public static Pair<ByteBuffer, Long> j(xt xtVar) throws IOException {
        if (xtVar.j() < 22) {
            return null;
        }
        Pair<ByteBuffer, Long> j6 = j(xtVar, 0);
        return j6 != null ? j6 : j(xtVar, 65535);
    }

    static long xt(ByteBuffer byteBuffer, int i6) {
        return byteBuffer.getInt(i6) & 4294967295L;
    }

    private static Pair<ByteBuffer, Long> j(xt xtVar, int i6) throws IOException {
        if (i6 >= 0 && i6 <= 65535) {
            long j6 = xtVar.j();
            if (j6 < 22) {
                return null;
            }
            int min = ((int) Math.min(i6, j6 - 22)) + 22;
            long j7 = j6 - min;
            ByteBuffer j8 = xtVar.j(j7, min);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            j8.order(byteOrder);
            int up = up(j8);
            if (up == -1) {
                return null;
            }
            j8.position(up);
            ByteBuffer slice = j8.slice();
            slice.order(byteOrder);
            return new Pair<>(slice, Long.valueOf(j7 + up));
        }
        throw new IllegalArgumentException("maxCommentSize: ".concat(String.valueOf(i6)));
    }

    public static int j(ByteBuffer byteBuffer, int i6) {
        return byteBuffer.getShort(i6) & j1.f43986d;
    }
}
