package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public interface PeekingIterator<E> extends Iterator<E> {
    @Override // java.util.Iterator
    @CanIgnoreReturnValue
    E next();

    E peek();

    @Override // java.util.Iterator
    void remove();
}
