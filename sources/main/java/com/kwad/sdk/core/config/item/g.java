package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class g extends a<Float> {
    @Override // com.kwad.sdk.core.config.item.b
    public final void k(JSONObject jSONObject) {
        if (jSONObject != null) {
            setValue(Float.valueOf((float) jSONObject.optDouble(getKey(), Gu().floatValue())));
        } else {
            setValue(Gu());
        }
    }

    public g(String str, float f6) {
        super(str, Float.valueOf(f6));
    }

    @Override // com.kwad.sdk.core.config.item.b
    @NonNull
    /* renamed from: Gy, reason: merged with bridge method [inline-methods] */
    public final Float getValue() {
        return (Float) super.getValue();
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        setValue(Float.valueOf(sharedPreferences.getFloat(getKey(), Gu().floatValue())));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(@NonNull SharedPreferences.Editor editor) {
        editor.putFloat(getKey(), getValue().floatValue());
    }
}
