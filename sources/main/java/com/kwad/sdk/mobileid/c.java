package com.kwad.sdk.mobileid;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.mobileid.model.CMTokenResponse;
import com.kwad.sdk.mobileid.model.UaidTokenResponse;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bg;
import java.util.UUID;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    private static String traceId;

    public static void a(Context context, d dVar) {
        traceId = UUID.randomUUID().toString();
        A(a(context, 1, dVar));
    }

    public static void b(Context context, d dVar) {
        A(a(context, 2, dVar));
    }

    public static void c(Context context, d dVar) {
        A(a(context, 4, dVar));
    }

    private static void A(final com.kwad.sdk.commercial.c.a aVar) {
        GlobalThreadPools.Jy().execute(new bg() { // from class: com.kwad.sdk.mobileid.c.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                if (com.kwad.sdk.commercial.c.a.this != null) {
                    com.kwad.sdk.core.d.c.d("UAIDMonitor", "asyncReport json: " + com.kwad.sdk.commercial.c.a.this.toJson().toString());
                }
                com.kwad.sdk.commercial.b.y(com.kwad.sdk.commercial.c.a.this);
            }
        });
    }

    public static void b(Context context, int i6, String str) {
        UaidInfo a6 = a(context, 3, new d(false, "uaidTokenCanRequest"));
        a6.token = null;
        StringBuilder sb = new StringBuilder();
        sb.append(i6);
        a6.errorCode = sb.toString();
        a6.errorMsg = str;
        a6.result = 0;
        A(a6);
    }

    public static void c(Context context, int i6, String str) {
        UaidInfo a6 = a(context, 5, new d(false, "uaidTokenCanRequest"));
        a6.uaid = null;
        StringBuilder sb = new StringBuilder();
        sb.append(i6);
        a6.errorCode = sb.toString();
        a6.errorMsg = str;
        a6.result = 0;
        A(a6);
    }

    public static void a(Context context, CMTokenResponse cMTokenResponse) {
        UaidInfo a6 = a(context, 3, new d(true, "uaidTokenCanRequest"));
        a6.token = cMTokenResponse.getResultToken();
        a6.errorCode = cMTokenResponse.getResultCode();
        a6.errorMsg = cMTokenResponse.getResultMsg();
        a6.result = !TextUtils.isEmpty(a6.token) ? 1 : 0;
        A(a6);
    }

    public static void a(Context context, @Nullable UaidTokenResponse uaidTokenResponse) {
        UaidInfo a6 = a(context, 5, new d(true, "uaidTokenCanRequest"));
        a6.uaid = uaidTokenResponse.uaid;
        StringBuilder sb = new StringBuilder();
        sb.append(uaidTokenResponse.result);
        a6.errorCode = sb.toString();
        a6.errorMsg = uaidTokenResponse.errorMsg;
        a6.result = !TextUtils.isEmpty(a6.token) ? 1 : 0;
        A(a6);
    }

    private static UaidInfo a(Context context, int i6, d dVar) {
        boolean useNetworkStateDisable = bc.useNetworkStateDisable();
        boolean usePhoneStateDisable = bc.usePhoneStateDisable();
        String dt = bd.dt(context);
        return UaidInfo.newBuilder().eb(i6).gp(traceId).go(dVar.Nz()).gq(dVar.NA()).ec(ao.d(context, dt, useNetworkStateDisable)).ed(ao.df(context)).bO((dt == null || TextUtils.isEmpty(dt.trim())) ? false : true).bM(!useNetworkStateDisable).bN(!usePhoneStateDisable).NB();
    }
}
