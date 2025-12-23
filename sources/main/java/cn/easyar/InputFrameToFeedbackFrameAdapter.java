package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("C7A4A3390")
/* loaded from: D:\Downloads\app\classes2.dex */
public class InputFrameToFeedbackFrameAdapter extends RefBase {
    @MethodId("CFA8847B0")
    public static native InputFrameToFeedbackFrameAdapter create();

    @MethodId("C5DE59913")
    public native int bufferRequirement();

    @MethodId("CC96C6D5B")
    public native InputFrameSink input();

    @MethodId("CE0EE8BB5")
    public native FeedbackFrameSource output();

    @MethodId("C92139225")
    public native OutputFrameSink sideInput();

    protected InputFrameToFeedbackFrameAdapter(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }
}
