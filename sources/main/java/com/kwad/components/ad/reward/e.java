package com.kwad.components.ad.reward;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {
        private static e rA = new e(0);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b extends com.kwad.sdk.core.network.l<f, BaseResultData> {

        @NonNull
        private AdTemplate adTemplate;
        private com.kwad.sdk.core.network.o<f, BaseResultData> rB = new com.kwad.sdk.core.network.o<f, BaseResultData>() { // from class: com.kwad.components.ad.reward.e.b.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                super.onSuccess(fVar, baseResultData);
                com.kwad.components.core.p.a.se().g(b.this.adTemplate, 0, "success");
                com.kwad.sdk.core.d.c.i("RewardCallbackVerifyHelper", "callbackUrlInfo verify success");
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(@NonNull f fVar, int i6, String str) {
                super.onError(fVar, i6, str);
                com.kwad.components.core.p.a.se().g(b.this.adTemplate, 1, str);
                com.kwad.sdk.core.d.c.i("RewardCallbackVerifyHelper", "callbackUrlInfo verify failed");
            }
        };

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: gB, reason: merged with bridge method [inline-methods] */
        public f createRequest() {
            return new f(this.adTemplate);
        }

        public final void gA() {
            request(this.rB);
        }

        @Override // com.kwad.sdk.core.network.l
        @NonNull
        public final BaseResultData parseData(String str) {
            BaseResultData baseResultData = new BaseResultData() { // from class: com.kwad.components.ad.reward.RewardCallbackVerifyHelper$ServerCallbackNetworking$2
            };
            if (!TextUtils.isEmpty(str)) {
                try {
                    baseResultData.parseJson(new JSONObject(str));
                    return baseResultData;
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            }
            return baseResultData;
        }

        public b(@NonNull AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
        }
    }

    /* synthetic */ e(byte b6) {
        this();
    }

    private e() {
    }

    private static void M(AdTemplate adTemplate) {
        new b(adTemplate).gA();
    }

    public final void L(AdTemplate adTemplate) {
        com.kwad.sdk.core.d.c.d("RewardCallbackVerifyHelper", "handleRewardVerify");
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        if (TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.bS(el))) {
            p.b(adTemplate, el);
        } else {
            M(adTemplate);
        }
    }

    public static e gy() {
        return a.rA;
    }
}
