package com.kwad.components.ad.splashscreen.b;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.config.item.d;
import com.kwad.sdk.core.config.item.k;
import com.kwad.sdk.core.config.item.r;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    public static k FM = new k("splashTimeOutMilliSecond", 5000);
    public static r FN = new r("splashTimerTips", "");
    public static r FO = new r("splashBtnText", "点击跳转详情页或第三方应用");
    public static d FP = new d("splashCropNewSwitch", true);
    public static d FQ = new d("splashAdLoadProcessChange", false);
    public static k FR = new k("splashMaterialDownloadTimeMs", 500);

    @InvokeBy(invokerClass = e.class, methodId = "initConfigList")
    public static void init() {
    }
}
