package com.autonavi.aps.amapapi.model;

import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.utils.b;
import com.autonavi.aps.amapapi.utils.j;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class a extends AMapLocation {

    /* renamed from: d, reason: collision with root package name */
    protected String f9982d;

    /* renamed from: e, reason: collision with root package name */
    boolean f9983e;

    /* renamed from: f, reason: collision with root package name */
    String f9984f;

    /* renamed from: g, reason: collision with root package name */
    private String f9985g;

    /* renamed from: h, reason: collision with root package name */
    private String f9986h;

    /* renamed from: i, reason: collision with root package name */
    private int f9987i;

    /* renamed from: j, reason: collision with root package name */
    private String f9988j;

    /* renamed from: k, reason: collision with root package name */
    private int f9989k;

    /* renamed from: l, reason: collision with root package name */
    private String f9990l;

    /* renamed from: m, reason: collision with root package name */
    private JSONObject f9991m;

    /* renamed from: n, reason: collision with root package name */
    private String f9992n;

    /* renamed from: o, reason: collision with root package name */
    private String f9993o;

    /* renamed from: p, reason: collision with root package name */
    private String f9994p;

    private void i(String str) {
        this.f9992n = str;
    }

    public final String a() {
        return this.f9985g;
    }

    public final String b() {
        return this.f9986h;
    }

    public final int c() {
        return this.f9987i;
    }

    public final String d() {
        return this.f9988j;
    }

    public final String e() {
        return this.f9990l;
    }

    public final JSONObject f() {
        return this.f9991m;
    }

    public final String g() {
        return this.f9992n;
    }

    public final a h() {
        String g6 = g();
        if (TextUtils.isEmpty(g6)) {
            return null;
        }
        String[] split = g6.split(",");
        if (split.length != 3) {
            return null;
        }
        a aVar = new a("");
        aVar.setProvider(getProvider());
        aVar.setLongitude(j.c(split[0]));
        aVar.setLatitude(j.c(split[1]));
        aVar.setAccuracy(j.d(split[2]));
        aVar.setCityCode(getCityCode());
        aVar.setAdCode(getAdCode());
        aVar.setCountry(getCountry());
        aVar.setProvince(getProvince());
        aVar.setCity(getCity());
        aVar.setTime(getTime());
        aVar.e(e());
        aVar.c(String.valueOf(c()));
        if (j.a(aVar)) {
            return aVar;
        }
        return null;
    }

    public final String j() {
        return this.f9984f;
    }

    @Override // com.amap.api.location.AMapLocation
    public final String toStr() {
        return toStr(1);
    }

    private void j(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] split = str.split("\\*");
        int length = split.length;
        int i6 = 0;
        while (true) {
            if (i6 >= length) {
                break;
            }
            String str2 = split[i6];
            if (!TextUtils.isEmpty(str2)) {
                String[] split2 = str2.split(",");
                setLongitude(j.c(split2[0]));
                setLatitude(j.c(split2[1]));
                setAccuracy(j.e(split2[2]));
                break;
            }
            i6++;
        }
        this.f9993o = str;
    }

    public final void a(String str) {
        this.f9985g = str;
    }

    public final void b(String str) {
        this.f9986h = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(java.lang.String r2) {
        /*
            r1 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto L1e
            java.lang.String r0 = "0"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L12
            r2 = 0
            r1.f9987i = r2
            goto L21
        L12:
            java.lang.String r0 = "1"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L1e
            r2 = 1
            r1.f9987i = r2
            goto L21
        L1e:
            r2 = -1
            r1.f9987i = r2
        L21:
            int r2 = r1.f9987i
            if (r2 != 0) goto L2b
            java.lang.String r2 = "WGS84"
            super.setCoordType(r2)
            return
        L2b:
            java.lang.String r2 = "GCJ02"
            super.setCoordType(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.model.a.c(java.lang.String):void");
    }

    public final void d(String str) {
        this.f9988j = str;
    }

    public final void e(String str) {
        this.f9990l = str;
    }

    public final void f(String str) {
        this.f9984f = str;
    }

    public final void g(String str) {
        this.f9982d = str;
    }

    public final boolean i() {
        return this.f9983e;
    }

    public final String k() {
        return this.f9994p;
    }

    public final int l() {
        return this.f9989k;
    }

    @Override // com.amap.api.location.AMapLocation
    public final JSONObject toJson(int i6) {
        try {
            JSONObject json = super.toJson(i6);
            if (i6 == 1) {
                json.put("retype", this.f9988j);
                json.put("cens", this.f9993o);
                json.put("coord", this.f9987i);
                json.put("mcell", this.f9992n);
                json.put("desc", this.f9982d);
                json.put("address", getAddress());
                if (this.f9991m != null && j.a(json, "offpct")) {
                    json.put("offpct", this.f9991m.getString("offpct"));
                }
            } else if (i6 != 2 && i6 != 3) {
                return json;
            }
            json.put("type", this.f9990l);
            json.put("isReversegeo", this.f9983e);
            json.put("geoLanguage", this.f9984f);
            return json;
        } catch (Throwable th) {
            b.a(th, "AmapLoc", "toStr");
            return null;
        }
    }

    @Override // com.amap.api.location.AMapLocation
    public final String toStr(int i6) {
        JSONObject jSONObject;
        try {
            jSONObject = toJson(i6);
            jSONObject.put("nb", this.f9994p);
        } catch (Throwable th) {
            b.a(th, "AMapLocation", "toStr part2");
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }

    public a(String str) {
        super(str);
        this.f9982d = "";
        this.f9985g = null;
        this.f9986h = "";
        this.f9988j = "";
        this.f9989k = 0;
        this.f9990l = "new";
        this.f9991m = null;
        this.f9992n = "";
        this.f9983e = true;
        this.f9984f = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);
        this.f9993o = "";
        this.f9994p = null;
    }

    public final void a(JSONObject jSONObject) {
        this.f9991m = jSONObject;
    }

    public final void b(JSONObject jSONObject) {
        try {
            b.a(this, jSONObject);
            e(jSONObject.optString("type", this.f9990l));
            d(jSONObject.optString("retype", this.f9988j));
            j(jSONObject.optString("cens", this.f9993o));
            g(jSONObject.optString("desc", this.f9982d));
            c(jSONObject.optString("coord", String.valueOf(this.f9987i)));
            i(jSONObject.optString("mcell", this.f9992n));
            a(jSONObject.optBoolean("isReversegeo", this.f9983e));
            f(jSONObject.optString("geoLanguage", this.f9984f));
            if (j.a(jSONObject, "poiid")) {
                setBuildingId(jSONObject.optString("poiid"));
            }
            if (j.a(jSONObject, "pid")) {
                setBuildingId(jSONObject.optString("pid"));
            }
            if (j.a(jSONObject, "floor")) {
                setFloor(jSONObject.optString("floor"));
            }
            if (j.a(jSONObject, "flr")) {
                setFloor(jSONObject.optString("flr"));
            }
        } catch (Throwable th) {
            b.a(th, "AmapLoc", "AmapLoc");
        }
    }

    public final void a(boolean z5) {
        this.f9983e = z5;
    }

    public final void a(int i6) {
        this.f9989k = i6;
    }

    public final void h(String str) {
        this.f9994p = str;
    }
}
