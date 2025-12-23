package com.kwad.components.ad.interstitial.report;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {
        private static final d nP = new d();
    }

    public final void b(@NonNull AdTemplate adTemplate, long j6) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(3).setCreativeId(e.ev(adTemplate)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(e.el(adTemplate))).setVideoDuration(com.kwad.sdk.core.response.b.a.L(r0) * 1000).setPlayStartedDuration(j6).setAdTemplate(adTemplate));
    }

    public final void E(@NonNull AdTemplate adTemplate) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(1).setAdTemplate(adTemplate));
    }

    private static void a(boolean z5, com.kwad.sdk.commercial.c.a aVar) {
        double d6;
        try {
            com.kwad.sdk.commercial.c cF = com.kwad.sdk.commercial.c.DS().cF(ILoggerReporter.Category.APM_LOG);
            if (z5) {
                d6 = 1.0d;
            } else {
                d6 = 0.01d;
            }
            com.kwad.sdk.commercial.b.d(cF.i(d6).O("ad_sdk_interstitial_play", NotificationCompat.CATEGORY_STATUS).b(BusinessType.AD_INTERSTITIAL).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static d eU() {
        return a.nP;
    }

    public final void b(@NonNull AdTemplate adTemplate, int i6, String str) {
        AdInfo el = e.el(adTemplate);
        a(true, new InterstitialReportInfo(adTemplate).setCreativeId(com.kwad.sdk.core.response.b.a.J(el)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(el)).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setVideoDuration(com.kwad.sdk.core.response.b.a.L(el) * 1000).setStatus(2).setErrorMsg(str).setErrorCode(i6).setAdTemplate(adTemplate));
    }
}
