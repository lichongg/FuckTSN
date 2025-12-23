package com.bumptech.glide.repackaged.com.google.common.collect;

import java.util.Comparator;
import java.util.SortedSet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class r0 {
    public static <E> Comparator<? super E> a(SortedSet<E> sortedSet) {
        Comparator<? super E> comparator = sortedSet.comparator();
        if (comparator == null) {
            return b0.b();
        }
        return comparator;
    }

    public static boolean b(Comparator<?> comparator, Iterable<?> iterable) {
        Comparator comparator2;
        com.bumptech.glide.repackaged.com.google.common.base.d.i(comparator);
        com.bumptech.glide.repackaged.com.google.common.base.d.i(iterable);
        if (iterable instanceof SortedSet) {
            comparator2 = a((SortedSet) iterable);
        } else if (iterable instanceof q0) {
            comparator2 = ((q0) iterable).comparator();
        } else {
            return false;
        }
        return comparator.equals(comparator2);
    }
}
