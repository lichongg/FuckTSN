package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import org.json.JSONException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final Context f33443a;

    /* renamed from: b, reason: collision with root package name */
    private final GrsBaseInfo f33444b;

    /* renamed from: c, reason: collision with root package name */
    private final o1.a f33445c;

    public String a(boolean z5) {
        String str;
        String str2 = com.huawei.hms.framework.network.grs.a.g(this.f33445c.b().a("geoipCountryCode", ""), "geoip.countrycode").get(org.slf4j.c.E0);
        Logger.i("GeoipCountry", "geoIpCountry is: " + str2);
        String a6 = this.f33445c.b().a("geoipCountryCodetime", "0");
        long j6 = 0;
        if (!TextUtils.isEmpty(a6) && a6.matches("\\d+")) {
            try {
                j6 = Long.parseLong(a6);
            } catch (NumberFormatException e6) {
                Logger.w("GeoipCountry", "convert urlParamKey from String to Long catch NumberFormatException.", e6);
            }
        }
        if (TextUtils.isEmpty(str2) || r1.e.a(Long.valueOf(j6))) {
            q1.c cVar = new q1.c(this.f33444b, this.f33443a);
            cVar.b("geoip.countrycode");
            o1.c i6 = this.f33445c.i();
            if (i6 != null) {
                try {
                    str = h.a(i6.a("services", ""), cVar.d());
                } catch (JSONException e7) {
                    Logger.w("GeoipCountry", "getGeoipCountry merge services occure jsonException. %s", StringUtils.anonymizeMessage(e7.getMessage()));
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    i6.f("services", str);
                }
            }
            if (z5) {
                d a7 = this.f33445c.g().a(cVar, "geoip.countrycode", i6, -1);
                if (a7 != null) {
                    str2 = com.huawei.hms.framework.network.grs.a.g(a7.y(), "geoip.countrycode").get(org.slf4j.c.E0);
                }
                Logger.i("GeoipCountry", "sync request to query geoip.countrycode is:" + str2);
            } else {
                Logger.i("GeoipCountry", "async request to query geoip.countrycode");
                this.f33445c.g().h(cVar, null, "geoip.countrycode", i6, -1);
            }
        }
        return str2;
    }

    public b(Context context, o1.a aVar, GrsBaseInfo grsBaseInfo) {
        this.f33443a = context;
        this.f33444b = grsBaseInfo;
        this.f33445c = aVar;
    }
}
