package com.kwad.components.ad.reward.monitor;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.proxy.PageCreateStage;
import com.kwad.components.core.t.f;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bg;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    public static void a(final boolean z5, final long j6) {
        GlobalThreadPools.Jy().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.c.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.b.a(z5, new RewardMonitorInfo().setLoadStatus(1).setPosId(j6), com.kwai.adclient.kscommerciallogger.model.a.bez);
            }
        });
    }

    public static void c(final boolean z5, final long j6) {
        GlobalThreadPools.Jy().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.c.23
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.b.a(z5, new RewardMonitorInfo().setLoadStatus(6).setPosId(j6), com.kwai.adclient.kscommerciallogger.model.a.bez);
            }
        });
    }

    public static void d(final boolean z5, @NonNull final AdTemplate adTemplate) {
        GlobalThreadPools.Jy().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.c.27
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                AdInfo el = e.el(AdTemplate.this);
                com.kwad.sdk.commercial.b.a(z5, new RewardMonitorInfo().setLoadStatus(7).setLoadType(AdTemplate.this.isLoadFromCache() ? 2 : 1).setCreativeId(com.kwad.sdk.core.response.b.a.J(el)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(el)).setDownloadType(AdTemplate.this.getDownloadType()).setDownloadSize(AdTemplate.this.getDownloadSize()).setVideoDuration(com.kwad.sdk.core.response.b.a.L(el) * 1000).setAdTemplate(AdTemplate.this), com.kwai.adclient.kscommerciallogger.model.a.bez);
            }
        });
    }

    public static void a(final boolean z5, @NonNull final AdTemplate adTemplate, final int i6, final long j6) {
        GlobalThreadPools.Jy().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.c.26
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                c.b(z5, adTemplate, i6, j6);
            }
        });
    }

    public static void b(final boolean z5, final long j6) {
        GlobalThreadPools.Jy().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.c.12
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.b.a(z5, new RewardMonitorInfo().setLoadStatus(5).setPosId(j6), com.kwai.adclient.kscommerciallogger.model.a.bez);
            }
        });
    }

    public static void c(final boolean z5, final AdTemplate adTemplate, final int i6, final long j6) {
        GlobalThreadPools.Jy().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.c.28
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                c.d(z5, adTemplate, i6, j6);
            }
        });
    }

    public static void d(boolean z5, AdTemplate adTemplate, int i6, long j6) {
        adTemplate.setDownloadFinishTime(SystemClock.elapsedRealtime());
        AdInfo el = e.el(adTemplate);
        long loadDataTime = adTemplate.getLoadDataTime() - j6;
        long downloadFinishTime = adTemplate.getDownloadFinishTime() - adTemplate.getLoadDataTime();
        long downloadFinishTime2 = adTemplate.getDownloadFinishTime() - j6;
        if (a(loadDataTime, downloadFinishTime, downloadFinishTime2)) {
            loadDataTime = -1;
            downloadFinishTime = -1;
            downloadFinishTime2 = -1;
        }
        com.kwad.sdk.commercial.b.a(z5, new RewardMonitorInfo().setLoadStatus(3).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setAdCount(i6).setLoadDataDuration(loadDataTime).setDownloadDuration(downloadFinishTime).setTotalDuration(downloadFinishTime2).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(el)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(el)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(el) * 1000).setAdTemplate(adTemplate), com.kwai.adclient.kscommerciallogger.model.a.bez);
    }

    public static void f(final boolean z5, final AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        GlobalThreadPools.Jy().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.c.4
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                AdInfo el = e.el(AdTemplate.this);
                com.kwad.sdk.commercial.b.c(z5, new RewardMonitorInfo().setPageStatus(5).setLoadType(AdTemplate.this.isLoadFromCache() ? 2 : 1).setDownloadType(AdTemplate.this.getDownloadType()).setDownloadSize(AdTemplate.this.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(el)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(el)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(el) * 1000).setAdTemplate(AdTemplate.this));
            }
        });
    }

    public static void j(boolean z5, @Nullable AdTemplate adTemplate) {
        String str;
        if (adTemplate != null) {
            if (f.aH(adTemplate.mDataCacheTraceElement)) {
                str = "data_cache";
            } else if (f.aH(adTemplate.mDataLoadTraceElement)) {
                str = "data_load";
            }
            com.kwad.sdk.commercial.b.c(z5, new RewardMonitorInfo().setPageStatus(101).setLaunchFrom(str).setSubStage(PageCreateStage.START_LAUNCH.getStage()).setAdTemplate(adTemplate));
        }
        str = "unknown";
        com.kwad.sdk.commercial.b.c(z5, new RewardMonitorInfo().setPageStatus(101).setLaunchFrom(str).setSubStage(PageCreateStage.START_LAUNCH.getStage()).setAdTemplate(adTemplate));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean o(long j6) {
        return j6 == -1;
    }

    public static void T(final AdTemplate adTemplate) {
        GlobalThreadPools.Jy().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.c.5
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                AdInfo el = e.el(AdTemplate.this);
                com.kwad.sdk.commercial.b.c(true, (com.kwad.sdk.commercial.c.a) new RewardMonitorInfo().setPageStatus(7).setLoadType(AdTemplate.this.isLoadFromCache() ? 2 : 1).setDownloadType(AdTemplate.this.getDownloadType()).setDownloadSize(AdTemplate.this.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(el)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(el)).setAdTemplate(AdTemplate.this));
            }
        });
    }

    public static void U(final AdTemplate adTemplate) {
        GlobalThreadPools.Jy().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.c.6
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                AdInfo el = e.el(AdTemplate.this);
                com.kwad.sdk.commercial.b.c(true, (com.kwad.sdk.commercial.c.a) new RewardMonitorInfo().setPageStatus(8).setLoadType(AdTemplate.this.isLoadFromCache() ? 2 : 1).setDownloadType(AdTemplate.this.getDownloadType()).setDownloadSize(AdTemplate.this.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(el)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(el)).setAdTemplate(AdTemplate.this));
            }
        });
    }

    public static void a(final boolean z5, final int i6, final String str, final long j6) {
        GlobalThreadPools.Jy().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.c.29
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.b.a(z5, new RewardMonitorInfo().setLoadStatus(4).setErrorCode(i6).setErrorMsg(str).setPosId(j6), com.kwai.adclient.kscommerciallogger.model.a.bev);
            }
        });
    }

    public static void b(boolean z5, @NonNull AdTemplate adTemplate, int i6, long j6) {
        long loadDataTime = (j6 <= 0 || adTemplate.getLoadDataTime() <= 0) ? -1L : adTemplate.getLoadDataTime() - j6;
        long j7 = a(loadDataTime) ? -1L : loadDataTime;
        AdInfo el = e.el(adTemplate);
        com.kwad.sdk.commercial.b.a(z5, new RewardMonitorInfo().setLoadStatus(2).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setAdCount(i6).setLoadDataDuration(j7).setCreativeId(com.kwad.sdk.core.response.b.a.J(el)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(el)).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setVideoDuration(com.kwad.sdk.core.response.b.a.L(el) * 1000).setAdTemplate(adTemplate), com.kwai.adclient.kscommerciallogger.model.a.bez);
    }

    public static void c(final AdTemplate adTemplate, final int i6, final String str) {
        GlobalThreadPools.Jy().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.c.7
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                AdInfo el = e.el(AdTemplate.this);
                com.kwad.sdk.commercial.b.c(true, (com.kwad.sdk.commercial.c.a) new RewardMonitorInfo().setPageStatus(9).setLoadType(AdTemplate.this.isLoadFromCache() ? 2 : 1).setDownloadType(AdTemplate.this.getDownloadType()).setDownloadSize(AdTemplate.this.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(el)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(el)).setErrorMsg(str).setErrorCode(i6).setAdTemplate(AdTemplate.this));
            }
        });
    }

    public static void e(final boolean z5, final AdTemplate adTemplate) {
        GlobalThreadPools.Jy().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.c.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                AdInfo el = e.el(AdTemplate.this);
                com.kwad.sdk.commercial.b.c(z5, new RewardMonitorInfo().setPageStatus(6).setLoadType(AdTemplate.this.isLoadFromCache() ? 2 : 1).setDownloadType(AdTemplate.this.getDownloadType()).setDownloadSize(AdTemplate.this.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(el)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(el)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(el) * 1000).setAdTemplate(AdTemplate.this));
            }
        });
    }

    public static void g(final boolean z5, final AdTemplate adTemplate) {
        GlobalThreadPools.Jy().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.c.8
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.b.g(new RewardWebViewInfo().setEvent("ad_show").setSceneId(z5 ? "ad_reward" : "ad_fullscreen").setAdTemplate(adTemplate));
            }
        });
    }

    public static void h(final boolean z5, final AdTemplate adTemplate) {
        GlobalThreadPools.Jy().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.c.15
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                AdInfo el = e.el(AdTemplate.this);
                com.kwad.sdk.commercial.b.c(z5, new RewardMonitorInfo().setPageStatus(3).setLoadType(AdTemplate.this.isLoadFromCache() ? 2 : 1).setDownloadType(AdTemplate.this.getDownloadType()).setDownloadSize(AdTemplate.this.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(el)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(el)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(el) * 1000).setAdTemplate(AdTemplate.this));
            }
        });
    }

    public static void i(final boolean z5, @Nullable final AdTemplate adTemplate) {
        GlobalThreadPools.Jy().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.c.20
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                c.j(z5, adTemplate);
            }
        });
    }

    public static void a(final boolean z5, final AdTemplate adTemplate, final String str) {
        GlobalThreadPools.Jy().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.c.30
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                AdInfo el = e.el(AdTemplate.this);
                com.kwad.sdk.commercial.b.b(z5, new RewardMonitorInfo().setLoadType(AdTemplate.this.isLoadFromCache() ? 2 : 1).setDownloadType(AdTemplate.this.getDownloadType()).setDownloadSize(AdTemplate.this.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(el)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(el)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(el) * 1000).setErrorMsg(str).setAdTemplate(AdTemplate.this));
            }
        });
    }

    public static void c(final boolean z5, @Nullable final AdTemplate adTemplate, final String str) {
        GlobalThreadPools.Jy().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.c.21
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.b.c(z5, new RewardMonitorInfo().setPageStatus(101).setSubStage(str).setAdTemplate(adTemplate));
            }
        });
    }

    public static void a(final boolean z5, final AdTemplate adTemplate, final long j6) {
        GlobalThreadPools.Jy().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.c.31
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                c.a(z5, adTemplate, j6, (AdGlobalConfigInfo) null);
            }
        });
    }

    public static void a(final boolean z5, final AdTemplate adTemplate, final long j6, final AdGlobalConfigInfo adGlobalConfigInfo) {
        GlobalThreadPools.Jy().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.c.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                c.b(z5, adTemplate, j6, adGlobalConfigInfo);
            }
        });
    }

    public static void a(final boolean z5, final String str) {
        GlobalThreadPools.Jy().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.c.9
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.b.g(new RewardWebViewInfo().setPageType(str).setEvent("webview_init").setSceneId(z5 ? "ad_reward" : "ad_fullscreen"));
            }
        });
    }

    public static void a(final AdTemplate adTemplate, final boolean z5, final String str, final String str2) {
        GlobalThreadPools.Jy().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.c.10
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.b.g(new RewardWebViewInfo().setPageType(str).setEvent("webview_load_url").setSceneId(z5 ? "ad_reward" : "ad_fullscreen").setUrl(str2).setAdTemplate(adTemplate));
            }
        });
    }

    public static void a(final AdTemplate adTemplate, final boolean z5, final String str, final String str2, final long j6, final int i6) {
        GlobalThreadPools.Jy().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.c.11
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.b.g(new RewardWebViewInfo().setPageType(str).setEvent("webview_timeout").setSceneId(z5 ? "ad_reward" : "ad_fullscreen").setDurationMs(j6).setTimeType(i6).setUrl(str2).setAdTemplate(adTemplate));
            }
        });
    }

    public static void a(final boolean z5, final String str, final String str2, final long j6) {
        GlobalThreadPools.Jy().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.c.13
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.b.g(new RewardWebViewInfo().setPageType(str).setEvent("webview_load_finish").setSceneId(z5 ? "ad_reward" : "ad_fullscreen").setDurationMs(j6).setUrl(str2));
            }
        });
    }

    public static void a(final boolean z5, @Nullable final AdTemplate adTemplate, final a aVar, final long j6, @Nullable com.kwad.sdk.g.a<RewardMonitorInfo> aVar2) {
        final com.kwad.sdk.g.a aVar3 = null;
        GlobalThreadPools.Jy().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.c.17
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                RewardMonitorInfo posId = new RewardMonitorInfo().setCallbackType(a.this.getTypeValue()).setAdTemplate(adTemplate).setPosId(j6);
                com.kwad.sdk.g.a aVar4 = aVar3;
                if (aVar4 != null) {
                    aVar4.accept(posId);
                }
                com.kwad.sdk.commercial.b.e(z5, posId);
            }
        });
    }

    public static void a(final boolean z5, final a aVar, final AdTemplate adTemplate, @Nullable final com.kwad.sdk.g.a<RewardMonitorInfo> aVar2) {
        GlobalThreadPools.Jy().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.c.18
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                c.b(z5, aVar, adTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) aVar2);
            }
        });
    }

    public static void a(final boolean z5, final AdTemplate adTemplate, final long j6, final int i6, final long j7) {
        GlobalThreadPools.Jy().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.c.19
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                AdInfo el = e.el(AdTemplate.this);
                com.kwad.sdk.commercial.b.f(z5, new RewardMonitorInfo().setLoadType(AdTemplate.this.isLoadFromCache() ? 2 : 1).setCurrentDuration(j6).setErrorCode(i6).setErrorMsg(String.valueOf(j7)).setDownloadType(AdTemplate.this.getDownloadType()).setDownloadSize(AdTemplate.this.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(el)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(el)).setVideoDuration(com.kwad.sdk.core.response.b.a.M(el)).setAdTemplate(AdTemplate.this));
            }
        });
    }

    public static void a(final boolean z5, @Nullable final AdTemplate adTemplate, final String str, final String str2) {
        GlobalThreadPools.Jy().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.c.22
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.b.c(z5, new RewardMonitorInfo().setPageStatus(101).setSubStage(str).setErrorMsg(str2).setAdTemplate(adTemplate));
            }
        });
    }

    public static void a(final AdTemplate adTemplate, final int i6, final int i7, final boolean z5) {
        GlobalThreadPools.Jy().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.c.24
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                AdInfo el = e.el(AdTemplate.this);
                com.kwad.sdk.commercial.b.h(new RewardMonitorInfo().setCreativeId(com.kwad.sdk.core.response.b.a.J(el)).setRewardType(!z5 ? 1 : 0).setTaskType(i6).setTaskStep(i7).setVideoUrl(com.kwad.sdk.core.response.b.a.K(el)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(el) * 1000).setAdTemplate(AdTemplate.this));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(long... jArr) {
        for (long j6 : jArr) {
            if (j6 >= 60000) {
                return true;
            }
        }
        return false;
    }

    public static void b(boolean z5, AdTemplate adTemplate, long j6, AdGlobalConfigInfo adGlobalConfigInfo) {
        long loadDataTime = adTemplate.getLoadDataTime();
        long downloadFinishTime = adTemplate.getDownloadFinishTime();
        long j7 = loadDataTime > 0 ? j6 - loadDataTime : 0L;
        long j8 = downloadFinishTime > 0 ? j6 - downloadFinishTime : 0L;
        int i6 = (adGlobalConfigInfo == null || adGlobalConfigInfo.neoPageType == 1) ? 3 : 0;
        AdInfo el = e.el(adTemplate);
        com.kwad.sdk.commercial.b.c(z5, new RewardMonitorInfo().setPageStatus(1).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setAdSceneType(i6).setDataLoadInterval(j7).setDataDownloadInterval(j8).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(el)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(el)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(el) * 1000).setAdTemplate(adTemplate));
    }

    public static void d(final AdTemplate adTemplate, final int i6, final int i7) {
        GlobalThreadPools.Jy().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.c.25
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                AdInfo el = e.el(AdTemplate.this);
                com.kwad.sdk.commercial.b.i(new RewardMonitorInfo().setPageStatus(10).setFraudVerifyType(i6).setFraudVerifyCode(i7).setCreativeId(com.kwad.sdk.core.response.b.a.J(el)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(el)).setAdTemplate(AdTemplate.this));
            }
        });
    }

    public static void b(final boolean z5, final AdTemplate adTemplate, final long j6) {
        GlobalThreadPools.Jy().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.c.14
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                long j7 = -1;
                if (!c.o(j6)) {
                    long elapsedRealtime = SystemClock.elapsedRealtime() - j6;
                    if (!c.a(elapsedRealtime)) {
                        j7 = elapsedRealtime;
                    }
                }
                AdInfo el = e.el(adTemplate);
                com.kwad.sdk.commercial.b.c(z5, new RewardMonitorInfo().setPageStatus(2).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setRenderDuration(j7).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(el)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(el)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(el) * 1000).setAdTemplate(adTemplate));
            }
        });
    }

    public static void b(final boolean z5, final AdTemplate adTemplate, final String str) {
        GlobalThreadPools.Jy().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.c.16
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                AdInfo el = e.el(AdTemplate.this);
                com.kwad.sdk.commercial.b.c(z5, new RewardMonitorInfo().setPageStatus(4).setLoadType(AdTemplate.this.isLoadFromCache() ? 2 : 1).setDownloadType(AdTemplate.this.getDownloadType()).setDownloadSize(AdTemplate.this.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(el)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(el)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(el) * 1000).setInterceptReason(str).setAdTemplate(AdTemplate.this));
            }
        });
    }

    public static void b(boolean z5, a aVar, AdTemplate adTemplate, @Nullable com.kwad.sdk.g.a<RewardMonitorInfo> aVar2) {
        if (adTemplate == null) {
            return;
        }
        RewardMonitorInfo adTemplate2 = new RewardMonitorInfo().setMaterialType(com.kwad.sdk.core.response.b.a.be(e.el(adTemplate))).setCallbackType(aVar.getTypeValue()).setAdTemplate(adTemplate);
        if (aVar2 != null) {
            aVar2.accept(adTemplate2);
        }
        com.kwad.sdk.commercial.b.d(z5, adTemplate2);
    }
}
