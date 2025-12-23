package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("CE9799336")
/* loaded from: D:\Downloads\app\classes2.dex */
public class RealTimeCoordinateTransform extends RefBase {
    protected RealTimeCoordinateTransform(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }

    @MethodId("CD33483F0")
    private static native long _ctor();

    @MethodId("C6F79935C")
    public native int getBufferSize();

    @MethodId("C949A799F")
    public native Matrix44F getPoseInMap(double timestamp, int status, Matrix44F localTwc);

    @MethodId("C7D763536")
    public native boolean insertData(double timestamp, Matrix44F localTwc, Matrix44F mapTcw);

    @MethodId("CB748CE17")
    public native void setBufferSize(int capacity);

    public RealTimeCoordinateTransform() {
        super(_ctor(), null);
    }
}
