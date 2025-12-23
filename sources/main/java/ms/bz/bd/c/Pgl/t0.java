package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import io.netty.handler.codec.http.HttpConstants;
import java.util.HashMap;
import ms.bz.bd.c.Pgl.pbly;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes8.dex */
final class t0 extends pbly.pgla {
    t0() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object b(long j6, String str, Object obj) throws Throwable {
        String str2;
        String str3;
        Context c6 = pblv.a().c();
        ApplicationInfo applicationInfo = c6.getPackageManager().getApplicationInfo(c6.getPackageName(), 0);
        String str4 = applicationInfo.sourceDir;
        if (str4 == null) {
            str4 = applicationInfo.publicSourceDir;
        }
        HashMap a6 = pblc.a(str4);
        String str5 = "";
        if (a6 == null || !a6.containsKey(1903654775)) {
            str2 = "";
        } else {
            str2 = (String) a6.get(1903654775);
        }
        if (str2 != null && str2.length() > 0) {
            JSONObject jSONObject = new JSONObject(str2);
            try {
                str3 = jSONObject.getString((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "70bbbb", new byte[]{43, 55, 5, 23, 98, 96, 57, 20, 61, 53, 25, 49, 25, 23, 83, 123, 49, 29}));
            } catch (JSONException unused) {
                str3 = "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "06e739", new byte[]{122}));
            try {
                str5 = jSONObject.getString((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e412d9", new byte[]{102, 51, 78, 67, 90, 61, 99, 42, 98, 119, 125, HttpConstants.COLON, 70}));
            } catch (JSONException unused2) {
            }
            sb.append(str5);
            str5 = sb.toString();
        }
        if (str5.length() == 0) {
            return (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "53d452", new byte[]{10, 62, 25, 69});
        }
        return str5;
    }
}
