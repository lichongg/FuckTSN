package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("CCBF9567D")
/* loaded from: D:\Downloads\app\classes2.dex */
public class OutputFrameBuffer extends RefBase {
    @MethodId("CFA8847B0")
    public static native OutputFrameBuffer create();

    @MethodId("C5DE59913")
    public native int bufferRequirement();

    @MethodId("CC96C6D5B")
    public native OutputFrameSink input();

    @MethodId("C6210C0BF")
    public native void pause();

    @MethodId("C1CE8980E")
    public native OutputFrame peek();

    @MethodId("CA83A3132")
    public native void resume();

    @MethodId("CCE9B14BA")
    public native SignalSource signalOutput();

    protected OutputFrameBuffer(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }
}
