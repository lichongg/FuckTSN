package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("C163805D9")
/* loaded from: D:\Downloads\app\classes2.dex */
public class InputFramePlayer extends RefBase {
    @MethodId("CFA8847B0")
    public static native InputFramePlayer create();

    @MethodId("CCCE1F55E")
    public native double currentTime();

    @MethodId("C6BEDFE53")
    public native int initalScreenRotation();

    @MethodId("C3B43E764")
    public native boolean isCompleted();

    @MethodId("CE0EE8BB5")
    public native InputFrameSource output();

    @MethodId("C6210C0BF")
    public native void pause();

    @MethodId("CA83A3132")
    public native boolean resume();

    @MethodId("CCCED28C6")
    public native boolean start(String filePath);

    @MethodId("C6C45CB72")
    public native void stop();

    @MethodId("C0697B6B5")
    public native double totalTime();

    protected InputFramePlayer(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }
}
