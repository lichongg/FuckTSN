package ms.bz.bd.c.Pgl;

import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\Downloads\app\classes8.dex */
final class e extends pbly.pgla {
    e() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object b(long j6, String str, Object obj) throws Throwable {
        int i6;
        l1 c6 = l1.c(pblv.a().c());
        c6.getClass();
        try {
            synchronized (c6) {
                i6 = c6.b();
            }
        } catch (Exception unused) {
            i6 = -1;
        }
        return "" + i6;
    }
}
