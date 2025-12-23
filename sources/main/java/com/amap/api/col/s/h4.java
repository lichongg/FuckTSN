package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.acse.ottn.adapter.AutoScrollViewPager;
import com.amap.api.services.cloud.CloudItem;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.district.DistrictSearchQuery;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class h4 extends f4<CloudSearch.Query, CloudResult> {

    /* renamed from: t, reason: collision with root package name */
    private int f8135t;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public CloudResult I(String str) throws AMapException {
        ArrayList<CloudItem> arrayList = null;
        if (str == null || str.equals("")) {
            T t5 = this.f7863n;
            return CloudResult.createPagedResult((CloudSearch.Query) t5, this.f8135t, ((CloudSearch.Query) t5).getBound(), ((CloudSearch.Query) this.f7863n).getPageSize(), null);
        }
        try {
            arrayList = b0(new JSONObject(str));
        } catch (JSONException e6) {
            e6.printStackTrace();
        } catch (Exception e7) {
            e7.printStackTrace();
        }
        T t6 = this.f7863n;
        return CloudResult.createPagedResult((CloudSearch.Query) t6, this.f8135t, ((CloudSearch.Query) t6).getBound(), ((CloudSearch.Query) this.f7863n).getPageSize(), arrayList);
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final String M() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String Q() {
        return ((CloudSearch.Query) this.f7863n).getSortingrules() != null ? ((CloudSearch.Query) this.f7863n).getSortingrules().toString() : "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String R() {
        StringBuffer stringBuffer = new StringBuffer();
        String filterString = ((CloudSearch.Query) this.f7863n).getFilterString();
        String filterNumString = ((CloudSearch.Query) this.f7863n).getFilterNumString();
        stringBuffer.append(filterString);
        if (!j4.j(filterString) && !j4.j(filterNumString)) {
            stringBuffer.append("&&");
        }
        stringBuffer.append(filterNumString);
        return stringBuffer.toString();
    }

    private static String T(String str) {
        return str != null ? str.replace("&&", "%26%26") : str;
    }

    private static String Z(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb.append(entry.getKey());
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    private ArrayList<CloudItem> b0(JSONObject jSONObject) throws JSONException {
        ArrayList<CloudItem> arrayList = new ArrayList<>();
        JSONArray U = f4.U(jSONObject);
        if (U != null) {
            this.f8135t = f4.W(jSONObject);
            for (int i6 = 0; i6 < U.length(); i6++) {
                JSONObject optJSONObject = U.optJSONObject(i6);
                CloudItemDetail X = f4.X(optJSONObject);
                f4.V(X, optJSONObject);
                arrayList.add(X);
            }
        }
        return arrayList;
    }

    private static String c0(String str) {
        return str != null ? str.replace("%26%26", "&&") : str;
    }

    private static String d0(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            str = T(str);
            String[] split = str.split(ContainerUtils.FIELD_DELIMITER);
            Arrays.sort(split);
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
                stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            }
            String c02 = c0(stringBuffer.toString());
            return c02.length() > 1 ? (String) c02.subSequence(0, c02.length() - 1) : str;
        } catch (Throwable th) {
            d2.e(th, "ut", "sPa");
            return str;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.dz
    public final String h() {
        String str = i4.f() + "/datasearch";
        String shape = ((CloudSearch.Query) this.f7863n).getBound().getShape();
        if (shape.equals("Bound")) {
            return str + "/around";
        }
        if (shape.equals("Polygon") || shape.equals("Rectangle")) {
            return str + "/polygon";
        }
        if (!shape.equals(CloudSearch.SearchBound.LOCAL_SHAPE)) {
            return str;
        }
        return str + "/local";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3, com.amap.api.col.s.dz
    public final Map<String, String> o() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("key", x0.i(this.f7866q));
        hashtable.put("output", "json");
        if (((CloudSearch.Query) this.f7863n).getBound() != null) {
            if (((CloudSearch.Query) this.f7863n).getBound().getShape().equals("Bound")) {
                hashtable.put(AutoScrollViewPager.f4187g, j4.a(((CloudSearch.Query) this.f7863n).getBound().getCenter().getLongitude()) + "," + j4.a(((CloudSearch.Query) this.f7863n).getBound().getCenter().getLatitude()));
                StringBuilder sb = new StringBuilder();
                sb.append(((CloudSearch.Query) this.f7863n).getBound().getRange());
                hashtable.put("radius", sb.toString());
            } else if (((CloudSearch.Query) this.f7863n).getBound().getShape().equals("Rectangle")) {
                LatLonPoint lowerLeft = ((CloudSearch.Query) this.f7863n).getBound().getLowerLeft();
                LatLonPoint upperRight = ((CloudSearch.Query) this.f7863n).getBound().getUpperRight();
                double a6 = j4.a(lowerLeft.getLatitude());
                double a7 = j4.a(lowerLeft.getLongitude());
                double a8 = j4.a(upperRight.getLatitude());
                hashtable.put("polygon", a7 + "," + a6 + ";" + j4.a(upperRight.getLongitude()) + "," + a8);
            } else if (((CloudSearch.Query) this.f7863n).getBound().getShape().equals("Polygon")) {
                List<LatLonPoint> polyGonList = ((CloudSearch.Query) this.f7863n).getBound().getPolyGonList();
                if (polyGonList != null && polyGonList.size() > 0) {
                    hashtable.put("polygon", j4.g(polyGonList, ";"));
                }
            } else if (((CloudSearch.Query) this.f7863n).getBound().getShape().equals(CloudSearch.SearchBound.LOCAL_SHAPE)) {
                hashtable.put(DistrictSearchQuery.KEYWORDS_CITY, ((CloudSearch.Query) this.f7863n).getBound().getCity());
            }
        }
        hashtable.put("layerId", ((CloudSearch.Query) this.f7863n).getTableID());
        if (!j4.j(Q())) {
            hashtable.put("sortrule", Q());
        }
        String R = R();
        if (!j4.j(R)) {
            hashtable.put("filter", R);
        }
        String queryString = ((CloudSearch.Query) this.f7863n).getQueryString();
        if (queryString == null || "".equals(queryString)) {
            hashtable.put("keywords", "");
        } else {
            hashtable.put("keywords", queryString);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((CloudSearch.Query) this.f7863n).getPageSize());
        hashtable.put("pageSize", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(((CloudSearch.Query) this.f7863n).getPageNum());
        hashtable.put("pageNum", sb3.toString());
        String a9 = a1.a();
        String c6 = a1.c(this.f7866q, a9, c(hashtable));
        hashtable.put("ts", a9);
        hashtable.put("scode", c6);
        return hashtable;
    }

    public h4(Context context, CloudSearch.Query query) {
        super(context, query);
        this.f8135t = 0;
    }

    private static String c(Map<String, String> map) {
        return d0(Z(map));
    }
}
