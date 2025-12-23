package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import java.lang.ref.SoftReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class FinalizableSoftReference<T> extends SoftReference<T> implements FinalizableReference {
    protected FinalizableSoftReference(T t5, FinalizableReferenceQueue finalizableReferenceQueue) {
        super(t5, finalizableReferenceQueue.queue);
        finalizableReferenceQueue.cleanUp();
    }
}
