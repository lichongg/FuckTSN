package com.kwad.sdk;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.model.SDKInitMsg;
import com.kwad.sdk.utils.bg;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class m {
    private static int asM;

    public static void a(final com.kwai.adclient.kscommerciallogger.model.d dVar, final String str) {
        com.kwad.sdk.utils.h.execute(new bg() { // from class: com.kwad.sdk.m.7
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.ERROR_LOG, com.kwai.adclient.kscommerciallogger.model.d.this, new SDKInitMsg().setInitCount(m.asM).setErrorReason(str).setInitStatus(2));
            }
        });
    }

    public static void aj(long j6) {
        final long currentTimeMillis = j6 > 0 ? System.currentTimeMillis() - j6 : -1L;
        asM++;
        com.kwad.sdk.utils.h.execute(new bg() { // from class: com.kwad.sdk.m.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.bex, new SDKInitMsg().setLaunchIntervalTime(currentTimeMillis).setInitCount(m.asM).setInitStatus(0));
            }
        });
    }

    public static void ak(final long j6) {
        if (j6 > 10000) {
            j6 = -1;
        }
        com.kwad.sdk.utils.h.execute(new bg() { // from class: com.kwad.sdk.m.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.bex, new SDKInitMsg().setTotalDurationTime(j6).setInitCount(m.asM).setInitStatus(1));
            }
        });
    }

    public static void al(final long j6) {
        if (j6 > 10000) {
            j6 = -1;
        }
        com.kwad.sdk.utils.h.execute(new bg() { // from class: com.kwad.sdk.m.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.bex, new SDKInitMsg().setTotalDurationTime(j6).setInitCount(m.asM).setInitStatus(6));
            }
        });
    }

    public static void am(final long j6) {
        if (j6 > 10000) {
            j6 = -1;
        }
        com.kwad.sdk.utils.h.execute(new bg() { // from class: com.kwad.sdk.m.4
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.bex, new SDKInitMsg().setTotalDurationTime(j6).setInitCount(m.asM).setInitStatus(3));
            }
        });
    }

    public static void an(final long j6) {
        if (j6 > 10000) {
            j6 = -1;
        }
        com.kwad.sdk.utils.h.execute(new bg() { // from class: com.kwad.sdk.m.5
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.bex, new SDKInitMsg().setTotalDurationTime(j6).setInitCount(m.asM).setInitStatus(4));
            }
        });
    }

    public static void ao(final long j6) {
        if (j6 > 10000) {
            j6 = -1;
        }
        com.kwad.sdk.utils.h.execute(new bg() { // from class: com.kwad.sdk.m.6
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.bex, new SDKInitMsg().setTotalDurationTime(j6).setInitCount(m.asM).setInitStatus(5));
            }
        });
    }
}
