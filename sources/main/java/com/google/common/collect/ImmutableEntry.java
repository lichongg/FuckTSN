package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(serializable = true)
/* loaded from: D:\Downloads\app\classes5.dex */
class ImmutableEntry<K, V> extends AbstractMapEntry<K, V> implements Serializable {
    private static final long serialVersionUID = 0;

    @NullableDecl
    final K key;

    @NullableDecl
    final V value;

    @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
    @NullableDecl
    public final K getKey() {
        return this.key;
    }

    @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
    @NullableDecl
    public final V getValue() {
        return this.value;
    }

    @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
    public final V setValue(V v5) {
        throw new UnsupportedOperationException();
    }

    ImmutableEntry(@NullableDecl K k6, @NullableDecl V v5) {
        this.key = k6;
        this.value = v5;
    }
}
