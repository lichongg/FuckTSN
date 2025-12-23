package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("C9C38E31F")
/* loaded from: D:\Downloads\app\classes2.dex */
public class ImageTargetParameters extends RefBase {
    protected ImageTargetParameters(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }

    @MethodId("CD33483F0")
    private static native long _ctor();

    @MethodId("C6105D6CC")
    public native Image image();

    @MethodId("CEA3BD73E")
    public native String meta();

    @MethodId("C82A3537F")
    public native String name();

    @MethodId("CF469802A")
    public native float scale();

    @MethodId("C3BE10C43")
    public native void setImage(Image image);

    @MethodId("C9AF85922")
    public native void setMeta(String meta);

    @MethodId("C3E1A767C")
    public native void setName(String name);

    @MethodId("C859CD11A")
    public native void setScale(float scale);

    @MethodId("C83B06FAE")
    public native void setUid(String uid);

    @MethodId("C17B788A7")
    public native String uid();

    public ImageTargetParameters() {
        super(_ctor(), null);
    }
}
