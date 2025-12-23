package cn.easyar;

import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("CDA57866C")
/* loaded from: D:\Downloads\app\classes2.dex */
public class OutputFrame extends RefBase {
    protected OutputFrame(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }

    @MethodId("CD33483F0")
    private static native long _ctor(InputFrame inputFrame, ArrayList<o> results);

    @MethodId("C1BC04B52")
    public native int index();

    @MethodId("C2B2479BA")
    public native InputFrame inputFrame();

    @MethodId("CC099142B")
    public native ArrayList<o> results();

    public OutputFrame(InputFrame inputFrame, ArrayList<o> results) {
        super(_ctor(inputFrame, results), null);
    }
}
