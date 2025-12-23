package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("C21E49EB2")
/* loaded from: D:\Downloads\app\classes2.dex */
public class Log {
    @MethodId("C62278C32")
    public static native void resetLogFunc();

    @MethodId("CD5C6203B")
    public static native void setLogFunc(FunctorOfVoidFromLogLevelAndString func);

    @MethodId("C060C1415")
    public static native void setLogFuncWithScheduler(CallbackScheduler scheduler, FunctorOfVoidFromLogLevelAndString func);
}
