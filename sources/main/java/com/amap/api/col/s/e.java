package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.col.s.n;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.poisearch.PoiSearch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class e extends d<String, PoiItem> {

    /* renamed from: t, reason: collision with root package name */
    private PoiSearch.Query f8041t;

    /* JADX WARN: Multi-variable type inference failed */
    private String Q() {
        StringBuilder sb = new StringBuilder();
        sb.append("id=");
        sb.append((String) this.f7863n);
        sb.append("&output=json");
        PoiSearch.Query query = this.f8041t;
        if (query == null || d.V(query.getExtensions())) {
            sb.append("&extensions=base");
        } else {
            sb.append("&extensions=");
            sb.append(this.f8041t.getExtensions());
        }
        sb.append("&children=1");
        sb.append("&key=" + x0.i(this.f7866q));
        return sb.toString();
    }

    private static PoiItem W(JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject;
        JSONArray optJSONArray = jSONObject.optJSONArray("pois");
        if (optJSONArray == null || optJSONArray.length() <= 0 || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
            return null;
        }
        return r4.d0(optJSONObject);
    }

    private static PoiItem X(String str) throws AMapException {
        try {
            return W(new JSONObject(str));
        } catch (JSONException e6) {
            j4.i(e6, "PoiSearchIdHandler", "paseJSONJSONException");
            return null;
        } catch (Exception e7) {
            j4.i(e7, "PoiSearchIdHandler", "paseJSONException");
            return null;
        }
    }

    @Override // com.amap.api.col.s.a3
    protected final n.b P() {
        n.b bVar = new n.b();
        bVar.f8260a = h() + M() + "language=" + ServiceSettings.getInstance().getLanguage();
        return bVar;
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.b() + "/place/detail?";
    }

    public e(Context context, String str, PoiSearch.Query query) {
        super(context, str);
        this.f8041t = query;
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    public final /* synthetic */ Object I(String str) throws AMapException {
        return X(str);
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final String M() {
        return Q();
    }
}
