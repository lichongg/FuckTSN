package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d extends a<Boolean> {
    public d(String str) {
        this(str, false);
    }

    public d(String str, boolean z5) {
        super(str, Boolean.valueOf(z5));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void k(JSONObject jSONObject) {
        if (jSONObject != null) {
            setValue(Boolean.valueOf(jSONObject.optBoolean(getKey(), Gu().booleanValue())));
        } else {
            setValue(Gu());
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    @NonNull
    /* renamed from: Gv, reason: merged with bridge method [inline-methods] */
    public final Boolean getValue() {
        return (Boolean) super.getValue();
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        setValue(Boolean.valueOf(sharedPreferences.getBoolean(getKey(), Gu().booleanValue())));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(@NonNull SharedPreferences.Editor editor) {
        editor.putBoolean(getKey(), getValue().booleanValue());
    }
}
