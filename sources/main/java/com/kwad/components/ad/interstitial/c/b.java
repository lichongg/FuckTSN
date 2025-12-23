package com.kwad.components.ad.interstitial.c;

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
public class b extends com.kwad.sdk.core.response.a.a {
    private static SimpleDateFormat jB = new SimpleDateFormat("yyyy-MM-dd");
    public long jC = -1;
    public int lW = 0;
    public int lX = 0;

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

    public static void J(Context context) {
        String Qt = ag.Qt();
        b bVar = new b();
        if (TextUtils.isEmpty(Qt)) {
            bVar.lW = 1;
            bVar.jC = System.currentTimeMillis();
            ag.ac(context, bVar.toJson().toString());
            return;
        }
        try {
            bVar.parseJson(new JSONObject(Qt));
            if (b(bVar.jC, System.currentTimeMillis())) {
                bVar.lW++;
            } else {
                bVar.lW = 1;
                bVar.lX = 0;
                bVar.jC = System.currentTimeMillis();
            }
            ag.ac(context, bVar.toJson().toString());
        } catch (Exception e6) {
            c.printStackTraceOnly(e6);
        }
    }

    public static void K(Context context) {
        String Qt = ag.Qt();
        b bVar = new b();
        if (TextUtils.isEmpty(Qt)) {
            bVar.lX = 1;
            bVar.jC = System.currentTimeMillis();
            ag.ac(context, bVar.toJson().toString());
            return;
        }
        try {
            bVar.parseJson(new JSONObject(Qt));
            if (b(bVar.jC, System.currentTimeMillis())) {
                bVar.lX++;
            } else {
                bVar.lX = 1;
                bVar.lW = 0;
                bVar.jC = System.currentTimeMillis();
            }
            ag.ac(context, bVar.toJson().toString());
        } catch (Exception e6) {
            c.printStackTraceOnly(e6);
        }
    }

    public static int dO() {
        String Qt = ag.Qt();
        if (TextUtils.isEmpty(Qt)) {
            return 0;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(Qt));
            return bVar.lW;
        } catch (Exception e6) {
            c.printStackTraceOnly(e6);
            return 0;
        }
    }

    public static int dP() {
        String Qt = ag.Qt();
        if (TextUtils.isEmpty(Qt)) {
            return 0;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(Qt));
            return bVar.lX;
        } catch (Exception e6) {
            c.printStackTraceOnly(e6);
            return 0;
        }
    }
}
