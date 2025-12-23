package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class CircularArrayOffsetCalculator {
    public static <E> E[] allocate(int i6) {
        return (E[]) new Object[i6];
    }

    public static long calcElementOffset(long j6, long j7) {
        return UnsafeRefArrayAccess.REF_ARRAY_BASE + ((j6 & j7) << UnsafeRefArrayAccess.REF_ELEMENT_SHIFT);
    }
}
