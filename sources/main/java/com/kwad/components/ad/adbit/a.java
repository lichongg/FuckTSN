package com.kwad.components.ad.adbit;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.aa;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {

    @NonNull
    public JSONObject bB;

    @NonNull
    public Map<String, String> bC;

    public final String O() {
        for (String str : this.bC.keySet()) {
            aa.putValue(this.bB, str, this.bC.get(str));
        }
        return this.bB.toString();
    }

    public a(@NonNull JSONObject jSONObject, @NonNull Map<String, String> map) {
        this.bB = jSONObject;
        this.bC = map;
    }
}
