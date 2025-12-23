package com.kwad.components.ad.draw.a;

import androidx.core.app.NotificationCompat;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    public static void a(SceneImpl sceneImpl, String str) {
        try {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.DS().cF(ILoggerReporter.Category.ERROR_LOG).i(1.0d).b(BusinessType.AD_DRAW).O("ad_sdk_draw_params_monitor", "method_name").z(a.aM().o(str).setPosId(sceneImpl.getPosId())));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(SceneImpl sceneImpl) {
        a(a.aM().s(1).t(sceneImpl.getAdNum()).setPosId(sceneImpl.getPosId()), false);
    }

    public static void h(AdTemplate adTemplate) {
        AdInfo el = e.el(adTemplate);
        a(a.aM().u(com.kwad.sdk.core.response.b.a.be(el)).p(com.kwad.sdk.core.response.b.a.K(el)).x(adTemplate.adStyle).s(4).setAdTemplate(adTemplate), true);
    }

    public static void i(AdTemplate adTemplate) {
        a(a.aM().s(6).setAdTemplate(adTemplate), false);
    }

    public static void b(SceneImpl sceneImpl, int i6, long j6) {
        a(a.aM().s(5).e(j6).t(i6).setPosId(sceneImpl.getPosId()), false);
    }

    public static void b(AdTemplate adTemplate, long j6, String str) {
        a(a.aM().s(8).f(j6).setAdTemplate(adTemplate).setErrorMsg(str), true);
    }

    public static void a(SceneImpl sceneImpl, int i6, long j6) {
        a(a.aM().s(2).g(j6).t(i6).setPosId(sceneImpl.getPosId()), false);
    }

    public static void b(AdTemplate adTemplate, int i6, int i7) {
        a(a.aM().s(10).v(i6).w(i7).setAdTemplate(adTemplate), false);
    }

    public static void a(SceneImpl sceneImpl, int i6, String str, long j6) {
        try {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.DS().cF(ILoggerReporter.Category.ERROR_LOG).i(0.01d).b(BusinessType.AD_DRAW).O("ad_sdk_draw_load", NotificationCompat.CATEGORY_STATUS).z(a.aM().s(3).g(j6).t(0).setPosId(sceneImpl.getPosId()).setErrorCode(i6).setErrorMsg(str)));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, long j6, int i6, int i7, boolean z5) {
        try {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.DS().cF(z5 ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).i(z5 ? 0.01d : 0.001d).b(BusinessType.AD_DRAW).O("ad_sdk_draw_load", NotificationCompat.CATEGORY_STATUS).z(a.aM().s(7).f(j6).v(i6).w(i7).setAdTemplate(adTemplate)));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, int i6, int i7) {
        a(a.aM().s(9).v(i6).w(i7).setAdTemplate(adTemplate), false);
    }

    private static void a(com.kwad.sdk.commercial.c.a aVar, boolean z5) {
        try {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.DS().cF(z5 ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).i(z5 ? 1.0d : 0.001d).b(BusinessType.AD_DRAW).O("ad_sdk_draw_load", NotificationCompat.CATEGORY_STATUS).z(aVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
