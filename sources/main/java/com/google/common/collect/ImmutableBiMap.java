package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(emulated = true, serializable = true)
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class ImmutableBiMap<K, V> extends ImmutableMap<K, V> implements BiMap<K, V> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Builder<K, V> extends ImmutableMap.Builder<K, V> {
        public Builder() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableMap.Builder put(Object obj, Object obj2) {
            return put((Builder<K, V>) obj, obj2);
        }

        Builder(int i6) {
            super(i6);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public ImmutableBiMap<K, V> build() {
            if (this.size == 0) {
                return ImmutableBiMap.of();
            }
            sortEntries();
            this.entriesUsed = true;
            return new RegularImmutableBiMap(this.alternatingKeysAndValues, this.size);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        @Beta
        public Builder<K, V> orderEntriesByValue(Comparator<? super V> comparator) {
            super.orderEntriesByValue((Comparator) comparator);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> put(K k6, V v5) {
            super.put((Builder<K, V>) k6, (K) v5);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Map<? extends K, ? extends V> map) {
            super.putAll((Map) map);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry) {
            super.put((Map.Entry) entry);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        @Beta
        public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.putAll((Iterable) iterable);
            return this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class SerializedForm extends ImmutableMap.SerializedForm {
        private static final long serialVersionUID = 0;

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        Object readResolve() {
            return createMap(new Builder());
        }

        SerializedForm(ImmutableBiMap<?, ?> immutableBiMap) {
            super(immutableBiMap);
        }
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if (map instanceof ImmutableBiMap) {
            ImmutableBiMap<K, V> immutableBiMap = (ImmutableBiMap) map;
            if (!immutableBiMap.isPartialView()) {
                return immutableBiMap;
            }
        }
        return copyOf((Iterable) map.entrySet());
    }

    public static <K, V> ImmutableBiMap<K, V> of() {
        return RegularImmutableBiMap.EMPTY;
    }

    @Override // com.google.common.collect.BiMap
    public abstract ImmutableBiMap<V, K> inverse();

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    @Beta
    public static <K, V> Builder<K, V> builderWithExpectedSize(int i6) {
        CollectPreconditions.checkNonnegative(i6, "expectedSize");
        return new Builder<>(i6);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k6, V v5) {
        CollectPreconditions.checkEntryNotNull(k6, v5);
        return new RegularImmutableBiMap(new Object[]{k6, v5}, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public final ImmutableSet<V> createValues() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    @Deprecated
    public V forcePut(K k6, V v5) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMap
    Object writeReplace() {
        return new SerializedForm(this);
    }

    ImmutableBiMap() {
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k6, V v5, K k7, V v6) {
        CollectPreconditions.checkEntryNotNull(k6, v5);
        CollectPreconditions.checkEntryNotNull(k7, v6);
        return new RegularImmutableBiMap(new Object[]{k6, v5, k7, v6}, 2);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSet<V> values() {
        return inverse().keySet();
    }

    @Beta
    public static <K, V> ImmutableBiMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new Builder(iterable instanceof Collection ? ((Collection) iterable).size() : 4).putAll((Iterable) iterable).build();
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k6, V v5, K k7, V v6, K k8, V v7) {
        CollectPreconditions.checkEntryNotNull(k6, v5);
        CollectPreconditions.checkEntryNotNull(k7, v6);
        CollectPreconditions.checkEntryNotNull(k8, v7);
        return new RegularImmutableBiMap(new Object[]{k6, v5, k7, v6, k8, v7}, 3);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k6, V v5, K k7, V v6, K k8, V v7, K k9, V v8) {
        CollectPreconditions.checkEntryNotNull(k6, v5);
        CollectPreconditions.checkEntryNotNull(k7, v6);
        CollectPreconditions.checkEntryNotNull(k8, v7);
        CollectPreconditions.checkEntryNotNull(k9, v8);
        return new RegularImmutableBiMap(new Object[]{k6, v5, k7, v6, k8, v7, k9, v8}, 4);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k6, V v5, K k7, V v6, K k8, V v7, K k9, V v8, K k10, V v9) {
        CollectPreconditions.checkEntryNotNull(k6, v5);
        CollectPreconditions.checkEntryNotNull(k7, v6);
        CollectPreconditions.checkEntryNotNull(k8, v7);
        CollectPreconditions.checkEntryNotNull(k9, v8);
        CollectPreconditions.checkEntryNotNull(k10, v9);
        return new RegularImmutableBiMap(new Object[]{k6, v5, k7, v6, k8, v7, k9, v8, k10, v9}, 5);
    }
}
