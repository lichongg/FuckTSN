package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.kwad.sdk.service.ServiceProvider;
import com.umeng.socialize.common.SocializeConstants;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class x {
    private static boolean aZq;
    private static com.kwad.sdk.utils.c.a aZr = new com.kwad.sdk.utils.c.a();

    @SuppressLint({"MissingPermission"})
    private static com.kwad.sdk.internal.api.a a(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f36047g) != 0) {
                return null;
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation(GeocodeSearch.GPS);
            if (lastKnownLocation == null) {
                aZq = true;
            }
            return com.kwad.sdk.internal.api.a.a(lastKnownLocation);
        } catch (Exception e6) {
            aZq = true;
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    private static com.kwad.sdk.internal.api.a b(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f36047g) != 0 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f36048h) != 0) {
                return null;
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation("network");
            if (lastKnownLocation == null) {
                aZq = true;
            }
            return com.kwad.sdk.internal.api.a.a(lastKnownLocation);
        } catch (Exception e6) {
            aZq = true;
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    private static com.kwad.sdk.internal.api.a c(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f36048h) != 0) {
                return null;
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation("passive");
            if (lastKnownLocation == null) {
                aZq = true;
            }
            return com.kwad.sdk.internal.api.a.a(lastKnownLocation);
        } catch (Exception e6) {
            aZq = true;
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
            return null;
        }
    }

    @Nullable
    public static com.kwad.sdk.utils.c.a cL(Context context) {
        com.kwad.sdk.utils.c.a aVar;
        com.kwad.sdk.internal.api.a Ro;
        com.kwad.sdk.utils.c.a aVar2 = new com.kwad.sdk.utils.c.a();
        if (bc.readLocationDisable() && (Ro = bc.Ro()) != null) {
            aVar2.bcT = Ro;
            aVar2.type = 1;
            return aVar2;
        }
        if (aZq || (!((aVar = aZr) == null || aVar.bcT == null) || context == null)) {
            return aZr;
        }
        if (!bc.readLocationDisable() && !((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(64L)) {
            try {
                LocationManager locationManager = (LocationManager) context.getSystemService(SocializeConstants.KEY_LOCATION);
                if (locationManager.isProviderEnabled(GeocodeSearch.GPS)) {
                    aZr.bcT = a(context, locationManager);
                }
                if (aZr == null && locationManager.isProviderEnabled("network")) {
                    aZr.bcT = b(context, locationManager);
                }
                if (aZr == null && locationManager.isProviderEnabled("passive")) {
                    aZr.bcT = c(context, locationManager);
                }
                com.kwad.sdk.utils.c.a aVar3 = aZr;
                aVar3.type = 0;
                return aVar3;
            } catch (Exception e6) {
                aZq = true;
                com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
            }
        }
        return null;
    }
}
