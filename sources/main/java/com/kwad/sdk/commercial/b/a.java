package com.kwad.sdk.commercial.b;

import androidx.core.app.NotificationCompat;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private static void a(AdTemplate adTemplate, com.kwad.sdk.commercial.c.a aVar) {
        a(adTemplate, false, aVar);
    }

    private static void a(AdTemplate adTemplate, boolean z5, com.kwad.sdk.commercial.c.a aVar) {
        aVar.setAdTemplate(adTemplate);
        com.kwad.sdk.commercial.b.d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(z5 ? 0.1d : 0.01d).b(d.be(adTemplate)).O("ad_sdk_appstore_performance", NotificationCompat.CATEGORY_STATUS).z(aVar));
    }

    public static void b(AdTemplate adTemplate, String str, String str2, int i6, int i7) {
        try {
            a(adTemplate, b.DU().cy(2).cH(str).cI(str2).cA(i6).cz(i7));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, String str, int i6, int i7) {
        try {
            a(adTemplate, "", str, i6, i7, "marketUrl is empty");
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, String str, String str2, int i6, int i7) {
        try {
            a(adTemplate, b.DU().cy(1).cH(str).cI(str2).cA(i6).cz(i7));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, String str, String str2, int i6, int i7, String str3) {
        try {
            a(adTemplate, true, b.DU().cy(4).cH(str).cI(str2).cA(i6).cz(i7).setErrorCode(100006).setErrorMsg(str3));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
