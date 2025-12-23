package cn.easyar;

import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("C7ABB8A34")
/* loaded from: D:\Downloads\app\classes2.dex */
public class SparseSpatialMap extends RefBase {
    @MethodId("CFA8847B0")
    public static native SparseSpatialMap create();

    @MethodId("C7D824C42")
    public static native String getMapVersion();

    @MethodId("CE93DF2A9")
    public static native boolean isAvailable();

    @MethodId("C5DE59913")
    public native int bufferRequirement();

    @MethodId("C310FF200")
    public native void close();

    @MethodId("CD2FA4132")
    public native SparseSpatialMapConfig getConfig();

    @MethodId("CBD379665")
    public native ArrayList<PlaneData> getMapPlanes();

    @MethodId("C4B9B19AA")
    public native Buffer getPointCloudBuffer();

    @MethodId("C232CFE5E")
    public native ArrayList<o0> hitTestAgainstPlanes(Vec2F cameraImagePoint);

    @MethodId("C222BD61E")
    public native ArrayList<o0> hitTestAgainstPointCloud(Vec2F cameraImagePoint);

    @MethodId("CB6A3E444")
    public native InputFrameSink inputFrameSink();

    @MethodId("C5868A777")
    public native OutputFrameSource outputFrameSource();

    @MethodId("C20066313")
    public native void setConfig(SparseSpatialMapConfig config);

    @MethodId("C00AC221A")
    public native void setResultPoseType(boolean enableStabilization);

    @MethodId("CCCED28C6")
    public native boolean start();

    @MethodId("C917CBAC5")
    public native boolean startLocalization();

    @MethodId("C6C45CB72")
    public native void stop();

    @MethodId("C1DAB0FD7")
    public native void stopLocalization();

    @MethodId("C5C1486FD")
    public native void unloadMap(String mapID, CallbackScheduler callbackScheduler, FunctorOfVoidFromBool resultCallBack);

    protected SparseSpatialMap(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }
}
