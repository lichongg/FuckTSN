package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("C8B9155BE")
/* loaded from: D:\Downloads\app\classes2.dex */
public class OutputFrameFork extends RefBase {
    @MethodId("CFA8847B0")
    public static native OutputFrameFork create(int outputCount);

    @MethodId("CC96C6D5B")
    public native OutputFrameSink input();

    @MethodId("CE0EE8BB5")
    public native OutputFrameSource output(int index);

    @MethodId("C1856628F")
    public native int outputCount();

    protected OutputFrameFork(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }
}
