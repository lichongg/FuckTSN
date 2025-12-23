package com.kwad.sdk.liteapi.report;

import android.os.Build;
import com.kwad.sdk.liteapi.LiteApiLogger;
import com.kwad.sdk.liteapi.LiteOAIDHelper;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class b {
    public String LM;
    public String LN;
    public String LO;
    public String aCl;
    public String aIl;
    public int adi;
    public int adk;
    public String adl;

    public static b MV() {
        b bVar = new b();
        try {
            bVar.aCl = LiteOAIDHelper.obtainCurrent();
            bVar.adk = Build.VERSION.SDK_INT;
            bVar.LO = Build.VERSION.RELEASE;
            bVar.adi = 1;
            bVar.adl = Locale.getDefault().getLanguage();
            bVar.aIl = Build.MANUFACTURER;
            bVar.LM = Build.MODEL;
            bVar.LN = Build.BRAND;
        } catch (Throwable unused) {
        }
        return bVar;
    }

    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("oaid", this.aCl);
            return jSONObject;
        } catch (JSONException e6) {
            LiteApiLogger.printStackTrace(e6);
            return jSONObject;
        }
    }

    b() {
    }
}
