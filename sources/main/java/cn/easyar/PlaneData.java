package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("C3A2A6FB8")
/* loaded from: D:\Downloads\app\classes2.dex */
public class PlaneData extends RefBase {
    protected PlaneData(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }

    @MethodId("CD33483F0")
    private static native long _ctor();

    @MethodId("C4C67A9C8")
    public native float getExtentX();

    @MethodId("C55EC0927")
    public native float getExtentZ();

    @MethodId("C0D696EDA")
    public native Matrix44F getPose();

    @MethodId("C394D4C59")
    public native int getType();

    public PlaneData() {
        super(_ctor(), null);
    }
}
