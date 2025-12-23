package com.bytedance.msdk.tl;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.work.WorkRequest;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.stub.StubApp;
import com.umeng.socialize.common.SocializeConstants;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes3.dex */
public class m {

    /* renamed from: j, reason: collision with root package name */
    private static long f25221j = 1800000;
    private static Handler xt = new Handler(Looper.getMainLooper());

    private static class j implements Callable<Location> {

        /* renamed from: j, reason: collision with root package name */
        private LocationManager f25225j;
        private String xt;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Location call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            Location lastKnownLocation = this.f25225j.getLastKnownLocation(this.xt);
            com.bytedance.msdk.j.up.cw.j("AdLocationUtils", "location:" + lastKnownLocation + ",getLastKnownLocation use time :" + (System.currentTimeMillis() - currentTimeMillis));
            return lastKnownLocation;
        }

        public j(LocationManager locationManager, String str) {
            this.f25225j = locationManager;
            this.xt = str;
        }
    }

    @Nullable
    private static up cw(Context context) {
        l j6 = l.j((String) null, context);
        float xt2 = j6.xt("latitude", -1.0f);
        float xt3 = j6.xt("longitude", -1.0f);
        if (xt2 == -1.0f || xt3 == -1.0f) {
            return null;
        }
        return new up(xt2, xt3);
    }

    private static boolean xt(Context context) {
        long xt2 = l.j((String) null, context).xt("lbstime", -1L);
        return xt2 == -1 || System.currentTimeMillis() - xt2 > f25221j;
    }

    private static up r(final Context context) {
        final LocationManager locationManager = (LocationManager) context.getSystemService(SocializeConstants.KEY_LOCATION);
        up upVar = null;
        if (locationManager != null) {
            try {
                Location j6 = j(locationManager);
                if (j6 != null && xt(j6)) {
                    xt(context, j6);
                    upVar = new up((float) j6.getLatitude(), (float) j6.getLongitude());
                }
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.msdk.tl.m.1
                        @Override // java.lang.Runnable
                        public void run() {
                            m.xt(context, locationManager);
                        }
                    });
                    return upVar;
                }
                xt(context, locationManager);
                return upVar;
            } catch (Throwable th) {
                if (com.bytedance.msdk.j.up.cw.xt()) {
                    com.bytedance.sdk.component.utils.vl.j(th);
                }
            }
        }
        return null;
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

    @Nullable
    public static up j(Context context) {
        if (!com.bytedance.msdk.core.j.qv().p().j()) {
            return null;
        }
        Context context2 = context == null ? com.bytedance.msdk.core.xt.getContext() : StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (context2 == null) {
            return null;
        }
        up cw = cw(context2);
        if (!xt(context2)) {
            return cw;
        }
        int j6 = com.bytedance.msdk.core.vl.cw.j(context2, com.kuaishou.weapon.p0.g.f36047g);
        int j7 = com.bytedance.msdk.core.vl.cw.j(context2, com.kuaishou.weapon.p0.g.f36048h);
        if (j6 == 0 || j7 == 0) {
            return r(context2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xt(final Context context, final LocationManager locationManager) {
        if (context == null || locationManager == null) {
            return;
        }
        final LocationListener locationListener = new LocationListener() { // from class: com.bytedance.msdk.tl.m.2
            @Override // android.location.LocationListener
            public void onLocationChanged(Location location) {
                if (location != null && m.xt(location)) {
                    m.xt(context, location);
                }
                m.xt(locationManager, this);
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
            String xt2 = xt(locationManager);
            if (TextUtils.isEmpty(xt2)) {
                return;
            }
            locationManager.requestSingleUpdate(xt2, locationListener, Looper.getMainLooper());
            xt.postDelayed(new Runnable() { // from class: com.bytedance.msdk.tl.m.3
                @Override // java.lang.Runnable
                public void run() {
                    m.xt(locationManager, locationListener);
                }
            }, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
        } catch (Throwable th) {
            if (com.bytedance.msdk.j.up.cw.xt()) {
                com.bytedance.sdk.component.utils.vl.j(th);
            }
            xt(locationManager, locationListener);
        }
    }

    private static Location j(LocationManager locationManager) {
        Location j6 = j(locationManager, GeocodeSearch.GPS);
        if (j6 == null) {
            j6 = j(locationManager, "network");
        }
        return j6 == null ? j(locationManager, "passive") : j6;
    }

    private static Location j(LocationManager locationManager, String str) {
        try {
            FutureTask futureTask = new FutureTask(new j(locationManager, str));
            com.bytedance.msdk.j.up.m.r(futureTask);
            Location location = (Location) futureTask.get(1L, TimeUnit.SECONDS);
            com.bytedance.msdk.j.up.cw.j("AdLocationUtils", "location:".concat(String.valueOf(location)));
            return location;
        } catch (Throwable unused) {
            return null;
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
            if (com.bytedance.msdk.j.up.cw.xt()) {
                com.bytedance.sdk.component.utils.vl.j(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xt(Context context, Location location) {
        if (xt(location)) {
            l j6 = l.j((String) null, context);
            j6.j("latitude", (float) location.getLatitude());
            j6.j("longitude", (float) location.getLongitude());
            j6.j("lbstime", System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean xt(Location location) {
        return (location.getLatitude() == 0.0d || location.getLongitude() == 0.0d) ? false : true;
    }
}
