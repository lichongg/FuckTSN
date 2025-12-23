package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("C29D6C102")
/* loaded from: D:\Downloads\app\classes2.dex */
public class CameraParameters extends RefBase {
    protected CameraParameters(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }

    @MethodId("CD33483F0")
    private static native long _ctor(Vec2I imageSize, Vec2F focalLength, Vec2F principalPoint, int cameraDeviceType, int cameraOrientation);

    @MethodId("C82C54725")
    public static native CameraParameters createWithDefaultIntrinsics(Vec2I imageSize, int cameraDeviceType, int cameraOrientation);

    @MethodId("C8A4C8A83")
    public native int cameraDeviceType();

    @MethodId("C33D67BC7")
    public native int cameraOrientation();

    @MethodId("C02A861D9")
    public native boolean equalsTo(CameraParameters other);

    @MethodId("C13E9FB87")
    public native Vec2F focalLength();

    @MethodId("CF3D37286")
    public native CameraParameters getResized(Vec2I imageSize);

    @MethodId("C70B4F176")
    public native Vec2F imageCoordinatesFromScreenCoordinates(float viewportAspectRatio, int screenRotation, boolean combiningFlip, boolean manualHorizontalFlip, Vec2F screenCoordinates);

    @MethodId("C2A1C0E46")
    public native boolean imageHorizontalFlip(boolean manualHorizontalFlip);

    @MethodId("C2F345246")
    public native int imageOrientation(int screenRotation);

    @MethodId("C57D35EE0")
    public native Matrix44F imageProjection(float viewportAspectRatio, int screenRotation, boolean combiningFlip, boolean manualHorizontalFlip);

    @MethodId("CD0A0CE6F")
    public native Vec2F principalPoint();

    @MethodId("C1B250EA1")
    public native Matrix44F projection(float nearPlane, float farPlane, float viewportAspectRatio, int screenRotation, boolean combiningFlip, boolean manualHorizontalFlip);

    @MethodId("C47468C1E")
    public native Vec2F screenCoordinatesFromImageCoordinates(float viewportAspectRatio, int screenRotation, boolean combiningFlip, boolean manualHorizontalFlip, Vec2F imageCoordinates);

    @MethodId("CCCDCBE84")
    public native Vec2I size();

    public CameraParameters(Vec2I imageSize, Vec2F focalLength, Vec2F principalPoint, int cameraDeviceType, int cameraOrientation) {
        super(_ctor(imageSize, focalLength, principalPoint, cameraDeviceType, cameraOrientation), null);
    }
}
