package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("CC6961A9C")
/* loaded from: D:\Downloads\app\classes2.dex */
public class DenseSpatialMap extends RefBase {
    @MethodId("CFA8847B0")
    public static native DenseSpatialMap create();

    @MethodId("CE93DF2A9")
    public static native boolean isAvailable();

    @MethodId("C5DE59913")
    public native int bufferRequirement();

    @MethodId("C310FF200")
    public native void close();

    @MethodId("CA97A6598")
    public native SceneMesh getMesh();

    @MethodId("CB6A3E444")
    public native InputFrameSink inputFrameSink();

    @MethodId("CCCED28C6")
    public native boolean start();

    @MethodId("C6C45CB72")
    public native void stop();

    @MethodId("CAE114935")
    public native boolean updateSceneMesh(boolean updateMeshAll);

    protected DenseSpatialMap(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }
}
