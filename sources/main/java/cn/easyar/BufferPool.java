package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("C8F6FC2EA")
/* loaded from: D:\Downloads\app\classes2.dex */
public class BufferPool extends RefBase {
    protected BufferPool(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }

    @MethodId("CD33483F0")
    private static native long _ctor(int block_size, int capacity);

    @MethodId("C13D754BE")
    public native int block_size();

    @MethodId("CEC21B3B9")
    public native int capacity();

    @MethodId("CCCDCBE84")
    public native int size();

    @MethodId("C0AD04ED7")
    public native Buffer tryAcquire();

    public BufferPool(int block_size, int capacity) {
        super(_ctor(block_size, capacity), null);
    }
}
