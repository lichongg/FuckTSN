package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("C1AA4CB0B")
/* loaded from: D:\Downloads\app\classes2.dex */
public class Image extends RefBase {
    protected Image(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }

    @MethodId("CD33483F0")
    private static native long _ctor(Buffer buffer, int format, int width, int height);

    @MethodId("CFA8847B0")
    public static native Image create(Buffer buffer, int format, int width, int height, int pixelWidth, int pixelHeight);

    @MethodId("CD0CA8C2A")
    public native Buffer buffer();

    @MethodId("CE904C9CC")
    public native int format();

    @MethodId("C39E0F5EF")
    public native int height();

    @MethodId("C0D92355A")
    public native int pixelHeight();

    @MethodId("C0FA49014")
    public native int pixelWidth();

    @MethodId("CDEC0F004")
    public native int width();

    public Image(Buffer buffer, int format, int width, int height) {
        super(_ctor(buffer, format, width, height), null);
    }
}
