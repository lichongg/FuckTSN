package com.kwad.components.ad.reward;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bp;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class p {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {
        private String errorMsg;
        private boolean tq;

        private void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject != null) {
                this.tq = jSONObject.optBoolean("isValid");
                this.errorMsg = jSONObject.toString();
            }
        }

        public final boolean isValid() {
            return this.tq;
        }

        public a(String str) {
            JSONObject jSONObject;
            this.errorMsg = "-";
            try {
                jSONObject = new JSONObject(str);
            } catch (Throwable th) {
                th.printStackTrace();
                this.tq = false;
                this.errorMsg = "数据解析失败";
                jSONObject = null;
            }
            parseJson(jSONObject);
        }
    }

    public static void b(final AdTemplate adTemplate, AdInfo adInfo) {
        final String bR = com.kwad.sdk.core.response.b.a.bR(adInfo);
        com.kwad.sdk.core.d.c.d("ServerCallbackHandle", "handleRewardVerify callbackUrl: " + bR);
        if (!bp.isNullString(bR)) {
            com.kwad.sdk.utils.h.execute(new Runnable() { // from class: com.kwad.components.ad.reward.p.1
                private void K(String str) {
                    com.kwad.components.core.p.a.se().g(adTemplate, 1, str);
                }

                private void hy() {
                    com.kwad.components.core.p.a.se().g(adTemplate, 0, "success");
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        com.kwad.sdk.core.network.c doGet = com.kwad.sdk.g.AI().doGet(bR, null);
                        if (doGet == null) {
                            K("Network Error: url invalid");
                            return;
                        }
                        if (doGet.code == 200) {
                            a aVar = new a(doGet.aEk);
                            if (aVar.isValid()) {
                                hy();
                                return;
                            } else {
                                K(aVar.errorMsg);
                                return;
                            }
                        }
                        K("Network Error: " + doGet.aEk);
                    } catch (Throwable th) {
                        K("Request Error: " + th.getMessage());
                    }
                }
            });
        }
    }
}
