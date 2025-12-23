package androidx.core.location;

import android.location.GnssStatus;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(24)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\Downloads\app\classes.dex */
class GnssStatusWrapper extends GnssStatusCompat {
    private final GnssStatus mWrapped;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static float getCarrierFrequencyHz(GnssStatus gnssStatus, int i6) {
            return gnssStatus.getCarrierFrequencyHz(i6);
        }

        @DoNotInline
        static boolean hasCarrierFrequencyHz(GnssStatus gnssStatus, int i6) {
            return gnssStatus.hasCarrierFrequencyHz(i6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(30)
    static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        static float getBasebandCn0DbHz(GnssStatus gnssStatus, int i6) {
            return gnssStatus.getBasebandCn0DbHz(i6);
        }

        @DoNotInline
        static boolean hasBasebandCn0DbHz(GnssStatus gnssStatus, int i6) {
            return gnssStatus.hasBasebandCn0DbHz(i6);
        }
    }

    public boolean equals(Object obj) {
        boolean equals;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GnssStatusWrapper)) {
            return false;
        }
        equals = this.mWrapped.equals(((GnssStatusWrapper) obj).mWrapped);
        return equals;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getAzimuthDegrees(int i6) {
        float azimuthDegrees;
        azimuthDegrees = this.mWrapped.getAzimuthDegrees(i6);
        return azimuthDegrees;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getBasebandCn0DbHz(int i6) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getBasebandCn0DbHz(this.mWrapped, i6);
        }
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCarrierFrequencyHz(int i6) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getCarrierFrequencyHz(this.mWrapped, i6);
        }
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCn0DbHz(int i6) {
        float cn0DbHz;
        cn0DbHz = this.mWrapped.getCn0DbHz(i6);
        return cn0DbHz;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getConstellationType(int i6) {
        int constellationType;
        constellationType = this.mWrapped.getConstellationType(i6);
        return constellationType;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getElevationDegrees(int i6) {
        float elevationDegrees;
        elevationDegrees = this.mWrapped.getElevationDegrees(i6);
        return elevationDegrees;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSatelliteCount() {
        int satelliteCount;
        satelliteCount = this.mWrapped.getSatelliteCount();
        return satelliteCount;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSvid(int i6) {
        int svid;
        svid = this.mWrapped.getSvid(i6);
        return svid;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasAlmanacData(int i6) {
        boolean hasAlmanacData;
        hasAlmanacData = this.mWrapped.hasAlmanacData(i6);
        return hasAlmanacData;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasBasebandCn0DbHz(int i6) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.hasBasebandCn0DbHz(this.mWrapped, i6);
        }
        return false;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasCarrierFrequencyHz(int i6) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.hasCarrierFrequencyHz(this.mWrapped, i6);
        }
        return false;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasEphemerisData(int i6) {
        boolean hasEphemerisData;
        hasEphemerisData = this.mWrapped.hasEphemerisData(i6);
        return hasEphemerisData;
    }

    public int hashCode() {
        int hashCode;
        hashCode = this.mWrapped.hashCode();
        return hashCode;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean usedInFix(int i6) {
        boolean usedInFix;
        usedInFix = this.mWrapped.usedInFix(i6);
        return usedInFix;
    }

    GnssStatusWrapper(Object obj) {
        this.mWrapped = d.a(Preconditions.checkNotNull(d.a(obj)));
    }
}
