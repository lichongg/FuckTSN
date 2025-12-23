package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class AbstractNavigableMap<K, V> extends Maps.IteratorBasedAbstractMap<K, V> implements NavigableMap<K, V> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.common.collect.AbstractNavigableMap$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class DescendingMap extends Maps.DescendingMap<K, V> {
        private DescendingMap() {
        }

        /* synthetic */ DescendingMap(AbstractNavigableMap abstractNavigableMap, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.collect.Maps.DescendingMap
        Iterator<Map.Entry<K, V>> entryIterator() {
            return AbstractNavigableMap.this.descendingEntryIterator();
        }

        @Override // com.google.common.collect.Maps.DescendingMap
        NavigableMap<K, V> forward() {
            return AbstractNavigableMap.this;
        }
    }

    @Override // java.util.NavigableMap
    @NullableDecl
    public Map.Entry<K, V> ceilingEntry(K k6) {
        return tailMap(k6, true).firstEntry();
    }

    abstract Iterator<Map.Entry<K, V>> descendingEntryIterator();

    @Override // java.util.NavigableMap
    @NullableDecl
    public Map.Entry<K, V> floorEntry(K k6) {
        return headMap(k6, true).lastEntry();
    }

    @Override // java.util.AbstractMap, java.util.Map
    @NullableDecl
    public abstract V get(@NullableDecl Object obj);

    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap<K, V> headMap(K k6) {
        return headMap(k6, false);
    }

    @Override // java.util.NavigableMap
    @NullableDecl
    public Map.Entry<K, V> higherEntry(K k6) {
        return tailMap(k6, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    @NullableDecl
    public Map.Entry<K, V> lowerEntry(K k6) {
        return headMap(k6, false).lastEntry();
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap<K, V> subMap(K k6, K k7) {
        return subMap(k6, true, k7, false);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap<K, V> tailMap(K k6) {
        return tailMap(k6, true);
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> descendingMap() {
        return new DescendingMap(this, null);
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> navigableKeySet() {
        return new Maps.NavigableKeySet(this);
    }

    AbstractNavigableMap() {
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K k6) {
        return (K) Maps.keyOrNull(ceilingEntry(k6));
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> descendingKeySet() {
        return descendingMap().navigableKeySet();
    }

    @Override // java.util.NavigableMap
    @NullableDecl
    public Map.Entry<K, V> firstEntry() {
        return (Map.Entry) Iterators.getNext(entryIterator(), null);
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        Map.Entry<K, V> firstEntry = firstEntry();
        if (firstEntry != null) {
            return firstEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.NavigableMap
    public K floorKey(K k6) {
        return (K) Maps.keyOrNull(floorEntry(k6));
    }

    @Override // java.util.NavigableMap
    public K higherKey(K k6) {
        return (K) Maps.keyOrNull(higherEntry(k6));
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public Set<K> keySet() {
        return navigableKeySet();
    }

    @Override // java.util.NavigableMap
    @NullableDecl
    public Map.Entry<K, V> lastEntry() {
        return (Map.Entry) Iterators.getNext(descendingEntryIterator(), null);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        Map.Entry<K, V> lastEntry = lastEntry();
        if (lastEntry != null) {
            return lastEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K k6) {
        return (K) Maps.keyOrNull(lowerEntry(k6));
    }

    @Override // java.util.NavigableMap
    @NullableDecl
    public Map.Entry<K, V> pollFirstEntry() {
        return (Map.Entry) Iterators.pollNext(entryIterator());
    }

    @Override // java.util.NavigableMap
    @NullableDecl
    public Map.Entry<K, V> pollLastEntry() {
        return (Map.Entry) Iterators.pollNext(descendingEntryIterator());
    }
}
