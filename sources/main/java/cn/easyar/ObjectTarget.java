package cn.easyar;

import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("C0F54C27E")
/* loaded from: D:\Downloads\app\classes2.dex */
public class ObjectTarget extends Target {
    protected ObjectTarget(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }

    @MethodId("CD33483F0")
    private static native long _ctor();

    @MethodId("C0F2ECB5F")
    public static native ObjectTarget createFromObjectFile(String path, int storageType, String name, String uid, String meta, float scale);

    @MethodId("C179143BD")
    public static native ObjectTarget createFromParameters(ObjectTargetParameters parameters);

    @MethodId("CC679F44F")
    public native ArrayList<o0> boundingBox();

    @Override // cn.easyar.Target
    @MethodId("CEA3BD73E")
    public native String meta();

    @Override // cn.easyar.Target
    @MethodId("C82A3537F")
    public native String name();

    @Override // cn.easyar.Target
    @MethodId("C08EB3025")
    public native int runtimeID();

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

    public ObjectTarget() {
        super(_ctor(), null);
    }
}
