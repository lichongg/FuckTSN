package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.s.n;
import com.amap.api.col.s.p;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.poisearch.PoiResultV2;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class h extends d<l, PoiResultV2> {

    /* renamed from: t, reason: collision with root package name */
    private int f8101t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f8102u;

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
        if (((l) t5).f8218b != null) {
            if (((l) t5).f8218b.getShape().equals("Bound")) {
                if (z5) {
                    double a6 = j4.a(((l) this.f7863n).f8218b.getCenter().getLongitude());
                    double a7 = j4.a(((l) this.f7863n).f8218b.getCenter().getLatitude());
                    sb.append("&location=");
                    sb.append(a6 + "," + a7);
                }
                sb.append("&radius=");
                sb.append(((l) this.f7863n).f8218b.getRange());
                sb.append("&sortrule=");
                sb.append(X(((l) this.f7863n).f8218b.isDistanceSort()));
            } else if (((l) this.f7863n).f8218b.getShape().equals("Rectangle")) {
                LatLonPoint lowerLeft = ((l) this.f7863n).f8218b.getLowerLeft();
                LatLonPoint upperRight = ((l) this.f7863n).f8218b.getUpperRight();
                double a8 = j4.a(lowerLeft.getLatitude());
                double a9 = j4.a(lowerLeft.getLongitude());
                double a10 = j4.a(upperRight.getLatitude());
                sb.append("&polygon=" + a9 + "," + a8 + ";" + j4.a(upperRight.getLongitude()) + "," + a10);
            } else if (((l) this.f7863n).f8218b.getShape().equals("Polygon") && (polyGonList = ((l) this.f7863n).f8218b.getPolyGonList()) != null && polyGonList.size() > 0) {
                sb.append("&polygon=" + j4.f(polyGonList));
            }
        }
        String city = ((l) this.f7863n).f8217a.getCity();
        if (!d.V(city)) {
            String i6 = b4.i(city);
            sb.append("&region=");
            sb.append(i6);
        }
        String i7 = b4.i(((l) this.f7863n).f8217a.getQueryString());
        if (!d.V(i7)) {
            sb.append("&keywords=");
            sb.append(i7);
        }
        sb.append("&page_size=");
        sb.append(((l) this.f7863n).f8217a.getPageSize());
        sb.append("&page_num=");
        sb.append(((l) this.f7863n).f8217a.getPageNum());
        String building = ((l) this.f7863n).f8217a.getBuilding();
        if (building != null && building.trim().length() > 0) {
            sb.append("&building=");
            sb.append(((l) this.f7863n).f8217a.getBuilding());
        }
        String i8 = b4.i(((l) this.f7863n).f8217a.getCategory());
        if (!d.V(i8)) {
            sb.append("&types=");
            sb.append(i8);
        }
        String U = d.U(((l) this.f7863n).f8217a.getShowFields());
        if (U != null) {
            sb.append("&show_fields=");
            sb.append(U);
        }
        sb.append("&key=");
        sb.append(x0.i(this.f7866q));
        if (((l) this.f7863n).f8217a.getCityLimit()) {
            sb.append("&citylimit=true");
        } else {
            sb.append("&citylimit=false");
        }
        if (this.f8102u) {
            if (((l) this.f7863n).f8217a.isSpecial()) {
                sb.append("&special=1");
            } else {
                sb.append("&special=0");
            }
        }
        String channel = ((l) this.f7863n).f8217a.getChannel();
        if (!TextUtils.isEmpty(channel)) {
            sb.append("&channel=");
            sb.append(channel);
        }
        String premium = ((l) this.f7863n).f8217a.getPremium();
        if (!TextUtils.isEmpty(premium)) {
            sb.append("&permium=");
            sb.append(premium);
        }
        T t6 = this.f7863n;
        if (((l) t6).f8218b == null && ((l) t6).f8217a.getLocation() != null) {
            sb.append("&sortrule=");
            sb.append(X(((l) this.f7863n).f8217a.isDistanceSort()));
            double a11 = j4.a(((l) this.f7863n).f8217a.getLocation().getLongitude());
            double a12 = j4.a(((l) this.f7863n).f8217a.getLocation().getLatitude());
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
    public PoiResultV2 I(String str) throws AMapException {
        ArrayList<PoiItemV2> arrayList = new ArrayList<>();
        if (str == null) {
            T t5 = this.f7863n;
            return PoiResultV2.createPagedResult(((l) t5).f8217a, ((l) t5).f8218b, this.f8101t, arrayList);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f8101t = jSONObject.optInt("count");
            arrayList = r4.Z(jSONObject);
        } catch (JSONException e6) {
            j4.i(e6, "PoiSearchKeywordHandler", "paseJSONJSONException");
        } catch (Exception e7) {
            j4.i(e7, "PoiSearchKeywordHandler", "paseJSONException");
        }
        T t6 = this.f7863n;
        return PoiResultV2.createPagedResult(((l) t6).f8217a, ((l) t6).f8218b, this.f8101t, arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.a3
    protected final n.b P() {
        n.b bVar = new n.b();
        if (!this.f8102u) {
            bVar.f8260a = h() + M() + "language=" + ServiceSettings.getInstance().getLanguage();
            return bVar;
        }
        p Z = Z();
        double l6 = Z != null ? Z.l() : 0.0d;
        bVar.f8260a = h() + W(false) + "language=" + ServiceSettings.getInstance().getLanguage();
        if (((l) this.f7863n).f8218b.getShape().equals("Bound")) {
            bVar.f8261b = new p.a(j4.a(((l) this.f7863n).f8218b.getCenter().getLatitude()), j4.a(((l) this.f7863n).f8218b.getCenter().getLongitude()), l6);
        }
        return bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.dz
    public final String h() {
        String str = i4.d() + "/place";
        T t5 = this.f7863n;
        if (((l) t5).f8218b == null) {
            return str + "/text?";
        }
        if (((l) t5).f8218b.getShape().equals("Bound")) {
            String str2 = str + "/around?";
            this.f8102u = true;
            return str2;
        }
        if (!((l) this.f7863n).f8218b.getShape().equals("Rectangle") && !((l) this.f7863n).f8218b.getShape().equals("Polygon")) {
            return str;
        }
        return str + "/polygon?";
    }

    public h(Context context, l lVar) {
        super(context, lVar);
        this.f8101t = 0;
        this.f8102u = false;
    }

    private static p Z() {
        o c6 = n.b().c("regeo");
        if (c6 == null) {
            return null;
        }
        return (p) c6;
    }
}
