package com.kwad.sdk.i;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class e implements com.kwad.sdk.i.b {
    public int aSC;
    public b aSD;
    public a aSE;
    public double avY;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a implements com.kwad.sdk.i.b {
        public List<String> aSF;
        public List<String> aSG;
        public List<String> aSH;

        @Override // com.kwad.sdk.i.b
        public final JSONObject toJson() {
            return null;
        }

        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.aSF = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("levelList");
            if (optJSONArray != null) {
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    this.aSF.add(optJSONArray.optString(i6));
                }
            }
            this.aSG = new ArrayList();
            JSONArray optJSONArray2 = jSONObject.optJSONArray("tagList");
            if (optJSONArray2 != null) {
                for (int i7 = 0; i7 < optJSONArray2.length(); i7++) {
                    this.aSG.add(optJSONArray2.optString(i7));
                }
            }
            this.aSH = new ArrayList();
            JSONArray optJSONArray3 = jSONObject.optJSONArray("keywordList");
            if (optJSONArray3 != null) {
                for (int i8 = 0; i8 < optJSONArray3.length(); i8++) {
                    this.aSH.add(optJSONArray3.optString(i8));
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b implements com.kwad.sdk.i.b {
        public static int OK = 1;
        public static int aSI = -1;
        public static int aSJ;
        public List<String> aOb;
        public List<String> aOc;
        public List<String> aSK;
        public int aSL = aSI;

        @Override // com.kwad.sdk.i.b
        public final JSONObject toJson() {
            return null;
        }

        public final boolean MX() {
            return this.aSL == OK;
        }

        public final void bK(boolean z5) {
            this.aSL = z5 ? OK : aSJ;
        }

        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.aOb = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("appIdList");
            if (optJSONArray != null) {
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    this.aOb.add(optJSONArray.optString(i6));
                }
            }
            this.aOc = new ArrayList();
            JSONArray optJSONArray2 = jSONObject.optJSONArray("sdkVersionList");
            if (optJSONArray2 != null) {
                for (int i7 = 0; i7 < optJSONArray2.length(); i7++) {
                    this.aOc.add(optJSONArray2.optString(i7));
                }
            }
            this.aSK = new ArrayList();
            JSONArray optJSONArray3 = jSONObject.optJSONArray("deviceIdList");
            if (optJSONArray3 != null) {
                for (int i8 = 0; i8 < optJSONArray3.length(); i8++) {
                    this.aSK.add(optJSONArray3.optString(i8));
                }
            }
        }
    }

    @Override // com.kwad.sdk.i.b
    public final JSONObject toJson() {
        return null;
    }

    public final void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.avY = jSONObject.optDouble("ratio");
        this.aSC = jSONObject.optInt("kcType", 1);
        b bVar = new b();
        this.aSD = bVar;
        bVar.parseJson(jSONObject.optJSONObject("scopeConfig"));
        a aVar = new a();
        this.aSE = aVar;
        aVar.parseJson(jSONObject.optJSONObject("logConfig"));
    }

    e() {
    }
}
