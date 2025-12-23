package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("C2A2A6989")
/* loaded from: D:\Downloads\app\classes2.dex */
public class SparseSpatialMapManager extends RefBase {
    @MethodId("CFA8847B0")
    public static native SparseSpatialMapManager create();

    @MethodId("CE93DF2A9")
    public static native boolean isAvailable();

    @MethodId("C913A4CB9")
    public native void clear();

    @MethodId("C4740AE63")
    public native void host(SparseSpatialMap mapBuilder, String apiKey, String apiSecret, String sparseSpatialMapAppId, String name, Image preview, Integer timeoutMilliseconds, CallbackScheduler callbackScheduler, FunctorOfVoidFromBoolAndStringAndString onCompleted);

    @MethodId("C0CF67FC7")
    public native void load(SparseSpatialMap mapTracker, String serverMapId, String apiKey, String apiSecret, String sparseSpatialMapAppId, Integer timeoutMilliseconds, CallbackScheduler callbackScheduler, FunctorOfVoidFromBoolAndString onCompleted);

    protected SparseSpatialMapManager(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }
}
