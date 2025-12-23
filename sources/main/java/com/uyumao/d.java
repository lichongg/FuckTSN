package com.uyumao;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.analytics.pro.bi;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.uyumao.g;
import com.uyumao.sdk.UYMManager;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d implements g.a {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f42564a = true;

    /* renamed from: b, reason: collision with root package name */
    public static volatile boolean f42565b = true;

    /* renamed from: c, reason: collision with root package name */
    public static volatile boolean f42566c = true;

    /* renamed from: d, reason: collision with root package name */
    public static volatile boolean f42567d = true;

    /* renamed from: e, reason: collision with root package name */
    public static volatile boolean f42568e = true;

    /* renamed from: f, reason: collision with root package name */
    public static volatile boolean f42569f = true;

    /* renamed from: g, reason: collision with root package name */
    public static Context f42570g;

    /* renamed from: h, reason: collision with root package name */
    public static JSONObject f42571h;

    /* renamed from: i, reason: collision with root package name */
    public static JSONObject f42572i;

    /* renamed from: j, reason: collision with root package name */
    public static JSONObject f42573j;

    /* renamed from: k, reason: collision with root package name */
    public static JSONObject f42574k;

    /* renamed from: l, reason: collision with root package name */
    public static volatile boolean f42575l;

    /* renamed from: m, reason: collision with root package name */
    public static Map<String, Integer> f42576m;

    /* renamed from: n, reason: collision with root package name */
    public static LocationListener f42577n;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f42578a;

        public b(d dVar, String str) {
            this.f42578a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.a(d.f42570g, "https://yumao.puata.info/cc_info", this.f42578a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f42579a;

        public c(d dVar, String str) {
            this.f42579a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.a(d.f42570g, "https://yumao.puata.info/cc_info", this.f42579a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.uyumao.d$d, reason: collision with other inner class name */
    public class RunnableC0841d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f42580a;

        public RunnableC0841d(d dVar, String str) {
            this.f42580a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.a(d.f42570g, "https://yumao.puata.info/cc_info", this.f42580a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public static final d f42581a = new d();
    }

    static {
        HashMap hashMap = new HashMap();
        f42576m = hashMap;
        hashMap.put(com.umeng.ccg.a.f41526b, 101);
        f42576m.put(com.umeng.ccg.a.f41527c, 102);
        f42576m.put(com.umeng.ccg.a.f41528d, 103);
        f42576m.put(com.umeng.ccg.a.f41529e, 104);
        f42577n = new a();
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        try {
            Object optString = jSONObject2.optString(com.umeng.ccg.a.f41539o);
            String optString2 = jSONObject2.optString("sdk");
            jSONObject.put(com.umeng.ccg.a.f41539o, optString);
            String[] split = optString2.split(",");
            JSONArray jSONArray = new JSONArray();
            for (String str : split) {
                jSONArray.put(str);
            }
            jSONObject.put("sdk", jSONArray);
        } catch (Throwable unused) {
        }
    }

    public static JSONObject a(Context context) {
        JSONObject jSONObject = f42571h;
        if (jSONObject != null && jSONObject.length() > 0) {
            return f42571h;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("os", "Android");
            jSONObject2.put(com.kuaishou.weapon.p0.t.f36161v, Build.MODEL);
            jSONObject2.put("av", DeviceConfig.getAppVersionName(context));
            jSONObject2.put("umid", UMUtils.getUMId(context));
            jSONObject2.put("ov", Build.VERSION.RELEASE);
            jSONObject2.put("chn", UMUtils.getChannel(context));
            if (UMUtils.getActiveUser(context) != null && UMUtils.getActiveUser(context).length == 2) {
                jSONObject2.put(com.umeng.analytics.pro.d.N, UMUtils.getActiveUser(context)[1]);
            } else {
                jSONObject2.put(com.umeng.analytics.pro.d.N, "");
            }
            jSONObject2.put(bi.al, UMUtils.getZid(context));
            jSONObject2.put("sv", UYMManager.getSdkVersion());
            jSONObject2.put(SocializeProtocolConstants.PROTOCOL_KEY_AK, UMUtils.getAppkey(context));
            jSONObject2.put("idfa", DeviceConfig.getIdfa(context));
            jSONObject2.put("db", Build.BRAND);
            jSONObject2.put(CommonNetImpl.AID, DeviceConfig.getAndroidId(context));
            jSONObject2.put("oaid", DeviceConfig.getOaid(context));
            jSONObject2.put("imei", DeviceConfig.getImeiNew(context));
            jSONObject2.put("boa", Build.BOARD);
            jSONObject2.put("mant", Build.TIME);
            String[] localeInfo = DeviceConfig.getLocaleInfo(context);
            jSONObject2.put("ct", localeInfo[0]);
            jSONObject2.put("lang", localeInfo[1]);
            jSONObject2.put("tz", DeviceConfig.getTimeZone(context));
            jSONObject2.put("pkg", DeviceConfig.getPackageName(context));
            jSONObject2.put("disn", DeviceConfig.getAppName(context));
            String[] networkAccessMode = DeviceConfig.getNetworkAccessMode(context);
            if (!"Wi-Fi".equals(networkAccessMode[0])) {
                if ("2G/3G".equals(networkAccessMode[0])) {
                    jSONObject2.put("ac", "2G/3G");
                } else {
                    jSONObject2.put("ac", "unknown");
                }
            } else {
                jSONObject2.put("ac", "wifi");
            }
            if (!"".equals(networkAccessMode[1])) {
                jSONObject2.put("ast", networkAccessMode[1]);
            }
            jSONObject2.put("nt", DeviceConfig.getNetworkType(context));
            String deviceToken = UMUtils.getDeviceToken(context);
            if (!TextUtils.isEmpty(deviceToken)) {
                jSONObject2.put("device_token", deviceToken);
            }
            f42571h = jSONObject2;
        } catch (Throwable unused) {
        }
        return f42571h;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a implements LocationListener {
        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            boolean unused = d.f42575l = true;
            try {
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                long time = location.getTime();
                double altitude = location.hasAltitude() ? location.getAltitude() : 0.0d;
                double speed = location.hasSpeed() ? location.getSpeed() : 0.0d;
                JSONObject jSONObject = new JSONObject();
                d.f42573j = jSONObject;
                jSONObject.put(com.umeng.analytics.pro.d.C, latitude);
                d.f42573j.put(com.umeng.analytics.pro.d.D, longitude);
                d.f42573j.put("alt", altitude);
                d.f42573j.put("acc", speed);
                d.f42573j.put("lts", time);
                g.a(d.f42570g, 203, e.f42581a, d.f42574k);
            } catch (Throwable unused2) {
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i6, Bundle bundle) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ad, code lost:
    
        if (r5.contains("network") != false) goto L52;
     */
    @Override // com.uyumao.g.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.Object r19, int r20) {
        /*
            Method dump skipped, instructions count: 512
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uyumao.d.a(java.lang.Object, int):void");
    }
}
