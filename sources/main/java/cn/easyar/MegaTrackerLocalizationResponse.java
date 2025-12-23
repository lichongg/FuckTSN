package cn.easyar;

import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("CE383E5A7")
/* loaded from: D:\Downloads\app\classes2.dex */
public class MegaTrackerLocalizationResponse extends RefBase {
    @MethodId("C8DA078CC")
    public native AccelerometerResult acceleration();

    @MethodId("C1D7F81F3")
    public native String errorMessage();

    @MethodId("CEBDF7478")
    public native String extraInfo();

    @MethodId("C2B2479BA")
    public native InputFrame inputFrame();

    @MethodId("C20202235")
    public native ArrayList<MegaTrackerBlockInstance> instances();

    @MethodId("CE6EAEA18")
    public native LocationResult location();

    @MethodId("CA8F5DD1B")
    public native Double serverCalculationDuration();

    @MethodId("C0DB6757F")
    public native Double serverResponseDuration();

    @MethodId("C073C1634")
    public native int status();

    protected MegaTrackerLocalizationResponse(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }
}
