package cn.easyar;

import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("CFF153DBB")
/* loaded from: D:\Downloads\app\classes2.dex */
public class ImageTarget extends Target {
    protected ImageTarget(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }

    @MethodId("CD33483F0")
    private static native long _ctor();

    @MethodId("C3B6A15D7")
    public static native ImageTarget createFromImageFile(String path, int storageType, String name, String uid, String meta, float scale);

    @MethodId("C179143BD")
    public static native ImageTarget createFromParameters(ImageTargetParameters parameters);

    @MethodId("C5CF60574")
    public static native ImageTarget createFromTargetData(Buffer buffer);

    @MethodId("CF0A20C2F")
    public static native ImageTarget createFromTargetFile(String path, int storageType);

    @MethodId("C6BA61201")
    public native float aspectRatio();

    @MethodId("C21B2EED1")
    public native ArrayList<Image> images();

    @Override // cn.easyar.Target
    @MethodId("CEA3BD73E")
    public native String meta();

    @Override // cn.easyar.Target
    @MethodId("C82A3537F")
    public native String name();

    @Override // cn.easyar.Target
    @MethodId("C08EB3025")
    public native int runtimeID();

    @MethodId("C157DCA92")
    public native boolean save(String path);

    @MethodId("CF469802A")
    public native float scale();

    @Override // cn.easyar.Target
    @MethodId("C9AF85922")
    public native void setMeta(String data);

    @Override // cn.easyar.Target
    @MethodId("C3E1A767C")
    public native void setName(String name);

    @MethodId("C859CD11A")
    public native boolean setScale(float scale);

    @Override // cn.easyar.Target
    @MethodId("C17B788A7")
    public native String uid();

    public ImageTarget() {
        super(_ctor(), null);
    }
}
