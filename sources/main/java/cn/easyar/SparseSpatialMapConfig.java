package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("CAB9422F3")
/* loaded from: D:\Downloads\app\classes2.dex */
public class SparseSpatialMapConfig extends RefBase {
    protected SparseSpatialMapConfig(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }

    @MethodId("CD33483F0")
    private static native long _ctor();

    @MethodId("C98E3D319")
    public native int getLocalizationMode();

    @MethodId("C99504870")
    public native void setLocalizationMode(int value);

    public SparseSpatialMapConfig() {
        super(_ctor(), null);
    }
}
