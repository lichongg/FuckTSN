package com.bytedance.sdk.openadsdk.core.rn;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.umeng.socialize.common.SocializeConstants;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {
    private static volatile cw cw = null;

    /* renamed from: j, reason: collision with root package name */
    private static long f30145j = 1800000;

    /* renamed from: r, reason: collision with root package name */
    private static volatile long f30146r = 0;
    private static volatile long up = 0;
    private static long xt = 60000;

    private static class j implements Callable<com.bytedance.sdk.openadsdk.i.cw.cw.cw> {
        private j() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.bytedance.sdk.openadsdk.i.cw.cw.cw call() throws Exception {
            return com.bytedance.sdk.openadsdk.core.oq.i().w().g();
        }
    }

    private static class xt implements Callable<Location> {

        /* renamed from: j, reason: collision with root package name */
        private LocationManager f30152j;
        private String xt;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Location call() throws Exception {
            System.currentTimeMillis();
            Location lastKnownLocation = this.f30152j.getLastKnownLocation(this.xt);
            System.currentTimeMillis();
            return lastKnownLocation;
        }

        public xt(LocationManager locationManager, String str) {
            this.f30152j = locationManager;
            this.xt = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cw() {
        com.bytedance.sdk.component.oq.ae.xt(new com.bytedance.sdk.component.oq.g("getLocation c") { // from class: com.bytedance.sdk.openadsdk.core.rn.r.3
            @Override // java.lang.Runnable
            public void run() {
                cw xt2 = r.xt(com.bytedance.sdk.openadsdk.core.v.getContext());
                long unused = r.f30146r = 0L;
                if (xt2 != null) {
                    cw unused2 = r.cw = xt2;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("latitude", Float.toString(xt2.f30062j));
                        jSONObject.put("longitude", Float.toString(xt2.xt));
                        jSONObject.put("lbstime", xt2.cw);
                        String jSONObject2 = jSONObject.toString();
                        String xt3 = com.bytedance.sdk.component.utils.j.xt(jSONObject2);
                        com.bytedance.sdk.openadsdk.core.cw.r.j().r("sdk_ad_location", jSONObject2);
                        com.bytedance.sdk.openadsdk.core.cw.r.j().r("new_sdk_ad_location", xt3);
                    } catch (JSONException e6) {
                        com.bytedance.sdk.component.utils.vl.j(e6);
                    }
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static com.bytedance.sdk.openadsdk.i.cw.cw.cw m() {
        try {
            final com.bytedance.sdk.component.oq.tl tlVar = new com.bytedance.sdk.component.oq.tl(new j(), 1, 2);
            com.bytedance.sdk.component.oq.ae.xt(new com.bytedance.sdk.component.oq.g("getLastKnownLocation") { // from class: com.bytedance.sdk.openadsdk.core.rn.r.6
                @Override // java.lang.Runnable
                public void run() {
                    tlVar.run();
                }
            });
            return (com.bytedance.sdk.openadsdk.i.cw.cw.cw) tlVar.get(1L, TimeUnit.SECONDS);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static LocationManager cw(Context context) {
        try {
            return (LocationManager) context.getSystemService(SocializeConstants.KEY_LOCATION);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static cw xt(final Context context) {
        cw cwVar = null;
        if (!com.bytedance.sdk.openadsdk.core.oq.i().w().j()) {
            try {
                com.bytedance.sdk.openadsdk.i.cw.cw.cw m6 = m();
                if (m6 != null) {
                    return new cw(Double.valueOf(m6.j()).floatValue(), Double.valueOf(m6.xt()).floatValue(), System.currentTimeMillis());
                }
            } catch (Throwable unused) {
            }
            return null;
        }
        final LocationManager cw2 = cw(context);
        if (cw2 != null) {
            try {
                Location j6 = j(cw2);
                if (j6 != null && xt(j6)) {
                    cwVar = new cw((float) j6.getLatitude(), (float) j6.getLongitude(), System.currentTimeMillis());
                }
                com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rn.r.4
                    @Override // java.lang.Runnable
                    public void run() {
                        r.xt(context, cw2);
                    }
                });
                return cwVar;
            } catch (Throwable th) {
                if (com.bytedance.sdk.component.utils.vl.cw()) {
                    com.bytedance.sdk.component.utils.vl.j(th);
                }
            }
        }
        return cwVar;
    }

    private static boolean r() {
        if (System.currentTimeMillis() - up > f30145j) {
            return true;
        }
        return false;
    }

    private static boolean up() {
        if (System.currentTimeMillis() - f30146r > xt) {
            return true;
        }
        return false;
    }

    public static cw j() {
        return j(!com.bytedance.sdk.openadsdk.core.cw.j.xt());
    }

    public static cw j(boolean z5) {
        if ((cw != null && !r()) || !up()) {
            return cw;
        }
        String cw2 = com.bytedance.sdk.component.utils.j.cw(com.bytedance.sdk.openadsdk.core.cw.r.j().r("new_sdk_ad_location", 2147483647L));
        if (cw2 != null) {
            try {
                JSONObject jSONObject = new JSONObject(cw2);
                String optString = jSONObject.optString("latitude");
                String optString2 = jSONObject.optString("longitude");
                long optLong = jSONObject.optLong("lbstime");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    cw = new cw(Float.valueOf(optString).floatValue(), Float.valueOf(optString2).floatValue(), optLong);
                    up = optLong;
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.vl.j(th);
            }
            if (z5) {
                return cw;
            }
        }
        if (cw != null && !r()) {
            return cw;
        }
        com.bytedance.sdk.openadsdk.i.cw.cw.r w5 = com.bytedance.sdk.openadsdk.core.oq.i().w();
        if (!w5.j()) {
            com.bytedance.sdk.openadsdk.i.cw.cw.cw g6 = w5.g();
            if (g6 != null) {
                up = System.currentTimeMillis();
                cw = new cw((float) g6.j(), (float) g6.xt(), System.currentTimeMillis());
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                if (cw != null) {
                    jSONObject2.put("latitude", Float.toString(cw.f30062j));
                    jSONObject2.put("longitude", Float.toString(cw.xt));
                    jSONObject2.put("lbstime", cw.cw);
                }
                String jSONObject3 = jSONObject2.toString();
                String xt2 = com.bytedance.sdk.component.utils.j.xt(jSONObject3);
                com.bytedance.sdk.openadsdk.core.cw.r.j().r("sdk_ad_location", jSONObject3);
                com.bytedance.sdk.openadsdk.core.cw.r.j().r("new_sdk_ad_location", xt2);
            } catch (Exception e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
            }
            return cw;
        }
        up = System.currentTimeMillis();
        f30146r = System.currentTimeMillis();
        if (com.bytedance.sdk.openadsdk.core.r.j.tl()) {
            new com.bytedance.sdk.openadsdk.core.r.xt("device_locate").j(5).j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rn.r.2
                @Override // java.lang.Runnable
                public void run() {
                    long unused = r.f30146r = 0L;
                }
            }).xt(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rn.r.1
                @Override // java.lang.Runnable
                public void run() {
                    r.cw();
                }
            });
        } else {
            cw();
        }
        return cw;
    }

    private static String xt(LocationManager locationManager) {
        if (locationManager.isProviderEnabled(GeocodeSearch.GPS)) {
            return GeocodeSearch.GPS;
        }
        if (locationManager.isProviderEnabled("network")) {
            return "network";
        }
        if (locationManager.isProviderEnabled("passive")) {
            return "passive";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xt(Context context, final LocationManager locationManager) {
        if (context == null || locationManager == null) {
            return;
        }
        final LocationListener locationListener = new LocationListener() { // from class: com.bytedance.sdk.openadsdk.core.rn.r.7
            @Override // android.location.LocationListener
            public void onLocationChanged(Location location) {
                if (location != null) {
                    r.xt(location);
                }
                r.xt(locationManager, this);
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
        };
        try {
            if (TextUtils.isEmpty(xt(locationManager))) {
                return;
            }
            locationManager.requestSingleUpdate("network", locationListener, Looper.myLooper());
            com.bytedance.sdk.component.utils.tl.j().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rn.r.8
                @Override // java.lang.Runnable
                public void run() {
                    r.xt(locationManager, locationListener);
                }
            }, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
        } catch (Throwable th) {
            if (com.bytedance.sdk.component.utils.vl.cw()) {
                com.bytedance.sdk.component.utils.vl.j(th);
            }
            xt(locationManager, locationListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xt(LocationManager locationManager, LocationListener locationListener) {
        if (locationManager == null || locationListener == null) {
            return;
        }
        try {
            locationManager.removeUpdates(locationListener);
        } catch (Throwable th) {
            if (com.bytedance.sdk.component.utils.vl.cw()) {
                com.bytedance.sdk.component.utils.vl.j(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean xt(Location location) {
        return (location.getLatitude() == 0.0d || location.getLongitude() == 0.0d) ? false : true;
    }

    private static Location j(LocationManager locationManager) {
        Location j6 = j(locationManager, GeocodeSearch.GPS);
        if (j6 == null) {
            j6 = j(locationManager, "network");
        }
        return j6 == null ? j(locationManager, "passive") : j6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Location j(LocationManager locationManager, String str) {
        try {
            final com.bytedance.sdk.component.oq.tl tlVar = new com.bytedance.sdk.component.oq.tl(new xt(locationManager, str), 1, 2);
            com.bytedance.sdk.component.oq.ae.xt(new com.bytedance.sdk.component.oq.g("getLastKnownLocation") { // from class: com.bytedance.sdk.openadsdk.core.rn.r.5
                @Override // java.lang.Runnable
                public void run() {
                    tlVar.run();
                }
            });
            return (Location) tlVar.get(1L, TimeUnit.SECONDS);
        } catch (Throwable unused) {
            return null;
        }
    }
}
