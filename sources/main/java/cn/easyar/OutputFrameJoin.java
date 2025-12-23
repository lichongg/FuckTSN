package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("CE7D36DE6")
/* loaded from: D:\Downloads\app\classes2.dex */
public class OutputFrameJoin extends RefBase {
    @MethodId("CFA8847B0")
    public static native OutputFrameJoin create(int inputCount);

    @MethodId("C599C2C88")
    public static native OutputFrameJoin createWithJoiner(int inputCount, FunctorOfOutputFrameFromListOfOutputFrame joiner);

    @MethodId("CC96C6D5B")
    public native OutputFrameSink input(int index);

    @MethodId("CCE5F9BCF")
    public native int inputCount();

    @MethodId("CE0EE8BB5")
    public native OutputFrameSource output();

    protected OutputFrameJoin(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }
}
