package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.district.DistrictSearchQuery;
import com.autonavi.aps.amapapi.trans.b;
import com.umeng.socialize.common.SocializeConstants;
import java.util.HashMap;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    r6 f5931a;

    public final String a(Context context, String str, String str2) {
        Map<String, String> e6 = e(context, str2, null, null, null, null, null, null);
        e6.put("extensions", "all");
        e6.put("subdistrict", "0");
        return d(context, str, e6);
    }

    public final String b(Context context, String str, String str2, String str3, String str4, String str5) {
        Map<String, String> e6 = e(context, str2, str3, str4, str5, null, null, null);
        e6.put("children", "1");
        e6.put("page", "1");
        e6.put("extensions", "base");
        return d(context, str, e6);
    }

    public final String c(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Map<String, String> e6 = e(context, str2, str3, null, str4, str5, str6, str7);
        e6.put("children", "1");
        e6.put("page", "1");
        e6.put("extensions", "base");
        return d(context, str, e6);
    }

    private String d(Context context, String str, Map<String, String> map) {
        try {
            HashMap hashMap = new HashMap(16);
            b bVar = new b();
            hashMap.clear();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("Connection", "Keep-Alive");
            hashMap.put("User-Agent", "AMAP_Location_SDK_Android 6.4.3");
            String a6 = h4.a();
            String c6 = h4.c(context, a6, q4.r(map));
            map.put("ts", a6);
            map.put("scode", c6);
            bVar.b(map);
            bVar.a(hashMap);
            bVar.a(str);
            bVar.setProxy(o4.c(context));
            bVar.setConnectionTimeout(com.autonavi.aps.amapapi.utils.b.f10242i);
            bVar.setSoTimeout(com.autonavi.aps.amapapi.utils.b.f10242i);
            try {
                return new String(r6.d(bVar).f7800a, "utf-8");
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceNetManager", "post");
                return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Map<String, String> e(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        HashMap hashMap = new HashMap(16);
        hashMap.put("key", f4.j(context));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("keywords", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("types", str2);
        }
        if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
            hashMap.put(SocializeConstants.KEY_LOCATION, str6 + "," + str5);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put(DistrictSearchQuery.KEYWORDS_CITY, str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_OFFSET, str4);
        }
        if (!TextUtils.isEmpty(str7)) {
            hashMap.put("radius", str7);
        }
        return hashMap;
    }

    public e0(Context context) {
        this.f5931a = null;
        try {
            k4.a().c(context);
        } catch (Throwable unused) {
        }
        this.f5931a = r6.b();
    }
}
