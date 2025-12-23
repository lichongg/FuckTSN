package ms.bz.bd.c.Pgl;

import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.lang.reflect.Method;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\Downloads\app\classes8.dex */
final class y extends pbly.pgla {
    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    protected final Object b(long j6, String str, Object obj) throws Throwable {
        try {
            Method method = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "15d6b4", new byte[]{BinaryMemcacheOpcodes.GATK, 56, 26, 12, 95, HttpConstants.COLON, 38, 17, 49, 103, 46, 52, 18, 12, 80, HttpConstants.COMMA, 48, 7, 48, 101, 110, BinaryMemcacheOpcodes.GATKQ, 18, 76, 78, HttpConstants.COMMA, 32, 90, 56, 106, 110, 26, BinaryMemcacheOpcodes.GATKQ, 96})).getMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1d1a48", new byte[]{BinaryMemcacheOpcodes.SASL_AUTH}), null);
            if (method != null) {
                return (Long) method.invoke(null, null);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    y() {
    }
}
