package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("C37C077C9")
/* loaded from: D:\Downloads\app\classes2.dex */
public class SurfaceTracker extends RefBase {
    @MethodId("CFA8847B0")
    public static native SurfaceTracker create();

    @MethodId("CE93DF2A9")
    public static native boolean isAvailable();

    @MethodId("CCF4C4887")
    public native void alignTargetToCameraImagePoint(Vec2F cameraImagePoint);

    @MethodId("C5DE59913")
    public native int bufferRequirement();

    @MethodId("C310FF200")
    public native void close();

    @MethodId("CB6A3E444")
    public native InputFrameSink inputFrameSink();

    @MethodId("C5868A777")
    public native OutputFrameSource outputFrameSource();

    @MethodId("CCCED28C6")
    public native boolean start();

    @MethodId("C6C45CB72")
    public native void stop();

    protected SurfaceTracker(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }
}
