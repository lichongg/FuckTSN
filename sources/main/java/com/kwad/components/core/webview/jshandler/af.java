package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.bw;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class af implements com.kwad.sdk.core.webview.c.a {
    private final com.kwad.sdk.core.webview.b acw;
    private final boolean adc = false;
    private com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, AdResultData> add;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements com.kwad.sdk.core.b {
        AdResultData mAdResultData;

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject json;
            AdResultData adResultData = this.mAdResultData;
            if (adResultData == null || (json = adResultData.toJson()) == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (AdTemplate adTemplate : this.mAdResultData.getAdTemplateList()) {
                if (TextUtils.isEmpty(adTemplate.mOriginJString)) {
                    jSONArray.put(adTemplate.toJson());
                } else {
                    try {
                        jSONArray.put(new JSONObject(adTemplate.mOriginJString));
                    } catch (JSONException e6) {
                        com.kwad.sdk.core.d.c.printStackTrace(e6);
                        jSONArray.put(adTemplate.toJson());
                    }
                }
            }
            com.kwad.sdk.utils.aa.putValue(json, "impAdInfo", jSONArray);
            return json;
        }

        public a(AdResultData adResultData) {
            this.mAdResultData = adResultData;
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (!this.adc) {
            if (this.acw.KJ()) {
                cVar.onError(-1, "native adTemplate is null");
                return;
            } else {
                cVar.a(new a(this.acw.iu()));
                return;
            }
        }
        AdTemplate adTemplate = this.acw.getAdTemplate();
        ImpInfo impInfo = new ImpInfo(adTemplate.mAdScene);
        if (adTemplate.mAdScene != null) {
            impInfo.pageScene = r1.getPageScene();
        }
        impInfo.subPageScene = 106L;
        impInfo.adScene.setAdNum(12);
        impInfo.sdkExtraData = com.kwad.sdk.core.response.b.e.eu(adTemplate);
        a(impInfo, cVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getKsAdData";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, AdResultData> lVar = this.add;
        if (lVar != null) {
            lVar.cancel();
        }
    }

    public af(com.kwad.sdk.core.webview.b bVar) {
        this.acw = bVar;
    }

    private void a(final ImpInfo impInfo, final com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, AdResultData> lVar = this.add;
        if (lVar != null) {
            lVar.cancel();
        }
        com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, AdResultData> lVar2 = new com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, AdResultData>() { // from class: com.kwad.components.core.webview.jshandler.af.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            @NonNull
            /* renamed from: af, reason: merged with bridge method [inline-methods] */
            public AdResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdResultData adResultData = new AdResultData(impInfo.adScene);
                adResultData.parseJson(jSONObject);
                return adResultData;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: ou, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.core.request.a createRequest() {
                return new com.kwad.components.core.request.a(impInfo);
            }
        };
        this.add = lVar2;
        lVar2.request(new com.kwad.sdk.core.network.o<com.kwad.components.core.request.a, AdResultData>() { // from class: com.kwad.components.core.webview.jshandler.af.2
            private void k(int i6, String str) {
                com.kwad.sdk.core.d.c.d("WebCardGetKsAdDataHandler", "requestAggregateAd onError code:" + i6 + " msg: " + str);
                af.this.a(cVar);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.f fVar, @NonNull BaseResultData baseResultData) {
                n((AdResultData) baseResultData);
            }

            private void n(@NonNull final AdResultData adResultData) {
                String str;
                if (adResultData.isAdResultDataEmpty()) {
                    StringBuilder sb = new StringBuilder("onError:");
                    Integer valueOf = Integer.valueOf(com.kwad.sdk.core.network.e.aEq.errorCode);
                    if (TextUtils.isEmpty(adResultData.testErrorMsg)) {
                        str = com.kwad.sdk.core.network.e.aEq.msg;
                    } else {
                        str = adResultData.testErrorMsg;
                    }
                    sb.append(String.format("code:%s__msg:%s", valueOf, str));
                    com.kwad.sdk.core.d.c.d("WebCardGetKsAdDataHandler", sb.toString());
                    bw.runOnUiThread(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.af.2.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            cVar.a(adResultData);
                        }
                    });
                    return;
                }
                bw.runOnUiThread(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.af.2.2
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        cVar.a(adResultData);
                    }
                });
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(@NonNull com.kwad.sdk.core.network.f fVar, int i6, String str) {
                k(i6, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.kwad.sdk.core.webview.c.c cVar) {
        bw.runOnUiThread(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.af.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                AdResultData adResultData = new AdResultData();
                adResultData.setAdTemplateList(new ArrayList());
                cVar.a(adResultData);
            }
        });
    }
}
