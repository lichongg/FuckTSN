package ms.bz.bd.c.Pgl;

import java.util.TimeZone;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\Downloads\app\classes8.dex */
final class k0 extends pbly.pgla {
    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object b(long j6, String str, Object obj) throws Throwable {
        String str2;
        int i6;
        try {
            TimeZone timeZone = TimeZone.getDefault();
            str2 = timeZone.getID();
            try {
                i6 = ((timeZone.getRawOffset() / 60) / 60) / 1000;
            } catch (Throwable unused) {
                i6 = 0;
                return str2 + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "11a32f", new byte[]{108})) + i6;
            }
        } catch (Throwable unused2) {
            str2 = null;
        }
        return str2 + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "11a32f", new byte[]{108})) + i6;
    }

    k0() {
    }
}
