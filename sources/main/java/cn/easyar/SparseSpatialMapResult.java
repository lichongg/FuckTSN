package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("CEAB49599")
/* loaded from: D:\Downloads\app\classes2.dex */
public class SparseSpatialMapResult extends o {
    @MethodId("C6A42CF45")
    public native String getLocalizationMapID();

    @MethodId("CD8CE3A28")
    public native boolean getLocalizationStatus();

    @MethodId("CFC8BEB83")
    public native Matrix44F getMapPose();

    @MethodId("C8273C718")
    public native int getMotionTrackingStatus();

    @MethodId("CD3939F15")
    public native Matrix44F getVioPose();

    protected SparseSpatialMapResult(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }
}
