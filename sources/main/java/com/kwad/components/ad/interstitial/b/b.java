package com.kwad.components.ad.interstitial.b;

import com.kwad.sdk.core.response.model.AdInfo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    public static int b(AdInfo adInfo) {
        int intValue = a.lQ.getValue().intValue();
        if (com.kwad.sdk.core.response.b.a.bc(adInfo)) {
            int L = com.kwad.sdk.core.response.b.a.L(adInfo);
            return intValue == 0 ? L : Math.min(intValue, L);
        }
        if (intValue > 60 || intValue <= 0) {
            return 60;
        }
        return intValue;
    }

    public static boolean dH() {
        return a.lS.getValue().booleanValue();
    }

    public static boolean dI() {
        return a.lM.getValue().intValue() == 1;
    }

    public static int dJ() {
        return a.lN.getValue().intValue();
    }

    public static boolean dK() {
        return a.lO.getValue().intValue() == 1;
    }

    public static boolean dL() {
        return a.lP.getValue().intValue() == 1;
    }

    public static boolean dM() {
        return a.lR.getValue().intValue() == 1;
    }

    public static boolean dN() {
        return a.lT.getValue().intValue() == 1;
    }
}
