package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("C339A566A")
/* loaded from: D:\Downloads\app\classes2.dex */
public class CloudRecognizationResult extends RefBase {
    @MethodId("C62197BF2")
    public native int getStatus();

    @MethodId("CD6010142")
    public native ImageTarget getTarget();

    @MethodId("C3A667572")
    public native String getUnknownErrorMessage();

    protected CloudRecognizationResult(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }
}
