package com.amap.api.col.p0003l;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.district.DistrictSearchQuery;
import com.stub.StubApp;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class t6 {

    /* renamed from: b, reason: collision with root package name */
    private Context f7291b;

    /* renamed from: d, reason: collision with root package name */
    private WebView f7293d;

    /* renamed from: h, reason: collision with root package name */
    c f7297h;

    /* renamed from: a, reason: collision with root package name */
    Object f7290a = new Object();

    /* renamed from: c, reason: collision with root package name */
    private AMapLocationClient f7292c = null;

    /* renamed from: e, reason: collision with root package name */
    private String f7294e = "AMap.Geolocation.cbk";

    /* renamed from: f, reason: collision with root package name */
    AMapLocationClientOption f7295f = null;

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f7296g = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements ValueCallback<String> {
        a() {
        }

        @Override // android.webkit.ValueCallback
        public final /* bridge */ /* synthetic */ void onReceiveValue(String str) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7299a;

        b(String str) {
            this.f7299a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            t6.this.f7293d.loadUrl("javascript:" + t6.this.f7294e + "('" + this.f7299a + "')");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements AMapLocationListener {
        c() {
        }

        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation aMapLocation) {
            if (t6.this.f7296g) {
                t6.this.i(t6.g(aMapLocation));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005a A[Catch: all -> 0x007a, TryCatch #0 {all -> 0x007a, blocks: (B:18:0x0053, B:20:0x005a, B:21:0x0069, B:23:0x0072, B:28:0x0062), top: B:17:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0072 A[Catch: all -> 0x007a, TRY_LEAVE, TryCatch #0 {all -> 0x007a, blocks: (B:18:0x0053, B:20:0x005a, B:21:0x0069, B:23:0x0072, B:28:0x0062), top: B:17:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0062 A[Catch: all -> 0x007a, TryCatch #0 {all -> 0x007a, blocks: (B:18:0x0053, B:20:0x005a, B:21:0x0069, B:23:0x0072, B:28:0x0062), top: B:17:0x0053 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e(java.lang.String r9) {
        /*
            r8 = this;
            com.amap.api.location.AMapLocationClientOption r0 = r8.f7295f
            if (r0 != 0) goto Lb
            com.amap.api.location.AMapLocationClientOption r0 = new com.amap.api.location.AMapLocationClientOption
            r0.<init>()
            r8.f7295f = r0
        Lb:
            r0 = 5
            r1 = 30000(0x7530, double:1.4822E-319)
            r3 = 0
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L4f
            r4.<init>(r9)     // Catch: java.lang.Throwable -> L4f
            java.lang.String r9 = "to"
            long r1 = r4.optLong(r9, r1)     // Catch: java.lang.Throwable -> L4f
            java.lang.String r9 = "useGPS"
            r5 = 1
            int r9 = r4.optInt(r9, r5)     // Catch: java.lang.Throwable -> L4f
            if (r9 != r5) goto L25
            r9 = 1
            goto L26
        L25:
            r9 = 0
        L26:
            java.lang.String r6 = "watch"
            int r6 = r4.optInt(r6, r3)     // Catch: java.lang.Throwable -> L4e
            if (r6 != r5) goto L2f
            r3 = 1
        L2f:
            java.lang.String r5 = "interval"
            int r0 = r4.optInt(r5, r0)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r5 = "callback"
            r6 = 0
            java.lang.String r4 = r4.optString(r5, r6)     // Catch: java.lang.Throwable -> L4a
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L4a
            if (r5 != 0) goto L45
            r8.f7294e = r4     // Catch: java.lang.Throwable -> L4a
            goto L53
        L45:
            java.lang.String r4 = "AMap.Geolocation.cbk"
            r8.f7294e = r4     // Catch: java.lang.Throwable -> L4a
            goto L53
        L4a:
            r7 = r3
            r3 = r9
            r9 = r7
            goto L50
        L4e:
            r3 = r9
        L4f:
            r9 = 0
        L50:
            r7 = r3
            r3 = r9
            r9 = r7
        L53:
            com.amap.api.location.AMapLocationClientOption r4 = r8.f7295f     // Catch: java.lang.Throwable -> L7a
            r4.setHttpTimeOut(r1)     // Catch: java.lang.Throwable -> L7a
            if (r9 == 0) goto L62
            com.amap.api.location.AMapLocationClientOption r9 = r8.f7295f     // Catch: java.lang.Throwable -> L7a
            com.amap.api.location.AMapLocationClientOption$AMapLocationMode r1 = com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Hight_Accuracy     // Catch: java.lang.Throwable -> L7a
            r9.setLocationMode(r1)     // Catch: java.lang.Throwable -> L7a
            goto L69
        L62:
            com.amap.api.location.AMapLocationClientOption r9 = r8.f7295f     // Catch: java.lang.Throwable -> L7a
            com.amap.api.location.AMapLocationClientOption$AMapLocationMode r1 = com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Battery_Saving     // Catch: java.lang.Throwable -> L7a
            r9.setLocationMode(r1)     // Catch: java.lang.Throwable -> L7a
        L69:
            com.amap.api.location.AMapLocationClientOption r9 = r8.f7295f     // Catch: java.lang.Throwable -> L7a
            r1 = r3 ^ 1
            r9.setOnceLocation(r1)     // Catch: java.lang.Throwable -> L7a
            if (r3 == 0) goto L7a
            com.amap.api.location.AMapLocationClientOption r9 = r8.f7295f     // Catch: java.lang.Throwable -> L7a
            int r0 = r0 * 1000
            long r0 = (long) r0     // Catch: java.lang.Throwable -> L7a
            r9.setInterval(r0)     // Catch: java.lang.Throwable -> L7a
        L7a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.t6.e(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String g(AMapLocation aMapLocation) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (aMapLocation == null) {
                jSONObject.put("errorCode", -1);
                jSONObject.put(MyLocationStyle.ERROR_INFO, "unknownError");
            } else if (aMapLocation.getErrorCode() == 0) {
                jSONObject.put("errorCode", 0);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("x", aMapLocation.getLongitude());
                jSONObject2.put("y", aMapLocation.getLatitude());
                jSONObject2.put("precision", aMapLocation.getAccuracy());
                jSONObject2.put("type", aMapLocation.getLocationType());
                jSONObject2.put("country", aMapLocation.getCountry());
                jSONObject2.put(DistrictSearchQuery.KEYWORDS_PROVINCE, aMapLocation.getProvince());
                jSONObject2.put(DistrictSearchQuery.KEYWORDS_CITY, aMapLocation.getCity());
                jSONObject2.put("cityCode", aMapLocation.getCityCode());
                jSONObject2.put(DistrictSearchQuery.KEYWORDS_DISTRICT, aMapLocation.getDistrict());
                jSONObject2.put("adCode", aMapLocation.getAdCode());
                jSONObject2.put("street", aMapLocation.getStreet());
                jSONObject2.put("streetNum", aMapLocation.getStreetNum());
                jSONObject2.put("floor", aMapLocation.getFloor());
                jSONObject2.put("address", aMapLocation.getAddress());
                jSONObject.put("result", jSONObject2);
            } else {
                jSONObject.put("errorCode", aMapLocation.getErrorCode());
                jSONObject.put(MyLocationStyle.ERROR_INFO, aMapLocation.getErrorInfo());
                jSONObject.put("locationDetail", aMapLocation.getLocationDetail());
            }
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public void i(String str) {
        try {
            WebView webView = this.f7293d;
            if (webView != null) {
                webView.evaluateJavascript("javascript:" + this.f7294e + "('" + str + "')", new a());
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "H5LocationClient", "callbackJs()");
        }
    }

    public final void c() {
        if (this.f7293d == null || this.f7291b == null || this.f7296g) {
            return;
        }
        try {
            this.f7293d.getSettings().setJavaScriptEnabled(true);
            this.f7293d.addJavascriptInterface(this, "AMapAndroidLoc");
            if (!TextUtils.isEmpty(this.f7293d.getUrl())) {
                this.f7293d.reload();
            }
            if (this.f7292c == null) {
                AMapLocationClient aMapLocationClient = new AMapLocationClient(this.f7291b);
                this.f7292c = aMapLocationClient;
                aMapLocationClient.setLocationListener(this.f7297h);
            }
            this.f7296g = true;
        } catch (Throwable unused) {
        }
    }

    @JavascriptInterface
    public final void getLocation(String str) {
        synchronized (this.f7290a) {
            try {
                if (this.f7296g) {
                    e(str);
                    AMapLocationClient aMapLocationClient = this.f7292c;
                    if (aMapLocationClient != null) {
                        aMapLocationClient.setLocationOption(this.f7295f);
                        this.f7292c.stopLocation();
                        this.f7292c.startLocation();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void h() {
        synchronized (this.f7290a) {
            try {
                this.f7296g = false;
                AMapLocationClient aMapLocationClient = this.f7292c;
                if (aMapLocationClient != null) {
                    aMapLocationClient.unRegisterLocationListener(this.f7297h);
                    this.f7292c.stopLocation();
                    this.f7292c.onDestroy();
                    this.f7292c = null;
                }
                this.f7295f = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @JavascriptInterface
    public final void stopLocation() {
        AMapLocationClient aMapLocationClient;
        if (this.f7296g && (aMapLocationClient = this.f7292c) != null) {
            aMapLocationClient.stopLocation();
        }
    }

    public t6(Context context, WebView webView) {
        this.f7293d = null;
        this.f7297h = null;
        this.f7291b = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f7293d = webView;
        this.f7297h = new c();
    }
}
