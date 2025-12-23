package cn.easyar;

import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("CD37F5BCC")
/* loaded from: D:\Downloads\app\classes2.dex */
public class ImageTracker extends RefBase {
    @MethodId("CFA8847B0")
    public static native ImageTracker create();

    @MethodId("C03FD303A")
    public static native ImageTracker createWithMode(int trackMode);

    @MethodId("CE93DF2A9")
    public static native boolean isAvailable();

    @MethodId("C5DE59913")
    public native int bufferRequirement();

    @MethodId("C310FF200")
    public native void close();

    @MethodId("C2E26952A")
    public native FeedbackFrameSink feedbackFrameSink();

    @MethodId("C2ECEE0D4")
    public native void loadTarget(Target target, CallbackScheduler callbackScheduler, FunctorOfVoidFromTargetAndBool callback);

    @MethodId("C5868A777")
    public native OutputFrameSource outputFrameSource();

    @MethodId("C5DF178DB")
    public native void setResultPostProcessing(boolean enablePersistentTargetInstance, boolean enableMotionFusion);

    @MethodId("C66ED6549")
    public native boolean setSimultaneousNum(int num);

    @MethodId("CAC18A1C4")
    public native int simultaneousNum();

    @MethodId("CCCED28C6")
    public native boolean start();

    @MethodId("C6C45CB72")
    public native void stop();

    @MethodId("C26CAFB94")
    public native ArrayList<Target> targets();

    @MethodId("CC5040656")
    public native void unloadTarget(Target target, CallbackScheduler callbackScheduler, FunctorOfVoidFromTargetAndBool callback);

    protected ImageTracker(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }
}
