package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("CA7961F06")
/* loaded from: D:\Downloads\app\classes2.dex */
public class CameraDevice extends RefBase {
    protected CameraDevice(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }

    @MethodId("CD33483F0")
    private static native long _ctor();

    @MethodId("CE9310E04")
    public static native int cameraCount();

    @MethodId("CE93DF2A9")
    public static native boolean isAvailable();

    @MethodId("CBC9350A1")
    public static native void requestPermissions(CallbackScheduler callbackScheduler, FunctorOfVoidFromPermissionStatusAndString permissionCallback);

    @MethodId("CEB864E2A")
    public native int androidCameraApiType();

    @MethodId("C52AA90E6")
    public native boolean autoFocus();

    @MethodId("C0D416B9B")
    public native int bufferCapacity();

    @MethodId("C4DC3D319")
    public native CameraParameters cameraParameters();

    @MethodId("C310FF200")
    public native void close();

    @MethodId("C13B416EC")
    public native int frameRateRange();

    @MethodId("C1BC04B52")
    public native int index();

    @MethodId("CDB9FF390")
    public native InputFrameSource inputFrameSource();

    @MethodId("C01B65F19")
    public native int inputFrameSourceType();

    @MethodId("C187EBCC0")
    public native boolean openWithIndex(int cameraIndex);

    @MethodId("CCC267338")
    public native boolean openWithPreferredType(int type);

    @MethodId("C002D72C8")
    public native boolean openWithSpecificType(int type);

    @MethodId("C1B5B4008")
    public native void setAndroidCameraApiType(int type);

    @MethodId("C657F58C2")
    public native void setBufferCapacity(int capacity);

    @MethodId("CDD2BA271")
    public native void setCameraParameters(CameraParameters cameraParameters);

    @MethodId("CC849C9FE")
    public native boolean setFlashTorchMode(boolean on);

    @MethodId("CA6771E58")
    public native boolean setFocusMode(int focusMode);

    @MethodId("C360D21E6")
    public native boolean setFrameRateRange(int index);

    @MethodId("CCF2FAFCE")
    public native boolean setSize(Vec2I size);

    @MethodId("C630C5DD1")
    public native void setStateChangedCallback(CallbackScheduler callbackScheduler, FunctorOfVoidFromCameraState stateChangedCallback);

    @MethodId("CCCDCBE84")
    public native Vec2I size();

    @MethodId("CCCED28C6")
    public native boolean start();

    @MethodId("C6C45CB72")
    public native void stop();

    @MethodId("CB1A33B20")
    public native int supportedFrameRateRangeCount();

    @MethodId("CAC4E30F2")
    public native float supportedFrameRateRangeLower(int index);

    @MethodId("C1A35B3B6")
    public native float supportedFrameRateRangeUpper(int index);

    @MethodId("C1ADD38F9")
    public native Vec2I supportedSize(int index);

    @MethodId("C1065E475")
    public native int supportedSizeCount();

    @MethodId("C1303C06B")
    public native int type();

    public CameraDevice() {
        super(_ctor(), null);
    }
}
