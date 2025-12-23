package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.s.n;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.poisearch.PoiSearchV2;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class f extends d<String, PoiItemV2> {

    /* renamed from: t, reason: collision with root package name */
    private PoiSearchV2.Query f8070t;

    /* JADX WARN: Multi-variable type inference failed */
    private String Q() {
        StringBuilder sb = new StringBuilder();
        sb.append("id=");
        sb.append((String) this.f7863n);
        sb.append("&output=json");
        PoiSearchV2.Query query = this.f8070t;
        String U = (query == null || query.getShowFields() == null) ? null : d.U(this.f8070t.getShowFields());
        if (U != null) {
            sb.append("&show_fields=");
            sb.append(U);
        }
        sb.append("&key=" + x0.i(this.f7866q));
        String channel = this.f8070t.getChannel();
        if (!TextUtils.isEmpty(channel)) {
            sb.append("&channel=");
            sb.append(channel);
        }
        String premium = this.f8070t.getPremium();
        if (!TextUtils.isEmpty(premium)) {
            sb.append("&permium=");
            sb.append(premium);
        }
        return sb.toString();
    }

    private static PoiItemV2 W(JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject;
        JSONArray optJSONArray = jSONObject.optJSONArray("pois");
        if (optJSONArray == null || optJSONArray.length() <= 0 || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
            return null;
        }
        return r4.h0(optJSONObject);
    }

    private static PoiItemV2 X(String str) throws AMapException {
        try {
            return W(new JSONObject(str));
        } catch (JSONException e6) {
            j4.i(e6, "PoiSearchIdHandlerV2", "paseJSONJSONException");
            return null;
        } catch (Exception e7) {
            j4.i(e7, "PoiSearchIdHandlerV2", "paseJSONException");
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
        return i4.d() + "/place/detail?";
    }

    public f(Context context, String str, PoiSearchV2.Query query) {
        super(context, str);
        this.f8070t = query;
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
