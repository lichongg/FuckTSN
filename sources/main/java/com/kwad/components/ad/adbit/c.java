package com.kwad.components.ad.adbit;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.d;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bg;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    private static <T extends com.kwad.components.core.request.a> T a(com.kwad.sdk.g.c<T> cVar) {
        return cVar.get();
    }

    public static String a(SceneImpl sceneImpl) {
        SceneImpl.covert(sceneImpl);
        final com.kwad.components.core.request.model.a sw = new a.C0634a().e(new ImpInfo(sceneImpl)).a(new d()).sw();
        b bVar = (b) a(new com.kwad.sdk.g.c<b>() { // from class: com.kwad.components.ad.adbit.c.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.c
            /* renamed from: P, reason: merged with bridge method [inline-methods] */
            public b get() {
                return new b(com.kwad.components.core.request.model.a.this);
            }
        });
        return new a(bVar.getBody(), bVar.getHeader()).O();
    }

    public static List<AdTemplate> b(AdBitResultData adBitResultData) {
        AdTemplate a6;
        ArrayList arrayList = new ArrayList();
        for (AdBid adBid : adBitResultData.adBidList) {
            if (adBid != null && adBid.bidEcpm > 0) {
                long j6 = adBid.creativeId;
                if (j6 > 0 && (a6 = a(adBitResultData, j6)) != null) {
                    a6.mBidEcpm = adBid.bidEcpm;
                    arrayList.add(a6);
                }
            }
        }
        return arrayList;
    }

    public static boolean c(@NonNull final com.kwad.components.core.request.model.a aVar) {
        String bidResponseV2 = aVar.Rw.adScene.getBidResponseV2();
        if (!TextUtils.isEmpty(bidResponseV2)) {
            a(bidResponseV2, aVar);
            return true;
        }
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        final String bidResponse = aVar.Rw.adScene.getBidResponse();
        if (TextUtils.isEmpty(bidResponse)) {
            return false;
        }
        GlobalThreadPools.Jt().submit(new bg() { // from class: com.kwad.components.ad.adbit.c.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                try {
                    com.kwad.components.core.request.model.a.this.aE("server_bid_one");
                    com.kwad.components.core.request.model.a aVar2 = com.kwad.components.core.request.model.a.this;
                    com.kwad.sdk.commercial.d.d.c(aVar2.Rw.adScene, aVar2.sv());
                    JSONObject jSONObject = new JSONObject(bidResponse);
                    AdBitResultData adBitResultData = new AdBitResultData(com.kwad.components.core.request.model.a.this.Rw.adScene);
                    adBitResultData.parseJson(jSONObject);
                    adBitResultData.setAdTemplateList(c.b(adBitResultData));
                    adBitResultData.setAdSource("server_bid_one");
                    if (adBitResultData.isAdResultDataEmpty()) {
                        com.kwad.components.core.request.model.a.a(com.kwad.components.core.request.model.a.this, adBitResultData, true);
                        return;
                    }
                    AdTemplate adTemplate = adBitResultData.getAdTemplateList().get(0);
                    int adStyle = com.kwad.components.core.request.model.a.this.Rw.adScene.getAdStyle();
                    if (adStyle == 10000 || adStyle == e.ef(adTemplate)) {
                        com.kwad.components.core.request.model.a.a(com.kwad.components.core.request.model.a.this, adBitResultData, true);
                        return;
                    }
                    com.kwad.components.core.request.model.a aVar3 = com.kwad.components.core.request.model.a.this;
                    com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aEu;
                    com.kwad.components.core.request.model.a.a(aVar3, eVar.errorCode, eVar.msg, true);
                } catch (Exception e6) {
                    com.kwad.components.core.request.model.a aVar4 = com.kwad.components.core.request.model.a.this;
                    com.kwad.sdk.core.network.e eVar2 = com.kwad.sdk.core.network.e.aEp;
                    com.kwad.components.core.request.model.a.a(aVar4, eVar2.errorCode, eVar2.msg, true);
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
                }
            }
        });
        return true;
    }

    public static String getBidRequestTokenV2(KsScene ksScene) {
        final com.kwad.components.core.request.model.a sw = new a.C0634a().e(new ImpInfo(SceneImpl.covert(ksScene))).a(new d()).sw();
        com.kwad.components.ad.a.a aVar = (com.kwad.components.ad.a.a) a(new com.kwad.sdk.g.c<com.kwad.components.ad.a.a>() { // from class: com.kwad.components.ad.adbit.c.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.c
            /* renamed from: Q, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.ad.a.a get() {
                return new com.kwad.components.ad.a.a(com.kwad.components.core.request.model.a.this);
            }
        });
        return new a(aVar.getBody(), aVar.getHeader()).O();
    }

    private static void a(String str, @NonNull com.kwad.components.core.request.model.a aVar) {
        try {
            aVar.aE("server_bid_two");
            com.kwad.sdk.commercial.d.d.c(aVar.Rw.adScene, aVar.sv());
            JSONObject jSONObject = new JSONObject(str);
            AdBitResultData adBitResultData = new AdBitResultData(aVar.Rw.adScene);
            adBitResultData.parseJson(jSONObject);
            List<String> a6 = a(adBitResultData);
            if (a6.isEmpty()) {
                com.kwad.components.core.request.model.a.a(aVar, com.kwad.sdk.core.network.e.aEq.errorCode, TextUtils.isEmpty(adBitResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aEq.msg : adBitResultData.testErrorMsg, false);
            } else {
                a(a6, adBitResultData, aVar);
            }
        } catch (Exception e6) {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aEp;
            com.kwad.components.core.request.model.a.a(aVar, eVar.errorCode, eVar.msg, false);
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
        }
    }

    private static void a(final List<String> list, final AdBitResultData adBitResultData, final com.kwad.components.core.request.model.a aVar) {
        new l<com.kwad.components.ad.a.b, AdBitResultData>() { // from class: com.kwad.components.ad.adbit.c.4
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: R, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.ad.a.b createRequest() {
                return new com.kwad.components.ad.a.b(adBitResultData.adxId, list);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            @NonNull
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public AdBitResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdBitResultData adBitResultData2 = new AdBitResultData(com.kwad.components.core.request.model.a.this.Rw.adScene);
                adBitResultData2.parseJson(jSONObject);
                return adBitResultData2;
            }
        }.request(new o<com.kwad.components.ad.a.b, AdBitResultData>() { // from class: com.kwad.components.ad.adbit.c.5
            private void b(int i6, String str) {
                com.kwad.components.core.request.model.a.a(aVar, i6, str, false);
            }

            private void c(@NonNull AdBitResultData adBitResultData2) {
                adBitResultData2.setAdTemplateList(c.a(AdBitResultData.this, adBitResultData2));
                adBitResultData2.setAdSource("server_bid_two");
                if (adBitResultData2.isAdResultDataEmpty()) {
                    com.kwad.components.core.request.model.a.a(aVar, adBitResultData2, false);
                    return;
                }
                AdTemplate adTemplate = adBitResultData2.getAdTemplateList().get(0);
                int i6 = aVar.Rw.adScene.adStyle;
                if (i6 == 10000 || i6 == e.ef(adTemplate)) {
                    com.kwad.components.core.request.model.a.a(aVar, adBitResultData2, false);
                    return;
                }
                com.kwad.components.core.request.model.a aVar2 = aVar;
                com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aEu;
                com.kwad.components.core.request.model.a.a(aVar2, eVar.errorCode, eVar.msg, false);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                c((AdBitResultData) baseResultData);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(@NonNull f fVar, int i6, String str) {
                b(i6, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<AdTemplate> a(AdBitResultData adBitResultData, AdBitResultData adBitResultData2) {
        AdTemplate a6;
        ArrayList arrayList = new ArrayList();
        for (AdBid adBid : adBitResultData.adBidList) {
            if (adBid != null && adBid.bidEcpm > 0) {
                long j6 = adBid.creativeId;
                if (j6 > 0 && (a6 = a(adBitResultData2, j6)) != null) {
                    a6.mBidEcpm = adBid.bidEcpm;
                    arrayList.add(a6);
                }
            }
        }
        return arrayList;
    }

    private static List<String> a(AdBitResultData adBitResultData) {
        ArrayList arrayList = new ArrayList();
        for (AdBid adBid : adBitResultData.adBidList) {
            if (adBid != null && adBid.bidEcpm > 0 && adBid.creativeId > 0) {
                arrayList.add(adBid.materialId);
            }
        }
        return arrayList;
    }

    @Nullable
    private static AdTemplate a(AdBitResultData adBitResultData, long j6) {
        for (AdTemplate adTemplate : adBitResultData.getAdTemplateList()) {
            if (adTemplate != null && j6 == e.ev(adTemplate)) {
                return adTemplate;
            }
        }
        return null;
    }
}
