package com.kwad.sdk.core.adlog.b;

import androidx.core.app.NotificationCompat;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private static void a(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, b bVar) {
        a(aVar, cVar, false, bVar);
    }

    public static void b(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i6) {
        try {
            a(aVar, cVar, b.EI().cL(2).cQ(i6));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void a(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, boolean z5, b bVar) {
        com.kwad.sdk.core.adlog.c.a aVar2 = aVar.axr;
        AdTemplate adTemplate = aVar2.adTemplate;
        bVar.cM(aVar2.awx).cN(aVar.retryCount).cO(aVar.axt).m119do(aVar.axu).cP(cVar.axC).bp(cVar.axD).setAdTemplate(adTemplate);
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.DS().cF(ILoggerReporter.Category.APM_LOG).i(z5 ? 1.0d : 0.1d).b(com.kwad.sdk.commercial.d.be(adTemplate)).O("ad_sdk_adlog_retry", NotificationCompat.CATEGORY_STATUS).z(bVar));
    }

    public static void c(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i6) {
        try {
            a(aVar, cVar, true, b.EI().cL(3).cQ(i6));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void d(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i6) {
        try {
            a(aVar, cVar, b.EI().cL(4).cQ(i6));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void e(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i6) {
        try {
            a(aVar, cVar, true, b.EI().cL(7).cQ(i6));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i6, long j6) {
        try {
            a(aVar, cVar, true, b.EI().cL(6).cQ(i6).at(j6));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i6) {
        try {
            a(aVar, cVar, b.EI().cL(1).cQ(i6));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i6, long j6) {
        try {
            a(aVar, cVar, b.EI().cL(5).cQ(i6).at(j6));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
