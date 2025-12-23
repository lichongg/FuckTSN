package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.splashscreen.SplashPreloadManager;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.components.ad.splashscreen.monitor.SplashMonitorInfo;
import com.kwad.components.ad.splashscreen.monitor.SplashWebMonitorInfo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class cy {
    @InvokeBy(invokerClass = go.class, methodId = "registerHolder")
    public static void Hk() {
        go.Hl().put(SplashPreloadManager.PreLoadItem.class, new iw());
        go.Hl().put(SplashWebMonitorInfo.class, new ko());
        go.Hl().put(SplashSkipViewModel.class, new kl());
        go.Hl().put(SplashMonitorInfo.class, new kh());
        go.Hl().put(com.kwad.components.ad.splashscreen.local.a.class, new kg());
    }
}
