package cn.easyar;

import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("C229B93BA")
/* loaded from: D:\Downloads\app\classes2.dex */
public class MotionTrackerCameraDevice extends RefBase {
    protected MotionTrackerCameraDevice(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }

    @MethodId("CD33483F0")
    private static native long _ctor();

    @MethodId("C2F3B483E")
    public static native int getQualityLevel();

    @MethodId("CE93DF2A9")
    public static native boolean isAvailable();

    @MethodId("C0D416B9B")
    public native int bufferCapacity();

    @MethodId("C310FF200")
    public native void close();

    @MethodId("C4D1C55A1")
    public native ArrayList<o0> getLocalPointsCloud();

    @MethodId("CD0ED2B69")
    public native ArrayList<o0> hitTestAgainstHorizontalPlane(Vec2F cameraImagePoint);

    @MethodId("C222BD61E")
    public native ArrayList<o0> hitTestAgainstPointCloud(Vec2F cameraImagePoint);

    @MethodId("CDB9FF390")
    public native InputFrameSource inputFrameSource();

    @MethodId("C01B65F19")
    public native int inputFrameSourceType();

    @MethodId("C657F58C2")
    public native void setBufferCapacity(int capacity);

    @MethodId("CA6771E58")
    public native boolean setFocusMode(int focusMode);

    @MethodId("CACACABA2")
    public native boolean setFrameRateType(int fps);

    @MethodId("C21BB4788")
    public native boolean setFrameResolutionType(int resolution);

    @MethodId("CF873EA5A")
    public native boolean setTrackingMode(int trackingMode);

    @MethodId("CCCED28C6")
    public native boolean start();

    @MethodId("C6C45CB72")
    public native void stop();

    public MotionTrackerCameraDevice() {
        super(_ctor(), null);
    }
}
