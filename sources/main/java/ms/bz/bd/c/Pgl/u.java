package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\Downloads\app\classes8.dex */
final class u extends pbly.pgla {
    u() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object b(long j6, String str, Object obj) throws Throwable {
        Context c6 = pblv.a().c();
        ApplicationInfo applicationInfo = c6.getPackageManager().getApplicationInfo(c6.getPackageName(), 0);
        String str2 = applicationInfo.sourceDir;
        if (str2 == null) {
            return applicationInfo.publicSourceDir;
        }
        return str2;
    }
}
