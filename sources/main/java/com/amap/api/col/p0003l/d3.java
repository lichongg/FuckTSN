package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import com.huawei.hms.framework.common.ContainerUtils;
import com.stub.StubApp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class d3 {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, f3> f5897a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private static String f5898b = "";

    public static void a() {
        try {
            if (c3.f5801a) {
                Iterator<Map.Entry<String, f3>> it = f5897a.entrySet().iterator();
                while (it.hasNext()) {
                    it.next().getValue().a();
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void c(int i6, String str, String str2, String str3, String str4) {
        Map<String, f3> map;
        f3 f3Var;
        try {
            String str5 = str3 + str4;
            if (c3.f5802b) {
                b(i6, str2, str5);
            }
            if (!c3.f5801a || (map = f5897a) == null || (f3Var = map.get(str)) == null) {
                return;
            }
            f3Var.a(i6, str2, str5);
        } catch (Throwable unused) {
        }
    }

    public static void d(Context context) {
        if (context == null) {
            return;
        }
        try {
            k();
            b5.c(b3.s()).g(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        } catch (Throwable unused) {
        }
    }

    public static void e(String str, String str2) {
        c(0, PrerollVideoResponse.NORMAL, f5898b, str, str2);
    }

    public static void f(String str, String str2, MarkerOptions markerOptions) {
        if (markerOptions == null) {
            n(str, str2);
            return;
        }
        n(str, str2 + " " + markerOptions.getPosition() + " " + markerOptions.getIcons());
    }

    public static void g(String str, String str2, PolygonOptions polygonOptions) {
        if (polygonOptions == null) {
            n(str, str2);
            return;
        }
        StringBuilder sb = new StringBuilder();
        List<LatLng> points = polygonOptions.getPoints();
        if (points != null) {
            sb.append("points size =");
            sb.append(points.size());
        }
        sb.append(";width=");
        sb.append(polygonOptions.getStrokeWidth());
        sb.append(";fillColor=");
        sb.append(polygonOptions.getFillColor());
        sb.append(";strokeColor=");
        sb.append(polygonOptions.getStrokeColor());
        sb.append(";visible=");
        sb.append(polygonOptions.isVisible());
        n(str, str2 + " " + sb.toString());
    }

    public static void h(String str, String str2, PolylineOptions polylineOptions) {
        if (polylineOptions == null) {
            n(str, str2);
            return;
        }
        StringBuilder sb = new StringBuilder();
        List<LatLng> points = polylineOptions.getPoints();
        if (points != null) {
            sb.append("points size =");
            sb.append(points.size());
        }
        sb.append(";width=");
        sb.append(polylineOptions.getWidth());
        sb.append(";color=");
        sb.append(polylineOptions.getColor());
        sb.append(";visible=");
        sb.append(polylineOptions.isVisible());
        n(str, str2 + " " + sb.toString());
    }

    public static void i(String str, String str2, List<MarkerOptions> list) {
        if (list != null) {
            Iterator<MarkerOptions> it = list.iterator();
            while (it.hasNext()) {
                f(str, str2, it.next());
            }
        }
    }

    public static void j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            boolean x5 = g4.x(jSONObject.optString("able", ""), false);
            boolean x6 = g4.x(jSONObject.optString("mobile", ""), false);
            boolean x7 = g4.x(jSONObject.optString("debugupload", ""), false);
            boolean x8 = g4.x(jSONObject.optString("debugwrite", ""), false);
            boolean x9 = g4.x(jSONObject.optString("forcedUpload", ""), false);
            c3.f5801a = x5;
            boolean x10 = g4.x(jSONObject.optString("di", ""), false);
            String optString = jSONObject.optString("dis", "");
            if (!x10 || q4.B(optString)) {
                b5.c(b3.s()).k(x5, x6, x8, x7, Arrays.asList(jSONObject.optString("filter", "").split(ContainerUtils.FIELD_DELIMITER)));
                if (x9) {
                    b5.c(b3.s()).j(x9);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void k() {
        try {
            f5897a.put("overlay", new h3());
            f5897a.put(PrerollVideoResponse.NORMAL, new g3());
        } catch (Throwable unused) {
        }
    }

    public static void l(String str, String str2) {
        c(1, PrerollVideoResponse.NORMAL, f5898b, str, str2);
    }

    public static void m(String str, String str2) {
        c(0, "overlay", f5898b, str, str2);
    }

    private static void n(String str, String str2) {
        c(1, "overlay", f5898b, str, str2);
    }

    private static void b(int i6, String str, String str2) {
    }
}
