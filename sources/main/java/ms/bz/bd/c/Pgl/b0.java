package ms.bz.bd.c.Pgl;

import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Build;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\Downloads\app\classes8.dex */
final class b0 extends pbly.pgla {
    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    protected final Object b(long j6, String str, Object obj) {
        Network activeNetwork;
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) pblv.a().c().getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "60965a", new byte[]{BinaryMemcacheOpcodes.GATKQ, 61, 68, 76, 15, 117, BinaryMemcacheOpcodes.SASL_AUTH, 24, 126, 111, 51, 43}));
                activeNetwork = connectivityManager.getActiveNetwork();
                return (String) (connectivityManager.getNetworkCapabilities(activeNetwork).hasTransport(4) ? com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e8a67e", new byte[]{37}) : com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "743fad", new byte[]{118}));
            } catch (Throwable unused) {
            }
        }
        return (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6d3b33", new byte[]{119});
    }

    b0() {
    }
}
