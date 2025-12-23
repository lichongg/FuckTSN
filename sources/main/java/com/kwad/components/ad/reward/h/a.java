package com.kwad.components.ad.reward.h;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ag;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    public static long uN = -1;
    public static int uO;

    public static void J(Context context) {
        b bVar = new b();
        if (j(System.currentTimeMillis())) {
            uO++;
        } else {
            uO = 1;
        }
        long currentTimeMillis = System.currentTimeMillis();
        uN = currentTimeMillis;
        bVar.uP = uO;
        bVar.jC = currentTimeMillis;
        ag.ae(context, bVar.toJson().toString());
    }

    /* renamed from: if, reason: not valid java name */
    private static long m115if() {
        long j6 = uN;
        if (j6 != -1) {
            return j6;
        }
        String Qu = ag.Qu();
        if (TextUtils.isEmpty(Qu)) {
            return 0L;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(Qu));
            uN = bVar.jC;
            uO = bVar.uP;
        } catch (Exception e6) {
            c.printStackTraceOnly(e6);
        }
        return uN;
    }

    public static int dO() {
        if (!j(System.currentTimeMillis())) {
            uO = 0;
        }
        return uO;
    }

    private static boolean j(long j6) {
        if (m115if() <= 0 || j6 <= 0 || m115if() / 2460601000L != j6 / 2460601000L) {
            return false;
        }
        return true;
    }
}
