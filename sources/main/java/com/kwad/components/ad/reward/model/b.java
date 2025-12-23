package com.kwad.components.ad.reward.model;

import android.content.Context;
import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.ag;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    private static SimpleDateFormat jB = new SimpleDateFormat("yyyy-MM-dd");
    public long lY = -1;
    public int lZ = 0;

    private static boolean b(long j6, long j7) {
        if (j6 > 0 && j7 > 0) {
            try {
                return jB.format(new Date(j6)).equals(jB.format(new Date(j7)));
            } catch (Exception e6) {
                com.kwad.sdk.core.d.c.printStackTrace(e6);
            }
        }
        return false;
    }

    public static void L(Context context) {
        String Qw = ag.Qw();
        b bVar = new b();
        if (TextUtils.isEmpty(Qw)) {
            bVar.lZ = 1;
            bVar.lY = System.currentTimeMillis();
            ag.ag(context, bVar.toJson().toString());
            return;
        }
        try {
            bVar.parseJson(new JSONObject(Qw));
            if (b(bVar.lY, System.currentTimeMillis())) {
                bVar.lZ++;
            } else {
                bVar.lZ = 1;
                bVar.lY = System.currentTimeMillis();
            }
            ag.ag(context, bVar.toJson().toString());
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
        }
    }

    public static int dQ() {
        String Qw = ag.Qw();
        if (TextUtils.isEmpty(Qw)) {
            return 0;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(Qw));
            if (!b(bVar.lY, System.currentTimeMillis())) {
                return 0;
            }
            return bVar.lZ;
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
            return 0;
        }
    }
}
