package com.kwad.components.ad.draw.a;

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
    public static void a(AdTemplate adTemplate, long j6) {
        AdInfo el = e.el(adTemplate);
        a(d.aN().y(2).z(com.kwad.sdk.core.response.b.a.be(el)).q(com.kwad.sdk.core.response.b.a.bb(el)).h(j6).setAdTemplate(adTemplate), false);
    }

    public static void g(AdTemplate adTemplate) {
        AdInfo el = e.el(adTemplate);
        a(d.aN().y(1).z(com.kwad.sdk.core.response.b.a.be(el)).q(com.kwad.sdk.core.response.b.a.bb(el)).setAdTemplate(adTemplate), false);
    }

    public static void a(AdTemplate adTemplate, long j6, String str) {
        AdInfo el = e.el(adTemplate);
        a(d.aN().y(3).z(com.kwad.sdk.core.response.b.a.be(el)).q(com.kwad.sdk.core.response.b.a.bb(el)).h(j6).setAdTemplate(adTemplate).setErrorMsg(str), true);
    }

    private static void a(com.kwad.sdk.commercial.c.a aVar, boolean z5) {
        try {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.DS().cF(z5 ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).i(z5 ? 1.0d : 0.001d).b(BusinessType.AD_DRAW).O("ad_sdk_draw_material_load", NotificationCompat.CATEGORY_STATUS).z(aVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
