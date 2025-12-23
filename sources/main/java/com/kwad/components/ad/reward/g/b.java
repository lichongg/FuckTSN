package com.kwad.components.ad.reward.g;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.ad.reward.KsRewardVideoAdControl;
import com.kwad.components.core.request.e;
import com.kwad.components.core.request.j;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.t.n;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.commercial.d.d;
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
public final class b {
    public static void a(KsScene ksScene, @NonNull final c cVar) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final SceneImpl covert = SceneImpl.covert(ksScene);
        d.c(covert);
        com.kwad.components.ad.reward.monitor.c.a(true, covert.getPosId());
        boolean b6 = n.tn().b(covert, "loadRewardVideoAd");
        covert.setAdStyle(2);
        KsAdLoadManager.M().a(new a.C0634a().e(new ImpInfo(covert)).aM(b6).a(new j() { // from class: com.kwad.components.ad.reward.g.b.2
            @Override // com.kwad.components.core.request.j
            @WorkerThread
            public final void ah() {
                com.kwad.components.ad.reward.monitor.c.b(true, SceneImpl.this.posId);
            }
        }).a(new e() { // from class: com.kwad.components.ad.reward.g.b.1
            static /* synthetic */ boolean a(AnonymousClass1 anonymousClass1, boolean z5) {
                anonymousClass1.WY = true;
                return true;
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
            public final void onError(final int i6, final String str) {
                com.kwad.components.ad.reward.monitor.c.a(true, i6, str, SceneImpl.this.getPosId());
                if (i6 != com.kwad.sdk.core.network.e.aEq.errorCode && i6 != com.kwad.sdk.core.network.e.aEl.errorCode) {
                    com.kwad.components.ad.reward.monitor.b.c(true, i6);
                }
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.g.b.1.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.d("KsAdRewardLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i6), str));
                        cVar.onError(i6, str);
                    }
                });
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(@NonNull AdResultData adResultData, boolean z5) {
                com.kwad.components.ad.reward.monitor.c.c(true, SceneImpl.this.posId);
                List a6 = b.a(SceneImpl.this, adResultData.getProceedTemplateList());
                if (a6.isEmpty()) {
                    onError(com.kwad.sdk.core.network.e.aEq.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aEq.msg : adResultData.testErrorMsg);
                    k.aq("rewardAd_", "onRewardVideoAdCacheFailed");
                    return;
                }
                AdVideoPreCacheConfig obtainVideoPreCacheConfig = AdResultData.obtainVideoPreCacheConfig(adResultData, com.kwad.sdk.core.config.e.BQ());
                final ArrayList<KsRewardVideoAd> arrayList = new ArrayList();
                final AdTemplate adTemplate = (AdTemplate) a6.get(0);
                arrayList.add(new KsRewardVideoAdControl(adResultData));
                com.kwad.components.ad.reward.monitor.d.a(adTemplate, z5, obtainVideoPreCacheConfig);
                com.kwad.components.ad.reward.monitor.c.a(true, (AdTemplate) a6.get(0), a6.size(), elapsedRealtime);
                d.a(SceneImpl.this, a6.size());
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.g.b.1.2
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        try {
                            KsAdLoadManager.M().b(arrayList);
                            cVar.c(adTemplate, arrayList);
                        } catch (Throwable unused) {
                        }
                        try {
                            z.callMethod(cVar, "onRequestResult", Integer.valueOf(arrayList.size()));
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
                com.kwad.components.ad.reward.monitor.c.d(true, adTemplate);
                final boolean Gf = com.kwad.sdk.core.config.e.Gf();
                boolean z6 = false;
                for (final KsRewardVideoAd ksRewardVideoAd : arrayList) {
                    AdTemplate adTemplate2 = ((KsRewardVideoAdControl) ksRewardVideoAd).getAdTemplate();
                    AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate2);
                    if (!adTemplate2.isNativeRewardPreview && !com.kwad.sdk.core.response.b.a.cR(el) && !com.kwad.sdk.core.response.b.a.bd(el)) {
                        com.kwad.components.ad.d.b.a(adTemplate2, true, obtainVideoPreCacheConfig, new com.kwad.components.ad.d.a() { // from class: com.kwad.components.ad.reward.g.b.1.3
                            @Override // com.kwad.components.ad.d.a
                            public final void af() {
                                com.kwad.sdk.core.d.c.d("KsAdRewardLoadManager", "loadRewardVideoAd startCacheVideo onCacheTargetSuccess");
                                arrayList2.add(ksRewardVideoAd);
                                b.a(adTemplate, cVar, arrayList2);
                                AnonymousClass1.a(AnonymousClass1.this, true);
                            }

                            @Override // com.kwad.components.ad.d.a
                            public final void ag() {
                                if (!Gf || AnonymousClass1.this.WY) {
                                    return;
                                }
                                b.a(adTemplate, cVar, arrayList);
                            }
                        });
                    } else {
                        arrayList2.add(ksRewardVideoAd);
                        b.a(adTemplate, cVar, arrayList2);
                        z6 = true;
                    }
                }
                com.kwad.sdk.core.d.c.d("KsAdRewardLoadManager", "loadRewardVideoAd after cache");
                if (!Gf && !z6 && arrayList2.isEmpty()) {
                    com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aEr;
                    onError(eVar.errorCode, eVar.msg);
                    k.aq("rewardAd_", "onRewardVideoAdCacheFailed");
                    return;
                }
                com.kwad.components.ad.reward.monitor.c.c(true, (AdTemplate) a6.get(0), a6.size(), elapsedRealtime);
            }
        }).sw());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final AdTemplate adTemplate, final c cVar, final List<KsRewardVideoAd> list) {
        bw.postOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.g.b.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                k.aq("rewardAd_", "onRewardVideoAdCacheSuccess");
                c.this.d(adTemplate, list);
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
                    int be = com.kwad.sdk.core.response.b.a.be(el);
                    if (adTemplate.isNativeRewardPreview) {
                        arrayList.add(adTemplate);
                    } else if (com.kwad.sdk.core.response.b.a.cR(el)) {
                        arrayList.add(adTemplate);
                    } else if (1 == be && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.K(el))) {
                        arrayList.add(adTemplate);
                    } else if (com.kwad.sdk.core.response.b.a.bd(el)) {
                        arrayList.add(adTemplate);
                    }
                }
            }
        }
        return arrayList;
    }
}
