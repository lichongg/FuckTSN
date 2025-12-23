package xyz.adscope.common.v2.location;

import com.amap.api.location.AMapLocation;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface ILocation {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum CoordinateType {
        WGS_84(AMapLocation.COORD_TYPE_WGS84),
        GCJ_02(AMapLocation.COORD_TYPE_GCJ02),
        BD_09("BD09");

        private final String type;

        public String getType() {
            return this.type;
        }

        CoordinateType(String str) {
            this.type = str;
        }
    }

    CoordinateType getCoordinateType();

    double getLatitude();

    long getLocationTimestamp();

    double getLongitude();
}
