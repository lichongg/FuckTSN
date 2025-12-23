package com.autonavi.aps.amapapi.restruct;

import com.amap.api.maps.model.MyLocationStyle;
import java.util.Objects;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public int f10074a = 0;

    /* renamed from: b, reason: collision with root package name */
    public double f10075b = 0.0d;

    /* renamed from: c, reason: collision with root package name */
    public double f10076c = 0.0d;

    /* renamed from: d, reason: collision with root package name */
    public long f10077d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f10078e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f10079f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f10080g = 63;

    /* renamed from: h, reason: collision with root package name */
    public int f10081h = 0;

    public final String a() {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            jSONObject.put("time", this.f10077d);
            jSONObject.put("lon", this.f10076c);
            jSONObject.put(com.umeng.analytics.pro.d.C, this.f10075b);
            jSONObject.put("radius", this.f10078e);
            jSONObject.put(MyLocationStyle.LOCATION_TYPE, this.f10074a);
            jSONObject.put("reType", this.f10080g);
            jSONObject.put("reSubType", this.f10081h);
        } catch (Throwable unused) {
            jSONObject = null;
        }
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && f.class == obj.getClass()) {
            f fVar = (f) obj;
            if (this.f10074a == fVar.f10074a && Double.compare(fVar.f10075b, this.f10075b) == 0 && Double.compare(fVar.f10076c, this.f10076c) == 0 && this.f10077d == fVar.f10077d && this.f10078e == fVar.f10078e && this.f10079f == fVar.f10079f && this.f10080g == fVar.f10080g && this.f10081h == fVar.f10081h) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f10074a), Double.valueOf(this.f10075b), Double.valueOf(this.f10076c), Long.valueOf(this.f10077d), Integer.valueOf(this.f10078e), Integer.valueOf(this.f10079f), Integer.valueOf(this.f10080g), Integer.valueOf(this.f10081h));
    }

    public final void a(JSONObject jSONObject) {
        try {
            this.f10075b = jSONObject.optDouble(com.umeng.analytics.pro.d.C, this.f10075b);
            this.f10076c = jSONObject.optDouble("lon", this.f10076c);
            this.f10074a = jSONObject.optInt(MyLocationStyle.LOCATION_TYPE, this.f10074a);
            this.f10080g = jSONObject.optInt("reType", this.f10080g);
            this.f10081h = jSONObject.optInt("reSubType", this.f10081h);
            this.f10078e = jSONObject.optInt("radius", this.f10078e);
            this.f10077d = jSONObject.optLong("time", this.f10077d);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "CoreUtil", "transformLocation");
        }
    }
}
