package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.ad.reward.model.RewardFraudVerifyRespInfo;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class r implements com.kwad.sdk.core.webview.c.a {
    private WeakReference<com.kwad.components.ad.reward.g> td;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public RewardFraudVerifyRespInfo.FraudDataInfo AL;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        WeakReference<com.kwad.components.ad.reward.g> weakReference = this.td;
        com.kwad.components.ad.reward.g gVar = weakReference != null ? weakReference.get() : null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            a aVar = new a();
            aVar.parseJson(jSONObject);
            gVar.sa = aVar.AL.isFraud() ? 3 : 2;
            gVar.sb = aVar.AL.getCode();
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "rewardFraudVerify";
    }

    public r(WeakReference<com.kwad.components.ad.reward.g> weakReference) {
        this.td = weakReference;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
