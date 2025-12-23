package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("CEC2B9D1C")
/* loaded from: D:\Downloads\app\classes2.dex */
public class ARKitCameraDevice extends RefBase {
    protected ARKitCameraDevice(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }

    @MethodId("CD33483F0")
    private static native long _ctor();

    @MethodId("CE93DF2A9")
    public static native boolean isAvailable();

    @MethodId("C0D416B9B")
    public native int bufferCapacity();

    @MethodId("C310FF200")
    public native void close();

    @MethodId("CDB9FF390")
    public native InputFrameSource inputFrameSource();

    @MethodId("C01B65F19")
    public native int inputFrameSourceType();

    @MethodId("C657F58C2")
    public native void setBufferCapacity(int capacity);

    @MethodId("CA6771E58")
    public native void setFocusMode(int focusMode);

    @MethodId("CCCED28C6")
    public native boolean start();

    @MethodId("C6C45CB72")
    public native void stop();

    public ARKitCameraDevice() {
        super(_ctor(), null);
    }
}
