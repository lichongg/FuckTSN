package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class i extends b<com.kwad.sdk.core.network.idc.a.b> {
    public i() {
        super("idc", new com.kwad.sdk.core.network.idc.a.b());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void k(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(getKey())) == null) {
            setValue(Gu());
            return;
        }
        com.kwad.sdk.core.network.idc.a.b bVar = new com.kwad.sdk.core.network.idc.a.b();
        bVar.parseJson(optJSONObject);
        setValue(bVar);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
    }
}
