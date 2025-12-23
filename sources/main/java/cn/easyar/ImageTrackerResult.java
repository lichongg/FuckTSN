package cn.easyar;

import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("CCC482BB3")
/* loaded from: D:\Downloads\app\classes2.dex */
public class ImageTrackerResult extends TargetTrackerResult {
    @Override // cn.easyar.TargetTrackerResult
    @MethodId("CD7AB5CCD")
    public native void setTargetInstances(ArrayList<TargetInstance> instances);

    @Override // cn.easyar.TargetTrackerResult
    @MethodId("C5DED70BD")
    public native ArrayList<TargetInstance> targetInstances();

    protected ImageTrackerResult(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }
}
