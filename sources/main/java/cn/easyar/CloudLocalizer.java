package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("C97824B76")
/* loaded from: D:\Downloads\app\classes2.dex */
public class CloudLocalizer extends RefBase {
    @MethodId("CFA8847B0")
    public static native CloudLocalizer create(String server, String apiKey, String apiSecret, String appId);

    @MethodId("CE93DF2A9")
    public static native boolean isAvailable();

    @MethodId("C310FF200")
    public native void close();

    @MethodId("CFDF09CDF")
    public native void resolve(InputFrame inputFrame, String message, DeviceAuxiliaryInfo deviceAuxInfo, Integer timeoutMilliseconds, CallbackScheduler callbackScheduler, FunctorOfVoidFromCloudLocalizerResult callback);

    protected CloudLocalizer(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }
}
