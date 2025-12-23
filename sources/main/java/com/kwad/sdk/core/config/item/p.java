package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class p extends b<String> {
    private static volatile String[] aCq;

    public static boolean ah(long j6) {
        if (aCq == null) {
            return false;
        }
        for (String str : aCq) {
            if (str != null && String.valueOf(j6).equals(str.trim())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void k(JSONObject jSONObject) {
        if (jSONObject == null) {
            setValue(Gu());
            return;
        }
        String optString = jSONObject.optString(getKey(), Gu());
        setValue(optString);
        dB(optString);
    }

    public p(String str, String str2) {
        super(str, str2);
        aCq = null;
    }

    private static void dB(String str) {
        if (!TextUtils.isEmpty(str)) {
            aCq = str.split(",");
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString(getKey(), Gu());
        setValue(string);
        dB(string);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(@NonNull SharedPreferences.Editor editor) {
        editor.putString(getKey(), getValue());
    }
}
