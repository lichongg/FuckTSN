package ms.bz.bd.c.Pgl;

import java.util.Arrays;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\Downloads\app\classes8.dex */
final class v extends pbly.pgla {
    v() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    protected final Object b(long j6, String str, Object obj) throws Throwable {
        Throwable b6 = p1.a().b();
        if (b6 != null) {
            return Arrays.toString(b6.getStackTrace());
        }
        return "";
    }
}
