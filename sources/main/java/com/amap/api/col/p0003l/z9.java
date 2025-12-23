package com.amap.api.col.p0003l;

import android.location.Location;
import com.amap.api.maps.LocationSource;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
final class z9 implements LocationSource.OnLocationChangedListener {

    /* renamed from: a, reason: collision with root package name */
    private IAMapDelegate f7830a;

    /* renamed from: b, reason: collision with root package name */
    Location f7831b;

    @Override // com.amap.api.maps.LocationSource.OnLocationChangedListener
    public final void onLocationChanged(Location location) {
        this.f7831b = location;
        try {
            if (this.f7830a.isMyLocationEnabled()) {
                this.f7830a.showMyLocationOverlay(location);
            }
        } catch (Throwable th) {
            v5.p(th, "AMapOnLocationChangedListener", "onLocationChanged");
            th.printStackTrace();
        }
    }

    z9(IAMapDelegate iAMapDelegate) {
        this.f7830a = iAMapDelegate;
    }
}
