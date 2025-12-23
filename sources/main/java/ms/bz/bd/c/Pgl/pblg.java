package ms.bz.bd.c.Pgl;

import android.os.Build;
import io.netty.handler.codec.http.HttpConstants;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class pblg {
    public static String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            HashMap b6 = b();
            for (String str : b6.keySet()) {
                jSONObject.put(str, b6.get(str));
            }
            return jSONObject.toString();
        } catch (Throwable unused) {
            return (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "091f3c", new byte[]{HttpConstants.COLON, 38});
        }
    }

    private static HashMap b() {
        HashMap hashMap = new HashMap();
        hashMap.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f29f6f", new byte[]{38}), Build.MODEL);
        hashMap.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "98c1b3", new byte[]{122}), Build.BRAND);
        hashMap.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "19172b", new byte[]{115}), Build.BOARD);
        hashMap.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3b5625", new byte[]{118}), Build.VERSION.RELEASE);
        hashMap.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "919dd7", new byte[]{125}), Build.DISPLAY);
        hashMap.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "777ec4", new byte[]{112}), Build.HARDWARE);
        hashMap.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f491a0", new byte[]{32}), Build.FINGERPRINT);
        return hashMap;
    }
}
