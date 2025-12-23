package ms.bz.bd.c.Pgl;

import android.content.Context;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.lang.reflect.Method;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\Downloads\app\classes8.dex */
final class h0 extends pbly.pgla {
    h0() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object b(long j6, String str, Object obj) throws Throwable {
        double d6;
        Context c6 = pblv.a().c();
        try {
            Class<?> cls = Class.forName(new String(pbla.a((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "7c04c8", new byte[]{112, 50, 21, 70, 10, 43, 102, 71, 55, 53, 112, 100, 21, 20, 11, 125, 98, 68, 55, 61, 112, 53, 17, 69, 10, 118, 98, 71, 54, 48, 112, 52, 20, 18, 10, 42, 98, 19, 55, 103, 116, 100, 21, 70, 11, 124, 102, 71, 52, 52, 112, 103, 20, 23, 10, 122, 99, 16, 52, 52, 113, 51, 21, 70, 10, 121, 98, Ascii.ESC, 55, 103, 112, 52}))));
            Object newInstance = cls.getConstructor(Context.class).newInstance(c6);
            Method declaredMethod = cls.getDeclaredMethod(new String(pbla.a((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0ed66d", new byte[]{119, 48, 65, 23, 94, 39, 103, 21, 98, 48, 119, 50, SignedBytes.MAX_POWER_OF_TWO, 16, 95, 34, 101, 19, 99, 51, 116, 55, 65, 68, 94, BinaryMemcacheOpcodes.GATKQ, 101, 17, 98, 52}))), String.class);
            declaredMethod.setAccessible(true);
            d6 = ((Double) declaredMethod.invoke(newInstance, new String(pbla.a((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6ca0de", new byte[]{113, 51, 68, 21, 12, 38, 98, 22, 102, 53, 112, 51, 69, 29, 9, 119, 99, 17, 102, 49, 112, 49, 68, 21, 13, BinaryMemcacheOpcodes.SASL_AUTH, 99, Ascii.ESC, 103, 52, 112, 56}))))).doubleValue();
        } catch (Throwable unused) {
            d6 = 0.0d;
        }
        return Integer.toString((int) d6);
    }
}
