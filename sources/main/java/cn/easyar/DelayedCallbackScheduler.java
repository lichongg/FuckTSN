package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("C2C887208")
/* loaded from: D:\Downloads\app\classes2.dex */
public class DelayedCallbackScheduler extends CallbackScheduler {
    protected DelayedCallbackScheduler(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }

    @MethodId("CD33483F0")
    private static native long _ctor();

    @MethodId("CE47BD04B")
    public native boolean runOne();

    public DelayedCallbackScheduler() {
        super(_ctor(), null);
    }
}
