package com.kwad.sdk.l.a;

import android.content.Context;
import android.provider.Settings;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.aa;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    public int aWI = 0;
    public int aWJ = 0;
    public int aWK = 0;
    public int aWL = 0;
    public int aWM = 0;
    public int aWN = 0;
    public int aWO = 0;

    private void a(d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.aWI = jSONObject.optInt("isRoot");
        dVar.aWJ = jSONObject.optInt("isXPosed");
        dVar.aWK = jSONObject.optInt("isFrameworkHooked");
        dVar.aWL = jSONObject.optInt("isVirtual");
        dVar.aWM = jSONObject.optInt("isAdbEnabled");
        dVar.aWN = jSONObject.optInt("isEmulator");
        dVar.aWO = jSONObject.optInt("isGroupControl");
        super.afterParseJson(jSONObject);
    }

    private static JSONObject b(d dVar, JSONObject jSONObject) {
        aa.putValue(jSONObject, "isRoot", dVar.aWI);
        aa.putValue(jSONObject, "isXPosed", dVar.aWJ);
        aa.putValue(jSONObject, "isFrameworkHooked", dVar.aWK);
        aa.putValue(jSONObject, "isVirtual", dVar.aWL);
        aa.putValue(jSONObject, "isAdbEnabled", dVar.aWM);
        aa.putValue(jSONObject, "isEmulator", dVar.aWN);
        aa.putValue(jSONObject, "isGroupControl", dVar.aWO);
        return jSONObject;
    }

    private static int bZ(boolean z5) {
        return z5 ? 1 : 2;
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject b6 = b(this, new JSONObject());
        afterToJson(b6);
        return b6;
    }

    public d(Context context) {
        if (context != null) {
            try {
                bW(Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0);
            } catch (Throwable unused) {
            }
        }
    }

    private void bW(boolean z5) {
        this.aWM = bZ(z5);
    }

    public final void bT(boolean z5) {
        this.aWI = bZ(z5);
    }

    public final void bU(boolean z5) {
        this.aWJ = bZ(z5);
    }

    public final void bV(boolean z5) {
        this.aWK = bZ(z5);
    }

    public final void bX(boolean z5) {
        this.aWN = bZ(z5);
    }

    public final void bY(boolean z5) {
        this.aWO = bZ(z5);
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        a(this, jSONObject);
        afterParseJson(jSONObject);
    }
}
