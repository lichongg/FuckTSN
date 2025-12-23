package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("CE25B559B")
/* loaded from: D:\Downloads\app\classes2.dex */
public class CloudRecognizer extends RefBase {
    @MethodId("CFA8847B0")
    public static native CloudRecognizer create(String cloudRecognitionServiceServerAddress, String apiKey, String apiSecret, String cloudRecognitionServiceAppId);

    @MethodId("CEBE82622")
    public static native CloudRecognizer createByCloudSecret(String cloudRecognitionServiceServerAddress, String cloudRecognitionServiceSecret, String cloudRecognitionServiceAppId);

    @MethodId("CE93DF2A9")
    public static native boolean isAvailable();

    @MethodId("C310FF200")
    public native void close();

    @MethodId("CFDF09CDF")
    public native void resolve(InputFrame inputFrame, Integer timeoutMilliseconds, CallbackScheduler callbackScheduler, FunctorOfVoidFromCloudRecognizationResult callback);

    protected CloudRecognizer(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }
}
