package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.busline.BusLineQuery;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusStationQuery;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.SuggestionCity;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class e4<T> extends b4<T, Object> {

    /* renamed from: t, reason: collision with root package name */
    private int f8067t;

    /* renamed from: u, reason: collision with root package name */
    private List<String> f8068u;

    /* renamed from: v, reason: collision with root package name */
    private List<SuggestionCity> f8069v;

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final Object I(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("suggestion");
            if (optJSONObject != null) {
                this.f8069v = r4.w(optJSONObject);
                this.f8068u = r4.M(optJSONObject);
            }
            this.f8067t = jSONObject.optInt("count");
            if (this.f7863n instanceof BusLineQuery) {
                return BusLineResult.createPagedResult((BusLineQuery) this.f7863n, this.f8067t, this.f8069v, this.f8068u, r4.p0(jSONObject));
            }
            return BusStationResult.createPagedResult((BusStationQuery) this.f7863n, this.f8067t, this.f8069v, this.f8068u, r4.m0(jSONObject));
        } catch (Exception e6) {
            j4.i(e6, "BusSearchServerHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final String M() {
        StringBuilder sb = new StringBuilder();
        sb.append("output=json");
        T t5 = this.f7863n;
        if (t5 instanceof BusLineQuery) {
            BusLineQuery busLineQuery = (BusLineQuery) t5;
            if (TextUtils.isEmpty(busLineQuery.getExtensions())) {
                sb.append("&extensions=base");
            } else {
                sb.append("&extensions=");
                sb.append(busLineQuery.getExtensions());
            }
            if (busLineQuery.getCategory() == BusLineQuery.SearchType.BY_LINE_ID) {
                sb.append("&id=");
                sb.append(b4.i(((BusLineQuery) this.f7863n).getQueryString()));
            } else {
                String city = busLineQuery.getCity();
                if (!r4.s0(city)) {
                    String i6 = b4.i(city);
                    sb.append("&city=");
                    sb.append(i6);
                }
                sb.append("&keywords=" + b4.i(busLineQuery.getQueryString()));
                sb.append("&offset=" + busLineQuery.getPageSize());
                sb.append("&page=" + busLineQuery.getPageNumber());
            }
        } else {
            BusStationQuery busStationQuery = (BusStationQuery) t5;
            String city2 = busStationQuery.getCity();
            if (!r4.s0(city2)) {
                String i7 = b4.i(city2);
                sb.append("&city=");
                sb.append(i7);
            }
            sb.append("&keywords=" + b4.i(busStationQuery.getQueryString()));
            sb.append("&offset=" + busStationQuery.getPageSize());
            sb.append("&page=" + busStationQuery.getPageNumber());
        }
        sb.append("&key=" + x0.i(this.f7866q));
        return sb.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        T t5 = this.f7863n;
        return i4.b() + "/bus/" + (t5 instanceof BusLineQuery ? ((BusLineQuery) t5).getCategory() == BusLineQuery.SearchType.BY_LINE_ID ? "lineid" : ((BusLineQuery) this.f7863n).getCategory() == BusLineQuery.SearchType.BY_LINE_NAME ? "linename" : "" : "stopname") + "?";
    }

    public e4(Context context, T t5) {
        super(context, t5);
        this.f8067t = 0;
        this.f8068u = new ArrayList();
        this.f8069v = new ArrayList();
    }
}
