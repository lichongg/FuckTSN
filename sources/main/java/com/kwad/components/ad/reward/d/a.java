package com.kwad.components.ad.reward.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ag;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private static boolean b(long j6, long j7) {
        return j6 > 0 && j7 > 0 && j6 / 2460601000L == j7 / 2460601000L;
    }

    public static boolean b(@NonNull Context context, AdInfo adInfo) {
        if (!com.kwad.sdk.core.response.b.a.aG(adInfo)) {
            return false;
        }
        int max = Math.max(com.kwad.sdk.core.response.b.a.aH(adInfo) + 1, 1);
        boolean d6 = d(context, max);
        c(context, max);
        return d6 && e(context, com.kwad.sdk.core.response.b.a.aI(adInfo));
    }

    public static void S(@NonNull Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        b bVar = new b();
        String cY = ag.cY(context);
        int i6 = 0;
        if (!TextUtils.isEmpty(cY)) {
            try {
                bVar.parseJson(new JSONObject(cY));
                if (b(bVar.jC, currentTimeMillis)) {
                    i6 = bVar.ur;
                }
            } catch (Exception e6) {
                c.printStackTraceOnly(e6);
            }
        }
        bVar.jC = currentTimeMillis;
        bVar.ur = i6 + 1;
        ag.ad(context, bVar.toJson().toString());
    }

    private static void c(@NonNull Context context, int i6) {
        int cX = ag.cX(context);
        if (cX % i6 == 0) {
            ag.m(context, 1);
        } else {
            ag.m(context, cX + 1);
        }
    }

    private static boolean d(@NonNull Context context, int i6) {
        int cX = ag.cX(context);
        if (i6 != 0 && cX % i6 == 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0031 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0033 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean e(@androidx.annotation.NonNull android.content.Context r7, int r8) {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            com.kwad.components.ad.reward.d.b r2 = new com.kwad.components.ad.reward.d.b
            r2.<init>()
            java.lang.String r7 = com.kwad.sdk.utils.ag.cY(r7)
            boolean r3 = android.text.TextUtils.isEmpty(r7)
            r4 = 0
            if (r3 != 0) goto L29
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Exception -> L27
            r3.<init>(r7)     // Catch: java.lang.Exception -> L27
            r2.parseJson(r3)     // Catch: java.lang.Exception -> L27
            long r5 = r2.jC     // Catch: java.lang.Exception -> L27
            boolean r7 = b(r5, r0)     // Catch: java.lang.Exception -> L27
            if (r7 == 0) goto L29
            int r7 = r2.ur     // Catch: java.lang.Exception -> L27
            goto L2f
        L27:
            r7 = move-exception
            goto L2b
        L29:
            r7 = 0
            goto L2f
        L2b:
            com.kwad.sdk.core.d.c.printStackTraceOnly(r7)
            goto L29
        L2f:
            if (r7 >= r8) goto L33
            r7 = 1
            return r7
        L33:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.reward.d.a.e(android.content.Context, int):boolean");
    }
}
