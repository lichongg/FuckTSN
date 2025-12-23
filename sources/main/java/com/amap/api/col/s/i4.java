package com.amap.api.col.s;

import com.amap.api.col.s.i1;
import com.amap.api.services.core.ServiceSettings;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class i4 {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f8168a = {"com.amap.api.services", "com.amap.api.search.admic"};

    public static i1 a(boolean z5) {
        try {
            return new i1.a("sea", "9.7.0", "AMAP SDK Android Search 9.7.0").c(f8168a).b(z5).a("9.7.0").d();
        } catch (bv e6) {
            j4.i(e6, "ConfigableConst", "getSDKInfo");
            return null;
        }
    }

    public static String b() {
        if (ServiceSettings.getInstance().getProtocol() == 1) {
            return "http://restsdk.amap.com/v3";
        }
        return "https://restsdk.amap.com/v3";
    }

    public static String c() {
        if (ServiceSettings.getInstance().getProtocol() == 1) {
            return "http://restsdk.amap.com/v4";
        }
        return "https://restsdk.amap.com/v4";
    }

    public static String d() {
        if (ServiceSettings.getInstance().getProtocol() == 1) {
            return "http://restsdk.amap.com/v5";
        }
        return "https://restsdk.amap.com/v5";
    }

    public static String e() {
        if (ServiceSettings.getInstance().getProtocol() == 1) {
            return "http://yuntuapi.amap.com";
        }
        return "https://yuntuapi.amap.com";
    }

    public static String f() {
        if (ServiceSettings.getInstance().getProtocol() == 1) {
            return "http://restsdk.amap.com/rest/me/cpoint";
        }
        return "https://restsdk.amap.com/rest/me/cpoint";
    }

    public static String g() {
        if (ServiceSettings.getInstance().getProtocol() == 1) {
            return "http://apistore.amap.com";
        }
        return "https://apistore.amap.com";
    }

    public static String h() {
        if (ServiceSettings.getInstance().getProtocol() == 1) {
            return "http://m5.amap.com/ws/mapapi/shortaddress/transform";
        }
        return "https://m5.amap.com/ws/mapapi/shortaddress/transform";
    }
}
