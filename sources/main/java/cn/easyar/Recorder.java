package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("CB984D066")
/* loaded from: D:\Downloads\app\classes2.dex */
public class Recorder extends RefBase {
    @MethodId("CFA8847B0")
    public static native Recorder create(RecorderConfiguration config, CallbackScheduler callbackScheduler, FunctorOfVoidFromRecordStatusAndString statusCallback);

    @MethodId("CE93DF2A9")
    public static native boolean isAvailable();

    @MethodId("CBC9350A1")
    public static native void requestPermissions(CallbackScheduler callbackScheduler, FunctorOfVoidFromPermissionStatusAndString permissionCallback);

    @MethodId("CCCED28C6")
    public native void start();

    @MethodId("C6C45CB72")
    public native boolean stop();

    @MethodId("C14F3B6CB")
    public native void updateFrame(TextureId texture, int width, int height);

    protected Recorder(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }
}
