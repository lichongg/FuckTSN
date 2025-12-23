package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableSortedSet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class ImmutableSortedSetFauxverideShim<E> extends ImmutableSet<E> {
    @Deprecated
    public static <E> ImmutableSortedSet<E> of(E e6) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedSet.Builder<E> builder() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedSet.Builder<E> builderWithExpectedSize(int i6) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedSet<E> copyOf(E[] eArr) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedSet<E> of(E e6, E e7) {
        throw new UnsupportedOperationException();
    }

    ImmutableSortedSetFauxverideShim() {
    }

    @Deprecated
    public static <E> ImmutableSortedSet<E> of(E e6, E e7, E e8) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedSet<E> of(E e6, E e7, E e8, E e9) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedSet<E> of(E e6, E e7, E e8, E e9, E e10) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedSet<E> of(E e6, E e7, E e8, E e9, E e10, E e11, E... eArr) {
        throw new UnsupportedOperationException();
    }
}
