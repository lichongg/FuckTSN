package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("C7D6F4831")
/* loaded from: D:\Downloads\app\classes2.dex */
public class InputFrameRecorder extends RefBase {
    @MethodId("CFA8847B0")
    public static native InputFrameRecorder create();

    @MethodId("C5DE59913")
    public native int bufferRequirement();

    @MethodId("CC96C6D5B")
    public native InputFrameSink input();

    @MethodId("CE0EE8BB5")
    public native InputFrameSource output();

    @MethodId("CCCED28C6")
    public native boolean start(String filePath, int initialScreenRotation);

    @MethodId("C6C45CB72")
    public native void stop();

    protected InputFrameRecorder(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }
}
