package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("C539B1D1D")
/* loaded from: D:\Downloads\app\classes2.dex */
public class MegaTracker extends RefBase {
    @MethodId("CFA8847B0")
    public static native MegaTracker create(String server, String apiKey, String apiSecret, String appId);

    @MethodId("CE93DF2A9")
    public static native boolean isAvailable();

    @MethodId("C2FB61C05")
    public native AccelerometerResultSink accelerometerResultSink();

    @MethodId("C5DE59913")
    public native int bufferRequirement();

    @MethodId("C310FF200")
    public native void close();

    @MethodId("CB6A3E444")
    public native InputFrameSink inputFrameSink();

    @MethodId("CB25B2010")
    public native LocationResultSink locationResultSink();

    @MethodId("C5868A777")
    public native OutputFrameSource outputFrameSource();

    @MethodId("CAC35FF74")
    public native ProximityLocationResultSink proximityLocationResultSink();

    @MethodId("C01BE30BB")
    public native void reset();

    @MethodId("C2F76A5F5")
    public native void setInputFrameSourceType(int type);

    @MethodId("C54585498")
    public native void setLocalizationCallback(CallbackScheduler callbackScheduler, FunctorOfVoidFromMegaTrackerLocalizationResponse callback);

    @MethodId("C50B01E06")
    public native void setRequestMessage(String message);

    @MethodId("C8CB77031")
    public native void setRequestTimeParameters(Integer timeoutMilliseconds, int requestIntervalMilliseconds);

    @MethodId("C00AC221A")
    public native void setResultPoseType(boolean enableLocalization, boolean enableStabilization);

    @MethodId("CCCED28C6")
    public native boolean start();

    @MethodId("C6C45CB72")
    public native void stop();

    protected MegaTracker(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }
}
