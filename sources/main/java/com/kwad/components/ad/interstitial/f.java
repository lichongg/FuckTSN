package com.kwad.components.ad.interstitial;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.t.n;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.l;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.k;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f {
    public static void loadInterstitialAd(@NonNull KsScene ksScene, @NonNull final KsLoadManager.InterstitialAdListener interstitialAdListener) {
        if (!l.Cf().Bn()) {
            com.kwad.sdk.core.d.c.e("KsAdInterstitialLoadManager", "loadInterstitialAd please init sdk first");
            bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.interstitial.f.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    KsLoadManager.InterstitialAdListener.this.onError(com.kwad.sdk.core.network.e.aEq.errorCode, com.kwad.sdk.core.network.e.aEq.msg + "sdk not init");
                }
            });
            return;
        }
        final SceneImpl covert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.d.d.c(covert);
        boolean b6 = n.tn().b(covert, "loadInterstitialAd");
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        covert.setAdStyle(23);
        com.kwad.components.ad.interstitial.report.c.eS().m(covert.getPosId());
        KsAdLoadManager.M().a(new a.C0634a().e(new ImpInfo(covert)).aM(b6).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.interstitial.f.2
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(@NonNull AdResultData adResultData, boolean z5) {
                final List<AdTemplate> adTemplateList = adResultData.getAdTemplateList();
                if (adTemplateList.isEmpty()) {
                    onError(com.kwad.sdk.core.network.e.aEq.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aEq.msg : adResultData.testErrorMsg);
                    k.aq("insertAd_", "onInterstitialAdCacheFailed");
                    return;
                }
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.interstitial.f.2.2
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        try {
                            interstitialAdListener.onRequestResult(adTemplateList.size());
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                        }
                    }
                });
                try {
                    if (com.kwad.sdk.components.d.f(com.kwad.components.core.o.a.c.a.class) != null) {
                        com.kwad.sdk.components.d.f(com.kwad.components.core.o.a.c.a.class);
                        adTemplateList.get(0);
                        com.kwad.sdk.core.response.b.e.el(adTemplateList.get(0));
                    }
                } catch (Exception unused) {
                }
                com.kwad.components.ad.interstitial.report.c.eS().a(adTemplateList.get(0), z5);
                com.kwad.sdk.commercial.d.d.a(SceneImpl.this, adTemplateList.size());
                SystemClock.elapsedRealtime();
                final ArrayList arrayList = new ArrayList();
                if (com.kwad.sdk.core.response.b.c.u(adResultData)) {
                    ArrayList arrayList2 = new ArrayList();
                    for (AdTemplate adTemplate : adTemplateList) {
                        if (adTemplate != null) {
                            if (adTemplate.mAdScene == null) {
                                adTemplate.mAdScene = SceneImpl.this;
                            }
                            String K = com.kwad.sdk.core.response.b.a.K(com.kwad.sdk.core.response.b.e.el(adTemplate));
                            if (!com.kwad.sdk.core.response.b.b.di(adTemplate)) {
                                com.kwad.components.ad.interstitial.report.realtime.a.eW();
                                com.kwad.components.ad.interstitial.report.realtime.a.F(adTemplate);
                            }
                            if (TextUtils.isEmpty(K)) {
                                arrayList2.add(adTemplate);
                            } else {
                                boolean s5 = com.kwad.components.ad.interstitial.a.a.s(adTemplate);
                                if (com.kwad.sdk.core.config.e.EU() || s5) {
                                    arrayList2.add(adTemplate);
                                }
                            }
                        }
                    }
                    adResultData.setAdTemplateList(arrayList2);
                    arrayList.add(e.f(adResultData));
                } else {
                    for (AdTemplate adTemplate2 : adTemplateList) {
                        if (adTemplate2 != null) {
                            if (adTemplate2.mAdScene == null) {
                                adTemplate2.mAdScene = SceneImpl.this;
                            }
                            String K2 = com.kwad.sdk.core.response.b.a.K(com.kwad.sdk.core.response.b.e.el(adTemplate2));
                            if (!com.kwad.sdk.core.response.b.b.di(adTemplate2)) {
                                com.kwad.components.ad.interstitial.report.realtime.a.eW();
                                com.kwad.components.ad.interstitial.report.realtime.a.F(adTemplate2);
                            }
                            AdResultData a6 = com.kwad.sdk.core.response.b.c.a(adResultData, adTemplate2);
                            if (TextUtils.isEmpty(K2)) {
                                arrayList.add(e.f(a6));
                            } else {
                                boolean s6 = com.kwad.components.ad.interstitial.a.a.s(adTemplate2);
                                if (com.kwad.sdk.core.config.e.EU() || s6) {
                                    arrayList.add(e.f(a6));
                                }
                            }
                        }
                    }
                }
                if (arrayList.size() != 0) {
                    com.kwad.components.ad.interstitial.report.c.eS().b(adTemplateList.get(0), z5);
                    bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.interstitial.f.2.3
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            KsAdLoadManager.M().b(arrayList);
                            k.aq("insertAd_", "onInterstitialAdCacheSuccess");
                            interstitialAdListener.onInterstitialAdLoad(arrayList);
                        }
                    });
                } else {
                    onError(com.kwad.sdk.core.network.e.aEq.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aEq.msg : adResultData.testErrorMsg);
                    com.kwad.components.ad.interstitial.report.realtime.a.eW();
                    com.kwad.components.ad.interstitial.report.realtime.a.a(com.kwad.sdk.core.network.e.aEq);
                    k.aq("insertAd_", "onInterstitialAdCacheFailed");
                }
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
            public final void onError(final int i6, final String str) {
                com.kwad.components.ad.interstitial.report.c.eS().a(i6, str, SceneImpl.this.getPosId());
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.interstitial.f.2.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.w("KsAdInterstitialLoadManager", "loadInterstitialAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i6), str));
                        interstitialAdListener.onError(i6, str);
                    }
                });
            }
        }).sw());
    }
}
