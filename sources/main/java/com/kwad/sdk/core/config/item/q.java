package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class q extends b<a> {
    private String aCr;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements com.kwad.sdk.core.b {

        @NonNull
        public Map<Integer, String> aCs = new HashMap();

        @NonNull
        public List<String> aCt = new ArrayList();

        @NonNull
        public List<String> aCu = new ArrayList();
        public List<String> aCv = new ArrayList();
        public int aCw;
        private JSONObject aCx;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.aCx = jSONObject;
            JSONObject optJSONObject = jSONObject.optJSONObject("platformInfo");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.aCs.put(Integer.valueOf(next), optJSONObject.optString(next));
                }
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("keyStacks");
            if (optJSONArray != null) {
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    this.aCt.add(optJSONArray.optString(i6));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("extendClassNames");
            if (optJSONArray2 != null) {
                for (int i7 = 0; i7 < optJSONArray2.length(); i7++) {
                    this.aCu.add(optJSONArray2.optString(i7));
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("keyNames");
            if (optJSONArray3 != null) {
                for (int i8 = 0; i8 < optJSONArray3.length(); i8++) {
                    this.aCv.add(optJSONArray3.optString(i8));
                }
            }
            this.aCw = jSONObject.optInt("handleType");
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            return this.aCx;
        }
    }

    public q() {
        super("sdkPackInfo", null);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        String decodeString = b.getDecodeString(sharedPreferences.getString("sdkPackInfo", null));
        this.aCr = decodeString;
        try {
            if (TextUtils.isEmpty(decodeString)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(this.aCr);
            a aVar = new a();
            aVar.parseJson(jSONObject);
            setValue(aVar);
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        editor.putString("sdkPackInfo", b.dz(this.aCr));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void k(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("sdkPackInfo");
        if (optJSONObject == null) {
            return;
        }
        this.aCr = optJSONObject.toString();
        a aVar = new a();
        aVar.parseJson(optJSONObject);
        setValue(aVar);
    }
}
