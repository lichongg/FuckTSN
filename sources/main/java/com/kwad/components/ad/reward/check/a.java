package com.kwad.components.ad.reward.check;

import androidx.annotation.NonNull;
import com.kwad.sdk.commercial.b;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    public static void a(@NonNull AdTemplate adTemplate, int i6, long j6, int i7, String str) {
        b.f(new RewardCheckMonitorInfo().setRequestStatus(2).setCheckType(i6).setEnviType(0).setDataLoadInterval(j6).setCode(i7).setErrorMsg(str).setCreativeId(com.kwad.sdk.core.response.b.a.J(e.el(adTemplate))).setAdTemplate(adTemplate));
    }

    public static void b(@NonNull AdTemplate adTemplate, int i6) {
        b.f(new RewardCheckMonitorInfo().setRequestStatus(1).setCheckType(i6).setEnviType(0).setCreativeId(com.kwad.sdk.core.response.b.a.J(e.el(adTemplate))).setAdTemplate(adTemplate));
    }
}
