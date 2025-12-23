package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.internal.AbstractMapFactory;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Provider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class MapFactory<K, V> extends AbstractMapFactory<K, V, V> {
    private static final Provider<Map<Object, Object>> EMPTY = InstanceFactory.create(Collections.EMPTY_MAP);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.android.datatransport.runtime.dagger.internal.MapFactory$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Builder<K, V> extends AbstractMapFactory.Builder<K, V, V> {
        /* synthetic */ Builder(int i6, AnonymousClass1 anonymousClass1) {
            this(i6);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.datatransport.runtime.dagger.internal.AbstractMapFactory.Builder
        public /* bridge */ /* synthetic */ AbstractMapFactory.Builder put(Object obj, Provider provider) {
            return put((Builder<K, V>) obj, provider);
        }

        private Builder(int i6) {
            super(i6);
        }

        public MapFactory<K, V> build() {
            return new MapFactory<>(this.map, null);
        }

        @Override // com.google.android.datatransport.runtime.dagger.internal.AbstractMapFactory.Builder
        public Builder<K, V> put(K k6, Provider<V> provider) {
            super.put((Builder<K, V>) k6, (Provider) provider);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.datatransport.runtime.dagger.internal.AbstractMapFactory.Builder
        public Builder<K, V> putAll(Provider<Map<K, V>> provider) {
            super.putAll((Provider) provider);
            return this;
        }
    }

    /* synthetic */ MapFactory(Map map, AnonymousClass1 anonymousClass1) {
        this(map);
    }

    private MapFactory(Map<K, Provider<V>> map) {
        super(map);
    }

    public static <K, V> Builder<K, V> builder(int i6) {
        return new Builder<>(i6, null);
    }

    public static <K, V> Provider<Map<K, V>> emptyMapProvider() {
        return (Provider<Map<K, V>>) EMPTY;
    }

    @Override // javax.inject.Provider
    public Map<K, V> get() {
        LinkedHashMap newLinkedHashMapWithExpectedSize = DaggerCollections.newLinkedHashMapWithExpectedSize(contributingMap().size());
        for (Map.Entry<K, Provider<V>> entry : contributingMap().entrySet()) {
            newLinkedHashMapWithExpectedSize.put(entry.getKey(), entry.getValue().get());
        }
        return Collections.unmodifiableMap(newLinkedHashMapWithExpectedSize);
    }
}
