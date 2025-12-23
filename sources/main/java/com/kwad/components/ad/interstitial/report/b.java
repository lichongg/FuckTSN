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
public final class b {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {
        private static final b nN = new b();
    }

    public final void x(@NonNull AdTemplate adTemplate) {
        a(false, new InterstitialReportInfo().setDownloadType(adTemplate.getDownloadType()).setStatus(1).setAdTemplate(adTemplate));
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
            com.kwad.sdk.commercial.b.d(cF.i(d6).O("ad_sdk_interstitial_download_error", NotificationCompat.CATEGORY_STATUS).b(BusinessType.AD_INTERSTITIAL).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.beS));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static b eQ() {
        return a.nN;
    }

    public final void b(@NonNull AdTemplate adTemplate, String str) {
        AdInfo el = e.el(adTemplate);
        a(true, new InterstitialReportInfo().setCreativeId(com.kwad.sdk.core.response.b.a.J(el)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(el)).setDownloadSize(adTemplate.getDownloadSize()).setDownloadType(adTemplate.getDownloadType()).setVideoDuration(com.kwad.sdk.core.response.b.a.L(el) * 1000).setStatus(2).setErrorMsg(str).setAdTemplate(adTemplate));
    }
}
