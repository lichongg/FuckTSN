package ms.bz.bd.c.Pgl;

import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\Downloads\app\classes8.dex */
final class r0 extends pbly.pgla {
    r0() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object b(long j6, String str, Object obj) throws Throwable {
        boolean z5;
        try {
            z5 = v0.c(pblv.a().c(), str, obj.toString());
        } catch (Throwable unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "2a2451", new byte[]{BinaryMemcacheOpcodes.GATKQ, 98, 71});
            z5 = false;
        }
        if (z5) {
            return (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "7c0a5b", new byte[]{9, 74});
        }
        return null;
    }
}
