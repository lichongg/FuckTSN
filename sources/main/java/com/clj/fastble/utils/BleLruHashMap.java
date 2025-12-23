package com.clj.fastble.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class BleLruHashMap<K, V> extends LinkedHashMap<K, V> {
    private final int MAX_SIZE;

    public BleLruHashMap(int i6) {
        super(((int) Math.ceil(i6 / 0.75d)) + 1, 0.75f, true);
        this.MAX_SIZE = i6;
    }

    @Override // java.util.AbstractMap
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<K, V> entry : entrySet()) {
            sb.append(String.format("%s:%s ", entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry entry) {
        if (size() > this.MAX_SIZE && (entry.getValue() instanceof com.clj.fastble.bluetooth.b)) {
            ((com.clj.fastble.bluetooth.b) entry.getValue()).G();
        }
        if (size() > this.MAX_SIZE) {
            return true;
        }
        return false;
    }
}
