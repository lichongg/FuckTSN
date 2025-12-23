package com.kwad.components.ad.interstitial.report;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.ad.interstitial.report.a$a, reason: collision with other inner class name */
    static class C0568a {
        private static final a nM = new a();
    }

    private static void a(String str, com.kwad.sdk.commercial.c.a aVar) {
        if (l.Cf().Bn()) {
            try {
                com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_interstitial_callback", str).b(BusinessType.AD_INTERSTITIAL).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    public final void b(AdTemplate adTemplate, long j6, long j7) {
        a("callback_type", new InterstitialReportInfo().setCallbackType(2L).setClickSceneType(j6).setItemClickType(j7).setAdTemplate(adTemplate));
    }

    public final void v(AdTemplate adTemplate) {
        a("callback_type", new InterstitialReportInfo().setCallbackType(1L).setAdTemplate(adTemplate));
    }

    public final void w(AdTemplate adTemplate) {
        a("callback_type", new InterstitialReportInfo().setCallbackType(3L).setAdTemplate(adTemplate));
    }

    public static a eO() {
        return C0568a.nM;
    }

    public final void a(AdTemplate adTemplate, long j6, long j7) {
        a("action_type", new InterstitialReportInfo().setActionType(1L).setClickSceneType(j6).setItemClickType(j7).setAdTemplate(adTemplate));
    }

    public final void a(AdTemplate adTemplate, double d6) {
        a("action_type", new InterstitialReportInfo().setActionType(2L).setVisiblePercent(d6).setAdTemplate(adTemplate));
    }
}
