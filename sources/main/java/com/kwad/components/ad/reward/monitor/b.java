package com.kwad.components.ad.reward.monitor;

import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    public static void a(boolean z5, AdTemplate adTemplate) {
        a(z5, z5 ? "ad_sdk_neo_video_cache_monitor" : "ad_sdk_fullscreen_video_cache_monitor", adTemplate, z5 ? 102001 : 103001);
    }

    public static void c(boolean z5, int i6) {
        a(z5, z5 ? "ad_sdk_neo_request_monitor" : "ad_sdk_fullscreen_request_monitor", null, i6);
    }

    public static void b(boolean z5, AdTemplate adTemplate) {
        a(z5, z5 ? "ad_sdk_neo_page_enter_monitor" : "ad_sdk_fullscreen_page_enter_monitor", adTemplate, z5 ? 102002 : 103002);
    }

    public static void a(AdTemplate adTemplate, TKRenderFailReason tKRenderFailReason) {
        String str;
        int i6;
        boolean z5 = e.ef(adTemplate) == 2;
        if (z5) {
            str = "ad_sdk_neo_page_native_monitor";
        } else {
            str = "ad_sdk_fullscreen_page_native_monitor";
        }
        if (TKRenderFailReason.SWITCH_CLOSE.equals(tKRenderFailReason)) {
            i6 = z5 ? 102003 : 103003;
        } else {
            i6 = TKRenderFailReason.TK_FILE_LOAD_ERROR.equals(tKRenderFailReason) ? z5 ? 102004 : 103004 : 102005;
        }
        a(z5, str, adTemplate, i6);
    }

    public static void c(boolean z5, AdTemplate adTemplate) {
        String str;
        if (z5) {
            str = "ad_sdk_neo_video_play_monitor";
        } else {
            str = "ad_sdk_fullscreen_video_play_monitor";
        }
        a(z5, str, adTemplate, z5 ? 102007 : 103007);
    }

    private static void a(boolean z5, String str, AdTemplate adTemplate, int i6) {
        AdInfo el;
        com.kwad.sdk.commercial.b.a(z5, str, new RewardMonitorInfo().setErrorCode(i6).setCreativeId((adTemplate == null || (el = e.el(adTemplate)) == null) ? 0L : com.kwad.sdk.core.response.b.a.J(el)).setAdTemplate(adTemplate));
    }
}
