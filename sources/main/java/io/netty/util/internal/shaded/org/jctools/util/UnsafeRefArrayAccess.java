package io.netty.util.internal.shaded.org.jctools.util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class UnsafeRefArrayAccess {
    public static final long REF_ARRAY_BASE;
    public static final int REF_ELEMENT_SHIFT;

    static {
        int arrayIndexScale = UnsafeAccess.UNSAFE.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            REF_ELEMENT_SHIFT = 2;
        } else {
            if (8 != arrayIndexScale) {
                throw new IllegalStateException("Unknown pointer size");
            }
            REF_ELEMENT_SHIFT = 3;
        }
        REF_ARRAY_BASE = r0.arrayBaseOffset(Object[].class);
    }

    public static long calcElementOffset(long j6) {
        return REF_ARRAY_BASE + (j6 << REF_ELEMENT_SHIFT);
    }

    public static <E> E lpElement(E[] eArr, long j6) {
        return (E) UnsafeAccess.UNSAFE.getObject(eArr, j6);
    }

    public static <E> E lvElement(E[] eArr, long j6) {
        return (E) UnsafeAccess.UNSAFE.getObjectVolatile(eArr, j6);
    }

    public static <E> void soElement(E[] eArr, long j6, E e6) {
        UnsafeAccess.UNSAFE.putOrderedObject(eArr, j6, e6);
    }

    public static <E> void spElement(E[] eArr, long j6, E e6) {
        UnsafeAccess.UNSAFE.putObject(eArr, j6, e6);
    }
}
