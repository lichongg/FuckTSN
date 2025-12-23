package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Table;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class ForwardingTable<R, C, V> extends ForwardingObject implements Table<R, C, V> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingObject
    public abstract Table<R, C, V> delegate();

    @Override // com.google.common.collect.Table
    public boolean equals(Object obj) {
        return obj == this || delegate().equals(obj);
    }

    protected ForwardingTable() {
    }

    @Override // com.google.common.collect.Table
    public Set<Table.Cell<R, C, V>> cellSet() {
        return delegate().cellSet();
    }

    @Override // com.google.common.collect.Table
    public void clear() {
        delegate().clear();
    }

    @Override // com.google.common.collect.Table
    public Map<R, V> column(C c6) {
        return delegate().column(c6);
    }

    @Override // com.google.common.collect.Table
    public Set<C> columnKeySet() {
        return delegate().columnKeySet();
    }

    @Override // com.google.common.collect.Table
    public Map<C, Map<R, V>> columnMap() {
        return delegate().columnMap();
    }

    @Override // com.google.common.collect.Table
    public boolean contains(Object obj, Object obj2) {
        return delegate().contains(obj, obj2);
    }

    @Override // com.google.common.collect.Table
    public boolean containsColumn(Object obj) {
        return delegate().containsColumn(obj);
    }

    @Override // com.google.common.collect.Table
    public boolean containsRow(Object obj) {
        return delegate().containsRow(obj);
    }

    @Override // com.google.common.collect.Table
    public boolean containsValue(Object obj) {
        return delegate().containsValue(obj);
    }

    @Override // com.google.common.collect.Table
    public V get(Object obj, Object obj2) {
        return delegate().get(obj, obj2);
    }

    @Override // com.google.common.collect.Table
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // com.google.common.collect.Table
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    @Override // com.google.common.collect.Table
    @CanIgnoreReturnValue
    public V put(R r5, C c6, V v5) {
        return delegate().put(r5, c6, v5);
    }

    @Override // com.google.common.collect.Table
    public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        delegate().putAll(table);
    }

    @Override // com.google.common.collect.Table
    @CanIgnoreReturnValue
    public V remove(Object obj, Object obj2) {
        return delegate().remove(obj, obj2);
    }

    @Override // com.google.common.collect.Table
    public Map<C, V> row(R r5) {
        return delegate().row(r5);
    }

    @Override // com.google.common.collect.Table
    public Set<R> rowKeySet() {
        return delegate().rowKeySet();
    }

    @Override // com.google.common.collect.Table
    public Map<R, Map<C, V>> rowMap() {
        return delegate().rowMap();
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return delegate().size();
    }

    @Override // com.google.common.collect.Table
    public Collection<V> values() {
        return delegate().values();
    }
}
