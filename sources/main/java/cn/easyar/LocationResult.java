package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("CEF755FEA")
/* loaded from: D:\Downloads\app\classes2.dex */
public class LocationResult {
    public double altitude;
    public boolean hasAltitude;
    public boolean hasHorizontalAccuracy;
    public boolean hasVerticalAccuracy;
    public double horizontalAccuracy;
    public double latitude;
    public double longitude;
    public double verticalAccuracy;

    public LocationResult() {
    }

    public LocationResult(double latitude, double longitude, double altitude, double horizontalAccuracy, double verticalAccuracy, boolean hasAltitude, boolean hasHorizontalAccuracy, boolean hasVerticalAccuracy) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.horizontalAccuracy = horizontalAccuracy;
        this.verticalAccuracy = verticalAccuracy;
        this.hasAltitude = hasAltitude;
        this.hasHorizontalAccuracy = hasHorizontalAccuracy;
        this.hasVerticalAccuracy = hasVerticalAccuracy;
    }
}
