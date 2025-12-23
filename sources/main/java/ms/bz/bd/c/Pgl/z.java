package ms.bz.bd.c.Pgl;

import android.content.Context;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\Downloads\app\classes8.dex */
final class z extends pbly.pgla {
    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    protected final Object b(long j6, String str, Object obj) throws Throwable {
        Boolean bool = Boolean.FALSE;
        try {
            Context c6 = pblv.a().c();
            if (c6 != null) {
                return Boolean.valueOf((c6.getApplicationInfo() == null || (c6.getApplicationInfo().flags & 2) == 0) ? false : true);
            }
            return bool;
        } catch (Throwable unused) {
            return bool;
        }
    }

    z() {
    }
}
