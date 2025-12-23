package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("CC518D759")
/* loaded from: D:\Downloads\app\classes2.dex */
public class FeedbackFrame extends RefBase {
    protected FeedbackFrame(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }

    @MethodId("CD33483F0")
    private static native long _ctor(InputFrame inputFrame, OutputFrame previousOutputFrame);

    @MethodId("C2B2479BA")
    public native InputFrame inputFrame();

    @MethodId("C8C903C25")
    public native OutputFrame previousOutputFrame();

    public FeedbackFrame(InputFrame inputFrame, OutputFrame previousOutputFrame) {
        super(_ctor(inputFrame, previousOutputFrame), null);
    }
}
