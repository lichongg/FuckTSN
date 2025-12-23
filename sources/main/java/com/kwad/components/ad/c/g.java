package com.kwad.components.ad.c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.j;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.t.n;
import com.kwad.sdk.api.KsBannerAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.l;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.k;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class g {
    public static KsScene bV;

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
                    if (1 == com.kwad.sdk.core.response.b.a.be(el)) {
                        arrayList.add(adTemplate);
                    } else if (com.kwad.sdk.core.response.b.a.bd(el)) {
                        arrayList.add(adTemplate);
                    }
                }
            }
        }
        return arrayList;
    }

    public static void loadBannerAd(KsScene ksScene, @NonNull final KsLoadManager.BannerAdListener bannerAdListener) {
        if (!l.Cf().Bn()) {
            com.kwad.sdk.core.d.c.e("KsAdBannerLoadManager", "loadBannerAd please init sdk first");
            bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.c.g.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    KsLoadManager.BannerAdListener.this.onError(com.kwad.sdk.core.network.e.aEq.errorCode, com.kwad.sdk.core.network.e.aEq.msg + "sdk not init");
                }
            });
            return;
        }
        ksScene.setAdNum(com.kwad.sdk.core.config.e.Gj());
        bV = ksScene;
        final SceneImpl covert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.d.d.c(covert);
        boolean b6 = n.tn().b(covert, "loadBannerAd");
        covert.setAdStyle(5);
        KsAdLoadManager.M().a(new a.C0634a().e(new ImpInfo(covert)).aM(b6).a(new j() { // from class: com.kwad.components.ad.c.g.3
            @Override // com.kwad.components.core.request.j
            @WorkerThread
            public final void ah() {
            }
        }).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.c.g.2
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
            public final void onError(final int i6, final String str) {
                if (i6 != com.kwad.sdk.core.network.e.aEq.errorCode) {
                    com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aEl;
                }
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.c.g.2.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.d("KsAdBannerLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i6), str));
                        KsLoadManager.BannerAdListener.this.onError(i6, str);
                    }
                });
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(@NonNull AdResultData adResultData, boolean z5) {
                String str;
                List a6 = g.a(covert, adResultData.getAdTemplateList());
                if (a6.isEmpty()) {
                    int i6 = com.kwad.sdk.core.network.e.aEq.errorCode;
                    if (TextUtils.isEmpty(adResultData.testErrorMsg)) {
                        str = com.kwad.sdk.core.network.e.aEq.msg;
                    } else {
                        str = adResultData.testErrorMsg;
                    }
                    onError(i6, str);
                    k.aq("bannerAd_", "onBannerAdCacheFailed");
                    return;
                }
                AdVideoPreCacheConfig obtainVideoPreCacheConfig = AdResultData.obtainVideoPreCacheConfig(adResultData, com.kwad.sdk.core.config.e.BQ());
                final AdTemplate adTemplate = (AdTemplate) a6.get(0);
                new h(adResultData);
                com.kwad.sdk.commercial.d.d.a(covert, a6.size());
                final h hVar = new h(adResultData);
                com.kwad.sdk.core.config.e.Gf();
                AdTemplate adTemplate2 = hVar.getAdTemplate();
                if (com.kwad.sdk.core.response.b.a.bd(com.kwad.sdk.core.response.b.e.el(adTemplate2))) {
                    g.a(KsLoadManager.BannerAdListener.this, hVar);
                } else {
                    com.kwad.components.ad.c.a.a.a(adTemplate2, obtainVideoPreCacheConfig, new com.kwad.components.ad.c.a.b() { // from class: com.kwad.components.ad.c.g.2.2
                        @Override // com.kwad.components.ad.c.a.b
                        public final void af() {
                            com.kwad.sdk.core.d.c.d("KsAdBannerLoadManager", "loadFullScreenVideoAd startCacheVideo onCacheTargetSuccess");
                            AdTemplate adTemplate3 = adTemplate;
                            g.a(KsLoadManager.BannerAdListener.this, hVar);
                        }

                        @Override // com.kwad.components.ad.c.a.b
                        public final void ag() {
                            AdTemplate adTemplate3 = adTemplate;
                            g.a(KsLoadManager.BannerAdListener.this, hVar);
                        }
                    });
                }
                com.kwad.sdk.core.d.c.d("KsAdBannerLoadManager", "loadFullScreenVideoAd after cache");
            }
        }).sw());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final KsLoadManager.BannerAdListener bannerAdListener, final KsBannerAd ksBannerAd) {
        bw.postOnUiThread(new bg() { // from class: com.kwad.components.ad.c.g.4
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                k.aq("bannerAd_", "onBannerAdCacheSuccess");
                KsLoadManager.BannerAdListener.this.onBannerAdLoad(ksBannerAd);
            }
        });
    }
}
