package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("C91DC6AEC")
/* loaded from: D:\Downloads\app\classes2.dex */
public class FeedbackFrameFork extends RefBase {
    @MethodId("CFA8847B0")
    public static native FeedbackFrameFork create(int outputCount);

    @MethodId("CC96C6D5B")
    public native FeedbackFrameSink input();

    @MethodId("CE0EE8BB5")
    public native FeedbackFrameSource output(int index);

    @MethodId("C1856628F")
    public native int outputCount();

    protected FeedbackFrameFork(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }
}
