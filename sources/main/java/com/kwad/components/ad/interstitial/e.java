package com.kwad.components.ad.interstitial;

import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdResultData;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e {
    public static KsInterstitialAd f(@NonNull AdResultData adResultData) {
        int eD = com.kwad.sdk.core.response.b.e.eD(com.kwad.sdk.core.response.b.c.r(adResultData));
        if (eD != 1) {
            if (eD != 2) {
                return new b(adResultData);
            }
            return new com.kwad.components.ad.interstitial.e.a(false, adResultData);
        }
        return new com.kwad.components.ad.interstitial.e.a(true, adResultData);
    }
}
