package com.google.common.util.concurrent;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final /* synthetic */ class b {
    public static /* synthetic */ boolean a(AtomicReferenceArray atomicReferenceArray, int i6, Object obj, Object obj2) {
        while (!atomicReferenceArray.compareAndSet(i6, obj, obj2)) {
            if (atomicReferenceArray.get(i6) != obj) {
                return false;
            }
        }
        return true;
    }
}
