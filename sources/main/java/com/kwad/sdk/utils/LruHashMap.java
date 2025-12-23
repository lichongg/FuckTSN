package com.kwad.sdk.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class LruHashMap<K, V> extends LinkedHashMap<K, V> {
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private final long maxSize;

    public LruHashMap(long j6) {
        super(((int) Math.ceil(j6 / 0.75f)) + 1, 0.75f, true);
        this.maxSize = j6;
    }

    public long getMaxSize() {
        return this.maxSize;
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
        if (size() > this.maxSize) {
            return true;
        }
        return false;
    }
}
