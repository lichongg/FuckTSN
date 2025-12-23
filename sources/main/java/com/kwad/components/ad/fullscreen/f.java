package com.kwad.components.ad.fullscreen;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.j;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.t.n;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.utils.z;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f {
    public static void a(KsScene ksScene, @NonNull final e eVar) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final SceneImpl covert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.d.d.c(covert);
        com.kwad.components.ad.reward.monitor.c.a(false, covert.getPosId());
        boolean b6 = n.tn().b(covert, "loadFullScreenVideoAd");
        covert.setAdStyle(3);
        KsAdLoadManager.M().a(new a.C0634a().e(new ImpInfo(covert)).aM(b6).a(new j() { // from class: com.kwad.components.ad.fullscreen.f.2
            @Override // com.kwad.components.core.request.j
            @WorkerThread
            public final void ah() {
                com.kwad.components.ad.reward.monitor.c.b(false, SceneImpl.this.posId);
            }
        }).a(new com.kwad.components.core.request.e() { // from class: com.kwad.components.ad.fullscreen.f.1
            static /* synthetic */ boolean a(AnonymousClass1 anonymousClass1, boolean z5) {
                anonymousClass1.WY = true;
                return true;
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
            public final void onError(final int i6, final String str) {
                com.kwad.components.ad.reward.monitor.c.a(false, i6, str, SceneImpl.this.getPosId());
                if (i6 != com.kwad.sdk.core.network.e.aEq.errorCode && i6 != com.kwad.sdk.core.network.e.aEl.errorCode) {
                    com.kwad.components.ad.reward.monitor.b.c(false, i6);
                }
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.fullscreen.f.1.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.d("KsAdFullScreenLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i6), str));
                        eVar.onError(i6, str);
                    }
                });
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(@NonNull AdResultData adResultData, boolean z5) {
                com.kwad.components.ad.reward.monitor.c.c(false, SceneImpl.this.posId);
                List<AdTemplate> a6 = f.a(SceneImpl.this, adResultData.getAdTemplateList());
                if (a6.isEmpty()) {
                    onError(com.kwad.sdk.core.network.e.aEq.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aEq.msg : adResultData.testErrorMsg);
                    k.aq("fullAd_", "onFullScreenVideoAdCacheFailed");
                    return;
                }
                AdVideoPreCacheConfig obtainVideoPreCacheConfig = AdResultData.obtainVideoPreCacheConfig(adResultData, com.kwad.sdk.core.config.e.BQ());
                final ArrayList<KsFullScreenVideoAd> arrayList = new ArrayList();
                for (AdTemplate adTemplate : a6) {
                    arrayList.add(new g(com.kwad.sdk.core.response.b.c.a(adResultData, adTemplate)));
                    com.kwad.components.ad.reward.monitor.d.a(adTemplate, z5, obtainVideoPreCacheConfig);
                }
                final AdTemplate adTemplate2 = (AdTemplate) a6.get(0);
                com.kwad.components.ad.reward.monitor.c.a(false, adTemplate2, a6.size(), elapsedRealtime);
                com.kwad.sdk.commercial.d.d.a(SceneImpl.this, a6.size());
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.fullscreen.f.1.2
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        try {
                            eVar.a(adTemplate2, arrayList);
                        } catch (Throwable unused) {
                        }
                        try {
                            z.callMethod(eVar, "onRequestResult", Integer.valueOf(arrayList.size()));
                        } catch (Throwable unused2) {
                        }
                    }
                });
                try {
                    if (com.kwad.sdk.components.d.f(com.kwad.components.core.o.a.c.a.class) != null) {
                        com.kwad.sdk.components.d.f(com.kwad.components.core.o.a.c.a.class);
                        a6.get(0);
                        com.kwad.sdk.core.response.b.e.el((AdTemplate) a6.get(0));
                    }
                } catch (Exception unused) {
                }
                final ArrayList arrayList2 = new ArrayList();
                com.kwad.components.ad.reward.monitor.c.d(false, adTemplate2);
                final boolean Gf = com.kwad.sdk.core.config.e.Gf();
                for (final KsFullScreenVideoAd ksFullScreenVideoAd : arrayList) {
                    AdTemplate adTemplate3 = ((g) ksFullScreenVideoAd).getAdTemplate();
                    AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate3);
                    if (!com.kwad.sdk.core.response.b.a.bd(el) && !com.kwad.sdk.core.response.b.a.cR(el)) {
                        com.kwad.components.ad.d.b.a(adTemplate3, false, obtainVideoPreCacheConfig, new com.kwad.components.ad.d.a() { // from class: com.kwad.components.ad.fullscreen.f.1.3
                            @Override // com.kwad.components.ad.d.a
                            public final void af() {
                                com.kwad.sdk.core.d.c.d("KsAdFullScreenLoadManager", "loadFullScreenVideoAd startCacheVideo onCacheTargetSuccess");
                                arrayList2.add(ksFullScreenVideoAd);
                                AnonymousClass1.a(AnonymousClass1.this, true);
                                f.a(adTemplate2, eVar, arrayList2);
                            }

                            @Override // com.kwad.components.ad.d.a
                            public final void ag() {
                                if (!Gf || AnonymousClass1.this.WY) {
                                    return;
                                }
                                f.a(adTemplate2, eVar, arrayList);
                            }
                        });
                    } else {
                        arrayList2.add(ksFullScreenVideoAd);
                        this.WY = true;
                        f.a(adTemplate2, eVar, arrayList2);
                    }
                }
                com.kwad.sdk.core.d.c.d("KsAdFullScreenLoadManager", "loadFullScreenVideoAd after cache");
                if (!Gf && arrayList2.isEmpty()) {
                    com.kwad.sdk.core.network.e eVar2 = com.kwad.sdk.core.network.e.aEr;
                    onError(eVar2.errorCode, eVar2.msg);
                    k.aq("fullAd_", "onFullScreenVideoAdCacheFailed");
                    return;
                }
                com.kwad.components.ad.reward.monitor.c.c(false, (AdTemplate) a6.get(0), a6.size(), elapsedRealtime);
            }
        }).sw());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final AdTemplate adTemplate, final e eVar, final List<KsFullScreenVideoAd> list) {
        bw.postOnUiThread(new bg() { // from class: com.kwad.components.ad.fullscreen.f.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                k.aq("fullAd_", "onFullScreenVideoAdCacheFailed");
                KsAdLoadManager.M().b(list);
                eVar.b(adTemplate, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static List<AdTemplate> a(SceneImpl sceneImpl, List<AdTemplate> list) {
        ArrayList arrayList = new ArrayList();
        if (!list.isEmpty()) {
            for (AdTemplate adTemplate : list) {
                if (adTemplate != null) {
                    if (adTemplate.mAdScene == null) {
                        adTemplate.mAdScene = sceneImpl;
                    }
                    AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
                    if (1 == com.kwad.sdk.core.response.b.a.be(el) && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.K(el))) {
                        arrayList.add(adTemplate);
                    } else if (com.kwad.sdk.core.response.b.a.bd(el)) {
                        arrayList.add(adTemplate);
                    } else if (com.kwad.sdk.core.response.b.a.cR(el)) {
                        arrayList.add(adTemplate);
                    }
                }
            }
        }
        return arrayList;
    }
}
