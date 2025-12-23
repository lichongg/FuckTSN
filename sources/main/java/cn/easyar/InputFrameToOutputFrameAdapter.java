package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("C46C9565E")
/* loaded from: D:\Downloads\app\classes2.dex */
public class InputFrameToOutputFrameAdapter extends RefBase {
    @MethodId("CFA8847B0")
    public static native InputFrameToOutputFrameAdapter create();

    @MethodId("CC96C6D5B")
    public native InputFrameSink input();

    @MethodId("CE0EE8BB5")
    public native OutputFrameSource output();

    protected InputFrameToOutputFrameAdapter(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }
}
