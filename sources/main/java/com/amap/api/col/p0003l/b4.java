package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Handler;
import com.amap.api.maps.model.LatLng;
import com.amap.api.trace.TraceLocation;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class b4 extends z3<List<TraceLocation>, List<LatLng>> implements Runnable {
    private String A;

    /* renamed from: w, reason: collision with root package name */
    private List<TraceLocation> f5698w;

    /* renamed from: x, reason: collision with root package name */
    private Handler f5699x;

    /* renamed from: y, reason: collision with root package name */
    private int f5700y;

    /* renamed from: z, reason: collision with root package name */
    private int f5701z;

    @Override // com.amap.api.col.p0003l.Cif
    public final boolean isSupportIPV6() {
        return true;
    }

    private static List<LatLng> o(String str) throws fc {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("data") && (optJSONArray = jSONObject.optJSONObject("data").optJSONArray("points")) != null && optJSONArray.length() != 0) {
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                    arrayList.add(new LatLng(Double.parseDouble(optJSONObject.optString("y")), Double.parseDouble(optJSONObject.optString("x"))));
                }
            }
        } catch (JSONException e6) {
            e6.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return arrayList;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final String getURL() {
        String str = "key=" + f4.j(this.f7756t);
        String a6 = h4.a();
        return "http://restsdk.amap.com/v4/grasproad/driving?" + str + "&ts=".concat(String.valueOf(a6)) + "&scode=".concat(String.valueOf(h4.c(this.f7756t, a6, str)));
    }

    @Override // com.amap.api.col.p0003l.z3, com.amap.api.col.p0003l.y3
    protected final String l() {
        JSONArray jSONArray = new JSONArray();
        long j6 = 0;
        for (int i6 = 0; i6 < this.f5698w.size(); i6++) {
            TraceLocation traceLocation = this.f5698w.get(i6);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", traceLocation.getLongitude());
                jSONObject.put("y", traceLocation.getLatitude());
                jSONObject.put("ag", (int) traceLocation.getBearing());
                long time = traceLocation.getTime();
                if (i6 == 0) {
                    if (time == 0) {
                        time = (System.currentTimeMillis() - 10000) / 1000;
                    }
                    jSONObject.put("tm", time / 1000);
                } else {
                    if (time != 0) {
                        long j7 = time - j6;
                        if (j7 >= 1000) {
                            jSONObject.put("tm", j7 / 1000);
                        }
                    }
                    jSONObject.put("tm", 1);
                }
                j6 = time;
                jSONObject.put("sp", (int) traceLocation.getSpeed());
            } catch (JSONException e6) {
                e6.printStackTrace();
            }
            jSONArray.put(jSONObject);
        }
        this.f7757u = getURL() + ContainerUtils.FIELD_DELIMITER + jSONArray.toString();
        return jSONArray.toString();
    }

    @Override // java.lang.Runnable
    public final void run() {
        new ArrayList();
        try {
            try {
                d4.b().e(this.A, this.f5700y, m());
                d4.b().a(this.A).b(this.f5699x);
            } catch (fc e6) {
                d4.b();
                d4.c(this.f5699x, this.f5701z, e6.a());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public b4(Context context, Handler handler, List<TraceLocation> list, String str, int i6, int i7) {
        super(context, list);
        this.f5698w = list;
        this.f5699x = handler;
        this.f5701z = i6;
        this.f5700y = i7;
        this.A = str;
    }

    @Override // com.amap.api.col.p0003l.z3, com.amap.api.col.p0003l.y3
    protected final /* synthetic */ Object g(String str) throws fc {
        return o(str);
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final String getIPV6URL() {
        return b3.y(getURL());
    }
}
