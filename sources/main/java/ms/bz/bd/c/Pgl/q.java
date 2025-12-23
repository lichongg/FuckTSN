package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.sdk.openadsdk.api.plugin.xt;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\Downloads\app\classes8.dex */
final class q extends pbly.pgla {
    q() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object b(long j6, String str, Object obj) throws Throwable {
        Context c6 = pblv.a().c();
        String[] split = str.split((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3a0c32", new byte[]{30, Byte.MAX_VALUE}));
        String str2 = split[0];
        String str3 = split[1];
        SharedPreferences.Editor edit = xt.xt(c6, str2, 0).edit();
        edit.putString(str3, (String) obj);
        edit.commit();
        return null;
    }
}
