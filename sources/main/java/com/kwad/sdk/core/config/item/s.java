package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ap;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class s extends b<List<String>> {
    @Override // com.kwad.sdk.core.config.item.b
    public final void k(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray(getKey())) != null && optJSONArray.length() > 0) {
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                String optString = optJSONArray.optString(i6);
                if (optString != null && !optString.isEmpty()) {
                    copyOnWriteArrayList.add(optString);
                }
            }
            if (copyOnWriteArrayList.size() > 0) {
                setValue(copyOnWriteArrayList);
                return;
            }
        }
        setValue(Gu());
    }

    public s(String str, List<String> list) {
        super(str, list);
    }

    @Override // com.kwad.sdk.core.config.item.b
    @NonNull
    /* renamed from: GC, reason: merged with bridge method [inline-methods] */
    public final List<String> getValue() {
        List<String> list = (List) super.getValue();
        if (list == null) {
            return new ArrayList();
        }
        return list;
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        List gV = aa.gV(b.getDecodeString(sharedPreferences.getString(getKey(), "")));
        if (ap.T(gV)) {
            setValue(gV);
        } else {
            setValue(Gu());
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(@NonNull SharedPreferences.Editor editor) {
        if (ap.T(getValue())) {
            editor.putString(getKey(), b.dz(aa.toJsonArray(getValue()).toString()));
        }
    }
}
