package cn.easyar;

import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("CB3E5C2F7")
/* loaded from: D:\Downloads\app\classes2.dex */
public class TargetTrackerResult extends o {
    @MethodId("CD7AB5CCD")
    public native void setTargetInstances(ArrayList<TargetInstance> instances);

    @MethodId("C5DED70BD")
    public native ArrayList<TargetInstance> targetInstances();

    protected TargetTrackerResult(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }
}
