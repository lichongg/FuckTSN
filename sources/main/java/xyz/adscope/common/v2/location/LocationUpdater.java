package xyz.adscope.common.v2.location;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import com.kuaishou.weapon.p0.g;
import com.stub.StubApp;
import com.umeng.socialize.common.SocializeConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import xyz.adscope.common.v2.dev.info.PermissionUtil;
import xyz.adscope.common.v2.location.ILocation;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
class LocationUpdater implements ILocationHolder {
    private final Context mContext;
    private ILocation mLocalLocation;
    private boolean mUpdatePermissionGranted = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.v2.location.LocationUpdater$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class LastKnownLocation implements ILocation {
        private final Location mLastKnownLocation;

        /* synthetic */ LastKnownLocation(Location location, AnonymousClass1 anonymousClass1) {
            this(location);
        }

        private LastKnownLocation(Location location) {
            this.mLastKnownLocation = location;
        }

        @Override // xyz.adscope.common.v2.location.ILocation
        public ILocation.CoordinateType getCoordinateType() {
            return ILocation.CoordinateType.WGS_84;
        }

        @Override // xyz.adscope.common.v2.location.ILocation
        public double getLatitude() {
            return this.mLastKnownLocation.getLatitude();
        }

        @Override // xyz.adscope.common.v2.location.ILocation
        public long getLocationTimestamp() {
            return this.mLastKnownLocation.getTime();
        }

        @Override // xyz.adscope.common.v2.location.ILocation
        public double getLongitude() {
            return this.mLastKnownLocation.getLongitude();
        }
    }

    @Override // xyz.adscope.common.v2.location.ILocationHolder
    public void updatePermissionGranted() {
        this.mUpdatePermissionGranted = true;
    }

    private boolean isPermissionGranted() {
        Context context = this.mContext;
        if (context != null) {
            return PermissionUtil.isPermissionGranted(context, g.f36047g) || PermissionUtil.isPermissionGranted(this.mContext, g.f36048h);
        }
        return false;
    }

    @Override // xyz.adscope.common.v2.location.ILocationHolder
    @SuppressLint({"MissingPermission"})
    public ILocation getLastKnownLocation() {
        android.location.LocationManager locationManager;
        if (this.mUpdatePermissionGranted && isPermissionGranted() && (locationManager = (android.location.LocationManager) this.mContext.getSystemService(SocializeConstants.KEY_LOCATION)) != null) {
            List<String> providers = locationManager.getProviders(true);
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = providers.iterator();
            while (it.hasNext()) {
                Location lastKnownLocation = locationManager.getLastKnownLocation(it.next());
                if (lastKnownLocation != null) {
                    arrayList.add(lastKnownLocation);
                }
            }
            if (!arrayList.isEmpty()) {
                Collections.sort(arrayList, new Comparator() { // from class: xyz.adscope.common.v2.location.a
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        int compare;
                        compare = Long.compare(((Location) obj2).getTime(), ((Location) obj).getTime());
                        return compare;
                    }
                });
                return new LastKnownLocation((Location) arrayList.get(0), null);
            }
        }
        return this.mLocalLocation;
    }

    @Override // xyz.adscope.common.v2.location.ILocationHolder
    public void setLocalLocation(ILocation iLocation) {
        this.mLocalLocation = iLocation;
    }

    LocationUpdater(Context context) {
        this.mContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }
}
