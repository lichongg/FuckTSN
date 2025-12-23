package com.kwad.components.ad.interstitial.b;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.config.item.d;
import com.kwad.sdk.core.config.item.k;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    public static k lM = new k("interstitialAdSkipCloseType", 0);
    public static k lN = new k("interstitialAdSkipCloseArea", 0);
    public static k lO = new k("interstitialAdFullClick", 1);
    public static k lP = new k("interstitialAdBackPressSwitch", 0);
    public static k lQ = new k("interstitialPlayableTime", 999);
    public static k lR = new k("interstitialAdClickShutDown", 0);
    public static d lS = new d("interstitialAutoStartSwitch", false);
    public static k lT = new k("ecInterstitialAdOrderSwitch", 0);
    public static k lU = new k("interstitialCycleAggregateMaxCount", 3);

    @InvokeBy(invokerClass = e.class, methodId = "initConfigList")
    public static void init() {
    }
}
