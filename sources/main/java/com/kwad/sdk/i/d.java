package com.kwad.sdk.i;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class d implements b {
    public List<e> aSB;
    public long intervalTime;

    @Override // com.kwad.sdk.i.b
    public final JSONObject toJson() {
        return null;
    }

    public final long MW() {
        long j6 = this.intervalTime;
        if (j6 > 0) {
            return j6;
        }
        return 5000L;
    }

    public final void parseJson(@Nullable JSONObject jSONObject) {
        this.intervalTime = jSONObject.optInt("intervalTime", 5000);
        this.aSB = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("configList");
        if (optJSONArray != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                e eVar = new e();
                eVar.parseJson(optJSONArray.optJSONObject(i6));
                this.aSB.add(eVar);
            }
        }
    }

    d() {
    }
}
