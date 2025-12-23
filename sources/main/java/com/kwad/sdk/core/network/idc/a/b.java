package com.kwad.sdk.core.network.idc.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.aa;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b implements com.kwad.sdk.core.b {
    private final Map<String, List<String>> aFF = new ConcurrentHashMap();

    @NonNull
    private Map<String, List<String>> HL() {
        return this.aFF;
    }

    public static b eh(String str) {
        b bVar = new b();
        if (str != null && !str.isEmpty()) {
            try {
                bVar.parseJson(new JSONObject(str));
                return bVar;
            } catch (JSONException e6) {
                c.printStackTraceOnly(e6);
            }
        }
        return bVar;
    }

    @NonNull
    public final Set<String> HM() {
        return this.aFF.keySet();
    }

    public final void a(b bVar) {
        this.aFF.clear();
        if (bVar != null) {
            this.aFF.putAll(bVar.HL());
        }
    }

    @NonNull
    public final List<String> eg(String str) {
        Map<String, List<String>> map = this.aFF;
        if (map == null) {
            return Collections.EMPTY_LIST;
        }
        List<String> list = map.get(str);
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public final boolean isEmpty() {
        return this.aFF.isEmpty();
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                hashMap.put(next, aa.h(jSONObject.optJSONArray(next)));
            }
        }
        this.aFF.clear();
        this.aFF.putAll(hashMap);
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        Map<String, List<String>> map = this.aFF;
        JSONObject jSONObject = new JSONObject();
        for (String str : map.keySet()) {
            aa.putValue(jSONObject, str, aa.S(map.get(str)));
        }
        return jSONObject;
    }
}
