package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("C343F91B8")
/* loaded from: D:\Downloads\app\classes2.dex */
public class ObjectTargetParameters extends RefBase {
    protected ObjectTargetParameters(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }

    @MethodId("CD33483F0")
    private static native long _ctor();

    @MethodId("CB9FF9984")
    public native BufferDictionary bufferDictionary();

    @MethodId("CEA3BD73E")
    public native String meta();

    @MethodId("C82A3537F")
    public native String name();

    @MethodId("C6E95828B")
    public native String objPath();

    @MethodId("CF469802A")
    public native float scale();

    @MethodId("CBB691EA8")
    public native void setBufferDictionary(BufferDictionary bufferDictionary);

    @MethodId("C9AF85922")
    public native void setMeta(String meta);

    @MethodId("C3E1A767C")
    public native void setName(String name);

    @MethodId("C013D88F7")
    public native void setObjPath(String objPath);

    @MethodId("C859CD11A")
    public native void setScale(float size);

    @MethodId("C83B06FAE")
    public native void setUid(String uid);

    @MethodId("C17B788A7")
    public native String uid();

    public ObjectTargetParameters() {
        super(_ctor(), null);
    }
}
