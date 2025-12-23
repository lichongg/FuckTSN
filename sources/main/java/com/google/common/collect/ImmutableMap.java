package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(emulated = true, serializable = true)
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class ImmutableMap<K, V> implements Map<K, V>, Serializable {
    static final Map.Entry<?, ?>[] EMPTY_ENTRY_ARRAY = new Map.Entry[0];

    @LazyInit
    private transient ImmutableSet<Map.Entry<K, V>> entrySet;

    @RetainedWith
    @LazyInit
    private transient ImmutableSet<K> keySet;

    @LazyInit
    private transient ImmutableSetMultimap<K, V> multimapView;

    @RetainedWith
    @LazyInit
    private transient ImmutableCollection<V> values;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Builder<K, V> {
        Object[] alternatingKeysAndValues;
        boolean entriesUsed;
        int size;

        @MonotonicNonNullDecl
        Comparator<? super V> valueComparator;

        public Builder() {
            this(4);
        }

        @CanIgnoreReturnValue
        public Builder<K, V> put(K k6, V v5) {
            ensureCapacity(this.size + 1);
            CollectPreconditions.checkEntryNotNull(k6, v5);
            Object[] objArr = this.alternatingKeysAndValues;
            int i6 = this.size;
            objArr[i6 * 2] = k6;
            objArr[(i6 * 2) + 1] = v5;
            this.size = i6 + 1;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Map<? extends K, ? extends V> map) {
            return putAll(map.entrySet());
        }

        Builder(int i6) {
            this.alternatingKeysAndValues = new Object[i6 * 2];
            this.size = 0;
            this.entriesUsed = false;
        }

        private void ensureCapacity(int i6) {
            int i7 = i6 * 2;
            Object[] objArr = this.alternatingKeysAndValues;
            if (i7 > objArr.length) {
                this.alternatingKeysAndValues = Arrays.copyOf(objArr, ImmutableCollection.Builder.expandedCapacity(objArr.length, i7));
                this.entriesUsed = false;
            }
        }

        @CanIgnoreReturnValue
        @Beta
        public Builder<K, V> orderEntriesByValue(Comparator<? super V> comparator) {
            Preconditions.checkState(this.valueComparator == null, "valueComparator was already set");
            this.valueComparator = (Comparator) Preconditions.checkNotNull(comparator, "valueComparator");
            return this;
        }

        @CanIgnoreReturnValue
        @Beta
        public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            if (iterable instanceof Collection) {
                ensureCapacity(this.size + ((Collection) iterable).size());
            }
            Iterator<? extends Map.Entry<? extends K, ? extends V>> it = iterable.iterator();
            while (it.hasNext()) {
                put(it.next());
            }
            return this;
        }

        void sortEntries() {
            int i6;
            if (this.valueComparator != null) {
                if (this.entriesUsed) {
                    this.alternatingKeysAndValues = Arrays.copyOf(this.alternatingKeysAndValues, this.size * 2);
                }
                Map.Entry[] entryArr = new Map.Entry[this.size];
                int i7 = 0;
                while (true) {
                    i6 = this.size;
                    if (i7 >= i6) {
                        break;
                    }
                    Object[] objArr = this.alternatingKeysAndValues;
                    int i8 = i7 * 2;
                    entryArr[i7] = new AbstractMap.SimpleImmutableEntry(objArr[i8], objArr[i8 + 1]);
                    i7++;
                }
                Arrays.sort(entryArr, 0, i6, Ordering.from(this.valueComparator).onResultOf(Maps.valueFunction()));
                for (int i9 = 0; i9 < this.size; i9++) {
                    int i10 = i9 * 2;
                    this.alternatingKeysAndValues[i10] = entryArr[i9].getKey();
                    this.alternatingKeysAndValues[i10 + 1] = entryArr[i9].getValue();
                }
            }
        }

        public ImmutableMap<K, V> build() {
            sortEntries();
            this.entriesUsed = true;
            return RegularImmutableMap.create(this.size, this.alternatingKeysAndValues);
        }

        @CanIgnoreReturnValue
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry) {
            return put(entry.getKey(), entry.getValue());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static abstract class IteratorBasedImmutableMap<K, V> extends ImmutableMap<K, V> {
        abstract UnmodifiableIterator<Map.Entry<K, V>> entryIterator();

        @Override // com.google.common.collect.ImmutableMap
        ImmutableSet<Map.Entry<K, V>> createEntrySet() {
            return new ImmutableMapEntrySet<K, V>() { // from class: com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap.1EntrySetImpl
                @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
                public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
                    return IteratorBasedImmutableMap.this.entryIterator();
                }

                @Override // com.google.common.collect.ImmutableMapEntrySet
                ImmutableMap<K, V> map() {
                    return IteratorBasedImmutableMap.this;
                }
            };
        }

        @Override // com.google.common.collect.ImmutableMap
        ImmutableSet<K> createKeySet() {
            return new ImmutableMapKeySet(this);
        }

        @Override // com.google.common.collect.ImmutableMap
        ImmutableCollection<V> createValues() {
            return new ImmutableMapValues(this);
        }

        IteratorBasedImmutableMap() {
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set entrySet() {
            return super.entrySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set keySet() {
            return super.keySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class MapViewOfValuesAsSingletonSets extends IteratorBasedImmutableMap<K, ImmutableSet<V>> {
        private MapViewOfValuesAsSingletonSets() {
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public boolean containsKey(@NullableDecl Object obj) {
            return ImmutableMap.this.containsKey(obj);
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        ImmutableSet<K> createKeySet() {
            return ImmutableMap.this.keySet();
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
        UnmodifiableIterator<Map.Entry<K, ImmutableSet<V>>> entryIterator() {
            final UnmodifiableIterator<Map.Entry<K, V>> it = ImmutableMap.this.entrySet().iterator();
            return new UnmodifiableIterator<Map.Entry<K, ImmutableSet<V>>>() { // from class: com.google.common.collect.ImmutableMap.MapViewOfValuesAsSingletonSets.1
                @Override // java.util.Iterator
                public boolean hasNext() {
                    return it.hasNext();
                }

                @Override // java.util.Iterator
                public Map.Entry<K, ImmutableSet<V>> next() {
                    final Map.Entry entry = (Map.Entry) it.next();
                    return new AbstractMapEntry<K, ImmutableSet<V>>() { // from class: com.google.common.collect.ImmutableMap.MapViewOfValuesAsSingletonSets.1.1
                        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                        public K getKey() {
                            return (K) entry.getKey();
                        }

                        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                        public ImmutableSet<V> getValue() {
                            return ImmutableSet.of(entry.getValue());
                        }
                    };
                }
            };
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public ImmutableSet<V> get(@NullableDecl Object obj) {
            Object obj2 = ImmutableMap.this.get(obj);
            if (obj2 == null) {
                return null;
            }
            return ImmutableSet.of(obj2);
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public int hashCode() {
            return ImmutableMap.this.hashCode();
        }

        @Override // com.google.common.collect.ImmutableMap
        boolean isHashCodeFast() {
            return ImmutableMap.this.isHashCodeFast();
        }

        @Override // com.google.common.collect.ImmutableMap
        boolean isPartialView() {
            return ImmutableMap.this.isPartialView();
        }

        @Override // java.util.Map
        public int size() {
            return ImmutableMap.this.size();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final Object[] keys;
        private final Object[] values;

        Object createMap(Builder<Object, Object> builder) {
            int i6 = 0;
            while (true) {
                Object[] objArr = this.keys;
                if (i6 >= objArr.length) {
                    return builder.build();
                }
                builder.put(objArr[i6], this.values[i6]);
                i6++;
            }
        }

        Object readResolve() {
            return createMap(new Builder<>(this.keys.length));
        }

        SerializedForm(ImmutableMap<?, ?> immutableMap) {
            this.keys = new Object[immutableMap.size()];
            this.values = new Object[immutableMap.size()];
            UnmodifiableIterator<Map.Entry<?, ?>> it = immutableMap.entrySet().iterator();
            int i6 = 0;
            while (it.hasNext()) {
                Map.Entry<?, ?> next = it.next();
                this.keys[i6] = next.getKey();
                this.values[i6] = next.getValue();
                i6++;
            }
        }
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if ((map instanceof ImmutableMap) && !(map instanceof SortedMap)) {
            ImmutableMap<K, V> immutableMap = (ImmutableMap) map;
            if (!immutableMap.isPartialView()) {
                return immutableMap;
            }
        }
        return copyOf(map.entrySet());
    }

    public static <K, V> ImmutableMap<K, V> of() {
        return (ImmutableMap<K, V>) RegularImmutableMap.EMPTY;
    }

    abstract ImmutableSet<Map.Entry<K, V>> createEntrySet();

    abstract ImmutableSet<K> createKeySet();

    abstract ImmutableCollection<V> createValues();

    @Override // java.util.Map
    public abstract V get(@NullableDecl Object obj);

    boolean isHashCodeFast() {
        return false;
    }

    abstract boolean isPartialView();

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    @Beta
    public static <K, V> Builder<K, V> builderWithExpectedSize(int i6) {
        CollectPreconditions.checkNonnegative(i6, "expectedSize");
        return new Builder<>(i6);
    }

    static void checkNoConflict(boolean z5, String str, Map.Entry<?, ?> entry, Map.Entry<?, ?> entry2) {
        if (!z5) {
            throw conflictException(str, entry, entry2);
        }
    }

    static IllegalArgumentException conflictException(String str, Object obj, Object obj2) {
        return new IllegalArgumentException("Multiple entries with same " + str + ": " + obj + " and " + obj2);
    }

    public static <K, V> ImmutableMap<K, V> of(K k6, V v5) {
        CollectPreconditions.checkEntryNotNull(k6, v5);
        return RegularImmutableMap.create(1, new Object[]{k6, v5});
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.entrySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<Map.Entry<K, V>> createEntrySet = createEntrySet();
        this.entrySet = createEntrySet;
        return createEntrySet;
    }

    @Override // java.util.Map
    public ImmutableSet<K> keySet() {
        ImmutableSet<K> immutableSet = this.keySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<K> createKeySet = createKeySet();
        this.keySet = createKeySet;
        return createKeySet;
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    @Deprecated
    public final V put(K k6, V v5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public ImmutableCollection<V> values() {
        ImmutableCollection<V> immutableCollection = this.values;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        ImmutableCollection<V> createValues = createValues();
        this.values = createValues;
        return createValues;
    }

    Object writeReplace() {
        return new SerializedForm(this);
    }

    ImmutableMap() {
    }

    static <K, V> Map.Entry<K, V> entryOf(K k6, V v5) {
        CollectPreconditions.checkEntryNotNull(k6, v5);
        return new AbstractMap.SimpleImmutableEntry(k6, v5);
    }

    public ImmutableSetMultimap<K, V> asMultimap() {
        if (isEmpty()) {
            return ImmutableSetMultimap.of();
        }
        ImmutableSetMultimap<K, V> immutableSetMultimap = this.multimapView;
        if (immutableSetMultimap == null) {
            ImmutableSetMultimap<K, V> immutableSetMultimap2 = new ImmutableSetMultimap<>(new MapViewOfValuesAsSingletonSets(), size(), null);
            this.multimapView = immutableSetMultimap2;
            return immutableSetMultimap2;
        }
        return immutableSetMultimap;
    }

    @Override // java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        if (get(obj) != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        return values().contains(obj);
    }

    @Override // java.util.Map
    public boolean equals(@NullableDecl Object obj) {
        return Maps.equalsImpl(this, obj);
    }

    @Override // java.util.Map
    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v5) {
        V v6 = get(obj);
        if (v6 != null) {
            return v6;
        }
        return v5;
    }

    @Override // java.util.Map
    public int hashCode() {
        return Sets.hashCodeImpl(entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    UnmodifiableIterator<K> keyIterator() {
        final UnmodifiableIterator<Map.Entry<K, V>> it = entrySet().iterator();
        return new UnmodifiableIterator<K>() { // from class: com.google.common.collect.ImmutableMap.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override // java.util.Iterator
            public K next() {
                return (K) ((Map.Entry) it.next()).getKey();
            }
        };
    }

    public String toString() {
        return Maps.toStringImpl(this);
    }

    public static <K, V> ImmutableMap<K, V> of(K k6, V v5, K k7, V v6) {
        CollectPreconditions.checkEntryNotNull(k6, v5);
        CollectPreconditions.checkEntryNotNull(k7, v6);
        return RegularImmutableMap.create(2, new Object[]{k6, v5, k7, v6});
    }

    @Beta
    public static <K, V> ImmutableMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        Builder builder = new Builder(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
        builder.putAll(iterable);
        return builder.build();
    }

    public static <K, V> ImmutableMap<K, V> of(K k6, V v5, K k7, V v6, K k8, V v7) {
        CollectPreconditions.checkEntryNotNull(k6, v5);
        CollectPreconditions.checkEntryNotNull(k7, v6);
        CollectPreconditions.checkEntryNotNull(k8, v7);
        return RegularImmutableMap.create(3, new Object[]{k6, v5, k7, v6, k8, v7});
    }

    public static <K, V> ImmutableMap<K, V> of(K k6, V v5, K k7, V v6, K k8, V v7, K k9, V v8) {
        CollectPreconditions.checkEntryNotNull(k6, v5);
        CollectPreconditions.checkEntryNotNull(k7, v6);
        CollectPreconditions.checkEntryNotNull(k8, v7);
        CollectPreconditions.checkEntryNotNull(k9, v8);
        return RegularImmutableMap.create(4, new Object[]{k6, v5, k7, v6, k8, v7, k9, v8});
    }

    public static <K, V> ImmutableMap<K, V> of(K k6, V v5, K k7, V v6, K k8, V v7, K k9, V v8, K k10, V v9) {
        CollectPreconditions.checkEntryNotNull(k6, v5);
        CollectPreconditions.checkEntryNotNull(k7, v6);
        CollectPreconditions.checkEntryNotNull(k8, v7);
        CollectPreconditions.checkEntryNotNull(k9, v8);
        CollectPreconditions.checkEntryNotNull(k10, v9);
        return RegularImmutableMap.create(5, new Object[]{k6, v5, k7, v6, k8, v7, k9, v8, k10, v9});
    }
}
