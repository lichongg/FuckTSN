package com.kwad.components.ad.splashscreen.local;

import android.content.Context;
import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ag;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class a extends com.kwad.sdk.core.response.a.a {
    private static SimpleDateFormat jB = new SimpleDateFormat("yyyy-MM-dd");
    public long jC = 0;
    public int jD = 0;

    private static boolean b(long j6, long j7) {
        if (j6 > 0 && j7 > 0) {
            try {
                return jB.format(new Date(j6)).equals(jB.format(new Date(j7)));
            } catch (Exception e6) {
                c.printStackTraceOnly(e6);
            }
        }
        return false;
    }

    public static void V(Context context) {
        String Qv = ag.Qv();
        a aVar = new a();
        if (TextUtils.isEmpty(Qv)) {
            aVar.jD = 1;
            aVar.jC = System.currentTimeMillis();
            ag.af(context, aVar.toJson().toString());
            return;
        }
        try {
            aVar.parseJson(new JSONObject(Qv));
            if (b(aVar.jC, System.currentTimeMillis())) {
                aVar.jD++;
            } else {
                aVar.jD = 1;
            }
            aVar.jC = System.currentTimeMillis();
            ag.af(context, aVar.toJson().toString());
        } catch (Exception e6) {
            c.printStackTraceOnly(e6);
        }
    }
}
