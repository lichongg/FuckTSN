package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class ForwardingNavigableMap<K, V> extends ForwardingSortedMap<K, V> implements NavigableMap<K, V> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Beta
    protected class StandardDescendingMap extends Maps.DescendingMap<K, V> {
        public StandardDescendingMap() {
        }

        @Override // com.google.common.collect.Maps.DescendingMap
        protected Iterator<Map.Entry<K, V>> entryIterator() {
            return new Iterator<Map.Entry<K, V>>() { // from class: com.google.common.collect.ForwardingNavigableMap.StandardDescendingMap.1
                private Map.Entry<K, V> nextOrNull;
                private Map.Entry<K, V> toRemove = null;

                {
                    this.nextOrNull = StandardDescendingMap.this.forward().lastEntry();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.nextOrNull != null;
                }

                @Override // java.util.Iterator
                public Map.Entry<K, V> next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    try {
                        Map.Entry<K, V> entry = this.nextOrNull;
                        this.toRemove = entry;
                        this.nextOrNull = StandardDescendingMap.this.forward().lowerEntry(this.nextOrNull.getKey());
                        return entry;
                    } catch (Throwable th) {
                        this.toRemove = this.nextOrNull;
                        this.nextOrNull = StandardDescendingMap.this.forward().lowerEntry(this.nextOrNull.getKey());
                        throw th;
                    }
                }

                @Override // java.util.Iterator
                public void remove() {
                    CollectPreconditions.checkRemove(this.toRemove != null);
                    StandardDescendingMap.this.forward().remove(this.toRemove.getKey());
                    this.toRemove = null;
                }
            };
        }

        @Override // com.google.common.collect.Maps.DescendingMap
        NavigableMap<K, V> forward() {
            return ForwardingNavigableMap.this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Beta
    protected class StandardNavigableKeySet extends Maps.NavigableKeySet<K, V> {
        public StandardNavigableKeySet() {
            super(ForwardingNavigableMap.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingSortedMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public abstract NavigableMap<K, V> delegate();

    protected Map.Entry<K, V> standardCeilingEntry(K k6) {
        return tailMap(k6, true).firstEntry();
    }

    protected Map.Entry<K, V> standardFloorEntry(K k6) {
        return headMap(k6, true).lastEntry();
    }

    protected SortedMap<K, V> standardHeadMap(K k6) {
        return headMap(k6, false);
    }

    protected Map.Entry<K, V> standardHigherEntry(K k6) {
        return tailMap(k6, false).firstEntry();
    }

    protected Map.Entry<K, V> standardLowerEntry(K k6) {
        return headMap(k6, false).lastEntry();
    }

    @Override // com.google.common.collect.ForwardingSortedMap
    protected SortedMap<K, V> standardSubMap(K k6, K k7) {
        return subMap(k6, true, k7, false);
    }

    protected SortedMap<K, V> standardTailMap(K k6) {
        return tailMap(k6, true);
    }

    protected ForwardingNavigableMap() {
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> ceilingEntry(K k6) {
        return delegate().ceilingEntry(k6);
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K k6) {
        return delegate().ceilingKey(k6);
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> descendingKeySet() {
        return delegate().descendingKeySet();
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> descendingMap() {
        return delegate().descendingMap();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> firstEntry() {
        return delegate().firstEntry();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> floorEntry(K k6) {
        return delegate().floorEntry(k6);
    }

    @Override // java.util.NavigableMap
    public K floorKey(K k6) {
        return delegate().floorKey(k6);
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> headMap(K k6, boolean z5) {
        return delegate().headMap(k6, z5);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> higherEntry(K k6) {
        return delegate().higherEntry(k6);
    }

    @Override // java.util.NavigableMap
    public K higherKey(K k6) {
        return delegate().higherKey(k6);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lastEntry() {
        return delegate().lastEntry();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lowerEntry(K k6) {
        return delegate().lowerEntry(k6);
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K k6) {
        return delegate().lowerKey(k6);
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> navigableKeySet() {
        return delegate().navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollFirstEntry() {
        return delegate().pollFirstEntry();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollLastEntry() {
        return delegate().pollLastEntry();
    }

    protected K standardCeilingKey(K k6) {
        return (K) Maps.keyOrNull(ceilingEntry(k6));
    }

    @Beta
    protected NavigableSet<K> standardDescendingKeySet() {
        return descendingMap().navigableKeySet();
    }

    protected Map.Entry<K, V> standardFirstEntry() {
        return (Map.Entry) Iterables.getFirst(entrySet(), null);
    }

    protected K standardFirstKey() {
        Map.Entry<K, V> firstEntry = firstEntry();
        if (firstEntry != null) {
            return firstEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    protected K standardFloorKey(K k6) {
        return (K) Maps.keyOrNull(floorEntry(k6));
    }

    protected K standardHigherKey(K k6) {
        return (K) Maps.keyOrNull(higherEntry(k6));
    }

    protected Map.Entry<K, V> standardLastEntry() {
        return (Map.Entry) Iterables.getFirst(descendingMap().entrySet(), null);
    }

    protected K standardLastKey() {
        Map.Entry<K, V> lastEntry = lastEntry();
        if (lastEntry != null) {
            return lastEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    protected K standardLowerKey(K k6) {
        return (K) Maps.keyOrNull(lowerEntry(k6));
    }

    protected Map.Entry<K, V> standardPollFirstEntry() {
        return (Map.Entry) Iterators.pollNext(entrySet().iterator());
    }

    protected Map.Entry<K, V> standardPollLastEntry() {
        return (Map.Entry) Iterators.pollNext(descendingMap().entrySet().iterator());
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> subMap(K k6, boolean z5, K k7, boolean z6) {
        return delegate().subMap(k6, z5, k7, z6);
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> tailMap(K k6, boolean z5) {
        return delegate().tailMap(k6, z5);
    }
}
