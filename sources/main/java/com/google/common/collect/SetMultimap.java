package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public interface SetMultimap<K, V> extends Multimap<K, V> {
    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    Map<K, Collection<V>> asMap();

    @Override // com.google.common.collect.Multimap
    Set<Map.Entry<K, V>> entries();

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    boolean equals(@NullableDecl Object obj);

    @Override // com.google.common.collect.Multimap
    Set<V> get(@NullableDecl K k6);

    @Override // com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    Set<V> removeAll(@NullableDecl Object obj);

    @Override // com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    Set<V> replaceValues(K k6, Iterable<? extends V> iterable);
}
