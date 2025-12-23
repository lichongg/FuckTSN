package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Comparator;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class ForwardingSortedMap<K, V> extends ForwardingMap<K, V> implements SortedMap<K, V> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Beta
    protected class StandardKeySet extends Maps.SortedKeySet<K, V> {
        public StandardKeySet() {
            super(ForwardingSortedMap.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public abstract SortedMap<K, V> delegate();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingMap
    @Beta
    protected boolean standardContainsKey(@NullableDecl Object obj) {
        return unsafeCompare(tailMap(obj).firstKey(), obj) == 0;
    }

    protected ForwardingSortedMap() {
    }

    private int unsafeCompare(Object obj, Object obj2) {
        Comparator<? super K> comparator = comparator();
        if (comparator == null) {
            return ((Comparable) obj).compareTo(obj2);
        }
        return comparator.compare(obj, obj2);
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return delegate().comparator();
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        return delegate().firstKey();
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> headMap(K k6) {
        return delegate().headMap(k6);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return delegate().lastKey();
    }

    @Beta
    protected SortedMap<K, V> standardSubMap(K k6, K k7) {
        boolean z5;
        if (unsafeCompare(k6, k7) <= 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkArgument(z5, "fromKey must be <= toKey");
        return tailMap(k6).headMap(k7);
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> subMap(K k6, K k7) {
        return delegate().subMap(k6, k7);
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> tailMap(K k6) {
        return delegate().tailMap(k6);
    }
}
