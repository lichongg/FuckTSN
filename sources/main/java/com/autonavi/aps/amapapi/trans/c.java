package com.autonavi.aps.amapapi.trans;

import android.content.Context;
import com.amap.api.col.p0003l.Cif;
import com.amap.api.col.p0003l.f4;
import com.amap.api.col.p0003l.h4;
import com.amap.api.col.p0003l.k4;
import com.amap.api.col.p0003l.o4;
import com.amap.api.col.p0003l.q4;
import com.amap.api.col.p0003l.r6;
import com.amap.api.col.p0003l.z6;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DTileBuildType;
import com.autonavi.aps.amapapi.utils.j;
import com.umeng.analytics.pro.bi;
import java.util.HashMap;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    private static c f10163b;

    /* renamed from: a, reason: collision with root package name */
    r6 f10164a;

    /* renamed from: c, reason: collision with root package name */
    private Context f10165c;

    /* renamed from: d, reason: collision with root package name */
    private int f10166d = com.autonavi.aps.amapapi.utils.b.f10242i;

    /* renamed from: e, reason: collision with root package name */
    private boolean f10167e = false;

    /* renamed from: f, reason: collision with root package name */
    private int f10168f = 0;

    public static c a(Context context) {
        if (f10163b == null) {
            f10163b = new c(context);
        }
        return f10163b;
    }

    private c(Context context) {
        this.f10164a = null;
        this.f10165c = null;
        try {
            k4.a().c(context);
        } catch (Throwable unused) {
        }
        this.f10165c = context;
        this.f10164a = r6.b();
    }

    public final void a(long j6, boolean z5, int i6) {
        try {
            this.f10167e = z5;
            this.f10166d = Long.valueOf(j6).intValue();
            this.f10168f = i6;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "LocNetManager", "setOption");
        }
    }

    public final d a(Context context, byte[] bArr, String str, String str2, boolean z5) {
        try {
            HashMap hashMap = new HashMap(16);
            d dVar = new d(context, com.autonavi.aps.amapapi.utils.b.c());
            try {
                hashMap.put("Content-Type", "application/octet-stream");
                hashMap.put("Accept-Encoding", "gzip");
                hashMap.put("gzipped", "1");
                hashMap.put("Connection", "Keep-Alive");
                hashMap.put("User-Agent", "AMAP_Location_SDK_Android 6.4.3");
                hashMap.put("KEY", f4.j(context));
                hashMap.put("enginever", com.autonavi.aps.amapapi.utils.b.f10234a);
                String a6 = h4.a();
                String c6 = h4.c(context, a6, "key=" + f4.j(context));
                hashMap.put("ts", a6);
                hashMap.put("scode", c6);
                if (Double.valueOf(com.autonavi.aps.amapapi.utils.b.f10234a).doubleValue() >= 5.3d) {
                    hashMap.put("aps_s_src", "openapi");
                }
                hashMap.put("encr", "1");
                dVar.b(hashMap);
                String str3 = "loc";
                if (!z5) {
                    str3 = "locf";
                }
                dVar.b(true);
                dVar.a(String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", "6.4.3", str3, 3));
                dVar.a(z5);
                dVar.b(str);
                dVar.c(str2);
                dVar.c(j.a(bArr));
                dVar.setProxy(o4.c(context));
                HashMap hashMap2 = new HashMap(16);
                hashMap2.put("output", "bin");
                hashMap2.put(bi.bt, AMap3DTileBuildType.AIRPORT_TERMINAL);
                int i6 = this.f10168f;
                if (i6 == 0) {
                    hashMap2.remove("custom");
                } else if (i6 == 1) {
                    hashMap2.put("custom", "language:cn");
                } else if (i6 != 2) {
                    hashMap2.remove("custom");
                } else {
                    hashMap2.put("custom", "language:en");
                }
                dVar.a(hashMap2);
                dVar.setConnectionTimeout(this.f10166d);
                dVar.setSoTimeout(this.f10166d);
                if (this.f10167e) {
                    dVar.setHttpProtocol(Cif.c.HTTPS);
                }
                return dVar;
            } catch (Throwable unused) {
                return dVar;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public final z6 a(d dVar) throws Throwable {
        if (this.f10167e) {
            dVar.setHttpProtocol(Cif.c.HTTPS);
        }
        return r6.d(dVar);
    }

    public final String a(Context context, double d6, double d7) {
        try {
            HashMap hashMap = new HashMap(16);
            d dVar = new d(context, com.autonavi.aps.amapapi.utils.b.c());
            hashMap.clear();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("Connection", "Keep-Alive");
            hashMap.put("User-Agent", "AMAP_Location_SDK_Android 6.4.3");
            HashMap hashMap2 = new HashMap(16);
            hashMap2.put("custom", "26260A1F00020002");
            hashMap2.put("key", f4.j(context));
            int i6 = this.f10168f;
            if (i6 == 0) {
                hashMap2.remove("language");
            } else if (i6 == 1) {
                hashMap2.put("language", "zh-CN");
            } else if (i6 != 2) {
                hashMap2.remove("language");
            } else {
                hashMap2.put("language", "en");
            }
            hashMap2.put("curLocationType", j.m(this.f10165c) ? "coarseLoc" : "fineLoc");
            String a6 = h4.a();
            String c6 = h4.c(context, a6, q4.r(hashMap2));
            hashMap2.put("ts", a6);
            hashMap2.put("scode", c6);
            dVar.b(("output=json&radius=1000&extensions=all&location=" + d7 + "," + d6).getBytes("UTF-8"));
            dVar.b(false);
            dVar.a(true);
            dVar.a(String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", "6.4.3", "loc", 3));
            dVar.a(hashMap2);
            dVar.b(hashMap);
            dVar.setProxy(o4.c(context));
            dVar.setConnectionTimeout(com.autonavi.aps.amapapi.utils.b.f10242i);
            dVar.setSoTimeout(com.autonavi.aps.amapapi.utils.b.f10242i);
            try {
                dVar.c("http://dualstack-arestapi.amap.com/v3/geocode/regeo");
                dVar.b("http://restsdk.amap.com/v3/geocode/regeo");
                if (this.f10167e) {
                    dVar.setHttpProtocol(Cif.c.HTTPS);
                }
                return new String(r6.d(dVar).f7800a, "utf-8");
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "LocNetManager", "post");
                return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }
}
