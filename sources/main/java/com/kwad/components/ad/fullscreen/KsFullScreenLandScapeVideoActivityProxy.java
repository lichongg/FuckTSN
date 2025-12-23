package com.kwad.components.ad.fullscreen;

import androidx.annotation.Keep;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.KsFullScreenLandScapeVideoActivity;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsAdSdkDynamicImpl(KsFullScreenLandScapeVideoActivity.class)
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class KsFullScreenLandScapeVideoActivityProxy extends KsFullScreenVideoActivityProxy {
    @InvokeBy(invokerClass = com.kwad.sdk.service.c.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        com.kwad.sdk.service.c.a(KsFullScreenLandScapeVideoActivity.class, KsFullScreenLandScapeVideoActivityProxy.class);
    }
}
