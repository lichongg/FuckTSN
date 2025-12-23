package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("CE44193FD")
/* loaded from: D:\Downloads\app\classes2.dex */
public class Buffer extends RefBase {
    @MethodId("CFA8847B0")
    public static native Buffer create(int size);

    public static Buffer k(byte[] bytes) {
        return wrapByteArray(bytes, 0, bytes.length, false, new a());
    }

    @MethodId("C7961F5BD")
    public static native void memoryCopy(long src, long dest, int length);

    @MethodId("CF0A28992")
    public static native Buffer wrap(long ptr, int size, FunctorOfVoid deleter);

    @MethodId("C5C615131")
    public static native Buffer wrapBuffer(java.nio.Buffer directBuffer, FunctorOfVoid deleter);

    @MethodId("CC78A1A1F")
    public static native Buffer wrapByteArray(byte[] bytes, int index, int length, boolean readOnly, FunctorOfVoid deleter);

    @MethodId("CD3E58C33")
    public native void copyFromByteArray(byte[] src, int srcIndex, int index, int length);

    @MethodId("C7BBBC55D")
    public native void copyToByteArray(int index, byte[] dest, int destIndex, int length);

    @MethodId("C3A6EB079")
    public native long data();

    public void g(byte[] src) {
        copyFromByteArray(src, 0, 0, src.length);
    }

    public void h(byte[] dest) {
        copyToByteArray(0, dest, 0, size());
    }

    @MethodId("C2DF962D3")
    public native Buffer partition(int index, int length);

    @MethodId("CCCDCBE84")
    public native int size();

    @MethodId("C95576C7A")
    public native boolean tryCopyFrom(long src, int srcIndex, int index, int length);

    @MethodId("C8ADE585B")
    public native boolean tryCopyTo(int index, long dest, int destIndex, int length);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements FunctorOfVoid {
        a() {
        }

        @Override // cn.easyar.FunctorOfVoid
        public void invoke() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements FunctorOfVoid {
        b() {
        }

        @Override // cn.easyar.FunctorOfVoid
        public void invoke() {
        }
    }

    public static Buffer i(java.nio.Buffer directBuffer) {
        return wrapBuffer(directBuffer, new b());
    }

    protected Buffer(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }
}
