package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public interface BiMap<K, V> extends Map<K, V> {
    @CanIgnoreReturnValue
    @NullableDecl
    V forcePut(@NullableDecl K k6, @NullableDecl V v5);

    BiMap<V, K> inverse();

    @CanIgnoreReturnValue
    @NullableDecl
    V put(@NullableDecl K k6, @NullableDecl V v5);

    void putAll(Map<? extends K, ? extends V> map);

    @Override // java.util.Map
    Set<V> values();
}
