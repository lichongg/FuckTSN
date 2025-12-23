package androidx.core.location;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.os.Build;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import com.kwad.components.offline.api.IOfflineCompo;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\Downloads\app\classes.dex */
class GpsStatusWrapper extends GnssStatusCompat {
    private static final int BEIDOU_PRN_COUNT = 35;
    private static final int BEIDOU_PRN_OFFSET = 200;
    private static final int GLONASS_PRN_COUNT = 24;
    private static final int GLONASS_PRN_OFFSET = 64;
    private static final int GPS_PRN_COUNT = 32;
    private static final int GPS_PRN_OFFSET = 0;
    private static final int QZSS_SVID_MAX = 200;
    private static final int QZSS_SVID_MIN = 193;
    private static final int SBAS_PRN_MAX = 64;
    private static final int SBAS_PRN_MIN = 33;
    private static final int SBAS_PRN_OFFSET = -87;

    @GuardedBy("mWrapped")
    private Iterator<GpsSatellite> mCachedIterator;

    @GuardedBy("mWrapped")
    private int mCachedIteratorPosition;

    @GuardedBy("mWrapped")
    private GpsSatellite mCachedSatellite;

    @GuardedBy("mWrapped")
    private int mCachedSatelliteCount;
    private final GpsStatus mWrapped;

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasBasebandCn0DbHz(int i6) {
        return false;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasCarrierFrequencyHz(int i6) {
        return false;
    }

    private static int getConstellationFromPrn(int i6) {
        if (i6 > 0 && i6 <= 32) {
            return 1;
        }
        if (i6 >= 33 && i6 <= 64) {
            return 2;
        }
        if (i6 > 64 && i6 <= 88) {
            return 3;
        }
        if (i6 <= 200 || i6 > 235) {
            return (i6 < 193 || i6 > 200) ? 0 : 4;
        }
        return 5;
    }

    private GpsSatellite getSatellite(int i6) {
        GpsSatellite gpsSatellite;
        synchronized (this.mWrapped) {
            try {
                if (i6 < this.mCachedIteratorPosition) {
                    this.mCachedIterator = this.mWrapped.getSatellites().iterator();
                    this.mCachedIteratorPosition = -1;
                }
                while (true) {
                    int i7 = this.mCachedIteratorPosition;
                    if (i7 >= i6) {
                        break;
                    }
                    this.mCachedIteratorPosition = i7 + 1;
                    if (!this.mCachedIterator.hasNext()) {
                        this.mCachedSatellite = null;
                        break;
                    }
                    this.mCachedSatellite = this.mCachedIterator.next();
                }
                gpsSatellite = this.mCachedSatellite;
            } catch (Throwable th) {
                throw th;
            }
        }
        return (GpsSatellite) Preconditions.checkNotNull(gpsSatellite);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GpsStatusWrapper) {
            return this.mWrapped.equals(((GpsStatusWrapper) obj).mWrapped);
        }
        return false;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getBasebandCn0DbHz(int i6) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCarrierFrequencyHz(int i6) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getConstellationType(int i6) {
        if (Build.VERSION.SDK_INT < 24) {
            return 1;
        }
        return getConstellationFromPrn(getSatellite(i6).getPrn());
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSatelliteCount() {
        int i6;
        synchronized (this.mWrapped) {
            try {
                if (this.mCachedSatelliteCount == -1) {
                    for (GpsSatellite gpsSatellite : this.mWrapped.getSatellites()) {
                        this.mCachedSatelliteCount++;
                    }
                    this.mCachedSatelliteCount++;
                }
                i6 = this.mCachedSatelliteCount;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i6;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSvid(int i6) {
        return Build.VERSION.SDK_INT < 24 ? getSatellite(i6).getPrn() : getSvidFromPrn(getSatellite(i6).getPrn());
    }

    public int hashCode() {
        return this.mWrapped.hashCode();
    }

    GpsStatusWrapper(GpsStatus gpsStatus) {
        GpsStatus gpsStatus2 = (GpsStatus) Preconditions.checkNotNull(gpsStatus);
        this.mWrapped = gpsStatus2;
        this.mCachedSatelliteCount = -1;
        this.mCachedIterator = gpsStatus2.getSatellites().iterator();
        this.mCachedIteratorPosition = -1;
        this.mCachedSatellite = null;
    }

    private static int getSvidFromPrn(int i6) {
        int constellationFromPrn = getConstellationFromPrn(i6);
        if (constellationFromPrn != 2) {
            if (constellationFromPrn != 3) {
                if (constellationFromPrn != 5) {
                    return i6;
                }
                return i6 + IOfflineCompo.Priority.HIGHEST;
            }
            return i6 - 64;
        }
        return i6 + 87;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getAzimuthDegrees(int i6) {
        return getSatellite(i6).getAzimuth();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCn0DbHz(int i6) {
        return getSatellite(i6).getSnr();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getElevationDegrees(int i6) {
        return getSatellite(i6).getElevation();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasAlmanacData(int i6) {
        return getSatellite(i6).hasAlmanac();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasEphemerisData(int i6) {
        return getSatellite(i6).hasEphemeris();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean usedInFix(int i6) {
        return getSatellite(i6).usedInFix();
    }
}
