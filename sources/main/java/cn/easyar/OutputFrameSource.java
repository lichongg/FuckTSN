package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("C974CE6F8")
/* loaded from: D:\Downloads\app\classes2.dex */
public class OutputFrameSource extends RefBase {
    @MethodId("C5A638A12")
    public native void connect(OutputFrameSink sink);

    @MethodId("C4F935A0F")
    public native void disconnect();

    @MethodId("C29A51425")
    public native void setHandler(FunctorOfVoidFromOutputFrame handler);

    protected OutputFrameSource(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }
}
