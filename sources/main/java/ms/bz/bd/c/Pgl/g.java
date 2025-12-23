package ms.bz.bd.c.Pgl;

import java.util.Locale;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\Downloads\app\classes8.dex */
final class g extends pbly.pgla {
    g() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object b(long j6, String str, Object obj) throws Throwable {
        String str2;
        try {
            Locale locale = pblv.a().c().getResources().getConfiguration().locale;
            str2 = locale.getLanguage() + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3a5166", new byte[]{29})) + locale.getCountry();
        } catch (Throwable unused) {
            str2 = null;
        }
        return q1.a(str2);
    }
}
