package ms.bz.bd.c.Pgl;

import android.telephony.TelephonyManager;
import com.stub.StubApp;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\Downloads\app\classes8.dex */
final class k extends pbly.pgla {
    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object b(long j6, String str, Object obj) throws Throwable {
        Boolean bool = Boolean.FALSE;
        TelephonyManager telephonyManager = (TelephonyManager) StubApp.getOrigApplicationContext(pblv.a().c().getApplicationContext()).getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "082ff5", new byte[]{49, 50, 78, 28, 92}));
        return (telephonyManager == null || telephonyManager.getSimState() != 5) ? bool : Boolean.TRUE;
    }

    k() {
    }
}
