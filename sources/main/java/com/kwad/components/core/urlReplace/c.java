package com.kwad.components.core.urlReplace;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    private l<b, MarketUrlReplaceData> Yx;

    public final void a(final String str, final a aVar) {
        l<b, MarketUrlReplaceData> lVar = new l<b, MarketUrlReplaceData>() { // from class: com.kwad.components.core.urlReplace.c.1
            @NonNull
            private static MarketUrlReplaceData aG(String str2) {
                JSONObject jSONObject = new JSONObject(str2);
                MarketUrlReplaceData marketUrlReplaceData = new MarketUrlReplaceData();
                marketUrlReplaceData.parseJson(jSONObject);
                return marketUrlReplaceData;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: sV, reason: merged with bridge method [inline-methods] */
            public b createRequest() {
                return new b(str);
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ MarketUrlReplaceData parseData(String str2) {
                return aG(str2);
            }
        };
        this.Yx = lVar;
        lVar.request(new o<b, MarketUrlReplaceData>() { // from class: com.kwad.components.core.urlReplace.c.2
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                a((MarketUrlReplaceData) baseResultData);
            }

            private void a(@NonNull MarketUrlReplaceData marketUrlReplaceData) {
                if (marketUrlReplaceData.isParseSuccess() && marketUrlReplaceData.isReplaceSuccess()) {
                    aVar.onSuccess(marketUrlReplaceData.getMiMarketUrl());
                }
            }
        });
    }

    public final void sU() {
        l<b, MarketUrlReplaceData> lVar = this.Yx;
        if (lVar != null) {
            lVar.cancel();
            this.Yx = null;
        }
    }
}
