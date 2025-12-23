package com.kwad.sdk.internal.api;

import android.location.Location;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsLocation;
import com.kwad.sdk.core.d.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private double mLatitude = 0.0d;
    private double mLongitude = 0.0d;
    private double mAltitude = 0.0d;
    private float mSpeed = 0.0f;
    private float mBearing = 0.0f;

    @Nullable
    public static a a(Location location) {
        if (location == null) {
            return null;
        }
        a aVar = new a();
        aVar.mLatitude = location.getLatitude();
        aVar.mLongitude = location.getLongitude();
        aVar.mAltitude = location.getAltitude();
        aVar.mSpeed = location.getSpeed();
        aVar.mBearing = location.getBearing();
        return aVar;
    }

    @Nullable
    public static a m(Object obj) {
        try {
            if (!(obj instanceof KsLocation)) {
                return null;
            }
            KsLocation ksLocation = (KsLocation) obj;
            a aVar = new a();
            aVar.mLatitude = ksLocation.getLatitude();
            aVar.mLongitude = ksLocation.getLongitude();
            aVar.mAltitude = ksLocation.getAltitude();
            aVar.mSpeed = ksLocation.getSpeed();
            aVar.mBearing = ksLocation.getBearing();
            return aVar;
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
            return null;
        }
    }

    public final double getLatitude() {
        return this.mLatitude;
    }

    public final double getLongitude() {
        return this.mLongitude;
    }
}
