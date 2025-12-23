package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.pm.Signature;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\Downloads\app\classes8.dex */
final class j extends pbly.pgla {
    j() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object b(long j6, String str, Object obj) throws Throwable {
        Context c6 = pblv.a().c();
        Signature[] signatureArr = c6.getPackageManager().getPackageInfo(c6.getPackageName(), 64).signatures;
        if (signatureArr != null && signatureArr.length > 0) {
            return signatureArr[0].toByteArray();
        }
        return null;
    }
}
