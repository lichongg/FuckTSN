package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class LinkedArrayQueueUtil {
    static int length(Object[] objArr) {
        return objArr.length;
    }

    static long modifiedCalcElementOffset(long j6, long j7) {
        return UnsafeRefArrayAccess.REF_ARRAY_BASE + ((j6 & j7) << (UnsafeRefArrayAccess.REF_ELEMENT_SHIFT - 1));
    }

    static long nextArrayOffset(Object[] objArr) {
        return UnsafeRefArrayAccess.REF_ARRAY_BASE + ((length(objArr) - 1) << UnsafeRefArrayAccess.REF_ELEMENT_SHIFT);
    }

    private LinkedArrayQueueUtil() {
    }
}
