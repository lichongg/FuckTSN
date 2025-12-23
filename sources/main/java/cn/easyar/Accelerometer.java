package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("C814FB55D")
/* loaded from: D:\Downloads\app\classes2.dex */
public class Accelerometer extends RefBase {
    protected Accelerometer(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }

    @MethodId("CD33483F0")
    private static native long _ctor();

    @MethodId("C310FF200")
    public native void close();

    @MethodId("C06C2D301")
    public native AccelerometerResult getCurrentResult();

    @MethodId("CE93DF2A9")
    public native boolean isAvailable();

    @MethodId("C2348F998")
    public native boolean open();

    @MethodId("C835F60A9")
    public native boolean openWithSamplingPeriod(int samplingPeriodMilliseconds);

    @MethodId("CE0EE8BB5")
    public native AccelerometerResultSource output();

    public Accelerometer() {
        super(_ctor(), null);
    }
}
