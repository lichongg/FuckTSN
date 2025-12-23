package com.google.android.datatransport.runtime.dagger.internal;

import java.util.Collections;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class MapBuilder<K, V> {
    private final Map<K, V> contributions;

    public static <K, V> MapBuilder<K, V> newMapBuilder(int i6) {
        return new MapBuilder<>(i6);
    }

    public Map<K, V> build() {
        return this.contributions.size() != 0 ? Collections.unmodifiableMap(this.contributions) : Collections.EMPTY_MAP;
    }

    public MapBuilder<K, V> put(K k6, V v5) {
        this.contributions.put(k6, v5);
        return this;
    }

    public MapBuilder<K, V> putAll(Map<K, V> map) {
        this.contributions.putAll(map);
        return this;
    }

    private MapBuilder(int i6) {
        this.contributions = DaggerCollections.newLinkedHashMapWithExpectedSize(i6);
    }
}
