package com.google.android.datatransport.runtime.dagger.internal;

import com.umeng.analytics.pro.d;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Provider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
abstract class AbstractMapFactory<K, V, V2> implements Factory<Map<K, V2>> {
    private final Map<K, Provider<V>> contributingMap;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class Builder<K, V, V2> {
        final LinkedHashMap<K, Provider<V>> map;

        /* JADX WARN: Multi-variable type inference failed */
        Builder<K, V, V2> put(K k6, Provider<V> provider) {
            this.map.put(Preconditions.checkNotNull(k6, "key"), Preconditions.checkNotNull(provider, d.M));
            return this;
        }

        Builder<K, V, V2> putAll(Provider<Map<K, V2>> provider) {
            if (provider instanceof DelegateFactory) {
                return putAll(((DelegateFactory) provider).getDelegate());
            }
            this.map.putAll(((AbstractMapFactory) provider).contributingMap);
            return this;
        }

        Builder(int i6) {
            this.map = DaggerCollections.newLinkedHashMapWithExpectedSize(i6);
        }
    }

    final Map<K, Provider<V>> contributingMap() {
        return this.contributingMap;
    }

    AbstractMapFactory(Map<K, Provider<V>> map) {
        this.contributingMap = Collections.unmodifiableMap(map);
    }
}
