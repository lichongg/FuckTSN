package com.kwad.components.ad.splashscreen;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.t.n;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    private static final Handler iK = new Handler(Looper.getMainLooper());

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {
        private volatile boolean Fa;

        private a() {
            this.Fa = false;
        }

        /* synthetic */ a(byte b6) {
            this();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.ad.splashscreen.b$b, reason: collision with other inner class name */
    static class C0591b {
        private volatile boolean Fb;

        private C0591b() {
            this.Fb = false;
        }

        static /* synthetic */ boolean a(C0591b c0591b, boolean z5) {
            c0591b.Fb = true;
            return true;
        }

        /* synthetic */ C0591b(byte b6) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(C0591b c0591b, AdTemplate adTemplate, long j6, long j7, Runnable runnable) {
        if (!c0591b.Fb) {
            iK.removeCallbacks(runnable);
            return false;
        }
        com.kwad.components.ad.splashscreen.monitor.b.lZ();
        com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 7, j6, j7);
        com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
        return true;
    }

    public static void loadSplashScreenAd(@NonNull KsScene ksScene, @NonNull final KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final SceneImpl covert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.d.d.c(covert);
        com.kwad.components.ad.splashscreen.monitor.b.lZ();
        com.kwad.components.ad.splashscreen.monitor.b.u(covert.getPosId());
        boolean b6 = n.tn().b(covert, "loadSplashScreenAd");
        covert.setAdStyle(4);
        covert.setAdNum(1);
        com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenAd ");
        byte b7 = 0;
        final a aVar = new a(b7);
        aVar.Fa = false;
        final long elapsedRealtime2 = SystemClock.elapsedRealtime();
        final ImpInfo impInfo = new ImpInfo(covert);
        final C0591b c0591b = new C0591b(b7);
        com.kwad.components.core.p.a.se().sg();
        Handler handler = iK;
        handler.postDelayed(new bg() { // from class: com.kwad.components.ad.splashscreen.b.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                b.a(ImpInfo.this);
            }
        }, 15000L);
        final bg bgVar = new bg() { // from class: com.kwad.components.ad.splashscreen.b.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                C0591b.a(C0591b.this, true);
                com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd mTimeOutRunnable timeOut");
                KsLoadManager.SplashScreenAdListener splashScreenAdListener2 = splashScreenAdListener;
                com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aEs;
                splashScreenAdListener2.onError(eVar.errorCode, eVar.msg);
                com.kwad.components.ad.splashscreen.monitor.b.lZ();
                com.kwad.sdk.core.network.e eVar2 = com.kwad.sdk.core.network.e.aEs;
                com.kwad.components.ad.splashscreen.monitor.b.c(false, eVar2.errorCode, eVar2.msg, covert.getPosId());
                com.kwad.components.core.p.a.se().aS(4);
            }
        };
        int a6 = com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.FM);
        if (a6 < 0) {
            a6 = 5000;
        }
        handler.postDelayed(bgVar, a6);
        final long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime;
        com.kwad.components.ad.splashscreen.monitor.b.lZ();
        com.kwad.components.ad.splashscreen.monitor.b.f(covert.getPosId(), elapsedRealtime3);
        SplashPreloadManager.lD().a(covert.getPosId(), 2);
        List<String> lE = SplashPreloadManager.lD().lE();
        List<Integer> i6 = SplashPreloadManager.lD().i(lE);
        com.kwad.components.ad.splashscreen.monitor.b.lZ();
        com.kwad.components.ad.splashscreen.monitor.b.a(covert.getPosId(), lE, i6);
        KsAdLoadManager.M().a(new a.C0634a().e(impInfo).aL(true).aM(b6).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.splashscreen.b.3
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(final int i7, final String str, boolean z5) {
                if (C0591b.this.Fb) {
                    com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd onError isTimeOut return " + String.format("code:%s__msg:%s", Integer.valueOf(i7), str));
                    return;
                }
                b.iK.removeCallbacks(bgVar);
                if (!aVar.Fa && i7 != com.kwad.sdk.core.network.e.aEq.errorCode) {
                    com.kwad.components.ad.splashscreen.monitor.b.lZ();
                    com.kwad.components.ad.splashscreen.monitor.b.b(z5, i7, str, covert.getPosId());
                    com.kwad.components.ad.splashscreen.monitor.b.lZ();
                    com.kwad.components.ad.splashscreen.monitor.b.c(z5, i7, str, covert.getPosId());
                }
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.splashscreen.b.3.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i7), str));
                        splashScreenAdListener.onError(i7, str);
                        if (i7 == com.kwad.sdk.core.network.e.aEt.errorCode) {
                            com.kwad.components.core.p.a.se().aS(0);
                        } else {
                            com.kwad.components.core.p.a.se().aS(3);
                        }
                    }
                });
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(@NonNull final AdResultData adResultData, boolean z5) {
                boolean z6;
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.splashscreen.b.3.2
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        try {
                            splashScreenAdListener.onRequestResult(adResultData.getAdTemplateList().size());
                            com.kwad.components.ad.splashscreen.monitor.a.lX().t(covert.getPosId());
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                        }
                    }
                });
                try {
                    z6 = z5;
                } catch (Throwable th) {
                    th = th;
                    z6 = z5;
                }
                try {
                    if (b.a(adResultData, aVar, this, z6, covert.posId)) {
                        return;
                    }
                    AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
                    adTemplate.loadDataTime = SystemClock.elapsedRealtime() - elapsedRealtime2;
                    adTemplate.requestStartTime = elapsedRealtime;
                    adTemplate.notNetworkRequest = z6;
                    com.kwad.components.ad.splashscreen.monitor.b.lZ();
                    com.kwad.components.ad.splashscreen.monitor.b.e(adTemplate, elapsedRealtime3);
                    com.kwad.sdk.commercial.d.d.a(covert, 1);
                    long elapsedRealtime4 = SystemClock.elapsedRealtime();
                    KsSplashScreenAdControl ksSplashScreenAdControl = new KsSplashScreenAdControl(covert, adResultData);
                    if (com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.FQ)) {
                        SplashPreloadManager.lD();
                        if (SplashPreloadManager.i(adResultData)) {
                            if (b.a(C0591b.this, adTemplate, elapsedRealtime4, elapsedRealtime3, bgVar)) {
                                return;
                            }
                            b.a(splashScreenAdListener, ksSplashScreenAdControl, adTemplate);
                            if (SplashPreloadManager.lD().h(adResultData)) {
                                com.kwad.components.ad.splashscreen.monitor.b.lZ();
                                com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 2, elapsedRealtime4, elapsedRealtime3);
                                com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd cache returned");
                                com.kwad.components.core.p.a.se().aS(1);
                                adTemplate.splashAdLoadType = 2;
                                return;
                            }
                            if (SplashPreloadManager.lD().a(adResultData, true, 1) > 0) {
                                com.kwad.components.ad.splashscreen.monitor.b.lZ();
                                com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 3, elapsedRealtime4, elapsedRealtime3);
                                com.kwad.components.core.p.a.se().aS(2);
                                adTemplate.splashAdLoadType = 1;
                                return;
                            }
                            com.kwad.components.ad.splashscreen.monitor.b.lZ();
                            com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 4, elapsedRealtime4, elapsedRealtime3);
                            return;
                        }
                    }
                    SplashPreloadManager.lD();
                    if (!SplashPreloadManager.i(adResultData)) {
                        SplashPreloadManager.lD();
                        if (!SplashPreloadManager.j(adResultData)) {
                            if (b.a(C0591b.this, adTemplate, elapsedRealtime4, elapsedRealtime3, bgVar)) {
                                return;
                            }
                            b.a(splashScreenAdListener, ksSplashScreenAdControl, adTemplate);
                            com.kwad.components.ad.splashscreen.monitor.b.lZ();
                            com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 8, elapsedRealtime4, elapsedRealtime3);
                            com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd live no cache returned");
                            com.kwad.components.core.p.a.se().aS(5);
                            return;
                        }
                    }
                    boolean h6 = SplashPreloadManager.lD().h(adResultData);
                    com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd onSuccess " + h6);
                    if (h6) {
                        if (b.a(C0591b.this, adTemplate, elapsedRealtime4, elapsedRealtime3, bgVar)) {
                            return;
                        }
                        b.a(splashScreenAdListener, ksSplashScreenAdControl, adTemplate);
                        com.kwad.components.ad.splashscreen.monitor.b.lZ();
                        com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 2, elapsedRealtime4, elapsedRealtime3);
                        com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd cache returned");
                        com.kwad.components.core.p.a.se().aS(1);
                        adTemplate.splashAdLoadType = 2;
                        return;
                    }
                    SplashPreloadManager.lD();
                    if (!SplashPreloadManager.i(adResultData)) {
                        if (!C0591b.this.Fb) {
                            b.iK.removeCallbacks(bgVar);
                            com.kwad.components.ad.splashscreen.monitor.b.lZ();
                            com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 5, elapsedRealtime4, elapsedRealtime3);
                            aVar.Fa = true;
                            a(com.kwad.sdk.core.network.e.aEr.errorCode, "请求成功，但缓存未命中", z6);
                            com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd no cache returned");
                            com.kwad.components.core.p.a.se().aS(3);
                            return;
                        }
                        com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
                        return;
                    }
                    com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd image returned");
                    int a7 = SplashPreloadManager.lD().a(adResultData, true, 1);
                    if (b.a(C0591b.this, adTemplate, elapsedRealtime4, elapsedRealtime3, bgVar)) {
                        return;
                    }
                    if (a7 > 0) {
                        b.a(splashScreenAdListener, ksSplashScreenAdControl, adTemplate);
                        com.kwad.components.ad.splashscreen.monitor.b.lZ();
                        com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 3, elapsedRealtime4, elapsedRealtime3);
                        com.kwad.components.core.p.a.se().aS(2);
                        adTemplate.splashAdLoadType = 1;
                        return;
                    }
                    com.kwad.components.ad.splashscreen.monitor.b.lZ();
                    com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 4, elapsedRealtime4, elapsedRealtime3);
                    aVar.Fa = true;
                    com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aEt;
                    a(eVar.errorCode, eVar.msg, z6);
                } catch (Throwable th2) {
                    th = th2;
                    ServiceProvider.reportSdkCaughtException(th);
                    com.kwad.sdk.core.network.e eVar2 = com.kwad.sdk.core.network.e.aEv;
                    a(eVar2.errorCode, eVar2.msg, z6);
                }
            }
        }).sw());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final KsLoadManager.SplashScreenAdListener splashScreenAdListener, final KsSplashScreenAd ksSplashScreenAd, final AdTemplate adTemplate) {
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.splashscreen.b.4
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                try {
                    KsAdLoadManager.M().a((KsAdLoadManager) KsSplashScreenAd.this);
                    splashScreenAdListener.onSplashScreenAdLoad(KsSplashScreenAd.this);
                    com.kwad.components.ad.splashscreen.monitor.a.lX().af(adTemplate);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(AdResultData adResultData, a aVar, com.kwad.components.core.request.d dVar, boolean z5, long j6) {
        if (adResultData.getAdTemplateList().size() != 0) {
            return false;
        }
        com.kwad.components.ad.splashscreen.monitor.b.lZ();
        com.kwad.components.ad.splashscreen.monitor.b.c(z5, com.kwad.sdk.core.network.e.aEq.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aEq.msg : adResultData.testErrorMsg, j6);
        aVar.Fa = true;
        dVar.a(com.kwad.sdk.core.network.e.aEq.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aEq.msg : adResultData.testErrorMsg, z5);
        com.kwad.components.core.p.a.se().aS(3);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(ImpInfo impInfo) {
        final SceneImpl sceneImpl = impInfo.adScene;
        if (TextUtils.isEmpty(sceneImpl.getBidResponse()) && TextUtils.isEmpty(sceneImpl.getBidResponseV2())) {
            com.kwad.components.core.p.a.se().sh();
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.b.lZ();
            com.kwad.components.ad.splashscreen.monitor.b.v(sceneImpl.posId);
            sceneImpl.setAdStyle(4);
            sceneImpl.setAdNum(5);
            ImpInfo impInfo2 = new ImpInfo(sceneImpl);
            com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache ");
            KsAdLoadManager.M().a(new a.C0634a().e(impInfo2).aM(false).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.splashscreen.b.5
                @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
                public final void b(@NonNull AdResultData adResultData) {
                    try {
                        if (adResultData.getAdTemplateList().size() > 0) {
                            com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache onSuccess:" + adResultData.getAdTemplateList().size() + " saved " + SplashPreloadManager.lD().a(adResultData, false, 2));
                            com.kwad.components.ad.splashscreen.monitor.b.lZ();
                            com.kwad.components.ad.splashscreen.monitor.b.a(adResultData.getAdTemplateList(), SystemClock.elapsedRealtime() - elapsedRealtime, SceneImpl.this.getPosId());
                            com.kwad.components.core.p.a.se().aT(adResultData.getAdTemplateList().size());
                        }
                    } catch (Throwable th) {
                        ServiceProvider.reportSdkCaughtException(th);
                    }
                }

                @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
                public final void onError(int i6, String str) {
                    com.kwad.components.ad.splashscreen.monitor.b.lZ();
                    com.kwad.components.ad.splashscreen.monitor.b.b(i6, str, SceneImpl.this.getPosId());
                    com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i6), str));
                }
            }).sw());
        }
    }
}
