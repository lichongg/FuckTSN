package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("C66C032BA")
/* loaded from: D:\Downloads\app\classes2.dex */
public class ARCoreDeviceListDownloader extends RefBase {
    protected ARCoreDeviceListDownloader(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }

    @MethodId("CD33483F0")
    private static native long _ctor();

    @MethodId("C68FF63FB")
    public native void download(Integer timeoutMilliseconds, CallbackScheduler callbackScheduler, FunctorOfVoidFromARCoreDeviceListDownloadStatusAndOptionalOfString onCompleted);

    public ARCoreDeviceListDownloader() {
        super(_ctor(), null);
    }
}
