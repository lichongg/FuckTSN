package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class h extends b<a> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public String aCk = "";
        public String aCl = "";
    }

    public h() {
        super("idMapping", new a());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        a value = getValue();
        if (value == null) {
            value = new a();
        }
        String string = sharedPreferences.getString(getKey(), "");
        if (!TextUtils.isEmpty(string)) {
            try {
                value.parseJson(new JSONObject(b.getDecodeString(string)));
            } catch (JSONException e6) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
            }
        }
        setValue(value);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        if (getValue() != null && getValue().toJson() != null) {
            editor.putString(getKey(), b.dz(getValue().toJson().toString()));
        } else {
            editor.putString(getKey(), "");
        }
    }

    public final String getImei() {
        a value = getValue();
        if (value != null && !TextUtils.isEmpty(value.aCk)) {
            return value.aCk;
        }
        return "";
    }

    public final String getOaid() {
        a value = getValue();
        if (value != null && !TextUtils.isEmpty(value.aCl)) {
            return value.aCl;
        }
        return "";
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void k(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(getKey());
        if (optJSONObject == null) {
            return;
        }
        a aVar = new a();
        aVar.parseJson(optJSONObject);
        setValue(aVar);
    }
}
