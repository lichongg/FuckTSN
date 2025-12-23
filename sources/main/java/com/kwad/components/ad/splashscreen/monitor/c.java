package com.kwad.components.ad.splashscreen.monitor;

import com.kwad.sdk.core.response.model.AdTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    public static void a(AdTemplate adTemplate, String str, long j6, int i6, String str2) {
        com.kwad.sdk.commercial.b.g(new SplashWebMonitorInfo().setEvent("webview_timeout").setSceneId("ad_splash").setDurationMs(j6).setTimeType(i6).setUrl(str).setErrorMsg(str2).setAdTemplate(adTemplate));
    }

    public static void aq(AdTemplate adTemplate) {
        com.kwad.sdk.commercial.b.g(new SplashWebMonitorInfo().setEvent("ad_show").setSceneId("ad_splash").setAdTemplate(adTemplate));
    }

    public static void ar(AdTemplate adTemplate) {
        com.kwad.sdk.commercial.b.g(new SplashWebMonitorInfo().setEvent("webview_init").setSceneId("ad_splash").setAdTemplate(adTemplate));
    }

    public static void b(AdTemplate adTemplate, String str, long j6) {
        com.kwad.sdk.commercial.b.g(new SplashWebMonitorInfo().setEvent("webview_load_finish").setSceneId("ad_splash").setDurationMs(j6).setUrl(str).setAdTemplate(adTemplate));
    }

    public static void d(String str, AdTemplate adTemplate) {
        com.kwad.sdk.commercial.b.g(new SplashWebMonitorInfo().setEvent("webview_load_url").setSceneId("ad_splash").setUrl(str).setAdTemplate(adTemplate));
    }
}
