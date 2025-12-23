package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class k extends a<Integer> {
    @Override // com.kwad.sdk.core.config.item.b
    public final void k(JSONObject jSONObject) {
        if (jSONObject != null) {
            setValue(Integer.valueOf(jSONObject.optInt(getKey(), Gu().intValue())));
        } else {
            setValue(Gu());
        }
    }

    public k(String str, Integer num) {
        super(str, num);
    }

    @Override // com.kwad.sdk.core.config.item.b
    @NonNull
    /* renamed from: GA, reason: merged with bridge method [inline-methods] */
    public final Integer getValue() {
        return (Integer) super.getValue();
    }

    public final boolean Gz() {
        if (getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        setValue(Integer.valueOf(sharedPreferences.getInt(getKey(), Gu().intValue())));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(@NonNull SharedPreferences.Editor editor) {
        editor.putInt(getKey(), getValue().intValue());
    }
}
