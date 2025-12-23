package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("C4BC8185A")
/* loaded from: D:\Downloads\app\classes2.dex */
public class InputFrame extends RefBase {
    @MethodId("CFA8847B0")
    public static native InputFrame create(Image image, CameraParameters cameraParameters, double timestamp, Matrix44F cameraTransform, int trackingStatus);

    @MethodId("C1DFA11DA")
    public static native InputFrame createWithImage(Image image);

    @MethodId("CFFCE90E5")
    public static native InputFrame createWithImageAndCameraParameters(Image image, CameraParameters cameraParameters);

    @MethodId("C000FEBED")
    public static native InputFrame createWithImageAndCameraParametersAndTemporal(Image image, CameraParameters cameraParameters, double timestamp);

    @MethodId("C4DC3D319")
    public native CameraParameters cameraParameters();

    @MethodId("C912CF8F5")
    public native Matrix44F cameraTransform();

    @MethodId("CB00D3B50")
    public native boolean hasCameraParameters();

    @MethodId("C76C5CA3C")
    public native boolean hasSpatialInformation();

    @MethodId("C7C67FA5E")
    public native boolean hasTemporalInformation();

    @MethodId("C6105D6CC")
    public native Image image();

    @MethodId("C1BC04B52")
    public native int index();

    @MethodId("C323748F8")
    public native double timestamp();

    @MethodId("C4B3328F0")
    public native int trackingStatus();

    protected InputFrame(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }
}
