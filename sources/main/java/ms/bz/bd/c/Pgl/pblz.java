package ms.bz.bd.c.Pgl;

import com.bytedance.sdk.openadsdk.api.plugin.xt;
import io.netty.handler.codec.http.HttpConstants;
import java.io.File;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\Downloads\app\classes8.dex */
final class pblz extends pbly.pgla {
    pblz() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object b(long j6, String str, Object obj) throws Throwable {
        File file = new File(xt.j(pblv.a().c()), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "9efb08", new byte[]{102, 106, 6, 18, 14, HttpConstants.SEMICOLON, HttpConstants.SEMICOLON}));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }
}
