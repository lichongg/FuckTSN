package com.kwad.components.ad.reward;

import androidx.annotation.NonNull;
import com.kwad.components.ad.reward.model.RewardCallBackRespInfo;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class m {
    public static void a(final int i6, final g gVar) {
        com.kwad.sdk.core.network.l<com.kwad.components.core.request.f, RewardCallBackRespInfo> lVar = new com.kwad.sdk.core.network.l<com.kwad.components.core.request.f, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.m.1
            @NonNull
            private static RewardCallBackRespInfo J(String str) {
                JSONObject jSONObject = new JSONObject(str);
                RewardCallBackRespInfo rewardCallBackRespInfo = new RewardCallBackRespInfo();
                rewardCallBackRespInfo.parseJson(jSONObject);
                return rewardCallBackRespInfo;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: hv, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.core.request.f createRequest() {
                return new com.kwad.components.core.request.f(i6, gVar.mAdTemplate);
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ RewardCallBackRespInfo parseData(String str) {
                return J(str);
            }
        };
        if (i6 == 1) {
            lVar.request(k(gVar));
        } else if (i6 == 2) {
            lVar.request(l(gVar));
        }
    }

    private static com.kwad.sdk.core.network.o<com.kwad.components.core.request.f, RewardCallBackRespInfo> k(final g gVar) {
        return new com.kwad.sdk.core.network.o<com.kwad.components.core.request.f, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.m.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onStartRequest(@NonNull com.kwad.components.core.request.f fVar) {
                fVar.requestStartTime = System.currentTimeMillis();
                com.kwad.components.ad.reward.check.a.b(g.this.mAdTemplate, 1);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@NonNull com.kwad.components.core.request.f fVar, @NonNull final RewardCallBackRespInfo rewardCallBackRespInfo) {
                bw.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.m.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.this.mCheckExposureResult = rewardCallBackRespInfo.result == 1;
                    }
                });
                com.kwad.components.ad.reward.check.a.a(g.this.mAdTemplate, 1, System.currentTimeMillis() - fVar.requestStartTime, rewardCallBackRespInfo.result, rewardCallBackRespInfo.errorMsg);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(@NonNull com.kwad.components.core.request.f fVar, int i6, String str) {
                super.onError(fVar, i6, str);
                bw.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.m.2.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.this.mCheckExposureResult = false;
                    }
                });
                com.kwad.components.ad.reward.check.a.a(g.this.mAdTemplate, 1, System.currentTimeMillis() - fVar.requestStartTime, i6, str);
            }
        };
    }

    private static com.kwad.sdk.core.network.o<com.kwad.components.core.request.f, RewardCallBackRespInfo> l(final g gVar) {
        return new com.kwad.sdk.core.network.o<com.kwad.components.core.request.f, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.m.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onStartRequest(@NonNull com.kwad.components.core.request.f fVar) {
                fVar.requestStartTime = System.currentTimeMillis();
                com.kwad.components.ad.reward.check.a.b(g.this.mAdTemplate, 2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@NonNull com.kwad.components.core.request.f fVar, @NonNull final RewardCallBackRespInfo rewardCallBackRespInfo) {
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.m.3.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        if (rewardCallBackRespInfo.result == 1) {
                            g.this.sc = 1;
                        } else {
                            g.this.sc = 2;
                        }
                        g.this.rD.onRewardVerify();
                    }
                });
                com.kwad.components.ad.reward.check.a.a(g.this.mAdTemplate, 2, System.currentTimeMillis() - fVar.requestStartTime, rewardCallBackRespInfo.result, rewardCallBackRespInfo.errorMsg);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(@NonNull com.kwad.components.core.request.f fVar, int i6, String str) {
                super.onError(fVar, i6, str);
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.m.3.2
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        g.this.sc = 2;
                    }
                });
                com.kwad.components.ad.reward.check.a.a(g.this.mAdTemplate, 2, System.currentTimeMillis() - fVar.requestStartTime, i6, str);
            }
        };
    }

    private static boolean m(g gVar) {
        return !gVar.sd && com.kwad.sdk.core.response.b.a.dg(com.kwad.sdk.core.response.b.e.el(gVar.mAdTemplate));
    }

    public static void b(g gVar, long j6, long j7, long j8) {
        long j9;
        boolean m6 = m(gVar);
        if (m6) {
            j9 = com.kwad.sdk.core.response.b.a.de(com.kwad.sdk.core.response.b.e.el(gVar.mAdTemplate));
        } else {
            j9 = 0;
        }
        if (!gVar.sd && m6 && gVar.mCheckExposureResult && j6 > ((j7 - 800) - j8) - j9 && j9 > 0) {
            if (com.kwad.sdk.core.response.b.a.df(com.kwad.sdk.core.response.b.e.el(gVar.mAdTemplate))) {
                gVar.sc = 1;
                a(2, gVar);
            } else {
                gVar.rD.onRewardVerify();
            }
            gVar.sd = true;
        }
    }
}
