package com.kwad.components.core.o.c;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.service.ServiceProvider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    private static void a(d dVar, boolean z5) {
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.DS().cF(z5 ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).i(z5 ? 1.0d : 0.01d).O("ad_sdk_offline_component_update", "load_status").z(dVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
    }

    public static void b(String str, long j6, int i6, String str2, String str3) {
        try {
            a(new d().aw(str).I(j6).setErrorCode(i6).ay(str2).ax(str3).H(2L), true);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void d(String str, long j6, String str2) {
        try {
            a(new d().aw(str).ay(str2).I(j6).H(1L), false);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, long j6, long j7, String str2) {
        try {
            a(new d().aw(str).I(j6).J(j7).ay(str2).H(3L), false);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
