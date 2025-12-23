package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import com.ksad.json.annotation.KsJson;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class j extends b<a> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int aCm = 180000;
        public int aCn = 90000;
    }

    public j(String str) {
        super(str, new a());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void k(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(getKey())) == null) {
            setValue(Gu());
            return;
        }
        a aVar = new a();
        aVar.parseJson(optJSONObject);
        setValue(aVar);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        JSONObject jSONObject;
        a value = getValue();
        if (value == null) {
            value = new a();
        }
        try {
            jSONObject = new JSONObject(sharedPreferences.getString(getKey(), ""));
        } catch (JSONException e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
            jSONObject = null;
        }
        if (jSONObject != null) {
            value.parseJson(jSONObject);
        }
        setValue(value);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        if (getValue() != null && getValue().toJson() != null) {
            editor.putString(getKey(), getValue().toJson().toString());
        } else {
            editor.putString(getKey(), "");
        }
    }
}
