package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;
import com.google.android.datatransport.runtime.dagger.internal.AbstractMapFactory;
import java.util.Map;
import javax.inject.Provider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class MapProviderFactory<K, V> extends AbstractMapFactory<K, V, Provider<V>> implements Lazy<Map<K, Provider<V>>> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.android.datatransport.runtime.dagger.internal.MapProviderFactory$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Builder<K, V> extends AbstractMapFactory.Builder<K, V, Provider<V>> {
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

        public MapProviderFactory<K, V> build() {
            return new MapProviderFactory<>(this.map, null);
        }

        @Override // com.google.android.datatransport.runtime.dagger.internal.AbstractMapFactory.Builder
        public Builder<K, V> put(K k6, Provider<V> provider) {
            super.put((Builder<K, V>) k6, (Provider) provider);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.datatransport.runtime.dagger.internal.AbstractMapFactory.Builder
        public Builder<K, V> putAll(Provider<Map<K, Provider<V>>> provider) {
            super.putAll((Provider) provider);
            return this;
        }
    }

    /* synthetic */ MapProviderFactory(Map map, AnonymousClass1 anonymousClass1) {
        this(map);
    }

    private MapProviderFactory(Map<K, Provider<V>> map) {
        super(map);
    }

    public static <K, V> Builder<K, V> builder(int i6) {
        return new Builder<>(i6, null);
    }

    @Override // javax.inject.Provider
    public Map<K, Provider<V>> get() {
        return contributingMap();
    }
}
