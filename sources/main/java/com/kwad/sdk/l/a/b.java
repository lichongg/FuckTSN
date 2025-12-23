package com.kwad.sdk.l.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bh;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    public int aWF;
    public int aWG;
    public int aWH;

    public static synchronized b OO() {
        synchronized (b.class) {
            if (!((h) ServiceProvider.get(h.class)).Bx()) {
                return null;
            }
            return bh.OO();
        }
    }

    private static void a(b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aWF = jSONObject.optInt("cellId", -1);
        bVar.aWG = jSONObject.optInt("lac", -1);
        bVar.aWH = jSONObject.optInt("bsss", -1);
    }

    private static JSONObject b(b bVar, JSONObject jSONObject) {
        aa.putValue(jSONObject, "cellId", bVar.aWF);
        aa.putValue(jSONObject, "lac", bVar.aWG);
        aa.putValue(jSONObject, "bsss", bVar.aWH);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        return b(this, new JSONObject());
    }

    public b(int i6, int i7, int i8) {
        this.aWF = i6;
        this.aWG = i7;
        this.aWH = i8;
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        a(this, jSONObject);
        super.afterParseJson(jSONObject);
    }
}
