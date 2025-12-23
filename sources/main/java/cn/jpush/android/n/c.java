package cn.jpush.android.n;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.work.WorkRequest;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.kuaishou.weapon.p0.g;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static long f3713a;

    @SuppressLint({"MissingPermission"})
    public static Location a(Context context, LocationManager locationManager, boolean z5) {
        boolean z6 = !z5 || System.currentTimeMillis() - f3713a < WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        if (locationManager == null || !a(context, locationManager) || !z6) {
            return null;
        }
        f3713a = System.currentTimeMillis();
        Location lastKnownLocation = locationManager.getLastKnownLocation(GeocodeSearch.GPS);
        Location lastKnownLocation2 = locationManager.getLastKnownLocation("network");
        Location lastKnownLocation3 = locationManager.getLastKnownLocation("passive");
        Logger.v("GeoLocHelper", "gpsLocation:" + lastKnownLocation);
        Logger.v("GeoLocHelper", "netLocation:" + lastKnownLocation2);
        Logger.v("GeoLocHelper", "passLocation:" + lastKnownLocation3);
        long time = lastKnownLocation == null ? 0L : lastKnownLocation.getTime();
        long time2 = lastKnownLocation2 == null ? 0L : lastKnownLocation2.getTime();
        long time3 = lastKnownLocation3 != null ? lastKnownLocation3.getTime() : 0L;
        if (time > time2) {
            if (time > time3) {
                return lastKnownLocation;
            }
        } else if (time2 > time3) {
            return lastKnownLocation2;
        }
        return lastKnownLocation3;
    }

    public static boolean a(Context context, LocationManager locationManager) {
        if (!cn.jpush.android.ad.a.a(context, g.f36047g)) {
            Logger.w("GeoLocHelper", "Require the permissionandroid.permission.ACCESS_FINE_LOCATION");
            Logger.dd("GeoLocHelper", "No location permission!");
            return false;
        }
        if (!JPushConstants.canGetLbsInBackGround(context)) {
            Logger.ww("GeoLocHelper", "can not get lbs in background");
            return false;
        }
        if (!JCoreHelper.geoEnable(context)) {
            Logger.ww("GeoLocHelper", "lbs is disable by user");
            return false;
        }
        if (locationManager != null) {
            try {
                if (locationManager.isProviderEnabled(GeocodeSearch.GPS) || locationManager.isProviderEnabled("network")) {
                    return true;
                }
                return locationManager.isProviderEnabled("passive");
            } catch (IllegalArgumentException unused) {
                Logger.ww("GeoLocHelper", "The provider [gps] is illegal argument!");
                return false;
            } catch (SecurityException unused2) {
                Logger.ww("GeoLocHelper", "No suitable permission is present when get GPS_PROVIDER!");
            } catch (Throwable th) {
                Logger.ww("GeoLocHelper", "Check GPS enable failed:" + th);
                return false;
            }
        }
        return false;
    }
}
