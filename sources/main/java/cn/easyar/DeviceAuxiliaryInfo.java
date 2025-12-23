package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("C3AAB0B73")
/* loaded from: D:\Downloads\app\classes2.dex */
public class DeviceAuxiliaryInfo extends RefBase {
    @MethodId("CFA8847B0")
    public static native DeviceAuxiliaryInfo create();

    @MethodId("C8CE39611")
    public native void setAcceleration(AccelerometerResult acce);

    @MethodId("CEBD284B9")
    public native void setECompass(double northHeading, double headingAccuracy);

    @MethodId("CADCA3743")
    public native void setGPSLocation(LocationResult gps);

    @MethodId("CE555D1D2")
    public native void setProximityLocation(ProximityLocationResult proximity);

    protected DeviceAuxiliaryInfo(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }
}
