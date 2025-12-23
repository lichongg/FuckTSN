package com.kwad.components.core.o.c;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.service.ServiceProvider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private static void a(b bVar) {
        a(bVar, false);
    }

    public static void b(String str, long j6, int i6) {
        try {
            a(new b().at(str).G(j6).aL(i6).F(2L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void c(String str, long j6) {
        try {
            a(new b().at(str).G(j6).F(1L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void a(b bVar, boolean z5) {
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.DS().cF(z5 ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).i(z5 ? 1.0d : 0.01d).O("ad_sdk_offline_component_monitor", "load_status").z(bVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
    }

    public static void d(String str, long j6) {
        try {
            a(new b().at(str).G(j6).F(6L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void c(String str, long j6, String str2) {
        try {
            a(new b().at(str).G(j6).av(str2).F(4L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(String str, long j6, String str2) {
        try {
            a(new b().at(str).G(j6).av(str2).F(3L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, long j6, int i6, String str2, String str3) {
        try {
            a(new b().at(str).G(j6).setErrorCode(i6).av(str3).au(str2).F(7L), true);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void c(String str, long j6, int i6) {
        try {
            a(new b().at(str).F(8L).aL(i6).G(j6));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, long j6, String str2) {
        try {
            a(new b().at(str).av(str2).G(j6).F(5L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
