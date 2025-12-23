package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.feed.monitor.FeedErrorInfo;
import com.kwad.components.ad.feed.monitor.FeedPageInfo;
import com.kwad.components.ad.feed.monitor.FeedWebViewInfo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ct {
    @InvokeBy(invokerClass = go.class, methodId = "registerHolder")
    public static void Hk() {
        go.Hl().put(FeedPageInfo.a.class, new hc());
        go.Hl().put(FeedErrorInfo.class, new ej());
        go.Hl().put(FeedPageInfo.class, new em());
        go.Hl().put(FeedWebViewInfo.class, new eo());
    }
}
