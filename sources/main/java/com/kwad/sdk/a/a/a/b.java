package com.kwad.sdk.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ag;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    public static int agV = 0;
    public static long uN = -1;

    public static void J(Context context) {
        a aVar = new a();
        if (j(System.currentTimeMillis())) {
            agV++;
        } else {
            agV = 1;
        }
        long currentTimeMillis = System.currentTimeMillis();
        uN = currentTimeMillis;
        aVar.agV = agV;
        aVar.jC = currentTimeMillis;
        ag.an(context, aVar.toJson().toString());
    }

    /* renamed from: if, reason: not valid java name */
    private static long m118if() {
        long j6 = uN;
        if (j6 != -1) {
            return j6;
        }
        String QG = ag.QG();
        if (TextUtils.isEmpty(QG)) {
            return 0L;
        }
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(QG));
            uN = aVar.jC;
            agV = aVar.agV;
        } catch (Exception e6) {
            c.printStackTraceOnly(e6);
        }
        return uN;
    }

    public static int dO() {
        if (!j(System.currentTimeMillis())) {
            agV = 0;
        }
        return agV;
    }

    private static boolean j(long j6) {
        if (m118if() <= 0 || j6 <= 0 || m118if() / 2460601000L != j6 / 2460601000L) {
            return false;
        }
        return true;
    }
}
