package com.kwad.sdk.resourceCache;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.resourceCache.model.WarmUpReportMessage;
import com.kwad.sdk.resourceCache.model.WarmUpResponse;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    public static void a(final WarmUpResponse.ResourceItem resourceItem, final int i6) {
        h.execute(new bg() { // from class: com.kwad.sdk.resourceCache.c.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.b.b(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.bex, new WarmUpReportMessage().setDownloadStatus(1).setResourceType(i6).setResourceKey(resourceItem.resourceKey).setUrl(resourceItem.url));
            }
        });
    }

    public static void a(final WarmUpResponse.ResourceItem resourceItem, final int i6, int i7, final String str) {
        final int i8 = 0;
        h.execute(new bg() { // from class: com.kwad.sdk.resourceCache.c.4
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.b.b(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.bex, new WarmUpReportMessage().setDownloadStatus(3).setResourceType(i6).setResourceKey(resourceItem.resourceKey).setUrl(resourceItem.url).setErrorCode(i8).setErrorMsg(str));
            }
        });
    }

    public static void b(final WarmUpResponse.ResourceItem resourceItem, final int i6) {
        h.execute(new bg() { // from class: com.kwad.sdk.resourceCache.c.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.b.b(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.bex, new WarmUpReportMessage().setDownloadStatus(4).setResourceType(i6).setResourceKey(resourceItem.resourceKey).setUrl(resourceItem.url));
            }
        });
    }

    public static void c(final WarmUpResponse.ResourceItem resourceItem, final int i6) {
        h.execute(new bg() { // from class: com.kwad.sdk.resourceCache.c.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.b.b(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.bex, new WarmUpReportMessage().setDownloadStatus(2).setResourceType(i6).setResourceKey(resourceItem.resourceKey).setUrl(resourceItem.url));
            }
        });
    }

    public static void a(final List<WarmUpResponse.ResourceItem> list, final List<WarmUpResponse.ResourceItem> list2, final int i6) {
        h.execute(new bg() { // from class: com.kwad.sdk.resourceCache.c.5
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                try {
                    com.kwad.sdk.commercial.b.c(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.bex, new WarmUpReportMessage().setFreeDisk(i6).setConfigItems(aa.S(new ArrayList(list)).toString()).setLocalItems(aa.S(new ArrayList(list2)).toString()));
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
        });
    }
}
