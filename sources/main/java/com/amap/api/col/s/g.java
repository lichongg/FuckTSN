package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.col.s.n;
import com.amap.api.col.s.p;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.poisearch.PoiResult;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class g extends d<k, PoiResult> {

    /* renamed from: t, reason: collision with root package name */
    private int f8082t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f8083u;

    /* renamed from: v, reason: collision with root package name */
    private List<String> f8084v;

    /* renamed from: w, reason: collision with root package name */
    private List<SuggestionCity> f8085w;

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final String M() {
        return W(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String W(boolean z5) {
        List<LatLonPoint> polyGonList;
        StringBuilder sb = new StringBuilder();
        sb.append("output=json");
        T t5 = this.f7863n;
        if (((k) t5).f8187b != null) {
            if (((k) t5).f8187b.getShape().equals("Bound")) {
                if (z5) {
                    double a6 = j4.a(((k) this.f7863n).f8187b.getCenter().getLongitude());
                    double a7 = j4.a(((k) this.f7863n).f8187b.getCenter().getLatitude());
                    sb.append("&location=");
                    sb.append(a6 + "," + a7);
                }
                sb.append("&radius=");
                sb.append(((k) this.f7863n).f8187b.getRange());
                sb.append("&sortrule=");
                sb.append(X(((k) this.f7863n).f8187b.isDistanceSort()));
            } else if (((k) this.f7863n).f8187b.getShape().equals("Rectangle")) {
                LatLonPoint lowerLeft = ((k) this.f7863n).f8187b.getLowerLeft();
                LatLonPoint upperRight = ((k) this.f7863n).f8187b.getUpperRight();
                double a8 = j4.a(lowerLeft.getLatitude());
                double a9 = j4.a(lowerLeft.getLongitude());
                double a10 = j4.a(upperRight.getLatitude());
                sb.append("&polygon=" + a9 + "," + a8 + ";" + j4.a(upperRight.getLongitude()) + "," + a10);
            } else if (((k) this.f7863n).f8187b.getShape().equals("Polygon") && (polyGonList = ((k) this.f7863n).f8187b.getPolyGonList()) != null && polyGonList.size() > 0) {
                sb.append("&polygon=" + j4.f(polyGonList));
            }
        }
        String city = ((k) this.f7863n).f8186a.getCity();
        if (!d.V(city)) {
            String i6 = b4.i(city);
            sb.append("&city=");
            sb.append(i6);
        }
        String i7 = b4.i(((k) this.f7863n).f8186a.getQueryString());
        if (!d.V(i7)) {
            sb.append("&keywords=");
            sb.append(i7);
        }
        sb.append("&offset=");
        sb.append(((k) this.f7863n).f8186a.getPageSize());
        sb.append("&page=");
        sb.append(((k) this.f7863n).f8186a.getPageNum());
        String building = ((k) this.f7863n).f8186a.getBuilding();
        if (building != null && building.trim().length() > 0) {
            sb.append("&building=");
            sb.append(((k) this.f7863n).f8186a.getBuilding());
        }
        String i8 = b4.i(((k) this.f7863n).f8186a.getCategory());
        if (!d.V(i8)) {
            sb.append("&types=");
            sb.append(i8);
        }
        if (d.V(((k) this.f7863n).f8186a.getExtensions())) {
            sb.append("&extensions=base");
        } else {
            sb.append("&extensions=");
            sb.append(((k) this.f7863n).f8186a.getExtensions());
        }
        sb.append("&key=");
        sb.append(x0.i(this.f7866q));
        if (((k) this.f7863n).f8186a.getCityLimit()) {
            sb.append("&citylimit=true");
        } else {
            sb.append("&citylimit=false");
        }
        if (((k) this.f7863n).f8186a.isRequireSubPois()) {
            sb.append("&children=1");
        } else {
            sb.append("&children=0");
        }
        if (this.f8083u) {
            if (((k) this.f7863n).f8186a.isSpecial()) {
                sb.append("&special=1");
            } else {
                sb.append("&special=0");
            }
        }
        T t6 = this.f7863n;
        if (((k) t6).f8187b == null && ((k) t6).f8186a.getLocation() != null) {
            sb.append("&sortrule=");
            sb.append(X(((k) this.f7863n).f8186a.isDistanceSort()));
            double a11 = j4.a(((k) this.f7863n).f8186a.getLocation().getLongitude());
            double a12 = j4.a(((k) this.f7863n).f8186a.getLocation().getLatitude());
            sb.append("&location=");
            sb.append(a11 + "," + a12);
        }
        return sb.toString();
    }

    private static String X(boolean z5) {
        return z5 ? "distance" : "weight";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public PoiResult I(String str) throws AMapException {
        ArrayList<PoiItem> arrayList;
        JSONObject jSONObject;
        ArrayList<PoiItem> arrayList2 = new ArrayList<>();
        if (str == null) {
            T t5 = this.f7863n;
            return PoiResult.createPagedResult(((k) t5).f8186a, ((k) t5).f8187b, this.f8084v, this.f8085w, ((k) t5).f8186a.getPageSize(), this.f8082t, arrayList2);
        }
        try {
            jSONObject = new JSONObject(str);
            this.f8082t = jSONObject.optInt("count");
            arrayList = r4.U(jSONObject);
            try {
            } catch (JSONException e6) {
                e = e6;
                arrayList2 = arrayList;
                j4.i(e, "PoiSearchKeywordHandler", "paseJSONJSONException");
                arrayList = arrayList2;
                T t6 = this.f7863n;
                return PoiResult.createPagedResult(((k) t6).f8186a, ((k) t6).f8187b, this.f8084v, this.f8085w, ((k) t6).f8186a.getPageSize(), this.f8082t, arrayList);
            } catch (Exception e7) {
                e = e7;
                arrayList2 = arrayList;
                j4.i(e, "PoiSearchKeywordHandler", "paseJSONException");
                arrayList = arrayList2;
                T t62 = this.f7863n;
                return PoiResult.createPagedResult(((k) t62).f8186a, ((k) t62).f8187b, this.f8084v, this.f8085w, ((k) t62).f8186a.getPageSize(), this.f8082t, arrayList);
            }
        } catch (JSONException e8) {
            e = e8;
        } catch (Exception e9) {
            e = e9;
        }
        if (!jSONObject.has("suggestion")) {
            T t7 = this.f7863n;
            return PoiResult.createPagedResult(((k) t7).f8186a, ((k) t7).f8187b, this.f8084v, this.f8085w, ((k) t7).f8186a.getPageSize(), this.f8082t, arrayList);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("suggestion");
        if (optJSONObject == null) {
            T t8 = this.f7863n;
            return PoiResult.createPagedResult(((k) t8).f8186a, ((k) t8).f8187b, this.f8084v, this.f8085w, ((k) t8).f8186a.getPageSize(), this.f8082t, arrayList);
        }
        this.f8085w = r4.w(optJSONObject);
        this.f8084v = r4.M(optJSONObject);
        T t622 = this.f7863n;
        return PoiResult.createPagedResult(((k) t622).f8186a, ((k) t622).f8187b, this.f8084v, this.f8085w, ((k) t622).f8186a.getPageSize(), this.f8082t, arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.a3
    protected final n.b P() {
        n.b bVar = new n.b();
        if (!this.f8083u) {
            bVar.f8260a = h() + M() + "language=" + ServiceSettings.getInstance().getLanguage();
            return bVar;
        }
        p Z = Z();
        double l6 = Z != null ? Z.l() : 0.0d;
        bVar.f8260a = h() + W(false) + "language=" + ServiceSettings.getInstance().getLanguage();
        if (((k) this.f7863n).f8187b.getShape().equals("Bound")) {
            bVar.f8261b = new p.a(j4.a(((k) this.f7863n).f8187b.getCenter().getLatitude()), j4.a(((k) this.f7863n).f8187b.getCenter().getLongitude()), l6);
        }
        return bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.dz
    public final String h() {
        String str = i4.b() + "/place";
        T t5 = this.f7863n;
        if (((k) t5).f8187b == null) {
            return str + "/text?";
        }
        if (((k) t5).f8187b.getShape().equals("Bound")) {
            String str2 = str + "/around?";
            this.f8083u = true;
            return str2;
        }
        if (!((k) this.f7863n).f8187b.getShape().equals("Rectangle") && !((k) this.f7863n).f8187b.getShape().equals("Polygon")) {
            return str;
        }
        return str + "/polygon?";
    }

    public g(Context context, k kVar) {
        super(context, kVar);
        this.f8082t = 0;
        this.f8083u = false;
        this.f8084v = new ArrayList();
        this.f8085w = new ArrayList();
    }

    private static p Z() {
        o c6 = n.b().c("regeo");
        if (c6 == null) {
            return null;
        }
        return (p) c6;
    }
}
