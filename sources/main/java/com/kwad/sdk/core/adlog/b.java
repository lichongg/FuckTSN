package com.kwad.sdk.core.adlog;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.monitor.FraudVerifyCode;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.g;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import com.tencent.bugly.BuglyStrategy;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    public static void a(@NonNull final com.kwad.sdk.core.adlog.c.a aVar) {
        GlobalThreadPools.Jy().execute(new bg() { // from class: com.kwad.sdk.core.adlog.b.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a aVar2 = new a(com.kwad.sdk.core.adlog.c.a.this);
                b.a(aVar2.getUrl(), aVar2.getBody(), com.kwad.sdk.core.adlog.c.a.this, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    public static void a(String str, JSONObject jSONObject, @NonNull com.kwad.sdk.core.adlog.c.a aVar, @Nullable com.kwad.sdk.core.adlog.a.a aVar2) {
        int i6;
        AdTemplate adTemplate;
        AdTemplate adTemplate2 = aVar.adTemplate;
        int i7 = aVar.awx;
        try {
            com.kwad.sdk.core.adlog.b.c.a(adTemplate2, i7, aVar2);
            try {
                if (!ao.isNetworkConnected(ServiceProvider.getContext())) {
                    com.kwad.sdk.core.d.c.w("AdLogRequestManager", "no network while report log");
                    com.kwad.sdk.core.adlog.b.c.a(adTemplate2, i7, str, 100004, "no network", aVar2);
                    com.kwad.sdk.core.adlog.a.b.EA().a(aVar2, str, jSONObject, aVar, 100004, "no network");
                    return;
                }
                if (bw.hA(str)) {
                    com.kwad.sdk.core.adlog.b.c.b(adTemplate2, i7, str, FraudVerifyCode.RerwardFraudUnknown, "", aVar2);
                    return;
                }
                com.kwad.sdk.core.network.c doPost = g.AI().doPost(str, (Map<String, String>) null, jSONObject);
                AdLogRequestResult adLogRequestResult = new AdLogRequestResult();
                adLogRequestResult.parseResult(doPost.aEk);
                int i8 = doPost.code;
                ?? r8 = 200;
                try {
                    if (i8 != 200) {
                        try {
                            int cu = d.cu(i8);
                            String str2 = doPost.aEk;
                            com.kwad.sdk.core.adlog.b.c.d(adTemplate2, i7, str, cu, str2, aVar2);
                            com.kwad.sdk.core.adlog.a.b.EA().a(aVar2, str, jSONObject, aVar, cu, str2);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            r8 = adTemplate2;
                            adTemplate = r8;
                            i6 = i7;
                            com.kwad.sdk.core.adlog.b.c.b(adTemplate, i6, "", BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH, bw.s(th), aVar2);
                            com.kwad.sdk.core.d.c.printStackTrace(th);
                            ServiceProvider.reportSdkCaughtException(th);
                        }
                    }
                    if (adLogRequestResult.isResultOk()) {
                        com.kwad.sdk.core.adlog.b.c.b(adTemplate2, i7, aVar2);
                        b(aVar);
                        com.kwad.sdk.core.adlog.a.b.EA().EB();
                        return;
                    }
                    if (!adLogRequestResult.isCheatingFlow()) {
                        int i9 = adLogRequestResult.result;
                        String str3 = adLogRequestResult.errorMsg;
                        com.kwad.sdk.core.d.c.w("AdLogRequestManager", "request fail code:" + i9 + ", errorMsg:" + str3 + ", url=" + str);
                        com.kwad.sdk.core.adlog.b.c.c(adTemplate2, i7, str, i9, str3, aVar2);
                        com.kwad.sdk.core.adlog.a.b.EA().a(aVar2, str, jSONObject, aVar, i9, str3);
                        return;
                    }
                    try {
                        adTemplate2.setCheatingFlow(adLogRequestResult.isCheatingFlow());
                        com.kwad.sdk.core.adlog.b.c.c(adTemplate2, i7, str, adLogRequestResult.result, adLogRequestResult.errorMsg, aVar2);
                    } catch (Throwable th2) {
                        th = th2;
                        adTemplate2 = adTemplate2;
                        i7 = i7;
                        adTemplate = adTemplate2;
                        i6 = i7;
                        com.kwad.sdk.core.adlog.b.c.b(adTemplate, i6, "", BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH, bw.s(th), aVar2);
                        com.kwad.sdk.core.d.c.printStackTrace(th);
                        ServiceProvider.reportSdkCaughtException(th);
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    private static void b(@NonNull com.kwad.sdk.core.adlog.c.a aVar) {
        try {
            com.kwad.sdk.core.track.a.e(aVar);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void Ex() {
        GlobalThreadPools.Jy().execute(new bg() { // from class: com.kwad.sdk.core.adlog.b.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.core.adlog.a.a ED = com.kwad.sdk.core.adlog.a.b.EA().ED();
                if (ED != null) {
                    JSONObject jSONObject = ED.axq;
                    aa.putValue(jSONObject, "retryCount", ED.retryCount);
                    aa.putValue(jSONObject, "cacheType", 1);
                    b.a(ED.url, jSONObject, ED.axr, ED);
                }
            }
        });
    }
}
