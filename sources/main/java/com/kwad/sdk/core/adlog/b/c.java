package com.kwad.sdk.core.adlog.b;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    private static void a(AdTemplate adTemplate, @Nullable com.kwad.sdk.core.adlog.a.a aVar, d dVar) {
        a(adTemplate, aVar, false, dVar);
    }

    public static void b(AdTemplate adTemplate, int i6, com.kwad.sdk.core.adlog.a.a aVar) {
        try {
            a(adTemplate, aVar, d.EJ().cR(2).cS(i6).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void a(AdTemplate adTemplate, @Nullable com.kwad.sdk.core.adlog.a.a aVar, boolean z5, d dVar) {
        if (aVar != null) {
            dVar.cT(1).cU(aVar.retryCount);
        }
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.DS().cF(z5 ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).i(z5 ? 0.01d : 1.0E-4d).j(z5 ? 1.0d : 0.01d).b(com.kwad.sdk.commercial.d.be(adTemplate)).O("ad_sdk_adlog_performance", NotificationCompat.CATEGORY_STATUS).z(dVar));
    }

    public static void c(AdTemplate adTemplate, int i6, String str, int i7, String str2, com.kwad.sdk.core.adlog.a.a aVar) {
        try {
            a(adTemplate, aVar, true, d.EJ().cR(4).cS(i6).dp(str).setErrorCode(i7).setErrorMsg(str2).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void d(AdTemplate adTemplate, int i6, String str, int i7, String str2, com.kwad.sdk.core.adlog.a.a aVar) {
        try {
            a(adTemplate, aVar, true, d.EJ().cR(3).cS(i6).dp(str).setErrorCode(i7).setErrorMsg(str2).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(AdTemplate adTemplate, int i6, String str, int i7, String str2, com.kwad.sdk.core.adlog.a.a aVar) {
        try {
            a(adTemplate, aVar, true, d.EJ().cR(5).cS(i6).dp(str).setErrorCode(i7).setErrorMsg(str2).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, int i6, com.kwad.sdk.core.adlog.a.a aVar) {
        try {
            a(adTemplate, aVar, d.EJ().cR(1).cS(i6).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, int i6, String str, int i7, String str2, com.kwad.sdk.core.adlog.a.a aVar) {
        try {
            a(adTemplate, aVar, d.EJ().cR(5).cS(i6).dp(str).setErrorCode(100004).setErrorMsg(str2).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
