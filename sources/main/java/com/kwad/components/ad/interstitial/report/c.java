package com.kwad.components.ad.interstitial.report;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {
        private static final c nO = new c();
    }

    private static void a(boolean z5, com.kwad.sdk.commercial.c.a aVar) {
        if (l.Cf().Bn()) {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.DS().cF(z5 ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).i(z5 ? 1.0d : 0.01d).O("ad_sdk_interstitial_load", NotificationCompat.CATEGORY_STATUS).b(BusinessType.AD_INTERSTITIAL).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
        }
    }

    public final void A(@NonNull AdTemplate adTemplate) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(10).setAdTemplate(adTemplate));
    }

    public final void B(@NonNull AdTemplate adTemplate) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(7).setAdTemplate(adTemplate));
    }

    public final void C(@NonNull AdTemplate adTemplate) {
        a(true, new InterstitialReportInfo(adTemplate).setStatus(12).setRenderType(com.kwad.sdk.core.response.b.b.di(adTemplate) ? 3 : 1).setAdTemplate(adTemplate));
    }

    public final void D(@NonNull AdTemplate adTemplate) {
        a(true, new InterstitialReportInfo(adTemplate).setStatus(11).setRenderType(1).setAdTemplate(adTemplate));
    }

    public final void b(@NonNull AdTemplate adTemplate, boolean z5) {
        adTemplate.notNetworkRequest = z5;
        a(false, new InterstitialReportInfo(adTemplate).setStatus(3).setType(adTemplate.notNetworkRequest ? 2 : 1).setDownloadDuration(adTemplate.downloadDuration).setDownloadSize(adTemplate.getDownloadSize()).setDownloadType(adTemplate.getDownloadType()).setAdTemplate(adTemplate));
    }

    public final void m(long j6) {
        a(false, new InterstitialReportInfo().setStatus(1).setPosId(j6));
    }

    public final void y(AdTemplate adTemplate) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(6).setAdTemplate(adTemplate));
    }

    public static c eS() {
        return a.nO;
    }

    public final void z(AdTemplate adTemplate) {
        int i6;
        try {
            AdInfo el = e.el(adTemplate);
            InterstitialReportInfo status = new InterstitialReportInfo(adTemplate).setStatus(8);
            if (adTemplate.notNetworkRequest) {
                i6 = 2;
            } else {
                i6 = 1;
            }
            a(false, status.setType(i6).setMaterialType(com.kwad.sdk.core.response.b.a.be(el)).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void a(AdTemplate adTemplate, int i6, String str) {
        a(true, new InterstitialReportInfo(adTemplate).setStatus(9).setErrorCode(i6).setErrorMsg(str).setAdTemplate(adTemplate));
    }

    public final void a(@NonNull AdTemplate adTemplate, boolean z5) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(2).setType(z5 ? 2 : 1).setLoadDataTime(adTemplate.loadDataTime).setExpectedRenderType().setAdTemplate(adTemplate));
    }

    public final void a(@NonNull AdTemplate adTemplate, int i6) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(4).setType(adTemplate.notNetworkRequest ? 2 : 1).setMaterialType(com.kwad.sdk.core.response.b.a.be(e.el(adTemplate))).setRenderDuration(SystemClock.elapsedRealtime() - adTemplate.adShowStartTimeStamp).setRenderType(i6).setExpectedRenderType().setAdTemplate(adTemplate));
    }

    public final void a(int i6, String str, long j6) {
        a(true, new InterstitialReportInfo().setStatus(5).setErrorCode(i6).setErrorMsg(str).setPosId(j6));
    }
}
