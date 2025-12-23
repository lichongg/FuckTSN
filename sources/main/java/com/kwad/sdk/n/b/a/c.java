package com.kwad.sdk.n.b.a;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.aa;
import java.util.List;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class c extends com.kwad.sdk.commercial.c.a {
    public int aJI;
    public List<b> aXN;

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        for (b bVar : this.aXN) {
            aa.putValue(jSONObject, bVar.key, bVar.value);
        }
        aa.putValue(jSONObject, "func_ratio_count", this.aJI);
        JSONObject jSONObject2 = new JSONObject();
        aa.putValue(jSONObject2, "ranger", jSONObject);
        return jSONObject2;
    }
}
