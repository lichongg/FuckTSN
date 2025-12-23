package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class l<ValueType> extends b<JSONObject> {
    public l(String str) {
        super(str, new JSONObject());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void k(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(getKey())) == null) {
            setValue(Gu());
        } else {
            setValue(optJSONObject);
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        JSONObject jSONObject;
        JSONObject value = getValue();
        if (value == null) {
            value = new JSONObject();
        }
        try {
            jSONObject = new JSONObject(sharedPreferences.getString(getKey(), ""));
        } catch (Throwable unused) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            value = jSONObject;
        }
        setValue(value);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        if (getValue() != null) {
            editor.putString(getKey(), getValue().toString());
        } else {
            editor.putString(getKey(), "");
        }
    }

    public final ValueType getValue(String str) {
        try {
            if (getValue().has(str)) {
                return (ValueType) getValue().get(str);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
