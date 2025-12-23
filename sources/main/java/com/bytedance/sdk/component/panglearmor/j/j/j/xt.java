package com.bytedance.sdk.component.panglearmor.j.j.j;

import android.util.Pair;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    public static class j {

        /* renamed from: j, reason: collision with root package name */
        private final long f26694j;
        private final com.bytedance.sdk.component.panglearmor.j.xt.xt xt;

        public long j() {
            return this.f26694j;
        }

        public com.bytedance.sdk.component.panglearmor.j.xt.xt xt() {
            return this.xt;
        }

        public j(long j6, com.bytedance.sdk.component.panglearmor.j.xt.xt xtVar) {
            this.f26694j = j6;
            this.xt = xtVar;
        }
    }

    public static com.bytedance.sdk.component.panglearmor.j.j.cw.xt j(com.bytedance.sdk.component.panglearmor.j.xt.xt xtVar) throws IOException, com.bytedance.sdk.component.panglearmor.j.j.cw.j {
        Pair<ByteBuffer, Long> j6 = com.bytedance.sdk.component.panglearmor.j.j.xt.xt.j.j(xtVar);
        if (j6 == null) {
            throw new com.bytedance.sdk.component.panglearmor.j.j.cw.j("ZIP End of Central Directory record not found");
        }
        ByteBuffer byteBuffer = (ByteBuffer) j6.first;
        long longValue = ((Long) j6.second).longValue();
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        long j7 = com.bytedance.sdk.component.panglearmor.j.j.xt.xt.j.j(byteBuffer);
        if (j7 > longValue) {
            throw new com.bytedance.sdk.component.panglearmor.j.j.cw.j("ZIP Central Directory start offset out of range: " + j7 + ". ZIP End of Central Directory offset: " + longValue);
        }
        long xt = com.bytedance.sdk.component.panglearmor.j.j.xt.xt.j.xt(byteBuffer);
        long j8 = j7 + xt;
        if (j8 <= longValue) {
            return new com.bytedance.sdk.component.panglearmor.j.j.cw.xt(j7, xt, com.bytedance.sdk.component.panglearmor.j.j.xt.xt.j.cw(byteBuffer), longValue, byteBuffer);
        }
        throw new com.bytedance.sdk.component.panglearmor.j.j.cw.j("ZIP Central Directory overlaps with End of Central Directory. CD end: " + j8 + ", EoCD start: " + longValue);
    }

    public static j j(com.bytedance.sdk.component.panglearmor.j.xt.xt xtVar, com.bytedance.sdk.component.panglearmor.j.j.cw.xt xtVar2) throws IOException, Exception {
        long j6 = xtVar2.j();
        long xt = xtVar2.xt() + j6;
        long r5 = xtVar2.r();
        if (xt != r5) {
            throw new Exception("ZIP Central Directory is not immediately followed by End of Central Directory. CD end: " + xt + ", EoCD start: " + r5);
        }
        if (j6 >= 32) {
            ByteBuffer j7 = xtVar.j(j6 - 24, 24);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            j7.order(byteOrder);
            if (j7.getLong(8) == 2334950737559900225L && j7.getLong(16) == 3617552046287187010L) {
                long j8 = j7.getLong(0);
                if (j8 < j7.capacity() || j8 > 2147483639) {
                    throw new Exception("APK Signing Block size out of range: ".concat(String.valueOf(j8)));
                }
                long j9 = (int) (8 + j8);
                long j10 = j6 - j9;
                if (j10 >= 0) {
                    ByteBuffer j11 = xtVar.j(j10, 8);
                    j11.order(byteOrder);
                    long j12 = j11.getLong(0);
                    if (j12 == j8) {
                        return new j(j10, xtVar.j(j10, j9));
                    }
                    throw new Exception("APK Signing Block sizes in header and footer do not match: " + j12 + " vs " + j8);
                }
                throw new Exception("APK Signing Block offset out of range: ".concat(String.valueOf(j10)));
            }
            throw new Exception("No APK Signing Block before ZIP Central Directory");
        }
        throw new Exception("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(j6)));
    }
}
