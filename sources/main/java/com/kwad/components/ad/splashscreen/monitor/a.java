package com.kwad.components.ad.splashscreen.monitor;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.l;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.ad.splashscreen.monitor.a$a, reason: collision with other inner class name */
    static class C0592a {
        private static final a FS = new a();
    }

    public final void t(long j6) {
        d(new SplashMonitorInfo().setCallbackType(4).setPosId(j6));
    }

    private static SplashMonitorInfo ad(@NonNull AdTemplate adTemplate) {
        int i6;
        AdInfo el = e.el(adTemplate);
        SplashMonitorInfo creativeId = new SplashMonitorInfo().setPreloadId(com.kwad.sdk.core.response.b.a.aZ(el)).setCreativeId(com.kwad.sdk.core.response.b.a.J(el));
        if (com.kwad.sdk.core.response.b.a.bc(el)) {
            i6 = 1;
        } else {
            i6 = 2;
        }
        return creativeId.setMaterialType(i6).setAdTemplate(adTemplate);
    }

    private static void d(com.kwad.sdk.commercial.c.a aVar) {
        if (!l.Cf().Bn()) {
            return;
        }
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_splash_callback", "callback_type").b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
    }

    private static void e(com.kwad.sdk.commercial.c.a aVar) {
        if (!l.Cf().Bn()) {
            return;
        }
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_splash_action", "action_type").b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
    }

    public static a lX() {
        return C0592a.FS;
    }

    public final void ae(@NonNull AdTemplate adTemplate) {
        d(ad(adTemplate).setCallbackType(2));
    }

    public final void af(@NonNull AdTemplate adTemplate) {
        d(ad(adTemplate).setCallbackType(5));
    }

    public final void ag(@NonNull AdTemplate adTemplate) {
        e(ad(adTemplate).setActionType(1));
    }

    public final void ah(@NonNull AdTemplate adTemplate) {
        e(ad(adTemplate).setActionType(2));
    }

    public final void v(@NonNull AdTemplate adTemplate) {
        d(ad(adTemplate).setCallbackType(1));
    }

    public final void w(@NonNull AdTemplate adTemplate) {
        d(ad(adTemplate).setCallbackType(3));
    }
}
