package cn.easyar;

import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("C17C932C7")
/* loaded from: D:\Downloads\app\classes2.dex */
public class CloudLocalizerResult extends RefBase {
    @MethodId("C67F64BF4")
    public native ArrayList<CloudLocalizerBlockInstance> blockInstances();

    @MethodId("C7CA24AF6")
    public native String exceptionInfo();

    @MethodId("CEBDF7478")
    public native String extraInfo();

    @MethodId("C5C9CD880")
    public native int localizeStatus();

    @MethodId("CA8F5DD1B")
    public native Double serverCalculationDuration();

    @MethodId("C0DB6757F")
    public native Double serverResponseDuration();

    protected CloudLocalizerResult(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }
}
