package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("C4DA20F89")
/* loaded from: D:\Downloads\app\classes2.dex */
public class BufferDictionary extends RefBase {
    protected BufferDictionary(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }

    @MethodId("CD33483F0")
    private static native long _ctor();

    @MethodId("C913A4CB9")
    public native void clear();

    @MethodId("CBEEB20FB")
    public native boolean contains(String path);

    @MethodId("C6C35493A")
    public native int count();

    @MethodId("C7E5608AB")
    public native boolean remove(String path);

    @MethodId("C6EE0EB49")
    public native void set(String path, Buffer buffer);

    @MethodId("CF861531D")
    public native Buffer tryGet(String path);

    public BufferDictionary() {
        super(_ctor(), null);
    }
}
