package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("CE46D9FB1")
/* loaded from: D:\Downloads\app\classes2.dex */
public class JniUtility {
    @MethodId("CE5537884")
    public static native void deleteJniGlobalPointer(long ptr);

    @MethodId("C271CED7C")
    public static native long getDirectBufferAddress(long directBuffer);

    @MethodId("CB725F798")
    public static native long newJniGlobalPointer(Object obj);

    @MethodId("C5C615131")
    public static native Buffer wrapBuffer(long directBuffer, FunctorOfVoid deleter);

    @MethodId("CC78A1A1F")
    public static native Buffer wrapByteArray(long bytes, boolean readOnly, FunctorOfVoid deleter);
}
