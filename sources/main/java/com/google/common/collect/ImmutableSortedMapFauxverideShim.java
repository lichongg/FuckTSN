package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableSortedMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class ImmutableSortedMapFauxverideShim<K, V> extends ImmutableMap<K, V> {
    @Deprecated
    public static <K, V> ImmutableSortedMap<K, V> of(K k6, V v5) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <K, V> ImmutableSortedMap.Builder<K, V> builder() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <K, V> ImmutableSortedMap.Builder<K, V> builderWithExpectedSize(int i6) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <K, V> ImmutableSortedMap<K, V> of(K k6, V v5, K k7, V v6) {
        throw new UnsupportedOperationException();
    }

    ImmutableSortedMapFauxverideShim() {
    }

    @Deprecated
    public static <K, V> ImmutableSortedMap<K, V> of(K k6, V v5, K k7, V v6, K k8, V v7) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <K, V> ImmutableSortedMap<K, V> of(K k6, V v5, K k7, V v6, K k8, V v7, K k9, V v8) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <K, V> ImmutableSortedMap<K, V> of(K k6, V v5, K k7, V v6, K k8, V v7, K k9, V v8, K k10, V v9) {
        throw new UnsupportedOperationException();
    }
}
