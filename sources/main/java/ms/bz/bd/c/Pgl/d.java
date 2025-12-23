package ms.bz.bd.c.Pgl;

import android.content.Context;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\Downloads\app\classes8.dex */
final class d extends pbly.pgla {
    d() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object b(long j6, String str, Object obj) throws Throwable {
        Context c6 = pblv.a().c();
        if (c6 != null) {
            return c6.getPackageName();
        }
        return "";
    }
}
