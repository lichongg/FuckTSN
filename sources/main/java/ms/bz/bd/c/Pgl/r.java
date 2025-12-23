package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.Intent;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\Downloads\app\classes8.dex */
final class r extends pbly.pgla {
    r() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object b(long j6, String str, Object obj) throws Throwable {
        Context c6 = pblv.a().c();
        String[] strArr = (String[]) obj;
        if (c6 != null && str != null && strArr != null && strArr.length % 2 == 0) {
            Intent intent = new Intent(str);
            intent.setPackage(c6.getPackageName());
            for (int i6 = 0; i6 < strArr.length; i6 += 2) {
                intent.putExtra(strArr[i6], strArr[i6 + 1]);
            }
            c6.sendBroadcast(intent);
            return null;
        }
        return null;
    }
}
