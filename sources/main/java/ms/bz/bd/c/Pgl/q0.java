package ms.bz.bd.c.Pgl;

import com.bytedance.sdk.openadsdk.api.plugin.xt;
import java.io.File;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\Downloads\app\classes8.dex */
final class q0 extends pbly.pgla {
    q0() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object b(long j6, String str, Object obj) throws Throwable {
        File file = new File(xt.j(pblv.a().c()), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fa7531", new byte[]{57, 110, 87, 69, 13, 50, 100}));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }
}
